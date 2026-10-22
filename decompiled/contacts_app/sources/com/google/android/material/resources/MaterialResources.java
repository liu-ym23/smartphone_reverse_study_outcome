package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context r1, TypedArray r2, int r3) {
        if (r2.hasValue(r3) == false) goto L10;
        int r0 = r2.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r4 = AppCompatResources.getColorStateList(r1, r0);
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r2.getColorStateList(r3);
    }

    public static ColorStateList getColorStateList(Context r1, TintTypedArray r2, int r3) {
        if (r2.hasValue(r3) == false) goto L10;
        int r0 = r2.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r4 = AppCompatResources.getColorStateList(r1, r0);
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r2.getColorStateList(r3);
    }

    public static Drawable getDrawable(Context r1, TypedArray r2, int r3) {
        if (r2.hasValue(r3) == false) goto L10;
        int r0 = r2.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        Drawable r4 = AppCompatResources.getDrawable(r1, r0);
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r2.getDrawable(r3);
    }

    public static TextAppearance getTextAppearance(Context r1, TypedArray r2, int r3) {
        if (r2.hasValue(r3) == false) goto L8;
        int r4 = r2.getResourceId(r3, 0);
        if (r4 != 0) goto L7;
        return null;
    L7:
        return new TextAppearance(r1, r4);
    L8:
        return null;
    }

    public static int getDimensionPixelSize(Context r3, TypedArray r4, int r5, int r6) {
        TypedValue r0 = new TypedValue();
        if (r4.getValue(r5, r0) == false) goto L10;
        if (r0.type != 2) goto L10;
        TypedArray r7 = r3.getTheme().obtainStyledAttributes(new int[]{r0.data});
        int r8 = r7.getDimensionPixelSize(0, r6);
        r7.recycle();
        return r8;
    L10:
        return r4.getDimensionPixelSize(r5, r6);
    }

    public static boolean isFontScaleAtLeast1_3(Context r1) {
        if (r1.getResources().getConfiguration().fontScale < 1.3f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isFontScaleAtLeast2_0(Context r1) {
        if (r1.getResources().getConfiguration().fontScale < 2.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getUnscaledTextSize(Context r2, int r3, int r4) {
        if (r3 != 0) goto L4;
        return r4;
    L4:
        TypedArray r5 = r2.obtainStyledAttributes(r3, R.styleable.TextAppearance);
        TypedValue r0 = new TypedValue();
        boolean r1 = r5.getValue(R.styleable.TextAppearance_android_textSize, r0);
        r5.recycle();
        if (r1 == true) goto L8;
        return r4;
    L8:
        if (getComplexUnit(r0) != 2) goto L12;
        return Math.round(TypedValue.complexToFloat(r0.data) * r2.getResources().getDisplayMetrics().density);
    L12:
        return TypedValue.complexToDimensionPixelSize(r0.data, r2.getResources().getDisplayMetrics());
    }

    private static int getComplexUnit(TypedValue r0) {
        return r0.getComplexUnit();
    }

    static int getIndexWithValue(TypedArray r0, int r1, int r2) {
        if (r0.hasValue(r1) == false) goto L5;
        return r1;
    L5:
        return r2;
    }
}
