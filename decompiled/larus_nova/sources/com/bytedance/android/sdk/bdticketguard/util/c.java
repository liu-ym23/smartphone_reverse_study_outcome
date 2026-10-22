package com.bytedance.android.sdk.bdticketguard.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f164048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f164049b;

    public c(e r100, int r101) {
        this.f164048a = r100;
        this.f164049b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.f164048a, this.f164049b + 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
