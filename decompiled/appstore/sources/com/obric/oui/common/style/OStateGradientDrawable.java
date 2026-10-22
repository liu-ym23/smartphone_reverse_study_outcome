package com.obric.oui.common.style;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.StateSet;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJG\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016JO\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010#R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010#R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010#R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010#R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010#R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010#R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010#R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010#R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/obric/oui/common/style/OStateGradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "<init>", "()V", "", "toColor", "", "animate", "", "updateSolidColor", "(IZ)V", "updateStrokeColor", "normal", "pressed", "selected", CommonConfirmDialog.ARGS_CHECKED, "hover", "disabled", "setSolidColors", "(IIIIII)V", "Landroid/content/res/ColorStateList;", "colorStateList", "(Landroid/content/res/ColorStateList;)V", Style.KEY_WIDTH, "setStrokeConfigs", "(IIIIIII)V", "(ILandroid/content/res/ColorStateList;)V", "endAnimation", "isStateful", "()Z", "", "stateSet", "onStateChange", "([I)Z", "normalSolidColor", "I", "pressedSolidColor", "selectedSolidColor", "checkedSolidColor", "hoverSolidColor", "disabledSolidColor", "normalStrokeColor", "pressedStrokeColor", "selectedStrokeColor", "checkedStrokeColor", "hoverStrokeColor", "disabledStrokeColor", "strokeWidth", "targetSolidColor", "targetStrokeColor", "animatedSolidColor", "animatedStrokeColor", "Landroid/animation/ValueAnimator;", "colorAnimator", "Landroid/animation/ValueAnimator;", "strokeAnimator", "", "animDuration", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "Landroid/view/animation/LinearInterpolator;", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OStateGradientDrawable extends GradientDrawable {

    @NotNull
    public static final a Companion = null;

    @NotNull
    private static final int[] STATE_CHECKED = null;

    @NotNull
    private static final int[] STATE_DISABLED = null;

    @NotNull
    private static final int[] STATE_HOVERED = null;

    @NotNull
    private static final int[] STATE_NORMAL = null;

    @NotNull
    private static final int[] STATE_PRESSED = null;

    @NotNull
    private static final int[] STATE_SELECTED = null;
    private long animDuration;

    @NotNull
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private int checkedSolidColor;
    private int checkedStrokeColor;

    @Nullable
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

    @Nullable
    private ValueAnimator strokeAnimator;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
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

    public OStateGradientDrawable() {
        this.animDuration = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2.getDuration();
        this.animInterpolator = new LinearInterpolator();
    }

    public static /* synthetic */ void a(OStateGradientDrawable r10, ValueAnimator r11) {
        m16updateSolidColor$lambda1$lambda0(r10, r11);
    }

    public static /* synthetic */ void b(OStateGradientDrawable r10, ValueAnimator r11) {
        m17updateStrokeColor$lambda3$lambda2(r10, r11);
    }

    public static /* synthetic */ void setSolidColors$default(OStateGradientDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if ((r17 & 2) == 0) goto L5;
        int r19 = r11;
    L7:
        if ((r17 & 4) == 0) goto L9;
        int r20 = r11;
    L11:
        if ((r17 & 8) == 0) goto L13;
        int r21 = r11;
    L15:
        if ((r17 & 16) == 0) goto L17;
        int r22 = r11;
    L19:
        if ((r17 & 32) == 0) goto L21;
        int r23 = r11;
    L22:
        r10.setSolidColors(r11, r19, r20, r21, r22, r23);
        return;
    L21:
        r23 = r16;
        goto L22
    L17:
        r22 = r15;
        goto L19
    L13:
        r21 = r14;
        goto L15
    L9:
        r20 = r13;
        goto L11
    L5:
        r19 = r12;
        goto L7
    }

    public static /* synthetic */ void setStrokeConfigs$default(OStateGradientDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, Object r19) {
        if ((r18 & 4) == 0) goto L5;
        int r20 = r12;
    L7:
        if ((r18 & 8) == 0) goto L9;
        int r21 = r12;
    L11:
        if ((r18 & 16) == 0) goto L13;
        int r22 = r12;
    L15:
        if ((r18 & 32) == 0) goto L17;
        int r23 = r12;
    L19:
        if ((r18 & 64) == 0) goto L21;
        int r24 = r12;
    L22:
        r10.setStrokeConfigs(r11, r12, r20, r21, r22, r23, r24);
        return;
    L21:
        r24 = r17;
        goto L22
    L17:
        r23 = r16;
        goto L19
    L13:
        r22 = r15;
        goto L15
    L9:
        r21 = r14;
        goto L11
    L5:
        r20 = r13;
        goto L7
    }

    private final void updateSolidColor(int r10, boolean r11) {
        ValueAnimator r12 = this.colorAnimator;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        if (r11 == false) goto L8;
        int r13 = this.animatedSolidColor;
        ValueAnimator r14 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r13), Integer.valueOf(r10)});
        r14.setDuration(getAnimDuration());
        r14.setInterpolator(getAnimInterpolator());
        r14.addUpdateListener(new com.obric.oui.common.style.a(this));
        r14.start();
        this.colorAnimator = r14;
        return;
    L8:
        this.colorAnimator = null;
        this.animatedSolidColor = r10;
        setColor(r10);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-1$lambda-0, reason: not valid java name */
    private static final void m16updateSolidColor$lambda1$lambda0(OStateGradientDrawable r10, ValueAnimator r11) {
        q.g(r10, "this$0");
        q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        if (r12 == null) goto L7;
        int r13 = ((Integer) r12).intValue();
        r10.animatedSolidColor = r13;
        r10.setColor(r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void updateStrokeColor(int r10, boolean r11) {
        ValueAnimator r12 = this.strokeAnimator;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        if (r11 == false) goto L8;
        int r13 = this.animatedStrokeColor;
        ValueAnimator r14 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r13), Integer.valueOf(r10)});
        r14.setDuration(getAnimDuration());
        r14.setInterpolator(getAnimInterpolator());
        r14.addUpdateListener(new b(this));
        r14.start();
        this.strokeAnimator = r14;
        return;
    L8:
        this.strokeAnimator = null;
        this.animatedStrokeColor = r10;
        setStroke(this.strokeWidth, r10);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-3$lambda-2, reason: not valid java name */
    private static final void m17updateStrokeColor$lambda3$lambda2(OStateGradientDrawable r10, ValueAnimator r11) {
        q.g(r10, "this$0");
        q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        if (r12 == null) goto L7;
        int r13 = ((Integer) r12).intValue();
        r10.animatedStrokeColor = r13;
        r10.setStroke(r10.strokeWidth, r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void endAnimation() {
        ValueAnimator r10 = this.colorAnimator;
        if (r10 == null) goto L6;
        r10.end();
    L6:
        this.colorAnimator = null;
        ValueAnimator r11 = this.strokeAnimator;
        if (r11 == null) goto L10;
        r11.end();
    L10:
        this.strokeAnimator = null;
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    @NotNull
    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(@NotNull int[] r11) {
        q.g(r11, "stateSet");
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r11) == true) goto L6;
        int r10 = this.disabledSolidColor;
    L18:
        int r12 = this.targetSolidColor;
        if (r10 == r12) goto L26;
        int r13 = this.normalSolidColor;
        if (r10 != r13) goto L24;
        if (r12 == r13) goto L24;
        boolean r14 = true;
    L25:
        updateSolidColor(r10, r14);
        this.targetSolidColor = r10;
        boolean r15 = true;
    L28:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r11) == true) goto L31;
        int r16 = this.disabledStrokeColor;
    L43:
        int r17 = this.targetStrokeColor;
        if (r16 == r17) goto L51;
        int r18 = this.normalStrokeColor;
        if (r16 != r18) goto L49;
        if (r17 == r18) goto L49;
        boolean r19 = true;
    L50:
        updateStrokeColor(r16, r19);
        this.targetStrokeColor = r16;
        r15 = true;
    L49:
        r19 = false;
    L51:
        if (r15 == false) goto L53;
        return true;
    L53:
        if (super.onStateChange(r11) == false) goto L56;
        return true;
    L56:
        return false;
    L31:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r11) == false) goto L34;
        r16 = this.pressedStrokeColor;
        goto L43
    L34:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r11) == false) goto L37;
        r16 = this.selectedStrokeColor;
        goto L43
    L37:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r11) == false) goto L40;
        r16 = this.checkedStrokeColor;
        goto L43
    L40:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r11) == false) goto L42;
        r16 = this.hoverStrokeColor;
        goto L43
    L42:
        r16 = this.normalStrokeColor;
    L24:
        r14 = false;
        goto L25
    L26:
        r15 = false;
        goto L28
    L6:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r11) == false) goto L9;
        r10 = this.pressedSolidColor;
        goto L18
    L9:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r11) == false) goto L12;
        r10 = this.selectedSolidColor;
        goto L18
    L12:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r11) == false) goto L15;
        r10 = this.checkedSolidColor;
        goto L18
    L15:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r11) == false) goto L17;
        r10 = this.hoverSolidColor;
        goto L18
    L17:
        r10 = this.normalSolidColor;
        goto L18
    }

    public final void setAnimDuration(long r10) {
        this.animDuration = r10;
    }

    public final void setAnimInterpolator(@NotNull LinearInterpolator r10) {
        q.g(r10, "<set-?>");
        this.animInterpolator = r10;
    }

    public final void setSolidColors(int r10, int r11, int r12, int r13, int r14, int r15) {
        this.normalSolidColor = r10;
        this.pressedSolidColor = r11;
        this.selectedSolidColor = r12;
        this.checkedSolidColor = r13;
        this.hoverSolidColor = r14;
        this.disabledSolidColor = r15;
        this.targetSolidColor = r10;
        this.animatedSolidColor = r10;
        ValueAnimator r16 = this.colorAnimator;
        if (r16 == null) goto L6;
        r16.cancel();
    L6:
        setColor(r10);
    }

    public final void setStrokeConfigs(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        this.strokeWidth = r10;
        this.normalStrokeColor = r11;
        this.pressedStrokeColor = r12;
        this.selectedStrokeColor = r13;
        this.checkedStrokeColor = r14;
        this.hoverStrokeColor = r15;
        this.disabledStrokeColor = r16;
        this.targetStrokeColor = r11;
        this.animatedStrokeColor = r11;
        ValueAnimator r17 = this.strokeAnimator;
        if (r17 == null) goto L6;
        r17.cancel();
    L6:
        setStroke(r10, r11);
    }

    public final void setSolidColors(@NotNull ColorStateList r10) {
        q.g(r10, "colorStateList");
        int r11 = r10.getColorForState(STATE_NORMAL, r10.getDefaultColor());
        int r12 = r10.getColorForState(STATE_PRESSED, r11);
        setSolidColors(r11, r12, r10.getColorForState(STATE_SELECTED, r11), r10.getColorForState(STATE_CHECKED, r11), r10.getColorForState(STATE_HOVERED, r12), r10.getColorForState(STATE_DISABLED, r11));
    }

    public final void setStrokeConfigs(int r11, @NotNull ColorStateList r12) {
        q.g(r12, "colorStateList");
        int r10 = r12.getColorForState(STATE_NORMAL, r12.getDefaultColor());
        setStrokeConfigs(r11, r10, r12.getColorForState(STATE_PRESSED, r10), r12.getColorForState(STATE_SELECTED, r10), r12.getColorForState(STATE_CHECKED, r10), r12.getColorForState(STATE_HOVERED, r10), r12.getColorForState(STATE_DISABLED, r10));
    }
}
