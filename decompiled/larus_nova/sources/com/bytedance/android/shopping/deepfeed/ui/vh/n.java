package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductSlcVH f173854a;

    public n(DeepFeedProductSlcVH r100) {
        this.f173854a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductSlcVH r100 = this.f173854a;     // Catch: Throwable -> L4
        int r101 = DeepFeedProductSlcVH.f173813k0;     // Catch: Throwable -> L4
        r100.H4();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
