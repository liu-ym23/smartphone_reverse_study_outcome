package com.bytedance.android.live.recharge.panel.dynamic;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends j implements b, h<com.bytedance.android.live.recharge.core.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f90206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.core.b f90207f;

    public final String toString() {
        return "com.bytedance.android.live.recharge.panel.dynamic.__ScopeImpl_DynamicRechargePanelScope";
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.b
    public final com.bytedance.android.live.recharge.panel.context.f c() {
        Object r100 = this.f90206e;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.recharge.panel.context.f) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.context.RechargePanelContext");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f90207f;
    }

    public g(com.bytedance.android.live.recharge.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f90207f = r100;
        this.f90206e = k.f470908a;
    }
}
