package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Constants {
    public static final int ANTENNA_DISCONNECTED_TIMEOUT_MS = 100;
    public static final int INVALID_IMAGE = 0;
    public static final int LIST_COMPLETE_TIMEOUT_MS = 300000;

    public Constants() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "INVALID_IMAGE";
    L6:
        if (o != 100) goto L10;
        return "ANTENNA_DISCONNECTED_TIMEOUT_MS";
    L10:
        if (o != 300000) goto L14;
        return "LIST_COMPLETE_TIMEOUT_MS";
    L14:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("INVALID_IMAGE");
        if ((o & 100) != 100) goto L6;
        list.add("ANTENNA_DISCONNECTED_TIMEOUT_MS");
        flipped = 0 | 100;
    L6:
        if ((o & 300000) != 300000) goto L8;
        list.add("LIST_COMPLETE_TIMEOUT_MS");
        flipped = flipped | 300000;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
