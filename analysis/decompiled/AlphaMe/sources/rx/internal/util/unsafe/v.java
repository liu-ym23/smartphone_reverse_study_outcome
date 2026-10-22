package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f14123a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f14124b;

    static {
        f14124b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f14123a = unsafe;
    }

    public static long a(Class cls, String str) throws NoSuchFieldException {
        try {
            return f14123a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e4) {
            InternalError internalError = new InternalError();
            internalError.initCause(e4);
            throw internalError;
        }
    }
}
