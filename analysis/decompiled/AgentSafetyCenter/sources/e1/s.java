package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final float f3413a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3414b;

    public s(float f5, float f10) {
        this.f3413a = f5;
        this.f3414b = f10;
    }

    public final float[] a() {
        float f5 = this.f3413a;
        float f10 = this.f3414b;
        return new float[]{f5 / f10, 1.0f, ((1.0f - f5) - f10) / f10};
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Float.compare(this.f3413a, sVar.f3413a) == 0 && Float.compare(this.f3414b, sVar.f3414b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f3414b) + (Float.hashCode(this.f3413a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("WhitePoint(x=");
        sb2.append(this.f3413a);
        sb2.append(", y=");
        return k0.a.q(sb2, this.f3414b, ')');
    }
}
