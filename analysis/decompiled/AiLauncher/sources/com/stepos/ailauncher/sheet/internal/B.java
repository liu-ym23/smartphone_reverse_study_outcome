package com.stepos.ailauncher.sheet.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.provider.Settings;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.sheet.HandleBounds;
import com.stepos.ailauncher.sheet.InterfaceC3456j;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/B;", "", "<init>", "()V", "Landroid/view/View;", ChatTracker.CONTENT_SHEET, "Lcom/stepos/ailauncher/sheet/j;", "boundsProvider", "", "durationMs", "Lkotlin/Function1;", "", "LY8/t;", "onProgress", "Lkotlin/Function0;", "onEnd", "Landroid/animation/Animator;", Const.INTENT_KEY_UMID, "(Landroid/view/View;Lcom/stepos/ailauncher/sheet/j;JLp9/l;Lp9/a;)Landroid/animation/Animator;", "view", "screenX", "screenY", "", "c", "(Landroid/view/View;FF)[F", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(F)F", "Landroid/view/animation/PathInterpolator;", "morphInterpolator", "Landroid/view/animation/PathInterpolator;", "DEFAULT_DURATION_MS", "J", "ALPHA_START_FRACTION", "F", "END_SCALE", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    private static final float ALPHA_START_FRACTION = 0.4f;
    private static final long DEFAULT_DURATION_MS = 400;
    private static final float END_SCALE = 0.02f;
    public static final B INSTANCE = new B();
    private static final PathInterpolator morphInterpolator = new PathInterpolator(0.22f, 1.0f, 0.36f, 1.0f);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/sheet/internal/B$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ Ref$BooleanRef $ended;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onEnd;
        final /* synthetic */ InterfaceC5074l<Float, Y8.t> $onProgress;
        final /* synthetic */ View $sheet;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Ref$BooleanRef ref$BooleanRef, View view, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$ended = ref$BooleanRef;
            this.$sheet = view;
            this.$onProgress = interfaceC5074l;
            this.$onEnd = interfaceC5063a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            B.e(this.$ended, this.$sheet, this.$onProgress, this.$onEnd);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            B.e(this.$ended, this.$sheet, this.$onProgress, this.$onEnd);
        }
    }

    public static final void e(Ref$BooleanRef ref$BooleanRef, View view, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        view.setLayerType(0, null);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static /* synthetic */ Animator f(B b10, View view, InterfaceC3456j interfaceC3456j, long j10, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 400;
        }
        return b10.d(view, interfaceC3456j, j10, (i10 & 8) != 0 ? null : interfaceC5074l, (i10 & 16) != 0 ? null : interfaceC5063a);
    }

    public static final void g(View view, float f10, float f11, float f12, float f13, InterfaceC5074l interfaceC5074l, ValueAnimator anim) {
        kotlin.jvm.internal.p.i(anim, "anim");
        float animatedFraction = anim.getAnimatedFraction();
        B b10 = INSTANCE;
        float fH = b10.h(animatedFraction);
        view.setScaleX(f10 + ((f11 - f10) * fH));
        view.setScaleY(f12 + ((f11 - f12) * fH));
        if (animatedFraction > 0.4f) {
            f13 *= 1.0f - b10.h(C5685n.m((animatedFraction - 0.4f) / 0.6f, 0.0f, 1.0f));
        }
        view.setAlpha(f13);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(animatedFraction));
        }
    }

    public final float[] c(View view, float screenX, float screenY) {
        float[] fArr = {screenX, screenY};
        Matrix matrix = new Matrix();
        view.transformMatrixToGlobal(matrix);
        Matrix matrix2 = new Matrix();
        if (matrix.invert(matrix2)) {
            matrix2.mapPoints(fArr);
            return fArr;
        }
        view.getLocationOnScreen(new int[2]);
        float scaleX = view.getScaleX();
        if (scaleX == 0.0f) {
            scaleX = 1.0f;
        }
        float scaleY = view.getScaleY();
        float f10 = scaleY != 0.0f ? scaleY : 1.0f;
        fArr[0] = view.getPivotX() + (((screenX - r7[0]) - view.getPivotX()) / scaleX);
        fArr[1] = view.getPivotY() + (((screenY - r7[1]) - view.getPivotY()) / f10);
        return fArr;
    }

    public final Animator d(final View sheet, InterfaceC3456j boundsProvider, long durationMs, final InterfaceC5074l<? super Float, Y8.t> onProgress, InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(sheet, "sheet");
        kotlin.jvm.internal.p.i(boundsProvider, "boundsProvider");
        if (Settings.Global.getFloat(sheet.getContext().getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
            sheet.setAlpha(0.0f);
            if (onProgress != null) {
                onProgress.invoke(Float.valueOf(1.0f));
            }
            if (onEnd != null) {
                onEnd.invoke();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(0L);
            kotlin.jvm.internal.p.h(valueAnimatorOfFloat, "apply(...)");
            return valueAnimatorOfFloat;
        }
        HandleBounds handleBoundsA = boundsProvider.a(sheet);
        float[] fArrC = c(sheet, handleBoundsA.b(), handleBoundsA.c());
        sheet.setPivotX(fArrC[0]);
        sheet.setPivotY(fArrC[1]);
        float scaleX = sheet.getScaleX();
        if (scaleX == 0.0f) {
            scaleX = 1.0f;
        }
        float scaleY = sheet.getScaleY();
        final float f10 = scaleY == 0.0f ? 1.0f : scaleY;
        final float alpha = sheet.getAlpha();
        sheet.setLayerType(2, null);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(durationMs);
        valueAnimatorOfFloat2.setInterpolator(morphInterpolator);
        final float f11 = END_SCALE;
        final float f12 = scaleX;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.sheet.internal.A
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                B.g(sheet, f12, f11, f10, alpha, onProgress, valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new a(ref$BooleanRef, sheet, onProgress, onEnd));
        valueAnimatorOfFloat2.start();
        kotlin.jvm.internal.p.h(valueAnimatorOfFloat2, "apply(...)");
        return valueAnimatorOfFloat2;
    }

    public final float h(float t10) {
        float fM = C5685n.m(t10, 0.0f, 1.0f);
        return fM * fM * (3.0f - (fM * 2.0f));
    }
}
