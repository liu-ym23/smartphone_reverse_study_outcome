package android.hardware.audio.common.V2_0;

import com.android.server.utils.PriorityDump;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioMixLatencyClass {
    public static final int LOW = 0;
    public static final int NORMAL = 1;

    public AudioMixLatencyClass() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "LOW";
    L6:
        if (o != 1) goto L10;
        return PriorityDump.PRIORITY_ARG_NORMAL;
    L10:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("LOW");
        if ((o & 1) != 1) goto L5;
        list.add(PriorityDump.PRIORITY_ARG_NORMAL);
        flipped = 0 | 1;
    L5:
        if (o == flipped) goto L8;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L8:
        return String.join(" | ", list);
    }
}
