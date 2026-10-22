package com.obric.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImmersiveVerticalGradientDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/ui/ImmersiveVerticalGradientDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "gradientColors", "", "gradientPositions", "", "paint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImmersiveVerticalGradientDrawable extends Drawable {
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private final Paint paint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ImmersiveVerticalGradientDrawable() {
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        r0.setDither(true);
        r0.setFilterBitmap(true);
        r0.setSubpixelText(true);
        r0.setFlags(3);
        this.paint = r0;
        this.gradientColors = new int[]{Color.argb(255, 247, 247, 247), Color.argb(230, 247, 247, 247), Color.argb(191, 247, 247, 247), Color.argb(102, 247, 247, 247), Color.argb(0, 247, 247, 247)};
        this.gradientPositions = new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f};
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "bounds");
        super.onBoundsChange(r10);
        this.paint.setShader(new LinearGradient(r10.left, r10.top, r10.left, r10.bottom, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.drawRect(getBounds(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.paint.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.paint.setColorFilter(r1);
    }
}
