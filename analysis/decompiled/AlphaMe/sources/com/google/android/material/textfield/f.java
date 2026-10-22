package com.google.android.material.textfield;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f extends y1.h {

    /* renamed from: w, reason: collision with root package name */
    public final RectF f11012w;

    public f(y1.n nVar, RectF rectF) {
        super(nVar);
        this.f11012w = rectF;
    }

    @Override // y1.h, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.f11014H = this;
        gVar.invalidateSelf();
        return gVar;
    }

    public f(f fVar) {
        super(fVar);
        this.f11012w = fVar.f11012w;
    }
}
