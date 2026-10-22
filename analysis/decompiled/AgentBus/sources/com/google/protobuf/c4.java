package com.google.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class c4 {

    /* renamed from: f, reason: collision with root package name */
    public static final c4 f2327f = new c4(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2328a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2329b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2330c;

    /* renamed from: d, reason: collision with root package name */
    public int f2331d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2332e;

    public c4(int i2, int[] iArr, Object[] objArr, boolean z4) {
        this.f2328a = i2;
        this.f2329b = iArr;
        this.f2330c = objArr;
        this.f2332e = z4;
    }

    public static c4 c() {
        return new c4(0, new int[8], new Object[8], true);
    }

    public final void a(int i2) {
        int[] iArr = this.f2329b;
        if (i2 > iArr.length) {
            int i10 = this.f2328a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i2) {
                i2 = i11;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f2329b = Arrays.copyOf(iArr, i2);
            this.f2330c = Arrays.copyOf(this.f2330c, i2);
        }
    }

    public final int b() {
        int iU;
        int iW;
        int iU2;
        int i2 = this.f2331d;
        if (i2 != -1) {
            return i2;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f2328a; i11++) {
            int i12 = this.f2329b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f2330c[i11]).getClass();
                    iU2 = r.U(i13) + 8;
                } else if (i14 == 2) {
                    iU2 = r.Q(i13, (l) this.f2330c[i11]);
                } else if (i14 == 3) {
                    iU = r.U(i13) * 2;
                    iW = ((c4) this.f2330c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(r2.c());
                    }
                    ((Integer) this.f2330c[i11]).getClass();
                    iU2 = r.U(i13) + 4;
                }
                i10 = iU2 + i10;
            } else {
                long jLongValue = ((Long) this.f2330c[i11]).longValue();
                iU = r.U(i13);
                iW = r.W(jLongValue);
            }
            i10 = iW + iU + i10;
        }
        this.f2331d = i10;
        return i10;
    }

    public final void d(int i2, Object obj) {
        if (!this.f2332e) {
            throw new UnsupportedOperationException();
        }
        a(this.f2328a + 1);
        int[] iArr = this.f2329b;
        int i10 = this.f2328a;
        iArr[i10] = i2;
        this.f2330c[i10] = obj;
        this.f2328a = i10 + 1;
    }

    public final void e(z2 z2Var) {
        if (this.f2328a == 0) {
            return;
        }
        z2Var.getClass();
        r rVar = (r) z2Var.f2665a;
        for (int i2 = 0; i2 < this.f2328a; i2++) {
            int i10 = this.f2329b[i2];
            Object obj = this.f2330c[i2];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                rVar.s0(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                rVar.f0(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                rVar.b0(i11, (l) obj);
            } else if (i12 == 3) {
                rVar.p0(i11, 3);
                ((c4) obj).e(z2Var);
                rVar.p0(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(r2.c());
                }
                rVar.d0(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c4)) {
            return false;
        }
        c4 c4Var = (c4) obj;
        int i2 = this.f2328a;
        if (i2 == c4Var.f2328a) {
            int[] iArr = this.f2329b;
            int[] iArr2 = c4Var.f2329b;
            int i10 = 0;
            while (true) {
                if (i10 >= i2) {
                    Object[] objArr = this.f2330c;
                    Object[] objArr2 = c4Var.f2330c;
                    int i11 = this.f2328a;
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
        int i2 = this.f2328a;
        int i10 = (527 + i2) * 31;
        int[] iArr = this.f2329b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i2; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f2330c;
        int i14 = this.f2328a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
