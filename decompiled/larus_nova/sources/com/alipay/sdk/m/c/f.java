package com.alipay.sdk.m.c;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class f implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25251a;

    public f() {
        this.f25251a = false;
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f25251a == true) goto L8;
        com.alipay.sdk.m.h0.a.e(r100);
        this.f25251a = true;
    L8:
        boolean r101 = com.alipay.sdk.m.h0.a.a();
        com.alipay.sdk.m.d.a.b("getOAID", new Object[]{"isSupported", Boolean.valueOf(r101)});
        if (r101 == true) goto L12;
        return null;
    L12:
        return com.alipay.sdk.m.h0.a.b(r100);
    }
}
