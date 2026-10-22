package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: j, reason: collision with root package name */
    public int f4786j;

    /* renamed from: k, reason: collision with root package name */
    public int f4787k;

    /* renamed from: l, reason: collision with root package name */
    public int f4788l;

    /* renamed from: m, reason: collision with root package name */
    public int f4789m;

    /* renamed from: n, reason: collision with root package name */
    public p f4790n;

    public f(int i8, int i9, int i10, int i11, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        super(i8, i9, i10, i11);
        this.f4786j = i8;
        this.f4787k = i9;
        this.f4788l = i10;
        this.f4789m = i11;
        this.d = bigInteger3;
        this.f4800e = bigInteger4;
        this.f4790n = new p(this, null, null, 0);
        this.f4798b = j(bigInteger);
        this.f4799c = j(bigInteger2);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final h a() {
        int i8 = this.f4786j;
        int i9 = this.f4787k;
        int i10 = this.f4788l;
        int i11 = this.f4789m;
        m mVar = this.f4798b;
        m mVar2 = this.f4799c;
        BigInteger bigInteger = this.d;
        BigInteger bigInteger2 = this.f4800e;
        f fVar = new f(i8, i9, i10, i11);
        fVar.f4786j = i8;
        fVar.f4787k = i9;
        fVar.f4788l = i10;
        fVar.f4789m = i11;
        fVar.d = bigInteger;
        fVar.f4800e = bigInteger2;
        fVar.f4790n = new p(fVar, null, null, 0);
        fVar.f4798b = mVar;
        fVar.f4799c = mVar2;
        fVar.f4801f = 6;
        return fVar;
    }

    @Override // p7.h
    public final d0 b(r[] rVarArr, int i8) {
        int i9 = this.f4787k;
        int i10 = this.f4789m;
        int i11 = (this.f4786j + 63) >>> 6;
        int i12 = this.f4788l;
        int[] iArr = (i12 == 0 && i10 == 0) ? new int[]{i9} : new int[]{i9, i12, i10};
        long[] jArr = new long[i8 * i11 * 2];
        int i13 = 0;
        for (int i14 = 0; i14 < i8; i14++) {
            r rVar = rVarArr[i14];
            long[] jArr2 = ((k) rVar.f4818b).f4807j.f4829a;
            System.arraycopy(jArr2, 0, jArr, i13, jArr2.length);
            int i15 = i13 + i11;
            long[] jArr3 = ((k) rVar.f4819c).f4807j.f4829a;
            System.arraycopy(jArr3, 0, jArr, i15, jArr3.length);
            i13 = i15 + i11;
        }
        return new e(this, i8, i11, jArr, iArr);
    }

    @Override // p7.h
    public final n c() {
        return u() ? new s(2) : super.c();
    }

    @Override // p7.h
    public final r e(m mVar, m mVar2) {
        return new p(this, mVar, mVar2, 0);
    }

    @Override // p7.h
    public final r f(m mVar, m mVar2, m[] mVarArr) {
        return new p(this, mVar, mVar2, mVarArr, 0);
    }

    @Override // p7.h
    public final m j(BigInteger bigInteger) {
        int i8 = this.f4787k;
        if (bigInteger != null && bigInteger.signum() >= 0) {
            int iBitLength = bigInteger.bitLength();
            int i9 = this.f4786j;
            if (iBitLength <= i9) {
                int i10 = this.f4788l;
                int i11 = this.f4789m;
                char c3 = 2;
                int i12 = 1;
                int[] iArr = (i10 | i11) == 0 ? new int[]{i8} : new int[]{i8, i10, i11};
                v vVar = new v();
                if (bigInteger.signum() < 0) {
                    throw new IllegalArgumentException("invalid F2m field value");
                }
                if (bigInteger.signum() == 0) {
                    vVar.f4829a = new long[]{0};
                } else {
                    byte[] byteArray = bigInteger.toByteArray();
                    int length = byteArray.length;
                    if (byteArray[0] == 0) {
                        length--;
                    } else {
                        i12 = 0;
                    }
                    int i13 = (length + 7) / 8;
                    vVar.f4829a = new long[i13];
                    int i14 = i13 - 1;
                    int i15 = (length % 8) + i12;
                    if (i12 < i15) {
                        long j4 = 0;
                        while (i12 < i15) {
                            j4 = (j4 << 8) | (byteArray[i12] & 255);
                            i12++;
                            c3 = c3;
                        }
                        vVar.f4829a[i14] = j4;
                        i14 = i13 - 2;
                    }
                    while (i14 >= 0) {
                        long j8 = 0;
                        int i16 = 0;
                        while (i16 < 8) {
                            j8 = (j8 << 8) | (byteArray[i12] & 255);
                            i16++;
                            i12++;
                        }
                        vVar.f4829a[i14] = j8;
                        i14--;
                    }
                }
                return new k(i9, iArr, vVar);
            }
        }
        throw new IllegalArgumentException("x value invalid in F2m field element");
    }

    @Override // p7.h
    public final int l() {
        return this.f4786j;
    }

    @Override // p7.h
    public final r m() {
        return this.f4790n;
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 0 || i8 == 1 || i8 == 6;
    }

    public f(int i8, int i9, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this(i8, i9, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }
}
