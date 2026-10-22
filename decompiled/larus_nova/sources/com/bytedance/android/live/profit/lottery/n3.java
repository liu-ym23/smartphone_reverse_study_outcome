package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n3 extends e33.j implements l2, e33.h<cy0.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f88153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f88154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f88155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f88156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final cy0.f f88157i;

    public final String toString() {
        return "com.bytedance.android.live.profit.lottery.__ScopeImpl_LotteryScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f88155g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f88154f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f88156h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // com.bytedance.android.live.profit.lottery.l2
    public final LotteryContext u() {
        Object r100 = this.f88153e;
        if (r100 == null) goto L7;
        return (LotteryContext) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.lottery.LotteryContext");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f88157i;
    }

    public n3(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f88157i = r100;
        this.f88153e = e33.k.f470908a;
        this.f88154f = r100.F();
        this.f88155g = r100.A();
        this.f88156h = r100.i();
    }
}
