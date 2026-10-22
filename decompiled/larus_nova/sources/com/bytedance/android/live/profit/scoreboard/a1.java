package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class a1 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f88867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dv0.f f88868b;

    public a1(r0 r100, dv0.f r101) {
        this.f88867a = r100;
        this.f88868b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Action
    public final void run() {
        if (((dv0.f) sh6.c.b((sh6.b) this.f88867a.f88957c.k().f64752a)) != this.f88868b) goto L6;
        this.f88867a.f88957c.k().a(sh6.a.f541970a);
        return;
    }
}
