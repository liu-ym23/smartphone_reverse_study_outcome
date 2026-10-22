package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public final class B1 {

    /* renamed from: a, reason: collision with root package name */
    public static final M1 f20009a;

    static {
        C1752p1 c1752p1 = C1752p1.f20120c;
        f20009a = new O1();
    }

    public static void A(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.p(i10, list, z10);
    }

    public static void B(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.h(i10, list, z10);
    }

    public static void C(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.E(i10, list, z10);
    }

    public static void D(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.u(i10, list, z10);
    }

    public static void E(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.g(i10, list, z10);
    }

    public static void a(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.B(i10, list, z10);
    }

    public static void b(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.G(i10, list, z10);
    }

    public static void c(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.w(i10, list, z10);
    }

    public static void d(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.m(i10, list, z10);
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof G0)) {
            int iB = 0;
            while (i10 < size) {
                iB += AbstractC1739m0.b(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iB;
        }
        G0 g02 = (G0) list;
        int iB2 = 0;
        while (i10 < size) {
            iB2 += AbstractC1739m0.b(g02.c(i10));
            i10++;
        }
        return iB2;
    }

    public static int g(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC1739m0.a(i10 << 3) + 4);
    }

    public static int h(List list) {
        return list.size() * 4;
    }

    public static int i(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC1739m0.a(i10 << 3) + 8);
    }

    public static int j(List list) {
        return list.size() * 8;
    }

    public static int k(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof G0)) {
            int iB = 0;
            while (i10 < size) {
                iB += AbstractC1739m0.b(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iB;
        }
        G0 g02 = (G0) list;
        int iB2 = 0;
        while (i10 < size) {
            iB2 += AbstractC1739m0.b(g02.c(i10));
            i10++;
        }
        return iB2;
    }

    public static int l(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof X0)) {
            int iB = 0;
            while (i10 < size) {
                iB += AbstractC1739m0.b(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iB;
        }
        X0 x02 = (X0) list;
        int iB2 = 0;
        while (i10 < size) {
            iB2 += AbstractC1739m0.b(x02.c(i10));
            i10++;
        }
        return iB2;
    }

    public static int m(int i10, Object obj, InterfaceC1791z1 interfaceC1791z1) {
        int i11 = i10 << 3;
        if (!(obj instanceof S0)) {
            return AbstractC1739m0.a(i11) + AbstractC1739m0.B((InterfaceC1720h1) obj, interfaceC1791z1);
        }
        int iA = AbstractC1739m0.a(i11);
        int iA2 = ((S0) obj).a();
        return iA + AbstractC1739m0.a(iA2) + iA2;
    }

    public static int n(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof G0)) {
            int iA = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iA += AbstractC1739m0.a((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
            return iA;
        }
        G0 g02 = (G0) list;
        int iA2 = 0;
        while (i10 < size) {
            int iC = g02.c(i10);
            iA2 += AbstractC1739m0.a((iC >> 31) ^ (iC + iC));
            i10++;
        }
        return iA2;
    }

    public static int o(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof X0)) {
            int iB = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iB += AbstractC1739m0.b((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
            return iB;
        }
        X0 x02 = (X0) list;
        int iB2 = 0;
        while (i10 < size) {
            long jC = x02.c(i10);
            iB2 += AbstractC1739m0.b((jC >> 63) ^ (jC + jC));
            i10++;
        }
        return iB2;
    }

    public static int p(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof G0)) {
            int iA = 0;
            while (i10 < size) {
                iA += AbstractC1739m0.a(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iA;
        }
        G0 g02 = (G0) list;
        int iA2 = 0;
        while (i10 < size) {
            iA2 += AbstractC1739m0.a(g02.c(i10));
            i10++;
        }
        return iA2;
    }

    public static int q(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof X0)) {
            int iB = 0;
            while (i10 < size) {
                iB += AbstractC1739m0.b(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iB;
        }
        X0 x02 = (X0) list;
        int iB2 = 0;
        while (i10 < size) {
            iB2 += AbstractC1739m0.b(x02.c(i10));
            i10++;
        }
        return iB2;
    }

    public static M1 r() {
        return f20009a;
    }

    public static Object s(Object obj, int i10, int i11, Object obj2, M1 m12) {
        Object obj3 = obj2;
        if (obj2 == null) {
            F0 f02 = (F0) obj;
            N1 n12 = f02.zzc;
            obj3 = n12;
            if (n12 == N1.c()) {
                N1 n1F = N1.f();
                f02.zzc = n1F;
                obj3 = n1F;
            }
        }
        ((N1) obj3).j(i10 << 3, Long.valueOf(i11));
        return obj3;
    }

    public static void t(AbstractC1762s0 abstractC1762s0, Object obj, Object obj2) {
        C1778w0 c1778w0 = ((C0) obj2).zzb;
        if (c1778w0.f20143a.isEmpty()) {
            return;
        }
        ((C0) obj).H().h(c1778w0);
    }

    public static void u(M1 m12, Object obj, Object obj2) {
        F0 f02 = (F0) obj;
        N1 n1E = f02.zzc;
        N1 n12 = ((F0) obj2).zzc;
        if (!N1.c().equals(n12)) {
            if (N1.c().equals(n1E)) {
                n1E = N1.e(n1E, n12);
            } else {
                n1E.d(n12);
            }
        }
        f02.zzc = n1E;
    }

    public static void v(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.f(i10, list, z10);
    }

    public static void w(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.H(i10, list, z10);
    }

    public static void x(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.A(i10, list, z10);
    }

    public static void y(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.x(i10, list, z10);
    }

    public static void z(int i10, List list, Z1 z12, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z12.n(i10, list, z10);
    }
}
