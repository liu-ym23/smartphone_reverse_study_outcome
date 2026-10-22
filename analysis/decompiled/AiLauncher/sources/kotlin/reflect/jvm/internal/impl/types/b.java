package kotlin.reflect.jvm.internal.impl.types;

import Ca.e;
import Ca.f;
import Ca.g;
import Ca.h;
import Ca.i;
import Ca.j;
import Ca.k;
import Ca.n;
import Ca.o;
import Ca.q;
import Ca.r;
import Ca.v;
import Y8.t;
import Z8.A;
import Z8.C1172u;
import Z8.C1173v;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import ya.C5993f;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f36092a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f36093b;

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36094a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36095b;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.INV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeVariance.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f36094a = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f36095b = iArr2;
        }
    }

    public static final boolean d(q qVar, h hVar) {
        g gVarM;
        h hVarB0;
        return (hVar instanceof Ca.b) && (gVarM = r.m(qVar, r.V(qVar, r.Y(qVar, (Ca.b) hVar)))) != null && (hVarB0 = r.b0(qVar, gVarM)) != null && r.D(qVar, hVarB0);
    }

    public static final boolean e(q qVar, h hVar) {
        n nVarA0 = r.a0(qVar, hVar);
        if (!(nVarA0 instanceof f)) {
            return false;
        }
        Collection<g> collectionX = r.X(qVar, nVarA0);
        if ((collectionX instanceof Collection) && collectionX.isEmpty()) {
            return false;
        }
        Iterator<T> it = collectionX.iterator();
        while (it.hasNext()) {
            h hVarE = r.e(qVar, (g) it.next());
            if (hVarE != null && r.D(qVar, hVarE)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(q qVar, h hVar) {
        return r.D(qVar, hVar) || d(qVar, hVar);
    }

    public static final boolean g(q qVar, TypeCheckerState typeCheckerState, h hVar, h hVar2, boolean z10) {
        TypeCheckerState typeCheckerState2;
        h hVar3;
        Collection<g> collectionU = r.U(qVar, hVar);
        if ((collectionU instanceof Collection) && collectionU.isEmpty()) {
            return false;
        }
        for (g gVar : collectionU) {
            if (p.d(r.Z(qVar, gVar), r.a0(qVar, hVar2))) {
                return true;
            }
            if (z10) {
                typeCheckerState2 = typeCheckerState;
                hVar3 = hVar2;
                if (w(f36092a, typeCheckerState2, hVar3, gVar, false, 8, null)) {
                    return true;
                }
            } else {
                typeCheckerState2 = typeCheckerState;
                hVar3 = hVar2;
            }
            typeCheckerState = typeCheckerState2;
            hVar2 = hVar3;
        }
        return false;
    }

    public static /* synthetic */ boolean w(b bVar, TypeCheckerState typeCheckerState, g gVar, g gVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return bVar.v(typeCheckerState, gVar, gVar2, z10);
    }

    public static final t y(Collection collection, TypeCheckerState typeCheckerState, q qVar, h hVar, TypeCheckerState.a runForkingPoint) {
        p.i(runForkingPoint, "$this$runForkingPoint");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            runForkingPoint.a(new C5993f(typeCheckerState, qVar, (h) it.next(), hVar));
        }
        return t.f7040a;
    }

    public static final boolean z(TypeCheckerState typeCheckerState, q qVar, h hVar, h hVar2) {
        return f36092a.t(typeCheckerState, qVar, r.b(qVar, hVar), hVar2);
    }

    public final boolean A(q qVar, g gVar, g gVar2, n nVar) {
        o oVarN;
        h hVarE = r.e(qVar, gVar);
        if (hVarE instanceof Ca.b) {
            Ca.b bVar = (Ca.b) hVarE;
            if (r.J(qVar, bVar) || !r.L(qVar, r.V(qVar, r.Y(qVar, bVar))) || r.g(qVar, bVar) != CaptureStatus.FOR_SUBTYPING) {
                return false;
            }
            n nVarZ = r.Z(qVar, gVar2);
            v vVar = nVarZ instanceof v ? (v) nVarZ : null;
            if (vVar != null && (oVarN = r.n(qVar, vVar)) != null && r.q(qVar, oVarN, nVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<h> B(q qVar, List<? extends h> list) {
        int i10;
        if (list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                j jVarB = r.b(qVar, (h) obj);
                int iX = qVar.x(jVarB);
                while (true) {
                    if (i10 >= iX) {
                        arrayList.add(obj);
                        break;
                    }
                    g gVarM = r.m(qVar, qVar.Q(jVarB, i10));
                    i10 = (gVarM != null ? r.d(qVar, gVarM) : null) == null ? i10 + 1 : 0;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }

    public final Boolean c(TypeCheckerState typeCheckerState, q qVar, h hVar, h hVar2) {
        if (!r.D(qVar, hVar) && !r.D(qVar, hVar2)) {
            return null;
        }
        if (f(qVar, hVar) && f(qVar, hVar2)) {
            return Boolean.TRUE;
        }
        if (r.D(qVar, hVar)) {
            if (g(qVar, typeCheckerState, hVar, hVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (r.D(qVar, hVar2) && (e(qVar, hVar) || g(qVar, typeCheckerState, hVar2, hVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean h(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r13, Ca.q r14, Ca.h r15, Ca.h r16) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.b.h(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, Ca.q, Ca.h, Ca.h):java.lang.Boolean");
    }

    public final List<h> i(TypeCheckerState typeCheckerState, q qVar, h hVar, n nVar) {
        TypeCheckerState.b bVarQ0;
        List<i> listH = r.h(qVar, hVar, nVar);
        if (listH != null) {
            return listH;
        }
        if (!r.u(qVar, nVar) && r.t(qVar, hVar)) {
            return C1173v.m();
        }
        if (r.v(qVar, nVar)) {
            if (!qVar.y(r.a0(qVar, hVar), nVar)) {
                return C1173v.m();
            }
            h hVarK = qVar.k(hVar, CaptureStatus.FOR_SUBTYPING);
            if (hVarK != null) {
                hVar = hVarK;
            }
            return C1172u.e(hVar);
        }
        Ia.j jVar = new Ia.j();
        typeCheckerState.k();
        ArrayDeque<h> arrayDequeH = typeCheckerState.h();
        p.f(arrayDequeH);
        Set<h> setI = typeCheckerState.i();
        p.f(setI);
        arrayDequeH.push(hVar);
        while (!arrayDequeH.isEmpty()) {
            h hVarPop = arrayDequeH.pop();
            p.f(hVarPop);
            if (setI.add(hVarPop)) {
                h hVarK2 = qVar.k(hVarPop, CaptureStatus.FOR_SUBTYPING);
                if (hVarK2 == null) {
                    hVarK2 = hVarPop;
                }
                if (qVar.y(r.a0(qVar, hVarK2), nVar)) {
                    jVar.add(hVarK2);
                    bVarQ0 = TypeCheckerState.b.c.f36086a;
                } else {
                    bVarQ0 = r.a(qVar, hVarK2) == 0 ? TypeCheckerState.b.C0460b.f36085a : typeCheckerState.j().q0(hVarK2);
                }
                if (p.d(bVarQ0, TypeCheckerState.b.c.f36086a)) {
                    bVarQ0 = null;
                }
                if (bVarQ0 != null) {
                    q qVarJ = typeCheckerState.j();
                    Iterator<g> it = qVarJ.K0(qVarJ.e(hVarPop)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(bVarQ0.a(typeCheckerState, it.next()));
                    }
                }
            }
        }
        typeCheckerState.e();
        return jVar;
    }

    public final List<h> j(TypeCheckerState typeCheckerState, q qVar, h hVar, n nVar) {
        return B(qVar, i(typeCheckerState, qVar, hVar, nVar));
    }

    public final boolean k(TypeCheckerState typeCheckerState, q qVar, g gVar, g gVar2, boolean z10) {
        g gVarP = typeCheckerState.p(typeCheckerState.q(gVar));
        g gVarP2 = typeCheckerState.p(typeCheckerState.q(gVar2));
        if (typeCheckerState.m() && r.B(qVar, gVarP) && r.w(qVar, gVarP2)) {
            e eVarD = r.d(qVar, gVarP);
            p.f(eVarD);
            h hVarO = r.O(qVar, eVarD);
            h hVarE = r.e(qVar, gVarP2);
            p.f(hVarE);
            return k(typeCheckerState, qVar, hVarO, r.S(qVar, hVarE), z10);
        }
        Boolean boolH = h(typeCheckerState, qVar, r.P(qVar, gVarP), r.b0(qVar, gVarP2));
        if (boolH == null) {
            Boolean boolC = typeCheckerState.c(gVarP, gVarP2, z10);
            return boolC != null ? boolC.booleanValue() : x(typeCheckerState, qVar, r.P(qVar, gVarP), r.b0(qVar, gVarP2));
        }
        boolean zBooleanValue = boolH.booleanValue();
        typeCheckerState.c(gVarP, gVarP2, z10);
        return zBooleanValue;
    }

    public final TypeVariance l(TypeVariance declared, TypeVariance useSite) {
        p.i(declared, "declared");
        p.i(useSite, "useSite");
        TypeVariance typeVariance = TypeVariance.INV;
        if (declared == typeVariance) {
            return useSite;
        }
        if (useSite == typeVariance || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean m(TypeCheckerState state, g a10, g b10) {
        p.i(state, "state");
        p.i(a10, "a");
        p.i(b10, "b");
        q qVarJ = state.j();
        if (a10 == b10) {
            return true;
        }
        b bVar = f36092a;
        if (bVar.r(qVarJ, a10) && bVar.r(qVarJ, b10)) {
            g gVarP = state.p(state.q(a10));
            g gVarP2 = state.p(state.q(b10));
            h hVarZ0 = qVarJ.z0(gVarP);
            if (!qVarJ.y(qVarJ.V(gVarP), qVarJ.V(gVarP2))) {
                return false;
            }
            if (qVarJ.k0(hVarZ0) == 0) {
                return qVarJ.O0(gVarP) || qVarJ.O0(gVarP2) || qVarJ.N(hVarZ0) == qVarJ.N(qVarJ.z0(gVarP2));
            }
        }
        return w(bVar, state, a10, b10, false, 8, null) && w(bVar, state, b10, a10, false, 8, null);
    }

    public final List<h> n(TypeCheckerState state, h subType, n superConstructor) {
        p.i(state, "state");
        p.i(subType, "subType");
        p.i(superConstructor, "superConstructor");
        return f36092a.o(state, state.j(), subType, superConstructor);
    }

    public final List<h> o(TypeCheckerState state, q c10, h subType, n superConstructor) {
        TypeCheckerState.b bVar;
        p.i(state, "state");
        p.i(c10, "c");
        p.i(subType, "subType");
        p.i(superConstructor, "superConstructor");
        if (r.t(c10, subType)) {
            return j(state, c10, subType, superConstructor);
        }
        if (!r.u(c10, superConstructor) && !r.E(c10, superConstructor)) {
            return i(state, c10, subType, superConstructor);
        }
        Ia.j<h> jVar = new Ia.j();
        state.k();
        ArrayDeque<h> arrayDequeH = state.h();
        p.f(arrayDequeH);
        Set<h> setI = state.i();
        p.f(setI);
        arrayDequeH.push(subType);
        while (!arrayDequeH.isEmpty()) {
            h hVarPop = arrayDequeH.pop();
            p.f(hVarPop);
            if (setI.add(hVarPop)) {
                if (r.t(c10, hVarPop)) {
                    jVar.add(hVarPop);
                    bVar = TypeCheckerState.b.c.f36086a;
                } else {
                    bVar = TypeCheckerState.b.C0460b.f36085a;
                }
                if (p.d(bVar, TypeCheckerState.b.c.f36086a)) {
                    bVar = null;
                }
                if (bVar != null) {
                    q qVarJ = state.j();
                    Iterator<g> it = qVarJ.K0(qVarJ.e(hVarPop)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(bVar.a(state, it.next()));
                    }
                }
            }
        }
        state.e();
        ArrayList arrayList = new ArrayList();
        for (h hVar : jVar) {
            b bVar2 = f36092a;
            p.f(hVar);
            A.E(arrayList, bVar2.j(state, c10, hVar, superConstructor));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return Ca.r.l(r7, Ca.r.Z(r7, r8), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Ca.o p(Ca.q r7, Ca.g r8, Ca.g r9) {
        /*
            r6 = this;
            int r0 = Ca.r.a(r7, r8)
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L5e
            Ca.k r4 = Ca.r.j(r7, r8, r2)
            boolean r5 = Ca.r.L(r7, r4)
            if (r5 != 0) goto L14
            r3 = r4
        L14:
            if (r3 == 0) goto L5b
            Ca.g r3 = Ca.r.m(r7, r3)
            if (r3 != 0) goto L1d
            goto L5b
        L1d:
            Ca.h r4 = Ca.r.P(r7, r3)
            boolean r4 = Ca.r.s(r7, r4)
            if (r4 == 0) goto L33
            Ca.h r4 = Ca.r.P(r7, r9)
            boolean r4 = Ca.r.s(r7, r4)
            if (r4 == 0) goto L33
            r4 = 1
            goto L34
        L33:
            r4 = r1
        L34:
            boolean r5 = kotlin.jvm.internal.p.d(r3, r9)
            if (r5 != 0) goto L52
            if (r4 == 0) goto L4b
            Ca.n r4 = Ca.r.Z(r7, r3)
            Ca.n r5 = Ca.r.Z(r7, r9)
            boolean r4 = kotlin.jvm.internal.p.d(r4, r5)
            if (r4 == 0) goto L4b
            goto L52
        L4b:
            Ca.o r3 = r6.p(r7, r3, r9)
            if (r3 == 0) goto L5b
            return r3
        L52:
            Ca.n r6 = Ca.r.Z(r7, r8)
            Ca.o r6 = Ca.r.l(r7, r6, r2)
            return r6
        L5b:
            int r2 = r2 + 1
            goto L6
        L5e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.b.p(Ca.q, Ca.g, Ca.g):Ca.o");
    }

    public final boolean q(TypeCheckerState typeCheckerState, q qVar, h hVar) {
        n nVarA0 = r.a0(qVar, hVar);
        if (r.u(qVar, nVarA0)) {
            return r.I(qVar, nVarA0);
        }
        if (r.I(qVar, r.a0(qVar, hVar))) {
            return true;
        }
        typeCheckerState.k();
        ArrayDeque<h> arrayDequeH = typeCheckerState.h();
        p.f(arrayDequeH);
        Set<h> setI = typeCheckerState.i();
        p.f(setI);
        arrayDequeH.push(hVar);
        while (!arrayDequeH.isEmpty()) {
            h hVarPop = arrayDequeH.pop();
            p.f(hVarPop);
            if (setI.add(hVarPop)) {
                TypeCheckerState.b bVar = r.t(qVar, hVarPop) ? TypeCheckerState.b.c.f36086a : TypeCheckerState.b.C0460b.f36085a;
                if (p.d(bVar, TypeCheckerState.b.c.f36086a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    q qVarJ = typeCheckerState.j();
                    Iterator<g> it = qVarJ.K0(qVarJ.e(hVarPop)).iterator();
                    while (it.hasNext()) {
                        h hVarA = bVar.a(typeCheckerState, it.next());
                        if (r.I(qVar, r.a0(qVar, hVarA))) {
                            typeCheckerState.e();
                            return true;
                        }
                        arrayDequeH.add(hVarA);
                    }
                }
            }
        }
        typeCheckerState.e();
        return false;
    }

    public final boolean r(q qVar, g gVar) {
        return (!r.y(qVar, r.Z(qVar, gVar)) || r.z(qVar, gVar) || r.w(qVar, gVar) || r.H(qVar, gVar) || r.C(qVar, gVar)) ? false : true;
    }

    public final boolean s(q qVar, h hVar, h hVar2) {
        if (r.a0(qVar, hVar) != r.a0(qVar, hVar2)) {
            return false;
        }
        if (r.x(qVar, hVar) || !r.x(qVar, hVar2)) {
            return !r.G(qVar, hVar) || r.G(qVar, hVar2);
        }
        return false;
    }

    public final boolean t(TypeCheckerState typeCheckerState, q c10, j capturedSubArguments, h superType) {
        boolean zM;
        TypeCheckerState state = typeCheckerState;
        p.i(state, "state");
        p.i(c10, "c");
        p.i(capturedSubArguments, "capturedSubArguments");
        p.i(superType, "superType");
        n nVarA0 = r.a0(c10, superType);
        int iW = r.W(c10, capturedSubArguments);
        int iT = r.T(c10, nVarA0);
        if (iW != iT || iW != r.a(c10, superType)) {
            return false;
        }
        for (int i10 = 0; i10 < iT; i10++) {
            k kVarJ = r.j(c10, superType, i10);
            g gVarM = r.m(c10, kVarJ);
            if (gVarM != null) {
                k kVarI = r.i(c10, capturedSubArguments, i10);
                r.o(c10, kVarI);
                TypeVariance typeVariance = TypeVariance.INV;
                g gVarM2 = r.m(c10, kVarI);
                p.f(gVarM2);
                TypeVariance typeVarianceL = l(r.p(c10, r.l(c10, nVarA0, i10)), r.o(c10, kVarJ));
                if (typeVarianceL == null) {
                    return state.n();
                }
                if (typeVarianceL != typeVariance || (!A(c10, gVarM2, gVarM, nVarA0) && !A(c10, gVarM, gVarM2, nVarA0))) {
                    if (state.f36080h > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + gVarM2).toString());
                    }
                    state.f36080h++;
                    int i11 = a.f36094a[typeVarianceL.ordinal()];
                    if (i11 == 1) {
                        zM = f36092a.m(state, gVarM2, gVarM);
                    } else if (i11 == 2) {
                        state = typeCheckerState;
                        zM = w(f36092a, state, gVarM2, gVarM, false, 8, null);
                    } else {
                        if (i11 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zM = w(f36092a, state, gVarM, gVarM2, false, 8, null);
                        state = typeCheckerState;
                    }
                    state.f36080h--;
                    if (!zM) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean u(TypeCheckerState state, g subType, g superType) {
        p.i(state, "state");
        p.i(subType, "subType");
        p.i(superType, "superType");
        return w(this, state, subType, superType, false, 8, null);
    }

    public final boolean v(TypeCheckerState state, g subType, g superType, boolean z10) {
        p.i(state, "state");
        p.i(subType, "subType");
        p.i(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (!state.f(subType, superType)) {
            return false;
        }
        return f36092a.k(state, state.j(), subType, superType, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r20, Ca.q r21, Ca.h r22, Ca.h r23) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.b.x(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, Ca.q, Ca.h, Ca.h):boolean");
    }
}
