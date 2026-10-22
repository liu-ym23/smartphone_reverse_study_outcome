package android.hardware.biometrics.fingerprint.V2_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FingerprintMsgType {
    public static final int ACQUIRED = 1;
    public static final int AUTHENTICATED = 5;
    public static final int ERROR = -1;
    public static final int TEMPLATE_ENROLLING = 3;
    public static final int TEMPLATE_ENUMERATING = 6;
    public static final int TEMPLATE_REMOVED = 4;

    public FingerprintMsgType() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L7;
        return "ERROR";
    L7:
        if (o != 1) goto L11;
        return "ACQUIRED";
    L11:
        if (o != 3) goto L15;
        return "TEMPLATE_ENROLLING";
    L15:
        if (o != 4) goto L19;
        return "TEMPLATE_REMOVED";
    L19:
        if (o != 5) goto L23;
        return "AUTHENTICATED";
    L23:
        if (o != 6) goto L27;
        return "TEMPLATE_ENUMERATING";
    L27:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L6;
        list.add("ERROR");
        flipped = 0 | (-1);
    L6:
        if ((o & 1) != 1) goto L9;
        list.add("ACQUIRED");
        flipped = flipped | 1;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("TEMPLATE_ENROLLING");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("TEMPLATE_REMOVED");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("AUTHENTICATED");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L20;
        list.add("TEMPLATE_ENUMERATING");
        flipped = flipped | 6;
    L20:
        if (o == flipped) goto L23;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L23:
        return String.join(" | ", list);
    }
}
