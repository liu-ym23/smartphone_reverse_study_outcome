package com.android.contacts.common.widget;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class FlipDrawable extends Drawable implements Drawable.Callback {
    private static final float END_VALUE = 2.0f;
    protected final Drawable mBack;
    private final ValueAnimator mFlipAnimator;
    protected final int mFlipDurationMs;
    private float mFlipFraction;
    private boolean mFlipToSide;
    protected Drawable mFront;
    protected final int mPostFlipDurationMs;
    protected final int mPreFlipDurationMs;

    static /* synthetic */ float access$000(FlipDrawable r0) {
        return r0.mFlipFraction;
    }

    static /* synthetic */ float access$002(FlipDrawable r0, float r1) {
        r0.mFlipFraction = r1;
        return r1;
    }

    public FlipDrawable(Drawable r2, Drawable r3, int r4, int r5, int r6) {
        this.mFlipFraction = 0.0f;
        this.mFlipToSide = true;
        if (r2 == null) goto L8;
        if (r3 == null) goto L8;
        this.mFront = r2;
        this.mBack = r3;
        r2.setCallback(this);
        r3.setCallback(this);
        this.mFlipDurationMs = r4;
        this.mPreFlipDurationMs = r5;
        this.mPostFlipDurationMs = r6;
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 2.0f}).setDuration((r5 + r4) + r6);
        this.mFlipAnimator = r7;
        r7.addUpdateListener(new AnonymousClass1(this));
        reset();
        return;
    L8:
        throw new IllegalArgumentException("Front and back drawables must not be null.");
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        super.onBoundsChange(r2);
        if (r2.isEmpty() == false) goto L5;
        this.mFront.setBounds(0, 0, 0, 0);
        this.mBack.setBounds(0, 0, 0, 0);
        return;
    L5:
        this.mFront.setBounds(r2);
        this.mBack.setBounds(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        Rect r0 = getBounds();
        if (isVisible() == true) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if (getSideShown() == false) goto L10;
        Drawable r1 = this.mFront;
    L11:
        int r2 = this.mPreFlipDurationMs;
        int r3 = this.mFlipDurationMs + r2;
        int r4 = this.mPostFlipDurationMs;
        float r5 = r3 + r4;
        float r6 = this.mFlipFraction;
        if ((r6 / 2.0f) > (r2 / r5)) goto L15;
    L13:
        float r7 = 1.0f;
    L18:
        r11.save();
        r11.scale(r7, 1.0f, r0.exactCenterX(), r0.exactCenterY());
        r1.draw(r11);
        r11.restore();
        return;
    L15:
        if ((r6 / 2.0f) >= ((r5 - r4) / r5)) goto L13;
        float r8 = ((r2 / r5) + ((r5 - r4) / r5)) / 2.0f;
        r7 = Math.abs((r6 / 2.0f) - r8) * (1.0f / (r8 - (this.mPreFlipDurationMs / r5)));
        goto L18
    L10:
        r1 = this.mBack;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.mFront.setAlpha(r2);
        this.mBack.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mFront.setColorFilter(r2);
        this.mBack.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return resolveOpacity(this.mFront.getOpacity(), this.mBack.getOpacity());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r2) {
        if (this.mFront.setLevel(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mBack.setLevel(r2) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        scheduleSelf(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }

    public void reset() {
        float r0 = this.mFlipFraction;
        this.mFlipAnimator.cancel();
        if (this.mFlipToSide == false) goto L5;
        float r1 = 0.0f;
    L6:
        this.mFlipFraction = r1;
        if (r1 == r0) goto L10;
        invalidateSelf();
        return;
    L10:
        return;
    L5:
        r1 = 2.0f;
        goto L6
    }

    public boolean getSideShown() {
        int r0 = this.mPreFlipDurationMs;
        int r1 = this.mFlipDurationMs + r0;
        int r2 = this.mPostFlipDurationMs;
        float r3 = r1 + r2;
        if ((this.mFlipFraction / 2.0f) >= (((r0 / r3) + ((r3 - r2) / r3)) / 2.0f)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getSideFlippingTowards() {
        return this.mFlipToSide;
    }

    public void flip() {
        this.mFlipToSide = !this.mFlipToSide;
        if (this.mFlipAnimator.isStarted() == false) goto L6;
        this.mFlipAnimator.reverse();
        return;
    L6:
        if (this.mFlipToSide == true) goto L8;
        this.mFlipAnimator.start();
        return;
    L8:
        this.mFlipAnimator.reverse();
    }

    public void flipTo(boolean r2) {
        if (this.mFlipToSide == r2) goto L6;
        flip();
        return;
    }

    public boolean isFlipping() {
        return this.mFlipAnimator.isStarted();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.mFront.isStateful() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mBack.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r2) {
        if (this.mFront.setState(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mBack.setState(r2) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r2) {
        this.mFront.setTintMode(r2);
        this.mBack.setTintMode(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r2) {
        this.mFront.setTintList(r2);
        this.mBack.setTintList(r2);
    }
}
