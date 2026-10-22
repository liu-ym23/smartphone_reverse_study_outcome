package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 implements j1 {

    /* renamed from: c, reason: collision with root package name */
    public j1 f11099c;

    /* renamed from: f, reason: collision with root package name */
    public long f11100f;

    @Override // s.j1
    public final boolean a() {
        return this.f11099c.a();
    }

    @Override // s.j1
    public final long b(n nVar, n nVar2, n nVar3) {
        return this.f11099c.b(nVar, nVar2, nVar3) + this.f11100f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return q0Var.f11100f == this.f11100f && yb.k.a(q0Var.f11099c, this.f11099c);
    }

    @Override // s.j1
    public final n h(long j10, n nVar, n nVar2, n nVar3) {
        long j11 = this.f11100f;
        return j10 < j11 ? nVar3 : this.f11099c.h(j10 - j11, nVar, nVar2, nVar3);
    }

    public final int hashCode() {
        return Long.hashCode(this.f11100f) + (this.f11099c.hashCode() * 31);
    }

    @Override // s.j1
    public final n k(long j10, n nVar, n nVar2, n nVar3) {
        long j11 = this.f11100f;
        return j10 < j11 ? nVar : this.f11099c.k(j10 - j11, nVar, nVar2, nVar3);
    }
}
