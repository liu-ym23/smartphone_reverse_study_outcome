package k0;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public int[] f7029a;

    /* renamed from: b, reason: collision with root package name */
    public int f7030b;

    public r0() {
        this.f7029a = new int[10];
    }

    public int a(int i) {
        int i3 = this.f7030b - 1;
        return i3 >= 0 ? this.f7029a[i3] : i;
    }

    public int b() {
        int[] iArr = this.f7029a;
        int i = this.f7030b - 1;
        this.f7030b = i;
        return iArr[i];
    }

    public void c(int i) {
        int[] iArrCopyOf = this.f7029a;
        if (this.f7030b >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.f7029a = iArrCopyOf;
        }
        int i3 = this.f7030b;
        this.f7030b = i3 + 1;
        iArrCopyOf[i3] = i;
    }

    public void d(int i, int i3, int i10) {
        int i11 = this.f7030b;
        int[] iArrCopyOf = this.f7029a;
        int i12 = i11 + 3;
        if (i12 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.f7029a = iArrCopyOf;
        }
        iArrCopyOf[i11] = i + i10;
        iArrCopyOf[i11 + 1] = i3 + i10;
        iArrCopyOf[i11 + 2] = i10;
        this.f7030b = i12;
    }

    public void e(int i, int i3, int i10, int i11) {
        int i12 = this.f7030b;
        int[] iArrCopyOf = this.f7029a;
        int i13 = i12 + 4;
        if (i13 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.f7029a = iArrCopyOf;
        }
        iArrCopyOf[i12] = i;
        iArrCopyOf[i12 + 1] = i3;
        iArrCopyOf[i12 + 2] = i10;
        iArrCopyOf[i12 + 3] = i11;
        this.f7030b = i13;
    }

    public void f(int i, int i3) {
        if (i < i3) {
            int i10 = i - 3;
            for (int i11 = i; i11 < i3; i11 += 3) {
                int[] iArr = this.f7029a;
                int i12 = iArr[i11];
                int i13 = iArr[i3];
                if (i12 < i13 || (i12 == i13 && iArr[i11 + 1] <= iArr[i3 + 1])) {
                    i10 += 3;
                    g(i10, i11);
                }
            }
            g(i10 + 3, i3);
            f(i, i10);
            f(i10 + 6, i3);
        }
    }

    public void g(int i, int i3) {
        int[] iArr = this.f7029a;
        int i10 = iArr[i];
        iArr[i] = iArr[i3];
        iArr[i3] = i10;
        int i11 = i + 1;
        int i12 = i3 + 1;
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
        int i14 = i + 2;
        int i15 = i3 + 2;
        int i16 = iArr[i14];
        iArr[i14] = iArr[i15];
        iArr[i15] = i16;
    }

    public r0(int i) {
        this.f7029a = new int[i];
    }
}
