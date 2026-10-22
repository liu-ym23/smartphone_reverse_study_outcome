package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class AppSecretData {
    private final String appId;
    private final String secret;

    public AppSecretData(String str, String str2) {
        this.appId = str;
        this.secret = str2;
    }

    public static /* synthetic */ AppSecretData copy$default(AppSecretData appSecretData, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = appSecretData.appId;
        }
        if ((i5 & 2) != 0) {
            str2 = appSecretData.secret;
        }
        return appSecretData.copy(str, str2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.secret;
    }

    public final AppSecretData copy(String str, String str2) {
        return new AppSecretData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSecretData)) {
            return false;
        }
        AppSecretData appSecretData = (AppSecretData) obj;
        return k.b(this.appId, appSecretData.appId) && k.b(this.secret, appSecretData.secret);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSecret() {
        return this.secret;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secret;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AppSecretData(appId=" + this.appId + ", secret=" + this.secret + ')';
    }
}
