package com.stepos.ailauncher.foundation.credential.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/IntegrationDto;", "", "integrationId", "", "vendorId", "vendorName", "displayName", AbstractC3297l.KEY_AUTH, "Lcom/stepos/ailauncher/foundation/credential/api/IntegrationAuthDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/credential/api/IntegrationAuthDto;)V", "getIntegrationId", "()Ljava/lang/String;", "getVendorId", "getVendorName", "getDisplayName", "getAuth", "()Lcom/stepos/ailauncher/foundation/credential/api/IntegrationAuthDto;", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class IntegrationDto {

    @SerializedName(AbstractC3297l.KEY_AUTH)
    private final IntegrationAuthDto auth;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("integration_id")
    private final String integrationId;

    @SerializedName("vendor_id")
    private final String vendorId;

    @SerializedName("vendor_name")
    private final String vendorName;

    public IntegrationDto() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ IntegrationDto copy$default(IntegrationDto integrationDto, String str, String str2, String str3, String str4, IntegrationAuthDto integrationAuthDto, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = integrationDto.integrationId;
        }
        if ((i10 & 2) != 0) {
            str2 = integrationDto.vendorId;
        }
        if ((i10 & 4) != 0) {
            str3 = integrationDto.vendorName;
        }
        if ((i10 & 8) != 0) {
            str4 = integrationDto.displayName;
        }
        if ((i10 & 16) != 0) {
            integrationAuthDto = integrationDto.auth;
        }
        IntegrationAuthDto integrationAuthDto2 = integrationAuthDto;
        String str5 = str3;
        return integrationDto.copy(str, str2, str5, str4, integrationAuthDto2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVendorName() {
        return this.vendorName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component5, reason: from getter */
    public final IntegrationAuthDto getAuth() {
        return this.auth;
    }

    public final IntegrationDto copy(String integrationId, String vendorId, String vendorName, String displayName, IntegrationAuthDto auth) {
        return new IntegrationDto(integrationId, vendorId, vendorName, displayName, auth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntegrationDto)) {
            return false;
        }
        IntegrationDto integrationDto = (IntegrationDto) other;
        return p.d(this.integrationId, integrationDto.integrationId) && p.d(this.vendorId, integrationDto.vendorId) && p.d(this.vendorName, integrationDto.vendorName) && p.d(this.displayName, integrationDto.displayName) && p.d(this.auth, integrationDto.auth);
    }

    public final IntegrationAuthDto getAuth() {
        return this.auth;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        String str = this.integrationId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendorName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.displayName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        IntegrationAuthDto integrationAuthDto = this.auth;
        return iHashCode4 + (integrationAuthDto != null ? integrationAuthDto.hashCode() : 0);
    }

    public String toString() {
        return "IntegrationDto(integrationId=" + this.integrationId + ", vendorId=" + this.vendorId + ", vendorName=" + this.vendorName + ", displayName=" + this.displayName + ", auth=" + this.auth + ")";
    }

    public IntegrationDto(String str, String str2, String str3, String str4, IntegrationAuthDto integrationAuthDto) {
        this.integrationId = str;
        this.vendorId = str2;
        this.vendorName = str3;
        this.displayName = str4;
        this.auth = integrationAuthDto;
    }

    public /* synthetic */ IntegrationDto(String str, String str2, String str3, String str4, IntegrationAuthDto integrationAuthDto, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : integrationAuthDto);
    }
}
