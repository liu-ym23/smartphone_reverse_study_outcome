"use strict";

const DEFAULT_LLM_OVERRIDES = {
  LITE:     { thinking: false, temperature: 0.3 },
  STANDARD: { thinking: true },
  FULL:     { thinking: true },
};

/**
 * 根据 Prompt Tier 和用户 tierOverrides 生成 LLM 调用参数覆盖。
 *
 * @param {string} promptTier  "LITE" | "STANDARD" | "FULL"
 * @param {object} [tierOverrides]  config.json#tierOverrides
 * @returns {object} LlmOverrides — 空对象表示使用 Gateway 默认参数
 */
function resolveLlmOverrides(promptTier, tierOverrides) {
  const defaults = DEFAULT_LLM_OVERRIDES[promptTier] ?? {};
  const overrides = tierOverrides?.[promptTier]?.llmOverrides ?? {};
  return { ...defaults, ...overrides };
}

module.exports = { resolveLlmOverrides, DEFAULT_LLM_OVERRIDES };
