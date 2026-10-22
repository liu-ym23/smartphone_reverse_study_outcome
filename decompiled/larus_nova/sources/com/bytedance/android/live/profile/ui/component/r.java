package com.bytedance.android.live.profile.ui.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f86762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f86763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f86764c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f86763b;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r101, true);
    L5:
        UtilityKotlinExtentionsKt.z(this.f86762a, false);
        int r102 = com.bytedance.android.live.profile.ui.util.u.f86961a;
        int r103 = this.f86764c.element;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r104 = ts0.a.f547341f;
        Integer r105 = Integer.valueOf(r103);
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f86763b;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r101, true);
    L5:
        UtilityKotlinExtentionsKt.z(this.f86762a, false);
        Ref.IntRef r102 = this.f86764c;
        int r103 = r102.element + 1;
        r102.element = r103;
        int r104 = com.bytedance.android.live.profile.ui.util.u.f86961a;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = ts0.a.f547341f;
        Integer r106 = Integer.valueOf(r103);
        r105.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r105, r106);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f86764c.element++;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f86763b;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.A(r101, false);
        return;
    }

    public r(LottieAnimationView r100, View r101, Ref.IntRef r102) {
        this.f86762a = r100;
        this.f86763b = r101;
        this.f86764c = r102;
    }
}
