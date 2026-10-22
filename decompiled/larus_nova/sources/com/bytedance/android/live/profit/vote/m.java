package com.bytedance.android.live.profit.vote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m extends e33.j implements j, e33.h<cy0.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f89216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f89217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f89218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cy0.f f89219h;

    public final String toString() {
        return "com.bytedance.android.live.profit.vote.__ScopeImpl_VoteScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f89217f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f89216e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f89218g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f89219h;
    }

    public m(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f89219h = r100;
        Object r101 = e33.k.f470908a;
        this.f89216e = r100.F();
        this.f89217f = r100.A();
        this.f89218g = r100.i();
    }
}
