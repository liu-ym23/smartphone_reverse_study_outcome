package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportSubmitControl f59912a;

    public c(ReportSubmitControl r100) {
        this.f59912a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r102 = this.f59912a.f59902b;
        if (r102 == null) goto L6;
        r102.B0();
        return;
    }
}
