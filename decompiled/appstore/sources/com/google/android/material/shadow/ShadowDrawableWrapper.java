package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapper {
    static final double COS_45 = 0.0d;
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;

    @NonNull
    final RectF contentBounds;
    float cornerRadius;

    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;

    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public ShadowDrawableWrapper(Context r10, Drawable r11, float r12, float r13, float r14) {
        super(r11);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.b(r10, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.b(r10, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.b(r10, R.color.design_fab_shadow_end_color);
        Paint r15 = new Paint(5);
        this.cornerShadowPaint = r15;
        r15.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(r12);
        this.contentBounds = new RectF();
        Paint r16 = new Paint(r15);
        this.edgeShadowPaint = r16;
        r16.setAntiAlias(false);
        setShadowSize(r13, r14);
    }

    private void buildComponents(@NonNull Rect r10) {
        float r11 = this.rawMaxShadowSize;
        float r12 = 1.5f * r11;
        this.contentBounds.set(r10.left + r11, r10.top + r12, r10.right - r11, r10.bottom - r12);
        Drawable r13 = getWrappedDrawable();
        RectF r14 = this.contentBounds;
        r13.setBounds((int) r14.left, (int) r14.top, (int) r14.right, (int) r14.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float r10 = this.cornerRadius;
        RectF r11 = new RectF(-r10, -r10, r10, r10);
        RectF r12 = new RectF(r11);
        float r13 = this.shadowSize;
        r12.inset(-r13, -r13);
        Path r14 = this.cornerShadowPath;
        if (r14 != null) goto L5;
        this.cornerShadowPath = new Path();
    L6:
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(r12, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(r11, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float r15 = -r12.top;
        if (r15 <= 0.0f) goto L9;
        float r16 = this.cornerRadius / r15;
        this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, r15, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, r16, ((1.0f - r16) / 2.0f) + r16, 1.0f}, Shader.TileMode.CLAMP));
    L9:
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, r11.top, 0.0f, r12.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, SHADOW_HORIZ_SCALE, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r14.reset();
        goto L6
    }

    public static float calculateHorizontalPadding(float r10, float r11, boolean r12) {
        if (r12 == true) goto L4;
        return r10;
    L4:
        return (float) (((double) r10) + ((1.0d - COS_45) * ((double) r11)));
    }

    public static float calculateVerticalPadding(float r10, float r11, boolean r12) {
        if (r12 == false) goto L7;
        return (float) (((double) (r10 * 1.5f)) + ((1.0d - COS_45) * ((double) r11)));
    L7:
        return r10 * 1.5f;
    }

    private void drawShadow(@NonNull Canvas r21) {
        int r10 = r21.save();
        r21.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float r11 = this.cornerRadius;
        float r12 = (-r11) - this.shadowSize;
        float r13 = r11 * 2.0f;
        if ((this.contentBounds.width() - r13) <= 0.0f) goto L5;
        boolean r14 = true;
    L7:
        if ((this.contentBounds.height() - r13) <= 0.0f) goto L9;
        boolean r15 = true;
    L10:
        float r16 = this.rawShadowSize;
        float r17 = r16 - (SHADOW_TOP_SCALE * r16);
        float r18 = r11 / ((r16 - (SHADOW_HORIZ_SCALE * r16)) + r11);
        float r19 = r11 / (r17 + r11);
        float r20 = r11 / ((r16 - (r16 * 1.0f)) + r11);
        int r22 = r21.save();
        RectF r23 = this.contentBounds;
        r21.translate(r23.left + r11, r23.top + r11);
        r21.scale(r18, r19);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r14 == false) goto L14;
        r21.scale(1.0f / r18, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.width() - r13, -this.cornerRadius, this.edgeShadowPaint);
    L14:
        r21.restoreToCount(r22);
        int r110 = r21.save();
        RectF r24 = this.contentBounds;
        r21.translate(r24.right - r11, r24.bottom - r11);
        r21.scale(r18, r20);
        r21.rotate(180.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r14 == false) goto L18;
        r21.scale(1.0f / r18, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.width() - r13, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
    L18:
        r21.restoreToCount(r110);
        int r111 = r21.save();
        RectF r25 = this.contentBounds;
        r21.translate(r25.left + r11, r25.bottom - r11);
        r21.scale(r18, r6);
        r21.rotate(270.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r15 == false) goto L21;
        r21.scale(1.0f / r20, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.height() - r13, -this.cornerRadius, this.edgeShadowPaint);
    L21:
        r21.restoreToCount(r111);
        int r26 = r21.save();
        RectF r27 = this.contentBounds;
        r21.translate(r27.right - r11, r27.top + r11);
        r21.scale(r18, r19);
        r21.rotate(90.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r15 == false) goto L24;
        r21.scale(1.0f / r19, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.height() - r13, -this.cornerRadius, this.edgeShadowPaint);
    L24:
        r21.restoreToCount(r26);
        r21.restoreToCount(r10);
        return;
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L7
    }

    private static int toEven(float r10) {
        int r11 = Math.round(r10);
        if ((r11 % 2) == 1) goto L5;
        return r11;
    L5:
        return r11 - 1;
    }

    public void draw(@NonNull Canvas r10) {
        if (this.dirty == false) goto L5;
        buildComponents(getBounds());
        this.dirty = false;
    L5:
        drawShadow(r10);
        super.draw(r10);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float r10 = this.rawMaxShadowSize;
        return (Math.max(r10, this.cornerRadius + ((r10 * 1.5f) / 2.0f)) * 2.0f) + ((this.rawMaxShadowSize * 1.5f) * 2.0f);
    }

    public float getMinWidth() {
        float r10 = this.rawMaxShadowSize;
        return (Math.max(r10, this.cornerRadius + (r10 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(@NonNull Rect r10) {
        int r11 = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int r12 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        r10.set(r12, r11, r12, r11);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public void onBoundsChange(Rect r10) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean r10) {
        this.addPaddingForCorners = r10;
        invalidateSelf();
    }

    public void setAlpha(int r10) {
        super.setAlpha(r10);
        this.cornerShadowPaint.setAlpha(r10);
        this.edgeShadowPaint.setAlpha(r10);
    }

    public void setCornerRadius(float r10) {
        float r11 = Math.round(r10);
        if (this.cornerRadius != r11) goto L5;
        return;
    L5:
        this.cornerRadius = r11;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float r10) {
        setShadowSize(this.rawShadowSize, r10);
    }

    public final void setRotation(float r10) {
        if (this.rotation == r10) goto L6;
        this.rotation = r10;
        invalidateSelf();
        return;
    }

    public void setShadowSize(float r10, float r11) {
        if (r10 < 0.0f) goto L20;
        if (r11 < 0.0f) goto L20;
        float r12 = toEven(r10);
        float r13 = toEven(r11);
        if (r12 <= r13) goto L13;
        if (this.printedShadowClipWarning == true) goto L11;
        this.printedShadowClipWarning = true;
    L11:
        r12 = r13;
    L13:
        if (this.rawShadowSize == r12) goto L15;
    L17:
        this.rawShadowSize = r12;
        this.rawMaxShadowSize = r13;
        this.shadowSize = Math.round(r12 * 1.5f);
        this.maxShadowSize = r13;
        this.dirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.rawMaxShadowSize != r13) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("invalid shadow size");
    }

    public void setShadowSize(float r10) {
        setShadowSize(r10, this.rawMaxShadowSize);
    }
}
