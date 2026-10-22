package c2;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final p f1880c = new p(1.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f1881a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1882b;

    public p(float f10, float f11) {
        this.f1881a = f10;
        this.f1882b = f11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1881a == pVar.f1881a && this.f1882b == pVar.f1882b;
    }

    public final int hashCode() {
        return Float.hashCode(this.f1882b) + (Float.hashCode(this.f1881a) * 31);
    }

    public final String toString() {
        return "TextGeometricTransform(scaleX=" + this.f1881a + ", skewX=" + this.f1882b + ')';
    }
}
