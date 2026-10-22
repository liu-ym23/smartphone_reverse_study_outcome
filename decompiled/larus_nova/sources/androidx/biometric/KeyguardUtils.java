package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
class KeyguardUtils {

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static boolean isKeyguardSecure(KeyguardManager r100) {
            return r100.isKeyguardSecure();
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static KeyguardManager getKeyguardManager(Context r100) {
            return (KeyguardManager) r100.getSystemService(KeyguardManager.class);
        }

        public static boolean isDeviceSecure(KeyguardManager r100) {
            return r100.isDeviceSecure();
        }
    }

    private KeyguardUtils() {
    }

    public static KeyguardManager getKeyguardManager(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Object r101 = r100.getSystemService("keyguard");
        if ((r101 instanceof KeyguardManager) == true) goto L11;
        return null;
    L11:
        return (KeyguardManager) r101;
    L5:
        return Api23Impl.getKeyguardManager(r100);
    }

    public static boolean isDeviceSecuredWithCredential(Context r100) {
        KeyguardManager r101 = getKeyguardManager(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        return Api23Impl.isDeviceSecure(r101);
    L11:
        return Api16Impl.isKeyguardSecure(r101);
    }
}
