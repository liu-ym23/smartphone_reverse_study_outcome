package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: f, reason: collision with root package name */
    public static final e1 f1454f = new e1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f1455a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1456b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1457c;
    public int d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1458e;

    public e1(int i8, int[] iArr, Object[] objArr, boolean z) {
        this.f1455a = i8;
        this.f1456b = iArr;
        this.f1457c = objArr;
        this.f1458e = z;
    }

    public static e1 c() {
        return new e1(0, new int[8], new Object[8], true);
    }

    public final void a(int i8) {
        int[] iArr = this.f1456b;
        if (i8 > iArr.length) {
            int i9 = this.f1455a;
            int i10 = (i9 / 2) + i9;
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.f1456b = Arrays.copyOf(iArr, i8);
            this.f1457c = Arrays.copyOf(this.f1457c, i8);
        }
    }

    public final int b() {
        int iZ;
        int iB0;
        int iV;
        int i8 = this.d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f1455a; i10++) {
            int i11 = this.f1456b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f1457c[i10]).getClass();
                    iV = l.V(i12);
                } else if (i13 == 2) {
                    iV = l.S(i12, (i) this.f1457c[i10]);
                } else if (i13 == 3) {
                    iZ = l.Z(i12) * 2;
                    iB0 = ((e1) this.f1457c[i10]).b();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(c0.c());
                    }
                    ((Integer) this.f1457c[i10]).getClass();
                    iV = l.U(i12);
                }
                i9 = iV + i9;
            } else {
                long jLongValue = ((Long) this.f1457c[i10]).longValue();
                iZ = l.Z(i12);
                iB0 = l.b0(jLongValue);
            }
            i9 = iB0 + iZ + i9;
        }
        this.d = i9;
        return i9;
    }

    public final void d(int i8, Object obj) {
        if (!this.f1458e) {
            throw new UnsupportedOperationException();
        }
        a(this.f1455a + 1);
        int[] iArr = this.f1456b;
        int i9 = this.f1455a;
        iArr[i9] = i8;
        this.f1457c[i9] = obj;
        this.f1455a = i9 + 1;
    }

    public final void e(l0 l0Var) throws androidx.datastore.preferences.protobuf.k {
        if (this.f1455a == 0) {
            return;
        }
        l0Var.getClass();
        l lVar = (l) l0Var.f1492a;
        for (int i8 = 0; i8 < this.f1455a; i8++) {
            int i9 = this.f1456b[i8];
            Object obj = this.f1457c[i8];
            int i10 = i9 >>> 3;
            int i11 = i9 & 7;
            if (i11 == 0) {
                lVar.l0(i10, ((Long) obj).longValue());
            } else if (i11 == 1) {
                lVar.g0(i10, ((Long) obj).longValue());
            } else if (i11 == 2) {
                l0Var.a(i10, (i) obj);
            } else if (i11 == 3) {
                lVar.j0(i10, 3);
                ((e1) obj).e(l0Var);
                lVar.j0(i10, 4);
            } else {
                if (i11 != 5) {
                    throw new RuntimeException(c0.c());
                }
                lVar.e0(i10, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        int i8 = this.f1455a;
        if (i8 == e1Var.f1455a) {
            int[] iArr = this.f1456b;
            int[] iArr2 = e1Var.f1456b;
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    Object[] objArr = this.f1457c;
                    Object[] objArr2 = e1Var.f1457c;
                    int i10 = this.f1455a;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (objArr[i11].equals(objArr2[i11])) {
                        }
                    }
                    return true;
                }
                if (iArr[i9] != iArr2[i9]) {
                    break;
                }
                i9++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.f1455a;
        int i9 = (527 + i8) * 31;
        int[] iArr = this.f1456b;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i8; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = (i9 + i10) * 31;
        Object[] objArr = this.f1457c;
        int i13 = this.f1455a;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return i12 + iHashCode;
    }
}
