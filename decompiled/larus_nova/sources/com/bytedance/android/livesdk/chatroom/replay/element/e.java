package com.bytedance.android.livesdk.chatroom.replay.element;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayGestureGuideWidget f108549a;

    public e(ReplayGestureGuideWidget r100) {
        this.f108549a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f108549a.contentView;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getVisibility() != 0) goto L15;
        this.f108549a.contentView.setVisibility(8);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
