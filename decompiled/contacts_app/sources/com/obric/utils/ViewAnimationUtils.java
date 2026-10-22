package com.obric.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewAnimationUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ0\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ(\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ\"\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lcom/obric/utils/ViewAnimationUtils;", "", "()V", "hidePageAnimation", "", "layoutView", "Landroid/view/ViewGroup;", "centerView", "Landroid/view/View;", "animaEndAction", "Lkotlin/Function0;", "hidePageAnimationWithBGAlpha", "fromColor", "", "showPageAnimation", "showPageAnimationWithBGAlpha", "targetColor", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewAnimationUtils {
    public static final ViewAnimationUtils INSTANCE = null;

    public static /* synthetic */ void $r8$lambda$AeOrJx665ZxS1hujCYx7hL7aaxc(View r0, ViewGroup r1, Function0 r2) {
        hidePageAnimation$lambda$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$FFnQUg-Hq2iKx1Tq1boy11zA_XA, reason: not valid java name */
    public static /* synthetic */ void m781$r8$lambda$FFnQUgHq2iKx1Tq1boy11zA_XA(View r0, ViewGroup r1, Function0 r2) {
        showPageAnimation$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$KDpd2P02W0aFFQmteFoxe4UEOxk(View r0, ViewGroup r1, int r2) {
        showPageAnimationWithBGAlpha$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$cvUR0QkSIemEhp0B2i-t2Kd7ZJM, reason: not valid java name */
    public static /* synthetic */ void m782$r8$lambda$cvUR0QkSIemEhp0B2it2Kd7ZJM(View r0, ViewGroup r1, Function0 r2, int r3) {
        hidePageAnimationWithBGAlpha$lambda$7(r0, r1, r2, r3);
    }

    static {
        INSTANCE = new ViewAnimationUtils();
    }

    private ViewAnimationUtils() {
    }

    public final void showPageAnimation(final ViewGroup r1, final View r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "animaEndAction");
        if (r2 == null) goto L6;
        r2.post(new ViewAnimationUtils$$ExternalSyntheticLambda3(r2, r1, r3));
        return;
    }

    public final void hidePageAnimation(final ViewGroup r1, final View r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "animaEndAction");
        if (r2 == null) goto L6;
        r2.post(new ViewAnimationUtils$$ExternalSyntheticLambda0(r2, r1, r3));
        return;
    }

    private static final void hidePageAnimation$lambda$3(View r4, final ViewGroup r5, final Function0 r6) {
        Intrinsics.checkNotNullParameter(r6, "$animaEndAction");
        Slide r0 = new Slide(80);
        r0.setDuration(300);
        Fade r1 = new Fade();
        r1.setDuration(100);
        TransitionSet r2 = new TransitionSet();
        r2.addTransition(r0);
        r2.addTransition(r1);
        r2.addTarget(r4);
        r2.addListener(new ViewAnimationUtils$hidePageAnimation$1$1(r5, r6));
        if (r5 == null) goto L6;
        TransitionManager.beginDelayedTransition(r5, r2);
        r4.setVisibility(8);
        return;
    }

    public final void showPageAnimationWithBGAlpha(final ViewGroup r1, final View r2, final int r3) {
        if (r2 == null) goto L5;
        r2.post(new ViewAnimationUtils$$ExternalSyntheticLambda2(r2, r1, r3));
        return;
    }

    public final void hidePageAnimationWithBGAlpha(final ViewGroup r1, final View r2, final int r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "animaEndAction");
        if (r2 == null) goto L6;
        r2.post(new ViewAnimationUtils$$ExternalSyntheticLambda1(r2, r1, r4, r3));
        return;
    }

    private static final void hidePageAnimationWithBGAlpha$lambda$7(View r3, ViewGroup r4, Function0 r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "$animaEndAction");
        Slide r0 = new Slide(80);
        r0.setDuration(441);
        TransitionSet r1 = new TransitionSet();
        r1.addTransition(r0);
        r1.addTarget(r3);
        r1.setInterpolator(new SmoothInterpolator());
        r1.addListener(new ViewAnimationUtils$hidePageAnimationWithBGAlpha$1$1(r5, r6, r4));
        if (r4 == null) goto L6;
        TransitionManager.beginDelayedTransition(r4, r1);
        r3.setVisibility(8);
        return;
    }

    private static final void showPageAnimation$lambda$1(View r4, ViewGroup r5, final Function0 r6) {
        Intrinsics.checkNotNullParameter(r6, "$animaEndAction");
        r4.setVisibility(8);
        Slide r0 = new Slide(80);
        r0.setDuration(300);
        Fade r1 = new Fade();
        r1.setDuration(100);
        TransitionSet r2 = new TransitionSet();
        r2.addTransition(r0);
        r2.addTransition(r1);
        r2.addTarget(r4);
        if (r5 == null) goto L5;
        TransitionManager.beginDelayedTransition(r5, r2);
        r4.setVisibility(0);
    L5:
        r2.addListener(new ViewAnimationUtils$showPageAnimation$1$2(r6));
    }

    private static final void showPageAnimationWithBGAlpha$lambda$5(View r3, ViewGroup r4, int r5) {
        r3.setVisibility(8);
        Slide r0 = new Slide(80);
        r0.setDuration(515);
        TransitionSet r1 = new TransitionSet();
        r1.addTransition(r0);
        r1.addTarget(r3);
        r1.setInterpolator(new SmoothInterpolator());
        r1.addListener(new ViewAnimationUtils$showPageAnimationWithBGAlpha$1$1(r5, r4));
        if (r4 == null) goto L6;
        TransitionManager.beginDelayedTransition(r4, r1);
        r3.setVisibility(0);
        return;
    }
}
