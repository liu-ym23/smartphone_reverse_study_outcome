package com.google.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* renamed from: com.google.protobuf.q2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0983q2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2936a = GeneratedMessageV3.class;
    public static final H2 b;
    public static final O2 c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        H2 h22 = null;
        if (P2.class != 0) {
            try {
                h22 = (H2) P2.class.getConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
        }
        b = h22;
        c = new O2();
    }

    public static void A(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                long jLongValue = ((Long) list.get(i6)).longValue();
                c0980q.m0(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int iT = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            long jLongValue2 = ((Long) list.get(i10)).longValue();
            iT += C0980q.T((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        c0980q.l0(iT);
        while (i6 < list.size()) {
            long jLongValue3 = ((Long) list.get(i6)).longValue();
            c0980q.n0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i6++;
        }
    }

    public static void B(int i, List list, F1 f12) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!(list instanceof InterfaceC1009x1)) {
            while (i6 < list.size()) {
                String str = (String) list.get(i6);
                c0980q.k0(i, 2);
                c0980q.j0(str);
                i6++;
            }
            return;
        }
        InterfaceC1009x1 interfaceC1009x1 = (InterfaceC1009x1) list;
        while (i6 < list.size()) {
            Object raw = interfaceC1009x1.getRaw(i6);
            if (raw instanceof String) {
                c0980q.k0(i, 2);
                c0980q.j0((String) raw);
            } else {
                c0980q.X(i, (ByteString) raw);
            }
            i6++;
        }
    }

    public static void C(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        if (!z10) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                int iIntValue = ((Integer) list.get(i6)).intValue();
                c0980q.k0(i, 0);
                c0980q.l0(iIntValue);
            }
            return;
        }
        c0980q.k0(i, 2);
        int iS = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS += C0980q.S(((Integer) list.get(i10)).intValue());
        }
        c0980q.l0(iS);
        for (int i11 = 0; i11 < list.size(); i11++) {
            c0980q.l0(((Integer) list.get(i11)).intValue());
        }
    }

    public static void D(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.m0(i, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int iT = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iT += C0980q.T(((Long) list.get(i10)).longValue());
        }
        c0980q.l0(iT);
        while (i6 < list.size()) {
            c0980q.n0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static int a(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0970n1)) {
            int iO = 0;
            while (i < size) {
                iO += C0980q.O(((Integer) list.get(i)).intValue());
                i++;
            }
            return iO;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int iO2 = 0;
        while (i < size) {
            iO2 += C0980q.O(c0970n1.getInt(i));
            i++;
        }
        return iO2;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0980q.R(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0980q.R(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0970n1)) {
            int iO = 0;
            while (i < size) {
                iO += C0980q.O(((Integer) list.get(i)).intValue());
                i++;
            }
            return iO;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int iO2 = 0;
        while (i < size) {
            iO2 += C0980q.O(c0970n1.getInt(i));
            i++;
        }
        return iO2;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof D1) {
            D1 d12 = (D1) list;
            if (size <= 0) {
                return 0;
            }
            d12.c(0);
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            iT += C0980q.T(((Long) list.get(i)).longValue());
        }
        return iT;
    }

    public static int f(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0970n1)) {
            int iS = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iS += C0980q.S((iIntValue >> 31) ^ (iIntValue << 1));
                i++;
            }
            return iS;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int iS2 = 0;
        while (i < size) {
            int i6 = c0970n1.getInt(i);
            iS2 += C0980q.S((i6 >> 31) ^ (i6 << 1));
            i++;
        }
        return iS2;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof D1) {
            D1 d12 = (D1) list;
            if (size <= 0) {
                return 0;
            }
            d12.c(0);
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iT += C0980q.T((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iT;
    }

    public static int h(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0970n1)) {
            int iS = 0;
            while (i < size) {
                iS += C0980q.S(((Integer) list.get(i)).intValue());
                i++;
            }
            return iS;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int iS2 = 0;
        while (i < size) {
            iS2 += C0980q.S(c0970n1.getInt(i));
            i++;
        }
        return iS2;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof D1) {
            D1 d12 = (D1) list;
            if (size <= 0) {
                return 0;
            }
            d12.c(0);
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            iT += C0980q.T(((Long) list.get(i)).longValue());
        }
        return iT;
    }

    public static Object j(Object obj, int i, List list, InterfaceC0978p1 interfaceC0978p1, Object obj2, H2 h22) {
        if (interfaceC0978p1 == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!interfaceC0978p1.isInRange(iIntValue)) {
                    obj2 = n(obj, i, iIntValue, obj2, h22);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Integer num = (Integer) list.get(i10);
            int iIntValue2 = num.intValue();
            if (interfaceC0978p1.isInRange(iIntValue2)) {
                if (i10 != i6) {
                    list.set(i6, num);
                }
                i6++;
            } else {
                obj2 = n(obj, i, iIntValue2, obj2, h22);
            }
        }
        if (i6 != size) {
            list.subList(i6, size).clear();
        }
        return obj2;
    }

    public static void k(S0 s0, Object obj, Object obj2) {
        C0990s2 c0990s2;
        Y0 y0C = s0.c(obj2);
        if (y0C.f2903a.isEmpty()) {
            return;
        }
        Y0 y0D = s0.d(obj);
        y0D.getClass();
        int i = 0;
        while (true) {
            c0990s2 = y0C.f2903a;
            if (i >= c0990s2.b.size()) {
                break;
            }
            y0D.r(c0990s2.d(i));
            i++;
        }
        Iterator it = c0990s2.e().iterator();
        while (it.hasNext()) {
            y0D.r((Map.Entry) it.next());
        }
    }

    public static void l(H2 h22, Object obj, Object obj2) {
        ((O2) h22).getClass();
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        N2 n22 = generatedMessageLite.unknownFields;
        N2 n23 = ((GeneratedMessageLite) obj2).unknownFields;
        N2 n24 = N2.f;
        if (!n24.equals(n23)) {
            if (n24.equals(n22)) {
                int i = n22.f2861a + n23.f2861a;
                int[] iArrCopyOf = Arrays.copyOf(n22.b, i);
                System.arraycopy(n23.b, 0, iArrCopyOf, n22.f2861a, n23.f2861a);
                Object[] objArrCopyOf = Arrays.copyOf(n22.c, i);
                System.arraycopy(n23.c, 0, objArrCopyOf, n22.f2861a, n23.f2861a);
                n22 = new N2(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                n22.getClass();
                if (!n23.equals(n24)) {
                    if (!n22.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i6 = n22.f2861a + n23.f2861a;
                    n22.a(i6);
                    System.arraycopy(n23.b, 0, n22.b, n22.f2861a, n23.f2861a);
                    System.arraycopy(n23.c, 0, n22.c, n22.f2861a, n23.f2861a);
                    n22.f2861a = i6;
                }
            }
        }
        generatedMessageLite.unknownFields = n22;
    }

    public static boolean m(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object n(Object obj, int i, int i6, Object obj2, H2 h22) {
        if (obj2 == null) {
            obj2 = h22.a(obj);
        }
        ((O2) h22).getClass();
        ((N2) obj2).d(i << 3, Long.valueOf(i6));
        return obj2;
    }

    public static void o(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.W(i, ((Boolean) list.get(i6)).booleanValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10++;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.U(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    public static void p(int i, List list, F1 f12) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        f12.getClass();
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((C0980q) f12.b).X(i, (ByteString) list.get(i6));
        }
    }

    public static void q(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                double dDoubleValue = ((Double) list.get(i6)).doubleValue();
                c0980q.getClass();
                c0980q.a0(i, Double.doubleToRawLongBits(dDoubleValue));
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10 += 8;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.b0(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
            i6++;
        }
    }

    public static void r(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.d0(i, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int iO = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iO += C0980q.O(((Integer) list.get(i10)).intValue());
        }
        c0980q.l0(iO);
        while (i6 < list.size()) {
            c0980q.e0(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    public static void s(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.Y(i, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10 += 4;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.Z(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    public static void t(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.a0(i, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10 += 8;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.b0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static void u(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                float fFloatValue = ((Float) list.get(i6)).floatValue();
                c0980q.getClass();
                c0980q.Y(i, Float.floatToRawIntBits(fFloatValue));
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10 += 4;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.Z(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
            i6++;
        }
    }

    public static void v(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.d0(i, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int iO = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iO += C0980q.O(((Integer) list.get(i10)).intValue());
        }
        c0980q.l0(iO);
        while (i6 < list.size()) {
            c0980q.e0(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    public static void w(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.m0(i, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int iT = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iT += C0980q.T(((Long) list.get(i10)).longValue());
        }
        c0980q.l0(iT);
        while (i6 < list.size()) {
            c0980q.n0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static void x(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.Y(i, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10 += 4;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.Z(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    public static void y(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        int i6 = 0;
        if (!z10) {
            while (i6 < list.size()) {
                c0980q.a0(i, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        c0980q.k0(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = C0980q.g;
            i10 += 8;
        }
        c0980q.l0(i10);
        while (i6 < list.size()) {
            c0980q.b0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static void z(int i, List list, F1 f12, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C0980q c0980q = (C0980q) f12.b;
        if (!z10) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                int iIntValue = ((Integer) list.get(i6)).intValue();
                c0980q.k0(i, 0);
                c0980q.l0((iIntValue >> 31) ^ (iIntValue << 1));
            }
            return;
        }
        c0980q.k0(i, 2);
        int iS = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            int iIntValue2 = ((Integer) list.get(i10)).intValue();
            iS += C0980q.S((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        c0980q.l0(iS);
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue3 = ((Integer) list.get(i11)).intValue();
            c0980q.l0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
        }
    }
}
