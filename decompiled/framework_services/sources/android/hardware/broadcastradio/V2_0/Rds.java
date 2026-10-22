package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Rds {
    public static final byte RBDS = 2;
    public static final byte RDS = 1;

    public Rds() {
    }

    public static final String toString(byte o) {
        if (o != 1) goto L7;
        return "RDS";
    L7:
        if (o != 2) goto L11;
        return "RBDS";
    L11:
        return "0x" + Integer.toHexString(Byte.toUnsignedInt(o));
    }

    public static final String dumpBitfield(byte o) {
        ArrayList<String> list = new ArrayList();
        byte flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("RDS");
        flipped = (byte) (0 | 1);
    L6:
        if ((o & 2) != 2) goto L8;
        list.add("RBDS");
        flipped = (byte) (flipped | 2);
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString(Byte.toUnsignedInt((byte) ((~flipped) & o))));
    L11:
        return String.join(" | ", list);
    }
}
