package com.android.internal.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class BackgroundBlurDrawable extends Drawable {
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Keep
    public void setBlurRadius(int i10) {
    }

    @Keep
    public void setColor(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Keep
    public void setCornerRadius(float f10) {
    }

    @Keep
    public void setCornerRadius(float f10, float f11, float f12, float f13) {
    }
}
