/**
 * StepClaw Intercept Plugin
 *
 * Registers all OpenClaw plugin hooks for StepClaw HTTP service integration.
 *
 * Hook Categories:
 * - Agent Lifecycle: before_model_resolve, before_prompt_build, before_agent_start,
 *                    llm_input, llm_output, agent_end
 * - Message: message_received, message_sending, message_sent
 * - Tool: before_tool_call, after_tool_call, tool_client_correlation (Gateway WS redaction),
 *         tool_result_persist, before_message_write
 * - Session: session_start, session_end, before_reset, before_compaction, after_compaction
 * - Gateway: gateway_start, gateway_stop
 * - Subagent: subagent_spawning, subagent_delivery_target, subagent_spawned, subagent_ended
 *
 * Fail-open: if the endpoint is unreachable, operations proceed normally.
 */

const promptStats = require("./lib/prompt-stats");

// 自生成 per-run traceId：message_received 开始生成，agent_end 后重置
let _traceId = null;
function resolveTraceId() {
  if (!_traceId) {
    _traceId = `trace_${Date.now()}`;
  }
  return _traceId;
}
function resetTraceId() {
  _traceId = null;
}

/** 若 step-claw 与 Gateway 不同机，可设 STEPCLAW_HOOK_HOST 为设备 IP */
const STEPCLAW_HOST =
  typeof process !== "undefined" && process.env?.STEPCLAW_HOOK_HOST
    ? String(process.env.STEPCLAW_HOOK_HOST).trim() || "127.0.0.1"
    : "127.0.0.1";
const STEPCLAW_PORT = 18790;
const BASE_URL = `http://${STEPCLAW_HOST}:${STEPCLAW_PORT}`;

// Hook endpoints
const HOOK_ENDPOINTS = {
  // Agent lifecycle
  before_model_resolve: "/hooks/before_model_resolve",
  before_prompt_build: "/hooks/before_prompt_build",
  before_agent_start: "/hooks/before_agent_start",
  llm_input: "/hooks/llm_input",
  llm_output: "/hooks/llm_output",
  agent_end: "/hooks/agent_end",
  // Message
  message_received: "/hooks/message_received",
  message_sending: "/hooks/message_sending",
  message_sent: "/hooks/message_sent",
  // Tool
  before_tool_call: "/hooks/before_tool_call",
  after_tool_call: "/hooks/after_tool_call",
  tool_client_correlation: "/hooks/tool_client_correlation",
  tool_result_persist: "/hooks/tool_result_persist",
  before_message_write: "/hooks/before_message_write",
  // Session
  session_start: "/hooks/session_start",
  session_end: "/hooks/session_end",
  before_reset: "/hooks/before_reset",
  before_compaction: "/hooks/before_compaction",
  after_compaction: "/hooks/after_compaction",
  // Gateway
  gateway_start: "/hooks/gateway_start",
  gateway_stop: "/hooks/gateway_stop",
  // Subagent
  subagent_spawning: "/hooks/subagent_spawning",
  subagent_delivery_target: "/hooks/subagent_delivery_target",
  subagent_spawned: "/hooks/subagent_spawned",
  subagent_ended: "/hooks/subagent_ended",
};

// Timeouts
const DEFAULT_TIMEOUT_MS = 5000;
const NOTIFICATION_TIMEOUT_MS = 3000;

/**
 * 注册制：cron delivery 由 android-node 根据注册表设置，本插件不再设置，避免 hardcode sessionKey 规则。
 * @returns {undefined} 不处理，交给 android-node before_tool_call
 */
function ensureCronDeliveryForDemoSession(_event, _ctx) {
  return undefined;
}

// Default configuration
let config = {
  enableMemoryRecall: true,
  enableMemoryCapture: true,
  contextInjection: {
    enabled: true,
    mode: "prepend",
    maxContextLength: 4000,
  },
};

/**
 * Helper function for HTTP requests with timeout
 */
