package com.alipay.sdk.m.c;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class c implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25246d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alipay.sdk.m.r0.b f25247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25249c;

    public c() {
        this.f25248b = false;
        this.f25249c = false;
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f25248b == true) goto L12;
        com.alipay.sdk.m.r0.b r101 = new com.alipay.sdk.m.r0.b();
        this.f25247a = r101;
        if (r101.a(r100, null) != 1) goto L10;
        boolean r102 = true;
    L11:
        this.f25249c = r102;
        this.f25248b = true;
        goto L12
    L10:
        r102 = false;
    L12:
        com.alipay.sdk.m.d.a.b("getOAID", new Object[]{"isSupported", Boolean.valueOf(this.f25249c)});
        if (this.f25249c == true) goto L15;
    L18:
        return null;
    L15:
        if (this.f25247a.e() == false) goto L18;
        return this.f25247a.b();
    }
}
