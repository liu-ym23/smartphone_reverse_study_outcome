package com.bytedance.android.shopping.buynow.data.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/BuyNowPayType;", "", "", "type", "I", "getType", "()I", "COD", "WECHAT", "ALIPAY", "CARD", "BALANCE", "ZEROBUY", "CREDIT", "NEWCARD", "BYTEPAY", "PAY_AFTER_USE", "COMBINE_PAY", "QUICK_PAY", "LARGE_AMOUNT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowPayType extends Enum<BuyNowPayType> {
    public static final BuyNowPayType ALIPAY = null;
    public static final BuyNowPayType BALANCE = null;
    public static final BuyNowPayType BYTEPAY = null;
    public static final BuyNowPayType CARD = null;
    public static final BuyNowPayType COD = null;
    public static final BuyNowPayType COMBINE_PAY = null;
    public static final BuyNowPayType CREDIT = null;
    public static final BuyNowPayType LARGE_AMOUNT = null;
    public static final BuyNowPayType NEWCARD = null;
    public static final BuyNowPayType PAY_AFTER_USE = null;
    public static final BuyNowPayType QUICK_PAY = null;
    public static final BuyNowPayType WECHAT = null;
    public static final BuyNowPayType ZEROBUY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowPayType[] f170881a = null;
    private final int type;

    public static BuyNowPayType valueOf(String r100) {
        return (BuyNowPayType) a.a(BuyNowPayType.class, r100);
    }

    public static BuyNowPayType[] values() {
        return (BuyNowPayType[]) f170881a.clone();
    }

    static {
        BuyNowPayType r100 = new BuyNowPayType("COD", 0, 0);
        COD = r100;
        BuyNowPayType r101 = new BuyNowPayType("WECHAT", 1, 1);
        WECHAT = r101;
        BuyNowPayType r102 = new BuyNowPayType("ALIPAY", 2, 2);
        ALIPAY = r102;
        BuyNowPayType r103 = new BuyNowPayType("CARD", 3, 4);
        CARD = r103;
        BuyNowPayType r104 = new BuyNowPayType("BALANCE", 4, 5);
        BALANCE = r104;
        BuyNowPayType r105 = new BuyNowPayType("ZEROBUY", 5, 7);
        ZEROBUY = r105;
        BuyNowPayType r106 = new BuyNowPayType("CREDIT", 6, 8);
        CREDIT = r106;
        BuyNowPayType r107 = new BuyNowPayType("NEWCARD", 7, 9);
        NEWCARD = r107;
        BuyNowPayType r108 = new BuyNowPayType("BYTEPAY", 8, 10);
        BYTEPAY = r108;
        BuyNowPayType r109 = new BuyNowPayType("PAY_AFTER_USE", 9, 12);
        PAY_AFTER_USE = r109;
        BuyNowPayType r110 = new BuyNowPayType("COMBINE_PAY", 10, 13);
        COMBINE_PAY = r110;
        BuyNowPayType r111 = new BuyNowPayType("QUICK_PAY", 11, 14);
        QUICK_PAY = r111;
        BuyNowPayType r112 = new BuyNowPayType("LARGE_AMOUNT", 12, 17);
        LARGE_AMOUNT = r112;
        f170881a = new BuyNowPayType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getType() {
        return this.type;
    }

    public BuyNowPayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
