package com.android.server.biometrics.sensors.fingerprint.aidl;

/* JADX INFO: loaded from: classes.dex */
final class AidlConversionUtils {
    private AidlConversionUtils() {
    }

    public static int toFrameworkError(byte aidlError) {
        if (aidlError != 0) goto L6;
        return 17;
    L6:
        if (aidlError != 1) goto L9;
        return 1;
    L9:
        if (aidlError != 2) goto L12;
        return 2;
    L12:
        if (aidlError != 3) goto L15;
        return 3;
    L15:
        if (aidlError != 4) goto L18;
        return 4;
    L18:
        if (aidlError != 5) goto L21;
        return 5;
    L21:
        if (aidlError != 6) goto L24;
        return 6;
    L24:
        if (aidlError != 7) goto L26;
        return 8;
    L26:
        if (aidlError != 8) goto L30;
        return 18;
    L30:
        if (aidlError != 9) goto L33;
        return 19;
    L33:
        return 17;
    }

    public static int toFrameworkAcquiredInfo(byte aidlAcquiredInfo) {
        if (aidlAcquiredInfo != 0) goto L6;
        return 8;
    L6:
        if (aidlAcquiredInfo != 1) goto L10;
        return 0;
    L10:
        if (aidlAcquiredInfo != 2) goto L13;
        return 1;
    L13:
        if (aidlAcquiredInfo != 3) goto L16;
        return 2;
    L16:
        if (aidlAcquiredInfo != 4) goto L19;
        return 3;
    L19:
        if (aidlAcquiredInfo != 5) goto L22;
        return 4;
    L22:
        if (aidlAcquiredInfo != 6) goto L25;
        return 5;
    L25:
        if (aidlAcquiredInfo != 7) goto L27;
        return 6;
    L27:
        if (aidlAcquiredInfo != 8) goto L30;
        return 7;
    L30:
        if (aidlAcquiredInfo != 9) goto L33;
        return 8;
    L33:
        if (aidlAcquiredInfo != 10) goto L36;
        return 10;
    L36:
        if (aidlAcquiredInfo != 11) goto L39;
        return 9;
    L39:
        if (aidlAcquiredInfo != 12) goto L42;
        return 8;
    L42:
        if (aidlAcquiredInfo != 14) goto L44;
        return 11;
    L44:
        return 8;
    }
}
