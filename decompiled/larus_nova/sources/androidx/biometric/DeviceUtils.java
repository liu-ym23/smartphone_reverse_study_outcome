package androidx.biometric;

import android.content.Context;
import android.os.Build;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
class DeviceUtils {
    private DeviceUtils() {
    }

    public static boolean canAssumeStrongBiometrics(Context r100, String r101) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return false;
    L7:
        return isModelInList(r100, r101, R.array.assume_strong_biometrics_models);
    }

    public static boolean shouldDelayShowingPrompt(Context r100, String r101) {
        if (Build.VERSION.SDK_INT == 29) goto L7;
        return false;
    L7:
        return isModelInList(r100, r101, R.array.delay_showing_prompt_models);
    }

    public static boolean shouldHideFingerprintDialog(Context r100, String r101) {
        if (Build.VERSION.SDK_INT == 28) goto L7;
        return false;
    L7:
        return isModelInPrefixList(r100, r101, R.array.hide_fingerprint_instantly_prefixes);
    }

    private static boolean isModelInList(Context r100, String r101, int r102) {
        if (r101 != null) goto L5;
        return false;
    L5:
        String[] r103 = r100.getResources().getStringArray(r102);
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L12;
        if (r101.equals(r103[r105]) == true) goto L9;
        r105 = r105 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isModelInPrefixList(Context r100, String r101, int r102) {
        if (r101 != null) goto L5;
        return false;
    L5:
        String[] r103 = r100.getResources().getStringArray(r102);
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L12;
        if (r101.startsWith(r103[r105]) == true) goto L9;
        r105 = r105 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isVendorInList(Context r100, String r101, int r102) {
        if (r101 != null) goto L5;
        return false;
    L5:
        String[] r103 = r100.getResources().getStringArray(r102);
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L12;
        if (r101.equalsIgnoreCase(r103[r105]) == true) goto L9;
        r105 = r105 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean shouldUseFingerprintForCrypto(Context r100, String r101, String r102) {
        if (Build.VERSION.SDK_INT == 28) goto L6;
        return false;
    L6:
        if (isVendorInList(r100, r101, R.array.crypto_fingerprint_fallback_vendors) == false) goto L8;
    L9:
        return true;
    L8:
        if (isModelInPrefixList(r100, r102, R.array.crypto_fingerprint_fallback_prefixes) == true) goto L9;
        return false;
    }
}
