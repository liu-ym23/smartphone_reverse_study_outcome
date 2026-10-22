"use strict";

// LITE / STANDARD / FULL 三层段落包含矩阵。
// sections 值："on" = 包含完整版, "lite" = 包含精简版, "off" = 去除
// null（FULL）= 不额外过滤，等同于未安装分层功能

const TIER_MATRIX = {
  LITE: {
    sections: {
      "identity":       "lite",
      "tooling":        "off",
      "tool-call-style":"off",
      "safety":         "on",
      "skills-header":  "off",
      "memory-recall":  "off",
      "android-context":"lite",
      "cron-guidance":  "off",
      "workspace-info": "off",
      "silent-replies": "off",
      "heartbeat":      "off",
      "messaging":      "off",
    },
    inject: { currentTime: false, projectContext: false, runtimeLine: false },
    bootstrapWhitelist: ["IDENTITY.md"],
    toolSummaries: [],
  },

  STANDARD: {
    sections: {
      "identity":       "on",
      "tooling":        "on",
      "tool-call-style":"lite",
      "safety":         "on",
      "skills-header":  "lite",
      "memory-recall":  "off",
      "android-context":"lite",
      "cron-guidance":  "off",
      "workspace-info": "lite",
      "silent-replies": "on",
      "heartbeat":      "off",
      "messaging":      "on",
    },
    inject: { currentTime: true, projectContext: true, runtimeLine: true },
    bootstrapWhitelist: ["AGENTS.md", "SOUL.md", "IDENTITY.md"],
    toolSummaries: null,
  },

  FULL: {
    sections: null,
    inject: null,
    bootstrapWhitelist: null,
    toolSummaries: null,
  },
};

const INJECT_DEFAULTS = { currentTime: true, projectContext: true, runtimeLine: true };

/**
 * 将 TIER_MATRIX 默认值与用户 tierOverrides 合并后输出最终配置。
 *
 * @param {string} promptTier  "LITE" | "STANDARD" | "FULL"
 * @param {object} [tierOverrides]  config.json#tierOverrides
 * @returns {object} TierConfig
 */
function resolveTierConfig(promptTier, tierOverrides) {
  const base = TIER_MATRIX[promptTier] ?? TIER_MATRIX.FULL;
  const override = tierOverrides?.[promptTier];
  if (!override) return base;

  return {
    sections: base.sections
      ? { ...base.sections, ...(override.sections ?? {}) }
      : override.sections ?? null,
    inject: override.inject
      ? { ...(base.inject ?? INJECT_DEFAULTS), ...override.inject }
      : base.inject,
    bootstrapWhitelist: override.bootstrapWhitelist ?? base.bootstrapWhitelist,
    toolSummaries: override.toolSummaries ?? base.toolSummaries,
  };
}

/**
 * 查询指定段落在当前 TierConfig 中的模式。
 *
 * @param {object} tierConfig  resolveTierConfig() 的返回值
 * @param {string} sectionId   段落标识（如 "identity", "tooling"）
 * @returns {"on" | "off" | "lite"}
 */
function getTierSectionMode(tierConfig, sectionId) {
  if (!tierConfig || !tierConfig.sections) return "on";
  const mode = tierConfig.sections[sectionId];
  if (mode === "on" || mode === "off" || mode === "lite") return mode;
  return "off";
}

module.exports = { TIER_MATRIX, resolveTierConfig, getTierSectionMode };
