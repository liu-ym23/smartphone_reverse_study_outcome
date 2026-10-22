package com.bytedance.android.livesdk.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.DisplayCutout;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class k4 {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.DisplayInfo");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.DisplayInfo");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.DisplayInfo");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.DisplayInfo");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.DisplayInfo");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.DisplayInfo");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.DisplayInfo");
    }

    static {
    }

    @JvmStatic
    public static final Activity b(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof Application) == false) goto L9;
        return null;
    L9:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return b(((ContextWrapper) r100).getBaseContext());
    }

    @JvmStatic
    public static final Rect c(Context r100) {
        Activity r101 = b(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 30) goto L48;
        int r103 = 0;
        if (r102 < 29) goto L22;
        Configuration r104 = r101.getResources().getConfiguration();
        Field r105 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L18 NoSuchMethodException -> L19 NoSuchFieldException -> L20
        r105.setAccessible(true);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L18 NoSuchMethodException -> L19 NoSuchFieldException -> L20
        Object r106 = r105.get(r104);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L18 NoSuchMethodException -> L19 NoSuchFieldException -> L20
        Object r107 = r106.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r106, new Object[0]);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L18 NoSuchMethodException -> L19 NoSuchFieldException -> L20
        if (r107 == null) goto L16;
        return new Rect((Rect) r107);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L18 NoSuchMethodException -> L19 NoSuchFieldException -> L20
    L51:
        return d(r101);
    L53:
        return d(r101);
    L52:
        return d(r101);
    L50:
        return d(r101);
    L22:
        if (r102 < 28) goto L25;
        return d(r101);
    L25:
        if (r102 < 24) goto L38;
        Rect r108 = new Rect();
        Display r109 = r101.getWindowManager().getDefaultDisplay();
        r109.getRectSize(r108);
        if (e(r101) == true) goto L55;
        Point r110 = new Point();
        r109.getRealSize(r110);
        Resources r111 = r101.getResources();
        int r112 = r111.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r112 <= 0) goto L31;
        r103 = r111.getDimensionPixelSize(r112);
    L31:
        int r113 = r108.bottom + r103;
        if (r113 != r110.y) goto L34;
        r108.bottom = r113;
        goto L55
    L34:
        int r114 = r108.right + r103;
        if (r114 != r110.x) goto L55;
        r108.right = r114;
    L55:
        return r108;
    L38:
        Display r115 = r101.getWindowManager().getDefaultDisplay();
        Point r116 = new Point();
        r115.getRealSize(r116);
        Rect r117 = new Rect();
        int r118 = r116.x;
        if (r118 == 0) goto L44;
        int r119 = r116.y;
        if (r119 == 0) goto L44;
        r117.right = r118;
        r117.bottom = r119;
    L46:
        return r117;
    L44:
        r115.getRectSize(r117);
        goto L46
    L48:
        return r101.getWindowManager().getCurrentWindowMetrics().getBounds();
    }

    public static Rect d(Activity r100) {
        Rect r101 = new Rect();
        Configuration r102 = r100.getResources().getConfiguration();
        Field r103 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        r103.setAccessible(true);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        Object r104 = r103.get(r102);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (e(r100) != true) goto L11;
        Object r105 = r104.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r104, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r105 == null) goto L10;
        r101.set((Rect) r105);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L20:
        Display r106 = r100.getWindowManager().getDefaultDisplay();
        Point r107 = new Point();
        r106.getRealSize(r107);
        if (e(r100) == true) goto L36;
        Resources r108 = r100.getResources();
        int r109 = r108.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r109 <= 0) goto L25;
        int r110 = r108.getDimensionPixelSize(r109);
    L26:
        int r111 = r101.bottom + r110;
        if (r111 != r107.y) goto L29;
        r101.bottom = r111;
        goto L36
    L29:
        int r112 = r101.right + r110;
        if (r112 != r107.x) goto L33;
        r101.right = r112;
        goto L36
    L33:
        if (r101.left != r110) goto L36;
        r101.left = 0;
        goto L36
    L25:
        r110 = 0;
    L36:
        if (r101.width() < r107.x) goto L40;
        if (r101.height() < r107.y) goto L40;
    L59:
        return r101;
    L40:
        if (e(r100) == true) goto L59;
        Constructor r113 = a().getConstructor(new Class[0]);     // Catch: Throwable -> L60
        r113.setAccessible(true);     // Catch: Throwable -> L60
        Object r114 = r113.newInstance(new Object[0]);     // Catch: Throwable -> L60
        Method r115 = r106.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r114.getClass()});     // Catch: Throwable -> L60
        r115.setAccessible(true);     // Catch: Throwable -> L60
        r115.invoke(r106, new Object[]{r114});     // Catch: Throwable -> L60
        Field r116 = r114.getClass().getDeclaredField("displayCutout");     // Catch: Throwable -> L60
        r116.setAccessible(true);     // Catch: Throwable -> L60
        Object r117 = r116.get(r114);     // Catch: Throwable -> L60
        if ((r117 instanceof DisplayCutout) == false) goto L45;
        DisplayCutout r118 = (DisplayCutout) r117;     // Catch: Throwable -> L60
    L46:
        if (r118 == null) goto L59;
        if (r101.left != r118.getSafeInsetLeft()) goto L51;
        r101.left = 0;
    L51:
        if ((r107.x - r101.right) != r118.getSafeInsetRight()) goto L54;
        r101.right += r118.getSafeInsetRight();
    L54:
        if (r101.top != r118.getSafeInsetTop()) goto L57;
        r101.top = 0;
    L57:
        if ((r107.y - r101.bottom) != r118.getSafeInsetBottom()) goto L59;
        r101.bottom += r118.getSafeInsetBottom();
    L45:
        r118 = null;
        goto L46
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L11:
        Object r119 = r104.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r104, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r119 == null) goto L15;
        r101.set((Rect) r119);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        goto L20
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L17:
        r100.getWindowManager().getDefaultDisplay().getRectSize(r101);
    L19:
        r100.getWindowManager().getDefaultDisplay().getRectSize(r101);
    L18:
        r100.getWindowManager().getDefaultDisplay().getRectSize(r101);
    L16:
        r100.getWindowManager().getDefaultDisplay().getRectSize(r101);
        goto L20
    }

    @JvmStatic
    public static final boolean e(Context r100) {
        Activity r101 = b(r100);
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isInMultiWindowMode() != true) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }
}
