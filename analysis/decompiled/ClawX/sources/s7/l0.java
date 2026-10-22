package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class l0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5325g;

    public l0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f5325g = x.f.R(233, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((l0) mVar).f5325g;
        long[] jArr2 = this.f5325g;
        return new l0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr[3] ^ jArr2[3]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5325g;
        return new l0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l0) {
            return x.e.A(this.f5325g, ((l0) obj).f5325g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return 233;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f5325g;
        if (x.e.Y(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        b.g1(jArr2, jArr3);
        b.p0(jArr3, jArr2, jArr3);
        b.g1(jArr3, jArr3);
        b.p0(jArr3, jArr2, jArr3);
        b.B1(3, jArr3, jArr4);
        b.p0(jArr4, jArr3, jArr4);
        b.g1(jArr4, jArr4);
        b.p0(jArr4, jArr2, jArr4);
        b.B1(7, jArr4, jArr3);
        b.p0(jArr3, jArr4, jArr3);
        b.B1(14, jArr3, jArr4);
        b.p0(jArr4, jArr3, jArr4);
        b.g1(jArr4, jArr4);
        b.p0(jArr4, jArr2, jArr4);
        b.B1(29, jArr4, jArr3);
        b.p0(jArr3, jArr4, jArr3);
        b.B1(58, jArr3, jArr4);
        b.p0(jArr4, jArr3, jArr4);
        b.B1(116, jArr4, jArr3);
        b.p0(jArr3, jArr4, jArr3);
        b.g1(jArr3, jArr);
        return new l0(jArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.T(this.f5325g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5325g, 0, 4) ^ 2330074;
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.Y(this.f5325g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[4];
        b.p0(this.f5325g, ((l0) mVar).f5325g, jArr);
        return new l0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((l0) mVar).f5325g;
        long[] jArr2 = ((l0) mVar2).f5325g;
        long[] jArr3 = ((l0) mVar3).f5325g;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        b.F(this.f5325g, jArr, jArr5);
        b.m(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        b.F(jArr2, jArr3, jArr6);
        b.m(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        b.K0(jArr4, jArr7);
        return new l0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f5325g;
        long jA0 = x.e.A0(jArr2[0]);
        long jA02 = x.e.A0(jArr2[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long j8 = (jA0 >>> 32) | (jA02 & (-4294967296L));
        long jA03 = x.e.A0(jArr2[2]);
        int i8 = 3;
        long jA04 = x.e.A0(jArr2[3]);
        long j9 = (4294967295L & jA03) | (jA04 << 32);
        long j10 = (jA03 >>> 32) | (jA04 & (-4294967296L));
        long j11 = j10 >>> 27;
        long j12 = j10 ^ ((j8 >>> 27) | (j10 << 37));
        long j13 = j8 ^ (j8 << 37);
        long[] jArr3 = new long[8];
        int[] iArr = {32, 117, 191};
        int i9 = 0;
        while (i9 < i8) {
            int i10 = iArr[i9];
            int i11 = i10 >>> 6;
            int i12 = i10 & 63;
            jArr3[i11] = jArr3[i11] ^ (j13 << i12);
            int i13 = i11 + 1;
            int i14 = i8;
            int i15 = -i12;
            jArr3[i13] = jArr3[i13] ^ ((j12 << i12) | (j13 >>> i15));
            int i16 = i11 + 2;
            jArr3[i16] = jArr3[i16] ^ ((j11 << i12) | (j12 >>> i15));
            int i17 = i11 + 3;
            jArr3[i17] = jArr3[i17] ^ (j11 >>> i15);
            i9++;
            i8 = i14;
        }
        b.K0(jArr3, jArr);
        jArr[0] = jArr[0] ^ j4;
        jArr[1] = jArr[1] ^ j9;
        return new l0(jArr);
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[4];
        b.g1(this.f5325g, jArr);
        return new l0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((l0) mVar).f5325g;
        long[] jArr2 = ((l0) mVar2).f5325g;
        long[] jArr3 = new long[8];
        long[] jArr4 = new long[8];
        x.e.D(4, this.f5325g, jArr4);
        b.m(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        b.F(jArr, jArr2, jArr5);
        b.m(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[4];
        b.K0(jArr3, jArr6);
        return new l0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[4];
        b.B1(i8, this.f5325g, jArr);
        return new l0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5325g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.w0(this.f5325g);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        long[] jArr3 = this.f5325g;
        x.e.p(jArr3, jArr);
        for (int i8 = 1; i8 < 233; i8 += 2) {
            x.e.D(4, jArr, jArr2);
            b.K0(jArr2, jArr);
            x.e.D(4, jArr, jArr2);
            b.K0(jArr2, jArr);
            jArr[0] = jArr[0] ^ jArr3[0];
            jArr[1] = jArr[1] ^ jArr3[1];
            jArr[2] = jArr[2] ^ jArr3[2];
            jArr[3] = jArr[3] ^ jArr3[3];
        }
        return new l0(jArr);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        long[] jArr = this.f5325g;
        return ((int) (jArr[0] ^ (jArr[2] >>> 31))) & 1;
    }

    public l0(long[] jArr) {
        this.f5325g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
