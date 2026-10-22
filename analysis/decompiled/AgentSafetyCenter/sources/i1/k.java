package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5714c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5715d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5716e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5717f;

    /* renamed from: g, reason: collision with root package name */
    public final float f5718g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5719h;

    public k(float f5, float f10, float f11, float f12, float f13, float f14) {
        super(2);
        this.f5714c = f5;
        this.f5715d = f10;
        this.f5716e = f11;
        this.f5717f = f12;
        this.f5718g = f13;
        this.f5719h = f14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Float.compare(this.f5714c, kVar.f5714c) == 0 && Float.compare(this.f5715d, kVar.f5715d) == 0 && Float.compare(this.f5716e, kVar.f5716e) == 0 && Float.compare(this.f5717f, kVar.f5717f) == 0 && Float.compare(this.f5718g, kVar.f5718g) == 0 && Float.compare(this.f5719h, kVar.f5719h) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5719h) + k0.a.g(k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f5714c) * 31, this.f5715d, 31), this.f5716e, 31), this.f5717f, 31), this.f5718g, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CurveTo(x1=");
        sb2.append(this.f5714c);
        sb2.append(", y1=");
        sb2.append(this.f5715d);
        sb2.append(", x2=");
        sb2.append(this.f5716e);
        sb2.append(", y2=");
        sb2.append(this.f5717f);
        sb2.append(", x3=");
        sb2.append(this.f5718g);
        sb2.append(", y3=");
        return k0.a.q(sb2, this.f5719h, ')');
    }
}
