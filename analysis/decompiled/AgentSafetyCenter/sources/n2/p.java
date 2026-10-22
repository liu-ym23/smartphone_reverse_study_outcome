package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final p f8668c = new p(1.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f8669a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8670b;

    public p(float f5, float f10) {
        this.f8669a = f5;
        this.f8670b = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f8669a == pVar.f8669a && this.f8670b == pVar.f8670b;
    }

    public final int hashCode() {
        return Float.hashCode(this.f8670b) + (Float.hashCode(this.f8669a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TextGeometricTransform(scaleX=");
        sb2.append(this.f8669a);
        sb2.append(", skewX=");
        return k0.a.q(sb2, this.f8670b, ')');
    }
}
