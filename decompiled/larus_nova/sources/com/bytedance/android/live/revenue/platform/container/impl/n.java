package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p.a f91320a;

    public n(p.a r100) {
        this.f91320a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f91320a.f91332b.onNext(r100);
    }
}
