package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f89011a;

    public y(v r100) {
        this.f89011a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        jy0.b.d("ScoreboardBannerController", "banner width after layout: " + r101);
        this.f89011a.f88976c.s().a(r101);
    }
}
