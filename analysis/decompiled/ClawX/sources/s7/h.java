package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class h extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5306h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5307g;

    public h(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5306h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        int[] iArrP = x.f.P(bigInteger);
        if (iArrP[4] == -1) {
            int[] iArr = b.f5265g;
            if (x.f.Y(iArrP, iArr)) {
                x.f.J0(iArr, iArrP);
            }
        }
        this.f5307g = iArrP;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[5];
        if (x.f.b(this.f5307g, ((h) mVar).f5307g, iArr) != 0 || (iArr[4] == -1 && x.f.Y(iArr, b.f5265g))) {
            x.f.e(5, 21389, iArr);
        }
        return new h(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[5];
        if (x.f.b0(5, this.f5307g, iArr) != 0 || (iArr[4] == -1 && x.f.Y(iArr, b.f5265g))) {
            x.f.e(5, 21389, iArr);
        }
        return new h(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[5];
        x.f.s(b.f5265g, ((h) mVar).f5307g, iArr);
        b.e0(iArr, this.f5307g, iArr);
        return new h(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            return x.f.J(this.f5307g, ((h) obj).f5307g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5306h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[5];
        x.f.s(b.f5265g, this.f5307g, iArr);
        return new h(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.f.h0(this.f5307g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5307g, 0, 5) ^ f5306h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.f.l0(this.f5307g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[5];
        b.e0(this.f5307g, ((h) mVar).f5307g, iArr);
        return new h(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[5];
        int[] iArr3 = b.f5265g;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5307g;
            if (i8 >= 5) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.f.D0(iArr3, iArr3, iArr2);
        } else {
            x.f.D0(iArr3, iArr, iArr2);
        }
        return new h(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5307g;
        if (x.f.l0(iArr) || x.f.h0(iArr)) {
            return this;
        }
        int[] iArr2 = new int[5];
        b.f1(iArr, iArr2);
        b.e0(iArr2, iArr, iArr2);
        int[] iArr3 = new int[5];
        b.f1(iArr2, iArr3);
        b.e0(iArr3, iArr, iArr3);
        int[] iArr4 = new int[5];
        b.f1(iArr3, iArr4);
        b.e0(iArr4, iArr, iArr4);
        int[] iArr5 = new int[5];
        b.s1(3, iArr4, iArr5);
        b.e0(iArr5, iArr3, iArr5);
        b.s1(7, iArr5, iArr4);
        b.e0(iArr4, iArr5, iArr4);
        b.s1(3, iArr4, iArr5);
        b.e0(iArr5, iArr3, iArr5);
        int[] iArr6 = new int[5];
        b.s1(14, iArr5, iArr6);
        b.e0(iArr6, iArr4, iArr6);
        b.s1(31, iArr6, iArr4);
        b.e0(iArr4, iArr6, iArr4);
        b.s1(62, iArr4, iArr6);
        b.e0(iArr6, iArr4, iArr6);
        b.s1(3, iArr6, iArr4);
        b.e0(iArr4, iArr3, iArr4);
        b.s1(18, iArr4, iArr4);
        b.e0(iArr4, iArr5, iArr4);
        b.s1(2, iArr4, iArr4);
        b.e0(iArr4, iArr, iArr4);
        b.s1(3, iArr4, iArr4);
        b.e0(iArr4, iArr2, iArr4);
        b.s1(6, iArr4, iArr4);
        b.e0(iArr4, iArr3, iArr4);
        b.s1(2, iArr4, iArr4);
        b.e0(iArr4, iArr, iArr4);
        b.f1(iArr4, iArr2);
        if (x.f.J(iArr, iArr2)) {
            return new h(iArr4);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[5];
        b.f1(this.f5307g, iArr);
        return new h(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[5];
        b.H1(this.f5307g, ((h) mVar).f5307g, iArr);
        return new h(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.f.S(this.f5307g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.f.L0(this.f5307g);
    }

    public h(int[] iArr) {
        this.f5307g = iArr;
    }
}
