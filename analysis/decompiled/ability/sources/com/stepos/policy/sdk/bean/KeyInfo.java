package com.stepos.policy.sdk.bean;

import B7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/stepos/policy/sdk/bean/KeyInfo;", "", "keyId", "", "keyVersion", "keyLevel", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getKeyId", "setKeyId", "getKeyLevel", "setKeyLevel", "getKeyVersion", "setKeyVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class KeyInfo {
    private String extra;
    private String keyId;
    private String keyLevel;
    private String keyVersion;

    public KeyInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ KeyInfo copy$default(KeyInfo keyInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keyInfo.keyId;
        }
        if ((i & 2) != 0) {
            str2 = keyInfo.keyVersion;
        }
        if ((i & 4) != 0) {
            str3 = keyInfo.keyLevel;
        }
        if ((i & 8) != 0) {
            str4 = keyInfo.extra;
        }
        return keyInfo.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKeyId() {
        return this.keyId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKeyVersion() {
        return this.keyVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKeyLevel() {
        return this.keyLevel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final KeyInfo copy(String keyId, String keyVersion, String keyLevel, String extra) {
        k.f(keyId, "keyId");
        k.f(keyVersion, "keyVersion");
        k.f(keyLevel, "keyLevel");
        k.f(extra, "extra");
        return new KeyInfo(keyId, keyVersion, keyLevel, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyInfo)) {
            return false;
        }
        KeyInfo keyInfo = (KeyInfo) other;
        return k.b(this.keyId, keyInfo.keyId) && k.b(this.keyVersion, keyInfo.keyVersion) && k.b(this.keyLevel, keyInfo.keyLevel) && k.b(this.extra, keyInfo.extra);
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final String getKeyLevel() {
        return this.keyLevel;
    }

    public final String getKeyVersion() {
        return this.keyVersion;
    }

    public int hashCode() {
        return this.extra.hashCode() + a.c(a.c(this.keyId.hashCode() * 31, 31, this.keyVersion), 31, this.keyLevel);
    }

    public final void setExtra(String str) {
        k.f(str, "<set-?>");
        this.extra = str;
    }

    public final void setKeyId(String str) {
        k.f(str, "<set-?>");
        this.keyId = str;
    }

    public final void setKeyLevel(String str) {
        k.f(str, "<set-?>");
        this.keyLevel = str;
    }

    public final void setKeyVersion(String str) {
        k.f(str, "<set-?>");
        this.keyVersion = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KeyInfo(keyId=");
        sb.append(this.keyId);
        sb.append(", keyVersion=");
        sb.append(this.keyVersion);
        sb.append(", keyLevel=");
        sb.append(this.keyLevel);
        sb.append(", extra=");
        return a.g(')', this.extra, sb);
    }

    public KeyInfo(String keyId, String keyVersion, String keyLevel, String extra) {
        k.f(keyId, "keyId");
        k.f(keyVersion, "keyVersion");
        k.f(keyLevel, "keyLevel");
        k.f(extra, "extra");
        this.keyId = keyId;
        this.keyVersion = keyVersion;
        this.keyLevel = keyLevel;
        this.extra = extra;
    }

    public /* synthetic */ KeyInfo(String str, String str2, String str3, String str4, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
