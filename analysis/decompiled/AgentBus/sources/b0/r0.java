package b0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1327a;

    /* renamed from: b, reason: collision with root package name */
    public int f1328b;

    public r0() {
        this.f1327a = new int[10];
    }

    public int a(int i2) {
        int i10 = this.f1328b - 1;
        return i10 >= 0 ? this.f1327a[i10] : i2;
    }

    public int b() {
        int[] iArr = this.f1327a;
        int i2 = this.f1328b - 1;
        this.f1328b = i2;
        return iArr[i2];
    }

    public void c(int i2) {
        int[] iArrCopyOf = this.f1327a;
        if (this.f1328b >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f1327a = iArrCopyOf;
        }
        int i10 = this.f1328b;
        this.f1328b = i10 + 1;
        iArrCopyOf[i10] = i2;
    }

    public void d(int i2, int i10, int i11) {
        int i12 = this.f1328b;
        int[] iArrCopyOf = this.f1327a;
        int i13 = i12 + 3;
        if (i13 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f1327a = iArrCopyOf;
        }
        iArrCopyOf[i12] = i2 + i11;
        iArrCopyOf[i12 + 1] = i10 + i11;
        iArrCopyOf[i12 + 2] = i11;
        this.f1328b = i13;
    }

    public void e(int i2, int i10, int i11, int i12) {
        int i13 = this.f1328b;
        int[] iArrCopyOf = this.f1327a;
        int i14 = i13 + 4;
        if (i14 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f1327a = iArrCopyOf;
        }
        iArrCopyOf[i13] = i2;
        iArrCopyOf[i13 + 1] = i10;
        iArrCopyOf[i13 + 2] = i11;
        iArrCopyOf[i13 + 3] = i12;
        this.f1328b = i14;
    }

    public void f(int i2, int i10) {
        if (i2 < i10) {
            int i11 = i2 - 3;
            for (int i12 = i2; i12 < i10; i12 += 3) {
                int[] iArr = this.f1327a;
                int i13 = iArr[i12];
                int i14 = iArr[i10];
                if (i13 < i14 || (i13 == i14 && iArr[i12 + 1] <= iArr[i10 + 1])) {
                    i11 += 3;
                    g(i11, i12);
                }
            }
            g(i11 + 3, i10);
            f(i2, i11);
            f(i11 + 6, i10);
        }
    }

    public void g(int i2, int i10) {
        int[] iArr = this.f1327a;
        int i11 = iArr[i2];
        iArr[i2] = iArr[i10];
        iArr[i10] = i11;
        int i12 = i2 + 1;
        int i13 = i10 + 1;
        int i14 = iArr[i12];
        iArr[i12] = iArr[i13];
        iArr[i13] = i14;
        int i15 = i2 + 2;
        int i16 = i10 + 2;
        int i17 = iArr[i15];
        iArr[i15] = iArr[i16];
        iArr[i16] = i17;
    }

    public r0(int i2) {
        this.f1327a = new int[i2];
    }
}
