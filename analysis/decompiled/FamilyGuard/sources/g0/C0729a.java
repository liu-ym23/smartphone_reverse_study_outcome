package g0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0729a {

    /* renamed from: a, reason: collision with root package name */
    private static long f17224a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f17225b;

    public static void a(String str) {
        b.a(str);
    }

    public static void b() {
        b.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        try {
            if (f17225b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f17225b == null) {
                f17224a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f17225b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f17225b.invoke(null, Long.valueOf(f17224a))).booleanValue();
        } catch (Exception e6) {
            c("isTagEnabled", e6);
            return false;
        }
    }
}
