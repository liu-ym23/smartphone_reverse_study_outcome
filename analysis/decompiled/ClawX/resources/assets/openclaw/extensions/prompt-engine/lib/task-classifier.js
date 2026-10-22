"use strict";

const crypto = require("crypto");
const fs = require("fs");
const path = require("path");

const VALID_TIERS = new Set(["LITE", "STANDARD", "FULL"]);

// ─── 规则引擎数据 ────────────────────────────────────────────────────────────

const LITE_EXACT_SET = new Set([
  "你好", "好的", "谢谢", "再见", "嗯", "哦", "ok", "hello", "hi",
  "拜拜", "对", "是", "好", "不", "没有", "知道了", "明白", "收到",
  "感谢", "好吧", "行", "可以", "嗯嗯", "哈哈", "晚安", "早安",
  "你好啊", "谢谢你", "不客气", "没事", "没关系",
  "好呀", "了解", "行吧", "是的", "对的", "没问题", "看到了",
  "好哒", "得了", "好滴", "好嘞", "哦哦", "thanks", "bye",
]);

const LITE_PATTERNS = [
  /^什么是/,
  /^(.{1,10})是什么/,
  /等于(几|多少)/,
  /^(\d+[\s]*[+\-*/×÷]\s*\d+[\s]*[=]?\s*)$/,
  /(.{1,6})和(.{1,6})(的区别|有什么不同|哪个好)/,
  /^(介绍一下|解释一下|说说|讲讲)/,
  /^(.{1,6})是谁$/,
  /^(.{1,6})怎么读$/,
  /^(.{1,10})什么意思$/,
  /^what is /i,
  /^who is /i,
  /^how do you say /i,
  /^define /i,
];

// 上下文关键词：要求搭配动作词，防止 "什么是定时任务" 误触
const FULL_CONTEXT_KEYWORDS = [
  /(设置|创建|配置|帮我|添加|新建).{0,6}(定时|提醒|闹钟|计划任务)/,
  /(设置|创建|配置|帮我|添加|新建).{0,6}(cron|定期|周期)/,
  /(帮我|请|帮忙).{0,10}(生成|制作|创建).{0,6}(文档|PPT|报告|方案)/,
  /(帮我|请|帮忙).{0,10}(写|开发|实现|创建|搭建|做).{0,6}(游戏|程序|应用|项目)/,
  /(帮我|请|帮忙).{0,10}(批量|遍历|扫描).{0,6}(文件|目录|文件夹)/,
];

// 多步骤模式
const FULL_REGEX_PATTERNS = [
  /提醒我.{0,20}(点|时|分)/,
  /(先|首先).{2,30}(然后|再|接着|之后)/,
  /(第一步|步骤\s*[1一]).{2,}/,
  /每(天|周|月|小时|隔).{0,10}(执行|运行|发送|提醒|检查)/,
];

// ─── 归一化 ──────────────────────────────────────────────────────────────────

const TRAILING_PUNCT = /[？！。，.!?,~～…]+$/;

function normalizeForMatch(msg) {
  return msg.trim().replace(TRAILING_PUNCT, "");
}

// ─── 自定义规则预编译 ────────────────────────────────────────────────────────

let _compiledCustomRules = null;
let _compiledCustomRulesSource = null;

function getCompiledCustomRules(customRules) {
  if (!Array.isArray(customRules) || customRules.length === 0) return [];
  if (_compiledCustomRulesSource === customRules) return _compiledCustomRules;

  const compiled = [];
  for (const rule of customRules) {
    if (!rule.pattern || !rule.tier) continue;
    try {
      compiled.push({ re: new RegExp(rule.pattern), tier: rule.tier });
    } catch {
      // 非法正则，跳过
    }
  }
  _compiledCustomRules = compiled;
  _compiledCustomRulesSource = customRules;
  return compiled;
}

// ─── 跟随保护 ────────────────────────────────────────────────────────────────

const sessionLastTier = new Map();

const TIER_RANK = { LITE: 0, STANDARD: 1, FULL: 2 };

function maxTier(a, b) {
  return (TIER_RANK[a] ?? 0) >= (TIER_RANK[b] ?? 0) ? a : b;
}

// ─── ClassificationCache (LRU + TTL + inflight 去重) ────────────────────────

class ClassificationCache {
  constructor(maxSize = 128, ttlMs = 300000) {
    this._maxSize = maxSize;
    this._ttlMs = ttlMs;
    this._map = new Map();       // hash → { tier, source, ts }
    this._inflight = new Map();  // hash → Promise
  }

