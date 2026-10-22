package com.bytedance.crash.ensure;

import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IEnsure;

/* JADX INFO: compiled from: EnsureApi.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7452a = false;

    static {
    }

    public static void a() {
        if (f7452a == false) goto L5;
        return;
    L5:
        f7452a = true;
        IEnsure r0 = new EnsureApi$1();     // Catch: Throwable -> L8
        d.a(IEnsure.class, r0);     // Catch: Throwable -> L8
        com.bytedance.services.apm.api.a.a(r0);     // Catch: Throwable -> L8
        return;
    }
}
