package com.bytedance.android.live.revlink.impl.multianchor.scope;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends j implements a, h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f94638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f94639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f94640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.scope.j f94641h;

    public final String toString() {
        return "com.bytedance.android.live.revlink.impl.multianchor.scope.__ScopeImpl_MultiLinkAnchorControlScope";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.scope.a
    public Context getContext() {
        Object r100 = this.f94638e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.scope.a
    public final LifecycleOwner getLifeCycle() {
        Object r100 = this.f94639f;
        if (r100 == null) goto L7;
        return (LifecycleOwner) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.scope.a
    public final i11.b getLinkUserCenter() {
        Object r100 = this.f94640g;
        if (r100 == null) goto L7;
        return (i11.b) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.usercenter.IAnchorLinkUserCenter");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f94641h;
    }

    public e(u51.b r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f94641h = r100;
        Object r101 = k.f470908a;
        this.f94638e = r101;
        this.f94639f = r101;
        this.f94640g = r101;
    }
}
