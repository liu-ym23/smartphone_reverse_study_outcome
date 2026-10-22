package com.bytedance.android.livesdk.widget;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class s2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSGestureGuideWidget.c f162041a;

    public s2(VSGestureGuideWidget.c r100) {
        this.f162041a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f162041a.f161377a.contentView;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getVisibility() != 0) goto L15;
        this.f162041a.f161377a.contentView.setVisibility(8);     // Catch: Throwable -> L8
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = com.bytedance.android.livesdk.sharedpref.b.Q;     // Catch: Throwable -> L8
        Boolean r102 = Boolean.FALSE;     // Catch: Throwable -> L8
        r101.getClass();     // Catch: Throwable -> L8
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
