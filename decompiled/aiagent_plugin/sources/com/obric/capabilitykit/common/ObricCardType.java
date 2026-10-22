package com.obric.capabilitykit.common;

/* JADX INFO: loaded from: classes3.dex */
public final class ObricCardType {
    public static final ObricCardType INSTANCE = null;
    public static final int OBRIC_CARD_TYPE_ALARM_CLOCK = 1;
    public static final int OBRIC_CARD_TYPE_APP_CHOOSER = 16;
    public static final int OBRIC_CARD_TYPE_SETTINGS = 2;
    public static final int OBRIC_CARD_TYPE_TIMER = 4;
    public static final int OBRIC_CARD_TYPE_WIFI_QRCODE = 8;

    static {
        INSTANCE = new ObricCardType();
    }

    private ObricCardType() {
    }
}
