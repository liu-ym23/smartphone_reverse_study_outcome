package com.bytedance.android.sdk.bdticketguard.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f164089a;

    public g(f r100) {
        this.f164089a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TGThreadUtils.f164077f.getClass();     // Catch: Throwable -> L4
        Lazy r100 = TGThreadUtils.f164075d;     // Catch: Throwable -> L4
        KProperty r101 = TGThreadUtils.f164072a[0];     // Catch: Throwable -> L4
        ((ThreadPoolExecutor) r100.getValue()).execute(this.f164089a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
