package com.android.ttcjpaysdk.base.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayImmersedStatusBarUtils {
    public static final int DEFAULT_STATUS_BAR_ALPHA = 0;
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_OPPO_VERSION_NAME = "ro.vivo.os.version";
    public static final int STATUS_BAR_ALPHA_20 = 51;

    public CJPayImmersedStatusBarUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int calculateStatusColor(int r100, int r101) {
        float r102 = 1.0f - (r101 / 255.0f);
        return ((int) (((double) ((r100 & 255) * r102)) + 0.5d)) | (((((int) (((double) (((r100 >> 16) & 255) * r102)) + 0.5d)) << 16) | (-16777216)) | (((int) (((double) (((r100 >> 8) & 255) * r102)) + 0.5d)) << 8));
    }

    public static boolean canUseTransparentStateBar() {
        return true;
    }

    public static boolean isFlyme() {
        if (Build.class.getMethod("hasSmartBar", new Class[0]) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayImmersedStatusBarUtils#isFlyme", e);
        return false;
    }

    public static boolean isMIUI() {
        if (System.getProperty(KEY_MIUI_VERSION_CODE, null) == null) goto L5;
    L10:
        return true;
    L5:
        if (System.getProperty(KEY_MIUI_VERSION_NAME, null) != null) goto L10;
        if (System.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null) goto L10;
        return false;
    }

    private static int getNormalSystemUiFlags() {
        if (canUseTransparentStateBar() == false) goto L6;
        return 1280;
    L6:
        return 256;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void adjustMaterialTheme(Activity r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (canUseTransparentStateBar() == false) goto L7;
        enableTransparentStatusBar(r100);
        return;
    L7:
        CJPaySystemUiUtils.appendSystemUiFlags(r100, 256);
    }

    private static void enableTransparentStatusBar(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 == null) goto L8;
        r101.addFlags(Integer.MIN_VALUE);
        r101.clearFlags(67108864);
        r101.setStatusBarColor(0);
        View r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
        r102.setSystemUiVisibility(r102.getSystemUiVisibility() | getNormalSystemUiFlags());
        return;
    }

    public static int getStatusBarHeight(Context r100) {
        if (r100 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r100.getResources() == null) goto L14;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Exception -> L12
        int r102 = (int) r100.getResources().getDimension(r101);
        if (r102 >= 0) goto L11;
        return 0;
    L11:
        return r102;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayImmersedStatusBarUtils#getStatusBarHeight", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayImmersedStatusBarUtils#getStatusBarHeight", e);
        e.printStackTrace();
        goto L14
    }

    public static void adjustStatusBarLightMode(Activity r100, View r101) {
        adjustStatusBarLightMode(r100, r101, true);
    }

    private static boolean setFlymeStatusBarLightMode(Activity r100, boolean r101) {
        return setFlymeWindowStatusBarLightMode(r100.getWindow(), r101);
    }

    private static boolean setFlymeWindowStatusBarLightMode(Window r100, boolean r101) {
        if (r100 != null) goto L4;
    L13:
        return false;
    L4:
        if (isFlyme() == false) goto L13;
        WindowManager.LayoutParams r102 = r100.getAttributes();     // Catch: Throwable -> L11
        Field r103 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L11
        Field r104 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L11
        r103.setAccessible(true);     // Catch: Throwable -> L11
        r104.setAccessible(true);     // Catch: Throwable -> L11
        int r105 = r103.getInt(null);     // Catch: Throwable -> L11
        int r106 = r104.getInt(r102);     // Catch: Throwable -> L11
        if (r101 == false) goto L8;
        int r107 = r106 | r105;     // Catch: Throwable -> L11
    L9:
        r104.setInt(r102, r107);     // Catch: Throwable -> L11
        r100.setAttributes(r102);     // Catch: Throwable -> L11
        return true;
    L8:
        r107 = (~r105) & r106;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayImmersedStatusBarUtils#setFlymeWindowStatusBarLightMode", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayImmersedStatusBarUtils#setFlymeWindowStatusBarLightMode", th);
        goto L13
    }

    private static boolean setMiuiStatusBarLightMode(Activity r100, boolean r101) {
        return setMiuiWindowStatusBarLightMode(r100.getWindow(), r101);
    }

    private static boolean setMiuiWindowStatusBarLightMode(Window r100, boolean r101) {
        boolean r102 = false;
        if (r100 == null) goto L25;
    L19:
        th = th;
    L20:
        CJBasicCommonUtils.reportCatchException("CJPayImmersedStatusBarUtils#setMiuiWindowStatusBarLightMode", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayImmersedStatusBarUtils#setMiuiWindowStatusBarLightMode", th);
        return r102;
    L5:
        if (isMIUI() == false) goto L26;
        Class<?> r103 = r100.getClass();     // Catch: Throwable -> L19
        Class r104 = INVOKESTATIC_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L19
        int r105 = r104.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r104);     // Catch: Throwable -> L19
        Class<?> r106 = Integer.TYPE;     // Catch: Throwable -> L19
        Method r107 = r103.getMethod("setExtraFlags", new Class[]{r106, r106});     // Catch: Throwable -> L19
        Object[] r108 = new Object[2];     // Catch: Throwable -> L19
        if (r101 == false) goto L9;
        int r109 = r105;
    L10:
        r108[0] = Integer.valueOf(r109);     // Catch: Throwable -> L19
        r108[1] = Integer.valueOf(r105);     // Catch: Throwable -> L19
        r107.invoke(r100, r108);     // Catch: Throwable -> L19
    L17:
        th = th;
        r102 = true;
        goto L20
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L16;
        if (r101 == false) goto L15;
        CJPaySystemUiUtils.appendWindowSystemUiFlags(r100, 9216);     // Catch: Throwable -> L17
        goto L16
    L15:
        CJPaySystemUiUtils.clearWindowSystemUiFlags(r100, 8192);     // Catch: Throwable -> L17
    L16:
        return true;
    L9:
        r109 = 0;
        goto L10
    L26:
        return false;
    L25:
        return false;
    }

    public static void setStatusBarColor(Activity r100, int r101) {
        if (r100 == null) goto L5;
        setWindowStatusBarColor(r100.getWindow(), r101);
        return;
    }

    public static void setStatusBarLightMode(Activity r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r100 != null) goto L7;
        return;
    L7:
        if (INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()) != null) goto L9;
        return;
    L9:
        if (r101 == false) goto L11;
        CJPaySystemUiUtils.appendSystemUiFlags(r100, 9216);
    L12:
        setMiuiStatusBarLightMode(r100, r101);
        setFlymeStatusBarLightMode(r100, r101);
        return;
    L11:
        CJPaySystemUiUtils.clearSystemUiFlags(r100, 8192);
        goto L12
    }

    public static void setStatusBarLightModeCompatLollipop(Activity r100, boolean r101) {
        if (r100 == null) goto L13;
        int r102 = Build.VERSION.SDK_INT;
        if (r101 == false) goto L6;
        int r103 = -1;
    L8:
        if (r102 >= 23) goto L10;
        int r104 = calculateStatusColor(r103, 51);
    L11:
        setStatusBarLightMode(r100, r101);
        setStatusBarColor(r100, r104);
        return;
    L10:
        r104 = 0;
        goto L11
    L6:
        r103 = -16777216;
        goto L8
    }

    public static void setStatusBarTextColor(Activity r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r102 = r100.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L12;
        View r103 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102);
        int r104 = r103.getSystemUiVisibility();
        if (r101 == false) goto L9;
        int r105 = r104 | 8192;
    L10:
        r103.setSystemUiVisibility(r105);
        return;
    L9:
        r105 = r104 & (-8193);
        goto L10
    }

    public static void setWindowStatusBarColor(Window r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getStatusBarColor() != r101) goto L6;
        return;
    L6:
        r100.setStatusBarColor(r101);
    }

    public static void setWindowStatusBarLightMode(Window r100, boolean r101) {
        r100.clearFlags(67108864);
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPayImmersedStatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(9216);
        r100.addFlags(Integer.MIN_VALUE);
        r100.setStatusBarColor(0);
        setMiuiWindowStatusBarLightMode(r100, r101);
        setFlymeWindowStatusBarLightMode(r100, r101);
    }

    public static void setWindowStatusBarLightModeCompatLollipop(Window r100, boolean r101) {
        if (r100 == null) goto L13;
        int r102 = Build.VERSION.SDK_INT;
        if (r101 == false) goto L6;
        int r103 = -1;
    L8:
        if (r102 >= 23) goto L10;
        int r104 = calculateStatusColor(r103, 51);
    L11:
        setWindowStatusBarLightMode(r100, r101);
        setWindowStatusBarColor(r100, r104);
        return;
    L10:
        r104 = 0;
        goto L11
    L6:
        r103 = -16777216;
        goto L8
    }

    public static void adjustStatusBarLightMode(Activity r100, View r101, boolean r102) {
        if (r101 == null) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (canUseTransparentStateBar() == false) goto L8;
        r101.setPadding(0, getStatusBarHeight(r100), 0, 0);
    L9:
        setStatusBarLightModeCompatLollipop(r100, r102);
        return;
    L8:
        r101.setPadding(0, 0, 0, 0);
        goto L9
    }

    public static void adjustWindowStatusBar(Window r100, View r101, boolean r102) {
        if (r101 == null) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (canUseTransparentStateBar() == false) goto L8;
        r101.setPadding(0, getStatusBarHeight(r100.getContext()), 0, 0);
    L9:
        setWindowStatusBarLightModeCompatLollipop(r100, r102);
        return;
    L8:
        r101.setPadding(0, 0, 0, 0);
        goto L9
    }
}
