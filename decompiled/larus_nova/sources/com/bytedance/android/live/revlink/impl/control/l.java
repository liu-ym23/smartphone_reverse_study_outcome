package com.bytedance.android.live.revlink.impl.control;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f92420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f92421b;

    public l(e r100, long r101) {
        this.f92420a = r100;
        this.f92421b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f92420a.a(this.f92421b);
    }
}
