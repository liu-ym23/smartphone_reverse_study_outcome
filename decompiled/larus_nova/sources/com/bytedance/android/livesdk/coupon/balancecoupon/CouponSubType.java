package com.bytedance.android.livesdk.coupon.balancecoupon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/CouponSubType;", "", "", "value", "I", "getValue", "()I", "CouponSubType_Unknown", "CouponSubType_FullAmount", "CouponSubType_Amount", "CouponSubType_Discount", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum CouponSubType extends Enum<CouponSubType> {
    public static final CouponSubType CouponSubType_Amount = null;
    public static final CouponSubType CouponSubType_Discount = null;
    public static final CouponSubType CouponSubType_FullAmount = null;
    public static final CouponSubType CouponSubType_Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CouponSubType[] f121830a = null;
    private final int value;

    static {
        CouponSubType r100 = new CouponSubType("CouponSubType_Unknown", 0, 0);
        CouponSubType_Unknown = r100;
        CouponSubType r101 = new CouponSubType("CouponSubType_FullAmount", 1, 1);
        CouponSubType_FullAmount = r101;
        CouponSubType r102 = new CouponSubType("CouponSubType_Amount", 2, 2);
        CouponSubType_Amount = r102;
        CouponSubType r103 = new CouponSubType("CouponSubType_Discount", 3, 3);
        CouponSubType_Discount = r103;
        f121830a = new CouponSubType[]{r100, r101, r102, r103};
    }

    public static CouponSubType valueOf(String r100) {
        return (CouponSubType) a.a(CouponSubType.class, r100);
    }

    public static CouponSubType[] values() {
        return (CouponSubType[]) f121830a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CouponSubType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
