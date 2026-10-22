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
public final class a extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f125753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f125754e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamesticker.t01.anim.a$a, reason: collision with other inner class name */
    public static final class C2022a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f125755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f125756b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f125756b.c(TaskState.END);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f125756b.c(TaskState.END);
            this.f125755a.V2().setVisibility(8);
            this.f125756b.f125754e.invoke();
        }

        public C2022a(i r100, a r101) {
            this.f125755a = r100;
            this.f125756b = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "HideContainerTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
        ValueAnimator r100 = this.f125753d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f125753d = null;
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r100 = this.f125759c;
        if (r100 == null) goto L14;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100.V2(), LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -r100.getHeight()});
        this.f125753d = r101;
        if (r101 == null) goto L7;
        r101.setDuration(500);
    L7:
        ValueAnimator r102 = this.f125753d;
        if (r102 == null) goto L10;
        r102.addListener(new C2022a(r100, this));
    L10:
        ValueAnimator r103 = this.f125753d;
        if (r103 == null) goto L14;
        r103.start();
    L14:
        if (this.f125759c != null) goto L17;
        c(TaskState.END);
        return;
    }

    public a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onGone");
        this.f125754e = r100;
    }
}
