package com.bytedance.android.live.liveinteract.plantform.performance;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f77310a;

    public b(a r100) {
        this.f77310a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Disposable r100 = this.f77310a.f77305b;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.dispose();     // Catch: Throwable -> L7
    L5:
        this.f77310a.f77305b = null;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
