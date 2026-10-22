package com.bytedance.android.shopping.ligo.strategy.decision.scheduler;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f176490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f176491b;

    public g(f r100, Function0 r101) {
        this.f176490a = r100;
        this.f176491b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f176490a, this.f176491b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
