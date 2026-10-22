package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class v extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5365h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5366g;

    public v(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5365h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        int[] iArrO = x.f.O(384, bigInteger);
        if (iArrO[11] == -1) {
            int[] iArr = b.A;
            if (x.f.X(12, iArrO, iArr)) {
                x.f.I0(12, iArr, iArrO);
            }
        }
        this.f5366g = iArrO;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[12];
        if (x.f.a(this.f5366g, ((v) mVar).f5366g, 12, iArr) != 0 || (iArr[11] == -1 && x.f.X(12, iArr, b.A))) {
            b.s(iArr);
        }
        return new v(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[12];
        if (x.f.b0(12, this.f5366g, iArr) != 0 || (iArr[11] == -1 && x.f.X(12, iArr, b.A))) {
            b.s(iArr);
        }
        return new v(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[12];
        x.f.s(b.A, ((v) mVar).f5366g, iArr);
        int[] iArr2 = new int[24];
        x.e.d0(iArr, this.f5366g, iArr2);
        b.P0(iArr2, iArr);
        return new v(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return x.f.I(12, this.f5366g, ((v) obj).f5366g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5365h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[12];
        x.f.s(b.A, this.f5366g, iArr);
        return new v(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.f.g0(12, this.f5366g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5366g, 0, 12) ^ f5365h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.f.k0(12, this.f5366g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[12];
        int[] iArr2 = new int[24];
        x.e.d0(this.f5366g, ((v) mVar).f5366g, iArr2);
        b.P0(iArr2, iArr);
        return new v(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[12];
        int[] iArr3 = b.A;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5366g;
            if (i8 >= 12) {
                break;
            }
            i9 |= iArr[i8];
            i8++;
        }
        if (((((i9 >>> 1) | (i9 & 1)) - 1) >> 31) != 0) {
            x.f.C0(iArr3, iArr3, 12, iArr2);
        } else {
            x.f.C0(iArr3, iArr, 12, iArr2);
        }
        return new v(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5366g;
        if (x.f.k0(12, iArr) || x.f.g0(12, iArr)) {
            return this;
        }
        int[] iArr2 = new int[24];
        int[] iArr3 = new int[12];
        int[] iArr4 = new int[12];
        int[] iArr5 = new int[12];
        int[] iArr6 = new int[12];
        x.e.k0(iArr, iArr2);
        b.P0(iArr2, iArr3);
        x.e.d0(iArr3, iArr, iArr2);
        b.P0(iArr2, iArr3);
        b.u1(iArr3, iArr4, 2, iArr2);
        x.e.d0(iArr4, iArr3, iArr2);
        b.P0(iArr2, iArr4);
        x.e.k0(iArr4, iArr2);
        b.P0(iArr2, iArr4);
        x.e.d0(iArr4, iArr, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr5, 5, iArr2);
        x.e.d0(iArr5, iArr4, iArr2);
        b.P0(iArr2, iArr5);
        b.u1(iArr5, iArr6, 5, iArr2);
        x.e.d0(iArr6, iArr4, iArr2);
        b.P0(iArr2, iArr6);
        b.u1(iArr6, iArr4, 15, iArr2);
        x.e.d0(iArr4, iArr6, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr5, 2, iArr2);
        x.e.d0(iArr3, iArr5, iArr2);
        b.P0(iArr2, iArr3);
        b.u1(iArr5, iArr5, 28, iArr2);
        x.e.d0(iArr4, iArr5, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr5, 60, iArr2);
        x.e.d0(iArr5, iArr4, iArr2);
        b.P0(iArr2, iArr5);
        b.u1(iArr5, iArr4, 120, iArr2);
        x.e.d0(iArr4, iArr5, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr4, 15, iArr2);
        x.e.d0(iArr4, iArr6, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr4, 33, iArr2);
        x.e.d0(iArr4, iArr3, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr4, 64, iArr2);
        x.e.d0(iArr4, iArr, iArr2);
        b.P0(iArr2, iArr4);
        b.u1(iArr4, iArr3, 30, iArr2);
        x.e.k0(iArr3, iArr2);
        b.P0(iArr2, iArr4);
        if (x.f.I(12, iArr, iArr4)) {
            return new v(iArr3);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[12];
        int[] iArr2 = new int[24];
        x.e.k0(this.f5366g, iArr2);
        b.P0(iArr2, iArr);
        return new v(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[12];
        b.O1(this.f5366g, ((v) mVar).f5366g, iArr);
        return new v(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.f.U(this.f5366g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.f.K0(12, this.f5366g);
    }

    public v(int[] iArr) {
        this.f5366g = iArr;
    }
}
