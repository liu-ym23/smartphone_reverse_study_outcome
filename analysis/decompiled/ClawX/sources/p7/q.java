package p7;

import java.math.BigInteger;
import org.bouncycastle.asn1.BERTags;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4815g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(h hVar, m mVar, m mVar2, int i8) {
        super(hVar, mVar, mVar2);
        this.f4815g = i8;
    }

    private final r A(r rVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        if (this == rVar) {
            return x();
        }
        s7.p pVar = (s7.p) this.f4818b;
        s7.p pVar2 = (s7.p) this.f4819c;
        s7.p pVar3 = (s7.p) rVar.f4818b;
        s7.p pVar4 = (s7.p) rVar.h();
        s7.p pVar5 = (s7.p) this.d[0];
        s7.p pVar6 = (s7.p) rVar.i();
        int[] iArr5 = new int[14];
        int[] iArr6 = new int[7];
        int[] iArr7 = new int[7];
        int[] iArr8 = new int[7];
        int[] iArr9 = pVar5.f5341g;
        boolean zI0 = x.f.i0(iArr9);
        if (zI0) {
            iArr = pVar3.f5341g;
            iArr2 = pVar4.f5341g;
        } else {
            s7.b.l1(iArr9, iArr7);
            s7.b.o0(iArr7, pVar3.f5341g, iArr6);
            s7.b.o0(iArr7, iArr9, iArr7);
            s7.b.o0(iArr7, pVar4.f5341g, iArr7);
            iArr = iArr6;
            iArr2 = iArr7;
        }
        int[] iArr10 = pVar6.f5341g;
        boolean zI02 = x.f.i0(iArr10);
        if (zI02) {
            iArr3 = pVar.f5341g;
            iArr4 = pVar2.f5341g;
        } else {
            s7.b.l1(iArr10, iArr8);
            s7.b.o0(iArr8, pVar.f5341g, iArr5);
            s7.b.o0(iArr8, iArr10, iArr8);
            s7.b.o0(iArr8, pVar2.f5341g, iArr8);
            iArr3 = iArr5;
            iArr4 = iArr8;
        }
        int[] iArr11 = new int[7];
        s7.b.L1(iArr3, iArr, iArr11);
        s7.b.L1(iArr4, iArr2, iArr6);
        boolean zM0 = x.f.m0(iArr11);
        h hVar = this.f4817a;
        if (zM0) {
            return x.f.m0(iArr6) ? x() : hVar.m();
        }
        s7.b.l1(iArr11, iArr7);
        int[] iArr12 = new int[7];
        s7.b.o0(iArr7, iArr11, iArr12);
        s7.b.o0(iArr7, iArr3, iArr7);
        int[] iArr13 = s7.b.f5277s;
        int i8 = 0;
        for (int i9 = 0; i9 < 7; i9++) {
            i8 |= iArr12[i9];
        }
        if (((((i8 >>> 1) | (i8 & 1)) - 1) >> 31) != 0) {
            x.f.F0(iArr13, iArr13, iArr12);
        } else {
            x.f.F0(iArr13, iArr12, iArr12);
        }
        x.f.s0(iArr4, iArr12, iArr5);
        s7.b.X0(x.f.h(iArr7, iArr7, iArr12), iArr12);
        s7.p pVar7 = new s7.p(iArr8);
        s7.b.l1(iArr6, iArr8);
        s7.b.L1(iArr8, iArr12, iArr8);
        s7.p pVar8 = new s7.p(iArr12);
        s7.b.L1(iArr7, iArr8, iArr12);
        if ((x.f.u0(iArr12, iArr6, iArr5) != 0 || (iArr5[13] == -1 && x.f.X(14, iArr5, s7.b.f5278t))) && x.f.k(11, s7.b.f5279u, iArr5) != 0) {
            x.f.d0(14, 11, iArr5);
        }
        s7.b.J0(iArr5, iArr12);
        s7.p pVar9 = new s7.p(iArr11);
        if (!zI0) {
            s7.b.o0(iArr11, iArr9, iArr11);
        }
        if (!zI02) {
            s7.b.o0(iArr11, iArr10, iArr11);
        }
        return new q(hVar, pVar7, pVar8, new m[]{pVar9}, 10);
    }

    private final r B(r rVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        if (this == rVar) {
            return x();
        }
        s7.r rVar2 = (s7.r) this.f4818b;
        s7.r rVar3 = (s7.r) this.f4819c;
        s7.r rVar4 = (s7.r) rVar.f4818b;
        s7.r rVar5 = (s7.r) rVar.h();
        s7.r rVar6 = (s7.r) this.d[0];
        s7.r rVar7 = (s7.r) rVar.i();
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        int[] iArr7 = new int[8];
        int[] iArr8 = new int[8];
        int[] iArr9 = new int[8];
        int[] iArr10 = rVar6.f5349g;
        boolean zS = x.e.S(iArr10);
        if (zS) {
            iArr = rVar4.f5349g;
            iArr2 = rVar5.f5349g;
        } else {
            x.e.j0(iArr10, iArr5);
            s7.b.L0(iArr5, iArr8);
            s7.b.Z(iArr8, rVar4.f5349g, iArr7, iArr5);
            x.e.c0(iArr8, iArr10, iArr5);
            s7.b.L0(iArr5, iArr8);
            s7.b.Z(iArr8, rVar5.f5349g, iArr8, iArr5);
            iArr = iArr7;
            iArr2 = iArr8;
        }
        int[] iArr11 = rVar7.f5349g;
        boolean zS2 = x.e.S(iArr11);
        if (zS2) {
            iArr3 = rVar2.f5349g;
            iArr4 = rVar3.f5349g;
        } else {
            x.e.j0(iArr11, iArr5);
            s7.b.L0(iArr5, iArr9);
            s7.b.Z(iArr9, rVar2.f5349g, iArr6, iArr5);
            x.e.c0(iArr9, iArr11, iArr5);
            s7.b.L0(iArr5, iArr9);
            s7.b.Z(iArr9, rVar3.f5349g, iArr9, iArr5);
            iArr3 = iArr6;
            iArr4 = iArr9;
        }
        int[] iArr12 = new int[8];
        s7.b.M1(iArr3, iArr, iArr12);
        s7.b.M1(iArr4, iArr2, iArr7);
        boolean zW = x.e.W(iArr12);
        h hVar = this.f4817a;
        if (zW) {
            return x.e.W(iArr7) ? x() : hVar.m();
        }
        x.e.j0(iArr12, iArr5);
        s7.b.L0(iArr5, iArr8);
        int[] iArr13 = new int[8];
        x.e.c0(iArr8, iArr12, iArr5);
        s7.b.L0(iArr5, iArr13);
        x.e.c0(iArr8, iArr3, iArr5);
        s7.b.L0(iArr5, iArr8);
        int[] iArr14 = s7.b.f5280v;
        int i8 = 0;
        for (int i9 = 0; i9 < 8; i9++) {
            i8 |= iArr13[i9];
        }
        if (((((i8 >>> 1) | (i8 & 1)) - 1) >> 31) != 0) {
            x.e.p0(iArr14, iArr14, iArr13);
        } else {
            x.e.p0(iArr14, iArr13, iArr13);
        }
        x.e.c0(iArr4, iArr13, iArr6);
        s7.b.Y0(x.e.f(iArr8, iArr8, iArr13), iArr13);
        s7.r rVar8 = new s7.r(iArr9);
        x.e.j0(iArr7, iArr5);
        s7.b.L0(iArr5, iArr9);
        s7.b.M1(iArr9, iArr13, iArr9);
        s7.r rVar9 = new s7.r(iArr13);
        s7.b.M1(iArr8, iArr9, iArr13);
        if ((x.e.f0(iArr13, iArr7, iArr6) != 0 || (iArr6[15] == -1 && x.f.X(16, iArr6, s7.b.f5281w))) && x.f.k(10, s7.b.f5282x, iArr6) != 0) {
            x.f.d0(16, 10, iArr6);
        }
        s7.b.L0(iArr6, iArr13);
        s7.r rVar10 = new s7.r(iArr12);
        if (!zS) {
            s7.b.Z(iArr12, iArr10, iArr12, iArr5);
        }
        if (!zS2) {
            s7.b.Z(iArr12, iArr11, iArr12, iArr5);
        }
        return new q(hVar, rVar8, rVar9, new m[]{rVar10}, 11);
    }

    private final r C(r rVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        if (this == rVar) {
            return x();
        }
        s7.t tVar = (s7.t) this.f4818b;
        s7.t tVar2 = (s7.t) this.f4819c;
        s7.t tVar3 = (s7.t) rVar.f4818b;
        s7.t tVar4 = (s7.t) rVar.h();
        s7.t tVar5 = (s7.t) this.d[0];
        s7.t tVar6 = (s7.t) rVar.i();
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        int[] iArr7 = new int[8];
        int[] iArr8 = new int[8];
        int[] iArr9 = new int[8];
        int[] iArr10 = tVar5.f5358g;
        boolean zS = x.e.S(iArr10);
        if (zS) {
            iArr = tVar3.f5358g;
            iArr2 = tVar4.f5358g;
        } else {
            x.e.j0(iArr10, iArr5);
            s7.b.N0(iArr5, iArr8);
            s7.b.c0(iArr8, tVar3.f5358g, iArr7, iArr5);
            x.e.c0(iArr8, iArr10, iArr5);
            s7.b.N0(iArr5, iArr8);
            s7.b.c0(iArr8, tVar4.f5358g, iArr8, iArr5);
            iArr = iArr7;
            iArr2 = iArr8;
        }
        int[] iArr11 = tVar6.f5358g;
        boolean zS2 = x.e.S(iArr11);
        if (zS2) {
            iArr3 = tVar.f5358g;
            iArr4 = tVar2.f5358g;
        } else {
            x.e.j0(iArr11, iArr5);
            s7.b.N0(iArr5, iArr9);
            s7.b.c0(iArr9, tVar.f5358g, iArr6, iArr5);
            x.e.c0(iArr9, iArr11, iArr5);
            s7.b.N0(iArr5, iArr9);
            s7.b.c0(iArr9, tVar2.f5358g, iArr9, iArr5);
            iArr3 = iArr6;
            iArr4 = iArr9;
        }
        int[] iArr12 = new int[8];
        s7.b.N1(iArr3, iArr, iArr12);
        s7.b.N1(iArr4, iArr2, iArr7);
        boolean zW = x.e.W(iArr12);
        h hVar = this.f4817a;
        if (zW) {
            return x.e.W(iArr7) ? x() : hVar.m();
        }
        x.e.j0(iArr12, iArr5);
        s7.b.N0(iArr5, iArr8);
        int[] iArr13 = new int[8];
        x.e.c0(iArr8, iArr12, iArr5);
        s7.b.N0(iArr5, iArr13);
        x.e.c0(iArr8, iArr3, iArr5);
        s7.b.N0(iArr5, iArr8);
        int[] iArr14 = s7.b.y;
        int i8 = 0;
        for (int i9 = 0; i9 < 8; i9++) {
            i8 |= iArr13[i9];
        }
        if (((((i8 >>> 1) | (i8 & 1)) - 1) >> 31) != 0) {
            x.e.p0(iArr14, iArr14, iArr13);
        } else {
            x.e.p0(iArr14, iArr13, iArr13);
        }
        x.e.c0(iArr4, iArr13, iArr6);
        s7.b.Z0(x.e.f(iArr8, iArr8, iArr13), iArr13);
        s7.t tVar7 = new s7.t(iArr9);
        x.e.j0(iArr7, iArr5);
        s7.b.N0(iArr5, iArr9);
        s7.b.N1(iArr9, iArr13, iArr9);
        s7.t tVar8 = new s7.t(iArr13);
        s7.b.N1(iArr8, iArr9, iArr13);
        int[] iArr15 = s7.b.z;
        if (x.e.f0(iArr13, iArr7, iArr6) != 0 || ((iArr6[15] >>> 1) >= Integer.MAX_VALUE && x.f.X(16, iArr6, iArr15))) {
            x.f.I0(16, iArr15, iArr6);
        }
        s7.b.N0(iArr6, iArr13);
        s7.t tVar9 = new s7.t(iArr12);
        if (!zS) {
            s7.b.c0(iArr12, iArr10, iArr12, iArr5);
        }
        if (!zS2) {
            s7.b.c0(iArr12, iArr11, iArr12, iArr5);
        }
        return new q(hVar, tVar7, tVar8, new m[]{tVar9}, 12);
    }

    private final r D(r rVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i8;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        if (this == rVar) {
            return x();
        }
        s7.v vVar = (s7.v) this.f4818b;
        s7.v vVar2 = (s7.v) this.f4819c;
        s7.v vVar3 = (s7.v) rVar.f4818b;
        s7.v vVar4 = (s7.v) rVar.h();
        s7.v vVar5 = (s7.v) this.d[0];
        s7.v vVar6 = (s7.v) rVar.i();
        int[] iArr5 = new int[24];
        int[] iArr6 = new int[24];
        int[] iArr7 = new int[24];
        int[] iArr8 = new int[12];
        int[] iArr9 = new int[12];
        boolean zH = vVar5.h();
        int[] iArr10 = vVar5.f5366g;
        if (zH) {
            iArr = vVar3.f5366g;
            iArr2 = vVar4.f5366g;
        } else {
            x.e.k0(iArr10, iArr5);
            s7.b.P0(iArr5, iArr8);
            s7.b.f0(iArr8, vVar3.f5366g, iArr7, iArr5);
            x.e.d0(iArr8, iArr10, iArr5);
            s7.b.P0(iArr5, iArr8);
            s7.b.f0(iArr8, vVar4.f5366g, iArr8, iArr5);
            iArr = iArr7;
            iArr2 = iArr8;
        }
        boolean zH2 = vVar6.h();
        int[] iArr11 = vVar6.f5366g;
        if (zH2) {
            iArr3 = vVar.f5366g;
            iArr4 = vVar2.f5366g;
        } else {
            x.e.k0(iArr11, iArr5);
            s7.b.P0(iArr5, iArr9);
            s7.b.f0(iArr9, vVar.f5366g, iArr6, iArr5);
            x.e.d0(iArr9, iArr11, iArr5);
            s7.b.P0(iArr5, iArr9);
            s7.b.f0(iArr9, vVar2.f5366g, iArr9, iArr5);
            iArr3 = iArr6;
            iArr4 = iArr9;
        }
        int[] iArr12 = new int[12];
        s7.b.O1(iArr3, iArr, iArr12);
        int[] iArr13 = new int[12];
        s7.b.O1(iArr4, iArr2, iArr13);
        boolean zK0 = x.f.k0(12, iArr12);
        h hVar = this.f4817a;
        if (zK0) {
            return x.f.k0(12, iArr13) ? x() : hVar.m();
        }
        x.e.k0(iArr12, iArr5);
        s7.b.P0(iArr5, iArr8);
        int[] iArr14 = new int[12];
        x.e.d0(iArr8, iArr12, iArr5);
        s7.b.P0(iArr5, iArr14);
        s7.b.f0(iArr8, iArr3, iArr8, iArr5);
        int[] iArr15 = s7.b.A;
        int i9 = 0;
        for (int i10 = 0; i10 < 12; i10++) {
            i9 |= iArr14[i10];
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            i8 = 12;
            x.f.C0(iArr15, iArr15, 12, iArr14);
        } else {
            i8 = 12;
            x.f.C0(iArr15, iArr14, 12, iArr14);
        }
        x.e.d0(iArr4, iArr14, iArr6);
        s7.b.a1(x.f.f(iArr8, iArr8, i8, iArr14), iArr14);
        s7.v vVar7 = new s7.v(iArr9);
        x.e.k0(iArr13, iArr5);
        s7.b.P0(iArr5, iArr9);
        s7.b.O1(iArr9, iArr14, iArr9);
        s7.v vVar8 = new s7.v(iArr14);
        s7.b.O1(iArr8, iArr9, iArr14);
        x.e.d0(iArr14, iArr13, iArr7);
        if ((x.f.a(iArr6, iArr7, 24, iArr6) != 0 || (iArr6[23] == -1 && x.f.X(24, iArr6, s7.b.B))) && x.f.k(17, s7.b.C, iArr6) != 0) {
            x.f.d0(24, 17, iArr6);
        }
        s7.b.P0(iArr6, iArr14);
        s7.v vVar9 = new s7.v(iArr12);
        if (!zH) {
            s7.b.f0(iArr12, iArr10, iArr12, iArr5);
        }
        if (!zH2) {
            s7.b.f0(iArr12, iArr11, iArr12, iArr5);
        }
        return new q(hVar, vVar7, vVar8, new m[]{vVar9}, 13);
    }

    private final r z(r rVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        if (this == rVar) {
            return x();
        }
        s7.n nVar = (s7.n) this.f4818b;
        s7.n nVar2 = (s7.n) this.f4819c;
        s7.n nVar3 = (s7.n) rVar.f4818b;
        s7.n nVar4 = (s7.n) rVar.h();
        s7.n nVar5 = (s7.n) this.d[0];
        s7.n nVar6 = (s7.n) rVar.i();
        int[] iArr5 = new int[14];
        int[] iArr6 = new int[7];
        int[] iArr7 = new int[7];
        int[] iArr8 = new int[7];
        int[] iArr9 = nVar5.f5333g;
        boolean zI0 = x.f.i0(iArr9);
        if (zI0) {
            iArr = nVar3.f5333g;
            iArr2 = nVar4.f5333g;
        } else {
            s7.b.k1(iArr9, iArr7);
            s7.b.m0(iArr7, nVar3.f5333g, iArr6);
            s7.b.m0(iArr7, iArr9, iArr7);
            s7.b.m0(iArr7, nVar4.f5333g, iArr7);
            iArr = iArr6;
            iArr2 = iArr7;
        }
        int[] iArr10 = nVar6.f5333g;
        boolean zI02 = x.f.i0(iArr10);
        if (zI02) {
            iArr3 = nVar.f5333g;
            iArr4 = nVar2.f5333g;
        } else {
            s7.b.k1(iArr10, iArr8);
            s7.b.m0(iArr8, nVar.f5333g, iArr5);
            s7.b.m0(iArr8, iArr10, iArr8);
            s7.b.m0(iArr8, nVar2.f5333g, iArr8);
            iArr3 = iArr5;
            iArr4 = iArr8;
        }
        int[] iArr11 = new int[7];
        s7.b.K1(iArr3, iArr, iArr11);
        s7.b.K1(iArr4, iArr2, iArr6);
        boolean zM0 = x.f.m0(iArr11);
        h hVar = this.f4817a;
        if (zM0) {
            return x.f.m0(iArr6) ? x() : hVar.m();
        }
        s7.b.k1(iArr11, iArr7);
        int[] iArr12 = new int[7];
        s7.b.m0(iArr7, iArr11, iArr12);
        s7.b.m0(iArr7, iArr3, iArr7);
        int[] iArr13 = s7.b.f5274p;
        int i8 = 0;
        for (int i9 = 0; i9 < 7; i9++) {
            i8 |= iArr12[i9];
        }
        if (((((i8 >>> 1) | (i8 & 1)) - 1) >> 31) != 0) {
            x.f.F0(iArr13, iArr13, iArr12);
        } else {
            x.f.F0(iArr13, iArr12, iArr12);
        }
        x.f.s0(iArr4, iArr12, iArr5);
        s7.b.W0(x.f.h(iArr7, iArr7, iArr12), iArr12);
        s7.n nVar7 = new s7.n(iArr8);
        s7.b.k1(iArr6, iArr8);
        s7.b.K1(iArr8, iArr12, iArr8);
        s7.n nVar8 = new s7.n(iArr12);
        s7.b.K1(iArr7, iArr8, iArr12);
        if ((x.f.u0(iArr12, iArr6, iArr5) != 0 || (iArr5[13] == -1 && x.f.X(14, iArr5, s7.b.f5275q))) && x.f.k(9, s7.b.f5276r, iArr5) != 0) {
            x.f.d0(14, 9, iArr5);
        }
        s7.b.H0(iArr5, iArr12);
        s7.n nVar9 = new s7.n(iArr11);
        if (!zI0) {
            s7.b.m0(iArr11, iArr9, iArr11);
        }
        if (!zI02) {
            s7.b.m0(iArr11, iArr10, iArr11);
        }
        return new q(hVar, nVar7, nVar8, new m[]{nVar9}, 9);
    }

    public m E(m mVar, m mVar2) {
        m mVar3 = this.f4817a.f4798b;
        if (mVar3.i() || mVar.h()) {
            return mVar3;
        }
        if (mVar2 == null) {
            mVar2 = mVar.o();
        }
        m mVarO = mVar2.o();
        m mVarM = mVar3.m();
        return mVarM.c() < mVar3.c() ? mVarO.j(mVarM).m() : mVarO.j(mVar3);
    }

    public q7.d F(q7.d dVar, int[] iArr) {
        q7.d dVar2 = (q7.d) this.f4817a.f4798b;
        if (x.e.S(dVar.f4902g)) {
            return dVar2;
        }
        q7.d dVar3 = new q7.d();
        int[] iArr2 = new int[8];
        dVar3.f4902g = iArr2;
        if (iArr == null) {
            q7.c.d(dVar.f4902g, iArr2);
            iArr = iArr2;
        }
        q7.c.d(iArr, iArr2);
        q7.c.a(iArr2, dVar2.f4902g, iArr2);
        return dVar3;
    }

    public m G() {
        m[] mVarArr = this.d;
        m mVar = mVarArr[1];
        if (mVar != null) {
            return mVar;
        }
        m mVarE = E(mVarArr[0], null);
        mVarArr[1] = mVarE;
        return mVarE;
    }

    public q H(boolean z) {
        m mVarA;
        m mVar = this.d[0];
        m mVarG = G();
        m mVar2 = this.f4818b;
        m mVarO = mVar2.o();
        m mVarA2 = mVarO.a(mVarO).a(mVarO).a(mVarG);
        m mVar3 = this.f4819c;
        m mVarA3 = mVar3.a(mVar3);
        m mVarJ = mVarA3.j(mVar3);
        m mVarJ2 = mVar2.j(mVarJ);
        m mVarA4 = mVarJ2.a(mVarJ2);
        m mVarR = mVarA2.o().r(mVarA4.a(mVarA4));
        m mVarO2 = mVarJ.o();
        m mVarA5 = mVarO2.a(mVarO2);
        m mVarR2 = mVarA2.j(mVarA4.r(mVarR)).r(mVarA5);
        if (z) {
            m mVarJ3 = mVarA5.j(mVarG);
            mVarA = mVarJ3.a(mVarJ3);
        } else {
            mVarA = null;
        }
        if (!mVar.h()) {
            mVarA3 = mVarA3.j(mVar);
        }
        return new q(this.f4817a, mVarR, mVarR2, new m[]{mVarA3, mVarA}, 0);
    }

    public q I(boolean z) {
        q7.d dVar;
        q7.d dVar2 = (q7.d) this.f4818b;
        q7.d dVar3 = (q7.d) this.f4819c;
        m[] mVarArr = this.d;
        m mVar = mVarArr[0];
        q7.d dVar4 = (q7.d) mVar;
        q7.d dVarF = (q7.d) mVarArr[1];
        if (dVarF == null) {
            dVarF = F((q7.d) mVar, null);
            mVarArr[1] = dVarF;
        }
        int[] iArr = {(int) j, (int) j, (int) j, (int) j, (int) j, (int) j, (int) j, (int) j};
        q7.c.d(dVar2.f4902g, iArr);
        int iF = x.e.f(iArr, iArr, iArr);
        int[] iArr2 = dVarF.f4902g;
        long j4 = (iArr2[0] & 4294967295L) + (iArr[0] & 4294967295L);
        long j8 = (iArr2[1] & 4294967295L) + (iArr[1] & 4294967295L) + (j4 >>> 32);
        long j9 = (iArr2[2] & 4294967295L) + (iArr[2] & 4294967295L) + (j8 >>> 32);
        long j10 = (iArr2[3] & 4294967295L) + (iArr[3] & 4294967295L) + (j9 >>> 32);
        long j11 = (iArr2[4] & 4294967295L) + (iArr[4] & 4294967295L) + (j10 >>> 32);
        long j12 = (iArr2[5] & 4294967295L) + (iArr[5] & 4294967295L) + (j11 >>> 32);
        long j13 = (iArr2[6] & 4294967295L) + (iArr[6] & 4294967295L) + (j12 >>> 32);
        long j14 = (iArr2[7] & 4294967295L) + (iArr[7] & 4294967295L) + (j13 >>> 32);
        q7.c.c(iF + ((int) (j14 >>> 32)), iArr);
        int[] iArr3 = new int[8];
        q7.c.h(dVar3.f4902g, iArr3);
        int[] iArr4 = new int[8];
        q7.c.a(iArr3, dVar3.f4902g, iArr4);
        int[] iArr5 = new int[8];
        q7.c.a(iArr4, dVar2.f4902g, iArr5);
        q7.c.h(iArr5, iArr5);
        int[] iArr6 = new int[8];
        q7.c.d(iArr4, iArr6);
        q7.c.h(iArr6, iArr6);
        q7.d dVar5 = new q7.d(iArr4);
        q7.c.d(iArr, iArr4);
        q7.c.g(iArr4, iArr5, iArr4);
        q7.c.g(iArr4, iArr5, iArr4);
        q7.d dVar6 = new q7.d(iArr5);
        q7.c.g(iArr5, iArr4, iArr5);
        q7.c.a(iArr5, iArr, iArr5);
        q7.c.g(iArr5, iArr6, iArr5);
        q7.d dVar7 = new q7.d(iArr3);
        if (!x.e.S(dVar4.f4902g)) {
            q7.c.a(iArr3, dVar4.f4902g, iArr3);
        }
        if (z) {
            dVar = new q7.d(iArr6);
            q7.c.a(iArr6, dVarF.f4902g, iArr6);
            q7.c.h(iArr6, iArr6);
        } else {
            dVar = null;
        }
        return new q(this.f4817a, dVar5, dVar6, new m[]{dVar7, dVar}, 1);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // p7.r
    public final p7.r a(p7.r r39) {
        /*
            Method dump skipped, instructions count: 3508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.q.a(p7.r):p7.r");
    }

    @Override // p7.r
    public final boolean e() {
        return d().s();
    }

    @Override // p7.r
    public final r n() {
        switch (this.f4815g) {
            case 0:
                if (k()) {
                    return this;
                }
                h hVar = this.f4817a;
                int i8 = hVar.f4801f;
                m mVar = this.f4819c;
                m mVar2 = this.f4818b;
                return i8 != 0 ? new q(hVar, mVar2, mVar.m(), this.d, 0) : new q(hVar, mVar2, mVar.m(), 0);
            case 1:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 1);
            case 2:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 2);
            case 3:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 3);
            case 4:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 4);
            case 5:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 5);
            case 6:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 6);
            case 7:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 7);
            case 8:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 8);
            case 9:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 9);
            case 10:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 10);
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 11);
            case 12:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 12);
            case BERTags.RELATIVE_OID /* 13 */:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 13);
            default:
                if (k()) {
                    return this;
                }
                return new q(this.f4817a, this.f4818b, this.f4819c.m(), this.d, 14);
        }
    }

    @Override // p7.r
    public final boolean q() {
        h hVar = this.f4817a;
        m mVarJ = hVar.f4798b;
        m mVarJ2 = hVar.f4799c;
        m mVarO = this.f4819c.o();
        int iF = f();
        if (iF != 0) {
            m[] mVarArr = this.d;
            if (iF == 1) {
                m mVar = mVarArr[0];
                if (!mVar.h()) {
                    m mVarO2 = mVar.o();
                    m mVarJ3 = mVar.j(mVarO2);
                    mVarO = mVarO.j(mVar);
                    mVarJ = mVarJ.j(mVarO2);
                    mVarJ2 = mVarJ2.j(mVarJ3);
                }
            } else {
                if (iF != 2 && iF != 3 && iF != 4) {
                    throw new IllegalStateException("unsupported coordinate system");
                }
                m mVar2 = mVarArr[0];
                if (!mVar2.h()) {
                    m mVarO3 = mVar2.o();
                    m mVarO4 = mVarO3.o();
                    m mVarJ4 = mVarO3.j(mVarO4);
                    mVarJ = mVarJ.j(mVarO4);
                    mVarJ2 = mVarJ2.j(mVarJ4);
                }
            }
        }
        m mVar3 = this.f4818b;
        return mVarO.equals(mVar3.o().a(mVarJ).j(mVar3).a(mVarJ2));
    }

    @Override // p7.r
    public final r u(r rVar) {
        return rVar.k() ? this : a(rVar.n());
    }

    @Override // p7.r
    public final r v() {
        switch (this.f4815g) {
            case 0:
                if (!k()) {
                    m mVar = this.f4819c;
                    if (!mVar.i()) {
                        h hVar = this.f4817a;
                        int i8 = hVar.f4801f;
                        if (i8 == 0) {
                            m mVarA = mVar.a(mVar);
                            m mVarO = mVarA.o();
                            m mVar2 = this.f4818b;
                            m mVarO2 = mVar2.o();
                            m mVarA2 = mVarO2.a(mVarO2).a(mVarO2).a(hVar.f4798b);
                            m mVarR = mVar2.a(mVar2).a(mVar2).j(mVarO).r(mVarA2.o());
                            if (!mVarR.i()) {
                                m mVarG = mVarR.j(mVarA).g();
                                m mVarJ = mVarR.j(mVarG).j(mVarA2);
                                m mVarR2 = mVarO.o().j(mVarG).r(mVarJ);
                                m mVarA3 = mVarR2.r(mVarJ).j(mVarJ.a(mVarR2)).a(mVar2);
                                break;
                            } else {
                                break;
                            }
                        } else if (i8 == 4) {
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case 1:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 2:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 3:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 4:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 5:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 6:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 7:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 8:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 9:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 10:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case 12:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
            default:
                if (!k() && !this.f4819c.i()) {
                    break;
                }
                break;
        }
        return x().a(this);
    }

    @Override // p7.r
    public r w(int i8) {
        q qVar;
        m mVarO;
        switch (this.f4815g) {
            case 0:
                if (i8 < 0) {
                    throw new IllegalArgumentException("'e' cannot be negative");
                }
                if (i8 == 0 || k()) {
                    return this;
                }
                if (i8 == 1) {
                    return x();
                }
                m mVarJ = this.f4819c;
                boolean zI = mVarJ.i();
                h hVar = this.f4817a;
                if (!zI) {
                    int i9 = hVar.f4801f;
                    m mVarA = hVar.f4798b;
                    m[] mVarArr = this.d;
                    int i10 = 0;
                    m mVarJ2 = mVarArr.length < 1 ? hVar.j(a.f4758b) : mVarArr[0];
                    boolean zH = mVarJ2.h();
                    m mVarJ3 = this.f4818b;
                    if (!zH && i9 != 0) {
                        if (i9 == 1) {
                            mVarO = mVarJ2.o();
                            mVarJ3 = mVarJ3.j(mVarJ2);
                            mVarJ = mVarJ.j(mVarO);
                        } else if (i9 == 2) {
                            mVarO = null;
                        } else {
                            if (i9 != 4) {
                                throw new IllegalStateException("unsupported coordinate system");
                            }
                            mVarA = G();
                        }
                        mVarA = E(mVarJ2, mVarO);
                    }
                    m mVarR = mVarJ;
                    while (i10 < i8) {
                        if (!mVarR.i()) {
                            m mVarO2 = mVarJ3.o();
                            m mVarA2 = mVarO2.a(mVarO2).a(mVarO2);
                            m mVarA3 = mVarR.a(mVarR);
                            m mVarJ4 = mVarA3.j(mVarR);
                            m mVarJ5 = mVarJ3.j(mVarJ4);
                            m mVarA4 = mVarJ5.a(mVarJ5);
                            m mVarO3 = mVarJ4.o();
                            m mVarA5 = mVarO3.a(mVarO3);
                            if (!mVarA.i()) {
                                mVarA2 = mVarA2.a(mVarA);
                                m mVarJ6 = mVarA5.j(mVarA);
                                mVarA = mVarJ6.a(mVarJ6);
                            }
                            m mVarR2 = mVarA2.o().r(mVarA4.a(mVarA4));
                            mVarR = mVarA2.j(mVarA4.r(mVarR2)).r(mVarA5);
                            mVarJ2 = mVarJ2.h() ? mVarA3 : mVarA3.j(mVarJ2);
                            i10++;
                            mVarJ3 = mVarR2;
                        }
                    }
                    if (i9 == 0) {
                        m mVarG = mVarJ2.g();
                        m mVarO4 = mVarG.o();
                        return new q(hVar, mVarJ3.j(mVarO4), mVarR.j(mVarO4.j(mVarG)), 0);
                    }
                    if (i9 == 1) {
                        m mVar = mVarJ2;
                        qVar = new q(hVar, mVarJ3.j(mVar), mVarR, new m[]{mVar.j(mVar.o())}, 0);
                    } else {
                        if (i9 != 2) {
                            if (i9 == 4) {
                                return new q(hVar, mVarJ3, mVarR, new m[]{mVarJ2, mVarA}, 0);
                            }
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                        qVar = new q(hVar, mVarJ3, mVarR, new m[]{mVarJ2}, 0);
                    }
                    return qVar;
                }
                return hVar.m();
            default:
                return super.w(i8);
        }
    }

    @Override // p7.r
    public final r x() {
        q qVar;
        m mVarR;
        m mVarJ;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        int[] iArr9;
        int i8 = this.f4815g;
        m[] mVarArr = this.d;
        m mVar = this.f4818b;
        m mVar2 = this.f4819c;
        int i9 = 0;
        switch (i8) {
            case 0:
                if (k()) {
                    return this;
                }
                boolean zI = mVar2.i();
                h hVar = this.f4817a;
                if (zI) {
                    return hVar.m();
                }
                int i10 = hVar.f4801f;
                if (i10 == 0) {
                    m mVarO = mVar.o();
                    m mVarD = mVarO.a(mVarO).a(mVarO).a(hVar.f4798b).d(mVar2.a(mVar2));
                    m mVarR2 = mVarD.o().r(mVar.a(mVar));
                    qVar = new q(hVar, mVarR2, mVarD.j(mVar.r(mVarR2)).r(mVar2), i9);
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 4) {
                                return H(true);
                            }
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                        m mVar3 = mVarArr[0];
                        boolean zH = mVar3.h();
                        m mVarO2 = mVar2.o();
                        m mVarO3 = mVarO2.o();
                        m mVarJ2 = hVar.f4798b;
                        m mVarM = mVarJ2.m();
                        if (mVarM.t().equals(BigInteger.valueOf(3L))) {
                            m mVarO4 = zH ? mVar3 : mVar3.o();
                            m mVarJ3 = mVar.a(mVarO4).j(mVar.r(mVarO4));
                            mVarR = mVarJ3.a(mVarJ3).a(mVarJ3);
                            mVarJ = mVarO2.j(mVar);
                        } else {
                            m mVarO5 = mVar.o();
                            m mVarA = mVarO5.a(mVarO5).a(mVarO5);
                            if (zH) {
                                mVarR = mVarA.a(mVarJ2);
                                mVarJ = mVar.j(mVarO2);
                            } else {
                                if (mVarJ2.i()) {
                                    mVarR = mVarA;
                                } else {
                                    m mVarO6 = mVar3.o().o();
                                    if (mVarM.c() < mVarJ2.c()) {
                                        mVarR = mVarA.r(mVarO6.j(mVarM));
                                    } else {
                                        mVarJ2 = mVarO6.j(mVarJ2);
                                        mVarR = mVarA.a(mVarJ2);
                                    }
                                }
                                mVarJ = mVar.j(mVarO2);
                            }
                        }
                        m mVarA2 = mVarJ.a(mVarJ);
                        m mVarA3 = mVarA2.a(mVarA2);
                        m mVarR3 = mVarR.o().r(mVarA3.a(mVarA3));
                        m mVarJ4 = mVarA3.r(mVarR3).j(mVarR);
                        m mVarA4 = mVarO3.a(mVarO3);
                        m mVarA5 = mVarA4.a(mVarA4);
                        m mVarR4 = mVarJ4.r(mVarA5.a(mVarA5));
                        m mVarA6 = mVar2.a(mVar2);
                        if (!zH) {
                            mVarA6 = mVarA6.j(mVar3);
                        }
                        return new q(hVar, mVarR3, mVarR4, new m[]{mVarA6}, 0);
                    }
                    m mVar4 = mVarArr[0];
                    boolean zH2 = mVar4.h();
                    m mVarJ5 = hVar.f4798b;
                    if (!mVarJ5.i() && !zH2) {
                        mVarJ5 = mVarJ5.j(mVar4.o());
                    }
                    m mVarO7 = mVar.o();
                    m mVarA7 = mVarJ5.a(mVarO7.a(mVarO7).a(mVarO7));
                    m mVarJ6 = zH2 ? mVar2 : mVar2.j(mVar4);
                    m mVarO8 = zH2 ? mVar2.o() : mVarJ6.j(mVar2);
                    m mVarJ7 = mVar.j(mVarO8);
                    m mVarA8 = mVarJ7.a(mVarJ7);
                    m mVarA9 = mVarA8.a(mVarA8);
                    m mVarR5 = mVarA7.o().r(mVarA9.a(mVarA9));
                    m mVarA10 = mVarJ6.a(mVarJ6);
                    m mVarJ8 = mVarR5.j(mVarA10);
                    m mVarA11 = mVarO8.a(mVarO8);
                    m mVarJ9 = mVarA9.r(mVarR5).j(mVarA7);
                    m mVarO9 = mVarA11.o();
                    m mVarR6 = mVarJ9.r(mVarO9.a(mVarO9));
                    m mVarA12 = zH2 ? mVarA11.a(mVarA11) : mVarA10.o();
                    qVar = new q(hVar, mVarJ8, mVarR6, new m[]{mVarA12.a(mVarA12).j(mVarJ6)}, 0);
                }
                return qVar;
            case 1:
                return k() ? this : mVar2.i() ? this.f4817a.m() : I(true);
            case 2:
                if (k()) {
                    return this;
                }
                int[] iArr10 = ((r7.c) mVar2).f5227g;
                boolean zW = x.e.W(iArr10);
                h hVar2 = this.f4817a;
                if (zW) {
                    return hVar2.m();
                }
                r7.c cVar = (r7.c) mVar;
                r7.c cVar2 = (r7.c) mVarArr[0];
                int[] iArr11 = new int[8];
                int[] iArr12 = new int[8];
                int[] iArr13 = new int[8];
                r7.b.f(iArr10, iArr13);
                int[] iArr14 = new int[8];
                r7.b.f(iArr13, iArr14);
                int[] iArr15 = cVar2.f5227g;
                boolean zS = x.e.S(iArr15);
                if (zS) {
                    iArr = iArr15;
                } else {
                    r7.b.f(iArr15, iArr12);
                    iArr = iArr12;
                }
                int[] iArr16 = cVar.f5227g;
                r7.b.h(iArr16, iArr, iArr11);
                r7.b.a(iArr16, iArr, iArr12);
                r7.b.c(iArr12, iArr11, iArr12);
                r7.b.e(x.e.f(iArr12, iArr12, iArr12), iArr12);
                r7.b.c(iArr13, iArr16, iArr13);
                r7.b.e(x.f.y0(8, iArr13), iArr13);
                r7.b.e(x.f.z0(8, iArr14, iArr11), iArr11);
                r7.c cVar3 = new r7.c(iArr14);
                r7.b.f(iArr12, iArr14);
                r7.b.h(iArr14, iArr13, iArr14);
                r7.b.h(iArr14, iArr13, iArr14);
                r7.c cVar4 = new r7.c(iArr13);
                r7.b.h(iArr13, iArr14, iArr13);
                r7.b.c(iArr13, iArr12, iArr13);
                r7.b.h(iArr13, iArr11, iArr13);
                r7.c cVar5 = new r7.c(iArr12);
                if (x.f.x0(8, 0, iArr10, iArr12) != 0 || ((iArr12[7] >>> 1) >= Integer.MAX_VALUE && x.e.P(iArr12, r7.b.f5224a))) {
                    r7.b.b(iArr12);
                }
                if (!zS) {
                    r7.b.c(iArr12, iArr15, iArr12);
                }
                return new q(hVar2, cVar3, cVar4, new m[]{cVar5}, 2);
            case 3:
                if (k()) {
                    return this;
                }
                int[] iArr17 = ((s7.c) mVar2).f5285g;
                boolean zU = x.e.U(iArr17);
                h hVar3 = this.f4817a;
                if (zU) {
                    return hVar3.m();
                }
                s7.c cVar6 = (s7.c) mVar;
                s7.c cVar7 = (s7.c) mVarArr[0];
                int[] iArr18 = new int[4];
                int[] iArr19 = new int[4];
                int[] iArr20 = new int[4];
                s7.b.b1(iArr17, iArr20);
                int[] iArr21 = new int[4];
                s7.b.b1(iArr20, iArr21);
                int[] iArr22 = cVar7.f5285g;
                boolean zQ = x.e.Q(iArr22);
                if (zQ) {
                    iArr2 = iArr22;
                } else {
                    s7.b.b1(iArr22, iArr19);
                    iArr2 = iArr19;
                }
                int[] iArr23 = cVar6.f5285g;
                s7.b.E1(iArr23, iArr2, iArr18);
                s7.b.a(iArr23, iArr2, iArr19);
                s7.b.Y(iArr19, iArr18, iArr19);
                s7.b.R0(x.e.d(iArr19, iArr19, iArr19), iArr19);
                s7.b.Y(iArr20, iArr23, iArr20);
                s7.b.R0(x.f.y0(4, iArr20), iArr20);
                s7.b.R0(x.f.z0(4, iArr21, iArr18), iArr18);
                s7.c cVar8 = new s7.c(iArr21);
                s7.b.b1(iArr19, iArr21);
                s7.b.E1(iArr21, iArr20, iArr21);
                s7.b.E1(iArr21, iArr20, iArr21);
                s7.c cVar9 = new s7.c(iArr20);
                s7.b.E1(iArr20, iArr21, iArr20);
                s7.b.Y(iArr20, iArr19, iArr20);
                s7.b.E1(iArr20, iArr18, iArr20);
                s7.c cVar10 = new s7.c(iArr19);
                if (x.f.x0(4, 0, iArr17, iArr19) != 0 || ((iArr19[3] >>> 1) >= 2147483646 && x.e.N(iArr19, s7.b.f5260a))) {
                    s7.b.o(iArr19);
                }
                if (!zQ) {
                    s7.b.Y(iArr19, iArr22, iArr19);
                }
                return new q(hVar3, cVar8, cVar9, new m[]{cVar10}, 3);
            case 4:
                if (k()) {
                    return this;
                }
                int[] iArr24 = ((s7.h) mVar2).f5307g;
                boolean zL0 = x.f.l0(iArr24);
                h hVar4 = this.f4817a;
                if (zL0) {
                    return hVar4.m();
                }
                s7.h hVar5 = (s7.h) mVar;
                s7.h hVar6 = (s7.h) mVarArr[0];
                int[] iArr25 = new int[5];
                s7.b.f1(iArr24, iArr25);
                int[] iArr26 = new int[5];
                s7.b.f1(iArr25, iArr26);
                int[] iArr27 = new int[5];
                s7.b.f1(hVar5.f5307g, iArr27);
                s7.b.T0(x.f.g(iArr27, iArr27, iArr27), iArr27);
                s7.b.e0(iArr25, hVar5.f5307g, iArr25);
                s7.b.T0(x.f.y0(5, iArr25), iArr25);
                int[] iArr28 = new int[5];
                s7.b.T0(x.f.z0(5, iArr26, iArr28), iArr28);
                s7.h hVar7 = new s7.h(iArr26);
                s7.b.f1(iArr27, iArr26);
                s7.b.H1(iArr26, iArr25, iArr26);
                s7.b.H1(iArr26, iArr25, iArr26);
                s7.h hVar8 = new s7.h(iArr25);
                s7.b.H1(iArr25, iArr26, iArr25);
                s7.b.e0(iArr25, iArr27, iArr25);
                s7.b.H1(iArr25, iArr28, iArr25);
                s7.h hVar9 = new s7.h(iArr27);
                s7.b.P1(iArr24, iArr27);
                if (!x.f.h0(hVar6.f5307g)) {
                    s7.b.e0(iArr27, hVar6.f5307g, iArr27);
                }
                return new q(hVar4, hVar7, hVar8, new m[]{hVar9}, 4);
            case 5:
                int[] iArr29 = s7.b.d;
                if (k()) {
                    return this;
                }
                int[] iArr30 = ((s7.f) mVar2).f5298g;
                boolean zL02 = x.f.l0(iArr30);
                h hVar10 = this.f4817a;
                if (zL02) {
                    return hVar10.m();
                }
                s7.f fVar = (s7.f) mVar;
                s7.f fVar2 = (s7.f) mVarArr[0];
                int[] iArr31 = new int[5];
                int[] iArr32 = new int[5];
                int[] iArr33 = new int[5];
                s7.b.d1(iArr30, iArr33);
                int[] iArr34 = new int[5];
                s7.b.d1(iArr33, iArr34);
                int[] iArr35 = fVar2.f5298g;
                boolean zH0 = x.f.h0(iArr35);
                if (zH0) {
                    iArr3 = iArr35;
                } else {
                    s7.b.d1(iArr35, iArr32);
                    iArr3 = iArr32;
                }
                int[] iArr36 = fVar.f5298g;
                s7.b.F1(iArr36, iArr3, iArr31);
                if (x.f.b(iArr36, iArr3, iArr32) != 0 || (iArr32[4] == -1 && x.f.Y(iArr32, iArr29))) {
                    x.f.n(5, -2147483647, iArr32);
                }
                s7.b.b0(iArr32, iArr31, iArr32);
                s7.b.S0(x.f.g(iArr32, iArr32, iArr32), iArr32);
                s7.b.b0(iArr33, iArr36, iArr33);
                s7.b.S0(x.f.y0(5, iArr33), iArr33);
                s7.b.S0(x.f.z0(5, iArr34, iArr31), iArr31);
                s7.f fVar3 = new s7.f(iArr34);
                s7.b.d1(iArr32, iArr34);
                s7.b.F1(iArr34, iArr33, iArr34);
                s7.b.F1(iArr34, iArr33, iArr34);
                s7.f fVar4 = new s7.f(iArr33);
                s7.b.F1(iArr33, iArr34, iArr33);
                s7.b.b0(iArr33, iArr32, iArr33);
                s7.b.F1(iArr33, iArr31, iArr33);
                s7.f fVar5 = new s7.f(iArr32);
                if (x.f.x0(5, 0, iArr30, iArr32) != 0 || (iArr32[4] == -1 && x.f.Y(iArr32, iArr29))) {
                    x.f.n(5, -2147483647, iArr32);
                }
                if (!zH0) {
                    s7.b.b0(iArr32, iArr35, iArr32);
                }
                return new q(hVar10, fVar3, fVar4, new m[]{fVar5}, 5);
            case 6:
                if (k()) {
                    return this;
                }
                int[] iArr37 = ((s7.h) mVar2).f5307g;
                boolean zL03 = x.f.l0(iArr37);
                h hVar11 = this.f4817a;
                if (zL03) {
                    return hVar11.m();
                }
                s7.h hVar12 = (s7.h) mVar;
                s7.h hVar13 = (s7.h) mVarArr[0];
                int[] iArr38 = new int[5];
                int[] iArr39 = new int[5];
                int[] iArr40 = new int[5];
                s7.b.f1(iArr37, iArr40);
                int[] iArr41 = new int[5];
                s7.b.f1(iArr40, iArr41);
                int[] iArr42 = hVar13.f5307g;
                boolean zH02 = x.f.h0(iArr42);
                if (zH02) {
                    iArr4 = iArr42;
                } else {
                    s7.b.f1(iArr42, iArr39);
                    iArr4 = iArr39;
                }
                int[] iArr43 = hVar12.f5307g;
                s7.b.H1(iArr43, iArr4, iArr38);
                if (x.f.b(iArr43, iArr4, iArr39) != 0 || (iArr39[4] == -1 && x.f.Y(iArr39, s7.b.f5265g))) {
                    x.f.e(5, 21389, iArr39);
                }
                s7.b.e0(iArr39, iArr38, iArr39);
                s7.b.T0(x.f.g(iArr39, iArr39, iArr39), iArr39);
                s7.b.e0(iArr40, iArr43, iArr40);
                s7.b.T0(x.f.y0(5, iArr40), iArr40);
                s7.b.T0(x.f.z0(5, iArr41, iArr38), iArr38);
                s7.h hVar14 = new s7.h(iArr41);
                s7.b.f1(iArr39, iArr41);
                s7.b.H1(iArr41, iArr40, iArr41);
                s7.b.H1(iArr41, iArr40, iArr41);
                s7.h hVar15 = new s7.h(iArr40);
                s7.b.H1(iArr40, iArr41, iArr40);
                s7.b.e0(iArr40, iArr39, iArr40);
                s7.b.H1(iArr40, iArr38, iArr40);
                s7.h hVar16 = new s7.h(iArr39);
                s7.b.P1(iArr37, iArr39);
                if (!zH02) {
                    s7.b.e0(iArr39, iArr42, iArr39);
                }
                return new q(hVar11, hVar14, hVar15, new m[]{hVar16}, 6);
            case 7:
                if (k()) {
                    return this;
                }
                int[] iArr44 = ((s7.j) mVar2).f5315g;
                boolean zV = x.e.V(iArr44);
                h hVar17 = this.f4817a;
                if (zV) {
                    return hVar17.m();
                }
                s7.j jVar = (s7.j) mVar;
                s7.j jVar2 = (s7.j) mVarArr[0];
                int[] iArr45 = new int[6];
                s7.b.h1(iArr44, iArr45);
                int[] iArr46 = new int[6];
                s7.b.h1(iArr45, iArr46);
                int[] iArr47 = new int[6];
                s7.b.h1(jVar.f5315g, iArr47);
                s7.b.U0(x.e.e(iArr47, iArr47, iArr47), iArr47);
                s7.b.h0(iArr45, jVar.f5315g, iArr45);
                s7.b.U0(x.f.y0(6, iArr45), iArr45);
                int[] iArr48 = new int[6];
                s7.b.U0(x.f.z0(6, iArr46, iArr48), iArr48);
                s7.j jVar3 = new s7.j(iArr46);
                s7.b.h1(iArr47, iArr46);
                s7.b.I1(iArr46, iArr45, iArr46);
                s7.b.I1(iArr46, iArr45, iArr46);
                s7.j jVar4 = new s7.j(iArr45);
                s7.b.I1(iArr45, iArr46, iArr45);
                s7.b.h0(iArr45, iArr47, iArr45);
                s7.b.I1(iArr45, iArr48, iArr45);
                s7.j jVar5 = new s7.j(iArr47);
                if (x.f.x0(6, 0, iArr44, iArr47) != 0 || (iArr47[5] == -1 && x.e.O(iArr47, s7.b.f5268j))) {
                    x.f.e(6, 4553, iArr47);
                }
                if (!x.e.R(jVar2.f5315g)) {
                    s7.b.h0(iArr47, jVar2.f5315g, iArr47);
                }
                return new q(hVar17, jVar3, jVar4, new m[]{jVar5}, 7);
            case 8:
                int[] iArr49 = s7.b.f5271m;
                if (k()) {
                    return this;
                }
                int[] iArr50 = ((s7.l) mVar2).f5324g;
                boolean zV2 = x.e.V(iArr50);
                h hVar18 = this.f4817a;
                if (zV2) {
                    return hVar18.m();
                }
                s7.l lVar = (s7.l) mVar;
                s7.l lVar2 = (s7.l) mVarArr[0];
                int[] iArr51 = new int[6];
                int[] iArr52 = new int[6];
                int[] iArr53 = new int[6];
                s7.b.j1(iArr50, iArr53);
                int[] iArr54 = new int[6];
                s7.b.j1(iArr53, iArr54);
                int[] iArr55 = lVar2.f5324g;
                boolean zR = x.e.R(iArr55);
                if (zR) {
                    iArr5 = iArr55;
                } else {
                    s7.b.j1(iArr55, iArr52);
                    iArr5 = iArr52;
                }
                int[] iArr56 = lVar.f5324g;
                s7.b.J1(iArr56, iArr5, iArr51);
                if (x.e.b(iArr56, iArr5, iArr52) != 0 || (iArr52[5] == -1 && x.e.O(iArr52, iArr49))) {
                    s7.b.p(iArr52);
                }
                s7.b.k0(iArr52, iArr51, iArr52);
                s7.b.V0(x.e.e(iArr52, iArr52, iArr52), iArr52);
                s7.b.k0(iArr53, iArr56, iArr53);
                s7.b.V0(x.f.y0(6, iArr53), iArr53);
                s7.b.V0(x.f.z0(6, iArr54, iArr51), iArr51);
                s7.l lVar3 = new s7.l(iArr54);
                s7.b.j1(iArr52, iArr54);
                s7.b.J1(iArr54, iArr53, iArr54);
                s7.b.J1(iArr54, iArr53, iArr54);
                s7.l lVar4 = new s7.l(iArr53);
                s7.b.J1(iArr53, iArr54, iArr53);
                s7.b.k0(iArr53, iArr52, iArr53);
                s7.b.J1(iArr53, iArr51, iArr53);
                s7.l lVar5 = new s7.l(iArr52);
                if (x.f.x0(6, 0, iArr50, iArr52) != 0 || (iArr52[5] == -1 && x.e.O(iArr52, iArr49))) {
                    s7.b.p(iArr52);
                }
                if (!zR) {
                    s7.b.k0(iArr52, iArr55, iArr52);
                }
                return new q(hVar18, lVar3, lVar4, new m[]{lVar5}, 8);
            case 9:
                if (k()) {
                    return this;
                }
                int[] iArr57 = ((s7.n) mVar2).f5333g;
                boolean zM0 = x.f.m0(iArr57);
                h hVar19 = this.f4817a;
                if (zM0) {
                    return hVar19.m();
                }
                s7.n nVar = (s7.n) mVar;
                s7.n nVar2 = (s7.n) mVarArr[0];
                int[] iArr58 = new int[7];
                s7.b.k1(iArr57, iArr58);
                int[] iArr59 = new int[7];
                s7.b.k1(iArr58, iArr59);
                int[] iArr60 = new int[7];
                s7.b.k1(nVar.f5333g, iArr60);
                s7.b.W0(x.f.h(iArr60, iArr60, iArr60), iArr60);
                s7.b.m0(iArr58, nVar.f5333g, iArr58);
                s7.b.W0(x.f.y0(7, iArr58), iArr58);
                int[] iArr61 = new int[7];
                s7.b.W0(x.f.z0(7, iArr59, iArr61), iArr61);
                s7.n nVar3 = new s7.n(iArr59);
                s7.b.k1(iArr60, iArr59);
                s7.b.K1(iArr59, iArr58, iArr59);
                s7.b.K1(iArr59, iArr58, iArr59);
                s7.n nVar4 = new s7.n(iArr58);
                s7.b.K1(iArr58, iArr59, iArr58);
                s7.b.m0(iArr58, iArr60, iArr58);
                s7.b.K1(iArr58, iArr61, iArr58);
                s7.n nVar5 = new s7.n(iArr60);
                if (x.f.x0(7, 0, iArr57, iArr60) != 0 || (iArr60[6] == -1 && x.f.Z(iArr60, s7.b.f5274p))) {
                    x.f.e(7, 6803, iArr60);
                }
                if (!x.f.i0(nVar2.f5333g)) {
                    s7.b.m0(iArr60, nVar2.f5333g, iArr60);
                }
                return new q(hVar19, nVar3, nVar4, new m[]{nVar5}, 9);
            case 10:
                if (k()) {
                    return this;
                }
                int[] iArr62 = ((s7.p) mVar2).f5341g;
                boolean zM02 = x.f.m0(iArr62);
                h hVar20 = this.f4817a;
                if (zM02) {
                    return hVar20.m();
                }
                s7.p pVar = (s7.p) mVar;
                s7.p pVar2 = (s7.p) mVarArr[0];
                int[] iArr63 = new int[7];
                int[] iArr64 = new int[7];
                int[] iArr65 = new int[7];
                s7.b.l1(iArr62, iArr65);
                int[] iArr66 = new int[7];
                s7.b.l1(iArr65, iArr66);
                int[] iArr67 = pVar2.f5341g;
                boolean zI0 = x.f.i0(iArr67);
                if (zI0) {
                    iArr6 = iArr67;
                } else {
                    s7.b.l1(iArr67, iArr64);
                    iArr6 = iArr64;
                }
                int[] iArr68 = pVar.f5341g;
                s7.b.L1(iArr68, iArr6, iArr63);
                s7.b.c(iArr68, iArr6, iArr64);
                s7.b.o0(iArr64, iArr63, iArr64);
                s7.b.X0(x.f.h(iArr64, iArr64, iArr64), iArr64);
                s7.b.o0(iArr65, iArr68, iArr65);
                s7.b.X0(x.f.y0(7, iArr65), iArr65);
                s7.b.X0(x.f.z0(7, iArr66, iArr63), iArr63);
                s7.p pVar3 = new s7.p(iArr66);
                s7.b.l1(iArr64, iArr66);
                s7.b.L1(iArr66, iArr65, iArr66);
                s7.b.L1(iArr66, iArr65, iArr66);
                s7.p pVar4 = new s7.p(iArr65);
                s7.b.L1(iArr65, iArr66, iArr65);
                s7.b.o0(iArr65, iArr64, iArr65);
                s7.b.L1(iArr65, iArr63, iArr65);
                s7.p pVar5 = new s7.p(iArr64);
                s7.b.Q1(iArr62, iArr64);
                if (!zI0) {
                    s7.b.o0(iArr64, iArr67, iArr64);
                }
                return new q(hVar20, pVar3, pVar4, new m[]{pVar5}, 10);
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (k()) {
                    return this;
                }
                int[] iArr69 = ((s7.r) mVar2).f5349g;
                boolean zW2 = x.e.W(iArr69);
                h hVar21 = this.f4817a;
                if (zW2) {
                    return hVar21.m();
                }
                s7.r rVar = (s7.r) mVar;
                s7.r rVar2 = (s7.r) mVarArr[0];
                int[] iArr70 = new int[16];
                int[] iArr71 = new int[8];
                x.e.j0(iArr69, iArr70);
                s7.b.L0(iArr70, iArr71);
                int[] iArr72 = new int[8];
                x.e.j0(iArr71, iArr70);
                s7.b.L0(iArr70, iArr72);
                int[] iArr73 = new int[8];
                x.e.j0(rVar.f5349g, iArr70);
                s7.b.L0(iArr70, iArr73);
                s7.b.Y0(x.e.f(iArr73, iArr73, iArr73), iArr73);
                s7.b.Z(iArr71, rVar.f5349g, iArr71, iArr70);
                s7.b.Y0(x.f.y0(8, iArr71), iArr71);
                int[] iArr74 = new int[8];
                s7.b.Y0(x.f.z0(8, iArr72, iArr74), iArr74);
                s7.r rVar3 = new s7.r(iArr72);
                x.e.j0(iArr73, iArr70);
                s7.b.L0(iArr70, iArr72);
                s7.b.M1(iArr72, iArr71, iArr72);
                s7.b.M1(iArr72, iArr71, iArr72);
                s7.r rVar4 = new s7.r(iArr71);
                s7.b.M1(iArr71, iArr72, iArr71);
                x.e.c0(iArr71, iArr73, iArr70);
                s7.b.L0(iArr70, iArr71);
                s7.b.M1(iArr71, iArr74, iArr71);
                s7.r rVar5 = new s7.r(iArr73);
                if (x.f.x0(8, 0, iArr69, iArr73) != 0 || (iArr73[7] == -1 && x.e.P(iArr73, s7.b.f5280v))) {
                    x.f.e(8, 977, iArr73);
                }
                if (!x.e.S(rVar2.f5349g)) {
                    s7.b.Z(iArr73, rVar2.f5349g, iArr73, iArr70);
                }
                return new q(hVar21, rVar3, rVar4, new m[]{rVar5}, 11);
            case 12:
                int[] iArr75 = s7.b.y;
                if (k()) {
                    return this;
                }
                int[] iArr76 = ((s7.t) mVar2).f5358g;
                boolean zW3 = x.e.W(iArr76);
                h hVar22 = this.f4817a;
                if (zW3) {
                    return hVar22.m();
                }
                s7.t tVar = (s7.t) mVar;
                s7.t tVar2 = (s7.t) mVarArr[0];
                int[] iArr77 = new int[16];
                int[] iArr78 = new int[8];
                int[] iArr79 = new int[8];
                int[] iArr80 = new int[8];
                x.e.j0(iArr76, iArr77);
                s7.b.N0(iArr77, iArr80);
                int[] iArr81 = new int[8];
                x.e.j0(iArr80, iArr77);
                s7.b.N0(iArr77, iArr81);
                int[] iArr82 = tVar2.f5358g;
                boolean zS2 = x.e.S(iArr82);
                if (zS2) {
                    iArr7 = iArr82;
                } else {
                    x.e.j0(iArr82, iArr77);
                    s7.b.N0(iArr77, iArr79);
                    iArr7 = iArr79;
                }
                int[] iArr83 = tVar.f5358g;
                s7.b.N1(iArr83, iArr7, iArr78);
                if (x.e.c(iArr83, iArr7, iArr79) != 0 || (iArr79[7] == -1 && x.e.P(iArr79, iArr75))) {
                    s7.b.r(iArr79);
                }
                x.e.c0(iArr79, iArr78, iArr77);
                s7.b.N0(iArr77, iArr79);
                s7.b.Z0(x.e.f(iArr79, iArr79, iArr79), iArr79);
                x.e.c0(iArr80, iArr83, iArr77);
                s7.b.N0(iArr77, iArr80);
                s7.b.Z0(x.f.y0(8, iArr80), iArr80);
                s7.b.Z0(x.f.z0(8, iArr81, iArr78), iArr78);
                s7.t tVar3 = new s7.t(iArr81);
                x.e.j0(iArr79, iArr77);
                s7.b.N0(iArr77, iArr81);
                s7.b.N1(iArr81, iArr80, iArr81);
                s7.b.N1(iArr81, iArr80, iArr81);
                s7.t tVar4 = new s7.t(iArr80);
                s7.b.N1(iArr80, iArr81, iArr80);
                x.e.c0(iArr80, iArr79, iArr77);
                s7.b.N0(iArr77, iArr80);
                s7.b.N1(iArr80, iArr78, iArr80);
                s7.t tVar5 = new s7.t(iArr79);
                if (x.f.x0(8, 0, iArr76, iArr79) != 0 || (iArr79[7] == -1 && x.e.P(iArr79, iArr75))) {
                    s7.b.r(iArr79);
                }
                if (!zS2) {
                    s7.b.c0(iArr79, iArr82, iArr79, iArr77);
                }
                return new q(hVar22, tVar3, tVar4, new m[]{tVar5}, 12);
            case BERTags.RELATIVE_OID /* 13 */:
                int[] iArr84 = s7.b.A;
                if (k()) {
                    return this;
                }
                s7.v vVar = (s7.v) mVar2;
                boolean zI2 = vVar.i();
                int[] iArr85 = vVar.f5366g;
                h hVar23 = this.f4817a;
                if (zI2) {
                    return hVar23.m();
                }
                s7.v vVar2 = (s7.v) mVar;
                s7.v vVar3 = (s7.v) mVarArr[0];
                int[] iArr86 = new int[24];
                int[] iArr87 = new int[12];
                int[] iArr88 = new int[12];
                int[] iArr89 = new int[12];
                x.e.k0(iArr85, iArr86);
                s7.b.P0(iArr86, iArr89);
                int[] iArr90 = new int[12];
                x.e.k0(iArr89, iArr86);
                s7.b.P0(iArr86, iArr90);
                boolean zH3 = vVar3.h();
                int[] iArr91 = vVar3.f5366g;
                if (zH3) {
                    iArr8 = iArr91;
                } else {
                    x.e.k0(iArr91, iArr86);
                    s7.b.P0(iArr86, iArr88);
                    iArr8 = iArr88;
                }
                int[] iArr92 = vVar2.f5366g;
                s7.b.O1(iArr92, iArr8, iArr87);
                if (x.f.a(iArr92, iArr8, 12, iArr88) != 0 || (iArr88[11] == -1 && x.f.X(12, iArr88, iArr84))) {
                    s7.b.s(iArr88);
                }
                x.e.d0(iArr88, iArr87, iArr86);
                s7.b.P0(iArr86, iArr88);
                s7.b.a1(x.f.f(iArr88, iArr88, 12, iArr88), iArr88);
                s7.b.f0(iArr89, iArr92, iArr89, iArr86);
                s7.b.a1(x.f.y0(12, iArr89), iArr89);
                s7.b.a1(x.f.z0(12, iArr90, iArr87), iArr87);
                s7.v vVar4 = new s7.v(iArr90);
                x.e.k0(iArr88, iArr86);
                s7.b.P0(iArr86, iArr90);
                s7.b.O1(iArr90, iArr89, iArr90);
                s7.b.O1(iArr90, iArr89, iArr90);
                s7.v vVar5 = new s7.v(iArr89);
                s7.b.O1(iArr89, iArr90, iArr89);
                x.e.d0(iArr89, iArr88, iArr86);
                s7.b.P0(iArr86, iArr89);
                s7.b.O1(iArr89, iArr87, iArr89);
                s7.v vVar6 = new s7.v(iArr88);
                if (x.f.x0(12, 0, iArr85, iArr88) != 0 || (iArr88[11] == -1 && x.f.X(12, iArr88, iArr84))) {
                    s7.b.s(iArr88);
                }
                if (!zH3) {
                    s7.b.f0(iArr88, iArr91, iArr88, iArr86);
                }
                return new q(hVar23, vVar4, vVar5, new m[]{vVar6}, 13);
            default:
                if (k()) {
                    return this;
                }
                s7.x xVar = (s7.x) mVar2;
                boolean zI3 = xVar.i();
                int[] iArr93 = xVar.f5374g;
                h hVar24 = this.f4817a;
                if (zI3) {
                    return hVar24.m();
                }
                s7.x xVar2 = (s7.x) mVar;
                s7.x xVar3 = (s7.x) mVarArr[0];
                int[] iArr94 = new int[33];
                int[] iArr95 = new int[17];
                int[] iArr96 = new int[17];
                int[] iArr97 = new int[17];
                s7.b.S(iArr93, iArr94);
                s7.b.A0(iArr94, iArr97);
                int[] iArr98 = new int[17];
                s7.b.S(iArr97, iArr94);
                s7.b.A0(iArr94, iArr98);
                boolean zH4 = xVar3.h();
                int[] iArr99 = xVar3.f5374g;
                if (zH4) {
                    iArr9 = iArr99;
                } else {
                    s7.b.S(iArr99, iArr94);
                    s7.b.A0(iArr94, iArr96);
                    iArr9 = iArr96;
                }
                int[] iArr100 = xVar2.f5374g;
                s7.b.G1(iArr100, iArr9, iArr95);
                s7.b.d(iArr100, iArr9, iArr96);
                s7.b.y(iArr96, iArr95, iArr94);
                s7.b.A0(iArr94, iArr96);
                x.f.f(iArr96, iArr96, 17, iArr96);
                s7.b.Q0(iArr96);
                s7.b.y(iArr97, iArr100, iArr94);
                s7.b.A0(iArr94, iArr97);
                x.f.y0(17, iArr97);
                s7.b.Q0(iArr97);
                x.f.z0(17, iArr98, iArr95);
                s7.b.Q0(iArr95);
                s7.x xVar4 = new s7.x(iArr98);
                s7.b.S(iArr96, iArr94);
                s7.b.A0(iArr94, iArr98);
                s7.b.G1(iArr98, iArr97, iArr98);
                s7.b.G1(iArr98, iArr97, iArr98);
                s7.x xVar5 = new s7.x(iArr97);
                s7.b.G1(iArr97, iArr98, iArr97);
                s7.b.y(iArr97, iArr96, iArr94);
                s7.b.A0(iArr94, iArr97);
                s7.b.G1(iArr97, iArr95, iArr97);
                s7.x xVar6 = new s7.x(iArr96);
                int i11 = iArr93[16];
                iArr96[16] = (x.f.x0(16, i11 << 23, iArr93, iArr96) | (i11 << 1)) & 511;
                if (!zH4) {
                    s7.b.i0(iArr96, iArr99, iArr96, iArr94);
                }
                return new q(hVar24, xVar4, xVar5, new m[]{xVar6}, 14);
        }
    }

    @Override // p7.r
    public final r y(r rVar) {
        switch (this.f4815g) {
            case 0:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            m mVar = this.f4819c;
                            if (!mVar.i()) {
                                h hVar = this.f4817a;
                                int i8 = hVar.f4801f;
                                if (i8 == 0) {
                                    m mVar2 = rVar.f4818b;
                                    m mVar3 = rVar.f4819c;
                                    m mVar4 = this.f4818b;
                                    m mVarR = mVar2.r(mVar4);
                                    m mVarR2 = mVar3.r(mVar);
                                    if (!mVarR.i()) {
                                        m mVarO = mVarR.o();
                                        m mVarR3 = mVarO.j(mVar4.a(mVar4).a(mVar2)).r(mVarR2.o());
                                        if (!mVarR3.i()) {
                                            m mVarG = mVarR3.j(mVarR).g();
                                            m mVarJ = mVarR3.j(mVarG).j(mVarR2);
                                            m mVarR4 = mVar.a(mVar).j(mVarO).j(mVarR).j(mVarG).r(mVarJ);
                                            m mVarA = mVarR4.r(mVarJ).j(mVarJ.a(mVarR4)).a(mVar2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else if (mVarR2.i()) {
                                        break;
                                    }
                                } else if (i8 == 4) {
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                } else {
                    break;
                }
                break;
            case 1:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 2:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 3:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 4:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 5:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 6:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 7:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 8:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 9:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 10:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case 12:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
            default:
                if (this != rVar) {
                    if (!k()) {
                        if (!rVar.k()) {
                            if (!this.f4819c.i()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
                break;
        }
        return x().a(rVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(h hVar, m mVar, m mVar2, m[] mVarArr, int i8) {
        super(hVar, mVar, mVar2, mVarArr);
        this.f4815g = i8;
    }
}
