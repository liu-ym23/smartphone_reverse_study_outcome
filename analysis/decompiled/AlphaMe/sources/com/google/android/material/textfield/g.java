package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class g extends y1.j {

    /* renamed from: I, reason: collision with root package name */
    public static final /* synthetic */ int f11013I = 0;

    /* renamed from: H, reason: collision with root package name */
    public f f11014H;

    @Override // y1.j
    public final void g(Canvas canvas) {
        if (this.f11014H.f11012w.isEmpty()) {
            super.g(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.f11014H.f11012w);
        super.g(canvas);
        canvas.restore();
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final /* bridge */ /* synthetic */ Drawable mutate() {
        u();
        return this;
    }

    public final Drawable u() {
        this.f11014H = new f(this.f11014H);
        return this;
    }

    public final void v(float f4, float f5, float f6, float f7) {
        RectF rectF = this.f11014H.f11012w;
        if (f4 == rectF.left && f5 == rectF.top && f6 == rectF.right && f7 == rectF.bottom) {
            return;
        }
        rectF.set(f4, f5, f6, f7);
        invalidateSelf();
    }
}
