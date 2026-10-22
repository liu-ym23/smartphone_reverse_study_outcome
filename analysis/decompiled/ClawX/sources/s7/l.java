package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class l extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5323h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5324g;

    public l(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5323h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        int[] iArrH = x.e.H(bigInteger);
        if (iArrH[5] == -1) {
            int[] iArr = b.f5271m;
            if (x.e.O(iArrH, iArr)) {
                x.e.q0(iArr, iArrH);
            }
        }
        this.f5324g = iArrH;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[6];
        if (x.e.b(this.f5324g, ((l) mVar).f5324g, iArr) != 0 || (iArr[5] == -1 && x.e.O(iArr, b.f5271m))) {
            b.p(iArr);
        }
        return new l(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[6];
        if (x.f.b0(6, this.f5324g, iArr) != 0 || (iArr[5] == -1 && x.e.O(iArr, b.f5271m))) {
            b.p(iArr);
        }
        return new l(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[6];
        x.f.s(b.f5271m, ((l) mVar).f5324g, iArr);
        b.k0(iArr, this.f5324g, iArr);
        return new l(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            return x.e.y(this.f5324g, ((l) obj).f5324g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5323h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[6];
        x.f.s(b.f5271m, this.f5324g, iArr);
        return new l(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.R(this.f5324g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5324g, 0, 6) ^ f5323h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.V(this.f5324g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[6];
        b.k0(this.f5324g, ((l) mVar).f5324g, iArr);
        return new l(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[6];
        int[] iArr3 = b.f5271m;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5324g;
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
        return new l(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5324g;
        if (x.e.V(iArr) || x.e.R(iArr)) {
            return this;
        }
        int[] iArr2 = new int[6];
        int[] iArr3 = new int[6];
        b.j1(iArr, iArr2);
        b.k0(iArr2, iArr, iArr2);
        b.x1(2, iArr2, iArr3);
        b.k0(iArr3, iArr2, iArr3);
        b.x1(4, iArr3, iArr2);
        b.k0(iArr2, iArr3, iArr2);
        b.x1(8, iArr2, iArr3);
        b.k0(iArr3, iArr2, iArr3);
        b.x1(16, iArr3, iArr2);
        b.k0(iArr2, iArr3, iArr2);
        b.x1(32, iArr2, iArr3);
        b.k0(iArr3, iArr2, iArr3);
        b.x1(64, iArr3, iArr2);
        b.k0(iArr2, iArr3, iArr2);
        b.x1(62, iArr2, iArr2);
        b.j1(iArr2, iArr3);
        if (x.e.y(iArr, iArr3)) {
            return new l(iArr2);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[6];
        b.j1(this.f5324g, iArr);
        return new l(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[6];
        b.J1(this.f5324g, ((l) mVar).f5324g, iArr);
        return new l(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.e.J(this.f5324g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.t0(this.f5324g);
    }

    public l(int[] iArr) {
        this.f5324g = iArr;
    }
}
