package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.graphics.Paint;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleTetris f64680a;

    public h(TitleTetris r100) {
        this.f64680a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.common.j r100 = this.f64680a.A;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        Paint r101 = r100.getPaint();     // Catch: Throwable -> L10
        if (r101 == null) goto L17;
        float r102 = r101.measureText("正正正正正正正正正正正正正正正...");     // Catch: Throwable -> L10
        com.bytedance.android.livesdk.common.j r103 = this.f64680a.A;     // Catch: Throwable -> L10
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
