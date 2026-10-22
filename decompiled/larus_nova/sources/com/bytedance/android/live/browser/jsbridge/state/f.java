package com.bytedance.android.live.browser.jsbridge.state;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StateObserver.a f63956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63957b;

    public f(StateObserver.a r100, String r101) {
        this.f63956a = r100;
        this.f63957b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f63956a.f63899b.decrementAndGet();     // Catch: Throwable -> L6
        AtomicInteger r100 = this.f63956a.f63898a.get(this.f63957b);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.decrementAndGet();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
