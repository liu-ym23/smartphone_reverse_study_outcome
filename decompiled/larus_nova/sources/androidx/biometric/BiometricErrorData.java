package androidx.biometric;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class BiometricErrorData {
    private final int mErrorCode;
    private final CharSequence mErrorMessage;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mErrorCode), convertToString(this.mErrorMessage)});
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    private static String convertToString(CharSequence r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    private boolean isErrorMessageEqualTo(CharSequence r100) {
        String r101 = convertToString(this.mErrorMessage);
        String r102 = convertToString(r100);
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (r101.equals(r102) == false) goto L9;
        goto L8
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof BiometricErrorData) == false) goto L10;
        BiometricErrorData r101 = (BiometricErrorData) r100;
        if (this.mErrorCode == r101.mErrorCode) goto L7;
        return false;
    L7:
        if (isErrorMessageEqualTo(r101.mErrorMessage) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public BiometricErrorData(int r100, CharSequence r101) {
        this.mErrorCode = r100;
        this.mErrorMessage = r101;
    }
}
