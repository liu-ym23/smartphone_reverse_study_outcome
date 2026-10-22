package com.bytedance.android.live.room.navi.tetris;

import android.graphics.Paint;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeRoomNavigatorTetris f99777a;

    public m(LandscapeRoomNavigatorTetris r100) {
        this.f99777a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MarqueeTextView r100 = this.f99777a.f99744s;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        Paint r101 = r100.getPaint();     // Catch: Throwable -> L10
        if (r101 == null) goto L17;
        float r102 = r101.measureText("正正正正正正正正...");     // Catch: Throwable -> L10
        MarqueeTextView r103 = this.f99777a.f99744s;     // Catch: Throwable -> L10
        if (r103 == null) goto L18;
        r103.setMaxWidth((int) r102);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
