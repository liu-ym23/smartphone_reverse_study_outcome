package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.d;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes3.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(@NonNull Context r10) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(r10, R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(r10, R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(r10, R.attr.colorSurface, 0);
        this.displayDensity = r10.getResources().getDisplayMetrics().density;
    }

    private boolean isThemeSurfaceColor(@ColorInt int r10) {
        if (d.k(r10, PrivateKeyType.INVALID) != this.colorSurface) goto L5;
        return true;
    L5:
        return false;
    }

    public int calculateOverlayAlpha(float r10) {
        return Math.round(calculateOverlayAlphaFraction(r10) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float r10) {
        float r11 = this.displayDensity;
        if (r11 > 0.0f) goto L5;
    L9:
        return 0.0f;
    L5:
        if (r10 <= 0.0f) goto L9;
        return Math.min(((((float) Math.log1p(r10 / r11)) * FORMULA_MULTIPLIER) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int r10, float r11, @NonNull View r12) {
        return compositeOverlay(r10, r11 + getParentAbsoluteElevation(r12));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int r10, float r11, @NonNull View r12) {
        return compositeOverlayIfNeeded(r10, r11 + getParentAbsoluteElevation(r12));
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float r10, @NonNull View r11) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(r10 + getParentAbsoluteElevation(r11));
    }

    public float getParentAbsoluteElevation(@NonNull View r10) {
        return ViewUtils.getParentAbsoluteElevation(r10);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int r10, float r11) {
        float r12 = calculateOverlayAlphaFraction(r11);
        int r13 = Color.alpha(r10);
        return d.k(MaterialColors.layer(d.k(r10, PrivateKeyType.INVALID), this.elevationOverlayColor, r12), r13);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int r10, float r11) {
        if (this.elevationOverlayEnabled == true) goto L5;
    L8:
        return r10;
    L5:
        if (isThemeSurfaceColor(r10) == false) goto L8;
        return compositeOverlay(r10, r11);
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float r10) {
        return compositeOverlayIfNeeded(this.colorSurface, r10);
    }
}
