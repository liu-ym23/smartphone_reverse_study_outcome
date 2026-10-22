package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioInterleave {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public AudioInterleave() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "LEFT";
    L6:
        if (o != 1) goto L10;
        return "RIGHT";
    L10:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("LEFT");
        if ((o & 1) != 1) goto L5;
        list.add("RIGHT");
        flipped = 0 | 1;
    L5:
        if (o == flipped) goto L8;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L8:
        return String.join(" | ", list);
    }
}
