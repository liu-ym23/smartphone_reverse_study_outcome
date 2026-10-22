package com.gyf.barlibrary;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: FlymeOSStatusBarFontUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f13802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f13803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f13804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f13805d;

    public static int a(int r3) {
        int r0 = r3 & 255;
        int r1 = (65280 & r3) >> 8;
        return (((((r3 & 16711680) >> 16) * 38) + (r1 * 75)) + (r0 * 15)) >> 7;
    }

    static {
        f13802a = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L8
    L16:
        f13803b = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
    L12:
        f13804c = WindowManager.LayoutParams.class.getField("statusBarColor");     // Catch: NoSuchFieldException -> L10
    L14:
        f13805d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);     // Catch: Throwable -> L11
        return;
    }

    public static boolean a(int r0, int r1) {
        if (a(r0) >= r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(Activity r3, int r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        Method r0 = f13802a;
        if (r0 != null) goto L16;
        boolean r1 = a(r4, 50);
        if (f13804c == null) goto L14;
        a(r5, r1, r1);
        a(ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin"), r4);
        return;
    L14:
        a(r5, r1);
        return;
    L16:
        r0.invoke(r5, new Object[]{Integer.valueOf(r4)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L21:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Window r1, int r2) {
        b(r1, r2);     // Catch: Exception -> L6
        if (Build.VERSION.SDK_INT <= 22) goto L11;
        a(r1.getDecorView(), true);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Activity r2, boolean r3) {
        a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), r3, true);
    }

    private static boolean a(WindowManager.LayoutParams r3, String r4, boolean r5) {
        Field r6 = r3.getClass().getDeclaredField(r4);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        r6.setAccessible(true);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        int r7 = r6.getInt(r3);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        Field r1 = r3.getClass().getDeclaredField("meizuFlags");     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        r1.setAccessible(true);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        int r2 = r1.getInt(r3);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r5 == false) goto L5;
        int r8 = r7 | r2;     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
    L6:
        if (r2 == r8) goto L21;
        r1.setInt(r3, r8);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        return true;
    L21:
        return false;
    L5:
        r8 = (~r7) & r2;     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private static void a(View r1, boolean r2) {
        int r0 = r1.getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = f13805d | r0;
    L6:
        if (r3 == r0) goto L9;
        r1.setSystemUiVisibility(r3);
        return;
    L9:
        return;
    L5:
        r3 = (~f13805d) & r0;
        goto L6
    }

    private static void b(Window r2, int r3) {
        WindowManager.LayoutParams r0 = r2.getAttributes();
        Field r1 = f13804c;
        if (r1 == null) goto L13;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r1.getInt(r0) == r3) goto L14;
        f13804c.set(r0, Integer.valueOf(r3));     // Catch: IllegalAccessException -> L8
        r2.setAttributes(r0);     // Catch: IllegalAccessException -> L8
        return;
    L14:
        return;
    }

    public static void a(Window r2, boolean r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        a(r2.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", r3);
        return;
    L5:
        a(r2.getDecorView(), r3);
        b(r2, 0);
    }

    private static void a(Activity r2, boolean r3, boolean r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        Method r0 = f13803b;
        if (r0 != null) goto L14;
        if (r4 == false) goto L18;
        a(ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin"), r3);
        return;
    L18:
        return;
    L14:
        r0.invoke(r5, new Object[]{Boolean.valueOf(r3)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
