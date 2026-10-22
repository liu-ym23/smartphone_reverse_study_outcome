package com.bytedance.android.live.revlink.impl.multianchor.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f94813a;

    public o(p r100) {
        this.f94813a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        p r101 = this.f94813a;
        r101.f94816c = false;
        p.a(r101, (Throwable) r100);
    }
}
