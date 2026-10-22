package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean hasEnrolledFingerprints(Object r0) {
            return ((FingerprintManager) r0).hasEnrolledFingerprints();
        }

        static boolean isHardwareDetected(Object r0) {
            return ((FingerprintManager) r0).isHardwareDetected();
        }

        static void authenticate(Object r6, Object r7, CancellationSignal r8, int r9, Object r10, Handler r11) {
            ((FingerprintManager) r6).authenticate((FingerprintManager.CryptoObject) r7, r8, r9, (FingerprintManager.AuthenticationCallback) r10, r11);
        }

        static FingerprintManager.CryptoObject getCryptoObject(Object r0) {
            return ((FingerprintManager.AuthenticationResult) r0).getCryptoObject();
        }

        public static FingerprintManager getFingerprintManagerOrNull(Context r2) {
            if (r2.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
            return null;
        L5:
            return (FingerprintManager) r2.getSystemService(FingerprintManager.class);
        }

        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            if (r2.getCipher() == null) goto L10;
            return new FingerprintManager.CryptoObject(r2.getCipher());
        L10:
            if (r2.getSignature() == null) goto L14;
            return new FingerprintManager.CryptoObject(r2.getSignature());
        L14:
            if (r2.getMac() != null) goto L16;
            return null;
        L16:
            return new FingerprintManager.CryptoObject(r2.getMac());
        }

        public static CryptoObject unwrapCryptoObject(Object r2) {
            FingerprintManager.CryptoObject r3 = (FingerprintManager.CryptoObject) r2;
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3.getCipher() == null) goto L10;
            return new CryptoObject(r3.getCipher());
        L10:
            if (r3.getSignature() == null) goto L14;
            return new CryptoObject(r3.getSignature());
        L14:
            if (r3.getMac() != null) goto L16;
            return null;
        L16:
            return new CryptoObject(r3.getMac());
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int r1, CharSequence r2) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int r1, CharSequence r2) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r1) {
        }

        public AuthenticationCallback() {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject r1) {
            this.mCryptoObject = r1;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature r1) {
            this.mSignature = r1;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher r1) {
            this.mCipher = r1;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac r1) {
            this.mMac = r1;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }
    }

    public static FingerprintManagerCompat from(Context r1) {
        return new FingerprintManagerCompat(r1);
    }

    private FingerprintManagerCompat(Context r1) {
        this.mContext = r1;
    }

    public boolean hasEnrolledFingerprints() {
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (Api23Impl.hasEnrolledFingerprints(r0) == false) goto L7;
        return true;
    }

    public boolean isHardwareDetected() {
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (Api23Impl.isHardwareDetected(r0) == false) goto L7;
        return true;
    }

    public void authenticate(CryptoObject r7, int r8, androidx.core.os.CancellationSignal r9, AuthenticationCallback r10, Handler r11) {
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 == null) goto L9;
        if (r9 == null) goto L6;
        CancellationSignal r6 = (CancellationSignal) r9.getCancellationSignalObject();
    L7:
        FingerprintManager.CryptoObject r1 = wrapCryptoObject(r7);
        Api23Impl.authenticate(r0, r1, r6, r8, wrapCallback(r10), r11);
        return;
    L6:
        r6 = null;
        goto L7
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context r0) {
        return Api23Impl.getFingerprintManagerOrNull(r0);
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r0) {
        return Api23Impl.wrapCryptoObject(r0);
    }

    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject r0) {
        return Api23Impl.unwrapCryptoObject(r0);
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback r1) {
        return new AnonymousClass1(r1);
    }
}
