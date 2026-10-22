package com.bytedance.android.live.recharge.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f90352a = null;

    static {
        f90352a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.b("RechargeEventHandlerService", "on subscribe error", (Throwable) r100);
    }
}
