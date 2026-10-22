package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public final class f extends e3.k {

    /* renamed from: M, reason: collision with root package name */
    public static final /* synthetic */ int f2665M = 0;

    /* renamed from: L, reason: collision with root package name */
    public e f2666L;

    public final void A(float f, float f7, float f9, float f10) {
        RectF rectF = this.f2666L.f2664s;
        if (f == rectF.left && f7 == rectF.top && f9 == rectF.right && f10 == rectF.bottom) {
            return;
        }
        rectF.set(f, f7, f9, f10);
        invalidateSelf();
    }

    @Override // e3.k
    public final void g(Canvas canvas) {
        if (this.f2666L.f2664s.isEmpty()) {
            super.g(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.f2666L.f2664s);
        super.g(canvas);
        canvas.restore();
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f2666L = new e(this.f2666L);
        return this;
    }
}
