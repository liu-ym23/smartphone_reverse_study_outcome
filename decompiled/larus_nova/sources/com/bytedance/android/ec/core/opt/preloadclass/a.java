package com.bytedance.android.ec.core.opt.preloadclass;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClassPreloadService f45282a;

    public a(ClassPreloadService r100) {
        this.f45282a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f45282a.f(2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
