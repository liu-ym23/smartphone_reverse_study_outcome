package com.android.server.timezonedetector;

import android.app.time.TimeZoneConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public interface ServiceConfigAccessor {
    public static final String PROVIDER_MODE_DISABLED = "disabled";
    public static final String PROVIDER_MODE_ENABLED = "enabled";

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProviderMode {
    }

    void addConfigurationInternalChangeListener(StateChangeListener r1);

    void addLocationTimeZoneManagerConfigListener(StateChangeListener r1);

    ConfigurationInternal getConfigurationInternal(int r1);

    ConfigurationInternal getCurrentUserConfigurationInternal();

    Optional<Boolean> getGeoDetectionSettingEnabledOverride();

    Duration getLocationTimeZoneProviderEventFilteringAgeThreshold();

    Duration getLocationTimeZoneProviderInitializationTimeout();

    Duration getLocationTimeZoneProviderInitializationTimeoutFuzz();

    Duration getLocationTimeZoneUncertaintyDelay();

    String getPrimaryLocationTimeZoneProviderMode();

    String getPrimaryLocationTimeZoneProviderPackageName();

    boolean getRecordStateChangesForTests();

    String getSecondaryLocationTimeZoneProviderMode();

    String getSecondaryLocationTimeZoneProviderPackageName();

    boolean isGeoDetectionEnabledForUsersByDefault();

    boolean isGeoTimeZoneDetectionFeatureSupported();

    boolean isGeoTimeZoneDetectionFeatureSupportedInConfig();

    boolean isTelephonyTimeZoneDetectionFeatureSupported();

    boolean isTestPrimaryLocationTimeZoneProvider();

    boolean isTestSecondaryLocationTimeZoneProvider();

    void removeConfigurationInternalChangeListener(StateChangeListener r1);

    void resetVolatileTestConfig();

    void setRecordStateChangesForTests(boolean r1);

    void setTestPrimaryLocationTimeZoneProviderPackageName(String r1);

    void setTestSecondaryLocationTimeZoneProviderPackageName(String r1);

    boolean updateConfiguration(int r1, TimeZoneConfiguration r2, boolean r3);
}
