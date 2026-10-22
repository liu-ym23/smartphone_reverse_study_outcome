package com.baidu.mapauto.auth.base;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f31786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f31787b;

    public b(String r100) {
        this.f31786a = r100;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L5
    L6:
        this.f31787b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
