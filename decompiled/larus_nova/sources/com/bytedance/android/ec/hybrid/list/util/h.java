package com.bytedance.android.ec.hybrid.list.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f47331a;

    public h(e r100) {
        this.f47331a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f47331a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
