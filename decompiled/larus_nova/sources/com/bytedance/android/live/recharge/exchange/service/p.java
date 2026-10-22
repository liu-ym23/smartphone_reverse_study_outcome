package com.bytedance.android.live.recharge.exchange.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SaaSWalletInfoService f89965a;

    public p(SaaSWalletInfoService r100) {
        this.f89965a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f89965a.f89898c = (com.bytedance.android.live.recharge.exchange.model.h) r100;
    }
}
