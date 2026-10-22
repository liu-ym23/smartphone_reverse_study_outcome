package com.stepos.ailauncher.task.space.credential;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/t;", "", "", "vendorId", "integrationId", "", "fields", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getVendorId", "getIntegrationId", "Ljava/util/Map;", "getFields", "()Ljava/util/Map;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.t, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SaveCredentialRequest {

    @SerializedName("fields")
    private final Map<String, String> fields;

    @SerializedName("integration_id")
    private final String integrationId;

    @SerializedName("vendor_id")
    private final String vendorId;

    public SaveCredentialRequest(String vendorId, String str, Map<String, String> fields) {
        kotlin.jvm.internal.p.i(vendorId, "vendorId");
        kotlin.jvm.internal.p.i(fields, "fields");
        this.vendorId = vendorId;
        this.integrationId = str;
        this.fields = fields;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveCredentialRequest)) {
            return false;
        }
        SaveCredentialRequest saveCredentialRequest = (SaveCredentialRequest) other;
        return kotlin.jvm.internal.p.d(this.vendorId, saveCredentialRequest.vendorId) && kotlin.jvm.internal.p.d(this.integrationId, saveCredentialRequest.integrationId) && kotlin.jvm.internal.p.d(this.fields, saveCredentialRequest.fields);
    }

    public int hashCode() {
        int iHashCode = this.vendorId.hashCode() * 31;
        String str = this.integrationId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "SaveCredentialRequest(vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", fields=" + this.fields + ")";
    }
}
