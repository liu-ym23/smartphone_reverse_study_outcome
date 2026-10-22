package android.hardware.usb.V1_2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ContaminantProtectionMode {
    public static final int FORCE_DISABLE = 4;
    public static final int FORCE_SINK = 1;
    public static final int FORCE_SOURCE = 2;
    public static final int NONE = 0;

    public ContaminantProtectionMode() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "FORCE_SINK";
    L10:
        if (o != 2) goto L14;
        return "FORCE_SOURCE";
    L14:
        if (o != 4) goto L18;
        return "FORCE_DISABLE";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("FORCE_SINK");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("FORCE_SOURCE");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L11;
        list.add("FORCE_DISABLE");
        flipped = flipped | 4;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
