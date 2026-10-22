package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AnnouncementType {
    public static final byte EMERGENCY = 1;
    public static final byte EVENT = 6;
    public static final byte MISC = 8;
    public static final byte NEWS = 5;
    public static final byte SPORT = 7;
    public static final byte TRAFFIC = 3;
    public static final byte WARNING = 2;
    public static final byte WEATHER = 4;

    public AnnouncementType() {
    }

    public static final String toString(byte o) {
        if (o != 1) goto L7;
        return "EMERGENCY";
    L7:
        if (o != 2) goto L11;
        return "WARNING";
    L11:
        if (o != 3) goto L15;
        return "TRAFFIC";
    L15:
        if (o != 4) goto L19;
        return "WEATHER";
    L19:
        if (o != 5) goto L23;
        return "NEWS";
    L23:
        if (o != 6) goto L27;
        return "EVENT";
    L27:
        if (o != 7) goto L31;
        return "SPORT";
    L31:
        if (o != 8) goto L35;
        return "MISC";
    L35:
        return "0x" + Integer.toHexString(Byte.toUnsignedInt(o));
    }

    public static final String dumpBitfield(byte o) {
        ArrayList<String> list = new ArrayList();
        byte flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("EMERGENCY");
        flipped = (byte) (0 | 1);
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("WARNING");
        flipped = (byte) (flipped | 2);
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("TRAFFIC");
        flipped = (byte) (flipped | 3);
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("WEATHER");
        flipped = (byte) (flipped | 4);
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("NEWS");
        flipped = (byte) (flipped | 5);
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("EVENT");
        flipped = (byte) (flipped | 6);
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("SPORT");
        flipped = (byte) (flipped | 7);
    L24:
        if ((o & 8) != 8) goto L26;
        list.add("MISC");
        flipped = (byte) (flipped | 8);
    L26:
        if (o == flipped) goto L29;
        list.add("0x" + Integer.toHexString(Byte.toUnsignedInt((byte) ((~flipped) & o))));
    L29:
        return String.join(" | ", list);
    }
}
