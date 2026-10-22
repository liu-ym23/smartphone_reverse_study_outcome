package android.hardware.soundtrigger.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class SoundModelType {
    public static final int GENERIC = 1;
    public static final int KEYPHRASE = 0;
    public static final int UNKNOWN = -1;

    public SoundModelType() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "UNKNOWN";
    L6:
        if (o != 0) goto L10;
        return "KEYPHRASE";
    L10:
        if (o != 1) goto L14;
        return "GENERIC";
    L14:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("UNKNOWN");
        flipped = 0 | (-1);
    L5:
        list.add("KEYPHRASE");
        if ((o & 1) != 1) goto L8;
        list.add("GENERIC");
        flipped = flipped | 1;
    L8:
        if (o == flipped) goto L11;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L11:
        return String.join(" | ", list);
    }
}
