package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89685a;

    public d0(a0 r100) {
        this.f89685a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.recharge.platform.model.f r101 = (com.bytedance.android.live.recharge.platform.model.f) r100;
        this.f89685a.P.a(r101);
        this.f89685a.H.onNext(r101);
    }
}
