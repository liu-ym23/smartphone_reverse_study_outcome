package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioSource {
    public static final int CAMCORDER = 5;
    public static final int CNT = 10;
    public static final int DEFAULT = 0;
    public static final int FM_TUNER = 1998;
    public static final int HOTWORD = 1999;
    public static final int MAX = 9;
    public static final int MIC = 1;
    public static final int REMOTE_SUBMIX = 8;
    public static final int UNPROCESSED = 9;
    public static final int VOICE_CALL = 4;
    public static final int VOICE_COMMUNICATION = 7;
    public static final int VOICE_DOWNLINK = 3;
    public static final int VOICE_RECOGNITION = 6;
    public static final int VOICE_UPLINK = 2;

    public AudioSource() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "DEFAULT";
    L6:
        if (o != 1) goto L10;
        return "MIC";
    L10:
        if (o != 2) goto L14;
        return "VOICE_UPLINK";
    L14:
        if (o != 3) goto L18;
        return "VOICE_DOWNLINK";
    L18:
        if (o != 4) goto L22;
        return "VOICE_CALL";
    L22:
        if (o != 5) goto L26;
        return "CAMCORDER";
    L26:
        if (o != 6) goto L30;
        return "VOICE_RECOGNITION";
    L30:
        if (o != 7) goto L34;
        return "VOICE_COMMUNICATION";
    L34:
        if (o != 8) goto L38;
        return "REMOTE_SUBMIX";
    L38:
        if (o != 9) goto L42;
        return "UNPROCESSED";
    L42:
        if (o != 10) goto L45;
        return "CNT";
    L45:
        if (o != 9) goto L49;
        return "MAX";
    L49:
        if (o != 1998) goto L53;
        return "FM_TUNER";
    L53:
        if (o != 1999) goto L57;
        return "HOTWORD";
    L57:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("DEFAULT");
        if ((o & 1) != 1) goto L6;
        list.add("MIC");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("VOICE_UPLINK");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("VOICE_DOWNLINK");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("VOICE_CALL");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("CAMCORDER");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("VOICE_RECOGNITION");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("VOICE_COMMUNICATION");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("REMOTE_SUBMIX");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L30;
        list.add("UNPROCESSED");
        flipped = flipped | 9;
    L30:
        if ((o & 10) != 10) goto L33;
        list.add("CNT");
        flipped = flipped | 10;
    L33:
        if ((o & 9) != 9) goto L36;
        list.add("MAX");
        flipped = flipped | 9;
    L36:
        if ((o & FM_TUNER) != 1998) goto L39;
        list.add("FM_TUNER");
        flipped = flipped | FM_TUNER;
    L39:
        if ((o & 1999) != 1999) goto L41;
        list.add("HOTWORD");
        flipped = flipped | 1999;
    L41:
        if (o == flipped) goto L44;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L44:
        return String.join(" | ", list);
    }
}
