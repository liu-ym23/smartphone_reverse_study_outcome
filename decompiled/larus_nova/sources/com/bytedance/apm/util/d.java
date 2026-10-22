package com.bytedance.apm.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f190644a;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.apm.k.b.f190610a.a(this.f190644a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(Throwable r100) {
        this.f190644a = r100;
    }
}
