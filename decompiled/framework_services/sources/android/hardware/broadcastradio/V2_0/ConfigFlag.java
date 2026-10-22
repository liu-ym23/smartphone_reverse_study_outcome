package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigFlag {
    public static final int DAB_DAB_LINKING = 6;
    public static final int DAB_DAB_SOFT_LINKING = 8;
    public static final int DAB_FM_LINKING = 7;
    public static final int DAB_FM_SOFT_LINKING = 9;
    public static final int FORCE_ANALOG = 2;
    public static final int FORCE_DIGITAL = 3;
    public static final int FORCE_MONO = 1;
    public static final int RDS_AF = 4;
    public static final int RDS_REG = 5;

    public ConfigFlag() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "FORCE_MONO";
    L7:
        if (o != 2) goto L11;
        return "FORCE_ANALOG";
    L11:
        if (o != 3) goto L15;
        return "FORCE_DIGITAL";
    L15:
        if (o != 4) goto L19;
        return "RDS_AF";
    L19:
        if (o != 5) goto L23;
        return "RDS_REG";
    L23:
        if (o != 6) goto L27;
        return "DAB_DAB_LINKING";
    L27:
        if (o != 7) goto L31;
        return "DAB_FM_LINKING";
    L31:
        if (o != 8) goto L35;
        return "DAB_DAB_SOFT_LINKING";
    L35:
        if (o != 9) goto L39;
        return "DAB_FM_SOFT_LINKING";
    L39:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("FORCE_MONO");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("FORCE_ANALOG");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("FORCE_DIGITAL");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("RDS_AF");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("RDS_REG");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("DAB_DAB_LINKING");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("DAB_FM_LINKING");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("DAB_DAB_SOFT_LINKING");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L29;
        list.add("DAB_FM_SOFT_LINKING");
        flipped = flipped | 9;
    L29:
        if (o == flipped) goto L32;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L32:
        return String.join(" | ", list);
    }
}
