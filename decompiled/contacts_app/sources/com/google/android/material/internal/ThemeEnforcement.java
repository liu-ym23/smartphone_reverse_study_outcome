package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS = null;
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS = null;
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    static {
        APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};
        MATERIAL_CHECK_ATTRS = new int[]{R.attr.colorPrimaryVariant};
    }

    private ThemeEnforcement() {
    }

    public static TypedArray obtainStyledAttributes(Context r0, AttributeSet r1, int[] r2, int r3, int r4, int... r5) {
        checkCompatibleTheme(r0, r1, r3, r4);
        checkTextAppearance(r0, r1, r2, r3, r4, r5);
        return r0.obtainStyledAttributes(r1, r2, r3, r4);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context r0, AttributeSet r1, int[] r2, int r3, int r4, int... r5) {
        checkCompatibleTheme(r0, r1, r3, r4);
        checkTextAppearance(r0, r1, r2, r3, r4, r5);
        return TintTypedArray.obtainStyledAttributes(r0, r1, r2, r3, r4);
    }

    private static void checkCompatibleTheme(Context r1, AttributeSet r2, int r3, int r4) {
        TypedArray r5 = r1.obtainStyledAttributes(r2, R.styleable.ThemeEnforcement, r3, r4);
        boolean r6 = r5.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        r5.recycle();
        if (r6 == false) goto L11;
        TypedValue r7 = new TypedValue();
        if (r1.getTheme().resolveAttribute(R.attr.isMaterialTheme, r7, true) == true) goto L7;
    L10:
        checkMaterialTheme(r1);
        goto L11
    L7:
        if (r7.type != 18) goto L11;
        if (r7.data == 0) goto L10;
    L11:
        checkAppCompatTheme(r1);
    }

    private static void checkTextAppearance(Context r3, AttributeSet r4, int[] r5, int r6, int r7, int... r8) {
        TypedArray r0 = r3.obtainStyledAttributes(r4, R.styleable.ThemeEnforcement, r6, r7);
        boolean r2 = false;
        if (r0.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false) == true) goto L6;
        r0.recycle();
        return;
    L6:
        if (r8 == null) goto L12;
        if (r8.length == 0) goto L12;
        boolean r9 = isCustomTextAppearanceValid(r3, r4, r5, r6, r7, r8);
    L15:
        r0.recycle();
        if (r9 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L12:
        if (r0.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) == (-1)) goto L14;
        r2 = true;
    L14:
        r9 = r2;
        goto L15
    }

    private static boolean isCustomTextAppearanceValid(Context r1, AttributeSet r2, int[] r3, int r4, int r5, int... r6) {
        TypedArray r7 = r1.obtainStyledAttributes(r2, r3, r4, r5);
        int r8 = r6.length;
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L9;
        if (r7.getResourceId(r6[r9], -1) == (-1)) goto L6;
        r9 = r9 + 1;
        goto L3
    L6:
        r7.recycle();
        return false;
    L9:
        r7.recycle();
        return true;
    }

    public static void checkAppCompatTheme(Context r2) {
        checkTheme(r2, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    public static void checkMaterialTheme(Context r2) {
        checkTheme(r2, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    public static boolean isAppCompatTheme(Context r1) {
        return isTheme(r1, APPCOMPAT_CHECK_ATTRS);
    }

    public static boolean isMaterialTheme(Context r1) {
        return isTheme(r1, MATERIAL_CHECK_ATTRS);
    }

    public static boolean isMaterial3Theme(Context r2) {
        return MaterialAttributes.resolveBoolean(r2, R.attr.isMaterial3Theme, false);
    }

    private static boolean isTheme(Context r3, int[] r4) {
        TypedArray r5 = r3.obtainStyledAttributes(r4);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L10;
        if (r5.hasValue(r1) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        r5.recycle();
        return false;
    L10:
        r5.recycle();
        return true;
    }

    private static void checkTheme(Context r1, int[] r2, String r3) {
        if (isTheme(r1, r2) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + r3 + " (or a descendant).");
    }
}
