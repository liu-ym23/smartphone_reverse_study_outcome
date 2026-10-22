package com.bytedance.android.shopping.deepfeed.event;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f173346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f173347b;

    public b(a r100, long r101) {
        this.f173346a = r100;
        this.f173347b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f173346a;     // Catch: Throwable -> L12
        r100.f173306k = null;     // Catch: Throwable -> L12
        a.d r101 = r100.f173298c;     // Catch: Throwable -> L12
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f173323a == this.f173347b) goto L7;
        return;
    L7:
        if (r101.f173335m == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r101.f173336n, "switch_image") == false) goto L21;
        this.f173346a.e(r101, "switch_image");     // Catch: Throwable -> L12
        return;
    L21:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
