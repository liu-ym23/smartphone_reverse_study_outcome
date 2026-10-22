package com.bytedance.android.shopping.deepfeed.weights;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductHeaderView f174230a;

    public h(DeepFeedProductHeaderView r100) {
        this.f174230a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductHeaderView r100 = this.f174230a;     // Catch: Throwable -> L4
        r100.g(r100.f174059k, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
