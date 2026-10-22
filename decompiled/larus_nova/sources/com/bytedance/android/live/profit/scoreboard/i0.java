package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class i0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f88895a;

    public i0(j0 r100) {
        this.f88895a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PublishSubject<dv0.h> r101 = this.f88895a.f88900a.f88822c;
        r101.onNext((dv0.h) r100);
    }
}
