package q;

import java.lang.reflect.Array;

/* renamed from: q.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0935c {
    static <T> T[] a(T[] tArr, int i5) {
        if (tArr.length < i5) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5));
        }
        if (tArr.length > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }
}
