package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5754c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5755d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5756e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5757f;

    /* renamed from: g, reason: collision with root package name */
    public final float f5758g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5759h;

    public s(float f5, float f10, float f11, float f12, float f13, float f14) {
        super(2);
        this.f5754c = f5;
        this.f5755d = f10;
        this.f5756e = f11;
        this.f5757f = f12;
        this.f5758g = f13;
        this.f5759h = f14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Float.compare(this.f5754c, sVar.f5754c) == 0 && Float.compare(this.f5755d, sVar.f5755d) == 0 && Float.compare(this.f5756e, sVar.f5756e) == 0 && Float.compare(this.f5757f, sVar.f5757f) == 0 && Float.compare(this.f5758g, sVar.f5758g) == 0 && Float.compare(this.f5759h, sVar.f5759h) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5759h) + k0.a.g(k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f5754c) * 31, this.f5755d, 31), this.f5756e, 31), this.f5757f, 31), this.f5758g, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeCurveTo(dx1=");
        sb2.append(this.f5754c);
        sb2.append(", dy1=");
        sb2.append(this.f5755d);
        sb2.append(", dx2=");
        sb2.append(this.f5756e);
        sb2.append(", dy2=");
        sb2.append(this.f5757f);
        sb2.append(", dx3=");
        sb2.append(this.f5758g);
        sb2.append(", dy3=");
        return k0.a.q(sb2, this.f5759h, ')');
    }
}
