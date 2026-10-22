package n;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static int[] a(int[] r10, int r11, int r12) {
        if ((r11 + 1) <= r10.length) goto L5;
        int[] r13 = new int[c(r11)];
        System.arraycopy(r10, 0, r13, 0, r11);
        r10 = r13;
    L5:
        r10[r11] = r12;
        return r10;
    }

    public static Object[] b(Object[] r10, int r11, Object r12) {
        if ((r11 + 1) <= r10.length) goto L5;
        Object[] r13 = (Object[]) Array.newInstance(r10.getClass().getComponentType(), c(r11));
        System.arraycopy(r10, 0, r13, 0, r11);
        r10 = r13;
    L5:
        r10[r11] = r12;
        return r10;
    }

    public static int c(int r10) {
        if (r10 > 4) goto L6;
        return 8;
    L6:
        return r10 * 2;
    }
}
