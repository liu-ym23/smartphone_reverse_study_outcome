package android.hardware.health.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Result {
    public static final int CALLBACK_DIED = 4;
    public static final int NOT_FOUND = 3;
    public static final int NOT_SUPPORTED = 1;
    public static final int SUCCESS = 0;
    public static final int UNKNOWN = 2;

    public Result() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "SUCCESS";
    L6:
        if (o != 1) goto L10;
        return "NOT_SUPPORTED";
    L10:
        if (o != 2) goto L14;
        return "UNKNOWN";
    L14:
        if (o != 3) goto L18;
        return "NOT_FOUND";
    L18:
        if (o != 4) goto L22;
        return "CALLBACK_DIED";
    L22:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("SUCCESS");
        if ((o & 1) != 1) goto L6;
        list.add("NOT_SUPPORTED");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("UNKNOWN");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("NOT_FOUND");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L14;
        list.add("CALLBACK_DIED");
        flipped = flipped | 4;
    L14:
        if (o == flipped) goto L17;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L17:
        return String.join(" | ", list);
    }
}
