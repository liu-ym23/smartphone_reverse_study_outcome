package android.hardware.boot.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BoolResult {
    public static final int FALSE = 0;
    public static final int INVALID_SLOT = -1;
    public static final int TRUE = 1;

    public BoolResult() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "FALSE";
    L6:
        if (o != 1) goto L10;
        return "TRUE";
    L10:
        if (o != (-1)) goto L14;
        return "INVALID_SLOT";
    L14:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("FALSE");
        if ((o & 1) != 1) goto L6;
        list.add("TRUE");
        flipped = 0 | 1;
    L6:
        if ((o & (-1)) != (-1)) goto L8;
        list.add("INVALID_SLOT");
        flipped = flipped | (-1);
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
