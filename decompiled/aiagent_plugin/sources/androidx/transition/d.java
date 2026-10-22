package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: CanvasUtils.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f2813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2814c;

    static void a(Canvas r5, boolean r6) {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r6 == false) goto L9;
        r5.enableZ();
        return;
    L9:
        r5.disableZ();
        return;
    L11:
        if (Build.VERSION.SDK_INT == 28) goto L32;
        if (f2814c == false) goto L35;
    L17:
        if (r6 == true) goto L37;
    L23:
        if (r6 == true) goto L40;
        Method r7 = f2813b;     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
        if (r7 == null) goto L41;
        r7.invoke(r5, new Object[0]);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
    L21:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    L44:
        return;
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L37:
        Method r0 = f2812a;     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
        if (r0 == null) goto L23;
        r0.invoke(r5, new Object[0]);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
        goto L23
    L35:
        Method r2 = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);     // Catch: NoSuchMethodException -> L33
        f2812a = r2;     // Catch: NoSuchMethodException -> L33
        r2.setAccessible(true);     // Catch: NoSuchMethodException -> L33
        Method r3 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);     // Catch: NoSuchMethodException -> L33
        f2813b = r3;     // Catch: NoSuchMethodException -> L33
        r3.setAccessible(true);     // Catch: NoSuchMethodException -> L33
    L16:
        f2814c = true;
        goto L17
    L32:
        throw new IllegalStateException("This method doesn't work on Pie!");
    }
}
