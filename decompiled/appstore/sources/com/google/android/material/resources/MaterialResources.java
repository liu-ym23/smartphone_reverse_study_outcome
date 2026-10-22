package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.b0;
import c.a;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L10;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 == 0) goto L10;
        ColorStateList r14 = a.a(r10, r13);
        if (r14 == null) goto L10;
        return r14;
    L10:
        return r11.getColorStateList(r12);
    }

    public static int getDimensionPixelSize(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12, int r13) {
        TypedValue r14 = new TypedValue();
        if (r11.getValue(r12, r14) == false) goto L10;
        if (r14.type != 2) goto L10;
        TypedArray r15 = r10.getTheme().obtainStyledAttributes(new int[]{r14.data});
        int r16 = r15.getDimensionPixelSize(0, r13);
        r15.recycle();
        return r16;
    L10:
        return r11.getDimensionPixelSize(r12, r13);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L10;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 == 0) goto L10;
        Drawable r14 = a.b(r10, r13);
        if (r14 == null) goto L10;
        return r14;
    L10:
        return r11.getDrawable(r12);
    }

    @StyleableRes
    public static int getIndexWithValue(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12) {
        if (r10.hasValue(r11) == false) goto L5;
        return r11;
    L5:
        return r12;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L8;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 != 0) goto L7;
        return null;
    L7:
        return new TextAppearance(r10, r13);
    L8:
        return null;
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context r10) {
        if (r10.getResources().getConfiguration().fontScale < FONT_SCALE_1_3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context r10) {
        if (r10.getResources().getConfiguration().fontScale < 2.0f) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r10, @NonNull b0 r11, @StyleableRes int r12) {
        if (r11.s(r12) == false) goto L10;
        int r13 = r11.n(r12, 0);
        if (r13 == 0) goto L10;
        ColorStateList r14 = a.a(r10, r13);
        if (r14 == null) goto L10;
        return r14;
    L10:
        return r11.c(r12);
    }
}
