package s7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class r extends p7.j {

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f5348h = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5349g;

    public r(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5348h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        int[] iArrI = x.e.I(bigInteger);
        if (iArrI[7] == -1) {
            int[] iArr = b.f5280v;
            if (x.e.P(iArrI, iArr)) {
                x.e.r0(iArr, iArrI);
            }
        }
        this.f5349g = iArrI;
    }

    @Override // p7.m
    public final p7.m a(p7.m mVar) {
        int[] iArr = new int[8];
        if (x.e.c(this.f5349g, ((r) mVar).f5349g, iArr) != 0 || (iArr[7] == -1 && x.e.P(iArr, b.f5280v))) {
            x.f.e(8, 977, iArr);
        }
        return new r(iArr);
    }

    @Override // p7.m
    public final p7.m b() {
        int[] iArr = new int[8];
        if (x.f.b0(8, this.f5349g, iArr) != 0 || (iArr[7] == -1 && x.e.P(iArr, b.f5280v))) {
            x.f.e(8, 977, iArr);
        }
        return new r(iArr);
    }

    @Override // p7.m
    public final p7.m d(p7.m mVar) {
        int[] iArr = new int[8];
        x.f.s(b.f5280v, ((r) mVar).f5349g, iArr);
        int[] iArr2 = new int[16];
        x.e.c0(iArr, this.f5349g, iArr2);
        b.L0(iArr2, iArr);
        return new r(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            return x.e.z(this.f5349g, ((r) obj).f5349g);
        }
        return false;
    }

    @Override // p7.m
    public final int f() {
        return f5348h.bitLength();
    }

    @Override // p7.m
    public final p7.m g() {
        int[] iArr = new int[8];
        x.f.s(b.f5280v, this.f5349g, iArr);
        return new r(iArr);
    }

    @Override // p7.m
    public final boolean h() {
        return x.e.S(this.f5349g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5349g, 0, 8) ^ f5348h.hashCode();
    }

    @Override // p7.m
    public final boolean i() {
        return x.e.W(this.f5349g);
    }

    @Override // p7.m
    public final p7.m j(p7.m mVar) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        x.e.c0(this.f5349g, ((r) mVar).f5349g, iArr2);
        b.L0(iArr2, iArr);
        return new r(iArr);
    }

    @Override // p7.m
    public final p7.m m() {
        int[] iArr;
        int[] iArr2 = new int[8];
        int[] iArr3 = b.f5280v;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            iArr = this.f5349g;
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
        return new r(iArr2);
    }

    @Override // p7.m
    public final p7.m n() {
        int[] iArr = this.f5349g;
        if (x.e.W(iArr) || x.e.S(iArr)) {
            return this;
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[8];
        x.e.j0(iArr, iArr2);
        b.L0(iArr2, iArr3);
        x.e.c0(iArr3, iArr, iArr2);
        b.L0(iArr2, iArr3);
        int[] iArr4 = new int[8];
        x.e.j0(iArr3, iArr2);
        b.L0(iArr2, iArr4);
        x.e.c0(iArr4, iArr, iArr2);
        b.L0(iArr2, iArr4);
        int[] iArr5 = new int[8];
        b.o1(iArr4, iArr5, 3, iArr2);
        x.e.c0(iArr5, iArr4, iArr2);
        b.L0(iArr2, iArr5);
        b.o1(iArr5, iArr5, 3, iArr2);
        x.e.c0(iArr5, iArr4, iArr2);
        b.L0(iArr2, iArr5);
        b.o1(iArr5, iArr5, 2, iArr2);
        x.e.c0(iArr5, iArr3, iArr2);
        b.L0(iArr2, iArr5);
        int[] iArr6 = new int[8];
        b.o1(iArr5, iArr6, 11, iArr2);
        x.e.c0(iArr6, iArr5, iArr2);
        b.L0(iArr2, iArr6);
        b.o1(iArr6, iArr5, 22, iArr2);
        x.e.c0(iArr5, iArr6, iArr2);
        b.L0(iArr2, iArr5);
        int[] iArr7 = new int[8];
        b.o1(iArr5, iArr7, 44, iArr2);
        x.e.c0(iArr7, iArr5, iArr2);
        b.L0(iArr2, iArr7);
        int[] iArr8 = new int[8];
        b.o1(iArr7, iArr8, 88, iArr2);
        x.e.c0(iArr8, iArr7, iArr2);
        b.L0(iArr2, iArr8);
        b.o1(iArr8, iArr7, 44, iArr2);
        x.e.c0(iArr7, iArr5, iArr2);
        b.L0(iArr2, iArr7);
        b.o1(iArr7, iArr5, 3, iArr2);
        x.e.c0(iArr5, iArr4, iArr2);
        b.L0(iArr2, iArr5);
        b.o1(iArr5, iArr5, 23, iArr2);
        x.e.c0(iArr5, iArr6, iArr2);
        b.L0(iArr2, iArr5);
        b.o1(iArr5, iArr5, 6, iArr2);
        x.e.c0(iArr5, iArr3, iArr2);
        b.L0(iArr2, iArr5);
        b.o1(iArr5, iArr5, 2, iArr2);
        x.e.j0(iArr5, iArr2);
        b.L0(iArr2, iArr3);
        if (x.e.z(iArr, iArr3)) {
            return new r(iArr5);
        }
        return null;
    }

    @Override // p7.m
    public final p7.m o() {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        x.e.j0(this.f5349g, iArr2);
        b.L0(iArr2, iArr);
        return new r(iArr);
    }

    @Override // p7.m
    public final p7.m r(p7.m mVar) {
        int[] iArr = new int[8];
        b.M1(this.f5349g, ((r) mVar).f5349g, iArr);
        return new r(iArr);
    }

    @Override // p7.m
    public final boolean s() {
        return x.e.K(this.f5349g) == 1;
    }

    @Override // p7.m
    public final BigInteger t() {
        return x.e.u0(this.f5349g);
    }

    public r(int[] iArr) {
        this.f5349g = iArr;
    }
}
