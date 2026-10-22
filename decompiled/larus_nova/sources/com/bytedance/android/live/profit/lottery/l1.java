package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class l1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88134a;

    public l1(com.bytedance.android.live.revenue.common.g r100) {
        this.f88134a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f88134a.a("get review result: " + ((v.b) r100));
    }
}
