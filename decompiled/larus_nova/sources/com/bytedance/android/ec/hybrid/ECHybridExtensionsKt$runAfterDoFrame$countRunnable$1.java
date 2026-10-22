package com.bytedance.android.ec.hybrid;

import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridExtensionsKt$runAfterDoFrame$countRunnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f46244b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.f46243a != 1) goto L5;
        this.f46244b.invoke();     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        CommonUtilKt.g(new ECHybridExtensionsKt$runAfterDoFrame$countRunnable$1$run$1(this));     // Catch: Throwable -> L7
        goto L12
    }

    public ECHybridExtensionsKt$runAfterDoFrame$countRunnable$1(Function0 r100, int r101) {
        this.f46244b = r100;
        this.f46243a = r101;
    }
}
