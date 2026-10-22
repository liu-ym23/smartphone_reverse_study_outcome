package com.bytedance.android.shopping.buynow.controller;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f170870a;

    public u(w r100) {
        this.f170870a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w r100 = this.f170870a;     // Catch: Throwable -> L4
        r100.f170872a = true;     // Catch: Throwable -> L4
        w.a(r100, true);     // Catch: Throwable -> L4
        this.f170870a.f170877f.setPadding(0, 0, 0, 40);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
