package com.bytedance.apm.listener;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IApmLogListener {
    void onLog(String r10, String r11, JSONObject r12);
}
