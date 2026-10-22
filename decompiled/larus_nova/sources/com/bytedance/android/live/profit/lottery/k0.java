package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88124a;

    public k0(com.bytedance.android.live.revenue.common.g r100) {
        this.f88124a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f88124a.b(((v.b) r100).toString());
    }
}
