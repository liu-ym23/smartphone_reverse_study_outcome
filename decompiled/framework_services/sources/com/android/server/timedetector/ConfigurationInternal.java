package com.android.server.timedetector;

import android.app.time.TimeCapabilities;
import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.os.UserHandle;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public final class ConfigurationInternal {
    private final boolean mAutoDetectionEnabledSetting;
    private final boolean mAutoDetectionSupported;
    private final Instant mAutoSuggestionLowerBound;
    private final Instant mManualSuggestionLowerBound;
    private final int[] mOriginPriorities;
    private final Instant mSuggestionUpperBound;
    private final int mSystemClockConfidenceThresholdMillis;
    private final int mSystemClockUpdateThresholdMillis;
    private final boolean mUserConfigAllowed;
    private final int mUserId;

    static final class Builder {
        private boolean mAutoDetectionEnabledSetting;
        private boolean mAutoDetectionSupported;
        private Instant mAutoSuggestionLowerBound;
        private Instant mManualSuggestionLowerBound;
        private int[] mOriginPriorities;
        private Instant mSuggestionUpperBound;
        private int mSystemClockConfidenceThresholdMillis;
        private int mSystemClockUpdateThresholdMillis;
        private boolean mUserConfigAllowed;
        private final int mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmAutoDetectionEnabledSetting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8538$$Nest$fgetmAutoDetectionEnabledSetting(Builder r0) {
            return r0.mAutoDetectionEnabledSetting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAutoDetectionSupported, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8539$$Nest$fgetmAutoDetectionSupported(Builder r0) {
            return r0.mAutoDetectionSupported;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAutoSuggestionLowerBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ Instant m8540$$Nest$fgetmAutoSuggestionLowerBound(Builder r0) {
            return r0.mAutoSuggestionLowerBound;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmManualSuggestionLowerBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ Instant m8541$$Nest$fgetmManualSuggestionLowerBound(Builder r0) {
            return r0.mManualSuggestionLowerBound;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOriginPriorities, reason: not valid java name */
        static /* bridge */ /* synthetic */ int[] m8542$$Nest$fgetmOriginPriorities(Builder r0) {
            return r0.mOriginPriorities;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSuggestionUpperBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ Instant m8543$$Nest$fgetmSuggestionUpperBound(Builder r0) {
            return r0.mSuggestionUpperBound;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSystemClockConfidenceThresholdMillis, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8544$$Nest$fgetmSystemClockConfidenceThresholdMillis(Builder r0) {
            return r0.mSystemClockConfidenceThresholdMillis;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSystemClockUpdateThresholdMillis, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8545$$Nest$fgetmSystemClockUpdateThresholdMillis(Builder r0) {
            return r0.mSystemClockUpdateThresholdMillis;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserConfigAllowed, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8546$$Nest$fgetmUserConfigAllowed(Builder r0) {
            return r0.mUserConfigAllowed;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8547$$Nest$fgetmUserId(Builder r0) {
            return r0.mUserId;
        }

        Builder(int userId) {
            this.mUserId = userId;
        }

        Builder(ConfigurationInternal toCopy) {
            this.mUserId = ConfigurationInternal.m8537$$Nest$fgetmUserId(toCopy);
            this.mUserConfigAllowed = ConfigurationInternal.m8536$$Nest$fgetmUserConfigAllowed(toCopy);
            this.mAutoDetectionSupported = ConfigurationInternal.m8530$$Nest$fgetmAutoDetectionSupported(toCopy);
            this.mSystemClockUpdateThresholdMillis = ConfigurationInternal.m8535$$Nest$fgetmSystemClockUpdateThresholdMillis(toCopy);
            this.mAutoSuggestionLowerBound = ConfigurationInternal.m8531$$Nest$fgetmAutoSuggestionLowerBound(toCopy);
            this.mManualSuggestionLowerBound = ConfigurationInternal.m8532$$Nest$fgetmManualSuggestionLowerBound(toCopy);
            this.mSuggestionUpperBound = ConfigurationInternal.m8534$$Nest$fgetmSuggestionUpperBound(toCopy);
            this.mOriginPriorities = ConfigurationInternal.m8533$$Nest$fgetmOriginPriorities(toCopy);
            this.mAutoDetectionEnabledSetting = ConfigurationInternal.m8529$$Nest$fgetmAutoDetectionEnabledSetting(toCopy);
        }

        Builder setUserConfigAllowed(boolean userConfigAllowed) {
            this.mUserConfigAllowed = userConfigAllowed;
            return this;
        }

        public Builder setAutoDetectionSupported(boolean supported) {
            this.mAutoDetectionSupported = supported;
            return this;
        }

        public Builder setSystemClockUpdateThresholdMillis(int systemClockUpdateThresholdMillis) {
            this.mSystemClockUpdateThresholdMillis = systemClockUpdateThresholdMillis;
            return this;
        }

        public Builder setSystemClockConfidenceThresholdMillis(int thresholdMillis) {
            this.mSystemClockConfidenceThresholdMillis = thresholdMillis;
            return this;
        }

        public Builder setAutoSuggestionLowerBound(Instant autoSuggestionLowerBound) {
            autoSuggestionLowerBound.getClass();
            this.mAutoSuggestionLowerBound = autoSuggestionLowerBound;
            return this;
        }

        public Builder setManualSuggestionLowerBound(Instant manualSuggestionLowerBound) {
            manualSuggestionLowerBound.getClass();
            this.mManualSuggestionLowerBound = manualSuggestionLowerBound;
            return this;
        }

        public Builder setSuggestionUpperBound(Instant suggestionUpperBound) {
            suggestionUpperBound.getClass();
            this.mSuggestionUpperBound = suggestionUpperBound;
            return this;
        }

        public Builder setOriginPriorities(int... originPriorities) {
            originPriorities.getClass();
            this.mOriginPriorities = originPriorities;
            return this;
        }

        Builder setAutoDetectionEnabledSetting(boolean autoDetectionEnabledSetting) {
            this.mAutoDetectionEnabledSetting = autoDetectionEnabledSetting;
            return this;
        }

        ConfigurationInternal build() {
            return new ConfigurationInternal(this, null);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutoDetectionEnabledSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8529$$Nest$fgetmAutoDetectionEnabledSetting(ConfigurationInternal r0) {
        return r0.mAutoDetectionEnabledSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutoDetectionSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8530$$Nest$fgetmAutoDetectionSupported(ConfigurationInternal r0) {
        return r0.mAutoDetectionSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutoSuggestionLowerBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ Instant m8531$$Nest$fgetmAutoSuggestionLowerBound(ConfigurationInternal r0) {
        return r0.mAutoSuggestionLowerBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmManualSuggestionLowerBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ Instant m8532$$Nest$fgetmManualSuggestionLowerBound(ConfigurationInternal r0) {
        return r0.mManualSuggestionLowerBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOriginPriorities, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m8533$$Nest$fgetmOriginPriorities(ConfigurationInternal r0) {
        return r0.mOriginPriorities;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSuggestionUpperBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ Instant m8534$$Nest$fgetmSuggestionUpperBound(ConfigurationInternal r0) {
        return r0.mSuggestionUpperBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemClockUpdateThresholdMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8535$$Nest$fgetmSystemClockUpdateThresholdMillis(ConfigurationInternal r0) {
        return r0.mSystemClockUpdateThresholdMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserConfigAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8536$$Nest$fgetmUserConfigAllowed(ConfigurationInternal r0) {
        return r0.mUserConfigAllowed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8537$$Nest$fgetmUserId(ConfigurationInternal r0) {
        return r0.mUserId;
    }

    /* synthetic */ ConfigurationInternal(Builder r1, ConfigurationInternalIA r2) {
        this(r1);
    }

    private ConfigurationInternal(Builder builder) {
        this.mAutoDetectionSupported = Builder.m8539$$Nest$fgetmAutoDetectionSupported(builder);
        this.mSystemClockUpdateThresholdMillis = Builder.m8545$$Nest$fgetmSystemClockUpdateThresholdMillis(builder);
        this.mSystemClockConfidenceThresholdMillis = Builder.m8544$$Nest$fgetmSystemClockConfidenceThresholdMillis(builder);
        Instant r0 = Builder.m8540$$Nest$fgetmAutoSuggestionLowerBound(builder);
        r0.getClass();
        this.mAutoSuggestionLowerBound = r0;
        Instant r1 = Builder.m8541$$Nest$fgetmManualSuggestionLowerBound(builder);
        r1.getClass();
        this.mManualSuggestionLowerBound = r1;
        Instant r2 = Builder.m8543$$Nest$fgetmSuggestionUpperBound(builder);
        r2.getClass();
        this.mSuggestionUpperBound = r2;
        int[] r3 = Builder.m8542$$Nest$fgetmOriginPriorities(builder);
        r3.getClass();
        this.mOriginPriorities = r3;
        this.mAutoDetectionEnabledSetting = Builder.m8538$$Nest$fgetmAutoDetectionEnabledSetting(builder);
        this.mUserId = Builder.m8547$$Nest$fgetmUserId(builder);
        this.mUserConfigAllowed = Builder.m8546$$Nest$fgetmUserConfigAllowed(builder);
    }

    public boolean isAutoDetectionSupported() {
        return this.mAutoDetectionSupported;
    }

    public int getSystemClockUpdateThresholdMillis() {
        return this.mSystemClockUpdateThresholdMillis;
    }

    public int getSystemClockConfidenceThresholdMillis() {
        return this.mSystemClockConfidenceThresholdMillis;
    }

    public Instant getAutoSuggestionLowerBound() {
        return this.mAutoSuggestionLowerBound;
    }

    public Instant getManualSuggestionLowerBound() {
        return this.mManualSuggestionLowerBound;
    }

    public Instant getSuggestionUpperBound() {
        return this.mSuggestionUpperBound;
    }

    public int[] getAutoOriginPriorities() {
        return this.mOriginPriorities;
    }

    public boolean getAutoDetectionEnabledSetting() {
        return this.mAutoDetectionEnabledSetting;
    }

    public boolean getAutoDetectionEnabledBehavior() {
        if (isAutoDetectionSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAutoDetectionEnabledSetting == false) goto L7;
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

    public TimeCapabilitiesAndConfig createCapabilitiesAndConfig(boolean bypassUserPolicyChecks) {
        return new TimeCapabilitiesAndConfig(timeCapabilities(bypassUserPolicyChecks), timeConfiguration());
    }

    private TimeCapabilities timeCapabilities(boolean bypassUserPolicyChecks) {
        UserHandle userHandle = UserHandle.of(this.mUserId);
        TimeCapabilities.Builder builder = new TimeCapabilities.Builder(userHandle);
        if (isUserConfigAllowed() == true) goto L7;
        if (bypassUserPolicyChecks == true) goto L7;
        boolean allowConfigDateTime = false;
    L8:
        boolean deviceHasAutoTimeDetection = isAutoDetectionSupported();
        if (deviceHasAutoTimeDetection == true) goto L11;
        int configureAutoDetectionEnabledCapability = 10;
    L14:
        builder.setConfigureAutoDetectionEnabledCapability(configureAutoDetectionEnabledCapability);
        if (allowConfigDateTime == true) goto L18;
        int suggestManualTimeCapability = 20;
    L21:
        builder.setSetManualTimeCapability(suggestManualTimeCapability);
        return builder.build();
    L18:
        if (getAutoDetectionEnabledBehavior() == false) goto L20;
        suggestManualTimeCapability = 30;
        goto L21
    L20:
        suggestManualTimeCapability = 40;
        goto L21
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

    private TimeConfiguration timeConfiguration() {
        return new TimeConfiguration.Builder().setAutoDetectionEnabled(getAutoDetectionEnabledSetting()).build();
    }

    public ConfigurationInternal merge(TimeConfiguration newConfiguration) {
        Builder builder = new Builder(this);
        if (newConfiguration.hasIsAutoDetectionEnabled() == false) goto L6;
        builder.setAutoDetectionEnabledSetting(newConfiguration.isAutoDetectionEnabled());
    L6:
        return builder.build();
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof ConfigurationInternal) == true) goto L8;
        return false;
    L8:
        ConfigurationInternal that = (ConfigurationInternal) o;
        if (this.mAutoDetectionSupported != that.mAutoDetectionSupported) goto L30;
        if (this.mAutoDetectionEnabledSetting != that.mAutoDetectionEnabledSetting) goto L30;
        if (this.mUserId != that.mUserId) goto L30;
        if (this.mUserConfigAllowed != that.mUserConfigAllowed) goto L30;
        if (this.mSystemClockUpdateThresholdMillis != that.mSystemClockUpdateThresholdMillis) goto L30;
        if (this.mSystemClockConfidenceThresholdMillis != that.mSystemClockConfidenceThresholdMillis) goto L30;
        if (this.mAutoSuggestionLowerBound.equals(that.mAutoSuggestionLowerBound) == false) goto L30;
        if (this.mManualSuggestionLowerBound.equals(that.mManualSuggestionLowerBound) == false) goto L30;
        if (this.mSuggestionUpperBound.equals(that.mSuggestionUpperBound) == false) goto L30;
        if (Arrays.equals(this.mOriginPriorities, that.mOriginPriorities) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int result = Objects.hash(new Object[]{Boolean.valueOf(this.mAutoDetectionSupported), Boolean.valueOf(this.mAutoDetectionEnabledSetting), Integer.valueOf(this.mUserId), Boolean.valueOf(this.mUserConfigAllowed), Integer.valueOf(this.mSystemClockUpdateThresholdMillis), Integer.valueOf(this.mSystemClockConfidenceThresholdMillis), this.mAutoSuggestionLowerBound, this.mManualSuggestionLowerBound, this.mSuggestionUpperBound});
        return (result * 31) + Arrays.hashCode(this.mOriginPriorities);
    }

    public String toString() {
        String originPrioritiesString = (String) Arrays.stream(this.mOriginPriorities).mapToObj(new ConfigurationInternal$$ExternalSyntheticLambda0()).collect(Collectors.joining(",", "[", "]"));
        return "ConfigurationInternal{mAutoDetectionSupported=" + this.mAutoDetectionSupported + ", mSystemClockUpdateThresholdMillis=" + this.mSystemClockUpdateThresholdMillis + ", mSystemClockConfidenceThresholdMillis=" + this.mSystemClockConfidenceThresholdMillis + ", mAutoSuggestionLowerBound=" + this.mAutoSuggestionLowerBound + "(" + this.mAutoSuggestionLowerBound.toEpochMilli() + "), mManualSuggestionLowerBound=" + this.mManualSuggestionLowerBound + "(" + this.mManualSuggestionLowerBound.toEpochMilli() + "), mSuggestionUpperBound=" + this.mSuggestionUpperBound + "(" + this.mSuggestionUpperBound.toEpochMilli() + "), mOriginPriorities=" + originPrioritiesString + ", mAutoDetectionEnabled=" + this.mAutoDetectionEnabledSetting + ", mUserId=" + this.mUserId + ", mUserConfigAllowed=" + this.mUserConfigAllowed + '}';
    }
}
