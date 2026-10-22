package com.google.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class u3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2561a;

    /* renamed from: b, reason: collision with root package name */
    public static final d4 f2562b;

    /* renamed from: c, reason: collision with root package name */
    public static final d4 f2563c;

    static {
        Class<?> cls;
        Class<?> cls2;
        q3 q3Var = q3.f2501c;
        d4 d4Var = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f2561a = cls;
        try {
            q3 q3Var2 = q3.f2501c;
            try {
                cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                d4Var = (d4) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f2562b = d4Var;
        f2563c = new d4();
    }

    public static void A(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof j2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.q0(i2, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iV = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iV += r.V(((Integer) list.get(i11)).intValue());
            }
            rVar.r0(iV);
            while (i10 < list.size()) {
                rVar.r0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j2 j2Var = (j2) list;
        if (!z4) {
            while (i10 < j2Var.f2415h) {
                rVar.q0(i2, j2Var.getInt(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iV2 = 0;
        for (int i12 = 0; i12 < j2Var.f2415h; i12++) {
            iV2 += r.V(j2Var.getInt(i12));
        }
        rVar.r0(iV2);
        while (i10 < j2Var.f2415h) {
            rVar.r0(j2Var.getInt(i10));
            i10++;
        }
    }

    public static void B(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof x2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.s0(i2, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iW = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iW += r.W(((Long) list.get(i11)).longValue());
            }
            rVar.r0(iW);
            while (i10 < list.size()) {
                rVar.t0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        x2 x2Var = (x2) list;
        if (!z4) {
            while (i10 < 0) {
                rVar.s0(i2, x2Var.getLong(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iW2 = 0;
        for (int i12 = 0; i12 < 0; i12++) {
            iW2 += r.W(x2Var.getLong(i12));
        }
        rVar.r0(iW2);
        while (i10 < 0) {
            rVar.t0(x2Var.getLong(i10));
            i10++;
        }
    }

    public static int a(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j2)) {
            int iW = 0;
            while (i2 < size) {
                iW += r.W(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iW;
        }
        j2 j2Var = (j2) list;
        int iW2 = 0;
        while (i2 < size) {
            iW2 += r.W(j2Var.getInt(i2));
            i2++;
        }
        return iW2;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (r.U(i2) + 4) * size;
    }

    public static int c(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (r.U(i2) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j2)) {
            int iW = 0;
            while (i2 < size) {
                iW += r.W(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iW;
        }
        j2 j2Var = (j2) list;
        int iW2 = 0;
        while (i2 < size) {
            iW2 += r.W(j2Var.getInt(i2));
            i2++;
        }
        return iW2;
    }

    public static int e(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof x2)) {
            int iW = 0;
            while (i2 < size) {
                iW += r.W(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iW;
        }
        x2 x2Var = (x2) list;
        int iW2 = 0;
        while (i2 < size) {
            iW2 += r.W(x2Var.getLong(i2));
            i2++;
        }
        return iW2;
    }

    public static int f(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j2)) {
            int iR = 0;
            while (i2 < size) {
                iR += r.R(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iR;
        }
        j2 j2Var = (j2) list;
        int iR2 = 0;
        while (i2 < size) {
            iR2 += r.R(j2Var.getInt(i2));
            i2++;
        }
        return iR2;
    }

    public static int g(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof x2)) {
            int iS = 0;
            while (i2 < size) {
                iS += r.S(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iS;
        }
        x2 x2Var = (x2) list;
        int iS2 = 0;
        while (i2 < size) {
            iS2 += r.S(x2Var.getLong(i2));
            i2++;
        }
        return iS2;
    }

    public static int h(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j2)) {
            int iV = 0;
            while (i2 < size) {
                iV += r.V(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iV;
        }
        j2 j2Var = (j2) list;
        int iV2 = 0;
        while (i2 < size) {
            iV2 += r.V(j2Var.getInt(i2));
            i2++;
        }
        return iV2;
    }

    public static int i(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof x2)) {
            int iW = 0;
            while (i2 < size) {
                iW += r.W(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iW;
        }
        x2 x2Var = (x2) list;
        int iW2 = 0;
        while (i2 < size) {
            iW2 += r.W(x2Var.getLong(i2));
            i2++;
        }
        return iW2;
    }

    public static Object j(Object obj, int i2, o2 o2Var, l2 l2Var, Object obj2, d4 d4Var) {
        if (l2Var == null) {
            return obj2;
        }
        if (o2Var == null) {
            Iterator it = o2Var.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!l2Var.a(iIntValue)) {
                    obj2 = n(obj, i2, iIntValue, obj2, d4Var);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = o2Var.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Integer num = (Integer) o2Var.get(i11);
            int iIntValue2 = num.intValue();
            if (l2Var.a(iIntValue2)) {
                if (i11 != i10) {
                    o2Var.set(i10, num);
                }
                i10++;
            } else {
                obj2 = n(obj, i2, iIntValue2, obj2, d4Var);
            }
        }
        if (i10 != size) {
            o2Var.subList(i10, size).clear();
        }
        return obj2;
    }

    public static void k(v1 v1Var, Object obj, Object obj2) {
        ((w1) v1Var).getClass();
        b2 b2Var = ((h2) obj2).extensions;
        if (b2Var.f2318a.isEmpty()) {
            return;
        }
        ((h2) obj).p().getClass();
        v3 v3Var = b2Var.f2318a;
        if (v3Var.f2591g > 0) {
            v3Var.c(0).getKey().getClass();
            throw new ClassCastException();
        }
        Iterator it = v3Var.d().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getKey() != null) {
                throw new ClassCastException();
            }
            entry.getValue();
            throw null;
        }
    }

    public static void l(d4 d4Var, Object obj, Object obj2) {
        d4Var.getClass();
        i2 i2Var = (i2) obj;
        c4 c4Var = i2Var.unknownFields;
        c4 c4Var2 = ((i2) obj2).unknownFields;
        c4 c4Var3 = c4.f2327f;
        if (!c4Var3.equals(c4Var2)) {
            if (c4Var3.equals(c4Var)) {
                int i2 = c4Var.f2328a + c4Var2.f2328a;
                int[] iArrCopyOf = Arrays.copyOf(c4Var.f2329b, i2);
                System.arraycopy(c4Var2.f2329b, 0, iArrCopyOf, c4Var.f2328a, c4Var2.f2328a);
                Object[] objArrCopyOf = Arrays.copyOf(c4Var.f2330c, i2);
                System.arraycopy(c4Var2.f2330c, 0, objArrCopyOf, c4Var.f2328a, c4Var2.f2328a);
                c4Var = new c4(i2, iArrCopyOf, objArrCopyOf, true);
            } else {
                c4Var.getClass();
                if (!c4Var2.equals(c4Var3)) {
                    if (!c4Var.f2332e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = c4Var.f2328a + c4Var2.f2328a;
                    c4Var.a(i10);
                    System.arraycopy(c4Var2.f2329b, 0, c4Var.f2329b, c4Var.f2328a, c4Var2.f2328a);
                    System.arraycopy(c4Var2.f2330c, 0, c4Var.f2330c, c4Var.f2328a, c4Var2.f2328a);
                    c4Var.f2328a = i10;
                }
            }
        }
        i2Var.unknownFields = c4Var;
    }

    public static boolean m(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object n(Object obj, int i2, int i10, Object obj2, d4 d4Var) {
        if (obj2 == null) {
            d4Var.getClass();
            obj2 = d4.a(obj);
        }
        d4Var.getClass();
        ((c4) obj2).d(i2 << 3, Long.valueOf(i10));
        return obj2;
    }

    public static void o(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof h)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.Z(i2, ((Boolean) list.get(i10)).booleanValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Boolean) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11++;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.Y(((Boolean) list.get(i10)).booleanValue() ? (byte) 1 : (byte) 0);
                i10++;
            }
            return;
        }
        h hVar = (h) list;
        if (!z4) {
            while (i10 < 0) {
                rVar.Z(i2, hVar.getBoolean(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < 0; i14++) {
            hVar.getBoolean(i14);
            Logger logger2 = r.f2504b;
            i13++;
        }
        rVar.r0(i13);
        while (i10 < 0) {
            rVar.Y(hVar.getBoolean(i10) ? (byte) 1 : (byte) 0);
            i10++;
        }
    }

    public static void p(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof p1)) {
            if (!z4) {
                while (i10 < list.size()) {
                    double dDoubleValue = ((Double) list.get(i10)).doubleValue();
                    rVar.getClass();
                    rVar.f0(i2, Double.doubleToRawLongBits(dDoubleValue));
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Double) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11 += 8;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.g0(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
                i10++;
            }
            return;
        }
        p1 p1Var = (p1) list;
        if (!z4) {
            while (i10 < 0) {
                double d6 = p1Var.getDouble(i10);
                rVar.getClass();
                rVar.f0(i2, Double.doubleToRawLongBits(d6));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < 0; i14++) {
            p1Var.getDouble(i14);
            Logger logger2 = r.f2504b;
            i13 += 8;
        }
        rVar.r0(i13);
        while (i10 < 0) {
            rVar.g0(Double.doubleToRawLongBits(p1Var.getDouble(i10)));
            i10++;
        }
    }

    public static void q(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof j2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.h0(i2, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iW = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iW += r.W(((Integer) list.get(i11)).intValue());
            }
            rVar.r0(iW);
            while (i10 < list.size()) {
                rVar.i0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j2 j2Var = (j2) list;
        if (!z4) {
            while (i10 < j2Var.f2415h) {
                rVar.h0(i2, j2Var.getInt(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iW2 = 0;
        for (int i12 = 0; i12 < j2Var.f2415h; i12++) {
            iW2 += r.W(j2Var.getInt(i12));
        }
        rVar.r0(iW2);
        while (i10 < j2Var.f2415h) {
            rVar.i0(j2Var.getInt(i10));
            i10++;
        }
    }

    public static void r(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof j2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.d0(i2, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11 += 4;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.e0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j2 j2Var = (j2) list;
        if (!z4) {
            while (i10 < j2Var.f2415h) {
                rVar.d0(i2, j2Var.getInt(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < j2Var.f2415h; i14++) {
            j2Var.getInt(i14);
            Logger logger2 = r.f2504b;
            i13 += 4;
        }
        rVar.r0(i13);
        while (i10 < j2Var.f2415h) {
            rVar.e0(j2Var.getInt(i10));
            i10++;
        }
    }

    public static void s(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof x2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.f0(i2, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11 += 8;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.g0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        x2 x2Var = (x2) list;
        if (!z4) {
            while (i10 < 0) {
                rVar.f0(i2, x2Var.getLong(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < 0; i14++) {
            x2Var.getLong(i14);
            Logger logger2 = r.f2504b;
            i13 += 8;
        }
        rVar.r0(i13);
        while (i10 < 0) {
            rVar.g0(x2Var.getLong(i10));
            i10++;
        }
    }

    public static void t(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof d2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    float fFloatValue = ((Float) list.get(i10)).floatValue();
                    rVar.getClass();
                    rVar.d0(i2, Float.floatToRawIntBits(fFloatValue));
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Float) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11 += 4;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.e0(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
                i10++;
            }
            return;
        }
        d2 d2Var = (d2) list;
        if (!z4) {
            while (i10 < 0) {
                float f10 = d2Var.getFloat(i10);
                rVar.getClass();
                rVar.d0(i2, Float.floatToRawIntBits(f10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < 0; i14++) {
            d2Var.getFloat(i14);
            Logger logger2 = r.f2504b;
            i13 += 4;
        }
        rVar.r0(i13);
        while (i10 < 0) {
            rVar.e0(Float.floatToRawIntBits(d2Var.getFloat(i10)));
            i10++;
        }
    }

    public static void u(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof j2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.h0(i2, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iW = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iW += r.W(((Integer) list.get(i11)).intValue());
            }
            rVar.r0(iW);
            while (i10 < list.size()) {
                rVar.i0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j2 j2Var = (j2) list;
        if (!z4) {
            while (i10 < j2Var.f2415h) {
                rVar.h0(i2, j2Var.getInt(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iW2 = 0;
        for (int i12 = 0; i12 < j2Var.f2415h; i12++) {
            iW2 += r.W(j2Var.getInt(i12));
        }
        rVar.r0(iW2);
        while (i10 < j2Var.f2415h) {
            rVar.i0(j2Var.getInt(i10));
            i10++;
        }
    }

    public static void v(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof x2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.s0(i2, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iW = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iW += r.W(((Long) list.get(i11)).longValue());
            }
            rVar.r0(iW);
            while (i10 < list.size()) {
                rVar.t0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        x2 x2Var = (x2) list;
        if (!z4) {
            while (i10 < 0) {
                rVar.s0(i2, x2Var.getLong(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iW2 = 0;
        for (int i12 = 0; i12 < 0; i12++) {
            iW2 += r.W(x2Var.getLong(i12));
        }
        rVar.r0(iW2);
        while (i10 < 0) {
            rVar.t0(x2Var.getLong(i10));
            i10++;
        }
    }

    public static void w(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof j2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.d0(i2, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11 += 4;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.e0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j2 j2Var = (j2) list;
        if (!z4) {
            while (i10 < j2Var.f2415h) {
                rVar.d0(i2, j2Var.getInt(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < j2Var.f2415h; i14++) {
            j2Var.getInt(i14);
            Logger logger2 = r.f2504b;
            i13 += 4;
        }
        rVar.r0(i13);
        while (i10 < j2Var.f2415h) {
            rVar.e0(j2Var.getInt(i10));
            i10++;
        }
    }

    public static void x(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof x2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    rVar.f0(i2, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                Logger logger = r.f2504b;
                i11 += 8;
            }
            rVar.r0(i11);
            while (i10 < list.size()) {
                rVar.g0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        x2 x2Var = (x2) list;
        if (!z4) {
            while (i10 < 0) {
                rVar.f0(i2, x2Var.getLong(i10));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < 0; i14++) {
            x2Var.getLong(i14);
            Logger logger2 = r.f2504b;
            i13 += 8;
        }
        rVar.r0(i13);
        while (i10 < 0) {
            rVar.g0(x2Var.getLong(i10));
            i10++;
        }
    }

    public static void y(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof j2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    int iIntValue = ((Integer) list.get(i10)).intValue();
                    rVar.q0(i2, (iIntValue >> 31) ^ (iIntValue << 1));
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iR = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iR += r.R(((Integer) list.get(i11)).intValue());
            }
            rVar.r0(iR);
            while (i10 < list.size()) {
                int iIntValue2 = ((Integer) list.get(i10)).intValue();
                rVar.r0((iIntValue2 >> 31) ^ (iIntValue2 << 1));
                i10++;
            }
            return;
        }
        j2 j2Var = (j2) list;
        if (!z4) {
            while (i10 < j2Var.f2415h) {
                int i12 = j2Var.getInt(i10);
                rVar.q0(i2, (i12 >> 31) ^ (i12 << 1));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iR2 = 0;
        for (int i13 = 0; i13 < j2Var.f2415h; i13++) {
            iR2 += r.R(j2Var.getInt(i13));
        }
        rVar.r0(iR2);
        while (i10 < j2Var.f2415h) {
            int i14 = j2Var.getInt(i10);
            rVar.r0((i14 >> 31) ^ (i14 << 1));
            i10++;
        }
    }

    public static void z(int i2, List list, z2 z2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r rVar = (r) z2Var.f2665a;
        int i10 = 0;
        if (!(list instanceof x2)) {
            if (!z4) {
                while (i10 < list.size()) {
                    long jLongValue = ((Long) list.get(i10)).longValue();
                    rVar.s0(i2, (jLongValue >> 63) ^ (jLongValue << 1));
                    i10++;
                }
                return;
            }
            rVar.p0(i2, 2);
            int iS = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iS += r.S(((Long) list.get(i11)).longValue());
            }
            rVar.r0(iS);
            while (i10 < list.size()) {
                long jLongValue2 = ((Long) list.get(i10)).longValue();
                rVar.t0((jLongValue2 >> 63) ^ (jLongValue2 << 1));
                i10++;
            }
            return;
        }
        x2 x2Var = (x2) list;
        if (!z4) {
            while (i10 < 0) {
                long j2 = x2Var.getLong(i10);
                rVar.s0(i2, (j2 >> 63) ^ (j2 << 1));
                i10++;
            }
            return;
        }
        rVar.p0(i2, 2);
        int iS2 = 0;
        for (int i12 = 0; i12 < 0; i12++) {
            iS2 += r.S(x2Var.getLong(i12));
        }
        rVar.r0(iS2);
        while (i10 < 0) {
            long j4 = x2Var.getLong(i10);
            rVar.t0((j4 >> 63) ^ (j4 << 1));
            i10++;
        }
    }
}
