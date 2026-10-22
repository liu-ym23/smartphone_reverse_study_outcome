package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.d;
import com.google.android.material.resources.MaterialAttributes;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int r10, @IntRange(from = 0, to = 255) int r11) {
        return d.k(r10, (Color.alpha(r10) * r11) / PrivateKeyType.INVALID);
    }

    @ColorInt
    public static int getColor(@NonNull View r10, @AttrRes int r11) {
        return MaterialAttributes.resolveOrThrow(r10, r11);
    }

    public static boolean isColorLight(@ColorInt int r10) {
        if (r10 != 0) goto L4;
    L6:
        return false;
    L4:
        if (d.d(r10) <= 0.5d) goto L6;
        return true;
    }

    @ColorInt
    public static int layer(@NonNull View r10, @AttrRes int r11, @AttrRes int r12) {
        return layer(r10, r11, r12, 1.0f);
    }

    @ColorInt
    public static int getColor(Context r10, @AttrRes int r11, String r12) {
        return MaterialAttributes.resolveOrThrow(r10, r11, r12);
    }

    @ColorInt
    public static int layer(@NonNull View r10, @AttrRes int r11, @AttrRes int r12, @FloatRange(from = 0.0d, to = 1.0d) float r13) {
        return layer(getColor(r10, r11), getColor(r10, r12), r13);
    }

    @ColorInt
    public static int getColor(@NonNull View r10, @AttrRes int r11, @ColorInt int r12) {
        return getColor(r10.getContext(), r11, r12);
    }

    @ColorInt
    public static int getColor(@NonNull Context r10, @AttrRes int r11, @ColorInt int r12) {
        TypedValue r13 = MaterialAttributes.resolve(r10, r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        return r13.data;
    }

    @ColorInt
    public static int layer(@ColorInt int r10, @ColorInt int r11, @FloatRange(from = 0.0d, to = 1.0d) float r12) {
        return layer(r10, d.k(r11, Math.round(Color.alpha(r11) * r12)));
    }

    @ColorInt
    public static int layer(@ColorInt int r10, @ColorInt int r11) {
        return d.g(r11, r10);
    }
}
