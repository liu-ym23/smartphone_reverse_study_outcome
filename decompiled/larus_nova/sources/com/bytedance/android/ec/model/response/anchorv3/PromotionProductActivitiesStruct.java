package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010?\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010*\"\u0004\bA\u0010,R \u0010B\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010H\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR \u0010K\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010R8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR \u0010U\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010[\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006a"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductActivitiesStruct;", "Ljava/io/Serializable;", "()V", "activityStyle", "", "getActivityStyle", "()I", "setActivityStyle", "(I)V", "appointActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;", "getAppointActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;", "setAppointActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;)V", "auctionActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/AuctionInfoStruct;", "getAuctionActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuctionInfoStruct;", "setAuctionActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/AuctionInfoStruct;)V", "commonGirdle", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "getCommonGirdle", "()Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "setCommonGirdle", "(Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;)V", "commonGirdleV2", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2;", "getCommonGirdleV2", "()Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2;", "setCommonGirdleV2", "(Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2;)V", "depositPresaleActivity", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "getDepositPresaleActivity", "()Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "setDepositPresaleActivity", "(Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;)V", "groupInfoActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "getGroupInfoActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "setGroupInfoActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;)V", "ipActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;", "getIpActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;", "setIpActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;)V", "memberSample", "Lcom/bytedance/android/ec/model/response/anchorv3/MemberSampleActivityStruct;", "getMemberSample", "()Lcom/bytedance/android/ec/model/response/anchorv3/MemberSampleActivityStruct;", "setMemberSample", "(Lcom/bytedance/android/ec/model/response/anchorv3/MemberSampleActivityStruct;)V", "mfPromotionEvent", "Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;", "getMfPromotionEvent", "()Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;", "setMfPromotionEvent", "(Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;)V", "nGroupInfoActivity", "getNGroupInfoActivity", "setNGroupInfoActivity", "platformBannerActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;", "getPlatformBannerActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;", "setPlatformBannerActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;)V", "platformTextActivity", "getPlatformTextActivity", "setPlatformTextActivity", "presaleActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;", "getPresaleActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;", "setPresaleActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;)V", "qualificationBuy", "Lcom/bytedance/android/ec/model/response/anchorv3/QualificationBuyStruct;", "getQualificationBuy", "()Lcom/bytedance/android/ec/model/response/anchorv3/QualificationBuyStruct;", "secKillActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", "getSecKillActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", "setSecKillActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;)V", "subsidizedActivity", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "getSubsidizedActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "setSubsidizedActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductActivitiesStruct implements Serializable {

    @SerializedName("inner_flow_activity_style")
    private int activityStyle;

    @SerializedName("appoint_activity")
    private PromotionAppointment appointActivity;

    @SerializedName("auction_activity")
    private AuctionInfoStruct auctionActivity;

    @SerializedName("common_girdle")
    private CommonGirdleStruct commonGirdle;

    @SerializedName("common_girdle_v2")
    private CommonGirdleStructV2 commonGirdleV2;

    @SerializedName("deposit_presale_activity")
    private PromotionDepositPresaleActivity depositPresaleActivity;

    @SerializedName("group_info")
    private GroupInfo groupInfoActivity;

    @SerializedName("ip_activity")
    private PromotionIPActivity ipActivity;

    @SerializedName("member_sample")
    private MemberSampleActivityStruct memberSample;

    @SerializedName("mf_promotion_event")
    private MFPromotionEvent mfPromotionEvent;

    @SerializedName("n_group_buy_info")
    private GroupInfo nGroupInfoActivity;

    @SerializedName("platform_banner_activity")
    private PromotionMarketFloor platformBannerActivity;

    @SerializedName("platform_text_activity")
    private PromotionMarketFloor platformTextActivity;

    @SerializedName("presale_activity")
    private PromotionPreSale presaleActivity;

    @SerializedName("qualification_buy")
    private final QualificationBuyStruct qualificationBuy;

    @SerializedName("sec_kill_activity")
    private SeckillInfo secKillActivity;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SUBSIDIZED_ACTIVITY)
    private PromotionSubsidizedActivity subsidizedActivity;

    public PromotionProductActivitiesStruct() {
    }

    public final int getActivityStyle() {
        return this.activityStyle;
    }

    public final PromotionAppointment getAppointActivity() {
        return this.appointActivity;
    }

    public final AuctionInfoStruct getAuctionActivity() {
        return this.auctionActivity;
    }

    public final CommonGirdleStruct getCommonGirdle() {
        return this.commonGirdle;
    }

    public final CommonGirdleStructV2 getCommonGirdleV2() {
        return this.commonGirdleV2;
    }

    public final PromotionDepositPresaleActivity getDepositPresaleActivity() {
        return this.depositPresaleActivity;
    }

    public final GroupInfo getGroupInfoActivity() {
        return this.groupInfoActivity;
    }

    public final PromotionIPActivity getIpActivity() {
        return this.ipActivity;
    }

    public final MemberSampleActivityStruct getMemberSample() {
        return this.memberSample;
    }

    public final MFPromotionEvent getMfPromotionEvent() {
        return this.mfPromotionEvent;
    }

    public final GroupInfo getNGroupInfoActivity() {
        return this.nGroupInfoActivity;
    }

    public final PromotionMarketFloor getPlatformBannerActivity() {
        return this.platformBannerActivity;
    }

    public final PromotionMarketFloor getPlatformTextActivity() {
        return this.platformTextActivity;
    }

    public final PromotionPreSale getPresaleActivity() {
        return this.presaleActivity;
    }

    public final QualificationBuyStruct getQualificationBuy() {
        return this.qualificationBuy;
    }

    public final SeckillInfo getSecKillActivity() {
        return this.secKillActivity;
    }

    public final PromotionSubsidizedActivity getSubsidizedActivity() {
        return this.subsidizedActivity;
    }

    public final void setActivityStyle(int r100) {
        this.activityStyle = r100;
    }

    public final void setAppointActivity(PromotionAppointment r100) {
        this.appointActivity = r100;
    }

    public final void setAuctionActivity(AuctionInfoStruct r100) {
        this.auctionActivity = r100;
    }

    public final void setCommonGirdle(CommonGirdleStruct r100) {
        this.commonGirdle = r100;
    }

    public final void setCommonGirdleV2(CommonGirdleStructV2 r100) {
        this.commonGirdleV2 = r100;
    }

    public final void setDepositPresaleActivity(PromotionDepositPresaleActivity r100) {
        this.depositPresaleActivity = r100;
    }

    public final void setGroupInfoActivity(GroupInfo r100) {
        this.groupInfoActivity = r100;
    }

    public final void setIpActivity(PromotionIPActivity r100) {
        this.ipActivity = r100;
    }

    public final void setMemberSample(MemberSampleActivityStruct r100) {
        this.memberSample = r100;
    }

    public final void setMfPromotionEvent(MFPromotionEvent r100) {
        this.mfPromotionEvent = r100;
    }

    public final void setNGroupInfoActivity(GroupInfo r100) {
        this.nGroupInfoActivity = r100;
    }

    public final void setPlatformBannerActivity(PromotionMarketFloor r100) {
        this.platformBannerActivity = r100;
    }

    public final void setPlatformTextActivity(PromotionMarketFloor r100) {
        this.platformTextActivity = r100;
    }

    public final void setPresaleActivity(PromotionPreSale r100) {
        this.presaleActivity = r100;
    }

    public final void setSecKillActivity(SeckillInfo r100) {
        this.secKillActivity = r100;
    }

    public final void setSubsidizedActivity(PromotionSubsidizedActivity r100) {
        this.subsidizedActivity = r100;
    }
}
