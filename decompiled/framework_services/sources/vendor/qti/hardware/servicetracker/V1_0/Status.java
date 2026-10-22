package vendor.qti.hardware.servicetracker.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Status {
    public static final int ERROR_INVALID_ARGS = 2;
    public static final int ERROR_NOT_AVAILABLE = 1;
    public static final int ERROR_NOT_SUPPORTED = 3;
    public static final int ERROR_UNKNOWN = 4;
    public static final int SUCCESS = 0;

    public Status() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "SUCCESS";
    L6:
        if (o != 1) goto L10;
        return "ERROR_NOT_AVAILABLE";
    L10:
        if (o != 2) goto L14;
        return "ERROR_INVALID_ARGS";
    L14:
        if (o != 3) goto L18;
        return "ERROR_NOT_SUPPORTED";
    L18:
        if (o != 4) goto L22;
        return "ERROR_UNKNOWN";
    L22:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("SUCCESS");
        if ((o & 1) != 1) goto L6;
        list.add("ERROR_NOT_AVAILABLE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("ERROR_INVALID_ARGS");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("ERROR_NOT_SUPPORTED");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L14;
        list.add("ERROR_UNKNOWN");
        flipped = flipped | 4;
    L14:
        if (o == flipped) goto L17;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L17:
        return String.join(" | ", list);
    }
}
