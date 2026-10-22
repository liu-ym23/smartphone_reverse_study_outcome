package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: f, reason: collision with root package name */
    public static final d1 f2196f = new d1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2197a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2198b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2199c;

    /* renamed from: d, reason: collision with root package name */
    public int f2200d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2201e;

    public d1(int i2, int[] iArr, Object[] objArr, boolean z4) {
        this.f2197a = i2;
        this.f2198b = iArr;
        this.f2199c = objArr;
        this.f2201e = z4;
    }

    public static d1 c() {
        return new d1(0, new int[8], new Object[8], true);
    }

    public final void a(int i2) {
        int[] iArr = this.f2198b;
        if (i2 > iArr.length) {
            int i10 = this.f2197a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i2) {
                i2 = i11;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f2198b = Arrays.copyOf(iArr, i2);
            this.f2199c = Arrays.copyOf(this.f2199c, i2);
        }
    }

    public final int b() {
        int iX;
        int iZ;
        int iT;
        int i2 = this.f2200d;
        if (i2 != -1) {
            return i2;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f2197a; i11++) {
            int i12 = this.f2198b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f2199c[i11]).getClass();
                    iT = k.T(i13);
                } else if (i14 == 2) {
                    iT = k.Q(i13, (h) this.f2199c[i11]);
                } else if (i14 == 3) {
                    iX = k.X(i13) * 2;
                    iZ = ((d1) this.f2199c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(b0.c());
                    }
                    ((Integer) this.f2199c[i11]).getClass();
                    iT = k.S(i13);
                }
                i10 = iT + i10;
            } else {
                long jLongValue = ((Long) this.f2199c[i11]).longValue();
                iX = k.X(i13);
                iZ = k.Z(jLongValue);
            }
            i10 = iZ + iX + i10;
        }
        this.f2200d = i10;
        return i10;
    }

    public final void d(int i2, Object obj) {
        if (!this.f2201e) {
            throw new UnsupportedOperationException();
        }
        a(this.f2197a + 1);
        int[] iArr = this.f2198b;
        int i10 = this.f2197a;
        iArr[i10] = i2;
        this.f2199c[i10] = obj;
        this.f2197a = i10 + 1;
    }

    public final void e(k0 k0Var) throws androidx.datastore.preferences.protobuf.l {
        if (this.f2197a == 0) {
            return;
        }
        k0Var.getClass();
        k kVar = (k) k0Var.f2239a;
        for (int i2 = 0; i2 < this.f2197a; i2++) {
            int i10 = this.f2198b[i2];
            Object obj = this.f2199c[i2];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                kVar.j0(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                kVar.e0(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                k0Var.a(i11, (h) obj);
            } else if (i12 == 3) {
                kVar.h0(i11, 3);
                ((d1) obj).e(k0Var);
                kVar.h0(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(b0.c());
                }
                kVar.c0(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        int i2 = this.f2197a;
        if (i2 == d1Var.f2197a) {
            int[] iArr = this.f2198b;
            int[] iArr2 = d1Var.f2198b;
            int i10 = 0;
            while (true) {
                if (i10 >= i2) {
                    Object[] objArr = this.f2199c;
                    Object[] objArr2 = d1Var.f2199c;
                    int i11 = this.f2197a;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (objArr[i12].equals(objArr2[i12])) {
                        }
                    }
                    return true;
                }
                if (iArr[i10] != iArr2[i10]) {
                    break;
                }
                i10++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f2197a;
        int i10 = (527 + i2) * 31;
        int[] iArr = this.f2198b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i2; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f2199c;
        int i14 = this.f2197a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
