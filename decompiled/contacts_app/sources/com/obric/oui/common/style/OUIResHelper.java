package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public class OUIResHelper {
    private static TypedValue sTmpValue;

    public OUIResHelper() {
    }

    public static float getAttrFloatValue(Context r0, int r1) {
        return getAttrFloatValue(r0.getTheme(), r1);
    }

    public static float getAttrFloatValue(Resources.Theme r2, int r3) {
        if (sTmpValue != null) goto L6;
        sTmpValue = new TypedValue();
    L6:
        if (r2.resolveAttribute(r3, sTmpValue, true) == true) goto L10;
        return -1.0f;
    L10:
        return sTmpValue.getFloat();
    }

    public static int getAttrDimen(Context r3, int r4) {
        if (sTmpValue != null) goto L6;
        sTmpValue = new TypedValue();
    L6:
        if (r3.getTheme().resolveAttribute(r4, sTmpValue, true) == true) goto L10;
        return 0;
    L10:
        return TypedValue.complexToDimensionPixelSize(sTmpValue.data, OUIDisplayHelper.getDisplayMetrics(r3));
    }

    public static int getAttrColor(Context r0, int r1) {
        return getAttrColor(r0.getTheme(), r1);
    }

    public static int getAttrColor(Resources.Theme r2, int r3) {
        if (sTmpValue != null) goto L6;
        sTmpValue = new TypedValue();
    L6:
        if (r2.resolveAttribute(r3, sTmpValue, true) == true) goto L10;
        return 0;
    L10:
        if (sTmpValue.type != 2) goto L14;
        return getAttrColor(r2, sTmpValue.data);
    L14:
        return sTmpValue.data;
    }

    public static Drawable getAttrDrawable(Context r1, int r2) {
        return getAttrDrawable(r1, r1.getTheme(), r2);
    }

    public static Drawable getAttrDrawable(Context r3, Resources.Theme r4, int r5) {
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (sTmpValue != null) goto L9;
        sTmpValue = new TypedValue();
    L9:
        if (r4.resolveAttribute(r5, sTmpValue, true) == true) goto L12;
        return null;
    L12:
        if (sTmpValue.type < 28) goto L18;
        if (sTmpValue.type > 31) goto L18;
        return new ColorDrawable(sTmpValue.data);
    L18:
        if (sTmpValue.type != 2) goto L22;
        return getAttrDrawable(r3, r4, sTmpValue.data);
    L22:
        if (sTmpValue.resourceId != 0) goto L24;
        return null;
    L24:
        return OUIDrawableHelper.getVectorDrawable(r3, sTmpValue.resourceId);
    }

    public static Drawable getAttrDrawable(Context r1, TypedArray r2, int r3) {
        TypedValue r4 = r2.peekValue(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.type != 2) goto L7;
        return null;
    L7:
        if (r4.resourceId != 0) goto L9;
        return null;
    L9:
        return OUIDrawableHelper.getVectorDrawable(r1, r4.resourceId);
    }

    public static TypedArray obtainAttributes(Resources r0, Resources.Theme r1, AttributeSet r2, int[] r3) {
        if (r1 != null) goto L5;
        return r0.obtainAttributes(r2, r3);
    L5:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }
}
