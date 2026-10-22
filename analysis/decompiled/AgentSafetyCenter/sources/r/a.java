package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public float f10241a;

    /* renamed from: b, reason: collision with root package name */
    public float f10242b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(this.f10241a, aVar.f10241a) == 0 && Float.compare(this.f10242b, aVar.f10242b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f10242b) + (Float.hashCode(this.f10241a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FlingResult(distanceCoefficient=");
        sb2.append(this.f10241a);
        sb2.append(", velocityCoefficient=");
        return k0.a.q(sb2, this.f10242b, ')');
    }
}
