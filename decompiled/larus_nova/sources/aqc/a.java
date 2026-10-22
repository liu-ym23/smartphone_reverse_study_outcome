package aqc;

import com.volcengine.zeus.log.ZeusLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f15990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f15991b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f15992c = null;

    static {
        f15990a = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L4
        f15991b = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L4
        f15992c = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Throwable -> L4
        Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
    }

    public static Field a(Class<?> r100, String r101) {
        Method r102 = f15990a;
        Field r103 = null;
        if (r102 != null) goto L21;
    L15:
        if (r103 == null) goto L18;
        return r103;
    L18:
        return zpc.a.b(r100, r101);
    L21:
        Field r104 = (Field) r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L11
        if (r104 != null) goto L19;
    L14:
        r103 = r104;
        goto L15
    L19:
        r104.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        Throwable th10 = th;
    L13:
        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", new Object[]{r100.getName(), r101}), th10);
    L11:
        th = move-exception;
        th10 = th;
        r104 = null;
        goto L13
    }

    public static Method b(Class r100, Class... r110) {
        Method r101 = f15991b;
        Method r102 = null;
        if (r101 != null) goto L21;
    L15:
        if (r102 == null) goto L18;
        return r102;
    L18:
        return zpc.a.c(r100, "getKey", r110);
    L21:
        Method r103 = (Method) r101.invoke(r100, new Object[]{"getKey", r110});     // Catch: Throwable -> L11
        if (r103 != null) goto L19;
    L14:
        r102 = r103;
        goto L15
    L19:
        r103.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        Throwable th10 = th;
    L13:
        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", new Object[]{r100.getName(), "getKey"}), th10);
    L11:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L13
    }
}
