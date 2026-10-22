package android.hardware.usb.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PortRoleType {
    public static final int DATA_ROLE = 0;
    public static final int MODE = 2;
    public static final int POWER_ROLE = 1;

    public PortRoleType() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "DATA_ROLE";
    L6:
        if (o != 1) goto L10;
        return "POWER_ROLE";
    L10:
        if (o != 2) goto L14;
        return "MODE";
    L14:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("DATA_ROLE");
        if ((o & 1) != 1) goto L6;
        list.add("POWER_ROLE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("MODE");
        flipped = flipped | 2;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
