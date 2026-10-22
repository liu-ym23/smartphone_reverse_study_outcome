package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends j implements a, e33.h<b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f159511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f159512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f159513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f159514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PaidSceneViewEntry f159515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f159516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f159517k;

    public final String toString() {
        return "com.bytedance.android.livesdk.vscore_api.paidlive.scope.__ScopeImpl_IPaidSceneScope";
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final c D() {
        c r100 = this.f159516j;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_api.paidlive.scope.IPaidScopeDataProvider");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final int g() {
        Object r100 = this.f159514h;
        if (r100 == null) goto L7;
        return ((Integer) r100).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final long getId() {
        Object r100 = this.f159513g;
        if (r100 == null) goto L7;
        return ((Long) r100).longValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.a
    public final PaidSceneEnum i0() {
        Object r100 = this.f159511e;
        if (r100 == null) goto L7;
        return (PaidSceneEnum) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.a
    public final PaidSceneContext l() {
        Object r100 = this.f159512f;
        if (r100 == null) goto L7;
        return (PaidSceneContext) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.b
    public final PaidSceneViewEntry w0() {
        PaidSceneViewEntry r100 = this.f159515i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f159517k;
    }

    public h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f159517k = r100;
        Object r101 = k.f470908a;
        this.f159511e = r101;
        this.f159512f = r101;
        this.f159513g = Long.valueOf(r100.getId());
        this.f159514h = Integer.valueOf(r100.g());
        this.f159515i = r100.w0();
        this.f159516j = r100.D();
    }
}
