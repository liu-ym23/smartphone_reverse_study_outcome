package com.obric.common.oea.foundation.animation.spec.spring;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f11548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f11549b;

    public a(double r10, double r11) {
        this.f11548a = r10;
        this.f11549b = r11;
    }

    public static final /* synthetic */ double a(a r10) {
        return r10.f11549b;
    }

    public static final /* synthetic */ double b(a r10) {
        return r10.f11548a;
    }

    public static final /* synthetic */ void c(a r10, double r11) {
        r10.f11549b = r11;
    }

    public static final /* synthetic */ void d(a r10, double r11) {
        r10.f11548a = r11;
    }

    public final double e() {
        return this.f11549b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        if (Double.compare(this.f11548a, r11.f11548a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f11549b, r11.f11549b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final double f() {
        return this.f11548a;
    }

    public int hashCode() {
        return (Double.hashCode(this.f11548a) * 31) + Double.hashCode(this.f11549b);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this.f11548a + ", _imaginary=" + this.f11549b + ")";
    }
}
