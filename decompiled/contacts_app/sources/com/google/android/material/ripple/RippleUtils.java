package com.google.android.material.ripple;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET = null;
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;
    static final String LOG_TAG = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE = false;

    private static class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
        }

        static /* synthetic */ Drawable access$000(Context r0, int r1) {
            return createOvalRipple(r0, r1);
        }

        private static Drawable createOvalRipple(Context r7, int r8) {
            GradientDrawable r1 = new GradientDrawable();
            r1.setColor(-1);
            r1.setShape(1);
            InsetDrawable r6 = new InsetDrawable(r1, r8, r8, r8, r8);
            return new RippleDrawable(MaterialColors.getColorStateList(r7, R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, r6);
        }
    }

    static {
        USE_FRAMEWORK_RIPPLE = true;
        PRESSED_STATE_SET = new int[]{android.R.attr.state_pressed};
        HOVERED_FOCUSED_STATE_SET = new int[]{android.R.attr.state_hovered, android.R.attr.state_focused};
        FOCUSED_STATE_SET = new int[]{android.R.attr.state_focused};
        HOVERED_STATE_SET = new int[]{android.R.attr.state_hovered};
        SELECTED_PRESSED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_pressed};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_hovered, android.R.attr.state_focused};
        SELECTED_FOCUSED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_focused};
        SELECTED_HOVERED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_hovered};
        SELECTED_STATE_SET = new int[]{android.R.attr.state_selected};
        ENABLED_PRESSED_STATE_SET = new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed};
        LOG_TAG = "RippleUtils";
    }

    private RippleUtils() {
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList r7) {
        if (USE_FRAMEWORK_RIPPLE == false) goto L6;
        int[] r4 = FOCUSED_STATE_SET;
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, r4, StateSet.NOTHING}, new int[]{getColorForState(r7, SELECTED_PRESSED_STATE_SET), getColorForState(r7, r4), getColorForState(r7, PRESSED_STATE_SET)});
    L6:
        int[] r6 = SELECTED_PRESSED_STATE_SET;
        int[] r8 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] r3 = SELECTED_FOCUSED_STATE_SET;
        int[] r2 = SELECTED_HOVERED_STATE_SET;
        int[] r1 = PRESSED_STATE_SET;
        int[] r5 = HOVERED_FOCUSED_STATE_SET;
        int[] r9 = FOCUSED_STATE_SET;
        int[] r10 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{r6, r8, r3, r2, SELECTED_STATE_SET, r1, r5, r9, r10, StateSet.NOTHING}, new int[]{getColorForState(r7, r6), getColorForState(r7, r8), getColorForState(r7, r3), getColorForState(r7, r2), 0, getColorForState(r7, r1), getColorForState(r7, r5), getColorForState(r7, r9), getColorForState(r7, r10), 0});
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(int[] r8) {
        int r0 = r8.length;
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r2 >= r0) goto L18;
        int r6 = r8[r2];
        if (r6 != 16842910) goto L9;
        r3 = true;
    L17:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r6 != 16842908) goto L12;
    L10:
        r4 = true;
        goto L17
    L12:
        if (r6 == 16842919) goto L10;
        if (r6 != 16843623) goto L17;
    L18:
        if (r3 == false) goto L26;
        if (r4 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }

    public static Drawable createOvalRippleLollipop(Context r0, int r1) {
        return RippleUtilsLollipop.access$000(r0, r1);
    }

    private static int getColorForState(ColorStateList r1, int[] r2) {
        if (r1 == null) goto L4;
        int r3 = r1.getColorForState(r2, r1.getDefaultColor());
    L6:
        if (USE_FRAMEWORK_RIPPLE == true) goto L8;
        return r3;
    L8:
        return doubleAlpha(r3);
    L4:
        r3 = 0;
        goto L6
    }

    private static int doubleAlpha(int r2) {
        return ColorUtils.setAlphaComponent(r2, Math.min(Color.alpha(r2) * 2, 255));
    }
}
