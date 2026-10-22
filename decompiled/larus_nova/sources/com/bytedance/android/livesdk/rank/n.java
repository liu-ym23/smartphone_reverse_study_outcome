package com.bytedance.android.livesdk.rank;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n extends e33.j implements c, e33.h<cy0.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f156987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f156988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f156989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cy0.f f156990h;

    public final String toString() {
        return "com.bytedance.android.livesdk.rank.__ScopeImpl_RankScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f156988f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f156987e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f156989g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f156990h;
    }

    public n(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f156990h = r100;
        Object r101 = e33.k.f470908a;
        this.f156987e = r100.F();
        this.f156988f = r100.A();
        this.f156989g = r100.i();
    }
}
