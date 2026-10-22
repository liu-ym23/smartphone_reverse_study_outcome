package com.bytedance.android.livesdk.livecommerce.playback.card;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainPlaybackCardPresenter f149837a;

    public h(ExplainPlaybackCardPresenter r100) {
        this.f149837a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExplainPlaybackCardPresenter r100 = this.f149837a;     // Catch: Throwable -> L6
        if (r100.f149824t == true) goto L9;
        ExplainPlaybackCardPresenter.d0(r100, false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
