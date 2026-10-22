package com.bytedance.android.ec.core.address.api;

import com.bytedance.android.ec.core.address.z;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/address/api/ReportAddressResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "address", "Lcom/bytedance/android/ec/core/address/api/AddressItemVO;", "getAddress", "()Lcom/bytedance/android/ec/core/address/api/AddressItemVO;", "setAddress", "(Lcom/bytedance/android/ec/core/address/api/AddressItemVO;)V", "logId", "", "getLogId", "()Ljava/lang/String;", "serverTime", "", "getServerTime", "()J", "setServerTime", "(J)V", "isValid", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReportAddressResponse extends CommerceBaseResponse {

    @SerializedName("address")
    private AddressItemVO address;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("server_time")
    private long serverTime;

    public ReportAddressResponse() {
        this.serverTime = z.j();
    }

    public final boolean isValid() {
        if (getStatusCode() != 0) goto L10;
        AddressItemVO r100 = this.address;
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getAddressVO();
    L8:
        if (r101 == null) goto L10;
        return true;
    L7:
        r101 = null;
    L10:
        return false;
    }

    public final AddressItemVO getAddress() {
        return this.address;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final void setAddress(AddressItemVO r100) {
        this.address = r100;
    }

    public final void setServerTime(long r100) {
        this.serverTime = r100;
    }
}
