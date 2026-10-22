package r7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;
import p7.j;
import p7.m;
import x.e;
import x.f;

/* loaded from: classes.dex */
public final class c extends j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5226h = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5227g;

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5226h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        int[] iArrI = e.I(bigInteger);
        if ((iArrI[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = b.f5224a;
            if (e.P(iArrI, iArr)) {
                e.r0(iArr, iArrI);
            }
        }
        this.f5227g = iArrI;
    }

    @Override // p7.m
    public final m a(m mVar) {
        int[] iArr = new int[8];
        b.a(this.f5227g, ((c) mVar).f5227g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final m b() {
        int[] iArr = new int[8];
        if (f.b0(8, this.f5227g, iArr) != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && e.P(iArr, b.f5224a))) {
            b.b(iArr);
        }
        return new c(iArr);
    }

    @Override // p7.m
    public final m d(m mVar) {
        int[] iArr = new int[8];
        f.s(b.f5224a, ((c) mVar).f5227g, iArr);
        b.c(iArr, this.f5227g, iArr);
        return new c(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return e.z(this.f5227g, ((c) obj).f5227g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5226h.bitLength();
    }

    @Override // p7.m
    public final m g() {
        int[] iArr = new int[8];
        f.s(b.f5224a, this.f5227g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return e.S(this.f5227g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5227g, 0, 8) ^ f5226h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return e.W(this.f5227g);
    }

    @Override // p7.m
    public final m j(m mVar) {
        int[] iArr = new int[8];
        b.c(this.f5227g, ((c) mVar).f5227g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final m m() {
        int[] iArr;
        int[] iArr2 = new int[8];
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5227g;
            if (i8 >= 8) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        int i10 = (((i9 >>> 1) | (i9 & 1)) - 1) >> 31;
        int[] iArr3 = b.f5224a;
        if (i10 != 0) {
            e.p0(iArr3, iArr3, iArr2);
        } else {
            e.p0(iArr3, iArr, iArr2);
        }
        return new c(iArr2);
    }

    @Override // p7.m
    public final m n() {
        int[] iArr = this.f5227g;
        if (e.W(iArr) || e.S(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        b.f(iArr, iArr2);
        b.c(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        b.g(2, iArr2, iArr3);
        b.c(iArr3, iArr2, iArr3);
        int[] iArr4 = new int[8];
        b.g(2, iArr3, iArr4);
        b.c(iArr4, iArr2, iArr4);
        b.g(6, iArr4, iArr2);
        b.c(iArr2, iArr4, iArr2);
        int[] iArr5 = new int[8];
        b.g(12, iArr2, iArr5);
        b.c(iArr5, iArr2, iArr5);
        b.g(6, iArr5, iArr2);
        b.c(iArr2, iArr4, iArr2);
        b.f(iArr2, iArr4);
        b.c(iArr4, iArr, iArr4);
        b.g(31, iArr4, iArr5);
        b.c(iArr5, iArr4, iArr2);
        b.g(32, iArr5, iArr5);
        b.c(iArr5, iArr2, iArr5);
        b.g(62, iArr5, iArr5);
        b.c(iArr5, iArr2, iArr5);
        b.g(4, iArr5, iArr5);
        b.c(iArr5, iArr3, iArr5);
        b.g(32, iArr5, iArr5);
        b.c(iArr5, iArr, iArr5);
        b.g(62, iArr5, iArr5);
        b.f(iArr5, iArr3);
        if (e.z(iArr, iArr3)) {
            return new c(iArr5);
        }
        return null;
    }

    @Override // p7.m
    public final m o() {
        int[] iArr = new int[8];
        b.f(this.f5227g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final m r(m mVar) {
        int[] iArr = new int[8];
        b.h(this.f5227g, ((c) mVar).f5227g, iArr);
        return new c(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return e.K(this.f5227g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return e.u0(this.f5227g);
    }

    public c(int[] iArr) {
        this.f5227g = iArr;
    }
}
