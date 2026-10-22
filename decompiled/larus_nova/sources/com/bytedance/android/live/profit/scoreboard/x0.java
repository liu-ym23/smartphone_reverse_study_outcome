package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class x0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f89009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dv0.f f89010b;

    public x0(r0 r100, dv0.f r101) {
        this.f89009a = r100;
        this.f89010b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PublishSubject r101 = this.f89009a.f88957c.o();
        dv0.f r102 = this.f89010b;
        r101.onNext(TuplesKt.to(r102, (Boolean) r100));
    }
}
