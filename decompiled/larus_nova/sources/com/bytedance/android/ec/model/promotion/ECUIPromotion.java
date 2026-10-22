package com.bytedance.android.ec.model.promotion;

import android.text.TextUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.ec.model.response.ECGivenProductStruck;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPopExtendInfo;
import com.bytedance.android.ec.model.response.ECPriceDescription;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionBottomBanner;
import com.bytedance.android.ec.model.response.ECPromotionPopHeader;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.ec.model.response.ECSkinData;
import com.bytedance.android.ec.model.response.n;
import com.bytedance.android.ec.model.response.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ql.a;

/* JADX INFO: loaded from: classes44.dex */
public class ECUIPromotion extends a implements Serializable {
    public static final long BUTTOM_ICON_WIDE_LONG = 1;
    public static final long BUTTOM_ICON_WIDE_SHORT = 0;
    public static final int DONT_SHOW_SALE_POINT = -1;
    public static final int HAS_POINT_HAS_EXCLUSIVE = 3;
    public static final int HAS_POINT_NO_EXCLUSIVE = 1;
    public static final long LIVE_TYPE_INSURANCE_REAL_ROOM = 1;
    public static final long LIVE_TYPE_RECORD_SAVE_ROOM = 2;
    public static final long LIVE_TYPE_UN_KNOW_ROOM = -1;
    public static final int NO_POINT_HAS_EXCLUSIVE = 2;
    public static final int NO_POINT_NO_EXCLUSIVE = 0;
    public static final long PRODUCT_TYPE_APPOINTMENT = 21;
    public static final long PRODUCT_TYPE_FINDGOOD = 19;
    public static final int PRODUCT_TYPE_NORMAL = 0;
    public static final long PRODUCT_TYPE_PRESELL = 30;
    public n addCartParams;
    public int appType;

    @SerializedName("auction_atmosphere")
    public ECAuctionAtmosphere auctionAtmosphere;

    @SerializedName("auction_v2")
    public ECAuctionInfo auctionV2;

    @SerializedName("background_button_icon")
    public String backgroundButtonIcon;
    public ECPromotionBottomBanner bottomBanner;
    public long buttomIconWide;
    public String buttonLabel;
    public ECUICampaign campaign;
    public boolean canExplain;
    public boolean canSold;
    public long carouselTime;
    public int checkedIndex;
    public String commentaryVideoData;
    public String directlyJumpUrl;
    public Long exposureTime;
    public ECPopExtendInfo extendInfo;
    public String findGoodsInfo;
    public String flashIcon;
    public ECPromotion.FlickerIcon flickerIconV2;
    public ECFloatWindowInfo floatWindowInfo;
    public String fragmentId;
    public ECGivenProductStruck givenProduct;
    public String gmv;
    public boolean hasCommentaryVideo;
    public boolean hasShowHaveSeenLabel;
    public boolean hideCart;
    public HotAtmosphereState hotAtmosphereState;
    public String imageUrl;
    public boolean inStock;
    public boolean isAuctionFast;
    public boolean isCampaign;
    public boolean isFromPlayback;
    public boolean isShowPopCardProductTag;
    public boolean isShowPopCardRightSimulateTag;
    public boolean isShowSimulateTag;
    public boolean isShowUserRightsTag;
    public int labelColor;
    public String labelIcon;
    public long liveRoomType;
    public long logicalClock;
    public String marketPrice;
    public String maxPrice;
    public String minPriceStr;
    public boolean needUpdate;
    private int newIronIndex;
    public String normalBottonIcon;
    public String opType;
    public String openDetailButtonText;
    public String orderNum;
    public String orderUrl;
    public int overlayType;
    public int platform;
    public ECUrlModel platformAtmosphere;
    public ECPromotionPopHeader popHeader;
    public String price;
    public ECPriceDescription priceDescription;
    public String priceHeader;
    public int productKind;
    public Long productType;
    public ll.a promotionHeader;
    public ECCurrentPromotion.a publicArea;
    public String qIvIcon;
    public ECSalePointCarouselData recommendPointData;
    public String replaceRelatedInfo;
    public ECPromotion.ReservationInfo reservationInfo;
    public long reserveMinPrice;
    public int roomType;
    public ECSalePointCarouselData salePointData;
    public List<String> shopSource;
    public String shortTitle;
    public long showDuration;
    public long showPriority;
    public boolean showSalePoint;
    public Long showTimestamp;
    public String similarLabel;
    public ECSkinData skinData;
    public ECUISmallPopCard smallPopCard;
    public String soldHint;
    public long soldNum;
    public Map<String, String> statusImgMap;
    public ECUrlModel statusImgUrl;
    public v stepperInfo;
    public long stockNum;
    public String tabName;
    public String title;
    public String titleLabel;
    public ECUrlModel topIcon;

