package k0;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h2 {
    public static final int a(int[] iArr, int i) {
        return iArr[(i * 5) + 3];
    }

    public static final int b(ArrayList arrayList, int i, int i3) {
        int iE = e(arrayList, i, i3);
        return iE >= 0 ? iE : -(iE + 1);
    }

    public static final int c(int[] iArr, int i) {
        int i3 = i * 5;
        return Integer.bitCount(iArr[i3 + 1] >> 28) + iArr[i3 + 4];
    }

    public static final void d(int i, int i3, int[] iArr) {
        if (i3 >= 0) {
        }
        int i10 = (i * 5) + 1;
        iArr[i10] = i3 | (iArr[i10] & (-67108864));
    }

    public static final int e(ArrayList arrayList, int i, int i3) {
        int size = arrayList.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int i12 = ((b) arrayList.get(i11)).f6864a;
            if (i12 < 0) {
                i12 += i3;
            }
            int iB = yb.k.b(i12, i);
            if (iB < 0) {
                i10 = i11 + 1;
            } else {
                if (iB <= 0) {
                    return i11;
                }
                size = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final void f() {
        throw new ConcurrentModificationException();
    }
}
