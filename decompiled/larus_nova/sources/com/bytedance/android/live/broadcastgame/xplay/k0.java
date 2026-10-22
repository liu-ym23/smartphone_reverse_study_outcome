package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f62198a;

    public k0(m0 r100) {
        this.f62198a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        XplayMainService r102 = this.f62198a.f62275a;
        e r103 = r102.f61943j;
        Throwable r104 = r102.f61938e;
        if (r104 != null) goto L5;
        r104 = new RuntimeException("unknown reason");
    L5:
        r103.a(new e.a.C1027a(r104));
    }
}
