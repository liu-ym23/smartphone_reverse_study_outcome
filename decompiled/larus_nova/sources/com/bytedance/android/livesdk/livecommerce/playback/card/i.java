package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainPlaybackCardPresenter f149838a;

    public i(ExplainPlaybackCardPresenter r100) {
        this.f149838a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExplainPlaybackCardPresenter r100 = this.f149838a;     // Catch: Throwable -> L6
        FrameLayout r101 = r100.f149812h;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r100.f149816l = (r101.getWidth() - r101.getPaddingLeft()) - r101.getPaddingRight();     // Catch: Throwable -> L6
        ExplainPlaybackCardPresenter r102 = this.f149838a;     // Catch: Throwable -> L6
        r102.f149817m = (r101.getHeight() - r101.getPaddingTop()) - r101.getPaddingBottom();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
