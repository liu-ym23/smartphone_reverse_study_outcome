package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: c, reason: collision with root package name */
    public float f9111c;

    /* renamed from: f, reason: collision with root package name */
    public float f9112f;

    /* renamed from: g, reason: collision with root package name */
    public p2.a f9113g;

    @Override // o2.c
    public final float T() {
        return this.f9112f;
    }

    @Override // o2.c
    public final float a() {
        return this.f9111c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(this.f9111c, eVar.f9111c) == 0 && Float.compare(this.f9112f, eVar.f9112f) == 0 && this.f9113g.equals(eVar.f9113g);
    }

    public final int hashCode() {
        return this.f9113g.hashCode() + k0.a.g(Float.hashCode(this.f9111c) * 31, this.f9112f, 31);
    }

    @Override // o2.c
    public final long n(float f5) {
        return com.stepos.statsrpk.h.C(this.f9113g.a(f5), 4294967296L);
    }

    public final String toString() {
        return "DensityWithConverter(density=" + this.f9111c + ", fontScale=" + this.f9112f + ", converter=" + this.f9113g + ')';
    }

    @Override // o2.c
    public final float u(long j10) {
        if (o.a(n.c(j10), 4294967296L)) {
            return this.f9113g.b(n.d(j10));
        }
        od.f.e("Only Sp can convert to Px");
        return 0.0f;
    }
}
