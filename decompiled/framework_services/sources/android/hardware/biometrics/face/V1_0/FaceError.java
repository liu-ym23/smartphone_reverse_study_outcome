package android.hardware.biometrics.face.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FaceError {
    public static final int CANCELED = 5;
    public static final int HW_UNAVAILABLE = 1;
    public static final int LOCKOUT = 7;
    public static final int LOCKOUT_PERMANENT = 9;
    public static final int NO_SPACE = 4;
    public static final int TIMEOUT = 3;
    public static final int UNABLE_TO_PROCESS = 2;
    public static final int UNABLE_TO_REMOVE = 6;
    public static final int VENDOR = 8;

    public FaceError() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "HW_UNAVAILABLE";
    L7:
        if (o != 2) goto L11;
        return "UNABLE_TO_PROCESS";
    L11:
        if (o != 3) goto L15;
        return "TIMEOUT";
    L15:
        if (o != 4) goto L19;
        return "NO_SPACE";
    L19:
        if (o != 5) goto L23;
        return "CANCELED";
    L23:
        if (o != 6) goto L27;
        return "UNABLE_TO_REMOVE";
    L27:
        if (o != 7) goto L31;
        return "LOCKOUT";
    L31:
        if (o != 8) goto L35;
        return "VENDOR";
    L35:
        if (o != 9) goto L39;
        return "LOCKOUT_PERMANENT";
    L39:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("HW_UNAVAILABLE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("UNABLE_TO_PROCESS");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("TIMEOUT");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("NO_SPACE");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("CANCELED");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("UNABLE_TO_REMOVE");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("LOCKOUT");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("VENDOR");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L29;
        list.add("LOCKOUT_PERMANENT");
        flipped = flipped | 9;
    L29:
        if (o == flipped) goto L32;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L32:
        return String.join(" | ", list);
    }
}
