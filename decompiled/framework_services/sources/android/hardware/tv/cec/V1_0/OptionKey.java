package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class OptionKey {
    public static final int ENABLE_CEC = 2;
    public static final int SYSTEM_CEC_CONTROL = 3;
    public static final int WAKEUP = 1;

    public OptionKey() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "WAKEUP";
    L7:
        if (o != 2) goto L11;
        return "ENABLE_CEC";
    L11:
        if (o != 3) goto L15;
        return "SYSTEM_CEC_CONTROL";
    L15:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("WAKEUP");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("ENABLE_CEC");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("SYSTEM_CEC_CONTROL");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
