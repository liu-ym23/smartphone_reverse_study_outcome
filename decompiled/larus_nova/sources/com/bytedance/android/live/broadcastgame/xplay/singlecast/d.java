package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import com.bytedance.android.live.broadcastgame.api.xplay.f;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.g1;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends j implements b, h<g1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f62457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f62458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final XplayInternalContext f62459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f62460h;

    public final String toString() {
        return "com.bytedance.android.live.broadcastgame.xplay.singlecast.__ScopeImpl_XplaySingleCastScope";
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final f a() {
        f r100 = this.f62458f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.IXplayInstance");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final p h() {
        p r100 = this.f62457e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayNewEnv");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final XplayInternalContext x() {
        XplayInternalContext r100 = this.f62459g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f62460h;
    }

    public d(g1 r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f62460h = r100;
        Object r101 = k.f470908a;
        this.f62457e = r100.h();
        this.f62458f = r100.a();
        this.f62459g = r100.x();
    }
}
