package com.bytedance.android.live.lynx.ui;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLottieView f82741a;

    public j(LynxLottieView r100) {
        this.f82741a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LynxLottieView r101 = this.f82741a;
        LottieAnimationView r102 = LynxLottieView.M(r101);
        if (r102 == null) goto L5;
        int r103 = r102.getFrame();
    L6:
        LottieComposition r104 = LynxLottieView.M(this.f82741a).getComposition();
        if (r104 == null) goto L9;
        float r105 = r104.getDurationFrames();
    L10:
        LynxLottieView.N(r101, "cancel", r103, (int) r105, this.f82741a.f82718h);
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LottieAnimationView r101 = LynxLottieView.M(this.f82741a);
        if (r101 == null) goto L9;
        LynxLottieView r102 = this.f82741a;
        boolean r103 = r102.f82711a;
        LottieAnimationView r104 = LynxLottieView.M(r102);
        if (r103 == false) goto L7;
        float r105 = r104.getMaxFrame();
    L8:
        r101.setFrame((int) r105);
        goto L9
    L7:
        r105 = r104.getMinFrame();
    L9:
        LynxLottieView r106 = this.f82741a;
        LottieAnimationView r107 = LynxLottieView.M(r106);
        if (r107 == null) goto L12;
        int r108 = r107.getFrame();
    L13:
        LottieComposition r109 = LynxLottieView.M(this.f82741a).getComposition();
        if (r109 == null) goto L16;
        float r110 = r109.getDurationFrames();
    L17:
        LynxLottieView.N(r106, "completion", r108, (int) r110, this.f82741a.f82718h);
        return;
    L16:
        r110 = 0.0f;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LynxLottieView r101 = this.f82741a;
        r101.f82718h++;
        LottieAnimationView r102 = LynxLottieView.M(r101);
        if (r102 == null) goto L5;
        int r103 = r102.getFrame();
    L6:
        LottieComposition r104 = LynxLottieView.M(this.f82741a).getComposition();
        if (r104 == null) goto L9;
        float r105 = r104.getDurationFrames();
    L10:
        LynxLottieView.N(r101, SalesInfoStruct.REPEAT, r103, (int) r105, this.f82741a.f82718h);
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LynxLottieView r101 = this.f82741a;
        int r102 = 0;
        r101.f82718h = 0;
        LottieAnimationView r103 = LynxLottieView.M(r101);
        if (r103 == null) goto L5;
        r102 = r103.getFrame();
    L5:
        LottieComposition r104 = LynxLottieView.M(this.f82741a).getComposition();
        if (r104 == null) goto L8;
        float r105 = r104.getDurationFrames();
    L9:
        LynxLottieView.N(r101, "start", r102, (int) r105, this.f82741a.f82718h);
        return;
    L8:
        r105 = 0.0f;
        goto L9
    }
}
