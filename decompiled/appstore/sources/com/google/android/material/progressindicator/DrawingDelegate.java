package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes3.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    public DrawingDelegate(S r10) {
        this.spec = r10;
    }

    public abstract void adjustCanvas(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11);

    public abstract void fillIndicator(@NonNull Canvas r10, @NonNull Paint r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @ColorInt int r14);

    public abstract void fillTrack(@NonNull Canvas r10, @NonNull Paint r11);

    public abstract int getPreferredHeight();

    public abstract int getPreferredWidth();

    public void registerDrawable(@NonNull DrawableWithAnimatedVisibilityChange r10) {
        this.drawable = r10;
    }

    public void validateSpecAndAdjustCanvas(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        this.spec.validateSpec();
        adjustCanvas(r10, r11);
    }
}
