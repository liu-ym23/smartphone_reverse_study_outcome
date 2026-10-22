package com.bytedance.android.livesdk.coupon.balancecoupon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/CouponBenefitType;", "", "", "value", "I", "getValue", "()I", "COUPON_BENEFIT_TYPE_UG_COUPON", "COUPON_BENEFIT_TYPE_AD_QCPX_EXPANSION_COUPON", "COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum CouponBenefitType extends Enum<CouponBenefitType> {
    public static final CouponBenefitType COUPON_BENEFIT_TYPE_AD_QCPX_EXPANSION_COUPON = null;
    public static final CouponBenefitType COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON = null;
    public static final CouponBenefitType COUPON_BENEFIT_TYPE_UG_COUPON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CouponBenefitType[] f121829a = null;
    private final int value;

    static {
        CouponBenefitType r100 = new CouponBenefitType("COUPON_BENEFIT_TYPE_UG_COUPON", 0, 1);
        COUPON_BENEFIT_TYPE_UG_COUPON = r100;
        CouponBenefitType r101 = new CouponBenefitType("COUPON_BENEFIT_TYPE_AD_QCPX_EXPANSION_COUPON", 1, 2);
        COUPON_BENEFIT_TYPE_AD_QCPX_EXPANSION_COUPON = r101;
        CouponBenefitType r102 = new CouponBenefitType("COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON", 2, 3);
        COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON = r102;
        f121829a = new CouponBenefitType[]{r100, r101, r102};
    }

    public static CouponBenefitType valueOf(String r100) {
        return (CouponBenefitType) a.a(CouponBenefitType.class, r100);
    }

    public static CouponBenefitType[] values() {
        return (CouponBenefitType[]) f121829a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CouponBenefitType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
