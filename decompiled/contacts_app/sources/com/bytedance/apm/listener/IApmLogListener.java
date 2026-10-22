package com.bytedance.apm.listener;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IApmLogListener {
    void onLog(String r1, String r2, JSONObject r3);
}
