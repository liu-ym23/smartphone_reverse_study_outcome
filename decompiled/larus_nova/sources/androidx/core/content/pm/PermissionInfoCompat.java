package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public final class PermissionInfoCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getProtection(PermissionInfo r100) {
            return r100.getProtection();
        }

        public static int getProtectionFlags(PermissionInfo r100) {
            return r100.getProtectionFlags();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    public static int getProtection(PermissionInfo r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getProtection(r100);
    L7:
        return r100.protectionLevel & 15;
    }

    public static int getProtectionFlags(PermissionInfo r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getProtectionFlags(r100);
    L7:
        return r100.protectionLevel & (-16);
    }
}
