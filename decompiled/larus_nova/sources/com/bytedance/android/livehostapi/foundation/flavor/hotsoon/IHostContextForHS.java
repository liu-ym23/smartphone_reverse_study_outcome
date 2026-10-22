package com.bytedance.android.livehostapi.foundation.flavor.hotsoon;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostContextForHS extends IService, IBaseHostContext {
    int appIcon();

    int appId();

    String appName();

    Context context();

    Locale currentLocale();

    String getChannel();

    <T> T getClientABTestValue(ClientABTestKey<T> r100, boolean r101);

    LocationResult getCurrentLocation();

    EffectManager getEffectManager();

    Pair<String, String> getFreeFlowModel();

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
