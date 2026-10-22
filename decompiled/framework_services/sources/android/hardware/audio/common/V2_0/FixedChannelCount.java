package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FixedChannelCount {
    public static final int FCC_2 = 2;
    public static final int FCC_8 = 8;

    public FixedChannelCount() {
    }

    public static final String toString(int o) {
        if (o != 2) goto L7;
        return "FCC_2";
    L7:
        if (o != 8) goto L11;
        return "FCC_8";
    L11:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 2) != 2) goto L6;
        list.add("FCC_2");
        flipped = 0 | 2;
    L6:
        if ((o & 8) != 8) goto L8;
        list.add("FCC_8");
        flipped = flipped | 8;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
