package com.bytedance.android.ec.hybrid.list.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f47329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f47330b;

    public g(e r100, String r101) {
        this.f47329a = r100;
        this.f47330b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f47329a.b(this.f47330b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
