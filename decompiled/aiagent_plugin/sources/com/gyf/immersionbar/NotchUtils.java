package com.gyf.immersionbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_LENOVO = "config_screen_has_notch";
    private static final String NOTCH_MEIZU = "flyme.config.FlymeFeature";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    public NotchUtils() {
    }

    public static boolean hasNotchScreen(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        return hasNotchAtAndroidP(r4);
    L9:
        if (hasNotchAtXiaoMi(r4) == false) goto L11;
    L20:
        return true;
    L11:
        if (hasNotchAtHuaWei(r4) == true) goto L20;
        if (hasNotchAtOPPO(r4) == true) goto L20;
        if (hasNotchAtVIVO(r4) == true) goto L20;
        if (hasNotchAtLenovo(r4) == true) goto L20;
        if (hasNotchAtMeiZu() == true) goto L20;
        return false;
    }

    public static boolean hasNotchScreen(View r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        return hasNotchAtAndroidP(r4);
    L9:
        if (hasNotchAtXiaoMi((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L11;
    L16:
        return true;
    L11:
        if (hasNotchAtHuaWei((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L16;
        if (hasNotchAtOPPO((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L16;
        if (hasNotchAtVIVO((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L16;
        return false;
    }

    private static boolean hasNotchAtAndroidP(View r0) {
        if (getDisplayCutout(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasNotchAtAndroidP(Activity r2) {
        if (getDisplayCutout((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static DisplayCutout getDisplayCutout(Activity r2) {
        return getDisplayCutout(ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDecorView());
    }

    private static DisplayCutout getDisplayCutout(View r2) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        if (r2 == null) goto L11;
        WindowInsets r3 = r2.getRootWindowInsets();
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getDisplayCutout();
    L11:
        return null;
    L9:
        return null;
    }

    private static boolean hasNotchAtXiaoMi(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (OSUtils.isXiaoMi() == true) goto L14;
    L8:
        int r9 = 0;
    L9:
        if (r9 != 1) goto L12;
        return true;
    L12:
        return false;
    L14:
        Class<?> r10 = r8.getClassLoader().loadClass(SYSTEM_PROPERTIES);     // Catch: Throwable -> L13
        Object r11 = r10.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r10, new Object[]{NOTCH_XIAO_MI, 0});     // Catch: Throwable -> L13
        if (r11 == null) goto L8;
        r9 = ((Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L13
        goto L9
    }

    private static boolean hasNotchAtHuaWei(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (OSUtils.isHuaWei() == false) goto L9;
        Class<?> r6 = r5.getClassLoader().loadClass(NOTCH_HUA_WEI);     // Catch: Throwable -> L6
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6.getMethod("hasNotchInScreen", new Class[0]).invoke(r6, new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        return false;
    L9:
        return false;
    }

    private static boolean hasNotchAtVIVO(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (OSUtils.isVivo() == false) goto L9;
        Class<?> r8 = r7.getClassLoader().loadClass(NOTCH_VIVO);     // Catch: Throwable -> L6
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{32}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        return false;
    L9:
        return false;
    }

    private static boolean hasNotchAtOPPO(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (OSUtils.isOppo() == true) goto L8;
    L6:
        return false;
    L8:
        return r3.getPackageManager().hasSystemFeature(NOTCH_OPPO);
    }

    private static boolean hasNotchAtLenovo(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (OSUtils.isLenovo() == false) goto L8;
        int r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), NOTCH_LENOVO, "bool", "android", "com.obric.aiagent.plugin");
        if (r0 > 0) goto L7;
        return false;
    L7:
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getBoolean(r0);
    L8:
        return false;
    }

    private static boolean hasNotchAtMeiZu() {
        if (OSUtils.isMeizu() == true) goto L8;
    L6:
        return false;
    L8:
        return ((Boolean) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(NOTCH_MEIZU, "com.obric.aiagent.plugin").getDeclaredField("IS_FRINGE_DEVICE").get(null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public static int getNotchHeight(Activity r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (hasNotchScreen(r8) == true) goto L5;
        return 0;
    L5:
        int r0 = g.b(r8);
        DisplayCutout r3 = getDisplayCutout(r8);
        if (Build.VERSION.SDK_INT < 28) goto L16;
        if (r3 == null) goto L16;
        if (ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getConfiguration().orientation != 1) goto L12;
        return r3.getSafeInsetTop();
    L12:
        if (r3.getSafeInsetLeft() != 0) goto L43;
        return r3.getSafeInsetRight();
    L43:
        return r3.getSafeInsetLeft();
    L16:
        if (hasNotchAtXiaoMi(r8) == false) goto L19;
        r2 = getXiaoMiNotchHeight(r8);
    L19:
        if (hasNotchAtHuaWei(r8) == false) goto L22;
        r2 = getHuaWeiNotchSize(r8)[1];
    L22:
        if (hasNotchAtVIVO(r8) == false) goto L27;
        r2 = dp2px(r8, 32);
        if (r2 >= r0) goto L27;
        r2 = r0;
    L27:
        if (hasNotchAtOPPO(r8) == true) goto L29;
        r0 = r2;
    L34:
        if (hasNotchAtLenovo(r8) == false) goto L37;
        r0 = getLenovoNotchHeight(r8);
    L37:
        if (hasNotchAtMeiZu() == false) goto L40;
        return getMeizuNotchHeight(r8);
    L40:
        return r0;
    L29:
        if (80 < r0) goto L34;
        r0 = 80;
        goto L34
    }

    public static void getNotchHeight(Activity r2, k r3) {
        final Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        final k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.getWindow(r4, "com.obric.aiagent.plugin").getDecorView().post(new AnonymousClass1(r5, r4));
    }

    private static int getXiaoMiNotchHeight(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), "notch_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r0 > 0) goto L5;
        return 0;
    L5:
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimensionPixelSize(r0);
    }

    private static int[] getHuaWeiNotchSize(Context r5) {
        int[] r0 = {0, 0};
        Class<?> r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getClassLoader().loadClass(NOTCH_HUA_WEI);     // Catch: Throwable -> L5
        return (int[]) ZeusTransformUtils.preCheckCast(r6.getMethod("getNotchSize", new Class[0]).invoke(r6, new Object[0]), int[].class, "com.obric.aiagent.plugin");
    L5:
        return r0;
    }

    private static int getLenovoNotchHeight(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), "notch_h", "dimen", "android", "com.obric.aiagent.plugin");
        if (r0 > 0) goto L5;
        return 0;
    L5:
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimensionPixelSize(r0);
    }

    private static int getMeizuNotchHeight(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), "fringe_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimensionPixelSize(r0);
    }

    private static int dp2px(Context r2, int r3) {
        return (int) TypedValue.applyDimension(1, r3, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics());
    }
}
