package android.hardware.health.V2_1;

import com.android.server.utils.PriorityDump;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryCapacityLevel {
    public static final int CRITICAL = 1;
    public static final int FULL = 5;
    public static final int HIGH = 4;
    public static final int LOW = 2;
    public static final int NORMAL = 3;
    public static final int UNKNOWN = 0;
    public static final int UNSUPPORTED = -1;

    public BatteryCapacityLevel() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        if (o != 0) goto L10;
        return "UNKNOWN";
    L10:
        if (o != 1) goto L14;
        return PriorityDump.PRIORITY_ARG_CRITICAL;
    L14:
        if (o != 2) goto L18;
        return "LOW";
    L18:
        if (o != 3) goto L22;
        return PriorityDump.PRIORITY_ARG_NORMAL;
    L22:
        if (o != 4) goto L26;
        return PriorityDump.PRIORITY_ARG_HIGH;
    L26:
        if (o != 5) goto L30;
        return "FULL";
    L30:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("UNSUPPORTED");
        flipped = 0 | (-1);
    L5:
        list.add("UNKNOWN");
        if ((o & 1) != 1) goto L9;
        list.add(PriorityDump.PRIORITY_ARG_CRITICAL);
        flipped = flipped | 1;
    L9:
        if ((o & 2) != 2) goto L12;
        list.add("LOW");
        flipped = flipped | 2;
    L12:
        if ((o & 3) != 3) goto L15;
        list.add(PriorityDump.PRIORITY_ARG_NORMAL);
        flipped = flipped | 3;
    L15:
        if ((o & 4) != 4) goto L18;
        list.add(PriorityDump.PRIORITY_ARG_HIGH);
        flipped = flipped | 4;
    L18:
        if ((o & 5) != 5) goto L20;
        list.add("FULL");
        flipped = flipped | 5;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
