package com.stepos.ailauncher.foundation.credential.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/SaveCredentialRequest;", "", "vendorId", "", "integrationId", "fields", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getVendorId", "()Ljava/lang/String;", "getIntegrationId", "getFields", "()Ljava/util/Map;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SaveCredentialRequest {

    @SerializedName("fields")
    private final Map<String, String> fields;

    @SerializedName("integration_id")
    private final String integrationId;

    @SerializedName("vendor_id")
    private final String vendorId;

    public SaveCredentialRequest(String vendorId, String str, Map<String, String> fields) {
        p.i(vendorId, "vendorId");
        p.i(fields, "fields");
        this.vendorId = vendorId;
        this.integrationId = str;
        this.fields = fields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaveCredentialRequest copy$default(SaveCredentialRequest saveCredentialRequest, String str, String str2, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = saveCredentialRequest.vendorId;
        }
        if ((i10 & 2) != 0) {
            str2 = saveCredentialRequest.integrationId;
        }
        if ((i10 & 4) != 0) {
            map = saveCredentialRequest.fields;
        }
        return saveCredentialRequest.copy(str, str2, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final Map<String, String> component3() {
        return this.fields;
    }

    public final SaveCredentialRequest copy(String vendorId, String integrationId, Map<String, String> fields) {
        p.i(vendorId, "vendorId");
        p.i(fields, "fields");
        return new SaveCredentialRequest(vendorId, integrationId, fields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveCredentialRequest)) {
            return false;
        }
        SaveCredentialRequest saveCredentialRequest = (SaveCredentialRequest) other;
        return p.d(this.vendorId, saveCredentialRequest.vendorId) && p.d(this.integrationId, saveCredentialRequest.integrationId) && p.d(this.fields, saveCredentialRequest.fields);
    }

    public final Map<String, String> getFields() {
        return this.fields;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int iHashCode = this.vendorId.hashCode() * 31;
        String str = this.integrationId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "SaveCredentialRequest(vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", fields=" + this.fields + ")";
    }

    public /* synthetic */ SaveCredentialRequest(String str, String str2, Map map, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, map);
    }
}
