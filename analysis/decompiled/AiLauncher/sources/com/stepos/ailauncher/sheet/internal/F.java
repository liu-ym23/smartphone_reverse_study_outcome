package com.stepos.ailauncher.sheet.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Outline;
import android.graphics.RectF;
import android.provider.Settings;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/F;", "", "<init>", "()V", "Landroid/view/View;", "clipContainer", "panel", "Landroid/graphics/RectF;", "panelRect", "barRect", "", "panelCornerPx", "", "durationMs", "Lkotlin/Function1;", "LY8/t;", "onProgress", "Lkotlin/Function0;", "onEnd", "Landroid/animation/Animator;", "e", "(Landroid/view/View;Landroid/view/View;Landroid/graphics/RectF;Landroid/graphics/RectF;FJLp9/l;Lp9/a;)Landroid/animation/Animator;", "time", "durationRatio", "c", "(FF)F", "from", "to", "t", Const.INTENT_KEY_UMID, "(FFF)F", "Landroid/view/animation/PathInterpolator;", "MORPH_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "Y_AXIS_DURATION_RATIO", "F", "DEFAULT_DURATION_MS", "J", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F {
    private static final long DEFAULT_DURATION_MS = 400;
    public static final F INSTANCE = new F();
    private static final PathInterpolator MORPH_INTERPOLATOR = new PathInterpolator(0.22f, 1.0f, 0.36f, 1.0f);
    private static final float Y_AXIS_DURATION_RATIO = 0.6f;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sheet/internal/F$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ Ref$FloatRef $clipRadius;
        final /* synthetic */ RectF $clipRect;

        public a(RectF rectF, Ref$FloatRef ref$FloatRef) {
            this.$clipRect = rectF;
            this.$clipRadius = ref$FloatRef;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(C5227b.b(this.$clipRect.left), C5227b.b(this.$clipRect.top), C5227b.b(this.$clipRect.right), C5227b.b(this.$clipRect.bottom), this.$clipRadius.f34817a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/sheet/internal/F$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ View $clipContainer;
        final /* synthetic */ Ref$BooleanRef $ended;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onEnd;
        final /* synthetic */ InterfaceC5074l<Float, Y8.t> $onProgress;
        final /* synthetic */ View $panel;
        final /* synthetic */ int $savedClipLayerType;
        final /* synthetic */ int $savedPanelLayerType;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Ref$BooleanRef ref$BooleanRef, View view, int i10, View view2, int i11, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$ended = ref$BooleanRef;
            this.$clipContainer = view;
            this.$savedClipLayerType = i10;
            this.$panel = view2;
            this.$savedPanelLayerType = i11;
            this.$onProgress = interfaceC5074l;
            this.$onEnd = interfaceC5063a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            F.g(this.$ended, this.$clipContainer, this.$savedClipLayerType, this.$panel, this.$savedPanelLayerType, this.$onProgress, this.$onEnd);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            F.g(this.$ended, this.$clipContainer, this.$savedClipLayerType, this.$panel, this.$savedPanelLayerType, this.$onProgress, this.$onEnd);
        }
    }

    public static final void f(RectF rectF, RectF rectF2, RectF rectF3, Ref$FloatRef ref$FloatRef, float f10, float f11, View view, View view2, float f12, float f13) {
        F f14 = INSTANCE;
        rectF.set(f14.d(rectF2.left, rectF3.left, f12), f14.d(rectF2.top, rectF3.top, f13), f14.d(rectF2.right, rectF3.right, f12), f14.d(rectF2.bottom, rectF3.bottom, f13));
        ref$FloatRef.f34817a = f14.d(f10, f11, f13);
        view.invalidateOutline();
        view2.setScaleX(rectF.width() / Math.max(1.0f, rectF3.width()));
        view2.setScaleY(rectF.height() / Math.max(1.0f, rectF3.height()));
        view2.setTranslationX(rectF.left);
        view2.setTranslationY(rectF.top);
    }

    public static final void g(Ref$BooleanRef ref$BooleanRef, View view, int i10, View view2, int i11, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        view.setLayerType(i10, null);
        view2.setLayerType(i11, null);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void i(InterfaceC5074l interfaceC5074l, RectF rectF, RectF rectF2, RectF rectF3, Ref$FloatRef ref$FloatRef, float f10, float f11, View view, View view2, ValueAnimator anim) {
        kotlin.jvm.internal.p.i(anim, "anim");
        float animatedFraction = anim.getAnimatedFraction();
        F f12 = INSTANCE;
        f(rectF, rectF2, rectF3, ref$FloatRef, f10, f11, view, view2, 1.0f - f12.c(animatedFraction, 1.0f), 1.0f - f12.c(animatedFraction, 0.6f));
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(animatedFraction));
        }
    }

    public final float c(float time, float durationRatio) {
        return MORPH_INTERPOLATOR.getInterpolation(C5685n.i(time / durationRatio, 1.0f));
    }

    public final float d(float from, float to, float t10) {
        return from + ((to - from) * t10);
    }

    public final Animator e(final View clipContainer, final View panel, final RectF panelRect, final RectF barRect, final float panelCornerPx, long durationMs, final InterfaceC5074l<? super Float, Y8.t> onProgress, InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(clipContainer, "clipContainer");
        kotlin.jvm.internal.p.i(panel, "panel");
        kotlin.jvm.internal.p.i(panelRect, "panelRect");
        kotlin.jvm.internal.p.i(barRect, "barRect");
        panel.setClipToOutline(false);
        panel.setElevation(0.0f);
        panel.setPivotX(0.0f);
        panel.setPivotY(0.0f);
        final RectF rectF = new RectF(panelRect);
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.f34817a = panelCornerPx;
        clipContainer.setOutlineProvider(new a(rectF, ref$FloatRef));
        clipContainer.setClipToOutline(true);
        final float fHeight = barRect.height() / 2.0f;
        if (Settings.Global.getFloat(clipContainer.getContext().getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
            f(rectF, barRect, panelRect, ref$FloatRef, fHeight, panelCornerPx, clipContainer, panel, 0.0f, 0.0f);
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
        int layerType = clipContainer.getLayerType();
        int layerType2 = panel.getLayerType();
        clipContainer.setLayerType(2, null);
        panel.setLayerType(2, null);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(durationMs);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.sheet.internal.E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                F.i(onProgress, rectF, barRect, panelRect, ref$FloatRef, fHeight, panelCornerPx, clipContainer, panel, valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b(ref$BooleanRef, clipContainer, layerType, panel, layerType2, onProgress, onEnd));
        valueAnimatorOfFloat2.start();
        kotlin.jvm.internal.p.h(valueAnimatorOfFloat2, "apply(...)");
        return valueAnimatorOfFloat2;
    }
}
