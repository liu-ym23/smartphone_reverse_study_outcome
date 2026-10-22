package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: f, reason: collision with root package name */
    public static final b1 f451f = new b1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f452a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f453b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f454c;
    public int d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f455e;

    public b1(int i8, int[] iArr, Object[] objArr, boolean z) {
        this.f452a = i8;
        this.f453b = iArr;
        this.f454c = objArr;
        this.f455e = z;
    }

    public final void a(int i8) {
        int[] iArr = this.f453b;
        if (i8 > iArr.length) {
            int i9 = this.f452a;
            int i10 = (i9 / 2) + i9;
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.f453b = Arrays.copyOf(iArr, i8);
            this.f454c = Arrays.copyOf(this.f454c, i8);
        }
    }

    public final int b() {
        int iQ0;
        int iS0;
        int iQ02;
        int i8 = this.d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f452a; i10++) {
            int i11 = this.f453b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f454c[i10]).getClass();
                    iQ02 = l.q0(i12) + 8;
                } else if (i13 == 2) {
                    iQ02 = l.o0(i12, (g) this.f454c[i10]);
                } else if (i13 == 3) {
                    iQ0 = l.q0(i12) * 2;
                    iS0 = ((b1) this.f454c[i10]).b();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(z.b());
                    }
                    ((Integer) this.f454c[i10]).getClass();
                    iQ02 = l.q0(i12) + 4;
                }
                i9 = iQ02 + i9;
            } else {
                long jLongValue = ((Long) this.f454c[i10]).longValue();
                iQ0 = l.q0(i12);
                iS0 = l.s0(jLongValue);
            }
            i9 = iS0 + iQ0 + i9;
        }
        this.d = i9;
        return i9;
    }

    public final void c(int i8, Object obj) {
        if (!this.f455e) {
            throw new UnsupportedOperationException();
        }
        a(this.f452a + 1);
        int[] iArr = this.f453b;
        int i9 = this.f452a;
        iArr[i9] = i8;
        this.f454c[i9] = obj;
        this.f452a = i9 + 1;
    }

    public final void d(e0 e0Var) {
        if (this.f452a == 0) {
            return;
        }
        e0Var.getClass();
        l lVar = (l) e0Var.f466a;
        for (int i8 = 0; i8 < this.f452a; i8++) {
            int i9 = this.f453b[i8];
            Object obj = this.f454c[i8];
            int i10 = i9 >>> 3;
            int i11 = i9 & 7;
            if (i11 == 0) {
                lVar.M0(i10, ((Long) obj).longValue());
            } else if (i11 == 1) {
                lVar.C0(i10, ((Long) obj).longValue());
            } else if (i11 == 2) {
                lVar.y0(i10, (g) obj);
            } else if (i11 == 3) {
                lVar.J0(i10, 3);
                ((b1) obj).d(e0Var);
                lVar.J0(i10, 4);
            } else {
                if (i11 != 5) {
                    throw new RuntimeException(z.b());
                }
                lVar.A0(i10, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        int i8 = this.f452a;
        if (i8 == b1Var.f452a) {
            int[] iArr = this.f453b;
            int[] iArr2 = b1Var.f453b;
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    Object[] objArr = this.f454c;
                    Object[] objArr2 = b1Var.f454c;
                    int i10 = this.f452a;
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
        int i8 = this.f452a;
        int i9 = (527 + i8) * 31;
        int[] iArr = this.f453b;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i8; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = (i9 + i10) * 31;
        Object[] objArr = this.f454c;
        int i13 = this.f452a;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return i12 + iHashCode;
    }
}
