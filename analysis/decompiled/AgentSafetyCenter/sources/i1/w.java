package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5765c;

    /* renamed from: d, reason: collision with root package name */
    public float f5766d;

    /* renamed from: e, reason: collision with root package name */
    public float f5767e;

    /* renamed from: f, reason: collision with root package name */
    public float f5768f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Float.compare(this.f5765c, wVar.f5765c) == 0 && Float.compare(this.f5766d, wVar.f5766d) == 0 && Float.compare(this.f5767e, wVar.f5767e) == 0 && Float.compare(this.f5768f, wVar.f5768f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5768f) + k0.a.g(k0.a.g(Float.hashCode(this.f5765c) * 31, this.f5766d, 31), this.f5767e, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeQuadTo(dx1=");
        sb2.append(this.f5765c);
        sb2.append(", dy1=");
        sb2.append(this.f5766d);
        sb2.append(", dx2=");
        sb2.append(this.f5767e);
        sb2.append(", dy2=");
        return k0.a.q(sb2, this.f5768f, ')');
    }
}
