package androidx.d;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Trace.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f1567b;

    public static boolean a() {
        if (f1567b != null) goto L7;
        return Trace.isEnabled();
    L7:
        return c();
    }

    public static void a(String r2) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        b.a(r2);
        return;
    }

    public static void b() {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        b.a();
        return;
    }

    private static boolean c() {
        if (Build.VERSION.SDK_INT >= 18) goto L12;
    L11:
        return false;
    L12:
    L9:
        e = move-exception;
        a("isTagEnabled", e);
        goto L11
    L5:
        if (f1567b != null) goto L7;
        f1566a = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L9
        f1567b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L9
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(f1567b.invoke(null, new Object[]{Long.valueOf(f1566a)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static void a(String r2, Exception r3) {
        if (ZeusTransformUtils.instanceOf(r3, InvocationTargetException.class) == false) goto L10;
        Throwable r4 = r3.getCause();
        if (ZeusTransformUtils.instanceOf(r4, RuntimeException.class) == false) goto L9;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r4, RuntimeException.class, "com.obric.aiagent.plugin"));
    L9:
        throw new RuntimeException(r4);
    L10:
        a("Trace", "Unable to call " + r2 + " via reflection", r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2, r3);
    }
}
