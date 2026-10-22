package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/stepos/policy/sdk/bean/AppSecretQueryRequest;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppSecretQueryRequest {
    private final String appId;

    public AppSecretQueryRequest(String appId) {
        p.i(appId, "appId");
        this.appId = appId;
    }

    public static /* synthetic */ AppSecretQueryRequest copy$default(AppSecretQueryRequest appSecretQueryRequest, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appSecretQueryRequest.appId;
        }
        return appSecretQueryRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final AppSecretQueryRequest copy(String appId) {
        p.i(appId, "appId");
        return new AppSecretQueryRequest(appId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppSecretQueryRequest) && p.d(this.appId, ((AppSecretQueryRequest) other).appId);
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
