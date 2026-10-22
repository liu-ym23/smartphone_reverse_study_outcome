package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f1033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1034b = false;

    static {
        f1034b = true;
        Method r10 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L7
        f1033a = r10;     // Catch: NoSuchMethodException -> L7
        if (r10.isAccessible() == true) goto L11;
        f1033a.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        return;
    L11:
        return;
    L7:
        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
    }

    public static void a(View r10, Rect r11, Rect r12) {
        Method r13 = f1033a;
        if (r13 == null) goto L11;
        r13.invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
        return;
    }

    public static boolean b(View r10) {
        if (ViewCompat.A(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void c(View r10) {
        Method r11 = r10.getClass().getMethod("makeOptionalFitsSystemWindows", null);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
        if (r11.isAccessible() == true) goto L10;
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
    L10:
        r11.invoke(r10, null);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
    L20:
        return;
    L6:
        e = move-exception;
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    L14:
        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
    L8:
        e = move-exception;
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
    }
}
