package android.hardware.biometrics.fingerprint.V2_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class RequestStatus {
    public static final int SYS_EACCES = -13;
    public static final int SYS_EAGAIN = -11;
    public static final int SYS_EBUSY = -16;
    public static final int SYS_EFAULT = -14;
    public static final int SYS_EINTR = -4;
    public static final int SYS_EINVAL = -22;
    public static final int SYS_EIO = -5;
    public static final int SYS_ENOENT = -2;
    public static final int SYS_ENOMEM = -12;
    public static final int SYS_ENOSPC = -28;
    public static final int SYS_ETIMEDOUT = -110;
    public static final int SYS_OK = 0;
    public static final int SYS_UNKNOWN = 1;

    public RequestStatus() {
    }

    public static final String toString(int o) {
        if (o != 1) goto L6;
        return "SYS_UNKNOWN";
    L6:
        if (o != 0) goto L10;
        return "SYS_OK";
    L10:
        if (o != (-2)) goto L14;
        return "SYS_ENOENT";
    L14:
        if (o != (-4)) goto L18;
        return "SYS_EINTR";
    L18:
        if (o != (-5)) goto L22;
        return "SYS_EIO";
    L22:
        if (o != (-11)) goto L26;
        return "SYS_EAGAIN";
    L26:
        if (o != (-12)) goto L30;
        return "SYS_ENOMEM";
    L30:
        if (o != (-13)) goto L34;
        return "SYS_EACCES";
    L34:
        if (o != (-14)) goto L38;
        return "SYS_EFAULT";
    L38:
        if (o != (-16)) goto L42;
        return "SYS_EBUSY";
    L42:
        if (o != (-22)) goto L46;
        return "SYS_EINVAL";
    L46:
        if (o != (-28)) goto L50;
        return "SYS_ENOSPC";
    L50:
        if (o != (-110)) goto L54;
        return "SYS_ETIMEDOUT";
    L54:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) != 1) goto L5;
        list.add("SYS_UNKNOWN");
        flipped = 0 | 1;
    L5:
        list.add("SYS_OK");
        if ((o & (-2)) != (-2)) goto L9;
        list.add("SYS_ENOENT");
        flipped = flipped | (-2);
    L9:
        if ((o & (-4)) != (-4)) goto L12;
        list.add("SYS_EINTR");
        flipped = flipped | (-4);
    L12:
        if ((o & (-5)) != (-5)) goto L15;
        list.add("SYS_EIO");
        flipped = flipped | (-5);
    L15:
        if ((o & (-11)) != (-11)) goto L18;
        list.add("SYS_EAGAIN");
        flipped = flipped | (-11);
    L18:
        if ((o & (-12)) != (-12)) goto L21;
        list.add("SYS_ENOMEM");
        flipped = flipped | (-12);
    L21:
        if ((o & (-13)) != (-13)) goto L24;
        list.add("SYS_EACCES");
        flipped = flipped | (-13);
    L24:
        if ((o & (-14)) != (-14)) goto L27;
        list.add("SYS_EFAULT");
        flipped = flipped | (-14);
    L27:
        if ((o & (-16)) != (-16)) goto L30;
        list.add("SYS_EBUSY");
        flipped = flipped | (-16);
    L30:
        if ((o & (-22)) != (-22)) goto L33;
        list.add("SYS_EINVAL");
        flipped = flipped | (-22);
    L33:
        if ((o & (-28)) != (-28)) goto L36;
        list.add("SYS_ENOSPC");
        flipped = flipped | (-28);
    L36:
        if ((o & (-110)) != (-110)) goto L38;
        list.add("SYS_ETIMEDOUT");
        flipped = flipped | (-110);
    L38:
        if (o == flipped) goto L41;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L41:
        return String.join(" | ", list);
    }
}
