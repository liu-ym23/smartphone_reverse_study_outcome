package com.bytedance.android.live.platformplayer.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f85767a;

    public h(o r100) {
        this.f85767a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        o r101 = this.f85767a;
        o.a(r101, (ds0.b) r100);
    }
}
