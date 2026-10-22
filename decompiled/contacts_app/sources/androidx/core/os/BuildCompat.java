package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BuildCompat {
    public static final int AD_SERVICES_EXTENSION_INT = 0;
    public static final int R_EXTENSION_INT = 0;
    public static final int S_EXTENSION_INT = 0;
    public static final int T_EXTENSION_INT = 0;

    private static final class Extensions30Impl {
        static final int AD_SERVICES = 0;
        static final int R = 0;
        static final int S = 0;
        static final int TIRAMISU = 0;

        private Extensions30Impl() {
        }

        static {
            R = SdkExtensions.getExtensionVersion(30);
            S = SdkExtensions.getExtensionVersion(31);
            TIRAMISU = SdkExtensions.getExtensionVersion(33);
            AD_SERVICES = SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public @interface PrereleaseSdkCheck {
    }

    @Deprecated
    public static boolean isAtLeastN() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastR() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastS() {
        return true;
    }

    private BuildCompat() {
    }

    protected static boolean isAtLeastPreReleaseCodename(String r2, String r3) {
        if ("REL".equals(r3) == false) goto L6;
        return false;
    L6:
        if (r3.toUpperCase(Locale.ROOT).compareTo(r2.toUpperCase(Locale.ROOT)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Deprecated
    public static boolean isAtLeastSv2() {
        if (Build.VERSION.SDK_INT < 32) goto L5;
    L8:
        return true;
    L5:
        if (isAtLeastPreReleaseCodename("Sv2", Build.VERSION.CODENAME) == true) goto L8;
        return false;
    }

    public static boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 32) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    public static boolean isAtLeastU() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }

    static {
        R_EXTENSION_INT = Extensions30Impl.R;
        S_EXTENSION_INT = Extensions30Impl.S;
        T_EXTENSION_INT = Extensions30Impl.TIRAMISU;
        AD_SERVICES_EXTENSION_INT = Extensions30Impl.AD_SERVICES;
    }
}
