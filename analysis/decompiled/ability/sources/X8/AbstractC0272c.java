package X8;

import a9.InterfaceC0310b;
import a9.InterfaceC0311c;
import a9.InterfaceC0313e;
import h8.InterfaceC1506N;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.C1560f;
import i8.C1565k;
import i8.InterfaceC1561g;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import k8.AbstractC1637f;
import k8.AbstractC1644m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* renamed from: X8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0272c {
    public static kotlin.reflect.jvm.internal.impl.types.a A(List list, P p, InterfaceC1527j interfaceC1527j, ArrayList arrayList) {
        if (p == null) {
            a(1);
            throw null;
        }
        if (interfaceC1527j == null) {
            a(2);
            throw null;
        }
        if (arrayList == null) {
            a(3);
            throw null;
        }
        kotlin.reflect.jvm.internal.impl.types.a aVarB = B(list, p, interfaceC1527j, arrayList, null);
        if (aVarB != null) {
            return aVarB;
        }
        throw new AssertionError("Substitution failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static kotlin.reflect.jvm.internal.impl.types.a B(java.util.List r17, X8.P r18, h8.InterfaceC1527j r19, java.util.List r20, boolean[] r21) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.AbstractC0272c.B(java.util.List, X8.P, h8.j, java.util.List, boolean[]):kotlin.reflect.jvm.internal.impl.types.a");
    }

    public static final H C(InterfaceC1561g interfaceC1561g) {
        kotlin.jvm.internal.k.f(interfaceC1561g, "<this>");
        if (interfaceC1561g.isEmpty()) {
            H.b.getClass();
            return H.c;
        }
        O2.a aVar = H.b;
        List listM = H4.o.M(new C0276g(interfaceC1561g));
        aVar.getClass();
        return O2.a.l(listM);
    }

    public static final A E(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        U uZ = wVar.Z();
        if (uZ instanceof AbstractC0285p) {
            return ((AbstractC0285p) uZ).c;
        }
        if (uZ instanceof A) {
            return (A) uZ;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final A F(A a3, A abbreviatedType) {
        kotlin.jvm.internal.k.f(a3, "<this>");
        kotlin.jvm.internal.k.f(abbreviatedType, "abbreviatedType");
        return k(a3) ? a3 : new C0270a(a3, abbreviatedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final U G(U u, w wVar) {
        kotlin.jvm.internal.k.f(u, "<this>");
        if (u instanceof T) {
            return G(((T) u).G(), wVar);
        }
        if (wVar == null || wVar.equals(u)) {
            return u;
        }
        if (u instanceof A) {
            return new D((A) u, wVar);
        }
        if (u instanceof AbstractC0285p) {
            return new r((AbstractC0285p) u, wVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static final A b(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        U uZ = wVar.Z();
        A a3 = uZ instanceof A ? (A) uZ : null;
        if (a3 != null) {
            return a3;
        }
        throw new IllegalStateException(("This is should be simple type: " + wVar).toString());
    }

    public static final w c(ArrayList arrayList, List list, e8.i iVar) {
        w wVarI = new kotlin.reflect.jvm.internal.impl.types.a(new G(arrayList, 0)).i((w) D7.v.A0(list), Variance.e);
        return wVarI == null ? iVar.m() : wVarI;
    }

    public static final InterfaceC0310b d(InterfaceC0310b receiver, HashSet hashSet) {
        InterfaceC0310b interfaceC0310bD;
        Y8.m mVar = Y8.m.f1578a;
        K kW = mVar.W(receiver);
        if (!hashSet.add(kW)) {
            return null;
        }
        InterfaceC1507O interfaceC1507OS = Y8.g.s(kW);
        if (interfaceC1507OS != null) {
            InterfaceC0310b interfaceC0310bB = U7.a.B(interfaceC1507OS);
            InterfaceC0310b interfaceC0310bD2 = d(interfaceC0310bB, hashSet);
            if (interfaceC0310bD2 != null) {
                return ((interfaceC0310bD2 instanceof InterfaceC0311c) && Y8.g.I((InterfaceC0311c) interfaceC0310bD2) && Y8.g.H(receiver) && (Y8.g.C(mVar.W(interfaceC0310bB)) || ((interfaceC0310bB instanceof InterfaceC0311c) && Y8.g.I((InterfaceC0311c) interfaceC0310bB)))) ? mVar.m0(interfaceC0310bB) : (!Y8.g.H(interfaceC0310bD2) && (receiver instanceof InterfaceC0311c) && Y8.g.F((InterfaceC0311c) receiver)) ? mVar.m0(interfaceC0310bD2) : interfaceC0310bD2;
            }
            return null;
        }
        if (Y8.g.C(kW)) {
            kotlin.jvm.internal.k.f(receiver, "$receiver");
            if (!(receiver instanceof w)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(receiver);
                sb.append(", ");
                throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
            }
            A aI = J8.g.i((w) receiver);
            if (aI == null || (interfaceC0310bD = d(aI, hashSet)) == null) {
                return null;
            }
            if (!Y8.g.H(receiver)) {
                return interfaceC0310bD;
            }
            if (!Y8.g.H(interfaceC0310bD) && (!(interfaceC0310bD instanceof InterfaceC0311c) || !Y8.g.I((InterfaceC0311c) interfaceC0310bD))) {
                return mVar.m0(interfaceC0310bD);
            }
        }
        return receiver;
    }

    public static u1.d e(u1.d dVar, InterfaceC1506N typeAliasDescriptor, List arguments) {
        kotlin.jvm.internal.k.f(typeAliasDescriptor, "typeAliasDescriptor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        List parameters = ((AbstractC1637f) typeAliasDescriptor).h.getParameters();
        ArrayList arrayList = new ArrayList(D7.w.c0(parameters, 10));
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC1507O) it.next()).a());
        }
        return new u1.d(dVar, typeAliasDescriptor, arguments, kotlin.collections.a.X(D7.v.m1(arrayList, arguments)), 7);
    }

    public static final U f(A lowerBound, A upperBound) {
        kotlin.jvm.internal.k.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.k.f(upperBound, "upperBound");
        return lowerBound.equals(upperBound) ? lowerBound : new C0286q(lowerBound, upperBound);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final w g(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        if (wVar instanceof T) {
            return ((T) wVar).A();
        }
        return null;
    }

    public static boolean h(J j5, InterfaceC0311c type, AbstractC0272c abstractC0272c) {
        I i = I.c;
        kotlin.jvm.internal.k.f(type, "type");
        Y8.b bVar = j5.c;
        if ((bVar.G(type) && !bVar.p(type)) || bVar.f(type)) {
            return true;
        }
        j5.b();
        ArrayDeque arrayDeque = j5.g;
        kotlin.jvm.internal.k.c(arrayDeque);
        g9.i iVar = j5.h;
        kotlin.jvm.internal.k.c(iVar);
        arrayDeque.push(type);
        while (!arrayDeque.isEmpty()) {
            if (iVar.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + type + ". Supertypes = " + D7.v.I0(iVar, null, null, null, null, 63)).toString());
            }
            InterfaceC0311c interfaceC0311c = (InterfaceC0311c) arrayDeque.pop();
            kotlin.jvm.internal.k.c(interfaceC0311c);
            if (iVar.add(interfaceC0311c)) {
                AbstractC0272c abstractC0272c2 = bVar.p(interfaceC0311c) ? i : abstractC0272c;
                if (abstractC0272c2.equals(i)) {
                    abstractC0272c2 = null;
                }
                if (abstractC0272c2 == null) {
                    continue;
                } else {
                    Iterator it = bVar.i0(bVar.g(interfaceC0311c)).iterator();
                    while (it.hasNext()) {
                        InterfaceC0311c interfaceC0311cD = abstractC0272c2.D(j5, (InterfaceC0310b) it.next());
                        if ((bVar.G(interfaceC0311cD) && !bVar.p(interfaceC0311cD)) || bVar.f(interfaceC0311cD)) {
                            j5.a();
                            return true;
                        }
                        arrayDeque.add(interfaceC0311cD);
                    }
                }
            }
        }
        j5.a();
        return false;
    }

    public static final U i(U u, w origin) {
        kotlin.jvm.internal.k.f(u, "<this>");
        kotlin.jvm.internal.k.f(origin, "origin");
        return G(u, g(origin));
    }

    public static boolean j(J j5, InterfaceC0311c interfaceC0311c, InterfaceC0313e interfaceC0313e) {
        Y8.b bVar = j5.c;
        if (bVar.C(interfaceC0311c)) {
            return true;
        }
        if (bVar.p(interfaceC0311c)) {
            return false;
        }
        if (j5.b) {
            bVar.r(interfaceC0311c);
        }
        return bVar.w(bVar.g(interfaceC0311c), interfaceC0313e);
    }

    public static final boolean k(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        U uZ = wVar.Z();
        if (uZ instanceof Z8.g) {
            return true;
        }
        return (uZ instanceof AbstractC0285p) && (((AbstractC0285p) uZ).n0() instanceof Z8.g);
    }

    public static final boolean l(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        return wVar.Z() instanceof AbstractC0285p;
    }

    public static final A m(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        U uZ = wVar.Z();
        if (uZ instanceof AbstractC0285p) {
            return ((AbstractC0285p) uZ).b;
        }
        if (uZ instanceof A) {
            return (A) uZ;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final U n(U u, boolean z10) {
        kotlin.jvm.internal.k.f(u, "<this>");
        C0281l c0281lO = C0273d.o(u, z10);
        if (c0281lO != null) {
            return c0281lO;
        }
        A aO = o(u);
        return aO != null ? aO : u.f0(false);
    }

    public static final A o(U u) {
        v vVar;
        K kQ = u.Q();
        v vVar2 = kQ instanceof v ? (v) kQ : null;
        if (vVar2 != null) {
            LinkedHashSet<w> linkedHashSet = vVar2.b;
            ArrayList arrayList = new ArrayList(D7.w.c0(linkedHashSet, 10));
            boolean z10 = false;
            for (w wVarN : linkedHashSet) {
                if (S.e(wVarN)) {
                    wVarN = n(wVarN.Z(), false);
                    z10 = true;
                }
                arrayList.add(wVarN);
            }
            if (z10) {
                w wVarN2 = vVar2.f1536a;
                if (wVarN2 == null) {
                    wVarN2 = null;
                } else if (S.e(wVarN2)) {
                    wVarN2 = n(wVarN2.Z(), false);
                }
                arrayList.isEmpty();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList);
                linkedHashSet2.hashCode();
                vVar = new v(linkedHashSet2);
                vVar.f1536a = wVarN2;
            } else {
                vVar = null;
            }
            if (vVar != null) {
                return vVar.b();
            }
        }
        return null;
    }

    public static final A p(A a3, List newArguments, H newAttributes) {
        kotlin.jvm.internal.k.f(a3, "<this>");
        kotlin.jvm.internal.k.f(newArguments, "newArguments");
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == a3.M()) {
            return a3;
        }
        if (newArguments.isEmpty()) {
            return a3.m0(newAttributes);
        }
        if (!(a3 instanceof Z8.g)) {
            return u(newAttributes, a3.Q(), newArguments, a3.W());
        }
        Z8.g gVar = (Z8.g) a3;
        K k = gVar.b;
        Z8.f fVar = gVar.c;
        ErrorTypeKind errorTypeKind = gVar.d;
        boolean z10 = gVar.f;
        String[] strArr = gVar.g;
        return new Z8.g(k, fVar, errorTypeKind, newArguments, z10, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static w q(w wVar, List list, InterfaceC1561g interfaceC1561g, int i) {
        if ((i & 2) != 0) {
            interfaceC1561g = wVar.getAnnotations();
        }
        kotlin.jvm.internal.k.f(wVar, "<this>");
        if ((list.isEmpty() || list == wVar.L()) && interfaceC1561g == wVar.getAnnotations()) {
            return wVar;
        }
        H hM = wVar.M();
        if ((interfaceC1561g instanceof C1565k) && ((C1565k) interfaceC1561g).isEmpty()) {
            interfaceC1561g = C1560f.f4611a;
        }
        H hS = s(hM, interfaceC1561g);
        U uZ = wVar.Z();
        if (uZ instanceof AbstractC0285p) {
            AbstractC0285p abstractC0285p = (AbstractC0285p) uZ;
            return f(p(abstractC0285p.b, list, hS), p(abstractC0285p.c, list, hS));
        }
        if (uZ instanceof A) {
            return p((A) uZ, list, hS);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ A r(A a3, List list, H h, int i) {
        if ((i & 1) != 0) {
            list = a3.L();
        }
        if ((i & 2) != 0) {
            h = a3.M();
        }
        return p(a3, list, h);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final X8.H s(X8.H r5, i8.InterfaceC1561g r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.k.f(r5, r0)
            i8.g r0 = X8.AbstractC0277h.a(r5)
            if (r0 != r6) goto Lc
            return r5
        Lc:
            d9.p r0 = X8.AbstractC0277h.b
            Z7.t[] r1 = X8.AbstractC0277h.f1532a
            r2 = 0
            r1 = r1[r2]
            java.lang.Object r0 = r0.getValue(r5, r1)
            X8.g r0 = (X8.C0276g) r0
            if (r0 == 0) goto L5f
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L22
            goto L50
        L22:
            d9.a r1 = r5.f4305a
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L2d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r1.next()
            r4 = r3
            X8.g r4 = (X8.C0276g) r4
            boolean r4 = kotlin.jvm.internal.k.b(r4, r0)
            if (r4 != 0) goto L2d
            r2.add(r3)
            goto L2d
        L44:
            int r0 = r2.size()
            d9.a r1 = r5.f4305a
            int r1 = r1.b()
            if (r0 != r1) goto L52
        L50:
            r0 = r5
            goto L5b
        L52:
            O2.a r0 = X8.H.b
            r0.getClass()
            X8.H r0 = O2.a.l(r2)
        L5b:
            if (r0 != 0) goto L5e
            goto L5f
        L5e:
            r5 = r0
        L5f:
            java.util.Iterator r0 = r6.iterator()
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L70
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L70
            goto L95
        L70:
            X8.g r0 = new X8.g
            r0.<init>(r6)
            O2.a r6 = X8.H.b
            java.lang.Class<X8.g> r1 = X8.C0276g.class
            kotlin.jvm.internal.n r2 = kotlin.jvm.internal.m.f4928a
            Z7.d r1 = r2.b(r1)
            r6.getClass()
            java.lang.String r1 = r1.l()
            kotlin.jvm.internal.k.c(r1)
            int r6 = r6.o(r1)
            d9.a r1 = r5.f4305a
            java.lang.Object r6 = r1.get(r6)
            if (r6 == 0) goto L96
        L95:
            return r5
        L96:
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto La6
            X8.H r5 = new X8.H
            java.util.List r6 = H4.o.M(r0)
            r5.<init>(r6)
            return r5
        La6:
            java.util.List r5 = D7.v.f1(r5)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.ArrayList r5 = D7.v.R0(r5, r0)
            X8.H r5 = O2.a.l(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.AbstractC0272c.s(X8.H, i8.g):X8.H");
    }

    public static final A t(H attributes, InterfaceC1522e descriptor, List arguments) {
        kotlin.jvm.internal.k.f(attributes, "attributes");
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        K kM = descriptor.m();
        kotlin.jvm.internal.k.e(kM, "getTypeConstructor(...)");
        return u(attributes, kM, arguments, false);
    }

    public static A u(H attributes, K constructor, List arguments, boolean z10) {
        Q8.o oVarX;
        k8.y yVar;
        Q8.o oVarK;
        Q8.o oVar;
        Q8.o oVarA;
        kotlin.jvm.internal.k.f(attributes, "attributes");
        kotlin.jvm.internal.k.f(constructor, "constructor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !z10 && constructor.d() != null) {
            InterfaceC1524g interfaceC1524gD = constructor.d();
            kotlin.jvm.internal.k.c(interfaceC1524gD);
            A aG = interfaceC1524gD.g();
            kotlin.jvm.internal.k.e(aG, "getDefaultType(...)");
            return aG;
        }
        InterfaceC1524g interfaceC1524gD2 = constructor.d();
        if (interfaceC1524gD2 instanceof InterfaceC1507O) {
            oVarX = ((InterfaceC1507O) interfaceC1524gD2).g().w();
        } else {
            if (interfaceC1524gD2 instanceof InterfaceC1522e) {
                kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(interfaceC1524gD2));
                boolean zIsEmpty = arguments.isEmpty();
                Y8.f fVar = Y8.f.f1574a;
                if (zIsEmpty) {
                    InterfaceC1522e interfaceC1522e = (InterfaceC1522e) interfaceC1524gD2;
                    kotlin.jvm.internal.k.f(interfaceC1522e, "<this>");
                    yVar = interfaceC1522e instanceof k8.y ? (k8.y) interfaceC1522e : null;
                    if (yVar == null || (oVarA = yVar.A(fVar)) == null) {
                        oVarX = interfaceC1522e.R();
                        kotlin.jvm.internal.k.e(oVarX, "getUnsubstitutedMemberScope(...)");
                    } else {
                        oVar = oVarA;
                    }
                } else {
                    InterfaceC1522e interfaceC1522e2 = (InterfaceC1522e) interfaceC1524gD2;
                    P pF = L.b.f(constructor, arguments);
                    kotlin.jvm.internal.k.f(interfaceC1522e2, "<this>");
                    yVar = interfaceC1522e2 instanceof k8.y ? (k8.y) interfaceC1522e2 : null;
                    if (yVar == null || (oVarK = yVar.k(pF, fVar)) == null) {
                        oVarX = interfaceC1522e2.D(pF);
                        kotlin.jvm.internal.k.e(oVarX, "getMemberScope(...)");
                    } else {
                        oVar = oVarK;
                    }
                }
                return w(attributes, constructor, arguments, z10, oVar, new x(attributes, constructor, arguments, z10));
            }
            if (interfaceC1524gD2 instanceof InterfaceC1506N) {
                oVarX = Z8.i.a(ErrorScopeKind.d, true, ((AbstractC1644m) ((InterfaceC1506N) interfaceC1524gD2)).getName().f690a);
            } else {
                if (!(constructor instanceof v)) {
                    throw new IllegalStateException("Unsupported classifier: " + interfaceC1524gD2 + " for constructor: " + constructor);
                }
                oVarX = H4.o.x("member scope for intersection type", ((v) constructor).b);
            }
        }
        oVar = oVarX;
        return w(attributes, constructor, arguments, z10, oVar, new x(attributes, constructor, arguments, z10));
    }

    public static final A v(Q8.o memberScope, H attributes, K constructor, List arguments, boolean z10) {
        kotlin.jvm.internal.k.f(attributes, "attributes");
        kotlin.jvm.internal.k.f(constructor, "constructor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        kotlin.jvm.internal.k.f(memberScope, "memberScope");
        B b = new B(constructor, arguments, z10, memberScope, new x(memberScope, attributes, constructor, arguments, z10));
        return attributes.isEmpty() ? b : new C(b, attributes);
    }

    public static final A w(H attributes, K constructor, List arguments, boolean z10, Q8.o memberScope, S7.k kVar) {
        kotlin.jvm.internal.k.f(attributes, "attributes");
        kotlin.jvm.internal.k.f(constructor, "constructor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        kotlin.jvm.internal.k.f(memberScope, "memberScope");
        B b = new B(constructor, arguments, z10, memberScope, kVar);
        return attributes.isEmpty() ? b : new C(b, attributes);
    }

    public static final w x(InterfaceC1507O interfaceC1507O) {
        kotlin.jvm.internal.k.f(interfaceC1507O, "<this>");
        InterfaceC1527j interfaceC1527jD = interfaceC1507O.d();
        kotlin.jvm.internal.k.e(interfaceC1527jD, "getContainingDeclaration(...)");
        if (interfaceC1527jD instanceof InterfaceC1525h) {
            List parameters = ((InterfaceC1525h) interfaceC1527jD).m().getParameters();
            kotlin.jvm.internal.k.e(parameters, "getParameters(...)");
            List list = parameters;
            ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                K kM = ((InterfaceC1507O) it.next()).m();
                kotlin.jvm.internal.k.e(kM, "getTypeConstructor(...)");
                arrayList.add(kM);
            }
            List upperBounds = interfaceC1507O.getUpperBounds();
            kotlin.jvm.internal.k.e(upperBounds, "getUpperBounds(...)");
            return c(arrayList, upperBounds, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(interfaceC1507O));
        }
        if (!(interfaceC1527jD instanceof InterfaceC1536s)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List typeParameters = ((InterfaceC1536s) interfaceC1527jD).getTypeParameters();
        kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
        List list2 = typeParameters;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            K kM2 = ((InterfaceC1507O) it2.next()).m();
            kotlin.jvm.internal.k.e(kM2, "getTypeConstructor(...)");
            arrayList2.add(kM2);
        }
        List upperBounds2 = interfaceC1507O.getUpperBounds();
        kotlin.jvm.internal.k.e(upperBounds2, "getUpperBounds(...)");
        return c(arrayList2, upperBounds2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(interfaceC1507O));
    }

    public static boolean y(Y8.b bVar, InterfaceC0311c interfaceC0311c, InterfaceC0311c interfaceC0311c2) {
        if (bVar.O(interfaceC0311c) == bVar.O(interfaceC0311c2) && bVar.p(interfaceC0311c) == bVar.p(interfaceC0311c2)) {
            if ((bVar.c0(interfaceC0311c) == null) == (bVar.c0(interfaceC0311c2) == null) && bVar.w(bVar.g(interfaceC0311c), bVar.g(interfaceC0311c2))) {
                if (!bVar.o(interfaceC0311c, interfaceC0311c2)) {
                    int iO = bVar.O(interfaceC0311c);
                    for (int i = 0; i < iO; i++) {
                        N nS = bVar.S(interfaceC0311c, i);
                        N nS2 = bVar.S(interfaceC0311c2, i);
                        if (bVar.V(nS) == bVar.V(nS2) && (bVar.V(nS) || (bVar.q(nS) == bVar.q(nS2) && z(bVar, bVar.R(nS), bVar.R(nS2))))) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean z(Y8.b bVar, InterfaceC0310b interfaceC0310b, InterfaceC0310b interfaceC0310b2) {
        if (interfaceC0310b == interfaceC0310b2) {
            return true;
        }
        A aM = bVar.m(interfaceC0310b);
        A aM2 = bVar.m(interfaceC0310b2);
        if (aM != null && aM2 != null) {
            return y(bVar, aM, aM2);
        }
        AbstractC0285p abstractC0285pL = bVar.l(interfaceC0310b);
        AbstractC0285p abstractC0285pL2 = bVar.l(interfaceC0310b2);
        return abstractC0285pL != null && abstractC0285pL2 != null && y(bVar, bVar.s(abstractC0285pL), bVar.s(abstractC0285pL2)) && y(bVar, bVar.t(abstractC0285pL), bVar.t(abstractC0285pL2));
    }

    public abstract InterfaceC0311c D(J j5, InterfaceC0310b interfaceC0310b);
}
