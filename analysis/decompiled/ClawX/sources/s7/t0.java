package s7;

import java.math.BigInteger;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public final class t0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5359g;

    public t0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f5359g = x.f.R(409, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((t0) mVar).f5359g;
        long[] jArr2 = this.f5359g;
        return new t0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3], jArr2[4] ^ jArr[4], jArr2[5] ^ jArr[5], jArr2[6] ^ jArr[6]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5359g;
        return new t0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3], jArr[4], jArr[5], jArr[6]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        long[] jArr = ((t0) obj).f5359g;
        for (int i8 = 6; i8 >= 0; i8--) {
            if (this.f5359g[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return 409;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[7];
        for (int i8 = 0; i8 < 7; i8++) {
            long[] jArr2 = this.f5359g;
            if (jArr2[i8] != 0) {
                long[] jArr3 = new long[7];
                long[] jArr4 = new long[7];
                long[] jArr5 = new long[7];
                long[] jArr6 = new long[13];
                b.X(jArr2, jArr6);
                b.O0(jArr6, jArr3);
                b.D1(1, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(1, jArr4, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(3, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(6, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(12, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr5);
                b.D1(24, jArr5, jArr3);
                b.D1(24, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(48, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(96, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.D1(BERTags.PRIVATE, jArr3, jArr4);
                b.r0(jArr3, jArr4, jArr3);
                b.r0(jArr3, jArr5, jArr);
                return new t0(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // p7.m
    public final boolean h() {
        long[] jArr = this.f5359g;
        if (jArr[0] == 1) {
            for (int i8 = 1; i8 < 7; i8++) {
                if (jArr[i8] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5359g, 0, 7) ^ 4090087;
    }

    @Override // p7.m
    public final boolean i() {
        for (int i8 = 0; i8 < 7; i8++) {
            if (this.f5359g[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[7];
        b.r0(this.f5359g, ((t0) mVar).f5359g, jArr);
        return new t0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((t0) mVar).f5359g;
        long[] jArr2 = ((t0) mVar2).f5359g;
        long[] jArr3 = ((t0) mVar3).f5359g;
        long[] jArr4 = new long[13];
        long[] jArr5 = new long[14];
        b.H(this.f5359g, jArr, jArr5);
        for (int i8 = 0; i8 < 13; i8++) {
            jArr4[i8] = jArr4[i8] ^ jArr5[i8];
        }
        long[] jArr6 = new long[14];
        b.H(jArr2, jArr3, jArr6);
        for (int i9 = 0; i9 < 13; i9++) {
            jArr4[i9] = jArr4[i9] ^ jArr6[i9];
        }
        long[] jArr7 = new long[7];
        b.O0(jArr4, jArr7);
        return new t0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = this.f5359g;
        long jA0 = x.e.A0(jArr[0]);
        long jA02 = x.e.A0(jArr[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long j8 = (jA0 >>> 32) | (jA02 & (-4294967296L));
        long jA03 = x.e.A0(jArr[2]);
        long jA04 = x.e.A0(jArr[3]);
        long j9 = (jA03 & 4294967295L) | (jA04 << 32);
        long j10 = (jA03 >>> 32) | (jA04 & (-4294967296L));
        long jA05 = x.e.A0(jArr[4]);
        long jA06 = x.e.A0(jArr[5]);
        long j11 = (jA05 >>> 32) | (jA06 & (-4294967296L));
        long jA07 = x.e.A0(jArr[6]);
        long j12 = jA07 >>> 32;
        return new t0(new long[]{j4 ^ (j8 << 44), (j9 ^ (j10 << 44)) ^ (j8 >>> 20), (((jA05 & 4294967295L) | (jA06 << 32)) ^ (j11 << 44)) ^ (j10 >>> 20), (((jA07 & 4294967295L) ^ (j12 << 44)) ^ (j11 >>> 20)) ^ (j8 << 13), ((jA07 >>> 52) ^ (j10 << 13)) ^ (j8 >>> 51), (j11 << 13) ^ (j10 >>> 51), (j12 << 13) ^ (j11 >>> 51)});
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[7];
        long[] jArr2 = new long[13];
        b.X(this.f5359g, jArr2);
        b.O0(jArr2, jArr);
        return new t0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((t0) mVar).f5359g;
        long[] jArr2 = ((t0) mVar2).f5359g;
        long[] jArr3 = new long[13];
        long[] jArr4 = new long[13];
        b.X(this.f5359g, jArr4);
        for (int i8 = 0; i8 < 13; i8++) {
            jArr3[i8] = jArr3[i8] ^ jArr4[i8];
        }
        long[] jArr5 = new long[14];
        b.H(jArr, jArr2, jArr5);
        for (int i9 = 0; i9 < 13; i9++) {
            jArr3[i9] = jArr3[i9] ^ jArr5[i9];
        }
        long[] jArr6 = new long[7];
        b.O0(jArr3, jArr6);
        return new t0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[7];
        b.D1(i8, this.f5359g, jArr);
        return new t0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5359g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        byte[] bArr = new byte[56];
        for (int i8 = 0; i8 < 7; i8++) {
            long j4 = this.f5359g[i8];
            if (j4 != 0) {
                Pack.longToBigEndian(j4, bArr, (6 - i8) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[13];
        long[] jArr2 = this.f5359g;
        long[] jArr3 = {jArr2[0], jArr2[1], jArr2[2], jArr2[3], jArr2[4], jArr2[5], jArr2[6]};
        for (int i8 = 1; i8 < 409; i8 += 2) {
            b.X(jArr3, jArr);
            b.O0(jArr, jArr3);
            b.X(jArr3, jArr);
            b.O0(jArr, jArr3);
            jArr3[0] = jArr3[0] ^ jArr2[0];
            jArr3[1] = jArr3[1] ^ jArr2[1];
            jArr3[2] = jArr3[2] ^ jArr2[2];
            jArr3[3] = jArr3[3] ^ jArr2[3];
            jArr3[4] = jArr3[4] ^ jArr2[4];
            jArr3[5] = jArr3[5] ^ jArr2[5];
            jArr3[6] = jArr3[6] ^ jArr2[6];
        }
        return new t0(jArr3);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        return ((int) this.f5359g[0]) & 1;
    }

    public t0(long[] jArr) {
        this.f5359g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
