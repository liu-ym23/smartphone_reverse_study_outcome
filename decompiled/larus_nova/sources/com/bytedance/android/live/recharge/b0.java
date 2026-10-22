package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89641a;

    public b0(a0 r100) {
        this.f89641a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f89641a.f89610n.a(r101);
        this.f89641a.F.onNext(r101);
    }
}
