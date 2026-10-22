package com.bytedance.android.shopping.store.hybridproduct.holder;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.store.home.c0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f185084a = null;

    static {
        f185084a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s0.a(new c0());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
