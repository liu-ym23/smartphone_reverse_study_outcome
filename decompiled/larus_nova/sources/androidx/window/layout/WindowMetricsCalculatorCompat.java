package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
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
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "()V", "TAG", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "computeMaximumWindowMetrics", "computeWindowBoundsIceCreamSandwich", "Landroid/graphics/Rect;", "computeWindowBoundsIceCreamSandwich$window_release", "computeWindowBoundsN", "computeWindowBoundsN$window_release", "computeWindowBoundsP", "computeWindowBoundsP$window_release", "computeWindowBoundsQ", "computeWindowBoundsQ$window_release", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getRealSizeForDisplay", "Landroid/graphics/Point;", "getRealSizeForDisplay$window_release", "getRectSizeFromDisplay", "", "bounds", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = null;
    private static final String TAG = null;

    private WindowMetricsCalculatorCompat() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        INSTANCE = new WindowMetricsCalculatorCompat();
        TAG = "WindowMetricsCalculatorCompat";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_window_layout_WindowMetricsCalculatorCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private final DisplayCutout getCutoutForDisplay(Display r100) {
        Constructor r101 = INVOKESTATIC_androidx_window_layout_WindowMetricsCalculatorCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.DisplayInfo").getConstructor(new Class[0]);     // Catch: Throwable -> L8
        r101.setAccessible(true);     // Catch: Throwable -> L8
        Object r102 = r101.newInstance(new Object[0]);     // Catch: Throwable -> L8
        Method r103 = r100.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r102.getClass()});     // Catch: Throwable -> L8
        r103.setAccessible(true);     // Catch: Throwable -> L8
        r103.invoke(r100, new Object[]{r102});     // Catch: Throwable -> L8
        Field r104 = r102.getClass().getDeclaredField("displayCutout");     // Catch: Throwable -> L8
        r104.setAccessible(true);     // Catch: Throwable -> L8
        Object r105 = r104.get(r102);     // Catch: Throwable -> L8
        if ((r105 instanceof DisplayCutout) == false) goto L6;
        return (DisplayCutout) r105;
    L6:
        return null;
    }

    private final int getNavigationBarHeight(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 > 0) goto L7;
        return 0;
    L7:
        return r101.getDimensionPixelSize(r102);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeCurrentWindowMetrics(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L6;
        Rect r102 = ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(r100);
    L16:
        return new WindowMetrics(r102);
    L6:
        if (r101 < 29) goto L9;
        r102 = computeWindowBoundsQ$window_release(r100);
        goto L16
    L9:
        if (r101 < 28) goto L12;
        r102 = computeWindowBoundsP$window_release(r100);
        goto L16
    L12:
        if (r101 < 24) goto L14;
        r102 = computeWindowBoundsN$window_release(r100);
        goto L16
    L14:
        r102 = computeWindowBoundsIceCreamSandwich$window_release(r100);
        goto L16
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeMaximumWindowMetrics(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Rect r101 = ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(r100);
    L7:
        return new WindowMetrics(r101);
    L5:
        Point r102 = getRealSizeForDisplay$window_release(r100.getWindowManager().getDefaultDisplay());
        r101 = new Rect(0, 0, r102.x, r102.y);
        goto L7
    }

    public final Rect computeWindowBoundsIceCreamSandwich$window_release(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Display r101 = r100.getWindowManager().getDefaultDisplay();
        Point r102 = getRealSizeForDisplay$window_release(r101);
        Rect r103 = new Rect();
        int r104 = r102.x;
        if (r104 == 0) goto L8;
        int r105 = r102.y;
        if (r105 == 0) goto L8;
        r103.right = r104;
        r103.bottom = r105;
    L9:
        return r103;
    L8:
        r101.getRectSize(r103);
        goto L9
    }

    public final Rect computeWindowBoundsN$window_release(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Rect r101 = new Rect();
        Display r102 = r100.getWindowManager().getDefaultDisplay();
        r102.getRectSize(r101);
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r100) == true) goto L10;
        Point r103 = getRealSizeForDisplay$window_release(r102);
        int r104 = getNavigationBarHeight(r100);
        int r105 = r101.bottom;
        if ((r105 + r104) != r103.y) goto L7;
        r101.bottom = r105 + r104;
        goto L10
    L7:
        int r106 = r101.right;
        if ((r106 + r104) != r103.x) goto L10;
        r101.right = r106 + r104;
    L10:
        return r101;
    }

    public final Rect computeWindowBoundsP$window_release(Activity r110) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Rect r100 = new Rect();
        Configuration r101 = r110.getResources().getConfiguration();
        Field r102 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        Object r103 = r102.get(r101);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r110) == false) goto L11;
        Object r104 = r103.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r103, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r104 == null) goto L10;
        r100.set((Rect) r104);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L20:
        Display r105 = r110.getWindowManager().getDefaultDisplay();
        Point r106 = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(r105, r106);
        ActivityCompatHelperApi24 r107 = ActivityCompatHelperApi24.INSTANCE;
        if (r107.isInMultiWindowMode(r110) == true) goto L32;
        int r108 = getNavigationBarHeight(r110);
        int r109 = r100.bottom;
        if ((r109 + r108) != r106.y) goto L25;
        r100.bottom = r109 + r108;
        goto L32
    L25:
        int r111 = r100.right;
        if ((r111 + r108) != r106.x) goto L29;
        r100.right = r111 + r108;
        goto L32
    L29:
        if (r100.left != r108) goto L32;
        r100.left = 0;
    L32:
        if (r100.width() < r106.x) goto L36;
        if (r100.height() < r106.y) goto L36;
    L51:
        return r100;
    L36:
        if (r107.isInMultiWindowMode(r110) == true) goto L51;
        DisplayCutout r112 = getCutoutForDisplay(r105);
        if (r112 == null) goto L51;
        int r113 = r100.left;
        DisplayCompatHelperApi28 r114 = DisplayCompatHelperApi28.INSTANCE;
        if (r113 != r114.safeInsetLeft(r112)) goto L43;
        r100.left = 0;
    L43:
        if ((r106.x - r100.right) != r114.safeInsetRight(r112)) goto L46;
        r100.right += r114.safeInsetRight(r112);
    L46:
        if (r100.top != r114.safeInsetTop(r112)) goto L49;
        r100.top = 0;
    L49:
        if ((r106.y - r100.bottom) != r114.safeInsetBottom(r112)) goto L51;
        r100.bottom += r114.safeInsetBottom(r112);
        goto L51
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L11:
        Object r115 = r103.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r103, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        if (r115 == null) goto L15;
        r100.set((Rect) r115);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
        goto L20
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L17 NoSuchMethodException -> L18 NoSuchFieldException -> L19
    L17:
        getRectSizeFromDisplay(r110, r100);
    L19:
        getRectSizeFromDisplay(r110, r100);
    L18:
        getRectSizeFromDisplay(r110, r100);
    L16:
        getRectSizeFromDisplay(r110, r100);
        goto L20
    }

    public final Rect computeWindowBoundsQ$window_release(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Configuration r101 = r100.getResources().getConfiguration();
        Field r102 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 NoSuchFieldException -> L11
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 NoSuchFieldException -> L11
        Object r103 = r102.get(r101);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 NoSuchFieldException -> L11
        Object r104 = r103.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r103, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 NoSuchFieldException -> L11
        if (r104 == null) goto L7;
        return new Rect((Rect) r104);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 NoSuchFieldException -> L11
    L16:
        return computeWindowBoundsP$window_release(r100);
    L12:
        return computeWindowBoundsP$window_release(r100);
    L17:
        return computeWindowBoundsP$window_release(r100);
    L15:
        return computeWindowBoundsP$window_release(r100);
    }

    public final Point getRealSizeForDisplay$window_release(Display r100) {
        Intrinsics.checkNotNullParameter(r100, "display");
        Point r101 = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(r100, r101);
        return r101;
    }

    private final void getRectSizeFromDisplay(Activity r100, Rect r101) {
        r100.getWindowManager().getDefaultDisplay().getRectSize(r101);
    }
}
