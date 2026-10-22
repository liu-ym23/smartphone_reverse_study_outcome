package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyInfo {
    private String extra;
    private String keyId;
    private String keyLevel;
    private String keyVersion;

    public KeyInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ KeyInfo copy$default(KeyInfo keyInfo, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = keyInfo.keyId;
        }
        if ((i10 & 2) != 0) {
            str2 = keyInfo.keyVersion;
        }
        if ((i10 & 4) != 0) {
            str3 = keyInfo.keyLevel;
        }
        if ((i10 & 8) != 0) {
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

    public final KeyInfo copy(String keyId, String keyVersion, String keyLevel, String extra) {
        g.f(keyId, "keyId");
        g.f(keyVersion, "keyVersion");
        g.f(keyLevel, "keyLevel");
        g.f(extra, "extra");
        return new KeyInfo(keyId, keyVersion, keyLevel, extra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInfo)) {
            return false;
        }
        KeyInfo keyInfo = (KeyInfo) obj;
        return g.b(this.keyId, keyInfo.keyId) && g.b(this.keyVersion, keyInfo.keyVersion) && g.b(this.keyLevel, keyInfo.keyLevel) && g.b(this.extra, keyInfo.extra);
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
        return this.extra.hashCode() + d.a(d.a(this.keyId.hashCode() * 31, 31, this.keyVersion), 31, this.keyLevel);
    }

    public final void setExtra(String str) {
        g.f(str, "<set-?>");
        this.extra = str;
    }

    public final void setKeyId(String str) {
        g.f(str, "<set-?>");
        this.keyId = str;
    }

    public final void setKeyLevel(String str) {
        g.f(str, "<set-?>");
        this.keyLevel = str;
    }

    public final void setKeyVersion(String str) {
        g.f(str, "<set-?>");
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
        return a.n(sb2, this.extra, ')');
    }

    public KeyInfo(String keyId, String keyVersion, String keyLevel, String extra) {
        g.f(keyId, "keyId");
        g.f(keyVersion, "keyVersion");
        g.f(keyLevel, "keyLevel");
        g.f(extra, "extra");
        this.keyId = keyId;
        this.keyVersion = keyVersion;
        this.keyLevel = keyLevel;
        this.extra = extra;
    }

    public /* synthetic */ KeyInfo(String str, String str2, String str3, String str4, int i10, e eVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }
}
