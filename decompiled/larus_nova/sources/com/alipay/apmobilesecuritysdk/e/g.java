package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes28.dex */
public final class g {
    public static synchronized String a(Context r100, String r101) {
        monitor-enter(g.class);
        String r102 = com.alipay.sdk.m.b0.e.a(r100, "openapi_file_pri", "openApi" + r101, "");     // Catch: Throwable -> L16
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L7;
        String r103 = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), r102);     // Catch: Throwable -> L16
        if (com.alipay.sdk.m.z.a.a(r103) == true) goto L12;
        monitor-exit(g.class);
        return r103;
    L12:
        monitor-exit(g.class);
        return "";
    L7:
        monitor-exit(g.class);
        return "";
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void a() {
        monitor-enter(g.class);
        monitor-exit(g.class);
    }

    public static synchronized void a(Context r100) {
        monitor-enter(g.class);
        SharedPreferences.Editor r101 = r100.getSharedPreferences("openapi_file_pri", 0).edit();     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.clear();     // Catch: Throwable -> L9
        r101.commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(g.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Context r100, String r101, String r102) {
        monitor-enter(g.class);
        SharedPreferences.Editor r103 = r100.getSharedPreferences("openapi_file_pri", 0).edit();     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.putString("openApi" + r101, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), r102));     // Catch: Throwable -> L9
        r103.commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(g.class);
        return;
    }
}
