package android.os;

/* loaded from: classes.dex */
public class BuildExt {
    public static final boolean SHELL_EXTERNAL_SDCARD = false;
    public static final String STEPOS_VERSION = getString("ro.build.aios_version");
    private static final String TAG = "BuildExt";

    public static boolean isProductInternational() {
        return false;
    }

    public static boolean isStepOSRom() {
        return getBoolean("ro.stepos.rom.config", true);
    }

    public static boolean isCTA() {
        return getBoolean("ro.vendor.build.cta", false);
    }

    public static boolean hasNFC() {
        return getBoolean("ro.stepos.hardware.nfc", false);
    }

    public static boolean isShopDemo() {
        return getBoolean("ro.stepos.shopdemo", false) || getBoolean("persist.sys.shopdemo", false);
    }

    private static boolean getBoolean(String property, boolean defaultValue) {
        return SystemProperties.getBoolean(property, defaultValue);
    }

    private static String getString(String property) {
        return SystemProperties.get(property, "");
    }
}
