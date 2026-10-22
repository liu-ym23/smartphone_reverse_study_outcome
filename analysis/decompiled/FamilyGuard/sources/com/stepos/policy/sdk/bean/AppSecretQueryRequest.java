package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class AppSecretQueryRequest {
    private final String appId;

    public AppSecretQueryRequest(String str) {
        k.g(str, "appId");
        this.appId = str;
    }

    public static /* synthetic */ AppSecretQueryRequest copy$default(AppSecretQueryRequest appSecretQueryRequest, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = appSecretQueryRequest.appId;
        }
        return appSecretQueryRequest.copy(str);
    }

    public final String component1() {
        return this.appId;
    }

    public final AppSecretQueryRequest copy(String str) {
        k.g(str, "appId");
        return new AppSecretQueryRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppSecretQueryRequest) && k.b(this.appId, ((AppSecretQueryRequest) obj).appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public int hashCode() {
        return this.appId.hashCode();
    }

    public String toString() {
        return "AppSecretQueryRequest(appId=" + this.appId + ')';
    }
}
