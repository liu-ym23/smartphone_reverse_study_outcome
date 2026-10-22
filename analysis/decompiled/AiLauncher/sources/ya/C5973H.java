package ya;

import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* renamed from: ya.H, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5973H {

    /* renamed from: ya.H$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44022a;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f44022a = iArr;
        }
    }

    public static final Ca.o a(G0 g02, Ca.g gVar) {
        return g02.r(g02.V(gVar));
    }

    public static final Ca.o b(G0 g02, Ca.g gVar) {
        Ca.g gVarL0;
        Ca.o oVarA = a(g02, gVar);
        if (oVarA != null) {
            return oVarA;
        }
        if (g02.J0(gVar) && (gVarL0 = g02.L0((Ca.k) Z8.F.X0(g02.M(gVar)))) != null) {
            return b(g02, gVarL0);
        }
        return null;
    }

    public static final Ca.g c(G0 g02, Ca.g inlineClassType) {
        kotlin.jvm.internal.p.i(g02, "<this>");
        kotlin.jvm.internal.p.i(inlineClassType, "inlineClassType");
        return d(g02, inlineClassType, new HashSet());
    }

    public static final Ca.g d(G0 g02, Ca.g gVar, HashSet<Ca.n> hashSet) {
        Ca.g gVarD;
        Ca.n nVarV = g02.V(gVar);
        if (!hashSet.add(nVarV)) {
            return null;
        }
        Ca.o oVarR = g02.r(nVarV);
        if (oVarR != null) {
            Ca.g gVarB0 = g02.B0(oVarR);
            Ca.g gVarD2 = d(g02, gVarB0, hashSet);
            if (gVarD2 != null) {
                return ((gVarD2 instanceof Ca.i) && g02.r0((Ca.i) gVarD2) && g02.p(gVar) && (g02.s(g02.V(gVarB0)) || ((gVarB0 instanceof Ca.i) && g02.r0((Ca.i) gVarB0)))) ? g02.I(gVarB0) : (g02.p(gVarD2) || !g02.N(gVar)) ? gVarD2 : g02.I(gVarD2);
            }
            return null;
        }
        if (g02.s(nVarV)) {
            Ca.g gVarE = e(g02, gVar);
            if (gVarE == null || (gVarD = d(g02, gVarE, hashSet)) == null) {
                return null;
            }
            if (!g02.p(gVar)) {
                return gVarD;
            }
            if (!g02.p(gVarD) && (!(gVarD instanceof Ca.i) || !g02.r0((Ca.i) gVarD))) {
                return g02.I(gVarD);
            }
        }
        return gVar;
    }

    public static final Ca.g e(G0 g02, Ca.g gVar) {
        List<Ca.o> listE0 = g02.E0(g02.V(gVar));
        List<Ca.k> listM = g02.M(gVar);
        ArrayList arrayList = new ArrayList(C1174w.x(listM, 10));
        int i10 = 0;
        for (Object obj : listM) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Ca.g gVarL0 = g02.L0((Ca.k) obj);
            if (gVarL0 == null) {
                gVarL0 = g02.B0(listE0.get(i10));
            }
            arrayList.add(gVarL0);
            i10 = i11;
        }
        List<Ca.o> list = listE0;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(g02.g0((Ca.o) it.next()));
        }
        Ca.p pVarT = g02.T(kotlin.collections.a.y(Z8.F.w1(arrayList2, arrayList)));
        Ca.g gVarU = g02.U(gVar);
        if (gVarU == null) {
            return null;
        }
        Ca.o oVarB = b(g02, gVarU);
        return oVarB == null ? g02.t0(pVarT, gVarU) : f(g02, gVarU, g02.t0(pVarT, g02.B0(oVarB)));
    }

    public static final Ca.g f(G0 g02, Ca.g gVar, Ca.g gVar2) {
        Ca.g gVarF;
        if (a(g02, gVar) != null) {
            return g02.p(gVar) ? g02.I(gVar2) : gVar2;
        }
        Ca.k kVar = (Ca.k) Z8.F.X0(g02.M(gVar));
        if (a.f44022a[g02.D0(kVar).ordinal()] == 1) {
            gVarF = g02.i0();
        } else {
            Ca.g gVarL0 = g02.L0(kVar);
            kotlin.jvm.internal.p.f(gVarL0);
            gVarF = f(g02, gVarL0, gVar2);
        }
        Ca.i iVarF = g02.F(gVarF);
        return g02.p(gVar) ? g02.I(iVarF) : iVarF;
    }
}
