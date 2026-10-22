package android.hardware.oemlock.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class OemLockStatus {
    public static final int FAILED = 1;
    public static final int OK = 0;

    public OemLockStatus() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "OK";
    L6:
        if (o != 1) goto L10;
        return "FAILED";
    L10:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("OK");
        if ((o & 1) != 1) goto L5;
        list.add("FAILED");
        flipped = 0 | 1;
    L5:
        if (o == flipped) goto L8;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L8:
        return String.join(" | ", list);
    }
}
