package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\fR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/s;", "", "", "connectionId", "status", "vendorId", "vendorName", "", "masked", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getConnectionId", Const.INTENT_KEY_APIKEY, "getVendorId", "getVendorName", "Ljava/util/Map;", "getMasked", "()Ljava/util/Map;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.s, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SaveCredentialData {

    @SerializedName("connection_id")
    private final String connectionId;

    @SerializedName("masked")
    private final Map<String, String> masked;

    @SerializedName("status")
    private final String status;

    @SerializedName("vendor_id")
    private final String vendorId;

    @SerializedName("vendor_name")
    private final String vendorName;

    public SaveCredentialData() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveCredentialData)) {
            return false;
        }
        SaveCredentialData saveCredentialData = (SaveCredentialData) other;
        return kotlin.jvm.internal.p.d(this.connectionId, saveCredentialData.connectionId) && kotlin.jvm.internal.p.d(this.status, saveCredentialData.status) && kotlin.jvm.internal.p.d(this.vendorId, saveCredentialData.vendorId) && kotlin.jvm.internal.p.d(this.vendorName, saveCredentialData.vendorName) && kotlin.jvm.internal.p.d(this.masked, saveCredentialData.masked);
    }

    public int hashCode() {
        String str = this.connectionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendorId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.vendorName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<String, String> map = this.masked;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SaveCredentialData(connectionId=" + this.connectionId + ", status=" + this.status + ", vendorId=" + this.vendorId + ", vendorName=" + this.vendorName + ", masked=" + this.masked + ")";
    }

    public SaveCredentialData(String str, String str2, String str3, String str4, Map<String, String> map) {
        this.connectionId = str;
        this.status = str2;
        this.vendorId = str3;
        this.vendorName = str4;
        this.masked = map;
    }

    public /* synthetic */ SaveCredentialData(String str, String str2, String str3, String str4, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : map);
    }
}
