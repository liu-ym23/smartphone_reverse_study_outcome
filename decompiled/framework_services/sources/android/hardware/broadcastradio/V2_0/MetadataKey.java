package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataKey {
    public static final int ALBUM_ART = 9;
    public static final int DAB_COMPONENT_NAME = 15;
    public static final int DAB_COMPONENT_NAME_SHORT = 16;
    public static final int DAB_ENSEMBLE_NAME = 11;
    public static final int DAB_ENSEMBLE_NAME_SHORT = 12;
    public static final int DAB_SERVICE_NAME = 13;
    public static final int DAB_SERVICE_NAME_SHORT = 14;
    public static final int PROGRAM_NAME = 10;
    public static final int RBDS_PTY = 3;
    public static final int RDS_PS = 1;
    public static final int RDS_PTY = 2;
    public static final int RDS_RT = 4;
    public static final int SONG_ALBUM = 7;
    public static final int SONG_ARTIST = 6;
    public static final int SONG_TITLE = 5;
    public static final int STATION_ICON = 8;

    public MetadataKey() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "RDS_PS";
    L7:
        if (o != 2) goto L11;
        return "RDS_PTY";
    L11:
        if (o != 3) goto L15;
        return "RBDS_PTY";
    L15:
        if (o != 4) goto L19;
        return "RDS_RT";
    L19:
        if (o != 5) goto L23;
        return "SONG_TITLE";
    L23:
        if (o != 6) goto L27;
        return "SONG_ARTIST";
    L27:
        if (o != 7) goto L31;
        return "SONG_ALBUM";
    L31:
        if (o != 8) goto L35;
        return "STATION_ICON";
    L35:
        if (o != 9) goto L39;
        return "ALBUM_ART";
    L39:
        if (o != 10) goto L43;
        return "PROGRAM_NAME";
    L43:
        if (o != 11) goto L47;
        return "DAB_ENSEMBLE_NAME";
    L47:
        if (o != 12) goto L51;
        return "DAB_ENSEMBLE_NAME_SHORT";
    L51:
        if (o != 13) goto L55;
        return "DAB_SERVICE_NAME";
    L55:
        if (o != 14) goto L59;
        return "DAB_SERVICE_NAME_SHORT";
    L59:
        if (o != 15) goto L63;
        return "DAB_COMPONENT_NAME";
    L63:
        if (o != 16) goto L67;
        return "DAB_COMPONENT_NAME_SHORT";
    L67:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("RDS_PS");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("RDS_PTY");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("RBDS_PTY");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("RDS_RT");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("SONG_TITLE");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("SONG_ARTIST");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("SONG_ALBUM");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("STATION_ICON");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L30;
        list.add("ALBUM_ART");
        flipped = flipped | 9;
    L30:
        if ((o & 10) != 10) goto L33;
        list.add("PROGRAM_NAME");
        flipped = flipped | 10;
    L33:
        if ((o & 11) != 11) goto L36;
        list.add("DAB_ENSEMBLE_NAME");
        flipped = flipped | 11;
    L36:
        if ((o & 12) != 12) goto L39;
        list.add("DAB_ENSEMBLE_NAME_SHORT");
        flipped = flipped | 12;
    L39:
        if ((o & 13) != 13) goto L42;
        list.add("DAB_SERVICE_NAME");
        flipped = flipped | 13;
    L42:
        if ((o & 14) != 14) goto L45;
        list.add("DAB_SERVICE_NAME_SHORT");
        flipped = flipped | 14;
    L45:
        if ((o & 15) != 15) goto L48;
        list.add("DAB_COMPONENT_NAME");
        flipped = flipped | 15;
    L48:
        if ((o & 16) != 16) goto L50;
        list.add("DAB_COMPONENT_NAME_SHORT");
        flipped = flipped | 16;
    L50:
        if (o == flipped) goto L53;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L53:
        return String.join(" | ", list);
    }
}
