package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class n extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5331h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f5332i = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5333g;

    public n(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5331h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        int[] iArrQ = x.f.Q(bigInteger);
        if (iArrQ[6] == -1 && x.f.Z(iArrQ, b.f5274p)) {
            x.f.e(7, 6803, iArrQ);
        }
        this.f5333g = iArrQ;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[7];
        if (x.f.c(this.f5333g, ((n) mVar).f5333g, iArr) != 0 || (iArr[6] == -1 && x.f.Z(iArr, b.f5274p))) {
            x.f.e(7, 6803, iArr);
        }
        return new n(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[7];
        if (x.f.b0(7, this.f5333g, iArr) != 0 || (iArr[6] == -1 && x.f.Z(iArr, b.f5274p))) {
            x.f.e(7, 6803, iArr);
        }
        return new n(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[7];
        x.f.s(b.f5274p, ((n) mVar).f5333g, iArr);
        b.m0(iArr, this.f5333g, iArr);
        return new n(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return x.f.K(this.f5333g, ((n) obj).f5333g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5331h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[7];
        x.f.s(b.f5274p, this.f5333g, iArr);
        return new n(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.f.i0(this.f5333g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5333g, 0, 7) ^ f5331h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.f.m0(this.f5333g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[7];
        b.m0(this.f5333g, ((n) mVar).f5333g, iArr);
        return new n(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[7];
        int[] iArr3 = b.f5274p;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5333g;
            if (i8 >= 7) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.f.F0(iArr3, iArr3, iArr2);
        } else {
            x.f.F0(iArr3, iArr, iArr2);
        }
        return new n(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5333g;
        if (x.f.m0(iArr) || x.f.i0(iArr)) {
            return this;
        }
        int[] iArr2 = new int[7];
        b.k1(iArr, iArr2);
        b.m0(iArr2, iArr, iArr2);
        b.k1(iArr2, iArr2);
        b.m0(iArr2, iArr, iArr2);
        int[] iArr3 = new int[7];
        b.k1(iArr2, iArr3);
        b.m0(iArr3, iArr, iArr3);
        int[] iArr4 = new int[7];
        b.z1(4, iArr3, iArr4);
        b.m0(iArr4, iArr3, iArr4);
        int[] iArr5 = new int[7];
        b.z1(3, iArr4, iArr5);
        b.m0(iArr5, iArr2, iArr5);
        b.z1(8, iArr5, iArr5);
        b.m0(iArr5, iArr4, iArr5);
        b.z1(4, iArr5, iArr4);
        b.m0(iArr4, iArr3, iArr4);
        b.z1(19, iArr4, iArr3);
        b.m0(iArr3, iArr5, iArr3);
        int[] iArr6 = new int[7];
        b.z1(42, iArr3, iArr6);
        b.m0(iArr6, iArr3, iArr6);
        b.z1(23, iArr6, iArr3);
        b.m0(iArr3, iArr4, iArr3);
        b.z1(84, iArr3, iArr4);
        b.m0(iArr4, iArr6, iArr4);
        b.z1(20, iArr4, iArr4);
        b.m0(iArr4, iArr5, iArr4);
        b.z1(3, iArr4, iArr4);
        b.m0(iArr4, iArr, iArr4);
        b.z1(2, iArr4, iArr4);
        b.m0(iArr4, iArr, iArr4);
        b.z1(4, iArr4, iArr4);
        b.m0(iArr4, iArr2, iArr4);
        b.k1(iArr4, iArr4);
        b.k1(iArr4, iArr6);
        if (x.f.K(iArr, iArr6)) {
            return new n(iArr4);
        }
        b.m0(iArr4, f5332i, iArr4);
        b.k1(iArr4, iArr6);
        if (x.f.K(iArr, iArr6)) {
            return new n(iArr4);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[7];
        b.k1(this.f5333g, iArr);
        return new n(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[7];
        b.K1(this.f5333g, ((n) mVar).f5333g, iArr);
        return new n(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.f.T(this.f5333g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.f.M0(this.f5333g);
    }

    public n(int[] iArr) {
        this.f5333g = iArr;
    }
}
