package com.bytedance.android.ec.core.anchorv3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f43823a;

    public s(com.bytedance.android.shopping.anchorv4.containers.page.e r100) {
        this.f43823a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43823a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
