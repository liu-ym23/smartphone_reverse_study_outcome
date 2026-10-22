package b2;

import a4.t;
import ad.l;
import android.os.Handler;
import d1.f0;
import java.lang.invoke.VarHandle;
import m0.e;
import o2.i;
import p.a0;
import td.h;
import u1.c1;
import u1.g0;
import u1.g1;
import u1.m1;
import v1.h1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public a f1863a;

    /* renamed from: b, reason: collision with root package name */
    public c f1864b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f1865c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1866d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1867e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1868f;

    /* renamed from: g, reason: collision with root package name */
    public t f1869g;

    /* renamed from: h, reason: collision with root package name */
    public long f1870h;
    public l i;

    /* renamed from: j, reason: collision with root package name */
    public c1.a f1871j;

    public static long g(g0 g0Var) {
        float[] fArrB;
        int iG;
        c1 c1Var = g0Var.H;
        g1 g1Var = c1Var.f13744d;
        g1 g1Var2 = c1Var.f13743c;
        long jC = 0;
        while (g1Var2 != null && g1Var2 != g1Var) {
            m1 m1Var = g1Var2.M;
            jC = h.C(jC, g1Var2.D);
            g1Var2 = g1Var2.f13812u;
            if (m1Var != null && (iG = h5.t.g((fArrB = ((h1) m1Var).b()))) != 3) {
                if ((iG & 2) == 0) {
                    return 9223372034707292159L;
                }
                jC = f0.l(fArrB, jC);
            }
        }
        return h.H(jC);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(u1.g0 r10) {
        /*
            u1.c1 r0 = r10.H
            u1.g1 r0 = r0.f13744d
            long r0 = r0.D
            u1.g0 r2 = r10.t()
            if (r2 == 0) goto L45
            long r3 = r2.f13791g
            r5 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            boolean r3 = o2.i.b(r3, r5)
            if (r3 == 0) goto L1c
            h(r2)
        L1c:
            long r3 = r2.f13791g
            boolean r7 = o2.i.b(r3, r5)
            if (r7 == 0) goto L26
        L24:
            r0 = r5
            goto L45
        L26:
            boolean r7 = r2.f13793j
            if (r7 == 0) goto L34
            long r7 = g(r2)
            r2.i = r7
            r9 = 0
            r2.f13793j = r9
            goto L36
        L34:
            long r7 = r2.i
        L36:
            boolean r2 = o2.i.b(r7, r5)
            if (r2 == 0) goto L3d
            goto L24
        L3d:
            long r2 = o2.i.d(r3, r7)
            long r0 = o2.i.d(r2, r0)
        L45:
            r10.f13791g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.h(u1.g0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.a():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(u1.g0 r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.b(u1.g0, boolean):void");
    }

    public final void c(g0 g0Var) {
        e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            b(g0Var2, false);
            c(g0Var2);
        }
    }

    public final void d(g0 g0Var) {
        this.f1866d = true;
        a aVar = this.f1863a;
        int i = g0Var.f13790f & 67108863;
        long[] jArr = (long[]) aVar.f1861c;
        int i3 = aVar.f1860b;
        int i10 = 0;
        while (true) {
            if (i10 >= jArr.length - 2 || i10 >= i3) {
                break;
            }
            int i11 = i10 + 2;
            long j10 = jArr[i11];
            if ((((int) j10) & 67108863) == i) {
                jArr[i11] = 2305843009213693952L | j10;
                break;
            }
            i10 += 3;
        }
        t tVar = this.f1869g;
        boolean z10 = tVar != null;
        this.f1864b.getClass();
        if (z10) {
            return;
        }
        if (this.f1870h == -1 && z10) {
            return;
        }
        if (tVar != null) {
            Handler handler = w0.a.f15088a;
            w0.a.f15088a.removeCallbacks(tVar);
        }
        Handler handler2 = w0.a.f15088a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax = Math.max(-1L, 16 + jCurrentTimeMillis);
        this.f1870h = jMax;
        long j11 = jMax - jCurrentTimeMillis;
        l lVar = this.i;
        t tVar2 = new t(27);
        tVar2.f200f = lVar;
        VarHandle.storeStoreFence();
        w0.a.f15088a.postDelayed(tVar2, j11);
        this.f1869g = tVar2;
    }

    public final void e(g0 g0Var) {
        long jG = g(g0Var);
        if (i.b(jG, 9223372034707292159L)) {
            c(g0Var);
            return;
        }
        g0Var.i = jG;
        g0Var.f13793j = false;
        e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            f((g0) objArr[i3], false);
        }
        d(g0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(u1.g0 r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.f(u1.g0, boolean):void");
    }

    public final void i(g0 g0Var) {
        a aVar = this.f1863a;
        int i = g0Var.f13790f & 67108863;
        long[] jArr = (long[]) aVar.f1861c;
        int i3 = aVar.f1860b;
        int i10 = 0;
        while (true) {
            if (i10 >= jArr.length - 2 || i10 >= i3) {
                break;
            }
            int i11 = i10 + 2;
            if ((((int) jArr[i11]) & 67108863) == i) {
                jArr[i10] = -1;
                jArr[i10 + 1] = -1;
                jArr[i11] = 2305843009213693951L;
                break;
            }
            i10 += 3;
        }
        this.f1866d = true;
        this.f1868f = true;
    }
}
