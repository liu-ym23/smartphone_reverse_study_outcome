package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f1899a;

    /* renamed from: b, reason: collision with root package name */
    public static final c1<?, ?> f1900b;

    /* renamed from: c, reason: collision with root package name */
    public static final c1<?, ?> f1901c;

    /* renamed from: d, reason: collision with root package name */
    public static final e1 f1902d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f1899a = cls;
        f1900b = x(false);
        f1901c = x(true);
        f1902d = new e1();
    }

    public static <UT, UB> UB A(int i10, int i11, UB ub2, c1<UT, UB> c1Var) {
        if (ub2 == null) {
            ub2 = (UB) c1Var.m();
        }
        c1Var.e(i11, i10, ub2);
        return ub2;
    }

    public static void B(int i10, List<Boolean> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.y(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12++;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.x(list.get(i11).booleanValue() ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    public static void C(int i10, List<ByteString> list, h1 h1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j jVar = (j) h1Var;
        jVar.getClass();
        for (int i11 = 0; i11 < list.size(); i11++) {
            jVar.f1844a.A(i10, list.get(i11));
        }
    }

    public static void D(int i10, List<Double> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                double dDoubleValue = list.get(i11).doubleValue();
                codedOutputStream.getClass();
                codedOutputStream.E(i10, Double.doubleToRawLongBits(dDoubleValue));
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12 += 8;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.F(Double.doubleToRawLongBits(list.get(i11).doubleValue()));
            i11++;
        }
    }

    public static void E(int i10, List<Integer> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.G(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iP = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iP += CodedOutputStream.p(list.get(i12).intValue());
        }
        codedOutputStream.Q(iP);
        while (i11 < list.size()) {
            codedOutputStream.H(list.get(i11).intValue());
            i11++;
        }
    }

    public static void F(int i10, List<Integer> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.C(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12 += 4;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.D(list.get(i11).intValue());
            i11++;
        }
    }

    public static void G(int i10, List<Long> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.E(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12 += 8;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.F(list.get(i11).longValue());
            i11++;
        }
    }

    public static void H(int i10, List<Float> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                float fFloatValue = list.get(i11).floatValue();
                codedOutputStream.getClass();
                codedOutputStream.C(i10, Float.floatToRawIntBits(fFloatValue));
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12 += 4;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.D(Float.floatToRawIntBits(list.get(i11).floatValue()));
            i11++;
        }
    }

    public static void I(int i10, List<?> list, h1 h1Var, w0 w0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j jVar = (j) h1Var;
        jVar.getClass();
        for (int i11 = 0; i11 < list.size(); i11++) {
            jVar.b(i10, list.get(i11), w0Var);
        }
    }

    public static void J(int i10, List<Integer> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.G(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iP = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iP += CodedOutputStream.p(list.get(i12).intValue());
        }
        codedOutputStream.Q(iP);
        while (i11 < list.size()) {
            codedOutputStream.H(list.get(i11).intValue());
            i11++;
        }
    }

    public static void K(int i10, List<Long> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.R(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iV = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iV += CodedOutputStream.v(list.get(i12).longValue());
        }
        codedOutputStream.Q(iV);
        while (i11 < list.size()) {
            codedOutputStream.S(list.get(i11).longValue());
            i11++;
        }
    }

    public static void L(int i10, List<?> list, h1 h1Var, w0 w0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j jVar = (j) h1Var;
        jVar.getClass();
        for (int i11 = 0; i11 < list.size(); i11++) {
            jVar.f1844a.I(i10, (i0) list.get(i11), w0Var);
        }
    }

    public static void M(int i10, List<Integer> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.C(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12 += 4;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.D(list.get(i11).intValue());
            i11++;
        }
    }

    public static void N(int i10, List<Long> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.E(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).getClass();
            Logger logger = CodedOutputStream.f1721c;
            i12 += 8;
        }
        codedOutputStream.Q(i12);
        while (i11 < list.size()) {
            codedOutputStream.F(list.get(i11).longValue());
            i11++;
        }
    }

    public static void O(int i10, List<Integer> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                int iIntValue = list.get(i11).intValue();
                codedOutputStream.P(i10, (iIntValue >> 31) ^ (iIntValue << 1));
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iU = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            int iIntValue2 = list.get(i12).intValue();
            iU += CodedOutputStream.u((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        codedOutputStream.Q(iU);
        while (i11 < list.size()) {
            int iIntValue3 = list.get(i11).intValue();
            codedOutputStream.Q((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i11++;
        }
    }

    public static void P(int i10, List<Long> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                long jLongValue = list.get(i11).longValue();
                codedOutputStream.R(i10, (jLongValue >> 63) ^ (jLongValue << 1));
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iV = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            long jLongValue2 = list.get(i12).longValue();
            iV += CodedOutputStream.v((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        codedOutputStream.Q(iV);
        while (i11 < list.size()) {
            long jLongValue3 = list.get(i11).longValue();
            codedOutputStream.S((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i11++;
        }
    }

    public static void Q(int i10, List<String> list, h1 h1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!(list instanceof y)) {
            while (i11 < list.size()) {
                codedOutputStream.M(i10, list.get(i11));
                i11++;
            }
            return;
        }
        y yVar = (y) list;
        while (i11 < list.size()) {
            Object objC0 = yVar.C0(i11);
            if (objC0 instanceof String) {
                codedOutputStream.M(i10, (String) objC0);
            } else {
                codedOutputStream.A(i10, (ByteString) objC0);
            }
            i11++;
        }
    }

    public static void R(int i10, List<Integer> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.P(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iU = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iU += CodedOutputStream.u(list.get(i12).intValue());
        }
        codedOutputStream.Q(iU);
        while (i11 < list.size()) {
            codedOutputStream.Q(list.get(i11).intValue());
            i11++;
        }
    }

    public static void S(int i10, List<Long> list, h1 h1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
        int i11 = 0;
        if (!z) {
            while (i11 < list.size()) {
                codedOutputStream.R(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.O(i10, 2);
        int iV = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iV += CodedOutputStream.v(list.get(i12).longValue());
        }
        codedOutputStream.Q(iV);
        while (i11 < list.size()) {
            codedOutputStream.S(list.get(i11).longValue());
            i11++;
        }
    }

    public static int a(int i10, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = CodedOutputStream.s(i10) * size;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iS += CodedOutputStream.l(list.get(i11));
        }
        return iS;
    }

    public static int b(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * size) + c(list);
    }

    public static int c(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof t)) {
            int iP = 0;
            while (i10 < size) {
                iP += CodedOutputStream.p(list.get(i10).intValue());
                i10++;
            }
            return iP;
        }
        t tVar = (t) list;
        int iP2 = 0;
        while (i10 < size) {
            tVar.c(i10);
            iP2 += CodedOutputStream.p(tVar.f1883b[i10]);
            i10++;
        }
        return iP2;
    }

    public static int d(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.m(i10) * size;
    }

    public static int e(List<?> list) {
        return list.size() * 4;
    }

    public static int f(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.n(i10) * size;
    }

    public static int g(List<?> list) {
        return list.size() * 8;
    }

    public static int h(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * size) + i(list);
    }

    public static int i(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof t)) {
            int iP = 0;
            while (i10 < size) {
                iP += CodedOutputStream.p(list.get(i10).intValue());
                i10++;
            }
            return iP;
        }
        t tVar = (t) list;
        int iP2 = 0;
        while (i10 < size) {
            tVar.c(i10);
            iP2 += CodedOutputStream.p(tVar.f1883b[i10]);
            i10++;
        }
        return iP2;
    }

    public static int j(int i10, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * list.size()) + k(list);
    }

    public static int k(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a0)) {
            int iV = 0;
            while (i10 < size) {
                iV += CodedOutputStream.v(list.get(i10).longValue());
                i10++;
            }
            return iV;
        }
        a0 a0Var = (a0) list;
        int iV2 = 0;
        while (i10 < size) {
            a0Var.c(i10);
            iV2 += CodedOutputStream.v(a0Var.f1781b[i10]);
            i10++;
        }
        return iV2;
    }

    public static int l(int i10, Object obj, w0 w0Var) {
        if (obj instanceof w) {
            return CodedOutputStream.q((w) obj) + CodedOutputStream.s(i10);
        }
        int iS = CodedOutputStream.s(i10);
        int iG = ((a) ((i0) obj)).g(w0Var);
        return CodedOutputStream.u(iG) + iG + iS;
    }

    public static int m(int i10, List<?> list, w0 w0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = CodedOutputStream.s(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof w) {
                iS = CodedOutputStream.q((w) obj) + iS;
            } else {
                int iG = ((a) ((i0) obj)).g(w0Var);
                iS = CodedOutputStream.u(iG) + iG + iS;
            }
        }
        return iS;
    }

    public static int n(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * size) + o(list);
    }

    public static int o(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof t)) {
            int iU = 0;
            while (i10 < size) {
                int iIntValue = list.get(i10).intValue();
                iU += CodedOutputStream.u((iIntValue >> 31) ^ (iIntValue << 1));
                i10++;
            }
            return iU;
        }
        t tVar = (t) list;
        int iU2 = 0;
        while (i10 < size) {
            tVar.c(i10);
            int i11 = tVar.f1883b[i10];
            iU2 += CodedOutputStream.u((i11 >> 31) ^ (i11 << 1));
            i10++;
        }
        return iU2;
    }

    public static int p(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * size) + q(list);
    }

    public static int q(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a0)) {
            int iV = 0;
            while (i10 < size) {
                long jLongValue = list.get(i10).longValue();
                iV += CodedOutputStream.v((jLongValue >> 63) ^ (jLongValue << 1));
                i10++;
            }
            return iV;
        }
        a0 a0Var = (a0) list;
        int iV2 = 0;
        while (i10 < size) {
            a0Var.c(i10);
            long j10 = a0Var.f1781b[i10];
            iV2 += CodedOutputStream.v((j10 >> 63) ^ (j10 << 1));
            i10++;
        }
        return iV2;
    }

    public static int r(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iS = CodedOutputStream.s(i10) * size;
        if (!(list instanceof y)) {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof ByteString) {
                    int size2 = ((ByteString) obj).size();
                    iS = CodedOutputStream.u(size2) + size2 + iS;
                } else {
                    iS = CodedOutputStream.r((String) obj) + iS;
                }
                i11++;
            }
            return iS;
        }
        y yVar = (y) list;
        while (i11 < size) {
            Object objC0 = yVar.C0(i11);
            if (objC0 instanceof ByteString) {
                int size3 = ((ByteString) objC0).size();
                iS = CodedOutputStream.u(size3) + size3 + iS;
            } else {
                iS = CodedOutputStream.r((String) objC0) + iS;
            }
            i11++;
        }
        return iS;
    }

    public static int s(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * size) + t(list);
    }

    public static int t(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof t)) {
            int iU = 0;
            while (i10 < size) {
                iU += CodedOutputStream.u(list.get(i10).intValue());
                i10++;
            }
            return iU;
        }
        t tVar = (t) list;
        int iU2 = 0;
        while (i10 < size) {
            tVar.c(i10);
            iU2 += CodedOutputStream.u(tVar.f1883b[i10]);
            i10++;
        }
        return iU2;
    }

    public static int u(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.s(i10) * size) + v(list);
    }

    public static int v(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a0)) {
            int iV = 0;
            while (i10 < size) {
                iV += CodedOutputStream.v(list.get(i10).longValue());
                i10++;
            }
            return iV;
        }
        a0 a0Var = (a0) list;
        int iV2 = 0;
        while (i10 < size) {
            a0Var.c(i10);
            iV2 += CodedOutputStream.v(a0Var.f1781b[i10]);
            i10++;
        }
        return iV2;
    }

    public static <UT, UB> UB w(int i10, List<Integer> list, u.b bVar, UB ub2, c1<UT, UB> c1Var) {
        if (bVar == null) {
            return ub2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (!bVar.a()) {
                    ub2 = (UB) A(i10, iIntValue, ub2, c1Var);
                    it.remove();
                }
            }
            return ub2;
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer num = list.get(i12);
            int iIntValue2 = num.intValue();
            if (bVar.a()) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                ub2 = (UB) A(i10, iIntValue2, ub2, c1Var);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return ub2;
    }

    public static c1<?, ?> x(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (c1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static <T, FT extends q.a<FT>> void y(n<FT> nVar, T t8, T t10) {
        q<T> qVarC = nVar.c(t10);
        if (qVarC.f1876a.isEmpty()) {
            return;
        }
        q<T> qVarD = nVar.d(t8);
        qVarD.getClass();
        y0 y0Var = qVarC.f1876a;
        if (y0Var.f1908b.size() > 0) {
            qVarD.h(y0Var.c(0));
            throw null;
        }
        Iterator<Map.Entry<Object, Object>> it = y0Var.e().iterator();
        if (it.hasNext()) {
            qVarD.h(it.next());
            throw null;
        }
    }

    public static boolean z(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
