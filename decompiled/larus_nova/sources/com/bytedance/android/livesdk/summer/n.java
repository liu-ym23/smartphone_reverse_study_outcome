package com.bytedance.android.livesdk.summer;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummerService.a f158483a;

    @Override // java.lang.Runnable
    public final void run() {
        SummerService.access$400(this.f158483a.f158435a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(SummerService.a r100) {
        this.f158483a = r100;
    }
}
