package com.bytedance.android.live.profit.redpacket;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n1 extends e33.j implements w0, e33.h<cy0.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f88685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f88686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f88687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f88688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f88689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final cy0.f f88690j;

    public final String toString() {
        return "com.bytedance.android.live.profit.redpacket.__ScopeImpl_RedPacketScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f88688h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f88687g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // com.bytedance.android.live.profit.redpacket.w0
    public Context getContext() {
        Object r100 = this.f88685e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f88689i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // com.bytedance.android.live.profit.redpacket.w0
    public final l p() {
        Object r100 = this.f88686f;
        if (r100 == null) goto L7;
        return (l) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.redpacket.RedPacketContext");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f88690j;
    }

    public n1(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f88690j = r100;
        Object r101 = e33.k.f470908a;
        this.f88685e = r101;
        this.f88686f = r101;
        this.f88687g = r100.F();
        this.f88688h = r100.A();
        this.f88689i = r100.i();
    }
}
