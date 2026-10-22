package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/policy/sdk/bean/AppSecretData;", "", "appId", "", "secret", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getSecret", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppSecretData {
    private final String appId;
    private final String secret;

    public AppSecretData(String str, String str2) {
        this.appId = str;
        this.secret = str2;
    }

    public static /* synthetic */ AppSecretData copy$default(AppSecretData appSecretData, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appSecretData.appId;
        }
        if ((i10 & 2) != 0) {
            str2 = appSecretData.secret;
        }
        return appSecretData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    public final AppSecretData copy(String appId, String secret) {
        return new AppSecretData(appId, secret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSecretData)) {
            return false;
        }
        AppSecretData appSecretData = (AppSecretData) other;
        return p.d(this.appId, appSecretData.appId) && p.d(this.secret, appSecretData.secret);
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
