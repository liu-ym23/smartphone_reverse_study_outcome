package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public final class y extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5379g;

    public y(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f5379g = x.f.R(113, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((y) mVar).f5379g;
        long[] jArr2 = this.f5379g;
        return new y(new long[]{jArr2[0] ^ jArr[0], jArr[1] ^ jArr2[1]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5379g;
        return new y(new long[]{jArr[0] ^ 1, jArr[1]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        long[] jArr = ((y) obj).f5379g;
        for (int i8 = 1; i8 >= 0; i8--) {
            if (this.f5379g[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return 113;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[2];
        for (int i8 = 0; i8 < 2; i8++) {
            long[] jArr2 = this.f5379g;
            if (jArr2[i8] != 0) {
                long[] jArr3 = new long[2];
                long[] jArr4 = new long[2];
                long[] jArr5 = new long[4];
                x.e.D(2, jArr2, jArr5);
                b.G0(jArr5, jArr3);
                b.l0(jArr3, jArr2, jArr3);
                long[] jArr6 = new long[4];
                x.e.D(2, jArr3, jArr6);
                b.G0(jArr6, jArr3);
                b.l0(jArr3, jArr2, jArr3);
                b.y1(3, jArr3, jArr4);
                b.l0(jArr4, jArr3, jArr4);
                long[] jArr7 = new long[4];
                x.e.D(2, jArr4, jArr7);
                b.G0(jArr7, jArr4);
                b.l0(jArr4, jArr2, jArr4);
                b.y1(7, jArr4, jArr3);
                b.l0(jArr3, jArr4, jArr3);
                b.y1(14, jArr3, jArr4);
                b.l0(jArr4, jArr3, jArr4);
                b.y1(28, jArr4, jArr3);
                b.l0(jArr3, jArr4, jArr3);
                b.y1(56, jArr3, jArr4);
                b.l0(jArr4, jArr3, jArr4);
                long[] jArr8 = new long[4];
                x.e.D(2, jArr4, jArr8);
                b.G0(jArr8, jArr);
                return new y(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // p7.m
    public final boolean h() {
        long[] jArr = this.f5379g;
        return jArr[0] == 1 && jArr[1] == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5379g, 0, 2) ^ 113009;
    }

    @Override // p7.m
    public final boolean i() {
        for (int i8 = 0; i8 < 2; i8++) {
            if (this.f5379g[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[2];
        b.l0(this.f5379g, ((y) mVar).f5379g, jArr);
        return new y(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((y) mVar).f5379g;
        long[] jArr2 = ((y) mVar2).f5379g;
        long[] jArr3 = ((y) mVar3).f5379g;
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[8];
        b.D(this.f5379g, jArr, jArr5);
        b.k(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        b.D(jArr2, jArr3, jArr6);
        b.k(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[2];
        b.G0(jArr4, jArr7);
        return new y(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = this.f5379g;
        long jA0 = x.e.A0(jArr[0]);
        long jA02 = x.e.A0(jArr[1]);
        long j4 = (4294967295L & jA0) | (jA02 << 32);
        long j8 = (jA0 >>> 32) | (jA02 & (-4294967296L));
        return new y(new long[]{((j8 << 57) ^ j4) ^ (j8 << 5), (j8 >>> 59) ^ (j8 >>> 7)});
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[2];
        long[] jArr2 = new long[4];
        x.e.D(2, this.f5379g, jArr2);
        b.G0(jArr2, jArr);
        return new y(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((y) mVar).f5379g;
        long[] jArr2 = ((y) mVar2).f5379g;
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        x.e.D(2, this.f5379g, jArr4);
        b.k(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        b.D(jArr, jArr2, jArr5);
        b.k(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[2];
        b.G0(jArr3, jArr6);
        return new y(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[2];
        b.y1(i8, this.f5379g, jArr);
        return new y(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5379g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        byte[] bArr = new byte[16];
        for (int i8 = 0; i8 < 2; i8++) {
            long j4 = this.f5379g[i8];
            if (j4 != 0) {
                Pack.longToBigEndian(j4, bArr, (1 - i8) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f5379g;
        long[] jArr3 = {jArr2[0], jArr2[1]};
        for (int i8 = 1; i8 < 113; i8 += 2) {
            x.e.D(2, jArr3, jArr);
            b.G0(jArr, jArr3);
            x.e.D(2, jArr3, jArr);
            b.G0(jArr, jArr3);
            jArr3[0] = jArr3[0] ^ jArr2[0];
            jArr3[1] = jArr3[1] ^ jArr2[1];
        }
        return new y(jArr3);
    }

    @Override // p7.i
    public final int w() {
        return ((int) this.f5379g[0]) & 1;
    }

    public y(long[] jArr) {
        this.f5379g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
