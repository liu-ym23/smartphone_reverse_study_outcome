package com.bytedance.b.a;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatchTracingLogWrapUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static JSONArray a(JSONObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        JSONArray r3 = r2.optJSONArray("wrapper_array_data");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3;
    }
}
