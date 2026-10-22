package com.bytedanceos.appstore.buss.utilities;

import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static final com.bytedanceos.appstore.buss.network.ad.d.a a(Throwable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = com.bytedanceos.common.utils.k.b(r10);
        String r12 = BaseApplication.c().getString(com.bytedanceos.common.toolbox.l.f10067a.get(r11));     // Catch: Exception -> L5
        kotlin.jvm.internal.q.f(r12, "getString(...)");     // Catch: Exception -> L5
    L7:
        j.f8856a.d(r10);
        return new com.bytedanceos.appstore.buss.network.ad.d.a(r12, r11);
    L5:
        e = move-exception;
        j.f8856a.d(e);
        r12 = "get errorMsg exception !!!";
        goto L7
    }

    public static final com.bytedanceos.appstore.buss.network.g.a b(Throwable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = com.bytedanceos.common.utils.k.b(r10);
        String r12 = BaseApplication.c().getString(com.bytedanceos.common.toolbox.l.f10067a.get(r11));     // Catch: Exception -> L5
        kotlin.jvm.internal.q.f(r12, "getString(...)");     // Catch: Exception -> L5
    L7:
        j.f8856a.d(r10);
        return new com.bytedanceos.appstore.buss.network.g.a(r11, r12);
    L5:
        e = move-exception;
        j.f8856a.d(e);
        r12 = "get errorMsg exception !!!";
        goto L7
    }

    public static final com.bytedanceos.appstore.buss.network.h.a c(Throwable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = com.bytedanceos.common.utils.k.b(r10);
        String r12 = BaseApplication.c().getString(com.bytedanceos.common.toolbox.l.f10067a.get(r11));     // Catch: Exception -> L5
        kotlin.jvm.internal.q.f(r12, "getString(...)");     // Catch: Exception -> L5
    L7:
        j.f8856a.d(r10);
        return new com.bytedanceos.appstore.buss.network.h.a(r12, r11, r10);
    L5:
        e = move-exception;
        j.f8856a.d(e);
        r12 = "get errorMsg exception !!!";
        goto L7
    }
}
