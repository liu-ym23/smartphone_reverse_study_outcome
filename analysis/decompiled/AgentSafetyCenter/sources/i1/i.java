package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5701c;

    /* renamed from: d, reason: collision with root package name */
    public float f5702d;

    /* renamed from: e, reason: collision with root package name */
    public float f5703e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5704f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5705g;

    /* renamed from: h, reason: collision with root package name */
    public float f5706h;
    public float i;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Float.compare(this.f5701c, iVar.f5701c) == 0 && Float.compare(this.f5702d, iVar.f5702d) == 0 && Float.compare(this.f5703e, iVar.f5703e) == 0 && this.f5704f == iVar.f5704f && this.f5705g == iVar.f5705g && Float.compare(this.f5706h, iVar.f5706h) == 0 && Float.compare(this.i, iVar.i) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.i) + k0.a.g(k0.a.h(k0.a.h(k0.a.g(k0.a.g(Float.hashCode(this.f5701c) * 31, this.f5702d, 31), this.f5703e, 31), 31, this.f5704f), 31, this.f5705g), this.f5706h, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ArcTo(horizontalEllipseRadius=");
        sb2.append(this.f5701c);
        sb2.append(", verticalEllipseRadius=");
        sb2.append(this.f5702d);
        sb2.append(", theta=");
        sb2.append(this.f5703e);
        sb2.append(", isMoreThanHalf=");
        sb2.append(this.f5704f);
        sb2.append(", isPositiveArc=");
        sb2.append(this.f5705g);
        sb2.append(", arcStartX=");
        sb2.append(this.f5706h);
        sb2.append(", arcStartY=");
        return k0.a.q(sb2, this.i, ')');
    }
}
