package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class b0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5283g;

    public b0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f5283g = x.f.R(131, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((b0) mVar).f5283g;
        long[] jArr2 = this.f5283g;
        return new b0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr[2] ^ jArr2[2]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5283g;
        return new b0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        long[] jArr = ((b0) obj).f5283g;
        for (int i8 = 2; i8 >= 0; i8--) {
            if (this.f5283g[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return 131;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[3];
        long[] jArr2 = this.f5283g;
        if (x.e.X(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[3];
        long[] jArr4 = new long[3];
        long[] jArr5 = new long[5];
        b.T(jArr2, jArr5);
        b.x0(jArr5, jArr3);
        b.a0(jArr3, jArr2, jArr3);
        b.n1(2, jArr3, jArr4);
        b.a0(jArr4, jArr3, jArr4);
        b.n1(4, jArr4, jArr3);
        b.a0(jArr3, jArr4, jArr3);
        b.n1(8, jArr3, jArr4);
        b.a0(jArr4, jArr3, jArr4);
        b.n1(16, jArr4, jArr3);
        b.a0(jArr3, jArr4, jArr3);
        b.n1(32, jArr3, jArr4);
        b.a0(jArr4, jArr3, jArr4);
        long[] jArr6 = new long[5];
        b.T(jArr4, jArr6);
        b.x0(jArr6, jArr4);
        b.a0(jArr4, jArr2, jArr4);
        b.n1(65, jArr4, jArr3);
        b.a0(jArr3, jArr4, jArr3);
        long[] jArr7 = new long[5];
        b.T(jArr3, jArr7);
        b.x0(jArr7, jArr);
        return new b0(jArr);
    }

    @Override // p7.m
    public final boolean h() {
        long[] jArr = this.f5283g;
        if (jArr[0] == 1) {
            for (int i8 = 1; i8 < 3; i8++) {
                if (jArr[i8] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5283g, 0, 3) ^ 131832;
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.X(this.f5283g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[3];
        b.a0(this.f5283g, ((b0) mVar).f5283g, jArr);
        return new b0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((b0) mVar).f5283g;
        long[] jArr2 = ((b0) mVar2).f5283g;
        long[] jArr3 = ((b0) mVar3).f5283g;
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[8];
        b.z(this.f5283g, jArr, jArr5);
        b.g(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        b.z(jArr2, jArr3, jArr6);
        b.g(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[3];
        b.x0(jArr4, jArr7);
        return new b0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = new long[3];
        long[] jArr2 = this.f5283g;
        long jA0 = x.e.A0(jArr2[0]);
        long jA02 = x.e.A0(jArr2[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long jA03 = x.e.A0(jArr2[2]);
        b.a0(new long[]{(jA0 >>> 32) | (jA02 & (-4294967296L)), jA03 >>> 32, 0}, b.E, jArr);
        jArr[0] = jArr[0] ^ j4;
        jArr[1] = jArr[1] ^ (jA03 & 4294967295L);
        return new b0(jArr);
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[3];
        long[] jArr2 = new long[5];
        b.T(this.f5283g, jArr2);
        b.x0(jArr2, jArr);
        return new b0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((b0) mVar).f5283g;
        long[] jArr2 = ((b0) mVar2).f5283g;
        long[] jArr3 = new long[5];
        long[] jArr4 = new long[5];
        b.T(this.f5283g, jArr4);
        b.g(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        b.z(jArr, jArr2, jArr5);
        b.g(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[3];
        b.x0(jArr3, jArr6);
        return new b0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[3];
        b.n1(i8, this.f5283g, jArr);
        return new b0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5283g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.v0(this.f5283g);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[5];
        long[] jArr2 = this.f5283g;
        long[] jArr3 = {jArr2[0], jArr2[1], jArr2[2]};
        for (int i8 = 1; i8 < 131; i8 += 2) {
            b.T(jArr3, jArr);
            b.x0(jArr, jArr3);
            b.T(jArr3, jArr);
            b.x0(jArr, jArr3);
            jArr3[0] = jArr3[0] ^ jArr2[0];
            jArr3[1] = jArr3[1] ^ jArr2[1];
            jArr3[2] = jArr3[2] ^ jArr2[2];
        }
        return new b0(jArr3);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        long[] jArr = this.f5283g;
        return ((int) ((jArr[0] ^ (jArr[1] >>> 59)) ^ (jArr[2] >>> 1))) & 1;
    }

    public b0(long[] jArr) {
        this.f5283g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
