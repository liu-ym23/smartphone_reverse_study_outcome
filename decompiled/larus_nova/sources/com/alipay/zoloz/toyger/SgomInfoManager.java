package com.alipay.zoloz.toyger;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class SgomInfoManager {
    private static int isSupportFaceShield;
    private static Field sApdidTokenField;
    private static Object sClientInstance;
    private static Object sClientTokenInstance;
    private static Class sClzAPSecuritySdk;
    private static Class sClzClientToken;
    private static Class sClzConfig;
    private static Class sClzInitListener;
    private static Class sClzSgomClient;
    private static Class sClzSgomClientResult;
    private static Class sClzTokenResult;
    private static Context sContext;
    private static Method sGetTokenMethod;
    private static Method sInitTokenMethod;
    public static IReport sReportCrash;
    private static Field sResultInfoField;
    private static Field sResultResField;
    private static boolean sSimpleFlagsDetect;
    private static Method sUpdateSgomInfoMethod;
    private static Method sUpdateTokenMethod;
    private static String version;

    public interface IReport {
        void onException(Throwable r100);

        void onReport(String r100, String r101, Throwable r102, String... r103);
    }

    public interface ITokenUpdate {
        void onUpdate(Message r100);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void release() {
        sSimpleFlagsDetect = true;
        sContext = null;
        sReportCrash = null;
        version = null;
        sClzInitListener = null;
        sClzClientToken = null;
        sClzTokenResult = null;
        sClzSgomClient = null;
        sClzSgomClientResult = null;
        sClientTokenInstance = null;
        sUpdateTokenMethod = null;
        sInitTokenMethod = null;
        sGetTokenMethod = null;
        sApdidTokenField = null;
        sClientInstance = null;
        sUpdateSgomInfoMethod = null;
        sResultResField = null;
        sResultInfoField = null;
        isSupportFaceShield = 0;
    }

    public static String getDeepSecVersion() {
        if ("2".equals(version) == true) goto L15;
    L13:
        return "";
    L15:
    L9:
        th = move-exception;
        IReport r100 = sReportCrash;
        if (r100 == null) goto L13;
        r100.onReport("updateSgomInfo", "errMsg", th, new String[0]);
        goto L13
    L5:
        if (sClzConfig != null) goto L7;
        sClzConfig = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.alipaysecuritysdk.common.config.Constant");     // Catch: Throwable -> L9
    L7:
        Field r101 = sClzConfig.getField("SDK_VERSION");     // Catch: Throwable -> L9
        r101.setAccessible(true);     // Catch: Throwable -> L9
        return (String) r101.get(null);
    }

    public static String getSecChannel() {
        Method r100 = sClzAPSecuritySdk.getDeclaredMethod("init", new Class[]{Context.class, String.class});     // Catch: Throwable -> L14
        Method r101 = sClzAPSecuritySdk.getDeclaredMethod("init", new Class[]{Context.class, String.class, String.class});     // Catch: Throwable -> L14
        if (r100 != null) goto L6;
        if (r101 == null) goto L18;
        return "mpaas";
    L6:
        return "mpaas";
    L18:
        if (sClzAPSecuritySdk.getDeclaredMethod("init", new Class[]{Context.class}) == null) goto L12;
        return "sk";
    L12:
        return "";
    L21:
        return "";
    }

    public static String initEnv() {
        String r100 = version;
        if (r100 == null) goto L21;
        return r100;
    L21:
        sClzClientToken = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.APDeviceTokenClient");     // Catch: Throwable -> L7
        sClzAPSecuritySdk = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.alipaysecuritysdk.face.APSecuritySdk");     // Catch: Throwable -> L7
        sClzInitListener = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.APDeviceTokenClient$InitResultListener");     // Catch: Throwable -> L7
        sClzTokenResult = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.APDeviceTokenClient$TokenResult");     // Catch: Throwable -> L7
        sClzSgomClient = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.SgomInfoClient");     // Catch: Throwable -> L7
        sClzSgomClientResult = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.SgomInfoClient$SgomResult");     // Catch: Throwable -> L7
        version = "2";     // Catch: Throwable -> L7
    L9:
        String r101 = "";
    L13:
        if (TextUtils.isEmpty(version) == false) goto L18;
        version = "0";
        IReport r102 = sReportCrash;
        if (r102 == null) goto L18;
        r102.onException(new Exception(r101));
    L18:
        return version;
    L7:
        th = move-exception;
        sClzClientToken = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.DeviceTokenClient");     // Catch: Throwable -> L10
        sClzInitListener = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.DeviceTokenClient$InitResultListener");     // Catch: Throwable -> L10
        sClzTokenResult = INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.alipay.deviceid.DeviceTokenClient$TokenResult");     // Catch: Throwable -> L10
        version = "1";     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101 = (Log.getStackTraceString(th) + "\n") + Log.getStackTraceString(th);
        goto L13
    }

    public static int isSELinuxEnforcing() {
    L11:
        return 4;
    L4:
        if (new PolarisFileWrapper("/sys/fs/selinux/enforce").exists() == false) goto L10;
        if (new PolarisFileInputStreamWrapper("/sys/fs/selinux/enforce").read() != 49) goto L9;
        return 1;
    L9:
        return 2;
    L10:
        return 3;
    }

    public static void updateToken() {
        if ("2".equals(version) == true) goto L5;
        return;
    L5:
        if (isSupportFaceShield(false) == true) goto L8;
        return;
    L8:
        if (sClientTokenInstance != null) goto L10;
        initObjects(sContext);
    L10:
        Object r100 = sClientTokenInstance;
        if (r100 == null) goto L25;
        Method r101 = sUpdateTokenMethod;
        if (r101 != null) goto L22;
        return;
    L22:
        r101.invoke(r100, new Object[]{"zorro", "elBwppCSr9nB1LIQ", null, null});     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        IReport r102 = sReportCrash;
        if (r102 == null) goto L27;
        r102.onException(th);
        return;
    L27:
        return;
    }

    public SgomInfoManager() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_zoloz_toyger_SgomInfoManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String getTokenResult(Context r100) {
        if (sClientTokenInstance != null) goto L5;
        initObjects(r100);
    L5:
        Object r101 = sClientTokenInstance;
        if (r101 == null) goto L20;
        Method r102 = sGetTokenMethod;
        if (r102 != null) goto L18;
        return null;
    L18:
        Object r103 = r102.invoke(r101, new Object[0]);     // Catch: Throwable -> L12
        return (String) sApdidTokenField.get(r103);
    L12:
        th = move-exception;
        IReport r104 = sReportCrash;
        if (r104 == null) goto L22;
        r104.onException(th);
        return null;
    L22:
        return null;
    L20:
        return null;
    }

    private static void initObjects(Context r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        Class r100 = sClzClientToken;
        if (r100 != null) goto L7;
    L14:
        Class r101 = sClzClientToken;
        if (r101 != null) goto L17;
    L25:
        Class r102 = sClzClientToken;
        if (r102 != null) goto L28;
    L36:
        Class r103 = sClzClientToken;
        if (r103 != null) goto L39;
    L47:
        Class r104 = sClzTokenResult;
        if (r104 != null) goto L50;
    L57:
        Class r105 = sClzSgomClient;
        if (r105 != null) goto L60;
    L75:
        Class r111 = sClzSgomClientResult;
        if (r111 != null) goto L78;
        return;
    L78:
        if (sResultResField != null) goto L80;
    L100:
        sResultResField = r111.getField("resCode");     // Catch: Throwable -> L83
        sResultInfoField = sClzSgomClientResult.getField("resInfo");     // Catch: Throwable -> L83
        return;
    L83:
        th = move-exception;
        IReport r106 = sReportCrash;
        if (r106 == null) goto L106;
        r106.onException(th);
        return;
    L106:
        return;
    L80:
        if (sResultInfoField == null) goto L100;
        return;
    L60:
        if (sClientInstance != null) goto L75;
        sClientInstance = r105.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r110});     // Catch: Throwable -> L63
    L94:
        Class r112 = sClzSgomClient;     // Catch: Throwable -> L71
        sUpdateSgomInfoMethod = r112.getDeclaredMethod("updateSgomInfo", new Class[]{Integer.TYPE, Map.class});     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        IReport r107 = sReportCrash;
        if (r107 == null) goto L75;
        r107.onException(th);
    L63:
        th = move-exception;
        IReport r108 = sReportCrash;
        if (r108 == null) goto L94;
        r108.onException(th);
        goto L94
    L50:
        if (sApdidTokenField != null) goto L57;
        sApdidTokenField = r104.getField("apdidToken");     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        IReport r109 = sReportCrash;
        if (r109 == null) goto L57;
        r109.onException(th);
        goto L57
    L39:
        if (sGetTokenMethod != null) goto L47;
        sGetTokenMethod = r103.getDeclaredMethod("getTokenResult", new Class[0]);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        IReport r113 = sReportCrash;
        if (r113 == null) goto L47;
        r113.onException(th);
        goto L47
    L28:
        if (sInitTokenMethod != null) goto L36;
        sInitTokenMethod = r102.getDeclaredMethod("initToken", new Class[]{String.class, String.class, Map.class, sClzInitListener});     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        IReport r114 = sReportCrash;
        if (r114 == null) goto L36;
        r114.onException(th);
        goto L36
    L17:
        if (sUpdateTokenMethod != null) goto L25;
        sUpdateTokenMethod = r101.getDeclaredMethod("updateToken", new Class[]{String.class, String.class, Map.class, sClzInitListener});     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        IReport r115 = sReportCrash;
        if (r115 == null) goto L25;
        r115.onException(th);
        goto L25
    L7:
        if (sClientTokenInstance != null) goto L14;
        sClientTokenInstance = r100.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r110});     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        IReport r116 = sReportCrash;
        if (r116 == null) goto L14;
        r116.onException(th);
        goto L14
    }

    public static boolean isSupportFaceShield(boolean r110) {
        int r100 = isSupportFaceShield;
        if (r100 == 0) goto L9;
        if (r110 == true) goto L9;
        if (r100 == 1) goto L26;
        return false;
    L26:
        return true;
    L9:
        IReport r111 = sReportCrash;
        boolean r101 = ((Boolean) sClzAPSecuritySdk.getDeclaredMethod("isSupportFaceShield", new Class[0]).invoke(null, new Object[0])).booleanValue();     // Catch: Throwable -> L19
        if (r101 == false) goto L13;
        int r102 = 1;
    L14:
        isSupportFaceShield = r102;     // Catch: Throwable -> L19
        if (r111 != null) goto L17;
    L18:
        return r101;
    L17:
        r111.onReport("updateSgomInfo", "", null, new String[]{"isSupportFaceShield", String.valueOf(r101)});     // Catch: Throwable -> L19
        goto L18
    L13:
        r102 = -1;
    L19:
        th = move-exception;
        isSupportFaceShield = -1;
        if (r111 == null) goto L23;
        r111.onReport("updateSgomInfo", "errMsg", th, new String[]{"isSupportFaceShield", "false"});
    L23:
        return false;
    }

    public static void setSimpleFlagsDetect(boolean r100) {
        sSimpleFlagsDetect = r100;
    }

    public static void initToken(Context r100, final ITokenUpdate r101) {
        if (isSupportFaceShield(true) == true) goto L6;
        return;
    L6:
        if (sClientTokenInstance != null) goto L8;
        initObjects(r100);
    L8:
        Method r102 = sUpdateTokenMethod;
        if (r102 != null) goto L13;
        r102 = sInitTokenMethod;
    L13:
        if (sClientTokenInstance == null) goto L24;
        if (r102 == null) goto L25;
        Object r103 = Proxy.newProxyInstance(sClzInitListener.getClassLoader(), new Class[]{sClzInitListener}, new AnonymousClass1(r101));     // Catch: Throwable -> L17
        r102.invoke(sClientTokenInstance, new Object[]{"zorro", "elBwppCSr9nB1LIQ", null, r103});     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        IReport r104 = sReportCrash;
        if (r104 == null) goto L26;
        r104.onException(th);
        return;
    L26:
        return;
    L25:
        return;
    }

    public static void setContext(Context r100, IReport r101) {
        sContext = r100;
        sReportCrash = r101;
    }

    public static String updateSgomInfo(int r110, Map<String, String> r111) {
        ss7.a.c(r110, null);
        if ("2".equals(version) == true) goto L5;
    L29:
        return "";
    L5:
        if (isSupportFaceShield(false) == false) goto L29;
        if (sClientInstance != null) goto L11;
        initObjects(sContext);
    L11:
        if (sSimpleFlagsDetect == false) goto L29;
        Object r100 = sClientInstance;
        if (r100 == null) goto L29;
        Method r101 = sUpdateSgomInfoMethod;
        if (r101 == null) goto L29;
        Object r112 = r101.invoke(r100, new Object[]{Integer.valueOf(r110), r111});     // Catch: Throwable -> L25
        int r102 = ((Integer) sResultResField.get(r112)).intValue();     // Catch: Throwable -> L25
        if (r102 == 0) goto L23;
        IReport r103 = sReportCrash;     // Catch: Throwable -> L25
        if (r103 == null) goto L23;
        r103.onReport("updateSgomInfo", "", null, new String[]{"action", String.valueOf(r110), "resCode", "" + r102});     // Catch: Throwable -> L25
    L23:
        return (String) sResultInfoField.get(r112);
    L25:
        th = move-exception;
        IReport r104 = sReportCrash;
        if (r104 == null) goto L29;
        r104.onReport("SgomInfo", "errMsg", th, new String[]{"action ", String.valueOf(r110)});
        goto L29
    }
}
