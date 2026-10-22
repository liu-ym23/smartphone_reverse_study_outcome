package com.stepos.ailauncher.foundation.credential.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/SaveCredentialDto;", "", "connectionId", "", "status", "vendorId", "masked", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getConnectionId", "()Ljava/lang/String;", "getStatus", "getVendorId", "getMasked", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SaveCredentialDto {

    @SerializedName("connection_id")
    private final String connectionId;

    @SerializedName("masked")
    private final Map<String, String> masked;

    @SerializedName("status")
    private final String status;

    @SerializedName("vendor_id")
    private final String vendorId;

    public SaveCredentialDto() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaveCredentialDto copy$default(SaveCredentialDto saveCredentialDto, String str, String str2, String str3, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = saveCredentialDto.connectionId;
        }
        if ((i10 & 2) != 0) {
            str2 = saveCredentialDto.status;
        }
        if ((i10 & 4) != 0) {
            str3 = saveCredentialDto.vendorId;
        }
        if ((i10 & 8) != 0) {
            map = saveCredentialDto.masked;
        }
        return saveCredentialDto.copy(str, str2, str3, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConnectionId() {
        return this.connectionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    public final Map<String, String> component4() {
        return this.masked;
    }

    public final SaveCredentialDto copy(String connectionId, String status, String vendorId, Map<String, String> masked) {
        return new SaveCredentialDto(connectionId, status, vendorId, masked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveCredentialDto)) {
            return false;
        }
        SaveCredentialDto saveCredentialDto = (SaveCredentialDto) other;
        return p.d(this.connectionId, saveCredentialDto.connectionId) && p.d(this.status, saveCredentialDto.status) && p.d(this.vendorId, saveCredentialDto.vendorId) && p.d(this.masked, saveCredentialDto.masked);
    }

    public final String getConnectionId() {
        return this.connectionId;
    }

    public final Map<String, String> getMasked() {
        return this.masked;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.connectionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendorId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.masked;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SaveCredentialDto(connectionId=" + this.connectionId + ", status=" + this.status + ", vendorId=" + this.vendorId + ", masked=" + this.masked + ")";
    }

    public SaveCredentialDto(String str, String str2, String str3, Map<String, String> map) {
        this.connectionId = str;
        this.status = str2;
        this.vendorId = str3;
        this.masked = map;
    }

    public /* synthetic */ SaveCredentialDto(String str, String str2, String str3, Map map, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : map);
    }
}
