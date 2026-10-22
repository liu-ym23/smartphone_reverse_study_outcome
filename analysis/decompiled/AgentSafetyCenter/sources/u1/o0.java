package u1;

import java.lang.invoke.VarHandle;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o0 extends s1.o0 implements s1.h0, z0 {

    /* renamed from: j, reason: collision with root package name */
    public l0 f13877j;

    /* renamed from: k, reason: collision with root package name */
    public xb.l f13878k;

    /* renamed from: l, reason: collision with root package name */
    public r1 f13879l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13880m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13881n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13882o;

    /* renamed from: p, reason: collision with root package name */
    public final s1.c0 f13883p;

    /* renamed from: q, reason: collision with root package name */
    public ed.o f13884q;

    /* renamed from: r, reason: collision with root package name */
    public p.f0 f13885r;

    public o0() {
        s1.c0 c0Var = new s1.c0(0);
        c0Var.f11222g = this;
        VarHandle.storeStoreFence();
        this.f13883p = c0Var;
    }

    public static void t0(g1 g1Var) {
        h0 h0Var;
        g1 g1Var2 = g1Var.f13811t;
        g0 g0Var = g1Var.f13810s;
        if (!yb.k.a(g1Var2 != null ? g1Var2.f13810s : null, g0Var)) {
            g0Var.I.f13857p.B.f();
            return;
        }
        a aVarH = g0Var.I.f13857p.h();
        if (aVarH == null || (h0Var = ((x0) aVarH).B) == null) {
            return;
        }
        h0Var.f();
    }

    @Override // s1.o0
    public final int H(s1.l lVar) {
        int iB0;
        if (l0() && (iB0 = b0(lVar)) != Integer.MIN_VALUE) {
            return iB0 + ((int) (this.i & 4294967295L));
        }
        return Integer.MIN_VALUE;
    }

    @Override // s1.h0
    public boolean V() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(u1.g0 r32, s1.n r33) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.o0.Z(u1.g0, s1.n):void");
    }

    public abstract int b0(s1.l lVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final void c0(r1 r1Var, long j10, long j11) {
        boolean z10;
        char c9;
        long j12;
        long j13;
        long j14;
        g0 g0Var;
        boolean z11;
        int i;
        char c10;
        long j15;
        p1 snapshotObserver;
        p.f0 f0Var = this.f13885r;
        ed.o oVar = this.f13884q;
        if (oVar == null) {
            oVar = new ed.o();
            this.f13884q = oVar;
        }
        ed.o oVar2 = oVar;
        n1 n1Var = o0().f13800q;
        if (n1Var != null && (snapshotObserver = ((v1.t) n1Var).getSnapshotObserver()) != null) {
            snapshotObserver.a(r1Var, e.f13754g, new m0(this, j10, j11, r1Var));
        }
        boolean zV = V();
        p.g0 g0Var2 = (p.g0) oVar2.f3841e;
        p.g0 g0Var3 = (p.g0) oVar2.f3842f;
        int i3 = oVar2.f3837a;
        for (int i10 = 0; i10 < i3; i10++) {
            byte b10 = ((byte[]) oVar2.f3840d)[i10];
            if (b10 == 3) {
                s1.n nVar = ((s1.n[]) oVar2.f3838b)[i10];
                nVar.getClass();
                g0Var3.i(nVar);
            } else if (b10 != 0 && f0Var != null) {
                s1.n nVar2 = ((s1.n[]) oVar2.f3838b)[i10];
                nVar2.getClass();
                p.g0 g0Var4 = (p.g0) f0Var.k(nVar2);
                if (g0Var4 != null) {
                    g0Var2.j(g0Var4);
                }
            }
        }
        int i11 = oVar2.f3837a;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            byte[] bArr = (byte[]) oVar2.f3840d;
            if (bArr[i13] == 2) {
                i12++;
            } else if (i12 > 0) {
                s1.n[] nVarArr = (s1.n[]) oVar2.f3838b;
                nVarArr[i13 - i12] = nVarArr[i13];
            }
            bArr[i13] = 2;
        }
        int i14 = oVar2.f3837a;
        for (int i15 = i14 - i12; i15 < i14; i15++) {
            ((s1.n[]) oVar2.f3838b)[i15] = null;
        }
        oVar2.f3837a -= i12;
        o0 o0VarQ0 = q0();
        Object[] objArr = g0Var3.f9561b;
        long[] jArr = g0Var3.f9560a;
        int length = jArr.length - 2;
        char c11 = 7;
        long j16 = -9187201950435737472L;
        int i16 = 8;
        if (length >= 0) {
            j13 = 128;
            int i17 = 0;
            while (true) {
                long j17 = jArr[i17];
                j14 = 255;
                if ((((~j17) << c11) & j17 & j16) != j16) {
                    int i18 = 8 - ((~(i17 - length)) >>> 31);
                    int i19 = 0;
                    while (i19 < i18) {
                        if ((j17 & 255) < 128) {
                            c10 = c11;
                            s1.n nVar3 = (s1.n) objArr[(i17 << 3) + i19];
                            j15 = j16;
                            o0 o0Var = o0VarQ0 == null ? this : o0VarQ0;
                            i = i16;
                            o0 o0Var2 = o0Var;
                            while (true) {
                                ed.o oVar3 = o0Var2.f13884q;
                                if (oVar3 != null) {
                                    z11 = zV;
                                    if (!kb.k.d0((s1.n[]) oVar3.f3838b, nVar3)) {
                                        break;
                                        break;
                                    }
                                    break;
                                }
                                z11 = zV;
                                o0 o0VarQ02 = o0Var2.q0();
                                if (o0VarQ02 == null) {
                                    break;
                                }
                                o0Var2 = o0VarQ02;
                                zV = z11;
                            }
                            p.f0 f0Var2 = o0Var2.f13885r;
                            p.g0 g0Var5 = f0Var2 != null ? (p.g0) f0Var2.k(nVar3) : null;
                            if (g0Var5 != null) {
                                o0Var.u0(g0Var5);
                            }
                        } else {
                            z11 = zV;
                            i = i16;
                            c10 = c11;
                            j15 = j16;
                        }
                        j17 >>= i;
                        i19++;
                        c11 = c10;
                        j16 = j15;
                        i16 = i;
                        zV = z11;
                    }
                    z10 = zV;
                    c9 = c11;
                    j12 = j16;
                    if (i18 != i16) {
                        break;
                    }
                } else {
                    z10 = zV;
                    c9 = c11;
                    j12 = j16;
                }
                if (i17 == length) {
                    break;
                }
                i17++;
                c11 = c9;
                j16 = j12;
                zV = z10;
                i16 = 8;
            }
        } else {
            z10 = zV;
            c9 = 7;
            j12 = -9187201950435737472L;
            j13 = 128;
            j14 = 255;
        }
        g0Var3.b();
        Object[] objArr2 = g0Var2.f9561b;
        long[] jArr2 = g0Var2.f9560a;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i20 = 0;
            while (true) {
                long j18 = jArr2[i20];
                if ((((~j18) << c9) & j18 & j12) != j12) {
                    int i21 = 8 - ((~(i20 - length2)) >>> 31);
                    for (int i22 = 0; i22 < i21; i22++) {
                        if ((j18 & j14) < j13 && (g0Var = (g0) ((b2) objArr2[(i20 << 3) + i22]).get()) != null) {
                            if (z10) {
                                g0Var.S(false);
                            } else {
                                g0Var.U(false);
                            }
                        }
                        j18 >>= 8;
                    }
                    if (i21 != 8) {
                        break;
                    }
                }
                if (i20 == length2) {
                    break;
                } else {
                    i20++;
                }
            }
        }
        g0Var2.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(s1.g0 r15) {
        /*
            r14 = this;
            p.f0 r0 = r14.f13885r
            boolean r1 = r14.f13882o
            if (r1 == 0) goto L8
            goto Lc4
        L8:
            xb.l r1 = r15.f()
            r2 = 0
            if (r1 != 0) goto L59
            if (r0 == 0) goto Lc4
            java.lang.Object[] r15 = r0.f9554c
            long[] r1 = r0.f9552a
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L55
            r4 = r2
        L1b:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L50
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L35:
            if (r9 >= r7) goto L4e
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4a
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r15[r10]
            p.g0 r10 = (p.g0) r10
            r14.u0(r10)
        L4a:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L35
        L4e:
            if (r7 != r8) goto L55
        L50:
            if (r4 == r3) goto L55
            int r4 = r4 + 1
            goto L1b
        L55:
            r0.a()
            return
        L59:
            xb.l r0 = r14.f13878k
            r3 = 1
            if (r0 == r1) goto L60
            r0 = r3
            goto L61
        L60:
            r0 = r2
        L61:
            r4 = 0
            if (r0 != 0) goto L9a
            u1.l0 r1 = r14.s0()
            boolean r1 = r1.f13861c
            if (r1 == 0) goto L9a
            s1.q r0 = r14.h0()
            long r4 = r0.m(r4)
            long r4 = td.h.H(r4)
            long r0 = r0.l()
            u1.l0 r6 = r14.s0()
            long r6 = r6.f13862f
            boolean r6 = o2.i.b(r4, r6)
            if (r6 == 0) goto L95
            u1.l0 r6 = r14.s0()
            long r6 = r6.f13863g
            boolean r6 = o2.k.b(r0, r6)
            if (r6 != 0) goto L96
        L95:
            r2 = r3
        L96:
            r3 = r4
            r5 = r0
            r0 = r2
            goto La1
        L9a:
            r1 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            r5 = r4
            r3 = r1
        La1:
            if (r0 == 0) goto Lc4
            u1.r1 r0 = r14.f13879l
            if (r0 == 0) goto Lac
            r0.f13912c = r15
        La9:
            r1 = r14
            r2 = r0
            goto Lbb
        Lac:
            u1.r1 r0 = new u1.r1
            r0.<init>()
            r0.f13912c = r15
            r0.f13913f = r14
            java.lang.invoke.VarHandle.storeStoreFence()
            r14.f13879l = r0
            goto La9
        Lbb:
            r1.c0(r2, r3, r5)
            xb.l r14 = r15.f()
            r1.f13878k = r14
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.o0.d0(s1.g0):void");
    }

    public abstract o0 f0();

    public abstract s1.q h0();

    @Override // s1.h0
    public final s1.g0 i(int i, int i3, Map map, xb.l lVar, xb.l lVar2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i3) != 0) {
            r1.a.b("Size(" + i + " x " + i3 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        n0 n0Var = new n0();
        n0Var.f13871a = i;
        n0Var.f13872b = i3;
        n0Var.f13873c = map;
        n0Var.f13874d = lVar;
        n0Var.f13875e = lVar2;
        n0Var.f13876f = this;
        VarHandle.storeStoreFence();
        return n0Var;
    }

    public abstract boolean l0();

    public abstract g0 o0();

    public abstract s1.g0 p0();

    public abstract o0 q0();

    public abstract long r0();

    public final l0 s0() {
        l0 l0Var = this.f13877j;
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0();
        l0Var2.f13864h = this;
        l0Var2.f13862f = 9223372034707292159L;
        l0Var2.f13863g = 0L;
        VarHandle.storeStoreFence();
        this.f13877j = l0Var2;
        return l0Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0(p.g0 g0Var) {
        g0 g0Var2;
        Object[] objArr = g0Var.f9561b;
        long[] jArr = g0Var.f9560a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128 && (g0Var2 = (g0) ((b2) objArr[(i << 3) + i10]).get()) != null) {
                        if (V()) {
                            g0Var2.S(false);
                        } else {
                            g0Var2.U(false);
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract void v0();

    @Override // u1.z0
    public final void y(boolean z10) {
        o0 o0VarQ0 = q0();
        g0 g0VarO0 = o0VarQ0 != null ? o0VarQ0.o0() : null;
        if (yb.k.a(g0VarO0, o0())) {
            this.f13880m = z10;
            return;
        }
        if ((g0VarO0 != null ? g0VarO0.I.f13846d : null) != c0.f13738g) {
            if ((g0VarO0 != null ? g0VarO0.I.f13846d : null) != c0.f13739h) {
                return;
            }
        }
        this.f13880m = z10;
    }
}
