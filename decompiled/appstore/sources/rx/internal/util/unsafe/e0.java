package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f24434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f24435b = false;

    static {
        if (System.getProperty("rx.unsafe-disable") == null) goto L5;
        boolean r10 = true;
    L6:
        f24435b = r10;
        Unsafe r11 = null;
        Field r12 = Unsafe.class.getDeclaredField("theUnsafe");     // Catch: Throwable -> L11
        r12.setAccessible(true);     // Catch: Throwable -> L11
        r11 = (Unsafe) r12.get(null);     // Catch: Throwable -> L11
    L9:
        f24434a = r11;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static long a(Class r10, String r11) {
        Field r12 = r10.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L4
        return f24434a.objectFieldOffset(r12);
    L4:
        e = move-exception;
        InternalError r13 = new InternalError();
        r13.initCause(e);
        throw r13;
    }

    public static boolean b() {
        if (f24434a != null) goto L5;
    L7:
        return false;
    L5:
        if (f24435b == true) goto L7;
        return true;
    }
}
