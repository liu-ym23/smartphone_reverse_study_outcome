package v;

import androidx.room.AbstractC0351g;

/* renamed from: v.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0941a extends AbstractC0950j {

    /* renamed from: s0, reason: collision with root package name */
    public int f15494s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f15495t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f15496u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f15497v0;

    @Override // v.C0944d
    public final boolean B() {
        return this.f15497v0;
    }

    @Override // v.C0944d
    public final boolean C() {
        return this.f15497v0;
    }

    public final boolean T() {
        int i4;
        int i5;
        int i6;
        boolean z4 = true;
        int i7 = 0;
        while (true) {
            i4 = this.f15672r0;
            if (i7 >= i4) {
                break;
            }
            C0944d c0944d = this.f15671q0[i7];
            if ((this.f15495t0 || c0944d.d()) && ((((i5 = this.f15494s0) == 0 || i5 == 1) && !c0944d.B()) || (((i6 = this.f15494s0) == 2 || i6 == 3) && !c0944d.C()))) {
                z4 = false;
            }
            i7++;
        }
        if (!z4 || i4 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z5 = false;
        for (int i8 = 0; i8 < this.f15672r0; i8++) {
            C0944d c0944d2 = this.f15671q0[i8];
            if (this.f15495t0 || c0944d2.d()) {
                if (!z5) {
                    int i9 = this.f15494s0;
                    if (i9 == 0) {
                        iMax = c0944d2.j(2).d();
                    } else if (i9 == 1) {
                        iMax = c0944d2.j(4).d();
                    } else if (i9 == 2) {
                        iMax = c0944d2.j(3).d();
                    } else if (i9 == 3) {
                        iMax = c0944d2.j(5).d();
                    }
                    z5 = true;
                }
                int i10 = this.f15494s0;
                if (i10 == 0) {
                    iMax = Math.min(iMax, c0944d2.j(2).d());
                } else if (i10 == 1) {
                    iMax = Math.max(iMax, c0944d2.j(4).d());
                } else if (i10 == 2) {
                    iMax = Math.min(iMax, c0944d2.j(3).d());
                } else if (i10 == 3) {
                    iMax = Math.max(iMax, c0944d2.j(5).d());
                }
            }
        }
        int i11 = iMax + this.f15496u0;
        int i12 = this.f15494s0;
        if (i12 == 0 || i12 == 1) {
            K(i11, i11);
        } else {
            L(i11, i11);
        }
        this.f15497v0 = true;
        return true;
    }

    public final int U() {
        int i4 = this.f15494s0;
        if (i4 == 0 || i4 == 1) {
            return 0;
        }
        return (i4 == 2 || i4 == 3) ? 1 : -1;
    }

    @Override // v.C0944d
    public final void c(t.e eVar, boolean z4) {
        boolean z5;
        int i4;
        int i5;
        C0943c[] c0943cArr = this.f15540Q;
        C0943c c0943c = this.f15532I;
        c0943cArr[0] = c0943c;
        C0943c c0943c2 = this.f15533J;
        int i6 = 2;
        c0943cArr[2] = c0943c2;
        C0943c c0943c3 = this.f15534K;
        c0943cArr[1] = c0943c3;
        C0943c c0943c4 = this.f15535L;
        c0943cArr[3] = c0943c4;
        for (C0943c c0943c5 : c0943cArr) {
            c0943c5.f15523i = eVar.k(c0943c5);
        }
        int i7 = this.f15494s0;
        if (i7 < 0 || i7 >= 4) {
            return;
        }
        C0943c c0943c6 = c0943cArr[i7];
        if (!this.f15497v0) {
            T();
        }
        if (this.f15497v0) {
            this.f15497v0 = false;
            int i8 = this.f15494s0;
            if (i8 == 0 || i8 == 1) {
                eVar.d(c0943c.f15523i, this.f15547Y);
                eVar.d(c0943c3.f15523i, this.f15547Y);
                return;
            } else {
                if (i8 == 2 || i8 == 3) {
                    eVar.d(c0943c2.f15523i, this.f15548Z);
                    eVar.d(c0943c4.f15523i, this.f15548Z);
                    return;
                }
                return;
            }
        }
        for (int i9 = 0; i9 < this.f15672r0; i9++) {
            C0944d c0944d = this.f15671q0[i9];
            if ((this.f15495t0 || c0944d.d()) && ((((i5 = this.f15494s0) == 0 || i5 == 1) && c0944d.f15580p0[0] == 3 && c0944d.f15532I.f15520f != null && c0944d.f15534K.f15520f != null) || ((i5 == 2 || i5 == 3) && c0944d.f15580p0[1] == 3 && c0944d.f15533J.f15520f != null && c0944d.f15535L.f15520f != null))) {
                z5 = true;
                break;
            }
        }
        z5 = false;
        boolean z6 = c0943c.g() || c0943c3.g();
        boolean z7 = c0943c2.g() || c0943c4.g();
        int i10 = (z5 || !(((i4 = this.f15494s0) == 0 && z6) || ((i4 == 2 && z7) || ((i4 == 1 && z6) || (i4 == 3 && z7))))) ? 4 : 5;
        int i11 = 0;
        while (i11 < this.f15672r0) {
            C0944d c0944d2 = this.f15671q0[i11];
            if (this.f15495t0 || c0944d2.d()) {
                t.i iVarK = eVar.k(c0944d2.f15540Q[this.f15494s0]);
                int i12 = this.f15494s0;
                C0943c c0943c7 = c0944d2.f15540Q[i12];
                c0943c7.f15523i = iVarK;
                C0943c c0943c8 = c0943c7.f15520f;
                int i13 = (c0943c8 == null || c0943c8.f15518d != this) ? 0 : c0943c7.f15521g;
                if (i12 == 0 || i12 == i6) {
                    t.i iVar = c0943c6.f15523i;
                    int i14 = this.f15496u0 - i13;
                    t.c cVarL = eVar.l();
                    t.i iVarM = eVar.m();
                    iVarM.f15304d = 0;
                    cVarL.c(iVar, iVarK, iVarM, i14);
                    eVar.c(cVarL);
                } else {
                    t.i iVar2 = c0943c6.f15523i;
                    int i15 = this.f15496u0 + i13;
                    t.c cVarL2 = eVar.l();
                    t.i iVarM2 = eVar.m();
                    iVarM2.f15304d = 0;
                    cVarL2.b(iVar2, iVarK, iVarM2, i15);
                    eVar.c(cVarL2);
                }
                eVar.e(c0943c6.f15523i, iVarK, this.f15496u0 + i13, i10);
            }
            i11++;
            i6 = 2;
        }
        int i16 = this.f15494s0;
        if (i16 == 0) {
            eVar.e(c0943c3.f15523i, c0943c.f15523i, 0, 8);
            eVar.e(c0943c.f15523i, this.T.f15534K.f15523i, 0, 4);
            eVar.e(c0943c.f15523i, this.T.f15532I.f15523i, 0, 0);
            return;
        }
        if (i16 == 1) {
            eVar.e(c0943c.f15523i, c0943c3.f15523i, 0, 8);
            eVar.e(c0943c.f15523i, this.T.f15532I.f15523i, 0, 4);
            eVar.e(c0943c.f15523i, this.T.f15534K.f15523i, 0, 0);
        } else if (i16 == 2) {
            eVar.e(c0943c4.f15523i, c0943c2.f15523i, 0, 8);
            eVar.e(c0943c2.f15523i, this.T.f15535L.f15523i, 0, 4);
            eVar.e(c0943c2.f15523i, this.T.f15533J.f15523i, 0, 0);
        } else if (i16 == 3) {
            eVar.e(c0943c2.f15523i, c0943c4.f15523i, 0, 8);
            eVar.e(c0943c2.f15523i, this.T.f15533J.f15523i, 0, 4);
            eVar.e(c0943c2.f15523i, this.T.f15535L.f15523i, 0, 0);
        }
    }

    @Override // v.C0944d
    public final boolean d() {
        return true;
    }

    @Override // v.C0944d
    public final String toString() {
        String strR = B0.g.r(new StringBuilder("[Barrier] "), this.f15564h0, " {");
        for (int i4 = 0; i4 < this.f15672r0; i4++) {
            C0944d c0944d = this.f15671q0[i4];
            if (i4 > 0) {
                strR = AbstractC0351g.p(strR, ", ");
            }
            StringBuilder sbS = B0.g.s(strR);
            sbS.append(c0944d.f15564h0);
            strR = sbS.toString();
        }
        return AbstractC0351g.p(strR, "}");
    }
}
