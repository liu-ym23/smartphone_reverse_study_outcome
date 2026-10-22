package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MaxLength {
    public static final int MESSAGE_BODY = 15;

    public MaxLength() {
    }

    public static final String toString(int o) {
        if (o != 15) goto L7;
        return "MESSAGE_BODY";
    L7:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 15) != 15) goto L5;
        list.add("MESSAGE_BODY");
        flipped = 0 | 15;
    L5:
        if (o == flipped) goto L8;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L8:
        return String.join(" | ", list);
    }
}
