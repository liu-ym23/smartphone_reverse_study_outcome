package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes17.dex */
public class FingerprintManagerCompat {
    private final Context mContext;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static FingerprintManager.CryptoObject getCryptoObject(Object r100) {
            return ((FingerprintManager.AuthenticationResult) r100).getCryptoObject();
        }

        public static FingerprintManager getFingerprintManagerOrNull(Context r100) {
            int r101 = Build.VERSION.SDK_INT;
            if (r101 == 23) goto L5;
            if (r101 > 23) goto L8;
            return null;
        L8:
            if (r100.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L10;
            return null;
        L10:
            return (FingerprintManager) r100.getSystemService(FingerprintManager.class);
        L5:
            return (FingerprintManager) r100.getSystemService(FingerprintManager.class);
        }

        public static boolean hasEnrolledFingerprints(Object r100) {
            return ((FingerprintManager) r100).hasEnrolledFingerprints();
        }

        public static boolean isHardwareDetected(Object r100) {
            return ((FingerprintManager) r100).isHardwareDetected();
        }

        public static CryptoObject unwrapCryptoObject(Object r100) {
            FingerprintManager.CryptoObject r101 = (FingerprintManager.CryptoObject) r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            if (r101.getCipher() == null) goto L10;
            return new CryptoObject(r101.getCipher());
        L10:
            if (r101.getSignature() == null) goto L14;
            return new CryptoObject(r101.getSignature());
        L14:
            if (r101.getMac() != null) goto L16;
            return null;
        L16:
            return new CryptoObject(r101.getMac());
        }

        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.getCipher() == null) goto L10;
            return new FingerprintManager.CryptoObject(r100.getCipher());
        L10:
            if (r100.getSignature() == null) goto L14;
            return new FingerprintManager.CryptoObject(r100.getSignature());
        L14:
            if (r100.getMac() != null) goto L16;
            return null;
        L16:
            return new FingerprintManager.CryptoObject(r100.getMac());
        }

        public static void authenticate(Object r100, Object r101, CancellationSignal r102, int r103, Object r110, Handler r111) {
            ((FingerprintManager) r100).authenticate((FingerprintManager.CryptoObject) r101, r102, r103, (FingerprintManager.AuthenticationCallback) r110, r111);
        }
    }

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r100, CharSequence r101) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int r100, CharSequence r101) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r100) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }

        public AuthenticationResult(CryptoObject r100) {
            this.mCryptoObject = r100;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(Signature r100) {
            this.mSignature = r100;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher r100) {
            this.mCipher = r100;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac r100) {
            this.mMac = r100;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    public boolean hasEnrolledFingerprints() {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        FingerprintManager r100 = getFingerprintManagerOrNull(this.mContext);
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Api23Impl.hasEnrolledFingerprints(r100) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean isHardwareDetected() {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        FingerprintManager r100 = getFingerprintManagerOrNull(this.mContext);
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Api23Impl.isHardwareDetected(r100) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private FingerprintManagerCompat(Context r100) {
        this.mContext = r100;
    }

    public static FingerprintManagerCompat from(Context r100) {
        return new FingerprintManagerCompat(r100);
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context r100) {
        return Api23Impl.getFingerprintManagerOrNull(r100);
    }

    public static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject r100) {
        return Api23Impl.unwrapCryptoObject(r100);
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback r100) {
        return new AnonymousClass1(r100);
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r100) {
        return Api23Impl.wrapCryptoObject(r100);
    }

    public void authenticate(CryptoObject r100, int r101, CancellationSignal r110, AuthenticationCallback r111, Handler r112) {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        FingerprintManager r102 = getFingerprintManagerOrNull(this.mContext);
        if (r102 == null) goto L9;
        Api23Impl.authenticate(r102, wrapCryptoObject(r100), r110, r101, wrapCallback(r111), r112);
        return;
    L9:
        return;
    }

    public void authenticate(CryptoObject r100, int r101, androidx.core.os.CancellationSignal r102, AuthenticationCallback r110, Handler r111) {
        if (r102 == null) goto L4;
        CancellationSignal r103 = (CancellationSignal) r102.getCancellationSignalObject();
    L5:
        authenticate(r100, r101, r103, r110, r111);
        return;
    L4:
        r103 = null;
        goto L5
    }
}
