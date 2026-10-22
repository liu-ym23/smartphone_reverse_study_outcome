package p;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static float a(float r10, float r11, float r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        if (r10 <= r12) goto L8;
        return r12;
    L8:
        return r10;
    }

    public static int b(int r10, int r11, int r12) {
        if (r10 >= r11) goto L4;
        return r11;
    L4:
        if (r10 <= r12) goto L6;
        return r12;
    L6:
        return r10;
    }

    public static long c(long r10, long r11, long r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        if (r10 <= r12) goto L8;
        return r12;
    L8:
        return r10;
    }
}
