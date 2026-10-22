package com.google.protobuf;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class N2 {
    public static final N2 f = new N2(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2861a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public N2(int i, int[] iArr, Object[] objArr, boolean z10) {
        this.f2861a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z10;
    }

    public static N2 c() {
        return new N2(0, new int[8], new Object[8], true);
    }

    public final void a(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i6 = this.f2861a;
            int i10 = (i6 / 2) + i6;
            if (i10 >= i) {
                i = i10;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final int b() {
        int iR;
        int iT;
        int iR2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i6 = 0;
        for (int i10 = 0; i10 < this.f2861a; i10++) {
            int i11 = this.b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.c[i10]).getClass();
                    iR2 = C0980q.R(i12) + 8;
                } else if (i13 == 2) {
                    iR2 = C0980q.K(i12, (ByteString) this.c[i10]);
                } else if (i13 == 3) {
                    iR = C0980q.R(i12) * 2;
                    iT = ((N2) this.c[i10]).b();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(InvalidProtocolBufferException.c());
                    }
                    ((Integer) this.c[i10]).getClass();
                    iR2 = C0980q.R(i12) + 4;
                }
                i6 = iR2 + i6;
            } else {
                long jLongValue = ((Long) this.c[i10]).longValue();
                iR = C0980q.R(i12);
                iT = C0980q.T(jLongValue);
            }
            i6 = iT + iR + i6;
        }
        this.d = i6;
        return i6;
    }

    public final void d(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        a(this.f2861a + 1);
        int[] iArr = this.b;
        int i6 = this.f2861a;
        iArr[i6] = i;
        this.c[i6] = obj;
        this.f2861a = i6 + 1;
    }

    public final void e(F1 f12) throws CodedOutputStream$OutOfSpaceException {
        if (this.f2861a == 0) {
            return;
        }
        f12.getClass();
        C0980q c0980q = (C0980q) f12.b;
        for (int i = 0; i < this.f2861a; i++) {
            int i6 = this.b[i];
            Object obj = this.c[i];
            int i10 = i6 >>> 3;
            int i11 = i6 & 7;
            if (i11 == 0) {
                c0980q.m0(i10, ((Long) obj).longValue());
            } else if (i11 == 1) {
                c0980q.a0(i10, ((Long) obj).longValue());
            } else if (i11 == 2) {
                c0980q.X(i10, (ByteString) obj);
            } else if (i11 == 3) {
                c0980q.k0(i10, 3);
                ((N2) obj).e(f12);
                c0980q.k0(i10, 4);
            } else {
                if (i11 != 5) {
                    throw new RuntimeException(InvalidProtocolBufferException.c());
                }
                c0980q.Y(i10, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof N2)) {
            return false;
        }
        N2 n22 = (N2) obj;
        int i = this.f2861a;
        if (i == n22.f2861a) {
            int[] iArr = this.b;
            int[] iArr2 = n22.b;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = n22.c;
                    int i10 = this.f2861a;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (objArr[i11].equals(objArr2[i11])) {
                        }
                    }
                    return true;
                }
                if (iArr[i6] != iArr2[i6]) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2861a;
        int i6 = (527 + i) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = (i6 + i10) * 31;
        Object[] objArr = this.c;
        int i13 = this.f2861a;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return i12 + iHashCode;
    }
}
