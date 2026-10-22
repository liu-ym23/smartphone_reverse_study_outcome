package com.android.server.timezonedetector;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.time.TimeZoneCapabilities;
import android.app.time.TimeZoneConfiguration;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IUserRestrictionsListener;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import com.android.server.LocalServices;
import com.android.server.timedetector.ServerFlags;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConfigAccessorImpl implements ServiceConfigAccessor {
    private static final Set<String> CONFIGURATION_INTERNAL_SERVER_FLAGS_KEYS_TO_WATCH = null;
    private static final Duration DEFAULT_LTZP_EVENT_FILTER_AGE_THRESHOLD = null;
    private static final Duration DEFAULT_LTZP_INITIALIZATION_TIMEOUT = null;
    private static final Duration DEFAULT_LTZP_INITIALIZATION_TIMEOUT_FUZZ = null;
    private static final Duration DEFAULT_LTZP_UNCERTAINTY_DELAY = null;
    private static final Set<String> LOCATION_TIME_ZONE_MANAGER_SERVER_FLAGS_KEYS_TO_WATCH = null;
    private static final Object SLOCK = null;
    private static ServiceConfigAccessor sInstance;
    private final List<StateChangeListener> mConfigurationInternalListeners;
    private final Context mContext;
    private final ContentResolver mCr;
    private final LocationManager mLocationManager;
    private boolean mRecordStateChangesForTests;
    private final ServerFlags mServerFlags;
    private String mTestPrimaryLocationTimeZoneProviderMode;
    private String mTestPrimaryLocationTimeZoneProviderPackageName;
    private String mTestSecondaryLocationTimeZoneProviderMode;
    private String mTestSecondaryLocationTimeZoneProviderPackageName;
    private final UserManager mUserManager;

    /* JADX INFO: renamed from: com.android.server.timezonedetector.ServiceConfigAccessorImpl$3, reason: invalid class name */
    class AnonymousClass3 extends IUserRestrictionsListener.Stub {
        final /* synthetic */ ServiceConfigAccessorImpl this$0;
        final /* synthetic */ Handler val$mainThreadHandler;

        public static /* synthetic */ void $r8$lambda$NkZpuI_CAvdjY4tSj0Zm8pNT24M(AnonymousClass3 r0, int r1, Bundle r2, Bundle r3) {
            r0.lambda$onUserRestrictionsChanged$0(r1, r2, r3);
        }

        AnonymousClass3(ServiceConfigAccessorImpl this$0, Handler r2) {
            this.this$0 = this$0;
            this.val$mainThreadHandler = r2;
        }

        public void onUserRestrictionsChanged(final int userId, final Bundle newRestrictions, final Bundle prevRestrictions) {
            this.val$mainThreadHandler.post(new ServiceConfigAccessorImpl$3$$ExternalSyntheticLambda0(this, userId, newRestrictions, prevRestrictions));
        }

        private /* synthetic */ void lambda$onUserRestrictionsChanged$0(int userId, Bundle newRestrictions, Bundle prevRestrictions) {
            ServiceConfigAccessorImpl.m8596$$Nest$mhandleUserRestrictionsChangeOnMainThread(this.this$0, userId, newRestrictions, prevRestrictions);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0jigQL7VN-jAH6VbV4023YMMKLk, reason: not valid java name */
    public static /* synthetic */ void m8594$r8$lambda$0jigQL7VNjAH6VbV4023YMMKLk(ServiceConfigAccessorImpl r0) {
        r0.handleConfigurationInternalChangeOnMainThread();
    }

    public static /* synthetic */ void $r8$lambda$gxEwKFbg9t8OLCTnVCyPFXNrp6s(ServiceConfigAccessorImpl r0) {
        r0.handleConfigurationInternalChangeOnMainThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleConfigurationInternalChangeOnMainThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8595$$Nest$mhandleConfigurationInternalChangeOnMainThread(ServiceConfigAccessorImpl r0) {
        r0.handleConfigurationInternalChangeOnMainThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUserRestrictionsChangeOnMainThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8596$$Nest$mhandleUserRestrictionsChangeOnMainThread(ServiceConfigAccessorImpl r0, int r1, Bundle r2, Bundle r3) {
        r0.handleUserRestrictionsChangeOnMainThread(r1, r2, r3);
    }

    static {
        CONFIGURATION_INTERNAL_SERVER_FLAGS_KEYS_TO_WATCH = Set.of(new String[]{ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_FEATURE_SUPPORTED, ServerFlags.KEY_PRIMARY_LTZP_MODE_OVERRIDE, ServerFlags.KEY_SECONDARY_LTZP_MODE_OVERRIDE, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_RUN_IN_BACKGROUND_ENABLED, ServerFlags.KEY_ENHANCED_METRICS_COLLECTION_ENABLED, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_DEFAULT, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_OVERRIDE, ServerFlags.KEY_TIME_ZONE_DETECTOR_AUTO_DETECTION_ENABLED_DEFAULT, ServerFlags.KEY_TIME_ZONE_DETECTOR_TELEPHONY_FALLBACK_SUPPORTED, ServerFlags.KEY_TIME_ZONE_NOTIFICATIONS_SUPPORTED, ServerFlags.KEY_TIME_ZONE_NOTIFICATIONS_ENABLED_DEFAULT, ServerFlags.KEY_TIME_ZONE_NOTIFICATIONS_TRACKING_SUPPORTED, ServerFlags.KEY_TIME_ZONE_MANUAL_CHANGE_TRACKING_SUPPORTED});
        LOCATION_TIME_ZONE_MANAGER_SERVER_FLAGS_KEYS_TO_WATCH = Set.of(ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_FEATURE_SUPPORTED, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_RUN_IN_BACKGROUND_ENABLED, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_DEFAULT, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_OVERRIDE, ServerFlags.KEY_PRIMARY_LTZP_MODE_OVERRIDE, ServerFlags.KEY_SECONDARY_LTZP_MODE_OVERRIDE, ServerFlags.KEY_LTZP_INITIALIZATION_TIMEOUT_MILLIS, ServerFlags.KEY_LTZP_INITIALIZATION_TIMEOUT_FUZZ_MILLIS, ServerFlags.KEY_LTZP_EVENT_FILTERING_AGE_THRESHOLD_MILLIS, ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_UNCERTAINTY_DELAY_MILLIS);
        DEFAULT_LTZP_INITIALIZATION_TIMEOUT = Duration.ofMinutes(5);
        DEFAULT_LTZP_INITIALIZATION_TIMEOUT_FUZZ = Duration.ofMinutes(1);
        DEFAULT_LTZP_UNCERTAINTY_DELAY = Duration.ofMinutes(5);
        DEFAULT_LTZP_EVENT_FILTER_AGE_THRESHOLD = Duration.ofMinutes(1);
        SLOCK = new Object();
    }

    private ServiceConfigAccessorImpl(Context context) {
        this.mConfigurationInternalListeners = new ArrayList();
        context.getClass();
        this.mContext = context;
        this.mCr = context.getContentResolver();
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mLocationManager = (LocationManager) context.getSystemService(LocationManager.class);
        this.mServerFlags = ServerFlags.getInstance(this.mContext);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_SWITCHED");
        filter.addAction("android.location.MODE_CHANGED");
        this.mContext.registerReceiverForAllUsers(new AnonymousClass1(this), filter, null, null);
        final Handler mainThreadHandler = this.mContext.getMainThreadHandler();
        ContentResolver contentResolver = this.mContext.getContentResolver();
        ContentObserver contentObserver = new AnonymousClass2(this, mainThreadHandler);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("auto_time_zone"), true, contentObserver);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("auto_time_zone_explicit"), true, contentObserver);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("time_zone_notifications"), true, contentObserver);
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("location_time_zone_detection_enabled"), true, contentObserver, -1);
        this.mServerFlags.addListener(new ServiceConfigAccessorImpl$$ExternalSyntheticLambda0(this), CONFIGURATION_INTERNAL_SERVER_FLAGS_KEYS_TO_WATCH);
        this.mUserManager.addUserRestrictionsListener(new AnonymousClass3(this, mainThreadHandler));
    }

    public static ServiceConfigAccessor getInstance(Context context) {
        Object r0 = SLOCK;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new ServiceConfigAccessorImpl(context);     // Catch: Throwable -> L7
    L9:
        ServiceConfigAccessor r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    private void handleConfigurationInternalChangeOnMainThread() {
        monitor-enter(this);
        List<StateChangeListener> configurationInternalListeners = new ArrayList(this.mConfigurationInternalListeners);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        Iterator<StateChangeListener> r1 = configurationInternalListeners.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        StateChangeListener changeListener = r1.next();
        changeListener.onChange();
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleUserRestrictionsChangeOnMainThread(int userId, Bundle newRestrictions, Bundle prevRestrictions) {
        handleConfigurationInternalChangeOnMainThread();
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized void addConfigurationInternalChangeListener(StateChangeListener listener) {
        monitor-enter(this);
        List<StateChangeListener> r0 = this.mConfigurationInternalListeners;     // Catch: Throwable -> L6
        listener.getClass();     // Catch: Throwable -> L6
        r0.add(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized void removeConfigurationInternalChangeListener(StateChangeListener listener) {
        monitor-enter(this);
        List<StateChangeListener> r0 = this.mConfigurationInternalListeners;     // Catch: Throwable -> L6
        listener.getClass();     // Catch: Throwable -> L6
        r0.remove(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized ConfigurationInternal getCurrentUserConfigurationInternal() {
        monitor-enter(this);
        int currentUserId = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCurrentUserId();     // Catch: Throwable -> L6
        ConfigurationInternal r1 = getConfigurationInternal(currentUserId);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized boolean updateConfiguration(int userId, TimeZoneConfiguration requestedConfigurationUpdates, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
        requestedConfigurationUpdates.getClass();     // Catch: Throwable -> L12
        ConfigurationInternal configurationInternal = getConfigurationInternal(userId);     // Catch: Throwable -> L12
        TimeZoneCapabilities capabilities = configurationInternal.asCapabilities(bypassUserPolicyChecks);     // Catch: Throwable -> L12
        TimeZoneConfiguration oldConfiguration = configurationInternal.asConfiguration();     // Catch: Throwable -> L12
        TimeZoneConfiguration newConfiguration = capabilities.tryApplyConfigChanges(oldConfiguration, requestedConfigurationUpdates);     // Catch: Throwable -> L12
        if (newConfiguration != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        storeConfiguration(userId, requestedConfigurationUpdates, newConfiguration);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    private void storeConfiguration(int userId, TimeZoneConfiguration requestedConfigurationUpdates, TimeZoneConfiguration newConfiguration) {
        newConfiguration.getClass();
        if (isAutoDetectionFeatureSupported() == true) goto L5;
    L14:
        boolean autoDetectionEnabled = areNotificationsSupported();
        if (autoDetectionEnabled == true) goto L17;
        return;
    L17:
        if (requestedConfigurationUpdates.hasIsNotificationsEnabled() == false) goto L19;
        setNotificationsEnabledSetting(requestedConfigurationUpdates.areNotificationsEnabled());
    L19:
        setNotificationsEnabledIfRequired(newConfiguration.areNotificationsEnabled());
        return;
    L5:
        if (requestedConfigurationUpdates.hasIsAutoDetectionEnabled() == false) goto L7;
        Settings.Global.putInt(this.mCr, "auto_time_zone_explicit", 1);
    L7:
        boolean autoDetectionEnabled2 = newConfiguration.isAutoDetectionEnabled();
        setAutoDetectionEnabledIfRequired(autoDetectionEnabled2);
        if (getGeoDetectionSettingEnabledOverride().isEmpty() == false) goto L14;
        if (isGeoTimeZoneDetectionFeatureSupported() == false) goto L14;
        if (isTelephonyTimeZoneDetectionFeatureSupported() == false) goto L14;
        boolean geoDetectionEnabledSetting = newConfiguration.isGeoDetectionEnabled();
        setGeoDetectionEnabledSettingIfRequired(userId, geoDetectionEnabledSetting);
        goto L14
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized ConfigurationInternal getConfigurationInternal(int userId) {
        monitor-enter(this);
        ConfigurationInternal r0 = new ConfigurationInternal.Builder().setUserId(userId).setTelephonyDetectionFeatureSupported(isTelephonyTimeZoneDetectionFeatureSupported()).setGeoDetectionFeatureSupported(isGeoTimeZoneDetectionFeatureSupported()).setTelephonyFallbackSupported(isTelephonyFallbackSupported()).setGeoDetectionRunInBackgroundEnabled(getGeoDetectionRunInBackgroundEnabled()).setEnhancedMetricsCollectionEnabled(isEnhancedMetricsCollectionEnabled()).setAutoDetectionEnabledSetting(getAutoDetectionEnabledSetting()).setUserConfigAllowed(isUserConfigAllowed(userId)).setLocationEnabledSetting(getLocationEnabledSetting(userId)).setGeoDetectionEnabledSetting(getGeoDetectionEnabledSetting(userId)).setNotificationsSupported(areNotificationsSupported()).setNotificationsEnabledSetting(getNotificationsEnabledSetting()).setNotificationsTrackingSupported(isNotificationTrackingSupported()).setManualChangeTrackingSupported(isManualChangeTrackingSupported()).build();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void setAutoDetectionEnabledIfRequired(boolean r3) {
        if (getAutoDetectionEnabledSetting() == r3) goto L6;
        Settings.Global.putInt(this.mCr, "auto_time_zone", r3 ? 1 : 0);
        return;
    }

    private boolean getLocationEnabledSetting(int userId) {
        return this.mLocationManager.isLocationEnabledForUser(UserHandle.of(userId));
    }

    private boolean isUserConfigAllowed(int userId) {
        UserHandle userHandle = UserHandle.of(userId);
        return !this.mUserManager.hasUserRestriction("no_config_date_time", userHandle);
    }

    private boolean getAutoDetectionEnabledSetting() {
        boolean r2 = true;
        if (Settings.Global.getInt(this.mCr, "auto_time_zone", 1) > 0) goto L6;
        r2 = false;
    L6:
        Optional<Boolean> r0 = this.mServerFlags.getOptionalBoolean(ServerFlags.KEY_TIME_ZONE_DETECTOR_AUTO_DETECTION_ENABLED_DEFAULT);
        if (r0.isPresent() == true) goto L9;
        return r2;
    L9:
        if (Settings.Global.getInt(this.mCr, "auto_time_zone_explicit", 0) != 0) goto L16;
        boolean r3 = r0.get().booleanValue();
        if (r3 == r2) goto L14;
        Settings.Global.putInt(this.mCr, "auto_time_zone", r3 ? 1 : 0);
    L14:
        return r3;
    L16:
        return r2;
    }

    private boolean getGeoDetectionEnabledSetting(int r5) {
        Optional<Boolean> r0 = getGeoDetectionSettingEnabledOverride();
        if (r0.isPresent() == true) goto L5;
        boolean r1 = isGeoDetectionEnabledForUsersByDefault();
        if (Settings.Secure.getIntForUser(this.mCr, "location_time_zone_detection_enabled", r1 ? 1 : 0, r5) == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        return r0.get().booleanValue();
    }

    private void setGeoDetectionEnabledSettingIfRequired(int r3, boolean r4) {
        if (getGeoDetectionEnabledSetting(r3) == r4) goto L6;
        Settings.Secure.putIntForUser(this.mCr, "location_time_zone_detection_enabled", r4 ? 1 : 0, r3);
        return;
    }

    private boolean areNotificationsSupported() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_TIME_ZONE_NOTIFICATIONS_SUPPORTED, getConfigBoolean(R.bool.config_enableViewGroupScalingFading));
    }

    private boolean isNotificationTrackingSupported() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_TIME_ZONE_NOTIFICATIONS_TRACKING_SUPPORTED, getConfigBoolean(R.bool.config_enableVirtualDeviceManager));
    }

    private boolean isManualChangeTrackingSupported() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_TIME_ZONE_MANUAL_CHANGE_TRACKING_SUPPORTED, getConfigBoolean(R.bool.config_enableUserSwitcherUponUserCreation));
    }

    private boolean getNotificationsEnabledSetting() {
        boolean r0 = areNotificationsEnabledByDefault();
        if (Settings.Global.getInt(this.mCr, "time_zone_notifications", r0 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean areNotificationsEnabledByDefault() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_TIME_ZONE_NOTIFICATIONS_ENABLED_DEFAULT, true);
    }

    private void setNotificationsEnabledSetting(boolean r3) {
        Settings.Global.putInt(this.mCr, "time_zone_notifications", r3 ? 1 : 0);
    }

    private void setNotificationsEnabledIfRequired(boolean r3) {
        if (getNotificationsEnabledSetting() == r3) goto L6;
        Settings.Global.putInt(this.mCr, "time_zone_notifications", r3 ? 1 : 0);
        return;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public void addLocationTimeZoneManagerConfigListener(StateChangeListener listener) {
        this.mServerFlags.addListener(listener, LOCATION_TIME_ZONE_MANAGER_SERVER_FLAGS_KEYS_TO_WATCH);
    }

    private boolean isAutoDetectionFeatureSupported() {
        if (isTelephonyTimeZoneDetectionFeatureSupported() == false) goto L5;
    L8:
        return true;
    L5:
        if (isGeoTimeZoneDetectionFeatureSupported() == true) goto L8;
        return false;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public boolean isTelephonyTimeZoneDetectionFeatureSupported() {
        if (getConfigBoolean(R.bool.config_enableUdcSysfsUsbStateUpdate) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony") == false) goto L7;
        return true;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public boolean isGeoTimeZoneDetectionFeatureSupportedInConfig() {
        return getConfigBoolean(R.bool.config_enableIdleScreenBrightnessMode);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public boolean isGeoTimeZoneDetectionFeatureSupported() {
        if (isGeoTimeZoneDetectionFeatureSupportedInConfig() == true) goto L5;
    L9:
        return false;
    L5:
        if (isGeoTimeZoneDetectionFeatureSupportedInternal() == false) goto L9;
        if (atLeastOneProviderIsEnabled() == false) goto L9;
        return true;
    }

    private boolean atLeastOneProviderIsEnabled() {
        if (Objects.equals(getPrimaryLocationTimeZoneProviderMode(), ServiceConfigAccessor.PROVIDER_MODE_DISABLED) == true) goto L5;
    L8:
        return true;
    L5:
        if (Objects.equals(getSecondaryLocationTimeZoneProviderMode(), ServiceConfigAccessor.PROVIDER_MODE_DISABLED) == false) goto L8;
        return false;
    }

    private boolean isGeoTimeZoneDetectionFeatureSupportedInternal() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_FEATURE_SUPPORTED, true);
    }

    private boolean getGeoDetectionRunInBackgroundEnabled() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_RUN_IN_BACKGROUND_ENABLED, false);
    }

    private boolean isEnhancedMetricsCollectionEnabled() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_ENHANCED_METRICS_COLLECTION_ENABLED, false);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized String getPrimaryLocationTimeZoneProviderPackageName() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTestPrimaryLocationTimeZoneProviderMode == null) goto L10;
        String r0 = this.mTestPrimaryLocationTimeZoneProviderPackageName;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        String r1 = this.mContext.getResources().getString(R.string.config_wearMediaControlsPackage);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized void setTestPrimaryLocationTimeZoneProviderPackageName(String testPrimaryLocationTimeZoneProviderPackageName) {
        monitor-enter(this);
        this.mTestPrimaryLocationTimeZoneProviderPackageName = testPrimaryLocationTimeZoneProviderPackageName;     // Catch: Throwable -> L6
        if (this.mTestPrimaryLocationTimeZoneProviderPackageName != null) goto L8;
        String r0 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L9:
        this.mTestPrimaryLocationTimeZoneProviderMode = r0;     // Catch: Throwable -> L6
        this.mContext.getMainThreadHandler().post(new ServiceConfigAccessorImpl$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r0 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized boolean isTestPrimaryLocationTimeZoneProvider() {
        monitor-enter(this);
        if (this.mTestPrimaryLocationTimeZoneProviderMode == null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized String getSecondaryLocationTimeZoneProviderPackageName() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTestSecondaryLocationTimeZoneProviderMode == null) goto L10;
        String r0 = this.mTestSecondaryLocationTimeZoneProviderPackageName;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        String r1 = this.mContext.getResources().getString(R.string.contentServiceSyncNotificationTitle);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized void setTestSecondaryLocationTimeZoneProviderPackageName(String testSecondaryLocationTimeZoneProviderPackageName) {
        monitor-enter(this);
        this.mTestSecondaryLocationTimeZoneProviderPackageName = testSecondaryLocationTimeZoneProviderPackageName;     // Catch: Throwable -> L6
        if (this.mTestSecondaryLocationTimeZoneProviderPackageName != null) goto L8;
        String r0 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L9:
        this.mTestSecondaryLocationTimeZoneProviderMode = r0;     // Catch: Throwable -> L6
        this.mContext.getMainThreadHandler().post(new ServiceConfigAccessorImpl$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r0 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized boolean isTestSecondaryLocationTimeZoneProvider() {
        monitor-enter(this);
        if (this.mTestSecondaryLocationTimeZoneProviderMode == null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized void setRecordStateChangesForTests(boolean enabled) {
        monitor-enter(this);
        this.mRecordStateChangesForTests = enabled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized boolean getRecordStateChangesForTests() {
        monitor-enter(this);
        boolean r0 = this.mRecordStateChangesForTests;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized String getPrimaryLocationTimeZoneProviderMode() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTestPrimaryLocationTimeZoneProviderMode == null) goto L10;
        String r0 = this.mTestPrimaryLocationTimeZoneProviderMode;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        String r1 = this.mServerFlags.getOptionalString(ServerFlags.KEY_PRIMARY_LTZP_MODE_OVERRIDE).orElse(getPrimaryLocationTimeZoneProviderModeFromConfig());     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    }

    private synchronized String getPrimaryLocationTimeZoneProviderModeFromConfig() {
        monitor-enter(this);
        if (getConfigBoolean(R.bool.config_enableSecondaryLocationTimeZoneProvider) == false) goto L9;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L10:
        monitor-exit(this);
        return r1;
    L9:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized String getSecondaryLocationTimeZoneProviderMode() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTestSecondaryLocationTimeZoneProviderMode == null) goto L10;
        String r0 = this.mTestSecondaryLocationTimeZoneProviderMode;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        String r1 = this.mServerFlags.getOptionalString(ServerFlags.KEY_SECONDARY_LTZP_MODE_OVERRIDE).orElse(getSecondaryLocationTimeZoneProviderModeFromConfig());     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    }

    private synchronized String getSecondaryLocationTimeZoneProviderModeFromConfig() {
        monitor-enter(this);
        if (getConfigBoolean(R.bool.config_enableTimeZoneNotificationsSupported) == false) goto L9;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L10:
        monitor-exit(this);
        return r1;
    L9:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public boolean isGeoDetectionEnabledForUsersByDefault() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_DEFAULT, false);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public Optional<Boolean> getGeoDetectionSettingEnabledOverride() {
        return this.mServerFlags.getOptionalBoolean(ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_OVERRIDE);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public Duration getLocationTimeZoneProviderInitializationTimeout() {
        return this.mServerFlags.getDurationFromMillis(ServerFlags.KEY_LTZP_INITIALIZATION_TIMEOUT_MILLIS, DEFAULT_LTZP_INITIALIZATION_TIMEOUT);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public Duration getLocationTimeZoneProviderInitializationTimeoutFuzz() {
        return this.mServerFlags.getDurationFromMillis(ServerFlags.KEY_LTZP_INITIALIZATION_TIMEOUT_FUZZ_MILLIS, DEFAULT_LTZP_INITIALIZATION_TIMEOUT_FUZZ);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public Duration getLocationTimeZoneUncertaintyDelay() {
        return this.mServerFlags.getDurationFromMillis(ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_UNCERTAINTY_DELAY_MILLIS, DEFAULT_LTZP_UNCERTAINTY_DELAY);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public Duration getLocationTimeZoneProviderEventFilteringAgeThreshold() {
        return this.mServerFlags.getDurationFromMillis(ServerFlags.KEY_LTZP_EVENT_FILTERING_AGE_THRESHOLD_MILLIS, DEFAULT_LTZP_EVENT_FILTER_AGE_THRESHOLD);
    }

    @Override // com.android.server.timezonedetector.ServiceConfigAccessor
    public synchronized void resetVolatileTestConfig() {
        monitor-enter(this);
        this.mTestPrimaryLocationTimeZoneProviderPackageName = null;     // Catch: Throwable -> L7
        this.mTestPrimaryLocationTimeZoneProviderMode = null;     // Catch: Throwable -> L7
        this.mTestSecondaryLocationTimeZoneProviderPackageName = null;     // Catch: Throwable -> L7
        this.mTestSecondaryLocationTimeZoneProviderMode = null;     // Catch: Throwable -> L7
        this.mRecordStateChangesForTests = false;     // Catch: Throwable -> L7
        this.mContext.getMainThreadHandler().post(new ServiceConfigAccessorImpl$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isTelephonyFallbackSupported() {
        return this.mServerFlags.getBoolean(ServerFlags.KEY_TIME_ZONE_DETECTOR_TELEPHONY_FALLBACK_SUPPORTED, getConfigBoolean(R.bool.config_supportsRoundedCornersOnWindows));
    }

    private boolean getConfigBoolean(int providerEnabledConfigId) {
        Resources resources = this.mContext.getResources();
        return resources.getBoolean(providerEnabledConfigId);
    }
}
