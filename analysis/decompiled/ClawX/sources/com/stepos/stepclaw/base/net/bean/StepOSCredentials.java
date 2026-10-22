package com.stepos.stepclaw.base.net.bean;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/stepclaw/base/net/bean/StepOSCredentials;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "appId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "appSecret", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppSecret", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class StepOSCredentials {
    private final String appId;
    private final String appSecret;

    public StepOSCredentials(String appId, String appSecret) {
        p.e(appId, "appId");
        p.e(appSecret, "appSecret");
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public static /* synthetic */ StepOSCredentials copy$default(StepOSCredentials stepOSCredentials, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = stepOSCredentials.appId;
        }
        if ((i8 & 2) != 0) {
            str2 = stepOSCredentials.appSecret;
        }
        return stepOSCredentials.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppSecret() {
        return this.appSecret;
    }

    public final StepOSCredentials copy(String appId, String appSecret) {
        p.e(appId, "appId");
        p.e(appSecret, "appSecret");
        return new StepOSCredentials(appId, appSecret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepOSCredentials)) {
            return false;
        }
        StepOSCredentials stepOSCredentials = (StepOSCredentials) other;
        return p.a(this.appId, stepOSCredentials.appId) && p.a(this.appSecret, stepOSCredentials.appSecret);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppSecret() {
        return this.appSecret;
    }

    public int hashCode() {
        return this.appSecret.hashCode() + (this.appId.hashCode() * 31);
    }

    public String toString() {
        return b.q("StepOSCredentials(appId=", this.appId, ", appSecret=", this.appSecret, ")");
    }
}