    @SerializedName("transparent_button_icon")
    public String transparentBottonIcon;
    public String upDesc;
    public String userNum;

    public static class AtmosphereTopState implements Serializable {
        public List<ECPromotionInterationData> interactionData;
        public boolean interactionFull;

        public AtmosphereTopState() {
            this.interactionFull = false;
        }
    }

    public static class HotAtmosphereState implements Serializable {
        public boolean hasShown;
        public boolean isFold;
        public int lastNum;
        public int lastType;

        public void reset() {
            this.hasShown = false;
            this.lastNum = 0;
            this.isFold = false;
            this.lastType = 0;
        }

        public HotAtmosphereState() {
            this.hasShown = false;
            this.lastNum = 0;
            this.isFold = false;
            this.lastType = 0;
        }
    }

    public static int getECUIPromotionStatus(int r100, boolean r101, boolean r102) {
        if (r100 != 1) goto L7;
        return 4;
    L7:
        if (r100 != 2) goto L15;
        if (r101 == false) goto L13;
        if (r102 == false) goto L11;
        return 1;
    L11:
        return 5;
    L13:
        return 2;
    L15:
        if (r100 != 7000) goto L18;
        return 7000;
    L18:
        if (r100 != 8000) goto L21;
        return 8000;
    L21:
        if (r100 != 9000) goto L24;
        return 9000;
    L24:
        if (r100 != 10000) goto L27;
        return 10000;
    L27:
        if (r100 != 10) goto L30;
        return 10;
    L30:
        if (r100 >= 20000) goto L32;
        return 3;
    L32:
        if (r100 > 29999) goto L36;
        return r100;
    L36:
        return 3;
    }

    @Override // ql.a
    public boolean canShowAddCart() {
        if (this.hideCart == false) goto L5;
    L9:
        return false;
    L5:
        if (isFindGoods() == true) goto L9;
        if (shouldShowFindSimilar() == true) goto L9;
        return true;
    }

