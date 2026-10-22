package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public final class q0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5347g;

    public q0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f5347g = x.f.R(283, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((q0) mVar).f5347g;
        long[] jArr2 = this.f5347g;
        return new q0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3], jArr[4] ^ jArr2[4]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5347g;
        return new q0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3], jArr[4]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        long[] jArr = ((q0) obj).f5347g;
        for (int i8 = 4; i8 >= 0; i8--) {
            if (this.f5347g[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return 283;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[5];
        for (int i8 = 0; i8 < 5; i8++) {
            long[] jArr2 = this.f5347g;
            if (jArr2[i8] != 0) {
                long[] jArr3 = new long[5];
                long[] jArr4 = new long[5];
                b.c1(jArr2, jArr3);
                b.g0(jArr3, jArr2, jArr3);
                b.t1(2, jArr3, jArr4);
                b.g0(jArr4, jArr3, jArr4);
                b.t1(4, jArr4, jArr3);
                b.g0(jArr3, jArr4, jArr3);
                b.t1(8, jArr3, jArr4);
                b.g0(jArr4, jArr3, jArr4);
                b.c1(jArr4, jArr4);
                b.g0(jArr4, jArr2, jArr4);
                b.t1(17, jArr4, jArr3);
                b.g0(jArr3, jArr4, jArr3);
                b.c1(jArr3, jArr3);
                b.g0(jArr3, jArr2, jArr3);
                b.t1(35, jArr3, jArr4);
                b.g0(jArr4, jArr3, jArr4);
                b.t1(70, jArr4, jArr3);
                b.g0(jArr3, jArr4, jArr3);
                b.c1(jArr3, jArr3);
                b.g0(jArr3, jArr2, jArr3);
                b.t1(141, jArr3, jArr4);
                b.g0(jArr4, jArr3, jArr4);
                b.c1(jArr4, jArr);
                return new q0(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // p7.m
    public final boolean h() {
        long[] jArr = this.f5347g;
        if (jArr[0] == 1) {
            for (int i8 = 1; i8 < 5; i8++) {
                if (jArr[i8] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5347g, 0, 5) ^ 2831275;
    }

    @Override // p7.m
    public final boolean i() {
        for (int i8 = 0; i8 < 5; i8++) {
            if (this.f5347g[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[5];
        b.g0(this.f5347g, ((q0) mVar).f5347g, jArr);
        return new q0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((q0) mVar).f5347g;
        long[] jArr2 = ((q0) mVar2).f5347g;
        long[] jArr3 = ((q0) mVar3).f5347g;
        long[] jArr4 = new long[9];
        long[] jArr5 = new long[10];
        b.B(this.f5347g, jArr, jArr5);
        b.i(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[10];
        b.B(jArr2, jArr3, jArr6);
        b.i(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[5];
        b.C0(jArr4, jArr7);
        return new q0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = new long[5];
        long[] jArr2 = this.f5347g;
        long jA0 = x.e.A0(jArr2[0]);
        long jA02 = x.e.A0(jArr2[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long jA03 = x.e.A0(jArr2[2]);
        long jA04 = x.e.A0(jArr2[3]);
        long j8 = (jA03 & 4294967295L) | (jA04 << 32);
        long jA05 = x.e.A0(jArr2[4]);
        b.g0(new long[]{(jA0 >>> 32) | (jA02 & (-4294967296L)), (jA03 >>> 32) | (jA04 & (-4294967296L)), jA05 >>> 32, 0, 0}, b.G, jArr);
        jArr[0] = jArr[0] ^ j4;
        jArr[1] = jArr[1] ^ j8;
        jArr[2] = jArr[2] ^ (4294967295L & jA05);
        return new q0(jArr);
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[5];
        b.c1(this.f5347g, jArr);
        return new q0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((q0) mVar).f5347g;
        long[] jArr2 = ((q0) mVar2).f5347g;
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        b.U(this.f5347g, jArr4);
        b.i(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[10];
        b.B(jArr, jArr2, jArr5);
        b.i(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[5];
        b.C0(jArr3, jArr6);
        return new q0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[5];
        b.t1(i8, this.f5347g, jArr);
        return new q0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5347g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        byte[] bArr = new byte[40];
        for (int i8 = 0; i8 < 5; i8++) {
            long j4 = this.f5347g[i8];
            if (j4 != 0) {
                Pack.longToBigEndian(j4, bArr, (4 - i8) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[9];
        long[] jArr2 = this.f5347g;
        long[] jArr3 = {jArr2[0], jArr2[1], jArr2[2], jArr2[3], jArr2[4]};
        for (int i8 = 1; i8 < 283; i8 += 2) {
            b.U(jArr3, jArr);
            b.C0(jArr, jArr3);
            b.U(jArr3, jArr);
            b.C0(jArr, jArr3);
            jArr3[0] = jArr3[0] ^ jArr2[0];
            jArr3[1] = jArr3[1] ^ jArr2[1];
            jArr3[2] = jArr3[2] ^ jArr2[2];
            jArr3[3] = jArr3[3] ^ jArr2[3];
            jArr3[4] = jArr3[4] ^ jArr2[4];
        }
        return new q0(jArr3);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        long[] jArr = this.f5347g;
        return ((int) (jArr[0] ^ (jArr[4] >>> 15))) & 1;
    }

    public q0(long[] jArr) {
        this.f5347g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
