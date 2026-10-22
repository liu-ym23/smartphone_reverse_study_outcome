package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductInfoMarqueeView f174242a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f174243a;

        public a(r r100) {
            this.f174243a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator r100 = this.f174243a.f174242a.f174110d;     // Catch: Throwable -> L10
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isRunning() == true) goto L17;
            ValueAnimator r101 = this.f174243a.f174242a.f174110d;     // Catch: Throwable -> L10
            if (r101 == null) goto L18;
            r101.start();     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public r(DeepFeedProductInfoMarqueeView r100) {
        this.f174242a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        DeepFeedProductInfoMarqueeView r101 = this.f174242a;
        if (r101.f174116j == false) goto L7;
        View r102 = r101.f174107a;
        if (r102 == null) goto L10;
        r102.setTranslationY(r101.f174109c);
    L10:
        DeepFeedProductInfoMarqueeView r103 = this.f174242a;
        r103.f174116j = !r103.f174116j;
        Runnable r104 = r103.f174111e;
        if (r104 == null) goto L13;
        r103.f174112f.removeCallbacks(r104);
    L13:
        DeepFeedProductInfoMarqueeView r105 = this.f174242a;
        a r106 = new a(this);
        r105.f174111e = r106;
        Handler r107 = r105.f174112f;
        Intrinsics.checkNotNull(r106);
        r107.postDelayed(r106, this.f174242a.f174114h);
        return;
    L7:
        View r108 = r101.f174108b;
        if (r108 == null) goto L10;
        r108.setTranslationY(r101.f174109c);
        goto L10
    }
}
