package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class t0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RpcMethodImpl f91347a;

    public t0(RpcMethodImpl r100) {
        this.f91347a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f91347a.f91098d = (String) r100;
    }
}
