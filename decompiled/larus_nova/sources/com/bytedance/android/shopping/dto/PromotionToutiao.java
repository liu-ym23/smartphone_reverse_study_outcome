package com.bytedance.android.shopping.dto;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionAppointment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionPreSale;
import com.bytedance.android.ec.model.response.anchorv3.SeckillInfo;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR \u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR \u0010+\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR \u0010.\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR \u00101\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR \u00104\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR \u00107\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010=\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010C\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010I\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR \u0010L\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR \u0010O\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR \u0010R\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006X"}, d2 = {"Lcom/bytedance/android/shopping/dto/PromotionToutiao;", "Ljava/io/Serializable;", "()V", "alreadyBuy", "", "getAlreadyBuy", "()Ljava/lang/Boolean;", "setAlreadyBuy", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", ActivityVO.APPOINTMENT, "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;", "getAppointment", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;", "setAppointment", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;)V", "button", "Lcom/bytedance/android/shopping/dto/CommerceToutiaoButton;", "getButton", "()Lcom/bytedance/android/shopping/dto/CommerceToutiaoButton;", "setButton", "(Lcom/bytedance/android/shopping/dto/CommerceToutiaoButton;)V", "cartUrl", "", "getCartUrl", "()Ljava/lang/String;", "setCartUrl", "(Ljava/lang/String;)V", "couponRule", "", "getCouponRule", "()Ljava/util/List;", "setCouponRule", "(Ljava/util/List;)V", "deliveryDelayText", "getDeliveryDelayText", "setDeliveryDelayText", "imUrl", "getImUrl", "setImUrl", "needCheck", "getNeedCheck", "setNeedCheck", "orderTmaUrl", "getOrderTmaUrl", "setOrderTmaUrl", "orderUrl", "getOrderUrl", "setOrderUrl", "originId", "getOriginId", "setOriginId", "originType", "getOriginType", "setOriginType", "preSale", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;", "getPreSale", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;", "setPreSale", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;)V", "reductionInfo", "Lcom/bytedance/android/shopping/dto/TouTiaoFullReductionInfo;", "getReductionInfo", "()Lcom/bytedance/android/shopping/dto/TouTiaoFullReductionInfo;", "setReductionInfo", "(Lcom/bytedance/android/shopping/dto/TouTiaoFullReductionInfo;)V", "secKillInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", "getSecKillInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;", "setSecKillInfo", "(Lcom/bytedance/android/ec/model/response/anchorv3/SeckillInfo;)V", "shopName", "getShopName", "setShopName", "skuJsonString", "getSkuJsonString", "setSkuJsonString", "titlePrefix", "getTitlePrefix", "setTitlePrefix", "virtualPromotion", "Lcom/bytedance/android/shopping/dto/VirtualPromotionBean;", "getVirtualPromotion", "()Lcom/bytedance/android/shopping/dto/VirtualPromotionBean;", "setVirtualPromotion", "(Lcom/bytedance/android/shopping/dto/VirtualPromotionBean;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionToutiao implements Serializable {

    @SerializedName("already_buy")
    private Boolean alreadyBuy;

    @SerializedName(ActivityVO.APPOINTMENT)
    private PromotionAppointment appointment;

    @SerializedName("button")
    private CommerceToutiaoButton button;

    @SerializedName("cart_url")
    private String cartUrl;

    @SerializedName("coupon_rule")
    private List<String> couponRule;

    @SerializedName("delivery_delay_text")
    private String deliveryDelayText;

    @SerializedName("im_url")
    private String imUrl;

    @SerializedName("need_check")
    private Boolean needCheck;

    @SerializedName("order_tma_url")
    private String orderTmaUrl;

    @SerializedName("order_url")
    private String orderUrl;

    @SerializedName(a.KEY_ORIGIN_ID)
    private String originId;

    @SerializedName(a.KEY_ORIGIN_TYPE)
    private String originType;

    @SerializedName("pre_sale")
    private PromotionPreSale preSale;

    @SerializedName("full_reduction")
    private TouTiaoFullReductionInfo reductionInfo;

    @SerializedName("sec_kill_info")
    private SeckillInfo secKillInfo;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName(ECPromotion.SKU)
    private String skuJsonString;

    @SerializedName("title_prefix")
    private String titlePrefix;

    @SerializedName("virtual_promotion")
    private VirtualPromotionBean virtualPromotion;

    public PromotionToutiao() {
        this.needCheck = Boolean.TRUE;
        this.alreadyBuy = Boolean.FALSE;
    }

    public final Boolean getAlreadyBuy() {
        return this.alreadyBuy;
    }

    public final PromotionAppointment getAppointment() {
        return this.appointment;
    }

    public final CommerceToutiaoButton getButton() {
        return this.button;
    }

    public final String getCartUrl() {
        return this.cartUrl;
    }

    public final List<String> getCouponRule() {
        return this.couponRule;
    }

    public final String getDeliveryDelayText() {
        return this.deliveryDelayText;
    }

    public final String getImUrl() {
        return this.imUrl;
    }

    public final Boolean getNeedCheck() {
        return this.needCheck;
    }

    public final String getOrderTmaUrl() {
        return this.orderTmaUrl;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final PromotionPreSale getPreSale() {
        return this.preSale;
    }

    public final TouTiaoFullReductionInfo getReductionInfo() {
        return this.reductionInfo;
    }

    public final SeckillInfo getSecKillInfo() {
        return this.secKillInfo;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final String getSkuJsonString() {
        return this.skuJsonString;
    }

    public final String getTitlePrefix() {
        return this.titlePrefix;
    }

    public final VirtualPromotionBean getVirtualPromotion() {
        return this.virtualPromotion;
    }

    public final void setAlreadyBuy(Boolean r100) {
        this.alreadyBuy = r100;
    }

    public final void setAppointment(PromotionAppointment r100) {
        this.appointment = r100;
    }

    public final void setButton(CommerceToutiaoButton r100) {
        this.button = r100;
    }

    public final void setCartUrl(String r100) {
        this.cartUrl = r100;
    }

    public final void setCouponRule(List<String> r100) {
        this.couponRule = r100;
    }

    public final void setDeliveryDelayText(String r100) {
        this.deliveryDelayText = r100;
    }

    public final void setImUrl(String r100) {
        this.imUrl = r100;
    }

    public final void setNeedCheck(Boolean r100) {
        this.needCheck = r100;
    }

    public final void setOrderTmaUrl(String r100) {
        this.orderTmaUrl = r100;
    }

    public final void setOrderUrl(String r100) {
        this.orderUrl = r100;
    }

    public final void setOriginId(String r100) {
        this.originId = r100;
    }

    public final void setOriginType(String r100) {
        this.originType = r100;
    }

    public final void setPreSale(PromotionPreSale r100) {
        this.preSale = r100;
    }

    public final void setReductionInfo(TouTiaoFullReductionInfo r100) {
        this.reductionInfo = r100;
    }

    public final void setSecKillInfo(SeckillInfo r100) {
        this.secKillInfo = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }

    public final void setSkuJsonString(String r100) {
        this.skuJsonString = r100;
    }

    public final void setTitlePrefix(String r100) {
        this.titlePrefix = r100;
    }

    public final void setVirtualPromotion(VirtualPromotionBean r100) {
        this.virtualPromotion = r100;
    }
}
