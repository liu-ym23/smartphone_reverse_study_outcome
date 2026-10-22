package com.bytedance.android.ec.core.buynow;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/BuyNowBizCode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "YATA_SKUBUY", "BUY", "CONTINUE_PAY", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowBizCode extends Enum<BuyNowBizCode> {
    public static final BuyNowBizCode BUY = null;
    public static final BuyNowBizCode CONTINUE_PAY = null;
    public static final BuyNowBizCode YATA_SKUBUY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowBizCode[] f43904a = null;
    private final String value;

    static {
        BuyNowBizCode r100 = new BuyNowBizCode("YATA_SKUBUY", 0, "yata_skubuy");
        YATA_SKUBUY = r100;
        BuyNowBizCode r101 = new BuyNowBizCode("BUY", 1, "yata_buynow");
        BUY = r101;
        BuyNowBizCode r102 = new BuyNowBizCode("CONTINUE_PAY", 2, "yata_continue_pay");
        CONTINUE_PAY = r102;
        f43904a = new BuyNowBizCode[]{r100, r101, r102};
    }

    public static BuyNowBizCode valueOf(String r100) {
        return (BuyNowBizCode) r27.a.a(BuyNowBizCode.class, r100);
    }

    public static BuyNowBizCode[] values() {
        return (BuyNowBizCode[]) f43904a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public BuyNowBizCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
