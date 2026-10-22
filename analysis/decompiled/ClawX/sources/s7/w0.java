package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public final class w0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public long[] f5372g;

    public w0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f5372g = x.f.R(571, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = new long[9];
        b.b(this.f5372g, ((w0) mVar).f5372g, jArr);
        return new w0(jArr);
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = new long[9];
        long[] jArr2 = this.f5372g;
        jArr[0] = jArr2[0] ^ 1;
        for (int i8 = 1; i8 < 9; i8++) {
            jArr[i8] = jArr2[i8];
        }
        return new w0(jArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        long[] jArr = this.f5372g;
        long[] jArr2 = ((w0) obj).f5372g;
        for (int i8 = 8; i8 >= 0; i8--) {
            if (jArr[i8] != jArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return 571;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[9];
        long[] jArr2 = this.f5372g;
        if (x.e.Z(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        long[] jArr5 = new long[9];
        b.e1(jArr2, jArr5);
        b.e1(jArr5, jArr3);
        b.e1(jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(2, jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.j0(jArr3, jArr5, jArr3);
        b.w1(5, jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(5, jArr4, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(15, jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr5);
        b.w1(30, jArr5, jArr3);
        b.w1(30, jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(60, jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(60, jArr4, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(180, jArr3, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.w1(180, jArr4, jArr4);
        b.j0(jArr3, jArr4, jArr3);
        b.j0(jArr3, jArr5, jArr);
        return new w0(jArr);
    }

    @Override // p7.m
    public final boolean h() {
        long[] jArr = this.f5372g;
        if (jArr[0] == 1) {
            for (int i8 = 1; i8 < 9; i8++) {
                if (jArr[i8] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5372g, 0, 9) ^ 5711052;
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.Z(this.f5372g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[9];
        b.j0(this.f5372g, ((w0) mVar).f5372g, jArr);
        return new w0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = this.f5372g;
        long[] jArr2 = ((w0) mVar).f5372g;
        long[] jArr3 = ((w0) mVar2).f5372g;
        long[] jArr4 = ((w0) mVar3).f5372g;
        long[] jArr5 = new long[18];
        b.t0(jArr, jArr2, jArr5);
        b.t0(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[9];
        b.E0(jArr5, jArr6);
        return new w0(jArr6);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = new long[9];
        long[] jArr2 = this.f5372g;
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i8 + 1;
            long jA0 = x.e.A0(jArr2[i8]);
            i8 += 2;
            long jA02 = x.e.A0(jArr2[i10]);
            jArr3[i9] = (4294967295L & jA0) | (jA02 << 32);
            jArr4[i9] = (jA0 >>> 32) | ((-4294967296L) & jA02);
        }
        long jA03 = x.e.A0(jArr2[i8]);
        jArr3[4] = 4294967295L & jA03;
        jArr4[4] = jA03 >>> 32;
        b.j0(jArr4, b.H, jArr);
        b.b(jArr, jArr3, jArr);
        return new w0(jArr);
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[9];
        b.e1(this.f5372g, jArr);
        return new w0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = this.f5372g;
        long[] jArr2 = ((w0) mVar).f5372g;
        long[] jArr3 = ((w0) mVar2).f5372g;
        long[] jArr4 = new long[18];
        long[] jArr5 = new long[18];
        b.V(jArr, jArr5);
        b.j(jArr4, jArr5, jArr4);
        b.t0(jArr2, jArr3, jArr4);
        long[] jArr6 = new long[9];
        b.E0(jArr4, jArr6);
        return new w0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[9];
        b.w1(i8, this.f5372g, jArr);
        return new w0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5372g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        long[] jArr = this.f5372g;
        byte[] bArr = new byte[72];
        for (int i8 = 0; i8 < 9; i8++) {
            long j4 = jArr[i8];
            if (j4 != 0) {
                Pack.longToBigEndian(j4, bArr, (8 - i8) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[9];
        long[] jArr2 = this.f5372g;
        long[] jArr3 = new long[18];
        jArr[0] = jArr2[0];
        jArr[1] = jArr2[1];
        jArr[2] = jArr2[2];
        jArr[3] = jArr2[3];
        jArr[4] = jArr2[4];
        jArr[5] = jArr2[5];
        jArr[6] = jArr2[6];
        jArr[7] = jArr2[7];
        jArr[8] = jArr2[8];
        for (int i8 = 1; i8 < 571; i8 += 2) {
            b.V(jArr, jArr3);
            b.E0(jArr3, jArr);
            b.V(jArr, jArr3);
            b.E0(jArr3, jArr);
            for (int i9 = 0; i9 < 9; i9++) {
                jArr[i9] = jArr[i9] ^ jArr2[i9];
            }
        }
        return new w0(jArr);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        long[] jArr = this.f5372g;
        long j4 = jArr[0];
        long j8 = jArr[8];
        return ((int) ((j4 ^ (j8 >>> 49)) ^ (j8 >>> 57))) & 1;
    }

    public w0(long[] jArr) {
        this.f5372g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
