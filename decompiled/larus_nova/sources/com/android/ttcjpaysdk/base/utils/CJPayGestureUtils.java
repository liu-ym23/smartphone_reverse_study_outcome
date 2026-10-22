package com.android.ttcjpaysdk.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayGestureUtils {
    public static final String IMMERSION_NAVIGATION_BAR_HEIGHT = "navigation_bar_height";
    public static final String IMMERSION_NAVIGATION_BAR_HEIGHT_LANDSCAPE = "navigation_bar_height_landscape";
    static final String IMMERSION_NAVIGATION_BAR_MODE_DEFAULT = "navigation_mode";
    static final String IMMERSION_NAVIGATION_BAR_MODE_EMUI = "navigationbar_is_min";
    static final String IMMERSION_NAVIGATION_BAR_MODE_MIUI = "force_fsg_nav_bar";
    static final String IMMERSION_NAVIGATION_BAR_MODE_MIUI_HIDE = "hide_gesture_line";
    static final String IMMERSION_NAVIGATION_BAR_MODE_OPPO = "hide_navigationbar_enable";
    static final String IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG = "navigation_bar_gesture_while_hidden";
    static final String IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG_GESTURE = "navigation_bar_gesture_hint";
    static final String IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG_GESTURE_TYPE = "navigation_bar_gesture_detail_type";
    static final String IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG_OLD = "navigationbar_hide_bar_enabled";
    static final String IMMERSION_NAVIGATION_BAR_MODE_VIVO = "navigation_gesture_on";
    static final String IMMERSION_NAVIGATION_BAR_WIDTH = "navigation_bar_width";
    public static final String IMMERSION_STATUS_BAR_HEIGHT = "status_bar_height";

    public static class GestureBean {
        public boolean checkNavigation;
        public boolean isGesture;
        public CJPayNavBarType type;

        public String toString() {
            return "GestureBean{isGesture=" + this.isGesture + ", checkNavigation=" + this.checkNavigation + ", type=" + this.type + '}';
        }

        public GestureBean() {
            this.isGesture = false;
            this.checkNavigation = false;
        }
    }

    public CJPayGestureUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isColorOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.opporom"));
    }

    public static boolean isFuntouchOrOriginOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.vivo.os.version"));
    }

    public static boolean isHuaWei() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains(RomUtils.BRAND_HUAWEI);
    }

    public static boolean isOppo() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains(SmEditTextLeakOpt.SAMSUNG);
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains(DimLocationCheckUtil.VIVO);
    }

    public static boolean isXiaoMi() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains(DimLocationCheckUtil.XIAOMI);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayGestureUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static GestureBean getGestureBean(Context r100) {
        GestureBean r101 = new GestureBean();
        if (r100 != null) goto L5;
    L87:
        return r101;
    L5:
        if (r100.getContentResolver() == null) goto L87;
        ContentResolver r102 = r100.getContentResolver();
        CJPayNavBarType r103 = CJPayNavBarType.UNKNOWN;
        boolean r104 = false;
        boolean r105 = true;
        if (isHuaWei() == true) goto L68;
        CJPayRomUtils r106 = CJPayRomUtils.INSTANCE;
        if (r106.isEMUI() == true) goto L68;
        if (isXiaoMi() == false) goto L14;
    L61:
        int r107 = Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_MIUI, -1);
        if (r107 != 0) goto L64;
        r103 = CJPayNavBarType.CLASSIC;
    L75:
        boolean r108 = false;
        boolean r109 = false;
    L76:
        if (r107 != (-1)) goto L85;
        int r110 = Settings.Secure.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_DEFAULT, -1);
        if (r110 != 0) goto L81;
        r103 = CJPayNavBarType.CLASSIC;
    L80:
        r105 = r108;
    L86:
        r101.isGesture = r104;
        r101.checkNavigation = r105;
        r101.type = r103;
        goto L87
    L81:
        if (r110 != 1) goto L83;
        r103 = CJPayNavBarType.DOUBLE;
        goto L80
    L83:
        if (r110 != 2) goto L85;
        r103 = CJPayNavBarType.GESTURES;
        r104 = true;
    L85:
        r105 = r108;
        r104 = r109;
        goto L86
    L64:
        if (r107 != 1) goto L75;
        r103 = CJPayNavBarType.GESTURES;
        if (Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_MIUI_HIDE, 1) != 1) goto L39;
    L73:
        r108 = false;
    L74:
        r109 = true;
    L39:
        r108 = true;
        goto L74
    L14:
        if (r106.isMIUI() == true) goto L61;
        if (isVivo() == false) goto L19;
    L54:
        r107 = Settings.Secure.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_VIVO, -1);
        if (r107 != 0) goto L57;
        r103 = CJPayNavBarType.CLASSIC;
        goto L75
    L57:
        if (r107 != 1) goto L59;
        r103 = CJPayNavBarType.GESTURES_THREE_STAGE;
        goto L73
    L59:
        if (r107 != 2) goto L75;
        r103 = CJPayNavBarType.GESTURES;
        goto L73
    L19:
        if (isFuntouchOrOriginOs() == true) goto L54;
        if (isOppo() == false) goto L24;
    L46:
        r107 = Settings.Secure.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_OPPO, -1);
        if (r107 != 0) goto L49;
        r103 = CJPayNavBarType.CLASSIC;
        goto L75
    L49:
        if (r107 == 1) goto L53;
        if (r107 == 2) goto L53;
        if (r107 != 3) goto L75;
    L53:
        r103 = CJPayNavBarType.GESTURES;
        goto L73
    L24:
        if (isColorOs() == true) goto L46;
        if (isSamsung() == false) goto L45;
        r107 = Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG, -1);
        if (r107 == (-1)) goto L40;
        if (r107 != 0) goto L32;
        r103 = CJPayNavBarType.CLASSIC;
        goto L75
    L32:
        if (r107 != 1) goto L75;
        if (Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG_GESTURE_TYPE, 1) != 1) goto L36;
        r103 = CJPayNavBarType.GESTURES;
    L38:
        if (Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG_GESTURE, 1) != 1) goto L73;
    L36:
        r103 = CJPayNavBarType.GESTURES_THREE_STAGE;
        goto L38
    L40:
        r107 = Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_SAMSUNG_OLD, -1);
        if (r107 != 0) goto L43;
        r103 = CJPayNavBarType.CLASSIC;
        goto L75
    L43:
        if (r107 != 1) goto L75;
        r103 = CJPayNavBarType.GESTURES;
        goto L73
    L45:
        r107 = -1;
    L68:
        r107 = Settings.Global.getInt(r102, IMMERSION_NAVIGATION_BAR_MODE_EMUI, -1);
        if (r107 != 0) goto L71;
        r103 = CJPayNavBarType.CLASSIC;
        goto L75
    L71:
        if (r107 != 1) goto L75;
        r103 = CJPayNavBarType.GESTURES;
        goto L73
    }

    private static String getSystemProperty(String r100) {
        Class r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayGestureUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r101, new Object[]{r100, ""});
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayGestureUtils#getSystemProperty", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayGestureUtils#getSystemProperty", e);
        e.printStackTrace();
        return "";
    }
}
