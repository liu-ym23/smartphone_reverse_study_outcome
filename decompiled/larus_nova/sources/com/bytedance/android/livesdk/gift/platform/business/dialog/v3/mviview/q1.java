package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q1 extends e33.j implements o1, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f127969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.scope.j f127970f;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.__ScopeImpl_TopViewScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.o1
    public Context getContext() {
        Object r100 = this.f127969e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f127970f;
    }

    public q1(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f127970f = r100;
        this.f127969e = e33.k.f470908a;
    }
}
