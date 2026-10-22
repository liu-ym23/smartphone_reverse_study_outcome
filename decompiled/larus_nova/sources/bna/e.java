package bna;

import android.app.Activity;
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
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    static {
    }

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

    public static ena.c b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L5;
        int r102 = b.f19777a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Rect r103 = r100.getWindowManager().getCurrentWindowMetrics().getBounds();
    L42:
        return new ena.c(r103);
    L5:
        int r104 = 0;
        if (r101 < 29) goto L18;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Configuration r105 = r100.getResources().getConfiguration();
        Field r106 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchMethodException -> L15 NoSuchFieldException -> L16
        r106.setAccessible(true);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchMethodException -> L15 NoSuchFieldException -> L16
        Object r107 = r106.get(r105);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchMethodException -> L15 NoSuchFieldException -> L16
        Object r108 = r107.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r107, new Object[0]);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchMethodException -> L15 NoSuchFieldException -> L16
        if (r108 == null) goto L12;
        r103 = new Rect((Rect) r108);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchMethodException -> L15 NoSuchFieldException -> L16
        goto L42
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchMethodException -> L15 NoSuchFieldException -> L16
    L14:
        r103 = c(r100);
    L16:
        r103 = c(r100);
    L15:
        r103 = c(r100);
    L13:
        r103 = c(r100);
        goto L42
    L18:
        if (r101 < 28) goto L21;
        r103 = c(r100);
        goto L42
    L21:
        if (r101 < 24) goto L34;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Rect r109 = new Rect();
        Display r110 = r100.getWindowManager().getDefaultDisplay();
        r110.getRectSize(r109);
        int r111 = a.f19776a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r100.isInMultiWindowMode() == true) goto L33;
        Point r112 = new Point();
        int r113 = c.f19778a;
        Intrinsics.checkNotNullParameter(r110, "display");
        Intrinsics.checkNotNullParameter(r112, "point");
        r110.getRealSize(r112);
        Resources r114 = r100.getResources();
        int r115 = r114.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r115 <= 0) goto L27;
        r104 = r114.getDimensionPixelSize(r115);
    L27:
        int r116 = r109.bottom + r104;
        if (r116 != r112.y) goto L30;
        r109.bottom = r116;
        goto L33
    L30:
        int r117 = r109.right + r104;
        if (r117 != r112.x) goto L33;
        r109.right = r117;
    L33:
        r103 = r109;
        goto L42
    L34:
        Display r118 = r100.getWindowManager().getDefaultDisplay();
        Point r119 = new Point();
        int r120 = c.f19778a;
        Intrinsics.checkNotNullParameter(r118, "display");
        Intrinsics.checkNotNullParameter(r119, "point");
        r118.getRealSize(r119);
        r109 = new Rect();
        int r121 = r119.x;
        if (r121 == 0) goto L40;
        int r122 = r119.y;
        if (r122 == 0) goto L40;
        r109.right = r121;
        r109.bottom = r122;
    L40:
        r118.getRectSize(r109);
        goto L33
    }

    public static Rect c(Activity r110) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Rect r100 = new Rect();
        Configuration r101 = r110.getResources().getConfiguration();
        Field r102 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        Object r103 = r102.get(r101);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        int r104 = a.f19776a;     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        Intrinsics.checkNotNullParameter(r110, "activity");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r110.isInMultiWindowMode() == false) goto L11;
        Object r105 = r103.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r103, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r105 == null) goto L10;
        r100.set((Rect) r105);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L20:
        Display r106 = r110.getWindowManager().getDefaultDisplay();
        Point r107 = new Point();
        int r108 = c.f19778a;
        Intrinsics.checkNotNullParameter(r106, "display");
        Intrinsics.checkNotNullParameter(r107, "point");
        r106.getRealSize(r107);
        int r109 = a.f19776a;
        Intrinsics.checkNotNullParameter(r110, "activity");
        if (r110.isInMultiWindowMode() == true) goto L36;
        Resources r111 = r110.getResources();
        int r112 = r111.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r112 <= 0) goto L25;
        int r113 = r111.getDimensionPixelSize(r112);
    L26:
        int r114 = r100.bottom + r113;
        if (r114 != r107.y) goto L29;
        r100.bottom = r114;
        goto L36
    L29:
        int r115 = r100.right + r113;
        if (r115 != r107.x) goto L33;
        r100.right = r115;
        goto L36
    L33:
        if (r100.left != r113) goto L36;
        r100.left = 0;
        goto L36
    L25:
        r113 = 0;
    L36:
        if (r100.width() >= r107.x) goto L38;
    L39:
        Intrinsics.checkNotNullParameter(r110, "activity");
        if (r110.isInMultiWindowMode() == false) goto L61;
    L59:
        return r100;
    L61:
        Constructor r116 = a().getConstructor(new Class[0]);     // Catch: Throwable -> L60
        r116.setAccessible(true);     // Catch: Throwable -> L60
        Object r117 = r116.newInstance(new Object[0]);     // Catch: Throwable -> L60
        Method r118 = r106.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r117.getClass()});     // Catch: Throwable -> L60
        r118.setAccessible(true);     // Catch: Throwable -> L60
        r118.invoke(r106, new Object[]{r117});     // Catch: Throwable -> L60
        Field r119 = r117.getClass().getDeclaredField("displayCutout");     // Catch: Throwable -> L60
        r119.setAccessible(true);     // Catch: Throwable -> L60
        Object r120 = r119.get(r117);     // Catch: Throwable -> L60
        if ((r120 instanceof DisplayCutout) == false) goto L45;
        DisplayCutout r121 = (DisplayCutout) r120;     // Catch: Throwable -> L60
    L46:
        if (r121 == null) goto L59;
        int r122 = r100.left;
        int r123 = d.f19779a;
        Intrinsics.checkNotNullParameter(r121, "displayCutout");
        if (r122 != r121.getSafeInsetLeft()) goto L50;
        r100.left = 0;
    L50:
        int r124 = r107.x - r100.right;
        Intrinsics.checkNotNullParameter(r121, "displayCutout");
        if (r124 != r121.getSafeInsetRight()) goto L53;
        int r125 = r100.right;
        Intrinsics.checkNotNullParameter(r121, "displayCutout");
        r100.right = r125 + r121.getSafeInsetRight();
    L53:
        int r126 = r100.top;
        Intrinsics.checkNotNullParameter(r121, "displayCutout");
        if (r126 != r121.getSafeInsetTop()) goto L56;
        r100.top = 0;
    L56:
        int r127 = r107.y - r100.bottom;
        Intrinsics.checkNotNullParameter(r121, "displayCutout");
        if (r127 != r121.getSafeInsetBottom()) goto L59;
        int r128 = r100.bottom;
        Intrinsics.checkNotNullParameter(r121, "displayCutout");
        r100.bottom = r128 + r121.getSafeInsetBottom();
    L45:
        r121 = null;
        goto L46
    L38:
        if (r100.height() >= r107.y) goto L59;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L11:
        Object r129 = r103.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r103, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r129 == null) goto L15;
        r100.set((Rect) r129);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        goto L20
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L17:
        r110.getWindowManager().getDefaultDisplay().getRectSize(r100);
    L19:
        r110.getWindowManager().getDefaultDisplay().getRectSize(r100);
    L18:
        r110.getWindowManager().getDefaultDisplay().getRectSize(r100);
    L16:
        r110.getWindowManager().getDefaultDisplay().getRectSize(r100);
        goto L20
    }
}