    public String getImageUrl() {
        String r100 = this.imageUrl;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    @Override // ql.a
    public String getLabelNameLive() {
        HashSet r100 = new HashSet();
        if (isPopCard() == false) goto L34;
        if (this.isShowPopCardRightSimulateTag == false) goto L13;
        List<ECRitTag> r101 = a("live_room_pop_biz_under");
        if (r101 == null) goto L13;
        Iterator<ECRitTag> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L13;
        addTagToSet(r100, r102.next().getLabelName());
    L13:
        if (this.isShowPopCardProductTag == true) goto L15;
    L21:
        ECPromotion.FlickerIcon r103 = this.flickerIconV2;
        if (r103 == null) goto L29;
        String r104 = r103.eventTag;
        if (r104 == null) goto L29;
        if (TextUtils.isEmpty(r104) == true) goto L29;
        addTagToSet(r100, this.flickerIconV2.eventTag);
    L29:
        if (TextUtils.isEmpty(getLiveLabelNameFromEventParams()) == true) goto L32;
        addTagToSet(r100, getLiveLabelNameFromEventParams());
    L32:
        return tagSetToString(r100);
    L15:
        if (getRitTag() == null) goto L21;
        List<ECRitTag> r105 = a("live_room_product_title_before");
        if (r105 == null) goto L21;
        if (r105.isEmpty() == true) goto L21;
        addTagToSet(r100, ((ECRitTag) ListProtector.get(r105, 0)).getLabelName());
        goto L21
    L34:
        if (this.isShowUserRightsTag == false) goto L46;
        if (getRitTag() == null) goto L46;
        List<ECRitTag> r106 = a("live_room_good_list_user_right");
        if (r106 == null) goto L46;
        Iterator<ECRitTag> r107 = r106.iterator();
    L41:
        if (r107.hasNext() == false) goto L46;
        ECRitTag r108 = r107.next();
        if (TextUtils.isEmpty(r108.getLabelName()) == true) goto L41;
        addTagToSet(r100, r108.getLabelName());
    L46:
        if (this.isShowSimulateTag == false) goto L58;
        if (getRitTag() == null) goto L58;
        List<ECRitTag> r109 = a("live_room_good_list_stimulate");
        if (r109 == null) goto L58;
        Iterator<ECRitTag> r110 = r109.iterator();
    L53:
        if (r110.hasNext() == false) goto L58;
        ECRitTag r111 = r110.next();
        if (TextUtils.isEmpty(r111.getLabelName()) == true) goto L53;
        addTagToSet(r100, r111.getLabelName());
    L58:
        if (getRitTag() == null) goto L68;
        if (a("live_room_product_title_before") == null) goto L68;
        Iterator<ECRitTag> r112 = a("live_room_product_title_before").iterator();
    L63:
        if (r112.hasNext() == false) goto L68;
        ECRitTag r113 = r112.next();
        if (TextUtils.isEmpty(r113.getLabelName()) == true) goto L63;
        addTagToSet(r100, r113.getLabelName());
    L68:
        if (getHasFlagShopTag() == false) goto L70;
        addTagToSet(r100, "flagship_shop");
    L70:
        List<String> r114 = getPromotionListHeaderLabelNames();
        if (r114 == null) goto L79;
        Iterator<String> r115 = r114.iterator();
    L74:
        if (r115.hasNext() == false) goto L79;
        String r116 = r115.next();
        if (TextUtils.isEmpty(r116) == true) goto L74;
        addTagToSet(r100, r116);
    L79:
        if (TextUtils.isEmpty(getLiveLabelNameFromEventParams()) == true) goto L81;
        addTagToSet(r100, getLiveLabelNameFromEventParams());
    L81:
        ECPromotion.FlickerIcon r117 = this.flickerIconV2;
        if (r117 != null) goto L84;
    L86:
        ECSalePointCarouselData r118 = getRealSalePointCarouselData();
        if (r118 == null) goto L99;
        if (r118.getData() == null) goto L99;
        Iterator<ECCarouselData> r119 = r118.getData().iterator();
    L92:
        if (r119.hasNext() == false) goto L99;
        ECCarouselData r120 = r119.next();
        if (r120.getEventParam() == null) goto L92;
        String r121 = r120.getEventParam().get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        if (r121 == null) goto L92;
        r100.add(r121);
    L99:
        return tagSetToString(r100);
    L84:
        if (TextUtils.isEmpty(r117.eventTag) == true) goto L86;
        r100.add(this.flickerIconV2.eventTag);
        goto L86
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getPrice */
    public String mo8153getPrice() {
        String r100 = this.price;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public ECSalePointCarouselData getRealSalePointCarouselData() {
        ECSalePointCarouselData r100 = this.salePointData;
        if (r100 == null) goto L21;
        if (r100.getData() == null) goto L21;
        if (isOnTopExplain() == true) goto L21;
        ECSalePointCarouselData r101 = new ECSalePointCarouselData(this.salePointData.getCarouselTime(), new ArrayList(), this.salePointData.getLeftIcon());
        Iterator<ECCarouselData> r102 = this.salePointData.getData().iterator();
    L11:
        if (r102.hasNext() == false) goto L19;
        ECCarouselData r103 = r102.next();
        if (r103.getType() == 1) goto L18;
        if (r103.getType() == 5) goto L18;
        if (r103.getType() != 6) goto L11;
    L18:
        r101.getData().add(r103);
        goto L11
    L19:
        return r101;
    L21:
        return this.salePointData;
    }

    @Override // ql.a
    public boolean isCrossborderProduct() {
        if (this.productKind != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFindGoods() {
        Long r100 = this.productType;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.longValue() != 19) goto L7;
        return true;
    }

    @Override // ql.a
    public boolean isFlash() {
        return !TextUtils.isEmpty(this.flashIcon);
    }

    public boolean isHourArrivedRoom() {
        if (this.roomType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInsuranceOrSaveRoom() {
        long r100 = this.liveRoomType;
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    public boolean isNormalProduct() {
        Long r100 = this.productType;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.longValue() == 0) goto L8;
        return false;
    }

    public boolean shouldShowGivenProduct() {
        if (this.givenProduct != null) goto L5;
    L9:
        return false;
    L5:
        if (isOnTopExplain() == false) goto L9;
        if (isOnSale() == false) goto L9;
        return true;
    }

    public void tryToUpdateIronIndexAndResetAskExplainInfo() {
        int r100 = this.newIronIndex;
        if (r100 <= (-1)) goto L8;
        if (r100 == getIronIndex()) goto L8;
        setIronIndex(this.newIronIndex);
        this.newIronIndex = -1;
    L8:
        if (isOnExplain() == true) goto L10;
        return;
    L10:
        if (getAskExplainInfo() != null) goto L12;
        return;
    L12:
        if (getAskExplainInfo().needResetAckExplainStatus() == false) goto L17;
        getAskExplainInfo().resetAckExplainStatus();
        return;
    }

    public ECUIPromotion() {
        this.canSold = true;
        this.similarLabel = "";
        this.isFromPlayback = false;
        this.exposureTime = 0L;
        this.showTimestamp = 0L;
        this.needUpdate = false;
        this.hasShowHaveSeenLabel = false;
        this.newIronIndex = -1;
        this.liveRoomType = -1;
        this.roomType = -1;
        this.showDuration = 10;
        this.publicArea = null;
        this.showSalePoint = false;
        this.carouselTime = 0;
        this.tabName = "default";
        this.isAuctionFast = false;
        this.isShowUserRightsTag = false;
        this.isShowSimulateTag = false;
        this.isShowPopCardRightSimulateTag = false;
        this.isShowPopCardProductTag = false;
    }

    public String getBorderImageUrl() {
        if (getRitTag() == null) goto L10;
        List<ECRitTag> r100 = a("live_room_product_border");
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return null;
    L9:
        return ((ECRitTag) ListProtector.get(r100, 0)).getFirstIconUrl();
    L10:
        return null;
    }

    public String getCampaignSubType() {
        ECUICampaign r100 = getCampaign();
        if (isAuction() == false) goto L10;
        if (r100 == null) goto L10;
        if (r100.auctionInfo.getStatus() != null) goto L36;
        return "";
    L36:
        return r100.auctionInfo.getStatus().toString();
    L10:
        ECPromotion.ReservationInfo r101 = this.reservationInfo;
        if (r101 == null) goto L21;
        int r102 = r101.hasReserved;
        if (r102 != 0) goto L15;
        return PromotionDepositPresaleActivity.WAIT_RESERVE;
    L15:
        if (r102 != 1) goto L37;
        return PromotionDepositPresaleActivity.RESERVED;
    L37:
        return null;
    L21:
        if (r100 == null) goto L27;
        if (r100.style != 10) goto L27;
        return PromotionDepositPresaleActivity.SALE;
    L27:
        if (isSecKill().booleanValue() == false) goto L31;
        return "shop";
    L31:
        if (isGoodsSubsidy() == false) goto L34;
        return "platform";
    L34:
        return null;
    }

    public Integer getCampaignType() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(r100.campaignType);
    }

    @Override // ql.a
    public Integer getCampainExtraType() {
        ECUICampaign r100 = getCampaign();
        if (isAuction() == false) goto L7;
        if (r100 != null) goto L6;
        return null;
    L6:
        return Integer.valueOf(r100.auctionInfo.getBizId());
    L7:
        return null;
    }

    @Override // ql.a
    public int getEcomGoodsStatus() {
        return getStatus();
    }

    public String getLotteryElasticTitleText() {
        if (isScarceLottery() == false) goto L7;
        String r100 = getLotteryInfo().getScarceLotteryElasticTitle();
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return r100;
    L9:
        return null;
    L7:
        return null;
    }

    public boolean isActivity() {
        if (getCampaign() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ql.a
    public boolean isAuction() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isAuction() == false) goto L7;
        return true;
    }

    @Override // ql.a
    public boolean isAuctionV2() {
        if (getAuctionV2() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBlocked() {
        if (getStatus() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCampaignActive() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.inCampaignTime() == false) goto L7;
        return true;
    }

    public boolean isCommonLottery() {
        if (getLotteryInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getLotteryInfo().isScarceLottery() == true) goto L7;
        return true;
    }

    public boolean isGoodsSubsidy() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isGoodsSubsidy().booleanValue() == false) goto L7;
        return true;
    }

    public boolean isInvalid() {
        if (getStatus() >= 20000) goto L5;
    L7:
        return false;
    L5:
        if (getStatus() > 29999) goto L7;
        return true;
    }

    public boolean isLimitBuy() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isLimitBuy() == false) goto L7;
        return true;
    }

    @Override // ql.a
    public boolean isLottery() {
        if (getLotteryInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOnExplain() {
        if (getExplainType() != 1) goto L5;
        return true;
    L5:
        if (getExplainType() == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isOnTopExplain() {
        if (getExplainType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ql.a
    public boolean isPreSale() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPreSale().booleanValue() == false) goto L7;
        return true;
    }

    public boolean isPreheat() {
        if (getStatus() != 7000) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPriceDeduce() {
        if (getStatus() != 9000) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPromotionNoStock() {
        if (getStatus() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPromotionRemoved() {
        if (getStatus() != 4) goto L5;
    L8:
        return true;
    L5:
        if (getStatus() == 3) goto L8;
        return false;
    }

    public boolean isScarceLottery() {
        if (getLotteryInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getLotteryInfo().isScarceLottery() == false) goto L7;
        return true;
    }

    public boolean isScarceLotteryFinish() {
        if (getLotteryInfo() != null) goto L5;
    L9:
        return false;
    L5:
        if (getLotteryInfo().isScarceLottery() == false) goto L9;
        if (getLotteryInfo().isScarceLotteryFinish() == false) goto L9;
        return true;
    }

    public Boolean isSecKill() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        return Boolean.valueOf(r101);
    L5:
        if (r100.isSecKill().booleanValue() == false) goto L7;
        r101 = true;
        goto L9
    }

    public boolean shouldCheckIfNotOnSale() {
        if (getJumpDestination() != null) goto L5;
    L7:
        return false;
    L5:
        if (getJumpDestination().getButton() != 7) goto L7;
        return true;
    }

    public boolean shouldShowFindSimilarWithOtherStore() {
        if (getStatus() != 10) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldShowSimulateTag() {
        if (getRitTag() != null) goto L5;
        return false;
    L5:
        List<ECRitTag> r100 = a("live_room_good_list_stimulate");
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.isEmpty() == false) goto L10;
        return false;
    L10:
        if (((ECRitTag) ListProtector.get(r100, 0)).getFirstIconUrl() != null) goto L12;
        return false;
    L12:
        if (((ECRitTag) ListProtector.get(r100, 0)).getFirstText() == null) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean shouldShowUserRightsTag() {
        if (getRitTag() != null) goto L5;
        return false;
    L5:
        List<ECRitTag> r100 = a("live_room_good_list_user_right");
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.isEmpty() == false) goto L10;
        return false;
    L10:
        if (((ECRitTag) ListProtector.get(r100, 0)).getFirstText() == null) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // ql.a
    public ECAuctionAtmosphere getAuctionAtmosphere() {
        return this.auctionAtmosphere;
    }

    @Override // ql.a
    public ECAuctionInfo getAuctionV2() {
        return this.auctionV2;
    }

    @Override // ql.a
    public ECUICampaign getCampaign() {
        return this.campaign;
    }

    @Override // ql.a
    public String getCover() {
        return this.imageUrl;
    }

    public String getMarketPrice() {
        return this.marketPrice;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getPriceHeader() {
        return this.priceHeader;
    }

    @Override // ql.a
    public v getStepperInfo() {
        return this.stepperInfo;
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getTitle */
    public String mo8154getTitle() {
        return this.title;
    }

    public final List<ECRitTag> a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        Map<String, List<ECRitTag>> r101 = getRitTag();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    L8:
        return null;
    }

    @Override // ql.a
    public boolean containsIconTag(String r100) {
        ECPromotion.FlickerIcon r101 = this.flickerIconV2;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r101.eventTag, r100) == false) goto L7;
        return true;
    }

    @Override // ql.a
    public void copyIconDataFromPromotion(a r100) {
        if ((r100 instanceof ECUIPromotion) == false) goto L6;
        this.flickerIconV2 = ((ECUIPromotion) r100).flickerIconV2;
        return;
    }

    public void setCampaign(ECUICampaign r100) {
        this.campaign = r100;
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L9;
    L11:
        if (r100 == null) goto L16;
        this.priceHeader = r100.priceHeader;
        return;
    L16:
        return;
    L9:
        if (r100.isPreheat().booleanValue() == false) goto L11;
        this.price = r100.price;
        this.maxPrice = r100.maxPrice;
        this.priceHeader = r100.priceHeader;
        this.marketPrice = r100.marketPrice;
        return;
    L5:
        if (r100.isGroup().booleanValue() == false) goto L7;
        this.price = r100.price;
    }

    @Override // ql.a
    public void setCover(String r100) {
        this.imageUrl = r100;
    }

    public void setIsInsurance(Map<String, String> r100) {
        if (r100 != null) goto L4;
    L6:
        super.setInsuranceProduct(false);
        return;
    L4:
        if (TextUtils.equals(r100.get("insurance_commodity_flag"), "1") == false) goto L6;
        super.setInsuranceProduct(true);
    }

    public void setNeedUpdateIronIndex(int r100) {
        this.newIronIndex = r100;
    }

    public void setShowSalePoint(Boolean r100) {
        this.showSalePoint = r100.booleanValue();
    }

    @Override // ql.a
    public void setTitle(String r100) {
        this.title = r100;
    }

    @Override // ql.a
    public void updateHotAtmosphere(ECHotAtmosphere r100) {
        setHotAtmosphere(r100);
    }

    public void updateStatus(boolean r100, boolean r101) {
        this.inStock = r100;
        this.canSold = r101;
        if (getStatus() != 1) goto L5;
    L8:
        if (r100 == false) goto L12;
        if (r101 == false) goto L11;
        setStatus(1);
        return;
    L11:
        setStatus(5);
        return;
    L12:
        setStatus(2);
        return;
    L5:
        if (getStatus() == 5) goto L8;
        if (getStatus() == 2) goto L8;
    }
}
