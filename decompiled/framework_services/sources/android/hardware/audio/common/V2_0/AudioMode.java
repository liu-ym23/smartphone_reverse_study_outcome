package android.hardware.audio.common.V2_0;

import com.android.server.utils.PriorityDump;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioMode {
    public static final int CNT = 4;
    public static final int CURRENT = -1;
    public static final int INVALID = -2;
    public static final int IN_CALL = 2;
    public static final int IN_COMMUNICATION = 3;
    public static final int MAX = 3;
    public static final int NORMAL = 0;
    public static final int RINGTONE = 1;

    public AudioMode() {
    }

    public static final String toString(int o) {
        if (o != (-2)) goto L7;
        return "INVALID";
    L7:
        if (o != (-1)) goto L10;
        return "CURRENT";
    L10:
        if (o != 0) goto L14;
        return PriorityDump.PRIORITY_ARG_NORMAL;
    L14:
        if (o != 1) goto L18;
        return "RINGTONE";
    L18:
        if (o != 2) goto L22;
        return "IN_CALL";
    L22:
        if (o != 3) goto L26;
        return "IN_COMMUNICATION";
    L26:
        if (o != 4) goto L29;
        return "CNT";
    L29:
        if (o != 3) goto L33;
        return "MAX";
    L33:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-2)) != (-2)) goto L6;
        list.add("INVALID");
        flipped = 0 | (-2);
    L6:
        if ((o & (-1)) != (-1)) goto L8;
        list.add("CURRENT");
        flipped = flipped | (-1);
    L8:
        list.add(PriorityDump.PRIORITY_ARG_NORMAL);
        if ((o & 1) != 1) goto L12;
        list.add("RINGTONE");
        flipped = flipped | 1;
    L12:
        if ((o & 2) != 2) goto L15;
        list.add("IN_CALL");
        flipped = flipped | 2;
    L15:
        if ((o & 3) != 3) goto L18;
        list.add("IN_COMMUNICATION");
        flipped = flipped | 3;
    L18:
        if ((o & 4) != 4) goto L21;
        list.add("CNT");
        flipped = flipped | 4;
    L21:
        if ((o & 3) != 3) goto L23;
        list.add("MAX");
        flipped = flipped | 3;
    L23:
        if (o == flipped) goto L26;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L26:
        return String.join(" | ", list);
    }
}
