package com.bytedance.framwork.core.sdkmonitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static JSONObject a(JSONObject r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONObject r13 = r10.optJSONObject(r11);
        if (r13 != null) goto L9;
        return null;
    L9:
        return r13.optJSONObject(r12);
    }
}
