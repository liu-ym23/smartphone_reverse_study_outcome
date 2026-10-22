package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VsMsgBoardBottomTipSectionProvider f137335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f137336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f137337c;

    public u(VsMsgBoardBottomTipSectionProvider r100, boolean r101, ValueAnimator r102) {
        this.f137335a = r100;
        this.f137336b = r101;
        this.f137337c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        View r101 = this.f137335a.f137238c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f137336b == false) goto L16;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.z(r101, true);
    L8:
        View r102 = this.f137335a.f137238c;
        if (r102 == null) goto L13;
        ViewGroup r103 = UtilityKotlinExtentionsKt.p(r102);
        if (r103 == null) goto L13;
        UtilityKotlinExtentionsKt.z(r103, true);
    L13:
        View r104 = this.f137335a.f137238c;
        if (r104 == null) goto L30;
        r104.setAlpha(r100.getAnimatedFraction());
        return;
    L30:
        return;
    L16:
        if (r101 == null) goto L19;
        r101.setAlpha(1 - r100.getAnimatedFraction());
    L19:
        if (this.f137337c.getAnimatedFraction() < 1.0f) goto L32;
        View r105 = this.f137335a.f137238c;
        if (r105 == null) goto L23;
        UtilityKotlinExtentionsKt.z(r105, false);
    L23:
        View r106 = this.f137335a.f137238c;
        if (r106 == null) goto L33;
        ViewGroup r107 = UtilityKotlinExtentionsKt.p(r106);
        if (r107 == null) goto L34;
        UtilityKotlinExtentionsKt.z(r107, false);
        return;
    L34:
        return;
    L33:
        return;
    }
}
