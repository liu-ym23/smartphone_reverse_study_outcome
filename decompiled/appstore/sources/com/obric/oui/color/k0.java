package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlendMode f12960c;

    public k0(float r10, int r11, BlendMode r12) {
        this.f12958a = r10;
        this.f12959b = r11;
        this.f12960c = r12;
    }

    public static k0 b(k0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new k0(r10.f12958a, r10.f12959b, r10.f12960c);
    }

    public static k0 f(k0 r10, k0 r11, float r12) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r11 != null) goto L6;
        return r10;
    L6:
        float r13 = Math.max(0.0f, Math.min(1.0f, r12));
        if (r13 > 0.0f) goto L10;
        return r10;
    L10:
        if (r13 < 1.0f) goto L12;
        return r11;
    L12:
        float r14 = r10.f12958a;
        return new k0(r14 + ((r11.f12958a - r14) * r13), androidx.core.graphics.d.c(r10.f12959b, r11.f12959b, r13), r10.f12960c);
    }

    public k0 a() {
        return b(this);
    }

    public BlendMode c() {
        return this.f12960c;
    }

    public int d() {
        return this.f12959b;
    }

    public float e() {
        return this.f12958a;
    }
}
