package android.content.res.stepostheme;

import android.app.ActivityManager;
import android.content.res.Configuration;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class StepOSConfigurationExtImpl implements IStepOSConfigurationExt {
    public static final int CONFIG_FONT_CHANGED = 536870912;
    public static final int CONFIG_THEME_CHANGED = 1073741824;
    private static final String TAG = "StepOSConfiguration";
    private final AtomicInteger mThemeVersion = new AtomicInteger(0);
    private final AtomicInteger mFontVersion = new AtomicInteger(0);
    private String mThemePackage = null;

    public int getThemeVersion() {
        return this.mThemeVersion.get();
    }

    public void setThemeVersion(int version) {
        this.mThemeVersion.set(version);
        StepOSLogUtil.d("Theme version set to: " + version);
    }

    public int incrementThemeVersion() {
        int newVersion = this.mThemeVersion.incrementAndGet();
        fireConfigurationThemeChange();
        StepOSLogUtil.d("Theme version incremented to: " + newVersion);
        return newVersion;
    }

    public boolean hasThemeChanged(int otherVersion) {
        return this.mThemeVersion.get() != otherVersion;
    }

    public int getFontVersion() {
        return this.mFontVersion.get();
    }

    public void setFontVersion(int version) {
        int old = this.mFontVersion.getAndSet(version);
        if (old != version) {
            fireConfigurationFontChange();
        }
        StepOSLogUtil.d("Font version set to: " + version);
    }

    public boolean hasFontChanged(int otherVersion) {
        return this.mFontVersion.get() != otherVersion;
    }

    public int getThemeDiff(int oldThemeVersion, int newThemeVersion) {
        if (oldThemeVersion != newThemeVersion) {
            int diff = 0 | 1073741824;
            return diff;
        }
        return 0;
    }

    public boolean requiresActivityRestart(int diff) {
        return (1073741824 & diff) != 0;
    }

    public String getThemePackage() {
        return this.mThemePackage;
    }

    public void setThemePackage(String packageName) {
        this.mThemePackage = packageName;
        StepOSLogUtil.d("Theme package set to: " + packageName);
    }

    public boolean isDefaultTheme() {
        return this.mThemePackage == null || this.mThemePackage.isEmpty();
    }

    private void fireConfigurationThemeChange() {
        try {
            Configuration cfg = ActivityManager.getService().getConfiguration();
            if (cfg != null && cfg.configurationExt != null) {
                cfg.configurationExt.fireThemeChange();
                ActivityManager.getService().updateConfiguration(cfg);
            }
        } catch (Throwable t) {
            StepOSLogUtil.d("fireConfigurationThemeChange skipped: " + t.getMessage());
        }
    }

    private void fireConfigurationFontChange() {
        try {
            Configuration cfg = ActivityManager.getService().getConfiguration();
            if (cfg != null && cfg.configurationExt != null) {
                cfg.configurationExt.fireFontChange();
                ActivityManager.getService().updateConfiguration(cfg);
            }
        } catch (Throwable t) {
            StepOSLogUtil.d("fireConfigurationFontChange skipped: " + t.getMessage());
        }
    }
}
