package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowMetricsCalculatorCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "()V", "TAG", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "computeMaximumWindowMetrics", "computeWindowBoundsIceCreamSandwich", "Landroid/graphics/Rect;", "computeWindowBoundsIceCreamSandwich$window_release", "computeWindowBoundsN", "computeWindowBoundsN$window_release", "computeWindowBoundsP", "computeWindowBoundsP$window_release", "computeWindowBoundsQ", "computeWindowBoundsQ$window_release", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRealSizeForDisplay", "Landroid/graphics/Point;", "getRealSizeForDisplay$window_release", "getRectSizeFromDisplay", "", "bounds", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = null;
    private static final String TAG = null;

    private WindowMetricsCalculatorCompat() {
    }

    static {
        INSTANCE = new WindowMetricsCalculatorCompat();
        Intrinsics.checkNotNullExpressionValue("WindowMetricsCalculatorCompat", "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = "WindowMetricsCalculatorCompat";
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeCurrentWindowMetrics(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        return new WindowMetrics(ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(r1));
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeMaximumWindowMetrics(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        return new WindowMetrics(ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(r1));
    }

    public final Rect computeWindowBoundsQ$window_release(Activity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Configuration r0 = r6.getResources().getConfiguration();
        Field r1 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        r1.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        Object r2 = r1.get(r0);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        Object r3 = r2.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        if (r3 == null) goto L7;
        return new Rect((Rect) r3);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
    L10:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$window_release(r6);
    L14:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$window_release(r6);
    L12:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$window_release(r6);
    L8:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$window_release(r6);
    }

    public final Rect computeWindowBoundsP$window_release(Activity r8) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Rect r0 = new Rect();
        Configuration r1 = r8.getResources().getConfiguration();
        Field r3 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        r3.setAccessible(true);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        Object r2 = r3.get(r1);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r8) == false) goto L11;
        Object r4 = r2.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (r4 == null) goto L10;
        r0.set((Rect) r4);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L24:
        Display r5 = r8.getWindowManager().getDefaultDisplay();
        Point r6 = new Point();
        DisplayCompatHelperApi17 r7 = DisplayCompatHelperApi17.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r5, "currentDisplay");
        r7.getRealSize(r5, r6);
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r8) == true) goto L36;
        int r9 = getNavigationBarHeight(r8);
        if ((r0.bottom + r9) != r6.y) goto L30;
        r0.bottom += r9;
        goto L36
    L30:
        if ((r0.right + r9) != r6.x) goto L33;
        r0.right += r9;
        goto L36
    L33:
        if (r0.left != r9) goto L36;
        r0.left = 0;
    L36:
        if (r0.width() < r6.x) goto L40;
        if (r0.height() < r6.y) goto L40;
    L55:
        return r0;
    L40:
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r8) == true) goto L55;
        DisplayCutout r10 = getCutoutForDisplay(r5);
        if (r10 == null) goto L55;
        if (r0.left != DisplayCompatHelperApi28.INSTANCE.safeInsetLeft(r10)) goto L47;
        r0.left = 0;
    L47:
        if ((r6.x - r0.right) != DisplayCompatHelperApi28.INSTANCE.safeInsetRight(r10)) goto L50;
        r0.right += DisplayCompatHelperApi28.INSTANCE.safeInsetRight(r10);
    L50:
        if (r0.top != DisplayCompatHelperApi28.INSTANCE.safeInsetTop(r10)) goto L53;
        r0.top = 0;
    L53:
        if ((r6.y - r0.bottom) != DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(r10)) goto L55;
        r0.bottom += DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(r10);
        goto L55
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L11:
        Object r11 = r2.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (r11 == null) goto L15;
        r0.set((Rect) r11);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        goto L24
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L18:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r8, r0);
    L22:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r8, r0);
    L20:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r8, r0);
    L16:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r8, r0);
        goto L24
    }

    private final void getRectSizeFromDisplay(Activity r1, Rect r2) {
        r1.getWindowManager().getDefaultDisplay().getRectSize(r2);
    }

    public final Rect computeWindowBoundsN$window_release(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Rect r0 = new Rect();
        Display r1 = r4.getWindowManager().getDefaultDisplay();
        r1.getRectSize(r0);
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r4) == true) goto L10;
        Intrinsics.checkNotNullExpressionValue(r1, "defaultDisplay");
        Point r2 = getRealSizeForDisplay$window_release(r1);
        int r3 = getNavigationBarHeight(r4);
        if ((r0.bottom + r3) != r2.y) goto L8;
        r0.bottom += r3;
        goto L10
    L8:
        if ((r0.right + r3) != r2.x) goto L10;
        r0.right += r3;
    L10:
        return r0;
    }

    public final Rect computeWindowBoundsIceCreamSandwich$window_release(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Display r4 = r3.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(r4, "defaultDisplay");
        Point r2 = getRealSizeForDisplay$window_release(r4);
        Rect r0 = new Rect();
        if (r2.x != 0) goto L5;
    L8:
        r4.getRectSize(r0);
    L9:
        return r0;
    L5:
        if (r2.y == 0) goto L8;
        r0.right = r2.x;
        r0.bottom = r2.y;
        goto L9
    }

    public final Point getRealSizeForDisplay$window_release(Display r2) {
        Intrinsics.checkNotNullParameter(r2, "display");
        Point r1 = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(r2, r1);
        return r1;
    }

    private final int getNavigationBarHeight(Context r3) {
        Resources r2 = r3.getResources();
        int r4 = r2.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r4 > 0) goto L7;
        return 0;
    L7:
        return r2.getDimensionPixelSize(r4);
    }

    private final DisplayCutout getCutoutForDisplay(Display r7) {
        Constructor<?> r6 = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        r6.setAccessible(true);     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        Object r8 = r6.newInstance(new Object[0]);     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        Method r2 = r7.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r8.getClass()});     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        r2.setAccessible(true);     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        r2.invoke(r7, new Object[]{r8});     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        Field r9 = r8.getClass().getDeclaredField("displayCutout");     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        r9.setAccessible(true);     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        Object r10 = r9.get(r8);     // Catch: InstantiationException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12 NoSuchMethodException -> L14 ClassNotFoundException -> L16
        if ((r10 instanceof DisplayCutout) == false) goto L18;
    L22:
        return (DisplayCutout) r10;
    L18:
        return null;
    L16:
        e = move-exception;
        Log.w(TAG, e);
    L10:
        e = move-exception;
        Log.w(TAG, e);
    L6:
        e = move-exception;
        Log.w(TAG, e);
    L12:
        e = move-exception;
        Log.w(TAG, e);
    L14:
        e = move-exception;
        Log.w(TAG, e);
    L8:
        e = move-exception;
        Log.w(TAG, e);
        goto L18
    }
}
