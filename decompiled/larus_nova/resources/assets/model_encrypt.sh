#!/usr/bin/env bash
set -euo pipefail

HOST="https://os.bytedance.net"
API_PATH="/secret-api/v1/openapi/model/encrypt"

APP_ID="${APP_ID:-obric_assistant_voice}"

#ZTI_TOKEN需要使用boas生成，有效期24H
ZTI_TOKEN="${ZTI_TOKEN:-xxxx}"

#模型文件路径根据需要修改，切勿使用已加密的模型！！
MODEL_FILE_PATH="${MODEL_FILE_PATH:-./xxxx}"
OUT_DIR="${OUT_DIR:-./}"
OUT_FILE="$OUT_DIR/encrypt_result_$(date +%s).zip"

mkdir -p "$OUT_DIR"
if [ ! -f "$MODEL_FILE_PATH" ]; then
  mkdir -p "$(dirname "$MODEL_FILE_PATH")"
  dd if=/dev/urandom of="$MODEL_FILE_PATH" bs=1024 count=1 >/dev/null 2>&1 || true
fi

STATUS=$(curl -s -o "$OUT_FILE" -w "%{http_code}" -X POST "$HOST$API_PATH" \
  -H "x-tt-env: ppe_o_model_enc" \
  -H "x-use-ppe: 1" \
  -F "manufacturer_name_list[]=\"pacific\""\
  -F "manufacturer_name_list[]=\"nerida\""\
  -F "app_id=$APP_ID" \
  -F "model_file=@$MODEL_FILE_PATH" \
  -F "zti_token=$ZTI_TOKEN")

if [ "$STATUS" -ge 200 ] && [ "$STATUS" -lt 300 ]; then
  echo "ok:$OUT_FILE"
else
  rm -f "$OUT_FILE"
  echo "http_error:$STATUS"
  exit 1
fi
