package d2;

import m.x;

/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: f, reason: collision with root package name */
    public final float f2781f;

    /* renamed from: g, reason: collision with root package name */
    public final float f2782g;

    /* renamed from: h, reason: collision with root package name */
    public final e2.a f2783h;

    public e(float f10, float f11, e2.a aVar) {
        this.f2781f = f10;
        this.f2782g = f11;
        this.f2783h = aVar;
    }

    @Override // d2.c
    public final float c() {
        return this.f2781f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(this.f2781f, eVar.f2781f) == 0 && Float.compare(this.f2782g, eVar.f2782g) == 0 && q7.k.a(this.f2783h, eVar.f2783h);
    }

    public final int hashCode() {
        return this.f2783h.hashCode() + x.d(this.f2782g, Float.hashCode(this.f2781f) * 31, 31);
    }

    @Override // d2.c
    public final float j() {
        return this.f2782g;
    }

    @Override // d2.c
    public final long n(float f10) {
        return s7.a.Q(this.f2783h.a(f10), 4294967296L);
    }

    @Override // d2.c
    public final float t(long j2) {
        if (o.a(n.b(j2), 4294967296L)) {
            return this.f2783h.b(n.c(j2));
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    public final String toString() {
        return "DensityWithConverter(density=" + this.f2781f + ", fontScale=" + this.f2782g + ", converter=" + this.f2783h + ')';
    }
}
