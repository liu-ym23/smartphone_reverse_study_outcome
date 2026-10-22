package n;

/* loaded from: classes.dex */
public final class k1 implements h1 {

    /* renamed from: f, reason: collision with root package name */
    public final i1 f6645f;

    /* renamed from: g, reason: collision with root package name */
    public final long f6646g;

    /* renamed from: h, reason: collision with root package name */
    public final long f6647h;

    public k1(i1 i1Var, long j2) {
        this.f6645f = i1Var;
        this.f6646g = (i1Var.v() + i1Var.m()) * 1000000;
        this.f6647h = j2 * 1000000;
    }

    @Override // n.h1
    public final boolean a() {
        return true;
    }

    public final long b(long j2) {
        long j4 = j2 + this.f6647h;
        if (j4 <= 0) {
            return 0L;
        }
        long j10 = this.f6646g;
        return j4 - ((j4 / j10) * j10);
    }

    @Override // n.h1
    public final long c(n nVar, n nVar2, n nVar3) {
        return Long.MAX_VALUE;
    }

    public final n d(long j2, n nVar, n nVar2, n nVar3) {
        long j4 = this.f6647h;
        long j10 = j2 + j4;
        long j11 = this.f6646g;
        return j10 > j11 ? this.f6645f.r(j11 - j4, nVar, nVar3, nVar2) : nVar2;
    }

    @Override // n.h1
    public final n r(long j2, n nVar, n nVar2, n nVar3) {
        return this.f6645f.r(b(j2), nVar, nVar2, d(j2, nVar, nVar3, nVar2));
    }

    @Override // n.h1
    public final n s(long j2, n nVar, n nVar2, n nVar3) {
        return this.f6645f.s(b(j2), nVar, nVar2, d(j2, nVar, nVar3, nVar2));
    }
}
