package o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: r0, reason: collision with root package name */
    public int f4184r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f4185s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f4186t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f4187u0;

    public final boolean O() {
        int i8;
        int i9;
        int i10;
        boolean z = true;
        int i11 = 0;
        while (true) {
            i8 = this.f4294q0;
            if (i11 >= i8) {
                break;
            }
            d dVar = this.f4293p0[i11];
            if ((this.f4185s0 || dVar.c()) && ((((i9 = this.f4184r0) == 0 || i9 == 1) && !dVar.x()) || (((i10 = this.f4184r0) == 2 || i10 == 3) && !dVar.y()))) {
                z = false;
            }
            i11++;
        }
        if (!z || i8 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i12 = 0; i12 < this.f4294q0; i12++) {
            d dVar2 = this.f4293p0[i12];
            if (this.f4185s0 || dVar2.c()) {
                if (!z2) {
                    int i13 = this.f4184r0;
                    if (i13 == 0) {
                        iMax = dVar2.i(2).d();
                    } else if (i13 == 1) {
                        iMax = dVar2.i(4).d();
                    } else if (i13 == 2) {
                        iMax = dVar2.i(3).d();
                    } else if (i13 == 3) {
                        iMax = dVar2.i(5).d();
                    }
                    z2 = true;
                }
                int i14 = this.f4184r0;
                if (i14 == 0) {
                    iMax = Math.min(iMax, dVar2.i(2).d());
                } else if (i14 == 1) {
                    iMax = Math.max(iMax, dVar2.i(4).d());
                } else if (i14 == 2) {
                    iMax = Math.min(iMax, dVar2.i(3).d());
                } else if (i14 == 3) {
                    iMax = Math.max(iMax, dVar2.i(5).d());
                }
            }
        }
        int i15 = iMax + this.f4186t0;
        int i16 = this.f4184r0;
        if (i16 == 0 || i16 == 1) {
            E(i15, i15);
        } else {
            F(i15, i15);
        }
        this.f4187u0 = true;
        return true;
    }

    public final int P() {
        int i8 = this.f4184r0;
        if (i8 == 0 || i8 == 1) {
            return 0;
        }
        return (i8 == 2 || i8 == 3) ? 1 : -1;
    }

    @Override // o.d
    public final void b(m.c cVar, boolean z) {
        boolean z2;
        int i8;
        int i9;
        c[] cVarArr = this.P;
        c cVar2 = this.H;
        cVarArr[0] = cVar2;
        int i10 = 2;
        c cVar3 = this.I;
        cVarArr[2] = cVar3;
        c cVar4 = this.J;
        cVarArr[1] = cVar4;
        c cVar5 = this.K;
        cVarArr[3] = cVar5;
        for (c cVar6 : cVarArr) {
            cVar6.f4211i = cVar.k(cVar6);
        }
        int i11 = this.f4184r0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        c cVar7 = cVarArr[i11];
        if (!this.f4187u0) {
            O();
        }
        if (this.f4187u0) {
            this.f4187u0 = false;
            int i12 = this.f4184r0;
            if (i12 == 0 || i12 == 1) {
                cVar.d(cVar2.f4211i, this.X);
                cVar.d(cVar4.f4211i, this.X);
                return;
            } else {
                if (i12 == 2 || i12 == 3) {
                    cVar.d(cVar3.f4211i, this.Y);
                    cVar.d(cVar5.f4211i, this.Y);
                    return;
                }
                return;
            }
        }
        for (int i13 = 0; i13 < this.f4294q0; i13++) {
            d dVar = this.f4293p0[i13];
            if ((this.f4185s0 || dVar.c()) && ((((i9 = this.f4184r0) == 0 || i9 == 1) && dVar.f4239o0[0] == 3 && dVar.H.f4208f != null && dVar.J.f4208f != null) || ((i9 == 2 || i9 == 3) && dVar.f4239o0[1] == 3 && dVar.I.f4208f != null && dVar.K.f4208f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z8 = cVar2.g() || cVar4.g();
        boolean z9 = cVar3.g() || cVar5.g();
        int i14 = !(!z2 && (((i8 = this.f4184r0) == 0 && z8) || ((i8 == 2 && z9) || ((i8 == 1 && z8) || (i8 == 3 && z9))))) ? 4 : 5;
        int i15 = 0;
        while (i15 < this.f4294q0) {
            d dVar2 = this.f4293p0[i15];
            if (this.f4185s0 || dVar2.c()) {
                m.g gVarK = cVar.k(dVar2.P[this.f4184r0]);
                c[] cVarArr2 = dVar2.P;
                int i16 = this.f4184r0;
                c cVar8 = cVarArr2[i16];
                cVar8.f4211i = gVarK;
                c cVar9 = cVar8.f4208f;
                int i17 = (cVar9 == null || cVar9.d != this) ? 0 : cVar8.f4209g;
                if (i16 == 0 || i16 == i10) {
                    m.g gVar = cVar7.f4211i;
                    int i18 = this.f4186t0 - i17;
                    m.b bVarL = cVar.l();
                    m.g gVarM = cVar.m();
                    gVarM.d = 0;
                    bVarL.c(gVar, gVarK, gVarM, i18);
                    cVar.c(bVarL);
                } else {
                    m.g gVar2 = cVar7.f4211i;
                    int i19 = this.f4186t0 + i17;
                    m.b bVarL2 = cVar.l();
                    m.g gVarM2 = cVar.m();
                    gVarM2.d = 0;
                    bVarL2.b(gVar2, gVarK, gVarM2, i19);
                    cVar.c(bVarL2);
                }
                cVar.e(cVar7.f4211i, gVarK, this.f4186t0 + i17, i14);
            }
            i15++;
            i10 = 2;
        }
        int i20 = this.f4184r0;
        if (i20 == 0) {
            cVar.e(cVar4.f4211i, cVar2.f4211i, 0, 8);
            cVar.e(cVar2.f4211i, this.S.J.f4211i, 0, 4);
            cVar.e(cVar2.f4211i, this.S.H.f4211i, 0, 0);
            return;
        }
        if (i20 == 1) {
            cVar.e(cVar2.f4211i, cVar4.f4211i, 0, 8);
            cVar.e(cVar2.f4211i, this.S.H.f4211i, 0, 4);
            cVar.e(cVar2.f4211i, this.S.J.f4211i, 0, 0);
        } else if (i20 == 2) {
            cVar.e(cVar5.f4211i, cVar3.f4211i, 0, 8);
            cVar.e(cVar3.f4211i, this.S.K.f4211i, 0, 4);
            cVar.e(cVar3.f4211i, this.S.I.f4211i, 0, 0);
        } else if (i20 == 3) {
            cVar.e(cVar3.f4211i, cVar5.f4211i, 0, 8);
            cVar.e(cVar3.f4211i, this.S.I.f4211i, 0, 4);
            cVar.e(cVar3.f4211i, this.S.K.f4211i, 0, 0);
        }
    }

    @Override // o.d
    public final boolean c() {
        return true;
    }

    @Override // o.d
    public final String toString() {
        String strF = m0.f.f(new StringBuilder("[Barrier] "), this.f4224g0, " {");
        for (int i8 = 0; i8 < this.f4294q0; i8++) {
            d dVar = this.f4293p0[i8];
            if (i8 > 0) {
                strF = a8.b.n(strF, ", ");
            }
            strF = strF + dVar.f4224g0;
        }
        return a8.b.n(strF, "}");
    }

    @Override // o.d
    public final boolean x() {
        return this.f4187u0;
    }

    @Override // o.d
    public final boolean y() {
        return this.f4187u0;
    }
}
