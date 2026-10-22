package com.bytedance.android.openlive.inner.utils.wrapper;

import android.text.TextUtils;
import com.bytedance.android.live.AbsLiveAppInfo;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.openlive.inner.IInitParams;
import com.bytedance.common.utility.android.ManifestData;
import eta.b;

/* JADX INFO: loaded from: classes12.dex */
public class AppInfoWrapper extends AbsLiveAppInfo {
    private b appContext;
    private IInitParams initParams;

    @Override // com.bytedance.android.live.AbsLiveAppInfo
    public boolean isFreeFlow() {
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int appIcon() {
        return this.initParams.appIcon();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int appId() {
        return this.initParams.webcastAppId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String appName() {
        return this.initParams.appName();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String channel() {
        return this.appContext.getChannel();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String clientKey() {
        return this.initParams.clientKey();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isDebug() {
        return this.initParams.isDebug();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int updateVersionCode() {
        return ManifestData.getInt(this.appContext.getContext(), "UPDATE_VERSION_CODE");
    L4:
        return 0;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int versionCode() {
        return this.appContext.getVersionCode();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String versionName() {
        return this.appContext.getVersion();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String devicesId() {
        if (BDLiveSdk.appLog() == null) goto L9;
        String r100 = BDLiveSdk.appLog().getDid();
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return "0";
    L8:
        return r100;
    L9:
        return "0";
    }

    public AppInfoWrapper(b r100, IInitParams r101) {
        this.appContext = r100;
        this.initParams = r101;
    }
}
