package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/stepos/policy/sdk/bean/KeyInfo;", "", "keyId", "", "keyVersion", "keyLevel", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getKeyId", "setKeyId", "getKeyLevel", "setKeyLevel", "getKeyVersion", "setKeyVersion", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KeyInfo {
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
        p.i(keyId, "keyId");
        p.i(keyVersion, "keyVersion");
        p.i(keyLevel, "keyLevel");
        p.i(extra, "extra");
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
        return p.d(this.keyId, keyInfo.keyId) && p.d(this.keyVersion, keyInfo.keyVersion) && p.d(this.keyLevel, keyInfo.keyLevel) && p.d(this.extra, keyInfo.extra);
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
        p.i(str, "<set-?>");
        this.extra = str;
    }

    public final void setKeyId(String str) {
        p.i(str, "<set-?>");
        this.keyId = str;
    }

    public final void setKeyLevel(String str) {
        p.i(str, "<set-?>");
        this.keyLevel = str;
    }

    public final void setKeyVersion(String str) {
        p.i(str, "<set-?>");
        this.keyVersion = str;
    }

    public String toString() {
        return "KeyInfo(keyId=" + this.keyId + ", keyVersion=" + this.keyVersion + ", keyLevel=" + this.keyLevel + ", extra=" + this.extra + ')';
    }

    public KeyInfo(String keyId, String keyVersion, String keyLevel, String extra) {
        p.i(keyId, "keyId");
        p.i(keyVersion, "keyVersion");
        p.i(keyLevel, "keyLevel");
        p.i(extra, "extra");
        this.keyId = keyId;
        this.keyVersion = keyVersion;
        this.keyLevel = keyLevel;
        this.extra = extra;
    }

    public /* synthetic */ KeyInfo(String str, String str2, String str3, String str4, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }
}
