package com.bytedance.android.ec.model.response;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\"\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR \u0010,\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000e¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/model/response/Product;", "Ljava/io/Serializable;", "()V", "auctionType", "", "getAuctionType", "()J", "setAuctionType", "(J)V", "bizIdentity", "", "getBizIdentity", "()Ljava/lang/String;", "setBizIdentity", "(Ljava/lang/String;)V", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "setChannelId", "channelType", "", "getChannelType", "()Ljava/lang/Integer;", "setChannelType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "detailUrl", "getDetailUrl", "setDetailUrl", "isAuction", "", "()Z", "setAuction", "(Z)V", "isLottery", "setLottery", "itemType", "getItemType", "()Ljava/lang/Long;", "setItemType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "productId", "getProductId", "setProductId", "shopId", "getShopId", "setShopId", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class Product implements Serializable {

    @SerializedName("auction_type")
    private long auctionType;

    @SerializedName("biz_identity")
    private String bizIdentity;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private Integer channelType;

    @SerializedName("detail_url")
    private String detailUrl;

    @SerializedName("is_auction")
    private boolean isAuction;

    @SerializedName("is_lottery")
    private boolean isLottery;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Long itemType;

    @SerializedName("product_id")
    private String productId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private String shopId;

    public Product() {
    }

    public final long getAuctionType() {
        return this.auctionType;
    }

    public final String getBizIdentity() {
        return this.bizIdentity;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final Long getItemType() {
        return this.itemType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean isAuction() {
        return this.isAuction;
    }

    public final boolean isLottery() {
        return this.isLottery;
    }

    public final void setAuction(boolean r100) {
        this.isAuction = r100;
    }

    public final void setAuctionType(long r100) {
        this.auctionType = r100;
    }

    public final void setBizIdentity(String r100) {
        this.bizIdentity = r100;
    }

    public final void setChannelId(String r100) {
        this.channelId = r100;
    }

    public final void setChannelType(Integer r100) {
        this.channelType = r100;
    }

    public final void setDetailUrl(String r100) {
        this.detailUrl = r100;
    }

    public final void setItemType(Long r100) {
        this.itemType = r100;
    }

    public final void setLottery(boolean r100) {
        this.isLottery = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }
}
