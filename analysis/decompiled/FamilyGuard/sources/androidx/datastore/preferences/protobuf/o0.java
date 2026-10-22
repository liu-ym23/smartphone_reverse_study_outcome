package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
abstract class o0<T, B> {
    o0() {
    }

    abstract void a(B b6, int i5, int i6);

    abstract void b(B b6, int i5, long j5);

    abstract void c(B b6, int i5, T t5);

    abstract void d(B b6, int i5, AbstractC0488h abstractC0488h);

    abstract void e(B b6, int i5, long j5);

    abstract B f(Object obj);

    abstract T g(Object obj);

    abstract int h(T t5);

    abstract int i(T t5);

    abstract void j(Object obj);

    abstract T k(T t5, T t6);

    final void l(B b6, g0 g0Var) {
        while (g0Var.A() != Integer.MAX_VALUE && m(b6, g0Var)) {
        }
    }

    final boolean m(B b6, g0 g0Var) throws B {
        int iA = g0Var.a();
        int iA2 = u0.a(iA);
        int iB = u0.b(iA);
        if (iB == 0) {
            e(b6, iA2, g0Var.M());
            return true;
        }
        if (iB == 1) {
            b(b6, iA2, g0Var.e());
            return true;
        }
        if (iB == 2) {
            d(b6, iA2, g0Var.D());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw B.d();
            }
            a(b6, iA2, g0Var.j());
            return true;
        }
        B bN = n();
        int iC = u0.c(iA2, 4);
        l(bN, g0Var);
        if (iC != g0Var.a()) {
            throw B.a();
        }
        c(b6, iA2, r(bN));
        return true;
    }

    abstract B n();

    abstract void o(Object obj, B b6);

    abstract void p(Object obj, T t5);

    abstract boolean q(g0 g0Var);

    abstract T r(B b6);

    abstract void s(T t5, v0 v0Var);

    abstract void t(T t5, v0 v0Var);
}
