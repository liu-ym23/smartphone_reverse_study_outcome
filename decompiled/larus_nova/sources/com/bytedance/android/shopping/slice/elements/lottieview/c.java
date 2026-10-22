package com.bytedance.android.shopping.slice.elements.lottieview;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f183309a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public c(d r100) {
        this.f183309a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ECLottieAnimationView r101 = this.f183309a.f183310c;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        ECDraweeView r102 = this.f183309a.f183311d;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ECLottieAnimationView r101 = this.f183309a.f183310c;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        ECDraweeView r102 = this.f183309a.f183311d;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ECLottieAnimationView r101 = this.f183309a.f183310c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ECDraweeView r102 = this.f183309a.f183311d;
        if (r102 == null) goto L9;
        r102.setVisibility(4);
        return;
    }
}
