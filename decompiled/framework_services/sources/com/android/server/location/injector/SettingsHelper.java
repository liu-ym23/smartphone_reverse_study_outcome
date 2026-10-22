package com.android.server.location.injector;

import android.os.PackageTagsList;
import android.util.IndentingPrintWriter;
import java.io.FileDescriptor;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SettingsHelper {

    public interface GlobalSettingChangedListener extends UserSettingChangedListener {
        void onSettingChanged();

        @Override // com.android.server.location.injector.SettingsHelper.UserSettingChangedListener
        default void onSettingChanged(int userId) {
            onSettingChanged();
        }
    }

    public interface UserSettingChangedListener {
        void onSettingChanged(int r1);
    }

    public abstract void addAdasAllowlistChangedListener(GlobalSettingChangedListener r1);

    public abstract void addIgnoreSettingsAllowlistChangedListener(GlobalSettingChangedListener r1);

    public abstract void addOnBackgroundThrottleIntervalChangedListener(GlobalSettingChangedListener r1);

    public abstract void addOnBackgroundThrottlePackageWhitelistChangedListener(GlobalSettingChangedListener r1);

    public abstract void addOnGnssMeasurementsFullTrackingEnabledChangedListener(GlobalSettingChangedListener r1);

    public abstract void addOnLocationEnabledChangedListener(UserSettingChangedListener r1);

    public abstract void addOnLocationPackageBlacklistChangedListener(UserSettingChangedListener r1);

    public abstract void dump(FileDescriptor r1, IndentingPrintWriter r2, String[] r3);

    public abstract PackageTagsList getAdasAllowlist();

    public abstract long getBackgroundThrottleIntervalMs();

    public abstract Set<String> getBackgroundThrottlePackageWhitelist();

    public abstract long getBackgroundThrottleProximityAlertIntervalMs();

    public abstract float getCoarseLocationAccuracyM();

    public abstract PackageTagsList getIgnoreSettingsAllowlist();

    public abstract boolean isGnssMeasurementsFullTrackingEnabled();

    public abstract boolean isLocationEnabled(int r1);

    public abstract boolean isLocationPackageBlacklisted(int r1, String r2);

    public abstract void removeAdasAllowlistChangedListener(GlobalSettingChangedListener r1);

    public abstract void removeIgnoreSettingsAllowlistChangedListener(GlobalSettingChangedListener r1);

    public abstract void removeOnBackgroundThrottleIntervalChangedListener(GlobalSettingChangedListener r1);

    public abstract void removeOnBackgroundThrottlePackageWhitelistChangedListener(GlobalSettingChangedListener r1);

    public abstract void removeOnGnssMeasurementsFullTrackingEnabledChangedListener(GlobalSettingChangedListener r1);

    public abstract void removeOnLocationEnabledChangedListener(UserSettingChangedListener r1);

    public abstract void removeOnLocationPackageBlacklistChangedListener(UserSettingChangedListener r1);

    public abstract void setLocationEnabled(boolean r1, int r2);

    public SettingsHelper() {
    }
}
