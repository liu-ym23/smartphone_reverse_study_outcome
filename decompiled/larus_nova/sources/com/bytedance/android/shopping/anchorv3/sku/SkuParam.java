package com.bytedance.android.shopping.anchorv3.sku;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bI\u0018\u00002\u00020\u0001BÃ\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010'\u001a\u00020\u0017\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u0006\u0012\b\b\u0002\u0010,\u001a\u00020\u0017\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010/\u001a\u00020\u0017\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010=R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010+\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u00104\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0013\u0010:\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u0013\u0010<\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010CR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010CR\u0013\u00105\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010CR\u0015\u00106\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u0013\u00107\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010CR\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010CR\u0013\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010CR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010CR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010CR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010M\u001a\u0004\bU\u0010LR\u0015\u0010;\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010M\u001a\u0004\bV\u0010LR\u0015\u00108\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010M\u001a\u0004\bW\u0010LR\u0011\u0010'\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010XR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010XR\u0011\u0010,\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010XR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010CR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010CR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010CR\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010CR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010CR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010CR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010CR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010CR\u0013\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010CR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010CR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010CR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010M\u001a\u0004\bd\u0010LR\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010CR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010CR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u0010CR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010CR\u0013\u00102\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010CR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010CR\u0011\u0010/\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bm\u0010XR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010CR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010CR\u0015\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010t\u001a\u0004\br\u0010sR\u0015\u0010.\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010t\u001a\u0004\bu\u0010sR\u0015\u00109\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010M\u001a\u0004\bv\u0010LR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010CR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010CR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010C¨\u0006z"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/sku/SkuParam;", "Ljava/io/Serializable;", "promotionId", "", "productId", "promotionSource", "", "resumeTime", "", "pageSource", "authorId", "secAuthorId", "itemId", "followStatus", "sourcePage", "sourceMethod", "enterMethod", "entranceInfo", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "isLuban", "", "pageId", "marqueePV", "pageType", "metaParam", "v3EventAdditions", "originType", "originId", "shopId", "cashRebate", "whichAccount", "eComEntranceFrom", "trackExtra", "roomId", "recommendInfo", "spellGroupId", "isGroupingBuy", "skuExtraData", "Lcom/bytedance/android/ec/model/sku/SkuExtraData;", "receiveAddressId", "addToastType", "isUserJoinActivity", "passThroughEventData", "tag", "shouldScrollToDouInstallment", "defaultSelect", "Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "selectCarId", "enterFrom", "attachParentId", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "cpsTrack", "heightPercent", "termCount", "authorOpenId", "forceYataSku", "bizIdentifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLcom/bytedance/android/ec/model/sku/SkuExtraData;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/Long;ZLcom/bytedance/android/ec/model/sku/DefaultSelect;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAddToastType", "()I", "getAttachParentId", "()Ljava/lang/String;", "getAuthorId", "getAuthorOpenId", "getBizIdentifier", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "getCashRebate", "getChannelId", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCpsTrack", "getDefaultSelect", "()Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "getEComEntranceFrom", "getEnterFrom", "getEnterMethod", "getEntranceInfo", "getFollowStatus", "getForceYataSku", "getHeightPercent", "()Z", "getItemId", "getMarqueePV", "getMetaParam", "getOriginId", "getOriginType", "getPageId", "getPageSource", "getPageType", "getPassThroughEventData", "getProductId", "getPromotionId", "getPromotionSource", "getReceiveAddressId", "getRecommendInfo", "getResumeTime", "()J", "getRoomId", "getSecAuthorId", "getSelectCarId", "getShopId", "getShouldScrollToDouInstallment", "getSkuExtraData", "()Lcom/bytedance/android/ec/model/sku/SkuExtraData;", "getSourceMethod", "getSourcePage", "getSpellGroupId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTag", "getTermCount", "getTrackExtra", "getV3EventAdditions", "getWhichAccount", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuParam implements Serializable {
    private final ECAdLogExtra adLogExtra;
    private final int addToastType;
    private final String attachParentId;
    private final String authorId;
    private final String authorOpenId;
    private final String bizIdentifier;
    private final ECBoltParam boltParam;
    private final String cashRebate;
    private final String channelId;
    private final Integer channelType;
    private final String cpsTrack;
    private final DefaultSelect defaultSelect;
    private final String eComEntranceFrom;
    private final String enterFrom;
    private final String enterMethod;
    private final String entranceInfo;
    private final Integer followStatus;
    private final Integer forceYataSku;
    private final Integer heightPercent;
    private final boolean isGroupingBuy;
    private final boolean isLuban;
    private final boolean isUserJoinActivity;
    private final String itemId;
    private final String marqueePV;
    private final String metaParam;
    private final String originId;
    private final String originType;
    private final String pageId;
    private final String pageSource;
    private final String pageType;
    private final String passThroughEventData;
    private final String productId;
    private final String promotionId;
    private final Integer promotionSource;
    private final String receiveAddressId;
    private final String recommendInfo;
    private final long resumeTime;
    private final String roomId;
    private final String secAuthorId;
    private final String selectCarId;
    private final String shopId;
    private final boolean shouldScrollToDouInstallment;
    private final SkuExtraData skuExtraData;
    private final String sourceMethod;
    private final String sourcePage;
    private final Long spellGroupId;
    private final Long tag;
    private final Integer termCount;
    private final String trackExtra;
    private final String v3EventAdditions;
    private final String whichAccount;

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final int getAddToastType() {
        return this.addToastType;
    }

    public final String getAttachParentId() {
        return this.attachParentId;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorOpenId() {
        return this.authorOpenId;
    }

    public final String getBizIdentifier() {
        return this.bizIdentifier;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final String getCashRebate() {
        return this.cashRebate;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getCpsTrack() {
        return this.cpsTrack;
    }

    public final DefaultSelect getDefaultSelect() {
        return this.defaultSelect;
    }

    public final String getEComEntranceFrom() {
        return this.eComEntranceFrom;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final Integer getForceYataSku() {
        return this.forceYataSku;
    }

    public final Integer getHeightPercent() {
        return this.heightPercent;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getMarqueePV() {
        return this.marqueePV;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageSource() {
        return this.pageSource;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final String getPassThroughEventData() {
        return this.passThroughEventData;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final Integer getPromotionSource() {
        return this.promotionSource;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final long getResumeTime() {
        return this.resumeTime;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSelectCarId() {
        return this.selectCarId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShouldScrollToDouInstallment() {
        return this.shouldScrollToDouInstallment;
    }

    public final SkuExtraData getSkuExtraData() {
        return this.skuExtraData;
    }

    public final String getSourceMethod() {
        return this.sourceMethod;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final Long getSpellGroupId() {
        return this.spellGroupId;
    }

    public final Long getTag() {
        return this.tag;
    }

    public final Integer getTermCount() {
        return this.termCount;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final String getV3EventAdditions() {
        return this.v3EventAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final boolean isGroupingBuy() {
        return this.isGroupingBuy;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isUserJoinActivity() {
        return this.isUserJoinActivity;
    }

    public SkuParam(String r110, String r111, Integer r112, long r113, String r114, String r115, String r116, String r210, Integer r211, String r212, String r213, String r214, String r215, ECAdLogExtra r216, ECBoltParam r217, boolean r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, Long r413, boolean r414, SkuExtraData r415, String r416, int r417, boolean r418, String r419, Long r510, boolean r511, DefaultSelect r512, String r513, String r514, String r515, String r516, Integer r517, String r518, Integer r519, Integer r610, String r611, Integer r612, String r613) {
        Intrinsics.checkNotNullParameter(r114, "pageSource");
        Intrinsics.checkNotNullParameter(r310, "marqueePV");
        Intrinsics.checkNotNullParameter(r311, "pageType");
        Intrinsics.checkNotNullParameter(r314, "originType");
        Intrinsics.checkNotNullParameter(r315, "originId");
        Intrinsics.checkNotNullParameter(r317, "cashRebate");
        Intrinsics.checkNotNullParameter(r411, "roomId");
        Intrinsics.checkNotNullParameter(r515, "attachParentId");
        this.promotionId = r110;
        this.productId = r111;
        this.promotionSource = r112;
        this.resumeTime = r113;
        this.pageSource = r114;
        this.authorId = r115;
        this.secAuthorId = r116;
        this.itemId = r210;
        this.followStatus = r211;
        this.sourcePage = r212;
        this.sourceMethod = r213;
        this.enterMethod = r214;
        this.entranceInfo = r215;
        this.adLogExtra = r216;
        this.boltParam = r217;
        this.isLuban = r218;
        this.pageId = r219;
        this.marqueePV = r310;
        this.pageType = r311;
        this.metaParam = r312;
        this.v3EventAdditions = r313;
        this.originType = r314;
        this.originId = r315;
        this.shopId = r316;
        this.cashRebate = r317;
        this.whichAccount = r318;
        this.eComEntranceFrom = r319;
        this.trackExtra = r410;
        this.roomId = r411;
        this.recommendInfo = r412;
        this.spellGroupId = r413;
        this.isGroupingBuy = r414;
        this.skuExtraData = r415;
        this.receiveAddressId = r416;
        this.addToastType = r417;
        this.isUserJoinActivity = r418;
        this.passThroughEventData = r419;
        this.tag = r510;
        this.shouldScrollToDouInstallment = r511;
        this.defaultSelect = r512;
        this.selectCarId = r513;
        this.enterFrom = r514;
        this.attachParentId = r515;
        this.channelId = r516;
        this.channelType = r517;
        this.cpsTrack = r518;
        this.heightPercent = r519;
        this.termCount = r610;
        this.authorOpenId = r611;
        this.forceYataSku = r612;
        this.bizIdentifier = r613;
    }

    public /* synthetic */ SkuParam(String r510, String r511, Integer r610, long r611, String r612, String r613, String r614, String r615, Integer r616, String r617, String r618, String r710, String r711, ECAdLogExtra r712, ECBoltParam r713, boolean r714, String r715, String r716, String r717, String r718, String r719, String r810, String r811, String r812, String r813, String r814, String r815, String r816, String r817, String r818, Long r819, boolean r910, SkuExtraData r911, String r912, int r913, boolean r914, String r915, Long r916, boolean r917, DefaultSelect r918, String r919, String r100, String r101, String r102, Integer r103, String r104, Integer r105, Integer r106, String r107, Integer r108, String r109, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r110 & 32) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r110 & 64) == 0) goto L9;
        String r114 = null;
    L11:
        if ((r110 & 128) == 0) goto L13;
        String r115 = null;
    L15:
        if ((r110 & 256) == 0) goto L17;
        Integer r116 = null;
    L19:
        if ((r110 & 512) == 0) goto L21;
        String r117 = null;
    L23:
        if ((r110 & 1024) == 0) goto L25;
        String r118 = null;
    L27:
        if ((r110 & 2048) == 0) goto L29;
        String r119 = null;
    L31:
        if ((r110 & 4096) == 0) goto L33;
        String r120 = null;
    L35:
        if ((r110 & 8192) == 0) goto L37;
        ECAdLogExtra r121 = null;
    L39:
        if ((r110 & 16384) == 0) goto L41;
        ECBoltParam r210 = null;
    L43:
        if ((r110 & 32768) == 0) goto L45;
        boolean r211 = false;
    L47:
        if ((r110 & 65536) == 0) goto L49;
        String r212 = "";
    L51:
        if ((r110 & 131072) == 0) goto L53;
        String r213 = "";
    L55:
        if ((r110 & 262144) == 0) goto L57;
        String r214 = "";
    L59:
        if ((524288 & r110) == 0) goto L61;
        String r215 = null;
    L63:
        if ((1048576 & r110) == 0) goto L65;
        String r216 = null;
    L67:
        if ((2097152 & r110) == 0) goto L69;
        String r217 = "";
    L71:
        if ((4194304 & r110) == 0) goto L73;
        String r218 = "";
    L75:
        if ((8388608 & r110) == 0) goto L77;
        String r219 = null;
    L79:
        if ((16777216 & r110) == 0) goto L81;
        String r310 = "";
    L83:
        if ((33554432 & r110) == 0) goto L85;
        String r311 = null;
    L87:
        if ((67108864 & r110) == 0) goto L89;
        String r312 = null;
    L91:
        if ((134217728 & r110) == 0) goto L93;
        String r313 = null;
    L95:
        if ((268435456 & r110) == 0) goto L97;
        String r314 = "";
    L99:
        if ((536870912 & r110) == 0) goto L101;
        String r315 = null;
    L103:
        if ((1073741824 & r110) == 0) goto L105;
        Long r316 = null;
    L107:
        if ((r110 & Integer.MIN_VALUE) == 0) goto L109;
        boolean r317 = false;
    L111:
        if ((r111 & 1) == 0) goto L113;
        SkuExtraData r318 = null;
    L115:
        if ((r111 & 2) == 0) goto L117;
        String r319 = null;
    L119:
        if ((r111 & 4) == 0) goto L121;
        int r410 = 0;
    L123:
        if ((r111 & 8) == 0) goto L125;
        boolean r411 = true;
    L127:
        if ((r111 & 16) == 0) goto L129;
        String r412 = null;
    L131:
        if ((r111 & 32) == 0) goto L133;
        Long r413 = null;
    L135:
        if ((r111 & 64) == 0) goto L137;
        boolean r414 = false;
    L139:
        if ((r111 & 128) == 0) goto L141;
        DefaultSelect r415 = null;
    L143:
        if ((r111 & 256) == 0) goto L145;
        String r416 = null;
    L147:
        if ((r111 & 512) == 0) goto L149;
        String r417 = null;
    L151:
        if ((r111 & 1024) == 0) goto L153;
        String r418 = "";
    L155:
        if ((r111 & 2048) == 0) goto L157;
        String r419 = null;
    L159:
        if ((r111 & 4096) == 0) goto L161;
        Integer r512 = 0;
    L163:
        if ((r111 & 8192) == 0) goto L165;
        String r513 = null;
    L167:
        if ((r111 & 16384) == 0) goto L169;
        Integer r514 = 0;
    L171:
        if ((r111 & 32768) == 0) goto L173;
        Integer r515 = 0;
    L175:
        if ((r111 & 65536) == 0) goto L177;
        String r516 = null;
    L179:
        if ((r111 & 131072) == 0) goto L181;
        Integer r517 = 0;
    L183:
        if ((r111 & 262144) == 0) goto L185;
        String r518 = null;
    L186:
        this(r510, r511, r610, r611, r612, r113, r114, r115, r116, r117, r118, r119, r120, r121, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r512, r513, r514, r515, r516, r517, r518);
        return;
    L185:
        r518 = r109;
        goto L186
    L181:
        r517 = r108;
        goto L183
    L177:
        r516 = r107;
        goto L179
    L173:
        r515 = r106;
        goto L175
    L169:
        r514 = r105;
        goto L171
    L165:
        r513 = r104;
        goto L167
    L161:
        r512 = r103;
        goto L163
    L157:
        r419 = r102;
        goto L159
    L153:
        r418 = r101;
        goto L155
    L149:
        r417 = r100;
        goto L151
    L145:
        r416 = r919;
        goto L147
    L141:
        r415 = r918;
        goto L143
    L137:
        r414 = r917;
        goto L139
    L133:
        r413 = r916;
        goto L135
    L129:
        r412 = r915;
        goto L131
    L125:
        r411 = r914;
        goto L127
    L121:
        r410 = r913;
        goto L123
    L117:
        r319 = r912;
        goto L119
    L113:
        r318 = r911;
        goto L115
    L109:
        r317 = r910;
        goto L111
    L105:
        r316 = r819;
        goto L107
    L101:
        r315 = r818;
        goto L103
    L97:
        r314 = r817;
        goto L99
    L93:
        r313 = r816;
        goto L95
    L89:
        r312 = r815;
        goto L91
    L85:
        r311 = r814;
        goto L87
    L81:
        r310 = r813;
        goto L83
    L77:
        r219 = r812;
        goto L79
    L73:
        r218 = r811;
        goto L75
    L69:
        r217 = r810;
        goto L71
    L65:
        r216 = r719;
        goto L67
    L61:
        r215 = r718;
        goto L63
    L57:
        r214 = r717;
        goto L59
    L53:
        r213 = r716;
        goto L55
    L49:
        r212 = r715;
        goto L51
    L45:
        r211 = r714;
        goto L47
    L41:
        r210 = r713;
        goto L43
    L37:
        r121 = r712;
        goto L39
    L33:
        r120 = r711;
        goto L35
    L29:
        r119 = r710;
        goto L31
    L25:
        r118 = r618;
        goto L27
    L21:
        r117 = r617;
        goto L23
    L17:
        r116 = r616;
        goto L19
    L13:
        r115 = r615;
        goto L15
    L9:
        r114 = r614;
        goto L11
    L5:
        r113 = r613;
        goto L7
    }
}
