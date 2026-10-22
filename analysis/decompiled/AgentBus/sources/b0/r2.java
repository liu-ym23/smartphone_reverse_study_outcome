package b0;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public abstract class r2 {
    public static final int a(int i2, int[] iArr) {
        return iArr[(i2 * 5) + 3];
    }

    public static final int b(ArrayList arrayList, int i2, int i10) {
        int iE = e(arrayList, i2, i10);
        return iE >= 0 ? iE : -(iE + 1);
    }

    public static final int c(int i2, int[] iArr) {
        int i10 = i2 * 5;
        return Integer.bitCount(iArr[i10 + 1] >> 28) + iArr[i10 + 4];
    }

    public static final void d(int i2, int i10, int[] iArr) {
        if (i10 >= 0) {
        }
        int i11 = (i2 * 5) + 1;
        iArr[i11] = i10 | (iArr[i11] & (-67108864));
    }

    public static final int e(ArrayList arrayList, int i2, int i10) {
        int size = arrayList.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            int i13 = ((a) arrayList.get(i12)).f1096a;
            if (i13 < 0) {
                i13 += i10;
            }
            int iF = q7.k.f(i13, i2);
            if (iF < 0) {
                i11 = i12 + 1;
            } else {
                if (iF <= 0) {
                    return i12;
                }
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static final void f() {
        throw new ConcurrentModificationException();
    }
}