async function fetchWithTimeout(url, body, timeoutMs) {
  const controller = new AbortController();
  const timer = setTimeout(() => controller.abort(), timeoutMs);

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
      signal: controller.signal,
    });
    clearTimeout(timer);
    return response;
  } catch (error) {
    clearTimeout(timer);
    throw error;
  }
}

/**
 * Call a hook endpoint and return the result
 * @param {string} hookName - Name of the hook
 * @param {object} payload - Request payload
 * @param {number} timeoutMs - Timeout in milliseconds
 * @returns {Promise<object|null>} Response or null on error
 */
async function callHook(hookName, payload, timeoutMs = DEFAULT_TIMEOUT_MS) {
  const endpoint = HOOK_ENDPOINTS[hookName];
  if (!endpoint) {
    return null;
  }

  const url = `${BASE_URL}${endpoint}`;

  try {
    const res = await fetchWithTimeout(url, payload, timeoutMs);
    if (!res.ok) {
      return null;
    }
    return await res.json();
  } catch (_err) {
    // fail-open: endpoint unreachable or timeout
    return null;
  }
}

/**
 * Call a hook endpoint without waiting for response (fire-and-forget)
 * @param {string} hookName - Name of the hook
 * @param {object} payload - Request payload
 */
function callHookAsync(hookName, payload) {
  const endpoint = HOOK_ENDPOINTS[hookName];
  if (!endpoint) {
    return;
  }

  const url = `${BASE_URL}${endpoint}`;

  fetchWithTimeout(url, payload, NOTIFICATION_TIMEOUT_MS).catch((_err) => {
    // fail-open: log but don't throw
    console.error(`[stepclaw-intercept] ${hookName} hook failed:`, _err.message);
  });
}

/**
 * Extract text content from a message content field
 * Handles both string content and multimodal array format
 * @param {string|Array} content - The content field from a message
 * @returns {string} Extracted text content
 */
function extractTextContent(content) {
  if (!content) {
    return "";
  }

  // If content is already a string, return it
  if (typeof content === "string") {
    return content;
  }

  // If content is an array (multimodal format), extract text parts
  if (Array.isArray(content)) {
    return content
      .filter((part) => part.type === "text" && part.text)
      .map((part) => part.text)
      .join("\n");
  }

  // Fallback: convert to string
  return String(content);
}

/**
 * Helper function to build message history array from hook context
 * Converts OpenClaw message format to LightMem API format
 */
function buildMessageHistory(messages) {
  if (!messages || !Array.isArray(messages)) {
    return [];
  }

  return messages.map((msg) => ({
    role: msg.role || "user",
    content: extractTextContent(msg.content),
  }));
}

/**
 * Format contextBlocks into a string
 * @param {Array} blocks - Array of {label, content, priority}
 * @returns {string} Formatted context string
 */
function formatContextBlocks(blocks) {
  if (!blocks || blocks.length === 0) {
    return "";
  }

  // Sort by priority descending (higher priority first)
  const sortedBlocks = [...blocks].sort((a, b) => (b.priority || 0) - (a.priority || 0));

  // Format each block as [Label]\n\nContent
  const parts = sortedBlocks.map((block) => `[${block.label}]\n\n${block.content}`);

  // Join blocks with separator
  return parts.join("\n\n---\n\n");
}

/**
 * Truncate context to max length, preserving complete blocks when possible
 * @param {string} context - The context string to truncate
 * @param {number} maxLength - Maximum allowed length
 * @returns {string} Truncated context
 */
function truncateContext(context, maxLength) {
  if (!context || context.length <= maxLength) {
    return context;
  }

  // Simple truncation with ellipsis
  return context.substring(0, maxLength - 3) + "...";
}

/**
 * Build the final message content based on mode
 * @param {string} originalContent - Original user message
 * @param {object} result - Response from /hooks/message_sending endpoint
 * @param {object} contextConfig - contextInjection config
 * @returns {object|null} Modified content or null if no modification
 */
