package com.bytedance.android.live.platformplayer.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f85772a;

    public l(o r100) {
        this.f85772a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f85772a.f85780d.e("listenPersonalPanel failed!");
    }
}
