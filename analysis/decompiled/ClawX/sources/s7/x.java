package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class x extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5373h = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5374g;

    public x(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5373h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        int[] iArrO = x.f.O(521, bigInteger);
        if (x.f.I(17, iArrO, b.D)) {
            for (int i8 = 0; i8 < 17; i8++) {
                iArrO[i8] = 0;
            }
        }
        this.f5374g = iArrO;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[17];
        b.d(this.f5374g, ((x) mVar).f5374g, iArr);
        return new x(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[17];
        int[] iArr2 = this.f5374g;
        int iB0 = x.f.b0(16, iArr2, iArr) + iArr2[16];
        if (iB0 > 511 || (iB0 == 511 && x.f.I(16, iArr, b.D))) {
            iB0 = (x.f.c0(iArr) + iB0) & 511;
        }
        iArr[16] = iB0;
        return new x(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[17];
        x.f.s(b.D, ((x) mVar).f5374g, iArr);
        int[] iArr2 = new int[33];
        b.y(iArr, this.f5374g, iArr2);
        b.A0(iArr2, iArr);
        return new x(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            return x.f.I(17, this.f5374g, ((x) obj).f5374g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5373h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[17];
        x.f.s(b.D, this.f5374g, iArr);
        return new x(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.f.g0(17, this.f5374g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5374g, 0, 17) ^ f5373h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.f.k0(17, this.f5374g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[17];
        int[] iArr2 = new int[33];
        b.y(this.f5374g, ((x) mVar).f5374g, iArr2);
        b.A0(iArr2, iArr);
        return new x(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[17];
        int[] iArr3 = b.D;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5374g;
            if (i8 >= 17) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.f.C0(iArr3, iArr3, 17, iArr2);
        } else {
            x.f.C0(iArr3, iArr, 17, iArr2);
        }
        return new x(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5374g;
        if (x.f.k0(17, iArr) || x.f.g0(17, iArr)) {
            return this;
        }
        int[] iArr2 = new int[33];
        int[] iArr3 = new int[17];
        int[] iArr4 = new int[17];
        b.S(iArr, iArr2);
        b.A0(iArr2, iArr3);
        int i8 = 519;
        while (true) {
            i8--;
            if (i8 <= 0) {
                break;
            }
            b.S(iArr3, iArr2);
            b.A0(iArr2, iArr3);
        }
        b.S(iArr3, iArr2);
        b.A0(iArr2, iArr4);
        if (x.f.I(17, iArr, iArr4)) {
            return new x(iArr3);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[17];
        int[] iArr2 = new int[33];
        b.S(this.f5374g, iArr2);
        b.A0(iArr2, iArr);
        return new x(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[17];
        b.G1(this.f5374g, ((x) mVar).f5374g, iArr);
        return new x(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.f.U(this.f5374g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.f.K0(17, this.f5374g);
    }

    public x(int[] iArr) {
        this.f5374g = iArr;
    }
}
