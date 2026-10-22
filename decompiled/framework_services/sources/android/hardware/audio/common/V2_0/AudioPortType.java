package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioPortType {
    public static final int DEVICE = 1;
    public static final int MIX = 2;
    public static final int NONE = 0;
    public static final int SESSION = 3;

    public AudioPortType() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "DEVICE";
    L10:
        if (o != 2) goto L14;
        return "MIX";
    L14:
        if (o != 3) goto L18;
        return "SESSION";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("DEVICE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("MIX");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("SESSION");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
