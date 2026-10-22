package com.obric.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEAAnim.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0018\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a)\u0010\u0011\u001a\u00020\u0012*\u00020\u00072\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0080\bø\u0001\u0000\u001a1\u0010\u0011\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0080\bø\u0001\u0000\u001a\r\u0010\u001a\u001a\u00020\u0016*\u00020\u0007H\u0080\b\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0000\u001a\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u0014\u0010 \u001a\u00020\u001f*\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u0014\u0010!\u001a\u00020\u001f*\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u0014\u0010\"\u001a\u00020\u001f*\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u0014\u0010#\u001a\u00020\u001f*\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u0014\u0010$\u001a\u00020\u001f*\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\f\u0010%\u001a\u00020\u0016*\u0004\u0018\u00010\u001d\u001a\u0014\u0010%\u001a\u00020\u0016*\u0004\u0018\u00010\u001d2\u0006\u0010&\u001a\u00020'\u001a\u001c\u0010(\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u001c\u0010+\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u001c\u0010+\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, d2 = {"ANIM_DURATION", "", "HIDE_DURATION", "SHOW_DURATION", "value", "Lcom/obric/anim/TransitionEx;", "runningTransition", "Landroid/view/ViewGroup;", "getRunningTransition", "(Landroid/view/ViewGroup;)Lcom/obric/anim/TransitionEx;", "setRunningTransition", "(Landroid/view/ViewGroup;Lcom/obric/anim/TransitionEx;)V", "customAnimator", "Landroid/animation/ValueAnimator;", "duration", "listener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animTransit", "", "block", "Lkotlin/Function1;", "Landroidx/transition/TransitionSet;", "", "Lkotlin/ExtensionFunctionType;", SimContactsConstants.STR_TAG, "", "cancelTransit", "center", "Landroid/graphics/PointF;", "Landroid/view/View;", "fadeHideAnimator", "Landroid/animation/Animator;", "fadeScaleHideAnimator", "fadeScaleShowAnimator", "fadeShowAnimator", "immediatelyHideAnimator", "immediatelyShowAnimator", "reset", "visibility", "", "scaleAnimator", "from", "", "transAnimator", "targetView", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OEAAnimKt {
    public static final long ANIM_DURATION = 300;
    public static final long HIDE_DURATION = 100;
    public static final long SHOW_DURATION = 200;

    public static /* synthetic */ void $r8$lambda$6XI4P4aOOeFbSMRTcSxgYg06BCc(View r0, PointF r1, ValueAnimator r2) {
        transAnimator$lambda$16$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$F8kH17r3coHenMWY6lv8slPnRzE(View r0, View r1, float[] r2, ValueAnimator r3) {
        transAnimator$lambda$19$lambda$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$IMAgQjWcLJOb4VOyuWlgVPTx8_Q(View r0, ValueAnimator r1) {
        fadeScaleShowAnimator$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JH1OhqPtYBStH_tX25Df_GkWUT8(View r0, ValueAnimator r1) {
        immediatelyShowAnimator$lambda$2$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OYWhxZ-cpUSnnHBEk2By6izKUsk, reason: not valid java name */
    public static /* synthetic */ void m327$r8$lambda$OYWhxZcpUSnnHBEk2By6izKUsk(View r0, ValueAnimator r1) {
        fadeHideAnimator$lambda$8$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$U4K-J5L1gl_slGXStWOnxZ-KkcM, reason: not valid java name */
    public static /* synthetic */ void m328$r8$lambda$U4KJ5L1gl_slGXStWOnxZKkcM(View r0, ValueAnimator r1) {
        fadeShowAnimator$lambda$6$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$VQYfpZs2ZtQXRMOkP-2nKN-CmNs, reason: not valid java name */
    public static /* synthetic */ void m329$r8$lambda$VQYfpZs2ZtQXRMOkP2nKNCmNs(float r0, View r1, ValueAnimator r2) {
        scaleAnimator$lambda$14$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$diHEkvpWf1ZRTl6Yw53sSdA6dlc(View r0, ValueAnimator r1) {
        fadeScaleHideAnimator$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$h40iZJGhgL12Kr9pfHkHtLpiYsM(View r0, ValueAnimator r1) {
        immediatelyHideAnimator$lambda$4$lambda$3(r0, r1);
    }

    public static final /* synthetic */ void access$setRunningTransition(ViewGroup r0, TransitionEx r1) {
        setRunningTransition(r0, r1);
    }

    public static final TransitionEx getRunningTransition(ViewGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r2 = r1.getTag(R.id.custom_transit_running);
        if ((r2 instanceof TransitionEx) == true) goto L7;
        return null;
    L7:
        return (TransitionEx) r2;
    }

    private static final void setRunningTransition(ViewGroup r1, TransitionEx r2) {
        r1.setTag(R.id.custom_transit_running, r2);
    }

    public static final void cancelTransit(ViewGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        TransitionManager.endTransitions(r1);
    }

    public static final boolean animTransit(ViewGroup r4, String r5, Function1<? super TransitionSet, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r6, "block");
        if (r5.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        TransitionEx r1 = getRunningTransition(r4);
        if (r1 == null) goto L10;
        String r2 = r1.getTag();
    L12:
        if (Intrinsics.areEqual(r5, r2) == false) goto L14;
        return false;
    L10:
        r2 = null;
    L14:
        TransitionManager.endTransitions(r4);
        TransitionSet r3 = new TransitionSet();
        r3.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        r6.invoke(r3);
        TransitionSet r7 = r3;
        access$setRunningTransition(r4, new TransitionEx(r5, r7));
        r3.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r4)));
        TransitionManager.beginDelayedTransition(r4, r7);
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public static final PointF center(View r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new PointF(r4.getLeft() + (r4.getWidth() / 2.0f), r4.getTop() + (r4.getHeight() / 2.0f));
    }

    public static /* synthetic */ Animator immediatelyShowAnimator$default(View r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 200;
    L6:
        return immediatelyShowAnimator(r0, r1);
    }

    public static final Animator immediatelyShowAnimator(final View r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda2(r3));
        r0.setDuration(r4);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(1f).apply {\n    …duration = duration\n    }");
        return r0;
    }

    private static final void immediatelyShowAnimator$lambda$2$lambda$1(View r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_immediatelyShowAnimator");
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.setAlpha(1.0f);
    }

    public static /* synthetic */ Animator immediatelyHideAnimator$default(View r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 100;
    L6:
        return immediatelyHideAnimator(r0, r1);
    }

    public static final Animator immediatelyHideAnimator(final View r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda4(r3));
        r0.setDuration(r4);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(0f).apply {\n    …duration = duration\n    }");
        return r0;
    }

    private static final void immediatelyHideAnimator$lambda$4$lambda$3(View r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_immediatelyHideAnimator");
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.setAlpha(0.0f);
    }

    public static /* synthetic */ Animator fadeShowAnimator$default(View r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 200;
    L6:
        return fadeShowAnimator(r0, r1);
    }

    public static final Animator fadeShowAnimator(final View r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda7(r2));
        r0.setDuration(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(0f, 1f).apply {\n…duration = duration\n    }");
        return r0;
    }

    private static final void fadeShowAnimator$lambda$6$lambda$5(View r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_fadeShowAnimator");
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
        r1.setAlpha(((Float) r3).floatValue());
    }

    public static /* synthetic */ Animator fadeHideAnimator$default(View r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 100;
    L6:
        return fadeHideAnimator(r0, r1);
    }

    public static final Animator fadeHideAnimator(final View r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda6(r2));
        r0.setDuration(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(1f, 0f).apply {\n…duration = duration\n    }");
        return r0;
    }

    private static final void fadeHideAnimator$lambda$8$lambda$7(View r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_fadeHideAnimator");
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
        r1.setAlpha(((Float) r3).floatValue());
    }

    public static /* synthetic */ Animator fadeScaleShowAnimator$default(View r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 200;
    L6:
        return fadeScaleShowAnimator(r0, r1);
    }

    public static final Animator fadeScaleShowAnimator(final View r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.88f, 1.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda0(r2));
        r0.setDuration(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(0.88f, 1f).apply…duration = duration\n    }");
        return r0;
    }

    private static final void fadeScaleShowAnimator$lambda$10$lambda$9(View r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "$this_fadeScaleShowAnimator");
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.setAlpha(r3.getAnimatedFraction());
        Object r0 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
        r2.setScaleX(((Float) r0).floatValue());
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setScaleY(((Float) r4).floatValue());
    }

    public static /* synthetic */ Animator fadeScaleHideAnimator$default(View r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 100;
    L6:
        return fadeScaleHideAnimator(r0, r1);
    }

    public static final Animator fadeScaleHideAnimator(final View r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.88f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda1(r2));
        r0.setDuration(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(1f, 0.88f).apply…duration = duration\n    }");
        return r0;
    }

    private static final void fadeScaleHideAnimator$lambda$12$lambda$11(View r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "$this_fadeScaleHideAnimator");
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.setAlpha(1.0f - r3.getAnimatedFraction());
        Object r0 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
        r2.setScaleX(((Float) r0).floatValue());
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setScaleY(((Float) r4).floatValue());
    }

    public static /* synthetic */ Animator scaleAnimator$default(View r0, float r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 300;
    L6:
        return scaleAnimator(r0, r1, r2);
    }

    public static final Animator scaleAnimator(final View r3, final float r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{r4, 1.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda5(r4, r3));
        r0.setDuration(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(from, 1f).apply …duration = duration\n    }");
        return r0;
    }

    private static final void scaleAnimator$lambda$14$lambda$13(float r1, View r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "$this_scaleAnimator");
        Intrinsics.checkNotNullParameter(r3, "it");
        float r4 = r1 + ((1.0f - r1) * r3.getAnimatedFraction());
        r2.setScaleX(r4);
        r2.setScaleY(r4);
    }

    public static /* synthetic */ Animator transAnimator$default(View r0, PointF r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 300;
    L6:
        return transAnimator(r0, r1, r2);
    }

    public static final Animator transAnimator(final View r3, final PointF r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "from");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f});
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda3(r3, r4));
        r0.setDuration(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(1f).apply {\n    …duration = duration\n    }");
        return r0;
    }

    private static final void transAnimator$lambda$16$lambda$15(View r3, PointF r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r3, "$this_transAnimator");
        Intrinsics.checkNotNullParameter(r4, "$from");
        Intrinsics.checkNotNullParameter(r5, "it");
        float r6 = r5.getAnimatedFraction();
        int r0 = r3.getLeft() + (r3.getWidth() / 2);
        int r1 = r3.getTop() + (r3.getHeight() / 2);
        float r2 = r4.x - r0;
        float r7 = r4.y - r1;
        float r8 = 1 - r6;
        r3.setTranslationX(r2 * r8);
        r3.setTranslationY(r7 * r8);
    }

    public static /* synthetic */ Animator transAnimator$default(View r0, View r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 300;
    L6:
        return transAnimator(r0, r1, r2);
    }

    public static final Animator transAnimator(final View r3, final View r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f});
        final float[] r1 = new float[3];
        r0.addUpdateListener(new OEAAnimKt$$ExternalSyntheticLambda8(r3, r4, r1));
        r0.setDuration(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(1f).apply {\n    …duration = duration\n    }");
        return r0;
    }

    private static final void transAnimator$lambda$19$lambda$18(View r6, View r7, float[] r8, ValueAnimator r9) {
        Intrinsics.checkNotNullParameter(r6, "$this_transAnimator");
        Intrinsics.checkNotNullParameter(r7, "$targetView");
        Intrinsics.checkNotNullParameter(r8, "$from");
        Intrinsics.checkNotNullParameter(r9, "it");
        float r10 = r9.getAnimatedFraction();
        if (r10 != 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L13;
        PointF r1 = center(r7);
        r8[0] = r1.x;
        r8[1] = r1.y;
        if (r6.getWidth() == 0) goto L11;
        float r11 = r7.getWidth() / r6.getWidth();
    L12:
        r8[2] = r11;
        goto L13
    L11:
        r11 = 1.0f;
    L13:
        int r12 = r6.getLeft() + (r6.getWidth() / 2);
        int r2 = r6.getTop() + (r6.getHeight() / 2);
        float r3 = r8[0] - r12;
        float r13 = r8[1] - r2;
        float r14 = r8[2] - 1.0f;
        float r4 = 1;
        float r15 = r4 - r10;
        r6.setTranslationX(r3 * r15);
        r6.setTranslationY(r13 * r15);
        float r5 = r4 + (r14 * r15);
        r6.setScaleX(r5);
        r6.setScaleY(r5);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public static final void reset(View r0, int r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setVisibility(r1);
        reset(r0);
    }

    public static final void reset(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setTranslationX(0.0f);
        r1.setTranslationY(0.0f);
        r1.setScaleX(1.0f);
        r1.setScaleY(1.0f);
        r1.setAlpha(1.0f);
    }

    public static /* synthetic */ ValueAnimator customAnimator$default(long r0, ValueAnimator.AnimatorUpdateListener r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = 300;
    L6:
        return customAnimator(r0, r2);
    }

    public static final ValueAnimator customAnimator(long r3, ValueAnimator.AnimatorUpdateListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f});
        r0.addUpdateListener(r5);
        r0.setDuration(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "ofFloat(1f).apply {\n    …duration = duration\n    }");
        return r0;
    }

    public static final boolean animTransit(ViewGroup r5, Function1<? super TransitionSet, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "block");
        if ("".length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        TransitionEx r2 = getRunningTransition(r5);
        if (r2 == null) goto L10;
        String r3 = r2.getTag();
    L12:
        if (Intrinsics.areEqual("", r3) == false) goto L14;
        return false;
    L10:
        r3 = null;
    L14:
        TransitionManager.endTransitions(r5);
        TransitionSet r4 = new TransitionSet();
        r4.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        r6.invoke(r4);
        TransitionSet r7 = r4;
        access$setRunningTransition(r5, new TransitionEx("", r7));
        r4.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r5)));
        TransitionManager.beginDelayedTransition(r5, r7);
        return true;
    L5:
        r1 = false;
        goto L6
    }
}