  _hash(message) {
    const normalized = normalizeForMatch(message);
    return crypto.createHash("sha256").update(normalized).digest("hex").slice(0, 16);
  }

  get(message) {
    const key = this._hash(message);
    const entry = this._map.get(key);
    if (!entry) return null;
    if (Date.now() - entry.ts > this._ttlMs) {
      this._map.delete(key);
      return null;
    }
    // 真 LRU：delete + set 刷新位置
    this._map.delete(key);
    this._map.set(key, entry);
    return { tier: entry.tier, source: entry.source };
  }

  set(message, tier, source) {
    const key = this._hash(message);
    if (this._map.size >= this._maxSize) {
      // 淘汰最旧条目（Map 迭代顺序 = 插入顺序）
      const oldest = this._map.keys().next().value;
      this._map.delete(oldest);
    }
    this._map.set(key, { tier, source, ts: Date.now() });
    this._inflight.delete(key);
  }

  getInflight(message) {
    return this._inflight.get(this._hash(message));
  }

  setInflight(message, promise) {
    const key = this._hash(message);
    this._inflight.set(key, promise);
    promise.finally(() => {
      if (this._inflight.get(key) === promise) {
        this._inflight.delete(key);
      }
    });
  }
}

let _cache = null;
let _cacheMaxSize = null;
let _cacheTtlMs = null;

function getCache(config) {
  const maxSize = config.cacheMaxSize ?? 128;
  const ttlMs = config.cacheTtlMs ?? 300000;
  if (!_cache || _cacheMaxSize !== maxSize || _cacheTtlMs !== ttlMs) {
    _cache = new ClassificationCache(maxSize, ttlMs);
    _cacheMaxSize = maxSize;
    _cacheTtlMs = ttlMs;
  }
  return _cache;
}

// ─── 分类 Prompt 加载 ───────────────────────────────────────────────────────

let _classificationPrompt = null;

async function loadClassificationPrompt() {
  if (_classificationPrompt) return _classificationPrompt;
  try {
    const promptPath = path.join(__dirname, "..", "classification-prompts", "complexity.md");
    _classificationPrompt = await fs.promises.readFile(promptPath, "utf-8");
  } catch {
    _classificationPrompt =
      "你是一个任务复杂度分类器。根据用户消息判断任务复杂度。\n" +
      "输出一行 JSON：{\"tier\":\"LITE\"} 或 {\"tier\":\"STANDARD\"} 或 {\"tier\":\"FULL\"}";
  }
  return _classificationPrompt;
}

// ─── 模型输出解析（容错） ───────────────────────────────────────────────────

function extractTier(text) {
  if (!text || typeof text !== "string") return null;
  const trimmed = text.trim();

  // 1. JSON 解析
  try {
    const json = JSON.parse(trimmed);
    if (VALID_TIERS.has(json.tier)) return json.tier;
  } catch { /* fallthrough */ }

  // 2. 从可能包含其他文本的 JSON 中提取
  const jsonMatch = trimmed.match(/\{[^}]*"tier"\s*:\s*"(\w+)"[^}]*\}/);
  if (jsonMatch && VALID_TIERS.has(jsonMatch[1])) return jsonMatch[1];

  // 3. 关键词回退
  const upper = trimmed.toUpperCase();
  if (upper.includes("LITE"))     return "LITE";
  if (upper.includes("STANDARD")) return "STANDARD";
  if (upper.includes("FULL"))     return "FULL";

  return null;
}

// ─── 解析主 Agent 模型 ──────────────────────────────────────────────────────

function resolveMainAgentModel(api) {
  const model = api?.config?.agents?.defaults?.model;
  if (!model) return undefined;
  if (typeof model === "string") return model || undefined;
  if (typeof model === "object" && typeof model.primary === "string") {
    return model.primary || undefined;
  }
  return undefined;
}

/**
 * 从 "provider/model" 格式中拆分 provider 和 modelId，
 * 并从 api.config.models.providers 获取对应 baseUrl。
 * apiKey 优先从 provider 配置读取，其次尝试从 auth-profiles.json 读取。
 */
