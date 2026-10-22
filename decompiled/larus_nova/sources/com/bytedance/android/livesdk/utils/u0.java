package com.bytedance.android.livesdk.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class u0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f159174a;

    public u0(v0 r100) {
        this.f159174a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f159174a.f159186a = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
