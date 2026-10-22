package com.bytedance.android.shopping.anchorv4.log;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VisibleLogManager f167064a;

    public f(VisibleLogManager r100) {
        this.f167064a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VisibleLogManager.a(this.f167064a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
