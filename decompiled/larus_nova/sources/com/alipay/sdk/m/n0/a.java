package com.alipay.sdk.m.n0;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public a() {
    }

    public static String a(Context r100) {
        b r101 = c.b(r100);
        if (r101 != null) goto L5;
    L8:
        return "ffffffffffffffffffffffff";
    L5:
        if (com.alipay.sdk.m.l0.f.m8017a(r101.c()) == true) goto L8;
        return r101.c();
    }

    public static String b(Context r100) {
        String r101 = d.a(r100).a();
        if (r101 != null) goto L5;
    L6:
        return "ffffffffffffffffffffffff";
    L5:
        if (com.alipay.sdk.m.l0.f.m8017a(r101) == true) goto L6;
        return r101;
    }

    public static String c(Context r100) {
        return a(r100);
    }

    public static String d(Context r100) {
        return b(r100);
    }
}
