package android.hardware.usb.V1_0;

import com.android.server.media.IMediaSessionServiceExt;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Status {
    public static final int ERROR = 1;
    public static final int INVALID_ARGUMENT = 2;
    public static final int SUCCESS = 0;
    public static final int UNRECOGNIZED_ROLE = 3;

    public Status() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "SUCCESS";
    L6:
        if (o != 1) goto L10;
        return "ERROR";
    L10:
        if (o != 2) goto L14;
        return IMediaSessionServiceExt.ERROR_INVALID_ARGUMENT;
    L14:
        if (o != 3) goto L18;
        return "UNRECOGNIZED_ROLE";
    L18:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("SUCCESS");
        if ((o & 1) != 1) goto L6;
        list.add("ERROR");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add(IMediaSessionServiceExt.ERROR_INVALID_ARGUMENT);
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L11;
        list.add("UNRECOGNIZED_ROLE");
        flipped = flipped | 3;
    L11:
        if (o == flipped) goto L14;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L14:
        return String.join(" | ", list);
    }
}
