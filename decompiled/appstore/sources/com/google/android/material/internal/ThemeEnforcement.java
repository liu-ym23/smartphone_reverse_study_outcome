package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.b0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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

    public static void checkAppCompatTheme(@NonNull Context r10) {
        checkTheme(r10, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.ThemeEnforcement, r12, r13);
        boolean r15 = r14.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        r14.recycle();
        if (r15 == false) goto L11;
        TypedValue r16 = new TypedValue();
        if (r10.getTheme().resolveAttribute(R.attr.isMaterialTheme, r16, true) == true) goto L7;
    L10:
        checkMaterialTheme(r10);
        goto L11
    L7:
        if (r16.type != 18) goto L11;
        if (r16.data == 0) goto L10;
    L11:
        checkAppCompatTheme(r10);
    }

    public static void checkMaterialTheme(@NonNull Context r10) {
        checkTheme(r10, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @Nullable @StyleableRes int... r15) {
        TypedArray r16 = r10.obtainStyledAttributes(r11, R.styleable.ThemeEnforcement, r13, r14);
        boolean r17 = false;
        if (r16.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false) == true) goto L6;
        r16.recycle();
        return;
    L6:
        if (r15 == null) goto L12;
        if (r15.length == 0) goto L12;
        boolean r18 = isCustomTextAppearanceValid(r10, r11, r12, r13, r14, r15);
    L15:
        r16.recycle();
        if (r18 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L12:
        if (r16.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) == (-1)) goto L14;
        r17 = true;
    L14:
        r18 = r17;
        goto L15
    }

    private static void checkTheme(@NonNull Context r10, @NonNull int[] r11, String r12) {
        if (isTheme(r10, r11) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + r12 + " (or a descendant).");
    }

    public static boolean isAppCompatTheme(@NonNull Context r10) {
        return isTheme(r10, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @NonNull @StyleableRes int... r15) {
        TypedArray r16 = r10.obtainStyledAttributes(r11, r12, r13, r14);
        int r17 = r15.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L9;
        if (r16.getResourceId(r15[r18], -1) == (-1)) goto L6;
        r18 = r18 + 1;
        goto L3
    L6:
        r16.recycle();
        return false;
    L9:
        r16.recycle();
        return true;
    }

    public static boolean isMaterialTheme(@NonNull Context r10) {
        return isTheme(r10, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(@NonNull Context r10, @NonNull int[] r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11);
        int r13 = 0;
    L4:
        if (r13 >= r11.length) goto L10;
        if (r12.hasValue(r13) == false) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        r12.recycle();
        return false;
    L10:
        r12.recycle();
        return true;
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @StyleableRes int... r15) {
        checkCompatibleTheme(r10, r11, r13, r14);
        checkTextAppearance(r10, r11, r12, r13, r14, r15);
        return r10.obtainStyledAttributes(r11, r12, r13, r14);
    }

    public static b0 obtainTintedStyledAttributes(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @StyleableRes int... r15) {
        checkCompatibleTheme(r10, r11, r13, r14);
        checkTextAppearance(r10, r11, r12, r13, r14, r15);
        return b0.v(r10, r11, r12, r13, r14);
    }
}
