package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.widget.FrameLayout;
import cf.l;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f149828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExplainPlaybackCardPresenter f149829b;

    public c(l r100, ExplainPlaybackCardPresenter r101) {
        this.f149828a = r100;
        this.f149829b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExplainPlaybackCardPresenter r100 = this.f149829b;     // Catch: Throwable -> L6
        FrameLayout r101 = r100.f149811g;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r100.f149814j = (r101.getWidth() - r101.getPaddingLeft()) - r101.getPaddingRight();     // Catch: Throwable -> L6
        ExplainPlaybackCardPresenter r102 = this.f149829b;     // Catch: Throwable -> L6
        r102.f149815k = (r101.getHeight() - r101.getPaddingTop()) - r101.getPaddingBottom();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
