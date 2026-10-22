package com.bytedance.android.livesdk.gift.grouplive.component;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends e33.j implements f, e33.h<k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f126312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f126313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f126314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f126315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i12.g f126316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f126317j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.grouplive.component.__ScopeImpl_GroupComponentScope";
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.f, com.bytedance.android.livesdk.gift.grouplive.component.k, i12.e
    public Context getContext() {
        Object r100 = this.f126312e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r100 = this.f126313f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r100 = this.f126315h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final i12.g i() {
        i12.g r100 = this.f126316i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r100 = this.f126314g;
        if (r100 == null) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f126317j;
    }

    public m(k r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f126317j = r100;
        Object r101 = e33.k.f470908a;
        this.f126312e = r100.getContext();
        this.f126313f = r100.getDataCenter();
        this.f126314g = Boolean.valueOf(r100.m());
        this.f126315h = r100.getRoomContext();
        this.f126316i = r100.i();
    }
}
