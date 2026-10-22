package com.obric.common.oea.style.scene.qsanim.morph;

import android.animation.Animator;
import android.view.animation.Interpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewMorphAnimHelperEx$doScaleAnimation$$inlined$apply$lambda$1 implements Animator.AnimatorListener {
    final /* synthetic */ a $animType$inlined;
    final /* synthetic */ long $duration$inlined;
    final /* synthetic */ Animator $heightAnimator$inlined;
    final /* synthetic */ Interpolator $interpolator$inlined;
    final /* synthetic */ boolean $scaleUp$inlined;
    final /* synthetic */ float $targetHeight$inlined;
    final /* synthetic */ float $targetWidth$inlined;
    final /* synthetic */ float $targetX$inlined;
    final /* synthetic */ float $targetY$inlined;
    final /* synthetic */ Animator $widthAnimator$inlined;
    final /* synthetic */ Animator $xAnimator$inlined;
    final /* synthetic */ Animator $yAnimator$inlined;
    final /* synthetic */ d this$0;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    ViewMorphAnimHelperEx$doScaleAnimation$$inlined$apply$lambda$1(d r5, boolean r6, float r7, float r8, float r9, float r10, long r11, a r13, Interpolator r14, Animator r15, Animator r16, Animator r17, Animator r18) {
        Interpolator r1 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r14, Interpolator.class, "com.obric.aiagent.plugin");
        this.this$0 = r5;
        this.$scaleUp$inlined = r6;
        this.$targetWidth$inlined = r7;
        this.$targetHeight$inlined = r8;
        this.$targetX$inlined = r9;
        this.$targetY$inlined = r10;
        this.$duration$inlined = r11;
        this.$animType$inlined = r13;
        this.$interpolator$inlined = r1;
        this.$xAnimator$inlined = r15;
        this.$yAnimator$inlined = r16;
        this.$widthAnimator$inlined = r17;
        this.$heightAnimator$inlined = r18;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r4) {
        o.e(r4, "animation");
        com.obric.common.oea.foundation.b.c.f32472a.c("ViewMorphAnimHelper", "doScaleAnimation, onAnimationStart, scaleUp: " + this.$scaleUp$inlined + ", targetWidth: " + this.$targetWidth$inlined + ", targetHeight: " + this.$targetHeight$inlined + ", targetX: " + this.$targetX$inlined + ", targetY: " + this.$targetY$inlined + ", duration: " + this.$duration$inlined);
        b r5 = d.a(this.this$0);
        if (r5 == null) goto L6;
        r5.a(this.$animType$inlined);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r4) {
        o.e(r4, "animation");
        com.obric.common.oea.foundation.b.c.f32472a.c("ViewMorphAnimHelper", "doScaleAnimation, onAnimationEnd, scaleUp: " + this.$scaleUp$inlined + ", targetWidth: " + this.$targetWidth$inlined + ", targetHeight: " + this.$targetHeight$inlined + ", targetX: " + this.$targetX$inlined + ", targetY: " + this.$targetY$inlined + ", duration: " + this.$duration$inlined);
        b r5 = d.a(this.this$0);
        if (r5 == null) goto L6;
        r5.b(this.$animType$inlined);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r4) {
        o.e(r4, "animation");
        com.obric.common.oea.foundation.b.c.f32472a.c("ViewMorphAnimHelper", "doScaleAnimation, onAnimationCancel, scaleUp: " + this.$scaleUp$inlined + ", targetWidth: " + this.$targetWidth$inlined + ", targetHeight: " + this.$targetHeight$inlined + ", targetX: " + this.$targetX$inlined + ", targetY: " + this.$targetY$inlined + ", duration: " + this.$duration$inlined);
        b r5 = d.a(this.this$0);
        if (r5 == null) goto L6;
        r5.b(this.$animType$inlined);
        return;
    }
}
