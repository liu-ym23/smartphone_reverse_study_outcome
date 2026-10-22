package ya;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import v9.C5685n;
import xa.InterfaceC5863f;
import ya.w0;
import za.C6457c;

/* loaded from: classes5.dex */
public final class A0 {

    /* renamed from: f, reason: collision with root package name */
    public static final a f44002f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final C5971F f44003a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f44004b;

    /* renamed from: c, reason: collision with root package name */
    public final LockBasedStorageManager f44005c;

    /* renamed from: d, reason: collision with root package name */
    public final Y8.h f44006d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5863f<b, S> f44007e;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ya.S a(ya.S r17, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r18, java.util.Set<? extends E9.b0> r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 506
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ya.A0.a.a(ya.S, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor, java.util.Set, boolean):ya.S");
        }

        public a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final E9.b0 f44008a;

        /* renamed from: b, reason: collision with root package name */
        public final C5972G f44009b;

        public b(E9.b0 typeParameter, C5972G typeAttr) {
            kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
            kotlin.jvm.internal.p.i(typeAttr, "typeAttr");
            this.f44008a = typeParameter;
            this.f44009b = typeAttr;
        }

        public final C5972G a() {
            return this.f44009b;
        }

        public final E9.b0 b() {
            return this.f44008a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.p.d(bVar.f44008a, this.f44008a) && kotlin.jvm.internal.p.d(bVar.f44009b, this.f44009b);
        }

        public int hashCode() {
            int iHashCode = this.f44008a.hashCode();
            return iHashCode + (iHashCode * 31) + this.f44009b.hashCode();
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f44008a + ", typeAttr=" + this.f44009b + ')';
        }
    }

    public A0(C5971F projectionComputer, x0 options) {
        kotlin.jvm.internal.p.i(projectionComputer, "projectionComputer");
        kotlin.jvm.internal.p.i(options, "options");
        this.f44003a = projectionComputer;
        this.f44004b = options;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.f44005c = lockBasedStorageManager;
        this.f44006d = C4848b.b(new y0(this));
        InterfaceC5863f<b, S> interfaceC5863fC = lockBasedStorageManager.c(new z0(this));
        kotlin.jvm.internal.p.h(interfaceC5863fC, "createMemoizedFunction(...)");
        this.f44007e = interfaceC5863fC;
    }

    public static final Aa.g c(A0 a02) {
        return Aa.i.d(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, a02.toString());
    }

    public static final S f(A0 a02, b bVar) {
        return a02.g(bVar.b(), bVar.a());
    }

    public final S d(C5972G c5972g) {
        S sD;
        AbstractC5990d0 abstractC5990d0A = c5972g.a();
        return (abstractC5990d0A == null || (sD = Da.d.D(abstractC5990d0A)) == null) ? h() : sD;
    }

    public final S e(E9.b0 typeParameter, C5972G typeAttr) {
        kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
        kotlin.jvm.internal.p.i(typeAttr, "typeAttr");
        S sInvoke = this.f44007e.invoke(new b(typeParameter, typeAttr));
        kotlin.jvm.internal.p.h(sInvoke, "invoke(...)");
        return sInvoke;
    }

    public final S g(E9.b0 b0Var, C5972G c5972g) {
        B0 b0A;
        Set<E9.b0> setC = c5972g.c();
        if (setC != null && setC.contains(b0Var.a())) {
            return d(c5972g);
        }
        AbstractC5990d0 abstractC5990d0N = b0Var.n();
        kotlin.jvm.internal.p.h(abstractC5990d0N, "getDefaultType(...)");
        Set<E9.b0> setL = Da.d.l(abstractC5990d0N, setC);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(setL, 10)), 16));
        for (E9.b0 b0Var2 : setL) {
            if (setC == null || !setC.contains(b0Var2)) {
                b0A = this.f44003a.a(b0Var2, c5972g, this, e(b0Var2, c5972g.d(b0Var)));
            } else {
                b0A = H0.t(b0Var2, c5972g);
                kotlin.jvm.internal.p.h(b0A, "makeStarProjection(...)");
            }
            Pair pairA = Y8.j.a(b0Var2.j(), b0A);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        TypeSubstitutor typeSubstitutorH = TypeSubstitutor.h(w0.a.e(w0.f44131c, linkedHashMap, false, 2, null));
        kotlin.jvm.internal.p.h(typeSubstitutorH, "create(...)");
        List<S> upperBounds = b0Var.getUpperBounds();
        kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
        Set<S> setI = i(typeSubstitutorH, upperBounds, c5972g);
        if (setI.isEmpty()) {
            return d(c5972g);
        }
        if (!this.f44004b.a()) {
            if (setI.size() == 1) {
                return (S) Z8.F.W0(setI);
            }
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
        }
        List listM1 = Z8.F.m1(setI);
        ArrayList arrayList = new ArrayList(C1174w.x(listM1, 10));
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            arrayList.add(((S) it.next()).K0());
        }
        return C6457c.a(arrayList);
    }

    public final Aa.g h() {
        return (Aa.g) this.f44006d.getValue();
    }

    public final Set<S> i(TypeSubstitutor typeSubstitutor, List<? extends S> list, C5972G c5972g) {
        Set setB = Z8.X.b();
        for (S s10 : list) {
            InterfaceC0799d interfaceC0799dD = s10.H0().d();
            if (interfaceC0799dD instanceof InterfaceC0797b) {
                setB.add(f44002f.a(s10, typeSubstitutor, c5972g.c(), this.f44004b.b()));
            } else if (interfaceC0799dD instanceof E9.b0) {
                Set<E9.b0> setC = c5972g.c();
                if (setC == null || !setC.contains(interfaceC0799dD)) {
                    List<S> upperBounds = ((E9.b0) interfaceC0799dD).getUpperBounds();
                    kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
                    setB.addAll(i(typeSubstitutor, upperBounds, c5972g));
                } else {
                    setB.add(d(c5972g));
                }
            }
            if (!this.f44004b.a()) {
                break;
            }
        }
        return Z8.X.a(setB);
    }

    public /* synthetic */ A0(C5971F c5971f, x0 x0Var, int i10, kotlin.jvm.internal.i iVar) {
        this(c5971f, (i10 & 2) != 0 ? new x0(false, false) : x0Var);
    }
}
