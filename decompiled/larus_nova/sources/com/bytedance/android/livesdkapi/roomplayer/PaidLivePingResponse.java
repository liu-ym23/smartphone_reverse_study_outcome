package com.bytedance.android.livesdkapi.roomplayer;

import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated(message = "付费ping接口path迁移 使用PaidLivePingV2Response")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PaidLivePingResponse;", "", "retType", "", "duration", "", "delivery", "needDeliveryNotice", "", "(IJIZ)V", "getDelivery", "()I", "getDuration", "()J", "getNeedDeliveryNotice", "()Z", "getRetType", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLivePingResponse {

    @SerializedName("delivery")
    private final int delivery;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("need_delivery_notice")
    private final boolean needDeliveryNotice;

    @SerializedName("ret_type")
    private final int retType;

    public final int getDelivery() {
        return this.delivery;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getNeedDeliveryNotice() {
        return this.needDeliveryNotice;
    }

    public final int getRetType() {
        return this.retType;
    }

    public PaidLivePingResponse(int r100, long r101, int r102, boolean r103) {
        this.retType = r100;
        this.duration = r101;
        this.delivery = r102;
        this.needDeliveryNotice = r103;
    }
}
