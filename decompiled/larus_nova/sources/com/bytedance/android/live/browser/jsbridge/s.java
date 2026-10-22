package com.bytedance.android.live.browser.jsbridge;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class s {
    public static JSONObject a(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("status_code", r100);     // Catch: JSONException -> L5
        r102.put("message", r101);     // Catch: JSONException -> L5
    L4:
        return r102;
    }
}
