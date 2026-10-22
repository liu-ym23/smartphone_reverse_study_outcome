package m9;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22254a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f22255b = false;

    static {
    }

    public static DisplayCutout a(Activity r10) {
        if (r10 == null) goto L9;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L11;
        WindowInsets r12 = r11.getDecorView().getRootWindowInsets();
        if (r12 != null) goto L8;
        return null;
    L8:
        return r12.getDisplayCutout();
    L11:
        return null;
    L9:
        return null;
    }

    public static boolean b(Activity r10) {
        if (a(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(Context r10) {
        Class<?> r11 = r10.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L4
        return ((Boolean) r11.getMethod("hasNotchInScreen", null).invoke(r11, null)).booleanValue();
    L4:
        return false;
    }

    public static boolean d(Context r10) {
        return r10.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    L4:
        return false;
    }

    public static boolean e(Context r10) {
        Class<?> r11 = r10.getClassLoader().loadClass("android.util.FtFeature");     // Catch: Throwable -> L4
        return ((Boolean) r11.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r11, new Object[]{32})).booleanValue();
    L4:
        return false;
    }

    public static boolean f(Context r10) {
        if ("Xiaomi".equals(Build.MANUFACTURER) == true) goto L12;
    L6:
        int r11 = 0;
    L8:
        if (r11 == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        Class<?> r12 = r10.getClassLoader().loadClass("android.os.SystemProperties");     // Catch: Throwable -> L11
        r11 = ((Integer) r12.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r12, new Object[]{"ro.miui.notch", 0})).intValue();     // Catch: Throwable -> L11
        goto L8
    }

    public static boolean g(Activity r10) {
        if (f22255b == true) goto L5;
        boolean r11 = false;
        if (r10 != null) goto L10;
        return false;
    L10:
        if (f(r10) == false) goto L12;
    L19:
        r11 = true;
    L20:
        f22254a = r11;
        f22255b = true;
        return r11;
    L12:
        if (c(r10) == true) goto L19;
        if (d(r10) == true) goto L19;
        if (e(r10) == true) goto L19;
        if (b(r10) == false) goto L20;
    L5:
        return f22254a;
    }
}
