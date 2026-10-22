package com.android.server.biometrics.sensors.face.aidl;

import android.hardware.biometrics.face.AuthenticationFrame;
import android.hardware.biometrics.face.BaseFrame;
import android.hardware.biometrics.face.Cell;
import android.hardware.biometrics.face.EnrollmentFrame;
import android.hardware.face.FaceAuthenticationFrame;
import android.hardware.face.FaceDataFrame;
import android.hardware.face.FaceEnrollCell;
import android.hardware.face.FaceEnrollFrame;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public final class AidlConversionUtils {
    private static final String TAG = "AidlConversionUtils";

    private AidlConversionUtils() {
    }

    public static int toFrameworkError(byte aidlError) {
        switch(aidlError) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return 17;
    L5:
        return 16;
    L7:
        return 8;
    L9:
        return 6;
    L11:
        return 5;
    L13:
        return 4;
    L15:
        return 3;
    L17:
        return 2;
    L19:
        return 1;
    }

    public static int toFrameworkAcquiredInfo(byte aidlAcquiredInfo) {
        switch(aidlAcquiredInfo) {
            case 1: goto L55;
            case 2: goto L53;
            case 3: goto L51;
            case 4: goto L49;
            case 5: goto L47;
            case 6: goto L45;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L35;
            case 12: goto L33;
            case 13: goto L31;
            case 14: goto L29;
            case 15: goto L27;
            case 16: goto L25;
            case 17: goto L23;
            case 18: goto L21;
            case 19: goto L19;
            case 20: goto L17;
            case 21: goto L15;
            case 22: goto L13;
            case 23: goto L11;
            case 24: goto L9;
            case 25: goto L7;
            case 26: goto L5;
            default: goto L3;
        };
    L3:
        return 23;
    L5:
        return 26;
    L7:
        return 25;
    L9:
        return 24;
    L11:
        return 22;
    L13:
        return 21;
    L15:
        return 20;
    L17:
        return 19;
    L19:
        return 18;
    L21:
        return 17;
    L23:
        return 16;
    L25:
        return 15;
    L27:
        return 14;
    L29:
        return 13;
    L31:
        return 12;
    L33:
        return 11;
    L35:
        return 10;
    L37:
        return 9;
    L39:
        return 8;
    L41:
        return 7;
    L43:
        return 6;
    L45:
        return 5;
    L47:
        return 4;
    L49:
        return 3;
    L51:
        return 2;
    L53:
        return 1;
    L55:
        return 0;
    }

    public static int toFrameworkEnrollmentStage(int aidlEnrollmentStage) {
        switch(aidlEnrollmentStage) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    }

    public static FaceAuthenticationFrame toFrameworkAuthenticationFrame(AuthenticationFrame frame) {
        return new FaceAuthenticationFrame(toFrameworkBaseFrame(frame.data));
    }

    public static FaceEnrollFrame toFrameworkEnrollmentFrame(EnrollmentFrame frame) {
        return new FaceEnrollFrame(toFrameworkCell(frame.cell), toFrameworkEnrollmentStage(frame.stage), toFrameworkBaseFrame(frame.data));
    }

    public static FaceDataFrame toFrameworkBaseFrame(BaseFrame frame) {
        return new FaceDataFrame(toFrameworkAcquiredInfo(frame.acquiredInfo), frame.vendorCode, frame.pan, frame.tilt, frame.distance, frame.isCancellable);
    }

    public static FaceEnrollCell toFrameworkCell(Cell cell) {
        if (cell != null) goto L5;
        return null;
    L5:
        return new FaceEnrollCell(cell.x, cell.y, cell.z);
    }

    public static byte convertFrameworkToAidlFeature(int feature) throws IllegalArgumentException {
        switch(feature) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, "Unsupported feature : " + feature);
        throw new IllegalArgumentException();
    L5:
        return 1;
    L7:
        return 0;
    }

    public static int convertAidlToFrameworkFeature(byte feature) throws IllegalArgumentException {
        switch(feature) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, "Unsupported feature : " + feature);
        throw new IllegalArgumentException();
    L5:
        return 2;
    L7:
        return 1;
    }
}
