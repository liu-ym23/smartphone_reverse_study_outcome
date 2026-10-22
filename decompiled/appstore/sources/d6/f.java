package d6;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static void a(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static Object b(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static void c(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11);
    }
}
