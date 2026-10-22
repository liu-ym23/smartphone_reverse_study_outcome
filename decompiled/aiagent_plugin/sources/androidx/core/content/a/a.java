package androidx.core.content.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;

/* JADX INFO: compiled from: PackageInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.core.content.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PackageInfoCompat.java */
    private static class C0025a {
        static boolean a(PackageManager r0, String r1, byte[] r2, int r3) {
            return r0.hasSigningCertificate(r1, r2, r3);
        }

        static boolean a(SigningInfo r0) {
            return r0.hasMultipleSigners();
        }

        static Signature[] b(SigningInfo r0) {
            return r0.getApkContentsSigners();
        }

        static Signature[] c(SigningInfo r0) {
            return r0.getSigningCertificateHistory();
        }

        static long a(PackageInfo r2) {
            return r2.getLongVersionCode();
        }
    }

    public static long a(PackageInfo r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return C0025a.a(r2);
    L7:
        return r2.versionCode;
    }
}
