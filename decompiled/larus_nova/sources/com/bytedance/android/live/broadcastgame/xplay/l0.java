package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class l0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f62199a;

    public l0(m0 r100) {
        this.f62199a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        this.f62199a.f62275a.f61943j.a(e.a.b.f62065a);
    }
}
