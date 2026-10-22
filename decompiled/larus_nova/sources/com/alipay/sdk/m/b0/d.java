package com.alipay.sdk.m.b0;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public final class d {
    public static synchronized void a(Context r100, String r101, String r102, String r103) {
        monitor-enter(d.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L15;
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L15;
        if (r100 == null) goto L15;
        String r104 = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), r103);     // Catch: Throwable -> L13
        HashMap r105 = new HashMap();     // Catch: Throwable -> L13
        r105.put(r102, r104);     // Catch: Throwable -> L13
        e.a(r100, r101, r105);     // Catch: Throwable -> L13
        monitor-exit(d.class);
        return;
    L14:
        return;
    L15:
        monitor-exit(d.class);
    }
}
