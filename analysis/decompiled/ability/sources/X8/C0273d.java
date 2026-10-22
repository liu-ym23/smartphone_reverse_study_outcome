package X8;

import a9.InterfaceC0309a;
import a9.InterfaceC0310b;
import a9.InterfaceC0311c;
import a9.InterfaceC0312d;
import a9.InterfaceC0313e;
import b9.C0865a;
import h8.InterfaceC1506N;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import i8.InterfaceC1555a;
import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k8.AbstractC1637f;
import k8.AbstractC1644m;
import k8.C1636e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* renamed from: X8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0273d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0273d f1528a = new C0273d();

    public static final boolean b(Y8.b bVar, InterfaceC0311c interfaceC0311c) {
        if (bVar.e(interfaceC0311c)) {
            return true;
        }
        if (!(interfaceC0311c instanceof InterfaceC0309a)) {
            return false;
        }
        N nU = bVar.U(bVar.j((InterfaceC0309a) interfaceC0311c));
        return !bVar.V(nU) && bVar.e(bVar.A(bVar.R(nU)));
    }

    public static final boolean c(Y8.b bVar, J j5, InterfaceC0311c interfaceC0311c, InterfaceC0311c interfaceC0311c2, boolean z10) {
        Collection<InterfaceC0310b> collectionD = bVar.d(interfaceC0311c);
        if ((collectionD instanceof Collection) && collectionD.isEmpty()) {
            return false;
        }
        for (InterfaceC0310b interfaceC0310b : collectionD) {
            if (kotlin.jvm.internal.k.b(bVar.W(interfaceC0310b), bVar.g(interfaceC0311c2))) {
                return true;
            }
            if (z10 && m(f1528a, j5, interfaceC0311c2, interfaceC0310b)) {
                return true;
            }
        }
        return false;
    }

    public static List d(J j5, InterfaceC0311c interfaceC0311c, InterfaceC0313e interfaceC0313e) {
        AbstractC0272c abstractC0272cU;
        I i = I.c;
        Y8.b bVar = j5.c;
        bVar.l0(interfaceC0311c, interfaceC0313e);
        if (!bVar.J(interfaceC0313e) && bVar.G(interfaceC0311c)) {
            return EmptyList.f4893a;
        }
        if (bVar.k(interfaceC0313e)) {
            if (!bVar.w(bVar.g(interfaceC0311c), interfaceC0313e)) {
                return EmptyList.f4893a;
            }
            CaptureStatus captureStatus = CaptureStatus.f5164a;
            A aI = bVar.i(interfaceC0311c);
            if (aI != null) {
                interfaceC0311c = aI;
            }
            return H4.o.M(interfaceC0311c);
        }
        g9.f fVar = new g9.f();
        j5.b();
        ArrayDeque arrayDeque = j5.g;
        kotlin.jvm.internal.k.c(arrayDeque);
        g9.i iVar = j5.h;
        kotlin.jvm.internal.k.c(iVar);
        arrayDeque.push(interfaceC0311c);
        while (!arrayDeque.isEmpty()) {
            if (iVar.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + interfaceC0311c + ". Supertypes = " + D7.v.I0(iVar, null, null, null, null, 63)).toString());
            }
            InterfaceC0311c interfaceC0311c2 = (InterfaceC0311c) arrayDeque.pop();
            kotlin.jvm.internal.k.c(interfaceC0311c2);
            if (iVar.add(interfaceC0311c2)) {
                CaptureStatus captureStatus2 = CaptureStatus.f5164a;
                A aI2 = bVar.i(interfaceC0311c2);
                if (aI2 == null) {
                    aI2 = interfaceC0311c2;
                }
                if (bVar.w(bVar.g(aI2), interfaceC0313e)) {
                    fVar.add(aI2);
                    abstractC0272cU = i;
                } else {
                    abstractC0272cU = bVar.O(aI2) == 0 ? I.b : bVar.u(aI2);
                }
                if (abstractC0272cU.equals(i)) {
                    abstractC0272cU = null;
                }
                if (abstractC0272cU != null) {
                    Iterator it = bVar.i0(bVar.g(interfaceC0311c2)).iterator();
                    while (it.hasNext()) {
                        arrayDeque.add(abstractC0272cU.D(j5, (InterfaceC0310b) it.next()));
                    }
                }
            }
        }
        j5.a();
        return fVar;
    }

    public static List e(J j5, InterfaceC0311c interfaceC0311c, InterfaceC0313e interfaceC0313e) {
        int i;
        List listD = d(j5, interfaceC0311c, interfaceC0313e);
        Y8.b bVar = j5.c;
        if (listD.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                InterfaceC0312d interfaceC0312dN = bVar.N((InterfaceC0311c) obj);
                int iZ = bVar.Z(interfaceC0312dN);
                while (true) {
                    if (i >= iZ) {
                        arrayList.add(obj);
                        break;
                    }
                    i = bVar.l(bVar.R(bVar.x(interfaceC0312dN, i))) == null ? i + 1 : 0;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return listD;
    }

    public static boolean g(J j5, InterfaceC0310b a3, InterfaceC0310b b) {
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b, "b");
        Y8.b bVar = j5.c;
        if (a3 == b) {
            return true;
        }
        if (k(bVar, a3) && k(bVar, b)) {
            U uC = j5.c(j5.d(a3));
            U uC2 = j5.c(j5.d(b));
            A aX = bVar.X(uC);
            if (!bVar.w(bVar.W(uC), bVar.W(uC2))) {
                return false;
            }
            if (bVar.O(aX) == 0) {
                return bVar.j0(uC) || bVar.j0(uC2) || bVar.p(aX) == bVar.p(bVar.X(uC2));
            }
        }
        C0273d c0273d = f1528a;
        return m(c0273d, j5, a3, b) && m(c0273d, j5, b, a3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return r6.B(r6.W(r7), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h8.InterfaceC1507O j(Y8.b r6, a9.InterfaceC0310b r7, a9.InterfaceC0310b r8) {
        /*
            int r0 = r6.O(r7)
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L66
            X8.N r4 = r6.S(r7, r2)
            boolean r5 = r6.V(r4)
            if (r5 != 0) goto L14
            r3 = r4
        L14:
            if (r3 == 0) goto L63
            X8.U r3 = r6.R(r3)
            if (r3 != 0) goto L1d
            goto L63
        L1d:
            X8.A r4 = r6.X(r3)
            a9.c r4 = r6.c(r4)
            boolean r4 = r6.h0(r4)
            if (r4 == 0) goto L3b
            X8.A r4 = r6.X(r8)
            a9.c r4 = r6.c(r4)
            boolean r4 = r6.h0(r4)
            if (r4 == 0) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = r1
        L3c:
            boolean r5 = r3.equals(r8)
            if (r5 != 0) goto L5a
            if (r4 == 0) goto L53
            X8.K r4 = r6.W(r3)
            X8.K r5 = r6.W(r8)
            boolean r4 = kotlin.jvm.internal.k.b(r4, r5)
            if (r4 == 0) goto L53
            goto L5a
        L53:
            h8.O r3 = j(r6, r3, r8)
            if (r3 == 0) goto L63
            return r3
        L5a:
            X8.K r7 = r6.W(r7)
            h8.O r6 = r6.B(r7, r2)
            return r6
        L63:
            int r2 = r2 + 1
            goto L6
        L66:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.C0273d.j(Y8.b, a9.b, a9.b):h8.O");
    }

    public static boolean k(Y8.b bVar, InterfaceC0310b interfaceC0310b) {
        if (!bVar.k0(bVar.W(interfaceC0310b))) {
            return false;
        }
        bVar.E(interfaceC0310b);
        return (bVar.f(interfaceC0310b) || bVar.T(interfaceC0310b) || bVar.H(interfaceC0310b)) ? false : true;
    }

    public static boolean l(J j5, InterfaceC0312d capturedSubArguments, InterfaceC0311c interfaceC0311c) {
        boolean zM;
        kotlin.jvm.internal.k.f(capturedSubArguments, "capturedSubArguments");
        Y8.b bVar = j5.c;
        K kG = bVar.g(interfaceC0311c);
        int iZ = bVar.Z(capturedSubArguments);
        int iE0 = bVar.e0(kG);
        if (iZ == iE0 && iZ == bVar.O(interfaceC0311c)) {
            for (int i = 0; i < iE0; i++) {
                N nS = bVar.S(interfaceC0311c, i);
                if (!bVar.V(nS)) {
                    U uR = bVar.R(nS);
                    N nX = bVar.x(capturedSubArguments, i);
                    bVar.q(nX);
                    TypeVariance typeVariance = TypeVariance.d;
                    U uR2 = bVar.R(nX);
                    TypeVariance typeVarianceB = bVar.b(bVar.B(kG, i));
                    TypeVariance typeVarianceQ = bVar.q(nS);
                    if (typeVarianceB == typeVariance) {
                        typeVarianceB = typeVarianceQ;
                    } else if (typeVarianceQ != typeVariance && typeVarianceB != typeVarianceQ) {
                        typeVarianceB = null;
                    }
                    if (typeVarianceB == null) {
                        return j5.f1524a;
                    }
                    if (typeVarianceB == typeVariance) {
                        n(bVar, uR2, uR);
                        n(bVar, uR, uR2);
                    }
                    int i6 = j5.f;
                    if (i6 > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + uR2).toString());
                    }
                    j5.f = i6 + 1;
                    int iOrdinal = typeVarianceB.ordinal();
                    C0273d c0273d = f1528a;
                    if (iOrdinal == 0) {
                        zM = m(c0273d, j5, uR, uR2);
                    } else if (iOrdinal == 1) {
                        zM = m(c0273d, j5, uR2, uR);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zM = g(j5, uR2, uR);
                    }
                    j5.f--;
                    if (!zM) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02cd A[EDGE_INSN: B:350:0x02cd->B:168:0x02cd BREAK  A[LOOP:11: B:159:0x02ae->B:351:0x02ae]] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0102  */
    /* JADX WARN: Type inference failed for: r3v0, types: [Y8.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v23, types: [int] */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m(X8.C0273d r23, X8.J r24, a9.InterfaceC0310b r25, a9.InterfaceC0310b r26) {
        /*
            Method dump skipped, instructions count: 1450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.C0273d.m(X8.d, X8.J, a9.b, a9.b):boolean");
    }

    public static void n(Y8.b bVar, InterfaceC0310b interfaceC0310b, InterfaceC0310b interfaceC0310b2) {
        InterfaceC0310b interfaceC0310bM = bVar.m(interfaceC0310b);
        if (interfaceC0310bM instanceof InterfaceC0309a) {
            InterfaceC0309a interfaceC0309a = (InterfaceC0309a) interfaceC0310bM;
            if (!bVar.I(interfaceC0309a) && bVar.V(bVar.U(bVar.j(interfaceC0309a))) && bVar.Y(interfaceC0309a) == CaptureStatus.f5164a) {
                bVar.W(interfaceC0310b2);
            }
        }
    }

    public static C0281l o(U type, boolean z10) {
        boolean zE;
        kotlin.jvm.internal.k.f(type, "type");
        if (type instanceof C0281l) {
            return (C0281l) type;
        }
        type.Q();
        if ((type.Q().d() instanceof InterfaceC1507O) || (type instanceof Y8.h)) {
            InterfaceC1524g interfaceC1524gD = type.Q().d();
            k8.O o = interfaceC1524gD instanceof k8.O ? (k8.O) interfaceC1524gD : null;
            zE = true;
            if (o == null || o.l) {
                zE = (z10 && (type.Q().d() instanceof InterfaceC1507O)) ? S.e(type) : true ^ AbstractC0272c.h(Y8.g.l(false, null, 24), AbstractC0272c.m(type), I.b);
            }
        } else {
            zE = false;
        }
        if (!zE) {
            return null;
        }
        if (type instanceof AbstractC0285p) {
            AbstractC0285p abstractC0285p = (AbstractC0285p) type;
            kotlin.jvm.internal.k.b(abstractC0285p.b.Q(), abstractC0285p.c.Q());
        }
        return new C0281l(AbstractC0272c.m(type).f0(false), z10);
    }

    public void a(InterfaceC1561g interfaceC1561g, InterfaceC1561g interfaceC1561g2) {
        HashSet hashSet = new HashSet();
        Iterator it = interfaceC1561g.iterator();
        while (it.hasNext()) {
            hashSet.add(((InterfaceC1556b) it.next()).b());
        }
        Iterator it2 = interfaceC1561g2.iterator();
        while (it2.hasNext()) {
            hashSet.contains(((InterfaceC1556b) it2.next()).b());
        }
    }

    public P f(K typeConstructor, List arguments) {
        kotlin.jvm.internal.k.f(typeConstructor, "typeConstructor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        List parameters = typeConstructor.getParameters();
        kotlin.jvm.internal.k.e(parameters, "getParameters(...)");
        InterfaceC1507O interfaceC1507O = (InterfaceC1507O) D7.v.L0(parameters);
        if (interfaceC1507O == null || !interfaceC1507O.K()) {
            return new C0287s((InterfaceC1507O[]) parameters.toArray(new InterfaceC1507O[0]), (N[]) arguments.toArray(new N[0]), false);
        }
        List parameters2 = typeConstructor.getParameters();
        kotlin.jvm.internal.k.e(parameters2, "getParameters(...)");
        List list = parameters2;
        ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC1507O) it.next()).m());
        }
        return new G(kotlin.collections.a.X(D7.v.m1(arrayList, arguments)), 1);
    }

    public A h(u1.d dVar, H h, boolean z10, int i, boolean z11) {
        H hL;
        Variance variance = Variance.c;
        InterfaceC1506N interfaceC1506N = (InterfaceC1506N) dVar.c;
        N nI = i(new F(((V8.t) interfaceC1506N).T0(), variance), dVar, null, i);
        w wVarB = nI.b();
        kotlin.jvm.internal.k.e(wVarB, "getType(...)");
        A aB = AbstractC0272c.b(wVarB);
        if (AbstractC0272c.k(aB)) {
            return aB;
        }
        nI.a();
        a(aB.getAnnotations(), AbstractC0277h.a(h));
        if (!AbstractC0272c.k(aB)) {
            if (AbstractC0272c.k(aB)) {
                hL = aB.M();
            } else {
                H other = aB.M();
                O2.a aVar = H.b;
                kotlin.jvm.internal.k.f(other, "other");
                if (h.isEmpty() && other.isEmpty()) {
                    hL = h;
                } else {
                    ArrayList arrayList = new ArrayList();
                    Collection collectionValues = ((ConcurrentHashMap) aVar.b).values();
                    kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
                    Iterator it = collectionValues.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        C0276g c0276g = (C0276g) h.f4305a.get(iIntValue);
                        C0276g c0276g2 = (C0276g) other.f4305a.get(iIntValue);
                        if (c0276g != null) {
                            if (c0276g2 != null) {
                                c0276g = new C0276g(S0.b.H0(c0276g.f1531a, c0276g2.f1531a));
                            }
                            c0276g2 = c0276g;
                        } else if (c0276g2 == null) {
                            c0276g2 = null;
                        } else if (c0276g != null) {
                            c0276g2 = new C0276g(S0.b.H0(c0276g2.f1531a, c0276g.f1531a));
                        }
                        g9.l.b(arrayList, c0276g2);
                    }
                    hL = O2.a.l(arrayList);
                }
            }
            aB = AbstractC0272c.r(aB, null, hL, 1);
        }
        A aI = S.i(aB, z10);
        if (!z11) {
            return aI;
        }
        C1636e c1636e = ((AbstractC1637f) interfaceC1506N).h;
        kotlin.jvm.internal.k.e(c1636e, "getTypeConstructor(...)");
        return AbstractC0272c.F(aI, AbstractC0272c.v(Q8.n.b, h, c1636e, (List) dVar.d, z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public N i(N n, u1.d dVar, InterfaceC1507O interfaceC1507O, int i) {
        Variance varianceR;
        Variance variance;
        Variance variance2;
        InterfaceC1555a typeAlias = (InterfaceC1506N) dVar.c;
        if (i > 100) {
            throw new AssertionError("Too deep recursion while expanding type alias " + ((AbstractC1644m) typeAlias).getName());
        }
        if (n.c()) {
            kotlin.jvm.internal.k.c(interfaceC1507O);
            return S.j(interfaceC1507O);
        }
        w wVarB = n.b();
        kotlin.jvm.internal.k.e(wVarB, "getType(...)");
        K constructor = wVarB.Q();
        kotlin.jvm.internal.k.f(constructor, "constructor");
        InterfaceC1524g interfaceC1524gD = constructor.d();
        N n7 = interfaceC1524gD instanceof InterfaceC1507O ? (N) ((Map) dVar.e).get(interfaceC1524gD) : null;
        if (n7 == null) {
            A aB = AbstractC0272c.b(n.b().Z());
            if (!AbstractC0272c.k(aB) && S.c(aB, C0865a.c, null)) {
                K kQ = aB.Q();
                InterfaceC1524g interfaceC1524gD2 = kQ.d();
                kQ.getParameters().size();
                aB.L().size();
                if (!(interfaceC1524gD2 instanceof InterfaceC1507O)) {
                    int i6 = 0;
                    if (interfaceC1524gD2 instanceof InterfaceC1506N) {
                        InterfaceC1506N interfaceC1506N = (InterfaceC1506N) interfaceC1524gD2;
                        if (dVar.U(interfaceC1506N)) {
                            return new F(Z8.i.c(ErrorTypeKind.f, ((AbstractC1644m) interfaceC1506N).getName().f690a), Variance.c);
                        }
                        List listL = aB.L();
                        ArrayList arrayList = new ArrayList(D7.w.c0(listL, 10));
                        for (Object obj : listL) {
                            int i10 = i6 + 1;
                            if (i6 < 0) {
                                H4.o.X();
                                throw null;
                            }
                            arrayList.add(i((N) obj, dVar, (InterfaceC1507O) kQ.getParameters().get(i6), i + 1));
                            i6 = i10;
                        }
                        return new F(AbstractC0272c.F(h(AbstractC0272c.e(dVar, interfaceC1506N, arrayList), aB.M(), aB.W(), i + 1, false), p(aB, dVar, i)), n.a());
                    }
                    A aP = p(aB, dVar, i);
                    kotlin.reflect.jvm.internal.impl.types.a.d(aP);
                    for (Object obj2 : aP.L()) {
                        int i11 = i6 + 1;
                        if (i6 < 0) {
                            H4.o.X();
                            throw null;
                        }
                        N n10 = (N) obj2;
                        if (!n10.c()) {
                            w wVarB2 = n10.b();
                            kotlin.jvm.internal.k.e(wVarB2, "getType(...)");
                            if (!S.c(wVarB2, C0865a.b, null)) {
                            }
                        }
                        i6 = i11;
                    }
                    return new F(aP, n.a());
                }
            }
            return n;
        }
        if (n7.c()) {
            kotlin.jvm.internal.k.c(interfaceC1507O);
            return S.j(interfaceC1507O);
        }
        U uZ = n7.b().Z();
        Variance varianceA = n7.a();
        kotlin.jvm.internal.k.e(varianceA, "getProjectionKind(...)");
        Variance varianceA2 = n.a();
        kotlin.jvm.internal.k.e(varianceA2, "getProjectionKind(...)");
        if (varianceA2 != varianceA && varianceA2 != (variance2 = Variance.c)) {
            if (varianceA == variance2) {
                varianceA = varianceA2;
            } else {
                kotlin.jvm.internal.k.f(typeAlias, "typeAlias");
            }
        }
        if (interfaceC1507O == null || (varianceR = interfaceC1507O.r()) == null) {
            varianceR = Variance.c;
        }
        if (varianceR != varianceA && varianceR != (variance = Variance.c)) {
            if (varianceA == variance) {
                varianceA = variance;
            } else {
                kotlin.jvm.internal.k.f(typeAlias, "typeAlias");
            }
        }
        a(wVarB.getAnnotations(), uZ.getAnnotations());
        A aI = S.i(AbstractC0272c.b(uZ), wVarB.W());
        H hM = wVarB.M();
        if (!AbstractC0272c.k(aI)) {
            if (AbstractC0272c.k(aI)) {
                hM = aI.M();
            } else {
                H other = aI.M();
                hM.getClass();
                O2.a aVar = H.b;
                kotlin.jvm.internal.k.f(other, "other");
                if (!hM.isEmpty() || !other.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    Collection collectionValues = ((ConcurrentHashMap) aVar.b).values();
                    kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
                    Iterator it = collectionValues.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        C0276g c0276g = (C0276g) hM.f4305a.get(iIntValue);
                        C0276g c0276g2 = (C0276g) other.f4305a.get(iIntValue);
                        if (c0276g != null) {
                            if (c0276g2 != null) {
                                c0276g = new C0276g(S0.b.H0(c0276g.f1531a, c0276g2.f1531a));
                            }
                            c0276g2 = c0276g;
                        } else if (c0276g2 == null) {
                            c0276g2 = null;
                        } else if (c0276g != null) {
                            c0276g2 = new C0276g(S0.b.H0(c0276g2.f1531a, c0276g.f1531a));
                        }
                        g9.l.b(arrayList2, c0276g2);
                    }
                    hM = O2.a.l(arrayList2);
                }
            }
            aI = AbstractC0272c.r(aI, null, hM, 1);
        }
        return new F(aI, varianceA);
    }

    public A p(A a3, u1.d dVar, int i) {
        K kQ = a3.Q();
        List listL = a3.L();
        ArrayList arrayList = new ArrayList(D7.w.c0(listL, 10));
        int i6 = 0;
        for (Object obj : listL) {
            int i10 = i6 + 1;
            if (i6 < 0) {
                H4.o.X();
                throw null;
            }
            N n = (N) obj;
            N nI = i(n, dVar, (InterfaceC1507O) kQ.getParameters().get(i6), i + 1);
            if (!nI.c()) {
                nI = new F(S.h(nI.b(), n.b().W()), nI.a());
            }
            arrayList.add(nI);
            i6 = i10;
        }
        return AbstractC0272c.r(a3, arrayList, null, 2);
    }
}
