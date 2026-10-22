package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public x f11094a;

    /* renamed from: b, reason: collision with root package name */
    public long f11095b;

    @Override // s.h
    public final j1 a(n6.a aVar) {
        j1 j1VarA = this.f11094a.a(aVar);
        long j10 = this.f11095b;
        q0 q0Var = new q0();
        q0Var.f11099c = j1VarA;
        q0Var.f11100f = j10;
        VarHandle.storeStoreFence();
        return q0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return p0Var.f11095b == this.f11095b && yb.k.a(p0Var.f11094a, this.f11094a);
    }

    public final int hashCode() {
        return Long.hashCode(this.f11095b) + (this.f11094a.hashCode() * 31);
    }
}
