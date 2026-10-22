package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;
import com.bytedance.android.livehostapi.foundation.depend.IUgSettingCallback;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddleWareHostContext extends IService, IBaseHostContext {
    public static final String ENTERPRISE_VERIFY_SETTING = "douyin_enterprise_verify_setting";
    public static final String PAD_UI_OPT_SETTING = "douyin_pad_ui_opt_setting";
    public static final String PLATFORM_ANDROID = "Android";
    public static final String PLATFORM_PAD = "Android_Pad";
    public static final String POI_LOCAL_LIVING_ROOM_CLOSE_RIGHTS = "poi_local_living_room_close_rights";

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$ecHostAppId(IMiddleWareHostContext r100) {
            return "";
        }

        public static Map $default$getSettings(IMiddleWareHostContext r100, List r101) {
            return null;
        }

        public static Object $default$getUgSettingsByKey(IMiddleWareHostContext r100, int r101, String r102) {
            return null;
        }

        public static int $default$hostAppId(IMiddleWareHostContext r100) {
            return 0;
        }

        public static void $default$initHostJsbRegister(IMiddleWareHostContext r100) {
        }

        public static Map $default$getFEParamExtra(IMiddleWareHostContext r100) {
            return new HashMap();
        }

        public static Boolean $default$isDarkMode(IMiddleWareHostContext r100) {
            return Boolean.TRUE;
        }
    }

    public @interface HostSettingKeys {
    }

    int appIcon();

    int appId();

    String appName();

    Context context();

    Locale currentLocale();

    String ecHostAppId();

    String getChannel();

    <T> T getClientABTestValue(ClientABTestKey<T> r100, boolean r101);

    LocationResult getCurrentLocation();

    String getDevicePlatform();

    EffectManager getEffectManager();

    String getEffectSDKVersion();

    Map<String, String> getFEParamExtra();

    int getFoldStatus();

    int getFoldStatusV3(Context r100);

    int getFoldType();

    Pair<String, String> getFreeFlowModel();

    <T> T getHostABValue(String r100, String r101, T r102, T r103);

    HostBoeParams getHostBoeParams();

    HostLargeFontParam getHostLargeFontModeParams();

    String getInstallId();

    String getPackageName();

    int getScreenHeight(Context r100);

    int getScreenWidth(Context r100);

    String getServerDeviceId();

    <T> T getSetting(String r100, T r101);

    Map<String, Object> getSettings(List<String> r100);

    int getTopSpaceHeight();

    Object getUgSettingsByKey(int r100, String r101);

    void getUgSettingsByKey(int r100, List<String> r101, IUgSettingCallback r102);

    int getUpdateVersionCode();

    String getVersionCode();

    String getVersionName();

    String getXTTToken();

    int hostAppId();

    void initDownloadableModelSupport();

    void initDownloadableModelSupportOnReady();

    void initDownloadableModelSupportSafely();

    void initHostJsbRegister();

    boolean isBoe();

    Boolean isDarkMode();

    boolean isFoldDevice();

    boolean isLocalTest();

    boolean isNeedProtectUnderage();

    boolean isOscarRun(Context r100);

    boolean isStrictMode();

    boolean isTransparentStatusBar();

    void linkNSForLive();

    int liveId();

    void refreshClientABTestValues();
}
