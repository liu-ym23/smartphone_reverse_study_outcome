package com.stepos.widget.internal;

import Y8.t;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import r9.C5227b;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0003JK\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/widget/internal/TabIndicatorMover;", "", "<init>", "()V", "LY8/t;", "cancel$StepOSWidget_release", "cancel", "Landroid/graphics/Rect;", "currentBounds", "target", "", "hadBounds", "animate", "", "durationMs", "Lkotlin/Function1;", "onFrame", "move$StepOSWidget_release", "(Landroid/graphics/Rect;Landroid/graphics/Rect;ZZILp9/l;)V", com.stepos.ailauncher.container.wallpaper.a.PHASE_MOVE, "from", "Landroid/graphics/Rect;", "to", "current", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TabIndicatorMover {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Interpolator INTERPOLATOR = new PathInterpolator(0.0f, 0.33f, 0.0f, 0.33f);
    private ValueAnimator animator;
    private final Rect from = new Rect();
    private final Rect to = new Rect();
    private final Rect current = new Rect();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/stepos/widget/internal/TabIndicatorMover$Companion;", "", "<init>", "()V", "INTERPOLATOR", "Landroid/view/animation/Interpolator;", "getINTERPOLATOR$StepOSWidget_release", "()Landroid/view/animation/Interpolator;", "lerp", "", "from", "to", "fraction", "", "lerp$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Interpolator getINTERPOLATOR$StepOSWidget_release() {
            return TabIndicatorMover.INTERPOLATOR;
        }

        public final int lerp$StepOSWidget_release(int from, int to, float fraction) {
            return from + C5227b.b((to - from) * fraction);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void move$lambda$1$lambda$0(TabIndicatorMover tabIndicatorMover, Rect rect, InterfaceC5074l interfaceC5074l, ValueAnimator animator) {
        p.i(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        Rect rect2 = tabIndicatorMover.current;
        Companion companion = INSTANCE;
        rect2.set(companion.lerp$StepOSWidget_release(tabIndicatorMover.from.left, tabIndicatorMover.to.left, fFloatValue), companion.lerp$StepOSWidget_release(tabIndicatorMover.from.top, tabIndicatorMover.to.top, fFloatValue), companion.lerp$StepOSWidget_release(tabIndicatorMover.from.right, tabIndicatorMover.to.right, fFloatValue), companion.lerp$StepOSWidget_release(tabIndicatorMover.from.bottom, tabIndicatorMover.to.bottom, fFloatValue));
        rect.set(tabIndicatorMover.current);
        interfaceC5074l.invoke(tabIndicatorMover.current);
    }

    public final void cancel$StepOSWidget_release() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }

    public final void move$StepOSWidget_release(final Rect currentBounds, Rect target, boolean hadBounds, boolean animate, int durationMs, final InterfaceC5074l<? super Rect, t> onFrame) {
        p.i(currentBounds, "currentBounds");
        p.i(target, "target");
        p.i(onFrame, "onFrame");
        cancel$StepOSWidget_release();
        this.to.set(target);
        this.from.set(currentBounds);
        if (!animate || durationMs <= 0 || !hadBounds || p.d(this.from, this.to)) {
            currentBounds.set(this.to);
            onFrame.invoke(this.to);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(durationMs);
        valueAnimatorOfFloat.setInterpolator(INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.internal.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TabIndicatorMover.move$lambda$1$lambda$0(this.f31259a, currentBounds, onFrame, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }
}
