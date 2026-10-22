package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Deemphasis {
    public static final byte D50 = 1;
    public static final byte D75 = 2;

    public Deemphasis() {
    }

    public static final String toString(byte o) {
        if (o != 1) goto L7;
        return "D50";
    L7:
        if (o != 2) goto L11;
        return "D75";
    L11:
        return "0x" + Integer.toHexString(Byte.toUnsignedInt(o));
    }

    public static final String dumpBitfield(byte o) {
        ArrayList<String> list = new ArrayList();
        byte flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("D50");
        flipped = (byte) (0 | 1);
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("D75");
        flipped = (byte) (flipped | 2);
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString(Byte.toUnsignedInt((byte) ((~flipped) & o))));
    L11:
        return String.join(" | ", list);
    }
}
