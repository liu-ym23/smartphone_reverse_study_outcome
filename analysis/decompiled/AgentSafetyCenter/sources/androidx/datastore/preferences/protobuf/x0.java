package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f1220a;

    /* renamed from: b, reason: collision with root package name */
    public static final e1 f1221b;

    /* renamed from: c, reason: collision with root package name */
    public static final e1 f1222c;

    static {
        Class<?> cls;
        Class<?> cls2;
        t0 t0Var = t0.f1207c;
        e1 e1Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f1220a = cls;
        try {
            t0 t0Var2 = t0.f1207c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                e1Var = (e1) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f1221b = e1Var;
        f1222c = new e1();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += l.j(((Integer) list.get(i)).intValue());
        }
        return iJ;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.h(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.h(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += l.j(((Integer) list.get(i)).intValue());
        }
        return iJ;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += l.j(((Long) list.get(i)).longValue());
        }
        return iJ;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int iIntValue = ((Integer) list.get(i3)).intValue();
            i += l.i((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return i;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iJ += l.j((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iJ;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += l.i(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += l.j(((Long) list.get(i)).longValue());
        }
        return iJ;
    }

    public static void k(e1 e1Var, Object obj, Object obj2) {
        e1Var.getClass();
        v vVar = (v) obj;
        d1 d1Var = vVar.unknownFields;
        d1 d1Var2 = ((v) obj2).unknownFields;
        d1 d1Var3 = d1.f1097f;
        if (!d1Var3.equals(d1Var2)) {
            if (d1Var3.equals(d1Var)) {
                int i = d1Var.f1098a + d1Var2.f1098a;
                int[] iArrCopyOf = Arrays.copyOf(d1Var.f1099b, i);
                System.arraycopy(d1Var2.f1099b, 0, iArrCopyOf, d1Var.f1098a, d1Var2.f1098a);
                Object[] objArrCopyOf = Arrays.copyOf(d1Var.f1100c, i);
                System.arraycopy(d1Var2.f1100c, 0, objArrCopyOf, d1Var.f1098a, d1Var2.f1098a);
                d1Var = new d1(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                d1Var.getClass();
                if (!d1Var2.equals(d1Var3)) {
                    if (!d1Var.f1102e) {
                        b8.z.c();
                        return;
                    }
                    int i3 = d1Var.f1098a + d1Var2.f1098a;
                    d1Var.a(i3);
                    System.arraycopy(d1Var2.f1099b, 0, d1Var.f1099b, d1Var.f1098a, d1Var2.f1098a);
                    System.arraycopy(d1Var2.f1100c, 0, d1Var.f1100c, d1Var.f1098a, d1Var2.f1098a);
                    d1Var.f1098a = i3;
                }
            }
        }
        vVar.unknownFields = d1Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.o(i, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10++;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.m(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    public static void n(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.t(i, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10 += 8;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.u(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    public static void o(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.v(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iJ += l.j(((Integer) list.get(i10)).intValue());
        }
        lVar.D(iJ);
        while (i3 < list.size()) {
            lVar.w(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public static void p(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.r(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10 += 4;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.s(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public static void q(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.t(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10 += 8;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.u(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public static void r(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.r(i, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10 += 4;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.s(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    public static void s(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.v(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iJ += l.j(((Integer) list.get(i10)).intValue());
        }
        lVar.D(iJ);
        while (i3 < list.size()) {
            lVar.w(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public static void t(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.E(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iJ += l.j(((Long) list.get(i10)).longValue());
        }
        lVar.D(iJ);
        while (i3 < list.size()) {
            lVar.F(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public static void u(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.r(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10 += 4;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.s(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public static void v(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.t(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = l.f1148f;
            i10 += 8;
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.u(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public static void w(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                lVar.C(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue2 = ((Integer) list.get(i11)).intValue();
            i10 += l.i((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i3)).intValue();
            lVar.D((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i3++;
        }
    }

    public static void x(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                lVar.E(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            long jLongValue2 = ((Long) list.get(i10)).longValue();
            iJ += l.j((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        lVar.D(iJ);
        while (i3 < list.size()) {
            long jLongValue3 = ((Long) list.get(i3)).longValue();
            lVar.F((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i3++;
        }
    }

    public static void y(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.C(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += l.i(((Integer) list.get(i11)).intValue());
        }
        lVar.D(i10);
        while (i3 < list.size()) {
            lVar.D(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public static void z(int i, List list, f0 f0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) f0Var.f1110a;
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                lVar.E(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        lVar.B(i, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iJ += l.j(((Long) list.get(i10)).longValue());
        }
        lVar.D(iJ);
        while (i3 < list.size()) {
            lVar.F(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public static Object j(Object obj, int i, w wVar, Object obj2, e1 e1Var) {
        return obj2;
    }
}
