package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C0500u;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f10048a = B();

    /* renamed from: b, reason: collision with root package name */
    private static final o0<?, ?> f10049b = C(false);

    /* renamed from: c, reason: collision with root package name */
    private static final o0<?, ?> f10050c = C(true);

    /* renamed from: d, reason: collision with root package name */
    private static final o0<?, ?> f10051d = new q0();

    static <UT, UB> UB A(int i5, List<Integer> list, A.e eVar, UB ub, o0<UT, UB> o0Var) {
        if (eVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (!eVar.a(iIntValue)) {
                    ub = (UB) L(i5, iIntValue, ub, o0Var);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Integer num = list.get(i7);
            int iIntValue2 = num.intValue();
            if (eVar.a(iIntValue2)) {
                if (i7 != i6) {
                    list.set(i6, num);
                }
                i6++;
            } else {
                ub = (UB) L(i5, iIntValue2, ub, o0Var);
            }
        }
        if (i6 != size) {
            list.subList(i6, size).clear();
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static o0<?, ?> C(boolean z5) {
        try {
            Class<?> clsD = D();
            if (clsD == null) {
                return null;
            }
            return (o0) clsD.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z5));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends C0500u.b<FT>> void E(AbstractC0497q<FT> abstractC0497q, T t5, T t6) {
        C0500u<T> c0500uC = abstractC0497q.c(t6);
        if (c0500uC.n()) {
            return;
        }
        abstractC0497q.d(t5).u(c0500uC);
    }

    static <T> void F(M m5, T t5, T t6, long j5) {
        s0.O(t5, j5, m5.a(s0.A(t5, j5), s0.A(t6, j5)));
    }

    static <T, UT, UB> void G(o0<UT, UB> o0Var, T t5, T t6) {
        o0Var.p(t5, o0Var.k(o0Var.g(t5), o0Var.g(t6)));
    }

    public static o0<?, ?> H() {
        return f10049b;
    }

    public static o0<?, ?> I() {
        return f10050c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!AbstractC0504y.class.isAssignableFrom(cls) && (cls2 = f10048a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean K(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <UT, UB> UB L(int i5, int i6, UB ub, o0<UT, UB> o0Var) {
        if (ub == null) {
            ub = o0Var.n();
        }
        o0Var.e(ub, i5, i6);
        return ub;
    }

    public static o0<?, ?> M() {
        return f10051d;
    }

    public static void N(int i5, List<Boolean> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.A(i5, list, z5);
    }

    public static void O(int i5, List<AbstractC0488h> list, v0 v0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.N(i5, list);
    }

    public static void P(int i5, List<Double> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.K(i5, list, z5);
    }

    public static void Q(int i5, List<Integer> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.J(i5, list, z5);
    }

    public static void R(int i5, List<Integer> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.y(i5, list, z5);
    }

    public static void S(int i5, List<Long> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.u(i5, list, z5);
    }

    public static void T(int i5, List<Float> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.a(i5, list, z5);
    }

    public static void U(int i5, List<?> list, v0 v0Var, h0 h0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.l(i5, list, h0Var);
    }

    public static void V(int i5, List<Integer> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.o(i5, list, z5);
    }

    public static void W(int i5, List<Long> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.I(i5, list, z5);
    }

    public static void X(int i5, List<?> list, v0 v0Var, h0 h0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.j(i5, list, h0Var);
    }

    public static void Y(int i5, List<Integer> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.v(i5, list, z5);
    }

    public static void Z(int i5, List<Long> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.f(i5, list, z5);
    }

    static int a(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(size) : size * AbstractC0491k.d(i5, true);
    }

    public static void a0(int i5, List<Integer> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.G(i5, list, z5);
    }

    static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i5, List<Long> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.C(i5, list, z5);
    }

    static int c(int i5, List<AbstractC0488h> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = size * AbstractC0491k.V(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            iV += AbstractC0491k.h(list.get(i6));
        }
        return iV;
    }

    public static void c0(int i5, List<String> list, v0 v0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.k(i5, list);
    }

    static int d(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iE) : iE + (size * AbstractC0491k.V(i5));
    }

    public static void d0(int i5, List<Integer> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.B(i5, list, z5);
    }

    static int e(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0505z)) {
            int iL = 0;
            while (i5 < size) {
                iL += AbstractC0491k.l(list.get(i5).intValue());
                i5++;
            }
            return iL;
        }
        C0505z c0505z = (C0505z) list;
        int iL2 = 0;
        while (i5 < size) {
            iL2 += AbstractC0491k.l(c0505z.o(i5));
            i5++;
        }
        return iL2;
    }

    public static void e0(int i5, List<Long> list, v0 v0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.g(i5, list, z5);
    }

    static int f(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(size * 4) : size * AbstractC0491k.m(i5, 0);
    }

    static int g(List<?> list) {
        return list.size() * 4;
    }

    static int h(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(size * 8) : size * AbstractC0491k.o(i5, 0L);
    }

    static int i(List<?> list) {
        return list.size() * 8;
    }

    static int j(int i5, List<S> list, h0 h0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = 0;
        for (int i6 = 0; i6 < size; i6++) {
            iS += AbstractC0491k.s(i5, list.get(i6), h0Var);
        }
        return iS;
    }

    static int k(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iL) : iL + (size * AbstractC0491k.V(i5));
    }

    static int l(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0505z)) {
            int iW = 0;
            while (i5 < size) {
                iW += AbstractC0491k.w(list.get(i5).intValue());
                i5++;
            }
            return iW;
        }
        C0505z c0505z = (C0505z) list;
        int iW2 = 0;
        while (i5 < size) {
            iW2 += AbstractC0491k.w(c0505z.o(i5));
            i5++;
        }
        return iW2;
    }

    static int m(int i5, List<Long> list, boolean z5) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iN) : iN + (list.size() * AbstractC0491k.V(i5));
    }

    static int n(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof I)) {
            int iY = 0;
            while (i5 < size) {
                iY += AbstractC0491k.y(list.get(i5).longValue());
                i5++;
            }
            return iY;
        }
        I i6 = (I) list;
        int iY2 = 0;
        while (i5 < size) {
            iY2 += AbstractC0491k.y(i6.o(i5));
            i5++;
        }
        return iY2;
    }

    static int o(int i5, Object obj, h0 h0Var) {
        return obj instanceof E ? AbstractC0491k.A(i5, (E) obj) : AbstractC0491k.F(i5, (S) obj, h0Var);
    }

    static int p(int i5, List<?> list, h0 h0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = AbstractC0491k.V(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            iV += obj instanceof E ? AbstractC0491k.B((E) obj) : AbstractC0491k.H((S) obj, h0Var);
        }
        return iV;
    }

    static int q(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iR) : iR + (size * AbstractC0491k.V(i5));
    }

    static int r(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0505z)) {
            int iQ = 0;
            while (i5 < size) {
                iQ += AbstractC0491k.Q(list.get(i5).intValue());
                i5++;
            }
            return iQ;
        }
        C0505z c0505z = (C0505z) list;
        int iQ2 = 0;
        while (i5 < size) {
            iQ2 += AbstractC0491k.Q(c0505z.o(i5));
            i5++;
        }
        return iQ2;
    }

    static int s(int i5, List<Long> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iT) : iT + (size * AbstractC0491k.V(i5));
    }

    static int t(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof I)) {
            int iS = 0;
            while (i5 < size) {
                iS += AbstractC0491k.S(list.get(i5).longValue());
                i5++;
            }
            return iS;
        }
        I i6 = (I) list;
        int iS2 = 0;
        while (i5 < size) {
            iS2 += AbstractC0491k.S(i6.o(i5));
            i5++;
        }
        return iS2;
    }

    static int u(int i5, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int iV = AbstractC0491k.V(i5) * size;
        if (!(list instanceof G)) {
            while (i6 < size) {
                Object obj = list.get(i6);
                iV += obj instanceof AbstractC0488h ? AbstractC0491k.h((AbstractC0488h) obj) : AbstractC0491k.U((String) obj);
                i6++;
            }
            return iV;
        }
        G g5 = (G) list;
        while (i6 < size) {
            Object objK = g5.k(i6);
            iV += objK instanceof AbstractC0488h ? AbstractC0491k.h((AbstractC0488h) objK) : AbstractC0491k.U((String) objK);
            i6++;
        }
        return iV;
    }

    static int v(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iW) : iW + (size * AbstractC0491k.V(i5));
    }

    static int w(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0505z)) {
            int iX = 0;
            while (i5 < size) {
                iX += AbstractC0491k.X(list.get(i5).intValue());
                i5++;
            }
            return iX;
        }
        C0505z c0505z = (C0505z) list;
        int iX2 = 0;
        while (i5 < size) {
            iX2 += AbstractC0491k.X(c0505z.o(i5));
            i5++;
        }
        return iX2;
    }

    static int x(int i5, List<Long> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z5 ? AbstractC0491k.V(i5) + AbstractC0491k.C(iY) : iY + (size * AbstractC0491k.V(i5));
    }

    static int y(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof I)) {
            int iZ = 0;
            while (i5 < size) {
                iZ += AbstractC0491k.Z(list.get(i5).longValue());
                i5++;
            }
            return iZ;
        }
        I i6 = (I) list;
        int iZ2 = 0;
        while (i5 < size) {
            iZ2 += AbstractC0491k.Z(i6.o(i5));
            i5++;
        }
        return iZ2;
    }

    static <UT, UB> UB z(int i5, List<Integer> list, A.d<?> dVar, UB ub, o0<UT, UB> o0Var) {
        if (dVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (dVar.a(iIntValue) == null) {
                    ub = (UB) L(i5, iIntValue, ub, o0Var);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Integer num = list.get(i7);
            int iIntValue2 = num.intValue();
            if (dVar.a(iIntValue2) != null) {
                if (i7 != i6) {
                    list.set(i6, num);
                }
                i6++;
            } else {
                ub = (UB) L(i5, iIntValue2, ub, o0Var);
            }
        }
        if (i6 != size) {
            list.subList(i6, size).clear();
        }
        return ub;
    }
}
