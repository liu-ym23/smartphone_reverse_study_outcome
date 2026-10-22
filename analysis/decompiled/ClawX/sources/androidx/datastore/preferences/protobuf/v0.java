package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f571a;

    /* renamed from: b, reason: collision with root package name */
    public static final c1 f572b;

    /* renamed from: c, reason: collision with root package name */
    public static final c1 f573c;

    static {
        Class<?> cls;
        Class<?> cls2;
        r0 r0Var = r0.f559c;
        c1 c1Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f571a = cls;
        try {
            r0 r0Var2 = r0.f559c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                c1Var = (c1) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f572b = c1Var;
        f573c = new c1();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iS0 += l.s0(((Integer) list.get(i8)).intValue());
        }
        return iS0;
    }

    public static int b(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.q0(i8) + 4) * size;
    }

    public static int c(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.q0(i8) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iS0 += l.s0(((Integer) list.get(i8)).intValue());
        }
        return iS0;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iS0 += l.s0(((Long) list.get(i8)).longValue());
        }
        return iS0;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            int iIntValue = ((Integer) list.get(i8)).intValue();
            iR0 += l.r0((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iR0;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            long jLongValue = ((Long) list.get(i8)).longValue();
            iS0 += l.s0((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iS0;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iR0 += l.r0(((Integer) list.get(i8)).intValue());
        }
        return iR0;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS0 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iS0 += l.s0(((Long) list.get(i8)).longValue());
        }
        return iS0;
    }

    public static void k(c1 c1Var, Object obj, Object obj2) {
        c1Var.getClass();
        v vVar = (v) obj;
        b1 b1Var = vVar.unknownFields;
        b1 b1Var2 = ((v) obj2).unknownFields;
        b1 b1Var3 = b1.f451f;
        if (!b1Var3.equals(b1Var2)) {
            if (b1Var3.equals(b1Var)) {
                int i8 = b1Var.f452a + b1Var2.f452a;
                int[] iArrCopyOf = Arrays.copyOf(b1Var.f453b, i8);
                System.arraycopy(b1Var2.f453b, 0, iArrCopyOf, b1Var.f452a, b1Var2.f452a);
                Object[] objArrCopyOf = Arrays.copyOf(b1Var.f454c, i8);
                System.arraycopy(b1Var2.f454c, 0, objArrCopyOf, b1Var.f452a, b1Var2.f452a);
                b1Var = new b1(i8, iArrCopyOf, objArrCopyOf, true);
            } else {
                b1Var.getClass();
                if (!b1Var2.equals(b1Var3)) {
                    if (!b1Var.f455e) {
                        throw new UnsupportedOperationException();
                    }
                    int i9 = b1Var.f452a + b1Var2.f452a;
                    b1Var.a(i9);
                    System.arraycopy(b1Var2.f453b, 0, b1Var.f453b, b1Var.f452a, b1Var2.f452a);
                    System.arraycopy(b1Var2.f454c, 0, b1Var.f454c, b1Var.f452a, b1Var2.f452a);
                    b1Var.f452a = i9;
                }
            }
        }
        vVar.unknownFields = b1Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.x0(i8, ((Boolean) list.get(i9)).booleanValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10++;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.v0(((Boolean) list.get(i9)).booleanValue() ? (byte) 1 : (byte) 0);
            i9++;
        }
    }

    public static void n(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                double dDoubleValue = ((Double) list.get(i9)).doubleValue();
                lVar.getClass();
                lVar.C0(i8, Double.doubleToRawLongBits(dDoubleValue));
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10 += 8;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.D0(Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
            i9++;
        }
    }

    public static void o(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.E0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iS0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS0 += l.s0(((Integer) list.get(i10)).intValue());
        }
        lVar.L0(iS0);
        while (i9 < list.size()) {
            lVar.F0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void p(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.A0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10 += 4;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.B0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void q(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.C0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10 += 8;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.D0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void r(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                float fFloatValue = ((Float) list.get(i9)).floatValue();
                lVar.getClass();
                lVar.A0(i8, Float.floatToRawIntBits(fFloatValue));
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10 += 4;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.B0(Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
            i9++;
        }
    }

    public static void s(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.E0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iS0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS0 += l.s0(((Integer) list.get(i10)).intValue());
        }
        lVar.L0(iS0);
        while (i9 < list.size()) {
            lVar.F0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void t(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.M0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iS0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS0 += l.s0(((Long) list.get(i10)).longValue());
        }
        lVar.L0(iS0);
        while (i9 < list.size()) {
            lVar.N0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void u(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.A0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Integer) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10 += 4;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.B0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void v(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.C0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).getClass();
            Logger logger = l.f507f;
            i10 += 8;
        }
        lVar.L0(i10);
        while (i9 < list.size()) {
            lVar.D0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static void w(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                int iIntValue = ((Integer) list.get(i9)).intValue();
                lVar.K0(i8, (iIntValue >> 31) ^ (iIntValue << 1));
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iR0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            int iIntValue2 = ((Integer) list.get(i10)).intValue();
            iR0 += l.r0((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        lVar.L0(iR0);
        while (i9 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i9)).intValue();
            lVar.L0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i9++;
        }
    }

    public static void x(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                long jLongValue = ((Long) list.get(i9)).longValue();
                lVar.M0(i8, (jLongValue >> 63) ^ (jLongValue << 1));
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iS0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            long jLongValue2 = ((Long) list.get(i10)).longValue();
            iS0 += l.s0((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        lVar.L0(iS0);
        while (i9 < list.size()) {
            long jLongValue3 = ((Long) list.get(i9)).longValue();
            lVar.N0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i9++;
        }
    }

    public static void y(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.K0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iR0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iR0 += l.r0(((Integer) list.get(i10)).intValue());
        }
        lVar.L0(iR0);
        while (i9 < list.size()) {
            lVar.L0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public static void z(int i8, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f466a;
        int i9 = 0;
        if (!z) {
            while (i9 < list.size()) {
                lVar.M0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        lVar.J0(i8, 2);
        int iS0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS0 += l.s0(((Long) list.get(i10)).longValue());
        }
        lVar.L0(iS0);
        while (i9 < list.size()) {
            lVar.N0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    public static Object j(Object obj, int i8, w wVar, Object obj2, c1 c1Var) {
        return obj2;
    }
}
