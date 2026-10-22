package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.AuctionSuccess")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionSuccess;", "", "()V", "bizId", "", "buttonLabel", "", "charge", "depositInfo", "freight", "freightCollect", "jumpUrl", "leftPaymentTime", "price", "productId", "productName", "productPic", "title", "total", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2AuctionSuccess {

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public long bizId;

    @SerializedName("button_label")
    public String buttonLabel;

    @SerializedName("charge")
    public long charge;

    @SerializedName("deposit_info")
    public String depositInfo;

    @SerializedName("freight")
    public long freight;

    @SerializedName("freight_collect")
    public String freightCollect;

    @SerializedName("jump_url")
    public String jumpUrl;

    @SerializedName("left_payment_time")
    public long leftPaymentTime;

    @SerializedName("price")
    public long price;

    @SerializedName("product_id")
    public long productId;

    @SerializedName("product_name")
    public String productName;

    @SerializedName("product_pic")
    public String productPic;

    @SerializedName("title")
    public String title;

    @SerializedName("total")
    public long total;

    public ECV2AuctionSuccess() {
    }
}