function buildMessageContent(originalContent, result, contextConfig) {
  // If contextBlocks exist, use new logic
  if (result.contextBlocks && result.contextBlocks.length > 0) {
    const contextText = formatContextBlocks(result.contextBlocks);
    const truncatedContext = truncateContext(contextText, contextConfig.maxContextLength);

    if (!truncatedContext) {
      return null;
    }

    // Use mode from response, fallback to config
    const mode = (result.mode || contextConfig.mode || "prepend").toLowerCase();

    switch (mode) {
      case "prepend":
        return {
          content: `${truncatedContext}\n\n[Original Message]\n\n${originalContent}`,
        };
      case "append":
        return {
          content: `${originalContent}\n\n${truncatedContext}`,
        };
      case "replace":
        return {
          content: result.transformedContent || originalContent,
        };
      default:
        // Unknown mode, use prepend
        return {
          content: `${truncatedContext}\n\n[Original Message]\n\n${originalContent}`,
        };
    }
  }

  // Legacy: use hint field (backward compatibility)
  if (result.hint && result.hint.length > 0) {
    const truncatedHint = truncateContext(result.hint, contextConfig.maxContextLength);
    return {
      content: `[Memory Context]\n\n${truncatedHint}\n\n[Original Message]\n\n${originalContent}`,
    };
  }

  return null;
}

