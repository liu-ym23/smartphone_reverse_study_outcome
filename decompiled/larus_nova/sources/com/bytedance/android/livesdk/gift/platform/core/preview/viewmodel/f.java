package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends j implements d, h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f131133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f131134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.scope.j f131135g;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.__ScopeImpl_UgcPoolPanelScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.d
    public final String getClickFrom() {
        Object r100 = this.f131134f;
        if (r100 == null) goto L7;
        return (String) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.d
    public final int getSourceFrom() {
        Object r100 = this.f131133e;
        if (r100 == null) goto L7;
        return ((Integer) r100).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f131135g;
    }

    public f(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f131135g = r100;
        Object r101 = k.f470908a;
        this.f131133e = r101;
        this.f131134f = r101;
    }
}
