package com.bytedance.android.livesdk.livecommerce.playback.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f149879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f149880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f149881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ExplainPlaybackGuidePresenter f149882d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ExplainPlaybackGuidePresenter.d0(this.f149882d);
        this.f149880b.removeAllUpdateListeners();
        this.f149879a.removeView(this.f149881c);
    }

    public b(ViewGroup r100, LottieAnimationView r101, FrameLayout r102, ExplainPlaybackGuidePresenter r103) {
        this.f149879a = r100;
        this.f149880b = r101;
        this.f149881c = r102;
        this.f149882d = r103;
    }
}
