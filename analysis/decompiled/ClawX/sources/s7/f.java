package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class f extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5297h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5298g;

    public f(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5297h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        int[] iArrP = x.f.P(bigInteger);
        if (iArrP[4] == -1) {
            int[] iArr = b.d;
            if (x.f.Y(iArrP, iArr)) {
                x.f.J0(iArr, iArrP);
            }
        }
        this.f5298g = iArrP;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[5];
        if (x.f.b(this.f5298g, ((f) mVar).f5298g, iArr) != 0 || (iArr[4] == -1 && x.f.Y(iArr, b.d))) {
            x.f.n(5, -2147483647, iArr);
        }
        return new f(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[5];
        if (x.f.b0(5, this.f5298g, iArr) != 0 || (iArr[4] == -1 && x.f.Y(iArr, b.d))) {
            x.f.n(5, -2147483647, iArr);
        }
        return new f(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[5];
        x.f.s(b.d, ((f) mVar).f5298g, iArr);
        b.b0(iArr, this.f5298g, iArr);
        return new f(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return x.f.J(this.f5298g, ((f) obj).f5298g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5297h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[5];
        x.f.s(b.d, this.f5298g, iArr);
        return new f(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.f.h0(this.f5298g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5298g, 0, 5) ^ f5297h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.f.l0(this.f5298g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[5];
        b.b0(this.f5298g, ((f) mVar).f5298g, iArr);
        return new f(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[5];
        int[] iArr3 = b.d;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5298g;
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
        return new f(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5298g;
        if (x.f.l0(iArr) || x.f.h0(iArr)) {
            return this;
        }
        int[] iArr2 = new int[5];
        b.d1(iArr, iArr2);
        b.b0(iArr2, iArr, iArr2);
        int[] iArr3 = new int[5];
        b.p1(2, iArr2, iArr3);
        b.b0(iArr3, iArr2, iArr3);
        b.p1(4, iArr3, iArr2);
        b.b0(iArr2, iArr3, iArr2);
        b.p1(8, iArr2, iArr3);
        b.b0(iArr3, iArr2, iArr3);
        b.p1(16, iArr3, iArr2);
        b.b0(iArr2, iArr3, iArr2);
        b.p1(32, iArr2, iArr3);
        b.b0(iArr3, iArr2, iArr3);
        b.p1(64, iArr3, iArr2);
        b.b0(iArr2, iArr3, iArr2);
        b.d1(iArr2, iArr3);
        b.b0(iArr3, iArr, iArr3);
        b.p1(29, iArr3, iArr3);
        b.d1(iArr3, iArr2);
        if (x.f.J(iArr, iArr2)) {
            return new f(iArr3);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[5];
        b.d1(this.f5298g, iArr);
        return new f(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[5];
        b.F1(this.f5298g, ((f) mVar).f5298g, iArr);
        return new f(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.f.S(this.f5298g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.f.L0(this.f5298g);
    }

    public f(int[] iArr) {
        this.f5298g = iArr;
    }
}
