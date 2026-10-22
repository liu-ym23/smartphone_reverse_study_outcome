package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f795a;

    /* renamed from: b, reason: collision with root package name */
    public static final k1 f796b;

    /* renamed from: c, reason: collision with root package name */
    public static final k1 f797c;

    /* renamed from: d, reason: collision with root package name */
    public static final k1 f798d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f795a = cls;
        f796b = w(false);
        f797c = w(true);
        f798d = new k1();
    }

    public static void A(int i2, List list, i0 i0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        i0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((m) i0Var.f880a).A(i2, (g) list.get(i10));
        }
    }

    public static void B(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                double dDoubleValue = ((Double) list.get(i10)).doubleValue();
                mVar.getClass();
                mVar.E(i2, Double.doubleToRawLongBits(dDoubleValue));
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11 += 8;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.F(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void C(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.G(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iQ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iQ += m.q(((Integer) list.get(i11)).intValue());
        }
        mVar.N(iQ);
        while (i10 < list.size()) {
            mVar.H(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void D(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.C(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11 += 4;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.D(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void E(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.E(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11 += 8;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.F(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void F(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                float fFloatValue = ((Float) list.get(i10)).floatValue();
                mVar.getClass();
                mVar.C(i2, Float.floatToRawIntBits(fFloatValue));
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11 += 4;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.D(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void G(int i2, List list, i0 i0Var, z0 z0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        i0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            i0Var.b(i2, list.get(i10), z0Var);
        }
    }

    public static void H(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.G(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iQ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iQ += m.q(((Integer) list.get(i11)).intValue());
        }
        mVar.N(iQ);
        while (i10 < list.size()) {
            mVar.H(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void I(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.O(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iU = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iU += m.u(((Long) list.get(i11)).longValue());
        }
        mVar.N(iU);
        while (i10 < list.size()) {
            mVar.P(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void J(int i2, List list, i0 i0Var, z0 z0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        i0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((m) i0Var.f880a).I(i2, (a) list.get(i10), z0Var);
        }
    }

    public static void K(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.C(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11 += 4;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.D(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void L(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.E(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11 += 8;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.F(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void M(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                mVar.M(i2, (iIntValue >> 31) ^ (iIntValue << 1));
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iT = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue2 = ((Integer) list.get(i11)).intValue();
            iT += m.t((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        mVar.N(iT);
        while (i10 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i10)).intValue();
            mVar.N((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i10++;
        }
    }

    public static void N(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                mVar.O(i2, (jLongValue >> 63) ^ (jLongValue << 1));
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iU = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            long jLongValue2 = ((Long) list.get(i11)).longValue();
            iU += m.u((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        mVar.N(iU);
        while (i10 < list.size()) {
            long jLongValue3 = ((Long) list.get(i10)).longValue();
            mVar.P((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i10++;
        }
    }

    public static void O(int i2, List list, i0 i0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!(list instanceof d0)) {
            while (i10 < list.size()) {
                mVar.J(i2, (String) list.get(i10));
                i10++;
            }
            return;
        }
        d0 d0Var = (d0) list;
        while (i10 < list.size()) {
            Object raw = d0Var.getRaw(i10);
            if (raw instanceof String) {
                mVar.J(i2, (String) raw);
            } else {
                mVar.A(i2, (g) raw);
            }
            i10++;
        }
    }

    public static void P(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.M(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iT = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iT += m.t(((Integer) list.get(i11)).intValue());
        }
        mVar.N(iT);
        while (i10 < list.size()) {
            mVar.N(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void Q(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.O(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int iU = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iU += m.u(((Long) list.get(i11)).longValue());
        }
        mVar.N(iU);
        while (i10 < list.size()) {
            mVar.P(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static int a(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = m.s(i2) * size;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS += m.m((g) list.get(i10));
        }
        return iS;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.s(i2) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iQ += m.q(((Integer) list.get(i2)).intValue());
        }
        return iQ;
    }

    public static int d(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m.n(i2) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m.o(i2) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.s(i2) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iQ += m.q(((Integer) list.get(i2)).intValue());
        }
        return iQ;
    }

    public static int j(int i2, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (m.s(i2) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iU += m.u(((Long) list.get(i2)).longValue());
        }
        return iU;
    }

    public static int l(int i2, List list, z0 z0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = m.s(i2) * size;
        for (int i10 = 0; i10 < size; i10++) {
            int iA = ((a) list.get(i10)).a(z0Var);
            iS += m.t(iA) + iA;
        }
        return iS;
    }

    public static int m(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.s(i2) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int iIntValue = ((Integer) list.get(i2)).intValue();
            iT += m.t((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iT;
    }

    public static int o(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.s(i2) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i2 = 0; i2 < size; i2++) {
            long jLongValue = ((Long) list.get(i2)).longValue();
            iU += m.u((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iU;
    }

    public static int q(int i2, List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        int iS = m.s(i2) * size;
        if (!(list instanceof d0)) {
            while (i10 < size) {
                Object obj = list.get(i10);
                if (obj instanceof g) {
                    int size2 = ((g) obj).size();
                    iS = m.t(size2) + size2 + iS;
                } else {
                    iS = m.r((String) obj) + iS;
                }
                i10++;
            }
            return iS;
        }
        d0 d0Var = (d0) list;
        while (i10 < size) {
            Object raw = d0Var.getRaw(i10);
            if (raw instanceof g) {
                int size3 = ((g) raw).size();
                iS = m.t(size3) + size3 + iS;
            } else {
                iS = m.r((String) raw) + iS;
            }
            i10++;
        }
        return iS;
    }

    public static int r(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.s(i2) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iT += m.t(((Integer) list.get(i2)).intValue());
        }
        return iT;
    }

    public static int t(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.s(i2) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iU += m.u(((Long) list.get(i2)).longValue());
        }
        return iU;
    }

    public static Object v(Object obj, int i2, List list, Object obj2, k1 k1Var) {
        return obj2;
    }

    public static k1 w(boolean z4) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (k1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z4));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static void x(k1 k1Var, Object obj, Object obj2) {
        k1Var.getClass();
        w wVar = (w) obj;
        j1 j1Var = wVar.unknownFields;
        j1 j1Var2 = ((w) obj2).unknownFields;
        j1 j1Var3 = j1.f886f;
        if (!j1Var3.equals(j1Var2)) {
            if (j1Var3.equals(j1Var)) {
                int i2 = j1Var.f887a + j1Var2.f887a;
                int[] iArrCopyOf = Arrays.copyOf(j1Var.f888b, i2);
                System.arraycopy(j1Var2.f888b, 0, iArrCopyOf, j1Var.f887a, j1Var2.f887a);
                Object[] objArrCopyOf = Arrays.copyOf(j1Var.f889c, i2);
                System.arraycopy(j1Var2.f889c, 0, objArrCopyOf, j1Var.f887a, j1Var2.f887a);
                j1Var = new j1(i2, iArrCopyOf, objArrCopyOf, true);
            } else {
                j1Var.getClass();
                if (!j1Var2.equals(j1Var3)) {
                    if (!j1Var.f891e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = j1Var.f887a + j1Var2.f887a;
                    j1Var.a(i10);
                    System.arraycopy(j1Var2.f888b, 0, j1Var.f888b, j1Var.f887a, j1Var2.f887a);
                    System.arraycopy(j1Var2.f889c, 0, j1Var.f889c, j1Var.f887a, j1Var2.f887a);
                    j1Var.f887a = i10;
                }
            }
        }
        wVar.unknownFields = j1Var;
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void z(int i2, List list, i0 i0Var, boolean z4) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) i0Var.f880a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                mVar.z(i2, ((Boolean) list.get(i10)).booleanValue());
                i10++;
            }
            return;
        }
        mVar.L(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            Logger logger = m.f901h;
            i11++;
        }
        mVar.N(i11);
        while (i10 < list.size()) {
            mVar.x(((Boolean) list.get(i10)).booleanValue() ? (byte) 1 : (byte) 0);
            i10++;
        }
    }
}
