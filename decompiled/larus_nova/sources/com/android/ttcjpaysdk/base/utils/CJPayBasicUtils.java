package com.android.ttcjpaysdk.base.utils;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.Toast;
import com.android.ttcjpaysdk.base.CJBioInfo;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.adapter.TTCJPayToastAdapter;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.android.ttcjpaysdk.base.service.ICJPayFaceCheckService;
import com.android.ttcjpaysdk.base.service.ICJPayFingerprintService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.android.ttcjpaysdk.ttcjpayapi.CJPayCarrierAuthManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.utils.g;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import cta.b;
import f06.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayBasicUtils {
    public static final int CJ_NETWORK_CUSTOMIZED_TYPE_MOBILE = 1;
    public static final int CJ_NETWORK_CUSTOMIZED_TYPE_NONE = 0;
    public static final int CJ_NETWORK_CUSTOMIZED_TYPE_UNKNOWN = -1;
    public static final int CJ_NETWORK_CUSTOMIZED_TYPE_WIFI = 2;
    public static final int CJ_NETWORK_CUSTOMIZED_TYPE_WIFI_AND_MOBILE = 3;
    private static final int MIN_CLICK_DELAY_TIME = 500;
    public static final String NETWORK_2G = "2g";
    public static final String NETWORK_3G = "3g";
    public static final String NETWORK_4G = "4g";
    public static final String NETWORK_MOBILE = "5g";
    public static final String NETWORK_NONE = "mobile";
    public static final String NETWORK_WIFI = "wifi";
    private static final String TAG = "CJPayBasicUtils";
    public static final int TOAST_LONG_DURATION = 3000;
    public static final byte[] TT_CJ_PAY_TFCC_DEBUG_KEY = null;
    public static final byte[] TT_CJ_PAY_TFCC_ONLINE_KEY = null;
    private static volatile int isJailBroken;
    private static long lastClickTime;
    private static volatile String mAppName;
    private static volatile int mAppVersionCode;
    private static volatile String mAppVersionName;

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.utils.CJPayBasicUtils$6, reason: invalid class name */
    /* JADX INFO: loaded from: classes28.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ttcjpaysdk$base$utils$CJPayBasicUtils$HalfType = null;

        static {
            int[] r100 = new int[HalfType.values().length];
            $SwitchMap$com$android$ttcjpaysdk$base$utils$CJPayBasicUtils$HalfType = r100;
            r100[HalfType.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$ttcjpaysdk$base$utils$CJPayBasicUtils$HalfType[HalfType.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$ttcjpaysdk$base$utils$CJPayBasicUtils$HalfType[HalfType.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static final enum HalfType extends Enum<HalfType> {
        private static final /* synthetic */ HalfType[] $VALUES = null;
        public static final HalfType ALL = null;
        public static final HalfType BOTTOM = null;
        public static final HalfType TOP = null;

        private static /* synthetic */ HalfType[] $values() {
            return new HalfType[]{TOP, BOTTOM, ALL};
        }

        static {
            TOP = new HalfType("TOP", 0);
            BOTTOM = new HalfType("BOTTOM", 1);
            ALL = new HalfType(AccountType.ALL, 2);
            $VALUES = $values();
        }

        public static HalfType[] values() {
            return (HalfType[]) $VALUES.clone();
        }

        public static HalfType valueOf(String r100) {
            return (HalfType) a.a(HalfType.class, r100);
        }

        private HalfType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CJPayBasicUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static String getNavBarOverride() {
        Method r100 = INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Throwable -> L6
        r100.setAccessible(true);     // Catch: Throwable -> L6
        return (String) r100.invoke(null, new Object[]{"qemu.hw.mainkeys"});
    L9:
        return null;
    }

    private static boolean isApiBiggerThan16() {
        return true;
    }

    static {
        TT_CJ_PAY_TFCC_DEBUG_KEY = new byte[]{48, 52, 97, 99, 97, 102, 54, 54, 51, 48, 99, 51, 98, 54, 51, 57, 99, 55, 49, 98, 55, 52, 55, 97, 99, 99, 53, 101, 50, 100, 97, 100, 54, 101, 98, 55, 50, 102, 57, 98, 101, 101, 52, 52, 52, 53, 55, 50, 53, 57, 100, 54, 48, 101, 54, 52, 98, 55, 100, 57, 50, 55, 51, 50, 49, 57, 57, 48, 97, 56, 100, 49, 57, 57, 102, 102, 54, 52, 55, 97, 102, 99, 57, 57, 56, 49, 101, 97, 102, 49, 98, 98, 50, 52, 51, 50, 98, 98, 97, 97, 57, 55, 52, 50, 51, 49, 53, 51, 99, 52, 48, 49, 100, 50, 98, 53, 56, 57, 99, 55, 101, 54, 100, 54, 53, 98, 97, 50, 48, 99};
        TT_CJ_PAY_TFCC_ONLINE_KEY = new byte[]{48, 52, 100, 97, 102, 49, 53, 57, 51, 98, 53, 49, 48, 49, 53, 55, 52, 101, 100, 50, 48, 49, 51, 98, 52, 49, 97, 48, 100, 51, 97, 52, 52, 98, 52, 48, 54, 54, 50, 97, 100, 50, 48, 98, 97, 102, 101, 57, 98, 98, 101, 51, 97, 99, 98, 97, 97, 99, 50, 48, 101, 48, 56, 49, 99, 99, 48, 102, 101, 100, 99, 54, 57, 97, 98, 102, 97, 57, 54, 50, 52, 48, 52, 48, 52, 49, 51, 50, 52, 53, 50, 49, 100, 57, 48, 51, 52, 51, 49, 57, 99, 100, 49, 48, 55, 55, 99, 50, 97, 56, 102, 98, 99, 102, 53, 102, 51, 57, 54, 51, 52, 51, 99, 100, 98, 99, 100, 100, 102, 57};
        mAppVersionCode = -9999;
        isJailBroken = -1;
    }

    private static synchronized boolean checkAccessRootData() {
        monitor-enter(CJPayBasicUtils.class);
        writeFile("/data/su_test", "test_ok");     // Catch: Throwable -> L7 Exception -> L10
        boolean r100 = "test_ok".equals(readFile("/data/su_test"));     // Catch: Throwable -> L7 Exception -> L10
        monitor-exit(CJPayBasicUtils.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    L11:
        return false;
    }

    private static boolean checkRootPathSU() {
        String[] r100 = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int r101 = 0;
    L4:
        if (r101 >= 5) goto L10;
        if (new PolarisFileWrapper(r100[r101] + "su").exists() == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private static boolean checkSuperuserApk() {
        if (new PolarisFileWrapper("/system/app/Superuser.apk").exists() == false) goto L6;
        return true;
    L6:
        return false;
    L11:
        return false;
    }

    public static String getBioTypeInfo() {
        return String.valueOf(isSupportFingerPrint(CJPayHostInfo.applicationContext) ? 1 : 0);
    }

    public static byte[] getTfccKey() {
        if (CJPayHostInfo.serverType == 2) goto L7;
        return TT_CJ_PAY_TFCC_ONLINE_KEY;
    L7:
        return TT_CJ_PAY_TFCC_DEBUG_KEY;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    public static boolean isJailBroken() {
        ?? r100 = 0;
        if (isJailBroken == (-1)) goto L9;
        if (isJailBroken != 1) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (checkAccessRootData() == false) goto L11;
    L14:
        r100 = 1;
    L15:
        isJailBroken = r100;
        return r100;
    L11:
        if (checkSuperuserApk() == true) goto L14;
        if (checkRootPathSU() == false) goto L15;
        goto L14
    }

    public static JSONObject getBioInfo() {
        if (CJPaySettingsManager.getInstance().isDegradeBioInfoUpload() == true) goto L5;
        return new CJBioInfo().getBioInfo().toJson();
    L8:
        e = move-exception;
        CJLogger.c(TAG, "getBioInfo", e);
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public static ArrayList<Integer> getBiometricIds() {
        Object r100 = CJEnv.a().getSystemService(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT);     // Catch: Exception -> L15
        Method r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.hardware.fingerprint.FingerprintManager").getDeclaredMethod("getEnrolledFingerprints", new Class[0]);     // Catch: Exception -> L15
        r101.setAccessible(true);     // Catch: Exception -> L15
        List r102 = (List) r101.invoke(r100, new Object[0]);     // Catch: Exception -> L15
        ArrayList<Integer> r103 = new ArrayList();     // Catch: Exception -> L15
        if (r102 != null) goto L5;
    L14:
        return r103;
    L5:
        if (r102.isEmpty() == true) goto L14;
        Iterator r104 = r102.iterator();     // Catch: Exception -> L15
    L8:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();     // Catch: Exception -> L15
        if (r105 == null) goto L8;
        Class r106 = INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.hardware.fingerprint.Fingerprint").getSuperclass();     // Catch: Exception -> L15
        Method r107 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Exception -> L15
        r107.setAccessible(true);     // Catch: Exception -> L15
        Field r108 = (Field) r107.invoke(r106, new Object[]{"mBiometricId"});     // Catch: Exception -> L15
        r108.setAccessible(true);     // Catch: Exception -> L15
        r103.add((Integer) r108.get(r105));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static JSONObject getCJPassThroughInfo() {
        if ("1".equals(CJPayABExperimentKeys.getFrontPayRiskInfoOpt().value(true)) == false) goto L7;
        return CJPassThroughInfoCache.get();
    L7:
        return CJPassThroughInfoCache.getWithoutCache();
    }

    public static String getCameraPermission() {
        Application r100 = CJEnv.a();
        ICJPayFaceCheckService r101 = (ICJPayFaceCheckService) CJPayServiceManager.getInstance().getIService(ICJPayFaceCheckService.class);
        if (r101 != null) goto L5;
        return "";
    L5:
        if (((Boolean) r101.cameraPermissionAvailable(r100).first).booleanValue() == false) goto L7;
        return "1";
    L7:
        return "0";
    }

    public static String getJailBreakInfo() {
        if (isJailBroken() == false) goto L5;
        return "1";
    L5:
        return "2";
    }

    public static JSONObject getNetProxyInfo() {
        if (CJPaySettingsManager.getInstance().isDegradeWifiProxyInfoUpload() == true) goto L5;
        JSONObject r100 = new JSONObject();
    L18:
        e = move-exception;
        CJLogger.c(TAG, "getWifiProxyInfo error", e);
    L20:
        return r100;
    L8:
        String r101 = "1";
        if (isVpnOn() == false) goto L11;
        Object r102 = "1";
    L12:
        r100.put("vpn_status", r102);     // Catch: Exception -> L18
        if (isWifiProxy() == true) goto L16;
        r101 = "0";
    L16:
        r100.put("proxy_status", r101);     // Catch: Exception -> L18
        goto L20
    L11:
        r102 = "0";
        goto L12
    L5:
        return new JSONObject();
    }

    public static JSONObject getPhoneAuthInfo() {
        if (CJPaySettingsManager.getInstance().isCarrierAuthPassThroughDisabled() == true) goto L5;
        JSONObject r100 = new JSONObject();
        CJPayCarrierAuthManager r101 = CJPayCarrierAuthManager.INSTANCE;     // Catch: Exception -> L13
        JSONObject r102 = r101.getPhoneInfo();     // Catch: Exception -> L13
        if (r102 != null) goto L10;
    L15:
        return r100;
    L10:
        if (TextUtils.isEmpty(r102.optString("masked_phone")) == true) goto L15;
        r100.put("phone_carrier", r101.mapCarrier(r102.optString("phone_carrier")));     // Catch: Exception -> L13
        r100.put("masked_phone", r102.optString("masked_phone"));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        CJLogger.c(TAG, "getPhoneAuthInfo error", e);
        goto L15
    L5:
        return new JSONObject();
    }

    public static long getPluginVerCodeHost() {
        CJEnv.f().getEnvController();
        return -1;
    }

    public static String getRealVersion() {
        return CJEnv.m();
    }

    public static int getSDKVersionCode() {
        return (int) CJEnv.l();
    }

    public static String getSettingsVersion() {
        String r100 = CJEnv.k().split("-")[0];
        StringBuffer r101 = new StringBuffer();
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L13
        int r103 = Math.min(r102.length, 4);     // Catch: Exception -> L13
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L6;
        r101.append(formatSettingsSubCode(r102[r104]));     // Catch: Exception -> L13
        r101.append(".");     // Catch: Exception -> L13
        r104 = r104 + 1;     // Catch: Exception -> L13
        goto L4
    L6:
        int r105 = 0;
    L7:
        if (r105 >= (4 - r102.length)) goto L12;
        r101.append("0.");     // Catch: Exception -> L13
        r105 = r105 + 1;
    L12:
        return r101.substring(0, r101.length() - 1).toString();
    }

    public static String getVersionName() {
        return CJEnv.k();
    }

    public static String getVoicePermission() {
        if (b.b(CJEnv.a(), "android.permission.RECORD_AUDIO") == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    public static boolean isBasicMode() {
        return CJEnv.f().isBasicMode();
    }

    public static boolean isClickValid() {
        long r100 = System.currentTimeMillis();
        if (r100 <= 0) goto L11;
        long r101 = lastClickTime;
        if (r101 < 0) goto L11;
        if ((r100 - r101) < 0) goto L11;
        if ((r100 - r101) >= 500) goto L11;
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        lastClickTime = r100;
    L14:
        return r102;
    L11:
        r102 = true;
        goto L12
    }

    public static boolean isInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVpnOn() {
        Application r100 = CJEnv.a();
        if (r100 != null) goto L26;
        return false;
    L26:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L23
        if (r101 != null) goto L8;
        return false;
    L8:
        Network[] r102 = r101.getAllNetworks();     // Catch: Exception -> L23
        if (r102 != null) goto L11;
    L22:
        return false;
    L11:
        if (r102.length == 0) goto L22;
        int r103 = r102.length;     // Catch: Exception -> L23
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L22;
        NetworkCapabilities r105 = r101.getNetworkCapabilities(r102[r104]);     // Catch: Exception -> L23
        if (r105 == null) goto L21;
        if (r105.hasTransport(4) == false) goto L21;
        return true;
    L21:
        r104 = r104 + 1;
    L23:
        e = move-exception;
        CJLogger.c(TAG, "checkIsVpnOn error", e);
        return false;
    }

    public static boolean isWifiProxy() {
        Application r100 = CJEnv.a();
        if (r100 != null) goto L14;
        return false;
    L14:
        ve4.a.f554342a.getClass();     // Catch: Exception -> L11
        CJHostService r101 = (CJHostService) ve4.a.a(CJHostService.class);     // Catch: Exception -> L11
        if (r101 == null) goto L16;
        if (r101.isWifiProxy(r100) == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        CJLogger.c(TAG, "isWifiProxy error", e);
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static Map<String, String> Json2Map(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L12;
        Iterator<String> r102 = r100.keys();
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Exception -> L11
        Object r104 = r100.opt(r103);     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r101.put(r103, r104.toString());     // Catch: Exception -> L11
    L12:
        return r101;
    }

    public static Map<String, Object> Json2ObjMap(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L12;
        Iterator<String> r102 = r100.keys();
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Exception -> L11
        Object r104 = r100.opt(r103);     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r101.put(r103, r104);     // Catch: Exception -> L11
    L12:
        return r101;
    }

    public static void deleteAllFiles(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L10;
        File[] r101 = r100.listFiles();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        deleteAllFiles(r101[r103]);
        r103 = r103 + 1;
    L10:
        r100.delete();
    }

    public static void deleteDir(String r100) {
        if (r100 == null) goto L5;
        deleteAllFiles(new PolarisFileWrapper(r100));
        return;
    }

    public static void detachFromParent(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getParent() == null) goto L15;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L12;
        return;
    L12:
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L11
        return;
    L16:
        return;
    }

    private static String formatSettingsSubCode(String r100) {
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L5
    L6:
        if (r101 != (-1)) goto L8;
    L9:
        return "0";
    L8:
        if (r101 > 9) goto L9;
        return r100;
    L5:
        r101 = -1;
        goto L6
    }

    public static int getAbsolutePhysicalWidthOfScreen(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return getScreenMetrics(r100).x;
    }

    public static int getAccurateNavigationBarHeight(Activity r100) {
        if (r100 != null) goto L27;
        CJLogger.e(TAG, "activity IS null");
        return 0;
    L27:
    L24:
        e = move-exception;
        CJLogger.c(TAG, "getNavigationBarHeightViaSys", e);
    L26:
        return 0;
    L7:
        if (hasNavBarBackup(r100) == true) goto L10;
        CJLogger.e(TAG, "hasNavBarBackup = false");     // Catch: Exception -> L24
        return 0;
    L10:
        int r101 = Resources.getSystem().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");     // Catch: Exception -> L24
        if (r101 <= 0) goto L26;
        int r102 = r100.getResources().getDimensionPixelSize(r101);     // Catch: Exception -> L24
        int r103 = Resources.getSystem().getDimensionPixelSize(r101);     // Catch: Exception -> L24
        if (r103 < r102) goto L18;
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        return r103;
    L18:
        float r104 = (r102 * INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) / INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        if (r104 < 0.0f) goto L23;
        float r105 = r104 + 0.5f;
    L22:
        return (int) r105;
    L23:
        r105 = r104 - 0.5f;
        goto L22
    }

    public static synchronized String getAppName(Context r100) {
        monitor-enter(CJPayBasicUtils.class);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(mAppName) == true) goto L9;
        String r101 = mAppName;     // Catch: Throwable -> L28
        monitor-exit(CJPayBasicUtils.class);
        return r101;
    L9:
        String r102 = "未知应用";
        if (r100 != null) goto L32;
        monitor-exit(CJPayBasicUtils.class);
        return "未知应用";
    L32:
        PackageManager r103 = r100.getApplicationContext().getPackageManager();     // Catch: Exception -> L31 Throwable -> L28
        if (r103 == null) goto L25;
        if (TextUtils.isEmpty(r100.getPackageName()) == true) goto L25;
        ApplicationInfo r104 = r103.getApplicationInfo(r100.getPackageName(), 128);     // Catch: Exception -> L31 Throwable -> L28
        if (r104 == null) goto L25;
        CharSequence r105 = r103.getApplicationLabel(r104);     // Catch: Exception -> L31 Throwable -> L28
        if (r105 == null) goto L25;
        if (TextUtils.isEmpty(r105.toString()) == true) goto L25;
        r102 = r105.toString();     // Catch: Exception -> L31 Throwable -> L28
    L25:
        mAppName = r102;     // Catch: Throwable -> L28
        monitor-exit(CJPayBasicUtils.class);
        return r102;
    }

    public static int getAppVersionCode(Context r100) {
        if (mAppVersionCode != (-9999)) goto L5;
        int r101 = -1;
        if (r100 != null) goto L18;
        return -1;
    L18:
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L17
        if (r102 == null) goto L15;
        PackageInfo r103 = r102.getPackageInfo(r100.getPackageName(), 0);     // Catch: Exception -> L17
        if (r103 == null) goto L15;
        r101 = r103.versionCode;     // Catch: Exception -> L17
    L15:
        mAppVersionCode = r101;
        return r101;
    L5:
        return mAppVersionCode;
    }

    public static String getAppVersionName(Context r100) {
        if (TextUtils.isEmpty(mAppVersionName) == false) goto L5;
        String r101 = "未知版本";
        if (r100 != null) goto L19;
        return "未知版本";
    L19:
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L18
        if (r102 == null) goto L16;
        PackageInfo r103 = r102.getPackageInfo(r100.getPackageName(), 0);     // Catch: Exception -> L18
        if (r103 == null) goto L16;
        String r104 = r103.versionName;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r101 = r104;
    L16:
        mAppVersionName = r101;
        return r101;
    L5:
        return mAppVersionName;
    }

    public static Map<String, String> getBasicRiskInfo(String r100) {
        Application r101 = CJEnv.a();
        String r102 = CJEnv.e();
        String r103 = CJEnv.c();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r104 = new HashMap();
        r104.put("app_name", getAppName(r101));
        r104.put("platform", "3");
        r104.put("device_id", r103);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_DID, r103);
        r104.put("device_type", Build.MODEL);
        r104.put("device_platform", "android");
        r104.put("version_code", String.valueOf(getAppVersionCode(r101)));
        r104.put("aid", r102);
        r104.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        r104.put("os_version", Build.VERSION.RELEASE);
        r104.put(TTVideoEngineInterface.PLAY_API_KEY_AC, getNetworkState(r101));
        r104.put("brand", Build.MANUFACTURER);
        String r105 = "1";
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        r104.put("merchant_id", r100);
        r104.put("resolution", getScreenHeight(r101) + "*" + getAbsolutePhysicalWidthOfScreen(r101));
        if (isJailBroken() == true) goto L9;
        r105 = "2";
    L9:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, r105);
        r104.put("sim_carrier", g.a(sf4.a.a(r101)));
        r104.put("cj_pass_through_info", getCJPassThroughInfo().toString());
        return r104;
    }

    public static String getBiometricsInfo(String r100) {
        String r101 = "1";
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");     // Catch: Exception -> L18
        if (isJailBroken() == true) goto L7;
        r101 = "2";
    L7:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, r101);     // Catch: Exception -> L18
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, getRealVersion());     // Catch: Exception -> L18
        int r103 = 1;
        if (isSupportFingerPrint(CJPayHostInfo.applicationContext) == false) goto L10;
        int r104 = 1;
    L11:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, r104);     // Catch: Exception -> L18
        if (isSupportFingerPrint(CJPayHostInfo.applicationContext) == true) goto L15;
        r103 = 0;
    L15:
        r102.put("can_rec_open_bio", String.valueOf(r103));     // Catch: Exception -> L18
        r102.put("is_hardware_support_biometrics", isSupportFingerPrint(CJPayHostInfo.applicationContext));     // Catch: Exception -> L18
        r102.put("is_local_enable_biometrics", isEnableFingerprint(CJPayHostInfo.applicationContext, r100));     // Catch: Exception -> L18
        r102.put("is_support_open_biometrics", isSupportFingerPrint(CJPayHostInfo.applicationContext));     // Catch: Exception -> L18
        goto L17
    L10:
        r104 = 0;
    L17:
        return r102.toString();
    }

    public static Map<String, String> getDeviceInfo(String r100) {
        Context r101 = CJPayHostInfo.applicationContext;
        if (r101 == null) goto L5;
        Map<String, String> r102 = getBasicRiskInfo(r100);
        r102.put("version_name", getAppVersionName(r101));
        r102.put("version_code", String.valueOf(getAppVersionCode(r101)));
        r102.put("host", CJPayParamsUtils.getHostDomainInfo());
        r102.put("app_version", getAppVersionName(r101));
        String r103 = "";
        if (TextUtils.isEmpty(CJEnv.f().getIID()) == false) goto L9;
        String r104 = "";
    L10:
        r102.put(WsConstants.KEY_INSTALL_ID, r104);
        if (TextUtils.isEmpty(CJEnv.b()) == true) goto L14;
        r103 = CJEnv.b();
    L14:
        r102.put("channel", r103);
        return r102;
    L9:
        r104 = CJEnv.f().getIID();
        goto L10
    L5:
        return new HashMap();
    }

    public static JSONObject getJsonDeviceInfo(String r100) {
        Map<String, String> r101 = getDeviceInfo(r100);     // Catch: Exception -> L8
        if (r101 == null) goto L7;
        return new JSONObject(r101);
    L7:
        return new JSONObject();
    }

    public static int getNavigationBarHeight(Activity r100) {
        int r101 = 0;
        if (r100 != null) goto L41;
        return 0;
    L41:
    L34:
        e = e;
    L35:
        CJLogger.c(TAG, "getNavigationBarHeight", e);
        return r101;
    L6:
        if (hasNavBar(r100) == true) goto L9;
        CJLogger.e(TAG, "hasNavBar = false");     // Catch: Exception -> L34
        return 0;
    L9:
        ViewGroup r102 = (ViewGroup) INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow());     // Catch: Exception -> L34
        if (r102 == null) goto L32;
        int r103 = 0;
    L39:
        if (r101 >= r102.getChildCount()) goto L48;
        r102.getChildAt(r101).getContext().getPackageName();     // Catch: Exception -> L30
        int r104 = r102.getChildAt(r101).getId();     // Catch: Exception -> L30
        if (r104 != (-1)) goto L17;
    L22:
        CJLogger.e(TAG, "id=" + r104);     // Catch: Exception -> L30
        if (r104 == (-1)) goto L28;
        CJLogger.e(TAG, "name=" + r100.getResources().getResourceEntryName(r104));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        CJLogger.c(TAG, "getNavigationBarHeightSub", e);     // Catch: Exception -> L30
    L28:
        r101 = r101 + 1;
        goto L39
    L17:
        if ("navigationBarBackground".equals(r100.getResources().getResourceEntryName(r104)) == false) goto L22;
        Resources r105 = r100.getResources();     // Catch: Exception -> L30
        int r106 = r105.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");     // Catch: Exception -> L30
        if (r106 <= 0) goto L21;
        r103 = r105.getDimensionPixelSize(r106);     // Catch: Exception -> L30
        goto L28
    L21:
        CJLogger.e(TAG, "resourceId=" + r106);     // Catch: Exception -> L30
        goto L28
    L48:
        return r103;
    L30:
        e = e;
        r101 = r103;
        goto L35
    L32:
        CJLogger.e(TAG, "vp=null");     // Catch: Exception -> L34
        return 0;
    }

    public static int getNavigationBarHeightViaInsets(Activity r100) {
        if (r100 != null) goto L19;
        CJLogger.e(TAG, "activity IS null");
        return 0;
    L19:
    L16:
        e = move-exception;
        CJLogger.c(TAG, "getNavigationBarHeightViaInsets", e);
        return 0;
    L7:
        if (CJPayBrandUtils.isMiui() == true) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L21;
        return realGetVirtualBarHeight(r100);
    L21:
        return 0;
    L9:
        if (isMIUIVirtualBarHide(r100) == false) goto L11;
        r101 = true;
        goto L12
    }

    public static int getNetworkCapabilitiesType(Context r110) {
        if (r110 != null) goto L44;
        return 0;
    L44:
        ConnectivityManager r111 = (ConnectivityManager) r110.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L41
        if (r111 != null) goto L8;
        return 0;
    L8:
        Network[] r100 = r111.getAllNetworks();     // Catch: Throwable -> L41
        if (r100 != null) goto L11;
        return 0;
    L11:
        if (r100.length == 0) goto L51;
        int r101 = r100.length;     // Catch: Throwable -> L41
        int r102 = 0;
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
    L15:
        if (r102 >= r101) goto L29;
        NetworkCapabilities r106 = r111.getNetworkCapabilities(r100[r102]);     // Catch: Throwable -> L41
        if (r106 == null) goto L28;
        if (r106.hasCapability(12) == false) goto L28;
        if (r106.hasTransport(1) == false) goto L24;
        r103 = true;
    L24:
        if (r106.hasTransport(0) == false) goto L27;
        r104 = true;
    L27:
        r105 = true;
    L28:
        r102 = r102 + 1;
        goto L15
    L29:
        if (r103 == false) goto L33;
        if (r104 == false) goto L33;
        return 3;
    L33:
        if (r103 == false) goto L36;
        return 2;
    L36:
        if (r104 == false) goto L38;
        return 1;
    L38:
        if (r105 == false) goto L52;
        return -1;
    L52:
        return 0;
    L51:
        return 0;
    L41:
        th = move-exception;
        CJLogger.b(TAG, "getNetworkCapabilitiesType exception:" + th.getMessage());
        return 0;
    }

    public static int getNetworkCustomizedType(Context r100) {
        if (r100 != null) goto L36;
        return 0;
    L36:
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L33
        if (r101 != null) goto L8;
        return 0;
    L8:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L33
        if (r102 != null) goto L11;
    L32:
        return 0;
    L11:
        if (r102.isAvailable() == false) goto L32;
        NetworkInfo r103 = r101.getNetworkInfo(1);     // Catch: Throwable -> L33
        if (CJPaySettingsManager.getInstance().notFetchMobileDataSwitch() == false) goto L17;
        int r104 = getNetworkMobileCustomizedType(r100);     // Catch: Throwable -> L33
    L20:
        if (r103 == null) goto L38;
        NetworkInfo.State r105 = r103.getState();     // Catch: Throwable -> L33
        if (r105 != null) goto L24;
        return r104;
    L24:
        if (r105 == NetworkInfo.State.CONNECTED) goto L27;
        if (r105 == NetworkInfo.State.CONNECTING) goto L27;
        return r104;
    L27:
        if (r104 != 1) goto L30;
        return 3;
    L30:
        return 2;
    L38:
        return r104;
    L17:
        if (isMobileDataSwitchOn(r100) != 0) goto L19;
        r104 = 0;
        goto L20
    L19:
        r104 = getNetworkMobileCustomizedType(r100);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CJLogger.b(TAG, "getNetworkCustomizeType exception:" + th.getMessage());
        return 0;
    }

    private static int getNetworkMobileCustomizedType(Context r100) {
        if (r100 != null) goto L20;
        return 0;
    L20:
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L17
        ICJPayBPEAService r102 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);     // Catch: Throwable -> L17
        if (r102 == null) goto L8;
        int r103 = r102.getNetworkType(r101);     // Catch: Throwable -> L17
    L10:
        if (r103 != (-1000)) goto L13;
        return 0;
    L13:
        switch(r103) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L16;
            case 16: goto L16;
            case 17: goto L16;
            case 18: goto L16;
            case 19: goto L14;
            case 20: goto L16;
            default: goto L14;
        };
    L14:
        return -1;
    L16:
        return 1;
    L8:
        r103 = r101.getNetworkType();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CJLogger.b(TAG, "getNetworkMobileCustomizedType exception:" + th.getMessage());
        return 0;
    }

    public static String getNetworkState(Context r100) {
        if (r100 != null) goto L37;
        return "mobile";
    L37:
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L36
        if (r101 != null) goto L8;
        return "mobile";
    L8:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L36
        if (r102 == null) goto L35;
        if (r102.isAvailable() == false) goto L35;
        NetworkInfo r103 = r101.getNetworkInfo(1);     // Catch: Throwable -> L36
        if (r103 == null) goto L23;
        NetworkInfo.State r104 = r103.getState();     // Catch: Throwable -> L36
        if (r104 == null) goto L23;
        if (r104 != NetworkInfo.State.CONNECTED) goto L20;
        return "wifi";
    L20:
        if (r104 != NetworkInfo.State.CONNECTING) goto L23;
        return "wifi";
    L23:
        TelephonyManager r105 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L36
        ICJPayBPEAService r106 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);     // Catch: Throwable -> L36
        if (r106 == null) goto L26;
        int r107 = r106.getNetworkType(r105);     // Catch: Throwable -> L36
    L27:
        switch(r107) {
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L33;
            case 12: goto L31;
            case 13: goto L29;
            case 14: goto L31;
            case 15: goto L31;
            default: goto L39;
        };     // Catch: Throwable -> L36
    L29:
        return NETWORK_4G;
    L31:
        return NETWORK_3G;
    L33:
        return NETWORK_2G;
    L39:
        return NETWORK_MOBILE;
    L26:
        r107 = r105.getNetworkType();     // Catch: Throwable -> L36
    L35:
        return "mobile";
    }

    public static String getSafeUrlBase64(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        return r100.replace('+', '-').replace('/', '_').replaceAll(ContainerUtils.KEY_VALUE_DELIMITER, "");
    }

    public static int getScreenHeight(Activity r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        View r101 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).findViewById(R.id.content);
        if (r101 != null) goto L8;
        int r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).heightPixels;
    L13:
        if (r102 < INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).heightPixels) goto L15;
        return r102;
    L15:
        return INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).heightPixels;
    L8:
        if (INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getSystemUiVisibility() <= 0) goto L10;
        r102 = r101.getHeight();
        goto L13
    L10:
        r102 = r101.getHeight() + getStatusBarHeight(r100);
        goto L13
    }

    public static Point getScreenMetrics(Context r100) {
        if (r100 == null) goto L9;
        if (r100.getResources() == null) goto L9;
        DisplayMetrics r101 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        return new Point(r101.widthPixels, r101.heightPixels);
    L9:
        return new Point(0, 0);
    }

    public static int getScreenMinimumSize(Context r100) {
        if (getAbsolutePhysicalWidthOfScreen(r100) > getScreenHeight(r100)) goto L6;
        return getAbsolutePhysicalWidthOfScreen(r100);
    L6:
        return getScreenHeight(r100);
    }

    public static int getStatusBarHeight(Context r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.getResources() == null) goto L14;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        float r102 = r100.getResources().getDimension(r101);
        if (r102 < 0.0f) goto L9;
        float r103 = r102 + 0.5f;
    L11:
        return (int) r103;
    L9:
        r103 = r102 - 0.5f;
        goto L11
    L14:
        return 0;
    }

    public static String getUA(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return "CJPay-" + getRealVersion() + "-Android" + Build.VERSION.RELEASE + "-" + getAppName(r100) + "-" + getScreenHeight(r100) + "_" + getAbsolutePhysicalWidthOfScreen(r100) + "_" + Build.MODEL;
    }

    public static String getValueStr(long r100) {
        return new DecimalFormat("0.00").format(r100 * 0.01d);
    L5:
        e = move-exception;
        CJReporter r101 = CJReporter.f202294a;
        CJReporter.m(null, "amount_parser_exception", 0, e);
        return "";
    }

    public static boolean hasNavBar(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r102 == 0) goto L18;
        boolean r103 = r101.getBoolean(r102);
        if (TextUtils.equals(Build.BRAND, SmEditTextLeakOpt.SAMSUNG) == true) goto L7;
    L9:
        String r104 = getNavBarOverride();
        if ("1".equals(r104) == false) goto L13;
        return false;
    L13:
        if ("0".equals(r104) == false) goto L16;
        return true;
    L16:
        return r103;
    L7:
        if (TextUtils.equals(Build.MODEL, "SM-A9100") == false) goto L9;
        return r103;
    L18:
        return !ViewConfiguration.get(r100).hasPermanentMenuKey();
    }

    private static boolean hasNavBarBackup(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        CJPayGestureUtils.GestureBean r101 = CJPayGestureUtils.getGestureBean(r100);
        if (r101.checkNavigation == false) goto L8;
    L10:
        WindowManager r102 = r100.getWindowManager();
        if (r102 == null) goto L13;
        Display r103 = r102.getDefaultDisplay();
    L14:
        if (r103 != null) goto L16;
        return false;
    L16:
        DisplayMetrics r104 = new DisplayMetrics();
        r103.getRealMetrics(r104);
        int r105 = r104.heightPixels;
        int r106 = r104.widthPixels;
        DisplayMetrics r107 = new DisplayMetrics();
        r103.getMetrics(r107);
        int r108 = r107.heightPixels;
        int r109 = r107.widthPixels;
        if ((r105 - r108) <= 0) goto L19;
    L20:
        return true;
    L19:
        if ((r106 - r109) > 0) goto L20;
        return false;
    L13:
        r103 = null;
        goto L14
    L8:
        if (r101.isGesture == false) goto L10;
        return false;
    }

    public static void initStatusBar(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        r101.addFlags(Integer.MIN_VALUE);
        r101.setStatusBarColor(ColorProtector.parseColor("#00000000"));
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).setSystemUiVisibility(9728);
    }

    public static String intIP2StringIP(int r100) {
        return (r100 & 255) + "." + ((r100 >> 8) & 255) + "." + ((r100 >> 16) & 255) + "." + ((r100 >> 24) & 255);
    }

    public static boolean isMIUIVirtualBarHide(Context r100) {
        if (r100 != null) goto L5;
    L7:
        int r101 = 1;
        int r102 = 0;
    L8:
        if (r102 != 1) goto L12;
        if (r101 != 1) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L5:
        if (isApiBiggerThan16() == false) goto L7;
        r102 = Settings.Global.getInt(r100.getContentResolver(), "force_fsg_nav_bar", 0);
        r101 = Settings.Global.getInt(r100.getContentResolver(), "force_fsg_nav_bar", 1);
        goto L8
    }

    public static int isMobileDataSwitchOn(Context r100) {
        if (r100 != null) goto L21;
        return 0;
    L21:
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L18
        if (r101 != null) goto L10;
        return 0;
    L10:
        if (Build.VERSION.SDK_INT >= 26) goto L12;
        Method r102 = r101.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);     // Catch: Throwable -> L18
        if (r102 != null) goto L16;
        return -1;
    L16:
        return ((Boolean) r102.invoke(r101, new Object[0])).booleanValue() ? 1 : 0;
    L12:
        return r101.isDataEnabled() ? 1 : 0;
    L18:
        th = move-exception;
        CJLogger.b(TAG, "isMobileDataSwitchOn exception:" + th.getMessage());
        return -1;
    }

    public static boolean isNetworkAvailable(Context r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
        NetworkInfo r101 = ((ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r101 == null) goto L14;
        if (r101.isConnected() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    public static boolean isSupportFingerPrint(Context r100) {
        return isSupportFingerPrint(r100, false);
    }

    public static Map<String, Object> json2MapObject(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L12;
        Iterator<String> r102 = r100.keys();
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Exception -> L11
        Object r104 = r100.opt(r103);     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r101.put(r103, r104);     // Catch: Exception -> L11
    L12:
        return r101;
    }

    public static void logToastEvent(String r100) {
        CJContext r101 = CJPayCallBackCenter.getInstance().getCjContext();
        HashMap r102 = new HashMap();
        r102.put(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG, r100);
        CJReporter r103 = CJReporter.f202294a;
        CJReporter.g(r101, "wallet_cashier_toast", r102, null, -1, false);
    }

    private static String readFile(String r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: Exception -> L9
        byte[] r102 = new byte[1024];     // Catch: Exception -> L9
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Exception -> L9
    L4:
        int r104 = r101.read(r102);     // Catch: Exception -> L9
        if (r104 <= 0) goto L7;
        r103.write(r102, 0, r104);     // Catch: Exception -> L9
        goto L4
    L7:
        return new String(r103.toByteArray());
    L9:
        return null;
    }

    public static int realGetVirtualBarHeight(Activity r100) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return r100.getWindowManager().getCurrentWindowMetrics().getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout()).bottom;
    L7:
        return getAccurateNavigationBarHeight(r100);
    }

    public static void switchLanguage(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = CJPayHostInfo.languageTypeStr;
        if (r101 != null) goto L7;
    L9:
        Locale r102 = Locale.SIMPLIFIED_CHINESE;
    L10:
        Configuration r103 = r100.getResources().getConfiguration();
        Resources r104 = r100.getResources();
        DisplayMetrics r105 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r104);
        r103.locale = r102;
        r104.updateConfiguration(r103, r105);
        return;
    L7:
        if ("en".equals(r101) == false) goto L9;
        r102 = Locale.ENGLISH;
        goto L10
    }

    public static int getScreenHeight(Context r100) {
        if (r100 != null) goto L8;
        return 0;
    L8:
        return getScreenMetrics(r100).y;
    L7:
        return 0;
    }

    public static boolean checkAppInstalled(Context r100, String r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if (r101.isEmpty() == true) goto L14;
        if (r100.getPackageManager().getPackageInfo(r101, 0) == null) goto L17;
        return true;
    L17:
        return false;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBasicUtils#checkAppInstalled", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBasicUtils#checkAppInstalled", e);
    L14:
        return false;
    }

    public static void copyJSONObject(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L22;
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next();     // Catch: JSONException -> L12
        Object r104 = r100.opt(r103);     // Catch: JSONException -> L12
        if (r104 == null) goto L7;
        r101.put(r103, r104);     // Catch: JSONException -> L12
        goto L7
    L23:
        return;
    L22:
        return;
    }

    public static int dipToPX(Context r100, float r101) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return (int) TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static void displayToast(Context r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        displayToastInternal(r100, r101, 0, 17, 0, 0);
        return;
    }

    private static int formatStringCodeForMax(String r100, int r101) {
        int r102 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L9
        if (r102 < 0) goto L8;
        if (r102 > r101) goto L8;
        return r102;
    L8:
        return 0;
    }

    public static String getConfigFromAssets(Context r100, String r101) {
        InputStream r102 = null;
        r102 = r100.getAssets().open(r101);     // Catch: Throwable -> L8
        byte[] r103 = new byte[r102.available()];     // Catch: Throwable -> L8
        r102.read(r103);     // Catch: Throwable -> L8
        String r104 = new String(r103, "UTF-8");     // Catch: Throwable -> L8
        r102.close();     // Catch: IOException -> L6
        return r104;
    L6:
        e = move-exception;
        e.printStackTrace();
        return r104;
    L9:
        if (r102 != null) goto L16;
    L14:
        return "";
    L16:
        r102.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static Map<String, String> getHeaderParams(Context r100, String r101) {
        return getHeaderParams(r100, r101, false);
    }

    public static boolean isEnableFingerprint(Context r100, String r101) {
        if (isBasicMode() == false) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        ICJPayFingerprintService r102 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);     // Catch: Exception -> L13
        if (r102 == null) goto L12;
        return r102.isLocalEnableFingerprint(r100, r101, true);
    L12:
        return false;
    }

    public static boolean isSupportFingerPrint(Context r100, boolean r101) {
    L12:
        e = move-exception;
        CJReporter r102 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "check_fingerprint_exception", 1, e);
    L14:
        return false;
    L4:
        if (isBasicMode() == false) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        ICJPayFingerprintService r103 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);     // Catch: Exception -> L12
        if (r103 == null) goto L14;
        return r103.isSupportFingerprint(r100, Boolean.valueOf(r101));
    }

    public static int sp2px(Context r100, float r101) {
        if (r100 != null) goto L4;
        r100 = CJPayHostInfo.applicationContext;
    L4:
        if (r100 != null) goto L8;
        return 0;
    L8:
        return (int) ((((double) r101) * INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getApplicationContext().getResources()).scaledDensity) + 0.5d);
    }

    private static Boolean writeFile(String r100, String r101) {
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Exception -> L4
        r102.write(r101.getBytes());     // Catch: Exception -> L4
        r102.close();     // Catch: Exception -> L4
        return Boolean.TRUE;
    L5:
        return Boolean.FALSE;
    }

    public static void displayToast(Context r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        displayToast(r100, r100.getString(r101));
    }

    private static Uri com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void displayToast(Context r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        displayToastInternal(r100, r101, r102, 17, 0, 0);
        return;
    }

    public static void displayToastInternal(final Context r100, final String r101, final int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getApplicationContext() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        if (isInUIThread() == true) goto L11;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass3(r102, r100, r101));
        return;
    L11:
        logToastEvent(r101);
        final TTCJPayToastAdapter r103 = CJEnv.f().hostToastAdapter();
        if (r103 == null) goto L36;
        new Handler().post(new AnonymousClass4(r103, r100, r101));
        return;
    L36:
        Toast r104 = Toast.makeText(r100.getApplicationContext(), null, 0);     // Catch: Exception -> L35
        if (r104 != null) goto L18;
        return;
    L18:
        if (r102 != 0) goto L20;
        r104.setGravity(49, 0, (getScreenHeight(r100) - dipToPX(r100, 235.0f)) - getStatusBarHeight(r100));     // Catch: Exception -> L35
    L33:
        r104.setText(r101);     // Catch: Exception -> L35
        r104.show();     // Catch: Exception -> L35
        return;
    L20:
        if (r102 != 1) goto L22;
        r104.setGravity(17, 0, 0);     // Catch: Exception -> L35
        goto L33
    L22:
        if (r102 != 2) goto L24;
        r104.setGravity(17, 0, 0);     // Catch: Exception -> L35
        goto L33
    L24:
        if (r102 == 3) goto L27;
        r104.setGravity(17, 0, 0);     // Catch: Exception -> L35
        goto L33
    L27:
        if (getAbsolutePhysicalWidthOfScreen(r100) <= getScreenHeight(r100)) goto L29;
        r104.setGravity(17, 0, 0);     // Catch: Exception -> L35
        goto L33
    L29:
        r104.setGravity(49, 0, (getScreenHeight(r100) - dipToPX(r100, 165.0f)) - getStatusBarHeight(r100));     // Catch: Exception -> L35
    }

    public static Map<String, String> getHeaderParams(Context r100, String r101, boolean r102) {
        HashMap r103 = new HashMap();
        r103.put("TTCJ-Pay-Channel", "1.2");
        r103.put("TTCJ-Pay-DeviceInfo", "app_name=" + getAppName(r100) + ";app_version=" + getAppVersionName(r100) + ";sdk_version=" + Build.VERSION.SDK + ";os=android;os_version=" + Build.VERSION.RELEASE + ";device=" + Build.MODEL);
        String r104 = CJPayHostInfo.boeEnv;
        if (r102 == false) goto L8;
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r103.put("X-TT-ENV", r104);
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r103.put(AppConstants.HTTP_H_REFERER, r101);
    L10:
        return r103;
    }

    public static Bitmap getRoundCornerImage(Bitmap r110, int r111, HalfType r112) {
        if (r111 > 0) goto L5;
        return r110;
    L5:
        if (r110 == null) goto L18;
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        Bitmap r102 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L16
        Canvas r103 = new Canvas(r102);     // Catch: Exception -> L16
        Paint r104 = new Paint();     // Catch: Exception -> L16
        Rect r105 = new Rect(0, 0, r100, r101);     // Catch: Exception -> L16
        RectF r106 = new RectF(r105);     // Catch: Exception -> L16
        r104.setAntiAlias(true);     // Catch: Exception -> L16
        float r113 = r111;
        r103.drawRoundRect(r106, r113, r113, r104);     // Catch: Exception -> L16
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L16
        r103.drawBitmap(r110, null, r105, r104);     // Catch: Exception -> L16
        int r114 = AnonymousClass6.$SwitchMap$com$android$ttcjpaysdk$base$utils$CJPayBasicUtils$HalfType[r112.ordinal()];     // Catch: Exception -> L16
        if (r114 == 1) goto L15;
        if (r114 == 2) goto L12;
        return r102;
    L12:
        int r107 = r101 - r111;     // Catch: Exception -> L16
        return Bitmap.createBitmap(r102, 0, r107, r100, r107);
    L15:
        return Bitmap.createBitmap(r102, 0, 0, r100, r101 - r111);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        return null;
    }

    public static void addBitmapToAlbum(Context r100, Bitmap r101, String r102, String r103, Bitmap.CompressFormat r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        ContentValues r105 = new ContentValues();
        r105.put("_display_name", r102);
        r105.put("mime_type", r103);
        String r106 = Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_PICTURES + "/QrCodePay";
        if (Build.VERSION.SDK_INT < 29) goto L7;
        r105.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/QrCodePay");
    L11:
        Uri r107 = com_android_ttcjpaysdk_base_utils_CJPayBasicUtils_android_content_ContentResolver_insert(r100.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r105);
        if (r107 == null) goto L20;
        OutputStream r108 = ContentResolverWrapper.openOutputStream(r100.getContentResolver(), r107);     // Catch: Exception -> L17
        if (r108 == null) goto L20;
        r101.compress(r104, 100, r108);     // Catch: Exception -> L17
        r108.close();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L20:
        if (TextUtils.isEmpty(r106) == true) goto L25;
        MediaScannerConnection.scanFile(r100, new String[]{r106}, new String[]{"image/jpeg"}, new AnonymousClass5());
        return;
    L25:
        return;
    L7:
        PolarisFileWrapper r109 = new PolarisFileWrapper(r106);
        if (r109.exists() == true) goto L10;
        r109.mkdir();
    L10:
        r106 = r106 + HTTP.URL_DEFAULT + r102;
        r105.put("_data", r106);
        goto L11
    }

    public static Bitmap updateArrowColour(Context r100, int r101, int r102, int r103, int r104) {
        Bitmap r105 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L4
        Canvas r106 = new Canvas(r105);     // Catch: Exception -> L4
        Paint r107 = new Paint(1);     // Catch: Exception -> L4
        r107.setColor(r102);     // Catch: Exception -> L4
        r106.drawRoundRect(new RectF(0.0f, 0.0f, r103, r104), 0.0f, 0.0f, r107);     // Catch: Exception -> L4
        r107.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));     // Catch: Exception -> L4
        r106.drawBitmap(BitmapFactory.decodeResource(r100.getResources(), r101), 0.0f, 0.0f, r107);     // Catch: Exception -> L4
        return r105;
    L4:
        return null;
    }

    public static void displayToastInternal(final Context r110, final String r111, final int r112, final int r113, final int r114, final int r115) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.getApplicationContext() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r111) == false) goto L9;
        return;
    L9:
        if (isInUIThread() == true) goto L11;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r110, r111, r112, r113, r114, r115));
        return;
    L11:
        logToastEvent(r111);
        final TTCJPayToastAdapter r100 = CJEnv.f().hostToastAdapter();
        if (r100 == null) goto L20;
        new Handler().post(new AnonymousClass2(r100, r110, r111, r112, r113, r114, r115));
        return;
    L20:
        Toast r116 = Toast.makeText(r110.getApplicationContext(), r111, r112);     // Catch: Exception -> L19
        if (r116 == null) goto L25;
        r116.setGravity(r113, r114, r115);     // Catch: Exception -> L19
        r116.show();     // Catch: Exception -> L19
        return;
    L25:
        return;
    }
}
