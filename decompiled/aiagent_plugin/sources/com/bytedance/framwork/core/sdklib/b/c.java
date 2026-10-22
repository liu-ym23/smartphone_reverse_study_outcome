package com.bytedance.framwork.core.sdklib.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: JsonUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static JSONObject a(JSONObject r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r2.toString());
    L7:
        return r2;
    }
}
