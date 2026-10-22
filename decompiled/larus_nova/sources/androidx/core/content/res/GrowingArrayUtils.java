package androidx.core.content.res;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes17.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static int growSize(int r100) {
        if (r100 > 4) goto L6;
        return 8;
    L6:
        return r100 * 2;
    }

    public static <T> T[] append(T[] r100, int r101, T r102) {
        if ((r101 + 1) <= r100.length) goto L5;
        Object[] r103 = (Object[]) Array.newInstance(r100.getClass().getComponentType(), growSize(r101));
        System.arraycopy(r100, 0, r103, 0, r101);
        r100 = (T[]) r103;
    L5:
        r100[r101] = r102;
        return r100;
    }

    public static int[] append(int[] r100, int r101, int r102) {
        if ((r101 + 1) <= r100.length) goto L5;
        int[] r103 = new int[growSize(r101)];
        System.arraycopy(r100, 0, r103, 0, r101);
        r100 = r103;
    L5:
        r100[r101] = r102;
        return r100;
    }

    public static long[] append(long[] r100, int r101, long r102) {
        if ((r101 + 1) <= r100.length) goto L5;
        long[] r103 = new long[growSize(r101)];
        System.arraycopy(r100, 0, r103, 0, r101);
        r100 = r103;
    L5:
        r100[r101] = r102;
        return r100;
    }

    public static boolean[] append(boolean[] r100, int r101, boolean r102) {
        if ((r101 + 1) <= r100.length) goto L5;
        boolean[] r103 = new boolean[growSize(r101)];
        System.arraycopy(r100, 0, r103, 0, r101);
        r100 = r103;
    L5:
        r100[r101] = r102;
        return r100;
    }

    public static <T> T[] insert(T[] r100, int r101, int r102, T r103) {
        if ((r101 + 1) > r100.length) goto L6;
        System.arraycopy(r100, r102, r100, r102 + 1, r101 - r102);
        r100[r102] = r103;
        return r100;
    L6:
        T[] r104 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), growSize(r101)));
        System.arraycopy(r100, 0, r104, 0, r102);
        r104[r102] = r103;
        System.arraycopy(r100, r102, r104, r102 + 1, r100.length - r102);
        return r104;
    }

    public static int[] insert(int[] r100, int r101, int r102, int r103) {
        if ((r101 + 1) > r100.length) goto L6;
        System.arraycopy(r100, r102, r100, r102 + 1, r101 - r102);
        r100[r102] = r103;
        return r100;
    L6:
        int[] r104 = new int[growSize(r101)];
        System.arraycopy(r100, 0, r104, 0, r102);
        r104[r102] = r103;
        System.arraycopy(r100, r102, r104, r102 + 1, r100.length - r102);
        return r104;
    }

    public static long[] insert(long[] r100, int r101, int r102, long r103) {
        if ((r101 + 1) > r100.length) goto L6;
        System.arraycopy(r100, r102, r100, r102 + 1, r101 - r102);
        r100[r102] = r103;
        return r100;
    L6:
        long[] r104 = new long[growSize(r101)];
        System.arraycopy(r100, 0, r104, 0, r102);
        r104[r102] = r103;
        System.arraycopy(r100, r102, r104, r102 + 1, r100.length - r102);
        return r104;
    }

    public static boolean[] insert(boolean[] r100, int r101, int r102, boolean r103) {
        if ((r101 + 1) > r100.length) goto L6;
        System.arraycopy(r100, r102, r100, r102 + 1, r101 - r102);
        r100[r102] = r103;
        return r100;
    L6:
        boolean[] r104 = new boolean[growSize(r101)];
        System.arraycopy(r100, 0, r104, 0, r102);
        r104[r102] = r103;
        System.arraycopy(r100, r102, r104, r102 + 1, r100.length - r102);
        return r104;
    }
}
