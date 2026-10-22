package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedPkBridgePresenter f96453a;

    public b(FeedPkBridgePresenter r100) {
        this.f96453a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f96453a.c("timeUp");
    }
}
