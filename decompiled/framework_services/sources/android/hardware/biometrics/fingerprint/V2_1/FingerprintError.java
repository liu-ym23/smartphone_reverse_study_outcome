package android.hardware.biometrics.fingerprint.V2_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FingerprintError {
    public static final int ERROR_CANCELED = 5;
    public static final int ERROR_HW_UNAVAILABLE = 1;
    public static final int ERROR_LOCKOUT = 7;
    public static final int ERROR_NO_ERROR = 0;
    public static final int ERROR_NO_SPACE = 4;
    public static final int ERROR_TIMEOUT = 3;
    public static final int ERROR_UNABLE_TO_PROCESS = 2;
    public static final int ERROR_UNABLE_TO_REMOVE = 6;
    public static final int ERROR_VENDOR = 8;

    public FingerprintError() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "ERROR_NO_ERROR";
    L6:
        if (o != 1) goto L10;
        return "ERROR_HW_UNAVAILABLE";
    L10:
        if (o != 2) goto L14;
        return "ERROR_UNABLE_TO_PROCESS";
    L14:
        if (o != 3) goto L18;
        return "ERROR_TIMEOUT";
    L18:
        if (o != 4) goto L22;
        return "ERROR_NO_SPACE";
    L22:
        if (o != 5) goto L26;
        return "ERROR_CANCELED";
    L26:
        if (o != 6) goto L30;
        return "ERROR_UNABLE_TO_REMOVE";
    L30:
        if (o != 7) goto L34;
        return "ERROR_LOCKOUT";
    L34:
        if (o != 8) goto L38;
        return "ERROR_VENDOR";
    L38:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("ERROR_NO_ERROR");
        if ((o & 1) != 1) goto L6;
        list.add("ERROR_HW_UNAVAILABLE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("ERROR_UNABLE_TO_PROCESS");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("ERROR_TIMEOUT");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("ERROR_NO_SPACE");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("ERROR_CANCELED");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("ERROR_UNABLE_TO_REMOVE");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("ERROR_LOCKOUT");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L26;
        list.add("ERROR_VENDOR");
        flipped = flipped | 8;
    L26:
        if (o == flipped) goto L29;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L29:
        return String.join(" | ", list);
    }
}
