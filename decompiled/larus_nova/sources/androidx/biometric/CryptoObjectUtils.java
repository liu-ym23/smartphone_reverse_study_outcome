package androidx.biometric;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.keystore.KeyGenParameterSpec;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
class CryptoObjectUtils {
    private static final String FAKE_KEY_NAME = "androidxBiometric";
    private static final String KEYSTORE_INSTANCE = "AndroidKeyStore";
    private static final String TAG = "CryptoObjectUtils";

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static KeyGenParameterSpec buildKeyGenParameterSpec(KeyGenParameterSpec.Builder r100) {
            return r100.build();
        }

        public static void setBlockModeCBC(KeyGenParameterSpec.Builder r100) {
            r100.setBlockModes(new String[]{"CBC"});
        }

        public static void setEncryptionPaddingPKCS7(KeyGenParameterSpec.Builder r100) {
            r100.setEncryptionPaddings(new String[]{"PKCS7Padding"});
        }

        public static KeyGenParameterSpec.Builder createKeyGenParameterSpecBuilder(String r100, int r101) {
            return new KeyGenParameterSpec.Builder(r100, r101);
        }

        public static void initKeyGenerator(KeyGenerator r100, KeyGenParameterSpec r101) throws InvalidAlgorithmParameterException {
            r100.init(r101);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static android.hardware.biometrics.BiometricPrompt.CryptoObject create(Signature r100) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r100);
        }

        public static Cipher getCipher(android.hardware.biometrics.BiometricPrompt.CryptoObject r100) {
            return r100.getCipher();
        }

        public static Mac getMac(android.hardware.biometrics.BiometricPrompt.CryptoObject r100) {
            return r100.getMac();
        }

        public static Signature getSignature(android.hardware.biometrics.BiometricPrompt.CryptoObject r100) {
            return r100.getSignature();
        }

        public static android.hardware.biometrics.BiometricPrompt.CryptoObject create(Cipher r100) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r100);
        }

        public static android.hardware.biometrics.BiometricPrompt.CryptoObject create(Mac r100) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r100);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static android.hardware.biometrics.BiometricPrompt.CryptoObject create(IdentityCredential r100) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r100);
        }

        public static IdentityCredential getIdentityCredential(android.hardware.biometrics.BiometricPrompt.CryptoObject r100) {
            return r100.getIdentityCredential();
        }
    }

    private CryptoObjectUtils() {
    }

    public static BiometricPrompt.CryptoObject createFakeCryptoObject() {
        KeyStore r100 = KeyStore.getInstance(KEYSTORE_INSTANCE);     // Catch: Throwable -> L5
        r100.load(null);     // Catch: Throwable -> L5
        KeyGenParameterSpec.Builder r101 = Api23Impl.createKeyGenParameterSpecBuilder(FAKE_KEY_NAME, 3);     // Catch: Throwable -> L5
        Api23Impl.setBlockModeCBC(r101);     // Catch: Throwable -> L5
        Api23Impl.setEncryptionPaddingPKCS7(r101);     // Catch: Throwable -> L5
        KeyGenerator r102 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, KEYSTORE_INSTANCE);     // Catch: Throwable -> L5
        Api23Impl.initKeyGenerator(r102, Api23Impl.buildKeyGenParameterSpec(r101));     // Catch: Throwable -> L5
        r102.generateKey();     // Catch: Throwable -> L5
        SecretKey r103 = (SecretKey) r100.getKey(FAKE_KEY_NAME, null);     // Catch: Throwable -> L5
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L5
        r104.init(1, r103);     // Catch: Throwable -> L5
        return new BiometricPrompt.CryptoObject(r104);
    L5:
        return null;
    }

    public static BiometricPrompt.CryptoObject unwrapFromBiometricPrompt(android.hardware.biometrics.BiometricPrompt.CryptoObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Cipher r101 = Api28Impl.getCipher(r100);
        if (r101 != null) goto L8;
        Signature r102 = Api28Impl.getSignature(r100);
        if (r102 != null) goto L12;
        Mac r103 = Api28Impl.getMac(r100);
        if (r103 == null) goto L18;
        return new BiometricPrompt.CryptoObject(r103);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L23;
        IdentityCredential r104 = Api30Impl.getIdentityCredential(r100);
        if (r104 != null) goto L22;
        return null;
    L22:
        return new BiometricPrompt.CryptoObject(r104);
    L23:
        return null;
    L12:
        return new BiometricPrompt.CryptoObject(r102);
    L8:
        return new BiometricPrompt.CryptoObject(r101);
    }

    public static BiometricPrompt.CryptoObject unwrapFromFingerprintManager(FingerprintManagerCompat.CryptoObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Cipher r101 = r100.getCipher();
        if (r101 != null) goto L8;
        Signature r102 = r100.getSignature();
        if (r102 != null) goto L12;
        Mac r103 = r100.getMac();
        if (r103 != null) goto L16;
        return null;
    L16:
        return new BiometricPrompt.CryptoObject(r103);
    L12:
        return new BiometricPrompt.CryptoObject(r102);
    L8:
        return new BiometricPrompt.CryptoObject(r101);
    }

    public static android.hardware.biometrics.BiometricPrompt.CryptoObject wrapForBiometricPrompt(BiometricPrompt.CryptoObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Cipher r101 = r100.getCipher();
        if (r101 != null) goto L8;
        Signature r102 = r100.getSignature();
        if (r102 != null) goto L12;
        Mac r103 = r100.getMac();
        if (r103 == null) goto L18;
        return Api28Impl.create(r103);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L23;
        IdentityCredential r104 = r100.getIdentityCredential();
        if (r104 == null) goto L23;
        return Api30Impl.create(r104);
    L23:
        return null;
    L12:
        return Api28Impl.create(r102);
    L8:
        return Api28Impl.create(r101);
    }

    public static FingerprintManagerCompat.CryptoObject wrapForFingerprintManager(BiometricPrompt.CryptoObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Cipher r101 = r100.getCipher();
        if (r101 != null) goto L8;
        Signature r102 = r100.getSignature();
        if (r102 != null) goto L12;
        Mac r103 = r100.getMac();
        if (r103 == null) goto L18;
        return new FingerprintManagerCompat.CryptoObject(r103);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L20;
        r100.getIdentityCredential();
    L20:
        return null;
    L12:
        return new FingerprintManagerCompat.CryptoObject(r102);
    L8:
        return new FingerprintManagerCompat.CryptoObject(r101);
    }
}
