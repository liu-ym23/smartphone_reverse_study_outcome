package q1;

import a8.c;
import ab.x;
import android.os.Handler;
import d0.e;
import d2.i;
import i1.a1;
import i1.d1;
import i1.f0;
import i1.j1;
import i1.r;
import j1.n1;
import k.z;
import n7.m;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final x f8625a;

    /* renamed from: b, reason: collision with root package name */
    public final b f8626b;

    /* renamed from: c, reason: collision with root package name */
    public final z f8627c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8628d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8629e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8630f;

    /* renamed from: g, reason: collision with root package name */
    public j1.x f8631g;

    /* renamed from: h, reason: collision with root package name */
    public long f8632h;

    /* renamed from: i, reason: collision with root package name */
    public final c f8633i;

    /* renamed from: j, reason: collision with root package name */
    public final t0.a f8634j;

    public a() {
        x xVar = new x(5, (byte) 0);
        xVar.f669c = new long[192];
        xVar.f670d = new long[192];
        this.f8625a = xVar;
        this.f8626b = new b();
        this.f8627c = new z();
        this.f8632h = -1L;
        this.f8633i = new c(26, this);
        this.f8634j = new t0.a();
    }

    public static long a(d1 d1Var, long j2) {
        float[] fArrB;
        int iC;
        j1 j1Var = d1Var.N;
        if (j1Var == null || (iC = m.c((fArrB = ((n1) j1Var).b()))) == 3) {
            return j2;
        }
        if ((iC & 2) == 0) {
            return 9223372034707292159L;
        }
        return a.a.i0(u0.z.j(fArrB, (Float.floatToRawIntBits((int) (j2 & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32)));
    }

    public static long h(f0 f0Var) {
        a1 a1Var = f0Var.H;
        d1 d1Var = (d1) a1Var.f4402h;
        long jC = 0;
        for (d1 d1Var2 = (r) a1Var.f4401g; d1Var2 != null && d1Var2 != d1Var; d1Var2 = d1Var2.f4439v) {
            long jA = a(d1Var2, jC);
            if (i.a(jA, 9223372034707292159L)) {
                return 9223372034707292159L;
            }
            jC = i.c(jA, d1Var2.E);
        }
        return jC;
    }

    public static void i(f0 f0Var) {
        long jH;
        d1 d1Var = (d1) f0Var.H.f4402h;
        long jA = a(d1Var, 0L);
        long jC = 9223372034707292159L;
        if (!m.d(jA)) {
            f0Var.f4454h = 9223372034707292159L;
            return;
        }
        long jC2 = i.c(jA, d1Var.E);
        f0 f0VarN = f0Var.n();
        if (f0VarN != null) {
            if (!m.d(f0VarN.f4454h)) {
                i(f0VarN);
            }
            long j2 = f0VarN.f4454h;
            if (m.d(j2)) {
                if (f0VarN.f4457k) {
                    jH = h(f0VarN);
                    f0VarN.f4456j = jH;
                    f0VarN.f4457k = false;
                } else {
                    jH = f0VarN.f4456j;
                }
                if (m.d(jH)) {
                    jC = i.c(i.c(j2, jH), jC2);
                }
            }
        } else {
            jC = jC2;
        }
        f0Var.f4454h = jC;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.b():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(i1.f0 r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.c(i1.f0, boolean):void");
    }

    public final void d(f0 f0Var) {
        e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var2 = (f0) objArr[i10];
            c(f0Var2, false);
            d(f0Var2);
        }
    }

    public final void e(f0 f0Var) {
        this.f8628d = true;
        int i2 = f0Var.f4453g & 67108863;
        x xVar = this.f8625a;
        long[] jArr = (long[]) xVar.f669c;
        int i10 = xVar.f668b;
        int i11 = 0;
        while (true) {
            if (i11 >= jArr.length - 2 || i11 >= i10) {
                break;
            }
            int i12 = i11 + 2;
            long j2 = jArr[i12];
            if ((((int) j2) & 67108863) == i2) {
                jArr[i12] = 2305843009213693952L | j2;
                break;
            }
            i11 += 3;
        }
        j1.x xVar2 = this.f8631g;
        boolean z4 = xVar2 != null;
        long j4 = this.f8626b.f8636b;
        if (j4 >= 0 || !z4) {
            if (this.f8632h == j4 && z4) {
                return;
            }
            if (xVar2 != null) {
                Handler handler = n0.a.f6771a;
                n0.a.f6771a.removeCallbacks(xVar2);
            }
            Handler handler2 = n0.a.f6771a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax = Math.max(j4, 16 + jCurrentTimeMillis);
            this.f8632h = jMax;
            j1.x xVar3 = new j1.x(this.f8633i, 1);
            n0.a.f6771a.postDelayed(xVar3, jMax - jCurrentTimeMillis);
            this.f8631g = xVar3;
        }
    }

    public final void f(f0 f0Var) {
        long jH = h(f0Var);
        if (!m.d(jH)) {
            d(f0Var);
            return;
        }
        f0Var.f4456j = jH;
        f0Var.f4457k = false;
        e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            g((f0) objArr[i10], false);
        }
        e(f0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(i1.f0 r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.g(i1.f0, boolean):void");
    }

    public final void j(f0 f0Var) {
        int i2 = f0Var.f4453g & 67108863;
        x xVar = this.f8625a;
        long[] jArr = (long[]) xVar.f669c;
        int i10 = xVar.f668b;
        int i11 = 0;
        while (true) {
            if (i11 >= jArr.length - 2 || i11 >= i10) {
                break;
            }
            int i12 = i11 + 2;
            if ((((int) jArr[i12]) & 67108863) == i2) {
                jArr[i11] = -1;
                jArr[i11 + 1] = -1;
                jArr[i12] = 2305843009213693951L;
                break;
            }
            i11 += 3;
        }
        this.f8628d = true;
        this.f8630f = true;
    }
}
