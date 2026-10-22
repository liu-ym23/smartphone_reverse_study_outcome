package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdk.chatroom.event.VSUserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInRoomCollection;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class BannerInRoomCollection extends FlexModelBase<IBannerInRoomCollection> implements IBannerInRoomCollection {

    @IgnoreProtoFieldCheck
    @SerializedName("activity_interactive")
    BannerInfo activityInteractive;

    @SerializedName("activity_top_right")
    BannerInfo activityTopRightBanner;

    @IgnoreProtoFieldCheck
    @SerializedName("activity_vs_bottom_right")
    BannerInfo activityVSBottomRight;

    @IgnoreProtoFieldCheck
    @SerializedName("activity_vs_interactive")
    BannerInfo activityVSInteractive;

    @SerializedName(VSUserProfileEvent.CLICK_POS_RIGHT)
    BannerInfo bottomRightBanner;

    @SerializedName("gift_panel")
    BannerInfo giftPanelBanner;

    @SerializedName("middle")
    BannerInfo middleBanner;

    @IgnoreProtoFieldCheck
    @SerializedName("retain_consult")
    BannerInfo retainConsult;

    @SerializedName("live_scene")
    BannerInfo sceneBanner;

    @SerializedName("top_left")
    BannerInfo topLeftActivityBanner;

    @SerializedName("top_right")
    BannerInfo topRightBanner;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static final class BannerInfo extends FlexModelBase<IBannerInfo> implements IBannerInfo {

        @SerializedName("animation_image")
        py.k animationImage;

        @SerializedName("banner_list")
        List<com.bytedance.android.livesdk.gift.model.b1> bannerList;

        @SerializedName("collapse")
        public m collapseInfo;

        @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
        int containerType;

        @SerializedName("container_url")
        String h5Url;

        @SerializedName("container_height")
        public int height;
        public boolean isLoadMessageBanner;
        public JSONObject loadMessageBannerJson;
        public String logId;

        @SerializedName("lynx_container_url")
        public String lynxUrl;

        @SerializedName("token_list")
        public List<String> tokenList;

        @SerializedName("container_width")
        public int width;

        public BannerInfo() {
            super(IBannerInfo.class);
            this.isLoadMessageBanner = false;
            this.loadMessageBannerJson = null;
        }

        public boolean isLynxContainerEnabled() {
            if (this.containerType == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public String toString() {
            return "BannerInfo{h5Url='" + this.h5Url + "', lynxUrl='" + this.lynxUrl + "', containerType=" + this.containerType + '}';
        }

        public py.k getAnimationImage() {
            return this.animationImage;
        }

        public List<com.bytedance.android.livesdk.gift.model.b1> getBannerList() {
            return this.bannerList;
        }

        public String getUrl() {
            return this.h5Url;
        }

        public void setBannerList(List<com.bytedance.android.livesdk.gift.model.b1> r100) {
            this.bannerList = r100;
        }

        public void setContainerType(int r100) {
            this.containerType = r100;
        }

        public void setH5Url(String r100) {
            this.h5Url = r100;
        }
    }

    public BannerInRoomCollection() {
        super(IBannerInRoomCollection.class);
    }

    public String toString() {
        return "BannerInRoomCollection{bottomRightBanner=" + this.bottomRightBanner + ", topRightBanner=" + this.topRightBanner + ", giftPanelBanner=" + this.giftPanelBanner + ", middleBanner=" + this.middleBanner + ", activityTopRightBanner=" + this.activityTopRightBanner + ", topLeftActivityBanner=" + this.topLeftActivityBanner + ", sceneBanner=" + this.sceneBanner + ", activityVSInteractive=" + this.activityVSInteractive + ", activityInteractive=" + this.activityInteractive + '}';
    }

    public BannerInfo getActivityInteractive() {
        return this.activityInteractive;
    }

    public BannerInfo getActivityTopRightBanner() {
        return this.activityTopRightBanner;
    }

    public BannerInfo getActivityVSBottomRight() {
        return this.activityVSBottomRight;
    }

    public BannerInfo getActivityVSInteractive() {
        return this.activityVSInteractive;
    }

    public BannerInfo getBottomRightBanner() {
        return this.bottomRightBanner;
    }

    public BannerInfo getGiftPanelBanner() {
        return this.giftPanelBanner;
    }

    public BannerInfo getMiddleBanner() {
        return this.middleBanner;
    }

    public BannerInfo getRetainConsult() {
        return this.retainConsult;
    }

    public BannerInfo getSceneBanner() {
        return this.sceneBanner;
    }

    public BannerInfo getTopLeftActivityBanner() {
        return this.topLeftActivityBanner;
    }

    public BannerInfo getTopRightBanner() {
        return this.topRightBanner;
    }

    public BannerInfo getVSBottomRightBanner() {
        return this.activityVSBottomRight;
    }
}
