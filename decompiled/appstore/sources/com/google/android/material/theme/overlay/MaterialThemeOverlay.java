package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import g.b;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = null;
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = null;

    static {
        ANDROID_THEME_OVERLAY_ATTRS = new int[]{R.attr.theme, com.google.android.material.R.attr.theme};
        MATERIAL_THEME_OVERLAY_ATTR = new int[]{com.google.android.material.R.attr.materialThemeOverlay};
    }

    private MaterialThemeOverlay() {
    }

    @StyleRes
    private static int obtainAndroidThemeOverlayId(@NonNull Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, ANDROID_THEME_OVERLAY_ATTRS);
        int r13 = r12.getResourceId(0, 0);
        int r14 = r12.getResourceId(1, 0);
        r12.recycle();
        if (r13 == 0) goto L6;
        return r13;
    L6:
        return r14;
    }

    @StyleRes
    private static int obtainMaterialThemeOverlayId(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, MATERIAL_THEME_OVERLAY_ATTR, r12, r13);
        int r15 = r14.getResourceId(0, 0);
        r14.recycle();
        return r15;
    }

    @NonNull
    public static Context wrap(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        int r14 = obtainMaterialThemeOverlayId(r10, r11, r12, r13);
        if ((r10 instanceof b) == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r14 == 0) goto L15;
        if (r15 == true) goto L15;
        b r16 = new b(r10, r14);
        int r17 = obtainAndroidThemeOverlayId(r10, r11);
        if (r17 == 0) goto L14;
        r16.getTheme().applyStyle(r17, true);
    L14:
        return r16;
    L15:
        return r10;
    L5:
        if (((b) r10).getThemeResId() != r14) goto L7;
        r15 = true;
        goto L8
    }
}
