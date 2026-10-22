package com.bytedance.android.shopping.feed.widget.gesture;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f176024a;

    public a(b r100) {
        this.f176024a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (b.a(this.f176024a) != null) goto L5;
        return;
    L5:
        if (b.a(this.f176024a).isAnimating() == false) goto L15;
        b.a(this.f176024a).cancelAnimation();     // Catch: Throwable -> L8
        return;
    }
}
