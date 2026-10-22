package i1;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class m0 extends g1.s implements x0, d2.c {

    /* renamed from: k, reason: collision with root package name */
    public j0 f4527k;

    /* renamed from: l, reason: collision with root package name */
    public p7.k f4528l;

    /* renamed from: m, reason: collision with root package name */
    public o1 f4529m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4530n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4531o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4532p;

    /* renamed from: q, reason: collision with root package name */
    public final g1.m f4533q = new g1.m(0, this);

    /* renamed from: r, reason: collision with root package name */
    public eb.p f4534r;

    /* renamed from: s, reason: collision with root package name */
    public k.a0 f4535s;

    public static void i0(d1 d1Var) {
        g0 g0Var;
        d1 d1Var2 = d1Var.f4438u;
        f0 f0Var = d1Var.f4437t;
        if (!q7.k.a(d1Var2 != null ? d1Var2.f4437t : null, f0Var)) {
            f0Var.I.f4507o.A.f();
            return;
        }
        a aVarM = f0Var.I.f4507o.m();
        if (aVarM == null || (g0Var = ((v0) aVarM).A) == null) {
            return;
        }
        g0Var.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(i1.f0 r32, g1.h r33) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.m0.Q(i1.f0, g1.h):void");
    }

    public abstract int S(g1.f fVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(o1 o1Var, long j2, long j4) {
        boolean z4;
        char c10;
        long j10;
        long j11;
        long j12;
        f0 f0Var;
        boolean z10;
        int i2;
        char c11;
        long j13;
        m1 snapshotObserver;
        k.a0 a0Var = this.f4535s;
        eb.p pVar = this.f4534r;
        if (pVar == null) {
            pVar = new eb.p();
            this.f4534r = pVar;
        }
        eb.p pVar2 = pVar;
        k1 k1Var = d0().f4464r;
        if (k1Var != null && (snapshotObserver = ((j1.y) k1Var).getSnapshotObserver()) != null) {
            snapshotObserver.a(o1Var, d.f4421i, new k0(this, j2, j4, o1Var));
        }
        boolean zJ0 = j0();
        k.b0 b0Var = (k.b0) pVar2.f3322e;
        k.b0 b0Var2 = (k.b0) pVar2.f3323f;
        int i10 = pVar2.f3318a;
        for (int i11 = 0; i11 < i10; i11++) {
            byte b10 = ((byte[]) pVar2.f3321d)[i11];
            if (b10 == 3) {
                g1.h hVar = ((g1.h[]) pVar2.f3319b)[i11];
                q7.k.b(hVar);
                b0Var2.i(hVar);
            } else if (b10 != 0 && a0Var != null) {
                g1.h hVar2 = ((g1.h[]) pVar2.f3319b)[i11];
                q7.k.b(hVar2);
                k.b0 b0Var3 = (k.b0) a0Var.j(hVar2);
                if (b0Var3 != null) {
                    b0Var.j(b0Var3);
                }
            }
        }
        int i12 = pVar2.f3318a;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            byte[] bArr = (byte[]) pVar2.f3321d;
            if (bArr[i14] == 2) {
                i13++;
            } else if (i13 > 0) {
                g1.h[] hVarArr = (g1.h[]) pVar2.f3319b;
                hVarArr[i14 - i13] = hVarArr[i14];
            }
            bArr[i14] = 2;
        }
        int i15 = pVar2.f3318a;
        for (int i16 = i15 - i13; i16 < i15; i16++) {
            ((g1.h[]) pVar2.f3319b)[i16] = null;
        }
        pVar2.f3318a -= i13;
        m0 m0VarF0 = f0();
        Object[] objArr = b0Var2.f5454b;
        long[] jArr = b0Var2.f5453a;
        int length = jArr.length - 2;
        char c12 = 7;
        long j14 = -9187201950435737472L;
        int i17 = 8;
        if (length >= 0) {
            j11 = 128;
            int i18 = 0;
            while (true) {
                long j15 = jArr[i18];
                j12 = 255;
                if ((((~j15) << c12) & j15 & j14) != j14) {
                    int i19 = 8 - ((~(i18 - length)) >>> 31);
                    int i20 = 0;
                    while (i20 < i19) {
                        if ((j15 & 255) < 128) {
                            c11 = c12;
                            g1.h hVar3 = (g1.h) objArr[(i18 << 3) + i20];
                            j13 = j14;
                            m0 m0Var = m0VarF0 == null ? this : m0VarF0;
                            i2 = i17;
                            m0 m0Var2 = m0Var;
                            while (true) {
                                eb.p pVar3 = m0Var2.f4534r;
                                if (pVar3 != null) {
                                    z10 = zJ0;
                                    if (!d7.n.U((g1.h[]) pVar3.f3319b, hVar3)) {
                                        break;
                                        break;
                                    }
                                    break;
                                }
                                z10 = zJ0;
                                m0 m0VarF02 = m0Var2.f0();
                                if (m0VarF02 == null) {
                                    break;
                                }
                                m0Var2 = m0VarF02;
                                zJ0 = z10;
                            }
                            k.a0 a0Var2 = m0Var2.f4535s;
                            k.b0 b0Var4 = a0Var2 != null ? (k.b0) a0Var2.j(hVar3) : null;
                            if (b0Var4 != null) {
                                m0Var.m0(b0Var4);
                            }
                        } else {
                            z10 = zJ0;
                            i2 = i17;
                            c11 = c12;
                            j13 = j14;
                        }
                        j15 >>= i2;
                        i20++;
                        c12 = c11;
                        j14 = j13;
                        i17 = i2;
                        zJ0 = z10;
                    }
                    z4 = zJ0;
                    c10 = c12;
                    j10 = j14;
                    if (i19 != i17) {
                        break;
                    }
                } else {
                    z4 = zJ0;
                    c10 = c12;
                    j10 = j14;
                }
                if (i18 == length) {
                    break;
                }
                i18++;
                c12 = c10;
                j14 = j10;
                zJ0 = z4;
                i17 = 8;
            }
        } else {
            z4 = zJ0;
            c10 = 7;
            j10 = -9187201950435737472L;
            j11 = 128;
            j12 = 255;
        }
        b0Var2.b();
        Object[] objArr2 = b0Var.f5454b;
        long[] jArr2 = b0Var.f5453a;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i21 = 0;
            while (true) {
                long j16 = jArr2[i21];
                if ((((~j16) << c10) & j16 & j10) != j10) {
                    int i22 = 8 - ((~(i21 - length2)) >>> 31);
                    for (int i23 = 0; i23 < i22; i23++) {
                        if ((j16 & j12) < j11 && (f0Var = (f0) ((y1) objArr2[(i21 << 3) + i23]).get()) != null) {
                            if (z4) {
                                f0Var.J(false);
                            } else {
                                f0Var.L(false);
                            }
                        }
                        j16 >>= 8;
                    }
                    if (i22 != 8) {
                        break;
                    }
                }
                if (i21 == length2) {
                    break;
                } else {
                    i21++;
                }
            }
        }
        b0Var.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V(i1.l0 r15) {
        /*
            r14 = this;
            k.a0 r0 = r14.f4535s
            boolean r1 = r14.f4532p
            if (r1 == 0) goto L8
            goto Lbd
        L8:
            p7.k r1 = r15.c()
            r2 = 0
            if (r1 != 0) goto L59
            if (r0 == 0) goto Lbd
            java.lang.Object[] r15 = r0.f5448c
            long[] r1 = r0.f5446a
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
            k.b0 r10 = (k.b0) r10
            r14.m0(r10)
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
            p7.k r0 = r14.f4528l
            r3 = 1
            if (r0 == r1) goto L60
            r0 = r3
            goto L61
        L60:
            r0 = r2
        L61:
            r4 = 0
            if (r0 != 0) goto L9a
            i1.j0 r1 = r14.h0()
            boolean r1 = r1.f4509f
            if (r1 == 0) goto L9a
            g1.k r0 = r14.a0()
            long r4 = r0.a(r4)
            long r4 = a.a.i0(r4)
            long r0 = r0.x()
            i1.j0 r6 = r14.h0()
            long r6 = r6.f4510g
            boolean r6 = d2.i.a(r4, r6)
            if (r6 == 0) goto L95
            i1.j0 r6 = r14.h0()
            long r6 = r6.f4511h
            boolean r6 = d2.k.a(r0, r6)
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
            if (r0 == 0) goto Lbd
            i1.o1 r0 = r14.f4529m
            if (r0 == 0) goto Lac
            r0.f4557f = r15
        La9:
            r1 = r14
            r2 = r0
            goto Lb4
        Lac:
            i1.o1 r0 = new i1.o1
            r0.<init>(r15, r14)
            r14.f4529m = r0
            goto La9
        Lb4:
            r1.T(r2, r3, r5)
            p7.k r14 = r15.c()
            r1.f4528l = r14
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.m0.V(i1.l0):void");
    }

    public final int W(g1.f fVar) {
        int iS;
        if (b0() && (iS = S(fVar)) != Integer.MIN_VALUE) {
            return iS + ((int) (this.f3760j & 4294967295L));
        }
        return Integer.MIN_VALUE;
    }

    public abstract m0 Z();

    public abstract g1.k a0();

    public abstract boolean b0();

    public abstract d2.l c0();

    public abstract f0 d0();

    public abstract l0 e0();

    public abstract m0 f0();

    public abstract long g0();

    public final j0 h0() {
        j0 j0Var = this.f4527k;
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0Var2 = new j0(this);
        this.f4527k = j0Var2;
        return j0Var2;
    }

    @Override // i1.x0
    public final void i(boolean z4) {
        m0 m0VarF0 = f0();
        f0 f0VarD0 = m0VarF0 != null ? m0VarF0.d0() : null;
        if (q7.k.a(f0VarD0, d0())) {
            this.f4530n = z4;
            return;
        }
        if ((f0VarD0 != null ? f0VarD0.I.f4495c : null) != b0.f4410h) {
            if ((f0VarD0 != null ? f0VarD0.I.f4495c : null) != b0.f4411i) {
                return;
            }
        }
        this.f4530n = z4;
    }

    public boolean j0() {
        return false;
    }

    public final l0 k0(int i2, int i10, Map map, g1.y yVar, p7.k kVar) {
        if ((i2 & (-16777216)) != 0 || ((-16777216) & i10) != 0) {
            f1.a.b("Size(" + i2 + " x " + i10 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new l0(i2, i10, map, yVar, kVar, this);
    }

    public l0 l0(int i2, int i10, Map map, p7.k kVar) {
        return k0(i2, i10, map, null, kVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0(k.b0 b0Var) {
        f0 f0Var;
        Object[] objArr = b0Var.f5454b;
        long[] jArr = b0Var.f5453a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128 && (f0Var = (f0) ((y1) objArr[(i2 << 3) + i11]).get()) != null) {
                        if (j0()) {
                            f0Var.J(false);
                        } else {
                            f0Var.L(false);
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public abstract void n0();
}
