package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f136496a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.common.combinedtext.a$a, reason: collision with other inner class name */
    public static final class C2167a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f136497a;

        public C2167a(e r100) {
            this.f136497a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            e r101 = this.f136497a;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            e r101 = this.f136497a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    static {
    }

    @JvmStatic
    public static final Animator a(View r100, e r101) {
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.35f, 1.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.35f, 1.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r102, r103});
        r104.setDuration(200);
        r104.addListener(new C2167a(r101));
        return r104;
    }

    public static Animator b(DisplayTextView r100, j r101) {
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(80);
        r102.addUpdateListener(new b(r100));
        r102.addListener(new c(r101));
        return r102;
    }
}
