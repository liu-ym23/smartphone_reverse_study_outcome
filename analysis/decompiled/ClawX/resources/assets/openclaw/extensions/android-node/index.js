/**
 * android-node 插件（纯 JS，部署到 APK assets）。
 *
 * 功能：
 * 1. 注册 android-node channel，通过 Gateway broadcast 投递消息到 Android 设备
 * 2. 注册 android-node.init gateway 方法，捕获 broadcast 引用
 * 3. 注册 before_tool_call 钩子，为 demo-session 的 cron add 强制设置 delivery
 */

const CHANNEL_ID = "android-node";

/** 注册制：SDK 通过 android-node.register-session 注册的 sessionKey 集合，cron 仅对注册会话设置 delivery */
const _sdkSessions = new Set();

// ── 模块级共享状态 ──

let _broadcast = null;
let _log = {
  debug: function (msg) { console.log(msg); },
  info: function (msg) { console.log(msg); },
  warn: function (msg) { console.warn(msg); },
};

/**
 * cron 任务每次触发时（before_agent_start, cron session）从 stepclaw 获取并缓存的 traceId。
 * Key = jobId, Value = traceId（由 Android 生成）。
 * sendText 时按 cronJobId 取出并注入到 channel.message payload。
 */
const _cronJobTraceIds = new Map();

const STEPCLAW_HOOK_PORT = 18790;

/** 轻量 HTTP fetch（仅用于 cron_session_start，不依赖全局 fetch 可能不存在的环境）。 */
async function fetchCronSessionStart(sessionKey, jobId) {
  const url = "http://127.0.0.1:" + STEPCLAW_HOOK_PORT + "/hooks/cron_session_start";
  const body = JSON.stringify({ sessionKey: sessionKey, jobId: jobId });
  const controller = typeof AbortController !== "undefined" ? new AbortController() : null;
  const timer = controller ? setTimeout(function () { controller.abort(); }, 2000) : null;
  try {
    const res = await fetch(url, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: body,
      signal: controller ? controller.signal : undefined,
    });
    if (timer) clearTimeout(timer);
    if (!res.ok) return null;
    return await res.json();
  } catch (_err) {
    if (timer) clearTimeout(timer);
    return null;
  }
}

// ── Channel Plugin ──

const androidNodePlugin = {
  id: CHANNEL_ID,

  meta: {
    id: CHANNEL_ID,
    label: "Android Node",
    selectionLabel: "Android Node",
    docsPath: "",
    blurb: "Deliver messages to connected Android devices via Gateway WebSocket broadcast",
  },

  capabilities: {
    chatTypes: ["direct"],
    reactions: false,
    threads: false,
    media: false,
    polls: false,
    nativeCommands: false,
    blockStreaming: false,
  },

  config: {
    listAccountIds: function () { return ["default"]; },

    resolveAccount: function (_cfg, accountId) {
      return { accountId: accountId || "default", enabled: true };
    },

    isConfigured: function () { return true; },
  },

  outbound: {
    deliveryMode: "direct",
    textChunkLimit: 4096,

    sendText: async function (ctx) {
      var rawTo = ctx.to;
      var text = ctx.text;
      // add by stepos modify start
      var cronJobId = null;
      var sep = typeof rawTo === "string" ? rawTo.indexOf("|cronJobId=") : -1;
      if (sep >= 0) {
        cronJobId = rawTo.substring(sep + "|cronJobId=".length).trim();
        rawTo = rawTo.substring(0, sep);
      }
      // add by stepos modify end
      var to = rawTo;
      _log.info("[android-node] sendText: to=" + to + ", textLen=" + text.length);

      if (!_broadcast) {
        _log.warn("[android-node] sendText: broadcast not initialized, call android-node.init first");
        return { channel: CHANNEL_ID, messageId: "", ok: false, error: "not initialized" };
      }

      var timestamp = Date.now();
      var messageId = CHANNEL_ID + "-" + timestamp;

      // to 可为 sessionKey；cron 等场景可能为 "agent:main:desktop-UUID"、"nodeId:sessionKey" 或裸 sessionKey
      var targetSession = null;
      if (typeof to === "string" && to.trim()) {
        var t = to.trim();
        var agentMainPrefix = "agent:main:";
        if (t.startsWith(agentMainPrefix)) {
          targetSession = t.substring(agentMainPrefix.length); // "desktop-UUID"
        } else {
          targetSession = t.indexOf(":") >= 0 ? t.substring(t.indexOf(":") + 1) : t;
        }
      }
      var payload = {
        channel: CHANNEL_ID,
        to: to,
        text: text,
        timestamp: timestamp,
        messageId: messageId,
      };
      if (targetSession) payload.targetSession = targetSession;
      // add by stepos modify start
      if (cronJobId) payload.cronJobId = cronJobId;
      // add by stepos modify end

      // 取出由 before_agent_start（cron session）从 stepclaw 获取的 traceId，注入 payload
      if (cronJobId) {
        var cronTraceId = _cronJobTraceIds.get(cronJobId);
        if (cronTraceId) {
          payload.traceId = cronTraceId;
          _cronJobTraceIds.delete(cronJobId);
          _log.info("[android-node] sendText: inject cron traceId=" + cronTraceId + " cronJobId=" + cronJobId);
        } else {
          _log.debug("[android-node] sendText: no cached traceId for cronJobId=" + cronJobId);
        }
      }

      if (cronJobId) {
        _log.info("[cron-msgid] plugin_sendText_encode | cronJobId=" + cronJobId + " targetSession=" + (targetSession || "(none)") + " (channel.message payload will include cronJobId for SDK SP lookup)");
      }
      _log.info("[android-node] sendText: payload targetSession=" + (targetSession || "(none)") + (cronJobId ? " cronJobId=" + cronJobId : "") + ", broadcasting channel.message");
      // add by stepos modify start
      // New Gateway returns { sent }; old/no return → conservative success (do not fail delivery).
      var br = _broadcast("channel.message", payload, { dropIfSlow: true });
      if (br && typeof br === "object" && Object.prototype.hasOwnProperty.call(br, "sent") && br.sent === 0) {
        _log.warn("[android-node] sendText: broadcast sent=0 (no subscribers)");
        return { channel: CHANNEL_ID, messageId: "", ok: false, error: "broadcast: no subscribers" };
      }
      // add by stepos modify end

      _log.info("[android-node] sendText: broadcast ok, messageId=" + messageId);
      return { channel: CHANNEL_ID, messageId: messageId };
    },
  },
};

