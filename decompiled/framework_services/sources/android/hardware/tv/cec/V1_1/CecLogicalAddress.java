package android.hardware.tv.cec.V1_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CecLogicalAddress {
    public static final int AUDIO_SYSTEM = 5;
    public static final int BACKUP_1 = 12;
    public static final int BACKUP_2 = 13;
    public static final int BROADCAST = 15;
    public static final int FREE_USE = 14;
    public static final int PLAYBACK_1 = 4;
    public static final int PLAYBACK_2 = 8;
    public static final int PLAYBACK_3 = 11;
    public static final int RECORDER_1 = 1;
    public static final int RECORDER_2 = 2;
    public static final int RECORDER_3 = 9;
    public static final int TUNER_1 = 3;
    public static final int TUNER_2 = 6;
    public static final int TUNER_3 = 7;
    public static final int TUNER_4 = 10;
    public static final int TV = 0;
    public static final int UNREGISTERED = 15;

    public CecLogicalAddress() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "TV";
    L6:
        if (o != 1) goto L10;
        return "RECORDER_1";
    L10:
        if (o != 2) goto L14;
        return "RECORDER_2";
    L14:
        if (o != 3) goto L18;
        return "TUNER_1";
    L18:
        if (o != 4) goto L22;
        return "PLAYBACK_1";
    L22:
        if (o != 5) goto L26;
        return "AUDIO_SYSTEM";
    L26:
        if (o != 6) goto L30;
        return "TUNER_2";
    L30:
        if (o != 7) goto L34;
        return "TUNER_3";
    L34:
        if (o != 8) goto L38;
        return "PLAYBACK_2";
    L38:
        if (o != 9) goto L42;
        return "RECORDER_3";
    L42:
        if (o != 10) goto L46;
        return "TUNER_4";
    L46:
        if (o != 11) goto L50;
        return "PLAYBACK_3";
    L50:
        if (o != 14) goto L54;
        return "FREE_USE";
    L54:
        if (o != 15) goto L57;
        return "UNREGISTERED";
    L57:
        if (o != 15) goto L61;
        return "BROADCAST";
    L61:
        if (o != 12) goto L65;
        return "BACKUP_1";
    L65:
        if (o != 13) goto L69;
        return "BACKUP_2";
    L69:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("TV");
        if ((o & 1) != 1) goto L6;
        list.add("RECORDER_1");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("RECORDER_2");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("TUNER_1");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("PLAYBACK_1");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("AUDIO_SYSTEM");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("TUNER_2");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("TUNER_3");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("PLAYBACK_2");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L30;
        list.add("RECORDER_3");
        flipped = flipped | 9;
    L30:
        if ((o & 10) != 10) goto L33;
        list.add("TUNER_4");
        flipped = flipped | 10;
    L33:
        if ((o & 11) != 11) goto L36;
        list.add("PLAYBACK_3");
        flipped = flipped | 11;
    L36:
        if ((o & 14) != 14) goto L39;
        list.add("FREE_USE");
        flipped = flipped | 14;
    L39:
        if ((o & 15) != 15) goto L42;
        list.add("UNREGISTERED");
        flipped = flipped | 15;
    L42:
        if ((o & 15) != 15) goto L45;
        list.add("BROADCAST");
        flipped = flipped | 15;
    L45:
        if ((o & 12) != 12) goto L48;
        list.add("BACKUP_1");
        flipped = flipped | 12;
    L48:
        if ((o & 13) != 13) goto L50;
        list.add("BACKUP_2");
        flipped = flipped | 13;
    L50:
        if (o == flipped) goto L53;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L53:
        return String.join(" | ", list);
    }
}
