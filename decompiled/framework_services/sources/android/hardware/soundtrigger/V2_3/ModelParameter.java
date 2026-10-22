package android.hardware.soundtrigger.V2_3;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ModelParameter {
    public static final int INVALID = -1;
    public static final int THRESHOLD_FACTOR = 0;

    public ModelParameter() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "INVALID";
    L6:
        if (o != 0) goto L10;
        return "THRESHOLD_FACTOR";
    L10:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("INVALID");
        flipped = 0 | (-1);
    L5:
        list.add("THRESHOLD_FACTOR");
        if (o == flipped) goto L9;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L9:
        return String.join(" | ", list);
    }
}
