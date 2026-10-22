package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PaidRoomTempWatchEndView$alphaAnimator$2 extends Lambda implements Function0<ValueAnimator> {
    final /* synthetic */ PaidRoomTempWatchEndView this$0;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidRoomTempWatchEndView$alphaAnimator$2 f160065a;

        public a(PaidRoomTempWatchEndView$alphaAnimator$2 r100) {
            this.f160065a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            PaidRoomTempWatchEndView r101 = this.f160065a.this$0;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L11;
            r101.setAlpha(((Float) r102).floatValue());
            if (this.f160065a.this$0.getAlpha() <= 0.3d) goto L12;
            View r103 = PaidRoomTempWatchEndView.c(this.f160065a.this$0);
            if (r103 == null) goto L13;
            r103.setVisibility(0);
            return;
        L13:
            return;
        L12:
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidRoomTempWatchEndView$alphaAnimator$2 f160066a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f160067a;

            public a(b r100) {
                this.f160067a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f160067a.f160066a.this$0.i();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(PaidRoomTempWatchEndView$alphaAnimator$2 r100) {
            this.f160066a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = PaidRoomTempWatchEndView.c(this.f160066a.this$0);
            if (r101 == null) goto L6;
            r101.post(new a(this));
            return;
        }
    }

    public PaidRoomTempWatchEndView$alphaAnimator$2(PaidRoomTempWatchEndView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValueAnimator invoke() {
        ValueAnimator r100 = ObjectAnimator.ofFloat(new float[]{0.0f, PaidRoomTempWatchEndView.a(this.this$0).f()});
        r100.setDuration(1500);
        r100.addUpdateListener(new a(this));
        r100.addListener(new b(this));
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValueAnimator invoke() {
        return invoke();
    }
}
