package com.autonavi.aps.protocol.aps.common.constant;

/* loaded from: classes.dex */
public enum WifiStandard {
    WIFI_STANDARD_UNKNOWN(0),
    WIFI_STANDARD_LEGACY(1),
    WIFI_STANDARD_11N(4),
    WIFI_STANDARD_11AC(5),
    WIFI_STANDARD_11AX(6),
    WIFI_STANDARD_11AD(7),
    WIFI_STANDARD_11BE(8);


    /* renamed from: a, reason: collision with root package name */
    final short f18507a;

    WifiStandard(short s10) {
        this.f18507a = s10;
    }

    public static short getWifiStandardCode(short s10) {
        WifiStandard[] wifiStandardArrValues = values();
        for (int i10 = 0; i10 < 7; i10++) {
            if (s10 == wifiStandardArrValues[i10].f18507a) {
                return s10;
            }
        }
        return WIFI_STANDARD_UNKNOWN.f18507a;
    }
}
