package com.obric.utils;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.core.graphics.ColorUtils;
import androidx.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewAnimationUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/utils/ViewAnimationUtils$hidePageAnimationWithBGAlpha$1$1", "Landroidx/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroidx/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewAnimationUtils$hidePageAnimationWithBGAlpha$1$1 implements Transition.TransitionListener {
    final /* synthetic */ Function0<Unit> $animaEndAction;
    final /* synthetic */ int $fromColor;
    final /* synthetic */ ViewGroup $layoutView;

    public static /* synthetic */ void $r8$lambda$E8DqyfxIbcezEIXjWnTYSDJiT8I(int r0, int r1, ViewGroup r2, ValueAnimator r3) {
        onTransitionStart$lambda$0(r0, r1, r2, r3);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r1) {
        Intrinsics.checkNotNullParameter(r1, "transition");
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r1) {
        Intrinsics.checkNotNullParameter(r1, "transition");
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r1) {
        Intrinsics.checkNotNullParameter(r1, "transition");
    }

    ViewAnimationUtils$hidePageAnimationWithBGAlpha$1$1(Function0<Unit> r1, int r2, ViewGroup r3) {
        this.$animaEndAction = r1;
        this.$fromColor = r2;
        this.$layoutView = r3;
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        this.$animaEndAction.invoke();
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r4) {
        Intrinsics.checkNotNullParameter(r4, "transition");
        final int r5 = ColorUtils.setAlphaComponent(this.$fromColor, 0);
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(441);
        r0.setInterpolator(new SmoothInterpolator());
        final int r1 = this.$fromColor;
        final ViewGroup r3 = this.$layoutView;
        r0.addUpdateListener(new ViewAnimationUtils$hidePageAnimationWithBGAlpha$1$1$$ExternalSyntheticLambda0(r1, r5, r3));
        r0.start();
    }

    private static final void onTransitionStart$lambda$0(int r1, int r2, ViewGroup r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        int r6 = ColorUtils.blendARGB(r1, r2, ((Float) r5).floatValue());
        if (r6 != 0) goto L5;
        r6 = 0;
    L5:
        if (r3 == null) goto L8;
        r3.setBackgroundColor(r6);
        return;
    }
}
