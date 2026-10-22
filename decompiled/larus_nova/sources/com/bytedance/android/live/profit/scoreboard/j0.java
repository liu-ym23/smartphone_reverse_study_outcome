package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScoreboardExternalServiceFacade f88900a;

    public j0(ScoreboardExternalServiceFacade r100) {
        this.f88900a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        jy0.b.d("ScoreboardServiceFacade", "current round changed: " + ((dv0.h) sh6.c.b(r101)));
        Object r102 = sh6.c.b(r101);
        if (r102 == null) goto L6;
        dv0.h r103 = (dv0.h) r102;
        this.f88900a.f88821b.onNext(r103);
        r103.c().subscribe(new i0(this));
        return;
    }
}
