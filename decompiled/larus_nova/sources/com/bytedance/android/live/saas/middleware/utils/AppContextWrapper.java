package com.bytedance.android.live.saas.middleware.utils;

import android.content.Context;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import eta.b;

/* JADX INFO: loaded from: classes47.dex */
public class AppContextWrapper implements b {
    private final IAppInfo appInfo;
    private Context context;

    @Override // eta.b
    public String getAbClient() {
        return "";
    }

    @Override // eta.b
    public String getAbFeature() {
        return "";
    }

    @Override // eta.b
    public long getAbFlag() {
        return 0;
    }

    @Override // eta.b
    public String getAbGroup() {
        return "";
    }

    @Override // eta.b
    public String getAbVersion() {
        return "";
    }

    public String getFeedbackAppKey() {
        return "";
    }

    @Override // eta.b
    public String getManifestVersion() {
        return "1.0.0";
    }

    @Override // eta.b
    public int getManifestVersionCode() {
        return 0;
    }

    @Override // eta.b
    public int getAid() {
        return CastIntegerProtector.parseInt(this.appInfo.hostAppId());
    L4:
        return 0;
    }

    @Override // eta.b
    public String getAppName() {
        return this.appInfo.appName();
    }

    @Override // eta.b
    public String getChannel() {
        return this.appInfo.channel();
    }

    public String getStringAppName() {
        return this.appInfo.appName();
    }

    @Override // eta.b
    public String getTweakedChannel() {
        return this.appInfo.channel();
    }

    @Override // eta.b
    public int getUpdateVersionCode() {
        return this.appInfo.updateVersionCode();
    }

    @Override // eta.b
    public String getVersion() {
        return this.appInfo.versionName();
    }

    @Override // eta.b
    public int getVersionCode() {
        return this.appInfo.versionCode();
    }

    @Override // eta.b
    public String getDeviceId() {
        return BDLiveSdk.appLog().getDid();
    }

    @Override // eta.b
    public Context getContext() {
        return this.context;
    }

    public AppContextWrapper(Context r100, IAppInfo r101) {
        this.context = r100;
        this.appInfo = r101;
    }
}
