package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioSessionConsts {
    public static final int ALLOCATE = 0;
    public static final int NONE = 0;
    public static final int OUTPUT_MIX = 0;
    public static final int OUTPUT_STAGE = -1;

    public AudioSessionConsts() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "OUTPUT_STAGE";
    L6:
        if (o != 0) goto L9;
        return "OUTPUT_MIX";
    L9:
        if (o != 0) goto L12;
        return "ALLOCATE";
    L12:
        if (o != 0) goto L16;
        return "NONE";
    L16:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("OUTPUT_STAGE");
        flipped = 0 | (-1);
    L5:
        list.add("OUTPUT_MIX");
        list.add("ALLOCATE");
        list.add("NONE");
        if (o == flipped) goto L9;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L9:
        return String.join(" | ", list);
    }
}
