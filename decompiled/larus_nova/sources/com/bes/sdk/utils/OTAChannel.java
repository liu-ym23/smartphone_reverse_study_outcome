package com.bes.sdk.utils;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum OTAChannel extends Enum<OTAChannel> {
    public static final OTAChannel CHANNEL_AMAZON_AI = null;
    public static final OTAChannel CHANNEL_APP = null;
    public static final OTAChannel CHANNEL_GOOGLE_AI = null;
    public static final OTAChannel CHANNEL_UNKNOWN = null;
    public static final OTAChannel STATUS_XIAOWEI_AI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OTAChannel[] f33671a = null;
    private String mName;
    private int mValue;

    static {
        OTAChannel r100 = new OTAChannel("CHANNEL_UNKNOWN", 0, -1, "OTA Channel Unknown");
        CHANNEL_UNKNOWN = r100;
        OTAChannel r101 = new OTAChannel("CHANNEL_APP", 1, 0, "OTA Channel App");
        CHANNEL_APP = r101;
        OTAChannel r102 = new OTAChannel("CHANNEL_GOOGLE_AI", 2, 1, "OTA Channel Google Assistant");
        CHANNEL_GOOGLE_AI = r102;
        OTAChannel r103 = new OTAChannel("CHANNEL_AMAZON_AI", 3, 2, "OTA Channel Amazon Alexa");
        CHANNEL_AMAZON_AI = r103;
        OTAChannel r104 = new OTAChannel("STATUS_XIAOWEI_AI", 4, 3, "OTA Channel Xiaowei");
        STATUS_XIAOWEI_AI = r104;
        f33671a = new OTAChannel[]{r100, r101, r102, r103, r104};
    }

    public static OTAChannel[] values() {
        return (OTAChannel[]) f33671a.clone();
    }

    public String getName() {
        return this.mName;
    }

    public int getValue() {
        return this.mValue;
    }

    public static OTAChannel valueOf(String r100) {
        return (OTAChannel) a.a(OTAChannel.class, r100);
    }

    public OTAChannel(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mName = r103;
    }
}
