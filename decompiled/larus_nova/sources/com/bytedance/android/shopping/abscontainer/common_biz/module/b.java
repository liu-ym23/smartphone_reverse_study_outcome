package com.bytedance.android.shopping.abscontainer.common_biz.module;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k43.a f164311a;

    public b(k43.a r100) {
        this.f164311a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f164311a.f(0, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
