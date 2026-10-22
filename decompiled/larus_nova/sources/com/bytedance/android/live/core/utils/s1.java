package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f66388a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f66389b = -1;

    public static final int A() {
        int r100 = f66389b;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 <= 0) goto L8;
        int r102 = getContext().getResources().getDimensionPixelSize(r101);
    L9:
        f66389b = r102;
        return r102;
    L8:
        r102 = 0;
        goto L9
    }

    public static int o() {
        int r100 = f66388a;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        Resources r101 = getResources();
        if (r101 == null) goto L13;
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 == 0) goto L11;
        int r103 = r101.getDimensionPixelSize(r102);
        f66388a = r103;
        return r103;
    L11:
        f66388a = 0;
        return 0;
    L13:
        f66388a = 0;
        return 0;
    }

    public static String[] D() {
        return getContext().getResources().getStringArray(R.array.trial_hint);
    }

    public static float E() {
        Configuration r100 = getContext().getResources().getConfiguration();
        Resources r101 = getContext().getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        float r103 = r100.fontScale;
        float r104 = r102.density;
        if (r103 > 1.0f) goto L6;
        return r104;
    L6:
        if (r103 >= 1.3f) goto L10;
        return r104 * 1.15f;
    L10:
        return r104 * 1.3f;
    }

    public static boolean F() {
        if (getResources() != null) goto L6;
        return true;
    L6:
        if (getResources().getConfiguration().orientation == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static Context getContext() {
        rm0.a r100 = om0.c.e();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContext();
    }

    public static Resources getResources() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getResources();
    }

    public static DisplayMetrics l() {
        if (getContext() != null) goto L6;
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    L6:
        Resources r101 = getContext().getApplicationContext().getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
    }

    public static float n() {
        Context r100 = getContext();
        if (r100 == null) goto L8;
        float r101 = r100.getResources().getConfiguration().fontScale;
        if (r101 <= 1.3d) goto L10;
        return 1.3f;
    L10:
        return r101;
    L8:
        return 1.0f;
    }

    public static int r() {
        if (F() == false) goto L7;
        return Math.max(l().heightPixels, l().widthPixels);
    L7:
        return Math.min(l().heightPixels, l().widthPixels);
    }

    public static int t() {
        if (F() == false) goto L7;
        return Math.min(l().heightPixels, l().widthPixels);
    L7:
        return Math.max(l().heightPixels, l().widthPixels);
    }

    public static float u() {
        return l().density;
    }

    public static int v() {
        return l().densityDpi;
    }

    public static int w() {
        return l().heightPixels;
    }

    public static int x() {
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels;
    }

    public static int y() {
        return l().widthPixels;
    }

    public static int z() {
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
    }

    public static String B(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getString(r100);
    }

    public static float G(int r100) {
        return r100 / l().density;
    }

    public static float I(float r100) {
        return TypedValue.applyDimension(2, r100, l());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static float b(float r100) {
        return E() * r100;
    }

    public static String c(Context r100) {
        Method r101 = a("com.bytedance.mira.core.opt.res.temp.PrintUtils").getDeclaredMethod("buildDebugInfo", new Class[]{Context.class});     // Catch: Throwable -> L4
        r101.setAccessible(true);     // Catch: Throwable -> L4
        return (String) r101.invoke(null, new Object[]{r100});
    L4:
        th = move-exception;
        return th.toString();
    }

    public static boolean d(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean r103 = false;
        if (r102 <= 0) goto L5;
        boolean r104 = r101.getBoolean(r102);
    L16:
        Class r105 = a("android.os.SystemProperties");     // Catch: Exception -> L15
        String r106 = (String) r105.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r105, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L15
        if ("1".equals(r106) == true) goto L14;
        if ("0".equals(r106) == false) goto L12;
        r103 = true;
        goto L14
    L12:
        r103 = r104;
    L14:
        return r103;
    L18:
        return r104;
    L5:
        r104 = false;
        goto L16
    }

    public static float e(float r100) {
        return TypedValue.applyDimension(1, r100, l());
    }

    public static int f(float r100) {
        return (int) ((r100 * l().density) + 0.5f);
    }

    public static Bitmap g(int r100) {
        Drawable r101 = m(r100);
        if ((r101 instanceof BitmapDrawable) == true) goto L5;
        Bitmap r102 = Bitmap.createBitmap(r101.getIntrinsicWidth(), r101.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        r101.setBounds(0, 0, r103.getWidth(), r103.getHeight());
        r101.draw(r103);
        return r102;
    L5:
        return ((BitmapDrawable) r101).getBitmap();
    }

    public static int h(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L14;
    L12:
        return 0;
    L14:
    L9:
        th = move-exception;
        throw new RuntimeException(c(r101), th);
    L5:
        if (r101.getResources() == null) goto L12;
        return r101.getResources().getColor(r100);
    }

    public static int j(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L14;
    L12:
        return 0;
    L14:
    L9:
        th = move-exception;
        throw new RuntimeException(c(r101), th);
    L5:
        if (r101.getResources() == null) goto L12;
        return (int) r101.getResources().getDimension(r100);
    }

    public static int k(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r101.getResources() == null) goto L8;
        return r101.getResources().getDimensionPixelSize(r100);
    }

    public static Drawable m(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
    L8:
        return null;
    L5:
        if (r101.getResources() == null) goto L8;
        return r101.getResources().getDrawable(r100);
    }

    public static DisplayMetrics q(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        if ((r100 instanceof Activity) == false) goto L5;
        WindowManager r102 = ((Activity) r100).getWindowManager();
    L6:
        if (r102 != null) goto L8;
        return r101;
    L8:
        r102.getDefaultDisplay().getRealMetrics(r101);
        r101.toString();
        return r101;
    L5:
        r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        goto L6
    }

    public static int s(Activity r100) {
        return q(r100).heightPixels;
    }

    public static String C(int r100, Object... r101) {
        Context r102 = getContext();
        if (r102 != null) goto L6;
        return null;
    L6:
        return r102.getString(r100, r101);
    }

    public static void H(View r100, Drawable r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setBackground(r101);
    }

    public static int i(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return r101;
    L11:
    L10:
        return r101;
    L6:
        if (r100.startsWith("#") == true) goto L8;
        r100 = "#".concat(r100);     // Catch: IllegalArgumentException -> L10
    L8:
        return Color.parseColor(r100);
    }

    public static String p(int r100, int r101) {
        Context r102 = getContext();
        if (r102 != null) goto L6;
        return null;
    L6:
        return r102.getResources().getQuantityString(r100, r101);
    }
}
