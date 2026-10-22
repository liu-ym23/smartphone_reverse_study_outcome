package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class ECCurrentPromotion extends com.bytedance.android.ec.model.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f47901a;

    @SerializedName("campaign")
    public ECPromotionCampaign campaign;

    @SerializedName("carousel_time")
    public long carouselTime;

    @SerializedName("commodity_icon")
    public CommodityIcon commodityIconInfo;

    @SerializedName("extend_info")
    public ECPopExtendInfo extendInfo;

    @SerializedName("extra")
    public b extra;

    @SerializedName("extra_param")
    public String extraParam;

    @SerializedName("float_window_info")
    public ECFloatWindowInfo floatWindowInfo;

    @SerializedName("logical_clock")
    public long logicalClock;

    @SerializedName("promotion")
    public ECPromotion promotion;

    @SerializedName("promotions")
    public List<ECPromotion> promotions;

    @SerializedName("public_area")
    public a publicArea;

    @SerializedName("replace_related_info")
    public String replaceRelatedInfo;

    @SerializedName("room_info")
    public PopRoomInfo roomInfo;

    @SerializedName(IPerformanceManager.Params.room_type)
    public int roomType;

    @SerializedName("server_time")
    public long serverTime;

    @SerializedName("show_duration")
    public long showDuration;

    @SerializedName("show_priority")
    public long showPriority;

    @SerializedName("skin")
    public ECSkinData skinData;

    public static class CommodityIcon implements Serializable {

        @SerializedName("background")
        public PopBackground background;

        @SerializedName("bottom_icon")
        public Map<String, String> bottomIcon;

        @SerializedName("bottom_icon_wide")
        public long buttomIconWide;

        @SerializedName("live_room_type")
        public long liveRoomType;

        @SerializedName("product_type")
        public long productType;

        @SerializedName("top_icon")
        public ECUrlModel topIcon;

        @SerializedName("up_desc")
        public String upDesc;

        @SerializedName("up_icon")
        public String upIcon;

        @SerializedName("up_icon_tag_track")
        public RitTagTrack upIconTagTrack;

        public CommodityIcon() {
        }
    }

    public static class PopBackground implements Serializable {

        @SerializedName("image")
        public String image;

        @SerializedName("tag_track")
        public RitTagTrack tagTrack;

        public PopBackground() {
        }
    }

    public static class a {

        @SerializedName("notice_text")
        public String noticeText;

        public a() {
            this.noticeText = null;
        }
    }

    public static class b {

        @SerializedName(CronetDataStorageAccess.LOGID)
        public String logid;

        public b() {
        }
    }

    public final List<ECPromotion> a() {
        List<ECPromotion> r100 = this.promotions;
        if (r100 == null) goto L9;
        if (r100.size() <= 0) goto L9;
        return this.promotions;
    L9:
        if (this.promotion == null) goto L13;
        LinkedList r101 = new LinkedList();
        r101.add(this.promotion);
        return r101;
    L13:
        return new ArrayList();
    }

    public ECCurrentPromotion() {
        this.serverTime = System.currentTimeMillis() / 1000;
        this.logicalClock = System.currentTimeMillis();
        this.showDuration = 10000;
        this.carouselTime = 0;
        this.f47901a = false;
    }
}
