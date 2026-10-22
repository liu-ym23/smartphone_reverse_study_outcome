package com.bytedance.android.ec.window.base.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BouncingMarqueeTextView f49932a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f49933a;

        public a(ValueAnimator r100) {
            this.f49933a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f49933a.resume();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public b(BouncingMarqueeTextView r100) {
        this.f49932a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f49932a.getEdgePauseDuration() > 0) goto L5;
        return;
    L5:
        if ((r100 instanceof ValueAnimator) == true) goto L7;
        r100 = null;
    L7:
        ValueAnimator r101 = (ValueAnimator) r100;
        if (r101 == null) goto L12;
        r101.pause();
        BouncingMarqueeTextView r102 = this.f49932a;
        r102.postDelayed(new a(r101), r102.getEdgePauseDuration());
        return;
    }
}
