package com.bytedance.android.ec.core.sku;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMarqueeView f45321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f45322b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        CommonMarqueeView r101 = this.f45321a;
        r101.f45316h = this.f45322b;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        CommonMarqueeView r101 = this.f45321a;
        Function1<? super View, Unit> r102 = r101.f45314f;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r101.getChildAt(r101.f45316h));
        return;
    }

    public a(CommonMarqueeView r100, int r101) {
        this.f45321a = r100;
        this.f45322b = r101;
    }
}
