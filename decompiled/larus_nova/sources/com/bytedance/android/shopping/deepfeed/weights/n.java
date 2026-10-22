package com.bytedance.android.shopping.deepfeed.weights;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductInfoExtraView f174239a;

    public n(DeepFeedProductInfoExtraView r100) {
        this.f174239a = r100;
    }

    public final void a() {
        DeepFeedProductInfoMarqueeView r100 = this.f174239a.f174097j;
        int r101 = r100.f174109c;
        if (r101 > 0) goto L6;
        r101 = r100.getHeight();
    L6:
        if (r101 <= 0) goto L13;
        r100.f174109c = r101;
        r100.U5();
        Runnable r102 = r100.f174111e;
        if (r102 == null) goto L11;
        r100.f174112f.removeCallbacks(r102);
    L11:
        r100.f174116j = true;
        p r103 = new p(r100);
        r100.f174111e = r103;
        Handler r104 = r100.f174112f;
        Intrinsics.checkNotNull(r103);
        r104.postDelayed(r103, 3000);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
