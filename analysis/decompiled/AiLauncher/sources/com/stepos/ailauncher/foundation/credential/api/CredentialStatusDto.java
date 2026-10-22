package com.stepos.ailauncher.foundation.credential.api;

import La.D;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/CredentialStatusDto;", "", "vendorId", "", "vendorName", "status", "iconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVendorId", "()Ljava/lang/String;", "getVendorName", "getStatus", "getIconUrl", "isAuthorized", "", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CredentialStatusDto {
    public static final String STATUS_AUTHORIZED = "authorized";
    public static final String STATUS_EXPIRED = "expired";
    public static final String STATUS_MISSING = "missing";

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("status")
    private final String status;

    @SerializedName("vendor_id")
    private final String vendorId;

    @SerializedName("vendor_name")
    private final String vendorName;

    public CredentialStatusDto() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CredentialStatusDto copy$default(CredentialStatusDto credentialStatusDto, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = credentialStatusDto.vendorId;
        }
        if ((i10 & 2) != 0) {
            str2 = credentialStatusDto.vendorName;
        }
        if ((i10 & 4) != 0) {
            str3 = credentialStatusDto.status;
        }
        if ((i10 & 8) != 0) {
            str4 = credentialStatusDto.iconUrl;
        }
        return credentialStatusDto.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVendorName() {
        return this.vendorName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final CredentialStatusDto copy(String vendorId, String vendorName, String status, String iconUrl) {
        return new CredentialStatusDto(vendorId, vendorName, status, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CredentialStatusDto)) {
            return false;
        }
        CredentialStatusDto credentialStatusDto = (CredentialStatusDto) other;
        return p.d(this.vendorId, credentialStatusDto.vendorId) && p.d(this.vendorName, credentialStatusDto.vendorName) && p.d(this.status, credentialStatusDto.status) && p.d(this.iconUrl, credentialStatusDto.iconUrl);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        String str = this.vendorId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconUrl;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isAuthorized() {
        return D.L(this.status, "authorized", true);
    }

    public String toString() {
        return "CredentialStatusDto(vendorId=" + this.vendorId + ", vendorName=" + this.vendorName + ", status=" + this.status + ", iconUrl=" + this.iconUrl + ")";
    }

    public CredentialStatusDto(String str, String str2, String str3, String str4) {
        this.vendorId = str;
        this.vendorName = str2;
        this.status = str3;
        this.iconUrl = str4;
    }

    public /* synthetic */ CredentialStatusDto(String str, String str2, String str3, String str4, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}
