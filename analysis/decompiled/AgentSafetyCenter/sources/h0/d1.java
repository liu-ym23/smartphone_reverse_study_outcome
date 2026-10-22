package h0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 implements t.t0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4945a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4946b;

    public d1(long j10, boolean z10) {
        this.f4945a = z10;
        this.f4946b = j10;
    }

    @Override // t.t0
    public final u1.l a(v.k kVar) {
        a1.g gVar = new a1.g(13, false);
        gVar.f19f = this;
        VarHandle.storeStoreFence();
        h0 h0Var = new h0();
        h0Var.f4992u = kVar;
        h0Var.f4993v = this.f4945a;
        h0Var.f4994w = Float.NaN;
        h0Var.f4995x = gVar;
        VarHandle.storeStoreFence();
        return h0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        if (this.f4945a == d1Var.f4945a && o2.f.b(Float.NaN, Float.NaN)) {
            return d1.p.d(this.f4946b, d1Var.f4946b);
        }
        return false;
    }

    public final int hashCode() {
        int iG = k0.a.g(Boolean.hashCode(this.f4945a) * 31, Float.NaN, 961);
        int i = d1.p.f3025h;
        return Long.hashCode(this.f4946b) + iG;
    }
}
