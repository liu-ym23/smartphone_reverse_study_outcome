package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class c extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5284h = new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5285g;

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5284h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[4];
        for (int i8 = 0; i8 < 4; i8++) {
            iArr[i8] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        if ((iArr[3] >>> 1) >= 2147483646) {
            if (x.e.N(iArr, b.f5260a)) {
                long j4 = (iArr[0] & 4294967295L) - (r0[0] & 4294967295L);
                iArr[0] = (int) j4;
                long j8 = ((iArr[1] & 4294967295L) - (r0[1] & 4294967295L)) + (j4 >> 32);
                iArr[1] = (int) j8;
                long j9 = ((iArr[2] & 4294967295L) - (r0[2] & 4294967295L)) + (j8 >> 32);
                iArr[2] = (int) j9;
                iArr[3] = (int) (((iArr[3] & 4294967295L) - (r0[3] & 4294967295L)) + (j9 >> 32));
            }
        }
        this.f5285g = iArr;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[4];
        b.a(this.f5285g, ((c) mVar).f5285g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[4];
        if (x.f.b0(4, this.f5285g, iArr) != 0 || ((iArr[3] >>> 1) >= 2147483646 && x.e.N(iArr, b.f5260a))) {
            b.o(iArr);
        }
        return new c(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[4];
        x.f.s(b.f5260a, ((c) mVar).f5285g, iArr);
        b.Y(iArr, this.f5285g, iArr);
        return new c(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        int[] iArr = ((c) obj).f5285g;
        for (int i8 = 3; i8 >= 0; i8--) {
            if (this.f5285g[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final int f() {
        return f5284h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[4];
        x.f.s(b.f5260a, this.f5285g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.Q(this.f5285g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5285g, 0, 4) ^ f5284h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.U(this.f5285g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[4];
        b.Y(this.f5285g, ((c) mVar).f5285g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[4];
        int[] iArr3 = b.f5260a;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5285g;
            if (i8 >= 4) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.e.l0(iArr3, iArr3, iArr2);
        } else {
            x.e.l0(iArr3, iArr, iArr2);
        }
        return new c(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5285g;
        if (x.e.U(iArr) || x.e.Q(iArr)) {
            return this;
        }
        int[] iArr2 = new int[4];
        b.b1(iArr, iArr2);
        b.Y(iArr2, iArr, iArr2);
        int[] iArr3 = new int[4];
        b.m1(2, iArr2, iArr3);
        b.Y(iArr3, iArr2, iArr3);
        int[] iArr4 = new int[4];
        b.m1(4, iArr3, iArr4);
        b.Y(iArr4, iArr3, iArr4);
        b.m1(2, iArr4, iArr3);
        b.Y(iArr3, iArr2, iArr3);
        b.m1(10, iArr3, iArr2);
        b.Y(iArr2, iArr3, iArr2);
        b.m1(10, iArr2, iArr4);
        b.Y(iArr4, iArr3, iArr4);
        b.b1(iArr4, iArr3);
        b.Y(iArr3, iArr, iArr3);
        b.m1(95, iArr3, iArr3);
        b.b1(iArr3, iArr4);
        for (int i8 = 3; i8 >= 0; i8--) {
            if (iArr[i8] != iArr4[i8]) {
                return null;
            }
        }
        return new c(iArr3);
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[4];
        b.b1(this.f5285g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[4];
        b.E1(this.f5285g, ((c) mVar).f5285g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return (this.f5285g[0] & 1) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        byte[] bArr = new byte[16];
        for (int i8 = 0; i8 < 4; i8++) {
            int i9 = this.f5285g[i8];
            if (i9 != 0) {
                Pack.intToBigEndian(i9, bArr, (3 - i8) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public c(int[] iArr) {
        this.f5285g = iArr;
    }
}
