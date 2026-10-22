package android.hardware.health.V2_1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Constants {
    public static final long BATTERY_CHARGE_TIME_TO_FULL_NOW_SECONDS_UNSUPPORTED = -1;

    public Constants() {
    }

    public static final String toString(long o) {
        if (o != (-1)) goto L7;
        return "BATTERY_CHARGE_TIME_TO_FULL_NOW_SECONDS_UNSUPPORTED";
    L7:
        return "0x" + Long.toHexString(o);
    }

    public static final String dumpBitfield(long o) {
        ArrayList<String> list = new ArrayList();
        long flipped = 0;
        if ((o & (-1)) != (-1)) goto L6;
        list.add("BATTERY_CHARGE_TIME_TO_FULL_NOW_SECONDS_UNSUPPORTED");
        flipped = 0 | (-1);
    L6:
        if (o == flipped) goto L9;
        list.add("0x" + Long.toHexString((~flipped) & o));
    L9:
        return String.join(" | ", list);
    }
}
