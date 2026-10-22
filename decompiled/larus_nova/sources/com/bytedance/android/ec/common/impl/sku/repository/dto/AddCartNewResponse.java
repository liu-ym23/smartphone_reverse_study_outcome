package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.sku.AddCartData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/AddCartNewResponse;", "Ljava/io/Serializable;", "()V", "data", "Lcom/bytedance/android/ec/model/sku/AddCartData;", "getData", "()Lcom/bytedance/android/ec/model/sku/AddCartData;", "setData", "(Lcom/bytedance/android/ec/model/sku/AddCartData;)V", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", Segment.JsonKey.START, "", "getSt", "()I", "setSt", "(I)V", "statusCode", "getStatusCode", "setStatusCode", a.KEY_STATUS_MSG, "", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "asJsonDescription", "Lorg/json/JSONObject;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddCartNewResponse implements Serializable {

    @SerializedName("data")
    private AddCartData data;

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    @SerializedName(Segment.JsonKey.START)
    private int f43346st;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("msg")
    private String statusMsg;

    public AddCartNewResponse() {
    }

    public final JSONObject asJsonDescription() {
        JSONObject r100 = new JSONObject();
        r100.put(Segment.JsonKey.START, this.f43346st);
        r100.put("status_msg", this.statusMsg);
        AddCartData r101 = this.data;
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        JSONObject r103 = r101.asJSONDescription();
    L6:
        r100.put("data", r103);
        PromotionLogPbData r104 = this.logPb;
        if (r104 == null) goto L9;
        r102 = r104.asJSONDescription();
    L9:
        r100.put("log_pb", r102);
        r100.put("status_code", this.statusCode);
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public final AddCartData getData() {
        return this.data;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final int getSt() {
        return this.f43346st;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final void setData(AddCartData r100) {
        this.data = r100;
    }

    public final void setSt(int r100) {
        this.f43346st = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }
}
