"use strict";
/**
 * Prompt 统计模块
 *
 * 按 traceId 记录各阶段耗时和完整 prompt 内容。
 * 每个 trace 独立一个 JSON 日志文件，文件名：`{本地时间}_{traceId}.json`，
 * 例如 `2020-5-20-12-03-09_abc123.json`（时间取自该 trace 首次 recordPhase 的时刻）。
 *
 * 使用方式：
 * 1. 在宿主 register() 中调用 init({ enabled, debug, logDir })；OpenClaw 下由 stepclaw-intercept 的
 *    插件配置 `promptStats` 块传入（与插件顶层 `enabled` / `debug` 无关）。
 * 2. 在各 hook 中调用 recordPhase(traceId, phase, context)
 * 3. 在 llm_input hook 中调用 recordPrompt(traceId, promptData)（只更新内存，不落盘）
 * 4. llm_output 阶段 recordPhase 后会落盘（含 llm_input 与 prompt），不依赖 agent_end
 * 5. 在 agent_end hook 中调用 recordResult(traceId, resultData)（无 traceId 时跳过，仍以 llm_output 落盘为准）
 */

const fs = require("fs");
const path = require("path");

/** 本模块逻辑版本（与插件 package 版本可不同步；写入 JSON 便于确认是否已部署新脚本） */
const VERSION = "1.0.1";

// 阶段常量
const PHASES = {
  MESSAGE_RECEIVED: "message_received",
  MESSAGE_SENDING: "message_sending",
  BEFORE_MODEL_RESOLVE: "before_model_resolve",
  BEFORE_PROMPT_BUILD: "before_prompt_build",
  BEFORE_AGENT_START: "before_agent_start",
  LLM_INPUT: "llm_input",
  LLM_OUTPUT: "llm_output",
  AGENT_END: "agent_end",
};

// 阶段顺序（用于计算相邻阶段耗时）
const PHASE_ORDER = [
  PHASES.MESSAGE_RECEIVED,
  PHASES.MESSAGE_SENDING,
  PHASES.BEFORE_MODEL_RESOLVE,
  PHASES.BEFORE_PROMPT_BUILD,
  PHASES.BEFORE_AGENT_START,
  PHASES.LLM_INPUT,
  PHASES.LLM_OUTPUT,
  PHASES.AGENT_END,
];

// 模块配置。trace JSON 含完整 prompt，属敏感内容：默认关闭，且不内置落盘目录，
// 必须由宿主显式传入 promptStats.enabled + logDir 才会落盘。
let config = {
  enabled: false,
  /** 为 true 时打印 recordPhase / recordResult / 落盘文件名等诊断日志 */
  debug: false,
  logDir: "",
};

// 内存缓存：traceId -> TraceData
const traceCache = new Map();

function debugLog(...args) {
  if (config.debug) {
    console.log(...args);
  }
}

/**
 * 初始化模块配置
 * @param {object} [options]
 * @param {boolean} [options.enabled] - 是否启用统计与落盘；默认 false
 * @param {boolean} [options.debug] - 是否打印详细控制台日志；默认 false
 * @param {string} [options.logDir] - 日志目录；未配置时不落盘
 */
function init(options = {}) {
  if (typeof options.enabled === "boolean") {
    config.enabled = options.enabled;
  }
  if (typeof options.debug === "boolean") {
    config.debug = options.debug;
  }
  if (typeof options.logDir === "string") {
    config.logDir = options.logDir;
  }
  console.log(
    `[prompt-stats] v${VERSION} initialized: enabled=${config.enabled}, debug=${config.debug}, logDir=${config.logDir}`,
  );
}

/**
 * 检查是否启用统计
 * @returns {boolean}
 */
function isEnabled() {
  return config.enabled;
}

/**
 * 确保日志目录存在
 * @returns {boolean}
 */
function ensureLogDir() {
  if (!config.logDir) {
    return false;
  }
  try {
    if (!fs.existsSync(config.logDir)) {
      fs.mkdirSync(config.logDir, { recursive: true });
    }
    return true;
  } catch (err) {
    console.error(`[prompt-stats] failed to create log dir: ${err.message}`);
    return false;
  }
}

/**
 * 获取或创建 trace 数据
 * @param {string} traceId
 * @returns {object|null}
 */
function getOrCreateTrace(traceId) {
  if (!traceId) {
    return null;
  }

  if (traceCache.has(traceId)) {
    return traceCache.get(traceId);
  }

  const trace = {
    traceId,
    sessionKey: null,
    startTime: null,
    startTimestamp: null,
    phases: new Map(),
    metadata: {},
    prompt: null,
    result: null,
    written: false,
  };
  traceCache.set(traceId, trace);
  return trace;
}

/**
 * 格式化 ISO 时间
 * @param {number} timestamp
 * @returns {string}
 */
function formatISOTime(timestamp) {
  return new Date(timestamp).toISOString();
}

