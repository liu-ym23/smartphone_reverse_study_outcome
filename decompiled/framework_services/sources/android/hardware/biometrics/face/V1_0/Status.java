package android.hardware.biometrics.face.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Status {
    public static final int ILLEGAL_ARGUMENT = 1;
    public static final int INTERNAL_ERROR = 3;
    public static final int NOT_ENROLLED = 4;
    public static final int OK = 0;
    public static final int OPERATION_NOT_SUPPORTED = 2;

    public Status() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "OK";
    L6:
        if (o != 1) goto L10;
        return "ILLEGAL_ARGUMENT";
    L10:
        if (o != 2) goto L14;
        return "OPERATION_NOT_SUPPORTED";
    L14:
        if (o != 3) goto L18;
        return "INTERNAL_ERROR";
    L18:
        if (o != 4) goto L22;
        return "NOT_ENROLLED";
    L22:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("OK");
        if ((o & 1) != 1) goto L6;
        list.add("ILLEGAL_ARGUMENT");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("OPERATION_NOT_SUPPORTED");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("INTERNAL_ERROR");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L14;
        list.add("NOT_ENROLLED");
        flipped = flipped | 4;
    L14:
        if (o == flipped) goto L17;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L17:
        return String.join(" | ", list);
    }
}
