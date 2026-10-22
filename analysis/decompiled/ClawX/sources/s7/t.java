package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class t extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5357h = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5358g;

    public t(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5357h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        int[] iArrI = x.e.I(bigInteger);
        if (iArrI[7] == -1) {
            int[] iArr = b.y;
            if (x.e.P(iArrI, iArr)) {
                x.e.r0(iArr, iArrI);
            }
        }
        this.f5358g = iArrI;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[8];
        if (x.e.c(this.f5358g, ((t) mVar).f5358g, iArr) != 0 || (iArr[7] == -1 && x.e.P(iArr, b.y))) {
            b.r(iArr);
        }
        return new t(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[8];
        if (x.f.b0(8, this.f5358g, iArr) != 0 || (iArr[7] == -1 && x.e.P(iArr, b.y))) {
            b.r(iArr);
        }
        return new t(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[8];
        x.f.s(b.y, ((t) mVar).f5358g, iArr);
        int[] iArr2 = new int[16];
        x.e.c0(iArr, this.f5358g, iArr2);
        b.N0(iArr2, iArr);
        return new t(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            return x.e.z(this.f5358g, ((t) obj).f5358g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5357h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[8];
        x.f.s(b.y, this.f5358g, iArr);
        return new t(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.S(this.f5358g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5358g, 0, 8) ^ f5357h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.W(this.f5358g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        x.e.c0(this.f5358g, ((t) mVar).f5358g, iArr2);
        b.N0(iArr2, iArr);
        return new t(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[8];
        int[] iArr3 = b.y;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5358g;
            if (i8 >= 8) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.e.p0(iArr3, iArr3, iArr2);
        } else {
            x.e.p0(iArr3, iArr, iArr2);
        }
        return new t(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5358g;
        if (x.e.W(iArr) || x.e.S(iArr)) {
            return this;
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[8];
        x.e.j0(iArr, iArr2);
        b.N0(iArr2, iArr3);
        x.e.c0(iArr3, iArr, iArr2);
        b.N0(iArr2, iArr3);
        b.r1(iArr3, iArr4, 2, iArr2);
        x.e.c0(iArr4, iArr3, iArr2);
        b.N0(iArr2, iArr4);
        b.r1(iArr4, iArr3, 4, iArr2);
        x.e.c0(iArr3, iArr4, iArr2);
        b.N0(iArr2, iArr3);
        b.r1(iArr3, iArr4, 8, iArr2);
        x.e.c0(iArr4, iArr3, iArr2);
        b.N0(iArr2, iArr4);
        b.r1(iArr4, iArr3, 16, iArr2);
        x.e.c0(iArr3, iArr4, iArr2);
        b.N0(iArr2, iArr3);
        b.r1(iArr3, iArr3, 32, iArr2);
        x.e.c0(iArr3, iArr, iArr2);
        b.N0(iArr2, iArr3);
        b.r1(iArr3, iArr3, 96, iArr2);
        x.e.c0(iArr3, iArr, iArr2);
        b.N0(iArr2, iArr3);
        b.r1(iArr3, iArr3, 94, iArr2);
        x.e.j0(iArr3, iArr2);
        b.N0(iArr2, iArr4);
        if (x.e.z(iArr, iArr4)) {
            return new t(iArr3);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        x.e.j0(this.f5358g, iArr2);
        b.N0(iArr2, iArr);
        return new t(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[8];
        b.N1(this.f5358g, ((t) mVar).f5358g, iArr);
        return new t(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.e.K(this.f5358g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.u0(this.f5358g);
    }

    public t(int[] iArr) {
        this.f5358g = iArr;
    }
}
