package com.alipay.sdk.m.h0;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public static boolean a() {
        if (com.alipay.sdk.m.a.a.b.f25212a == false) goto L7;
        return com.alipay.sdk.m.a.a.b.f25213b;
    L7:
        throw new RuntimeException("SDK Need Init First!");
    }

    public a() {
    }

    public static String a(Context r100) {
        if (com.alipay.sdk.m.a.a.b.f25212a == false) goto L7;
        return com.alipay.sdk.m.a.a.c.b.f25220a.a(r100.getApplicationContext(), "AUID");
    L7:
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context r100) {
        if (com.alipay.sdk.m.a.a.b.f25212a == false) goto L7;
        return com.alipay.sdk.m.a.a.c.b.f25220a.a(r100.getApplicationContext(), "OUID");
    L7:
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context r100) {
        if (com.alipay.sdk.m.a.a.b.f25212a == false) goto L7;
        return com.alipay.sdk.m.a.a.c.b.f25220a.a(r100.getApplicationContext(), "GUID");
    L7:
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context r100) {
        if (com.alipay.sdk.m.a.a.b.f25212a == false) goto L7;
        return com.alipay.sdk.m.a.a.c.b.f25220a.a(r100.getApplicationContext(), "DUID");
    L7:
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void e(Context r100) {
        com.alipay.sdk.m.a.a.b.f25213b = com.alipay.sdk.m.a.a.c.b.f25220a.a(r100.getApplicationContext());
        com.alipay.sdk.m.a.a.b.f25212a = true;
    }
}
