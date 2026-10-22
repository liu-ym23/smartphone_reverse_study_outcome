package com.bytedance.android.live.broadcastgame.opengame.test;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f61141a;

    public e(d r100) {
        this.f61141a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f61141a.c();
    }
}
