package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p1 extends e33.j implements n1, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f127963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.scope.j f127964f;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.__ScopeImpl_ReceiverViewScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.n1
    public Context getContext() {
        Object r100 = this.f127963e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f127964f;
    }

    public p1(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f127964f = r100;
        this.f127963e = e33.k.f470908a;
    }
}
