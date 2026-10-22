package com.bytedance.android.livesdk.interactivity.like.controller;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class HeartAnimationControllerImpl$turnLargeAnimatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    final /* synthetic */ c this$0;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeartAnimationControllerImpl$turnLargeAnimatorSet$2 f137625a;

        public a(HeartAnimationControllerImpl$turnLargeAnimatorSet$2 r100) {
            this.f137625a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            c r101 = this.f137625a.this$0;
            int r102 = c.f137646b;
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

    public HeartAnimationControllerImpl$turnLargeAnimatorSet$2(c r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnimatorSet invoke() {
        new AnimatorSet();
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        int r101 = c.f137646b;
        r100.setDuration(150);
        r100.addUpdateListener(new a(this));
        Unit r102 = Unit.INSTANCE;
        this.this$0.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("loveTextView");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnimatorSet invoke() {
        return invoke();
    }
}
