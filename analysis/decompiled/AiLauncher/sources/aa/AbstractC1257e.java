package aa;

import S9.AbstractC1003b;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import p9.InterfaceC5074l;

/* renamed from: aa.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1257e<TAnnotation> {

    /* renamed from: aa.e$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Ca.g f8121a;

        /* renamed from: b, reason: collision with root package name */
        public final S9.B f8122b;

        /* renamed from: c, reason: collision with root package name */
        public final Ca.o f8123c;

        public a(Ca.g gVar, S9.B b10, Ca.o oVar) {
            this.f8121a = gVar;
            this.f8122b = b10;
            this.f8123c = oVar;
        }

        public final S9.B a() {
            return this.f8122b;
        }

        public final Ca.g b() {
            return this.f8121a;
        }

        public final Ca.o c() {
            return this.f8123c;
        }
    }

    public static final Iterable M(AbstractC1257e abstractC1257e, Ca.q qVar, a it) {
        Ca.g gVarB;
        Ca.n nVarV;
        List<Ca.o> listE0;
        Ca.g gVarB2;
        kotlin.jvm.internal.p.i(it, "it");
        if ((abstractC1257e.D() && (gVarB2 = it.b()) != null && qVar.I0(gVarB2)) || (gVarB = it.b()) == null || (nVarV = qVar.V(gVarB)) == null || (listE0 = qVar.E0(nVarV)) == null) {
            return null;
        }
        List<Ca.o> list = listE0;
        List<Ca.k> listM = qVar.M(it.b());
        Iterator<T> it2 = list.iterator();
        Iterator<T> it3 = listM.iterator();
        ArrayList arrayList = new ArrayList(Math.min(C1174w.x(list, 10), C1174w.x(listM, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            Ca.o oVar = (Ca.o) it2.next();
            Ca.g gVarL0 = qVar.L0((Ca.k) it3.next());
            arrayList.add(gVarL0 == null ? new a(null, it.a(), oVar) : new a(gVarL0, abstractC1257e.i(gVarL0, it.a()), oVar));
        }
        return arrayList;
    }

    public static final List a(List list, AbstractC1257e abstractC1257e) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Ca.g gVarY = abstractC1257e.y((Ca.g) it.next());
            if (gVarY != null) {
                arrayList.add(gVarY);
            }
        }
        return arrayList;
    }

    public static final List<Ca.g> b(Y8.h<? extends List<? extends Ca.g>> hVar) {
        return (List) hVar.getValue();
    }

    public static final C1261i h(p0 p0Var, C1261i[] c1261iArr, int i10) {
        Map<Integer, C1261i> mapB;
        C1261i c1261i;
        return (p0Var == null || (mapB = p0Var.b()) == null || (c1261i = mapB.get(Integer.valueOf(i10))) == null) ? (i10 < 0 || i10 >= c1261iArr.length) ? C1261i.f8142e.a() : c1261iArr[i10] : c1261i;
    }

    public static final boolean l(AbstractC1257e abstractC1257e, a aVar, Object extractNullability) {
        kotlin.jvm.internal.p.i(extractNullability, "$this$extractNullability");
        return abstractC1257e.o(extractNullability, aVar.b());
    }

    public abstract ga.d A(Ca.g gVar);

    public final NullabilityQualifier B(Ca.g gVar) {
        Ca.q qVarE = E();
        if (qVarE.N(qVarE.z0(gVar))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (qVarE.N(qVarE.E(gVar))) {
            return null;
        }
        return NullabilityQualifier.NOT_NULL;
    }

    public boolean C(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return true;
    }

    public abstract boolean D();

    public abstract Ca.q E();

    public abstract boolean F(Ca.g gVar);

    public abstract boolean G();

    public abstract boolean H(Ca.g gVar, Ca.g gVar2);

    public abstract boolean I(Ca.o oVar);

    public abstract boolean J(Ca.g gVar);

    public final C1263k K(C1263k c1263k, C1263k c1263k2) {
        return c1263k == null ? c1263k2 : (c1263k2 != null && ((c1263k.d() && !c1263k2.d()) || ((c1263k.d() || !c1263k2.d()) && (c1263k.c().compareTo(c1263k2.c()) < 0 || c1263k.c().compareTo(c1263k2.c()) <= 0)))) ? c1263k2 : c1263k;
    }

    public final List<a> L(Ca.g gVar) {
        return m(new a(gVar, i(gVar, u()), null), new C1256d(this, E()));
    }

    public final InterfaceC5074l<Integer, C1261i> g(Ca.g gVar, Iterable<? extends Ca.g> overrides, p0 p0Var, boolean z10) {
        int size;
        Ca.g gVarB;
        kotlin.jvm.internal.p.i(gVar, "<this>");
        kotlin.jvm.internal.p.i(overrides, "overrides");
        List<a> listL = L(gVar);
        ArrayList arrayList = new ArrayList(C1174w.x(overrides, 10));
        Iterator<? extends Ca.g> it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(L(it.next()));
        }
        if (z()) {
            size = 1;
            break;
        }
        if (G() && (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty())) {
            Iterator<? extends Ca.g> it2 = overrides.iterator();
            while (it2.hasNext()) {
                if (!H(gVar, it2.next())) {
                    size = 1;
                    break;
                }
            }
        }
        size = listL.size();
        C1261i[] c1261iArr = new C1261i[size];
        int i10 = 0;
        while (i10 < size) {
            C1261i c1261iK = k(listL.get(i10));
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                a aVar = (a) Z8.F.t0((List) it3.next(), i10);
                C1261i c1261iJ = (aVar == null || (gVarB = aVar.b()) == null) ? null : j(gVarB);
                if (c1261iJ != null) {
                    arrayList2.add(c1261iJ);
                }
            }
            c1261iArr[i10] = r0.a(c1261iK, arrayList2, i10 == 0 && G(), i10 == 0 && v(), z10);
            i10++;
        }
        return new C1255c(p0Var, c1261iArr);
    }

    public final S9.B i(Ca.g gVar, S9.B b10) {
        return p().d(b10, q(gVar));
    }

    public final C1261i j(Ca.g gVar) {
        NullabilityQualifier nullabilityQualifierB;
        NullabilityQualifier nullabilityQualifierB2 = B(gVar);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifierB2 == null) {
            Ca.g gVarY = y(gVar);
            nullabilityQualifierB = gVarY != null ? B(gVarY) : null;
        } else {
            nullabilityQualifierB = nullabilityQualifierB2;
        }
        Ca.q qVarE = E();
        D9.a aVar = D9.a.f2270a;
        if (aVar.l(A(qVarE.z0(gVar)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (aVar.k(A(qVarE.E(gVar)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        return new C1261i(nullabilityQualifierB, mutabilityQualifier, E().o(gVar) || J(gVar), nullabilityQualifierB != nullabilityQualifierB2);
    }

    public final C1261i k(a aVar) {
        List listM;
        C1263k c1263kR;
        Ca.g gVarB;
        Ca.n nVarV;
        if (aVar.b() == null) {
            Ca.q qVarE = E();
            Ca.o oVarC = aVar.c();
            if ((oVarC != null ? qVarE.F0(oVarC) : null) == TypeVariance.IN) {
                return C1261i.f8142e.a();
            }
        }
        boolean z10 = false;
        boolean z11 = aVar.c() == null;
        Ca.g gVarB2 = aVar.b();
        if (gVarB2 == null || (listM = q(gVarB2)) == null) {
            listM = C1173v.m();
        }
        Ca.q qVarE2 = E();
        Ca.g gVarB3 = aVar.b();
        Ca.o oVarR = (gVarB3 == null || (nVarV = qVarE2.V(gVarB3)) == null) ? null : qVarE2.r(nVarV);
        boolean z12 = t() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        if (z11) {
            if (z12 || !x() || (gVarB = aVar.b()) == null || !F(gVarB)) {
                listM = Z8.F.P0(s(), listM);
            } else {
                Iterable<TAnnotation> iterableS = s();
                ArrayList arrayList = new ArrayList();
                for (TAnnotation tannotation : iterableS) {
                    if (!p().p(tannotation)) {
                        arrayList.add(tannotation);
                    }
                }
                listM = Z8.F.S0(arrayList, listM);
            }
        }
        MutabilityQualifier mutabilityQualifierG = p().g(listM);
        C1263k c1263kH = p().h(listM, new C1253a(this, aVar));
        if (c1263kH != null) {
            NullabilityQualifier nullabilityQualifierC = c1263kH.c();
            if (c1263kH.c() == NullabilityQualifier.NOT_NULL && oVarR != null) {
                z10 = true;
            }
            return new C1261i(nullabilityQualifierC, mutabilityQualifierG, z10, c1263kH.d());
        }
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityTypeT = (z11 || z12) ? t() : AnnotationQualifierApplicabilityType.TYPE_USE;
        S9.B bA = aVar.a();
        S9.t tVarA = bA != null ? bA.a(annotationQualifierApplicabilityTypeT) : null;
        C1263k c1263kR2 = oVarR != null ? r(oVarR) : null;
        C1263k c1263kW = w(c1263kR2, tVarA);
        boolean z13 = (c1263kR2 != null ? c1263kR2.c() : null) == NullabilityQualifier.NOT_NULL || !(oVarR == null || tVarA == null || !tVarA.c());
        Ca.o oVarC2 = aVar.c();
        if (oVarC2 == null || (c1263kR = r(oVarC2)) == null) {
            c1263kR = null;
        } else if (c1263kR.c() == NullabilityQualifier.NULLABLE) {
            c1263kR = C1263k.b(c1263kR, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
        }
        C1263k c1263kK = K(c1263kR, c1263kW);
        NullabilityQualifier nullabilityQualifierC2 = c1263kK != null ? c1263kK.c() : null;
        if (c1263kK != null && c1263kK.d()) {
            z10 = true;
        }
        return new C1261i(nullabilityQualifierC2, mutabilityQualifierG, z13, z10);
    }

    public final <T> List<T> m(T t10, InterfaceC5074l<? super T, ? extends Iterable<? extends T>> interfaceC5074l) {
        ArrayList arrayList = new ArrayList(1);
        n(t10, arrayList, interfaceC5074l);
        return arrayList;
    }

    public final <T> void n(T t10, List<T> list, InterfaceC5074l<? super T, ? extends Iterable<? extends T>> interfaceC5074l) {
        list.add(t10);
        Iterable<? extends T> iterableInvoke = interfaceC5074l.invoke(t10);
        if (iterableInvoke != null) {
            Iterator<? extends T> it = iterableInvoke.iterator();
            while (it.hasNext()) {
                n(it.next(), list, interfaceC5074l);
            }
        }
    }

    public abstract boolean o(TAnnotation tannotation, Ca.g gVar);

    public abstract AbstractC1003b<TAnnotation> p();

    public abstract Iterable<TAnnotation> q(Ca.g gVar);

    public final C1263k r(Ca.o oVar) {
        List<Ca.g> listB;
        NullabilityQualifier nullabilityQualifier;
        Ca.q qVarE = E();
        if (!I(oVar)) {
            return null;
        }
        List<Ca.g> listD0 = qVarE.d0(oVar);
        List<Ca.g> list = listD0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!qVarE.C0((Ca.g) it.next())) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (B((Ca.g) obj) != null) {
                            arrayList.add(obj);
                        }
                    }
                    Y8.h hVarA = C4848b.a(LazyThreadSafetyMode.NONE, new C1254b(listD0, this));
                    if (!arrayList.isEmpty()) {
                        if (!arrayList.isEmpty()) {
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                if (C((Ca.g) it2.next())) {
                                    listB = listD0;
                                }
                            }
                        }
                        return new C1263k(NullabilityQualifier.FORCE_FLEXIBILITY, false);
                    }
                    if (!b(hVarA).isEmpty()) {
                        List<Ca.g> listB2 = b(hVarA);
                        if (!(listB2 instanceof Collection) || !listB2.isEmpty()) {
                            Iterator<T> it3 = listB2.iterator();
                            while (it3.hasNext()) {
                                if (C((Ca.g) it3.next())) {
                                    listB = b(hVarA);
                                }
                            }
                        }
                        return new C1263k(NullabilityQualifier.FORCE_FLEXIBILITY, true);
                    }
                    List<Ca.g> list2 = listB;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        nullabilityQualifier = NullabilityQualifier.NULLABLE;
                    } else {
                        Iterator<T> it4 = list2.iterator();
                        while (it4.hasNext()) {
                            if (!qVarE.p((Ca.g) it4.next())) {
                                nullabilityQualifier = NullabilityQualifier.NOT_NULL;
                                break;
                            }
                        }
                        nullabilityQualifier = NullabilityQualifier.NULLABLE;
                    }
                    return new C1263k(nullabilityQualifier, listB != listD0);
                }
            }
        }
        return null;
    }

    public abstract Iterable<TAnnotation> s();

    public abstract AnnotationQualifierApplicabilityType t();

    public abstract S9.B u();

    public abstract boolean v();

    public abstract C1263k w(C1263k c1263k, S9.t tVar);

    public abstract boolean x();

    public abstract Ca.g y(Ca.g gVar);

    public boolean z() {
        return false;
    }
}
