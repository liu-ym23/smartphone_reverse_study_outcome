package g0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f19780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f19781b;

    public static void a(String r10) {
        b.a(r10);
    }

    public static void b() {
        b.b();
    }

    public static void c(String r10, Exception r11) {
        if ((r11 instanceof InvocationTargetException) == false) goto L10;
        Throwable r12 = r11.getCause();
        if ((r12 instanceof RuntimeException) == false) goto L9;
        throw ((RuntimeException) r12);
    L9:
        throw new RuntimeException(r12);
    L10:
        Log.v("Trace", "Unable to call " + r10 + " via reflection", r11);
    }

    public static boolean d() {
        if (f19781b != null) goto L7;
        return Trace.isEnabled();
    L7:
        return e();
    }

    public static boolean e() {
    L6:
        e = move-exception;
        c("isTagEnabled", e);
        return false;
    L4:
        if (f19781b != null) goto L8;
        f19780a = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L6
        f19781b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L6
    L8:
        return ((Boolean) f19781b.invoke(null, new Object[]{Long.valueOf(f19780a)})).booleanValue();
    }
}
