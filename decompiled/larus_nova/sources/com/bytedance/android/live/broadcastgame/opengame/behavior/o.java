package com.bytedance.android.live.broadcastgame.opengame.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f59780a;

    public o(g r100) {
        this.f59780a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        g.r(this.f59780a);
    }
}
