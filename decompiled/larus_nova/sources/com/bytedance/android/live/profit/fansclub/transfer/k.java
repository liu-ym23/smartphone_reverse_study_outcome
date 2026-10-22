package com.bytedance.android.live.profit.fansclub.transfer;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f87394a;

    public k(com.bytedance.android.live.revenue.common.g r100) {
        this.f87394a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f87394a.d("error " + ((Throwable) r100));
    }
}
