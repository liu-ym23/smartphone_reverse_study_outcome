package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class N1 {

    /* renamed from: f, reason: collision with root package name */
    public static final N1 f20040f = new N1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f20041a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f20042b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f20043c;

    /* renamed from: d, reason: collision with root package name */
    public int f20044d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20045e;

    public N1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f20044d = -1;
        this.f20041a = i10;
        this.f20042b = iArr;
        this.f20043c = objArr;
        this.f20045e = z10;
    }

    public static N1 c() {
        return f20040f;
    }

    public static N1 e(N1 n12, N1 n13) {
        int i10 = n12.f20041a + n13.f20041a;
        int[] iArrCopyOf = Arrays.copyOf(n12.f20042b, i10);
        System.arraycopy(n13.f20042b, 0, iArrCopyOf, n12.f20041a, n13.f20041a);
        Object[] objArrCopyOf = Arrays.copyOf(n12.f20043c, i10);
        System.arraycopy(n13.f20043c, 0, objArrCopyOf, n12.f20041a, n13.f20041a);
        return new N1(i10, iArrCopyOf, objArrCopyOf, true);
    }

    public static N1 f() {
        return new N1(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iA;
        int iB;
        int iA2;
        int i10 = this.f20044d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f20041a; i12++) {
            int i13 = this.f20042b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 != 0) {
                if (i15 == 1) {
                    ((Long) this.f20043c[i12]).getClass();
                    iA2 = AbstractC1739m0.a(i14 << 3) + 8;
                } else if (i15 == 2) {
                    int i16 = i14 << 3;
                    zzdf zzdfVar = (zzdf) this.f20043c[i12];
                    int iA3 = AbstractC1739m0.a(i16);
                    int iF = zzdfVar.f();
                    iA2 = iA3 + AbstractC1739m0.a(iF) + iF;
                } else if (i15 == 3) {
                    int iA4 = AbstractC1739m0.a(i14 << 3);
                    iA = iA4 + iA4;
                    iB = ((N1) this.f20043c[i12]).a();
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException(new zzeq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f20043c[i12]).getClass();
                    iA2 = AbstractC1739m0.a(i14 << 3) + 4;
                }
                i11 += iA2;
            } else {
                int i17 = i14 << 3;
                long jLongValue = ((Long) this.f20043c[i12]).longValue();
                iA = AbstractC1739m0.a(i17);
                iB = AbstractC1739m0.b(jLongValue);
            }
            iA2 = iA + iB;
            i11 += iA2;
        }
        this.f20044d = i11;
        return i11;
    }

    public final int b() {
        int i10 = this.f20044d;
        if (i10 != -1) {
            return i10;
        }
        int iA = 0;
        for (int i11 = 0; i11 < this.f20041a; i11++) {
            int i12 = this.f20042b[i11] >>> 3;
            zzdf zzdfVar = (zzdf) this.f20043c[i11];
            int iA2 = AbstractC1739m0.a(8);
            int iA3 = AbstractC1739m0.a(16) + AbstractC1739m0.a(i12);
            int iA4 = AbstractC1739m0.a(24);
            int iF = zzdfVar.f();
            iA += iA2 + iA2 + iA3 + iA4 + AbstractC1739m0.a(iF) + iF;
        }
        this.f20044d = iA;
        return iA;
    }

    public final N1 d(N1 n12) {
        if (n12.equals(f20040f)) {
            return this;
        }
        g();
        int i10 = this.f20041a + n12.f20041a;
        m(i10);
        System.arraycopy(n12.f20042b, 0, this.f20042b, this.f20041a, n12.f20041a);
        System.arraycopy(n12.f20043c, 0, this.f20043c, this.f20041a, n12.f20041a);
        this.f20041a = i10;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof N1)) {
            return false;
        }
        N1 n12 = (N1) obj;
        int i10 = this.f20041a;
        if (i10 == n12.f20041a) {
            int[] iArr = this.f20042b;
            int[] iArr2 = n12.f20042b;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.f20043c;
                    Object[] objArr2 = n12.f20043c;
                    int i12 = this.f20041a;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (objArr[i13].equals(objArr2[i13])) {
                        }
                    }
                    return true;
                }
                if (iArr[i11] != iArr2[i11]) {
                    break;
                }
                i11++;
            }
        }
        return false;
    }

    public final void g() {
        if (!this.f20045e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        if (this.f20045e) {
            this.f20045e = false;
        }
    }

    public final int hashCode() {
        int i10 = this.f20041a;
        int i11 = i10 + 527;
        int[] iArr = this.f20042b;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = ((i11 * 31) + i12) * 31;
        Object[] objArr = this.f20043c;
        int i15 = this.f20041a;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public final void i(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f20041a; i11++) {
            C1728j1.b(sb2, i10, String.valueOf(this.f20042b[i11] >>> 3), this.f20043c[i11]);
        }
    }

    public final void j(int i10, Object obj) {
        g();
        m(this.f20041a + 1);
        int[] iArr = this.f20042b;
        int i11 = this.f20041a;
        iArr[i11] = i10;
        this.f20043c[i11] = obj;
        this.f20041a = i11 + 1;
    }

    public final void k(Z1 z12) throws IOException {
        for (int i10 = 0; i10 < this.f20041a; i10++) {
            z12.F(this.f20042b[i10] >>> 3, this.f20043c[i10]);
        }
    }

    public final void l(Z1 z12) throws IOException {
        if (this.f20041a != 0) {
            for (int i10 = 0; i10 < this.f20041a; i10++) {
                int i11 = this.f20042b[i10];
                Object obj = this.f20043c[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    z12.e(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    z12.I(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    z12.j(i13, (zzdf) obj);
                } else if (i12 == 3) {
                    z12.s(i13);
                    ((N1) obj).l(z12);
                    z12.r(i13);
                } else {
                    if (i12 != 5) {
                        throw new RuntimeException(new zzeq("Protocol message tag had invalid wire type."));
                    }
                    z12.v(i13, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void m(int i10) {
        int[] iArr = this.f20042b;
        if (i10 > iArr.length) {
            int i11 = this.f20041a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f20042b = Arrays.copyOf(iArr, i10);
            this.f20043c = Arrays.copyOf(this.f20043c, i10);
        }
    }

    public N1() {
        this(0, new int[8], new Object[8], true);
    }
}
