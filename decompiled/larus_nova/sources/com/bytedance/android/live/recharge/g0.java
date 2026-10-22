package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;

/* JADX INFO: loaded from: classes47.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89979a;

    public g0(a0 r100) {
        this.f89979a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ReplaySubject r101 = this.f89979a.I;
        r101.onError((Throwable) r100);
    }
}
