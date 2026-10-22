package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f21074a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f21075b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f21076c;

    /* renamed from: d, reason: collision with root package name */
    public float f21077d;

    public void a(float f10) {
        if (this.f21077d != f10) {
            this.f21077d = f10;
            f.a(f10, this.f21076c);
            this.f21074a.setAlpha((int) (this.f21076c[0] * 255.0f));
            this.f21075b.setAlpha((int) (this.f21076c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f21074a.draw(canvas);
        this.f21075b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f21074a.getIntrinsicHeight(), this.f21075b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f21074a.getIntrinsicWidth(), this.f21075b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f21074a.getMinimumHeight(), this.f21075b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f21074a.getMinimumWidth(), this.f21075b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f21074a.isStateful() || this.f21075b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f21077d <= 0.5f) {
            this.f21074a.setAlpha(i10);
            this.f21075b.setAlpha(0);
        } else {
            this.f21074a.setAlpha(0);
            this.f21075b.setAlpha(i10);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f21074a.setBounds(i10, i11, i12, i13);
        this.f21075b.setBounds(i10, i11, i12, i13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f21074a.setColorFilter(colorFilter);
        this.f21075b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f21074a.setState(iArr) || this.f21075b.setState(iArr);
    }
}
