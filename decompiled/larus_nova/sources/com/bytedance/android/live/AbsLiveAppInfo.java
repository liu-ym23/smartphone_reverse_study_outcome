package com.bytedance.android.live;

import com.bytedance.android.live.saas.middleware.IAppInfo;

/* JADX INFO: loaded from: classes45.dex */
public abstract class AbsLiveAppInfo implements IAppInfo {
    public AbsLiveAppInfo() {
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String apiHost() {
        return "webcast-open.douyin.com";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String boeLane() {
        return "";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String hostAppId() {
        return "";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isBoe() {
        return false;
    }

    public abstract boolean isFreeFlow();

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isPPE() {
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String ppeLane() {
        return "";
    }

    public int hostAid() {
        return appId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int sdkVersion() {
        return com.bytedance.android.livesdk.paas.c.b();
    }

    public int webcastId() {
        return appId();
    }
}
