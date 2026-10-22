package com.bytedance.android.shopping.deepfeed.weights;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductHeaderView f174228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f174229b;

    public g(DeepFeedProductHeaderView r100, boolean r101) {
        this.f174228a = r100;
        this.f174229b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductHeaderView r100 = this.f174228a;     // Catch: Throwable -> L4
        boolean r101 = this.f174229b;     // Catch: Throwable -> L4
        Set<String> r102 = DeepFeedProductHeaderView.H0;     // Catch: Throwable -> L4
        r100.g(0, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
