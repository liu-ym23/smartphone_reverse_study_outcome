package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public u f10943a;

    /* renamed from: b, reason: collision with root package name */
    public long f10944b;

    @Override // s.h
    public final j1 a(n6.a aVar) {
        k1 k1VarA = this.f10943a.a(aVar);
        long j10 = this.f10944b;
        m1 m1Var = new m1();
        m1Var.f11054c = k1VarA;
        m1Var.f11055f = (k1VarA.r() + k1VarA.o()) * 1000000;
        m1Var.f11056g = j10 * 1000000;
        VarHandle.storeStoreFence();
        return m1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return b0Var.f10943a.equals(this.f10943a) && b0Var.f10944b == this.f10944b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10944b) + ((f.c(1) + (this.f10943a.hashCode() * 31)) * 31);
    }
}
