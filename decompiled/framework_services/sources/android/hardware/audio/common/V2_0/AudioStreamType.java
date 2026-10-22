package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioStreamType {
    public static final int ACCESSIBILITY = 10;
    public static final int ALARM = 4;
    public static final int BLUETOOTH_SCO = 6;
    public static final int CNT = 13;
    public static final int DEFAULT = -1;
    public static final int DTMF = 8;
    public static final int ENFORCED_AUDIBLE = 7;
    public static final int FOR_POLICY_CNT = 12;
    public static final int MIN = 0;
    public static final int MUSIC = 3;
    public static final int NOTIFICATION = 5;
    public static final int PATCH = 12;
    public static final int PUBLIC_CNT = 11;
    public static final int REROUTING = 11;
    public static final int RING = 2;
    public static final int SYSTEM = 1;
    public static final int TTS = 9;
    public static final int VOICE_CALL = 0;

    public AudioStreamType() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "DEFAULT";
    L6:
        if (o != 0) goto L9;
        return "MIN";
    L9:
        if (o != 0) goto L13;
        return "VOICE_CALL";
    L13:
        if (o != 1) goto L17;
        return "SYSTEM";
    L17:
        if (o != 2) goto L21;
        return "RING";
    L21:
        if (o != 3) goto L25;
        return "MUSIC";
    L25:
        if (o != 4) goto L29;
        return "ALARM";
    L29:
        if (o != 5) goto L33;
        return "NOTIFICATION";
    L33:
        if (o != 6) goto L37;
        return "BLUETOOTH_SCO";
    L37:
        if (o != 7) goto L41;
        return "ENFORCED_AUDIBLE";
    L41:
        if (o != 8) goto L45;
        return "DTMF";
    L45:
        if (o != 9) goto L49;
        return "TTS";
    L49:
        if (o != 10) goto L53;
        return "ACCESSIBILITY";
    L53:
        if (o != 11) goto L57;
        return "REROUTING";
    L57:
        if (o != 12) goto L60;
        return "PATCH";
    L60:
        if (o != 11) goto L63;
        return "PUBLIC_CNT";
    L63:
        if (o != 12) goto L67;
        return "FOR_POLICY_CNT";
    L67:
        if (o != 13) goto L71;
        return "CNT";
    L71:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("DEFAULT");
        flipped = 0 | (-1);
    L5:
        list.add("MIN");
        list.add("VOICE_CALL");
        if ((o & 1) != 1) goto L9;
        list.add("SYSTEM");
        flipped = flipped | 1;
    L9:
        if ((o & 2) != 2) goto L12;
        list.add("RING");
        flipped = flipped | 2;
    L12:
        if ((o & 3) != 3) goto L15;
        list.add("MUSIC");
        flipped = flipped | 3;
    L15:
        if ((o & 4) != 4) goto L18;
        list.add("ALARM");
        flipped = flipped | 4;
    L18:
        if ((o & 5) != 5) goto L21;
        list.add("NOTIFICATION");
        flipped = flipped | 5;
    L21:
        if ((o & 6) != 6) goto L24;
        list.add("BLUETOOTH_SCO");
        flipped = flipped | 6;
    L24:
        if ((o & 7) != 7) goto L27;
        list.add("ENFORCED_AUDIBLE");
        flipped = flipped | 7;
    L27:
        if ((o & 8) != 8) goto L30;
        list.add("DTMF");
        flipped = flipped | 8;
    L30:
        if ((o & 9) != 9) goto L33;
        list.add("TTS");
        flipped = flipped | 9;
    L33:
        if ((o & 10) != 10) goto L36;
        list.add("ACCESSIBILITY");
        flipped = flipped | 10;
    L36:
        if ((o & 11) != 11) goto L39;
        list.add("REROUTING");
        flipped = flipped | 11;
    L39:
        if ((o & 12) != 12) goto L42;
        list.add("PATCH");
        flipped = flipped | 12;
    L42:
        if ((o & 11) != 11) goto L45;
        list.add("PUBLIC_CNT");
        flipped = flipped | 11;
    L45:
        if ((o & 12) != 12) goto L48;
        list.add("FOR_POLICY_CNT");
        flipped = flipped | 12;
    L48:
        if ((o & 13) != 13) goto L50;
        list.add("CNT");
        flipped = flipped | 13;
    L50:
        if (o == flipped) goto L53;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L53:
        return String.join(" | ", list);
    }
}
