package com.alipay.sdk.m.c;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class h implements com.alipay.sdk.m.b.b {
    public h() {
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        boolean r101 = com.alipay.sdk.m.p0.e.c(r100);
        com.alipay.sdk.m.d.a.b("getOAID", new Object[]{"isSupported", Boolean.valueOf(r101)});
        if (r101 == true) goto L9;
        return null;
    L9:
        return com.alipay.sdk.m.p0.e.a(r100);
    }
}
