package J8;

import D7.v;
import D7.w;
import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0285p;
import X8.C0281l;
import X8.F;
import X8.K;
import X8.N;
import X8.U;
import a9.InterfaceC0309a;
import a9.InterfaceC0310b;
import a9.InterfaceC0311c;
import a9.InterfaceC0312d;
import a9.InterfaceC0313e;
import h8.InterfaceC1507O;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import y8.C2142e;

/* loaded from: classes4.dex */
public final class l implements Y8.b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f888a;
    public final Y8.c b;

    public l(HashMap map, Y8.c equalityAxioms) {
        kotlin.jvm.internal.k.f(equalityAxioms, "equalityAxioms");
        this.f888a = map;
        this.b = equalityAxioms;
    }

    @Override // Y8.b
    public final A A(InterfaceC0310b interfaceC0310b) {
        A aY;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        AbstractC0285p abstractC0285pG = Y8.g.g(interfaceC0310b);
        if (abstractC0285pG != null && (aY = Y8.g.Y(abstractC0285pG)) != null) {
            return aY;
        }
        A aH = Y8.g.h(interfaceC0310b);
        kotlin.jvm.internal.k.c(aH);
        return aH;
    }

    @Override // Y8.b
    public final InterfaceC1507O B(InterfaceC0313e interfaceC0313e, int i) {
        return Y8.g.q(interfaceC0313e, i);
    }

    @Override // Y8.b
    public final boolean C(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        return Y8.g.G(W(interfaceC0311c)) && !Y8.g.H(interfaceC0311c);
    }

    @Override // Y8.b
    public final void D(InterfaceC0311c interfaceC0311c) {
        Y8.g.M(interfaceC0311c);
    }

    @Override // Y8.b
    public final void E(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        Y8.g.g(interfaceC0310b);
    }

    @Override // Y8.b
    public final F F(InterfaceC0310b interfaceC0310b) {
        return Y8.g.i(interfaceC0310b);
    }

    @Override // Y8.b
    public final boolean G(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        return Y8.g.y(Y8.g.W(interfaceC0311c));
    }

    @Override // Y8.b
    public final boolean H(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        return !kotlin.jvm.internal.k.b(Y8.g.W(X(interfaceC0310b)), Y8.g.W(A(interfaceC0310b)));
    }

    @Override // Y8.b
    public final boolean I(InterfaceC0309a receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        return receiver instanceof K8.a;
    }

    @Override // Y8.b
    public final boolean J(InterfaceC0313e interfaceC0313e) {
        return Y8.g.y(interfaceC0313e);
    }

    @Override // Y8.b
    public final U K(InterfaceC0311c interfaceC0311c, InterfaceC0311c interfaceC0311c2) {
        return Y8.g.m(this, interfaceC0311c, interfaceC0311c2);
    }

    @Override // Y8.b
    public final boolean L(InterfaceC0313e interfaceC0313e) {
        return Y8.g.E(interfaceC0313e);
    }

    @Override // Y8.b
    public final A M(C0281l c0281l) {
        return Y8.g.Q(c0281l);
    }

    @Override // Y8.b
    public final InterfaceC0312d N(InterfaceC0311c interfaceC0311c) {
        return Y8.g.d(interfaceC0311c);
    }

    @Override // Y8.b
    public final int O(InterfaceC0310b interfaceC0310b) {
        return Y8.g.c(interfaceC0310b);
    }

    @Override // Y8.b
    public final boolean P(InterfaceC1507O interfaceC1507O, InterfaceC0313e interfaceC0313e) {
        return Y8.g.v(interfaceC1507O, interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean Q(InterfaceC0313e interfaceC0313e) {
        return Y8.g.D(interfaceC0313e);
    }

    @Override // Y8.b
    public final U R(N n) {
        return Y8.g.r(n);
    }

    @Override // Y8.b
    public final N S(InterfaceC0310b interfaceC0310b, int i) {
        return Y8.g.p(interfaceC0310b, i);
    }

    @Override // Y8.b
    public final boolean T(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        return receiver instanceof C2142e;
    }

    @Override // Y8.b
    public final N U(K8.b bVar) {
        return Y8.g.T(bVar);
    }

    @Override // Y8.b
    public final boolean V(N n) {
        return Y8.g.K(n);
    }

    @Override // Y8.b
    public final K W(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        A aH = Y8.g.h(interfaceC0310b);
        if (aH == null) {
            aH = X(interfaceC0310b);
        }
        return Y8.g.W(aH);
    }

    @Override // Y8.b
    public final A X(InterfaceC0310b interfaceC0310b) {
        A aN;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        AbstractC0285p abstractC0285pG = Y8.g.g(interfaceC0310b);
        if (abstractC0285pG != null && (aN = Y8.g.N(abstractC0285pG)) != null) {
            return aN;
        }
        A aH = Y8.g.h(interfaceC0310b);
        kotlin.jvm.internal.k.c(aH);
        return aH;
    }

    @Override // Y8.b
    public final CaptureStatus Y(InterfaceC0309a interfaceC0309a) {
        return Y8.g.k(interfaceC0309a);
    }

    @Override // Y8.b
    public final int Z(InterfaceC0312d interfaceC0312d) {
        kotlin.jvm.internal.k.f(interfaceC0312d, "<this>");
        if (interfaceC0312d instanceof InterfaceC0311c) {
            return Y8.g.c((InterfaceC0310b) interfaceC0312d);
        }
        if (interfaceC0312d instanceof ArgumentList) {
            return ((ArgumentList) interfaceC0312d).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + interfaceC0312d + ", " + kotlin.jvm.internal.m.f4928a.b(interfaceC0312d.getClass())).toString());
    }

    @Override // Y8.b
    public final boolean a(InterfaceC0309a interfaceC0309a) {
        return Y8.g.J(interfaceC0309a);
    }

    @Override // Y8.b
    public final boolean a0(InterfaceC0313e interfaceC0313e) {
        return Y8.g.G(interfaceC0313e);
    }

    @Override // Y8.b
    public final TypeVariance b(InterfaceC1507O receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        Variance varianceR = receiver.r();
        kotlin.jvm.internal.k.e(varianceR, "getVariance(...)");
        return z2.l.p(varianceR);
    }

    @Override // Y8.b
    public final U b0(InterfaceC0310b interfaceC0310b) {
        return Y8.g.P(interfaceC0310b);
    }

    @Override // Y8.b
    public final InterfaceC0311c c(InterfaceC0311c interfaceC0311c) {
        A aQ;
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        C0281l c0281lF = Y8.g.f(interfaceC0311c);
        return (c0281lF == null || (aQ = Y8.g.Q(c0281lF)) == null) ? interfaceC0311c : aQ;
    }

    @Override // Y8.b
    public final C0281l c0(InterfaceC0311c interfaceC0311c) {
        return Y8.g.f(interfaceC0311c);
    }

    @Override // Y8.b
    public final Collection d(InterfaceC0311c interfaceC0311c) {
        return Y8.g.S(this, interfaceC0311c);
    }

    @Override // Y8.b
    public final U d0(InterfaceC0309a interfaceC0309a) {
        return Y8.g.O(interfaceC0309a);
    }

    @Override // Y8.b
    public final boolean e(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        return Y8.g.D(Y8.g.W(interfaceC0311c));
    }

    @Override // Y8.b
    public final int e0(InterfaceC0313e interfaceC0313e) {
        return Y8.g.R(interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean f(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        A aH = Y8.g.h(interfaceC0310b);
        return (aH != null ? Y8.g.f(aH) : null) != null;
    }

    @Override // Y8.b
    public final A f0(InterfaceC0311c interfaceC0311c, boolean z10) {
        return Y8.g.Z(interfaceC0311c, z10);
    }

    @Override // Y8.b
    public final K g(InterfaceC0311c interfaceC0311c) {
        return Y8.g.W(interfaceC0311c);
    }

    @Override // Y8.b
    public final InterfaceC0309a g0(InterfaceC0311c interfaceC0311c) {
        return Y8.g.e(this, interfaceC0311c);
    }

    @Override // Y8.b
    public final boolean h(InterfaceC0313e interfaceC0313e) {
        return Y8.g.x(interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean h0(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        A aH = Y8.g.h(interfaceC0311c);
        return (aH != null ? Y8.g.e(this, aH) : null) != null;
    }

    @Override // Y8.b
    public final A i(InterfaceC0311c interfaceC0311c) {
        CaptureStatus captureStatus = CaptureStatus.f5164a;
        return Y8.g.j(interfaceC0311c);
    }

    @Override // Y8.b
    public final Collection i0(InterfaceC0313e interfaceC0313e) {
        return Y8.g.V(interfaceC0313e);
    }

    @Override // Y8.b
    public final Y8.i j(InterfaceC0309a interfaceC0309a) {
        return Y8.g.X(interfaceC0309a);
    }

    @Override // Y8.b
    public final boolean j0(U u) {
        kotlin.jvm.internal.k.f(u, "<this>");
        return Y8.g.F(X(u)) != Y8.g.F(A(u));
    }

    @Override // Y8.b
    public final boolean k(InterfaceC0313e interfaceC0313e) {
        return Y8.g.z(interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean k0(InterfaceC0313e interfaceC0313e) {
        return Y8.g.A(interfaceC0313e);
    }

    @Override // Y8.b
    public final AbstractC0285p l(InterfaceC0310b interfaceC0310b) {
        return Y8.g.g(interfaceC0310b);
    }

    @Override // Y8.b
    public final void l0(InterfaceC0311c interfaceC0311c, InterfaceC0313e interfaceC0313e) {
    }

    @Override // Y8.b
    public final A m(InterfaceC0310b interfaceC0310b) {
        return Y8.g.h(interfaceC0310b);
    }

    @Override // Y8.b
    public final boolean n(InterfaceC0311c interfaceC0311c) {
        return Y8.g.B(interfaceC0311c);
    }

    @Override // Y8.b
    public final boolean o(InterfaceC0311c interfaceC0311c, InterfaceC0311c interfaceC0311c2) {
        return Y8.g.w(interfaceC0311c, interfaceC0311c2);
    }

    @Override // Y8.b
    public final boolean p(InterfaceC0311c interfaceC0311c) {
        return Y8.g.F(interfaceC0311c);
    }

    @Override // Y8.b
    public final TypeVariance q(N n) {
        return Y8.g.t(n);
    }

    @Override // Y8.b
    public final void r(InterfaceC0311c interfaceC0311c) {
        Y8.g.L(interfaceC0311c);
    }

    @Override // Y8.b
    public final A s(AbstractC0285p abstractC0285p) {
        return Y8.g.N(abstractC0285p);
    }

    @Override // Y8.b
    public final A t(AbstractC0285p abstractC0285p) {
        return Y8.g.Y(abstractC0285p);
    }

    @Override // Y8.b
    public final Y8.a u(InterfaceC0311c interfaceC0311c) {
        return Y8.g.U(this, interfaceC0311c);
    }

    @Override // Y8.b
    public final U v(ArrayList arrayList) {
        A a3;
        int size = arrayList.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (U) v.T0(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        boolean z10 = false;
        boolean z11 = false;
        while (it.hasNext()) {
            U u = (U) it.next();
            z10 = z10 || AbstractC0272c.k(u);
            if (u instanceof A) {
                a3 = (A) u;
            } else {
                if (!(u instanceof AbstractC0285p)) {
                    throw new NoWhenBranchMatchedException();
                }
                kotlin.jvm.internal.k.f(u, "<this>");
                a3 = ((AbstractC0285p) u).b;
                z11 = true;
            }
            arrayList2.add(a3);
        }
        if (z10) {
            return Z8.i.c(ErrorTypeKind.f5161x, arrayList.toString());
        }
        kotlin.reflect.jvm.internal.impl.types.checker.b bVar = kotlin.reflect.jvm.internal.impl.types.checker.b.f5146a;
        if (!z11) {
            return bVar.b(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(w.c0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(AbstractC0272c.E((U) it2.next()));
        }
        return AbstractC0272c.f(bVar.b(arrayList2), bVar.b(arrayList3));
    }

    @Override // Y8.b
    public final boolean w(InterfaceC0313e c12, InterfaceC0313e c2) {
        kotlin.jvm.internal.k.f(c12, "c1");
        kotlin.jvm.internal.k.f(c2, "c2");
        if (!(c12 instanceof K)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!(c2 instanceof K)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (Y8.g.b(c12, c2)) {
            return true;
        }
        K k = (K) c12;
        K k5 = (K) c2;
        if (this.b.e(k, k5)) {
            return true;
        }
        Map map = this.f888a;
        if (map == null) {
            return false;
        }
        K k10 = (K) map.get(k);
        K k11 = (K) map.get(k5);
        if (k10 == null || !k10.equals(k5)) {
            return k11 != null && k11.equals(k);
        }
        return true;
    }

    @Override // Y8.b
    public final N x(InterfaceC0312d interfaceC0312d, int i) {
        kotlin.jvm.internal.k.f(interfaceC0312d, "<this>");
        if (interfaceC0312d instanceof InterfaceC0311c) {
            return Y8.g.p((InterfaceC0310b) interfaceC0312d, i);
        }
        if (interfaceC0312d instanceof ArgumentList) {
            N n = ((ArgumentList) interfaceC0312d).get(i);
            kotlin.jvm.internal.k.e(n, "get(...)");
            return n;
        }
        throw new IllegalStateException(("unknown type argument list type: " + interfaceC0312d + ", " + kotlin.jvm.internal.m.f4928a.b(interfaceC0312d.getClass())).toString());
    }

    @Override // Y8.b
    public final N y(InterfaceC0311c interfaceC0311c, int i) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        if (i < 0 || i >= Y8.g.c(interfaceC0311c)) {
            return null;
        }
        return Y8.g.p(interfaceC0311c, i);
    }

    @Override // Y8.b
    public final InterfaceC0310b z(InterfaceC0310b interfaceC0310b) {
        return Y8.g.a0(this, interfaceC0310b);
    }
}
