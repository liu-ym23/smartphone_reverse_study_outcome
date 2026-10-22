package androidx.collection;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes6.dex */
class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    public static <T> T[] resizeForToArray(T[] r100, int r101) {
        if (r100.length >= r101) goto L7;
        return (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r101));
    L7:
        if (r100.length <= r101) goto L9;
        r100[r101] = null;
    L9:
        return r100;
    }
}
