package androidx.biometric;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
class PackageUtils {

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static boolean hasSystemFeatureFingerprint(PackageManager r100) {
            return r100.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    private PackageUtils() {
    }

    public static boolean hasSystemFeatureFingerprint(Context r100) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r100 == null) goto L10;
        if (r100.getPackageManager() == null) goto L10;
        if (Api23Impl.hasSystemFeatureFingerprint(r100.getPackageManager()) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
