package Y8;

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
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import y8.C2142e;

/* loaded from: classes4.dex */
public final class m implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final m f1578a = new m();

    @Override // Y8.b
    public final A A(InterfaceC0310b interfaceC0310b) {
        A aY;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        AbstractC0285p abstractC0285pG = g.g(interfaceC0310b);
        if (abstractC0285pG != null && (aY = g.Y(abstractC0285pG)) != null) {
            return aY;
        }
        A aH = g.h(interfaceC0310b);
        kotlin.jvm.internal.k.c(aH);
        return aH;
    }

    @Override // Y8.b
    public final InterfaceC1507O B(InterfaceC0313e interfaceC0313e, int i) {
        return g.q(interfaceC0313e, i);
    }

    @Override // Y8.b
    public final boolean C(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        return g.G(W(interfaceC0311c)) && !g.H(interfaceC0311c);
    }

    @Override // Y8.b
    public final void D(InterfaceC0311c interfaceC0311c) {
        g.M(interfaceC0311c);
    }

    @Override // Y8.b
    public final void E(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        g.g(interfaceC0310b);
    }

    @Override // Y8.b
    public final F F(InterfaceC0310b interfaceC0310b) {
        return g.i(interfaceC0310b);
    }

    @Override // Y8.b
    public final boolean G(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        return g.y(g.W(interfaceC0311c));
    }

    @Override // Y8.b
    public final boolean H(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        return !kotlin.jvm.internal.k.b(g.W(X(interfaceC0310b)), g.W(A(interfaceC0310b)));
    }

    @Override // Y8.b
    public final boolean I(InterfaceC0309a receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        return receiver instanceof K8.a;
    }

    @Override // Y8.b
    public final boolean J(InterfaceC0313e interfaceC0313e) {
        return g.y(interfaceC0313e);
    }

    @Override // Y8.b
    public final U K(InterfaceC0311c interfaceC0311c, InterfaceC0311c interfaceC0311c2) {
        return g.m(this, interfaceC0311c, interfaceC0311c2);
    }

    @Override // Y8.b
    public final boolean L(InterfaceC0313e interfaceC0313e) {
        return g.E(interfaceC0313e);
    }

    @Override // Y8.b
    public final A M(C0281l c0281l) {
        return g.Q(c0281l);
    }

    @Override // Y8.b
    public final InterfaceC0312d N(InterfaceC0311c interfaceC0311c) {
        return g.d(interfaceC0311c);
    }

    @Override // Y8.b
    public final int O(InterfaceC0310b interfaceC0310b) {
        return g.c(interfaceC0310b);
    }

    @Override // Y8.b
    public final boolean P(InterfaceC1507O interfaceC1507O, InterfaceC0313e interfaceC0313e) {
        return g.v(interfaceC1507O, interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean Q(InterfaceC0313e interfaceC0313e) {
        return g.D(interfaceC0313e);
    }

    @Override // Y8.b
    public final U R(N n) {
        return g.r(n);
    }

    @Override // Y8.b
    public final N S(InterfaceC0310b interfaceC0310b, int i) {
        return g.p(interfaceC0310b, i);
    }

    @Override // Y8.b
    public final boolean T(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        return receiver instanceof C2142e;
    }

    @Override // Y8.b
    public final N U(K8.b bVar) {
        return g.T(bVar);
    }

    @Override // Y8.b
    public final boolean V(N n) {
        return g.K(n);
    }

    @Override // Y8.b
    public final K W(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        A aH = g.h(interfaceC0310b);
        if (aH == null) {
            aH = X(interfaceC0310b);
        }
        return g.W(aH);
    }

    @Override // Y8.b
    public final A X(InterfaceC0310b interfaceC0310b) {
        A aN;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        AbstractC0285p abstractC0285pG = g.g(interfaceC0310b);
        if (abstractC0285pG != null && (aN = g.N(abstractC0285pG)) != null) {
            return aN;
        }
        A aH = g.h(interfaceC0310b);
        kotlin.jvm.internal.k.c(aH);
        return aH;
    }

    @Override // Y8.b
    public final CaptureStatus Y(InterfaceC0309a interfaceC0309a) {
        return g.k(interfaceC0309a);
    }

    @Override // Y8.b
    public final int Z(InterfaceC0312d interfaceC0312d) {
        kotlin.jvm.internal.k.f(interfaceC0312d, "<this>");
        if (interfaceC0312d instanceof InterfaceC0311c) {
            return g.c((InterfaceC0310b) interfaceC0312d);
        }
        if (interfaceC0312d instanceof ArgumentList) {
            return ((ArgumentList) interfaceC0312d).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + interfaceC0312d + ", " + kotlin.jvm.internal.m.f4928a.b(interfaceC0312d.getClass())).toString());
    }

    @Override // Y8.b
    public final boolean a(InterfaceC0309a interfaceC0309a) {
        return g.J(interfaceC0309a);
    }

    @Override // Y8.b
    public final boolean a0(InterfaceC0313e interfaceC0313e) {
        return g.G(interfaceC0313e);
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
        return g.P(interfaceC0310b);
    }

    @Override // Y8.b
    public final InterfaceC0311c c(InterfaceC0311c interfaceC0311c) {
        A aQ;
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        C0281l c0281lF = g.f(interfaceC0311c);
        return (c0281lF == null || (aQ = g.Q(c0281lF)) == null) ? interfaceC0311c : aQ;
    }

    @Override // Y8.b
    public final C0281l c0(InterfaceC0311c interfaceC0311c) {
        return g.f(interfaceC0311c);
    }

    @Override // Y8.b
    public final Collection d(InterfaceC0311c interfaceC0311c) {
        return g.S(this, interfaceC0311c);
    }

    @Override // Y8.b
    public final U d0(InterfaceC0309a interfaceC0309a) {
        return g.O(interfaceC0309a);
    }

    @Override // Y8.b
    public final boolean e(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        return g.D(g.W(interfaceC0311c));
    }

    @Override // Y8.b
    public final int e0(InterfaceC0313e interfaceC0313e) {
        return g.R(interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean f(InterfaceC0310b interfaceC0310b) {
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        A aH = g.h(interfaceC0310b);
        return (aH != null ? g.f(aH) : null) != null;
    }

    @Override // Y8.b
    public final A f0(InterfaceC0311c interfaceC0311c, boolean z10) {
        return g.Z(interfaceC0311c, z10);
    }

    @Override // Y8.b
    public final K g(InterfaceC0311c interfaceC0311c) {
        return g.W(interfaceC0311c);
    }

    @Override // Y8.b
    public final InterfaceC0309a g0(InterfaceC0311c interfaceC0311c) {
        return g.e(this, interfaceC0311c);
    }

    @Override // Y8.b
    public final boolean h(InterfaceC0313e interfaceC0313e) {
        return g.x(interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean h0(InterfaceC0311c interfaceC0311c) {
        kotlin.jvm.internal.k.f(interfaceC0311c, "<this>");
        A aH = g.h(interfaceC0311c);
        return (aH != null ? g.e(this, aH) : null) != null;
    }

    @Override // Y8.b
    public final A i(InterfaceC0311c interfaceC0311c) {
        CaptureStatus captureStatus = CaptureStatus.f5164a;
        return g.j(interfaceC0311c);
    }

    @Override // Y8.b
    public final Collection i0(InterfaceC0313e interfaceC0313e) {
        return g.V(interfaceC0313e);
    }

    @Override // Y8.b
    public final i j(InterfaceC0309a interfaceC0309a) {
        return g.X(interfaceC0309a);
    }

    @Override // Y8.b
    public final boolean j0(U u) {
        kotlin.jvm.internal.k.f(u, "<this>");
        return g.F(X(u)) != g.F(A(u));
    }

    @Override // Y8.b
    public final boolean k(InterfaceC0313e interfaceC0313e) {
        return g.z(interfaceC0313e);
    }

    @Override // Y8.b
    public final boolean k0(InterfaceC0313e interfaceC0313e) {
        return g.A(interfaceC0313e);
    }

    @Override // Y8.b
    public final AbstractC0285p l(InterfaceC0310b interfaceC0310b) {
        return g.g(interfaceC0310b);
    }

    @Override // Y8.b
    public final void l0(InterfaceC0311c interfaceC0311c, InterfaceC0313e interfaceC0313e) {
    }

    @Override // Y8.b
    public final A m(InterfaceC0310b interfaceC0310b) {
        return g.h(interfaceC0310b);
    }

    public final InterfaceC0310b m0(InterfaceC0310b interfaceC0310b) {
        A aZ;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        A aH = g.h(interfaceC0310b);
        return (aH == null || (aZ = g.Z(aH, true)) == null) ? interfaceC0310b : aZ;
    }

    @Override // Y8.b
    public final boolean n(InterfaceC0311c interfaceC0311c) {
        return g.B(interfaceC0311c);
    }

    @Override // Y8.b
    public final boolean o(InterfaceC0311c interfaceC0311c, InterfaceC0311c interfaceC0311c2) {
        return g.w(interfaceC0311c, interfaceC0311c2);
    }

    @Override // Y8.b
    public final boolean p(InterfaceC0311c interfaceC0311c) {
        return g.F(interfaceC0311c);
    }

    @Override // Y8.b
    public final TypeVariance q(N n) {
        return g.t(n);
    }

    @Override // Y8.b
    public final void r(InterfaceC0311c interfaceC0311c) {
        g.L(interfaceC0311c);
    }

    @Override // Y8.b
    public final A s(AbstractC0285p abstractC0285p) {
        return g.N(abstractC0285p);
    }

    @Override // Y8.b
    public final A t(AbstractC0285p abstractC0285p) {
        return g.Y(abstractC0285p);
    }

    @Override // Y8.b
    public final a u(InterfaceC0311c interfaceC0311c) {
        return g.U(this, interfaceC0311c);
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
    public final boolean w(InterfaceC0313e interfaceC0313e, InterfaceC0313e interfaceC0313e2) {
        return g.b(interfaceC0313e, interfaceC0313e2);
    }

    @Override // Y8.b
    public final N x(InterfaceC0312d interfaceC0312d, int i) {
        kotlin.jvm.internal.k.f(interfaceC0312d, "<this>");
        if (interfaceC0312d instanceof InterfaceC0311c) {
            return g.p((InterfaceC0310b) interfaceC0312d, i);
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
        if (i < 0 || i >= g.c(interfaceC0311c)) {
            return null;
        }
        return g.p(interfaceC0311c, i);
    }

    @Override // Y8.b
    public final InterfaceC0310b z(InterfaceC0310b interfaceC0310b) {
        return g.a0(this, interfaceC0310b);
    }
}
