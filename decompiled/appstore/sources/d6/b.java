package d6;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f19096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class[] f19097b = null;

    static {
        f19096a = new Object[0];
        f19097b = new Class[0];
    }

    public static Class[] a(Class[] r10) {
        if (r10 == null) goto L7;
        if (r10.length == 0) goto L7;
        return r10;
    L7:
        return f19097b;
    }

    public static Object[] b(Object[] r10) {
        if (r10 == null) goto L7;
        if (r10.length == 0) goto L7;
        return r10;
    L7:
        return f19096a;
    }

    public static Class[] c(Object... r10) {
        if (r10 == null) goto L15;
        if (r10.length == 0) goto L15;
        Class[] r11 = new Class[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L13;
        Object r13 = r10[r12];
        if (r13 != null) goto L11;
        Class<?> r14 = null;
    L12:
        r11[r12] = r14;
        r12 = r12 + 1;
        goto L7
    L11:
        r14 = r13.getClass();
        goto L12
    L13:
        return r11;
    L15:
        return f19097b;
    }
}
