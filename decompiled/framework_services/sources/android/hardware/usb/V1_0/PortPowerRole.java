package android.hardware.usb.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PortPowerRole {
    public static final int NONE = 0;
    public static final int NUM_POWER_ROLES = 3;
    public static final int SINK = 2;
    public static final int SOURCE = 1;

    public PortPowerRole() {
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
        if (o != 3) goto L18;
        return "NUM_POWER_ROLES";
    L18:
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
        if ((o & 2) != 2) goto L9;
        list.add("SINK");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("NUM_POWER_ROLES");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
