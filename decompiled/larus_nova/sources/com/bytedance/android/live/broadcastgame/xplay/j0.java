package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class j0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f62188a;

    public j0(m0 r100) {
        this.f62188a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f62188a.f62275a.f61943j.a(new e.a.c(((Float) r100).floatValue()));
    }
}
