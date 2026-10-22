package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import y4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class e extends y4.g {
    public static final /* synthetic */ int I = 0;
    public a H;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends e {
        @Override // y4.g
        public final void f(Canvas canvas) {
            if (this.H.r.isEmpty()) {
                super.f(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.H.r);
            super.f(canvas);
            canvas.restore();
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.H = new a(this.H);
        return this;
    }

    public final void t(float f8, float f9, float f10, float f11) {
        RectF rectF = this.H.r;
        if (f8 == rectF.left && f9 == rectF.top && f10 == rectF.right && f11 == rectF.bottom) {
            return;
        }
        rectF.set(f8, f9, f10, f11);
        invalidateSelf();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends g.c {
        public final RectF r;

        public a(y4.j jVar, RectF rectF) {
            super(jVar);
            this.r = rectF;
        }

        @Override // y4.g.c, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            b bVar = new b(this);
            bVar.H = this;
            bVar.invalidateSelf();
            return bVar;
        }

        public a(a aVar) {
            super(aVar);
            this.r = aVar.r;
        }
    }
}
