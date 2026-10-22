package la;

import b0.e2;

/* loaded from: classes.dex */
public final class r0 implements o0 {

    /* renamed from: f, reason: collision with root package name */
    public final long f5993f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5994g;

    public r0(long j2, long j4) {
        this.f5993f = j2;
        this.f5994g = j4;
        if (j2 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j2 + " ms) cannot be negative").toString());
        }
        if (j4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j4 + " ms) cannot be negative").toString());
    }

    @Override // la.o0
    public final j a(ma.w wVar) {
        q0 q0Var = new q0(this, null);
        int i2 = u.f6012a;
        ma.k kVar = new ma.k(q0Var, wVar, g7.m.f3866f, -2, ka.a.f5661f);
        int i10 = 2;
        return k0.h(new q6.b(23, kVar, new e2(i10, null, i10)));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f5993f == r0Var.f5993f && this.f5994g == r0Var.f5994g;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5994g) + (Long.hashCode(this.f5993f) * 31);
    }

    public final String toString() {
        e7.c cVar = new e7.c(2);
        long j2 = this.f5993f;
        if (j2 > 0) {
            cVar.add("stopTimeout=" + j2 + "ms");
        }
        long j4 = this.f5994g;
        if (j4 < Long.MAX_VALUE) {
            cVar.add("replayExpiration=" + j4 + "ms");
        }
        return a1.a.l(new StringBuilder("SharingStarted.WhileSubscribed("), d7.r.U0(a.a.e(cVar), null, null, null, null, 63), ')');
    }
}
