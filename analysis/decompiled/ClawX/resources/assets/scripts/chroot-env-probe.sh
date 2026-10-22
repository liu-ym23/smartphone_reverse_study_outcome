#!/bin/bash
# chroot-env-probe.sh - L0 environment probe for StepClaw chroot rootfs.
# Runs inside chroot and outputs JSON to stdout.
# Called only by the E2E harness after entering chroot outside the app process.

set -u
export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
export HOME=/root

RESULTS="["
FIRST=true
PASS=0
FAIL=0

emit() {
  local id="$1" status="$2" details="$3"
  if [ "$FIRST" = true ]; then FIRST=false; else RESULTS="$RESULTS,"; fi
  RESULTS="$RESULTS{\"id\":\"$id\",\"status\":\"$status\",\"details\":$details}"
  if [ "$status" = "pass" ]; then PASS=$((PASS+1)); else FAIL=$((FAIL+1)); fi
}

# --- Binaries ---
for bin in python3 node bash npm pip3 curl git; do
  p=$(which "$bin" 2>/dev/null)
  if [ -n "$p" ]; then
    ver=$("$bin" --version 2>&1 | head -1)
    emit "$bin" "pass" "{\"path\":\"$p\",\"version\":\"$ver\"}"
  else
    emit "$bin" "fail" "{\"error\":\"not found in PATH\"}"
  fi
done

# --- Python packages ---
for pkg in requests numpy pandas PIL faster_whisper av srt; do
  imp="$pkg"
  if [ "$pkg" = "PIL" ]; then imp="from PIL import Image"; else imp="import $pkg"; fi
  err=$(python3 -c "$imp" 2>&1)
  if [ $? -eq 0 ]; then
    emit "python:$pkg" "pass" "{}"
  else
    emit "python:$pkg" "fail" "{\"error\":\"$(echo "$err" | tail -1 | sed 's/"/\\"/g')\"}"
  fi
done

# --- Node modules (with Gateway NODE_PATH) ---
export NODE_PATH=/usr/local/lib/node_modules/openclaw/node_modules
err=$(node -e "require('zod'); console.log('ok')" 2>&1)
if echo "$err" | grep -q "ok"; then
  emit "node:zod" "pass" "{}"
else
  emit "node:zod" "fail" "{\"error\":\"$(echo "$err" | tail -1 | sed 's/"/\\"/g')\"}"
fi

# --- npm functional ---
npm list -g --depth=0 >/dev/null 2>&1
if [ $? -eq 0 ]; then
  emit "npm_functional" "pass" "{}"
else
  emit "npm_functional" "fail" "{\"error\":\"npm list -g returned non-zero\"}"
fi

# --- Network ---
python3 -c "import socket; s=socket.socket(); s.settimeout(5); s.connect(('8.8.8.8',53)); s.close(); print('ok')" 2>/dev/null | grep -q ok
if [ $? -eq 0 ]; then
  emit "network_socket" "pass" "{}"
else
  emit "network_socket" "fail" "{\"error\":\"socket connect to 8.8.8.8:53 failed\"}"
fi

python3 -c "import socket; socket.getaddrinfo('api.moonshot.cn', 443); print('ok')" 2>/dev/null | grep -q ok
if [ $? -eq 0 ]; then
  emit "dns" "pass" "{}"
else
  emit "dns" "fail" "{\"error\":\"DNS resolution failed for api.moonshot.cn\"}"
fi

# --- Filesystem ---
TESTFILE="/sdcard/stepclaw-test/.probe-rw-test-$$"
echo "probe" > "$TESTFILE" 2>/dev/null && [ "$(cat "$TESTFILE" 2>/dev/null)" = "probe" ] && rm -f "$TESTFILE"
if [ $? -eq 0 ]; then
  emit "sdcard_rw" "pass" "{}"
else
  emit "sdcard_rw" "fail" "{\"error\":\"cannot read/write /sdcard/stepclaw-test/\"}"
fi

WSTESTFILE="$HOME/.openclaw/workspace/.probe-rw-test-$$"
echo "probe" > "$WSTESTFILE" 2>/dev/null && [ "$(cat "$WSTESTFILE" 2>/dev/null)" = "probe" ] && rm -f "$WSTESTFILE"
if [ $? -eq 0 ]; then
  emit "workspace_rw" "pass" "{}"
else
  emit "workspace_rw" "fail" "{\"error\":\"cannot read/write ~/.openclaw/workspace/\"}"
fi

# --- stdout pipe ---
OUT=$(python3 -c 'import json; print(json.dumps({"k":"v"}))' 2>/dev/null)
if [ "$OUT" = '{"k": "v"}' ]; then
  emit "stdout_pipe" "pass" "{}"
else
  emit "stdout_pipe" "fail" "{\"error\":\"stdout pipe data mismatch: got '$OUT'\"}"
fi

# --- Process identity ---
PROCUID=$(awk '/^Uid:/{print $2}' /proc/self/status 2>/dev/null)
PROCGID=$(awk '/^Gid:/{print $2}' /proc/self/status 2>/dev/null)
PROCGROUPS=$(awk '/^Groups:/{$1=""; print}' /proc/self/status 2>/dev/null | xargs)
emit "process_identity" "pass" "{\"uid\":\"$PROCUID\",\"gid\":\"$PROCGID\",\"groups\":\"$PROCGROUPS\"}"

# --- Gateway alive ---
python3 -c "
import socket
s = socket.socket()
s.settimeout(3)
try:
    s.connect(('127.0.0.1', 18789))
    s.close()
    print('ok')
except Exception as e:
    print('fail:' + str(e))
" 2>/dev/null | grep -q ok
if [ $? -eq 0 ]; then
  emit "gateway_alive" "pass" "{}"
else
  emit "gateway_alive" "fail" "{\"error\":\"cannot connect to 127.0.0.1:18789\"}"
fi

# --- Output ---
RESULTS="$RESULTS]"
TOTAL=$((PASS+FAIL))
echo "{\"probe_version\":\"1.0\",\"results\":$RESULTS,\"summary\":{\"total\":$TOTAL,\"pass\":$PASS,\"fail\":$FAIL}}"
