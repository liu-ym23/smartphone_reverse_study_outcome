package com.bytedance.android.live.profit.scoreboard;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p1 extends e33.j implements k1, e33.h<cy0.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f88942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f88943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f88944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cy0.f f88945h;

    public final String toString() {
        return "com.bytedance.android.live.profit.scoreboard.__ScopeImpl_ScoreboardScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f88943f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f88942e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f88944g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f88945h;
    }

    public p1(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f88945h = r100;
        Object r101 = e33.k.f470908a;
        this.f88942e = r100.F();
        this.f88943f = r100.A();
        this.f88944g = r100.i();
    }
}
