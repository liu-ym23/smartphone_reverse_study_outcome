package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class j extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5314h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5315g;

    public j(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5314h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        int[] iArrH = x.e.H(bigInteger);
        if (iArrH[5] == -1) {
            int[] iArr = b.f5268j;
            if (x.e.O(iArrH, iArr)) {
                x.e.q0(iArr, iArrH);
            }
        }
        this.f5315g = iArrH;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[6];
        if (x.e.b(this.f5315g, ((j) mVar).f5315g, iArr) != 0 || (iArr[5] == -1 && x.e.O(iArr, b.f5268j))) {
            x.f.e(6, 4553, iArr);
        }
        return new j(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[6];
        if (x.f.b0(6, this.f5315g, iArr) != 0 || (iArr[5] == -1 && x.e.O(iArr, b.f5268j))) {
            x.f.e(6, 4553, iArr);
        }
        return new j(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[6];
        x.f.s(b.f5268j, ((j) mVar).f5315g, iArr);
        b.h0(iArr, this.f5315g, iArr);
        return new j(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return x.e.y(this.f5315g, ((j) obj).f5315g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5314h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[6];
        x.f.s(b.f5268j, this.f5315g, iArr);
        return new j(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.R(this.f5315g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5315g, 0, 6) ^ f5314h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.V(this.f5315g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[6];
        b.h0(this.f5315g, ((j) mVar).f5315g, iArr);
        return new j(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[6];
        int[] iArr3 = b.f5268j;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5315g;
            if (i8 >= 6) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.e.n0(iArr3, iArr3, iArr2);
        } else {
            x.e.n0(iArr3, iArr, iArr2);
        }
        return new j(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5315g;
        if (x.e.V(iArr) || x.e.R(iArr)) {
            return this;
        }
        int[] iArr2 = new int[6];
        b.h1(iArr, iArr2);
        b.h0(iArr2, iArr, iArr2);
        int[] iArr3 = new int[6];
        b.h1(iArr2, iArr3);
        b.h0(iArr3, iArr, iArr3);
        int[] iArr4 = new int[6];
        b.v1(3, iArr3, iArr4);
        b.h0(iArr4, iArr3, iArr4);
        b.v1(2, iArr4, iArr4);
        b.h0(iArr4, iArr2, iArr4);
        b.v1(8, iArr4, iArr2);
        b.h0(iArr2, iArr4, iArr2);
        b.v1(3, iArr2, iArr4);
        b.h0(iArr4, iArr3, iArr4);
        int[] iArr5 = new int[6];
        b.v1(16, iArr4, iArr5);
        b.h0(iArr5, iArr2, iArr5);
        b.v1(35, iArr5, iArr2);
        b.h0(iArr2, iArr5, iArr2);
        b.v1(70, iArr2, iArr5);
        b.h0(iArr5, iArr2, iArr5);
        b.v1(19, iArr5, iArr2);
        b.h0(iArr2, iArr4, iArr2);
        b.v1(20, iArr2, iArr2);
        b.h0(iArr2, iArr4, iArr2);
        b.v1(4, iArr2, iArr2);
        b.h0(iArr2, iArr3, iArr2);
        b.v1(6, iArr2, iArr2);
        b.h0(iArr2, iArr3, iArr2);
        b.h1(iArr2, iArr2);
        b.h1(iArr2, iArr3);
        if (x.e.y(iArr, iArr3)) {
            return new j(iArr2);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[6];
        b.h1(this.f5315g, iArr);
        return new j(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[6];
        b.I1(this.f5315g, ((j) mVar).f5315g, iArr);
        return new j(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.e.J(this.f5315g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.t0(this.f5315g);
    }

    public j(int[] iArr) {
        this.f5315g = iArr;
    }
}
