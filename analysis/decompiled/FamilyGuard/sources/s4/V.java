package s4;

import V3.n;
import x4.C1298J;
import x4.C1310j;

/* loaded from: classes.dex */
public final class V {
    public static final <T> void a(U<? super T> u5, int i5) {
        Z3.e<? super T> eVarG = u5.g();
        boolean z5 = i5 == 4;
        if (z5 || !(eVarG instanceof C1310j) || b(i5) != b(u5.f20322c)) {
            d(u5, eVarG, z5);
            return;
        }
        AbstractC1056E abstractC1056E = ((C1310j) eVarG).f23857d;
        Z3.i context = eVarG.getContext();
        if (abstractC1056E.c0(context)) {
            abstractC1056E.Y(context, u5);
        } else {
            e(u5);
        }
    }

    public static final boolean b(int i5) {
        return i5 == 1 || i5 == 2;
    }

    public static final boolean c(int i5) {
        return i5 == 2;
    }

    public static final <T> void d(U<? super T> u5, Z3.e<? super T> eVar, boolean z5) {
        Object objJ;
        Object objL = u5.l();
        Throwable thI = u5.i(objL);
        if (thI != null) {
            n.a aVar = V3.n.f5531a;
            objJ = V3.o.a(thI);
        } else {
            n.a aVar2 = V3.n.f5531a;
            objJ = u5.j(objL);
        }
        Object objA = V3.n.a(objJ);
        if (!z5) {
            eVar.resumeWith(objA);
            return;
        }
        j4.k.e(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C1310j c1310j = (C1310j) eVar;
        Z3.e<T> eVar2 = c1310j.f23858e;
        Object obj = c1310j.f23860g;
        Z3.i context = eVar2.getContext();
        Object objC = C1298J.c(context, obj);
        J0<?> j0G = objC != C1298J.f23835a ? C1055D.g(eVar2, context, objC) : null;
        try {
            c1310j.f23858e.resumeWith(objA);
            V3.v vVar = V3.v.f5542a;
            if (j0G == null || j0G.N0()) {
                C1298J.a(context, objC);
            }
        } catch (Throwable th) {
            if (j0G == null || j0G.N0()) {
                C1298J.a(context, objC);
            }
            throw th;
        }
    }

    private static final void e(U<?> u5) {
        AbstractC1061a0 abstractC1061a0B = H0.f20303a.b();
        if (abstractC1061a0B.p0()) {
            abstractC1061a0B.l0(u5);
            return;
        }
        abstractC1061a0B.n0(true);
        try {
            d(u5, u5.g(), true);
            do {
            } while (abstractC1061a0B.w0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