function resolveProviderEndpoint(api, modelRef) {
  if (!modelRef || !api?.config?.models?.providers) return null;
  const slashIdx = modelRef.indexOf("/");
  let providerName, modelId;
  if (slashIdx > 0) {
    providerName = modelRef.slice(0, slashIdx);
    modelId = modelRef.slice(slashIdx + 1);
  } else {
    modelId = modelRef;
    for (const [name, cfg] of Object.entries(api.config.models.providers)) {
      if (cfg?.models?.some((m) => m.id === modelRef || m.id?.endsWith(`/${modelRef}`))) {
        providerName = name;
        break;
      }
    }
  }
  const provider = providerName ? api.config.models.providers[providerName] : null;
  if (!provider?.baseUrl) return null;
  const apiKey = provider.apiKey || resolveAuthProfileKey(providerName);
  return { baseUrl: provider.baseUrl, modelId, apiKey };
}

let _authProfiles = null;

function resolveAuthProfileKey(providerName) {
  if (!_authProfiles) {
    try {
      const agentDir = process.env.OPENCLAW_AGENT_DIR
        || process.env.PI_CODING_AGENT_DIR
        || path.join(
            process.env.OPENCLAW_STATE_DIR || "/root/.openclaw",
            "agents", "main", "agent"
          );
      const profilePath = path.join(agentDir, "auth-profiles.json");
      const raw = fs.readFileSync(profilePath, "utf-8");
      _authProfiles = JSON.parse(raw);
    } catch {
      _authProfiles = {};
    }
  }
  const profile = _authProfiles?.profiles?.[`${providerName}:default`];
  return profile?.key || undefined;
}

// ─── 模型分类 ───────────────────────────────────────────────────────────────

async function classifyByModel(userMessage, api, config) {
  const model = config.classifierModel ?? resolveMainAgentModel(api) ?? "qwen3-4b";
  const timeoutMs = config.modelTimeoutMs ?? 3000;
  const systemPrompt = await loadClassificationPrompt();
  const logger = api?.logger;

  // 解析 endpoint：优先用 config.classifierEndpoint，否则从 provider 配置解析
  let endpoint = config.classifierEndpoint;
  let modelId = model;
  let apiKey;
  if (!endpoint) {
    const resolved = resolveProviderEndpoint(api, model);
    if (!resolved) {
      logger?.warn?.(`[task-classifier] cannot resolve endpoint for model=${model}`);
      return null;
    }
    endpoint = resolved.baseUrl;
    modelId = resolved.modelId;
    apiKey = resolved.apiKey;
  }

  const url = `${endpoint.replace(/\/+$/, "")}/chat/completions`;
  logger?.debug?.(`[task-classifier] classifyByModel: model=${modelId}, url=${url}, timeout=${timeoutMs}ms`);

  const body = JSON.stringify({
    model: modelId,
    messages: [
      { role: "system", content: systemPrompt },
      { role: "user",   content: userMessage },
    ],
    max_tokens: 32,
    temperature: 0.1,
  });

  const headers = { "Content-Type": "application/json" };
  if (apiKey) headers["Authorization"] = `Bearer ${apiKey}`;

  let text;
  try {
    const controller = new AbortController();
    const timer = setTimeout(() => controller.abort(), timeoutMs);
    const resp = await fetch(url, {
      method: "POST",
      headers,
      body,
      signal: controller.signal,
    });
    clearTimeout(timer);
    if (!resp.ok) {
      logger?.warn?.(`[task-classifier] HTTP ${resp.status} from ${url}`);
      return null;
    }
    const json = await resp.json();
    text = json?.choices?.[0]?.message?.content ?? "";
  } catch (err) {
    logger?.warn?.(`[task-classifier] classifyByModel failed: model=${modelId}, error=${err?.message || err}`);
    return null;
  }

  const tier = extractTier(text);
  if (!tier) return null;
  return { tier, source: `model(${tier})` };
}

// ─── 规则引擎 ────────────────────────────────────────────────────────────────

/**
 * 按优先级顺序执行规则，首个命中即返回。
 *
 * @param {string} msg  用户消息（原文）
 * @param {object} config  taskClassification 配置
 * @param {string|null} lastTier  上一轮 tier
 * @returns {{ tier: string, source: string } | null}
 */
