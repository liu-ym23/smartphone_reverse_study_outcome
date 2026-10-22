package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t1 extends e33.j implements g1, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f62471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f62472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f62473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.scope.j f62474h;

    public final String toString() {
        return "com.bytedance.android.live.broadcastgame.xplay.__ScopeImpl_XplayScope";
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final com.bytedance.android.live.broadcastgame.api.xplay.f a() {
        Object r100 = this.f62472f;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.xplay.f) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.IXplayInstance");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final com.bytedance.android.live.broadcastgame.api.xplay.p h() {
        Object r100 = this.f62471e;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.xplay.p) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayNewEnv");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final XplayInternalContext x() {
        Object r100 = this.f62473g;
        if (r100 == null) goto L7;
        return (XplayInternalContext) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f62474h;
    }

    public t1(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f62474h = r100;
        Object r101 = e33.k.f470908a;
        this.f62471e = r101;
        this.f62472f = r101;
        this.f62473g = r101;
    }
}
