package com.obric.oui.color;

/* JADX INFO: compiled from: StrokeConfigCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f34507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.oui.a.a f34509c;

    public f(float r1, int r2, com.obric.oui.a.a r3) {
        this.f34507a = r1;
        this.f34508b = r2;
        this.f34509c = r3;
    }

    public float a() {
        return this.f34507a;
    }

    public int b() {
        return this.f34508b;
    }

    public com.obric.oui.a.a c() {
        return this.f34509c;
    }

    public f d() {
        return a(this);
    }

    public static f a(f r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new f(r3.f34507a, r3.f34508b, r3.f34509c);
    }

    public static f a(f r2, f r3, float r4) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L6;
        return r2;
    L6:
        float r5 = Math.max(0.0f, Math.min(1.0f, r4));
        if (r5 > 0.0f) goto L10;
        return r2;
    L10:
        if (r5 < 1.0f) goto L12;
        return r3;
    L12:
        float r0 = r2.f34507a;
        return new f(r0 + ((r3.f34507a - r0) * r5), androidx.core.graphics.e.a(r2.f34508b, r3.f34508b, r5), r2.f34509c);
    }
}
