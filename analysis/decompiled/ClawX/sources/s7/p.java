package s7;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class p extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5340h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5341g;

    public p(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5340h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        int[] iArrQ = x.f.Q(bigInteger);
        if (iArrQ[6] == -1) {
            if (x.f.Z(iArrQ, b.f5277s)) {
                long j4 = (iArrQ[0] & 4294967295L) - (r1[0] & 4294967295L);
                iArrQ[0] = (int) j4;
                long j8 = ((iArrQ[1] & 4294967295L) - (r1[1] & 4294967295L)) + (j4 >> 32);
                iArrQ[1] = (int) j8;
                long j9 = ((iArrQ[2] & 4294967295L) - (r1[2] & 4294967295L)) + (j8 >> 32);
                iArrQ[2] = (int) j9;
                long j10 = ((iArrQ[3] & 4294967295L) - (r1[3] & 4294967295L)) + (j9 >> 32);
                iArrQ[3] = (int) j10;
                long j11 = ((iArrQ[4] & 4294967295L) - (r1[4] & 4294967295L)) + (j10 >> 32);
                iArrQ[4] = (int) j11;
                long j12 = ((iArrQ[5] & 4294967295L) - (r1[5] & 4294967295L)) + (j11 >> 32);
                iArrQ[5] = (int) j12;
                iArrQ[6] = (int) (((iArrQ[6] & 4294967295L) - (r1[6] & 4294967295L)) + (j12 >> 32));
            }
        }
        this.f5341g = iArrQ;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[7];
        b.c(this.f5341g, ((p) mVar).f5341g, iArr);
        return new p(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[7];
        if (x.f.b0(7, this.f5341g, iArr) != 0 || (iArr[6] == -1 && x.f.Z(iArr, b.f5277s))) {
            b.q(iArr);
        }
        return new p(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[7];
        x.f.s(b.f5277s, ((p) mVar).f5341g, iArr);
        b.o0(iArr, this.f5341g, iArr);
        return new p(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            return x.f.K(this.f5341g, ((p) obj).f5341g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5340h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[7];
        x.f.s(b.f5277s, this.f5341g, iArr);
        return new p(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.f.i0(this.f5341g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5341g, 0, 7) ^ f5340h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.f.m0(this.f5341g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[7];
        b.o0(this.f5341g, ((p) mVar).f5341g, iArr);
        return new p(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[7];
        int[] iArr3 = b.f5277s;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5341g;
            if (i8 >= 7) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.f.F0(iArr3, iArr3, iArr2);
        } else {
            x.f.F0(iArr3, iArr, iArr2);
        }
        return new p(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3 = b.f5277s;
        int[] iArr4 = this.f5341g;
        if (x.f.m0(iArr4) || x.f.i0(iArr4)) {
            return this;
        }
        int[] iArr5 = new int[7];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < 7; i10++) {
            i9 |= iArr4[i10];
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.f.F0(iArr3, iArr3, iArr5);
        } else {
            x.f.F0(iArr3, iArr4, iArr5);
        }
        Random random = new Random();
        int[] iArr6 = new int[7];
        int i11 = iArr3[6];
        int i12 = i11 | (i11 >>> 1);
        int i13 = i12 | (i12 >>> 2);
        int i14 = i13 | (i13 >>> 4);
        int i15 = i14 | (i14 >>> 8);
        int i16 = (i15 >>> 16) | i15;
        do {
            for (int i17 = 0; i17 != 7; i17++) {
                iArr6[i17] = random.nextInt();
            }
            iArr6[6] = iArr6[6] & i16;
        } while (x.f.X(7, iArr6, iArr3));
        int[] iArr7 = new int[7];
        int[] iArr8 = new int[7];
        int[] iArr9 = new int[7];
        x.f.w(iArr4, iArr8);
        for (int i18 = 0; i18 < 7; i18++) {
            x.f.w(iArr8, iArr9);
            int i19 = 1 << i18;
            int[] iArr10 = new int[14];
            do {
                x.f.B0(iArr8, iArr10);
                b.J0(iArr10, iArr8);
                i19--;
            } while (i19 > 0);
            b.o0(iArr8, iArr9, iArr8);
        }
        int[] iArr11 = new int[14];
        x.f.B0(iArr8, iArr11);
        b.J0(iArr11, iArr8);
        int i20 = 95;
        while (true) {
            i20--;
            if (i20 <= 0) {
                break;
            }
            x.f.B0(iArr8, iArr11);
            b.J0(iArr11, iArr8);
        }
        if (!x.f.i0(iArr8)) {
            return null;
        }
        loop6: while (true) {
            int[] iArr12 = new int[7];
            x.f.w(iArr6, iArr12);
            int[] iArr13 = new int[7];
            iArr13[i8] = 1;
            int[] iArr14 = new int[7];
            x.f.w(iArr5, iArr14);
            int[] iArr15 = new int[7];
            int[] iArr16 = new int[7];
            for (int i21 = i8; i21 < 7; i21++) {
                x.f.w(iArr12, iArr15);
                x.f.w(iArr13, iArr16);
                int i22 = 1 << i21;
                while (true) {
                    i22--;
                    if (i22 >= 0) {
                        b.o0(iArr13, iArr12, iArr13);
                        b.Q1(iArr13, iArr13);
                        b.l1(iArr12, iArr7);
                        b.c(iArr14, iArr7, iArr12);
                        b.o0(iArr14, iArr7, iArr14);
                        b.X0(x.f.y0(7, iArr14), iArr14);
                    }
                }
                b.o0(iArr13, iArr16, iArr7);
                b.o0(iArr7, iArr5, iArr7);
                b.o0(iArr12, iArr15, iArr14);
                b.c(iArr14, iArr7, iArr14);
                b.o0(iArr12, iArr16, iArr7);
                x.f.w(iArr14, iArr12);
                b.o0(iArr13, iArr15, iArr13);
                b.c(iArr13, iArr7, iArr13);
                b.l1(iArr13, iArr14);
                b.o0(iArr14, iArr5, iArr14);
            }
            iArr = new int[7];
            iArr2 = new int[7];
            for (int i23 = 1; i23 < 96; i23++) {
                x.f.w(iArr12, iArr);
                x.f.w(iArr13, iArr2);
                b.o0(iArr13, iArr12, iArr13);
                b.Q1(iArr13, iArr13);
                b.l1(iArr12, iArr7);
                b.c(iArr14, iArr7, iArr12);
                b.o0(iArr14, iArr7, iArr14);
                b.X0(x.f.y0(7, iArr14), iArr14);
                if (x.f.m0(iArr12)) {
                    break loop6;
                }
            }
            if (x.f.b0(7, iArr6, iArr6) != 0 || (iArr6[6] == -1 && x.f.Z(iArr6, iArr3))) {
                b.q(iArr6);
            }
            i8 = 0;
        }
        x.f.s(iArr3, iArr2, iArr7);
        b.o0(iArr7, iArr, iArr7);
        b.l1(iArr7, iArr6);
        if (x.f.K(iArr4, iArr6)) {
            return new p(iArr7);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[7];
        b.l1(this.f5341g, iArr);
        return new p(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[7];
        b.L1(this.f5341g, ((p) mVar).f5341g, iArr);
        return new p(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.f.T(this.f5341g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.f.M0(this.f5341g);
    }

    public p(int[] iArr) {
        this.f5341g = iArr;
    }
}
