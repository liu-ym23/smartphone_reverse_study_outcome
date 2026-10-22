package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uc3.f f173868a;

    public v(uc3.f r100) {
        this.f173868a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uc3.f r100 = this.f173868a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.f(System.currentTimeMillis());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
