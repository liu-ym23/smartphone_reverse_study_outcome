package com.bytedance.android.ec.window.base.shop;

import com.bytedance.android.ec.core.utils.s0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f49646a = null;

    static {
        f49646a = new h();
    }

    public h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s0.a(new k());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
