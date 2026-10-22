package vendor.qti.hardware.servicetracker.V1_2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityStates {
    public static final int DESTROYED = 9;
    public static final int DESTROYING = 8;
    public static final int FINISHING = 7;
    public static final int INITIALIZING = 0;
    public static final int PAUSED = 4;
    public static final int PAUSING = 3;
    public static final int RESTARTING_PROCESS = 10;
    public static final int RESUMED = 2;
    public static final int STARTED = 1;
    public static final int STOPPED = 6;
    public static final int STOPPING = 5;
    public static final int UNKNOWN = 11;

    public ActivityStates() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "INITIALIZING";
    L6:
        if (o != 1) goto L10;
        return "STARTED";
    L10:
        if (o != 2) goto L14;
        return "RESUMED";
    L14:
        if (o != 3) goto L18;
        return "PAUSING";
    L18:
        if (o != 4) goto L22;
        return "PAUSED";
    L22:
        if (o != 5) goto L26;
        return "STOPPING";
    L26:
        if (o != 6) goto L30;
        return "STOPPED";
    L30:
        if (o != 7) goto L34;
        return "FINISHING";
    L34:
        if (o != 8) goto L38;
        return "DESTROYING";
    L38:
        if (o != 9) goto L42;
        return "DESTROYED";
    L42:
        if (o != 10) goto L46;
        return "RESTARTING_PROCESS";
    L46:
        if (o != 11) goto L50;
        return "UNKNOWN";
    L50:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("INITIALIZING");
        if ((o & 1) != 1) goto L6;
        list.add("STARTED");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("RESUMED");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("PAUSING");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("PAUSED");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("STOPPING");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("STOPPED");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("FINISHING");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("DESTROYING");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L30;
        list.add("DESTROYED");
        flipped = flipped | 9;
    L30:
        if ((o & 10) != 10) goto L33;
        list.add("RESTARTING_PROCESS");
        flipped = flipped | 10;
    L33:
        if ((o & 11) != 11) goto L35;
        list.add("UNKNOWN");
        flipped = flipped | 11;
    L35:
        if (o == flipped) goto L38;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L38:
        return String.join(" | ", list);
    }
}
