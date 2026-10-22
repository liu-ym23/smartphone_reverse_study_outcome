package com.android.ttcjpaysdk.integrated.counter.component.config;

import com.android.ttcjpaysdk.base.CJPayConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/PayType;", "", "ptcode", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPtcode", "()Ljava/lang/String;", "WX", "ALIPAY", "BYTEPAY", "GLOBALPAY", "SUPERPAY", "FUNDPAY", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PayType extends Enum<PayType> {
    private static final /* synthetic */ PayType[] $VALUES = null;
    public static final PayType ALIPAY = null;
    public static final PayType BYTEPAY = null;
    public static final PayType FUNDPAY = null;
    public static final PayType GLOBALPAY = null;
    public static final PayType SUPERPAY = null;
    public static final PayType WX = null;
    private final String ptcode;

    private static final /* synthetic */ PayType[] $values() {
        return new PayType[]{WX, ALIPAY, BYTEPAY, GLOBALPAY, SUPERPAY, FUNDPAY};
    }

    public static PayType valueOf(String r100) {
        return (PayType) a.a(PayType.class, r100);
    }

    public static PayType[] values() {
        return (PayType[]) $VALUES.clone();
    }

    static {
        WX = new PayType("WX", 0, "wx");
        ALIPAY = new PayType("ALIPAY", 1, "alipay");
        BYTEPAY = new PayType("BYTEPAY", 2, CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY);
        GLOBALPAY = new PayType("GLOBALPAY", 3, CJPayConstant.TT_CJ_PAY_KEY_FOR_OVERSEA_PAY);
        SUPERPAY = new PayType("SUPERPAY", 4, "superpay");
        FUNDPAY = new PayType("FUNDPAY", 5, CJPayConstant.TT_CJ_PAY_KEY_FOR_MFUND_BCB_PAY);
        $VALUES = $values();
    }

    public final String getPtcode() {
        return this.ptcode;
    }

    private PayType(String r100, int r101, String r102) {
        super(r100, r101);
        this.ptcode = r102;
    }
}
