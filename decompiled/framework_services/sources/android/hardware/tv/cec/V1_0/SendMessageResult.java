package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class SendMessageResult {
    public static final int BUSY = 2;
    public static final int FAIL = 3;
    public static final int NACK = 1;
    public static final int SUCCESS = 0;

    public SendMessageResult() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "SUCCESS";
    L6:
        if (o != 1) goto L10;
        return "NACK";
    L10:
        if (o != 2) goto L14;
        return "BUSY";
    L14:
        if (o != 3) goto L18;
        return "FAIL";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("SUCCESS");
        if ((o & 1) != 1) goto L6;
        list.add("NACK");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("BUSY");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("FAIL");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
