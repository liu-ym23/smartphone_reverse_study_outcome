package com.bytedance.ai.bridge.method.payment.bean;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentWithSignResponse;", "", "data", "", "logId", "errCode", "", "errMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getLogId", "setLogId", "getErrCode", "()I", "setErrCode", "(I)V", "getErrMsg", "setErrMsg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetOrderPaymentWithSignResponse {

    @SerializedName("pay_data")
    private String data;

    @SerializedName("err_code")
    private int errCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private String errMsg;

    @SerializedName("log_id")
    private String logId;

    public GetOrderPaymentWithSignResponse() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ GetOrderPaymentWithSignResponse copy$default(GetOrderPaymentWithSignResponse r100, String r101, String r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.logId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.errCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.errMsg;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.data;
    }

    public final String component2() {
        return this.logId;
    }

    public final int component3() {
        return this.errCode;
    }

    public final String component4() {
        return this.errMsg;
    }

    public final GetOrderPaymentWithSignResponse copy(String r100, String r101, int r102, String r103) {
        return new GetOrderPaymentWithSignResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetOrderPaymentWithSignResponse) == true) goto L8;
        return false;
    L8:
        GetOrderPaymentWithSignResponse r101 = (GetOrderPaymentWithSignResponse) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L15;
        return false;
    L15:
        if (this.errCode == r101.errCode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.data;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.logId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.errCode) * 31;
        String r107 = this.errMsg;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetOrderPaymentWithSignResponse(data=" + this.data + ", logId=" + this.logId + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
    }

    public final String getData() {
        return this.data;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setData(String r100) {
        this.data = r100;
    }

    public final void setErrCode(int r100) {
        this.errCode = r100;
    }

    public final void setErrMsg(String r100) {
        this.errMsg = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public GetOrderPaymentWithSignResponse(String r100, String r101, int r102, String r103) {
        this.data = r100;
        this.logId = r101;
        this.errCode = r102;
        this.errMsg = r103;
    }

    public /* synthetic */ GetOrderPaymentWithSignResponse(String r100, String r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
