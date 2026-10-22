package android.hardware.oemlock.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class OemLockSecureStatus {
    public static final int FAILED = 1;
    public static final int INVALID_SIGNATURE = 2;
    public static final int OK = 0;

    public OemLockSecureStatus() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "OK";
    L6:
        if (o != 1) goto L10;
        return "FAILED";
    L10:
        if (o != 2) goto L14;
        return "INVALID_SIGNATURE";
    L14:
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
        if ((o & 2) != 2) goto L8;
        list.add("INVALID_SIGNATURE");
        flipped = flipped | 2;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
