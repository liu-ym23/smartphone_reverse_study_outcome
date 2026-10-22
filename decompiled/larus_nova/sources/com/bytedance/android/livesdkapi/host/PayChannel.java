package com.bytedance.android.livesdkapi.host;

import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum PayChannel extends Enum<PayChannel> {
    private static final /* synthetic */ PayChannel[] $VALUES = null;
    public static final PayChannel ALIPAY = null;
    public static final PayChannel BOKU = null;
    public static final PayChannel CJ = null;
    public static final PayChannel DIAMOND = null;
    public static final PayChannel FIRE = null;
    public static final PayChannel GOOGLE = null;
    public static final PayChannel HUOLI = null;
    public static final PayChannel MASTERCARD = null;
    public static final PayChannel ONECARD = null;
    public static final PayChannel TEST = null;
    public static final PayChannel UNKNOWN = null;
    public static final PayChannel VISA = null;
    public static final PayChannel WEIXIN = null;
    String value;

    static {
        PayChannel r100 = new PayChannel("WEIXIN", 0, "WEIXIN");
        WEIXIN = r100;
        PayChannel r101 = new PayChannel("ALIPAY", 1, "ALIPAY");
        ALIPAY = r101;
        PayChannel r102 = new PayChannel(FlowDoraWifiScene.TEST, 2, FlowDoraWifiScene.TEST);
        TEST = r102;
        PayChannel r103 = new PayChannel("FIRE", 3, "FIRE");
        FIRE = r103;
        PayChannel r104 = new PayChannel("GOOGLE", 4, "GooglePay");
        GOOGLE = r104;
        PayChannel r105 = new PayChannel("DIAMOND", 5, "DIAMOND");
        DIAMOND = r105;
        PayChannel r110 = new PayChannel("ONECARD", 6, "OneCard");
        ONECARD = r110;
        PayChannel r111 = new PayChannel("VISA", 7, "Visa");
        VISA = r111;
        PayChannel r112 = new PayChannel("MASTERCARD", 8, "MasterCard");
        MASTERCARD = r112;
        PayChannel r113 = new PayChannel("BOKU", 9, "Pay by mobile");
        BOKU = r113;
        PayChannel r114 = new PayChannel("HUOLI", 10, "Huoli");
        HUOLI = r114;
        PayChannel r106 = new PayChannel("CJ", 11, "CJ");
        CJ = r106;
        PayChannel r115 = new PayChannel("UNKNOWN", 12, "UNKNOWN");
        UNKNOWN = r115;
        $VALUES = new PayChannel[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r115};
    }

    public static PayChannel[] values() {
        return (PayChannel[]) $VALUES.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static PayChannel valueOf(String r100) {
        return (PayChannel) a.a(PayChannel.class, r100);
    }

    private PayChannel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
