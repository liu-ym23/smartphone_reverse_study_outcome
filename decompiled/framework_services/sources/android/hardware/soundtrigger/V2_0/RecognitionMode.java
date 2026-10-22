package android.hardware.soundtrigger.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class RecognitionMode {
    public static final int GENERIC_TRIGGER = 8;
    public static final int USER_AUTHENTICATION = 4;
    public static final int USER_IDENTIFICATION = 2;
    public static final int VOICE_TRIGGER = 1;

    public RecognitionMode() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "VOICE_TRIGGER";
    L7:
        if (o != 2) goto L11;
        return "USER_IDENTIFICATION";
    L11:
        if (o != 4) goto L15;
        return "USER_AUTHENTICATION";
    L15:
        if (o != 8) goto L19;
        return "GENERIC_TRIGGER";
    L19:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("VOICE_TRIGGER");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("USER_IDENTIFICATION");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L12;
        list.add("USER_AUTHENTICATION");
        flipped = flipped | 4;
    L12:
        if ((o & 8) != 8) goto L14;
        list.add("GENERIC_TRIGGER");
        flipped = flipped | 8;
    L14:
        if (o == flipped) goto L17;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L17:
        return String.join(" | ", list);
    }
}
