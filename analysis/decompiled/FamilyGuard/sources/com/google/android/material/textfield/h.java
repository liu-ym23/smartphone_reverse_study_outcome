package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import t1.C1115h;

/* loaded from: classes.dex */
class h extends C1115h {

    /* renamed from: J, reason: collision with root package name */
    b f13319J;

    private static class c extends h {
        c(b bVar) {
            super(bVar);
        }

        @Override // t1.C1115h
        protected void w(Canvas canvas) {
            if (this.f13319J.f13320x.isEmpty()) {
                super.w(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.f13319J.f13320x);
            super.w(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h x0(b bVar) {
        return new c(bVar);
    }

    static h y0(t1.l lVar) {
        if (lVar == null) {
            lVar = new t1.l();
        }
        return x0(new b(lVar, new RectF()));
    }

    void A0() {
        B0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void B0(float f5, float f6, float f7, float f8) {
        if (f5 == this.f13319J.f13320x.left && f6 == this.f13319J.f13320x.top && f7 == this.f13319J.f13320x.right && f8 == this.f13319J.f13320x.bottom) {
            return;
        }
        this.f13319J.f13320x.set(f5, f6, f7, f8);
        invalidateSelf();
    }

    void C0(RectF rectF) {
        B0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f13319J = new b(this.f13319J);
        return this;
    }

    boolean z0() {
        return !this.f13319J.f13320x.isEmpty();
    }

    private static final class b extends C1115h.c {

        /* renamed from: x, reason: collision with root package name */
        private final RectF f13320x;

        @Override // t1.C1115h.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVarX0 = h.x0(this);
            hVarX0.invalidateSelf();
            return hVarX0;
        }

        private b(t1.l lVar, RectF rectF) {
            super(lVar, null);
            this.f13320x = rectF;
        }

        private b(b bVar) {
            super(bVar);
            this.f13320x = bVar.f13320x;
        }
    }

    private h(b bVar) {
        super(bVar);
        this.f13319J = bVar;
    }
}
