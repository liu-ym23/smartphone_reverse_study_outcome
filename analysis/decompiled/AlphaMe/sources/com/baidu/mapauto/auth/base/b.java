package com.baidu.mapauto.auth.base;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f7666a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f7667b;

    public b(String str) {
        JSONObject jSONObject;
        this.f7666a = str;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        this.f7667b = jSONObject;
    }
}
