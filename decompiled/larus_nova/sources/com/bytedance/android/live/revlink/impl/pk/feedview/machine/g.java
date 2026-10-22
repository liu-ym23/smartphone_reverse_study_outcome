package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f96570a;

    public g(a r100) {
        this.f96570a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f96570a.onFailed();
    }
}
