package com.bytedance.android.live.matchroom;

import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f82888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f82889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f82890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f82891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f82892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f82893f;

    public i(float r100, float r101, float r102, float r103, View r104) {
        this.f82888a = r100;
        this.f82889b = r101;
        this.f82890c = r102;
        this.f82891d = r103;
        this.f82892e = true;
        this.f82893f = r104;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        float r101 = this.f82888a;
        float r102 = this.f82889b - r101;
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L29;
        float r104 = r101 + (r102 * ((Float) r103).floatValue());
        float r105 = this.f82890c;
        float r106 = this.f82891d - r105;
        Object r107 = r100.getAnimatedValue();
        if (r107 == null) goto L27;
        float r108 = r105 + (r106 * ((Float) r107).floatValue());
        if (Float.isNaN(r104) == false) goto L9;
        return;
    L9:
        if (Float.isInfinite(r104) == false) goto L11;
        return;
    L11:
        if (Float.isNaN(r108) == false) goto L13;
        return;
    L13:
        if (Float.isInfinite(r108) == true) goto L33;
        boolean r109 = MatchRoomLandScapeAnimUtil.f82832a;
        WeakReference<d> r110 = MatchRoomLandScapeAnimUtil.f82843l;
        if (r110 == null) goto L24;
        d r111 = r110.get();
        if (r111 == null) goto L24;
        if (this.f82892e == true) goto L22;
        r111 = null;
    L22:
        if (r111 == null) goto L24;
        r111.c(r104, r108);
        return;
    L24:
        this.f82893f.setScaleX(r104);
        this.f82893f.setScaleY(r108);
        Unit r112 = Unit.INSTANCE;
        return;
    L33:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
