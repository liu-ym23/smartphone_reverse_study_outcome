package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioUsage {
    public static final int ALARM = 4;
    public static final int ASSISTANCE_ACCESSIBILITY = 11;
    public static final int ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int ASSISTANCE_SONIFICATION = 13;
    public static final int ASSISTANT = 16;
    public static final int CNT = 17;
    public static final int GAME = 14;
    public static final int MAX = 16;
    public static final int MEDIA = 1;
    public static final int NOTIFICATION = 5;
    public static final int NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int NOTIFICATION_EVENT = 10;
    public static final int NOTIFICATION_TELEPHONY_RINGTONE = 6;
    public static final int UNKNOWN = 0;
    public static final int VIRTUAL_SOURCE = 15;
    public static final int VOICE_COMMUNICATION = 2;
    public static final int VOICE_COMMUNICATION_SIGNALLING = 3;

    public AudioUsage() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "UNKNOWN";
    L6:
        if (o != 1) goto L10;
        return "MEDIA";
    L10:
        if (o != 2) goto L14;
        return "VOICE_COMMUNICATION";
    L14:
        if (o != 3) goto L18;
        return "VOICE_COMMUNICATION_SIGNALLING";
    L18:
        if (o != 4) goto L22;
        return "ALARM";
    L22:
        if (o != 5) goto L26;
        return "NOTIFICATION";
    L26:
        if (o != 6) goto L30;
        return "NOTIFICATION_TELEPHONY_RINGTONE";
    L30:
        if (o != 7) goto L34;
        return "NOTIFICATION_COMMUNICATION_REQUEST";
    L34:
        if (o != 8) goto L38;
        return "NOTIFICATION_COMMUNICATION_INSTANT";
    L38:
        if (o != 9) goto L42;
        return "NOTIFICATION_COMMUNICATION_DELAYED";
    L42:
        if (o != 10) goto L46;
        return "NOTIFICATION_EVENT";
    L46:
        if (o != 11) goto L50;
        return "ASSISTANCE_ACCESSIBILITY";
    L50:
        if (o != 12) goto L54;
        return "ASSISTANCE_NAVIGATION_GUIDANCE";
    L54:
        if (o != 13) goto L58;
        return "ASSISTANCE_SONIFICATION";
    L58:
        if (o != 14) goto L62;
        return "GAME";
    L62:
        if (o != 15) goto L66;
        return "VIRTUAL_SOURCE";
    L66:
        if (o != 16) goto L70;
        return "ASSISTANT";
    L70:
        if (o != 17) goto L73;
        return "CNT";
    L73:
        if (o != 16) goto L77;
        return "MAX";
    L77:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("UNKNOWN");
        if ((o & 1) != 1) goto L6;
        list.add("MEDIA");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("VOICE_COMMUNICATION");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("VOICE_COMMUNICATION_SIGNALLING");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("ALARM");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("NOTIFICATION");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("NOTIFICATION_TELEPHONY_RINGTONE");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("NOTIFICATION_COMMUNICATION_REQUEST");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("NOTIFICATION_COMMUNICATION_INSTANT");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L30;
        list.add("NOTIFICATION_COMMUNICATION_DELAYED");
        flipped = flipped | 9;
    L30:
        if ((o & 10) != 10) goto L33;
        list.add("NOTIFICATION_EVENT");
        flipped = flipped | 10;
    L33:
        if ((o & 11) != 11) goto L36;
        list.add("ASSISTANCE_ACCESSIBILITY");
        flipped = flipped | 11;
    L36:
        if ((o & 12) != 12) goto L39;
        list.add("ASSISTANCE_NAVIGATION_GUIDANCE");
        flipped = flipped | 12;
    L39:
        if ((o & 13) != 13) goto L42;
        list.add("ASSISTANCE_SONIFICATION");
        flipped = flipped | 13;
    L42:
        if ((o & 14) != 14) goto L45;
        list.add("GAME");
        flipped = flipped | 14;
    L45:
        if ((o & 15) != 15) goto L48;
        list.add("VIRTUAL_SOURCE");
        flipped = flipped | 15;
    L48:
        if ((o & 16) != 16) goto L51;
        list.add("ASSISTANT");
        flipped = flipped | 16;
    L51:
        if ((o & 17) != 17) goto L54;
        list.add("CNT");
        flipped = flipped | 17;
    L54:
        if ((o & 16) != 16) goto L56;
        list.add("MAX");
        flipped = flipped | 16;
    L56:
        if (o == flipped) goto L59;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L59:
        return String.join(" | ", list);
    }
}
