package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import e33.j;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends j implements b, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f159518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f159519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f159520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f159521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.scope.j f159522i;

    public final String toString() {
        return "com.bytedance.android.livesdk.vscore_api.paidlive.scope.__ScopeImpl_IPaidScope";
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final c D() {
        Object r100 = this.f159521h;
        if (r100 == null) goto L7;
        return (c) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_api.paidlive.scope.IPaidScopeDataProvider");
    }

    public final void I() {
        Object r100 = k.f470908a;
        if (this.f159518e != r100) goto L6;
        String r101 = "id";
    L15:
        if (r101 != null) goto L18;
        return;
    L18:
        throw new UninitializedPropertyAccessException(r101);
    L6:
        if (this.f159519f != r100) goto L9;
        r101 = "fragmentHashCode";
        goto L15
    L9:
        if (this.f159520g != r100) goto L12;
        r101 = "paidSceneViewEntry";
        goto L15
    L12:
        if (this.f159521h != r100) goto L14;
        r101 = "paidScopeDataProvider";
        goto L15
    L14:
        r101 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final int g() {
        Object r100 = this.f159519f;
        if (r100 == null) goto L7;
        return ((Integer) r100).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final long getId() {
        Object r100 = this.f159518e;
        if (r100 == null) goto L7;
        return ((Long) r100).longValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final PaidSceneViewEntry w0() {
        Object r100 = this.f159520g;
        if (r100 == null) goto L7;
        return (PaidSceneViewEntry) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f159522i;
    }

    public i(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f159522i = r100;
        Object r101 = k.f470908a;
        this.f159518e = r101;
        this.f159519f = r101;
        this.f159520g = r101;
        this.f159521h = r101;
    }
}
