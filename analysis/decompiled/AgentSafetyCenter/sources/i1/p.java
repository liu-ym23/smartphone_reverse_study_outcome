package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5742c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5743d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5744e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5745f;

    public p(float f5, float f10, float f11, float f12) {
        super(2);
        this.f5742c = f5;
        this.f5743d = f10;
        this.f5744e = f11;
        this.f5745f = f12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Float.compare(this.f5742c, pVar.f5742c) == 0 && Float.compare(this.f5743d, pVar.f5743d) == 0 && Float.compare(this.f5744e, pVar.f5744e) == 0 && Float.compare(this.f5745f, pVar.f5745f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5745f) + k0.a.g(k0.a.g(Float.hashCode(this.f5742c) * 31, this.f5743d, 31), this.f5744e, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ReflectiveCurveTo(x1=");
        sb2.append(this.f5742c);
        sb2.append(", y1=");
        sb2.append(this.f5743d);
        sb2.append(", x2=");
        sb2.append(this.f5744e);
        sb2.append(", y2=");
        return k0.a.q(sb2, this.f5745f, ')');
    }
}
