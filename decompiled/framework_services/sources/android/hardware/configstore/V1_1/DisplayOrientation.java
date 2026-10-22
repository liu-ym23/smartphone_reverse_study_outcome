package android.hardware.configstore.V1_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayOrientation {
    public static final byte ORIENTATION_0 = 0;
    public static final byte ORIENTATION_180 = 2;
    public static final byte ORIENTATION_270 = 3;
    public static final byte ORIENTATION_90 = 1;

    public DisplayOrientation() {
    }

    public static final String toString(byte o) {
        if (o != 0) goto L6;
        return "ORIENTATION_0";
    L6:
        if (o != 1) goto L10;
        return "ORIENTATION_90";
    L10:
        if (o != 2) goto L14;
        return "ORIENTATION_180";
    L14:
        if (o != 3) goto L18;
        return "ORIENTATION_270";
    L18:
        return "0x" + Integer.toHexString(Byte.toUnsignedInt(o));
    }

    public static final String dumpBitfield(byte o) {
        ArrayList<String> list = new ArrayList();
        byte flipped = 0;
        list.add("ORIENTATION_0");
        if ((o & 1) != 1) goto L6;
        list.add("ORIENTATION_90");
        flipped = (byte) (0 | 1);
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("ORIENTATION_180");
        flipped = (byte) (flipped | 2);
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("ORIENTATION_270");
        flipped = (byte) (flipped | 3);
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString(Byte.toUnsignedInt((byte) ((~flipped) & o))));
    L14:
        return String.join(" | ", list);
    }
}
