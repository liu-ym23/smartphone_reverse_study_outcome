package com.bytedance.android.shopping.feed.view;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InnerFeedPageHeadWidget f175646a;

    public m(InnerFeedPageHeadWidget r100) {
        this.f175646a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f175646a.f175585t;     // Catch: Throwable -> L12
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L12
    L6:
        if (r101 == null) goto L8;
        r101.height = com.bytedance.android.shopping.extensions.b.b(100);     // Catch: Throwable -> L12
    L8:
        View r102 = this.f175646a.f175585t;     // Catch: Throwable -> L12
        if (r102 == null) goto L15;
        r102.setLayoutParams(r101);     // Catch: Throwable -> L12
        return;
    L15:
        return;
    L5:
        r101 = null;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
