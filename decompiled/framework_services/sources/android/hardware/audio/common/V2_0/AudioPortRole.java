package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioPortRole {
    public static final int NONE = 0;
    public static final int SINK = 2;
    public static final int SOURCE = 1;

    public AudioPortRole() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "SOURCE";
    L10:
        if (o != 2) goto L14;
        return "SINK";
    L14:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("SOURCE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("SINK");
        flipped = flipped | 2;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
