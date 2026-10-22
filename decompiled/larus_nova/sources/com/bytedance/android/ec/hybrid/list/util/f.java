package com.bytedance.android.ec.hybrid.list.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f47327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f47328b;

    public f(e r100, i r101) {
        this.f47327a = r100;
        this.f47328b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f47327a.a(this.f47328b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
