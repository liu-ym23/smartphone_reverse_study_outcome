package com.android.ttcjpaysdk.base.paymentbasis.constants;

import com.android.ttcjpaysdk.base.CJPayConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/constants/WXPayType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP", "MINIAPP", CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MWEB, CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MINIH5, "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum WXPayType extends Enum<WXPayType> {
    private static final /* synthetic */ WXPayType[] $VALUES = null;
    public static final WXPayType APP = null;
    public static final WXPayType MINIAPP = null;
    public static final WXPayType MINIH5 = null;
    public static final WXPayType MWEB = null;
    private final String value;

    private static final /* synthetic */ WXPayType[] $values() {
        return new WXPayType[]{APP, MINIAPP, MWEB, MINIH5};
    }

    public static WXPayType valueOf(String r100) {
        return (WXPayType) a.a(WXPayType.class, r100);
    }

    public static WXPayType[] values() {
        return (WXPayType[]) $VALUES.clone();
    }

    static {
        APP = new WXPayType("APP", 0, "APP");
        MINIAPP = new WXPayType("MINIAPP", 1, "MINIAPP");
        MWEB = new WXPayType(CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MWEB, 2, CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MWEB);
        MINIH5 = new WXPayType(CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MINIH5, 3, CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MINIH5);
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private WXPayType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
