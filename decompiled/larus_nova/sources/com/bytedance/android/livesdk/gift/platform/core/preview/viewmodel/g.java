package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends j implements e, h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f131136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f131137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f131138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.scope.j f131139h;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.__ScopeImpl_UgcSalePanelScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.e
    public final String getClickFrom() {
        Object r100 = this.f131138g;
        if (r100 == null) goto L7;
        return (String) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.e
    public final int getSourceFrom() {
        Object r100 = this.f131136e;
        if (r100 == null) goto L7;
        return ((Integer) r100).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.e
    public final Long k() {
        return (Long) this.f131137f;
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f131139h;
    }

    public g(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f131139h = r100;
        Object r101 = k.f470908a;
        this.f131136e = r101;
        this.f131137f = r101;
        this.f131138g = r101;
    }
}
