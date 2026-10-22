package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\bO\u0010PR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR*\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010C\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\"\u0010F\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010I\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u00108\u001a\u0004\bJ\u0010:\"\u0004\bK\u0010<R\"\u0010L\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u00108\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<¨\u0006S"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBannerStruct;", "Ljava/io/Serializable;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "bannerType", "Ljava/lang/Integer;", "getBannerType", "()Ljava/lang/Integer;", "setBannerType", "(Ljava/lang/Integer;)V", "content", "getContent", "setContent", "textColor", "getTextColor", "setTextColor", "drawableLeftColor", "getDrawableLeftColor", "setDrawableLeftColor", "drawableRightColor", "getDrawableRightColor", "setDrawableRightColor", "drawableBorderColor", "getDrawableBorderColor", "setDrawableBorderColor", "url", "getUrl", "setUrl", "trackTag", "getTrackTag", "setTrackTag", "backgroundImg", "getBackgroundImg", "setBackgroundImg", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBannerItemStruct;", "bannerItems", "Ljava/util/List;", "getBannerItems", "()Ljava/util/List;", "setBannerItems", "(Ljava/util/List;)V", "bannerContentStrategy", "I", "getBannerContentStrategy", "()I", "setBannerContentStrategy", "(I)V", "boxLeftPadding", "getBoxLeftPadding", "setBoxLeftPadding", "boxRightPadding", "getBoxRightPadding", "setBoxRightPadding", "boxTopPadding", "getBoxTopPadding", "setBoxTopPadding", "boxBottomPadding", "getBoxBottomPadding", "setBoxBottomPadding", "iconRightDistance", "getIconRightDistance", "setIconRightDistance", "iconLeftDistance", "getIconLeftDistance", "setIconLeftDistance", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductBannerStruct implements Serializable {
    public static final int CONTENT_STRATEGY_BANNER_ITEMS = 1;
    public static final int CONTENT_STRATEGY_CONTENT = 0;
    public static final a Companion = null;
    public static final int LABEL_TYPE_FIND_GOOD = 12;
    public static final int TYPE_AUCTION_DOING = 9;
    public static final int TYPE_AUCTION_DONE = 10;
    public static final int TYPE_AUCTION_FAILED = 11;
    public static final int TYPE_AUCTION_STARTING = 8;
    public static final int TYPE_BEST_SELECTED = 14;
    public static final int TYPE_BRAND = 1;
    public static final int TYPE_CHARITY_GOODS = 31;
    public static final int TYPE_DCAR_REPORT = 32;
    public static final int TYPE_DEPOSIT = 4;
    public static final int TYPE_DOUYIN_FLAGSHIP = 133;
    public static final int TYPE_EXPLOSIVE_SUBSIDY = 19;
    public static final int TYPE_FEATURED_NEW_PRODUCT = 6;
    public static final int TYPE_FIRST_NEW_PRODUCT = 5;
    public static final int TYPE_GLOBAL = 3;
    public static final int TYPE_JIDI = 2;
    public static final int TYPE_SELECTED_GOOD_PRODUCT = 7;
    public static final int TYPE_SUPERMARKET_POP = 131;
    public static final int TYPE_SUPERMARKET_RETAIL = 132;

    @SerializedName("background_img")
    private ECUrlModel backgroundImg;

    @SerializedName("banner_content_strategy")
    private int bannerContentStrategy;

    @SerializedName("banner_items")
    private List<PromotionBannerItemStruct> bannerItems;

    @SerializedName("banner_type")
    private Integer bannerType;

    @SerializedName("box_bottom_padding")
    private int boxBottomPadding;

    @SerializedName("box_left_padding")
    private int boxLeftPadding;

    @SerializedName("box_right_padding")
    private int boxRightPadding;

    @SerializedName("box_top_padding")
    private int boxTopPadding;

    @SerializedName("content")
    private String content;

    @SerializedName("border_bg_color")
    private String drawableBorderColor;

    @SerializedName("bg_left_color")
    private String drawableLeftColor;

    @SerializedName("bg_right_color")
    private String drawableRightColor;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("icon_left_distance")
    private int iconLeftDistance;

    @SerializedName("icon_right_distance")
    private int iconRightDistance;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("title")
    private String title;

    @SerializedName("track_tag")
    private String trackTag;

    @SerializedName("url")
    private String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductBannerStruct() {
    }

    public final ECUrlModel getBackgroundImg() {
        return this.backgroundImg;
    }

    public final int getBannerContentStrategy() {
        return this.bannerContentStrategy;
    }

    public final List<PromotionBannerItemStruct> getBannerItems() {
        return this.bannerItems;
    }

    public final Integer getBannerType() {
        return this.bannerType;
    }

    public final int getBoxBottomPadding() {
        return this.boxBottomPadding;
    }

    public final int getBoxLeftPadding() {
        return this.boxLeftPadding;
    }

    public final int getBoxRightPadding() {
        return this.boxRightPadding;
    }

    public final int getBoxTopPadding() {
        return this.boxTopPadding;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDrawableBorderColor() {
        return this.drawableBorderColor;
    }

    public final String getDrawableLeftColor() {
        return this.drawableLeftColor;
    }

    public final String getDrawableRightColor() {
        return this.drawableRightColor;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final int getIconLeftDistance() {
        return this.iconLeftDistance;
    }

    public final int getIconRightDistance() {
        return this.iconRightDistance;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTrackTag() {
        return this.trackTag;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setBackgroundImg(ECUrlModel r100) {
        this.backgroundImg = r100;
    }

    public final void setBannerContentStrategy(int r100) {
        this.bannerContentStrategy = r100;
    }

    public final void setBannerItems(List<PromotionBannerItemStruct> r100) {
        this.bannerItems = r100;
    }

    public final void setBannerType(Integer r100) {
        this.bannerType = r100;
    }

    public final void setBoxBottomPadding(int r100) {
        this.boxBottomPadding = r100;
    }

    public final void setBoxLeftPadding(int r100) {
        this.boxLeftPadding = r100;
    }

    public final void setBoxRightPadding(int r100) {
        this.boxRightPadding = r100;
    }

    public final void setBoxTopPadding(int r100) {
        this.boxTopPadding = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDrawableBorderColor(String r100) {
        this.drawableBorderColor = r100;
    }

    public final void setDrawableLeftColor(String r100) {
        this.drawableLeftColor = r100;
    }

    public final void setDrawableRightColor(String r100) {
        this.drawableRightColor = r100;
    }

    public final void setIcon(ECUrlModel r100) {
        this.icon = r100;
    }

    public final void setIconLeftDistance(int r100) {
        this.iconLeftDistance = r100;
    }

    public final void setIconRightDistance(int r100) {
        this.iconRightDistance = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTrackTag(String r100) {
        this.trackTag = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
