package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: f, reason: collision with root package name */
    public static final j1 f886f = new j1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f887a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f888b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f889c;

    /* renamed from: d, reason: collision with root package name */
    public int f890d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f891e;

    public j1(int i2, int[] iArr, Object[] objArr, boolean z4) {
        this.f887a = i2;
        this.f888b = iArr;
        this.f889c = objArr;
        this.f891e = z4;
    }

    public final void a(int i2) {
        int[] iArr = this.f888b;
        if (i2 > iArr.length) {
            int i10 = this.f887a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i2) {
                i2 = i11;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f888b = Arrays.copyOf(iArr, i2);
            this.f889c = Arrays.copyOf(this.f889c, i2);
        }
    }

    public final int b() {
        int iS;
        int iU;
        int iO;
        int i2 = this.f890d;
        if (i2 != -1) {
            return i2;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f887a; i11++) {
            int i12 = this.f888b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f889c[i11]).getClass();
                    iO = m.o(i13);
                } else if (i14 == 2) {
                    iO = m.l(i13, (g) this.f889c[i11]);
                } else if (i14 == 3) {
                    iS = m.s(i13) * 2;
                    iU = ((j1) this.f889c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(a0.b());
                    }
                    ((Integer) this.f889c[i11]).getClass();
                    iO = m.n(i13);
                }
                i10 = iO + i10;
            } else {
                long jLongValue = ((Long) this.f889c[i11]).longValue();
                iS = m.s(i13);
                iU = m.u(jLongValue);
            }
            i10 = iU + iS + i10;
        }
        this.f890d = i10;
        return i10;
    }

    public final void c(int i2, Object obj) {
        if (!this.f891e) {
            throw new UnsupportedOperationException();
        }
        a(this.f887a + 1);
        int[] iArr = this.f888b;
        int i10 = this.f887a;
        iArr[i10] = i2;
        this.f889c[i10] = obj;
        this.f887a = i10 + 1;
    }

    public final void d(i0 i0Var) throws IOException {
        if (this.f887a == 0) {
            return;
        }
        i0Var.getClass();
        m mVar = (m) i0Var.f880a;
        for (int i2 = 0; i2 < this.f887a; i2++) {
            int i10 = this.f888b[i2];
            Object obj = this.f889c[i2];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                mVar.O(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                mVar.E(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                i0Var.a(i11, (g) obj);
            } else if (i12 == 3) {
                mVar.L(i11, 3);
                ((j1) obj).d(i0Var);
                mVar.L(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(a0.b());
                }
                mVar.C(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        int i2 = this.f887a;
        if (i2 == j1Var.f887a) {
            int[] iArr = this.f888b;
            int[] iArr2 = j1Var.f888b;
            int i10 = 0;
            while (true) {
                if (i10 >= i2) {
                    Object[] objArr = this.f889c;
                    Object[] objArr2 = j1Var.f889c;
                    int i11 = this.f887a;
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
        int i2 = this.f887a;
        int i10 = (527 + i2) * 31;
        int[] iArr = this.f888b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i2; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f889c;
        int i14 = this.f887a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
