package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class e0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5296g;

    public e0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f5296g = x.f.R(163, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((e0) mVar).f5296g;
        long[] jArr2 = this.f5296g;
        return new e0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr[2] ^ jArr2[2]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5296g;
        return new e0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        long[] jArr = ((e0) obj).f5296g;
        for (int i8 = 2; i8 >= 0; i8--) {
            if (this.f5296g[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return 163;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[3];
        long[] jArr2 = this.f5296g;
        if (x.e.X(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[3];
        long[] jArr4 = new long[3];
        long[] jArr5 = new long[6];
        x.e.D(3, jArr2, jArr5);
        b.z0(jArr5, jArr3);
        b.q1(1, jArr3, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(1, jArr4, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(3, jArr3, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(3, jArr4, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(9, jArr3, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(9, jArr4, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(27, jArr3, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(27, jArr4, jArr4);
        b.d0(jArr3, jArr4, jArr3);
        b.q1(81, jArr3, jArr4);
        b.d0(jArr3, jArr4, jArr);
        return new e0(jArr);
    }

    @Override // p7.m
    public final boolean h() {
        long[] jArr = this.f5296g;
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
        return Arrays.hashCode(this.f5296g, 0, 3) ^ 163763;
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.X(this.f5296g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[3];
        b.d0(this.f5296g, ((e0) mVar).f5296g, jArr);
        return new e0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((e0) mVar).f5296g;
        long[] jArr2 = ((e0) mVar2).f5296g;
        long[] jArr3 = ((e0) mVar3).f5296g;
        long[] jArr4 = new long[6];
        long[] jArr5 = new long[8];
        b.A(this.f5296g, jArr, jArr5);
        b.h(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        b.A(jArr2, jArr3, jArr6);
        b.h(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[3];
        b.z0(jArr4, jArr7);
        return new e0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = new long[3];
        long[] jArr2 = this.f5296g;
        long jA0 = x.e.A0(jArr2[0]);
        long jA02 = x.e.A0(jArr2[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long jA03 = x.e.A0(jArr2[2]);
        b.d0(new long[]{(jA0 >>> 32) | (jA02 & (-4294967296L)), jA03 >>> 32, 0}, b.F, jArr);
        jArr[0] = jArr[0] ^ j4;
        jArr[1] = jArr[1] ^ (jA03 & 4294967295L);
        return new e0(jArr);
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[3];
        long[] jArr2 = new long[6];
        x.e.D(3, this.f5296g, jArr2);
        b.z0(jArr2, jArr);
        return new e0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((e0) mVar).f5296g;
        long[] jArr2 = ((e0) mVar2).f5296g;
        long[] jArr3 = new long[6];
        long[] jArr4 = new long[6];
        x.e.D(3, this.f5296g, jArr4);
        b.h(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        b.A(jArr, jArr2, jArr5);
        b.h(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[3];
        b.z0(jArr3, jArr6);
        return new e0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[3];
        b.q1(i8, this.f5296g, jArr);
        return new e0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5296g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.v0(this.f5296g);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[6];
        long[] jArr2 = this.f5296g;
        long[] jArr3 = {jArr2[0], jArr2[1], jArr2[2]};
        for (int i8 = 1; i8 < 163; i8 += 2) {
            x.e.D(3, jArr3, jArr);
            b.z0(jArr, jArr3);
            x.e.D(3, jArr3, jArr);
            b.z0(jArr, jArr3);
            jArr3[0] = jArr3[0] ^ jArr2[0];
            jArr3[1] = jArr3[1] ^ jArr2[1];
            jArr3[2] = jArr3[2] ^ jArr2[2];
        }
        return new e0(jArr3);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        long[] jArr = this.f5296g;
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }

    public e0(long[] jArr) {
        this.f5296g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
