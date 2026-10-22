package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Result {
    public static final int FAILURE_BUSY = 5;
    public static final int FAILURE_INVALID_ARGS = 2;
    public static final int FAILURE_INVALID_STATE = 3;
    public static final int FAILURE_NOT_SUPPORTED = 4;
    public static final int FAILURE_UNKNOWN = 1;
    public static final int SUCCESS = 0;

    public Result() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "SUCCESS";
    L6:
        if (o != 1) goto L10;
        return "FAILURE_UNKNOWN";
    L10:
        if (o != 2) goto L14;
        return "FAILURE_INVALID_ARGS";
    L14:
        if (o != 3) goto L18;
        return "FAILURE_INVALID_STATE";
    L18:
        if (o != 4) goto L22;
        return "FAILURE_NOT_SUPPORTED";
    L22:
        if (o != 5) goto L26;
        return "FAILURE_BUSY";
    L26:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("SUCCESS");
        if ((o & 1) != 1) goto L6;
        list.add("FAILURE_UNKNOWN");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("FAILURE_INVALID_ARGS");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("FAILURE_INVALID_STATE");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("FAILURE_NOT_SUPPORTED");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L17;
        list.add("FAILURE_BUSY");
        flipped = flipped | 5;
    L17:
        if (o == flipped) goto L20;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L20:
        return String.join(" | ", list);
    }
}
