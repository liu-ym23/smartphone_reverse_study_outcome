package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89776a;

    public e0(a0 r100) {
        this.f89776a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f89776a.H.onNext(new com.bytedance.android.live.recharge.platform.model.f(0));
        this.f89776a.P.a(new com.bytedance.android.live.recharge.platform.model.f(0));
    }
}
