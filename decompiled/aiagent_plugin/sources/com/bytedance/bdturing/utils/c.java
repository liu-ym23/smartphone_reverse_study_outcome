package com.bytedance.bdturing.utils;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(JSONObject r0, String r1, Object r2) {
        if (r0 == null) goto L10;
        r0.put(r1, r2);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
