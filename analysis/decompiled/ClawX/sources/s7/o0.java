package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class o0 extends p7.i {

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5339g;

    public o0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f5339g = x.f.R(239, bigInteger);
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        long[] jArr = ((o0) mVar).f5339g;
        long[] jArr2 = this.f5339g;
        return new o0(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr[3] ^ jArr2[3]});
    }

    @Override // p7.m
    public final p7.m b() {
        long[] jArr = this.f5339g;
        return new o0(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o0) {
            return x.e.A(this.f5339g, ((o0) obj).f5339g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return 239;
    }

    @Override // p7.m
    public final p7.m g() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f5339g;
        if (x.e.Y(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        b.i1(jArr2, jArr3);
        b.q0(jArr3, jArr2, jArr3);
        b.i1(jArr3, jArr3);
        b.q0(jArr3, jArr2, jArr3);
        b.C1(3, jArr3, jArr4);
        b.q0(jArr4, jArr3, jArr4);
        b.i1(jArr4, jArr4);
        b.q0(jArr4, jArr2, jArr4);
        b.C1(7, jArr4, jArr3);
        b.q0(jArr3, jArr4, jArr3);
        b.C1(14, jArr3, jArr4);
        b.q0(jArr4, jArr3, jArr4);
        b.i1(jArr4, jArr4);
        b.q0(jArr4, jArr2, jArr4);
        b.C1(29, jArr4, jArr3);
        b.q0(jArr3, jArr4, jArr3);
        b.i1(jArr3, jArr3);
        b.q0(jArr3, jArr2, jArr3);
        b.C1(59, jArr3, jArr4);
        b.q0(jArr4, jArr3, jArr4);
        b.i1(jArr4, jArr4);
        b.q0(jArr4, jArr2, jArr4);
        b.C1(119, jArr4, jArr3);
        b.q0(jArr3, jArr4, jArr3);
        b.i1(jArr3, jArr);
        return new o0(jArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.T(this.f5339g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5339g, 0, 4) ^ 23900158;
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.Y(this.f5339g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        long[] jArr = new long[4];
        b.q0(this.f5339g, ((o0) mVar).f5339g, jArr);
        return new o0(jArr);
    }

    @Override // p7.m
    public final p7.m k(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final p7.m l(p7.m mVar, p7.m mVar2, p7.m mVar3) {
        long[] jArr = ((o0) mVar).f5339g;
        long[] jArr2 = ((o0) mVar2).f5339g;
        long[] jArr3 = ((o0) mVar3).f5339g;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        b.G(this.f5339g, jArr, jArr5);
        b.n(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        b.G(jArr2, jArr3, jArr6);
        b.n(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        b.M0(jArr4, jArr7);
        return new o0(jArr7);
    }

    @Override // p7.m
    public final p7.m n() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f5339g;
        boolean z = false;
        long jA0 = x.e.A0(jArr2[0]);
        boolean z2 = true;
        long jA02 = x.e.A0(jArr2[1]);
        long j4 = (jA0 & 4294967295L) | (jA02 << 32);
        long j8 = (jA0 >>> 32) | (jA02 & (-4294967296L));
        long jA03 = x.e.A0(jArr2[2]);
        long jA04 = x.e.A0(jArr2[3]);
        long j9 = (jA03 & 4294967295L) | (jA04 << 32);
        long j10 = (jA03 >>> 32) | (jA04 & (-4294967296L));
        long j11 = j10 >>> 49;
        long j12 = (j8 >>> 49) | (j10 << 15);
        long j13 = j10 ^ (j8 << 15);
        long[] jArr3 = new long[8];
        int[] iArr = {39, 120};
        int i8 = 0;
        while (i8 < 2) {
            int i9 = iArr[i8];
            int i10 = i9 >>> 6;
            boolean z8 = z;
            int i11 = i9 & 63;
            jArr3[i10] = jArr3[i10] ^ (j8 << i11);
            int i12 = i10 + 1;
            boolean z9 = z2;
            int i13 = -i11;
            jArr3[i12] = jArr3[i12] ^ ((j13 << i11) | (j8 >>> i13));
            int i14 = i10 + 2;
            jArr3[i14] = jArr3[i14] ^ ((j12 << i11) | (j13 >>> i13));
            int i15 = i10 + 3;
            jArr3[i15] = jArr3[i15] ^ ((j11 << i11) | (j12 >>> i13));
            int i16 = i10 + 4;
            jArr3[i16] = jArr3[i16] ^ (j11 >>> i13);
            i8++;
            z = z8;
            z2 = z9;
        }
        boolean z10 = z;
        boolean z11 = z2;
        b.M0(jArr3, jArr);
        jArr[z10 ? 1 : 0] = jArr[z10 ? 1 : 0] ^ j4;
        jArr[z11 ? 1 : 0] = jArr[z11 ? 1 : 0] ^ j9;
        return new o0(jArr);
    }

    @Override // p7.m
    public final p7.m o() {
        long[] jArr = new long[4];
        b.i1(this.f5339g, jArr);
        return new o0(jArr);
    }

    @Override // p7.m
    public final p7.m p(p7.m mVar, p7.m mVar2) {
        long[] jArr = ((o0) mVar).f5339g;
        long[] jArr2 = ((o0) mVar2).f5339g;
        long[] jArr3 = new long[8];
        long[] jArr4 = new long[8];
        x.e.D(4, this.f5339g, jArr4);
        b.n(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        b.G(jArr, jArr2, jArr5);
        b.n(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[4];
        b.M0(jArr3, jArr6);
        return new o0(jArr6);
    }

    @Override // p7.m
    public final p7.m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        long[] jArr = new long[4];
        b.C1(i8, this.f5339g, jArr);
        return new o0(jArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5339g[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.w0(this.f5339g);
    }

    @Override // p7.i
    public final p7.m u() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        long[] jArr3 = this.f5339g;
        x.e.p(jArr3, jArr);
        for (int i8 = 1; i8 < 239; i8 += 2) {
            x.e.D(4, jArr, jArr2);
            b.M0(jArr2, jArr);
            x.e.D(4, jArr, jArr2);
            b.M0(jArr2, jArr);
            jArr[0] = jArr[0] ^ jArr3[0];
            jArr[1] = jArr[1] ^ jArr3[1];
            jArr[2] = jArr[2] ^ jArr3[2];
            jArr[3] = jArr[3] ^ jArr3[3];
        }
        return new o0(jArr);
    }

    @Override // p7.i
    public final boolean v() {
        return true;
    }

    @Override // p7.i
    public final int w() {
        long[] jArr = this.f5339g;
        return ((int) ((jArr[0] ^ (jArr[1] >>> 17)) ^ (jArr[2] >>> 34))) & 1;
    }

    public o0(long[] jArr) {
        this.f5339g = jArr;
    }

    @Override // p7.m
    public final p7.m m() {
        return this;
    }
}
