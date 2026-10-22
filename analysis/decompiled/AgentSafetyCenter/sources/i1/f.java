package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static int f5657k;

    /* renamed from: l, reason: collision with root package name */
    public static final f8.b f5658l = new f8.b(7);

    /* renamed from: a, reason: collision with root package name */
    public String f5659a;

    /* renamed from: b, reason: collision with root package name */
    public float f5660b;

    /* renamed from: c, reason: collision with root package name */
    public float f5661c;

    /* renamed from: d, reason: collision with root package name */
    public float f5662d;

    /* renamed from: e, reason: collision with root package name */
    public float f5663e;

    /* renamed from: f, reason: collision with root package name */
    public g0 f5664f;

    /* renamed from: g, reason: collision with root package name */
    public long f5665g;

    /* renamed from: h, reason: collision with root package name */
    public int f5666h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f5667j;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return yb.k.a(this.f5659a, fVar.f5659a) && o2.f.b(this.f5660b, fVar.f5660b) && o2.f.b(this.f5661c, fVar.f5661c) && this.f5662d == fVar.f5662d && this.f5663e == fVar.f5663e && this.f5664f.equals(fVar.f5664f) && d1.p.d(this.f5665g, fVar.f5665g) && this.f5666h == fVar.f5666h && this.i == fVar.i;
    }

    public final int hashCode() {
        int iHashCode = (this.f5664f.hashCode() + k0.a.g(k0.a.g(k0.a.g(k0.a.g(this.f5659a.hashCode() * 31, this.f5660b, 31), this.f5661c, 31), this.f5662d, 31), this.f5663e, 31)) * 31;
        long j10 = this.f5665g;
        int i = d1.p.f3025h;
        return Boolean.hashCode(this.i) + s.f.b(this.f5666h, k0.a.i(j10, iHashCode, 31), 31);
    }
}
