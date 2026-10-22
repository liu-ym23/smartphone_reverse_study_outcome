package androidx.biometric;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
class AuthenticatorUtils {
    private static final int BIOMETRIC_CLASS_MASK = 32767;

    private AuthenticatorUtils() {
    }

    public static boolean isDeviceCredentialAllowed(int r100) {
        if ((r100 & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSomeBiometricAllowed(int r100) {
        if ((r100 & 32767) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isWeakBiometricAllowed(int r100) {
        if ((r100 & 255) != 255) goto L5;
        return true;
    L5:
        return false;
    }

    public static String convertToString(int r100) {
        if (r100 != 15) goto L5;
        return "BIOMETRIC_STRONG";
    L5:
        if (r100 != 255) goto L7;
        return "BIOMETRIC_WEAK";
    L7:
        if (r100 != 32768) goto L9;
        return "DEVICE_CREDENTIAL";
    L9:
        if (r100 != 32783) goto L11;
        return "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
    L11:
        if (r100 != 33023) goto L13;
        return "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
    L13:
        return String.valueOf(r100);
    }

    public static boolean isSupportedCombination(int r100) {
        if (r100 != 15) goto L5;
        return true;
    L5:
        if (r100 != 255) goto L7;
        return true;
    L7:
        if (r100 == 32768) goto L24;
        if (r100 != 32783) goto L11;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 28) goto L19;
        return true;
    L19:
        if (r101 > 29) goto L30;
        return false;
    L30:
        return true;
    L11:
        if (r100 == 33023) goto L33;
        if (r100 == 0) goto L28;
        return false;
    L28:
        return true;
    L33:
        return true;
    L24:
        if (Build.VERSION.SDK_INT >= 30) goto L34;
        return false;
    L34:
        return true;
    }

    public static int getConsolidatedAuthenticators(BiometricPrompt.PromptInfo r100, BiometricPrompt.CryptoObject r101) {
        if (r100.getAllowedAuthenticators() != 0) goto L13;
        if (r101 == null) goto L7;
        int r102 = 15;
    L9:
        if (r100.isDeviceCredentialAllowed() == false) goto L12;
        return 32768 | r102;
    L12:
        return r102;
    L7:
        r102 = 255;
        goto L9
    L13:
        return r100.getAllowedAuthenticators();
    }
}
