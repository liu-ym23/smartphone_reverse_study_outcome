package com.stepos.cloud.securedata;

import kotlin.Metadata;
import m.x;
import q7.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/stepos/cloud/securedata/InitResult;", "", "publicKeySource", "Lcom/stepos/cloud/securedata/KeySource;", "encryptedKeySource", "appId", "", "deviceId", "<init>", "(Lcom/stepos/cloud/securedata/KeySource;Lcom/stepos/cloud/securedata/KeySource;Ljava/lang/String;Ljava/lang/String;)V", "getPublicKeySource", "()Lcom/stepos/cloud/securedata/KeySource;", "getEncryptedKeySource", "getAppId", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InitResult {
    private final String appId;
    private final String deviceId;
    private final KeySource encryptedKeySource;
    private final KeySource publicKeySource;

    public InitResult(KeySource keySource, KeySource keySource2, String str, String str2) {
        k.e(keySource, "publicKeySource");
        k.e(keySource2, "encryptedKeySource");
        k.e(str, "appId");
        k.e(str2, "deviceId");
        this.publicKeySource = keySource;
        this.encryptedKeySource = keySource2;
        this.appId = str;
        this.deviceId = str2;
    }

    public static /* synthetic */ InitResult copy$default(InitResult initResult, KeySource keySource, KeySource keySource2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            keySource = initResult.publicKeySource;
        }
        if ((i2 & 2) != 0) {
            keySource2 = initResult.encryptedKeySource;
        }
        if ((i2 & 4) != 0) {
            str = initResult.appId;
        }
        if ((i2 & 8) != 0) {
            str2 = initResult.deviceId;
        }
        return initResult.copy(keySource, keySource2, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final KeySource getPublicKeySource() {
        return this.publicKeySource;
    }

    /* renamed from: component2, reason: from getter */
    public final KeySource getEncryptedKeySource() {
        return this.encryptedKeySource;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final InitResult copy(KeySource publicKeySource, KeySource encryptedKeySource, String appId, String deviceId) {
        k.e(publicKeySource, "publicKeySource");
        k.e(encryptedKeySource, "encryptedKeySource");
        k.e(appId, "appId");
        k.e(deviceId, "deviceId");
        return new InitResult(publicKeySource, encryptedKeySource, appId, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitResult)) {
            return false;
        }
        InitResult initResult = (InitResult) other;
        return this.publicKeySource == initResult.publicKeySource && this.encryptedKeySource == initResult.encryptedKeySource && k.a(this.appId, initResult.appId) && k.a(this.deviceId, initResult.deviceId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final KeySource getEncryptedKeySource() {
        return this.encryptedKeySource;
    }

    public final KeySource getPublicKeySource() {
        return this.publicKeySource;
    }

    public int hashCode() {
        return this.deviceId.hashCode() + x.g(this.appId, (this.encryptedKeySource.hashCode() + (this.publicKeySource.hashCode() * 31)) * 31, 31);
    }

    public String toString() {
        return "InitResult(publicKeySource=" + this.publicKeySource + ", encryptedKeySource=" + this.encryptedKeySource + ", appId=" + this.appId + ", deviceId=" + this.deviceId + ")";
    }
}
