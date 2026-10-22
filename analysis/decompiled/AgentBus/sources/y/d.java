package y;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f11368a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11369b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11370c;

    /* renamed from: d, reason: collision with root package name */
    public final float f11371d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11372e;

    public d(float f10, float f11, float f12, float f13, float f14) {
        this.f11368a = f10;
        this.f11369b = f11;
        this.f11370c = f12;
        this.f11371d = f13;
        this.f11372e = f14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return d2.f.a(this.f11368a, dVar.f11368a) && d2.f.a(this.f11369b, dVar.f11369b) && d2.f.a(this.f11370c, dVar.f11370c) && d2.f.a(this.f11371d, dVar.f11371d) && d2.f.a(this.f11372e, dVar.f11372e);
    }

    public final int hashCode() {
        return Float.hashCode(this.f11372e) + m.x.d(this.f11371d, m.x.d(this.f11370c, m.x.d(this.f11369b, Float.hashCode(this.f11368a) * 31, 31), 31), 31);
    }
}
