package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5748c;

    /* renamed from: d, reason: collision with root package name */
    public float f5749d;

    /* renamed from: e, reason: collision with root package name */
    public float f5750e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5751f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5752g;

    /* renamed from: h, reason: collision with root package name */
    public float f5753h;
    public float i;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Float.compare(this.f5748c, rVar.f5748c) == 0 && Float.compare(this.f5749d, rVar.f5749d) == 0 && Float.compare(this.f5750e, rVar.f5750e) == 0 && this.f5751f == rVar.f5751f && this.f5752g == rVar.f5752g && Float.compare(this.f5753h, rVar.f5753h) == 0 && Float.compare(this.i, rVar.i) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.i) + k0.a.g(k0.a.h(k0.a.h(k0.a.g(k0.a.g(Float.hashCode(this.f5748c) * 31, this.f5749d, 31), this.f5750e, 31), 31, this.f5751f), 31, this.f5752g), this.f5753h, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeArcTo(horizontalEllipseRadius=");
        sb2.append(this.f5748c);
        sb2.append(", verticalEllipseRadius=");
        sb2.append(this.f5749d);
        sb2.append(", theta=");
        sb2.append(this.f5750e);
        sb2.append(", isMoreThanHalf=");
        sb2.append(this.f5751f);
        sb2.append(", isPositiveArc=");
        sb2.append(this.f5752g);
        sb2.append(", arcStartDx=");
        sb2.append(this.f5753h);
        sb2.append(", arcStartDy=");
        return k0.a.q(sb2, this.i, ')');
    }
}
