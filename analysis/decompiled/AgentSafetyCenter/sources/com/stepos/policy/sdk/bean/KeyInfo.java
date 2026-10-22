package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import k0.a;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class KeyInfo {
    private String extra;
    private String keyId;
    private String keyLevel;
    private String keyVersion;

    public /* synthetic */ KeyInfo(String str, String str2, String str3, String str4, int i, f fVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
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
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
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
        return k.a(this.keyId, keyInfo.keyId) && k.a(this.keyVersion, keyInfo.keyVersion) && k.a(this.keyLevel, keyInfo.keyLevel) && k.a(this.extra, keyInfo.extra);
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
        return this.extra.hashCode() + b.d(b.d(this.keyId.hashCode() * 31, 31, this.keyVersion), 31, this.keyLevel);
    }

    public final void setExtra(String str) {
        str.getClass();
        this.extra = str;
    }

    public final void setKeyId(String str) {
        str.getClass();
        this.keyId = str;
    }

    public final void setKeyLevel(String str) {
        str.getClass();
        this.keyLevel = str;
    }

    public final void setKeyVersion(String str) {
        str.getClass();
        this.keyVersion = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("KeyInfo(keyId=");
        sb2.append(this.keyId);
        sb2.append(", keyVersion=");
        sb2.append(this.keyVersion);
        sb2.append(", keyLevel=");
        sb2.append(this.keyLevel);
        sb2.append(", extra=");
        return a.s(sb2, this.extra, ')');
    }

    public KeyInfo(String str, String str2, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.keyId = str;
        this.keyVersion = str2;
        this.keyLevel = str3;
        this.extra = str4;
    }

    public KeyInfo() {
        this(null, null, null, null, 15, null);
    }
}
