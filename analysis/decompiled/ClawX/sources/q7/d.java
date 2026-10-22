package q7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import p7.j;
import p7.m;
import x.e;
import x.f;

/* loaded from: classes.dex */
public final class d extends j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f4900h = e.u0(c.f4898a);

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f4901i = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};

    /* renamed from: g, reason: collision with root package name */
    public int[] f4902g;

    public d(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f4900h) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        int[] iArrI = e.I(bigInteger);
        while (true) {
            int[] iArr = c.f4898a;
            if (!e.P(iArrI, iArr)) {
                this.f4902g = iArrI;
                return;
            }
            e.r0(iArr, iArrI);
        }
    }

    @Override // p7.m
    public final m a(m mVar) {
        int[] iArr = new int[8];
        e.c(this.f4902g, ((d) mVar).f4902g, iArr);
        if (e.P(iArr, c.f4898a)) {
            c.f(iArr);
        }
        return new d(iArr);
    }

    @Override // p7.m
    public final m b() {
        int[] iArr = new int[8];
        f.b0(8, this.f4902g, iArr);
        if (e.P(iArr, c.f4898a)) {
            c.f(iArr);
        }
        return new d(iArr);
    }

    @Override // p7.m
    public final m d(m mVar) {
        int[] iArr = new int[8];
        f.s(c.f4898a, ((d) mVar).f4902g, iArr);
        c.a(iArr, this.f4902g, iArr);
        return new d(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return e.z(this.f4902g, ((d) obj).f4902g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f4900h.bitLength();
    }

    @Override // p7.m
    public final m g() {
        int[] iArr = new int[8];
        f.s(c.f4898a, this.f4902g, iArr);
        return new d(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return e.S(this.f4902g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4902g, 0, 8) ^ f4900h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return e.W(this.f4902g);
    }

    @Override // p7.m
    public final m j(m mVar) {
        int[] iArr = new int[8];
        c.a(this.f4902g, ((d) mVar).f4902g, iArr);
        return new d(iArr);
    }

    @Override // p7.m
    public final m m() {
        int[] iArr = new int[8];
        int[] iArr2 = this.f4902g;
        int i8 = 0;
        for (int i9 = 0; i9 < 8; i9++) {
            i8 |= iArr2[i9];
        }
        int i10 = (((i8 >>> 1) | (i8 & 1)) - 1) >> 31;
        int[] iArr3 = c.f4898a;
        if (i10 != 0) {
            e.p0(iArr3, iArr3, iArr);
        } else {
            e.p0(iArr3, iArr2, iArr);
        }
        return new d(iArr);
    }

    @Override // p7.m
    public final m n() {
        int[] iArr = this.f4902g;
        if (e.W(iArr) || e.S(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        c.d(iArr, iArr2);
        c.a(iArr2, iArr, iArr2);
        c.d(iArr2, iArr2);
        c.a(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        c.d(iArr2, iArr3);
        c.a(iArr3, iArr, iArr3);
        int[] iArr4 = new int[8];
        c.e(3, iArr3, iArr4);
        c.a(iArr4, iArr2, iArr4);
        c.e(4, iArr4, iArr2);
        c.a(iArr2, iArr3, iArr2);
        c.e(4, iArr2, iArr4);
        c.a(iArr4, iArr3, iArr4);
        c.e(15, iArr4, iArr3);
        c.a(iArr3, iArr4, iArr3);
        c.e(30, iArr3, iArr4);
        c.a(iArr4, iArr3, iArr4);
        c.e(60, iArr4, iArr3);
        c.a(iArr3, iArr4, iArr3);
        c.e(11, iArr3, iArr4);
        c.a(iArr4, iArr2, iArr4);
        c.e(120, iArr4, iArr2);
        c.a(iArr2, iArr3, iArr2);
        c.d(iArr2, iArr2);
        c.d(iArr2, iArr3);
        if (e.z(iArr, iArr3)) {
            return new d(iArr2);
        }
        c.a(iArr2, f4901i, iArr2);
        c.d(iArr2, iArr3);
        if (e.z(iArr, iArr3)) {
            return new d(iArr2);
        }
        return null;
    }

    @Override // p7.m
    public final m o() {
        int[] iArr = new int[8];
        c.d(this.f4902g, iArr);
        return new d(iArr);
    }

    @Override // p7.m
    public final m r(m mVar) {
        int[] iArr = new int[8];
        c.g(this.f4902g, ((d) mVar).f4902g, iArr);
        return new d(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return e.K(this.f4902g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return e.u0(this.f4902g);
    }

    public d(int[] iArr) {
        this.f4902g = iArr;
    }
}