module.exports = {
  id: "stepclaw-intercept",
  name: "StepClaw Intercept",
  description: "Forwards all plugin hooks to StepClaw HTTP service",

  // 与 openclaw.plugin.json 一致
  configSchema: {
    type: "object",
    properties: {
      enabled: {
        type: "boolean",
        description: "Enable hook forwarding to StepClaw Android. Omit or true to enable; set false to disable.",
        default: true,
      },
      promptStats: {
        type: "object",
        description:
          "lib/prompt-stats.js only: trace JSON and its console logs, independent of other plugin diagnostics.",
        properties: {
          enabled: {
            type: "boolean",
            description:
              "Enable prompt-stats (per-trace JSON under logDir). Off unless explicitly set to true together with logDir; trace JSON contains the full prompt.",
            default: false,
          },
          debug: {
            type: "boolean",
            description: "Verbose console logging from prompt-stats only. Off unless explicitly set to true.",
            default: false,
          },
          logDir: {
            type: "string",
            description: "Directory for per-trace JSON files. No default: prompt-stats does not write anything unless this is set.",
            default: "",
          },
        },
      },
    },
  },

  register(api) {
    // OpenClaw：`plugins.entries["stepclaw-intercept"].config` → `api.pluginConfig`
    const pluginConfig =
      api.pluginConfig && typeof api.pluginConfig === "object" && !Array.isArray(api.pluginConfig)
        ? api.pluginConfig
        : typeof api.config === "function"
          ? api.config()?.["stepclaw-intercept"] ?? {}
          : {};
    // 与 openclaw.plugin.json 一致：仅显式 enabled=false 时关闭整插件注册
    if (pluginConfig.enabled === false) {
      console.log("[stepclaw-intercept] disabled via config (enabled=false)");
      return;
    }

    // Load config from OpenClaw plugin config
    try {
      if (typeof pluginConfig.enableMemoryRecall === "boolean") {
        config.enableMemoryRecall = pluginConfig.enableMemoryRecall;
      }
      if (typeof pluginConfig.enableMemoryCapture === "boolean") {
        config.enableMemoryCapture = pluginConfig.enableMemoryCapture;
      }
      // Load contextInjection config
      if (pluginConfig.contextInjection) {
        const ci = pluginConfig.contextInjection;
        if (typeof ci.enabled === "boolean") {
          config.contextInjection.enabled = ci.enabled;
        }
        if (typeof ci.mode === "string") {
          config.contextInjection.mode = ci.mode;
        }
        if (typeof ci.maxContextLength === "number") {
          config.contextInjection.maxContextLength = ci.maxContextLength;
        }
      }
      // prompt-stats：独立配置块 pluginConfig.promptStats（与顶层 debug 无关）。
      // trace JSON 含完整 prompt，属敏感内容：默认关闭，且必须显式配置 logDir 才落盘。
      const ps = pluginConfig.promptStats;
      const psObject = ps && typeof ps === "object" ? ps : null;
      const logDir =
        psObject && typeof psObject.logDir === "string" ? psObject.logDir.trim() : "";
      promptStats.init({
        enabled: Boolean(psObject && psObject.enabled === true && logDir),
        debug: Boolean(psObject && psObject.debug === true),
        logDir,
      });
    } catch (_err) {
      // Use default config
    }

    // ============================================================
    // AGENT LIFECYCLE HOOKS
    // ============================================================

    // ----------------------------------------
    // before_model_resolve hook
    // Can override model and provider
    // ----------------------------------------
    api.on("before_model_resolve", async (event, ctx) => {
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.BEFORE_MODEL_RESOLVE, {});

      const result = await callHook("before_model_resolve", {
        sessionId: ctx.sessionKey,
        requestedModel: event.requestedModel,
        messages: buildMessageHistory(event.messages),
      });

      if (!result) return;

      return {
        modelOverride: result.modelOverride,
        providerOverride: result.providerOverride,
      };
    });

    // ----------------------------------------
    // before_prompt_build hook
    // Can modify system prompt and inject context
    // ----------------------------------------
    api.on("before_prompt_build", async (event, ctx) => {
      // 记录阶段时间点
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.BEFORE_PROMPT_BUILD, {});

      const result = await callHook("before_prompt_build", {
        sessionId: ctx.sessionKey,
        prompt: event.prompt,
        messages: buildMessageHistory(event.messages),
      }, 15000);

      if (!result) return;

      return {
        systemPrompt: result.systemPrompt,
        prependContext: result.prependContext,
        appendSystemContext: result.appendSystemContext,
      };
    });

    // ----------------------------------------
    // before_agent_start hook (legacy)
    // Combines model resolution and prompt build capabilities
    // ----------------------------------------
    api.on("before_agent_start", async (event, ctx) => {
      // 记录阶段时间点
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.BEFORE_AGENT_START, {});

      const result = await callHook("before_agent_start", {
        sessionId: ctx.sessionKey,
        prompt: event.prompt,
        messages: buildMessageHistory(event.messages),
      });

      if (!result) return;

      return {
        modelOverride: result.modelOverride,
        providerOverride: result.providerOverride,
        systemPrompt: result.systemPrompt,
        prependContext: result.prependContext,
      };
    });

    // ----------------------------------------
    // llm_input hook (notification)
    // For logging/monitoring LLM input
    // ----------------------------------------
    api.on("llm_input", async (event, ctx) => {
      console.log(`[stepclaw-intercept] llm_input: resolved=${resolveTraceId()}, requestSeq=${event.requestSeq}, statsEnabled=${promptStats.isEnabled()}`);

      // 记录阶段时间点
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.LLM_INPUT, {});

      // 记录 prompt 内容（首次请求，或 requestSeq 不可用时始终记录）
      if (!event.requestSeq || event.requestSeq === 1) {
        promptStats.recordPrompt(resolveTraceId(), {
          systemPrompt: event.systemPrompt,
          userPrompt: event.prompt,
          model: event.model,
          provider: event.provider,
          agentId: ctx.agentId,
          agentName: event.agentName,
          requestSeq: event.requestSeq,
          runId: event.runId,
          llmRequestId: event.llmRequestId,
          imagesCount: event.imagesCount,
          historyMessages: buildMessageHistory(event.historyMessages),
        });
      }

      callHookAsync("llm_input", {
        sessionKey: ctx.sessionKey,
        runId: event.runId,
        llmRequestId: event.llmRequestId,
        requestSeq: event.requestSeq,
        model: event.model,
        provider: event.provider,
        systemPrompt: event.systemPrompt,
        prompt: event.prompt,
        historyMessages: buildMessageHistory(event.historyMessages),
        imagesCount: event.imagesCount,
        finalRequestPayload: event.finalRequestPayload ?? null,
        requestEnvelope: event.requestEnvelope ?? null,
      });
    });

    // ----------------------------------------
    // llm_output hook (notification)
    // For logging/monitoring LLM output
    // ----------------------------------------
    api.on("llm_output", async (event, ctx) => {
      console.log(`[stepclaw-intercept] llm_output: resolved=${resolveTraceId()}, runId=${event.runId}`);

      // 记录阶段时间点（包含 usage 信息）
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.LLM_OUTPUT, {
        usage: event.usage,
      });

      callHookAsync("llm_output", {
        sessionKey: ctx.sessionKey,
        runId: event.runId,
        llmRequestId: event.llmRequestId,
        requestSeq: event.requestSeq,
        model: event.model,
        provider: event.provider,
        response: (event.assistantTexts ?? []).join(""),
        sessionResponse: event.sessionResponse ?? null,
        usage: event.usage ?? null,
      });
    });

    // ----------------------------------------
    // agent_end hook - run completion notification
    // Used for memory capture and Android-side end-of-run listeners.
    // ----------------------------------------
    api.on("agent_end", async (event, ctx) => {
      console.log(`[stepclaw-intercept] agent_end: resolved=${resolveTraceId()}, success=${event.success}, durationMs=${event.durationMs}`);

      // 记录阶段时间点
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.AGENT_END, {});

      // 记录最终结果并更新日志
      promptStats.recordResult(resolveTraceId(), {
        success: event.success,
        error: event.error,
        durationMs: event.durationMs,
      });

      const payload = {
        sessionId: ctx.sessionKey,
        sessionKey: ctx.sessionKey,
        success: event.success,
        error: event.error,
        durationMs: event.durationMs,
      };
      if (config.enableMemoryCapture) {
        payload.messages = buildMessageHistory(event.messages || ctx.messages || []);
      }
      callHookAsync("agent_end", payload);

      // 本轮结束，重置 traceId，下轮自动生成新 ID
      resetTraceId();
    });

    // ============================================================
    // MESSAGE HOOKS
    // ============================================================

    // ----------------------------------------
    // message_received hook (notification)
    // Triggered when a message is received
    // ----------------------------------------
    api.on("message_received", async (event, ctx) => {
      // 新一轮对话入口，确保 traceId 重置（兜底 agent_end 未触发的情况）
      resetTraceId();
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.MESSAGE_RECEIVED, {
        sessionKey: ctx.sessionKey,
      });

      callHookAsync("message_received", {
        sessionId: ctx.sessionKey,
        content: event.content,
        senderId: event.senderId,
        timestamp: new Date().toISOString(),
      });
    });

    // ----------------------------------------
    // message_sending hook - Context Injection
    // Can modify or cancel message sending
    // ----------------------------------------
    api.on("message_sending", async (event, ctx) => {
      // 记录阶段时间点
      promptStats.recordPhase(resolveTraceId(), promptStats.PHASES.MESSAGE_SENDING, {});

      if (!config.enableMemoryRecall) {
        return;
      }

      if (!config.contextInjection.enabled) {
        return;
      }

      const result = await callHook("message_sending", {
        sessionId: ctx.sessionKey,
        content: event.content,
        messages: buildMessageHistory(ctx.messages),
        modelName: ctx.modelName || "unknown",
      });

      if (!result) return;

      // Handle cancellation
      if (result.cancel) {
        return { cancel: true };
      }

      // Handle content modification
      const originalContent = event.content || "";
      const modified = buildMessageContent(originalContent, result, config.contextInjection);
      return modified;
    });

    // ----------------------------------------
    // message_sent hook (notification)
    // Triggered after a message is sent
    // ----------------------------------------
    api.on("message_sent", async (event, ctx) => {
      callHookAsync("message_sent", {
        sessionId: ctx.sessionKey,
        content: event.content,
        timestamp: new Date().toISOString(),
      });
    });

    // ============================================================
    // TOOL HOOKS
    // ============================================================

    // ----------------------------------------
    // before_tool_call hook
    // Can intercept, modify, or block tool calls
    // ----------------------------------------
    api.on("before_tool_call", async (event, ctx) => {
      // demo-session 的 cron add：强制 delivery 投递到 android-node / stepclaw-demo
      const cronModified = ensureCronDeliveryForDemoSession(event, ctx);
      if (cronModified) return cronModified;

      const result = await callHook("before_tool_call", {
        sessionId: ctx.sessionKey,
        toolName: event.toolName,
        toolCallId: event.toolCallId,
        params: event.params,
        timestamp: new Date().toISOString(),
      });

      if (result && result.block) {
        return {
          block: true,
          blockReason: result.blockReason || "Blocked by StepClaw policy",
        };
      }

      let finalParams = result && result.params ? result.params : null;

      // Inject sessionKey / runId into node invoke params so Android-side
      // ability handlers can correlate audit records back to the current chat run.
      if (event.toolName === "nodes") {
        const runId = event.runId;
        const base = finalParams || event.params;
        if (base && base.action === "invoke") {
          const raw =
            typeof base.invokeParamsJson === "string"
              ? base.invokeParamsJson.trim()
              : "";
          let parsed = {};
          if (raw) {
            try {
              parsed = JSON.parse(raw);
            } catch (_) {}
          }
          const injectInvokeContext = (obj) => {
            if (!obj || typeof obj !== "object" || Array.isArray(obj)) {
              return;
            }
            if (ctx.sessionKey && obj.sessionKey === undefined) {
              obj.sessionKey = ctx.sessionKey;
            }
            if (runId) {
              if (obj.runId === undefined) {
                obj.runId = runId;
              }
              if (obj._runId === undefined) {
                obj._runId = runId;
              }
            }
          };

          if (Array.isArray(parsed)) {
            parsed.forEach(injectInvokeContext);
          } else {
            injectInvokeContext(parsed);
          }
          finalParams = {
            ...base,
            invokeParamsJson: JSON.stringify(parsed),
          };
        }
      }

      if (finalParams) {
        return { params: finalParams };
      }
    });

    // ----------------------------------------
    // after_tool_call hook (notification)
    // Triggered after a tool execution completes
    // ----------------------------------------
    api.on("after_tool_call", async (event, ctx) => {
      callHookAsync("after_tool_call", {
        sessionId: ctx.sessionKey,
        runId: event.runId,
        toolName: event.toolName,
        toolCallId: event.toolCallId,
        params: event.params,
        result: event.result,
        error: event.error,
        timestamp: new Date().toISOString(),
      });
    });

    // Gateway: full tool result before WS strips it (verbose ≠ full)
    api.on("tool_client_correlation", async (event, ctx) => {
      callHookAsync("tool_client_correlation", {
        sessionId: ctx.sessionKey ?? event.sessionKey,
        runId: event.clientRunId ?? event.runId,
        toolName: event.toolName,
        result: event.result,
        timestamp: new Date().toISOString(),
      });
    });

    // ----------------------------------------
    // tool_result_persist hook (notification only - sync hook)
    // NOTE: This is a synchronous hook, so we use fire-and-forget.
    // Cannot modify the message; use message_sending for content modification.
    // ----------------------------------------
    api.on("tool_result_persist", (event, ctx) => {
      callHookAsync("tool_result_persist", {
        sessionId: ctx.sessionKey,
        toolName: event.toolName,
        message: event.message,
      });
    });

    // ----------------------------------------
    // before_message_write hook (notification only - sync hook)
    // NOTE: This is a synchronous hook, so we use fire-and-forget.
    // Cannot block or modify the message; use message_sending for that.
    // ----------------------------------------
    api.on("before_message_write", (event, ctx) => {
      callHookAsync("before_message_write", {
        sessionId: ctx.sessionKey,
        message: event.message,
      });
    });

    // ============================================================
    // SESSION HOOKS
    // ============================================================

    // ----------------------------------------
    // session_start hook (notification)
    // Triggered when a session is created
    // ----------------------------------------
    api.on("session_start", async (event, ctx) => {
      callHookAsync("session_start", {
        sessionId: ctx.sessionKey,
        agentId: ctx.agentId,
        timestamp: new Date().toISOString(),
      });
    });

    // ----------------------------------------
    // session_end hook (notification)
    // Triggered when a session ends
    // ----------------------------------------
    api.on("session_end", async (event, ctx) => {
      callHookAsync("session_end", {
        sessionId: ctx.sessionKey,
        agentId: ctx.agentId,
        timestamp: new Date().toISOString(),
      });
    });

    // ----------------------------------------
    // before_reset hook (notification)
    // Triggered before /new or /reset
    // ----------------------------------------
    api.on("before_reset", async (event, ctx) => {
      callHookAsync("before_reset", {
        sessionId: ctx.sessionKey,
        agentId: ctx.agentId,
        timestamp: new Date().toISOString(),
      });
    });

    // ----------------------------------------
    // before_compaction hook (notification)
    // Triggered before message compaction
    // ----------------------------------------
    api.on("before_compaction", async (event, ctx) => {
      callHookAsync("before_compaction", {
        sessionId: ctx.sessionKey,
        messageCount: event.messageCount,
        messages: buildMessageHistory(event.messages),
      });
    });

    // ----------------------------------------
    // after_compaction hook (notification)
    // Triggered after message compaction
    // ----------------------------------------
    api.on("after_compaction", async (event, ctx) => {
      callHookAsync("after_compaction", {
        sessionId: ctx.sessionKey,
        originalCount: event.originalCount,
        compactedCount: event.compactedCount,
      });
    });

    // ============================================================
    // GATEWAY HOOKS
    // ============================================================

    // ----------------------------------------
    // gateway_start hook (notification)
    // Triggered when gateway starts
    // ----------------------------------------
    api.on("gateway_start", async (event, ctx) => {
      callHookAsync("gateway_start", {
        gatewayId: event.gatewayId,
        config: event.config,
        timestamp: new Date().toISOString(),
      });
    });

    // ----------------------------------------
    // gateway_stop hook (notification)
    // Triggered when gateway stops
    // ----------------------------------------
    api.on("gateway_stop", async (event, ctx) => {
      callHookAsync("gateway_stop", {
        gatewayId: event.gatewayId,
        reason: event.reason,
        timestamp: new Date().toISOString(),
      });
    });

    // ============================================================
    // SUBAGENT HOOKS
    // ============================================================

    // ----------------------------------------
    // subagent_spawning hook
    // Can control subagent creation behavior
    // ----------------------------------------
    api.on("subagent_spawning", async (event, ctx) => {
      const result = await callHook("subagent_spawning", {
        sessionId: ctx.sessionKey,
        parentSessionId: event.parentSessionId,
        subagentConfig: event.subagentConfig,
      });

      if (!result) return;

      return {
        block: result.block,
        blockReason: result.blockReason,
        modifiedConfig: result.modifiedConfig,
      };
    });

    // ----------------------------------------
    // subagent_delivery_target hook
    // Can modify message delivery target
    // ----------------------------------------
    api.on("subagent_delivery_target", async (event, ctx) => {
      const result = await callHook("subagent_delivery_target", {
        sessionId: ctx.sessionKey,
        originalTarget: event.originalTarget,
      });

      if (!result) return;

      return {
        deliveryTarget: result.deliveryTarget,
      };
    });

    // ----------------------------------------
    // subagent_spawned hook (notification)
    // Triggered after a subagent is created
    // ----------------------------------------
    api.on("subagent_spawned", async (event, ctx) => {
      callHookAsync("subagent_spawned", {
        sessionId: ctx.sessionKey,
        parentSessionId: event.parentSessionId,
        subagentSessionId: event.subagentSessionId,
      });
    });

    // ----------------------------------------
    // subagent_ended hook (notification)
    // Triggered after a subagent ends
    // ----------------------------------------
    api.on("subagent_ended", async (event, ctx) => {
      callHookAsync("subagent_ended", {
        sessionId: ctx.sessionKey,
        parentSessionId: event.parentSessionId,
      });
    });

    // 定期清理过期的缓存记录
    setInterval(() => {
      promptStats.cleanup();
    }, 60000);
  },
};
