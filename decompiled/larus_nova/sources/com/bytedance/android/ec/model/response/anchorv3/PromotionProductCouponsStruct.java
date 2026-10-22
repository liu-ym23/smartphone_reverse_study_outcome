package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0004R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCouponsStruct;", "Ljava/io/Serializable;", "()V", "autoApplyCoupons", "", "Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "getAutoApplyCoupons", "()Ljava/util/List;", "benefitComponent", "Lcom/bytedance/android/ec/model/response/anchorv3/BenefitComponent;", "getBenefitComponent", "()Lcom/bytedance/android/ec/model/response/anchorv3/BenefitComponent;", "canApplyCoupons", "getCanApplyCoupons", "canUseCoupons", "getCanUseCoupons", "couponMetaLabels", "", "getCouponMetaLabels", "discountLabels", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "getDiscountLabels", "exchangeCoupons", "Lcom/bytedance/android/ec/model/response/anchorv3/ExchangeCoupons;", "getExchangeCoupons", "()Lcom/bytedance/android/ec/model/response/anchorv3/ExchangeCoupons;", "setExchangeCoupons", "(Lcom/bytedance/android/ec/model/response/anchorv3/ExchangeCoupons;)V", "innerFlowCouponExtra", "Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowCouponExtra;", "getInnerFlowCouponExtra", "()Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowCouponExtra;", "setInnerFlowCouponExtra", "(Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowCouponExtra;)V", "marketingBanner", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;", "getMarketingBanner", "()Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;", "setMarketingBanner", "(Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;)V", "marketingTip", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;", "getMarketingTip", "()Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;", "setMarketingTip", "(Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;)V", "discounts", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCouponsStruct implements Serializable {

    @SerializedName("auto_apply_coupons")
    private final List<CommerceGoodCoupon> autoApplyCoupons;

    @SerializedName("benefit_component")
    private final BenefitComponent benefitComponent;

    @SerializedName("can_apply_coupons")
    private final List<CommerceGoodCoupon> canApplyCoupons;

    @SerializedName("can_use_coupons")
    private final List<CommerceGoodCoupon> canUseCoupons;

    @SerializedName("coupon_meta_labels")
    private final List<String> couponMetaLabels;

    @SerializedName("discount_labels")
    private final List<PromotionDiscountLabel> discountLabels;

    @SerializedName("exchange_coupons")
    private ExchangeCoupons exchangeCoupons;

    @SerializedName("inner_flow_coupon_extra")
    private InnerFlowCouponExtra innerFlowCouponExtra;

    @SerializedName("marketing_banner")
    private MarketingBanner marketingBanner;

    @SerializedName("marketing_tip")
    private MarketingTip marketingTip;

    public PromotionProductCouponsStruct() {
    }

    public final List<PromotionDiscountLabel> discounts() {
        List<PromotionDiscountLabel> r100 = this.discountLabels;
        if (r100 != null) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
        boolean r103 = false;
    L8:
        if (r102.hasNext() == false) goto L18;
        Object r104 = r102.next();
        if (r103 == true) goto L11;
        if (((PromotionDiscountLabel) r104).getType() == 1) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L8;
        r101.add(r104);
        r103 = true;
        goto L8
    L15:
        r105 = false;
        goto L16
    L11:
        r101.add(r104);
        goto L8
    L18:
        return r101;
    }

    public final List<CommerceGoodCoupon> getAutoApplyCoupons() {
        return this.autoApplyCoupons;
    }

    public final BenefitComponent getBenefitComponent() {
        return this.benefitComponent;
    }

    public final List<CommerceGoodCoupon> getCanApplyCoupons() {
        return this.canApplyCoupons;
    }

    public final List<CommerceGoodCoupon> getCanUseCoupons() {
        return this.canUseCoupons;
    }

    public final List<String> getCouponMetaLabels() {
        return this.couponMetaLabels;
    }

    public final List<PromotionDiscountLabel> getDiscountLabels() {
        return this.discountLabels;
    }

    public final ExchangeCoupons getExchangeCoupons() {
        return this.exchangeCoupons;
    }

    public final InnerFlowCouponExtra getInnerFlowCouponExtra() {
        return this.innerFlowCouponExtra;
    }

    public final MarketingBanner getMarketingBanner() {
        return this.marketingBanner;
    }

    public final MarketingTip getMarketingTip() {
        return this.marketingTip;
    }

    public final void setExchangeCoupons(ExchangeCoupons r100) {
        this.exchangeCoupons = r100;
    }

    public final void setInnerFlowCouponExtra(InnerFlowCouponExtra r100) {
        this.innerFlowCouponExtra = r100;
    }

    public final void setMarketingBanner(MarketingBanner r100) {
        this.marketingBanner = r100;
    }

    public final void setMarketingTip(MarketingTip r100) {
        this.marketingTip = r100;
    }
}
