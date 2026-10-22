package android.hardware.weaver.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class WeaverReadStatus {
    public static final int FAILED = 1;
    public static final int INCORRECT_KEY = 2;
    public static final int OK = 0;
    public static final int THROTTLE = 3;

    public WeaverReadStatus() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "OK";
    L6:
        if (o != 1) goto L10;
        return "FAILED";
    L10:
        if (o != 2) goto L14;
        return "INCORRECT_KEY";
    L14:
        if (o != 3) goto L18;
        return "THROTTLE";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("OK");
        if ((o & 1) != 1) goto L6;
        list.add("FAILED");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("INCORRECT_KEY");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("THROTTLE");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
