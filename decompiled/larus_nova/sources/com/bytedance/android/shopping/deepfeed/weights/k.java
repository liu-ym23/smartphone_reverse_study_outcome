package com.bytedance.android.shopping.deepfeed.weights;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductHeaderView f174234a;

    public k(DeepFeedProductHeaderView r100) {
        this.f174234a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f174234a.i();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
