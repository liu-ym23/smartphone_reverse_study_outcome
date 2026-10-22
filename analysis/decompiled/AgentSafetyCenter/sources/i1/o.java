package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5738c;

    /* renamed from: d, reason: collision with root package name */
    public float f5739d;

    /* renamed from: e, reason: collision with root package name */
    public float f5740e;

    /* renamed from: f, reason: collision with root package name */
    public float f5741f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Float.compare(this.f5738c, oVar.f5738c) == 0 && Float.compare(this.f5739d, oVar.f5739d) == 0 && Float.compare(this.f5740e, oVar.f5740e) == 0 && Float.compare(this.f5741f, oVar.f5741f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5741f) + k0.a.g(k0.a.g(Float.hashCode(this.f5738c) * 31, this.f5739d, 31), this.f5740e, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("QuadTo(x1=");
        sb2.append(this.f5738c);
        sb2.append(", y1=");
        sb2.append(this.f5739d);
        sb2.append(", x2=");
        sb2.append(this.f5740e);
        sb2.append(", y2=");
        return k0.a.q(sb2, this.f5741f, ')');
    }
}
