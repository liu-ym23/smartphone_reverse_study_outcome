package com.google.android.material.ripple;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.d;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET = null;
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;

    @VisibleForTesting
    static final String LOG_TAG = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;

    @VisibleForTesting
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE = false;

    static {
        USE_FRAMEWORK_RIPPLE = true;
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        HOVERED_FOCUSED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_focused};
        FOCUSED_STATE_SET = new int[]{R.attr.state_focused};
        HOVERED_STATE_SET = new int[]{R.attr.state_hovered};
        SELECTED_PRESSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_pressed};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        SELECTED_FOCUSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_focused};
        SELECTED_HOVERED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_hovered};
        SELECTED_STATE_SET = new int[]{R.attr.state_selected};
        ENABLED_PRESSED_STATE_SET = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        LOG_TAG = RippleUtils.class.getSimpleName();
    }

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList r10) {
        if (USE_FRAMEWORK_RIPPLE == true) goto L5;
        int[] r11 = SELECTED_PRESSED_STATE_SET;
        int[] r12 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] r13 = SELECTED_FOCUSED_STATE_SET;
        int[] r14 = SELECTED_HOVERED_STATE_SET;
        int[] r15 = PRESSED_STATE_SET;
        int[] r16 = HOVERED_FOCUSED_STATE_SET;
        int[] r17 = FOCUSED_STATE_SET;
        int[] r18 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{r11, r12, r13, r14, SELECTED_STATE_SET, r15, r16, r17, r18, StateSet.NOTHING}, new int[]{getColorForState(r10, r11), getColorForState(r10, r12), getColorForState(r10, r13), getColorForState(r10, r14), 0, getColorForState(r10, r15), getColorForState(r10, r16), getColorForState(r10, r17), getColorForState(r10, r18), 0});
    L5:
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{getColorForState(r10, SELECTED_PRESSED_STATE_SET), getColorForState(r10, PRESSED_STATE_SET)});
    }

    @ColorInt
    @TargetApi(21)
    private static int doubleAlpha(@ColorInt int r10) {
        return d.k(r10, Math.min(Color.alpha(r10) * 2, PrivateKeyType.INVALID));
    }

    @ColorInt
    private static int getColorForState(@Nullable ColorStateList r10, int[] r11) {
        if (r10 == null) goto L4;
        int r12 = r10.getColorForState(r11, r10.getDefaultColor());
    L6:
        if (USE_FRAMEWORK_RIPPLE == true) goto L8;
        return r12;
    L8:
        return doubleAlpha(r12);
    L4:
        r12 = 0;
        goto L6
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] r10) {
        int r11 = r10.length;
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
    L4:
        if (r12 >= r11) goto L18;
        int r15 = r10[r12];
        if (r15 != 16842910) goto L9;
        r13 = true;
    L17:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r15 != 16842908) goto L12;
    L10:
        r14 = true;
        goto L17
    L12:
        if (r15 == 16842919) goto L10;
        if (r15 != 16843623) goto L17;
    L18:
        if (r13 == false) goto L26;
        if (r14 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }
}
