package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5746c;

    /* renamed from: d, reason: collision with root package name */
    public float f5747d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Float.compare(this.f5746c, qVar.f5746c) == 0 && Float.compare(this.f5747d, qVar.f5747d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5747d) + (Float.hashCode(this.f5746c) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ReflectiveQuadTo(x=");
        sb2.append(this.f5746c);
        sb2.append(", y=");
        return k0.a.q(sb2, this.f5747d, ')');
    }
}
