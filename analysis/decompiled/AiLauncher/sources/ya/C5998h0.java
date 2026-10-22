package ya;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ya.C6017x;
import za.C6459e;

/* renamed from: ya.h0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5998h0 {
    public static final C5983a a(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        K0 K02 = s10.K0();
        if (K02 instanceof C5983a) {
            return (C5983a) K02;
        }
        return null;
    }

    public static final AbstractC5990d0 b(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        C5983a c5983aA = a(s10);
        if (c5983aA != null) {
            return c5983aA.T0();
        }
        return null;
    }

    public static final boolean c(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return s10.K0() instanceof C6017x;
    }

    public static final C5982Q d(C5982Q c5982q) {
        S s10;
        Collection<S> collectionE = c5982q.e();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionE, 10));
        Iterator<T> it = collectionE.iterator();
        boolean z10 = false;
        while (true) {
            s10 = null;
            if (!it.hasNext()) {
                break;
            }
            S sF = (S) it.next();
            if (H0.l(sF)) {
                sF = f(sF.K0(), false, 1, null);
                z10 = true;
            }
            arrayList.add(sF);
        }
        if (!z10) {
            return null;
        }
        S sN = c5982q.n();
        if (sN != null) {
            if (H0.l(sN)) {
                sN = f(sN.K0(), false, 1, null);
            }
            s10 = sN;
        }
        return new C5982Q(arrayList).t(s10);
    }

    public static final K0 e(K0 k02, boolean z10) {
        kotlin.jvm.internal.p.i(k02, "<this>");
        C6017x c6017xC = C6017x.a.c(C6017x.f44134d, k02, z10, false, 4, null);
        if (c6017xC != null) {
            return c6017xC;
        }
        AbstractC5990d0 abstractC5990d0G = g(k02);
        return abstractC5990d0G != null ? abstractC5990d0G : k02.L0(false);
    }

    public static /* synthetic */ K0 f(K0 k02, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return e(k02, z10);
    }

    public static final AbstractC5990d0 g(S s10) {
        C5982Q c5982qD;
        v0 v0VarH0 = s10.H0();
        C5982Q c5982q = v0VarH0 instanceof C5982Q ? (C5982Q) v0VarH0 : null;
        if (c5982q == null || (c5982qD = d(c5982q)) == null) {
            return null;
        }
        return c5982qD.l();
    }

    public static final AbstractC5990d0 h(AbstractC5990d0 abstractC5990d0, boolean z10) {
        kotlin.jvm.internal.p.i(abstractC5990d0, "<this>");
        C6017x c6017xC = C6017x.a.c(C6017x.f44134d, abstractC5990d0, z10, false, 4, null);
        if (c6017xC != null) {
            return c6017xC;
        }
        AbstractC5990d0 abstractC5990d0G = g(abstractC5990d0);
        return abstractC5990d0G == null ? abstractC5990d0.L0(false) : abstractC5990d0G;
    }

    public static /* synthetic */ AbstractC5990d0 i(AbstractC5990d0 abstractC5990d0, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(abstractC5990d0, z10);
    }

    public static final AbstractC5990d0 j(AbstractC5990d0 abstractC5990d0, AbstractC5990d0 abbreviatedType) {
        kotlin.jvm.internal.p.i(abstractC5990d0, "<this>");
        kotlin.jvm.internal.p.i(abbreviatedType, "abbreviatedType");
        return W.a(abstractC5990d0) ? abstractC5990d0 : new C5983a(abstractC5990d0, abbreviatedType);
    }

    public static final C6459e k(C6459e c6459e) {
        kotlin.jvm.internal.p.i(c6459e, "<this>");
        return new C6459e(c6459e.Q0(), c6459e.H0(), c6459e.S0(), c6459e.G0(), c6459e.I0(), true);
    }
}
