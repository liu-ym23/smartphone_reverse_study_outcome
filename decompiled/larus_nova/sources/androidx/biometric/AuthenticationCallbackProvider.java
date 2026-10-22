package androidx.biometric;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: loaded from: classes2.dex */
class AuthenticationCallbackProvider {
    private android.hardware.biometrics.BiometricPrompt.AuthenticationCallback mBiometricCallback;
    private FingerprintManagerCompat.AuthenticationCallback mFingerprintCallback;
    final Listener mListener;

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static android.hardware.biometrics.BiometricPrompt.AuthenticationCallback createCallback(final Listener r100) {
            return new AnonymousClass1(r100);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static int getAuthenticationType(android.hardware.biometrics.BiometricPrompt.AuthenticationResult r100) {
            return r100.getAuthenticationType();
        }
    }

    public static class Listener {
        public Listener() {
        }

        public void onError(int r100, CharSequence r101) {
        }

        public void onFailure() {
        }

        public void onHelp(CharSequence r100) {
        }

        public void onSuccess(BiometricPrompt.AuthenticationResult r100) {
        }
    }

    public android.hardware.biometrics.BiometricPrompt.AuthenticationCallback getBiometricCallback() {
        if (this.mBiometricCallback != null) goto L6;
        this.mBiometricCallback = Api28Impl.createCallback(this.mListener);
    L6:
        return this.mBiometricCallback;
    }

    public FingerprintManagerCompat.AuthenticationCallback getFingerprintCallback() {
        if (this.mFingerprintCallback != null) goto L6;
        this.mFingerprintCallback = new AnonymousClass1(this);
    L6:
        return this.mFingerprintCallback;
    }

    public AuthenticationCallbackProvider(Listener r100) {
        this.mListener = r100;
    }
}
