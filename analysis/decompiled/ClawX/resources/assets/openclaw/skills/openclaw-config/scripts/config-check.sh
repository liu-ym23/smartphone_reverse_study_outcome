#!/bin/bash
# config-check.sh — OpenClaw 配置验证脚本
# 用法: bash scripts/config-check.sh
#
# 执行 openclaw doctor 并输出简洁结果。
# 可在修改配置后运行，验证 schema 是否合法。

set -euo pipefail

echo "=== OpenClaw Config Check ==="
echo ""

# 1. 显示当前配置文件路径
echo "[1/3] Config path:"
openclaw config get --keys-only 2>/dev/null | head -5 || echo "  (unable to read config)"
echo ""

# 2. 运行 doctor
echo "[2/3] Running openclaw doctor..."
if openclaw doctor 2>&1; then
  echo "  ✅ All checks passed"
else
  echo "  ❌ Issues found — check output above"
  exit 1
fi
echo ""

# 3. 检查 Gateway 在线状态
echo "[3/3] Gateway status:"
if openclaw gateway call config.get --params '{}' >/dev/null 2>&1; then
  echo "  ✅ Gateway online and responding"
else
  echo "  ⚠️  Gateway offline or not responding (config changes will apply on next start)"
fi
