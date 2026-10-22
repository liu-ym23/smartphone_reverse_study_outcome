package androidx.datastore.preferences.protobuf;

import d.C0527a;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f3492a;

    /* renamed from: b, reason: collision with root package name */
    public static final r0 f3493b;

    /* renamed from: c, reason: collision with root package name */
    public static final r0 f3494c;

    /* renamed from: d, reason: collision with root package name */
    public static final r0 f3495d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f3492a = cls;
        f3493b = A(false);
        f3494c = A(true);
        f3495d = new r0();
    }

    public static r0 A(boolean z4) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (r0) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z4));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void B(r0 r0Var, Object obj, Object obj2) {
        r0Var.getClass();
        A a4 = (A) obj;
        q0 q0Var = a4.unknownFields;
        q0 q0Var2 = ((A) obj2).unknownFields;
        if (!q0Var2.equals(q0.f3526f)) {
            int i4 = q0Var.f3527a + q0Var2.f3527a;
            int[] iArrCopyOf = Arrays.copyOf(q0Var.f3528b, i4);
            System.arraycopy(q0Var2.f3528b, 0, iArrCopyOf, q0Var.f3527a, q0Var2.f3527a);
            Object[] objArrCopyOf = Arrays.copyOf(q0Var.f3529c, i4);
            System.arraycopy(q0Var2.f3529c, 0, objArrCopyOf, q0Var.f3527a, q0Var2.f3527a);
            q0Var = new q0(i4, iArrCopyOf, objArrCopyOf, true);
        }
        a4.unknownFields = q0Var;
    }

    public static boolean C(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void D(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).J(i4, ((Boolean) list.get(i5)).booleanValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Boolean) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6++;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).I(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
            i5++;
        }
    }

    public static void E(int i4, List list, C0527a c0527a) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0527a.getClass();
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((AbstractC0268o) c0527a.f12410b).L(i4, (AbstractC0259h) list.get(i5));
        }
    }

    public static void F(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                AbstractC0268o abstractC0268o = (AbstractC0268o) c0527a.f12410b;
                double dDoubleValue = ((Double) list.get(i5)).doubleValue();
                abstractC0268o.getClass();
                abstractC0268o.P(i4, Double.doubleToRawLongBits(dDoubleValue));
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Double) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6 += 8;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            AbstractC0268o abstractC0268o2 = (AbstractC0268o) c0527a.f12410b;
            double dDoubleValue2 = ((Double) list.get(i5)).doubleValue();
            abstractC0268o2.getClass();
            abstractC0268o2.Q(Double.doubleToRawLongBits(dDoubleValue2));
            i5++;
        }
    }

    public static void G(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).R(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iU = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iU += AbstractC0268o.u(((Integer) list.get(i6)).intValue());
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iU);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).S(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public static void H(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).N(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Integer) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6 += 4;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).O(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public static void I(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).P(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Long) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6 += 8;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).Q(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public static void J(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                AbstractC0268o abstractC0268o = (AbstractC0268o) c0527a.f12410b;
                float fFloatValue = ((Float) list.get(i5)).floatValue();
                abstractC0268o.getClass();
                abstractC0268o.N(i4, Float.floatToRawIntBits(fFloatValue));
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Float) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6 += 4;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            AbstractC0268o abstractC0268o2 = (AbstractC0268o) c0527a.f12410b;
            float fFloatValue2 = ((Float) list.get(i5)).floatValue();
            abstractC0268o2.getClass();
            abstractC0268o2.O(Float.floatToRawIntBits(fFloatValue2));
            i5++;
        }
    }

    public static void K(int i4, List list, C0527a c0527a, InterfaceC0262i0 interfaceC0262i0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0527a.getClass();
        for (int i5 = 0; i5 < list.size(); i5++) {
            c0527a.x(i4, interfaceC0262i0, list.get(i5));
        }
    }

    public static void L(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).R(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iU = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iU += AbstractC0268o.u(((Integer) list.get(i6)).intValue());
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iU);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).S(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public static void M(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).a0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iG = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iG += AbstractC0268o.G(((Long) list.get(i6)).longValue());
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iG);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).b0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public static void N(int i4, List list, C0527a c0527a, InterfaceC0262i0 interfaceC0262i0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0527a.getClass();
        for (int i5 = 0; i5 < list.size(); i5++) {
            c0527a.A(i4, interfaceC0262i0, list.get(i5));
        }
    }

    public static void O(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).N(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Integer) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6 += 4;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).O(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public static void P(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).P(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Long) list.get(i7)).getClass();
            Logger logger = AbstractC0268o.f3518d;
            i6 += 8;
        }
        ((AbstractC0268o) c0527a.f12410b).Z(i6);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).Q(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public static void Q(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                AbstractC0268o abstractC0268o = (AbstractC0268o) c0527a.f12410b;
                int iIntValue = ((Integer) list.get(i5)).intValue();
                abstractC0268o.Y(i4, (iIntValue >> 31) ^ (iIntValue << 1));
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iE = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int iIntValue2 = ((Integer) list.get(i6)).intValue();
            iE += AbstractC0268o.E((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iE);
        while (i5 < list.size()) {
            AbstractC0268o abstractC0268o2 = (AbstractC0268o) c0527a.f12410b;
            int iIntValue3 = ((Integer) list.get(i5)).intValue();
            abstractC0268o2.Z((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i5++;
        }
    }

    public static void R(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                AbstractC0268o abstractC0268o = (AbstractC0268o) c0527a.f12410b;
                long jLongValue = ((Long) list.get(i5)).longValue();
                abstractC0268o.a0(i4, (jLongValue >> 63) ^ (jLongValue << 1));
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iG = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            long jLongValue2 = ((Long) list.get(i6)).longValue();
            iG += AbstractC0268o.G((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iG);
        while (i5 < list.size()) {
            AbstractC0268o abstractC0268o2 = (AbstractC0268o) c0527a.f12410b;
            long jLongValue3 = ((Long) list.get(i5)).longValue();
            abstractC0268o2.b0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i5++;
        }
    }

    public static void S(int i4, List list, C0527a c0527a) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0527a.getClass();
        int i5 = 0;
        if (!(list instanceof I)) {
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).V(i4, (String) list.get(i5));
                i5++;
            }
            return;
        }
        I i6 = (I) list;
        while (i5 < list.size()) {
            Object objM = i6.m(i5);
            if (objM instanceof String) {
                ((AbstractC0268o) c0527a.f12410b).V(i4, (String) objM);
            } else {
                ((AbstractC0268o) c0527a.f12410b).L(i4, (AbstractC0259h) objM);
            }
            i5++;
        }
    }

    public static void T(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).Y(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iE = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iE += AbstractC0268o.E(((Integer) list.get(i6)).intValue());
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iE);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).Z(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public static void U(int i4, List list, C0527a c0527a, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        if (!z4) {
            c0527a.getClass();
            while (i5 < list.size()) {
                ((AbstractC0268o) c0527a.f12410b).a0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
        int iG = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iG += AbstractC0268o.G(((Long) list.get(i6)).longValue());
        }
        ((AbstractC0268o) c0527a.f12410b).Z(iG);
        while (i5 < list.size()) {
            ((AbstractC0268o) c0527a.f12410b).b0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public static int a(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return AbstractC0268o.k(i4) * size;
    }

    public static int b(List list) {
        return list.size();
    }

    public static int c(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC = AbstractC0268o.C(i4) * size;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iC += AbstractC0268o.m((AbstractC0259h) list.get(i5));
        }
        return iC;
    }

    public static int d(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * size) + e(list);
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof B) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iU = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iU += AbstractC0268o.u(((Integer) list.get(i4)).intValue());
        }
        return iU;
    }

    public static int f(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return AbstractC0268o.p(i4) * size;
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return AbstractC0268o.q(i4) * size;
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i4, List list, InterfaceC0262i0 interfaceC0262i0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = 0;
        for (int i5 = 0; i5 < size; i5++) {
            iS += AbstractC0268o.s(i4, (AbstractC0247b) list.get(i5), interfaceC0262i0);
        }
        return iS;
    }

    public static int k(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * size) + l(list);
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof B) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iU = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iU += AbstractC0268o.u(((Integer) list.get(i4)).intValue());
        }
        return iU;
    }

    public static int m(int i4, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * list.size()) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof M) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iG = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iG += AbstractC0268o.G(((Long) list.get(i4)).longValue());
        }
        return iG;
    }

    public static int o(int i4, InterfaceC0262i0 interfaceC0262i0, Object obj) {
        int iC = AbstractC0268o.C(i4);
        int iB = ((AbstractC0247b) obj).b(interfaceC0262i0);
        return AbstractC0268o.E(iB) + iB + iC;
    }

    public static int p(int i4, List list, InterfaceC0262i0 interfaceC0262i0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC = AbstractC0268o.C(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            int iB = ((AbstractC0247b) list.get(i5)).b(interfaceC0262i0);
            iC += AbstractC0268o.E(iB) + iB;
        }
        return iC;
    }

    public static int q(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * size) + r(list);
    }

    public static int r(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof B) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iE = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int iIntValue = ((Integer) list.get(i4)).intValue();
            iE += AbstractC0268o.E((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iE;
    }

    public static int s(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * size) + t(list);
    }

    public static int t(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof M) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iG = 0;
        for (int i4 = 0; i4 < size; i4++) {
            long jLongValue = ((Long) list.get(i4)).longValue();
            iG += AbstractC0268o.G((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iG;
    }

    public static int u(int i4, List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int iC = AbstractC0268o.C(i4) * size;
        if (list instanceof I) {
            I i6 = (I) list;
            while (i5 < size) {
                Object objM = i6.m(i5);
                iC = (objM instanceof AbstractC0259h ? AbstractC0268o.m((AbstractC0259h) objM) : AbstractC0268o.B((String) objM)) + iC;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                iC = (obj instanceof AbstractC0259h ? AbstractC0268o.m((AbstractC0259h) obj) : AbstractC0268o.B((String) obj)) + iC;
                i5++;
            }
        }
        return iC;
    }

    public static int v(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * size) + w(list);
    }

    public static int w(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof B) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iE = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iE += AbstractC0268o.E(((Integer) list.get(i4)).intValue());
        }
        return iE;
    }

    public static int x(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0268o.C(i4) * size) + y(list);
    }

    public static int y(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof M) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iG = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iG += AbstractC0268o.G(((Long) list.get(i4)).longValue());
        }
        return iG;
    }

    public static Object z(int i4, List list, Object obj, r0 r0Var) {
        return obj;
    }
}
