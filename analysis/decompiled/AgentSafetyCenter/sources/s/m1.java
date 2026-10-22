package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m1 implements j1 {

    /* renamed from: c, reason: collision with root package name */
    public k1 f11054c;

    /* renamed from: f, reason: collision with root package name */
    public long f11055f;

    /* renamed from: g, reason: collision with root package name */
    public long f11056g;

    @Override // s.j1
    public final boolean a() {
        return true;
    }

    @Override // s.j1
    public final long b(n nVar, n nVar2, n nVar3) {
        return Long.MAX_VALUE;
    }

    public final long c(long j10) {
        long j11 = j10 + this.f11056g;
        if (j11 <= 0) {
            return 0L;
        }
        long j12 = this.f11055f;
        return j11 - ((j11 / j12) * j12);
    }

    public final n d(long j10, n nVar, n nVar2, n nVar3) {
        long j11 = this.f11056g;
        long j12 = j10 + j11;
        long j13 = this.f11055f;
        return j12 > j13 ? this.f11054c.h(j13 - j11, nVar, nVar3, nVar2) : nVar2;
    }

    @Override // s.j1
    public final n h(long j10, n nVar, n nVar2, n nVar3) {
        return this.f11054c.h(c(j10), nVar, nVar2, d(j10, nVar, nVar3, nVar2));
    }

    @Override // s.j1
    public final n k(long j10, n nVar, n nVar2, n nVar3) {
        return this.f11054c.k(c(j10), nVar, nVar2, d(j10, nVar, nVar3, nVar2));
    }
}
