package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class l0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f88920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f88921b;

    public l0(String r100, long r101) {
        this.f88920a = r100;
        this.f88921b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        jy0.b.d("ScoreboardServiceFacade", "subscription disposed: " + this.f88920a + ' ' + this.f88921b);
    }
}
