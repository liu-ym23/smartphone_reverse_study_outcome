package android.hardware.biometrics.face.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Feature {
    public static final int REQUIRE_ATTENTION = 1;
    public static final int REQUIRE_DIVERSITY = 2;

    public Feature() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "REQUIRE_ATTENTION";
    L7:
        if (o != 2) goto L11;
        return "REQUIRE_DIVERSITY";
    L11:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("REQUIRE_ATTENTION");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("REQUIRE_DIVERSITY");
        flipped = flipped | 2;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
