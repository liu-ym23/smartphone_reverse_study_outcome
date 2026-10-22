package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f1437a;

    /* renamed from: b, reason: collision with root package name */
    public static final f1 f1438b;

    /* renamed from: c, reason: collision with root package name */
    public static final f1 f1439c;
    public static final f1 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f1437a = cls;
        f1438b = v(false);
        f1439c = v(true);
        d = new f1();
    }

    public static void A(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                double dDoubleValue = ((Double) list.get(i9)).doubleValue();
                lVar.getClass();
                lVar.g0(i8, Double.doubleToRawLongBits(dDoubleValue));
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10 += 8;
        }
        lVar.k0(i10);
        while (i9 < list.size()) {
            lVar.h0(Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
            i9++;
        }
    }

    public static void B(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        if (!z) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                lVar.j0(i8, 0);
                lVar.i0(iIntValue);
            }
            return;
        }
        lVar.j0(i8, 2);
        int iX = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iX += l.X(((Integer) list.get(i10)).intValue());
        }
        lVar.k0(iX);
        for (int i11 = 0; i11 < list.size(); i11++) {
            lVar.i0(((Integer) list.get(i11)).intValue());
        }
    }

    public static void C(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.e0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10 += 4;
        }
        lVar.k0(i10);
        while (i9 < list.size()) {
            lVar.f0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void D(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.g0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10 += 8;
        }
        lVar.k0(i10);
        while (i9 < list.size()) {
            lVar.h0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void E(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                float fFloatValue = ((Float) list.get(i9)).floatValue();
                lVar.getClass();
                lVar.e0(i8, Float.floatToRawIntBits(fFloatValue));
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10 += 4;
        }
        lVar.k0(i10);
        while (i9 < list.size()) {
            lVar.f0(Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
            i9++;
        }
    }

    public static void F(int i8, List list, l0 l0Var, b1 b1Var) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l0Var.getClass();
        for (int i9 = 0; i9 < list.size(); i9++) {
            l0Var.b(i8, list.get(i9), b1Var);
        }
    }

    public static void G(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        if (!z) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                lVar.j0(i8, 0);
                lVar.i0(iIntValue);
            }
            return;
        }
        lVar.j0(i8, 2);
        int iX = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iX += l.X(((Integer) list.get(i10)).intValue());
        }
        lVar.k0(iX);
        for (int i11 = 0; i11 < list.size(); i11++) {
            lVar.i0(((Integer) list.get(i11)).intValue());
        }
    }

    public static void H(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.l0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int iB0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iB0 += l.b0(((Long) list.get(i10)).longValue());
        }
        lVar.k0(iB0);
        while (i9 < list.size()) {
            lVar.m0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void I(int i8, List list, l0 l0Var, b1 b1Var) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l0Var.getClass();
        for (int i9 = 0; i9 < list.size(); i9++) {
            l0Var.c(i8, list.get(i9), b1Var);
        }
    }

    public static void J(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.e0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10 += 4;
        }
        lVar.k0(i10);
        while (i9 < list.size()) {
            lVar.f0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void K(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.g0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10 += 8;
        }
        lVar.k0(i10);
        while (i9 < list.size()) {
            lVar.h0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void L(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        if (!z) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                lVar.j0(i8, 0);
                lVar.k0((iIntValue >> 31) ^ (iIntValue << 1));
            }
            return;
        }
        lVar.j0(i8, 2);
        int iA0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            int iIntValue2 = ((Integer) list.get(i10)).intValue();
            iA0 += l.a0((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        lVar.k0(iA0);
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue3 = ((Integer) list.get(i11)).intValue();
            lVar.k0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
        }
    }

    public static void M(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                long jLongValue = ((Long) list.get(i9)).longValue();
                lVar.l0(i8, (jLongValue >> 63) ^ (jLongValue << 1));
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int iB0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            long jLongValue2 = ((Long) list.get(i10)).longValue();
            iB0 += l.b0((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        lVar.k0(iB0);
        while (i9 < list.size()) {
            long jLongValue3 = ((Long) list.get(i9)).longValue();
            lVar.m0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i9++;
        }
    }

    public static void N(int i8, List list, l0 l0Var) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        if (!(list instanceof f0)) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                String str = (String) list.get(i9);
                lVar.j0(i8, 2);
                int i10 = lVar.f1489e;
                byte[] bArr = lVar.d;
                int i11 = lVar.f1490f;
                try {
                    int iA0 = l.a0(str.length() * 3);
                    int iA02 = l.a0(str.length());
                    if (iA02 == iA0) {
                        int i12 = i11 + iA02;
                        lVar.f1490f = i12;
                        int iE = q1.f1510a.E(str, bArr, i12, i10 - i12);
                        lVar.f1490f = i11;
                        lVar.k0((iE - i11) - iA02);
                        lVar.f1490f = iE;
                    } else {
                        lVar.k0(q1.b(str));
                        int i13 = lVar.f1490f;
                        lVar.f1490f = q1.f1510a.E(str, bArr, i13, i10 - i13);
                    }
                } catch (p1 e9) {
                    lVar.f1490f = i11;
                    l.f1486g.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e9);
                    byte[] bytes = str.getBytes(a0.f1428a);
                    try {
                        lVar.k0(bytes.length);
                        lVar.d0(bytes, 0, bytes.length);
                    } catch (IndexOutOfBoundsException e10) {
                        throw new androidx.datastore.preferences.protobuf.k(e10);
                    }
                } catch (IndexOutOfBoundsException e11) {
                    throw new androidx.datastore.preferences.protobuf.k(e11);
                }
            }
            return;
        }
        f0 f0Var = (f0) list;
        for (int i14 = 0; i14 < list.size(); i14++) {
            Object objD = f0Var.d(i14);
            if (objD instanceof String) {
                String str2 = (String) objD;
                lVar.j0(i8, 2);
                int i15 = lVar.f1489e;
                byte[] bArr2 = lVar.d;
                int i16 = lVar.f1490f;
                try {
                    int iA03 = l.a0(str2.length() * 3);
                    int iA04 = l.a0(str2.length());
                    if (iA04 == iA03) {
                        int i17 = i16 + iA04;
                        lVar.f1490f = i17;
                        int iE2 = q1.f1510a.E(str2, bArr2, i17, i15 - i17);
                        lVar.f1490f = i16;
                        lVar.k0((iE2 - i16) - iA04);
                        lVar.f1490f = iE2;
                    } else {
                        lVar.k0(q1.b(str2));
                        int i18 = lVar.f1490f;
                        lVar.f1490f = q1.f1510a.E(str2, bArr2, i18, i15 - i18);
                    }
                } catch (p1 e12) {
                    lVar.f1490f = i16;
                    l.f1486g.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e12);
                    byte[] bytes2 = str2.getBytes(a0.f1428a);
                    try {
                        lVar.k0(bytes2.length);
                        lVar.d0(bytes2, 0, bytes2.length);
                    } catch (IndexOutOfBoundsException e13) {
                        throw new androidx.datastore.preferences.protobuf.k(e13);
                    }
                } catch (IndexOutOfBoundsException e14) {
                    throw new androidx.datastore.preferences.protobuf.k(e14);
                }
            } else {
                i iVar = (i) objD;
                lVar.j0(i8, 2);
                lVar.k0(iVar.size());
                h hVar = (h) iVar;
                lVar.d0(hVar.d, hVar.k(), hVar.size());
            }
        }
    }

    public static void O(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        if (!z) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                lVar.j0(i8, 0);
                lVar.k0(iIntValue);
            }
            return;
        }
        lVar.j0(i8, 2);
        int iA0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iA0 += l.a0(((Integer) list.get(i10)).intValue());
        }
        lVar.k0(iA0);
        for (int i11 = 0; i11 < list.size(); i11++) {
            lVar.k0(((Integer) list.get(i11)).intValue());
        }
    }

    public static void P(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.l0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.j0(i8, 2);
        int iB0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iB0 += l.b0(((Long) list.get(i10)).longValue());
        }
        lVar.k0(iB0);
        while (i9 < list.size()) {
            lVar.m0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static int a(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZ = l.Z(i8) * size;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iZ += l.T((i) list.get(i9));
        }
        return iZ;
    }

    public static int b(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.Z(i8) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            if (size <= 0) {
                return 0;
            }
            xVar.h(0);
            throw null;
        }
        int iX = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iX += l.X(((Integer) list.get(i8)).intValue());
        }
        return iX;
    }

    public static int d(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return l.U(i8) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return l.V(i8) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.Z(i8) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            if (size <= 0) {
                return 0;
            }
            xVar.h(0);
            throw null;
        }
        int iX = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iX += l.X(((Integer) list.get(i8)).intValue());
        }
        return iX;
    }

    public static int j(int i8, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (l.Z(i8) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            if (size <= 0) {
                return 0;
            }
            j0Var.h(0);
            throw null;
        }
        int iB0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iB0 += l.b0(((Long) list.get(i8)).longValue());
        }
        return iB0;
    }

    public static int l(int i8, List list, b1 b1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZ = l.Z(i8) * size;
        for (int i9 = 0; i9 < size; i9++) {
            int iB = ((a) list.get(i9)).b(b1Var);
            iZ += l.a0(iB) + iB;
        }
        return iZ;
    }

    public static int m(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.Z(i8) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            if (size <= 0) {
                return 0;
            }
            xVar.h(0);
            throw null;
        }
        int iA0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            int iIntValue = ((Integer) list.get(i8)).intValue();
            iA0 += l.a0((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iA0;
    }

    public static int o(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.Z(i8) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            if (size <= 0) {
                return 0;
            }
            j0Var.h(0);
            throw null;
        }
        int iB0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            long jLongValue = ((Long) list.get(i8)).longValue();
            iB0 += l.b0((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iB0;
    }

    public static int q(int i8, List list) {
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        int iZ = l.Z(i8) * size;
        if (!(list instanceof f0)) {
            while (i9 < size) {
                Object obj = list.get(i9);
                if (obj instanceof i) {
                    int size2 = ((i) obj).size();
                    iZ = l.a0(size2) + size2 + iZ;
                } else {
                    iZ = l.Y((String) obj) + iZ;
                }
                i9++;
            }
            return iZ;
        }
        f0 f0Var = (f0) list;
        while (i9 < size) {
            Object objD = f0Var.d(i9);
            if (objD instanceof i) {
                int size3 = ((i) objD).size();
                iZ = l.a0(size3) + size3 + iZ;
            } else {
                iZ = l.Y((String) objD) + iZ;
            }
            i9++;
        }
        return iZ;
    }

    public static int r(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.Z(i8) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            if (size <= 0) {
                return 0;
            }
            xVar.h(0);
            throw null;
        }
        int iA0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iA0 += l.a0(((Integer) list.get(i8)).intValue());
        }
        return iA0;
    }

    public static int t(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.Z(i8) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            if (size <= 0) {
                return 0;
            }
            j0Var.h(0);
            throw null;
        }
        int iB0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iB0 += l.b0(((Long) list.get(i8)).longValue());
        }
        return iB0;
    }

    public static f1 v(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (f1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static void w(f1 f1Var, Object obj, Object obj2) {
        f1Var.getClass();
        w wVar = (w) obj;
        e1 e1Var = wVar.unknownFields;
        e1 e1Var2 = ((w) obj2).unknownFields;
        e1 e1Var3 = e1.f1454f;
        if (!e1Var3.equals(e1Var2)) {
            if (e1Var3.equals(e1Var)) {
                int i8 = e1Var.f1455a + e1Var2.f1455a;
                int[] iArrCopyOf = Arrays.copyOf(e1Var.f1456b, i8);
                System.arraycopy(e1Var2.f1456b, 0, iArrCopyOf, e1Var.f1455a, e1Var2.f1455a);
                Object[] objArrCopyOf = Arrays.copyOf(e1Var.f1457c, i8);
                System.arraycopy(e1Var2.f1457c, 0, objArrCopyOf, e1Var.f1455a, e1Var2.f1455a);
                e1Var = new e1(i8, iArrCopyOf, objArrCopyOf, true);
            } else {
                e1Var.getClass();
                if (!e1Var2.equals(e1Var3)) {
                    if (!e1Var.f1458e) {
                        throw new UnsupportedOperationException();
                    }
                    int i9 = e1Var.f1455a + e1Var2.f1455a;
                    e1Var.a(i9);
                    System.arraycopy(e1Var2.f1456b, 0, e1Var.f1456b, e1Var.f1455a, e1Var2.f1455a);
                    System.arraycopy(e1Var2.f1457c, 0, e1Var.f1457c, e1Var.f1455a, e1Var2.f1455a);
                    e1Var.f1455a = i9;
                }
            }
        }
        wVar.unknownFields = e1Var;
    }

    public static boolean x(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void y(int i8, List list, l0 l0Var, boolean z) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) l0Var.f1492a;
        if (!z) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                boolean zBooleanValue = ((Boolean) list.get(i9)).booleanValue();
                lVar.j0(i8, 0);
                lVar.c0(zBooleanValue ? (byte) 1 : (byte) 0);
            }
            return;
        }
        lVar.j0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).getClass();
            Logger logger = l.f1486g;
            i10++;
        }
        lVar.k0(i10);
        for (int i12 = 0; i12 < list.size(); i12++) {
            lVar.c0(((Boolean) list.get(i12)).booleanValue() ? (byte) 1 : (byte) 0);
        }
    }

    public static void z(int i8, List list, l0 l0Var) throws androidx.datastore.preferences.protobuf.k {
        if (list == null || list.isEmpty()) {
            return;
        }
        l0Var.getClass();
        for (int i9 = 0; i9 < list.size(); i9++) {
            l lVar = (l) l0Var.f1492a;
            i iVar = (i) list.get(i9);
            lVar.j0(i8, 2);
            lVar.k0(iVar.size());
            h hVar = (h) iVar;
            lVar.d0(hVar.d, hVar.k(), hVar.size());
        }
    }
}
