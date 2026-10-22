package android.hardware.boot.V1_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MergeStatus {
    public static final int CANCELLED = 4;
    public static final int MERGING = 3;
    public static final int NONE = 0;
    public static final int SNAPSHOTTED = 2;
    public static final int UNKNOWN = 1;

    public MergeStatus() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "UNKNOWN";
    L10:
        if (o != 2) goto L14;
        return "SNAPSHOTTED";
    L14:
        if (o != 3) goto L18;
        return "MERGING";
    L18:
        if (o != 4) goto L22;
        return "CANCELLED";
    L22:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("UNKNOWN");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("SNAPSHOTTED");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("MERGING");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L14;
        list.add("CANCELLED");
        flipped = flipped | 4;
    L14:
        if (o == flipped) goto L17;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L17:
        return String.join(" | ", list);
    }
}
