package com.bytedance.android.sdk.bdticketguard.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SerialAsyncRetryExecutor f164066a;

    public h(SerialAsyncRetryExecutor r100) {
        this.f164066a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SerialAsyncRetryExecutor.a(this.f164066a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
