package com.android.server.timezonedetector;

import android.app.time.TimeZoneCapabilities;
import android.app.time.TimeZoneConfiguration;
import android.os.UserHandle;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ConfigurationInternal {
    public static final int DETECTION_MODE_GEO = 2;
    public static final int DETECTION_MODE_MANUAL = 1;
    public static final int DETECTION_MODE_TELEPHONY = 3;
    public static final int DETECTION_MODE_UNKNOWN = 0;
    private final boolean mAutoDetectionEnabledSetting;
    private final boolean mEnhancedMetricsCollectionEnabled;
    private final boolean mGeoDetectionEnabledSetting;
    private final boolean mGeoDetectionRunInBackgroundEnabled;
    private final boolean mGeoDetectionSupported;
    private final boolean mLocationEnabledSetting;
    private final boolean mManualChangeTrackingSupported;
    private final boolean mNotificationTrackingSupported;
    private final boolean mNotificationsEnabledSetting;
    private final boolean mNotificationsSupported;
    private final boolean mTelephonyDetectionSupported;
    private final boolean mTelephonyFallbackSupported;
    private final boolean mUserConfigAllowed;
    private final int mUserId;

    public static class Builder {
        private boolean mAutoDetectionEnabledSetting;
        private boolean mEnhancedMetricsCollectionEnabled;
        private boolean mGeoDetectionEnabledSetting;
        private boolean mGeoDetectionRunInBackgroundEnabled;
        private boolean mGeoDetectionSupported;
        private boolean mLocationEnabledSetting;
        private boolean mManualChangeTrackingSupported;
        private boolean mNotificationsEnabledSetting;
        private boolean mNotificationsSupported;
        private boolean mNotificationsTrackingSupported;
        private boolean mTelephonyDetectionSupported;
        private boolean mTelephonyFallbackSupported;
        private boolean mUserConfigAllowed;
        private Integer mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmAutoDetectionEnabledSetting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8577$$Nest$fgetmAutoDetectionEnabledSetting(Builder r0) {
            return r0.mAutoDetectionEnabledSetting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEnhancedMetricsCollectionEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8578$$Nest$fgetmEnhancedMetricsCollectionEnabled(Builder r0) {
            return r0.mEnhancedMetricsCollectionEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGeoDetectionEnabledSetting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8579$$Nest$fgetmGeoDetectionEnabledSetting(Builder r0) {
            return r0.mGeoDetectionEnabledSetting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGeoDetectionRunInBackgroundEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8580$$Nest$fgetmGeoDetectionRunInBackgroundEnabled(Builder r0) {
            return r0.mGeoDetectionRunInBackgroundEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGeoDetectionSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8581$$Nest$fgetmGeoDetectionSupported(Builder r0) {
            return r0.mGeoDetectionSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLocationEnabledSetting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8582$$Nest$fgetmLocationEnabledSetting(Builder r0) {
            return r0.mLocationEnabledSetting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmManualChangeTrackingSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8583$$Nest$fgetmManualChangeTrackingSupported(Builder r0) {
            return r0.mManualChangeTrackingSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNotificationsEnabledSetting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8584$$Nest$fgetmNotificationsEnabledSetting(Builder r0) {
            return r0.mNotificationsEnabledSetting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNotificationsSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8585$$Nest$fgetmNotificationsSupported(Builder r0) {
            return r0.mNotificationsSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNotificationsTrackingSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8586$$Nest$fgetmNotificationsTrackingSupported(Builder r0) {
            return r0.mNotificationsTrackingSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyDetectionSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8587$$Nest$fgetmTelephonyDetectionSupported(Builder r0) {
            return r0.mTelephonyDetectionSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyFallbackSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8588$$Nest$fgetmTelephonyFallbackSupported(Builder r0) {
            return r0.mTelephonyFallbackSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserConfigAllowed, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8589$$Nest$fgetmUserConfigAllowed(Builder r0) {
            return r0.mUserConfigAllowed;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ Integer m8590$$Nest$fgetmUserId(Builder r0) {
            return r0.mUserId;
        }

        public Builder() {
        }

        public Builder(ConfigurationInternal toCopy) {
            this.mUserId = Integer.valueOf(ConfigurationInternal.m8576$$Nest$fgetmUserId(toCopy));
            this.mUserConfigAllowed = ConfigurationInternal.m8575$$Nest$fgetmUserConfigAllowed(toCopy);
            this.mTelephonyDetectionSupported = ConfigurationInternal.m8573$$Nest$fgetmTelephonyDetectionSupported(toCopy);
            this.mTelephonyFallbackSupported = ConfigurationInternal.m8574$$Nest$fgetmTelephonyFallbackSupported(toCopy);
            this.mGeoDetectionSupported = ConfigurationInternal.m8567$$Nest$fgetmGeoDetectionSupported(toCopy);
            this.mGeoDetectionRunInBackgroundEnabled = ConfigurationInternal.m8566$$Nest$fgetmGeoDetectionRunInBackgroundEnabled(toCopy);
            this.mEnhancedMetricsCollectionEnabled = ConfigurationInternal.m8564$$Nest$fgetmEnhancedMetricsCollectionEnabled(toCopy);
            this.mAutoDetectionEnabledSetting = ConfigurationInternal.m8563$$Nest$fgetmAutoDetectionEnabledSetting(toCopy);
            this.mLocationEnabledSetting = ConfigurationInternal.m8568$$Nest$fgetmLocationEnabledSetting(toCopy);
            this.mGeoDetectionEnabledSetting = ConfigurationInternal.m8565$$Nest$fgetmGeoDetectionEnabledSetting(toCopy);
            this.mNotificationsSupported = ConfigurationInternal.m8572$$Nest$fgetmNotificationsSupported(toCopy);
            this.mNotificationsEnabledSetting = ConfigurationInternal.m8571$$Nest$fgetmNotificationsEnabledSetting(toCopy);
            this.mNotificationsTrackingSupported = ConfigurationInternal.m8570$$Nest$fgetmNotificationTrackingSupported(toCopy);
            this.mManualChangeTrackingSupported = ConfigurationInternal.m8569$$Nest$fgetmManualChangeTrackingSupported(toCopy);
        }

        public Builder setUserId(int userId) {
            this.mUserId = Integer.valueOf(userId);
            return this;
        }

        public Builder setUserConfigAllowed(boolean configAllowed) {
            this.mUserConfigAllowed = configAllowed;
            return this;
        }

        public Builder setTelephonyDetectionFeatureSupported(boolean supported) {
            this.mTelephonyDetectionSupported = supported;
            return this;
        }

        public Builder setGeoDetectionFeatureSupported(boolean supported) {
            this.mGeoDetectionSupported = supported;
            return this;
        }

        public Builder setTelephonyFallbackSupported(boolean supported) {
            this.mTelephonyFallbackSupported = supported;
            return this;
        }

        public Builder setGeoDetectionRunInBackgroundEnabled(boolean enabled) {
            this.mGeoDetectionRunInBackgroundEnabled = enabled;
            return this;
        }

        public Builder setEnhancedMetricsCollectionEnabled(boolean enabled) {
            this.mEnhancedMetricsCollectionEnabled = enabled;
            return this;
        }

        public Builder setAutoDetectionEnabledSetting(boolean enabled) {
            this.mAutoDetectionEnabledSetting = enabled;
            return this;
        }

        public Builder setLocationEnabledSetting(boolean enabled) {
            this.mLocationEnabledSetting = enabled;
            return this;
        }

        public Builder setGeoDetectionEnabledSetting(boolean enabled) {
            this.mGeoDetectionEnabledSetting = enabled;
            return this;
        }

        public Builder setNotificationsEnabledSetting(boolean enabled) {
            this.mNotificationsEnabledSetting = enabled;
            return this;
        }

        public Builder setNotificationsSupported(boolean enabled) {
            this.mNotificationsSupported = enabled;
            return this;
        }

        public Builder setNotificationsTrackingSupported(boolean supported) {
            this.mNotificationsTrackingSupported = supported;
            return this;
        }

        public Builder setManualChangeTrackingSupported(boolean supported) {
            this.mManualChangeTrackingSupported = supported;
            return this;
        }

        public ConfigurationInternal build() {
            return new ConfigurationInternal(this, null);
        }
    }

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface DetectionMode {
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutoDetectionEnabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8563$$Nest$fgetmAutoDetectionEnabledSetting(ConfigurationInternal r0) {
        return r0.mAutoDetectionEnabledSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnhancedMetricsCollectionEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8564$$Nest$fgetmEnhancedMetricsCollectionEnabled(ConfigurationInternal r0) {
        return r0.mEnhancedMetricsCollectionEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGeoDetectionEnabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8565$$Nest$fgetmGeoDetectionEnabledSetting(ConfigurationInternal r0) {
        return r0.mGeoDetectionEnabledSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGeoDetectionRunInBackgroundEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8566$$Nest$fgetmGeoDetectionRunInBackgroundEnabled(ConfigurationInternal r0) {
        return r0.mGeoDetectionRunInBackgroundEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGeoDetectionSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8567$$Nest$fgetmGeoDetectionSupported(ConfigurationInternal r0) {
        return r0.mGeoDetectionSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocationEnabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8568$$Nest$fgetmLocationEnabledSetting(ConfigurationInternal r0) {
        return r0.mLocationEnabledSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmManualChangeTrackingSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8569$$Nest$fgetmManualChangeTrackingSupported(ConfigurationInternal r0) {
        return r0.mManualChangeTrackingSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationTrackingSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8570$$Nest$fgetmNotificationTrackingSupported(ConfigurationInternal r0) {
        return r0.mNotificationTrackingSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationsEnabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8571$$Nest$fgetmNotificationsEnabledSetting(ConfigurationInternal r0) {
        return r0.mNotificationsEnabledSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationsSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8572$$Nest$fgetmNotificationsSupported(ConfigurationInternal r0) {
        return r0.mNotificationsSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyDetectionSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8573$$Nest$fgetmTelephonyDetectionSupported(ConfigurationInternal r0) {
        return r0.mTelephonyDetectionSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyFallbackSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8574$$Nest$fgetmTelephonyFallbackSupported(ConfigurationInternal r0) {
        return r0.mTelephonyFallbackSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserConfigAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8575$$Nest$fgetmUserConfigAllowed(ConfigurationInternal r0) {
        return r0.mUserConfigAllowed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8576$$Nest$fgetmUserId(ConfigurationInternal r0) {
        return r0.mUserId;
    }

    /* synthetic */ ConfigurationInternal(Builder r1, ConfigurationInternalIA r2) {
        this(r1);
    }

    private ConfigurationInternal(Builder builder) {
        this.mTelephonyDetectionSupported = Builder.m8587$$Nest$fgetmTelephonyDetectionSupported(builder);
        this.mGeoDetectionSupported = Builder.m8581$$Nest$fgetmGeoDetectionSupported(builder);
        this.mTelephonyFallbackSupported = Builder.m8588$$Nest$fgetmTelephonyFallbackSupported(builder);
        this.mGeoDetectionRunInBackgroundEnabled = Builder.m8580$$Nest$fgetmGeoDetectionRunInBackgroundEnabled(builder);
        this.mEnhancedMetricsCollectionEnabled = Builder.m8578$$Nest$fgetmEnhancedMetricsCollectionEnabled(builder);
        this.mAutoDetectionEnabledSetting = Builder.m8577$$Nest$fgetmAutoDetectionEnabledSetting(builder);
        Integer r0 = Builder.m8590$$Nest$fgetmUserId(builder);
        r0.getClass();
        this.mUserId = r0.intValue();
        this.mUserConfigAllowed = Builder.m8589$$Nest$fgetmUserConfigAllowed(builder);
        this.mLocationEnabledSetting = Builder.m8582$$Nest$fgetmLocationEnabledSetting(builder);
        this.mGeoDetectionEnabledSetting = Builder.m8579$$Nest$fgetmGeoDetectionEnabledSetting(builder);
        this.mNotificationsSupported = Builder.m8585$$Nest$fgetmNotificationsSupported(builder);
        this.mNotificationsEnabledSetting = Builder.m8584$$Nest$fgetmNotificationsEnabledSetting(builder);
        this.mNotificationTrackingSupported = Builder.m8586$$Nest$fgetmNotificationsTrackingSupported(builder);
        this.mManualChangeTrackingSupported = Builder.m8583$$Nest$fgetmManualChangeTrackingSupported(builder);
    }

    public boolean isAutoDetectionSupported() {
        if (this.mTelephonyDetectionSupported == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mGeoDetectionSupported == true) goto L8;
        return false;
    }

    public boolean isTelephonyDetectionSupported() {
        return this.mTelephonyDetectionSupported;
    }

    public boolean isGeoDetectionSupported() {
        return this.mGeoDetectionSupported;
    }

    public boolean isTelephonyFallbackSupported() {
        return this.mTelephonyFallbackSupported;
    }

    public boolean areNotificationsSupported() {
        return this.mNotificationsSupported;
    }

    public boolean isNotificationTrackingSupported() {
        if (areNotificationsSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNotificationTrackingSupported == false) goto L7;
        return true;
    }

    public boolean isManualChangeTrackingSupported() {
        return this.mManualChangeTrackingSupported;
    }

    boolean getGeoDetectionRunInBackgroundEnabledSetting() {
        return this.mGeoDetectionRunInBackgroundEnabled;
    }

    public boolean isEnhancedMetricsCollectionEnabled() {
        return this.mEnhancedMetricsCollectionEnabled;
    }

    public boolean getAutoDetectionEnabledSetting() {
        return this.mAutoDetectionEnabledSetting;
    }

    public boolean getAutoDetectionEnabledBehavior() {
        if (isAutoDetectionSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (getAutoDetectionEnabledSetting() == false) goto L7;
        return true;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public UserHandle getUserHandle() {
        return UserHandle.of(this.mUserId);
    }

    public boolean isUserConfigAllowed() {
        return this.mUserConfigAllowed;
    }

    public boolean getLocationEnabledSetting() {
        return this.mLocationEnabledSetting;
    }

    public boolean getGeoDetectionEnabledSetting() {
        return this.mGeoDetectionEnabledSetting;
    }

    public int getDetectionMode() {
        if (isAutoDetectionSupported() == true) goto L6;
        return 1;
    L6:
        if (getAutoDetectionEnabledSetting() == true) goto L9;
        return 1;
    L9:
        if (getGeoDetectionEnabledBehavior() == false) goto L13;
        return 2;
    L13:
        if (isTelephonyDetectionSupported() == false) goto L16;
        return 3;
    L16:
        return 0;
    }

    private boolean getGeoDetectionEnabledBehavior() {
        if (isGeoDetectionSupported() == true) goto L5;
        return false;
    L5:
        if (getLocationEnabledSetting() == true) goto L7;
        return false;
    L7:
        if (isTelephonyDetectionSupported() == true) goto L9;
        return true;
    L9:
        return getGeoDetectionEnabledSetting();
    }

    public boolean isGeoDetectionExecutionEnabled() {
        if (getDetectionMode() != 2) goto L5;
    L8:
        return true;
    L5:
        if (getGeoDetectionRunInBackgroundEnabledBehavior() == true) goto L8;
        return false;
    }

    private boolean getGeoDetectionRunInBackgroundEnabledBehavior() {
        if (isGeoDetectionSupported() == true) goto L5;
    L11:
        return false;
    L5:
        if (getLocationEnabledSetting() == false) goto L11;
        if (getAutoDetectionEnabledSetting() == false) goto L11;
        if (getGeoDetectionRunInBackgroundEnabledSetting() == false) goto L11;
        return true;
    }

    public boolean getNotificationsEnabledBehavior() {
        if (areNotificationsSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (getNotificationsEnabledSetting() == false) goto L7;
        return true;
    }

    private boolean getNotificationsEnabledSetting() {
        return this.mNotificationsEnabledSetting;
    }

    public TimeZoneCapabilities asCapabilities(boolean bypassUserPolicyChecks) {
        UserHandle userHandle = UserHandle.of(this.mUserId);
        TimeZoneCapabilities.Builder builder = new TimeZoneCapabilities.Builder(userHandle);
        if (isUserConfigAllowed() == true) goto L7;
        if (bypassUserPolicyChecks == true) goto L7;
        boolean allowConfigDateTime = false;
    L8:
        boolean deviceHasAutoTimeZoneDetection = isAutoDetectionSupported();
        if (deviceHasAutoTimeZoneDetection == true) goto L11;
        int configureAutoDetectionEnabledCapability = 10;
    L14:
        builder.setConfigureAutoDetectionEnabledCapability(configureAutoDetectionEnabledCapability);
        builder.setUseLocationEnabled(this.mLocationEnabledSetting);
        boolean deviceHasLocationTimeZoneDetection = isGeoDetectionSupported();
        boolean deviceHasTelephonyDetection = isTelephonyDetectionSupported();
        if (deviceHasLocationTimeZoneDetection == false) goto L25;
        if (deviceHasTelephonyDetection == false) goto L25;
        if (this.mAutoDetectionEnabledSetting == true) goto L21;
    L24:
        int configureGeolocationDetectionEnabledCapability = 30;
    L26:
        builder.setConfigureGeoDetectionEnabledCapability(configureGeolocationDetectionEnabledCapability);
        if (allowConfigDateTime == true) goto L30;
        int suggestManualTimeZoneCapability = 20;
    L33:
        builder.setSetManualTimeZoneCapability(suggestManualTimeZoneCapability);
        if (areNotificationsSupported() == false) goto L36;
        int configureNotificationsEnabledCapability = 40;
    L37:
        builder.setConfigureNotificationsEnabledCapability(configureNotificationsEnabledCapability);
        return builder.build();
    L36:
        configureNotificationsEnabledCapability = 10;
        goto L37
    L30:
        if (getAutoDetectionEnabledBehavior() == false) goto L32;
        suggestManualTimeZoneCapability = 30;
        goto L33
    L32:
        suggestManualTimeZoneCapability = 40;
        goto L33
    L21:
        if (getLocationEnabledSetting() == false) goto L24;
        configureGeolocationDetectionEnabledCapability = 40;
    L25:
        configureGeolocationDetectionEnabledCapability = 10;
        goto L26
    L11:
        if (allowConfigDateTime == true) goto L13;
        configureAutoDetectionEnabledCapability = 20;
        goto L14
    L13:
        configureAutoDetectionEnabledCapability = 40;
    L7:
        allowConfigDateTime = true;
        goto L8
    }

    public TimeZoneConfiguration asConfiguration() {
        return new TimeZoneConfiguration.Builder().setAutoDetectionEnabled(getAutoDetectionEnabledSetting()).setGeoDetectionEnabled(getGeoDetectionEnabledSetting()).setNotificationsEnabled(getNotificationsEnabledSetting()).build();
    }

    public ConfigurationInternal merge(TimeZoneConfiguration newConfiguration) {
        Builder builder = new Builder(this);
        if (newConfiguration.hasIsAutoDetectionEnabled() == false) goto L6;
        builder.setAutoDetectionEnabledSetting(newConfiguration.isAutoDetectionEnabled());
    L6:
        if (newConfiguration.hasIsGeoDetectionEnabled() == false) goto L9;
        builder.setGeoDetectionEnabledSetting(newConfiguration.isGeoDetectionEnabled());
    L9:
        if (newConfiguration.hasIsNotificationsEnabled() == false) goto L12;
        builder.setNotificationsEnabledSetting(newConfiguration.areNotificationsEnabled());
    L12:
        return builder.build();
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L41:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L41;
        ConfigurationInternal that = (ConfigurationInternal) o;
        if (this.mUserId != that.mUserId) goto L40;
        if (this.mUserConfigAllowed != that.mUserConfigAllowed) goto L40;
        if (this.mTelephonyDetectionSupported != that.mTelephonyDetectionSupported) goto L40;
        if (this.mGeoDetectionSupported != that.mGeoDetectionSupported) goto L40;
        if (this.mTelephonyFallbackSupported != that.mTelephonyFallbackSupported) goto L40;
        if (this.mGeoDetectionRunInBackgroundEnabled != that.mGeoDetectionRunInBackgroundEnabled) goto L40;
        if (this.mEnhancedMetricsCollectionEnabled != that.mEnhancedMetricsCollectionEnabled) goto L40;
        if (this.mAutoDetectionEnabledSetting != that.mAutoDetectionEnabledSetting) goto L40;
        if (this.mLocationEnabledSetting != that.mLocationEnabledSetting) goto L40;
        if (this.mGeoDetectionEnabledSetting != that.mGeoDetectionEnabledSetting) goto L40;
        if (this.mNotificationsSupported != that.mNotificationsSupported) goto L40;
        if (this.mNotificationsEnabledSetting != that.mNotificationsEnabledSetting) goto L40;
        if (this.mNotificationTrackingSupported != that.mNotificationTrackingSupported) goto L40;
        if (this.mManualChangeTrackingSupported != that.mManualChangeTrackingSupported) goto L40;
        return true;
    L40:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mUserId), Boolean.valueOf(this.mUserConfigAllowed), Boolean.valueOf(this.mTelephonyDetectionSupported), Boolean.valueOf(this.mGeoDetectionSupported), Boolean.valueOf(this.mTelephonyFallbackSupported), Boolean.valueOf(this.mGeoDetectionRunInBackgroundEnabled), Boolean.valueOf(this.mEnhancedMetricsCollectionEnabled), Boolean.valueOf(this.mAutoDetectionEnabledSetting), Boolean.valueOf(this.mLocationEnabledSetting), Boolean.valueOf(this.mGeoDetectionEnabledSetting), Boolean.valueOf(this.mNotificationsSupported), Boolean.valueOf(this.mNotificationsEnabledSetting), Boolean.valueOf(this.mNotificationTrackingSupported), Boolean.valueOf(this.mManualChangeTrackingSupported)});
    }

    public String toString() {
        return "ConfigurationInternal{mUserId=" + this.mUserId + ", mUserConfigAllowed=" + this.mUserConfigAllowed + ", mTelephonyDetectionSupported=" + this.mTelephonyDetectionSupported + ", mGeoDetectionSupported=" + this.mGeoDetectionSupported + ", mTelephonyFallbackSupported=" + this.mTelephonyFallbackSupported + ", mGeoDetectionRunInBackgroundEnabled=" + this.mGeoDetectionRunInBackgroundEnabled + ", mEnhancedMetricsCollectionEnabled=" + this.mEnhancedMetricsCollectionEnabled + ", mAutoDetectionEnabledSetting=" + this.mAutoDetectionEnabledSetting + ", mLocationEnabledSetting=" + this.mLocationEnabledSetting + ", mGeoDetectionEnabledSetting=" + this.mGeoDetectionEnabledSetting + ", mNotificationsSupported=" + this.mNotificationsSupported + ", mNotificationsEnabledSetting=" + this.mNotificationsEnabledSetting + ", mNotificationTrackingSupported=" + this.mNotificationTrackingSupported + ", mManualChangeTrackingSupported=" + this.mManualChangeTrackingSupported + '}';
    }
}
