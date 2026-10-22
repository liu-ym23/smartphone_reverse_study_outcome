package v0;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final float f10345a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10346b;

    public s(float f10, float f11) {
        this.f10345a = f10;
        this.f10346b = f11;
    }

    public final float[] a() {
        float f10 = this.f10345a;
        float f11 = this.f10346b;
        return new float[]{f10 / f11, 1.0f, ((1.0f - f10) - f11) / f11};
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Float.compare(this.f10345a, sVar.f10345a) == 0 && Float.compare(this.f10346b, sVar.f10346b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f10346b) + (Float.hashCode(this.f10345a) * 31);
    }

    public final String toString() {
        return "WhitePoint(x=" + this.f10345a + ", y=" + this.f10346b + ')';
    }
}
