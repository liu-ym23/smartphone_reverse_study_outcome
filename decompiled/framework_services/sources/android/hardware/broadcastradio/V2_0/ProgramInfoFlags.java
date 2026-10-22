package android.hardware.broadcastradio.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ProgramInfoFlags {
    public static final int LIVE = 1;
    public static final int MUTED = 2;
    public static final int STEREO = 32;
    public static final int TRAFFIC_ANNOUNCEMENT = 8;
    public static final int TRAFFIC_PROGRAM = 4;
    public static final int TUNED = 16;

    public ProgramInfoFlags() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L7;
        return "LIVE";
    L7:
        if (o != 2) goto L11;
        return "MUTED";
    L11:
        if (o != 4) goto L15;
        return "TRAFFIC_PROGRAM";
    L15:
        if (o != 8) goto L19;
        return "TRAFFIC_ANNOUNCEMENT";
    L19:
        if (o != 16) goto L23;
        return "TUNED";
    L23:
        if (o != 32) goto L27;
        return "STEREO";
    L27:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L6;
        list.add("LIVE");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("MUTED");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L12;
        list.add("TRAFFIC_PROGRAM");
        flipped = flipped | 4;
    L12:
        if ((o & 8) != 8) goto L15;
        list.add("TRAFFIC_ANNOUNCEMENT");
        flipped = flipped | 8;
    L15:
        if ((o & 16) != 16) goto L18;
        list.add("TUNED");
        flipped = flipped | 16;
    L18:
        if ((o & 32) != 32) goto L20;
        list.add("STEREO");
        flipped = flipped | 32;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
