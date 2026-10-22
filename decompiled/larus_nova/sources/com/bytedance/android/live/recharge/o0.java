package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class o0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f90061a = null;

    static {
        f90061a = new o0();
    }

    public o0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "preload pre pay cashier info error", (Throwable) r100);
    }
}
