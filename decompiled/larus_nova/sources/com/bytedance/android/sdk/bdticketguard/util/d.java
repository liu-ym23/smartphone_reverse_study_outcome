package com.bytedance.android.sdk.bdticketguard.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f164050a;

    public d(e r100) {
        this.f164050a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.f164050a, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
