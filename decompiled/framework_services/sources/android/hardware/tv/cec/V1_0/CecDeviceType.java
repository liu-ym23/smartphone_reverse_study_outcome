package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CecDeviceType {
    public static final int AUDIO_SYSTEM = 5;
    public static final int INACTIVE = -1;
    public static final int MAX = 5;
    public static final int PLAYBACK = 4;
    public static final int RECORDER = 1;
    public static final int TUNER = 3;
    public static final int TV = 0;

    public CecDeviceType() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "INACTIVE";
    L6:
        if (o != 0) goto L10;
        return "TV";
    L10:
        if (o != 1) goto L14;
        return "RECORDER";
    L14:
        if (o != 3) goto L18;
        return "TUNER";
    L18:
        if (o != 4) goto L22;
        return "PLAYBACK";
    L22:
        if (o != 5) goto L25;
        return "AUDIO_SYSTEM";
    L25:
        if (o != 5) goto L29;
        return "MAX";
    L29:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("INACTIVE");
        flipped = 0 | (-1);
    L5:
        list.add("TV");
        if ((o & 1) != 1) goto L9;
        list.add("RECORDER");
        flipped = flipped | 1;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("TUNER");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("PLAYBACK");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("AUDIO_SYSTEM");
        flipped = flipped | 5;
    L18:
        if ((o & 5) != 5) goto L20;
        list.add("MAX");
        flipped = flipped | 5;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
