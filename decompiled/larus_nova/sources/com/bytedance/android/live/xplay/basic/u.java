package com.bytedance.android.live.xplay.basic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u extends e33.j implements l, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f102871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f102872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.scope.j f102873g;

    public final String toString() {
        return "com.bytedance.android.live.xplay.basic.__ScopeImpl_XplayScope";
    }

    @Override // com.bytedance.android.live.xplay.basic.l
    public final com.bytedance.android.live.broadcastgame.api.xplay.f a() {
        Object r100 = this.f102872f;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.xplay.f) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.IXplayInstance");
    }

    @Override // com.bytedance.android.live.xplay.basic.l
    public final com.bytedance.android.live.broadcastgame.api.xplay.basic.c h() {
        Object r100 = this.f102871e;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.xplay.basic.c) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.basic.XplayBasicEnv");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f102873g;
    }

    public u(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f102873g = r100;
        Object r101 = e33.k.f470908a;
        this.f102871e = r101;
        this.f102872f = r101;
    }
}