// ── 插件主体 ──

module.exports = {
  id: "android-node",
  name: "Android Node",
  description: "Deliver cron/heartbeat messages to Android devices via Gateway broadcast",

  configSchema: {
    type: "object",
    additionalProperties: false,
    properties: {},
  },

  register: function (api) {
    if (api.logger) {
      _log = api.logger;
    }
    _log.info("[android-node] plugin registering");

    // 注册 channel
    api.registerChannel({ plugin: androidNodePlugin });
    _log.debug("[android-node] channel registered");

    // 注册 gateway 方法：android-node.init，捕获 broadcast 引用
    api.registerGatewayMethod("android-node.init", function (opts) {
      var respond = opts.respond;
      var context = opts.context;

      if (context && context.broadcast) {
        _broadcast = context.broadcast;
        _log.debug("[android-node] init: broadcast reference captured");
      } else {
        _log.warn("[android-node] init: context.broadcast not available");
      }

      respond(true, { ok: true });
    });
    _log.debug("[android-node] gateway method android-node.init registered");

    // 注册制：SDK 调用此方法注册 sessionKey，仅注册过的会话的 cron 会投递到 android-node
    api.registerGatewayMethod("android-node.register-session", function (opts) {
      var respond = opts.respond;
      var params = opts.params || opts;
      var sessionKey = (params && params.sessionKey != null) ? String(params.sessionKey).trim() : "";
      _log.info("[android-node] register-session: received sessionKey=" + (sessionKey || "(empty)"));
      if (sessionKey) {
        _sdkSessions.add(sessionKey);
        var ctx = opts.context;
        var client = opts.client;
        var connect = (client && client.connect) || {};
        var nodeId = (connect.device && connect.device.id) || (connect.client && connect.client.id) || null;
        if (nodeId && ctx && typeof ctx.nodeSubscribe === "function") {
          ctx.nodeSubscribe(nodeId, sessionKey);
          _log.debug("[android-node] register-session: nodeSubscribe(" + nodeId + ", " + sessionKey + ")");
        }
        _log.info("[android-node] register-session: registered sessionKey=" + sessionKey + ", total=" + _sdkSessions.size);
      } else {
        _log.warn("[android-node] register-session: empty sessionKey, ignored");
      }
      respond(true, { ok: true });
    });
    _log.debug("[android-node] gateway method android-node.register-session registered");

    // 注册制：仅对已注册会话设置 cron delivery。Gateway 的 ctx.sessionKey 可能带 agent:main: 前缀，用 effectiveKey 与注册表对齐
    api.on("before_tool_call", function (event, ctx) {
      if (!event || event.toolName !== "cron") return;
      var params = event.params;
      if (!params || params.action !== "add") return;

      var sessionKey = (ctx && ctx.sessionKey) ? String(ctx.sessionKey).trim() : "";
      var effectiveKey = sessionKey.startsWith("agent:main:") ? sessionKey.substring("agent:main:".length) : sessionKey;
      var isRegistered = _sdkSessions.has(sessionKey) || _sdkSessions.has(effectiveKey);
      _log.info("[android-node] before_tool_call cron add: ctx.sessionKey=" + (sessionKey || "(empty)") + " effectiveKey=" + effectiveKey + " isRegistered=" + isRegistered);
      if (!isRegistered) {
        _log.debug("[android-node] before_tool_call cron add: skip, sessionKey not registered, sessionKey=" + (sessionKey || "(empty)"));
        return;
      }
      var toSessionKey = sessionKey;
      _log.info("[android-node] before_tool_call cron add: setting delivery to=" + toSessionKey + " (full sessionKey)");
      var delivery = { mode: "announce", channel: CHANNEL_ID, to: toSessionKey };
      var out = Object.assign({}, params);

      // Gateway 要求：channel delivery 仅当 sessionTarget="isolated" 且 payload.kind="agentTurn" 时合法。
      // agentTurn 的 payload 不能有 systemEvent 的 text 等字段，必须重建干净对象，否则 cron.add 校验失败。
      function ensureAgentTurnPayload(p) {
        var msg = "reminder";
        var model;
        var thinking;
        var timeoutSeconds;
        var allowUnsafe;
        if (p && typeof p === "object") {
          if (p.kind === "agentTurn" && p.message != null) {
            msg = String(p.message);
            if (p.model != null && p.model !== "") model = p.model;
            if (p.thinking !== undefined) thinking = p.thinking;
            if (p.timeoutSeconds !== undefined && p.timeoutSeconds !== null) timeoutSeconds = p.timeoutSeconds;
            if (p.allowUnsafeExternalContent !== undefined) allowUnsafe = p.allowUnsafeExternalContent;
          } else if (p.kind === "systemEvent" && p.text != null) {
            msg = String(p.text);
          } else if (p.text != null) {
            msg = String(p.text);
          } else if (p.message != null) {
            msg = String(p.message);
          }
        }
        var pl = { kind: "agentTurn", message: msg };
        if (model !== undefined) pl.model = model;
        if (thinking !== undefined) pl.thinking = thinking;
        if (timeoutSeconds !== undefined) pl.timeoutSeconds = timeoutSeconds;
        if (allowUnsafe !== undefined) pl.allowUnsafeExternalContent = allowUnsafe;
        return pl;
      }
      if (out.job && typeof out.job === "object") {
        out.job = Object.assign({}, out.job, {
          sessionTarget: "isolated",
          delivery: Object.assign({}, out.job.delivery || {}, delivery),
          payload: ensureAgentTurnPayload(out.job.payload),
        });
      } else {
        out.sessionTarget = "isolated";
        out.delivery = Object.assign({}, out.delivery || {}, delivery);
        out.payload = ensureAgentTurnPayload(out.payload);
      }

      _log.info("[android-node] cron add: registered session, delivery to=" + toSessionKey);
      return { params: out };
    });
    _log.debug("[android-node] before_tool_call hook registered");

    // 检测 cron agent session 启动，从 stepclaw 获取本次触发的 traceId，缓存供 sendText 注入 payload。
    // ctx.sessionKey 格式：agent:main:cron:<jobId>
    api.on("before_agent_start", async function (event, ctx) {
      var sessionKey = (ctx && ctx.sessionKey) ? String(ctx.sessionKey).trim() : "";
      var cronMarker = ":cron:";
      var idx = sessionKey.indexOf(cronMarker);
      if (idx < 0) return; // 非 cron session，忽略

      var jobId = sessionKey.substring(idx + cronMarker.length).trim();
      if (!jobId) return;

      _log.info("[android-node] before_agent_start cron: sessionKey=" + sessionKey + " jobId=" + jobId);

      try {
        var result = await fetchCronSessionStart(sessionKey, jobId);
        if (result && result.traceId) {
          _cronJobTraceIds.set(jobId, result.traceId);
          _log.info("[android-node] cron traceId cached: jobId=" + jobId + " traceId=" + result.traceId);
        } else {
          _log.warn("[android-node] cron_session_start: no traceId returned for jobId=" + jobId);
        }
      } catch (err) {
        _log.warn("[android-node] cron_session_start fetch error: " + (err && err.message ? err.message : String(err)));
      }
    });
    _log.debug("[android-node] before_agent_start hook registered");

    // ── 会话生命周期广播 ──────────────────────────────────────────────────────
    // session_start / session_end：会话创建或结束时广播 "session.lifecycle" 事件。
    // 不在插件侧做渠道过滤，由 SDK 的 SessionManager.isChannelSessionKey() 统一判断。

    api.on("session_start", function (event, ctx) {
      var sessionKey = (ctx && ctx.sessionKey) ? String(ctx.sessionKey).trim() : "";
      if (!sessionKey) return;
      _log.info("[android-node] session_start: broadcasting session.lifecycle created sessionKey=" + sessionKey);
      if (_broadcast) {
        _broadcast("session.lifecycle", {
          action: "created",
          sessionKey: sessionKey,
          timestamp: Date.now(),
        });
      }
    });
    _log.debug("[android-node] session_start hook registered");

    api.on("session_end", function (event, ctx) {
      var sessionKey = (ctx && ctx.sessionKey) ? String(ctx.sessionKey).trim() : "";
      if (!sessionKey) return;
      _log.info("[android-node] session_end: broadcasting session.lifecycle deleted sessionKey=" + sessionKey);
      if (_broadcast) {
        _broadcast("session.lifecycle", {
          action: "deleted",
          sessionKey: sessionKey,
          timestamp: Date.now(),
        });
      }
    });
    _log.debug("[android-node] session_end hook registered");

    _log.info("[android-node] plugin registered");
  },
};
