package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f13003a;

    /* renamed from: b, reason: collision with root package name */
    private final Drawable f13004b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f13005c;

    /* renamed from: d, reason: collision with root package name */
    private float f13006d;

    public void a(float f5) {
        if (this.f13006d != f5) {
            this.f13006d = f5;
            f.a(f5, this.f13005c);
            this.f13003a.setAlpha((int) (this.f13005c[0] * 255.0f));
            this.f13004b.setAlpha((int) (this.f13005c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f13003a.draw(canvas);
        this.f13004b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f13003a.getIntrinsicHeight(), this.f13004b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f13003a.getIntrinsicWidth(), this.f13004b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f13003a.getMinimumHeight(), this.f13004b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f13003a.getMinimumWidth(), this.f13004b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f13003a.isStateful() || this.f13004b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        if (this.f13006d <= 0.5f) {
            this.f13003a.setAlpha(i5);
            this.f13004b.setAlpha(0);
        } else {
            this.f13003a.setAlpha(0);
            this.f13004b.setAlpha(i5);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i5, int i6, int i7, int i8) {
        super.setBounds(i5, i6, i7, i8);
        this.f13003a.setBounds(i5, i6, i7, i8);
        this.f13004b.setBounds(i5, i6, i7, i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13003a.setColorFilter(colorFilter);
        this.f13004b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f13003a.setState(iArr) || this.f13004b.setState(iArr);
    }
}
