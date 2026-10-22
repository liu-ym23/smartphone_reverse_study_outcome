package com.bytedance.android.live.livepullstream.service;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f82519a = null;

    static {
        f82519a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = h.f82520a;     // Catch: Throwable -> L4
        h.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
