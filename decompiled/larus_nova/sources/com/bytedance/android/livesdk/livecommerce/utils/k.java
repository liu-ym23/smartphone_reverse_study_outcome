package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionAskExplainInfo;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.response.ECPromotionLotteryInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdk.livecommerce.model.ECUISkuInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingDialog;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f153092a = null;

    static {
        f153092a = new Handler(Looper.getMainLooper());
    }

    public static si2.p b(xi2.l r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        si2.p r101 = new si2.p();
        r101.f542198j = r100.couponMetaId;
        int r102 = r100.type;
        boolean r103 = false;
        if (r102 > 0) goto L8;
    L10:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L15;
        r101.f542189a = 1;
        r101.f542190b = r100.discount;
    L30:
        r101.f542193e = r100.startTime + "-" + r100.expireTime;
        r101.f542194f = r100.periodType;
        r101.f542195g = r100.validPeriod;
        r101.f542196h = r100.typeString;
        r101.f542202n = r100.shopId;
        r101.f542197i = r100.leftAmount;
        if (r100.status != 3) goto L33;
        r103 = true;
    L33:
        r101.f542199k = r103;
        r101.f542200l = r100.liveCouponStatus;
        r101.f542201m = r100.couponSource;
        r101.f542203o = r100.typeIcon;
        r101.f542204p = r100.typeIconWidth;
        r101.f542205q = r100.typeIconHeight;
        r101.f542206r = r100.kolUserTag;
        return r101;
    L15:
        if (r102 > 0) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L22;
        r101.f542189a = 2;
        r101.f542191c = r100.credit / 100;
        goto L30
    L22:
        if (r102 > 0) goto L24;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L29;
        r101.f542189a = 3;
        r101.f542191c = r100.credit / 100;
        r101.f542192d = r100.threshold / 100;
        goto L30
    L29:
        r101.f542191c = r100.credit / 100;
        r101.f542192d = r100.threshold / 100;
        goto L30
    L24:
        if ((r102 % 10) != 3) goto L26;
        r106 = true;
        goto L27
    L17:
        if ((r102 % 10) != 2) goto L19;
        r105 = true;
        goto L20
    L8:
        if ((r102 % 10) != 1) goto L10;
        r104 = true;
        goto L12
    }

    public static ECPromotion c(ECCurrentPromotion r100) {
        ECPromotion r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        l(r100.a(), r100.extraParam);
        if (r100.a() != null) goto L8;
    L34:
        return r101;
    L8:
        if (r100.a().size() <= 0) goto L34;
        List<ECPromotion> r102 = r100.a();
        if (r102 == null) goto L13;
        r101 = (ECPromotion) ListProtector.get(r102, 0);
    L13:
        if (r101 == null) goto L34;
        r101.statusCode = r100.statusCode;
        r101.statusMessage = r100.statusMessage;
        ECCurrentPromotion.CommodityIcon r103 = r100.commodityIconInfo;
        if (r103 == null) goto L17;
        r101.productType = r103.productType;
        r101.upIcon = r103.upIcon;
        r101.bottomIcon = r103.bottomIcon;
        r101.buttomIconWide = r103.buttomIconWide;
        r101.liveRoomType = r103.liveRoomType;
        r101.upDesc = r103.upDesc;
        r101.topIcon = r103.topIcon;
        r101.upIconTagTrack = r103.upIconTagTrack;
        r101.background = r103.background;
    L17:
        r101.showDuration = r100.showDuration;
        r101.carouselTime = r100.carouselTime;
        r101.rawCampaign = r100.campaign;
        r101.serverTime = r100.serverTime;
        r101.logicalClock = r100.logicalClock;
        r101.floatWindowInfo = r100.floatWindowInfo;
        r101.extendInfo = r100.extendInfo;
        r101.roomType = r100.roomType;
        r101.isRetry = r100.f47901a;
        r101.publicArea = r100.publicArea;
        r101.skinData = r100.skinData;
        r101.showPriority = r100.showPriority;
        r101.replaceRelatedInfo = r100.replaceRelatedInfo;
        ECCurrentPromotion.b r104 = r100.extra;
        if (r104 == null) goto L21;
        r101.logid = r104.logid;
    L21:
        if (r100.roomInfo == null) goto L34;
        if (r101.eventParams != null) goto L25;
        r101.eventParams = new HashMap();
    L25:
        r101.eventParams.put(IPerformanceManager.Params.room_type, String.valueOf(r100.roomInfo.getRoomType()));
        r101.eventParams.put("instant_room_type", String.valueOf(r100.roomInfo.getInstantRoomType()));
        if (r100.roomInfo.getReceiveAddressId() == null) goto L29;
        r101.eventParams.put("receive_address_id", r100.roomInfo.getReceiveAddressId());
    L29:
        if (r100.roomInfo.getAddressType() == null) goto L32;
        r101.eventParams.put("address_type", r100.roomInfo.getAddressType());
    L32:
        if (r100.roomInfo.getAddressStrategy() == null) goto L34;
        r101.eventParams.put("address_strategy_type", r100.roomInfo.getAddressStrategy());
        goto L34
    }

    public static String g(long r100) {
        if ((r100 % 100) != 0) goto L7;
        return String.valueOf(r100 / 100);
    L7:
        if ((r100 % 10) != 0) goto L11;
        return String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(r100 / 100.0d)});
    L11:
        return String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(r100 / 100.0d)});
    }

    public static void h(int r100) {
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L6;
        r102.notifyPushStream(r100);
        return;
    }

    public static boolean a(ECPromotionCampaign r100, long r101) {
        if (r100 != null) goto L4;
    L20:
        return false;
    L4:
        if (TextUtils.isEmpty(r100.promotionId) == true) goto L20;
        if (r100.price > 0) goto L10;
        if (r100.auctionInfo == null) goto L20;
    L10:
        if (r101 <= 0) goto L20;
        long r102 = r100.startTime;
        if (r102 <= 0) goto L20;
        long r103 = r100.endTime;
        if (r103 <= 0) goto L20;
        if (r103 <= r102) goto L20;
        if (r103 <= r101) goto L20;
        return true;
    }

    public static ECUIPromotion e(ECPromotion r100, Boolean r101) {
        return d(r100, com.bytedance.android.livesdk.livecommerce.room.f.a(), 0, r101);
    }

    public static void i(Context r100, String r101) {
        if (ECDisplayUtils.c(r100) == true) goto L5;
    L15:
        com.bytedance.android.livesdk.livecommerce.room.f.b(r100, r101);
        return;
    L5:
        if (r101.contains("as_panel") == false) goto L15;
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r102, "as_panel")) == false) goto L10;
        Uri.Builder r103 = r102.buildUpon();     // Catch: Exception -> L12
        r103.appendQueryParameter("as_panel", "0");     // Catch: Exception -> L12
        r101 = r103.build().toString();     // Catch: Exception -> L12
    L17:
    L14:
        com.bytedance.android.livesdk.livecommerce.room.f.b(r100, r101);
        return;
    L10:
        r101 = com.bytedance.android.livesdk.livecommerce.event.l0.u(r102).toString();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L14
    }

    public static void j(Context r100, String r101) {
        HashMap r102 = new HashMap(com.bytedance.android.livesdk.livecommerce.event.l0.g());
        if (ECDisplayUtils.c(r100) == true) goto L5;
        String r103 = "0";
    L6:
        r102.put("screen_type", r103);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, "");
        Uri r104 = UriProtector.parse(r101);     // Catch: Exception -> L22
        String r105 = UriProtector.getQueryParameter(r104, "v3_events_additions");     // Catch: Exception -> L22
        if (r105 != null) goto L10;
    L11:
        r105 = SliceInitService.DEFAULT_SWITCH;
    L12:
        JSONObject r106 = new JSONObject(r105);     // Catch: Exception -> L22
        Iterator r107 = r102.entrySet().iterator();     // Catch: Exception -> L22
    L14:
        if (r107.hasNext() == false) goto L20;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Exception -> L22
        if (r108.getKey() == null) goto L14;
        if (r108.getValue() == null) goto L14;
        r106.put((String) r108.getKey(), r108.getValue());     // Catch: Exception -> L22
        goto L14
    L20:
        r101 = com.bytedance.android.livesdk.livecommerce.event.l0.t(r104, "v3_events_additions", r106.toString()).toString();     // Catch: Exception -> L22
    L24:
        com.bytedance.android.livesdk.livecommerce.room.f.b(r100, r101);
        return;
    L10:
        if (r105.isEmpty() == false) goto L12;
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L24
    L5:
        r103 = "1";
        goto L6
    }

    public static void k(List r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        Iterator r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L22;
        ECPromotion r103 = (ECPromotion) r102.next();
        if (r103 == null) goto L10;
        r103.logid = r101;
        goto L10
    L22:
        return;
    }

    public static void l(List<ECPromotion> r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        Iterator<ECPromotion> r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L22;
        ECPromotion r103 = r102.next();
        if (r103 == null) goto L10;
        r103.detailUrl += "&" + r101;
        goto L10
    L22:
        return;
    }

    public static ECLoadingDialog m(Context r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ECLoadingDialog r102 = new ECLoadingDialog(r100);
        r102.setDialogCancelable(false);
        r102.setCancelable(false);
        r102.setCanceledOnTouchOutside(false);
        r102.setShowCloseBtn(false);
        r102.setMessage(r101);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r102);
    L10:
        return r102;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L10
    }

    public static void n(Context r100, String r101) {
        ECToast.INSTANCE.showToast(r100, r101, Boolean.TRUE);
    }

    public static ECUISkuInfo f(ql.a r100, String r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ECUISkuInfo r103 = new ECUISkuInfo();
        r103.f149461f = r100.getPromotionId();
        r103.f149464i = r102;
        r100.mo8153getPrice();
        r103.f149465j = r101;
        r103.f149470o = r100.getEventItemType();
        r103.f149472q = r100.getEventParams();
        r103.f149463h = r100.getProductId();
        r103.f149462g = r100.getShopId();
        r103.f149473r = r100.getApplyCoupon();
        r103.f149475t = r100.getShowNotice();
        r103.f149476u = r100.getActivity();
        r103.f149456a = r100.getOriginId();
        r103.f149457b = r100.getOriginType();
        r100.getCanAddShopCart();
        r103.f149458c = r100.getSingleSku();
        r100.isOnSale();
        String r104 = r100.getTrackExtra();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f149459d = r104;
        r103.f149477v = r100.getAskExplainInfo();
        r103.f149460e = r100.getCampaign();
        r103.f149478w = r100.isMultiGroupBuy();
        return r103;
    }

    public static ECUIPromotion d(ECPromotion r410, Context r411, long r412, Boolean r413) {
        if (r410 != null) goto L5;
        return null;
    L5:
        ECUIPromotion r100 = new ECUIPromotion();
        r100.setCanAddShopCart(r410.canAddShopCart);
        r100.setSingleSku(r410.singleSku);
        r100.hideCart = r410.hideCart;
        String r101 = r410.promotionId;
        String r102 = "";
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r100.setPromotionId(r101);
        r100.setCover(r410.cover);
        r100.setDetailCover(r410.detailCover);
        r100.title = r410.title;
        r100.setEventItemType(String.valueOf(r410.itemType));
        boolean r103 = r410.inStock;
        r100.inStock = r103;
        boolean r104 = r410.canSold;
        r100.canSold = r104;
        r100.setStatus(ECUIPromotion.getECUIPromotionStatus(r410.status, r103, r104));
        r100.soldHint = r410.soldHint;
        r100.setEventLabel("normal");
        r100.titleLabel = r410.platformLabel;
        r100.platformAtmosphere = r410.platformAtmosphere;
        r100.canExplain = r410.canExplain;
        r100.fragmentId = r410.fragmentId;
        if (r411 == null) goto L12;
        Resources r105 = th.a.f(r411);
        r100.labelColor = r105.getColor(R.color.ec_color_label);
        r100.openDetailButtonText = r105.getString(R.string.ec_open_detail, new Object[]{""});
    L12:
        r100.setScheme(r410.detailUrl);
        ECPromotion.Extra r106 = r410.extra;
        if (r106 == null) goto L16;
        r100.setOriginId(r106.originId);
        r100.setOriginType(r410.extra.originType);
        r100.setShowNotice(r410.extra.showNotice);
        r100.setCouponMinPrice(r410.extra.couponMinPrice);
    L16:
        if (r410.extra != null) goto L156;
    L59:
        int r107 = n0.f153102a;
        String r108 = r100.getTrackExtra();
        int r109 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;
        r100.setTrackExtra(n0.a(r108, "ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b()));
        ECPromotion.AuthorStat r110 = r410.authorStat;
        if (r110 == null) goto L62;
        r100.gmv = r110.gmv;
        r100.orderNum = r110.orderNum;
        r100.userNum = r110.userNum;
    L62:
        r100.setBenefitLabels(r410.benefitLabels);
        r100.buttonLabel = r410.buttonLabel;
        r100.flashIcon = r410.flashIcon;
        r100.labelIcon = r410.labelIcon;
        r100.flickerIconV2 = r410.flickerIconV2;
        r100.stockNum = r410.stockNum;
        r100.soldNum = r410.soldNum;
        r100.setIronIndex(r410.index);
        r100.setRealIndex(r410.realIndex);
        r100.opType = r410.opType;
        boolean r111 = r410.campaign;
        r100.isCampaign = r111;
        if (r111 == true) goto L65;
    L67:
        r100.setEventParams(r410.eventParams);
        r100.setStandardEventTrack(r410.standardEventTrack);
        r100.processEventParams();
        r100.shortTitle = r410.shortTitle;
        r100.setFlashType(r410.flashType);
        ECPromotion.ECActivityResponse r112 = r410.activity;
        if (r112 != null) goto L70;
        ECUIActivity r113 = null;
    L71:
        r100.setActivity(r113);
        ECPromotionAskExplainInfo r114 = r410.askExplainInfo;
        if (r114 != null) goto L74;
        ECUIAskExplainInfo r115 = null;
    L75:
        r100.setAskExplainInfo(r115);
        r100.statusImgUrl = r410.statusImgUrl;
        if (r410.lottery == false) goto L82;
        ECPromotionLotteryInfo r116 = r410.lotteryInfo;
        if (r116 != null) goto L80;
        ECUILotteryInfo r117 = null;
    L81:
        r100.setLotteryInfo(r117);
        goto L82
    L80:
        long r118 = SystemClock.elapsedRealtime();
        r117 = new ECUILotteryInfo(r116.getActivityId(), r116.getLotteryType(), r116.getTaskType(), ((r116.getOpenTime() * 1000) + r118) - (r116.getServerTime() * 1000), r116.getUserActivityStatus(), r116.getWinRecordId(), r116.getResultLabel(), r116.getButtonLabel(), r116.getText(), r116.getJumpUrl(), r116.getShortPic(), (r118 + (r116.getBuyTime() * 1000)) - (r116.getServerTime() * 1000), r116.getElasticTitle(), r116.getBenefitLabel());
    L82:
        r100.platform = r410.platform;
        r100.setProductId(r410.productId);
        r100.setChannelId(r410.channelId);
        r100.setChannelType(Integer.valueOf(r410.channelType));
        String r119 = r410.shopId;
        if (r119 == null) goto L85;
        r100.setShopId(r119);
    L85:
        r100.shopSource = r410.shopSource;
        r100.setApplyCoupon(r410.applyCoupon);
        r100.statusImgMap = r410.statusImgMap;
        ECPromotion.SmallPopCard r120 = r410.smallPopCard;
        ECCurrentPromotion.PopBackground r121 = r410.background;
        if (r120 != null) goto L88;
        ECUISmallPopCard r122 = null;
    L92:
        r100.smallPopCard = r122;
        int r123 = b0.f153064a;
        Intrinsics.checkNotNullParameter(r410, "promotion");
        String r124 = g(r410.minPrice);
        if (r124 != null) goto L95;
        r124 = "";
    L95:
        r100.price = r124;
        r100.minPriceStr = r410.minPriceStr;
        Intrinsics.checkNotNullParameter(r410, "promotion");
        String r125 = g(r410.maxPrice);
        if (r125 != null) goto L98;
        r125 = "";
    L98:
        r100.maxPrice = r125;
        Intrinsics.checkNotNullParameter(r410, "promotion");
        String r126 = g(r410.marketPrice);
        if (r126 != null) goto L101;
        r126 = "";
    L101:
        r100.marketPrice = r126;
        r100.priceDescription = r410.priceDescription;
        if (r100.isScarceLottery() == false) goto L104;
        r100.marketPrice = null;
    L104:
        Intrinsics.checkNotNullParameter(r410, "promotion");
        String r127 = r410.priceHeader;
        if (r127 == null) goto L108;
        r102 = r127;
    L108:
        r100.priceHeader = r102;
        ECPromotion.Extra r128 = r410.extra;
        if (r128 == null) goto L111;
        r100.setHasDiscountPrice(r128.hasDiscountPrice);
    L111:
        r100.hasCommentaryVideo = r410.hasCommentaryVideo;
        r100.commentaryVideoData = r410.commentaryVideoData;
        r100.productKind = r410.productKind;
        r100.setExplainType(r410.explainType);
        r100.setIsInsurance(r410.eventParams);
        r100.setRitTag(r410.ritTags);
        r100.isAuctionFast = r410.isAuction;
        r100.qIvIcon = r410.upIcon;
        r100.upDesc = r410.upDesc;
        r100.topIcon = r410.topIcon;
        r100.setUpIconTagTrack(r410.upIconTagTrack);
        r100.setBackground(r410.background);
        Map<String, String> r129 = r410.bottomIcon;
        if (r129 == null) goto L114;
        r100.transparentBottonIcon = r129.get(ECPromotion.TRANSPARENT_BOTTON_ICON);
        r100.normalBottonIcon = r410.bottomIcon.get("normal");
        r100.backgroundButtonIcon = r410.bottomIcon.get("background");
    L115:
        r100.productType = Long.valueOf(r410.productType);
        if (r410.reservationInfo == null) goto L118;
        r100.productType = 21L;
        r100.reservationInfo = r410.reservationInfo;
        r100.reserveMinPrice = r410.minPrice;
    L118:
        String r130 = r410.findGoodsInfo;
        if (r130 != null) goto L121;
    L123:
        r100.findGoodsInfo = r410.findGoodsInfo;
        r100.buttomIconWide = r410.buttomIconWide;
        if (a(r410.rawCampaign, r410.serverTime) == false) goto L126;
        r100.campaign = ECUICampaign.convertCampaign(r410.rawCampaign, r410.serverTime);
    L126:
        r100.liveRoomType = r410.liveRoomType;
        r100.roomType = r410.roomType;
        long r131 = r410.showDuration;
        if (r131 <= 0) goto L129;
        r100.showDuration = r131 / 1000;
    L133:
        r100.publicArea = r410.publicArea;
    L144:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L146:
        r100.orderUrl = r410.orderUrl;
        r100.setJumpDestination(r410.jumpDestination);
        r100.setHotAtmosphere(r410.hotAtmosphere);
        r100.setAtmosphere(r410.atmosphere);
        r100.logicalClock = r410.logicalClock;
        r100.directlyJumpUrl = r410.directlyJumpUrl;
        r100.popHeader = r410.pop3DHeader;
        r100.bottomBanner = r410.bottomBanner;
        r100.setCombination(r410.combination);
        r100.setHasPriceModule(r410.hasPriceModule);
        r100.setForcePriceModule(r410.forcePriceModule);
        r100.setPromotionBottom(r410.promotionBottom);
        r100.floatWindowInfo = r410.floatWindowInfo;
        r100.carouselTime = r410.carouselTime;
        r100.setLogid(r410.logid);
        r100.setLeafCategory(r410.leafCategory);
        r100.setCategoryData(r410.categoryData);
        r100.salePointData = r410.salePointData;
        r100.recommendPointData = r410.recommendPointData;
        r100.givenProduct = r410.givenProduct;
        r100.promotionHeader = r410.promotionHeader;
        r100.stepperInfo = r410.stepperInfo;
        r100.setDynamicRecommendIndex(r410.dynamicRecommendIndex);
        r100.skinData = r410.skinData;
        r100.overlayType = r410.overlayType;
        r100.addCartParams = r410.addCartParams;
        r100.showPriority = r410.showPriority;
        r100.replaceRelatedInfo = r410.replaceRelatedInfo;
        r100.setBizIdentity(r410.bizIdentity);
        r100.setCheckCallback(r410.checkCallback);
        r100.auctionV2 = r410.auctionV2;
        r100.auctionAtmosphere = r410.auctionAtmosphere;
        r100.extendInfo = r410.extendInfo;
        r100.setPrefetchOrder(r410.prefetchOrder);
        long r132 = r100.logicalClock;
        if (r132 <= 0) goto L149;
        int r133 = wl.a.f560165b;
        long r134 = System.currentTimeMillis() - r132;
    L150:
        wl.a.f560164a = r134;
        ECUICampaign r135 = r100.campaign;
        if (r135 == null) goto L153;
        r100.setAuctionInfo(r135.auctionInfo);
        r100.setMultiGroupBuy(r100.campaign.isMultiGroupBuy().booleanValue());
    L153:
        return r100;
    L149:
        r134 = 0;
        goto L150
    L135:
        if (r413.booleanValue() == false) goto L138;
        JSONObject r136 = new JSONObject();     // Catch: Exception -> L144
        int r137 = RoomContextController.f151593h;     // Catch: Exception -> L144
        RoomContextController r138 = RoomContextController.a.a();     // Catch: Exception -> L144
        r136.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());     // Catch: Exception -> L144
        r136.put("anchor_id", r138.y());     // Catch: Exception -> L144
        r136.put("room_id", r138.B());     // Catch: Exception -> L144
        r100.setExtraTransmissibleLogParams(r136);     // Catch: Exception -> L144
    L140:
        JSONObject r139 = r100.getExtraTransmissibleLogParams();     // Catch: Exception -> L144
        if (r139 == null) goto L146;
        r139.put("show_dou_campaign", 0);     // Catch: Exception -> L144
        r139.put("is_retry", r410.isRetry);     // Catch: Exception -> L144
        goto L146
    L138:
        if (r100.getExtraTransmissibleLogParams() != null) goto L140;
        r100.setExtraTransmissibleLogParams(new JSONObject());     // Catch: Exception -> L144
        goto L140
    L129:
        if (r131 != 0) goto L131;
        r100.showDuration = 10;
        goto L133
    L131:
        if (r131 >= 0) goto L133;
        r100.showDuration = -1;
        goto L133
    L121:
        if (r130.isEmpty() == true) goto L123;
        r100.productType = 19L;
        goto L123
    L114:
        r100.normalBottonIcon = null;
        r100.transparentBottonIcon = null;
        goto L115
    L88:
        r122 = new ECUISmallPopCard();
        r122.backgroundImg = r120.backgroundImg;
        String r140 = r120.backgroundImgNew;
        if (r121 == null) goto L91;
        r140 = r121.image;
    L91:
        r122.backgroundImgNew = r140;
        r122.headerImg = r120.headerImg;
        r122.buttonLabel = r120.buttonLabel;
        r122.headerLabel = r120.headerLabel;
        goto L92
    L74:
        r115 = new ECUIAskExplainInfo(r114.getStatus(), r114.getUserCount(), r114.getRank(), r114.getRankIconUrl(), r114.getCanAskExplain());
        goto L75
    L70:
        r113 = new ECUIActivity(r112.activityIcon, r112.activityType, r112.activityId, r112.activityBanner, r112.activityBannerLandscape, r112.activityBannerSmall);
        goto L71
    L65:
        if (a(r410.campaignInfo, r412) == false) goto L67;
        r100.setCampaign(ECUICampaign.convertCampaign(r410.campaignInfo, r412, 0));
        goto L67
    L156:
        JSONObject r141 = new JSONObject(com.bytedance.android.livesdk.livecommerce.event.l0.c());     // Catch: Exception -> L49
        Lazy r142 = ExtraController.f151511l;     // Catch: Exception -> L49
        ExtraController r143 = ControllerCenter.c(null, null).f151430u;     // Catch: Exception -> L49
        Objects.toString(r143);     // Catch: Exception -> L49
        JSONObject r144 = r143.H();     // Catch: Exception -> L49
        if (r144 != null) goto L21;
    L35:
        fh2.a r145 = PromotionListController.H();     // Catch: Exception -> L49
        if (r145 == null) goto L43;
        String r146 = ((LivePromotionListFragment) r145).ea0();     // Catch: Exception -> L49
        if (r146 == null) goto L43;
        JSONObject r147 = new JSONObject(r146);     // Catch: Exception -> L41
    L44:
        if (r147 != null) goto L46;
    L51:
        Map<String, String> r148 = r410.eventParams;
        if (r148 != null) goto L154;
    L58:
        int r149 = n0.f153102a;
        r100.setTrackExtra(n0.a(r410.extra.trackExtra, "cart_track", r141.toString()));
        goto L59
    L154:
        r141.put("store_id", r148.get("store_id"));     // Catch: Exception -> L56
        r141.put("live_business_type", r148.get("live_business_type"));     // Catch: Exception -> L56
    L56:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L58
    L46:
        if (r147.has(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL) == false) goto L51;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, r147.optString(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL));     // Catch: Exception -> L49
        goto L51
    L41:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L49
    L43:
        r147 = null;
        goto L44
    L21:
        if (r144.has(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE) == false) goto L24;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r144.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE));     // Catch: Exception -> L49
    L24:
        if (r144.has(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE) == false) goto L27;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r144.optString(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE));     // Catch: Exception -> L49
    L27:
        if (r144.has(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE) == false) goto L30;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r144.optString(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE));     // Catch: Exception -> L49
    L30:
        if (r144.has(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD) == false) goto L33;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r144.optString(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD));     // Catch: Exception -> L49
    L33:
        if (r144.has(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE) == false) goto L35;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r144.optString(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE));     // Catch: Exception -> L49
    L49:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r141 = new JSONObject();
        goto L51
    }
}
