package com.bytedance.android.live.profit.lottery;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f88125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88126b;

    public k1(Disposable r100, com.bytedance.android.live.revenue.common.g r101) {
        this.f88125a = r100;
        this.f88126b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k3 r101 = (k3) r100;
        this.f88125a.dispose();
        this.f88126b.a("stopped due to state change");
    }
}
