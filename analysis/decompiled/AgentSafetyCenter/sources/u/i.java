package u;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends w0.l implements u1.v, u1.k {
    public boolean A;

    /* renamed from: s, reason: collision with root package name */
    public f0 f13479s;

    /* renamed from: t, reason: collision with root package name */
    public z0 f13480t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13481u;

    /* renamed from: v, reason: collision with root package name */
    public sa.c f13482v;

    /* renamed from: w, reason: collision with root package name */
    public s1.q f13483w;

    /* renamed from: x, reason: collision with root package name */
    public c1.c f13484x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13485y;

    /* renamed from: z, reason: collision with root package name */
    public long f13486z;

    /* JADX WARN: Removed duplicated region for block: B:43:0x006a A[EDGE_INSN: B:43:0x006a->B:25:0x006a BREAK  A[LOOP:0: B:8:0x001c->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:0: B:8:0x001c->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float B0(u.i r11, u.d r12) {
        /*
            long r0 = r11.f13486z
            r2 = 0
            boolean r0 = o2.k.b(r0, r2)
            if (r0 == 0) goto Lc
            goto L76
        Lc:
            sa.c r0 = r11.f13482v
            java.lang.Object r0 = r0.f12170f
            m0.e r0 = (m0.e) r0
            int r1 = r0.f8160g
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L69
            int r1 = r1 - r3
            java.lang.Object[] r0 = r0.f8158c
            r4 = r2
        L1c:
            r5 = r0[r1]
            u.h r5 = (u.h) r5
            z.b r5 = r5.f13471a
            java.lang.Object r5 = r5.invoke()
            c1.c r5 = (c1.c) r5
            if (r5 == 0) goto L64
            long r6 = r5.b()
            long r8 = r11.f13486z
            long r8 = ac.a.i0(r8)
            u.f0 r10 = r11.f13479s
            int r10 = r10.ordinal()
            if (r10 == 0) goto L50
            if (r10 != r3) goto L4b
            float r6 = c1.e.e(r6)
            float r7 = c1.e.e(r8)
            int r6 = java.lang.Float.compare(r6, r7)
            goto L5c
        L4b:
            g5.f.a()
            r11 = 0
            return r11
        L50:
            float r6 = c1.e.c(r6)
            float r7 = c1.e.c(r8)
            int r6 = java.lang.Float.compare(r6, r7)
        L5c:
            if (r6 > 0) goto L60
            r4 = r5
            goto L64
        L60:
            if (r4 != 0) goto L6a
            r4 = r5
            goto L6a
        L64:
            int r1 = r1 + (-1)
            if (r1 >= 0) goto L1c
            goto L6a
        L69:
            r4 = r2
        L6a:
            if (r4 != 0) goto L79
            boolean r0 = r11.f13485y
            if (r0 == 0) goto L74
            c1.c r2 = r11.C0()
        L74:
            if (r2 != 0) goto L78
        L76:
            r11 = 0
            return r11
        L78:
            r4 = r2
        L79:
            long r0 = r11.f13486z
            long r0 = ac.a.i0(r0)
            u.f0 r11 = r11.f13479s
            int r11 = r11.ordinal()
            if (r11 == 0) goto L9c
            if (r11 != r3) goto L97
            float r11 = r4.f2167a
            float r2 = r4.f2169c
            float r2 = r2 - r11
            float r0 = c1.e.e(r0)
            float r11 = r12.a(r11, r2, r0)
            return r11
        L97:
            g5.f.a()
            r11 = 0
            return r11
        L9c:
            float r11 = r4.f2168b
            float r2 = r4.f2170d
            float r2 = r2 - r11
            float r0 = c1.e.c(r0)
            float r11 = r12.a(r11, r2, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: u.i.B0(u.i, u.d):float");
    }

    public final c1.c C0() {
        if (this.f15126r) {
            u1.g1 g1VarT = u1.f.t(this);
            s1.q qVar = this.f13483w;
            if (qVar != null) {
                if (!qVar.k()) {
                    qVar = null;
                }
                if (qVar != null) {
                    return g1VarT.g(qVar, false);
                }
            }
        }
        return null;
    }

    public final boolean D0(c1.c cVar, long j10) {
        long jF0 = F0(cVar, j10);
        return Math.abs(c1.b.e(jF0)) <= 0.5f && Math.abs(c1.b.f(jF0)) <= 0.5f;
    }

    public final void E0() {
        d dVar = (d) u1.f.h(this, g.f13461a);
        if (this.A) {
            od.f.e("launchAnimation called when previous animation was running");
            return;
        }
        s.h hVarB = dVar.b();
        o1 o1Var = new o1();
        o1Var.f13541a = hVarB.a(s.i1.f11026a);
        o1Var.f13542b = Long.MIN_VALUE;
        o1Var.f13543c = o1.f13540f;
        VarHandle.storeStoreFence();
        kc.w.u(p0(), null, kc.u.f7484h, new androidx.lifecycle.i0(this, o1Var, dVar, null, 9), 1);
    }

    public final long F0(c1.c cVar, long j10) {
        long jI0 = ac.a.i0(j10);
        int iOrdinal = this.f13479s.ordinal();
        if (iOrdinal == 0) {
            d dVar = (d) u1.f.h(this, g.f13461a);
            float f5 = cVar.f2168b;
            return id.k.d(0.0f, dVar.a(f5, cVar.f2170d - f5, c1.e.c(jI0)));
        }
        if (iOrdinal != 1) {
            g5.f.a();
            return 0L;
        }
        d dVar2 = (d) u1.f.h(this, g.f13461a);
        float f10 = cVar.f2167a;
        return id.k.d(dVar2.a(f10, cVar.f2169c - f10, c1.e.e(jI0)), 0.0f);
    }

    @Override // u1.v
    public final void m(long j10) {
        int iB;
        c1.c cVarC0;
        long j11 = this.f13486z;
        this.f13486z = j10;
        int iOrdinal = this.f13479s.ordinal();
        if (iOrdinal == 0) {
            iB = yb.k.b((int) (j10 & 4294967295L), (int) (4294967295L & j11));
        } else {
            if (iOrdinal != 1) {
                g5.f.a();
                return;
            }
            iB = yb.k.b((int) (j10 >> 32), (int) (j11 >> 32));
        }
        if (iB < 0 && (cVarC0 = C0()) != null) {
            c1.c cVar = this.f13484x;
            if (cVar == null) {
                cVar = cVarC0;
            }
            if (!this.A && !this.f13485y && D0(cVar, j11) && !D0(cVarC0, j10)) {
                this.f13485y = true;
                E0();
            }
            this.f13484x = cVarC0;
        }
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }
}
