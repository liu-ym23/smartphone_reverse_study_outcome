package com.stepos.ailauncher.foundation.credential.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/IntegrationAuthDto;", "", "mode", "", "type", "required", "", "credentialScope", "methodLabel", "iconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getType", "getRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCredentialScope", "getMethodLabel", "getIconUrl", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/credential/api/IntegrationAuthDto;", "equals", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class IntegrationAuthDto {

    @SerializedName("credential_scope")
    private final String credentialScope;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("method_label")
    private final String methodLabel;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("required")
    private final Boolean required;

    @SerializedName("type")
    private final String type;

    public IntegrationAuthDto() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ IntegrationAuthDto copy$default(IntegrationAuthDto integrationAuthDto, String str, String str2, Boolean bool, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = integrationAuthDto.mode;
        }
        if ((i10 & 2) != 0) {
            str2 = integrationAuthDto.type;
        }
        if ((i10 & 4) != 0) {
            bool = integrationAuthDto.required;
        }
        if ((i10 & 8) != 0) {
            str3 = integrationAuthDto.credentialScope;
        }
        if ((i10 & 16) != 0) {
            str4 = integrationAuthDto.methodLabel;
        }
        if ((i10 & 32) != 0) {
            str5 = integrationAuthDto.iconUrl;
        }
        String str6 = str4;
        String str7 = str5;
        return integrationAuthDto.copy(str, str2, bool, str3, str6, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getRequired() {
        return this.required;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCredentialScope() {
        return this.credentialScope;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMethodLabel() {
        return this.methodLabel;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final IntegrationAuthDto copy(String mode, String type, Boolean required, String credentialScope, String methodLabel, String iconUrl) {
        return new IntegrationAuthDto(mode, type, required, credentialScope, methodLabel, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntegrationAuthDto)) {
            return false;
        }
        IntegrationAuthDto integrationAuthDto = (IntegrationAuthDto) other;
        return p.d(this.mode, integrationAuthDto.mode) && p.d(this.type, integrationAuthDto.type) && p.d(this.required, integrationAuthDto.required) && p.d(this.credentialScope, integrationAuthDto.credentialScope) && p.d(this.methodLabel, integrationAuthDto.methodLabel) && p.d(this.iconUrl, integrationAuthDto.iconUrl);
    }

    public final String getCredentialScope() {
        return this.credentialScope;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getMethodLabel() {
        return this.methodLabel;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.required;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.credentialScope;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.methodLabel;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.iconUrl;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "IntegrationAuthDto(mode=" + this.mode + ", type=" + this.type + ", required=" + this.required + ", credentialScope=" + this.credentialScope + ", methodLabel=" + this.methodLabel + ", iconUrl=" + this.iconUrl + ")";
    }

    public IntegrationAuthDto(String str, String str2, Boolean bool, String str3, String str4, String str5) {
        this.mode = str;
        this.type = str2;
        this.required = bool;
        this.credentialScope = str3;
        this.methodLabel = str4;
        this.iconUrl = str5;
    }

    public /* synthetic */ IntegrationAuthDto(String str, String str2, Boolean bool, String str3, String str4, String str5, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5);
    }
}
