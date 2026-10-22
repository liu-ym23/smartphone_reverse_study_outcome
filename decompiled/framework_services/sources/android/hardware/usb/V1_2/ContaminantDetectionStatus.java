package android.hardware.usb.V1_2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ContaminantDetectionStatus {
    public static final int DETECTED = 3;
    public static final int DISABLED = 1;
    public static final int NOT_DETECTED = 2;
    public static final int NOT_SUPPORTED = 0;

    public ContaminantDetectionStatus() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NOT_SUPPORTED";
    L6:
        if (o != 1) goto L10;
        return "DISABLED";
    L10:
        if (o != 2) goto L14;
        return "NOT_DETECTED";
    L14:
        if (o != 3) goto L18;
        return "DETECTED";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NOT_SUPPORTED");
        if ((o & 1) != 1) goto L6;
        list.add("DISABLED");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("NOT_DETECTED");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("DETECTED");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
