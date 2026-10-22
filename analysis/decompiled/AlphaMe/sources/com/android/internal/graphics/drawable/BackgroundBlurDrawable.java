package com.android.internal.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Keep
/* loaded from: classes.dex */
public class BackgroundBlurDrawable extends Drawable {
    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
    }

    @Keep
    public void setBlurRadius(int i4) {
    }

    @Keep
    public void setColor(int i4) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Keep
    public void setCornerRadius(float f4) {
    }

    @Keep
    public void setCornerRadius(float f4, float f5, float f6, float f7) {
    }
}
