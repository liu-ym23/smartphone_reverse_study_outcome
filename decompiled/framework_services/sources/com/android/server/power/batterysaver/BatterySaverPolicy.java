package com.android.server.power.batterysaver;

import android.R;
import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.BatterySaverPolicyConfig;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerSaveState;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ConcurrentUtils;
import com.android.server.utils.UserSettingDeviceConfigMediator;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class BatterySaverPolicy extends ContentObserver implements DeviceConfig.OnPropertiesChangedListener {
    static final boolean DEBUG = true;
    private static final Policy DEFAULT_ADAPTIVE_POLICY = null;
    static final String KEY_ADJUST_BRIGHTNESS_FACTOR = "adjust_brightness_factor";
    static final String KEY_ADVERTISE_IS_ENABLED = "advertise_is_enabled";

    @Deprecated
    private static final String KEY_CPU_FREQ_INTERACTIVE = "cpufreq-i";

    @Deprecated
    private static final String KEY_CPU_FREQ_NONINTERACTIVE = "cpufreq-n";
    static final String KEY_DEFER_FULL_BACKUP = "defer_full_backup";
    static final String KEY_DEFER_KEYVALUE_BACKUP = "defer_keyvalue_backup";
    static final String KEY_DISABLE_ANIMATION = "disable_animation";
    static final String KEY_DISABLE_AOD = "disable_aod";
    static final String KEY_DISABLE_LAUNCH_BOOST = "disable_launch_boost";
    static final String KEY_DISABLE_OPTIONAL_SENSORS = "disable_optional_sensors";
    static final String KEY_DISABLE_VIBRATION = "disable_vibration";
    static final String KEY_ENABLE_BRIGHTNESS_ADJUSTMENT = "enable_brightness_adjustment";
    static final String KEY_ENABLE_DATASAVER = "enable_datasaver";
    static final String KEY_ENABLE_FIREWALL = "enable_firewall";
    static final String KEY_ENABLE_NIGHT_MODE = "enable_night_mode";
    static final String KEY_ENABLE_QUICK_DOZE = "enable_quick_doze";
    static final String KEY_FORCE_ALL_APPS_STANDBY = "force_all_apps_standby";
    static final String KEY_FORCE_BACKGROUND_CHECK = "force_background_check";
    static final String KEY_LOCATION_MODE = "location_mode";
    static final String KEY_SOUNDTRIGGER_MODE = "soundtrigger_mode";
    private static final String KEY_SUFFIX_ADAPTIVE = "_adaptive";
    static final Policy OFF_POLICY = null;
    static final int POLICY_LEVEL_ADAPTIVE = 1;
    static final int POLICY_LEVEL_FULL = 2;
    static final int POLICY_LEVEL_OFF = 0;
    private static final String TAG = "BatterySaverPolicy";
    private final Policy DEFAULT_FULL_POLICY;
    final PolicyBoolean mAccessibilityEnabled;
    private Policy mAdaptivePolicy;
    final PolicyBoolean mAutomotiveProjectionActive;
    private final BatterySavingStats mBatterySavingStats;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private Policy mDefaultAdaptivePolicy;
    private Policy mDefaultFullPolicy;
    private String mDeviceSpecificSettings;
    private String mDeviceSpecificSettingsSource;
    private Policy mEffectivePolicyRaw;
    private String mEventLogKeys;
    private Policy mFullPolicy;
    private final Handler mHandler;
    private DeviceConfig.Properties mLastDeviceConfigProperties;
    private final List<BatterySaverPolicyListener> mListeners;
    private final Object mLock;
    private final UiModeManager.OnProjectionStateChangedListener mOnProjectionStateChangedListener;
    private int mPolicyLevel;
    private String mSettings;

    public interface BatterySaverPolicyListener {
        void onBatterySaverPolicyChanged(BatterySaverPolicy r1);
    }

    static class Policy {
        public final float adjustBrightnessFactor;
        public final boolean advertiseIsEnabled;
        public final boolean deferFullBackup;
        public final boolean deferKeyValueBackup;
        public final boolean disableAnimation;
        public final boolean disableAod;
        public final boolean disableLaunchBoost;
        public final boolean disableOptionalSensors;
        public final boolean disableVibration;
        public final boolean enableAdjustBrightness;
        public final boolean enableDataSaver;
        public final boolean enableFirewall;
        public final boolean enableNightMode;
        public final boolean enableQuickDoze;
        public final boolean forceAllAppsStandby;
        public final boolean forceBackgroundCheck;
        public final int locationMode;
        private final int mHashCode;
        public final int soundTriggerMode;

        /* JADX INFO: renamed from: -$$Nest$smfromSettings, reason: not valid java name */
        static /* bridge */ /* synthetic */ Policy m7633$$Nest$smfromSettings(String r0, String r1, DeviceConfig.Properties r2, String r3, Policy r4) {
            return fromSettings(r0, r1, r2, r3, r4);
        }

        Policy(float adjustBrightnessFactor, boolean advertiseIsEnabled, boolean deferFullBackup, boolean deferKeyValueBackup, boolean disableAnimation, boolean disableAod, boolean disableLaunchBoost, boolean disableOptionalSensors, boolean disableVibration, boolean enableAdjustBrightness, boolean enableDataSaver, boolean enableFirewall, boolean enableNightMode, boolean enableQuickDoze, boolean forceAllAppsStandby, boolean forceBackgroundCheck, int locationMode, int soundTriggerMode) {
            this.adjustBrightnessFactor = Math.min(1.0f, Math.max(0.0f, adjustBrightnessFactor));
            this.advertiseIsEnabled = advertiseIsEnabled;
            this.deferFullBackup = deferFullBackup;
            this.deferKeyValueBackup = deferKeyValueBackup;
            this.disableAnimation = disableAnimation;
            this.disableAod = disableAod;
            this.disableLaunchBoost = disableLaunchBoost;
            this.disableOptionalSensors = disableOptionalSensors;
            this.disableVibration = disableVibration;
            this.enableAdjustBrightness = enableAdjustBrightness;
            this.enableDataSaver = enableDataSaver;
            this.enableFirewall = enableFirewall;
            this.enableNightMode = enableNightMode;
            this.enableQuickDoze = enableQuickDoze;
            this.forceAllAppsStandby = forceAllAppsStandby;
            this.forceBackgroundCheck = forceBackgroundCheck;
            if (locationMode >= 0) goto L5;
        L8:
            Slog.e(BatterySaverPolicy.TAG, "Invalid location mode: " + locationMode);
            this.locationMode = 0;
        L9:
            if (soundTriggerMode >= 0) goto L11;
        L14:
            Slog.e(BatterySaverPolicy.TAG, "Invalid SoundTrigger mode: " + soundTriggerMode);
            this.soundTriggerMode = 0;
        L15:
            this.mHashCode = Objects.hash(new Object[]{Float.valueOf(adjustBrightnessFactor), Boolean.valueOf(advertiseIsEnabled), Boolean.valueOf(deferFullBackup), Boolean.valueOf(deferKeyValueBackup), Boolean.valueOf(disableAnimation), Boolean.valueOf(disableAod), Boolean.valueOf(disableLaunchBoost), Boolean.valueOf(disableOptionalSensors), Boolean.valueOf(disableVibration), Boolean.valueOf(enableAdjustBrightness), Boolean.valueOf(enableDataSaver), Boolean.valueOf(enableFirewall), Boolean.valueOf(enableNightMode), Boolean.valueOf(enableQuickDoze), Boolean.valueOf(forceAllAppsStandby), Boolean.valueOf(forceBackgroundCheck), Integer.valueOf(locationMode), Integer.valueOf(soundTriggerMode)});
            return;
        L11:
            if (soundTriggerMode > 2) goto L14;
            this.soundTriggerMode = soundTriggerMode;
            goto L15
        L5:
            if (4 < locationMode) goto L8;
            this.locationMode = locationMode;
            goto L9
        }

        static Policy fromConfig(BatterySaverPolicyConfig config) {
            if (config != null) goto L5;
            Slog.e(BatterySaverPolicy.TAG, "Null config passed down to BatterySaverPolicy");
            return BatterySaverPolicy.OFF_POLICY;
        L5:
            config.getDeviceSpecificSettings();
            return new Policy(config.getAdjustBrightnessFactor(), config.getAdvertiseIsEnabled(), config.getDeferFullBackup(), config.getDeferKeyValueBackup(), config.getDisableAnimation(), config.getDisableAod(), config.getDisableLaunchBoost(), config.getDisableOptionalSensors(), config.getDisableVibration(), config.getEnableAdjustBrightness(), config.getEnableDataSaver(), config.getEnableFirewall(), config.getEnableNightMode(), config.getEnableQuickDoze(), config.getForceAllAppsStandby(), config.getForceBackgroundCheck(), config.getLocationMode(), config.getSoundTriggerMode());
        }

        BatterySaverPolicyConfig toConfig() {
            return new BatterySaverPolicyConfig.Builder().setAdjustBrightnessFactor(this.adjustBrightnessFactor).setAdvertiseIsEnabled(this.advertiseIsEnabled).setDeferFullBackup(this.deferFullBackup).setDeferKeyValueBackup(this.deferKeyValueBackup).setDisableAnimation(this.disableAnimation).setDisableAod(this.disableAod).setDisableLaunchBoost(this.disableLaunchBoost).setDisableOptionalSensors(this.disableOptionalSensors).setDisableVibration(this.disableVibration).setEnableAdjustBrightness(this.enableAdjustBrightness).setEnableDataSaver(this.enableDataSaver).setEnableFirewall(this.enableFirewall).setEnableNightMode(this.enableNightMode).setEnableQuickDoze(this.enableQuickDoze).setForceAllAppsStandby(this.forceAllAppsStandby).setForceBackgroundCheck(this.forceBackgroundCheck).setLocationMode(this.locationMode).setSoundTriggerMode(this.soundTriggerMode).build();
        }

        static Policy fromSettings(String settings, String deviceSpecificSettings, DeviceConfig.Properties properties, String configSuffix) {
            return fromSettings(settings, deviceSpecificSettings, properties, configSuffix, BatterySaverPolicy.OFF_POLICY);
        }

        private static Policy fromSettings(String settings, String deviceSpecificSettings, DeviceConfig.Properties properties, String configSuffix, Policy defaultPolicy) {
            UserSettingDeviceConfigMediator userSettingDeviceConfigMediator = new UserSettingDeviceConfigMediator.SettingsOverridesIndividualMediator(',');
            String configSuffix2 = TextUtils.emptyIfNull(configSuffix);
            userSettingDeviceConfigMediator.setSettingsString(deviceSpecificSettings);     // Catch: IllegalArgumentException -> L5
        L20:
            userSettingDeviceConfigMediator.setSettingsString(settings);     // Catch: IllegalArgumentException -> L13
            userSettingDeviceConfigMediator.setDeviceConfigProperties(properties);     // Catch: IllegalArgumentException -> L11
        L16:
            float adjustBrightnessFactor = userSettingDeviceConfigMediator.getFloat(BatterySaverPolicy.KEY_ADJUST_BRIGHTNESS_FACTOR + configSuffix2, defaultPolicy.adjustBrightnessFactor);
            boolean advertiseIsEnabled = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_ADVERTISE_IS_ENABLED + configSuffix2, defaultPolicy.advertiseIsEnabled);
            boolean deferFullBackup = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DEFER_FULL_BACKUP + configSuffix2, defaultPolicy.deferFullBackup);
            boolean deferKeyValueBackup = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DEFER_KEYVALUE_BACKUP + configSuffix2, defaultPolicy.deferKeyValueBackup);
            boolean disableAnimation = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DISABLE_ANIMATION + configSuffix2, defaultPolicy.disableAnimation);
            boolean disableAod = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DISABLE_AOD + configSuffix2, defaultPolicy.disableAod);
            boolean disableLaunchBoost = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DISABLE_LAUNCH_BOOST + configSuffix2, defaultPolicy.disableLaunchBoost);
            boolean disableOptionalSensors = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DISABLE_OPTIONAL_SENSORS + configSuffix2, defaultPolicy.disableOptionalSensors);
            boolean disableVibrationConfig = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_DISABLE_VIBRATION + configSuffix2, defaultPolicy.disableVibration);
            boolean enableBrightnessAdjustment = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_ENABLE_BRIGHTNESS_ADJUSTMENT + configSuffix2, defaultPolicy.enableAdjustBrightness);
            boolean enableDataSaver = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_ENABLE_DATASAVER + configSuffix2, defaultPolicy.enableDataSaver);
            boolean enableFirewall = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_ENABLE_FIREWALL + configSuffix2, defaultPolicy.enableFirewall);
            boolean enableNightMode = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_ENABLE_NIGHT_MODE + configSuffix2, defaultPolicy.enableNightMode);
            boolean enableQuickDoze = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_ENABLE_QUICK_DOZE + configSuffix2, defaultPolicy.enableQuickDoze);
            boolean forceAllAppsStandby = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_FORCE_ALL_APPS_STANDBY + configSuffix2, defaultPolicy.forceAllAppsStandby);
            boolean forceBackgroundCheck = userSettingDeviceConfigMediator.getBoolean(BatterySaverPolicy.KEY_FORCE_BACKGROUND_CHECK + configSuffix2, defaultPolicy.forceBackgroundCheck);
            int locationMode = userSettingDeviceConfigMediator.getInt(BatterySaverPolicy.KEY_LOCATION_MODE + configSuffix2, defaultPolicy.locationMode);
            int soundTriggerMode = userSettingDeviceConfigMediator.getInt(BatterySaverPolicy.KEY_SOUNDTRIGGER_MODE + configSuffix2, defaultPolicy.soundTriggerMode);
            return new Policy(adjustBrightnessFactor, advertiseIsEnabled, deferFullBackup, deferKeyValueBackup, disableAnimation, disableAod, disableLaunchBoost, disableOptionalSensors, disableVibrationConfig, enableBrightnessAdjustment, enableDataSaver, enableFirewall, enableNightMode, enableQuickDoze, forceAllAppsStandby, forceBackgroundCheck, locationMode, soundTriggerMode);
        L15:
            Slog.wtf(BatterySaverPolicy.TAG, "Bad battery saver constants: " + settings);
        L6:
            Slog.wtf(BatterySaverPolicy.TAG, "Bad device specific battery saver constants: " + deviceSpecificSettings);
            goto L20
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if ((obj instanceof Policy) == true) goto L8;
            return false;
        L8:
            Policy other = (Policy) obj;
            if (Float.compare(other.adjustBrightnessFactor, this.adjustBrightnessFactor) != 0) goto L46;
            if (this.advertiseIsEnabled != other.advertiseIsEnabled) goto L46;
            if (this.deferFullBackup != other.deferFullBackup) goto L46;
            if (this.deferKeyValueBackup != other.deferKeyValueBackup) goto L46;
            if (this.disableAnimation != other.disableAnimation) goto L46;
            if (this.disableAod != other.disableAod) goto L46;
            if (this.disableLaunchBoost != other.disableLaunchBoost) goto L46;
            if (this.disableOptionalSensors != other.disableOptionalSensors) goto L46;
            if (this.disableVibration != other.disableVibration) goto L46;
            if (this.enableAdjustBrightness != other.enableAdjustBrightness) goto L46;
            if (this.enableDataSaver != other.enableDataSaver) goto L46;
            if (this.enableFirewall != other.enableFirewall) goto L46;
            if (this.enableNightMode != other.enableNightMode) goto L46;
            if (this.enableQuickDoze != other.enableQuickDoze) goto L46;
            if (this.forceAllAppsStandby != other.forceAllAppsStandby) goto L46;
            if (this.forceBackgroundCheck != other.forceBackgroundCheck) goto L46;
            if (this.locationMode != other.locationMode) goto L46;
            if (this.soundTriggerMode != other.soundTriggerMode) goto L46;
            return true;
        L46:
            return false;
        }

        public int hashCode() {
            return this.mHashCode;
        }
    }

    class PolicyBoolean {
        private final String mDebugName;
        private boolean mValue;
        final /* synthetic */ BatterySaverPolicy this$0;

        /* JADX INFO: renamed from: -$$Nest$mget, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7634$$Nest$mget(PolicyBoolean r0) {
            return r0.get();
        }

        /* JADX INFO: renamed from: -$$Nest$minitialize, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7635$$Nest$minitialize(PolicyBoolean r0, boolean r1) {
            r0.initialize(r1);
        }

        /* synthetic */ PolicyBoolean(BatterySaverPolicy r1, String r2, BatterySaverPolicyIA r3) {
            this(r1, r2);
        }

        private PolicyBoolean(BatterySaverPolicy this$0, String debugName) {
            this.this$0 = this$0;
            this.mDebugName = debugName;
        }

        private void initialize(boolean initialValue) {
            Object r0 = BatterySaverPolicy.m7630$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mValue = initialValue;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean get() {
            Object r0 = BatterySaverPolicy.m7630$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.mValue;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        void update(boolean newValue) {
            Object r0 = BatterySaverPolicy.m7630$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mValue == newValue) goto L9;
            Slog.d(BatterySaverPolicy.TAG, this.mDebugName + " changed to " + newValue + ", updating policy.");     // Catch: Throwable -> L7
            this.mValue = newValue;     // Catch: Throwable -> L7
            BatterySaverPolicy.m7632$$Nest$mupdatePolicyDependenciesLocked(this.this$0);     // Catch: Throwable -> L7
            BatterySaverPolicy.m7631$$Nest$mmaybeNotifyListenersOfPolicyChange(this.this$0);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PolicyLevel {
    }

    /* JADX INFO: renamed from: $r8$lambda$4jLBAhmrTxUtw0x-gqvwA_NGVEM, reason: not valid java name */
    public static /* synthetic */ void m7627$r8$lambda$4jLBAhmrTxUtw0xgqvwA_NGVEM(BatterySaverPolicy r0, int r1, Set r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$YPGGCCVYoOO-xKGa7QuR_WqxISo, reason: not valid java name */
    public static /* synthetic */ void m7628$r8$lambda$YPGGCCVYoOOxKGa7QuR_WqxISo(BatterySaverPolicy r0, boolean r1) {
        r0.lambda$systemReady$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vWjfwfC2lD8VHCNkNEpRdaZ6-o4, reason: not valid java name */
    public static /* synthetic */ void m7629$r8$lambda$vWjfwfC2lD8VHCNkNEpRdaZ6o4(BatterySaverPolicy r0, BatterySaverPolicyListener[] r1) {
        r0.lambda$maybeNotifyListenersOfPolicyChange$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7630$$Nest$fgetmLock(BatterySaverPolicy r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeNotifyListenersOfPolicyChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7631$$Nest$mmaybeNotifyListenersOfPolicyChange(BatterySaverPolicy r0) {
        r0.maybeNotifyListenersOfPolicyChange();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePolicyDependenciesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7632$$Nest$mupdatePolicyDependenciesLocked(BatterySaverPolicy r0) {
        r0.updatePolicyDependenciesLocked();
    }

    static {
        OFF_POLICY = new Policy(1.0f, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0);
        DEFAULT_ADAPTIVE_POLICY = OFF_POLICY;
    }

    private /* synthetic */ void lambda$new$0(int t, Set pkgs) {
        this.mAutomotiveProjectionActive.update(!pkgs.isEmpty());
    }

    public BatterySaverPolicy(Object lock, Context context, BatterySavingStats batterySavingStats) {
        super(BackgroundThread.getHandler());
        BatterySaverPolicyIA r3 = null;
        this.mAccessibilityEnabled = new PolicyBoolean(this, "accessibility", r3);
        this.mAutomotiveProjectionActive = new PolicyBoolean(this, "automotiveProjection", r3);
        this.mDefaultAdaptivePolicy = DEFAULT_ADAPTIVE_POLICY;
        this.mAdaptivePolicy = DEFAULT_ADAPTIVE_POLICY;
        this.mEffectivePolicyRaw = OFF_POLICY;
        this.mPolicyLevel = 0;
        this.mOnProjectionStateChangedListener = new BatterySaverPolicy$$ExternalSyntheticLambda1(this);
        this.mListeners = new ArrayList();
        this.mLock = lock;
        this.mHandler = BackgroundThread.getHandler();
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        this.mBatterySavingStats = batterySavingStats;
        Resources res = context.getResources();
        this.DEFAULT_FULL_POLICY = new Policy(res.getFloat(R.dimen.datepicker_selected_date_month_size), true, res.getBoolean(R.bool.config_batterySaver_full_disableAod), res.getBoolean(R.bool.config_batterySaver_full_disableLaunchBoost), res.getBoolean(R.bool.config_batterySaver_full_disableOptionalSensors), res.getBoolean(R.bool.config_batterySaver_full_disableVibration), res.getBoolean(R.bool.config_batterySaver_full_enableAdjustBrightness), res.getBoolean(R.bool.config_batterySaver_full_enableDataSaver), res.getBoolean(R.bool.config_batterySaver_full_enableFirewall), res.getBoolean(R.bool.config_batterySaver_full_enableNightMode), res.getBoolean(R.bool.config_batterySaver_full_enableQuickDoze), res.getBoolean(R.bool.config_batterySaver_full_forceAllAppsStandby), false, res.getBoolean(R.bool.config_batterySdCardAccessibility), res.getBoolean(R.bool.config_batteryStatsResetOnUnplugAfterSignificantCharge), res.getBoolean(R.bool.config_batteryStatsResetOnUnplugHighBatteryLevel), res.getInteger(R.integer.config_bluetooth_operating_voltage_mv), res.getInteger(R.integer.config_bluetooth_rx_cur_ma));
        this.mDefaultFullPolicy = this.DEFAULT_FULL_POLICY;
        this.mFullPolicy = this.DEFAULT_FULL_POLICY;
    }

    public void systemReady() {
        ConcurrentUtils.wtfIfLockHeld(TAG, this.mLock);
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("battery_saver_constants"), false, this);
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("battery_saver_device_specific_constants"), false, this);
        AccessibilityManager acm = (AccessibilityManager) this.mContext.getSystemService(AccessibilityManager.class);
        acm.addAccessibilityStateChangeListener(new BatterySaverPolicy$$ExternalSyntheticLambda2(this));
        PolicyBoolean.m7635$$Nest$minitialize(this.mAccessibilityEnabled, acm.isEnabled());
        UiModeManager uiModeManager = (UiModeManager) this.mContext.getSystemService(UiModeManager.class);
        uiModeManager.addOnProjectionStateChangedListener(1, this.mContext.getMainExecutor(), this.mOnProjectionStateChangedListener);
        PolicyBoolean r3 = this.mAutomotiveProjectionActive;
        if (uiModeManager.getActiveProjectionTypes() == 0) goto L5;
        boolean r4 = true;
    L6:
        PolicyBoolean.m7635$$Nest$minitialize(r3, r4);
        DeviceConfig.addOnPropertiesChangedListener("battery_saver", this.mContext.getMainExecutor(), this);
        this.mLastDeviceConfigProperties = DeviceConfig.getProperties("battery_saver", new String[0]);
        onChange(true, null);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private /* synthetic */ void lambda$systemReady$1(boolean enabled) {
        this.mAccessibilityEnabled.update(enabled);
    }

    public void addListener(BatterySaverPolicyListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    String getGlobalSetting(String key) {
        return Settings.Global.getString(this.mContentResolver, key);
    }

    int getDeviceSpecificConfigResId() {
        return R.string.config_defaultDisplayCompatHostActivity;
    }

    void invalidatePowerSaveModeCaches() {
        PowerManager.invalidatePowerSaveModeCaches();
    }

    private void maybeNotifyListenersOfPolicyChange() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPolicyLevel != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final BatterySaverPolicyListener[] listeners = (BatterySaverPolicyListener[]) this.mListeners.toArray(new BatterySaverPolicyListener[this.mListeners.size()]);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mHandler.post(new BatterySaverPolicy$$ExternalSyntheticLambda0(this, listeners));
    }

    private /* synthetic */ void lambda$maybeNotifyListenersOfPolicyChange$2(BatterySaverPolicyListener[] listeners) {
        int r0 = listeners.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        BatterySaverPolicyListener listener = listeners[r1];
        listener.onBatterySaverPolicyChanged(this);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        refreshSettings();
    }

    public void onPropertiesChanged(DeviceConfig.Properties properties) {
        boolean r1 = false;
        this.mLastDeviceConfigProperties = DeviceConfig.getProperties("battery_saver", new String[0]);
        Policy newAdaptivePolicy = null;
        Policy newFullPolicy = null;
        boolean changed = false;
        Object r4 = this.mLock;
        monitor-enter(r4);
        Iterator r5 = properties.getKeyset().iterator();     // Catch: Throwable -> L14
    L6:
        if (r5.hasNext() == false) goto L19;
        String name = (String) r5.next();     // Catch: Throwable -> L14
        if (name == null) goto L6;
        if (name.endsWith(KEY_SUFFIX_ADAPTIVE) == false) goto L16;
        if (newAdaptivePolicy != null) goto L6;
        newAdaptivePolicy = Policy.m7633$$Nest$smfromSettings("", "", this.mLastDeviceConfigProperties, KEY_SUFFIX_ADAPTIVE, DEFAULT_ADAPTIVE_POLICY);     // Catch: Throwable -> L14
        goto L6
    L16:
        if (newFullPolicy != null) goto L6;
        newFullPolicy = Policy.m7633$$Nest$smfromSettings(this.mSettings, this.mDeviceSpecificSettings, this.mLastDeviceConfigProperties, null, this.DEFAULT_FULL_POLICY);     // Catch: Throwable -> L14
        goto L6
    L19:
        if (newFullPolicy == null) goto L21;
        changed = false | maybeUpdateDefaultFullPolicy(newFullPolicy);     // Catch: Throwable -> L14
    L21:
        if (newAdaptivePolicy != null) goto L23;
    L28:
        updatePolicyDependenciesLocked();     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        if (changed == false) goto L43;
        maybeNotifyListenersOfPolicyChange();
        return;
    L43:
        return;
    L23:
        if (this.mAdaptivePolicy.equals(newAdaptivePolicy) == true) goto L28;
        this.mDefaultAdaptivePolicy = newAdaptivePolicy;     // Catch: Throwable -> L14
        this.mAdaptivePolicy = this.mDefaultAdaptivePolicy;     // Catch: Throwable -> L14
        if (this.mPolicyLevel != 1) goto L27;
        r1 = true;
    L27:
        changed = r1 | changed;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private void refreshSettings() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String setting = getGlobalSetting("battery_saver_constants");     // Catch: Throwable -> L9
        String deviceSpecificSetting = getGlobalSetting("battery_saver_device_specific_constants");     // Catch: Throwable -> L9
        this.mDeviceSpecificSettingsSource = "battery_saver_device_specific_constants";     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(deviceSpecificSetting) == true) goto L11;
        if ("null".equals(deviceSpecificSetting) == true) goto L11;
    L13:
        if (updateConstantsLocked(setting, deviceSpecificSetting) == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        maybeNotifyListenersOfPolicyChange();
        return;
    L11:
        deviceSpecificSetting = this.mContext.getString(getDeviceSpecificConfigResId());     // Catch: Throwable -> L9
        this.mDeviceSpecificSettingsSource = "(overlay)";     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    boolean updateConstantsLocked(String setting, String deviceSpecificSetting) {
        String setting2 = TextUtils.emptyIfNull(setting);
        String deviceSpecificSetting2 = TextUtils.emptyIfNull(deviceSpecificSetting);
        if (setting2.equals(this.mSettings) == true) goto L5;
    L8:
        this.mSettings = setting2;
        this.mDeviceSpecificSettings = deviceSpecificSetting2;
        Slog.i(TAG, "mSettings=" + this.mSettings);
        Slog.i(TAG, "mDeviceSpecificSettings=" + this.mDeviceSpecificSettings);
        boolean changed = maybeUpdateDefaultFullPolicy(Policy.m7633$$Nest$smfromSettings(setting2, deviceSpecificSetting2, this.mLastDeviceConfigProperties, null, this.DEFAULT_FULL_POLICY));
        this.mDefaultAdaptivePolicy = Policy.m7633$$Nest$smfromSettings("", "", this.mLastDeviceConfigProperties, KEY_SUFFIX_ADAPTIVE, DEFAULT_ADAPTIVE_POLICY);
        if (this.mPolicyLevel == 1) goto L11;
    L13:
        this.mAdaptivePolicy = this.mDefaultAdaptivePolicy;
        updatePolicyDependenciesLocked();
        return changed;
    L11:
        if (this.mAdaptivePolicy.equals(this.mDefaultAdaptivePolicy) == true) goto L13;
        changed = true;
        goto L13
    L5:
        if (deviceSpecificSetting2.equals(this.mDeviceSpecificSettings) == false) goto L8;
        return false;
    }

    private void updatePolicyDependenciesLocked() {
        Policy rawPolicy = getCurrentRawPolicyLocked();
        invalidatePowerSaveModeCaches();
        if (PolicyBoolean.m7634$$Nest$mget(this.mAutomotiveProjectionActive) == true) goto L5;
    L9:
        int locationMode = rawPolicy.locationMode;
        int locationMode2 = locationMode;
    L10:
        float r4 = rawPolicy.adjustBrightnessFactor;
        boolean r5 = rawPolicy.advertiseIsEnabled;
        boolean r6 = rawPolicy.deferFullBackup;
        boolean r7 = rawPolicy.deferKeyValueBackup;
        boolean r8 = rawPolicy.disableAnimation;
        boolean r9 = rawPolicy.disableAod;
        boolean r10 = rawPolicy.disableLaunchBoost;
        boolean r11 = rawPolicy.disableOptionalSensors;
        boolean r12 = false;
        if (rawPolicy.disableVibration == false) goto L16;
        if (PolicyBoolean.m7634$$Nest$mget(this.mAccessibilityEnabled) == true) goto L16;
        r12 = true;
    L16:
        boolean r13 = rawPolicy.enableAdjustBrightness;
        boolean r14 = rawPolicy.enableDataSaver;
        boolean r16 = true;
        boolean r15 = rawPolicy.enableFirewall;
        if (rawPolicy.enableNightMode == true) goto L19;
    L21:
        r16 = false;
    L22:
        this.mEffectivePolicyRaw = new Policy(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, rawPolicy.enableQuickDoze, rawPolicy.forceAllAppsStandby, rawPolicy.forceBackgroundCheck, locationMode2, rawPolicy.soundTriggerMode);
        StringBuilder sb = new StringBuilder();
        if (this.mEffectivePolicyRaw.forceAllAppsStandby == false) goto L26;
        sb.append("A");
    L26:
        if (this.mEffectivePolicyRaw.forceBackgroundCheck == false) goto L29;
        sb.append("B");
    L29:
        if (this.mEffectivePolicyRaw.disableVibration == false) goto L32;
        sb.append("v");
    L32:
        if (this.mEffectivePolicyRaw.disableAnimation == false) goto L34;
        sb.append(ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD);
    L34:
        sb.append(this.mEffectivePolicyRaw.soundTriggerMode);
        if (this.mEffectivePolicyRaw.deferFullBackup == false) goto L38;
        sb.append("F");
    L38:
        if (this.mEffectivePolicyRaw.deferKeyValueBackup == false) goto L41;
        sb.append("K");
    L41:
        if (this.mEffectivePolicyRaw.enableFirewall == false) goto L44;
        sb.append("f");
    L44:
        if (this.mEffectivePolicyRaw.enableDataSaver == false) goto L47;
        sb.append("d");
    L47:
        if (this.mEffectivePolicyRaw.enableAdjustBrightness == false) goto L50;
        sb.append("b");
    L50:
        if (this.mEffectivePolicyRaw.disableLaunchBoost == false) goto L53;
        sb.append("l");
    L53:
        if (this.mEffectivePolicyRaw.disableOptionalSensors == false) goto L56;
        sb.append("S");
    L56:
        if (this.mEffectivePolicyRaw.disableAod == false) goto L59;
        sb.append("o");
    L59:
        if (this.mEffectivePolicyRaw.enableQuickDoze == false) goto L61;
        sb.append("q");
    L61:
        sb.append(this.mEffectivePolicyRaw.locationMode);
        this.mEventLogKeys = sb.toString();
        return;
    L19:
        if (PolicyBoolean.m7634$$Nest$mget(this.mAutomotiveProjectionActive) == true) goto L21;
    L5:
        if (rawPolicy.locationMode == 0) goto L9;
        if (rawPolicy.locationMode == 3) goto L9;
        locationMode2 = 3;
        goto L10
    }

    public PowerSaveState getBatterySaverPolicy(int type) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Policy currPolicy = getCurrentPolicyLocked();     // Catch: Throwable -> L9
        PowerSaveState.Builder builder = new PowerSaveState.Builder().setGlobalBatterySaverEnabled(currPolicy.advertiseIsEnabled);     // Catch: Throwable -> L9
        boolean soundTriggerBatterySaverEnabled = true;
        switch(type) {
            case 1: goto L60;
            case 2: goto L56;
            case 3: goto L53;
            case 4: goto L50;
            case 5: goto L47;
            case 6: goto L44;
            case 7: goto L41;
            case 8: goto L33;
            case 9: goto L6;
            case 10: goto L29;
            case 11: goto L26;
            case 12: goto L23;
            case 13: goto L20;
            case 14: goto L17;
            case 15: goto L14;
            case 16: goto L11;
            default: goto L6;
        };     // Catch: Throwable -> L9
    L6:
        PowerSaveState r3 = builder.setBatterySaverEnabled(currPolicy.advertiseIsEnabled).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L11:
        PowerSaveState r4 = builder.setBatterySaverEnabled(currPolicy.enableNightMode).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L14:
        PowerSaveState r5 = builder.setBatterySaverEnabled(currPolicy.enableQuickDoze).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r5;
    L17:
        PowerSaveState r6 = builder.setBatterySaverEnabled(currPolicy.disableAod).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r6;
    L20:
        PowerSaveState r7 = builder.setBatterySaverEnabled(currPolicy.disableOptionalSensors).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r7;
    L23:
        PowerSaveState r8 = builder.setBatterySaverEnabled(currPolicy.forceBackgroundCheck).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r8;
    L26:
        PowerSaveState r9 = builder.setBatterySaverEnabled(currPolicy.forceAllAppsStandby).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r9;
    L29:
        PowerSaveState r10 = builder.setBatterySaverEnabled(currPolicy.enableDataSaver).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r10;
    L41:
        PowerSaveState r11 = builder.setBatterySaverEnabled(currPolicy.enableAdjustBrightness).setBrightnessFactor(currPolicy.adjustBrightnessFactor).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r11;
    L44:
        PowerSaveState r12 = builder.setBatterySaverEnabled(currPolicy.enableFirewall).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r12;
    L47:
        PowerSaveState r13 = builder.setBatterySaverEnabled(currPolicy.deferKeyValueBackup).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r13;
    L50:
        PowerSaveState r14 = builder.setBatterySaverEnabled(currPolicy.deferFullBackup).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r14;
    L53:
        PowerSaveState r15 = builder.setBatterySaverEnabled(currPolicy.disableAnimation).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r15;
    L56:
        PowerSaveState r16 = builder.setBatterySaverEnabled(currPolicy.disableVibration).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r16;
    L33:
        if (currPolicy.advertiseIsEnabled == true) goto L38;
        if (currPolicy.soundTriggerMode != 0) goto L38;
        soundTriggerBatterySaverEnabled = false;
    L38:
        PowerSaveState r17 = builder.setBatterySaverEnabled(soundTriggerBatterySaverEnabled).setSoundTriggerMode(currPolicy.soundTriggerMode).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r17;
    L60:
        if (currPolicy.advertiseIsEnabled == true) goto L65;
        if (currPolicy.locationMode != 0) goto L65;
        soundTriggerBatterySaverEnabled = false;
    L65:
        PowerSaveState r18 = builder.setBatterySaverEnabled(soundTriggerBatterySaverEnabled).setLocationMode(currPolicy.locationMode).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r18;
    L9:
        th = move-exception;
        throw th;
    }

    boolean setPolicyLevel(int level) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPolicyLevel != level) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (this.mPolicyLevel != 2) goto L13;
        this.mFullPolicy = this.mDefaultFullPolicy;     // Catch: Throwable -> L8
    L13:
        switch(level) {
            case 0: goto L17;
            case 1: goto L17;
            case 2: goto L17;
            default: goto L14;
        };     // Catch: Throwable -> L8
    L14:
        Slog.wtf(TAG, "setPolicyLevel invalid level given: " + level);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L17:
        this.mPolicyLevel = level;     // Catch: Throwable -> L8
        updatePolicyDependenciesLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    }

    Policy getPolicyLocked(int policyLevel) {
        switch(policyLevel) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("getPolicyLocked: incorrect policy level provided - " + policyLevel);
    L6:
        return this.mFullPolicy;
    L8:
        return this.mAdaptivePolicy;
    L10:
        return OFF_POLICY;
    }

    private boolean maybeUpdateDefaultFullPolicy(Policy p) {
        boolean fullPolicyChanged = false;
        if (this.mDefaultFullPolicy.equals(p) == true) goto L12;
        boolean r2 = true;
        boolean isDefaultFullPolicyOverridden = !this.mDefaultFullPolicy.equals(this.mFullPolicy);
        if (isDefaultFullPolicyOverridden == true) goto L11;
        this.mFullPolicy = p;
        if (this.mPolicyLevel == 2) goto L10;
        r2 = false;
    L10:
        fullPolicyChanged = r2;
    L11:
        this.mDefaultFullPolicy = p;
    L12:
        return fullPolicyChanged;
    }

    boolean setFullPolicyLocked(Policy p) {
        if (p != null) goto L7;
        Slog.wtf(TAG, "setFullPolicy given null policy");
        return false;
    L7:
        if (this.mFullPolicy.equals(p) == false) goto L9;
        return false;
    L9:
        this.mFullPolicy = p;
        if (this.mPolicyLevel != 2) goto L13;
        updatePolicyDependenciesLocked();
        return true;
    L13:
        return false;
    }

    boolean setAdaptivePolicyLocked(Policy p) {
        if (p != null) goto L7;
        Slog.wtf(TAG, "setAdaptivePolicy given null policy");
        return false;
    L7:
        if (this.mAdaptivePolicy.equals(p) == false) goto L9;
        return false;
    L9:
        this.mAdaptivePolicy = p;
        if (this.mPolicyLevel != 1) goto L13;
        updatePolicyDependenciesLocked();
        return true;
    L13:
        return false;
    }

    boolean resetAdaptivePolicyLocked() {
        return setAdaptivePolicyLocked(this.mDefaultAdaptivePolicy);
    }

    private Policy getCurrentPolicyLocked() {
        return this.mEffectivePolicyRaw;
    }

    private Policy getCurrentRawPolicyLocked() {
        switch(this.mPolicyLevel) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return OFF_POLICY;
    L7:
        return this.mFullPolicy;
    L9:
        return this.mAdaptivePolicy;
    }

    public int getGpsMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = getCurrentPolicyLocked().locationMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isLaunchBoostDisabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = getCurrentPolicyLocked().disableLaunchBoost;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean shouldAdvertiseIsEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = getCurrentPolicyLocked().advertiseIsEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String toEventLogString() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mEventLogKeys;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        Object r1 = this.mLock;
        monitor-enter(r1);
        ipw.println();     // Catch: Throwable -> L7
        this.mBatterySavingStats.dump(ipw);     // Catch: Throwable -> L7
        ipw.println();     // Catch: Throwable -> L7
        ipw.println("Battery saver policy (*NOTE* they only apply when battery saver is ON):");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        ipw.println("Settings: battery_saver_constants");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        ipw.println("value: " + this.mSettings);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println("Settings: " + this.mDeviceSpecificSettingsSource);     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        ipw.println("value: " + this.mDeviceSpecificSettings);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println("DeviceConfig: battery_saver");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        Set<String> keys = this.mLastDeviceConfigProperties.getKeyset();     // Catch: Throwable -> L7
        if (keys.size() != 0) goto L9;
        ipw.println("N/A");     // Catch: Throwable -> L7
    L13:
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println("mAccessibilityEnabled=" + PolicyBoolean.m7634$$Nest$mget(this.mAccessibilityEnabled));     // Catch: Throwable -> L7
        ipw.println("mAutomotiveProjectionActive=" + PolicyBoolean.m7634$$Nest$mget(this.mAutomotiveProjectionActive));     // Catch: Throwable -> L7
        ipw.println("mPolicyLevel=" + this.mPolicyLevel);     // Catch: Throwable -> L7
        dumpPolicyLocked(ipw, "default full", this.mDefaultFullPolicy);     // Catch: Throwable -> L7
        dumpPolicyLocked(ipw, "current full", this.mFullPolicy);     // Catch: Throwable -> L7
        dumpPolicyLocked(ipw, "default adaptive", this.mDefaultAdaptivePolicy);     // Catch: Throwable -> L7
        dumpPolicyLocked(ipw, "current adaptive", this.mAdaptivePolicy);     // Catch: Throwable -> L7
        dumpPolicyLocked(ipw, "effective", this.mEffectivePolicyRaw);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L9:
        Iterator<String> r3 = keys.iterator();     // Catch: Throwable -> L7
    L11:
        if (r3.hasNext() == false) goto L13;
        String key = r3.next();     // Catch: Throwable -> L7
        ipw.print(key);     // Catch: Throwable -> L7
        ipw.print(": ");     // Catch: Throwable -> L7
        ipw.println(this.mLastDeviceConfigProperties.getString(key, null));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpPolicyLocked(IndentingPrintWriter pw, String label, Policy p) {
        pw.println();
        pw.println("Policy '" + label + "'");
        pw.increaseIndent();
        pw.println("advertise_is_enabled=" + p.advertiseIsEnabled);
        pw.println("disable_vibration=" + p.disableVibration);
        pw.println("disable_animation=" + p.disableAnimation);
        pw.println("defer_full_backup=" + p.deferFullBackup);
        pw.println("defer_keyvalue_backup=" + p.deferKeyValueBackup);
        pw.println("enable_firewall=" + p.enableFirewall);
        pw.println("enable_datasaver=" + p.enableDataSaver);
        pw.println("disable_launch_boost=" + p.disableLaunchBoost);
        pw.println("enable_brightness_adjustment=" + p.enableAdjustBrightness);
        pw.println("adjust_brightness_factor=" + p.adjustBrightnessFactor);
        pw.println("location_mode=" + p.locationMode);
        pw.println("force_all_apps_standby=" + p.forceAllAppsStandby);
        pw.println("force_background_check=" + p.forceBackgroundCheck);
        pw.println("disable_optional_sensors=" + p.disableOptionalSensors);
        pw.println("disable_aod=" + p.disableAod);
        pw.println("soundtrigger_mode=" + p.soundTriggerMode);
        pw.println("enable_quick_doze=" + p.enableQuickDoze);
        pw.println("enable_night_mode=" + p.enableNightMode);
        pw.decreaseIndent();
    }

    private void dumpMap(PrintWriter pw, ArrayMap<String, String> map) {
        if (map != null) goto L4;
    L11:
        pw.println("N/A");
        return;
    L4:
        if (map.size() == 0) goto L11;
        int size = map.size();
        int i = 0;
    L7:
        if (i >= size) goto L10;
        pw.print(map.keyAt(i));
        pw.print(": '");
        pw.print(map.valueAt(i));
        pw.println("'");
        i = i + 1;
        goto L7
    }
}
