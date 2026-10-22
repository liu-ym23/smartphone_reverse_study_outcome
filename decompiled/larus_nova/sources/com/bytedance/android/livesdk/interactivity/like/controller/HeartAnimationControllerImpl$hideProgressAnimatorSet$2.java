package com.bytedance.android.livesdk.interactivity.like.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u32.h;
import u32.o;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class HeartAnimationControllerImpl$hideProgressAnimatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    final /* synthetic */ h.a $initializer;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.controller.c this$0;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 f137615a;

        public a(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r100) {
            this.f137615a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            com.bytedance.android.livesdk.interactivity.like.controller.c r101 = this.f137615a.this$0;
            int r102 = com.bytedance.android.livesdk.interactivity.like.controller.c.f137646b;
            r101.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            Object r103 = r100.getAnimatedValue();
            if (r103 == null) goto L5;
            ((Float) r103).floatValue();
            throw null;
        L5:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 f137616a;

        public b(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r100) {
            this.f137616a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            com.bytedance.android.livesdk.interactivity.like.controller.c r101 = this.f137616a.this$0;
            int r102 = com.bytedance.android.livesdk.interactivity.like.controller.c.f137646b;
            r101.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            throw null;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 f137617a;

        public c(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r100) {
            this.f137617a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f137617a.getClass();
            throw null;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 f137618a;

        public d(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r100) {
            this.f137618a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137618a.getClass();
            throw null;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 f137619a;

        public e(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r100) {
            this.f137619a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137619a.this$0.f137647a = State.CLEAR;
            DiggContext.Companion.getClass();
            DiggContext r101 = DiggContext.a.a(null);
            if (r101 == null) goto L7;
            n<o> r102 = r101.getThankAnimationController();
            if (r102 == null) goto L7;
            o r103 = r102.getValue();
        L9:
            if ((r103 instanceof com.bytedance.android.livesdk.interactivity.like.controller.e) == true) goto L11;
            r103 = null;
        L11:
            com.bytedance.android.livesdk.interactivity.like.controller.e r104 = (com.bytedance.android.livesdk.interactivity.like.controller.e) r103;
            if (r104 == null) goto L15;
            r104.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("thankTextView");
            throw null;
        L15:
            this.f137619a.this$0.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("heartView");
            throw null;
        L7:
            r103 = null;
            goto L9
        }
    }

    public HeartAnimationControllerImpl$hideProgressAnimatorSet$2(com.bytedance.android.livesdk.interactivity.like.controller.c r100, h.a r101) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnimatorSet invoke() {
        AnimatorSet r100 = new AnimatorSet();
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        int r102 = com.bytedance.android.livesdk.interactivity.like.controller.c.f137646b;
        r101.setDuration(200);
        r101.addUpdateListener(new a(this));
        r101.addListener(new b(this));
        Unit r103 = Unit.INSTANCE;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.setDuration(200);
        r104.addUpdateListener(new c(this));
        r104.addListener(new d(this));
        r100.playSequentially(new Animator[]{r101, r104});
        r100.addListener(new e(this));
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnimatorSet invoke() {
        return invoke();
    }
}
