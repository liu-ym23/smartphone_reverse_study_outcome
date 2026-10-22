package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioPortConfigMask {
    public static final int ALL = 15;
    public static final int CHANNEL_MASK = 2;
    public static final int FORMAT = 4;
    public static final int GAIN = 8;
    public static final int SAMPLE_RATE = 1;

    public AudioPortConfigMask() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "SAMPLE_RATE";
    L7:
        if (o != 2) goto L11;
        return "CHANNEL_MASK";
    L11:
        if (o != 4) goto L15;
        return "FORMAT";
    L15:
        if (o != 8) goto L19;
        return "GAIN";
    L19:
        if (o != 15) goto L23;
        return "ALL";
    L23:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("SAMPLE_RATE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("CHANNEL_MASK");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L12;
        list.add("FORMAT");
        flipped = flipped | 4;
    L12:
        if ((o & 8) != 8) goto L15;
        list.add("GAIN");
        flipped = flipped | 8;
    L15:
        if ((o & 15) != 15) goto L17;
        list.add("ALL");
        flipped = flipped | 15;
    L17:
        if (o == flipped) goto L20;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L20:
        return String.join(" | ", list);
    }
}
