package com.bytedance.android.livehostapi.platform.depend;

import com.bytedance.android.livehostapi.platform.base.IBaseHostConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddlewareHostAppConfig extends IBaseHostConfig {
    boolean canPlayInMobile();

    int enableHotsoonCityLiveVideoMix();

    boolean enableLiveVideoMixOpt();

    String getMobileFlowUrl();

    Map<String, String> getPreviewScrollAlphaConfig(String r100);

    boolean isFreeFlow();

    boolean isLivePlayFragmentOpen();

    boolean isMessageJsonPrintEnable();

    boolean isNetworkStateChanged();

    boolean isShowDebugInfo();

    void setCanPlayInMobile(boolean r100);

    void setLiveFragmentOpen(boolean r100);

    void setSettingLoaded(boolean r100);

    boolean settingLoaded();
}
