package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f87856a;

    public j(e r100) {
        this.f87856a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k r101 = this.f87856a.f87848d;
        r101.f87860d = ((Integer) r100).intValue();
        e r102 = this.f87856a;
        e.a(r102, r102.f87848d);
    }
}
