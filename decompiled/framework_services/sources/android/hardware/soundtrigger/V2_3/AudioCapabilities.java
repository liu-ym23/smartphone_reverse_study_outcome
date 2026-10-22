package android.hardware.soundtrigger.V2_3;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioCapabilities {
    public static final int ECHO_CANCELLATION = 1;
    public static final int NOISE_SUPPRESSION = 2;

    public AudioCapabilities() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "ECHO_CANCELLATION";
    L7:
        if (o != 2) goto L11;
        return "NOISE_SUPPRESSION";
    L11:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("ECHO_CANCELLATION");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("NOISE_SUPPRESSION");
        flipped = flipped | 2;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
