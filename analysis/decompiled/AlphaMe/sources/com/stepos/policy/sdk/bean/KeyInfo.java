package com.stepos.policy.sdk.bean;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/stepos/policy/sdk/bean/KeyInfo;", "", "keyId", "", "keyVersion", "keyLevel", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getKeyId", "setKeyId", "getKeyLevel", "setKeyLevel", "getKeyVersion", "setKeyVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KeyInfo {

    @NotNull
    private String extra;

    @NotNull
    private String keyId;

    @NotNull
    private String keyLevel;

    @NotNull
    private String keyVersion;

    public KeyInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ KeyInfo copy$default(KeyInfo keyInfo, String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = keyInfo.keyId;
        }
        if ((i4 & 2) != 0) {
            str2 = keyInfo.keyVersion;
        }
        if ((i4 & 4) != 0) {
            str3 = keyInfo.keyLevel;
        }
        if ((i4 & 8) != 0) {
            str4 = keyInfo.extra;
        }
        return keyInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getKeyId() {
        return this.keyId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getKeyVersion() {
        return this.keyVersion;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getKeyLevel() {
        return this.keyLevel;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    @NotNull
    public final KeyInfo copy(@NotNull String keyId, @NotNull String keyVersion, @NotNull String keyLevel, @NotNull String extra) {
        Intrinsics.checkNotNullParameter(keyId, "keyId");
        Intrinsics.checkNotNullParameter(keyVersion, "keyVersion");
        Intrinsics.checkNotNullParameter(keyLevel, "keyLevel");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new KeyInfo(keyId, keyVersion, keyLevel, extra);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyInfo)) {
            return false;
        }
        KeyInfo keyInfo = (KeyInfo) other;
        return Intrinsics.areEqual(this.keyId, keyInfo.keyId) && Intrinsics.areEqual(this.keyVersion, keyInfo.keyVersion) && Intrinsics.areEqual(this.keyLevel, keyInfo.keyLevel) && Intrinsics.areEqual(this.extra, keyInfo.extra);
    }

    @NotNull
    public final String getExtra() {
        return this.extra;
    }

    @NotNull
    public final String getKeyId() {
        return this.keyId;
    }

    @NotNull
    public final String getKeyLevel() {
        return this.keyLevel;
    }

    @NotNull
    public final String getKeyVersion() {
        return this.keyVersion;
    }

    public int hashCode() {
        return this.extra.hashCode() + AbstractC0351g.d(this.keyLevel, AbstractC0351g.d(this.keyVersion, this.keyId.hashCode() * 31, 31), 31);
    }

    public final void setExtra(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final void setKeyId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyId = str;
    }

    public final void setKeyLevel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyLevel = str;
    }

    public final void setKeyVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyVersion = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("KeyInfo(keyId=");
        sb.append(this.keyId);
        sb.append(", keyVersion=");
        sb.append(this.keyVersion);
        sb.append(", keyLevel=");
        sb.append(this.keyLevel);
        sb.append(", extra=");
        return g.q(sb, this.extra, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }

    public KeyInfo(@NotNull String keyId, @NotNull String keyVersion, @NotNull String keyLevel, @NotNull String extra) {
        Intrinsics.checkNotNullParameter(keyId, "keyId");
        Intrinsics.checkNotNullParameter(keyVersion, "keyVersion");
        Intrinsics.checkNotNullParameter(keyLevel, "keyLevel");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.keyId = keyId;
        this.keyVersion = keyVersion;
        this.keyLevel = keyLevel;
        this.extra = extra;
    }

    public /* synthetic */ KeyInfo(String str, String str2, String str3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? "" : str4);
    }
}
