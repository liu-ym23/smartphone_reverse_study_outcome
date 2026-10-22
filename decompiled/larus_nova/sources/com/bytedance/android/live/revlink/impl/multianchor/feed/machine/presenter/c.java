package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f94252a;

    public c(d r100) {
        this.f94252a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f94252a.onFailed();
    }
}
