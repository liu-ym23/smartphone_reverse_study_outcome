package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioInputFlag {
    public static final int FAST = 1;
    public static final int HW_HOTWORD = 2;
    public static final int MMAP_NOIRQ = 16;
    public static final int NONE = 0;
    public static final int RAW = 4;
    public static final int SYNC = 8;
    public static final int VOIP_TX = 32;

    public AudioInputFlag() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "FAST";
    L10:
        if (o != 2) goto L14;
        return "HW_HOTWORD";
    L14:
        if (o != 4) goto L18;
        return "RAW";
    L18:
        if (o != 8) goto L22;
        return "SYNC";
    L22:
        if (o != 16) goto L26;
        return "MMAP_NOIRQ";
    L26:
        if (o != 32) goto L30;
        return "VOIP_TX";
    L30:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("FAST");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("HW_HOTWORD");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L12;
        list.add("RAW");
        flipped = flipped | 4;
    L12:
        if ((o & 8) != 8) goto L15;
        list.add("SYNC");
        flipped = flipped | 8;
    L15:
        if ((o & 16) != 16) goto L18;
        list.add("MMAP_NOIRQ");
        flipped = flipped | 16;
    L18:
        if ((o & 32) != 32) goto L20;
        list.add("VOIP_TX");
        flipped = flipped | 32;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
