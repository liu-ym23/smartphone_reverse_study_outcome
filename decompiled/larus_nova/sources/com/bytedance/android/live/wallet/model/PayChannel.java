package com.bytedance.android.live.wallet.model;

/* JADX INFO: loaded from: classes7.dex */
public final enum PayChannel extends Enum<PayChannel> {
    public static final PayChannel ALIPAY = null;
    public static final PayChannel CJ = null;
    public static final PayChannel UNKNOWN = null;
    public static final PayChannel WEIXIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PayChannel[] f102677a = null;
    String value;

    static {
        PayChannel r100 = new PayChannel("WEIXIN", 0, "WEIXIN");
        WEIXIN = r100;
        PayChannel r101 = new PayChannel("ALIPAY", 1, "ALIPAY");
        ALIPAY = r101;
        PayChannel r102 = new PayChannel("CJ", 2, "CJ");
        CJ = r102;
        PayChannel r103 = new PayChannel("UNKNOWN", 3, "UNKNOWN");
        UNKNOWN = r103;
        f102677a = new PayChannel[]{r100, r101, r102, r103};
    }

    public static PayChannel[] values() {
        return (PayChannel[]) f102677a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static PayChannel valueOf(String r100) {
        return (PayChannel) r27.a.a(PayChannel.class, r100);
    }

    public PayChannel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
