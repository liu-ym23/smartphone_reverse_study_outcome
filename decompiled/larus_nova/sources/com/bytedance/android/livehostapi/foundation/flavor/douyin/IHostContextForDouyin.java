package com.bytedance.android.livehostapi.foundation.flavor.douyin;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostContextForDouyin extends IService, IBaseHostContext {
    public static final String ENTERPRISE_VERIFY_SETTING = "douyin_enterprise_verify_setting";
    public static final String PAD_UI_OPT_SETTING = "douyin_pad_ui_opt_setting";
    public static final String PLATFORM_ANDROID = "Android";
    public static final String PLATFORM_PAD = "Android_Pad";
    public static final String POI_LOCAL_LIVING_ROOM_CLOSE_RIGHTS = "poi_local_living_room_close_rights";

    public @interface HostSettingKeys {
    }

    int appIcon();

    int appId();

    String appName();

    Context context();

    Locale currentLocale();

    String getChannel();

    <T> T getClientABTestValue(ClientABTestKey<T> r100, boolean r101);

    LocationResult getCurrentLocation();

    String getDevicePlatform();

    EffectManager getEffectManager();

    <T> T getHostABValue(String r100, String r101, T r102, T r103);

    HostBoeParams getHostBoeParams();

    LocationResult getNearByLocation();

    String getNearbyCityCode();

    String getPackageName();

    String getServerDeviceId();

    int getUpdateVersionCode();

    String getVersionCode();

    String getVersionName();

    void initDownloadableModelSupport();

    boolean isBoe();

    boolean isLocalTest();

    boolean isNeedProtectUnderage();

    int liveId();

    void refreshClientABTestValues();
}
