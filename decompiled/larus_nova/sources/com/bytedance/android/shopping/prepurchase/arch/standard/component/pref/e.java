package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskScheduler f181010a;

    public e(TaskScheduler r100) {
        this.f181010a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskScheduler.a(this.f181010a, 4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
