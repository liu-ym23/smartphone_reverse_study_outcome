package android.hardware.biometrics.face.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FaceAcquiredInfo {
    public static final int FACE_OBSCURED = 19;
    public static final int FACE_TOO_HIGH = 6;
    public static final int FACE_TOO_LEFT = 9;
    public static final int FACE_TOO_LOW = 7;
    public static final int FACE_TOO_RIGHT = 8;
    public static final int GOOD = 0;
    public static final int INSUFFICIENT = 1;
    public static final int NOT_DETECTED = 11;
    public static final int PAN_TOO_EXTREME = 16;
    public static final int POOR_GAZE = 10;
    public static final int RECALIBRATE = 13;
    public static final int ROLL_TOO_EXTREME = 18;
    public static final int SENSOR_DIRTY = 21;
    public static final int START = 20;
    public static final int TILT_TOO_EXTREME = 17;
    public static final int TOO_BRIGHT = 2;
    public static final int TOO_CLOSE = 4;
    public static final int TOO_DARK = 3;
    public static final int TOO_DIFFERENT = 14;
    public static final int TOO_FAR = 5;
    public static final int TOO_MUCH_MOTION = 12;
    public static final int TOO_SIMILAR = 15;
    public static final int VENDOR = 22;

    public FaceAcquiredInfo() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "GOOD";
    L6:
        if (o != 1) goto L10;
        return "INSUFFICIENT";
    L10:
        if (o != 2) goto L14;
        return "TOO_BRIGHT";
    L14:
        if (o != 3) goto L18;
        return "TOO_DARK";
    L18:
        if (o != 4) goto L22;
        return "TOO_CLOSE";
    L22:
        if (o != 5) goto L26;
        return "TOO_FAR";
    L26:
        if (o != 6) goto L30;
        return "FACE_TOO_HIGH";
    L30:
        if (o != 7) goto L34;
        return "FACE_TOO_LOW";
    L34:
        if (o != 8) goto L38;
        return "FACE_TOO_RIGHT";
    L38:
        if (o != 9) goto L42;
        return "FACE_TOO_LEFT";
    L42:
        if (o != 10) goto L46;
        return "POOR_GAZE";
    L46:
        if (o != 11) goto L50;
        return "NOT_DETECTED";
    L50:
        if (o != 12) goto L54;
        return "TOO_MUCH_MOTION";
    L54:
        if (o != 13) goto L58;
        return "RECALIBRATE";
    L58:
        if (o != 14) goto L62;
        return "TOO_DIFFERENT";
    L62:
        if (o != 15) goto L66;
        return "TOO_SIMILAR";
    L66:
        if (o != 16) goto L70;
        return "PAN_TOO_EXTREME";
    L70:
        if (o != 17) goto L74;
        return "TILT_TOO_EXTREME";
    L74:
        if (o != 18) goto L78;
        return "ROLL_TOO_EXTREME";
    L78:
        if (o != 19) goto L82;
        return "FACE_OBSCURED";
    L82:
        if (o != 20) goto L86;
        return "START";
    L86:
        if (o != 21) goto L90;
        return "SENSOR_DIRTY";
    L90:
        if (o != 22) goto L94;
        return "VENDOR";
    L94:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("GOOD");
        if ((o & 1) != 1) goto L6;
        list.add("INSUFFICIENT");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("TOO_BRIGHT");
        flipped = flipped | 2;
    L9:
        if ((o & 3) != 3) goto L12;
        list.add("TOO_DARK");
        flipped = flipped | 3;
    L12:
        if ((o & 4) != 4) goto L15;
        list.add("TOO_CLOSE");
        flipped = flipped | 4;
    L15:
        if ((o & 5) != 5) goto L18;
        list.add("TOO_FAR");
        flipped = flipped | 5;
    L18:
        if ((o & 6) != 6) goto L21;
        list.add("FACE_TOO_HIGH");
        flipped = flipped | 6;
    L21:
        if ((o & 7) != 7) goto L24;
        list.add("FACE_TOO_LOW");
        flipped = flipped | 7;
    L24:
        if ((o & 8) != 8) goto L27;
        list.add("FACE_TOO_RIGHT");
        flipped = flipped | 8;
    L27:
        if ((o & 9) != 9) goto L30;
        list.add("FACE_TOO_LEFT");
        flipped = flipped | 9;
    L30:
        if ((o & 10) != 10) goto L33;
        list.add("POOR_GAZE");
        flipped = flipped | 10;
    L33:
        if ((o & 11) != 11) goto L36;
        list.add("NOT_DETECTED");
        flipped = flipped | 11;
    L36:
        if ((o & 12) != 12) goto L39;
        list.add("TOO_MUCH_MOTION");
        flipped = flipped | 12;
    L39:
        if ((o & 13) != 13) goto L42;
        list.add("RECALIBRATE");
        flipped = flipped | 13;
    L42:
        if ((o & 14) != 14) goto L45;
        list.add("TOO_DIFFERENT");
        flipped = flipped | 14;
    L45:
        if ((o & 15) != 15) goto L48;
        list.add("TOO_SIMILAR");
        flipped = flipped | 15;
    L48:
        if ((o & 16) != 16) goto L51;
        list.add("PAN_TOO_EXTREME");
        flipped = flipped | 16;
    L51:
        if ((o & 17) != 17) goto L54;
        list.add("TILT_TOO_EXTREME");
        flipped = flipped | 17;
    L54:
        if ((o & 18) != 18) goto L57;
        list.add("ROLL_TOO_EXTREME");
        flipped = flipped | 18;
    L57:
        if ((o & 19) != 19) goto L60;
        list.add("FACE_OBSCURED");
        flipped = flipped | 19;
    L60:
        if ((o & 20) != 20) goto L63;
        list.add("START");
        flipped = flipped | 20;
    L63:
        if ((o & 21) != 21) goto L66;
        list.add("SENSOR_DIRTY");
        flipped = flipped | 21;
    L66:
        if ((o & 22) != 22) goto L68;
        list.add("VENDOR");
        flipped = flipped | 22;
    L68:
        if (o == flipped) goto L71;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L71:
        return String.join(" | ", list);
    }
}
