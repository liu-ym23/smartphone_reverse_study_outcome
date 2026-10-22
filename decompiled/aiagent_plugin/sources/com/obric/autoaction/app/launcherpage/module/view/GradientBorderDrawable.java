package com.obric.autoaction.app.launcherpage.module.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CardStrokeBlinkHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GradientBorderDrawable extends Drawable {
    private final int[] colors;
    private final float cornerRadius;
    private final Paint paint;
    private final RectF rect;
    private final float strokeWidth;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public GradientBorderDrawable(int[] r2, float r3, float r4) {
        o.e(r2, "colors");
        this.colors = r2;
        this.strokeWidth = r3;
        this.cornerRadius = r4;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.paint = r5;
        this.rect = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        o.e(r11, "canvas");
        this.rect.set(getBounds());
        LinearGradient r0 = new LinearGradient(this.rect.left, this.rect.top, this.rect.right, this.rect.top, this.colors, null, Shader.TileMode.CLAMP);
        this.paint.setShader((Shader) ZeusTransformUtils.preCheckCast(r0, Shader.class, "com.obric.aiagent.plugin"));
        float r2 = this.rect.left;
        float r3 = this.rect.top;
        float r4 = this.rect.right;
        float r5 = this.rect.bottom;
        float r7 = this.cornerRadius;
        r11.drawRoundRect(r2, r3, r4, r5, r7, r7, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.paint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.paint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.paint.setColorFilter(r2);
        invalidateSelf();
    }
}
