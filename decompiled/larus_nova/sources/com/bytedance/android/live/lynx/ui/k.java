package com.bytedance.android.live.lynx.ui;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import com.airbnb.lottie.LottieComposition;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLottieView f82742a;

    public k(LynxLottieView r100) {
        this.f82742a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LottieComposition r101 = LynxLottieView.M(this.f82742a).getComposition();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.getAnimatedValue() == null) goto L23;
        LynxLottieView r102 = this.f82742a;     // Catch: Exception -> L18
        float r103 = r101.getDurationFrames();     // Catch: Exception -> L18
        Object r104 = r100.getAnimatedValue();     // Catch: Exception -> L18
        if (r104 == null) goto L17;
        r102.f82716f = (int) (r103 * ((Float) r104).floatValue());     // Catch: Exception -> L18
        this.f82742a.f82717g = (int) r101.getDurationFrames();     // Catch: Exception -> L18
        LynxLottieView r105 = this.f82742a;     // Catch: Exception -> L18
        int r106 = r105.f82716f;     // Catch: Exception -> L18
        int r107 = r105.f82717g;     // Catch: Exception -> L18
        int r108 = (int) ((r106 / r107) * 100);     // Catch: Exception -> L18
        if (r106 == 0) goto L15;
        if (r106 == r107) goto L15;
        if (r105.f82720j == r108) goto L24;
        long r109 = SystemClock.uptimeMillis();     // Catch: Exception -> L18
        LynxLottieView r110 = this.f82742a;     // Catch: Exception -> L18
        if ((r109 - r110.f82721k) >= (1000 / r110.f82715e)) goto L15;
        return;
    L24:
        return;
    L15:
        LynxLottieView r111 = this.f82742a;     // Catch: Exception -> L18
        LynxLottieView.N(r111, "update", r111.f82716f, r111.f82717g, r111.f82718h);     // Catch: Exception -> L18
        LynxLottieView r112 = this.f82742a;     // Catch: Exception -> L18
        r112.f82720j = r108;     // Catch: Exception -> L18
        r112.f82721k = SystemClock.uptimeMillis();     // Catch: Exception -> L18
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return;
    }
}
