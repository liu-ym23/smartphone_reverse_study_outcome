package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class IdentifierType {
    public static final int AMFM_FREQUENCY = 1;
    public static final int DAB_ENSEMBLE = 6;
    public static final int DAB_FREQUENCY = 8;
    public static final int DAB_SCID = 7;
    public static final int DAB_SID_EXT = 5;
    public static final int DRMO_FREQUENCY = 10;
    public static final int DRMO_SERVICE_ID = 9;
    public static final int HD_STATION_ID_EXT = 3;
    public static final int HD_STATION_NAME = 4;
    public static final int INVALID = 0;
    public static final int RDS_PI = 2;
    public static final int SXM_CHANNEL = 13;
    public static final int SXM_SERVICE_ID = 12;
    public static final int VENDOR_END = 1999;
    public static final int VENDOR_START = 1000;

    public IdentifierType() {
    }

    public static final String toString(int o) {
        if (o != 1000) goto L7;
        return "VENDOR_START";
    L7:
        if (o != 1999) goto L10;
        return "VENDOR_END";
    L10:
        if (o != 0) goto L14;
        return "INVALID";
    L14:
        if (o != 1) goto L18;
        return "AMFM_FREQUENCY";
    L18:
        if (o != 2) goto L22;
        return "RDS_PI";
    L22:
        if (o != 3) goto L26;
        return "HD_STATION_ID_EXT";
    L26:
        if (o != 4) goto L30;
        return "HD_STATION_NAME";
    L30:
        if (o != 5) goto L34;
        return "DAB_SID_EXT";
    L34:
        if (o != 6) goto L38;
        return "DAB_ENSEMBLE";
    L38:
        if (o != 7) goto L42;
        return "DAB_SCID";
    L42:
        if (o != 8) goto L46;
        return "DAB_FREQUENCY";
    L46:
        if (o != 9) goto L50;
        return "DRMO_SERVICE_ID";
    L50:
        if (o != 10) goto L54;
        return "DRMO_FREQUENCY";
    L54:
        if (o != 12) goto L58;
        return "SXM_SERVICE_ID";
    L58:
        if (o != 13) goto L62;
        return "SXM_CHANNEL";
    L62:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1000) != 1000) goto L6;
        list.add("VENDOR_START");
        flipped = 0 | 1000;
    L6:
        if ((o & 1999) != 1999) goto L8;
        list.add("VENDOR_END");
        flipped = flipped | 1999;
    L8:
        list.add("INVALID");
        if ((o & 1) != 1) goto L12;
        list.add("AMFM_FREQUENCY");
        flipped = flipped | 1;
    L12:
        if ((o & 2) != 2) goto L15;
        list.add("RDS_PI");
        flipped = flipped | 2;
    L15:
        if ((o & 3) != 3) goto L18;
        list.add("HD_STATION_ID_EXT");
        flipped = flipped | 3;
    L18:
        if ((o & 4) != 4) goto L21;
        list.add("HD_STATION_NAME");
        flipped = flipped | 4;
    L21:
        if ((o & 5) != 5) goto L24;
        list.add("DAB_SID_EXT");
        flipped = flipped | 5;
    L24:
        if ((o & 6) != 6) goto L27;
        list.add("DAB_ENSEMBLE");
        flipped = flipped | 6;
    L27:
        if ((o & 7) != 7) goto L30;
        list.add("DAB_SCID");
        flipped = flipped | 7;
    L30:
        if ((o & 8) != 8) goto L33;
        list.add("DAB_FREQUENCY");
        flipped = flipped | 8;
    L33:
        if ((o & 9) != 9) goto L36;
        list.add("DRMO_SERVICE_ID");
        flipped = flipped | 9;
    L36:
        if ((o & 10) != 10) goto L39;
        list.add("DRMO_FREQUENCY");
        flipped = flipped | 10;
    L39:
        if ((o & 12) != 12) goto L42;
        list.add("SXM_SERVICE_ID");
        flipped = flipped | 12;
    L42:
        if ((o & 13) != 13) goto L44;
        list.add("SXM_CHANNEL");
        flipped = flipped | 13;
    L44:
        if (o == flipped) goto L47;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L47:
        return String.join(" | ", list);
    }
}
