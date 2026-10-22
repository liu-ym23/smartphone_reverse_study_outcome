package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountResp;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "()V", "total", "", "getTotal", "()I", "setTotal", "(I)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardCountResp extends BaseResponse {

    @SerializedName("total")
    private int total;

    public CardCountResp() {
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int r100) {
        this.total = r100;
    }
}
