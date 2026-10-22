package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class i0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5313g;

    public i0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f5313g = x.f.R(193, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((i0) mVar).f5313g;
        long[] jArr2 = this.f5313g;
        return new i0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr[3] ^ jArr2[3]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5313g;
        return new i0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i0) {
            return x.e.A(this.f5313g, ((i0) obj).f5313g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return 193;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f5313g;
        if (x.e.Y(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[8];
        b.W(jArr2, jArr5);
        b.I0(jArr5, jArr3);
        b.A1(1, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(1, jArr4, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(3, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(6, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(12, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(24, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(48, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr3);
        b.A1(96, jArr3, jArr4);
        b.n0(jArr3, jArr4, jArr);
        return new i0(jArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.T(this.f5313g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5313g, 0, 4) ^ 1930015;
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.Y(this.f5313g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[4];
        b.n0(this.f5313g, ((i0) mVar).f5313g, jArr);
        return new i0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((i0) mVar).f5313g;
        long[] jArr2 = ((i0) mVar2).f5313g;
        long[] jArr3 = ((i0) mVar3).f5313g;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        b.E(this.f5313g, jArr, jArr5);
        b.l(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        b.E(jArr2, jArr3, jArr6);
        b.l(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        b.I0(jArr4, jArr7);
        return new i0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = this.f5313g;
        long jA0 = x.e.A0(jArr[0]);
        long jA02 = x.e.A0(jArr[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long j8 = (jA0 >>> 32) | (jA02 & (-4294967296L));
        long jA03 = x.e.A0(jArr[2]);
        long j9 = jA03 >>> 32;
        return new i0(new long[]{j4 ^ (j8 << 8), ((((jA03 & 4294967295L) ^ (jArr[3] << 32)) ^ (j9 << 8)) ^ (j8 >>> 56)) ^ (j8 << 33), (j8 >>> 31) ^ (j9 << 33), jA03 >>> 63});
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        b.W(this.f5313g, jArr2);
        b.I0(jArr2, jArr);
        return new i0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((i0) mVar).f5313g;
        long[] jArr2 = ((i0) mVar2).f5313g;
        long[] jArr3 = new long[8];
        long[] jArr4 = new long[8];
        b.W(this.f5313g, jArr4);
        b.l(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        b.E(jArr, jArr2, jArr5);
        b.l(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[4];
        b.I0(jArr3, jArr6);
        return new i0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[4];
        b.A1(i8, this.f5313g, jArr);
        return new i0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5313g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.w0(this.f5313g);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        long[] jArr3 = this.f5313g;
        x.e.p(jArr3, jArr);
        for (int i8 = 1; i8 < 193; i8 += 2) {
            b.W(jArr, jArr2);
            b.I0(jArr2, jArr);
            b.W(jArr, jArr2);
            b.I0(jArr2, jArr);
            jArr[0] = jArr[0] ^ jArr3[0];
            jArr[1] = jArr[1] ^ jArr3[1];
            jArr[2] = jArr[2] ^ jArr3[2];
            jArr[3] = jArr[3] ^ jArr3[3];
        }
        return new i0(jArr);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        return ((int) this.f5313g[0]) & 1;
    }

    public i0(long[] jArr) {
        this.f5313g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
