package m9;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f22220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f22221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f22222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f22223d;

    static {
        f22220a = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L8
    L12:
        f22221b = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
    L18:
        f22222c = WindowManager.LayoutParams.class.getField("statusBarColor");     // Catch: NoSuchFieldException -> L10
    L16:
        f22223d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);     // Catch: Throwable -> L11
        return;
    }

    public static boolean a(int r10, int r11) {
        if (i(r10) >= r11) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Window r10, int r11) {
        WindowManager.LayoutParams r12 = r10.getAttributes();
        Field r13 = f22222c;
        if (r13 == null) goto L13;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r13.getInt(r12) == r11) goto L14;
        f22222c.set(r12, Integer.valueOf(r11));     // Catch: IllegalAccessException -> L8
        r10.setAttributes(r12);     // Catch: IllegalAccessException -> L8
        return;
    L14:
        return;
    }

    public static void c(Activity r10, int r11) {
        Method r12 = f22220a;
        if (r12 != null) goto L17;
        boolean r13 = a(r11, 50);
        if (f22222c == null) goto L15;
        e(r10, r13, r13);
        g(r10.getWindow(), r11);
        return;
    L15:
        d(r10, r13);
        return;
    L17:
        r12.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8
    L22:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(Activity r10, boolean r11) {
        e(r10, r11, true);
    }

    public static void e(Activity r10, boolean r11, boolean r12) {
        Method r13 = f22221b;
        if (r13 != null) goto L15;
        if (r12 == false) goto L19;
        h(r10.getWindow(), r11);
        return;
    L19:
        return;
    L15:
        r13.invoke(r10, new Object[]{Boolean.valueOf(r11)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8
    L20:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void f(View r10, boolean r11) {
        int r12 = r10.getSystemUiVisibility();
        if (r11 == false) goto L5;
        int r13 = f22223d | r12;
    L6:
        if (r13 == r12) goto L9;
        r10.setSystemUiVisibility(r13);
        return;
    L9:
        return;
    L5:
        r13 = (~f22223d) & r12;
        goto L6
    }

    public static void g(Window r10, int r11) {
        b(r10, r11);     // Catch: Exception -> L4
        f(r10.getDecorView(), true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(Window r10, boolean r11) {
        f(r10.getDecorView(), r11);
        b(r10, 0);
    }

    public static int i(int r10) {
        int r11 = r10 & PrivateKeyType.INVALID;
        int r12 = (65280 & r10) >> 8;
        return (((((r10 & 16711680) >> 16) * 38) + (r12 * 75)) + (r11 * 15)) >> 7;
    }
}
