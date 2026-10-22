package android.hardware.usb.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PortDataRole {
    public static final int DEVICE = 2;
    public static final int HOST = 1;
    public static final int NONE = 0;
    public static final int NUM_DATA_ROLES = 3;

    public PortDataRole() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "HOST";
    L10:
        if (o != 2) goto L14;
        return "DEVICE";
    L14:
        if (o != 3) goto L18;
        return "NUM_DATA_ROLES";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("HOST");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("DEVICE");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("NUM_DATA_ROLES");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
