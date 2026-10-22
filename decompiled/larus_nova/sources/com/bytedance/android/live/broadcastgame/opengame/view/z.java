package com.bytedance.android.live.broadcastgame.opengame.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z {

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f61334a;

        public a(Function0 r100) {
            this.f61334a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f61334a.invoke();
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f61335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f61336b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f61335a.setVisibility(8);
            this.f61336b.invoke();
        }

        public b(View r100, Function0 r101) {
            this.f61335a = r100;
            this.f61336b = r101;
        }
    }

    public static /* synthetic */ void b(View r100) {
        a(r100, 250, 0.0f, RewardMsgContainerKt$fadeIn$1.INSTANCE);
    }

    public static /* synthetic */ void d(View r100) {
        c(r100, 250, 0.0f, RewardMsgContainerKt$fadeOut$1.INSTANCE);
    }

    public static final void e(View r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "inView");
        Intrinsics.checkNotNullParameter(r101, "endAction");
        if (r100.getHeight() != 0) goto L6;
        ALogger.i("RewardMsgContainer", "view的高度为0");
        return;
    L6:
        r100.clearAnimation();
        r100.setAlpha(0.0f);
        r100.setVisibility(0);
        float r102 = r100.getHeight() / 4;
        r100.setTranslationY(-r102);
        r100.animate().alpha(1.0f).translationYBy(r102).setDuration(250).setListener(new a0(r100, r101));
    }

    public static final void f(View r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "outView");
        Intrinsics.checkNotNullParameter(r101, "endAction");
        if (r100.getHeight() != 0) goto L6;
        ALogger.i("RewardMsgContainer", "view的高度为0");
        return;
    L6:
        float r102 = r100.getHeight() / 4;
        r100.clearAnimation();
        r100.animate().alpha(0.0f).translationYBy(r102).setDuration(250).setListener(new b0(r100, r101));
    }

    public static final void a(View r100, long r101, float r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "inView");
        Intrinsics.checkNotNullParameter(r103, "endAction");
        r100.setAlpha(r102);
        r100.setVisibility(0);
        r100.clearAnimation();
        r100.animate().alpha(1.0f).setDuration(r101).setListener(new a(r103));
    }

    public static final void c(View r100, long r101, float r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "outView");
        Intrinsics.checkNotNullParameter(r103, "endAction");
        r100.clearAnimation();
        r100.animate().alpha(r102).setDuration(r101).setListener(new b(r100, r103));
    }
}
