package com.bytedance.framwork.core.sdkmonitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class CommonLogData {
    JSONObject logData;
    String logType;
    long timestamp;

    public CommonLogData(String r1, JSONObject r2, long r3) {
        this.logType = r1;
        this.logData = r2;
        this.timestamp = r3;
    }
}
