package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.BatteryConsumer;
import android.os.BatteryStatsInternal;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.PowerExemptionManager;
import android.os.SystemClock;
import android.os.UidBatteryConsumer;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.ISmtResourceControl;
import com.android.server.pm.UserManagerInternal;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class AppBatteryTracker extends BaseAppStateTracker<AppBatteryPolicy> implements AppRestrictionController.UidBatteryUsageProvider {
    static final ImmutableBatteryUsage BATTERY_USAGE_NONE = null;
    static final long BATTERY_USAGE_STATS_POLLING_INTERVAL_MS_DEBUG = 2000;
    static final long BATTERY_USAGE_STATS_POLLING_INTERVAL_MS_LONG = 1800000;
    static final long BATTERY_USAGE_STATS_POLLING_MIN_INTERVAL_MS_DEBUG = 2000;
    static final long BATTERY_USAGE_STATS_POLLING_MIN_INTERVAL_MS_LONG = 300000;
    static final boolean DEBUG_BACKGROUND_BATTERY_TRACKER = false;
    static final boolean DEBUG_BACKGROUND_BATTERY_TRACKER_VERBOSE = false;
    static final String TAG = "ActivityManager";
    private final SparseBooleanArray mActiveUserIdStates;
    private final long mBatteryUsageStatsPollingIntervalMs;
    private final long mBatteryUsageStatsPollingMinIntervalMs;
    private boolean mBatteryUsageStatsUpdatePending;
    private final Runnable mBgBatteryUsageStatsCheck;
    private final Runnable mBgBatteryUsageStatsPolling;
    private final SparseArray<ImmutableBatteryUsage> mDebugUidPercentages;
    private long mLastBatteryUsageSamplingTs;
    private long mLastReportTime;
    private final SparseArray<ImmutableBatteryUsage> mLastUidBatteryUsage;
    private long mLastUidBatteryUsageStartTs;
    private final SparseArray<BatteryUsage> mTmpUidBatteryUsage;
    private final SparseArray<ImmutableBatteryUsage> mTmpUidBatteryUsage2;
    private final SparseArray<ImmutableBatteryUsage> mTmpUidBatteryUsageInWindow;
    private final ArraySet<UserHandle> mTmpUserIds;
    private final SparseArray<BatteryUsage> mUidBatteryUsage;
    private final SparseArray<ImmutableBatteryUsage> mUidBatteryUsageInWindow;

    static final class AppBatteryPolicy extends BaseAppStatePolicy<AppBatteryTracker> {
        static final int BATTERY_USAGE_TYPE_BACKGROUND = 4;
        static final int BATTERY_USAGE_TYPE_CACHED = 16;
        static final int BATTERY_USAGE_TYPE_FOREGROUND = 2;
        static final int BATTERY_USAGE_TYPE_FOREGROUND_SERVICE = 8;
        static final int BATTERY_USAGE_TYPE_UNSPECIFIED = 1;
        static final boolean DEFAULT_BG_CURRENT_DRAIN_DECOUPLE_THRESHOLD = true;
        static final int DEFAULT_BG_CURRENT_DRAIN_POWER_COMPONENTS = -1;
        static final int INDEX_HIGH_CURRENT_DRAIN_THRESHOLD = 1;
        static final int INDEX_REGULAR_CURRENT_DRAIN_THRESHOLD = 0;
        static final String KEY_BG_CURRENT_DRAIN_AUTO_RESTRICT_ABUSIVE_APPS_ENABLED = "bg_current_drain_auto_restrict_abusive_apps_enabled";
        static final String KEY_BG_CURRENT_DRAIN_DECOUPLE_THRESHOLDS = "bg_current_drain_decouple_thresholds";
        static final String KEY_BG_CURRENT_DRAIN_EVENT_DURATION_BASED_THRESHOLD_ENABLED = "bg_current_drain_event_duration_based_threshold_enabled";
        static final String KEY_BG_CURRENT_DRAIN_EXEMPTED_TYPES = "bg_current_drain_exempted_types";
        static final String KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_BY_BG_LOCATION = "bg_current_drain_high_threshold_by_bg_location";
        static final String KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_BG_RESTRICTED = "bg_current_drain_high_threshold_to_bg_restricted";
        static final String KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_RESTRICTED_BUCKET = "bg_current_drain_high_threshold_to_restricted_bucket";
        static final String KEY_BG_CURRENT_DRAIN_INTERACTION_GRACE_PERIOD = "bg_current_drain_interaction_grace_period";
        static final String KEY_BG_CURRENT_DRAIN_LOCATION_MIN_DURATION = "bg_current_drain_location_min_duration";
        static final String KEY_BG_CURRENT_DRAIN_MEDIA_PLAYBACK_MIN_DURATION = "bg_current_drain_media_playback_min_duration";
        static final String KEY_BG_CURRENT_DRAIN_MONITOR_ENABLED = "bg_current_drain_monitor_enabled";
        static final String KEY_BG_CURRENT_DRAIN_POWER_COMPONENTS = "bg_current_drain_power_components";
        static final String KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_BG_RESTRICTED = "bg_current_drain_threshold_to_bg_restricted";
        static final String KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_RESTRICTED_BUCKET = "bg_current_drain_threshold_to_restricted_bucket";
        static final String KEY_BG_CURRENT_DRAIN_TYPES_TO_BG_RESTRICTED = "bg_current_drain_types_to_bg_restricted";
        static final String KEY_BG_CURRENT_DRAIN_TYPES_TO_RESTRICTED_BUCKET = "bg_current_drain_types_to_restricted_bucket";
        static final String KEY_BG_CURRENT_DRAIN_WINDOW = "bg_current_drain_window";
        private static final int TIME_STAMP_INDEX_BG_RESTRICTED = 1;
        private static final int TIME_STAMP_INDEX_LAST = 2;
        private static final int TIME_STAMP_INDEX_RESTRICTED_BUCKET = 0;
        volatile BatteryConsumer.Dimensions[] mBatteryDimensions;
        private int mBatteryFullChargeMah;
        volatile boolean mBgCurrentDrainAutoRestrictAbusiveAppsEnabled;
        volatile float[] mBgCurrentDrainBgRestrictedThreshold;
        volatile int mBgCurrentDrainBgRestrictedTypes;
        volatile boolean mBgCurrentDrainDecoupleThresholds;
        volatile boolean mBgCurrentDrainEventDurationBasedThresholdEnabled;
        volatile int mBgCurrentDrainExemptedTypes;
        volatile boolean mBgCurrentDrainHighThresholdByBgLocation;
        volatile long mBgCurrentDrainInteractionGracePeriodMs;
        volatile long mBgCurrentDrainLocationMinDuration;
        volatile long mBgCurrentDrainMediaPlaybackMinDuration;
        volatile int mBgCurrentDrainPowerComponents;
        volatile float[] mBgCurrentDrainRestrictedBucketThreshold;
        volatile int mBgCurrentDrainRestrictedBucketTypes;
        volatile long mBgCurrentDrainWindowMs;
        final boolean mDefaultBgCurrentDrainAutoRestrictAbusiveAppsEnabled;
        final float mDefaultBgCurrentDrainBgRestrictedHighThreshold;
        final float mDefaultBgCurrentDrainBgRestrictedThreshold;
        final boolean mDefaultBgCurrentDrainEventDurationBasedThresholdEnabled;
        final int mDefaultBgCurrentDrainExemptedTypes;
        final boolean mDefaultBgCurrentDrainHighThresholdByBgLocation;
        final long mDefaultBgCurrentDrainInteractionGracePeriodMs;
        final long mDefaultBgCurrentDrainLocationMinDuration;
        final long mDefaultBgCurrentDrainMediaPlaybackMinDuration;
        final int mDefaultBgCurrentDrainPowerComponent;
        final float mDefaultBgCurrentDrainRestrictedBucket;
        final float mDefaultBgCurrentDrainRestrictedBucketHighThreshold;
        final int mDefaultBgCurrentDrainTypesToBgRestricted;
        final long mDefaultBgCurrentDrainWindowMs;
        final int mDefaultCurrentDrainTypesToRestrictedBucket;
        private final SparseArray<Pair<long[], ImmutableBatteryUsage[]>> mHighBgBatteryPackages;
        private final SparseLongArray mLastInteractionTime;
        private final Object mLock;

        AppBatteryPolicy(BaseAppStateTracker.Injector injector, AppBatteryTracker tracker) {
            super(injector, tracker, KEY_BG_CURRENT_DRAIN_MONITOR_ENABLED, tracker.mContext.getResources().getBoolean(R.bool.config_biometricFrrNotificationEnabled));
            this.mBgCurrentDrainRestrictedBucketThreshold = new float[2];
            this.mBgCurrentDrainBgRestrictedThreshold = new float[2];
            this.mHighBgBatteryPackages = new SparseArray();
            this.mLastInteractionTime = new SparseLongArray();
            this.mLock = tracker.mLock;
            Resources resources = tracker.mContext.getResources();
            float[] val = getFloatArray(resources.obtainTypedArray(R.array.config_companionPermSyncEnabledPackages));
            if (ActivityManager.isLowRamDeviceStatic() == false) goto L5;
            float r2 = val[1];
        L6:
            this.mDefaultBgCurrentDrainRestrictedBucket = r2;
            float[] val2 = getFloatArray(resources.obtainTypedArray(R.array.config_companionPermSyncEnabledCerts));
            if (ActivityManager.isLowRamDeviceStatic() == false) goto L9;
            float r3 = val2[1];
        L10:
            this.mDefaultBgCurrentDrainBgRestrictedThreshold = r3;
            this.mDefaultBgCurrentDrainWindowMs = resources.getInteger(R.integer.config_burnInProtectionMinHorizontalOffset) * 1000;
            this.mDefaultBgCurrentDrainInteractionGracePeriodMs = this.mDefaultBgCurrentDrainWindowMs;
            float[] val3 = getFloatArray(resources.obtainTypedArray(R.array.config_companionDevicePackages));
            if (ActivityManager.isLowRamDeviceStatic() == false) goto L13;
            float r4 = val3[1];
        L14:
            this.mDefaultBgCurrentDrainRestrictedBucketHighThreshold = r4;
            float[] val4 = getFloatArray(resources.obtainTypedArray(R.array.config_companionDeviceCerts));
            if (ActivityManager.isLowRamDeviceStatic() == false) goto L17;
            float r5 = val4[1];
        L18:
            this.mDefaultBgCurrentDrainBgRestrictedHighThreshold = r5;
            this.mDefaultBgCurrentDrainMediaPlaybackMinDuration = resources.getInteger(R.integer.config_brightness_ramp_rate_slow) * 1000;
            this.mDefaultBgCurrentDrainLocationMinDuration = resources.getInteger(R.integer.config_brightness_ramp_rate_fast) * 1000;
            this.mDefaultBgCurrentDrainEventDurationBasedThresholdEnabled = resources.getBoolean(R.bool.config_bg_prompt_abusive_apps_to_bg_restricted);
            this.mDefaultBgCurrentDrainAutoRestrictAbusiveAppsEnabled = resources.getBoolean(R.bool.config_bg_current_drain_monitor_enabled);
            this.mDefaultCurrentDrainTypesToRestrictedBucket = resources.getInteger(R.integer.config_burnInProtectionMaxVerticalOffset);
            this.mDefaultBgCurrentDrainTypesToBgRestricted = resources.getInteger(R.integer.config_burnInProtectionMaxRadius);
            this.mDefaultBgCurrentDrainPowerComponent = resources.getInteger(R.integer.config_burnInProtectionMaxHorizontalOffset);
            this.mDefaultBgCurrentDrainExemptedTypes = resources.getInteger(R.integer.config_bluetooth_tx_cur_ma);
            this.mDefaultBgCurrentDrainHighThresholdByBgLocation = resources.getBoolean(R.bool.config_bg_prompt_fgs_with_noti_to_bg_restricted);
            this.mBgCurrentDrainRestrictedBucketThreshold[0] = this.mDefaultBgCurrentDrainRestrictedBucket;
            this.mBgCurrentDrainRestrictedBucketThreshold[1] = this.mDefaultBgCurrentDrainRestrictedBucketHighThreshold;
            this.mBgCurrentDrainBgRestrictedThreshold[0] = this.mDefaultBgCurrentDrainBgRestrictedThreshold;
            this.mBgCurrentDrainBgRestrictedThreshold[1] = this.mDefaultBgCurrentDrainBgRestrictedHighThreshold;
            this.mBgCurrentDrainWindowMs = this.mDefaultBgCurrentDrainWindowMs;
            this.mBgCurrentDrainInteractionGracePeriodMs = this.mDefaultBgCurrentDrainInteractionGracePeriodMs;
            this.mBgCurrentDrainMediaPlaybackMinDuration = this.mDefaultBgCurrentDrainMediaPlaybackMinDuration;
            this.mBgCurrentDrainLocationMinDuration = this.mDefaultBgCurrentDrainLocationMinDuration;
            return;
        L17:
            r5 = val4[0];
            goto L18
        L13:
            r4 = val3[0];
            goto L14
        L9:
            r3 = val2[0];
            goto L10
        L5:
            r2 = val[0];
            goto L6
        }

        static float[] getFloatArray(TypedArray array) {
            int length = array.length();
            float[] floatArray = new float[length];
            int i = 0;
        L3:
            if (i >= length) goto L5;
            floatArray[i] = array.getFloat(i, Float.NaN);
            i = i + 1;
            goto L3
        L5:
            array.recycle();
            return floatArray;
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onPropertiesChanged(String name) {
            switch(name.hashCode()) {
                case -1969771998: goto L51;
                case -1881058465: goto L48;
                case -531697693: goto L45;
                case -523630921: goto L42;
                case -494951532: goto L39;
                case 50590052: goto L36;
                case 101017819: goto L33;
                case 129921652: goto L30;
                case 399258641: goto L27;
                case 517972572: goto L24;
                case 655159543: goto L21;
                case 718752671: goto L18;
                case 1136582590: goto L15;
                case 1362995852: goto L12;
                case 1869456581: goto L9;
                case 1961864407: goto L6;
                default: goto L53;
            };
        L53:
            byte r0 = -1;
        L54:
            switch(r0) {
                case 0: goto L64;
                case 1: goto L64;
                case 2: goto L64;
                case 3: goto L64;
                case 4: goto L64;
                case 5: goto L64;
                case 6: goto L64;
                case 7: goto L64;
                case 8: goto L63;
                case 9: goto L62;
                case 10: goto L61;
                case 11: goto L60;
                case 12: goto L59;
                case 13: goto L58;
                case 14: goto L57;
                case 15: goto L56;
                default: goto L55;
            };
        L55:
            super.onPropertiesChanged(name);
            return;
        L56:
            updateCurrentDrainDecoupleThresholds();
            return;
        L57:
            updateCurrentDrainExemptedTypes();
            return;
        L58:
            updateCurrentDrainEventDurationBasedThresholdEnabled();
            return;
        L59:
            updateCurrentDrainLocationMinDuration();
            return;
        L60:
            updateCurrentDrainMediaPlaybackMinDuration();
            return;
        L61:
            updateCurrentDrainInteractionGracePeriod();
            return;
        L62:
            updateCurrentDrainWindow();
            return;
        L63:
            updateBgCurrentDrainAutoRestrictAbusiveAppsEnabled();
            return;
        L64:
            updateCurrentDrainThreshold();
            return;
        L6:
            if (name.equals(KEY_BG_CURRENT_DRAIN_WINDOW) == false) goto L53;
            r0 = 9;
            goto L54
        L9:
            if (name.equals(KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_RESTRICTED_BUCKET) == false) goto L53;
            r0 = 0;
            goto L54
        L12:
            if (name.equals(KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_BG_RESTRICTED) == false) goto L53;
            r0 = 1;
            goto L54
        L15:
            if (name.equals(KEY_BG_CURRENT_DRAIN_TYPES_TO_BG_RESTRICTED) == false) goto L53;
            r0 = 6;
            goto L54
        L18:
            if (name.equals(KEY_BG_CURRENT_DRAIN_EXEMPTED_TYPES) == false) goto L53;
            r0 = 14;
            goto L54
        L21:
            if (name.equals(KEY_BG_CURRENT_DRAIN_TYPES_TO_RESTRICTED_BUCKET) == false) goto L53;
            r0 = 5;
            goto L54
        L24:
            if (name.equals(KEY_BG_CURRENT_DRAIN_INTERACTION_GRACE_PERIOD) == false) goto L53;
            r0 = 10;
            goto L54
        L27:
            if (name.equals(KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_BY_BG_LOCATION) == false) goto L53;
            r0 = 2;
            goto L54
        L30:
            if (name.equals(KEY_BG_CURRENT_DRAIN_AUTO_RESTRICT_ABUSIVE_APPS_ENABLED) == false) goto L53;
            r0 = 8;
            goto L54
        L33:
            if (name.equals(KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_BG_RESTRICTED) == false) goto L53;
            r0 = 4;
            goto L54
        L36:
            if (name.equals(KEY_BG_CURRENT_DRAIN_LOCATION_MIN_DURATION) == false) goto L53;
            r0 = 12;
            goto L54
        L39:
            if (name.equals(KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_RESTRICTED_BUCKET) == false) goto L53;
            r0 = 3;
            goto L54
        L42:
            if (name.equals(KEY_BG_CURRENT_DRAIN_POWER_COMPONENTS) == false) goto L53;
            r0 = 7;
            goto L54
        L45:
            if (name.equals(KEY_BG_CURRENT_DRAIN_MEDIA_PLAYBACK_MIN_DURATION) == false) goto L53;
            r0 = 11;
            goto L54
        L48:
            if (name.equals(KEY_BG_CURRENT_DRAIN_DECOUPLE_THRESHOLDS) == false) goto L53;
            r0 = 15;
            goto L54
        L51:
            if (name.equals(KEY_BG_CURRENT_DRAIN_EVENT_DURATION_BASED_THRESHOLD_ENABLED) == false) goto L53;
            r0 = 13;
            goto L54
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        void updateTrackerEnabled() {
            if (this.mBatteryFullChargeMah <= 0) goto L5;
            super.updateTrackerEnabled();
            return;
        L5:
            this.mTrackerEnabled = false;
            onTrackerEnabled(false);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onTrackerEnabled(boolean enabled) {
            AppBatteryTracker.m1287$$Nest$monCurrentDrainMonitorEnabled((AppBatteryTracker) this.mTracker, enabled);
        }

        private void updateCurrentDrainThreshold() {
            this.mBgCurrentDrainRestrictedBucketThreshold[0] = DeviceConfig.getFloat("activity_manager", KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_RESTRICTED_BUCKET, this.mDefaultBgCurrentDrainRestrictedBucket);
            this.mBgCurrentDrainRestrictedBucketThreshold[1] = DeviceConfig.getFloat("activity_manager", KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_RESTRICTED_BUCKET, this.mDefaultBgCurrentDrainRestrictedBucketHighThreshold);
            this.mBgCurrentDrainBgRestrictedThreshold[0] = DeviceConfig.getFloat("activity_manager", KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_BG_RESTRICTED, this.mDefaultBgCurrentDrainBgRestrictedThreshold);
            this.mBgCurrentDrainBgRestrictedThreshold[1] = DeviceConfig.getFloat("activity_manager", KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_BG_RESTRICTED, this.mDefaultBgCurrentDrainBgRestrictedHighThreshold);
            this.mBgCurrentDrainRestrictedBucketTypes = DeviceConfig.getInt("activity_manager", KEY_BG_CURRENT_DRAIN_TYPES_TO_RESTRICTED_BUCKET, this.mDefaultCurrentDrainTypesToRestrictedBucket);
            this.mBgCurrentDrainBgRestrictedTypes = DeviceConfig.getInt("activity_manager", KEY_BG_CURRENT_DRAIN_TYPES_TO_BG_RESTRICTED, this.mDefaultBgCurrentDrainTypesToBgRestricted);
            this.mBgCurrentDrainPowerComponents = DeviceConfig.getInt("activity_manager", KEY_BG_CURRENT_DRAIN_POWER_COMPONENTS, this.mDefaultBgCurrentDrainPowerComponent);
            if (this.mBgCurrentDrainPowerComponents != (-1)) goto L5;
            this.mBatteryDimensions = BatteryUsage.BATT_DIMENS;
        L8:
            this.mBgCurrentDrainHighThresholdByBgLocation = DeviceConfig.getBoolean("activity_manager", KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_BY_BG_LOCATION, this.mDefaultBgCurrentDrainHighThresholdByBgLocation);
            return;
        L5:
            this.mBatteryDimensions = new BatteryConsumer.Dimensions[5];
            int i = 0;
        L6:
            if (i >= 5) goto L8;
            this.mBatteryDimensions[i] = new BatteryConsumer.Dimensions(this.mBgCurrentDrainPowerComponents, i);
            i = i + 1;
            goto L6
        }

        private void updateCurrentDrainWindow() {
            this.mBgCurrentDrainWindowMs = DeviceConfig.getLong("activity_manager", KEY_BG_CURRENT_DRAIN_WINDOW, this.mDefaultBgCurrentDrainWindowMs);
        }

        private void updateCurrentDrainInteractionGracePeriod() {
            this.mBgCurrentDrainInteractionGracePeriodMs = DeviceConfig.getLong("activity_manager", KEY_BG_CURRENT_DRAIN_INTERACTION_GRACE_PERIOD, this.mDefaultBgCurrentDrainInteractionGracePeriodMs);
        }

        private void updateCurrentDrainMediaPlaybackMinDuration() {
            this.mBgCurrentDrainMediaPlaybackMinDuration = DeviceConfig.getLong("activity_manager", KEY_BG_CURRENT_DRAIN_MEDIA_PLAYBACK_MIN_DURATION, this.mDefaultBgCurrentDrainMediaPlaybackMinDuration);
        }

        private void updateCurrentDrainLocationMinDuration() {
            this.mBgCurrentDrainLocationMinDuration = DeviceConfig.getLong("activity_manager", KEY_BG_CURRENT_DRAIN_LOCATION_MIN_DURATION, this.mDefaultBgCurrentDrainLocationMinDuration);
        }

        private void updateCurrentDrainEventDurationBasedThresholdEnabled() {
            this.mBgCurrentDrainEventDurationBasedThresholdEnabled = DeviceConfig.getBoolean("activity_manager", KEY_BG_CURRENT_DRAIN_EVENT_DURATION_BASED_THRESHOLD_ENABLED, this.mDefaultBgCurrentDrainEventDurationBasedThresholdEnabled);
        }

        private void updateCurrentDrainExemptedTypes() {
            this.mBgCurrentDrainExemptedTypes = DeviceConfig.getInt("activity_manager", KEY_BG_CURRENT_DRAIN_EXEMPTED_TYPES, this.mDefaultBgCurrentDrainExemptedTypes);
        }

        private void updateCurrentDrainDecoupleThresholds() {
            this.mBgCurrentDrainDecoupleThresholds = DeviceConfig.getBoolean("activity_manager", KEY_BG_CURRENT_DRAIN_DECOUPLE_THRESHOLDS, true);
        }

        private void updateBgCurrentDrainAutoRestrictAbusiveAppsEnabled() {
            this.mBgCurrentDrainAutoRestrictAbusiveAppsEnabled = DeviceConfig.getBoolean("activity_manager", KEY_BG_CURRENT_DRAIN_AUTO_RESTRICT_ABUSIVE_APPS_ENABLED, this.mDefaultBgCurrentDrainAutoRestrictAbusiveAppsEnabled);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onSystemReady() {
            this.mBatteryFullChargeMah = this.mInjector.getBatteryManagerInternal().getBatteryFullCharge() / 1000;
            super.onSystemReady();
            updateCurrentDrainThreshold();
            updateCurrentDrainWindow();
            updateCurrentDrainInteractionGracePeriod();
            updateCurrentDrainMediaPlaybackMinDuration();
            updateCurrentDrainLocationMinDuration();
            updateCurrentDrainEventDurationBasedThresholdEnabled();
            updateCurrentDrainExemptedTypes();
            updateCurrentDrainDecoupleThresholds();
            updateBgCurrentDrainAutoRestrictAbusiveAppsEnabled();
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public int getProposedRestrictionLevel(String packageName, int uid, int maxLevel) {
            boolean canRestrict = false;
            if (maxLevel > 30) goto L5;
            return 0;
        L5:
            Object r5 = this.mLock;
            monitor-enter(r5);
            Pair<long[], ImmutableBatteryUsage[]> pair = this.mHighBgBatteryPackages.get(uid);     // Catch: Throwable -> L18
            if (pair == null) goto L36;
            long lastInteractionTime = this.mLastInteractionTime.get(uid, 0);     // Catch: Throwable -> L18
            long[] ts = (long[]) pair.first;     // Catch: Throwable -> L18
            if (ts[0] <= (this.mBgCurrentDrainInteractionGracePeriodMs + lastInteractionTime)) goto L12;
            boolean noInteractionRecently = true;
        L14:
            if (((AppBatteryTracker) this.mTracker).mAppRestrictionController.isAutoRestrictAbusiveAppEnabled() == true) goto L16;
        L21:
            if (noInteractionRecently == false) goto L24;
            if (canRestrict == false) goto L24;
            int restrictedLevel = 40;
        L25:
            int r15 = 50;
            if (maxLevel > 50) goto L28;
            if (maxLevel != 50) goto L36;
            monitor-exit(r5);     // Catch: Throwable -> L18
            return restrictedLevel;
        L28:
            if (ts[1] > 0) goto L31;
            r15 = restrictedLevel;
        L31:
            monitor-exit(r5);     // Catch: Throwable -> L18
            return r15;
        L24:
            restrictedLevel = 30;
            goto L25
        L16:
            if (this.mBgCurrentDrainAutoRestrictAbusiveAppsEnabled == false) goto L21;
            canRestrict = true;
            goto L21
        L12:
            noInteractionRecently = false;
        L36:
            monitor-exit(r5);     // Catch: Throwable -> L18
            return 30;
        L18:
            th = move-exception;
            throw th;
        }

        double[] calcPercentage(int uid, double[] usage, double[] percentage) {
            double[] forced = null;
            if (uid <= 0) goto L5;
            BatteryUsage debugUsage = (BatteryUsage) AppBatteryTracker.m1286$$Nest$fgetmDebugUidPercentages((AppBatteryTracker) this.mTracker).get(uid);
        L6:
            if (debugUsage == null) goto L8;
            forced = debugUsage.getPercentage();
        L8:
            int i = 0;
        L10:
            if (i >= usage.length) goto L16;
            if (forced == null) goto L13;
            double r3 = forced[i];
        L14:
            percentage[i] = r3;
            i = i + 1;
            goto L10
        L13:
            r3 = (usage[i] / ((double) this.mBatteryFullChargeMah)) * 100.0d;
            goto L14
        L16:
            return percentage;
        L5:
            debugUsage = null;
            goto L6
        }

        private double sumPercentageOfTypes(double[] percentage, int types) {
            double result = 0.0d;
            int type = Integer.highestOneBit(types);
        L3:
            if (type == 0) goto L6;
            int index = Integer.numberOfTrailingZeros(type);
            result = result + percentage[index];
            types = types & (~type);
            type = Integer.highestOneBit(types);
            goto L3
        L6:
            return result;
        }

        private static String batteryUsageTypesToString(int types) {
            StringBuilder sb = new StringBuilder("[");
            boolean needDelimiter = false;
            int type = Integer.highestOneBit(types);
        L3:
            if (type == 0) goto L16;
            if (needDelimiter == false) goto L6;
            sb.append('|');
        L6:
            needDelimiter = true;
            switch(type) {
                case 1: goto L14;
                case 2: goto L13;
                case 4: goto L12;
                case 8: goto L11;
                case 16: goto L10;
                default: goto L9;
            };
        L10:
            sb.append("CACHED");
        L15:
            types = types & (~type);
            type = Integer.highestOneBit(types);
            goto L3
        L11:
            sb.append("FOREGROUND_SERVICE");
            goto L15
        L12:
            sb.append("BACKGROUND");
            goto L15
        L13:
            sb.append("FOREGROUND");
            goto L15
        L14:
            sb.append("UNSPECIFIED");
            goto L15
        L9:
            return "[UNKNOWN(" + Integer.toHexString(types) + ")]";
        L16:
            sb.append("]");
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        void handleUidBatteryUsage(int uid, ImmutableBatteryUsage usage) {
            int reason = shouldExemptUid(uid);
            if (reason == (-1)) goto L5;
            return;
        L5:
            char r8 = 0;
            char r9 = 0;
            double rbPercentage = sumPercentageOfTypes(usage.getPercentage(), this.mBgCurrentDrainRestrictedBucketTypes);
            double brPercentage = sumPercentageOfTypes(usage.getPercentage(), this.mBgCurrentDrainBgRestrictedTypes);
            Object r15 = this.mLock;
            monitor-enter(r15);
            int curLevel = ((AppBatteryTracker) this.mTracker).mAppRestrictionController.getRestrictionLevel(uid);     // Catch: Throwable -> L11
            if (curLevel < 50) goto L13;
            monitor-exit(r15);     // Catch: Throwable -> L11
            return;
        L13:
            long lastInteractionTime = this.mLastInteractionTime.get(uid, 0);     // Catch: Throwable -> L11
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
            int thresholdIndex = getCurrentDrainThresholdIndex(uid, now, this.mBgCurrentDrainWindowMs);     // Catch: Throwable -> L11
            int index = this.mHighBgBatteryPackages.indexOfKey(uid);     // Catch: Throwable -> L11
            boolean decoupleThresholds = this.mBgCurrentDrainDecoupleThresholds;     // Catch: Throwable -> L11
            double rbThreshold = this.mBgCurrentDrainRestrictedBucketThreshold[thresholdIndex];     // Catch: Throwable -> L11
            double brThreshold = this.mBgCurrentDrainBgRestrictedThreshold[thresholdIndex];     // Catch: Throwable -> L11
            if (index >= 0) goto L30;
            long[] ts = null;
            ImmutableBatteryUsage[] usages = null;
            if (rbPercentage < rbThreshold) goto L22;
            char r28 = 1;
            if (now <= (lastInteractionTime + this.mBgCurrentDrainInteractionGracePeriodMs)) goto L21;
            long[] ts2 = {now, 0};     // Catch: Throwable -> L11
            ImmutableBatteryUsage[] usages2 = new ImmutableBatteryUsage[2];     // Catch: Throwable -> L11
            usages2[0] = usage;     // Catch: Throwable -> L11
            this.mHighBgBatteryPackages.put(uid, Pair.create(ts2, usages2));     // Catch: Throwable -> L11
            r8 = 1;
            ts = ts2;
            usages = usages2;
        L21:
            r9 = 1;
        L23:
            if (decoupleThresholds == false) goto L55;
            if (brPercentage < brThreshold) goto L55;
            if (ts != null) goto L28;
            long[] ts3 = new long[2];     // Catch: Throwable -> L11
            ImmutableBatteryUsage[] usages3 = new ImmutableBatteryUsage[2];     // Catch: Throwable -> L11
            this.mHighBgBatteryPackages.put(uid, Pair.create(ts3, usages3));     // Catch: Throwable -> L11
            ts = ts3;
            usages = usages3;
        L28:
            ts[r28] = now;     // Catch: Throwable -> L11
            usages[r28] = usage;     // Catch: Throwable -> L11
            r9 = r28;
            r8 = r28;
        L55:
            monitor-exit(r15);     // Catch: Throwable -> L11
            if (r9 == 0) goto L63;
            if (r8 == 0) goto L64;
            ((AppBatteryTracker) this.mTracker).mAppRestrictionController.refreshAppRestrictionLevelForUid(uid, 1536, 2, r28);
            return;
        L64:
            return;
        L63:
            return;
        L22:
            decoupleThresholds = decoupleThresholds;
            r28 = 1;
            goto L23
        L30:
            r28 = 1;
            Pair<long[], ImmutableBatteryUsage[]> pair = this.mHighBgBatteryPackages.valueAt(index);     // Catch: Throwable -> L11
            long[] ts4 = (long[]) pair.first;     // Catch: Throwable -> L11
            long lastRestrictBucketTs = ts4[0];     // Catch: Throwable -> L11
            if (rbPercentage < rbThreshold) goto L39;
            long[] ts5 = ts4;
            long lastRestrictBucketTs2 = lastRestrictBucketTs;
            if (now > (lastInteractionTime + this.mBgCurrentDrainInteractionGracePeriodMs)) goto L35;
        L38:
            r9 = 1;
        L41:
            if (brPercentage < brThreshold) goto L54;
            if (decoupleThresholds == true) goto L49;
            if (curLevel == 40) goto L46;
        L48:
            char r4 = 0;
        L50:
            r8 = r4;
            if (r8 == 0) goto L53;
            ts5[1] = now;     // Catch: Throwable -> L11
            ((ImmutableBatteryUsage[]) pair.second)[1] = usage;     // Catch: Throwable -> L11
        L53:
            r9 = 1;
            goto L55
        L46:
            if (now <= (lastRestrictBucketTs2 + this.mBgCurrentDrainWindowMs)) goto L48;
        L49:
            r4 = 1;
            goto L50
        L54:
            ts5[1] = 0;     // Catch: Throwable -> L11
            ((ImmutableBatteryUsage[]) pair.second)[1] = null;     // Catch: Throwable -> L11
            goto L55
        L35:
            if (lastRestrictBucketTs2 != 0) goto L37;
            ts5[0] = now;     // Catch: Throwable -> L11
            ((ImmutableBatteryUsage[]) pair.second)[0] = usage;     // Catch: Throwable -> L11
        L37:
            r8 = 1;
            goto L38
        L39:
            ts5 = ts4;
            lastRestrictBucketTs2 = lastRestrictBucketTs;
        L11:
            th = move-exception;
            throw th;
        }

        private int getCurrentDrainThresholdIndex(int uid, long now, long window) {
            if (hasMediaPlayback(uid, now, window) == false) goto L5;
        L8:
            return 1;
        L5:
            if (hasLocation(uid, now, window) == true) goto L8;
            return 0;
        }

        private boolean hasMediaPlayback(int uid, long now, long window) {
            if (this.mBgCurrentDrainEventDurationBasedThresholdEnabled == false) goto L8;
            if (((AppBatteryTracker) this.mTracker).mAppRestrictionController.getCompositeMediaPlaybackDurations(uid, now, window) < this.mBgCurrentDrainMediaPlaybackMinDuration) goto L8;
            return true;
        L8:
            return false;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private boolean hasLocation(int uid, long now, long window) {
            if (this.mBgCurrentDrainHighThresholdByBgLocation == true) goto L6;
            return false;
        L6:
            if (((AppBatteryTracker) this.mTracker).mInjector.checkPermission("android.permission.ACCESS_BACKGROUND_LOCATION", -1, uid) != 0) goto L9;
            return true;
        L9:
            if (this.mBgCurrentDrainEventDurationBasedThresholdEnabled == true) goto L11;
            return false;
        L11:
            long since = Math.max(0, now - window);
            AppRestrictionController controller = ((AppBatteryTracker) this.mTracker).mAppRestrictionController;
            long locationDuration = controller.getForegroundServiceTotalDurationsSince(uid, since, now, 8);
            if (locationDuration >= this.mBgCurrentDrainLocationMinDuration) goto L14;
            return false;
        L14:
            return true;
        }

        void onUserInteractionStarted(String packageName, int uid) {
            boolean changed = false;
            Object r1 = this.mLock;
            monitor-enter(r1);
            this.mLastInteractionTime.put(uid, SystemClock.elapsedRealtime());     // Catch: Throwable -> L10
            int curLevel = ((AppBatteryTracker) this.mTracker).mAppRestrictionController.getRestrictionLevel(uid, packageName);     // Catch: Throwable -> L10
            if (curLevel == 50) goto L12;
            int index = this.mHighBgBatteryPackages.indexOfKey(uid);     // Catch: Throwable -> L10
            if (index < 0) goto L12;
            this.mHighBgBatteryPackages.removeAt(index);     // Catch: Throwable -> L10
            changed = true;
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L10
            if (changed == false) goto L20;
            ((AppBatteryTracker) this.mTracker).mAppRestrictionController.refreshAppRestrictionLevelForUid(uid, 768, 3, true);
            return;
        L20:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        void onBackgroundRestrictionChanged(int uid, String pkgName, boolean restricted) {
            if (restricted == false) goto L4;
            return;
        L4:
            Object r0 = this.mLock;
            monitor-enter(r0);
            Pair<long[], ImmutableBatteryUsage[]> pair = this.mHighBgBatteryPackages.get(uid);     // Catch: Throwable -> L9
            if (pair == null) goto L11;
            ((long[]) pair.first)[1] = 0;     // Catch: Throwable -> L9
            ((ImmutableBatteryUsage[]) pair.second)[1] = null;     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        void reset() {
            this.mHighBgBatteryPackages.clear();
            this.mLastInteractionTime.clear();
            ((AppBatteryTracker) this.mTracker).reset();
        }

        void onUserRemovedLocked(int userId) {
            int i = this.mHighBgBatteryPackages.size() - 1;
        L3:
            if (i < 0) goto L8;
            if (UserHandle.getUserId(this.mHighBgBatteryPackages.keyAt(i)) != userId) goto L7;
            this.mHighBgBatteryPackages.removeAt(i);
        L7:
            i = i - 1;
            goto L3
        L8:
            int i2 = this.mLastInteractionTime.size() - 1;
        L9:
            if (i2 < 0) goto L15;
            if (UserHandle.getUserId(this.mLastInteractionTime.keyAt(i2)) != userId) goto L13;
            this.mLastInteractionTime.removeAt(i2);
        L13:
            i2 = i2 - 1;
            goto L9
        }

        void onUidRemovedLocked(int uid) {
            this.mHighBgBatteryPackages.remove(uid);
            this.mLastInteractionTime.delete(uid);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            AppBatteryPolicy r1 = this;
            pw.print(prefix);
            pw.println("APP BATTERY TRACKER POLICY SETTINGS:");
            String prefix2 = "  " + prefix;
            super.dump(pw, prefix2);
            if (r1.isEnabled() == false) goto L21;
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_RESTRICTED_BUCKET);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainRestrictedBucketThreshold[0]);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_RESTRICTED_BUCKET);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainRestrictedBucketThreshold[1]);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_THRESHOLD_TO_BG_RESTRICTED);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainBgRestrictedThreshold[0]);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_TO_BG_RESTRICTED);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainBgRestrictedThreshold[1]);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_WINDOW);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainWindowMs);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_INTERACTION_GRACE_PERIOD);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainInteractionGracePeriodMs);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_MEDIA_PLAYBACK_MIN_DURATION);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainMediaPlaybackMinDuration);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_LOCATION_MIN_DURATION);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainLocationMinDuration);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_EVENT_DURATION_BASED_THRESHOLD_ENABLED);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainEventDurationBasedThresholdEnabled);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_AUTO_RESTRICT_ABUSIVE_APPS_ENABLED);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainAutoRestrictAbusiveAppsEnabled);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_TYPES_TO_RESTRICTED_BUCKET);
            pw.print('=');
            pw.println(batteryUsageTypesToString(r1.mBgCurrentDrainRestrictedBucketTypes));
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_TYPES_TO_BG_RESTRICTED);
            pw.print('=');
            pw.println(batteryUsageTypesToString(r1.mBgCurrentDrainBgRestrictedTypes));
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_POWER_COMPONENTS);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainPowerComponents);
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_EXEMPTED_TYPES);
            pw.print('=');
            pw.println(BaseAppStateTracker.stateTypesToString(r1.mBgCurrentDrainExemptedTypes));
            pw.print(prefix2);
            pw.print(KEY_BG_CURRENT_DRAIN_HIGH_THRESHOLD_BY_BG_LOCATION);
            pw.print('=');
            pw.println(r1.mBgCurrentDrainHighThresholdByBgLocation);
            pw.print(prefix2);
            pw.print("Full charge capacity=");
            pw.print(r1.mBatteryFullChargeMah);
            pw.println(" mAh");
            pw.print(prefix2);
            pw.println("Excessive current drain detected:");
            Object r11 = r1.mLock;
            monitor-enter(r11);
            int size = r1.mHighBgBatteryPackages.size();     // Catch: Throwable -> L18
            String prefix3 = "  " + prefix2;     // Catch: Throwable -> L18
            if (size <= 0) goto L15;
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
            int i = 0;
        L10:
            if (i >= size) goto L16;
            int uid = r1.mHighBgBatteryPackages.keyAt(i);     // Catch: Throwable -> L12
            Pair<long[], ImmutableBatteryUsage[]> pair = r1.mHighBgBatteryPackages.valueAt(i);     // Catch: Throwable -> L12
            long[] ts = (long[]) pair.first;     // Catch: Throwable -> L12
            ImmutableBatteryUsage[] usages = (ImmutableBatteryUsage[]) pair.second;     // Catch: Throwable -> L12
            long now2 = now;
            int thresholdIndex = r1.getCurrentDrainThresholdIndex(uid, now2, r1.mBgCurrentDrainWindowMs);     // Catch: Throwable -> L12
            pw.format("%s%s: (threshold=%4.2f%%/%4.2f%%) %s / %s\n", new Object[]{prefix3, UserHandle.formatUid(uid), Float.valueOf(r1.mBgCurrentDrainRestrictedBucketThreshold[thresholdIndex]), Float.valueOf(r1.mBgCurrentDrainBgRestrictedThreshold[thresholdIndex]), r1.formatHighBgBatteryRecord(ts[0], now2, usages[0]), formatHighBgBatteryRecord(ts[1], now2, usages[1])});     // Catch: Throwable -> L12
            i = i + 1;     // Catch: Throwable -> L12
            r1 = this;
            now = now2;
        L16:
            monitor-exit(r11);     // Catch: Throwable -> L12
            return;
        L15:
            pw.print(prefix3);     // Catch: Throwable -> L12
            pw.println("(none)");     // Catch: Throwable -> L12
        L12:
            th = th;
        L19:
            monitor-exit(r11);     // Catch: Throwable -> L18
            throw th;
        L18:
            th = th;
            goto L19
        }

        private String formatHighBgBatteryRecord(long ts, long now, ImmutableBatteryUsage usage) {
            if (ts <= 0) goto L7;
            if (usage != null) goto L6;
            return "0";
        L6:
            return String.format("%s %s (%s)", new Object[]{TimeUtils.formatTime(ts, now), usage.toString(), usage.percentageToString()});
        L7:
            return "0";
        }
    }

    static class BatteryUsage {
        static final int BATTERY_USAGE_COUNT = 5;
        static final int BATTERY_USAGE_INDEX_BACKGROUND = 2;
        static final int BATTERY_USAGE_INDEX_CACHED = 4;
        static final int BATTERY_USAGE_INDEX_FOREGROUND = 1;
        static final int BATTERY_USAGE_INDEX_FOREGROUND_SERVICE = 3;
        static final int BATTERY_USAGE_INDEX_UNSPECIFIED = 0;
        static final BatteryConsumer.Dimensions[] BATT_DIMENS = null;
        double[] mPercentage;
        double[] mUsage;

        static {
            BATT_DIMENS = new BatteryConsumer.Dimensions[]{new BatteryConsumer.Dimensions(-1, 0), new BatteryConsumer.Dimensions(-1, 1), new BatteryConsumer.Dimensions(-1, 2), new BatteryConsumer.Dimensions(-1, 3), new BatteryConsumer.Dimensions(-1, 4)};
        }

        BatteryUsage() {
            this(0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        }

        BatteryUsage(double unspecifiedUsage, double fgUsage, double bgUsage, double fgsUsage, double cachedUsage) {
            this.mUsage = new double[]{unspecifiedUsage, fgUsage, bgUsage, fgsUsage, cachedUsage};
        }

        BatteryUsage(double[] usage) {
            this.mUsage = usage;
        }

        BatteryUsage(BatteryUsage other, double scale) {
            this(other);
            scaleInternal(scale);
        }

        BatteryUsage(BatteryUsage other) {
            this.mUsage = new double[other.mUsage.length];
            setToInternal(other);
        }

        BatteryUsage(UidBatteryConsumer consumer, AppBatteryPolicy policy) {
            BatteryConsumer.Dimensions[] dims = policy.mBatteryDimensions;
            this.mUsage = new double[]{getConsumedPowerNoThrow(consumer, dims[0]), getConsumedPowerNoThrow(consumer, dims[1]), getConsumedPowerNoThrow(consumer, dims[2]), getConsumedPowerNoThrow(consumer, dims[3]), getConsumedPowerNoThrow(consumer, dims[4])};
        }

        BatteryUsage setTo(BatteryUsage other) {
            return setToInternal(other);
        }

        private BatteryUsage setToInternal(BatteryUsage other) {
            System.arraycopy(other.mUsage, 0, this.mUsage, 0, other.mUsage.length);
            if (other.mPercentage == null) goto L5;
            this.mPercentage = new double[other.mPercentage.length];
            System.arraycopy(other.mPercentage, 0, this.mPercentage, 0, other.mPercentage.length);
        L6:
            return this;
        L5:
            this.mPercentage = null;
            goto L6
        }

        BatteryUsage add(BatteryUsage other) {
            int i = 0;
        L4:
            if (i >= other.mUsage.length) goto L7;
            double[] r1 = this.mUsage;
            r1[i] = r1[i] + other.mUsage[i];
            i = i + 1;
            goto L4
        L7:
            return this;
        }

        BatteryUsage subtract(BatteryUsage other) {
            int i = 0;
        L4:
            if (i >= other.mUsage.length) goto L7;
            this.mUsage[i] = Math.max(0.0d, this.mUsage[i] - other.mUsage[i]);
            i = i + 1;
            goto L4
        L7:
            return this;
        }

        BatteryUsage scale(double scale) {
            return scaleInternal(scale);
        }

        private BatteryUsage scaleInternal(double scale) {
            int i = 0;
        L4:
            if (i >= this.mUsage.length) goto L7;
            double[] r1 = this.mUsage;
            r1[i] = r1[i] * scale;
            i = i + 1;
            goto L4
        L7:
            return this;
        }

        ImmutableBatteryUsage unmutate() {
            return new ImmutableBatteryUsage(this);
        }

        BatteryUsage calcPercentage(int uid, AppBatteryPolicy policy) {
            if (this.mPercentage != null) goto L5;
        L6:
            this.mPercentage = new double[this.mUsage.length];
        L7:
            policy.calcPercentage(uid, this.mUsage, this.mPercentage);
            return this;
        L5:
            if (this.mPercentage.length == this.mUsage.length) goto L7;
            goto L6
        }

        BatteryUsage setPercentage(double[] percentage) {
            this.mPercentage = percentage;
            return this;
        }

        double[] getPercentage() {
            return this.mPercentage;
        }

        String percentageToString() {
            return formatBatteryUsagePercentage(this.mPercentage);
        }

        public String toString() {
            return formatBatteryUsage(this.mUsage);
        }

        double getUsagePowerMah(int processState) {
            switch(processState) {
                case 1: goto L12;
                case 2: goto L10;
                case 3: goto L8;
                case 4: goto L6;
                default: goto L3;
            };
        L3:
            return 0.0d;
        L6:
            return this.mUsage[4];
        L8:
            return this.mUsage[3];
        L10:
            return this.mUsage[2];
        L12:
            return this.mUsage[1];
        }

        boolean isValid() {
            int i = 0;
        L4:
            if (i >= this.mUsage.length) goto L10;
            if (this.mUsage[i] < 0.0d) goto L7;
            i = i + 1;
            goto L4
        L7:
            return false;
        L10:
            return true;
        }

        boolean isEmpty() {
            int i = 0;
        L4:
            if (i >= this.mUsage.length) goto L10;
            if (this.mUsage[i] > 0.0d) goto L7;
            i = i + 1;
            goto L4
        L7:
            return false;
        L10:
            return true;
        }

        public boolean equals(Object other) {
            if (other != null) goto L5;
            return false;
        L5:
            BatteryUsage otherUsage = (BatteryUsage) other;
            int i = 0;
        L7:
            if (i >= this.mUsage.length) goto L12;
            if (Double.compare(this.mUsage[i], otherUsage.mUsage[i]) != 0) goto L10;
            i = i + 1;
            goto L7
        L10:
            return false;
        L12:
            return true;
        }

        public int hashCode() {
            int hashCode = 0;
            int i = 0;
        L4:
            if (i >= this.mUsage.length) goto L7;
            hashCode = Double.hashCode(this.mUsage[i]) + (hashCode * 31);
            i = i + 1;
            goto L4
        L7:
            return hashCode;
        }

        private static String formatBatteryUsage(double[] usage) {
            return String.format("%.3f %.3f %.3f %.3f %.3f mAh", new Object[]{Double.valueOf(usage[0]), Double.valueOf(usage[1]), Double.valueOf(usage[2]), Double.valueOf(usage[3]), Double.valueOf(usage[4])});
        }

        static String formatBatteryUsagePercentage(double[] percentage) {
            return String.format("%4.2f%% %4.2f%% %4.2f%% %4.2f%% %4.2f%%", new Object[]{Double.valueOf(percentage[0]), Double.valueOf(percentage[1]), Double.valueOf(percentage[2]), Double.valueOf(percentage[3]), Double.valueOf(percentage[4])});
        }

        private static double getConsumedPowerNoThrow(UidBatteryConsumer uidConsumer, BatteryConsumer.Dimensions dimens) {
            return uidConsumer.getConsumedPower(dimens);
        L5:
            return 0.0d;
        }
    }

    static final class ImmutableBatteryUsage extends BatteryUsage {
        ImmutableBatteryUsage() {
        }

        ImmutableBatteryUsage(double unspecifiedUsage, double fgUsage, double bgUsage, double fgsUsage, double cachedUsage) {
            super(unspecifiedUsage, fgUsage, bgUsage, fgsUsage, cachedUsage);
        }

        ImmutableBatteryUsage(double[] usage) {
            super(usage);
        }

        ImmutableBatteryUsage(BatteryUsage other, double scale) {
            super(other, scale);
        }

        ImmutableBatteryUsage(BatteryUsage other) {
            super(other);
        }

        ImmutableBatteryUsage(UidBatteryConsumer consumer, AppBatteryPolicy policy) {
            super(consumer, policy);
        }

        @Override // com.android.server.am.AppBatteryTracker.BatteryUsage
        BatteryUsage setTo(BatteryUsage other) {
            throw new RuntimeException("Readonly");
        }

        @Override // com.android.server.am.AppBatteryTracker.BatteryUsage
        BatteryUsage add(BatteryUsage other) {
            throw new RuntimeException("Readonly");
        }

        @Override // com.android.server.am.AppBatteryTracker.BatteryUsage
        BatteryUsage subtract(BatteryUsage other) {
            throw new RuntimeException("Readonly");
        }

        @Override // com.android.server.am.AppBatteryTracker.BatteryUsage
        BatteryUsage scale(double scale) {
            throw new RuntimeException("Readonly");
        }

        @Override // com.android.server.am.AppBatteryTracker.BatteryUsage
        BatteryUsage setPercentage(double[] percentage) {
            throw new RuntimeException("Readonly");
        }

        BatteryUsage mutate() {
            return new BatteryUsage(this);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$GVjH5JD3sTOwGKB6DypsoPOGbCs(CountDownLatch r0) {
        return lambda$dump$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$Lvw7zZMxSUr0N2eHhDJL56S52v0(AppBatteryTracker r0) {
        r0.updateBatteryUsageStatsAndCheck();
    }

    /* JADX INFO: renamed from: $r8$lambda$P-Ua0UoczzrCFByY9q-jpnqiqVk, reason: not valid java name */
    public static /* synthetic */ void m1285$r8$lambda$PUa0UoczzrCFByY9qjpnqiqVk(AppBatteryTracker r0) {
        r0.checkBatteryUsageStats();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDebugUidPercentages, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m1286$$Nest$fgetmDebugUidPercentages(AppBatteryTracker r0) {
        return r0.mDebugUidPercentages;
    }

    /* JADX INFO: renamed from: -$$Nest$monCurrentDrainMonitorEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1287$$Nest$monCurrentDrainMonitorEnabled(AppBatteryTracker r0, boolean r1) {
        r0.onCurrentDrainMonitorEnabled(r1);
    }

    static {
        BATTERY_USAGE_NONE = new ImmutableBatteryUsage();
    }

    AppBatteryTracker(Context context, AppRestrictionController controller) {
        this(context, controller, null, null);
    }

    AppBatteryTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<AppBatteryPolicy>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mBgBatteryUsageStatsPolling = new AppBatteryTracker$$ExternalSyntheticLambda0(this);
        this.mBgBatteryUsageStatsCheck = new AppBatteryTracker$$ExternalSyntheticLambda1(this);
        this.mActiveUserIdStates = new SparseBooleanArray();
        this.mUidBatteryUsage = new SparseArray();
        this.mUidBatteryUsageInWindow = new SparseArray();
        this.mLastUidBatteryUsage = new SparseArray();
        this.mTmpUidBatteryUsage = new SparseArray();
        this.mTmpUidBatteryUsage2 = new SparseArray();
        this.mTmpUidBatteryUsageInWindow = new SparseArray();
        this.mTmpUserIds = new ArraySet();
        this.mLastReportTime = 0;
        this.mDebugUidPercentages = new SparseArray();
        if (injector != null) goto L5;
        this.mBatteryUsageStatsPollingIntervalMs = 1800000;
        this.mBatteryUsageStatsPollingMinIntervalMs = 300000;
    L6:
        this.mInjector.setPolicy(new AppBatteryPolicy(this.mInjector, this));
        return;
    L5:
        this.mBatteryUsageStatsPollingIntervalMs = ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME;
        this.mBatteryUsageStatsPollingMinIntervalMs = ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME;
        goto L6
    }

    @Override // com.android.server.am.BaseAppStateTracker
    int getType() {
        return 1;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onSystemReady() {
        super.onSystemReady();
        UserManagerInternal um = this.mInjector.getUserManagerInternal();
        int[] userIds = um.getUserIds();
        int r2 = userIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L15;
        int userId = userIds[r3];
        if (um.isUserRunning(userId) == false) goto L14;
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mActiveUserIdStates.put(userId, true);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        r3 = r3 + 1;
        goto L3
    L15:
        scheduleBatteryUsageStatsUpdateIfNecessary(this.mBatteryUsageStatsPollingIntervalMs);
    }

    private void scheduleBatteryUsageStatsUpdateIfNecessary(long delay) {
        if (((AppBatteryPolicy) this.mInjector.getPolicy()).isEnabled() == false) goto L15;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mBgHandler.hasCallbacks(this.mBgBatteryUsageStatsPolling) == true) goto L11;
        this.mBgHandler.postDelayed(this.mBgBatteryUsageStatsPolling, delay);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        logAppBatteryTrackerIfNeeded();
        return;
    }

    private void logAppBatteryTrackerIfNeeded() {
        long now = SystemClock.elapsedRealtime();
        Object r4 = this.mLock;
        monitor-enter(r4);
        AppBatteryPolicy bgPolicy = (AppBatteryPolicy) this.mInjector.getPolicy();     // Catch: Throwable -> L8
        if ((now - this.mLastReportTime) >= bgPolicy.mBgCurrentDrainWindowMs) goto L10;
        monitor-exit(r4);     // Catch: Throwable -> L8
        return;
    L10:
        this.mLastReportTime = now;     // Catch: Throwable -> L8
        monitor-exit(r4);     // Catch: Throwable -> L8
        updateBatteryUsageStatsIfNecessary(this.mInjector.currentTimeMillis(), true);
        Object r5 = this.mLock;
        monitor-enter(r5);
        int i = 0;
        int size = this.mUidBatteryUsageInWindow.size();     // Catch: Throwable -> L22
    L16:
        if (i >= size) goto L30;
        int uid = this.mUidBatteryUsageInWindow.keyAt(i);     // Catch: Throwable -> L22
        if (UserHandle.isCore(uid) == true) goto L25;
        if (UserHandle.isApp(uid) == true) goto L25;
    L28:
        i = i + 1;     // Catch: Throwable -> L22
    L25:
        if (BATTERY_USAGE_NONE.equals(this.mUidBatteryUsageInWindow.valueAt(i)) == true) goto L28;
        FrameworkStatsLog.write(FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO, uid, 0, 0, 0, null, getTrackerInfoForStatsd(uid), null, null, 0, 0, 0, ActivityManager.isLowRamDeviceStatic(), 0);     // Catch: Throwable -> L22
        goto L28
    L30:
        monitor-exit(r5);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    byte[] getTrackerInfoForStatsd(int uid) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        ImmutableBatteryUsage temp = this.mUidBatteryUsageInWindow.get(uid);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        if (temp != null) goto L9;
        return null;
    L9:
        BatteryUsage bgUsage = temp.calcPercentage(uid, (AppBatteryPolicy) this.mInjector.getPolicy());
        double allUsage = (((bgUsage.mPercentage[0] + bgUsage.mPercentage[1]) + bgUsage.mPercentage[2]) + bgUsage.mPercentage[3]) + bgUsage.mPercentage[4];
        double usageBackground = bgUsage.mPercentage[2];
        double usageFgs = bgUsage.mPercentage[3];
        double usageForeground = bgUsage.mPercentage[1];
        double usageCached = bgUsage.mPercentage[4];
        ProtoOutputStream proto = new ProtoOutputStream();
        proto.write(1120986464257L, allUsage * 10000.0d);
        proto.write(1120986464258L, usageBackground * 10000.0d);
        proto.write(1120986464259L, usageFgs * 10000.0d);
        proto.write(1120986464260L, usageForeground * 10000.0d);
        proto.write(1120986464261L, usageCached * 10000.0d);
        proto.flush();
        return proto.getBytes();
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUserStarted(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActiveUserIdStates.put(userId, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUserStopped(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActiveUserIdStates.put(userId, false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActiveUserIdStates.delete(userId);     // Catch: Throwable -> L9
        int i = this.mUidBatteryUsage.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L12;
        if (UserHandle.getUserId(this.mUidBatteryUsage.keyAt(i)) != userId) goto L11;
        this.mUidBatteryUsage.removeAt(i);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        int i2 = this.mUidBatteryUsageInWindow.size() - 1;     // Catch: Throwable -> L9
    L13:
        if (i2 < 0) goto L18;
        if (UserHandle.getUserId(this.mUidBatteryUsageInWindow.keyAt(i2)) != userId) goto L17;
        this.mUidBatteryUsageInWindow.removeAt(i2);     // Catch: Throwable -> L9
    L17:
        i2 = i2 - 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        ((AppBatteryPolicy) this.mInjector.getPolicy()).onUserRemovedLocked(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUidRemoved(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidBatteryUsage.delete(uid);     // Catch: Throwable -> L7
        this.mUidBatteryUsageInWindow.delete(uid);     // Catch: Throwable -> L7
        ((AppBatteryPolicy) this.mInjector.getPolicy()).onUidRemovedLocked(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUserInteractionStarted(String packageName, int uid) {
        ((AppBatteryPolicy) this.mInjector.getPolicy()).onUserInteractionStarted(packageName, uid);
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onBackgroundRestrictionChanged(int uid, String pkgName, boolean restricted) {
        ((AppBatteryPolicy) this.mInjector.getPolicy()).onBackgroundRestrictionChanged(uid, pkgName, restricted);
    }

    @Override // com.android.server.am.AppRestrictionController.UidBatteryUsageProvider
    public ImmutableBatteryUsage getUidBatteryUsage(int uid) {
        long now = this.mInjector.currentTimeMillis();
        boolean updated = updateBatteryUsageStatsIfNecessary(now, false);
        Object r3 = this.mLock;
        monitor-enter(r3);
        if (updated == true) goto L16;
    L8:
        BatteryUsage usage = this.mUidBatteryUsage.get(uid);     // Catch: Throwable -> L6
        if (usage == null) goto L11;
        ImmutableBatteryUsage r5 = new ImmutableBatteryUsage(usage);     // Catch: Throwable -> L6
    L12:
        monitor-exit(r3);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        throw th;
    L11:
        r5 = BATTERY_USAGE_NONE;     // Catch: Throwable -> L6
        goto L12
    L16:
        this.mBgHandler.removeCallbacks(this.mBgBatteryUsageStatsPolling);     // Catch: Throwable -> L6
        scheduleBgBatteryUsageStatsCheck();     // Catch: Throwable -> L6
        goto L8
    }

    private void scheduleBgBatteryUsageStatsCheck() {
        if (this.mBgHandler.hasCallbacks(this.mBgBatteryUsageStatsCheck) == true) goto L6;
        this.mBgHandler.post(this.mBgBatteryUsageStatsCheck);
        return;
    }

    private void updateBatteryUsageStatsAndCheck() {
        long now = this.mInjector.currentTimeMillis();
        if (updateBatteryUsageStatsIfNecessary(now, false) == false) goto L5;
        checkBatteryUsageStats();
        return;
    L5:
        Object r2 = this.mLock;
        monitor-enter(r2);
        scheduleBatteryUsageStatsUpdateIfNecessary((this.mLastBatteryUsageSamplingTs + this.mBatteryUsageStatsPollingMinIntervalMs) - now);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void checkBatteryUsageStats() {
        long now = SystemClock.elapsedRealtime();
        AppBatteryPolicy bgPolicy = (AppBatteryPolicy) this.mInjector.getPolicy();
        SparseArray<ImmutableBatteryUsage> uidConsumers = this.mTmpUidBatteryUsageInWindow;     // Catch: Throwable -> L10
        Object r1 = this.mLock;     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        copyUidBatteryUsage(this.mUidBatteryUsageInWindow, uidConsumers);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        long since = Math.max(0, now - bgPolicy.mBgCurrentDrainWindowMs);     // Catch: Throwable -> L10
        int size = uidConsumers.size();     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= size) goto L12;
        int uid = uidConsumers.keyAt(i);     // Catch: Throwable -> L10
        ImmutableBatteryUsage actualUsage = uidConsumers.valueAt(i);     // Catch: Throwable -> L10
        ImmutableBatteryUsage exemptedUsage = this.mAppRestrictionController.getUidBatteryExemptedUsageSince(uid, since, now, bgPolicy.mBgCurrentDrainExemptedTypes);     // Catch: Throwable -> L10
        ImmutableBatteryUsage bgUsage = actualUsage.mutate().subtract(exemptedUsage).calcPercentage(uid, bgPolicy).unmutate();     // Catch: Throwable -> L10
        bgPolicy.handleUidBatteryUsage(uid, bgUsage);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        int i2 = 0;
        int size2 = this.mDebugUidPercentages.size();     // Catch: Throwable -> L10
    L13:
        if (i2 >= size2) goto L16;
        bgPolicy.handleUidBatteryUsage(this.mDebugUidPercentages.keyAt(i2), this.mDebugUidPercentages.valueAt(i2));     // Catch: Throwable -> L10
        i2 = i2 + 1;
        goto L13
    L16:
        scheduleBatteryUsageStatsUpdateIfNecessary(this.mBatteryUsageStatsPollingIntervalMs);
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        scheduleBatteryUsageStatsUpdateIfNecessary(this.mBatteryUsageStatsPollingIntervalMs);
        throw th;
    }

    private boolean updateBatteryUsageStatsIfNecessary(long now, boolean forceUpdate) {
        boolean needUpdate = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((this.mLastBatteryUsageSamplingTs + this.mBatteryUsageStatsPollingMinIntervalMs) < now) goto L13;
        if (forceUpdate == true) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        return false;
    L13:
        if (this.mBatteryUsageStatsUpdatePending == false) goto L19;
        this.mLock.wait();     // Catch: Throwable -> L10 InterruptedException -> L16
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (needUpdate == false) goto L31;
        updateBatteryUsageStatsOnce(now);
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mLastBatteryUsageSamplingTs = now;     // Catch: Throwable -> L28
        this.mBatteryUsageStatsUpdatePending = false;     // Catch: Throwable -> L28
        this.mLock.notifyAll();     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        return true;
    L19:
        this.mBatteryUsageStatsUpdatePending = true;     // Catch: Throwable -> L10
        needUpdate = true;
        goto L21
    }

    private void updateBatteryUsageStatsOnce(long r31) {
        AppBatteryPolicy r8 = (AppBatteryPolicy) this.mInjector.getPolicy();
        ArraySet<UserHandle> r6 = this.mTmpUserIds;
        SparseArray<BatteryUsage> r4 = this.mTmpUidBatteryUsage;
        BatteryStatsInternal r7 = this.mInjector.getBatteryStatsInternal();
        long r9 = r8.mBgCurrentDrainWindowMs;
        r4.clear();
        r6.clear();
        Object r2 = this.mLock;
        monitor-enter(r2);
        int r0 = this.mActiveUserIdStates.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (r0 < 0) goto L13;
        r6.add(UserHandle.of(this.mActiveUserIdStates.keyAt(r0)));     // Catch: Throwable -> L9
        if (this.mActiveUserIdStates.valueAt(r0) == true) goto L11;
        this.mActiveUserIdStates.removeAt(r0);     // Catch: Throwable -> L9
    L11:
        r0 = r0 - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L9
        BatteryUsageStatsQuery.Builder r5 = new BatteryUsageStatsQuery.Builder().includeProcessStateData().setMaxStatsAgeMs(0);
        BatteryUsageStats r13 = updateBatteryUsageStatsOnceInternal(0, r4, r5, r6, r7);
        if (r13 == null) goto L17;
        long r3 = r13.getStatsStartTimestamp();
    L18:
        long r14 = r3;
        if (r13 == null) goto L21;
        long r10 = r13.getStatsEndTimestamp();
    L22:
        long r11 = r10 - r14;
        boolean r18 = true;
        if (r11 < r9) goto L38;
        Object r12 = this.mLock;
        monitor-enter(r12);
        copyUidBatteryUsage(r4, this.mUidBatteryUsageInWindow, (r9 * 1.0d) / r11);     // Catch: Throwable -> L31
        monitor-exit(r12);     // Catch: Throwable -> L31
        r18 = false;
    L31:
        th = th;
    L35:
        monitor-exit(r12);     // Catch: Throwable -> L31
        throw th;
    L33:
        th = th;
    L38:
        this.mTmpUidBatteryUsage2.clear();
        copyUidBatteryUsage(r4, this.mTmpUidBatteryUsage2);
        Object r15 = this.mLock;
        monitor-enter(r15);
        long r16 = this.mLastUidBatteryUsageStartTs;     // Catch: Throwable -> L121
        this.mLastUidBatteryUsageStartTs = r14;     // Catch: Throwable -> L121
        monitor-exit(r15);     // Catch: Throwable -> L121
        if (r14 > r16) goto L46;
    L56:
        long r21 = r16;
        ArraySet<UserHandle> r17 = r6;
        BatteryUsageStatsQuery.Builder r19 = r5;
        long r110 = r11;
        Object r20 = r15;
    L57:
        if (r18 == true) goto L59;
    L73:
        boolean r111 = r18;
    L74:
        Object r22 = this.mLock;
        monitor-enter(r22);
        int r1 = 0;
        int r23 = r4.size();     // Catch: Throwable -> L118
    L78:
        if (r1 >= r23) goto L94;
        int r24 = r4.keyAt(r1);     // Catch: Throwable -> L92
        int r112 = r23;
        int r25 = this.mUidBatteryUsage.indexOfKey(r24);     // Catch: Throwable -> L92
        ArraySet<UserHandle> r26 = r17;
        BatteryStatsInternal r27 = r7;
        ImmutableBatteryUsage r28 = this.mLastUidBatteryUsage.get(r24, BATTERY_USAGE_NONE);     // Catch: Throwable -> L86
        BatteryUsage r29 = r4.valueAt(r1);     // Catch: Throwable -> L86
        if (r25 < 0) goto L88;
        BatteryUsage r30 = this.mUidBatteryUsage.valueAt(r25);     // Catch: Throwable -> L86
        ImmutableBatteryUsage r210 = BATTERY_USAGE_NONE;     // Catch: Throwable -> L86
        r30.subtract(r28).add(r29);     // Catch: Throwable -> L86
    L89:
        r1 = r1 + 1;
        r23 = r112;
        r17 = r26;
        r7 = r27;
        goto L78
    L88:
        ImmutableBatteryUsage r32 = BATTERY_USAGE_NONE;     // Catch: Throwable -> L86
        this.mUidBatteryUsage.put(r24, r29);     // Catch: Throwable -> L86
    L86:
        th = th;
    L119:
        monitor-exit(r22);     // Catch: Throwable -> L118
    L118:
        th = th;
        goto L119
    L120:
        throw th;
    L90:
        th = th;
    L92:
        th = th;
        goto L119
    L94:
        ArraySet<UserHandle> r211 = r17;
        BatteryStatsInternal r212 = r7;
        copyUidBatteryUsage(this.mTmpUidBatteryUsage2, this.mLastUidBatteryUsage);     // Catch: Throwable -> L116
        monitor-exit(r22);     // Catch: Throwable -> L116
        this.mTmpUidBatteryUsage2.clear();
        if (r111 == false) goto L138;
        long r33 = r31 - r9;
        long r34 = r21 - 1;
        updateBatteryUsageStatsOnceInternal(r34 - r33, r4, new BatteryUsageStatsQuery.Builder().includeProcessStateData().aggregateSnapshots(r33, r34), r211, r212);
        Object r35 = this.mLock;
        monitor-enter(r35);
        copyUidBatteryUsage(r4, this.mUidBatteryUsageInWindow);     // Catch: Throwable -> L104
        monitor-exit(r35);     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        throw th;
    L138:
        if (r13 == null) goto L112;
        r13.close();     // Catch: IOException -> L110
    L137:
        return;
    L112:
        Slog.w(TAG, "Stat was null");     // Catch: IOException -> L110
    L114:
        Slog.w(TAG, "Failed to close a stat");
        return;
    L116:
        th = th;
        goto L119
    L157:
        th = th;
        goto L119
    L59:
        if (r110 < r9) goto L73;
        Object r36 = this.mLock;
        monitor-enter(r36);
        copyUidBatteryUsage(r4, this.mUidBatteryUsageInWindow, (r9 * 1.0d) / r110);     // Catch: Throwable -> L67
        monitor-exit(r36);     // Catch: Throwable -> L67
        r111 = false;
    L67:
        th = th;
        Object r37 = r20;
    L71:
        monitor-exit(r37);     // Catch: Throwable -> L67
        throw th;
    L69:
        th = th;
        r37 = r36;
        goto L71
    L46:
        if (r16 <= 0) goto L56;
        BatteryUsageStatsQuery.Builder r38 = new BatteryUsageStatsQuery.Builder().includeProcessStateData().aggregateSnapshots(r16, r14);
        r21 = r16;
        r17 = r6;
        BatteryUsageStats r39 = updateBatteryUsageStatsOnceInternal(0, r4, r38, r17, r7);
        r110 = r11 + (r14 - r21);
        if (r39 == null) goto L52;
        r39.close();     // Catch: IOException -> L50
    L152:
    L55:
        r19 = r38;
        r20 = r38;
        goto L57
    L52:
        Slog.w(TAG, "Stat was null");     // Catch: IOException -> L50
    L54:
        Slog.w(TAG, "Failed to close a stat");
    L121:
        th = th;
    L148:
        throw th;
    L125:
        th = th;
        goto L148
    L21:
        r10 = r31;
        goto L22
    L17:
        r3 = 0;
    L9:
        th = move-exception;
        throw th;
    }

    private BatteryUsageStats updateBatteryUsageStatsOnceInternal(long expectedDuration, SparseArray<BatteryUsage> buf, BatteryUsageStatsQuery.Builder builder, ArraySet<UserHandle> userIds, BatteryStatsInternal batteryStatsInternal) {
        int i = 0;
        int size = userIds.size();
    L3:
        if (i >= size) goto L5;
        builder.addUser(userIds.valueAt(i));
        i = i + 1;
        goto L3
    L5:
        List<BatteryUsageStats> statsList = batteryStatsInternal.getBatteryUsageStats(Arrays.asList(new BatteryUsageStatsQuery[]{builder.build()}));
        if (ArrayUtils.isEmpty(statsList) == false) goto L9;
        return null;
    L9:
        BatteryUsageStats stats = statsList.get(0);
        int i2 = 1;
    L11:
        if (i2 >= statsList.size()) goto L21;
        if (statsList.get(i2) == null) goto L17;
        statsList.get(i2).close();     // Catch: IOException -> L15
    L20:
        i2 = i2 + 1;
        goto L11
    L17:
        Slog.w(TAG, "Stat was null");     // Catch: IOException -> L15
    L19:
        Slog.w(TAG, "Failed to close a stat in BatteryUsageStats List");
        goto L20
    L21:
        List<UidBatteryConsumer> uidConsumers = stats.getUidBatteryConsumers();
        if (uidConsumers == null) goto L44;
        long start = stats.getStatsStartTimestamp();
        long end = stats.getStatsEndTimestamp();
        if (expectedDuration <= 0) goto L26;
        double scale = Math.min((expectedDuration * 1.0d) / (end - start), 1.0d);
    L27:
        AppBatteryPolicy bgPolicy = (AppBatteryPolicy) this.mInjector.getPolicy();
        Iterator r4 = uidConsumers.iterator();
    L29:
        if (r4.hasNext() == false) goto L44;
        UidBatteryConsumer uidConsumer = (UidBatteryConsumer) r4.next();
        int rawUid = uidConsumer.getUid();
        if (UserHandle.isIsolated(rawUid) == true) goto L29;
        int sharedAppId = UserHandle.getAppIdFromSharedAppGid(rawUid);
        if (sharedAppId <= 0) goto L36;
        int uid = UserHandle.getUid(0, sharedAppId);
        int uid2 = uid;
    L37:
        BatteryUsage bgUsage = new BatteryUsage(uidConsumer, bgPolicy).scale(scale);
        AppBatteryPolicy bgPolicy2 = bgPolicy;
        int index = buf.indexOfKey(uid2);
        if (index >= 0) goto L40;
        buf.put(uid2, bgUsage);
    L41:
        uidConsumers = uidConsumers;
        bgPolicy = bgPolicy2;
        goto L29
    L40:
        BatteryUsage before = buf.valueAt(index);
        before.add(bgUsage);
        goto L41
    L36:
        uid2 = rawUid;
        goto L37
    L26:
        scale = 1.0d;
    L44:
        return stats;
    }

    private static void copyUidBatteryUsage(SparseArray<? extends BatteryUsage> source, SparseArray<ImmutableBatteryUsage> dest) {
        dest.clear();
        int i = source.size() - 1;
    L3:
        if (i < 0) goto L6;
        dest.put(source.keyAt(i), new ImmutableBatteryUsage(source.valueAt(i)));
        i = i - 1;
        goto L3
    }

    private static void copyUidBatteryUsage(SparseArray<? extends BatteryUsage> source, SparseArray<ImmutableBatteryUsage> dest, double scale) {
        dest.clear();
        int i = source.size() - 1;
    L3:
        if (i < 0) goto L6;
        dest.put(source.keyAt(i), new ImmutableBatteryUsage(source.valueAt(i), scale));
        i = i - 1;
        goto L3
    }

    private void onCurrentDrainMonitorEnabled(boolean enabled) {
        if (enabled == true) goto L4;
        this.mBgHandler.removeCallbacks(this.mBgBatteryUsageStatsPolling);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (this.mBatteryUsageStatsUpdatePending == true) goto L20;
    L15:
        this.mUidBatteryUsage.clear();     // Catch: Throwable -> L12
        this.mUidBatteryUsageInWindow.clear();     // Catch: Throwable -> L12
        this.mLastUidBatteryUsage.clear();     // Catch: Throwable -> L12
        this.mLastBatteryUsageSamplingTs = 0;     // Catch: Throwable -> L12
        this.mLastUidBatteryUsageStartTs = 0;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L20:
        this.mLock.wait();     // Catch: Throwable -> L12 InterruptedException -> L14
        goto L15
    L4:
        if (this.mBgHandler.hasCallbacks(this.mBgBatteryUsageStatsPolling) == true) goto L24;
        this.mBgHandler.postDelayed(this.mBgBatteryUsageStatsPolling, this.mBatteryUsageStatsPollingIntervalMs);
        return;
    }

    void setDebugUidPercentage(int[] uids, double[][] percentages) {
        this.mDebugUidPercentages.clear();
        int i = 0;
    L4:
        if (i >= uids.length) goto L6;
        this.mDebugUidPercentages.put(uids[i], new BatteryUsage().setPercentage(percentages[i]).unmutate());
        i = i + 1;
        goto L4
    L6:
        scheduleBgBatteryUsageStatsCheck();
    }

    void clearDebugUidPercentage() {
        this.mDebugUidPercentages.clear();
        scheduleBgBatteryUsageStatsCheck();
    }

    void reset() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidBatteryUsage.clear();     // Catch: Throwable -> L8
        this.mUidBatteryUsageInWindow.clear();     // Catch: Throwable -> L8
        this.mLastUidBatteryUsage.clear();     // Catch: Throwable -> L8
        this.mLastBatteryUsageSamplingTs = 0;     // Catch: Throwable -> L8
        this.mLastUidBatteryUsageStartTs = 0;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mBgHandler.removeCallbacks(this.mBgBatteryUsageStatsPolling);
        updateBatteryUsageStatsAndCheck();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void dump(PrintWriter pw, String prefix) {
        AppBatteryTracker r1 = this;
        pw.print(prefix);
        pw.println("APP BATTERY STATE TRACKER:");
        if (r1.mInjector.getActivityManagerInternal().isBooted() == false) goto L5;
        r1.updateBatteryUsageStatsIfNecessary(r1.mInjector.currentTimeMillis(), true);
    L5:
        r1.scheduleBgBatteryUsageStatsCheck();
        final CountDownLatch latch = new CountDownLatch(1);
        r1.mBgHandler.getLooper().getQueue().addIdleHandler(new AppBatteryTracker$$ExternalSyntheticLambda2(latch));
        latch.await();     // Catch: InterruptedException -> L8
    L9:
        Object r5 = r1.mLock;
        monitor-enter(r5);
        SparseArray<ImmutableBatteryUsage> uidConsumers = r1.mUidBatteryUsageInWindow;     // Catch: Throwable -> L14
        pw.print("  " + prefix);     // Catch: Throwable -> L14
        pw.print("  Last battery usage start=");     // Catch: Throwable -> L14
        TimeUtils.dumpTime(pw, r1.mLastUidBatteryUsageStartTs);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.print("  " + prefix);     // Catch: Throwable -> L14
        pw.print("Battery usage over last ");     // Catch: Throwable -> L14
        String newPrefix = "    " + prefix;     // Catch: Throwable -> L14
        AppBatteryPolicy bgPolicy = (AppBatteryPolicy) r1.mInjector.getPolicy();     // Catch: Throwable -> L14
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        long since = Math.max(0, now - bgPolicy.mBgCurrentDrainWindowMs);     // Catch: Throwable -> L14
        pw.println(TimeUtils.formatDuration(now - since));     // Catch: Throwable -> L14
        if (uidConsumers.size() != 0) goto L16;
        pw.print(newPrefix);     // Catch: Throwable -> L14
        pw.println("(none)");     // Catch: Throwable -> L14
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L14
        super.dump(pw, prefix);
        return;
    L16:
        int i = 0;
        int size = uidConsumers.size();     // Catch: Throwable -> L14
    L17:
        if (i >= size) goto L20;
        int uid = uidConsumers.keyAt(i);     // Catch: Throwable -> L14
        BatteryUsage bgUsage = uidConsumers.valueAt(i).calcPercentage(uid, bgPolicy);     // Catch: Throwable -> L14
        long since2 = since;
        BatteryUsage exemptedUsage = r1.mAppRestrictionController.getUidBatteryExemptedUsageSince(uid, since, now, bgPolicy.mBgCurrentDrainExemptedTypes).calcPercentage(uid, bgPolicy);     // Catch: Throwable -> L14
        BatteryUsage reportedUsage = new BatteryUsage(bgUsage).subtract(exemptedUsage).calcPercentage(uid, bgPolicy);     // Catch: Throwable -> L14
        pw.format("%s%s: [%s] %s (%s) | %s (%s) | %s (%s) | %s\n", new Object[]{newPrefix, UserHandle.formatUid(uid), PowerExemptionManager.reasonCodeToString(bgPolicy.shouldExemptUid(uid)), bgUsage.toString(), bgUsage.percentageToString(), exemptedUsage.toString(), exemptedUsage.percentageToString(), reportedUsage.toString(), reportedUsage.percentageToString(), r1.mUidBatteryUsage.get(uid, BATTERY_USAGE_NONE).toString()});     // Catch: Throwable -> L14
        i = i + 1;     // Catch: Throwable -> L14
        r1 = this;
        uidConsumers = uidConsumers;
        now = now;
        since = since2;
        size = size;
    L14:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$dump$0(CountDownLatch latch) {
        latch.countDown();
        return false;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void dumpAsProto(ProtoOutputStream proto, int uid) {
        if (this.mInjector.getActivityManagerInternal().isBooted() == false) goto L5;
        updateBatteryUsageStatsIfNecessary(this.mInjector.currentTimeMillis(), true);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<ImmutableBatteryUsage> uidConsumers = this.mUidBatteryUsageInWindow;     // Catch: Throwable -> L12
        if (uid == (-1)) goto L15;
        BatteryUsage usage = uidConsumers.get(uid);     // Catch: Throwable -> L12
        if (usage == null) goto L18;
        dumpUidStats(proto, uid, usage);     // Catch: Throwable -> L12
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        int i = 0;
        int size = uidConsumers.size();     // Catch: Throwable -> L12
    L16:
        if (i >= size) goto L18;
        int aUid = uidConsumers.keyAt(i);     // Catch: Throwable -> L12
        dumpUidStats(proto, aUid, uidConsumers.valueAt(i));     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void dumpUidStats(ProtoOutputStream proto, int uid, BatteryUsage usage) {
        if (usage.mUsage != null) goto L5;
        return;
    L5:
        double foregroundUsage = usage.getUsagePowerMah(1);
        double backgroundUsage = usage.getUsagePowerMah(2);
        double fgsUsage = usage.getUsagePowerMah(3);
        double cachedUsage = usage.getUsagePowerMah(4);
        if (foregroundUsage == 0.0d) goto L8;
    L12:
        long token = proto.start(2246267895809L);
        proto.write(1120986464257L, uid);
        dumpProcessStateStats(proto, 1, foregroundUsage);
        dumpProcessStateStats(proto, 2, backgroundUsage);
        dumpProcessStateStats(proto, 3, fgsUsage);
        dumpProcessStateStats(proto, 4, cachedUsage);
        proto.end(token);
        return;
    L8:
        if (backgroundUsage != 0.0d) goto L12;
        if (fgsUsage != 0.0d) goto L12;
    }

    private void dumpProcessStateStats(ProtoOutputStream proto, int processState, double powerMah) {
        if (powerMah != 0.0d) goto L5;
        return;
    L5:
        long token = proto.start(2246267895810L);
        proto.write(1159641169921L, processState);
        proto.write(1103806595075L, powerMah);
        proto.end(token);
    }
}
