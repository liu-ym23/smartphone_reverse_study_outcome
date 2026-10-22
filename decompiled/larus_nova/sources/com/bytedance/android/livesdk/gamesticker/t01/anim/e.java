package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f125763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f125764e;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f125765a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public a(e r100) {
            this.f125765a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f125765a.c(TaskState.END);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f125765a.c(TaskState.END);
        }
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "ShowContainerTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
        ValueAnimator r100 = this.f125763d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f125763d = null;
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r100 = this.f125759c;
        if (r100 == null) goto L14;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100.V2(), LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-r100.getHeight(), 0.0f});
        this.f125763d = r101;
        if (r101 == null) goto L7;
        r101.setDuration(500);
    L7:
        ValueAnimator r102 = this.f125763d;
        if (r102 == null) goto L10;
        r102.addListener(new a(this));
    L10:
        r100.V2().setTranslationY(-r100.getHeight());
        r100.V2().setVisibility(0);
        this.f125764e.invoke();
        ValueAnimator r103 = this.f125763d;
        if (r103 == null) goto L14;
        r103.start();
    L14:
        if (this.f125759c != null) goto L17;
        c(TaskState.END);
        return;
    }

    public e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onVisible");
        this.f125764e = r100;
    }
}
