package com.bytedance.android.livesdk.summer;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummerService.a f158482a;

    @Override // java.lang.Runnable
    public final void run() {
        SummerService.access$200(this.f158482a.f158435a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(SummerService.a r100) {
        this.f158482a = r100;
    }
}
