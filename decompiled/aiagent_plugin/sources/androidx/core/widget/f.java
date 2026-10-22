package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PopupWindowCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final String TAG = "PopupWindowCompatApi21";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f1545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1546d;

    /* JADX INFO: compiled from: PopupWindowCompat.java */
    static class a {
        static void a(PopupWindow r0, View r1, int r2, int r3, int r4) {
            r0.showAsDropDown(r1, r2, r3, r4);
        }
    }

    /* JADX INFO: compiled from: PopupWindowCompat.java */
    static class b {
        static void a(PopupWindow r0, boolean r1) {
            r0.setOverlapAnchor(r1);
        }

        static boolean a(PopupWindow r0) {
            return r0.getOverlapAnchor();
        }

        static void a(PopupWindow r0, int r1) {
            r0.setWindowLayoutType(r1);
        }

        static int b(PopupWindow r0) {
            return r0.getWindowLayoutType();
        }
    }

    public static void a(PopupWindow r2, View r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        a.a(r2, r3, r4, r5, r6);
        return;
    L6:
        if ((androidx.core.view.d.a(r6, ViewCompat.i(r3)) & 7) != 5) goto L8;
        r4 = r4 - (r2.getWidth() - r3.getWidth());
    L8:
        r2.showAsDropDown(r3, r4, r5);
    }

    public static void a(PopupWindow r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        b.a(r4, r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        return;
    L8:
        if (f1546d == false) goto L22;
    L15:
        Field r0 = f1545c;
        if (r0 == null) goto L28;
        r0.set(r4, Boolean.valueOf(r5));     // Catch: IllegalAccessException -> L19
        return;
    L19:
        e = move-exception;
        a(TAG, "Could not set overlap anchor field in PopupWindow", e);
        return;
    L28:
        return;
    L22:
        Field r2 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L12
        f1545c = r2;     // Catch: NoSuchFieldException -> L12
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L12
    L14:
        f1546d = true;
    L12:
        e = move-exception;
        a(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
        goto L14
    }

    public static void a(PopupWindow r6, int r7) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        b.a(r6, r7);
        return;
    L6:
        if (f1544b == false) goto L17;
    L9:
        Method r0 = f1543a;
        if (r0 == null) goto L20;
        r0.invoke(r6, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L13
        return;
    L21:
        return;
    L20:
        return;
    L17:
        Method r1 = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});     // Catch: Exception -> L14
        f1543a = r1;     // Catch: Exception -> L14
        r1.setAccessible(true);     // Catch: Exception -> L14
    L8:
        f1544b = true;
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
