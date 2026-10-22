package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistData;", "", "allowed", "", "reason", "", "appletList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "signaturePublicKeyVersion", "", "<init>", "(ZILjava/util/List;Ljava/lang/String;)V", "getAllowed", "()Z", "getReason", "()I", "getAppletList", "()Ljava/util/List;", "getSignaturePublicKeyVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsInAppWhitelistData {
    private final boolean allowed;

    @SerializedName("applet_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformAppletItem> appletList;
    private final int reason;

    @SerializedName("sign_public_key_version")
    private final String signaturePublicKeyVersion;

    public IsInAppWhitelistData() {
        this(false, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsInAppWhitelistData copy$default(IsInAppWhitelistData r100, boolean r101, int r102, List r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.allowed;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.reason;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.appletList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.signaturePublicKeyVersion;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.allowed;
    }

    public final int component2() {
        return this.reason;
    }

    public final List<OpenPlatformAppletItem> component3() {
        return this.appletList;
    }

    public final String component4() {
        return this.signaturePublicKeyVersion;
    }

    public final IsInAppWhitelistData copy(boolean r100, int r101, List<OpenPlatformAppletItem> r102, String r103) {
        return new IsInAppWhitelistData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IsInAppWhitelistData) == true) goto L8;
        return false;
    L8:
        IsInAppWhitelistData r101 = (IsInAppWhitelistData) r100;
        if (this.allowed == r101.allowed) goto L12;
        return false;
    L12:
        if (this.reason == r101.reason) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletList, r101.appletList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.signaturePublicKeyVersion, r101.signaturePublicKeyVersion) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.allowed == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.reason) * 31;
        List<OpenPlatformAppletItem> r102 = this.appletList;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.signaturePublicKeyVersion;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "IsInAppWhitelistData(allowed=" + this.allowed + ", reason=" + this.reason + ", appletList=" + this.appletList + ", signaturePublicKeyVersion=" + this.signaturePublicKeyVersion + ')';
    }

    public final boolean getAllowed() {
        return this.allowed;
    }

    public final List<OpenPlatformAppletItem> getAppletList() {
        return this.appletList;
    }

    public final int getReason() {
        return this.reason;
    }

    public final String getSignaturePublicKeyVersion() {
        return this.signaturePublicKeyVersion;
    }

    public IsInAppWhitelistData(boolean r100, int r101, List<OpenPlatformAppletItem> r102, String r103) {
        this.allowed = r100;
        this.reason = r101;
        this.appletList = r102;
        this.signaturePublicKeyVersion = r103;
    }

    public /* synthetic */ IsInAppWhitelistData(boolean r100, int r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
