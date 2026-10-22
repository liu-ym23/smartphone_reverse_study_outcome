package com.alipay.sdk.m.p;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25650b;

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", new Object[]{this.f25649a, this.f25650b});
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f25650b) == false) goto L10;
        return null;
    L10:
        return new JSONObject(this.f25650b);
    L7:
        e = move-exception;
        com.alipay.sdk.m.u.e.a(e);
        return null;
    }

    public String a() {
        return this.f25650b;
    }

    public String b() {
        return this.f25649a;
    }

    public b(String r100, String r101) {
        this.f25649a = r100;
        this.f25650b = r101;
    }
}
