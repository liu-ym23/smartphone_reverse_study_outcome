package androidx.core.content.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: GrowingArrayUtils.java */
/* JADX INFO: loaded from: classes.dex */
final class g {
    public static int a(int r1) {
        if (r1 > 4) goto L6;
        return 8;
    L6:
        return r1 * 2;
    }

    public static <T> T[] a(T[] r3, int r4, T r5) {
        if ((r4 + 1) <= r3.length) goto L5;
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r3.getClass().getComponentType(), a(r4)), Object[].class, "com.obric.aiagent.plugin");
        System.arraycopy(r3, 0, r0, 0, r4);
        r3 = (T[]) r0;
    L5:
        r3[r4] = r5;
        return r3;
    }

    public static int[] a(int[] r2, int r3, int r4) {
        if ((r3 + 1) <= r2.length) goto L5;
        int[] r0 = new int[a(r3)];
        System.arraycopy(r2, 0, r0, 0, r3);
        r2 = r0;
    L5:
        r2[r3] = r4;
        return r2;
    }

    public static <T> T[] insert(T[] r2, int r3, int r4, T r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        T[] r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r2.getClass().getComponentType(), a(r3)), Object[].class, "com.obric.aiagent.plugin"));
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }

    public static int[] insert(int[] r2, int r3, int r4, int r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        int[] r6 = new int[a(r3)];
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }

    public static long[] insert(long[] r2, int r3, int r4, long r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        long[] r6 = new long[a(r3)];
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }

    public static boolean[] insert(boolean[] r2, int r3, int r4, boolean r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        boolean[] r6 = new boolean[a(r3)];
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }
}
