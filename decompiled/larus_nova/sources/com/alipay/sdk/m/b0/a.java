package com.alipay.sdk.m.b0;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public a() {
    }

    public static String a(Context r100, String r101, String r102) {
        monitor-enter(a.class);
        String r103 = null;
        if (r100 != null) goto L27;
    L20:
        monitor-exit(a.class);     // Catch: Throwable -> L18
        return null;
    L27:
    L18:
        th = move-exception;
        throw th;
    L7:
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L20;
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L20;
        String r104 = e.a(r100, r101, r102, "");     // Catch: Throwable -> L24
        if (com.alipay.sdk.m.z.a.a(r104) == false) goto L15;
        monitor-exit(a.class);     // Catch: Throwable -> L18
        return null;
    L15:
        r103 = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), r104);     // Catch: Throwable -> L24
    L16:
        monitor-exit(a.class);     // Catch: Throwable -> L18
        return r103;
    }

    public static void a(Context r100, String r101, String r102, String r103) {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L7;
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return;
    L7:
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L13;
        if (r100 == null) goto L13;
        String r104 = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), r103);     // Catch: Throwable -> L18
        HashMap r105 = new HashMap();     // Catch: Throwable -> L18
        r105.put(r102, r104);     // Catch: Throwable -> L18
        e.a(r100, r101, r105);     // Catch: Throwable -> L18
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L15
    }
}
