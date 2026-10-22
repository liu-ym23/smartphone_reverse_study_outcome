package com.stepos.policy.sdk.bean;

import j4.g;
import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class KeyInfo {
    private String extra;
    private String keyId;
    private String keyLevel;
    private String keyVersion;

    public KeyInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ KeyInfo copy$default(KeyInfo keyInfo, String str, String str2, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = keyInfo.keyId;
        }
        if ((i5 & 2) != 0) {
            str2 = keyInfo.keyVersion;
        }
        if ((i5 & 4) != 0) {
            str3 = keyInfo.keyLevel;
        }
        if ((i5 & 8) != 0) {
            str4 = keyInfo.extra;
        }
        return keyInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.keyId;
    }

    public final String component2() {
        return this.keyVersion;
    }

    public final String component3() {
        return this.keyLevel;
    }

    public final String component4() {
        return this.extra;
    }

    public final KeyInfo copy(String str, String str2, String str3, String str4) {
        k.g(str, "keyId");
        k.g(str2, "keyVersion");
        k.g(str3, "keyLevel");
        k.g(str4, "extra");
        return new KeyInfo(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInfo)) {
            return false;
        }
        KeyInfo keyInfo = (KeyInfo) obj;
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
        return (((((this.keyId.hashCode() * 31) + this.keyVersion.hashCode()) * 31) + this.keyLevel.hashCode()) * 31) + this.extra.hashCode();
    }

    public final void setExtra(String str) {
        k.g(str, "<set-?>");
        this.extra = str;
    }

    public final void setKeyId(String str) {
        k.g(str, "<set-?>");
        this.keyId = str;
    }

    public final void setKeyLevel(String str) {
        k.g(str, "<set-?>");
        this.keyLevel = str;
    }

    public final void setKeyVersion(String str) {
        k.g(str, "<set-?>");
        this.keyVersion = str;
    }

    public String toString() {
        return "KeyInfo(keyId=" + this.keyId + ", keyVersion=" + this.keyVersion + ", keyLevel=" + this.keyLevel + ", extra=" + this.extra + ')';
    }

    public KeyInfo(String str, String str2, String str3, String str4) {
        k.g(str, "keyId");
        k.g(str2, "keyVersion");
        k.g(str3, "keyLevel");
        k.g(str4, "extra");
        this.keyId = str;
        this.keyVersion = str2;
        this.keyLevel = str3;
        this.extra = str4;
    }

    public /* synthetic */ KeyInfo(String str, String str2, String str3, String str4, int i5, g gVar) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str2, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str3, (i5 & 8) != 0 ? BuildConfig.FLAVOR : str4);
    }
}
