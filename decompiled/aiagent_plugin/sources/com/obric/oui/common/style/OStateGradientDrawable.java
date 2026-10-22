package com.obric.oui.common.style;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.StateSet;
import android.view.animation.LinearInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OStateGradientDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OStateGradientDrawable extends GradientDrawable {
    public static final a Companion = null;
    private static final int[] STATE_CHECKED = null;
    private static final int[] STATE_DISABLED = null;
    private static final int[] STATE_HOVERED = null;
    private static final int[] STATE_NORMAL = null;
    private static final int[] STATE_PRESSED = null;
    private static final int[] STATE_SELECTED = null;
    private long animDuration;
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private int checkedSolidColor;
    private int checkedStrokeColor;
    private ValueAnimator colorAnimator;
    private int disabledSolidColor;
    private int disabledStrokeColor;
    private int hoverSolidColor;
    private int hoverStrokeColor;
    private int normalSolidColor;
    private int normalStrokeColor;
    private int pressedSolidColor;
    private int pressedStrokeColor;
    private int selectedSolidColor;
    private int selectedStrokeColor;
    private ValueAnimator strokeAnimator;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;

    /* JADX INFO: compiled from: OStateGradientDrawable.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ void lambda$8TrupzsaIO3Lpqgi4W2KueQ2vFc(OStateGradientDrawable r0, ValueAnimator r1) {
        m996updateSolidColor$lambda1$lambda0(r0, r1);
    }

    public static /* synthetic */ void lambda$jUbM_kLgHDYtgh1KNL0qpWkkJSw(OStateGradientDrawable r0, ValueAnimator r1) {
        m997updateStrokeColor$lambda3$lambda2(r0, r1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public OStateGradientDrawable() {
        this.animDuration = com.obric.common.oea.foundation.animation.h.e.c.f32439b.a();
        this.animInterpolator = new LinearInterpolator();
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final void setAnimDuration(long r1) {
        this.animDuration = r1;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    public final void setAnimInterpolator(LinearInterpolator r2) {
        o.e(r2, "<set-?>");
        this.animInterpolator = r2;
    }

    static {
        Companion = new a(null);
        STATE_PRESSED = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        STATE_SELECTED = new int[]{R.attr.state_selected, R.attr.state_enabled};
        STATE_CHECKED = new int[]{R.attr.state_checked, R.attr.state_enabled};
        STATE_HOVERED = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        STATE_DISABLED = new int[]{-16842910};
        STATE_NORMAL = new int[]{R.attr.state_enabled};
    }

    public static /* synthetic */ void setSolidColors$default(OStateGradientDrawable r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        int r2 = r8;
    L7:
        if ((r14 & 4) == 0) goto L9;
        int r3 = r8;
    L11:
        if ((r14 & 8) == 0) goto L13;
        int r4 = r8;
    L15:
        if ((r14 & 16) == 0) goto L17;
        int r5 = r8;
    L19:
        if ((r14 & 32) == 0) goto L21;
        int r6 = r8;
    L22:
        r7.setSolidColors(r8, r2, r3, r4, r5, r6);
        return;
    L21:
        r6 = r13;
        goto L22
    L17:
        r5 = r12;
        goto L19
    L13:
        r4 = r11;
        goto L15
    L9:
        r3 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public final void setSolidColors(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.normalSolidColor = r1;
        this.pressedSolidColor = r2;
        this.selectedSolidColor = r3;
        this.checkedSolidColor = r4;
        this.hoverSolidColor = r5;
        this.disabledSolidColor = r6;
        this.targetSolidColor = r1;
        this.animatedSolidColor = r1;
        ValueAnimator r7 = this.colorAnimator;
        if (r7 == null) goto L6;
        r7.cancel();
    L6:
        setColor(r1);
    }

    public final void setSolidColors(ColorStateList r10) {
        o.e(r10, "colorStateList");
        int r3 = r10.getColorForState(STATE_NORMAL, r10.getDefaultColor());
        int r4 = r10.getColorForState(STATE_PRESSED, r3);
        setSolidColors(r3, r4, r10.getColorForState(STATE_SELECTED, r3), r10.getColorForState(STATE_CHECKED, r3), r10.getColorForState(STATE_HOVERED, r4), r10.getColorForState(STATE_DISABLED, r3));
    }

    public static /* synthetic */ void setStrokeConfigs$default(OStateGradientDrawable r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        int r4 = r11;
    L7:
        if ((r17 & 8) == 0) goto L9;
        int r5 = r11;
    L11:
        if ((r17 & 16) == 0) goto L13;
        int r6 = r11;
    L15:
        if ((r17 & 32) == 0) goto L17;
        int r7 = r11;
    L19:
        if ((r17 & 64) == 0) goto L21;
        int r8 = r11;
    L22:
        r9.setStrokeConfigs(r10, r11, r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = r16;
        goto L22
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public final void setStrokeConfigs(int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        this.strokeWidth = r1;
        this.normalStrokeColor = r2;
        this.pressedStrokeColor = r3;
        this.selectedStrokeColor = r4;
        this.checkedStrokeColor = r5;
        this.hoverStrokeColor = r6;
        this.disabledStrokeColor = r7;
        this.targetStrokeColor = r2;
        this.animatedStrokeColor = r2;
        ValueAnimator r8 = this.strokeAnimator;
        if (r8 == null) goto L6;
        r8.cancel();
    L6:
        setStroke(r1, r2);
    }

    public final void setStrokeConfigs(int r11, ColorStateList r12) {
        o.e(r12, "colorStateList");
        int r4 = r12.getColorForState(STATE_NORMAL, r12.getDefaultColor());
        setStrokeConfigs(r11, r4, r12.getColorForState(STATE_PRESSED, r4), r12.getColorForState(STATE_SELECTED, r4), r12.getColorForState(STATE_CHECKED, r4), r12.getColorForState(STATE_HOVERED, r4), r12.getColorForState(STATE_DISABLED, r4));
    }

    public final void endAnimation() {
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L6;
        r0.end();
    L6:
        this.colorAnimator = null;
        ValueAnimator r1 = this.strokeAnimator;
        if (r1 == null) goto L10;
        r1.end();
    L10:
        this.strokeAnimator = null;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r11) {
        o.e(r11, "stateSet");
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r11) == true) goto L6;
        int r1 = this.disabledSolidColor;
    L18:
        int r8 = this.targetSolidColor;
        if (r1 == r8) goto L26;
        int r9 = this.normalSolidColor;
        if (r1 != r9) goto L24;
        if (r8 == r9) goto L24;
        boolean r10 = true;
    L25:
        updateSolidColor(r1, r10);
        this.targetSolidColor = r1;
        boolean r2 = true;
    L28:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r11) == true) goto L31;
        int r3 = this.disabledStrokeColor;
    L43:
        int r4 = this.targetStrokeColor;
        if (r3 == r4) goto L51;
        int r5 = this.normalStrokeColor;
        if (r3 != r5) goto L49;
        if (r4 == r5) goto L49;
        boolean r6 = true;
    L50:
        updateStrokeColor(r3, r6);
        this.targetStrokeColor = r3;
        r2 = true;
    L49:
        r6 = false;
    L51:
        if (r2 == false) goto L53;
        return true;
    L53:
        if (super.onStateChange(r11) == false) goto L56;
        return true;
    L56:
        return false;
    L31:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r11) == false) goto L34;
        r3 = this.pressedStrokeColor;
        goto L43
    L34:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r11) == false) goto L37;
        r3 = this.selectedStrokeColor;
        goto L43
    L37:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r11) == false) goto L40;
        r3 = this.checkedStrokeColor;
        goto L43
    L40:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r11) == false) goto L42;
        r3 = this.hoverStrokeColor;
        goto L43
    L42:
        r3 = this.normalStrokeColor;
    L24:
        r10 = false;
        goto L25
    L26:
        r2 = false;
        goto L28
    L6:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r11) == false) goto L9;
        r1 = this.pressedSolidColor;
        goto L18
    L9:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r11) == false) goto L12;
        r1 = this.selectedSolidColor;
        goto L18
    L12:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r11) == false) goto L15;
        r1 = this.checkedSolidColor;
        goto L18
    L15:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r11) == false) goto L17;
        r1 = this.hoverSolidColor;
        goto L18
    L17:
        r1 = this.normalSolidColor;
        goto L18
    }

    private final void updateSolidColor(int r5, boolean r6) {
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r6 == false) goto L8;
        int r7 = this.animatedSolidColor;
        ValueAnimator r8 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new ArgbEvaluator(), TypeEvaluator.class, "com.obric.aiagent.plugin"), new Object[]{Integer.valueOf(r7), Integer.valueOf(r5)});
        r8.setDuration(getAnimDuration());
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r8.addUpdateListener(new $$Lambda$OStateGradientDrawable$8TrupzsaIO3Lpqgi4W2KueQ2vFc(this));
        r8.start();
        this.colorAnimator = r8;
        return;
    L8:
        this.colorAnimator = null;
        this.animatedSolidColor = r5;
        setColor(r5);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-1$lambda-0, reason: not valid java name */
    private static final void m996updateSolidColor$lambda1$lambda0(OStateGradientDrawable r2, ValueAnimator r3) {
        o.e(r2, "this$0");
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Int");
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.animatedSolidColor = r5;
        r2.setColor(r5);
    }

    private final void updateStrokeColor(int r5, boolean r6) {
        ValueAnimator r0 = this.strokeAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r6 == false) goto L8;
        int r7 = this.animatedStrokeColor;
        ValueAnimator r8 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new ArgbEvaluator(), TypeEvaluator.class, "com.obric.aiagent.plugin"), new Object[]{Integer.valueOf(r7), Integer.valueOf(r5)});
        r8.setDuration(getAnimDuration());
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r8.addUpdateListener(new $$Lambda$OStateGradientDrawable$jUbM_kLgHDYtgh1KNL0qpWkkJSw(this));
        r8.start();
        this.strokeAnimator = r8;
        return;
    L8:
        this.strokeAnimator = null;
        this.animatedStrokeColor = r5;
        setStroke(this.strokeWidth, r5);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-3$lambda-2, reason: not valid java name */
    private static final void m997updateStrokeColor$lambda3$lambda2(OStateGradientDrawable r2, ValueAnimator r3) {
        o.e(r2, "this$0");
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Int");
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.animatedStrokeColor = r5;
        r2.setStroke(r2.strokeWidth, r5);
    }
}
