package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class FadeThroughDrawable extends Drawable {
    private final float[] alphas;
    private final Drawable fadeInDrawable;
    private final Drawable fadeOutDrawable;
    private float progress;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FadeThroughDrawable(Drawable r1, Drawable r2) {
        this.fadeOutDrawable = r1.getConstantState().newDrawable().mutate();
        Drawable r3 = r2.getConstantState().newDrawable().mutate();
        this.fadeInDrawable = r3;
        r3.setAlpha(0);
        this.alphas = new float[2];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        this.fadeOutDrawable.draw(r2);
        this.fadeInDrawable.draw(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r2, int r3, int r4, int r5) {
        super.setBounds(r2, r3, r4, r5);
        this.fadeOutDrawable.setBounds(r2, r3, r4, r5);
        this.fadeInDrawable.setBounds(r2, r3, r4, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.fadeOutDrawable.getIntrinsicWidth(), this.fadeInDrawable.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.fadeOutDrawable.getIntrinsicHeight(), this.fadeInDrawable.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.fadeOutDrawable.getMinimumWidth(), this.fadeInDrawable.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.fadeOutDrawable.getMinimumHeight(), this.fadeInDrawable.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r3) {
        if (this.progress > 0.5f) goto L5;
        this.fadeOutDrawable.setAlpha(r3);
        this.fadeInDrawable.setAlpha(0);
    L6:
        invalidateSelf();
        return;
    L5:
        this.fadeOutDrawable.setAlpha(0);
        this.fadeInDrawable.setAlpha(r3);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.fadeOutDrawable.setColorFilter(r2);
        this.fadeInDrawable.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.fadeOutDrawable.isStateful() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.fadeInDrawable.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r2) {
        boolean r0 = this.fadeOutDrawable.setState(r2);
        boolean r1 = this.fadeInDrawable.setState(r2);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return false;
    L7:
        return true;
    }

    public void setProgress(float r4) {
        if (this.progress == r4) goto L6;
        this.progress = r4;
        FadeThroughUtils.calculateFadeOutAndInAlphas(r4, this.alphas);
        this.fadeOutDrawable.setAlpha((int) (this.alphas[0] * 255.0f));
        this.fadeInDrawable.setAlpha((int) (this.alphas[1] * 255.0f));
        invalidateSelf();
        return;
    }
}
