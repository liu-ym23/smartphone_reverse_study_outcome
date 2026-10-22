package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AbortReason {
    public static final int CANNOT_PROVIDE_SOURCE = 2;
    public static final int INVALID_OPERAND = 3;
    public static final int NOT_IN_CORRECT_MODE = 1;
    public static final int REFUSED = 4;
    public static final int UNABLE_TO_DETERMINE = 5;
    public static final int UNRECOGNIZED_MODE = 0;

    public AbortReason() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "UNRECOGNIZED_MODE";
    L6:
        if (o != 1) goto L10;
        return "NOT_IN_CORRECT_MODE";
    L10:
        if (o != 2) goto L14;
        return "CANNOT_PROVIDE_SOURCE";
    L14:
        if (o != 3) goto L18;
        return "INVALID_OPERAND";
    L18:
        if (o != 4) goto L22;
        return "REFUSED";
    L22:
        if (o != 5) goto L26;
        return "UNABLE_TO_DETERMINE";
    L26:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("UNRECOGNIZED_MODE");
        if ((o & 1) != 1) goto L6;
        list.add("NOT_IN_CORRECT_MODE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("CANNOT_PROVIDE_SOURCE");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("INVALID_OPERAND");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("REFUSED");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L17;
        list.add("UNABLE_TO_DETERMINE");
        flipped = flipped | 5;
    L17:
        if (o == flipped) goto L20;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L20:
        return String.join(" | ", list);
    }
}
