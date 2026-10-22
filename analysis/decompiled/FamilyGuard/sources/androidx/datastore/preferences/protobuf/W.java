package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0500u;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.u0;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class W<T> implements h0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final S f9975a;

    /* renamed from: b, reason: collision with root package name */
    private final o0<?, ?> f9976b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f9977c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0497q<?> f9978d;

    private W(o0<?, ?> o0Var, AbstractC0497q<?> abstractC0497q, S s5) {
        this.f9976b = o0Var;
        this.f9977c = abstractC0497q.e(s5);
        this.f9978d = abstractC0497q;
        this.f9975a = s5;
    }

    private <UT, UB> int j(o0<UT, UB> o0Var, T t5) {
        return o0Var.i(o0Var.g(t5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends C0500u.b<ET>> void k(o0<UT, UB> o0Var, AbstractC0497q<ET> abstractC0497q, T t5, g0 g0Var, C0496p c0496p) throws Throwable {
        o0<UT, UB> o0Var2;
        UB ubF = o0Var.f(t5);
        Object objD = abstractC0497q.d(t5);
        while (g0Var.A() != Integer.MAX_VALUE) {
            try {
                W w5 = this;
                o0Var2 = o0Var;
                AbstractC0497q<ET> abstractC0497q2 = abstractC0497q;
                g0 g0Var2 = g0Var;
                C0496p c0496p2 = c0496p;
                try {
                    if (!w5.m(g0Var2, c0496p2, abstractC0497q2, objD, o0Var2, ubF)) {
                        o0Var2.o(t5, ubF);
                        return;
                    }
                    this = w5;
                    g0Var = g0Var2;
                    c0496p = c0496p2;
                    abstractC0497q = abstractC0497q2;
                    o0Var = o0Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    o0Var2.o(t5, ubF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                o0Var2 = o0Var;
            }
        }
        o0Var.o(t5, ubF);
    }

    static <T> W<T> l(o0<?, ?> o0Var, AbstractC0497q<?> abstractC0497q, S s5) {
        return new W<>(o0Var, abstractC0497q, s5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends C0500u.b<ET>> boolean m(g0 g0Var, C0496p c0496p, AbstractC0497q<ET> abstractC0497q, C0500u<ET> c0500u, o0<UT, UB> o0Var, UB ub) throws B {
        int iA = g0Var.a();
        if (iA != u0.f10153a) {
            if (u0.b(iA) != 2) {
                return g0Var.H();
            }
            Object objB = abstractC0497q.b(c0496p, this.f9975a, u0.a(iA));
            if (objB == null) {
                return o0Var.m(ub, g0Var);
            }
            abstractC0497q.h(g0Var, objB, c0496p, c0500u);
            return true;
        }
        Object objB2 = null;
        int iO = 0;
        AbstractC0488h abstractC0488hD = null;
        while (g0Var.A() != Integer.MAX_VALUE) {
            int iA2 = g0Var.a();
            if (iA2 == u0.f10155c) {
                iO = g0Var.o();
                objB2 = abstractC0497q.b(c0496p, this.f9975a, iO);
            } else if (iA2 == u0.f10156d) {
                if (objB2 != null) {
                    abstractC0497q.h(g0Var, objB2, c0496p, c0500u);
                } else {
                    abstractC0488hD = g0Var.D();
                }
            } else if (!g0Var.H()) {
                break;
            }
        }
        if (g0Var.a() != u0.f10154b) {
            throw B.a();
        }
        if (abstractC0488hD != null) {
            if (objB2 != null) {
                abstractC0497q.i(abstractC0488hD, objB2, c0496p, c0500u);
            } else {
                o0Var.d(ub, iO, abstractC0488hD);
            }
        }
        return true;
    }

    private <UT, UB> void n(o0<UT, UB> o0Var, T t5, v0 v0Var) {
        o0Var.s(o0Var.g(t5), v0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void a(T t5, T t6) {
        j0.G(this.f9976b, t5, t6);
        if (this.f9977c) {
            j0.E(this.f9978d, t5, t6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void b(T t5, g0 g0Var, C0496p c0496p) throws Throwable {
        k(this.f9976b, this.f9978d, t5, g0Var, c0496p);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void c(T t5) {
        this.f9976b.j(t5);
        this.f9978d.f(t5);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean d(T t5) {
        return this.f9978d.c(t5).p();
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void e(T t5, v0 v0Var) {
        Iterator itS = this.f9978d.c(t5).s();
        while (itS.hasNext()) {
            Map.Entry entry = (Map.Entry) itS.next();
            C0500u.b bVar = (C0500u.b) entry.getKey();
            if (bVar.A() != u0.c.MESSAGE || bVar.c() || bVar.B()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof D.b) {
                v0Var.c(bVar.a(), ((D.b) entry).a().e());
            } else {
                v0Var.c(bVar.a(), entry.getValue());
            }
        }
        n(this.f9976b, t5, v0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public boolean f(T t5, T t6) {
        if (!this.f9976b.g(t5).equals(this.f9976b.g(t6))) {
            return false;
        }
        if (this.f9977c) {
            return this.f9978d.c(t5).equals(this.f9978d.c(t6));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public int g(T t5) {
        int iJ = j(this.f9976b, t5);
        return this.f9977c ? iJ + this.f9978d.c(t5).j() : iJ;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public T h() {
        return (T) this.f9975a.i().r();
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public int i(T t5) {
        int iHashCode = this.f9976b.g(t5).hashCode();
        return this.f9977c ? (iHashCode * 53) + this.f9978d.c(t5).hashCode() : iHashCode;
    }
}
