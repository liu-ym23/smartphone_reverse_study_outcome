package com.bytedance.android.ec.store.search.history;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryChip.WrapCard f48556a;

    public a(HistoryChip.WrapCard r100) {
        this.f48556a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-2, -1);     // Catch: Throwable -> L4
        r100.gravity = 17;     // Catch: Throwable -> L4
        HistoryChip.WrapCard r101 = this.f48556a;     // Catch: Throwable -> L4
        r101.addView(r101.getChip(), r100);     // Catch: Throwable -> L4
        this.f48556a.setRadius(HistoryChip.f48534g);     // Catch: Throwable -> L4
        this.f48556a.setCardElevation(0.0f);     // Catch: Throwable -> L4
        this.f48556a.setCardBackgroundColor(-789516);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
