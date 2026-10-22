package com.bytedance.android.ecom.live.adapter.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51174a = null;

    static {
        f51174a = new a();
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.core.abtest.d r100 = com.bytedance.android.ec.core.abtest.d.f43639a;     // Catch: Throwable -> L7
        jj4.b r101 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r102 = jj4.a.a("ec_test_setting", String.class, "default", false);     // Catch: Throwable -> L7
        if (r102 != null) goto L5;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L5:
        String r103 = (String) r102;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
