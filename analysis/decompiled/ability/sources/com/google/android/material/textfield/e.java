package com.google.android.material.textfield;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import e3.C1419h;

/* loaded from: classes3.dex */
public final class e extends C1419h {

    /* renamed from: s, reason: collision with root package name */
    public final RectF f2664s;

    public e(e3.p pVar, RectF rectF) {
        super(pVar);
        this.f2664s = rectF;
    }

    @Override // e3.C1419h, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        f fVar = new f(this);
        fVar.f2666L = this;
        fVar.invalidateSelf();
        return fVar;
    }

    public e(e eVar) {
        super(eVar);
        this.f2664s = eVar.f2664s;
    }
}
