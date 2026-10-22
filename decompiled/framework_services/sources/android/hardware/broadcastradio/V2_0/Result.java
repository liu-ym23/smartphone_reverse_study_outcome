package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Result {
    public static final int INTERNAL_ERROR = 2;
    public static final int INVALID_ARGUMENTS = 3;
    public static final int INVALID_STATE = 4;
    public static final int NOT_SUPPORTED = 5;
    public static final int OK = 0;
    public static final int TIMEOUT = 6;
    public static final int UNKNOWN_ERROR = 1;

    public Result() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "OK";
    L6:
        if (o != 1) goto L10;
        return "UNKNOWN_ERROR";
    L10:
        if (o != 2) goto L14;
        return "INTERNAL_ERROR";
    L14:
        if (o != 3) goto L18;
        return "INVALID_ARGUMENTS";
    L18:
        if (o != 4) goto L22;
        return "INVALID_STATE";
    L22:
        if (o != 5) goto L26;
        return "NOT_SUPPORTED";
    L26:
        if (o != 6) goto L30;
        return "TIMEOUT";
    L30:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("OK");
        if ((o & 1) != 1) goto L6;
        list.add("UNKNOWN_ERROR");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("INTERNAL_ERROR");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("INVALID_ARGUMENTS");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("INVALID_STATE");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("NOT_SUPPORTED");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L20;
        list.add("TIMEOUT");
        flipped = flipped | 6;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
