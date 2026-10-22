package androidx.biometric;

import android.content.Context;
import android.os.Build;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class BiometricManager {
    public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1;
    public static final int BIOMETRIC_ERROR_NONE_ENROLLED = 11;
    public static final int BIOMETRIC_ERROR_NO_HARDWARE = 12;
    public static final int BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int BIOMETRIC_ERROR_UNSUPPORTED = -2;
    public static final int BIOMETRIC_STATUS_UNKNOWN = -1;
    public static final int BIOMETRIC_SUCCESS = 0;
    private static final String TAG = "BiometricManager";
    private final android.hardware.biometrics.BiometricManager mBiometricManager;
    private final FingerprintManagerCompat mFingerprintManager;
    private final Injector mInjector;

    /* JADX INFO: loaded from: classes2.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static Method getCanAuthenticateWithCryptoMethod() {
            return android.hardware.biometrics.BiometricManager.class.getMethod("canAuthenticate", new Class[]{android.hardware.biometrics.BiometricPrompt.CryptoObject.class});
        L4:
            return null;
        }

        public static int canAuthenticate(android.hardware.biometrics.BiometricManager r100) {
            return r100.canAuthenticate();
        }

        public static android.hardware.biometrics.BiometricManager create(Context r100) {
            return (android.hardware.biometrics.BiometricManager) r100.getSystemService(android.hardware.biometrics.BiometricManager.class);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static int canAuthenticate(android.hardware.biometrics.BiometricManager r100, int r101) {
            return r100.canAuthenticate(r101);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface Authenticators {
        public static final int BIOMETRIC_STRONG = 15;
        public static final int BIOMETRIC_WEAK = 255;
        public static final int DEVICE_CREDENTIAL = 32768;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class DefaultInjector implements Injector {
        private final Context mContext;

        @Override // androidx.biometric.BiometricManager.Injector
        public android.hardware.biometrics.BiometricManager getBiometricManager() {
            return Api29Impl.create(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public FingerprintManagerCompat getFingerprintManager() {
            return FingerprintManagerCompat.from(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecurable() {
            if (KeyguardUtils.getKeyguardManager(this.mContext) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecuredWithCredential() {
            return KeyguardUtils.isDeviceSecuredWithCredential(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isFingerprintHardwarePresent() {
            return PackageUtils.hasSystemFeatureFingerprint(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isStrongBiometricGuaranteed() {
            return DeviceUtils.canAssumeStrongBiometrics(this.mContext, Build.MODEL);
        }

        public DefaultInjector(Context r100) {
            this.mContext = r100.getApplicationContext();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface Injector {
        android.hardware.biometrics.BiometricManager getBiometricManager();

        FingerprintManagerCompat getFingerprintManager();

        boolean isDeviceSecurable();

        boolean isDeviceSecuredWithCredential();

        boolean isFingerprintHardwarePresent();

        boolean isStrongBiometricGuaranteed();
    }

    private int canAuthenticateWithFingerprint() {
        FingerprintManagerCompat r100 = this.mFingerprintManager;
        if (r100 != null) goto L7;
        return 1;
    L7:
        if (r100.isHardwareDetected() == true) goto L11;
        return 12;
    L11:
        if (this.mFingerprintManager.hasEnrolledFingerprints() == true) goto L14;
        return 11;
    L14:
        return 0;
    }

    private int canAuthenticateWithFingerprintOrUnknownBiometric() {
        if (this.mInjector.isDeviceSecuredWithCredential() == true) goto L7;
        return canAuthenticateWithFingerprint();
    L7:
        if (canAuthenticateWithFingerprint() != 0) goto L9;
        return 0;
    L9:
        return -1;
    }

    private int canAuthenticateWithWeakBiometricOnApi29() {
        android.hardware.biometrics.BiometricManager r100 = this.mBiometricManager;
        if (r100 != null) goto L7;
        return 1;
    L7:
        return Api29Impl.canAuthenticate(r100);
    }

    public int canAuthenticate() {
        return canAuthenticate(255);
    }

    private int canAuthenticateWithStrongBiometricOnApi29() {
        Method r100 = Api29Impl.getCanAuthenticateWithCryptoMethod();
        if (r100 == null) goto L11;
        android.hardware.biometrics.BiometricPrompt.CryptoObject r101 = CryptoObjectUtils.wrapForBiometricPrompt(CryptoObjectUtils.createFakeCryptoObject());
        if (r101 == null) goto L11;
        Object r102 = r100.invoke(this.mBiometricManager, new Object[]{r101});     // Catch: Throwable -> L10
        if ((r102 instanceof Integer) == false) goto L11;
        return ((Integer) r102).intValue();
    L11:
        int r103 = canAuthenticateWithWeakBiometricOnApi29();
        if (this.mInjector.isStrongBiometricGuaranteed() == true) goto L19;
        if (r103 == 0) goto L16;
        return r103;
    L16:
        return canAuthenticateWithFingerprintOrUnknownBiometric();
    L19:
        return r103;
    }

    public BiometricManager(Injector r100) {
        this.mInjector = r100;
        int r101 = Build.VERSION.SDK_INT;
        FingerprintManagerCompat r102 = null;
        if (r101 < 29) goto L5;
        android.hardware.biometrics.BiometricManager r103 = r100.getBiometricManager();
    L6:
        this.mBiometricManager = r103;
        if (r101 > 29) goto L9;
        r102 = r100.getFingerprintManager();
    L9:
        this.mFingerprintManager = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }

    private int canAuthenticateCompat(int r100) {
        if (AuthenticatorUtils.isSupportedCombination(r100) == true) goto L7;
        return -2;
    L7:
        if (r100 != 0) goto L10;
        return 12;
    L10:
        if (this.mInjector.isDeviceSecurable() == true) goto L13;
        return 12;
    L13:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r100) == true) goto L15;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 29) goto L27;
        if (AuthenticatorUtils.isWeakBiometricAllowed(r100) == false) goto L25;
        return canAuthenticateWithWeakBiometricOnApi29();
    L25:
        return canAuthenticateWithStrongBiometricOnApi29();
    L27:
        if (r101 != 28) goto L33;
        if (this.mInjector.isFingerprintHardwarePresent() == true) goto L31;
        return 12;
    L31:
        return canAuthenticateWithFingerprintOrUnknownBiometric();
    L33:
        return canAuthenticateWithFingerprint();
    L15:
        if (this.mInjector.isDeviceSecuredWithCredential() == false) goto L17;
        return 0;
    L17:
        return 11;
    }

    public static BiometricManager from(Context r100) {
        return new BiometricManager(new DefaultInjector(r100));
    }

    public int canAuthenticate(int r100) {
        if (Build.VERSION.SDK_INT < 30) goto L11;
        android.hardware.biometrics.BiometricManager r101 = this.mBiometricManager;
        if (r101 != null) goto L9;
        return 1;
    L9:
        return Api30Impl.canAuthenticate(r101, r100);
    L11:
        return canAuthenticateCompat(r100);
    }
}
