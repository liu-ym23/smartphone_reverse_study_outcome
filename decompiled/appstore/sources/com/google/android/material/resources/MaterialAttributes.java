package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes {
    public MaterialAttributes() {
    }

    @Nullable
    public static TypedValue resolve(@NonNull Context r10, @AttrRes int r11) {
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r12, true) == false) goto L5;
        return r12;
    L5:
        return null;
    }

    public static boolean resolveBoolean(@NonNull Context r10, @AttrRes int r11, boolean r12) {
        TypedValue r13 = resolve(r10, r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        if (r13.type == 18) goto L7;
        return r12;
    L7:
        if (r13.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context r10, @AttrRes int r11, @NonNull String r12) {
        if (resolveOrThrow(r10, r11, r12) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Px
    public static int resolveDimension(@NonNull Context r10, @AttrRes int r11, @DimenRes int r12) {
        TypedValue r13 = resolve(r10, r11);
        if (r13 != null) goto L5;
    L10:
        float r14 = r10.getResources().getDimension(r12);
    L9:
        return (int) r14;
    L5:
        if (r13.type != 5) goto L10;
        r14 = r13.getDimension(r10.getResources().getDisplayMetrics());
        goto L9
    }

    public static int resolveInteger(@NonNull Context r10, @AttrRes int r11, int r12) {
        TypedValue r13 = resolve(r10, r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        if (r13.type == 16) goto L7;
        return r12;
    L7:
        return r13.data;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context r10) {
        return resolveDimension(r10, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@NonNull Context r10, @AttrRes int r11, @NonNull String r12) {
        TypedValue r13 = resolve(r10, r11);
        if (r13 == null) goto L7;
        return r13.data;
    L7:
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{r12, r10.getResources().getResourceName(r11)}));
    }

    public static int resolveOrThrow(@NonNull View r10, @AttrRes int r11) {
        return resolveOrThrow(r10.getContext(), r11, r10.getClass().getCanonicalName());
    }
}
