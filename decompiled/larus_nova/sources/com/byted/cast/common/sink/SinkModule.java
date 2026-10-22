package com.byted.cast.common.sink;

/* JADX INFO: loaded from: classes39.dex */
public class SinkModule {
    public static final String BDAIRPLAY = "BDAirPlay";
    public static final String BDCLOUD = "BDCloud";
    public static final String BDDLNA = "BDDLNA";
    public static final String BDLINK = "BDLink";
    public static final String BYTELINK = "ByteLink";
    public static final String CHROMECAST = "ChromeCast";
    public static final String DIAL = "DIAL";
    public static final int ID_BDAirPlay = 0;
    public static final int ID_BDCloud = 6;
    public static final int ID_BDDLNA = 1;
    public static final int ID_BDLink = 2;
    public static final int ID_ByteCast = 5;
    public static final int ID_ByteLink = 3;
    public static final int ID_ChromeCast = 7;
    public static final int ID_DIAL = 8;
    public static final int ID_LELINK = 4;
    public static final int ID_VastCast = 8;
    public static final String LELINK = "LeLink";
    public static final String USBSINK = "UsbSink";
    public static final String VASTCAST = "VastCast";

    public SinkModule() {
    }

    public static String getProtocolNameByID(int r100) {
        switch(r100) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L3;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return "";
    L5:
        return "DIAL";
    L7:
        return "ChromeCast";
    L9:
        return "BDCloud";
    L11:
        return "LeLink";
    L13:
        return "ByteLink";
    L15:
        return "BDLink";
    L17:
        return "BDDLNA";
    L19:
        return "BDAirPlay";
    }
}
