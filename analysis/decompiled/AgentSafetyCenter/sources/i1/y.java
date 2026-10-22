package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5773c;

    /* renamed from: d, reason: collision with root package name */
    public float f5774d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Float.compare(this.f5773c, yVar.f5773c) == 0 && Float.compare(this.f5774d, yVar.f5774d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5774d) + (Float.hashCode(this.f5773c) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeReflectiveQuadTo(dx=");
        sb2.append(this.f5773c);
        sb2.append(", dy=");
        return k0.a.q(sb2, this.f5774d, ')');
    }
}
