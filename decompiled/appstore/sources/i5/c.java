package i5;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class[] f20508a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object[] f20509b = null;

    static {
        f20508a = new Class[0];
        f20509b = new Object[0];
    }

    public static boolean a(Object[] r10, Object[] r11) {
        if (r10 != null) goto L6;
        if (r11 == null) goto L6;
        if (r11.length <= 0) goto L6;
        return false;
    L6:
        if (r11 != null) goto L10;
        if (r10 == null) goto L10;
        if (r10.length <= 0) goto L10;
        return false;
    L10:
        if (r10 == null) goto L16;
        if (r11 != null) goto L13;
        return true;
    L13:
        if (r10.length == r11.length) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }

    public static Object[] b(Object[] r10) {
        if (r10 == null) goto L7;
        if (r10.length <= 0) goto L7;
        return r10;
    L7:
        return f20509b;
    }

    public static Class[] c(Object... r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.length == 0) goto L8;
        Class[] r11 = new Class[r10.length];
        int r12 = 0;
    L11:
        if (r12 >= r10.length) goto L17;
        Object r13 = r10[r12];
        if (r13 != null) goto L15;
        Class<?> r14 = null;
    L16:
        r11[r12] = r14;
        r12 = r12 + 1;
        goto L11
    L15:
        r14 = r13.getClass();
        goto L16
    L17:
        return r11;
    L8:
        return f20508a;
    }
}
