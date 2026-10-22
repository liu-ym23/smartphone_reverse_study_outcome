package android.hardware.health.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryStatus {
    public static final int CHARGING = 2;
    public static final int DISCHARGING = 3;
    public static final int FULL = 5;
    public static final int NOT_CHARGING = 4;
    public static final int UNKNOWN = 1;

    public BatteryStatus() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "UNKNOWN";
    L7:
        if (o != 2) goto L11;
        return "CHARGING";
    L11:
        if (o != 3) goto L15;
        return "DISCHARGING";
    L15:
        if (o != 4) goto L19;
        return "NOT_CHARGING";
    L19:
        if (o != 5) goto L23;
        return "FULL";
    L23:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("UNKNOWN");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("CHARGING");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("DISCHARGING");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("NOT_CHARGING");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L17;
        list.add("FULL");
        flipped = flipped | 5;
    L17:
        if (o == flipped) goto L20;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L20:
        return String.join(" | ", list);
    }
}
