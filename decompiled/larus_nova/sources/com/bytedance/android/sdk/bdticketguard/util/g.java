package com.bytedance.android.sdk.bdticketguard.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SerialAsyncRetryExecutor f164064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f164065b;

    public g(SerialAsyncRetryExecutor r100, com.bytedance.android.sdk.bdticketguard.key.tee.d r101) {
        this.f164064a = r100;
        this.f164065b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SerialAsyncRetryExecutor r100 = this.f164064a;     // Catch: Throwable -> L4
        r100.f164041e.add(new SerialAsyncRetryExecutor.a(this.f164065b, 0, r100.f164039c.get()));     // Catch: Throwable -> L4
        SerialAsyncRetryExecutor.a(this.f164064a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
