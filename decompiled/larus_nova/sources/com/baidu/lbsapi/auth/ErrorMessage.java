package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
class ErrorMessage {
    public ErrorMessage() {
    }

    public static String a(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("status", r100);     // Catch: JSONException -> L6
        r102.put("message", r101);     // Catch: JSONException -> L6
    L5:
        return r102.toString();
    }

    public static String a(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status", -1);     // Catch: JSONException -> L6
        r101.put("message", r100);     // Catch: JSONException -> L6
    L5:
        return r101.toString();
    }
}
