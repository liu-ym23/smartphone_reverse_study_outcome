package v;

import v.d;
import v.e;

/* renamed from: v.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1177a extends j {

    /* renamed from: N0, reason: collision with root package name */
    private int f22973N0 = 0;

    /* renamed from: O0, reason: collision with root package name */
    private boolean f22974O0 = true;

    /* renamed from: P0, reason: collision with root package name */
    private int f22975P0 = 0;

    /* renamed from: Q0, reason: collision with root package name */
    boolean f22976Q0 = false;

    public void A1(int i5) {
        this.f22973N0 = i5;
    }

    public void B1(int i5) {
        this.f22975P0 = i5;
    }

    @Override // v.e
    public void g(s.d dVar, boolean z5) {
        d[] dVarArr;
        boolean z6;
        int i5;
        int i6;
        int i7;
        d[] dVarArr2 = this.f23052W;
        dVarArr2[0] = this.f23044O;
        dVarArr2[2] = this.f23045P;
        dVarArr2[1] = this.f23046Q;
        dVarArr2[3] = this.f23047R;
        int i8 = 0;
        while (true) {
            dVarArr = this.f23052W;
            if (i8 >= dVarArr.length) {
                break;
            }
            d dVar2 = dVarArr[i8];
            dVar2.f23007i = dVar.q(dVar2);
            i8++;
        }
        int i9 = this.f22973N0;
        if (i9 < 0 || i9 >= 4) {
            return;
        }
        d dVar3 = dVarArr[i9];
        if (!this.f22976Q0) {
            t1();
        }
        if (this.f22976Q0) {
            this.f22976Q0 = false;
            int i10 = this.f22973N0;
            if (i10 == 0 || i10 == 1) {
                dVar.f(this.f23044O.f23007i, this.f23067f0);
                dVar.f(this.f23046Q.f23007i, this.f23067f0);
                return;
            } else {
                if (i10 == 2 || i10 == 3) {
                    dVar.f(this.f23045P.f23007i, this.f23069g0);
                    dVar.f(this.f23047R.f23007i, this.f23069g0);
                    return;
                }
                return;
            }
        }
        for (int i11 = 0; i11 < this.f23198M0; i11++) {
            e eVar = this.f23197L0[i11];
            if ((this.f22974O0 || eVar.h()) && ((((i6 = this.f22973N0) == 0 || i6 == 1) && eVar.A() == e.b.MATCH_CONSTRAINT && eVar.f23044O.f23004f != null && eVar.f23046Q.f23004f != null) || (((i7 = this.f22973N0) == 2 || i7 == 3) && eVar.T() == e.b.MATCH_CONSTRAINT && eVar.f23045P.f23004f != null && eVar.f23047R.f23004f != null))) {
                z6 = true;
                break;
            }
        }
        z6 = false;
        boolean z7 = this.f23044O.l() || this.f23046Q.l();
        boolean z8 = this.f23045P.l() || this.f23047R.l();
        int i12 = !(!z6 && (((i5 = this.f22973N0) == 0 && z7) || ((i5 == 2 && z8) || ((i5 == 1 && z7) || (i5 == 3 && z8))))) ? 4 : 5;
        for (int i13 = 0; i13 < this.f23198M0; i13++) {
            e eVar2 = this.f23197L0[i13];
            if (this.f22974O0 || eVar2.h()) {
                s.i iVarQ = dVar.q(eVar2.f23052W[this.f22973N0]);
                d[] dVarArr3 = eVar2.f23052W;
                int i14 = this.f22973N0;
                d dVar4 = dVarArr3[i14];
                dVar4.f23007i = iVarQ;
                d dVar5 = dVar4.f23004f;
                int i15 = (dVar5 == null || dVar5.f23002d != this) ? 0 : dVar4.f23005g;
                if (i14 == 0 || i14 == 2) {
                    dVar.i(dVar3.f23007i, iVarQ, this.f22975P0 - i15, z6);
                } else {
                    dVar.g(dVar3.f23007i, iVarQ, this.f22975P0 + i15, z6);
                }
                dVar.e(dVar3.f23007i, iVarQ, this.f22975P0 + i15, i12);
            }
        }
        int i16 = this.f22973N0;
        if (i16 == 0) {
            dVar.e(this.f23046Q.f23007i, this.f23044O.f23007i, 0, 8);
            dVar.e(this.f23044O.f23007i, this.f23057a0.f23046Q.f23007i, 0, 4);
            dVar.e(this.f23044O.f23007i, this.f23057a0.f23044O.f23007i, 0, 0);
            return;
        }
        if (i16 == 1) {
            dVar.e(this.f23044O.f23007i, this.f23046Q.f23007i, 0, 8);
            dVar.e(this.f23044O.f23007i, this.f23057a0.f23044O.f23007i, 0, 4);
            dVar.e(this.f23044O.f23007i, this.f23057a0.f23046Q.f23007i, 0, 0);
        } else if (i16 == 2) {
            dVar.e(this.f23047R.f23007i, this.f23045P.f23007i, 0, 8);
            dVar.e(this.f23045P.f23007i, this.f23057a0.f23047R.f23007i, 0, 4);
            dVar.e(this.f23045P.f23007i, this.f23057a0.f23045P.f23007i, 0, 0);
        } else if (i16 == 3) {
            dVar.e(this.f23045P.f23007i, this.f23047R.f23007i, 0, 8);
            dVar.e(this.f23045P.f23007i, this.f23057a0.f23045P.f23007i, 0, 4);
            dVar.e(this.f23045P.f23007i, this.f23057a0.f23047R.f23007i, 0, 0);
        }
    }

    @Override // v.e
    public boolean h() {
        return true;
    }

    @Override // v.e
    public boolean n0() {
        return this.f22976Q0;
    }

    @Override // v.e
    public boolean o0() {
        return this.f22976Q0;
    }

    public boolean t1() {
        int i5;
        int i6;
        int i7;
        boolean z5 = true;
        int i8 = 0;
        while (true) {
            i5 = this.f23198M0;
            if (i8 >= i5) {
                break;
            }
            e eVar = this.f23197L0[i8];
            if ((this.f22974O0 || eVar.h()) && ((((i6 = this.f22973N0) == 0 || i6 == 1) && !eVar.n0()) || (((i7 = this.f22973N0) == 2 || i7 == 3) && !eVar.o0()))) {
                z5 = false;
            }
            i8++;
        }
        if (!z5 || i5 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z6 = false;
        for (int i9 = 0; i9 < this.f23198M0; i9++) {
            e eVar2 = this.f23197L0[i9];
            if (this.f22974O0 || eVar2.h()) {
                if (!z6) {
                    int i10 = this.f22973N0;
                    if (i10 == 0) {
                        iMax = eVar2.o(d.b.LEFT).e();
                    } else if (i10 == 1) {
                        iMax = eVar2.o(d.b.RIGHT).e();
                    } else if (i10 == 2) {
                        iMax = eVar2.o(d.b.TOP).e();
                    } else if (i10 == 3) {
                        iMax = eVar2.o(d.b.BOTTOM).e();
                    }
                    z6 = true;
                }
                int i11 = this.f22973N0;
                if (i11 == 0) {
                    iMax = Math.min(iMax, eVar2.o(d.b.LEFT).e());
                } else if (i11 == 1) {
                    iMax = Math.max(iMax, eVar2.o(d.b.RIGHT).e());
                } else if (i11 == 2) {
                    iMax = Math.min(iMax, eVar2.o(d.b.TOP).e());
                } else if (i11 == 3) {
                    iMax = Math.max(iMax, eVar2.o(d.b.BOTTOM).e());
                }
            }
        }
        int i12 = iMax + this.f22975P0;
        int i13 = this.f22973N0;
        if (i13 == 0 || i13 == 1) {
            F0(i12, i12);
        } else {
            I0(i12, i12);
        }
        this.f22976Q0 = true;
        return true;
    }

    @Override // v.e
    public String toString() {
        String str = "[Barrier] " + t() + " {";
        for (int i5 = 0; i5 < this.f23198M0; i5++) {
            e eVar = this.f23197L0[i5];
            if (i5 > 0) {
                str = str + ", ";
            }
            str = str + eVar.t();
        }
        return str + "}";
    }

    public boolean u1() {
        return this.f22974O0;
    }

    public int v1() {
        return this.f22973N0;
    }

    public int w1() {
        return this.f22975P0;
    }

    public int x1() {
        int i5 = this.f22973N0;
        if (i5 == 0 || i5 == 1) {
            return 0;
        }
        return (i5 == 2 || i5 == 3) ? 1 : -1;
    }

    protected void y1() {
        for (int i5 = 0; i5 < this.f23198M0; i5++) {
            e eVar = this.f23197L0[i5];
            if (this.f22974O0 || eVar.h()) {
                int i6 = this.f22973N0;
                if (i6 == 0 || i6 == 1) {
                    eVar.S0(0, true);
                } else if (i6 == 2 || i6 == 3) {
                    eVar.S0(1, true);
                }
            }
        }
    }

    public void z1(boolean z5) {
        this.f22974O0 = z5;
    }
}
