package obric;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class InvokeApi {
    private static final boolean ENABLE_PRINT_TRACE = false;
    private static final int NONE = Integer.MIN_VALUE;

    public static class xAccessibilityManager {
        public xAccessibilityManager() {
        }

        public static AccessibilityManager getInstance(Context context) {
            return (AccessibilityManager) AccessibilityManager.class.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context});
        L5:
            return null;
        }
    }

    public static class xComAndroidInternalR {
        public xComAndroidInternalR() {
        }

        public static int getResId(String type, String name) {
            return Class.forName("com.android.internal.R$" + type).getField(name).getInt(null);
        L5:
            e = move-exception;
            e.printStackTrace();
            return 0;
        }
    }

    public static class xCompatibilityInfo {
        public xCompatibilityInfo() {
        }

        public static float getApplicationScale(Context context) {
            Resources r4 = context.getResources();     // Catch: Exception -> L4
            Object r5 = r4.getClass().getMethod("getCompatibilityInfo", new Class[0]).invoke(r4, new Object[0]);     // Catch: Exception -> L4
            return r5.getClass().getField("applicationScale").getFloat(r5);
        L4:
            return 1.0f;
        }
    }

    public static class xICU {
        public static String getBestDateTimePattern(String skeleton, String locale) {
            return null;
        }

        public xICU() {
        }

        public static char[] getDateFormatOrder(String pattern) {
            return (char[]) Class.forName("libcore.icu.ICU").getMethod("getDateFormatOrder", new Class[]{String.class}).invoke(null, new Object[]{pattern});
        L5:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        public static String getBestDateTimePattern(String skeleton, Locale locale) {
            return (String) Class.forName("libcore.icu.ICU").getMethod("getBestDateTimePattern", new Class[]{String.class, Locale.class}).invoke(null, new Object[]{skeleton, locale});
        L5:
            return null;
        }
    }

    public static class xPopupWindow {
        public xPopupWindow() {
        }

        public static void setClipToScreenEnabled(PopupWindow window, boolean enabled) {
            window.getClass().getMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE}).invoke(window, new Object[]{Boolean.valueOf(enabled)});     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class xRect {
        public xRect() {
        }

        public static void scale(Rect rect, float scale) {
            rect.getClass().getMethod("scale", new Class[]{Float.TYPE}).invoke(rect, new Object[]{Float.valueOf(scale)});     // Catch: Exception -> L4
            return;
        }
    }

    public static class xView {
        public xView() {
        }

        public static void getWindowDisplayFrame(View view, Rect rect) {
            view.getClass().getMethod("getWindowDisplayFrame", new Class[]{Rect.class}).invoke(view, new Object[]{rect});     // Catch: Exception -> L4
            return;
        }

        public static void setShadowProperty(View view, NinePatch patch, Paint paint, float left, float top, float right, float bottom) {
            view.getClass().getMethod("setShadowProperty", new Class[]{NinePatch.class, Paint.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE}).invoke(view, new Object[]{patch, paint, Float.valueOf(left), Float.valueOf(top), Float.valueOf(right), Float.valueOf(bottom)});     // Catch: Exception -> L4
            return;
        }

        public static void clearAccessibilityFocus(View view) {
            view.getClass().getMethod("clearAccessibilityFocus", new Class[0]).invoke(view, new Object[0]);     // Catch: Exception -> L4
            return;
        }

        public static boolean requestAccessibilityFocus(View view) {
            return ((Boolean) view.getClass().getMethod("requestAccessibilityFocus", new Class[0]).invoke(view, new Object[0])).booleanValue();
        L5:
            return false;
        }

        public static boolean isVisibleToUser(View view) {
            Method r1 = View.class.getDeclaredMethod("isVisibleToUser", new Class[0]);     // Catch: Exception -> L5
            r1.setAccessible(true);     // Catch: Exception -> L5
            return ((Boolean) r1.invoke(view, new Object[0])).booleanValue();
        L5:
            return false;
        }

        public static boolean isVisibleToUser(View view, Rect boundInView) {
            Method r1 = View.class.getDeclaredMethod("isVisibleToUser", new Class[]{Rect.class});     // Catch: Exception -> L5
            r1.setAccessible(true);     // Catch: Exception -> L5
            return ((Boolean) r1.invoke(view, new Object[]{boundInView})).booleanValue();
        L5:
            return false;
        }

        public static boolean isInScrollingContainer(View view) {
            return ((Boolean) view.getClass().getMethod("isInScrollingContainer", new Class[0]).invoke(view, new Object[0])).booleanValue();
        L5:
            return false;
        }

        public static void notifyViewAccessibilityStateChangedIfNeeded(View view, int changeType) {
            view.getClass().getMethod("notifyViewAccessibilityStateChangedIfNeeded", new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(changeType)});     // Catch: Exception -> L4
            return;
        }
    }

    public static class xWindow {
        public xWindow() {
        }

        public static void addPrivateFlags(Window window, String flagName) {
            Method r0 = Class.forName("android.view.Window").getMethod("addPrivateFlags", new Class[]{Integer.TYPE});     // Catch: Exception -> L6
            int r7 = xWindowManager.getLayoutParamsPrivateFlagValue(flagName);     // Catch: Exception -> L6
            if (r7 == Integer.MIN_VALUE) goto L9;
            r0.invoke(window, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L6
            return;
        L9:
            return;
        }
    }

    public static class xWindowManager {
        public xWindowManager() {
        }

        public static int getLayoutParamsPrivateFlagValue(String flagName) {
            return Class.forName("android.view.WindowManager$LayoutParams").getField(flagName).getInt(null);
        L4:
            return Integer.MIN_VALUE;
        }
    }

    public InvokeApi() {
    }
}
