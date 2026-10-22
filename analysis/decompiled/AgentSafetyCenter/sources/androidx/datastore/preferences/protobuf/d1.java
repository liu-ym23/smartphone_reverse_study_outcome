package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: f, reason: collision with root package name */
    public static final d1 f1097f = new d1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f1098a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1099b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1100c;

    /* renamed from: d, reason: collision with root package name */
    public int f1101d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1102e;

    public d1(int i, int[] iArr, Object[] objArr, boolean z10) {
        this.f1098a = i;
        this.f1099b = iArr;
        this.f1100c = objArr;
        this.f1102e = z10;
    }

    public final void a(int i) {
        int[] iArr = this.f1099b;
        if (i > iArr.length) {
            int i3 = this.f1098a;
            int i10 = (i3 / 2) + i3;
            if (i10 >= i) {
                i = i10;
            }
            if (i < 8) {
                i = 8;
            }
            this.f1099b = Arrays.copyOf(iArr, i);
            this.f1100c = Arrays.copyOf(this.f1100c, i);
        }
    }

    public final int b() {
        int iH;
        int iJ;
        int iH2;
        int i = this.f1101d;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i10 = 0; i10 < this.f1098a; i10++) {
            int i11 = this.f1099b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f1100c[i10]).getClass();
                    iH2 = l.h(i12) + 8;
                } else if (i13 == 2) {
                    iH2 = l.f(i12, (f) this.f1100c[i10]);
                } else if (i13 == 3) {
                    iH = l.h(i12) * 2;
                    iJ = ((d1) this.f1100c[i10]).b();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(z.b());
                    }
                    ((Integer) this.f1100c[i10]).getClass();
                    iH2 = l.h(i12) + 4;
                }
                i3 = iH2 + i3;
            } else {
                long jLongValue = ((Long) this.f1100c[i10]).longValue();
                iH = l.h(i12);
                iJ = l.j(jLongValue);
            }
            i3 = iJ + iH + i3;
        }
        this.f1101d = i3;
        return i3;
    }

    public final void c(int i, Object obj) {
        if (!this.f1102e) {
            b8.z.c();
            return;
        }
        a(this.f1098a + 1);
        int[] iArr = this.f1099b;
        int i3 = this.f1098a;
        iArr[i3] = i;
        this.f1100c[i3] = obj;
        this.f1098a = i3 + 1;
    }

    public final void d(f0 f0Var) throws IOException {
        if (this.f1098a == 0) {
            return;
        }
        f0Var.getClass();
        l lVar = (l) f0Var.f1110a;
        for (int i = 0; i < this.f1098a; i++) {
            int i3 = this.f1099b[i];
            Object obj = this.f1100c[i];
            int i10 = i3 >>> 3;
            int i11 = i3 & 7;
            if (i11 == 0) {
                lVar.E(i10, ((Long) obj).longValue());
            } else if (i11 == 1) {
                lVar.t(i10, ((Long) obj).longValue());
            } else if (i11 == 2) {
                lVar.p(i10, (f) obj);
            } else if (i11 == 3) {
                lVar.B(i10, 3);
                ((d1) obj).d(f0Var);
                lVar.B(i10, 4);
            } else {
                if (i11 != 5) {
                    ad.o.h(z.b());
                    return;
                }
                lVar.r(i10, ((Integer) obj).intValue());
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
        int i = this.f1098a;
        if (i == d1Var.f1098a) {
            int[] iArr = this.f1099b;
            int[] iArr2 = d1Var.f1099b;
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    Object[] objArr = this.f1100c;
                    Object[] objArr2 = d1Var.f1100c;
                    int i10 = this.f1098a;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (objArr[i11].equals(objArr2[i11])) {
                        }
                    }
                    return true;
                }
                if (iArr[i3] != iArr2[i3]) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f1098a;
        int i3 = (527 + i) * 31;
        int[] iArr = this.f1099b;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = (i3 + i10) * 31;
        Object[] objArr = this.f1100c;
        int i13 = this.f1098a;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return i12 + iHashCode;
    }
}
