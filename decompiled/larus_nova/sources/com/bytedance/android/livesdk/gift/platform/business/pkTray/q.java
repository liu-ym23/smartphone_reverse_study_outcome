package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends e33.j implements h, e33.h<i12.e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f130070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f130071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f130072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f130073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i12.g f130074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i12.e f130075j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.business.pkTray.__ScopeImpl_CrossRoomTrayScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.pkTray.h, i12.e
    public Context getContext() {
        Object r100 = this.f130070e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r100 = this.f130071f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r100 = this.f130073h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final i12.g i() {
        i12.g r100 = this.f130074i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r100 = this.f130072g;
        if (r100 == null) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f130075j;
    }

    public q(i12.e r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f130075j = r100;
        Object r101 = e33.k.f470908a;
        this.f130070e = r100.getContext();
        this.f130071f = r100.getDataCenter();
        this.f130072g = Boolean.valueOf(r100.m());
        this.f130073h = r100.getRoomContext();
        this.f130074i = r100.i();
    }
}
