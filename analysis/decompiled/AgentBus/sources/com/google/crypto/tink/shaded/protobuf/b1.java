package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class b1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2178a;

    /* renamed from: b, reason: collision with root package name */
    public static final e1 f2179b;

    /* renamed from: c, reason: collision with root package name */
    public static final e1 f2180c;

    /* renamed from: d, reason: collision with root package name */
    public static final e1 f2181d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f2178a = cls;
        f2179b = v(false);
        f2180c = v(true);
        f2181d = new e1();
    }

    public static void A(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                double dDoubleValue = ((Double) list.get(i10)).doubleValue();
                kVar.getClass();
                kVar.e0(i2, Double.doubleToRawLongBits(dDoubleValue));
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11 += 8;
        }
        kVar.i0(i11);
        while (i10 < list.size()) {
            kVar.f0(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void B(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        if (!z4) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                kVar.h0(i2, 0);
                kVar.g0(iIntValue);
            }
            return;
        }
        kVar.h0(i2, 2);
        int iV = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iV += k.V(((Integer) list.get(i11)).intValue());
        }
        kVar.i0(iV);
        for (int i12 = 0; i12 < list.size(); i12++) {
            kVar.g0(((Integer) list.get(i12)).intValue());
        }
    }

    public static void C(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                kVar.c0(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11 += 4;
        }
        kVar.i0(i11);
        while (i10 < list.size()) {
            kVar.d0(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void D(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                kVar.e0(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11 += 8;
        }
        kVar.i0(i11);
        while (i10 < list.size()) {
            kVar.f0(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void E(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                float fFloatValue = ((Float) list.get(i10)).floatValue();
                kVar.getClass();
                kVar.c0(i2, Float.floatToRawIntBits(fFloatValue));
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11 += 4;
        }
        kVar.i0(i11);
        while (i10 < list.size()) {
            kVar.d0(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void F(int i2, List list, k0 k0Var, a1 a1Var) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            k0Var.b(i2, list.get(i10), a1Var);
        }
    }

    public static void G(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        if (!z4) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                kVar.h0(i2, 0);
                kVar.g0(iIntValue);
            }
            return;
        }
        kVar.h0(i2, 2);
        int iV = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iV += k.V(((Integer) list.get(i11)).intValue());
        }
        kVar.i0(iV);
        for (int i12 = 0; i12 < list.size(); i12++) {
            kVar.g0(((Integer) list.get(i12)).intValue());
        }
    }

    public static void H(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                kVar.j0(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int iZ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iZ += k.Z(((Long) list.get(i11)).longValue());
        }
        kVar.i0(iZ);
        while (i10 < list.size()) {
            kVar.k0(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void I(int i2, List list, k0 k0Var, a1 a1Var) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            k0Var.c(i2, list.get(i10), a1Var);
        }
    }

    public static void J(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                kVar.c0(i2, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11 += 4;
        }
        kVar.i0(i11);
        while (i10 < list.size()) {
            kVar.d0(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void K(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                kVar.e0(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11 += 8;
        }
        kVar.i0(i11);
        while (i10 < list.size()) {
            kVar.f0(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void L(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        if (!z4) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                kVar.h0(i2, 0);
                kVar.i0((iIntValue >> 31) ^ (iIntValue << 1));
            }
            return;
        }
        kVar.h0(i2, 2);
        int iY = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue2 = ((Integer) list.get(i11)).intValue();
            iY += k.Y((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        kVar.i0(iY);
        for (int i12 = 0; i12 < list.size(); i12++) {
            int iIntValue3 = ((Integer) list.get(i12)).intValue();
            kVar.i0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
        }
    }

    public static void M(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                kVar.j0(i2, (jLongValue >> 63) ^ (jLongValue << 1));
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int iZ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            long jLongValue2 = ((Long) list.get(i11)).longValue();
            iZ += k.Z((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        kVar.i0(iZ);
        while (i10 < list.size()) {
            long jLongValue3 = ((Long) list.get(i10)).longValue();
            kVar.k0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i10++;
        }
    }

    public static void N(int i2, List list, k0 k0Var) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        if (!(list instanceof e0)) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                String str = (String) list.get(i10);
                kVar.h0(i2, 2);
                int i11 = kVar.f2236c;
                byte[] bArr = kVar.f2235b;
                int i12 = kVar.f2237d;
                try {
                    int iY = k.Y(str.length() * 3);
                    int iY2 = k.Y(str.length());
                    if (iY2 == iY) {
                        int i13 = i12 + iY2;
                        kVar.f2237d = i13;
                        int iR = p1.f2258a.r(i13, i11 - i13, str, bArr);
                        kVar.f2237d = i12;
                        kVar.i0((iR - i12) - iY2);
                        kVar.f2237d = iR;
                    } else {
                        kVar.i0(p1.b(str));
                        int i14 = kVar.f2237d;
                        kVar.f2237d = p1.f2258a.r(i14, i11 - i14, str, bArr);
                    }
                } catch (o1 e10) {
                    kVar.f2237d = i12;
                    k.f2232e.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e10);
                    byte[] bytes = str.getBytes(z.f2296a);
                    try {
                        kVar.i0(bytes.length);
                        kVar.b0(bytes, 0, bytes.length);
                    } catch (IndexOutOfBoundsException e11) {
                        throw new androidx.datastore.preferences.protobuf.l(e11);
                    }
                } catch (IndexOutOfBoundsException e12) {
                    throw new androidx.datastore.preferences.protobuf.l(e12);
                }
            }
            return;
        }
        e0 e0Var = (e0) list;
        for (int i15 = 0; i15 < list.size(); i15++) {
            Object raw = e0Var.getRaw(i15);
            if (raw instanceof String) {
                String str2 = (String) raw;
                kVar.h0(i2, 2);
                int i16 = kVar.f2236c;
                byte[] bArr2 = kVar.f2235b;
                int i17 = kVar.f2237d;
                try {
                    int iY3 = k.Y(str2.length() * 3);
                    int iY4 = k.Y(str2.length());
                    if (iY4 == iY3) {
                        int i18 = i17 + iY4;
                        kVar.f2237d = i18;
                        int iR2 = p1.f2258a.r(i18, i16 - i18, str2, bArr2);
                        kVar.f2237d = i17;
                        kVar.i0((iR2 - i17) - iY4);
                        kVar.f2237d = iR2;
                    } else {
                        kVar.i0(p1.b(str2));
                        int i19 = kVar.f2237d;
                        kVar.f2237d = p1.f2258a.r(i19, i16 - i19, str2, bArr2);
                    }
                } catch (o1 e13) {
                    kVar.f2237d = i17;
                    k.f2232e.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e13);
                    byte[] bytes2 = str2.getBytes(z.f2296a);
                    try {
                        kVar.i0(bytes2.length);
                        kVar.b0(bytes2, 0, bytes2.length);
                    } catch (IndexOutOfBoundsException e14) {
                        throw new androidx.datastore.preferences.protobuf.l(e14);
                    }
                } catch (IndexOutOfBoundsException e15) {
                    throw new androidx.datastore.preferences.protobuf.l(e15);
                }
            } else {
                h hVar = (h) raw;
                kVar.h0(i2, 2);
                kVar.i0(hVar.size());
                g gVar = (g) hVar;
                kVar.b0(gVar.f2207i, gVar.k(), gVar.size());
            }
        }
    }

    public static void O(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        if (!z4) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                kVar.h0(i2, 0);
                kVar.i0(iIntValue);
            }
            return;
        }
        kVar.h0(i2, 2);
        int iY = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iY += k.Y(((Integer) list.get(i11)).intValue());
        }
        kVar.i0(iY);
        for (int i12 = 0; i12 < list.size(); i12++) {
            kVar.i0(((Integer) list.get(i12)).intValue());
        }
    }

    public static void P(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        int i10 = 0;
        if (!z4) {
            while (i10 < list.size()) {
                kVar.j0(i2, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.h0(i2, 2);
        int iZ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iZ += k.Z(((Long) list.get(i11)).longValue());
        }
        kVar.i0(iZ);
        while (i10 < list.size()) {
            kVar.k0(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static int a(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = k.X(i2) * size;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iX += k.R((h) list.get(i10));
        }
        return iX;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.X(i2) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            if (size <= 0) {
                return 0;
            }
            wVar.f(0);
            throw null;
        }
        int iV = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iV += k.V(((Integer) list.get(i2)).intValue());
        }
        return iV;
    }

    public static int d(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k.S(i2) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k.T(i2) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.X(i2) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            if (size <= 0) {
                return 0;
            }
            wVar.f(0);
            throw null;
        }
        int iV = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iV += k.V(((Integer) list.get(i2)).intValue());
        }
        return iV;
    }

    public static int j(int i2, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (k.X(i2) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            if (size <= 0) {
                return 0;
            }
            i0Var.f(0);
            throw null;
        }
        int iZ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZ += k.Z(((Long) list.get(i2)).longValue());
        }
        return iZ;
    }

    public static int l(int i2, List list, a1 a1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = k.X(i2) * size;
        for (int i10 = 0; i10 < size; i10++) {
            int iA = ((a) list.get(i10)).a(a1Var);
            iX += k.Y(iA) + iA;
        }
        return iX;
    }

    public static int m(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.X(i2) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            if (size <= 0) {
                return 0;
            }
            wVar.f(0);
            throw null;
        }
        int iY = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int iIntValue = ((Integer) list.get(i2)).intValue();
            iY += k.Y((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iY;
    }

    public static int o(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.X(i2) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            if (size <= 0) {
                return 0;
            }
            i0Var.f(0);
            throw null;
        }
        int iZ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            long jLongValue = ((Long) list.get(i2)).longValue();
            iZ += k.Z((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iZ;
    }

    public static int q(int i2, List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        int iX = k.X(i2) * size;
        if (!(list instanceof e0)) {
            while (i10 < size) {
                Object obj = list.get(i10);
                if (obj instanceof h) {
                    int size2 = ((h) obj).size();
                    iX = k.Y(size2) + size2 + iX;
                } else {
                    iX = k.W((String) obj) + iX;
                }
                i10++;
            }
            return iX;
        }
        e0 e0Var = (e0) list;
        while (i10 < size) {
            Object raw = e0Var.getRaw(i10);
            if (raw instanceof h) {
                int size3 = ((h) raw).size();
                iX = k.Y(size3) + size3 + iX;
            } else {
                iX = k.W((String) raw) + iX;
            }
            i10++;
        }
        return iX;
    }

    public static int r(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.X(i2) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            if (size <= 0) {
                return 0;
            }
            wVar.f(0);
            throw null;
        }
        int iY = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iY += k.Y(((Integer) list.get(i2)).intValue());
        }
        return iY;
    }

    public static int t(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.X(i2) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            if (size <= 0) {
                return 0;
            }
            i0Var.f(0);
            throw null;
        }
        int iZ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZ += k.Z(((Long) list.get(i2)).longValue());
        }
        return iZ;
    }

    public static e1 v(boolean z4) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (e1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z4));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static void w(e1 e1Var, Object obj, Object obj2) {
        e1Var.getClass();
        v vVar = (v) obj;
        d1 d1Var = vVar.unknownFields;
        d1 d1Var2 = ((v) obj2).unknownFields;
        d1 d1Var3 = d1.f2196f;
        if (!d1Var3.equals(d1Var2)) {
            if (d1Var3.equals(d1Var)) {
                int i2 = d1Var.f2197a + d1Var2.f2197a;
                int[] iArrCopyOf = Arrays.copyOf(d1Var.f2198b, i2);
                System.arraycopy(d1Var2.f2198b, 0, iArrCopyOf, d1Var.f2197a, d1Var2.f2197a);
                Object[] objArrCopyOf = Arrays.copyOf(d1Var.f2199c, i2);
                System.arraycopy(d1Var2.f2199c, 0, objArrCopyOf, d1Var.f2197a, d1Var2.f2197a);
                d1Var = new d1(i2, iArrCopyOf, objArrCopyOf, true);
            } else {
                d1Var.getClass();
                if (!d1Var2.equals(d1Var3)) {
                    if (!d1Var.f2201e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = d1Var.f2197a + d1Var2.f2197a;
                    d1Var.a(i10);
                    System.arraycopy(d1Var2.f2198b, 0, d1Var.f2198b, d1Var.f2197a, d1Var2.f2197a);
                    System.arraycopy(d1Var2.f2199c, 0, d1Var.f2199c, d1Var.f2197a, d1Var2.f2197a);
                    d1Var.f2197a = i10;
                }
            }
        }
        vVar.unknownFields = d1Var;
    }

    public static boolean x(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void y(int i2, List list, k0 k0Var, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f2239a;
        if (!z4) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                boolean zBooleanValue = ((Boolean) list.get(i10)).booleanValue();
                kVar.h0(i2, 0);
                kVar.a0(zBooleanValue ? (byte) 1 : (byte) 0);
            }
            return;
        }
        kVar.h0(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            Logger logger = k.f2232e;
            i11++;
        }
        kVar.i0(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            kVar.a0(((Boolean) list.get(i13)).booleanValue() ? (byte) 1 : (byte) 0);
        }
    }

    public static void z(int i2, List list, k0 k0Var) throws androidx.datastore.preferences.protobuf.l {
        if (list == null || list.isEmpty()) {
            return;
        }
        k0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            k kVar = (k) k0Var.f2239a;
            h hVar = (h) list.get(i10);
            kVar.h0(i2, 2);
            kVar.i0(hVar.size());
            g gVar = (g) hVar;
            kVar.b0(gVar.f2207i, gVar.k(), gVar.size());
        }
    }
}
