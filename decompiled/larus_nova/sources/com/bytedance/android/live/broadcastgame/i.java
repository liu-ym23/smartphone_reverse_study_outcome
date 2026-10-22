package com.bytedance.android.live.broadcastgame;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f59631a;

    public i(a r100) {
        this.f59631a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a.c(this.f59631a);
    }
}
