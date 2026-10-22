package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScoreboardExternalServiceFacade f88918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f88919b;

    public k0(ScoreboardExternalServiceFacade r100, long r101) {
        this.f88918a = r100;
        this.f88919b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        j.a r101 = (j.a) r100;
        jy0.b.d("ScoreboardServiceFacade", "banner state changed: " + r101);
        this.f88918a.f88823d.onNext(TuplesKt.to(Long.valueOf(this.f88919b), r101));
    }
}
