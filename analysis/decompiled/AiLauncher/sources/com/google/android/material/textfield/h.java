package com.google.android.material.textfield;

import Z2.h;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class h extends Z2.h {

    /* renamed from: J, reason: collision with root package name */
    public b f21586J;

    public static class c extends h {
        public c(b bVar) {
            super(bVar);
        }

        @Override // Z2.h
        public void w(Canvas canvas) {
            if (this.f21586J.f21587x.isEmpty()) {
                super.w(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.f21586J.f21587x);
            super.w(canvas);
            canvas.restore();
        }
    }

    public static h x0(Z2.l lVar) {
        if (lVar == null) {
            lVar = new Z2.l();
        }
        return y0(new b(lVar, new RectF()));
    }

    public static h y0(b bVar) {
        return new c(bVar);
    }

    public void A0() {
        B0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void B0(float f10, float f11, float f12, float f13) {
        if (f10 == this.f21586J.f21587x.left && f11 == this.f21586J.f21587x.top && f12 == this.f21586J.f21587x.right && f13 == this.f21586J.f21587x.bottom) {
            return;
        }
        this.f21586J.f21587x.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    public void C0(RectF rectF) {
        B0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f21586J = new b(this.f21586J);
        return this;
    }

    public boolean z0() {
        return !this.f21586J.f21587x.isEmpty();
    }

    public static final class b extends h.c {

        /* renamed from: x, reason: collision with root package name */
        public final RectF f21587x;

        @Override // Z2.h.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVarY0 = h.y0(this);
            hVarY0.invalidateSelf();
            return hVarY0;
        }

        public b(Z2.l lVar, RectF rectF) {
            super(lVar, null);
            this.f21587x = rectF;
        }

        public b(b bVar) {
            super(bVar);
            this.f21587x = bVar.f21587x;
        }
    }

    public h(b bVar) {
        super(bVar);
        this.f21586J = bVar;
    }
}
