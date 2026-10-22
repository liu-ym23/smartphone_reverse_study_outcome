package com.bytedance.android.shopping.deepfeed.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedProductBannerIndicatorAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f173717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f173718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f173719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.deepfeed.ui.b f173720d;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductBannerIndicatorAnimator f173721a;

        public a(DeepFeedProductBannerIndicatorAnimator r100) {
            this.f173721a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f173721a.a().removeAllUpdateListeners();
            this.f173721a.a().removeAllListeners();
            this.f173721a.f173720d.j(1.0f, true);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductBannerIndicatorAnimator f173722a;

        public b(DeepFeedProductBannerIndicatorAnimator r100) {
            this.f173722a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f173722a.f173720d.j(r100.getAnimatedFraction(), false);
        }
    }

    public final ValueAnimator a() {
        return (ValueAnimator) this.f173719c.getValue();
    }

    public final void b() {
        if (a().isRunning() == false) goto L5;
        return;
    L5:
        a().addUpdateListener(this.f173717a);
        a().addListener(this.f173718b);
        a().start();
    }

    public final void c() {
        a().removeAllUpdateListeners();
        a().removeAllListeners();
        a().cancel();
    }

    public DeepFeedProductBannerIndicatorAnimator(com.bytedance.android.shopping.deepfeed.ui.b r100) {
        Intrinsics.checkNotNullParameter(r100, "banner");
        this.f173720d = r100;
        this.f173717a = new b(this);
        this.f173718b = new a(this);
        this.f173719c = LazyKt.lazy(DeepFeedProductBannerIndicatorAnimator$animator$2.INSTANCE);
    }
}
