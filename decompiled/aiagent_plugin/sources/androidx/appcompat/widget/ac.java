package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ac {
    private static final String TAG = "ViewUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f411a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f412b;

    static {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        boolean r0 = true;
    L6:
        f411a = r0;
        if (Build.VERSION.SDK_INT < 18) goto L16;
        Method r1 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L12
        f412b = r1;     // Catch: NoSuchMethodException -> L12
        if (r1.isAccessible() == true) goto L17;
        f412b.setAccessible(true);     // Catch: NoSuchMethodException -> L12
        return;
    L17:
        return;
    L12:
        a(TAG, "Could not find method computeFitSystemWindows. Oh well.");
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean a(View r1) {
        if (ViewCompat.i(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void a(View r3, Rect r4, Rect r5) {
        Method r0 = f412b;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.invoke(r3, new Object[]{r4, r5});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a(TAG, "Could not invoke computeFitSystemWindows", e);
    }

    public static void b(View r6) {
        if (Build.VERSION.SDK_INT < 16) goto L17;
        Method r2 = r6.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L11 NoSuchMethodException -> L13
        if (r2.isAccessible() == true) goto L7;
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L11 NoSuchMethodException -> L13
    L7:
        r2.invoke(r6, new Object[0]);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L11 NoSuchMethodException -> L13
    L20:
        return;
    L9:
        e = move-exception;
        a(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    L13:
        a(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
    L11:
        e = move-exception;
        a(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
