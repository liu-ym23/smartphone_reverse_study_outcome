package androidx.datastore.preferences.protobuf;

import d.C0527a;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: f, reason: collision with root package name */
    public static final q0 f3526f = new q0(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f3527a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f3528b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f3529c;

    /* renamed from: d, reason: collision with root package name */
    public int f3530d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3531e;

    public q0(int i4, int[] iArr, Object[] objArr, boolean z4) {
        this.f3527a = i4;
        this.f3528b = iArr;
        this.f3529c = objArr;
        this.f3531e = z4;
    }

    public static q0 b() {
        return new q0(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iF;
        int i4 = this.f3530d;
        if (i4 != -1) {
            return i4;
        }
        int iA = 0;
        for (int i5 = 0; i5 < this.f3527a; i5++) {
            int i6 = this.f3528b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                iF = AbstractC0268o.F(i7, ((Long) this.f3529c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f3529c[i5]).getClass();
                iF = AbstractC0268o.q(i7);
            } else if (i8 == 2) {
                iF = AbstractC0268o.l(i7, (AbstractC0259h) this.f3529c[i5]);
            } else if (i8 == 3) {
                iA = ((q0) this.f3529c[i5]).a() + (AbstractC0268o.C(i7) * 2) + iA;
            } else {
                if (i8 != 5) {
                    throw new IllegalStateException(F.b());
                }
                ((Integer) this.f3529c[i5]).getClass();
                iF = AbstractC0268o.p(i7);
            }
            iA = iF + iA;
        }
        this.f3530d = iA;
        return iA;
    }

    public final void c(int i4, Object obj) {
        if (!this.f3531e) {
            throw new UnsupportedOperationException();
        }
        int i5 = this.f3527a;
        int[] iArr = this.f3528b;
        if (i5 == iArr.length) {
            int i6 = i5 + (i5 < 4 ? 8 : i5 >> 1);
            this.f3528b = Arrays.copyOf(iArr, i6);
            this.f3529c = Arrays.copyOf(this.f3529c, i6);
        }
        int[] iArr2 = this.f3528b;
        int i7 = this.f3527a;
        iArr2[i7] = i4;
        this.f3529c[i7] = obj;
        this.f3527a = i7 + 1;
    }

    public final void d(C0527a c0527a) {
        if (this.f3527a == 0) {
            return;
        }
        c0527a.getClass();
        for (int i4 = 0; i4 < this.f3527a; i4++) {
            int i5 = this.f3528b[i4];
            Object obj = this.f3529c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                c0527a.z(i6, ((Long) obj).longValue());
            } else if (i7 == 1) {
                c0527a.v(i6, ((Long) obj).longValue());
            } else if (i7 == 2) {
                c0527a.r(i6, (AbstractC0259h) obj);
            } else if (i7 == 3) {
                ((AbstractC0268o) c0527a.f12410b).X(i6, 3);
                ((q0) obj).d(c0527a);
                ((AbstractC0268o) c0527a.f12410b).X(i6, 4);
            } else {
                if (i7 != 5) {
                    throw new RuntimeException(F.b());
                }
                c0527a.u(i6, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        int i4 = this.f3527a;
        if (i4 == q0Var.f3527a) {
            int[] iArr = this.f3528b;
            int[] iArr2 = q0Var.f3528b;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    Object[] objArr = this.f3529c;
                    Object[] objArr2 = q0Var.f3529c;
                    int i6 = this.f3527a;
                    for (int i7 = 0; i7 < i6; i7++) {
                        if (objArr[i7].equals(objArr2[i7])) {
                        }
                    }
                    return true;
                }
                if (iArr[i5] != iArr2[i5]) {
                    break;
                }
                i5++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.f3527a;
        int i5 = (527 + i4) * 31;
        int[] iArr = this.f3528b;
        int iHashCode = 17;
        int i6 = 17;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        int i8 = (i5 + i6) * 31;
        Object[] objArr = this.f3529c;
        int i9 = this.f3527a;
        for (int i10 = 0; i10 < i9; i10++) {
            iHashCode = (iHashCode * 31) + objArr[i10].hashCode();
        }
        return i8 + iHashCode;
    }
}
