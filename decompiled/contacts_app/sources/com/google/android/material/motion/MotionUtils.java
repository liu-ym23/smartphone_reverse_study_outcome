package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.android.contacts.common.SimContactsConstants;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class MotionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";

    private MotionUtils() {
    }

    public static int resolveThemeDuration(Context r0, int r1, int r2) {
        return MaterialAttributes.resolveInteger(r0, r1, r2);
    }

    public static TimeInterpolator resolveThemeInterpolator(Context r3, int r4, TimeInterpolator r5) {
        TypedValue r0 = new TypedValue();
        if (r3.getTheme().resolveAttribute(r4, r0, true) == true) goto L6;
        return r5;
    L6:
        if (r0.type != 3) goto L14;
        String r6 = String.valueOf(r0.string);
        if (isLegacyEasingAttribute(r6) == false) goto L12;
        return getLegacyThemeInterpolator(r6);
    L12:
        return AnimationUtils.loadInterpolator(r3, r0.resourceId);
    L14:
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }

    private static TimeInterpolator getLegacyThemeInterpolator(String r4) {
        if (isLegacyEasingType(r4, EASING_TYPE_CUBIC_BEZIER) == false) goto L11;
        String[] r5 = getLegacyEasingContent(r4, EASING_TYPE_CUBIC_BEZIER).split(SimContactsConstants.EMAIL_SEP);
        if (r5.length != 4) goto L9;
        return PathInterpolatorCompat.create(getLegacyControlPoint(r5, 0), getLegacyControlPoint(r5, 1), getLegacyControlPoint(r5, 2), getLegacyControlPoint(r5, 3));
    L9:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r5.length);
    L11:
        if (isLegacyEasingType(r4, "path") == false) goto L15;
        return PathInterpolatorCompat.create(PathParser.createPathFromPathData(getLegacyEasingContent(r4, "path")));
    L15:
        throw new IllegalArgumentException("Invalid motion easing type: " + r4);
    }

    private static boolean isLegacyEasingAttribute(String r1) {
        if (isLegacyEasingType(r1, EASING_TYPE_CUBIC_BEZIER) == false) goto L5;
    L8:
        return true;
    L5:
        if (isLegacyEasingType(r1, "path") == true) goto L8;
        return false;
    }

    private static boolean isLegacyEasingType(String r1, String r2) {
        if (r1.startsWith(r2 + EASING_TYPE_FORMAT_START) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.endsWith(EASING_TYPE_FORMAT_END) == false) goto L7;
        return true;
    }

    private static String getLegacyEasingContent(String r1, String r2) {
        return r1.substring(r2.length() + 1, r1.length() - 1);
    }

    private static float getLegacyControlPoint(String[] r2, int r3) {
        float r4 = Float.parseFloat(r2[r3]);
        if (r4 < 0.0f) goto L8;
        if (r4 > 1.0f) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r4);
    }
}
