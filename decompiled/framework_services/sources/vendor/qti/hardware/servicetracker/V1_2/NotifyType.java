package vendor.qti.hardware.servicetracker.V1_2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class NotifyType {
    public static final int BOTH = 2;
    public static final int EARLY = 0;
    public static final int LATE = 1;

    public NotifyType() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "EARLY";
    L6:
        if (o != 1) goto L10;
        return "LATE";
    L10:
        if (o != 2) goto L14;
        return "BOTH";
    L14:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("EARLY");
        if ((o & 1) != 1) goto L6;
        list.add("LATE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("BOTH");
        flipped = flipped | 2;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
