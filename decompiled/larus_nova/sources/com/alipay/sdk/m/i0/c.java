package com.alipay.sdk.m.i0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f25344b;

    public c() {
    }

    public void a(boolean r100) {
        this.f25344b = Boolean.valueOf(r100);
    }

    public boolean a() {
        if (this.f25344b == null) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return TextUtils.equals(this.f25343a, r100);
    }

    public void b(String r100) {
        this.f25343a = r100;
    }

    public boolean b() {
        Boolean r100 = this.f25344b;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.booleanValue();
    }
}
