package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AppSecretQueryRequest {
    private final String appId;

    public AppSecretQueryRequest(String appId) {
        g.f(appId, "appId");
        this.appId = appId;
    }

    public static /* synthetic */ AppSecretQueryRequest copy$default(AppSecretQueryRequest appSecretQueryRequest, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appSecretQueryRequest.appId;
        }
        return appSecretQueryRequest.copy(str);
    }

    public final String component1() {
        return this.appId;
    }

    public final AppSecretQueryRequest copy(String appId) {
        g.f(appId, "appId");
        return new AppSecretQueryRequest(appId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppSecretQueryRequest) && g.b(this.appId, ((AppSecretQueryRequest) obj).appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public int hashCode() {
        return this.appId.hashCode();
    }

    public String toString() {
        return a.n(new StringBuilder("AppSecretQueryRequest(appId="), this.appId, ')');
    }
}