/**
 * 日志文件名用本地时间前缀：YYYY-M-D-H-mm-ss（与示例 2020-5-20-12-03-09 一致，分秒两位补零）
 * @param {number} timestamp - ms
 * @returns {string}
 */
function formatLocalFileTimestamp(timestamp) {
  const d = new Date(timestamp);
  const y = d.getFullYear();
  const mo = d.getMonth() + 1;
  const day = d.getDate();
  const h = d.getHours();
  const mi = String(d.getMinutes()).padStart(2, "0");
  const s = String(d.getSeconds()).padStart(2, "0");
  return `${y}-${mo}-${day}-${h}-${mi}-${s}`;
}

/** 文件名用片段：去掉路径分隔符等，避免 traceId 异常时破坏落盘 */
function sanitizeFileSegment(raw) {
  return String(raw)
    .replace(/[\s<>:"/\\|?*\u0000-\u001f]+/g, "_")
    .replace(/_+/g, "_")
    .replace(/^_|_$/g, "")
    .slice(0, 200) || "unknown";
}

/**
 * 计算各阶段耗时（按实际触发顺序）
 * @param {Map} phases - phase -> timestamp
 * @param {number} startTimestamp
 * @returns {object}
 */
function calculatePhaseDurations(phases, startTimestamp) {
  const durations = {};

  // 按实际时间戳排序，而不是假设固定顺序
  const sortedPhases = [...phases.entries()]
    .sort((a, b) => a[1] - b[1])
    .map(([phase, timestamp]) => ({ phase, timestamp }));

  // 计算相邻阶段耗时
  for (let i = 1; i < sortedPhases.length; i++) {
    const prev = sortedPhases[i - 1];
    const curr = sortedPhases[i];
    const key = `${prev.phase}_to_${curr.phase}_ms`;
    durations[key] = curr.timestamp - prev.timestamp;
  }

  // 计算总耗时
  if (sortedPhases.length > 0) {
    const firstTimestamp = sortedPhases[0].timestamp;
    const lastTimestamp = sortedPhases[sortedPhases.length - 1].timestamp;
    durations.total_ms = lastTimestamp - firstTimestamp;
  }

  return durations;
}

/**
 * 构建日志对象
 * @param {object} trace
 * @returns {object}
 */
function buildLogObject(trace) {
  // 按时间戳排序获取阶段顺序
  const sortedPhases = [...trace.phases.entries()]
    .sort((a, b) => a[1] - b[1]);

  const timing = {};
  for (const [phase, timestamp] of sortedPhases) {
    timing[phase] = {
      timestamp,
      elapsed_ms: trace.startTimestamp ? timestamp - trace.startTimestamp : 0,
    };
  }

  const phaseDurations = calculatePhaseDurations(trace.phases, trace.startTimestamp);

  // 记录实际阶段顺序
  const phaseOrder = sortedPhases.map(([phase]) => phase);

  const lastPhaseTimestamp = sortedPhases.length > 0
    ? sortedPhases[sortedPhases.length - 1][1]
    : null;

  return {
    promptStatsSchemaVersion: 2,
    promptStatsModuleVersion: VERSION,
    traceId: trace.traceId,
    sessionKey: trace.sessionKey,
    startTime: trace.startTime,
    endTime: lastPhaseTimestamp ? formatISOTime(lastPhaseTimestamp) : null,
    phaseOrder,
    timing,
    phaseDurations,
    metadata: trace.metadata,
    prompt: trace.prompt,
    result: trace.result,
  };
}

/**
 * 写入日志文件（原子写入）
 * @param {object} trace
 */
function writeLogFile(trace) {
  if (!config.enabled) {
    return;
  }
  if (!ensureLogDir()) {
    return;
  }

  try {
    const logObject = buildLogObject(trace);
    const content = JSON.stringify(logObject, null, 2);

    const ts = trace.startTimestamp ?? Date.now();
    const prefix = formatLocalFileTimestamp(ts);
    const idPart = sanitizeFileSegment(trace.traceId ?? "unknown");
    const fileName = `${prefix}_${idPart}.json`;
    const filePath = path.join(config.logDir, fileName);
    const tmpPath = filePath + ".tmp";

    // 原子写入：先写 tmp 文件，再 rename
    fs.writeFileSync(tmpPath, content, "utf-8");
    fs.renameSync(tmpPath, filePath);

    trace.written = true;
    const absPath = path.resolve(filePath);
    debugLog(
      `[prompt-stats] v${VERSION} schema=2 wrote ${absPath} (basename=${fileName})`,
    );
  } catch (err) {
    console.error(`[prompt-stats] write error: ${err.message}`);
  }
}

/**
 * 记录某个阶段的时间点
 * @param {string} traceId - trace 标识（为空时静默返回）
 * @param {string} phase - 阶段名称
 * @param {object} [context] - 上下文信息
 */
function recordPhase(traceId, phase, context = {}) {
  if (!config.enabled) {
    return;
  }

  if (!traceId) {
    return;
  }

  const now = Date.now();
  const trace = getOrCreateTrace(traceId);
  if (!trace) {
    return;
  }

  trace.phases.set(phase, now);
  debugLog(`[prompt-stats] recordPhase: traceId=${traceId}, phase=${phase}, elapsed=${trace.startTimestamp ? now - trace.startTimestamp : 0}ms`);

  // 首个阶段记录开始时间
  if (trace.startTimestamp === null) {
    trace.startTimestamp = now;
    trace.startTime = formatISOTime(now);
  }

  // 记录 sessionKey
  if (context.sessionKey && !trace.sessionKey) {
    trace.sessionKey = context.sessionKey;
  }

  // 记录 usage 信息（llm_output 阶段）
  if (phase === PHASES.LLM_OUTPUT && context.usage) {
    trace.metadata.usage = context.usage;
  }

  // llm_output 阶段落盘（含 llm_input 与 prompt），不依赖 agent_end
  if (phase === PHASES.LLM_OUTPUT && trace.prompt) {
    setImmediate(() => {
      writeLogFile(trace);
    });
  }
}

/**
 * 记录 prompt 内容并写入日志文件
 * @param {string} traceId
 * @param {object} promptData
 */
function recordPrompt(traceId, promptData) {
  if (!config.enabled) {
    debugLog(`[prompt-stats] recordPrompt: skipped, disabled`);
    return;
  }

  if (!traceId) {
    debugLog(`[prompt-stats] recordPrompt: skipped, no traceId`);
    return;
  }

  const trace = traceCache.get(traceId);
  if (!trace) {
    debugLog(`[prompt-stats] recordPrompt: skipped, trace not found for ${traceId} (cache keys: ${[...traceCache.keys()].join(', ')})`);
    return;
  }

  const systemPromptChars = promptData.systemPrompt?.length || 0;
  const userPromptChars = promptData.userPrompt?.length || 0;
  const totalChars = systemPromptChars + userPromptChars;

  debugLog(`[prompt-stats] recordPrompt: traceId=${traceId}, systemPrompt=${systemPromptChars}chars, userPrompt=${userPromptChars}chars, total=${totalChars}chars`);

  trace.prompt = {
    systemPrompt: promptData.systemPrompt || "",
    userPrompt: promptData.userPrompt || "",
    systemPromptChars,
    userPromptChars,
    totalChars,
    estimatedTokens: Math.floor(totalChars / 2),
  };

  // 记录 metadata
  trace.metadata = {
    ...trace.metadata,
    model: promptData.model || null,
    provider: promptData.provider || null,
    agentId: promptData.agentId || null,
    agentName: promptData.agentName || null,
    requestSeq: promptData.requestSeq ?? null,
    runId: promptData.runId || null,
    llmRequestId: promptData.llmRequestId || null,
    imagesCount: promptData.imagesCount || 0,
  };

  // 记录 history（可选，截断避免文件过大）
  if (promptData.historyMessages && Array.isArray(promptData.historyMessages)) {
    trace.metadata.historyCount = promptData.historyMessages.length;
  }
}

/**
 * 记录最终结果并更新日志文件
 * @param {string} traceId
 * @param {object} resultData
 */
function recordResult(traceId, resultData) {
  if (!config.enabled) {
    return;
  }

  if (!traceId) {
    debugLog(`[prompt-stats] recordResult: skipped, no traceId`);
    return;
  }

  const trace = traceCache.get(traceId);
  if (!trace) {
    debugLog(`[prompt-stats] recordResult: trace not found for ${traceId}`);
    return;
  }

  debugLog(`[prompt-stats] recordResult: traceId=${traceId}, success=${resultData.success}`);

  trace.result = {
    success: resultData.success ?? null,
    error: resultData.error || null,
    durationMs: resultData.durationMs ?? null,
  };

  // 更新日志文件
  setImmediate(() => {
    writeLogFile(trace);
  });
}

/**
 * 清理过期的缓存记录
 * @param {number} [maxAgeMs=300000] - 最大存活时间（毫秒），默认 5 分钟
 */
function cleanup(maxAgeMs = 300000) {
  if (!config.enabled) {
    return;
  }
  const now = Date.now();
  let cleaned = 0;

  for (const [traceId, trace] of traceCache.entries()) {
    if (trace.startTimestamp && (now - trace.startTimestamp) > maxAgeMs) {
      traceCache.delete(traceId);
      cleaned++;
    }
  }

  if (cleaned > 0) {
    debugLog(`[prompt-stats] cleaned ${cleaned} stale entries`);
  }
}

module.exports = {
  VERSION,
  PHASES,
  init,
  isEnabled,
  recordPhase,
  recordPrompt,
  recordResult,
  cleanup,
};
