package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p.a f91322a;

    public o(p.a r100) {
        this.f91322a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ObservableEmitter r101 = this.f91322a.f91332b;
        r101.onError((Throwable) r100);
    }
}
