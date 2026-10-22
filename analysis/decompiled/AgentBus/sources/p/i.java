package p;

/* loaded from: classes.dex */
public final class i extends n0.l implements i1.u, i1.i {
    public boolean B;

    /* renamed from: t, reason: collision with root package name */
    public e0 f8117t;

    /* renamed from: u, reason: collision with root package name */
    public final y0 f8118u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8119v;

    /* renamed from: x, reason: collision with root package name */
    public g1.k f8121x;

    /* renamed from: y, reason: collision with root package name */
    public t0.c f8122y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8123z;

    /* renamed from: w, reason: collision with root package name */
    public final o4.d0 f8120w = new o4.d0(1);
    public long A = 0;

    public i(e0 e0Var, y0 y0Var, boolean z4) {
        this.f8117t = e0Var;
        this.f8118u = y0Var;
        this.f8119v = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006b A[EDGE_INSN: B:43:0x006b->B:25:0x006b BREAK  A[LOOP:0: B:8:0x001c->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:0: B:8:0x001c->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float l0(p.i r11, p.d r12) {
        /*
            long r0 = r11.A
            r2 = 0
            boolean r0 = d2.k.a(r0, r2)
            if (r0 == 0) goto Lc
            goto L77
        Lc:
            o4.d0 r0 = r11.f8120w
            java.lang.Object r0 = r0.f7326g
            d0.e r0 = (d0.e) r0
            int r1 = r0.f2751h
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L6a
            int r1 = r1 - r3
            java.lang.Object[] r0 = r0.f2749f
            r4 = r2
        L1c:
            r5 = r0[r1]
            p.h r5 = (p.h) r5
            s.b r5 = r5.f8111a
            java.lang.Object r5 = r5.c()
            t0.c r5 = (t0.c) r5
            if (r5 == 0) goto L65
            long r6 = r5.b()
            long r8 = r11.A
            long r8 = ib.k.W(r8)
            p.e0 r10 = r11.f8117t
            int r10 = r10.ordinal()
            if (r10 == 0) goto L51
            if (r10 != r3) goto L4b
            float r6 = t0.e.d(r6)
            float r7 = t0.e.d(r8)
            int r6 = java.lang.Float.compare(r6, r7)
            goto L5d
        L4b:
            a4.u r11 = new a4.u
            r11.<init>()
            throw r11
        L51:
            float r6 = t0.e.b(r6)
            float r7 = t0.e.b(r8)
            int r6 = java.lang.Float.compare(r6, r7)
        L5d:
            if (r6 > 0) goto L61
            r4 = r5
            goto L65
        L61:
            if (r4 != 0) goto L6b
            r4 = r5
            goto L6b
        L65:
            int r1 = r1 + (-1)
            if (r1 >= 0) goto L1c
            goto L6b
        L6a:
            r4 = r2
        L6b:
            if (r4 != 0) goto L7a
            boolean r0 = r11.f8123z
            if (r0 == 0) goto L75
            t0.c r2 = r11.m0()
        L75:
            if (r2 != 0) goto L79
        L77:
            r11 = 0
            return r11
        L79:
            r4 = r2
        L7a:
            long r0 = r11.A
            long r0 = ib.k.W(r0)
            p.e0 r11 = r11.f8117t
            int r11 = r11.ordinal()
            if (r11 == 0) goto L9e
            if (r11 != r3) goto L98
            float r11 = r4.f9656a
            float r2 = r4.f9658c
            float r2 = r2 - r11
            float r0 = t0.e.d(r0)
            float r11 = r12.a(r11, r2, r0)
            return r11
        L98:
            a4.u r11 = new a4.u
            r11.<init>()
            throw r11
        L9e:
            float r11 = r4.f9657b
            float r2 = r4.f9659d
            float r2 = r2 - r11
            float r0 = t0.e.b(r0)
            float r11 = r12.a(r11, r2, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p.i.l0(p.i, p.d):float");
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // i1.u
    public final void m(long j2) {
        int iF;
        t0.c cVarM0;
        long j4 = this.A;
        this.A = j2;
        int iOrdinal = this.f8117t.ordinal();
        if (iOrdinal == 0) {
            iF = q7.k.f((int) (j2 & 4294967295L), (int) (4294967295L & j4));
        } else {
            if (iOrdinal != 1) {
                throw new a4.u();
            }
            iF = q7.k.f((int) (j2 >> 32), (int) (j4 >> 32));
        }
        if (iF < 0 && (cVarM0 = m0()) != null) {
            t0.c cVar = this.f8122y;
            if (cVar == null) {
                cVar = cVarM0;
            }
            if (!this.B && !this.f8123z && n0(cVar, j4) && !n0(cVarM0, j2)) {
                this.f8123z = true;
                o0();
            }
            this.f8122y = cVarM0;
        }
    }

    public final t0.c m0() {
        if (this.f6810s) {
            i1.d1 d1VarT = i1.l.t(this);
            g1.k kVar = this.f8121x;
            if (kVar != null) {
                if (!kVar.v()) {
                    kVar = null;
                }
                if (kVar != null) {
                    return d1VarT.B(kVar, false);
                }
            }
        }
        return null;
    }

    public final boolean n0(t0.c cVar, long j2) {
        long jP0 = p0(cVar, j2);
        return Math.abs(t0.b.d(jP0)) <= 0.5f && Math.abs(t0.b.e(jP0)) <= 0.5f;
    }

    public final void o0() {
        d dVar = (d) i1.l.h(this, g.f8099a);
        if (this.B) {
            throw new IllegalStateException("launchAnimation called when previous animation was running");
        }
        ia.d0.s(Z(), null, ia.c0.f4929i, new la.a0(this, new g1(dVar.b()), dVar, (g7.d) null, 8), 1);
    }

    public final long p0(t0.c cVar, long j2) {
        long jW = ib.k.W(j2);
        int iOrdinal = this.f8117t.ordinal();
        if (iOrdinal == 0) {
            d dVar = (d) i1.l.h(this, g.f8099a);
            float f10 = cVar.f9657b;
            return n7.b.b(0.0f, dVar.a(f10, cVar.f9659d - f10, t0.e.b(jW)));
        }
        if (iOrdinal != 1) {
            throw new a4.u();
        }
        d dVar2 = (d) i1.l.h(this, g.f8099a);
        float f11 = cVar.f9656a;
        return n7.b.b(dVar2.a(f11, cVar.f9658c - f11, t0.e.d(jW)), 0.0f);
    }
}
