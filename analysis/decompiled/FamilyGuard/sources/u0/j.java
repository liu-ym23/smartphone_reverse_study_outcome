package u0;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f22794a = false;

    static {
        try {
            Class.forName("java.sql.Time");
            f22794a = true;
        } catch (Throwable unused) {
            f22794a = false;
        }
    }

    public static <T> T a(Callable<T> callable) {
        if (!f22794a) {
            return null;
        }
        try {
            return callable.call();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static <T, U, R> R b(InterfaceC1153c<T, U, R> interfaceC1153c, T t5, U u5) {
        if (f22794a) {
            return interfaceC1153c.apply(t5, u5);
        }
        return null;
    }

    public static <ARG, T> T c(InterfaceC1155e<ARG, T> interfaceC1155e, ARG arg) {
        if (f22794a) {
            return interfaceC1155e.apply(arg);
        }
        return null;
    }
}
