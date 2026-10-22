package com.bytedance.android.live.broadcastgame.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorGameWidget f61825a;

    public a(AnchorGameWidget r100) {
        this.f61825a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        j20.c r102 = this.f61825a.f61796g;
        if (r102 == null) goto L6;
        r102.setPerformancePanelVisible(r101.booleanValue());
        return;
    }
}
