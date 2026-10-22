package android.hardware.biometrics.fingerprint.V2_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FingerprintAcquiredInfo {
    public static final int ACQUIRED_GOOD = 0;
    public static final int ACQUIRED_IMAGER_DIRTY = 3;
    public static final int ACQUIRED_INSUFFICIENT = 2;
    public static final int ACQUIRED_PARTIAL = 1;
    public static final int ACQUIRED_TOO_FAST = 5;
    public static final int ACQUIRED_TOO_SLOW = 4;
    public static final int ACQUIRED_VENDOR = 6;

    public FingerprintAcquiredInfo() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "ACQUIRED_GOOD";
    L6:
        if (o != 1) goto L10;
        return "ACQUIRED_PARTIAL";
    L10:
        if (o != 2) goto L14;
        return "ACQUIRED_INSUFFICIENT";
    L14:
        if (o != 3) goto L18;
        return "ACQUIRED_IMAGER_DIRTY";
    L18:
        if (o != 4) goto L22;
        return "ACQUIRED_TOO_SLOW";
    L22:
        if (o != 5) goto L26;
        return "ACQUIRED_TOO_FAST";
    L26:
        if (o != 6) goto L30;
        return "ACQUIRED_VENDOR";
    L30:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("ACQUIRED_GOOD");
        if ((o & 1) != 1) goto L6;
        list.add("ACQUIRED_PARTIAL");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("ACQUIRED_INSUFFICIENT");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("ACQUIRED_IMAGER_DIRTY");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("ACQUIRED_TOO_SLOW");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("ACQUIRED_TOO_FAST");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L20;
        list.add("ACQUIRED_VENDOR");
        flipped = flipped | 6;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