function classifyByRules(msg, config, lastTier) {
  const normalized = normalizeForMatch(msg);
  const normalizedLower = normalized.toLowerCase();

  // R0: 跟随保护 — 上轮非 LITE 且当前短消息（≤10 字符）
  if (lastTier && lastTier !== "LITE" && msg.length <= 10) {
    return { tier: maxTier("STANDARD", lastTier), source: "rule:follow-up" };
  }

  // R1: 短消息 ≤ 4 字符
  if (normalized.length <= 4) {
    return { tier: "LITE", source: "rule:short-message" };
  }

  // R2: LITE 精确词表
  if (LITE_EXACT_SET.has(normalizedLower)) {
    return { tier: "LITE", source: `rule:exact(${normalized})` };
  }

  // R3: LITE 模式匹配（优先于 FULL 关键词）
  for (const re of LITE_PATTERNS) {
    if (re.test(normalized)) {
      return { tier: "LITE", source: `rule:pattern(${re.source.slice(0, 20)})` };
    }
  }

  // R4: FULL 上下文关键词
  for (const re of FULL_CONTEXT_KEYWORDS) {
    if (re.test(normalized)) {
      return { tier: "FULL", source: `rule:context-keyword(${re.source.slice(0, 30)})` };
    }
  }

  // R5: FULL 正则模式
  for (const re of FULL_REGEX_PATTERNS) {
    if (re.test(normalized)) {
      return { tier: "FULL", source: `rule:full-pattern(${re.source.slice(0, 30)})` };
    }
  }

  // R6: 长消息
  const threshold = config.longMessageThreshold ?? 200;
  if (msg.length >= threshold) {
    // 先扫描 FULL 上下文关键词
    for (const re of FULL_CONTEXT_KEYWORDS) {
      if (re.test(msg)) {
        return { tier: "FULL", source: "rule:long-message+keyword" };
      }
    }
    return {
      tier: config.longMessageDefaultTier ?? "STANDARD",
      source: "rule:long-message",
    };
  }

  // R7: 自定义规则
  const customRules = getCompiledCustomRules(config.customRules);
  for (const { re, tier } of customRules) {
    if (re.test(msg)) {
      return { tier, source: `rule:custom(${re.source.slice(0, 20)})` };
    }
  }

  return null;
}

// ─── 主入口 ──────────────────────────────────────────────────────────────────

/**
 * 分类任务复杂度，返回 Prompt Tier。
 *
 * @param {string} userMessage  用户消息文本
 * @param {object} api  插件 API
 * @param {object} config  taskClassification 配置块
 * @param {string} promptMode  "full" | "minimal" | "none"
 * @param {string} sessionKey  会话标识
 * @returns {Promise<{ tier: string, source: string, latencyMs: number } | null>}
 */
async function classifyTask(userMessage, api, config, promptMode, sessionKey) {
  if (config.enabled === false) return null;
  if (promptMode !== "full") return null;
  if (!userMessage || typeof userMessage !== "string" || !userMessage.trim()) return null;

  // 跳过特定会话类型
  const skipTypes = config.skipForSessionTypes ?? ["cron", "subagent"];
  if (sessionKey) {
    for (const t of skipTypes) {
      if (sessionKey.includes(`:${t}:`) || sessionKey.startsWith(`${t}:`)) {
        return null;
      }
    }
  }

  const start = Date.now();
  const lastTier = sessionLastTier.get(sessionKey) ?? null;

  // 缓存查找
  const cache = getCache(config);
  const cached = cache.get(userMessage);
  if (cached) {
    const result = { ...cached, source: `cache(${cached.source})`, latencyMs: 0 };
    sessionLastTier.set(sessionKey, result.tier);
    return result;
  }

  // 规则快路径
  const ruleResult = classifyByRules(userMessage, config, lastTier);
  if (ruleResult) {
    const result = { ...ruleResult, latencyMs: Date.now() - start };
    cache.set(userMessage, result.tier, result.source);
    sessionLastTier.set(sessionKey, result.tier);
    return result;
  }

  // 模型分类（含 inflight 去重）
  if (config.modelClassification !== false) {
    let modelPromise = cache.getInflight(userMessage);
    if (!modelPromise) {
      modelPromise = classifyByModel(userMessage, api, config);
      cache.setInflight(userMessage, modelPromise);
    }

    try {
      const modelResult = await modelPromise;
      if (modelResult) {
        const result = { ...modelResult, latencyMs: Date.now() - start };
        cache.set(userMessage, result.tier, result.source);
        sessionLastTier.set(sessionKey, result.tier);
        return result;
      }
    } catch {
      // 模型分类失败，走兜底
    }
  }

  // 兜底
  const fallbackTier = config.defaultTier ?? "FULL";
  const result = { tier: fallbackTier, source: "fallback", latencyMs: Date.now() - start };
  sessionLastTier.set(sessionKey, result.tier);
  return result;
}

module.exports = { classifyTask, classifyByRules, normalizeForMatch, extractTier, ClassificationCache };
