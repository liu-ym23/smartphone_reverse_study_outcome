package android.hardware.health.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryHealth {
    public static final int COLD = 7;
    public static final int DEAD = 4;
    public static final int GOOD = 2;
    public static final int OVERHEAT = 3;
    public static final int OVER_VOLTAGE = 5;
    public static final int UNKNOWN = 1;
    public static final int UNSPECIFIED_FAILURE = 6;

    public BatteryHealth() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "UNKNOWN";
    L7:
        if (o != 2) goto L11;
        return "GOOD";
    L11:
        if (o != 3) goto L15;
        return "OVERHEAT";
    L15:
        if (o != 4) goto L19;
        return "DEAD";
    L19:
        if (o != 5) goto L23;
        return "OVER_VOLTAGE";
    L23:
        if (o != 6) goto L27;
        return "UNSPECIFIED_FAILURE";
    L27:
        if (o != 7) goto L31;
        return "COLD";
    L31:
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
        list.add("GOOD");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("OVERHEAT");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("DEAD");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("OVER_VOLTAGE");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("UNSPECIFIED_FAILURE");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L23;
        list.add("COLD");
        flipped = flipped | 7;
    L23:
        if (o == flipped) goto L26;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L26:
        return String.join(" | ", list);
    }
}
