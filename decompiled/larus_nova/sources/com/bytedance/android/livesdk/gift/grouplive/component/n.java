package com.bytedance.android.livesdk.gift.grouplive.component;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n extends e33.j implements k, e33.h<i12.e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f126318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f126319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f126320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f126321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i12.g f126322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i12.e f126323j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.grouplive.component.__ScopeImpl_GroupScope";
    }

    public final void I() {
        Object r100 = e33.k.f470908a;
        if (this.f126318e != r100) goto L6;
        String r101 = PerfLog.PARAM_KEY_CONTEXT_ID;
    L18:
        if (r101 != null) goto L21;
        return;
    L21:
        throw new UninitializedPropertyAccessException(r101);
    L6:
        if (this.f126319f != r100) goto L9;
        r101 = "dataCenter";
        goto L18
    L9:
        if (this.f126320g != r100) goto L12;
        r101 = "isInLive";
        goto L18
    L12:
        if (this.f126321h != r100) goto L15;
        r101 = "roomContext";
        goto L18
    L15:
        if (this.f126322i != r100) goto L17;
        r101 = "roomInstance";
        goto L18
    L17:
        r101 = null;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.k, i12.e
    public Context getContext() {
        Object r100 = this.f126318e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r100 = this.f126319f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r100 = this.f126321h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final i12.g i() {
        i12.g r100 = this.f126322i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r100 = this.f126320g;
        if (r100 == null) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f126323j;
    }

    public n(i12.e r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f126323j = r100;
        Object r101 = e33.k.f470908a;
        this.f126318e = r100.getContext();
        this.f126319f = r100.getDataCenter();
        this.f126320g = Boolean.valueOf(r100.m());
        this.f126321h = r100.getRoomContext();
        this.f126322i = r100.i();
    }
}
