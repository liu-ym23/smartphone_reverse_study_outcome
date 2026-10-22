package android.hardware.biometrics.face.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class UserHandle {
    public static final int NONE = -1;

    public UserHandle() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L7;
        return "NONE";
    L7:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("NONE");
        flipped = 0 | (-1);
    L5:
        if (o == flipped) goto L8;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L8:
        return String.join(" | ", list);
    }
}
