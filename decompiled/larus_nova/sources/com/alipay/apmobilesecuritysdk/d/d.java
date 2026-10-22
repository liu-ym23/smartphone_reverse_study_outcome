package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        monitor-enter(d.class);
        HashMap r100 = new HashMap();     // Catch: Throwable -> L8
        new com.alipay.apmobilesecuritysdk.c.b();     // Catch: Throwable -> L11
        r100.put("AE16", "");     // Catch: Throwable -> L11
    L6:
        monitor-exit(d.class);
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> a(Context r100) {
        monitor-enter(d.class);
        com.alipay.sdk.m.a0.e.a();     // Catch: Throwable -> L15
        com.alipay.sdk.m.a0.b.a(APSecuritySdk.getInstance(r100));     // Catch: Throwable -> L15
        HashMap r101 = new HashMap();     // Catch: Throwable -> L15
        r101.put("AE1", com.alipay.sdk.m.a0.e.b());     // Catch: Throwable -> L15
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L15
        if (com.alipay.sdk.m.a0.e.c() == false) goto L7;
        String r103 = "1";
    L8:
        r102.append(r103);     // Catch: Throwable -> L15
        r101.put("AE2", r102.toString());     // Catch: Throwable -> L15
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L15
        if (com.alipay.sdk.m.a0.e.d() == false) goto L11;
        String r105 = "1";
    L12:
        r104.append(r105);     // Catch: Throwable -> L15
        r101.put("AE3", r104.toString());     // Catch: Throwable -> L15
        r101.put("AE4", com.alipay.sdk.m.a0.e.e());     // Catch: Throwable -> L15
        r101.put("AE5", com.alipay.sdk.m.a0.e.f());     // Catch: Throwable -> L15
        r101.put("AE6", com.alipay.sdk.m.a0.e.g());     // Catch: Throwable -> L15
        r101.put("AE7", com.alipay.sdk.m.a0.e.h());     // Catch: Throwable -> L15
        r101.put("AE8", com.alipay.sdk.m.a0.e.i());     // Catch: Throwable -> L15
        r101.put("AE9", com.alipay.sdk.m.a0.e.j());     // Catch: Throwable -> L15
        r101.put("AE10", com.alipay.sdk.m.a0.e.k());     // Catch: Throwable -> L15
        r101.put("AE11", com.alipay.sdk.m.a0.e.l());     // Catch: Throwable -> L15
        r101.put("AE12", com.alipay.sdk.m.a0.e.m());     // Catch: Throwable -> L15
        r101.put("AE13", com.alipay.sdk.m.a0.e.n());     // Catch: Throwable -> L15
        r101.put("AE14", com.alipay.sdk.m.a0.e.o());     // Catch: Throwable -> L15
        r101.put("AE15", com.alipay.sdk.m.a0.e.p());     // Catch: Throwable -> L15
        r101.put("AE21", com.alipay.sdk.m.a0.b.f());     // Catch: Throwable -> L15
        monitor-exit(d.class);
        return r101;
    L11:
        r105 = "0";
        goto L12
    L7:
        r103 = "0";
    L15:
        th = move-exception;
        throw th;
    }
}
