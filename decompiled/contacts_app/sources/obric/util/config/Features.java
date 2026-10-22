package obric.util.config;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;

/* JADX INFO: loaded from: classes5.dex */
public final class Features {
    public static final boolean BYTEDANCEOS_FEATURE_TEST = false;
    public static final boolean BYTEDANCEOS_VERSION_2_2_0 = true;
    public static final boolean BYTEDANCEOS_VERSION_3_0_0 = true;
    private static final String CN = "CN";
    private static final String DEFAULT_CODENAME = "Bytedance T2";
    public static final boolean FACTORY_MODE = false;
    public static final boolean FEATURE_2_2_0 = true;
    private static final int FEATURE_OFF = 0;
    private static final int FEATURE_ON = 1;
    public static final Boolean FEATURE_SETUP_WIZARD_FORCE_ACTIVATION = null;
    private static final String JP = "JP";
    private static final String PROP_DEVICE_COLOR = "persist.sys.device_color";
    public static final float SUPPORTED_FEATURE_NUM = 2.2f;
    private static final String TAG = "Features";
    private static final String US = "US";
    public static final String VERSION = "BytedanceOS 2.0";

    static {
        FEATURE_SETUP_WIZARD_FORCE_ACTIVATION = true;
    }

    public Features() {
    }

    public static final boolean isFeatureSoftsimEnabled(Context r1) {
        return r1.getResources().getBoolean(34340873);
    L4:
        return false;
    }

    public static final Boolean isFeatureCMCCEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340867));
    L5:
        return false;
    }

    public static final Boolean isFeatureCdmaBkuEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340864));
    L5:
        return false;
    }

    public static final String getFeatureRegion(Context r3) {
        return r3.getResources().getString(33882250, new Object[]{"CN"});
    L5:
        return "CN";
    }

    public static final boolean isFeatureDomestic(Context r1) {
        return r1.getResources().getBoolean(34340868);
    L4:
        return true;
    }

    public static final Boolean isFeatureOverseaUrlEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340870));
    L5:
        return false;
    }

    public static final Boolean isFeatureUSEnabled(Context r4) {
        return Boolean.valueOf(US.equals(r4.getResources().getString(33882250, new Object[]{"CN"})));
    L6:
        return false;
    }

    public static final boolean isFeatureJPEnabled(Context r4) {
        return JP.equals(r4.getResources().getString(33882250, new Object[]{"CN"}));
    L5:
        return false;
    }

    public static final Boolean isFeatureDSDSEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340869));
    L5:
        return false;
    }

    public static final Boolean isFeatureVirtualKeyEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340875));
    L5:
        return false;
    }

    public static final String getCodename(Context r3) {
        return r3.getResources().getString(33882329, new Object[]{DEFAULT_CODENAME});
    L5:
        return DEFAULT_CODENAME;
    }

    public static final String getFixedCodename(Context r3) {
        return r3.getResources().getString(33882330, new Object[]{DEFAULT_CODENAME});
    L5:
        return DEFAULT_CODENAME;
    }

    public static final boolean getIsSmallMemory(Context r1) {
        return r1.getResources().getBoolean(34340872);
    L4:
        return false;
    }

    public static final Boolean isFeatureCTEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340865));
    L5:
        return false;
    }

    public static final Boolean isFeatureCUEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340866));
    L5:
        return false;
    }

    public static final Boolean isFeatureRndisEnabled(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340871));
    L5:
        return false;
    }

    public static final Boolean isLowRamDevice(Context r1) {
        return Boolean.valueOf(SystemProperties.getBoolean("ro.config.bytedance.low_ram", false));
    }

    public static final Boolean useSmVibEffect(Context r1) {
        String r2 = Build.DEVICE.toLowerCase();
        if ("trident".equals(r2) == false) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return Boolean.valueOf(r3);
    L5:
        if ("ocean".equals(r2) == true) goto L8;
        r3 = false;
        goto L10
    }

    public static final String getDeviceColor() {
        return SystemProperties.get(PROP_DEVICE_COLOR, SystemProperties.get("ro.housing.color"));
    }

    public static final Boolean isUltrasonicSensor(Context r1) {
        return Boolean.valueOf(r1.getResources().getBoolean(34340874));
    L5:
        return false;
    }
}
