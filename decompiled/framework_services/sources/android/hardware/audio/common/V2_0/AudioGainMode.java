package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioGainMode {
    public static final int CHANNELS = 2;
    public static final int JOINT = 1;
    public static final int RAMP = 4;

    public AudioGainMode() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "JOINT";
    L7:
        if (o != 2) goto L11;
        return "CHANNELS";
    L11:
        if (o != 4) goto L15;
        return "RAMP";
    L15:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("JOINT");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("CHANNELS");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L11;
        list.add("RAMP");
        flipped = flipped | 4;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
