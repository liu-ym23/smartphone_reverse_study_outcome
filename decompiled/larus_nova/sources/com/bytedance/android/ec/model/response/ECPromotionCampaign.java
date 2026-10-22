package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes44.dex */
public class ECPromotionCampaign implements Serializable {

    @SerializedName("auction_info")
    public ECPromotionAuctionInfo auctionInfo;

    @SerializedName("campaign_type")
    public int campaignType;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("fake_sec_kill")
    public boolean fakeSecKill;

    @SerializedName("group_data")
    public ECPromotionCampaignGroup groupData;

    @SerializedName("is_preheat")
    public boolean isPreheat;

    @SerializedName("label")
    public String label;

    @SerializedName("left_stock")
    public long leftStock;

    @SerializedName("logical_clock")
    public long logicalClock;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    public long marketPrice;

    @SerializedName("max_price")
    public long maxPrice;

    @SerializedName("multi_group")
    public MultiGroupInfo multiGroupInfo;

    /* JADX INFO: renamed from: pic, reason: collision with root package name */
    @SerializedName("pic")
    public String f47906pic;

    @SerializedName("pre_sale_data")
    public ECPreSaleData preSaleData;

    @SerializedName("price")
    public long price;

    @SerializedName("price_header")
    public String priceHeader;

    @SerializedName("price_str")
    public String priceStr;

    @SerializedName("progress")
    public CampaignProgress progress;

    @SerializedName("progress_text")
    public String progressText;

    @SerializedName("promotion_id")
    public String promotionId;

    @SerializedName("sec_icon")
    public String secIcon;

    @SerializedName("skill_icon")
    public ECUrlModel skillIcon;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    @SerializedName("stock")
    public long stock;

    @SerializedName("style")
    public int style;

    @SerializedName("time_end_label")
    public String timeEndLabel;

    @SerializedName("time_start_label")
    public String timeStartLabel;

    @SerializedName("user_limit")
    public long userLimit;

    public ECPromotionCampaign() {
        this.isPreheat = false;
        this.logicalClock = 0;
    }
}
