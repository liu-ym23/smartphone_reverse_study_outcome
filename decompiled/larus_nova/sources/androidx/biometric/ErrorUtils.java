package androidx.biometric;

import android.content.Context;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
class ErrorUtils {
    private ErrorUtils() {
    }

    public static boolean isKnownError(int r100) {
        switch(r100) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L3;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static boolean isLockoutError(int r100) {
        if (r100 != 7) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 9) goto L8;
        return false;
    }

    public static String getFingerprintErrorString(Context r100, int r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r101 == 1) goto L21;
        if (r101 == 7) goto L19;
        switch(r101) {
            case 9: goto L19;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L13;
            default: goto L11;
        };
    L11:
        return r100.getString(R.string.default_error_msg);
    L13:
        return r100.getString(R.string.fingerprint_error_hw_not_present);
    L15:
        return r100.getString(R.string.fingerprint_error_no_fingerprints);
    L17:
        return r100.getString(R.string.fingerprint_error_user_canceled);
    L19:
        return r100.getString(R.string.fingerprint_error_lockout);
    L21:
        return r100.getString(R.string.fingerprint_error_hw_not_available);
    }
}
