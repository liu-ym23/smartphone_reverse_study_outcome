package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/PayType;", "", "", "rawValue", "I", "getRawValue", "()I", "COD", "WECHAT", "ALIPAY", "CARD", "BALANCE", "ZEROBUY", "CREDIT", "NEWCARD", "BYTEPAY", "PAY_AFTER_USE", "COMBINE_PAY", "QUICK_PAY", "LARGE_AMOUNT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PayType extends Enum<PayType> {
    public static final PayType ALIPAY = null;
    public static final PayType BALANCE = null;
    public static final PayType BYTEPAY = null;
    public static final PayType CARD = null;
    public static final PayType COD = null;
    public static final PayType COMBINE_PAY = null;
    public static final PayType CREDIT = null;
    public static final PayType LARGE_AMOUNT = null;
    public static final PayType NEWCARD = null;
    public static final PayType PAY_AFTER_USE = null;
    public static final PayType QUICK_PAY = null;
    public static final PayType WECHAT = null;
    public static final PayType ZEROBUY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PayType[] f164224a = null;
    private final int rawValue;

    public static PayType valueOf(String r100) {
        return (PayType) a.a(PayType.class, r100);
    }

    public static PayType[] values() {
        return (PayType[]) f164224a.clone();
    }

    static {
        PayType r100 = new PayType("COD", 0, 0);
        COD = r100;
        PayType r101 = new PayType("WECHAT", 1, 1);
        WECHAT = r101;
        PayType r102 = new PayType("ALIPAY", 2, 2);
        ALIPAY = r102;
        PayType r103 = new PayType("CARD", 3, 4);
        CARD = r103;
        PayType r104 = new PayType("BALANCE", 4, 5);
        BALANCE = r104;
        PayType r105 = new PayType("ZEROBUY", 5, 7);
        ZEROBUY = r105;
        PayType r106 = new PayType("CREDIT", 6, 8);
        CREDIT = r106;
        PayType r107 = new PayType("NEWCARD", 7, 9);
        NEWCARD = r107;
        PayType r108 = new PayType("BYTEPAY", 8, 10);
        BYTEPAY = r108;
        PayType r109 = new PayType("PAY_AFTER_USE", 9, 12);
        PAY_AFTER_USE = r109;
        PayType r110 = new PayType("COMBINE_PAY", 10, 13);
        COMBINE_PAY = r110;
        PayType r111 = new PayType("QUICK_PAY", 11, 14);
        QUICK_PAY = r111;
        PayType r112 = new PayType("LARGE_AMOUNT", 12, 17);
        LARGE_AMOUNT = r112;
        f164224a = new PayType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public PayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
