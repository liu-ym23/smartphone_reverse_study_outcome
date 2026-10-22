package com.obric.common.oea.foundation.a.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import d.h.b.o;

/* JADX INFO: compiled from: BasicRoundCornerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32262b;

    public a() {
        this.f32262b = "BasicRoundCornerImpl";
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public String getType() {
        return this.f32262b;
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public Path a(float r1, float r2, float r3, float r4, float r5) {
        return b(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public void a(Canvas r9, Paint r10, float r11, float r12, float r13, float r14, float r15) {
        o.e(r9, "canvas");
        o.e(r10, "paint");
        r9.drawRoundRect(r11, r12, r13, r14, r15, r15, r10);
    }
}
