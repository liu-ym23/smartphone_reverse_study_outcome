package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import La.D;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "", "vendorId", "", "integrationId", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVendorId", "()Ljava/lang/String;", "getIntegrationId", "getStatus", "isAuthorized", "", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CaocaoCredentialStatusData {

    @SerializedName("integration_id")
    private final String integrationId;

    @SerializedName("status")
    private final String status;

    @SerializedName("vendor_id")
    private final String vendorId;

    public CaocaoCredentialStatusData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CaocaoCredentialStatusData copy$default(CaocaoCredentialStatusData caocaoCredentialStatusData, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = caocaoCredentialStatusData.vendorId;
        }
        if ((i10 & 2) != 0) {
            str2 = caocaoCredentialStatusData.integrationId;
        }
        if ((i10 & 4) != 0) {
            str3 = caocaoCredentialStatusData.status;
        }
        return caocaoCredentialStatusData.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final CaocaoCredentialStatusData copy(String vendorId, String integrationId, String status) {
        return new CaocaoCredentialStatusData(vendorId, integrationId, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaocaoCredentialStatusData)) {
            return false;
        }
        CaocaoCredentialStatusData caocaoCredentialStatusData = (CaocaoCredentialStatusData) other;
        return p.d(this.vendorId, caocaoCredentialStatusData.vendorId) && p.d(this.integrationId, caocaoCredentialStatusData.integrationId) && p.d(this.status, caocaoCredentialStatusData.status);
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.vendorId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.integrationId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isAuthorized() {
        return D.L(this.status, "authorized", true);
    }

    public String toString() {
        return "CaocaoCredentialStatusData(vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", status=" + this.status + ")";
    }

    public CaocaoCredentialStatusData(String str, String str2, String str3) {
        this.vendorId = str;
        this.integrationId = str2;
        this.status = str3;
    }

    public /* synthetic */ CaocaoCredentialStatusData(String str, String str2, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
