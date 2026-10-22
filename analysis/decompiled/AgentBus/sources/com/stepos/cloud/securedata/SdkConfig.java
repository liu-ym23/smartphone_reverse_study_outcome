package com.stepos.cloud.securedata;

import kotlin.Metadata;
import m.x;
import q7.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/cloud/securedata/SdkConfig;", "", "appId", "", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SdkConfig {
    private final String appId;
    private final String deviceId;

    public SdkConfig(String str, String str2) {
        k.e(str, "appId");
        k.e(str2, "deviceId");
        this.appId = str;
        this.deviceId = str2;
    }

    public static /* synthetic */ SdkConfig copy$default(SdkConfig sdkConfig, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sdkConfig.appId;
        }
        if ((i2 & 2) != 0) {
            str2 = sdkConfig.deviceId;
        }
        return sdkConfig.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final SdkConfig copy(String appId, String deviceId) {
        k.e(appId, "appId");
        k.e(deviceId, "deviceId");
        return new SdkConfig(appId, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkConfig)) {
            return false;
        }
        SdkConfig sdkConfig = (SdkConfig) other;
        return k.a(this.appId, sdkConfig.appId) && k.a(this.deviceId, sdkConfig.deviceId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public int hashCode() {
        return this.deviceId.hashCode() + (this.appId.hashCode() * 31);
    }

    public String toString() {
        return x.x("SdkConfig(appId=", this.appId, ", deviceId=", this.deviceId, ")");
    }
}
