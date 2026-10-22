package com.bytedance.android.gamecp.live_impl.animation;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f57803a;

    public d(b r100) {
        this.f57803a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f57803a.d();
    }
}
