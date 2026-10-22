package com.bytedance.android.livehostapi.foundation.flavor.xt;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostContextForXT extends IBaseHostContext, IService {
    int appIcon();

    int appId();

    String appName();

    Context context();

    String getChannel();

    <T> T getClientABTestValue(ClientABTestKey<T> r100, boolean r101);

    String getPackageName();

    String getServerDeviceId();

    int getUpdateVersionCode();

    String getVersionCode();

    String getVersionName();

    boolean isLocalTest();

    boolean isNeedProtectUnderage();

    int liveId();

    void refreshClientABTestValues();
}
