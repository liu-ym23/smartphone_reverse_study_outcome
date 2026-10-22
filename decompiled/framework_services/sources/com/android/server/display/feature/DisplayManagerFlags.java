package com.android.server.display.feature;

import android.R;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Slog;
import android.window.DesktopExperienceFlags;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayManagerFlags {
    private static final boolean DEBUG = false;
    private static final String TAG = "DisplayManagerFlags";
    private final FlagState mAdaptiveToneImprovements1;
    private final FlagState mAdaptiveToneImprovements2;
    private final FlagState mAlwaysRotateDisplayDevice;
    private final FlagState mAutoBrightnessModeBedtimeWearFlagState;
    private final FlagState mAutoBrightnessModesFlagState;
    private final FlagState mBackUpSmoothDisplayAndForcePeakRefreshRateFlagState;
    private final FlagState mBaseDensityForExternalDisplays;
    private final FlagState mBlockAutobrightnessChangesOnStylusUsage;
    private final FlagState mBrightnessIntRangeUserPerceptionFlagState;
    private final FlagState mBrightnessWearBedtimeModeClamperFlagState;
    private final FlagState mCommittedStateSeparateEvent;
    private final FlagState mConnectedDisplayErrorHandlingFlagState;
    private final FlagState mDelayImplicitRrRegistrationUntilRrAccessed;
    private final FlagState mDisplayConfigErrorHalFlagState;
    private final FlagState mDisplayListenerPerformanceImprovementsFlagState;
    private final FlagState mDisplayOffloadFlagState;
    private final FlagState mDisplayTopology;
    private final FlagState mDozeBrightnessFloat;
    private final FlagState mEnableApplyDisplayChangedDuringDisplayAdded;
    private final FlagState mEnableBatteryStatsForAllDisplays;
    private final FlagState mEnableDisplayContentModeManagementFlagState;
    private final FlagState mEnableHdrOverridePluginTypeFlagState;
    private final FlagState mEnablePluginManagerFlagState;
    private final FlagState mEnableWaitingConfirmationBeforeMirroring;
    private final FlagState mEvenDimmerFlagState;
    private final FlagState mExternalDisplayLimitModeState;
    private final FlagState mFastHdrTransitions;
    private final FlagState mFramerateOverrideTriggersRrCallbacks;
    private final FlagState mGetSupportedRefreshRatesFlagState;
    private final FlagState mHasArrSupport;
    private final FlagState mIdleScreenConfigInSubscribingLightSensor;
    private final FlagState mIdleScreenRefreshRateTimeout;
    private final FlagState mIgnoreAppPreferredRefreshRate;
    private final FlagState mIsUserRefreshRateForExternalDisplayEnabled;
    private final FlagState mNewHdrBrightnessModifier;
    private final FlagState mNormalBrightnessForDozeParameter;
    private final FlagState mOffloadDozeOverrideHoldsWakelock;
    private final FlagState mOffloadSessionCancelBlockScreenOn;
    private final FlagState mPeakRefreshRatePhysicalLimit;
    private final FlagState mPixelAnisotropyCorrectionEnabled;
    private final FlagState mPortInDisplayLayoutFlagState;
    private final FlagState mPowerThrottlingClamperFlagState;
    private final FlagState mRefactorDisplayPowerController;
    private final FlagState mRefreshRateEventForForegroundApps;
    private final FlagState mResolutionBackupRestore;
    private final FlagState mRestrictDisplayModes;
    private final FlagState mSensorBasedBrightnessThrottling;
    private final FlagState mSeparateTimeouts;
    private final FlagState mSmallAreaDetectionFlagState;
    private final FlagState mSubscribeGranularDisplayEvents;
    private final FlagState mSyncedResolutionSwitch;
    private final FlagState mSynthetic60hzModes;
    private final FlagState mUseFusionProxSensor;
    private final FlagState mVirtualDisplayLimit;
    private final FlagState mVsyncLowLightVote;
    private final FlagState mVsyncLowPowerVote;

    private static class FlagState {
        private boolean mEnabled;
        private boolean mEnabledSet;
        private final Supplier<Boolean> mFlagFunction;
        private final String mName;

        /* JADX INFO: renamed from: -$$Nest$mgetName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4063$$Nest$mgetName(FlagState r0) {
            return r0.getName();
        }

        /* JADX INFO: renamed from: -$$Nest$misEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4064$$Nest$misEnabled(FlagState r0) {
            return r0.isEnabled();
        }

        /* synthetic */ FlagState(String r1, Supplier r2, DisplayManagerFlagsIA r3) {
            this(r1, r2);
        }

        private FlagState(String name, Supplier<Boolean> flagFunction) {
            this.mName = name;
            this.mFlagFunction = flagFunction;
        }

        private String getName() {
            return this.mName;
        }

        private boolean isEnabled() {
            if (this.mEnabledSet == true) goto L5;
            this.mEnabled = flagOrSystemProperty(this.mFlagFunction, this.mName);
            if (DisplayManagerFlags.m4062$$Nest$sfgetDEBUG() == false) goto L12;
            Slog.d(DisplayManagerFlags.TAG, this.mName + ": mEnabled. Flag value = " + this.mEnabled);
        L12:
            this.mEnabledSet = true;
            return this.mEnabled;
        L5:
            if (DisplayManagerFlags.m4062$$Nest$sfgetDEBUG() == false) goto L8;
            Slog.d(DisplayManagerFlags.TAG, this.mName + ": mEnabled. Recall = " + this.mEnabled);
        L8:
            return this.mEnabled;
        }

        private boolean flagOrSystemProperty(Supplier<Boolean> flagFunction, String flagName) {
            boolean flagValue = flagFunction.get().booleanValue();
            if (Build.IS_ENG == true) goto L9;
            if (Build.IS_USERDEBUG == true) goto L9;
            return flagValue;
        L9:
            return SystemProperties.getBoolean("persist.sys." + flagName + "-override", flagValue);
        }

        public String toString() {
            int nameLength = this.mName.length();
            return TextUtils.substring(this.mName, 41, nameLength) + ": " + TextUtils.formatSimple("%" + (93 - nameLength) + "s%s", new Object[]{" ", Boolean.valueOf(isEnabled())}) + " (def:" + this.mFlagFunction.get() + ")";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4062$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    public DisplayManagerFlags() {
        String r2 = "com.android.server.display.feature.flags.enable_port_in_display_layout";
        DisplayManagerFlagsIA r3 = null;
        this.mPortInDisplayLayoutFlagState = new FlagState(r2, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r4 = "com.android.server.display.feature.flags.enable_adaptive_tone_improvements_1";
        this.mAdaptiveToneImprovements1 = new FlagState(r4, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r5 = "com.android.server.display.feature.flags.enable_adaptive_tone_improvements_2";
        this.mAdaptiveToneImprovements2 = new FlagState(r5, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r6 = "com.android.server.display.feature.flags.enable_display_offload";
        this.mDisplayOffloadFlagState = new FlagState(r6, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r7 = "com.android.server.display.feature.flags.enable_mode_limit_for_external_display";
        this.mExternalDisplayLimitModeState = new FlagState(r7, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        final DesktopExperienceFlags r1 = DesktopExperienceFlags.DISPLAY_TOPOLOGY;
        r1.getClass();
        Supplier r8 = new DisplayManagerFlags$$ExternalSyntheticLambda2(r1);
        this.mDisplayTopology = new FlagState("com.android.server.display.feature.flags.display_topology", r8, r3);
        String r9 = "com.android.server.display.feature.flags.enable_connected_display_error_handling";
        this.mConnectedDisplayErrorHandlingFlagState = new FlagState(r9, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r10 = "com.android.server.display.feature.flags.back_up_smooth_display_and_force_peak_refresh_rate";
        this.mBackUpSmoothDisplayAndForcePeakRefreshRateFlagState = new FlagState(r10, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r11 = "com.android.server.display.feature.flags.enable_power_throttling_clamper";
        this.mPowerThrottlingClamperFlagState = new FlagState(r11, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r12 = "com.android.server.display.feature.flags.even_dimmer";
        this.mEvenDimmerFlagState = new FlagState(r12, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r13 = "com.android.graphics.surfaceflinger.flags.enable_small_area_detection";
        this.mSmallAreaDetectionFlagState = new FlagState(r13, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r14 = "com.android.graphics.surfaceflinger.flags.display_config_error_hal";
        this.mDisplayConfigErrorHalFlagState = new FlagState(r14, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r15 = "com.android.graphics.surfaceflinger.flags.synced_resolution_switch";
        this.mSyncedResolutionSwitch = new FlagState(r15, new DisplayManagerFlags$$ExternalSyntheticLambda1(), r3);
        String r16 = "com.android.server.display.feature.flags.brightness_int_range_user_perception";
        this.mBrightnessIntRangeUserPerceptionFlagState = new FlagState(r16, new DisplayManagerFlags$$ExternalSyntheticLambda1(), r3);
        String r17 = "com.android.server.display.feature.flags.enable_restrict_display_modes";
        this.mRestrictDisplayModes = new FlagState(r17, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r18 = "com.android.server.display.feature.flags.resolution_backup_restore";
        this.mResolutionBackupRestore = new FlagState(r18, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r19 = "com.android.server.display.feature.flags.enable_vsync_low_power_vote";
        this.mVsyncLowPowerVote = new FlagState(r19, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r20 = "com.android.server.display.feature.flags.enable_vsync_low_light_vote";
        this.mVsyncLowLightVote = new FlagState(r20, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r21 = "com.android.server.display.feature.flags.brightness_wear_bedtime_mode_clamper";
        this.mBrightnessWearBedtimeModeClamperFlagState = new FlagState(r21, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r22 = "com.android.server.display.feature.flags.auto_brightness_modes";
        this.mAutoBrightnessModesFlagState = new FlagState(r22, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r23 = "com.android.server.display.feature.flags.fast_hdr_transitions";
        this.mFastHdrTransitions = new FlagState(r23, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r24 = "com.android.server.display.feature.flags.always_rotate_display_device";
        this.mAlwaysRotateDisplayDevice = new FlagState(r24, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r25 = "com.android.server.display.feature.flags.enable_pixel_anisotropy_correction";
        this.mPixelAnisotropyCorrectionEnabled = new FlagState(r25, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r26 = "com.android.server.display.feature.flags.sensor_based_brightness_throttling";
        this.mSensorBasedBrightnessThrottling = new FlagState(r26, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r27 = "com.android.server.display.feature.flags.idle_screen_refresh_rate_timeout";
        this.mIdleScreenRefreshRateTimeout = new FlagState(r27, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r28 = "com.android.server.display.feature.flags.refactor_display_power_controller";
        this.mRefactorDisplayPowerController = new FlagState(r28, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r29 = "com.android.server.display.feature.flags.use_fusion_prox_sensor";
        this.mUseFusionProxSensor = new FlagState(r29, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r30 = "com.android.server.display.feature.flags.doze_brightness_float";
        this.mDozeBrightnessFloat = new FlagState(r30, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r31 = "com.android.server.display.feature.flags.enable_peak_refresh_rate_physical_limit";
        this.mPeakRefreshRatePhysicalLimit = new FlagState(r31, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r32 = "com.android.server.display.feature.flags.ignore_app_preferred_refresh_rate_request";
        this.mIgnoreAppPreferredRefreshRate = new FlagState(r32, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r33 = "com.android.server.display.feature.flags.enable_synthetic_60hz_modes";
        this.mSynthetic60hzModes = new FlagState(r33, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r34 = "com.android.server.display.feature.flags.offload_doze_override_holds_wakelock";
        this.mOffloadDozeOverrideHoldsWakelock = new FlagState(r34, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r35 = "com.android.server.display.feature.flags.offload_session_cancel_block_screen_on";
        this.mOffloadSessionCancelBlockScreenOn = new FlagState(r35, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r36 = "com.android.server.display.feature.flags.new_hdr_brightness_modifier";
        this.mNewHdrBrightnessModifier = new FlagState(r36, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r37 = "com.android.server.display.feature.flags.idle_screen_config_in_subscribing_light_sensor";
        this.mIdleScreenConfigInSubscribingLightSensor = new FlagState(r37, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r38 = "com.android.server.display.feature.flags.virtual_display_limit";
        this.mVirtualDisplayLimit = new FlagState(r38, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r39 = "com.android.server.display.feature.flags.normal_brightness_for_doze_parameter";
        this.mNormalBrightnessForDozeParameter = new FlagState(r39, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r40 = "com.android.server.display.feature.flags.block_autobrightness_changes_on_stylus_usage";
        this.mBlockAutobrightnessChangesOnStylusUsage = new FlagState(r40, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r41 = "com.android.server.display.feature.flags.enable_user_refresh_rate_for_external_display";
        this.mIsUserRefreshRateForExternalDisplayEnabled = new FlagState(r41, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r42 = "com.android.server.display.feature.flags.enable_waiting_confirmation_before_mirroring";
        this.mEnableWaitingConfirmationBeforeMirroring = new FlagState(r42, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r43 = "com.android.server.display.feature.flags.enable_apply_display_changed_during_display_added";
        this.mEnableApplyDisplayChangedDuringDisplayAdded = new FlagState(r43, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r44 = "com.android.server.display.feature.flags.enable_battery_stats_for_all_displays";
        this.mEnableBatteryStatsForAllDisplays = new FlagState(r44, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r45 = "com.android.server.display.feature.flags.enable_has_arr_support";
        this.mHasArrSupport = new FlagState(r45, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r46 = "com.android.server.display.feature.flags.auto_brightness_mode_bedtime_wear";
        this.mAutoBrightnessModeBedtimeWearFlagState = new FlagState(r46, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r47 = "com.android.server.display.feature.flags.enable_get_supported_refresh_rates";
        this.mGetSupportedRefreshRatesFlagState = new FlagState(r47, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r48 = "com.android.server.display.feature.flags.enable_plugin_manager";
        this.mEnablePluginManagerFlagState = new FlagState(r48, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r49 = "com.android.server.display.feature.flags.enable_hdr_override_plugin_type";
        this.mEnableHdrOverridePluginTypeFlagState = new FlagState(r49, new DisplayManagerFlags$$ExternalSyntheticLambda1(), r3);
        String r50 = "com.android.server.display.feature.flags.display_listener_performance_improvements";
        this.mDisplayListenerPerformanceImprovementsFlagState = new FlagState(r50, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        final DesktopExperienceFlags r51 = DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT;
        r51.getClass();
        Supplier r52 = new DisplayManagerFlags$$ExternalSyntheticLambda2(r51);
        this.mEnableDisplayContentModeManagementFlagState = new FlagState("com.android.server.display.feature.flags.enable_display_content_mode_management", r52, r3);
        String r53 = "com.android.server.display.feature.flags.subscribe_granular_display_events";
        this.mSubscribeGranularDisplayEvents = new FlagState(r53, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        final DesktopExperienceFlags r54 = DesktopExperienceFlags.BASE_DENSITY_FOR_EXTERNAL_DISPLAYS;
        r54.getClass();
        Supplier r55 = new DisplayManagerFlags$$ExternalSyntheticLambda2(r54);
        this.mBaseDensityForExternalDisplays = new FlagState("com.android.server.display.feature.flags.base_density_for_external_displays", r55, r3);
        String r56 = "com.android.server.display.feature.flags.framerate_override_triggers_rr_callbacks";
        this.mFramerateOverrideTriggersRrCallbacks = new FlagState(r56, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r57 = "com.android.server.display.feature.flags.refresh_rate_event_for_foreground_apps";
        this.mRefreshRateEventForForegroundApps = new FlagState(r57, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r58 = "com.android.server.display.feature.flags.committed_state_separate_event";
        this.mCommittedStateSeparateEvent = new FlagState(r58, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r59 = "com.android.server.display.feature.flags.separate_timeouts";
        this.mSeparateTimeouts = new FlagState(r59, new DisplayManagerFlags$$ExternalSyntheticLambda1(), r3);
        String r60 = "com.android.server.display.feature.flags.delay_implicit_rr_registration_until_rr_accessed";
        this.mDelayImplicitRrRegistrationUntilRrAccessed = new FlagState(r60, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    public boolean isPortInDisplayLayoutEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mPortInDisplayLayoutFlagState);
    }

    public boolean isPowerThrottlingClamperEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mPowerThrottlingClamperFlagState);
    }

    public boolean isAdaptiveTone1Enabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mAdaptiveToneImprovements1);
    }

    public boolean isAdaptiveTone2Enabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mAdaptiveToneImprovements2);
    }

    public boolean isDisplayResolutionRangeVotingEnabled() {
        return isExternalDisplayLimitModeEnabled();
    }

    public boolean isUserPreferredModeVoteEnabled() {
        return isExternalDisplayLimitModeEnabled();
    }

    public boolean isExternalDisplayLimitModeEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mExternalDisplayLimitModeState);
    }

    public boolean isDisplayTopologyEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mDisplayTopology);
    }

    public boolean isDisplaysRefreshRatesSynchronizationEnabled() {
        return isExternalDisplayLimitModeEnabled();
    }

    public boolean isDisplayOffloadEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mDisplayOffloadFlagState);
    }

    public boolean isConnectedDisplayErrorHandlingEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mConnectedDisplayErrorHandlingFlagState);
    }

    public boolean isBackUpSmoothDisplayAndForcePeakRefreshRateEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mBackUpSmoothDisplayAndForcePeakRefreshRateFlagState);
    }

    public boolean isEvenDimmerEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mEvenDimmerFlagState);
    }

    public boolean isSmallAreaDetectionEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mSmallAreaDetectionFlagState);
    }

    public boolean isDisplayConfigErrorHalEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mDisplayConfigErrorHalFlagState);
    }

    public boolean isSyncedResolutionSwitchEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mSyncedResolutionSwitch);
    }

    public boolean isBrightnessIntRangeUserPerceptionEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mBrightnessIntRangeUserPerceptionFlagState);
    }

    public boolean isRestrictDisplayModesEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mRestrictDisplayModes);
    }

    public boolean isResolutionBackupRestoreEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mResolutionBackupRestore);
    }

    public boolean isVsyncLowPowerVoteEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mVsyncLowPowerVote);
    }

    public boolean isVsyncLowLightVoteEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mVsyncLowLightVote);
    }

    public boolean isBrightnessWearBedtimeModeClamperEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mBrightnessWearBedtimeModeClamperFlagState);
    }

    public boolean areAutoBrightnessModesEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mAutoBrightnessModesFlagState);
    }

    public boolean isFastHdrTransitionsEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mFastHdrTransitions);
    }

    public boolean isAlwaysRotateDisplayDeviceEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mAlwaysRotateDisplayDevice);
    }

    public boolean isPixelAnisotropyCorrectionInLogicalDisplayEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mPixelAnisotropyCorrectionEnabled);
    }

    public boolean isSensorBasedBrightnessThrottlingEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mSensorBasedBrightnessThrottling);
    }

    public boolean isIdleScreenRefreshRateTimeoutEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mIdleScreenRefreshRateTimeout);
    }

    public boolean isRefactorDisplayPowerControllerEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mRefactorDisplayPowerController);
    }

    public boolean isUseFusionProxSensorEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mUseFusionProxSensor);
    }

    public String getUseFusionProxSensorFlagName() {
        return FlagState.m4063$$Nest$mgetName(this.mUseFusionProxSensor);
    }

    public boolean isDozeBrightnessFloatEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mDozeBrightnessFloat);
    }

    public boolean isPeakRefreshRatePhysicalLimitEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mPeakRefreshRatePhysicalLimit);
    }

    public boolean isOffloadDozeOverrideHoldsWakelockEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mOffloadDozeOverrideHoldsWakelock);
    }

    public boolean isOffloadSessionCancelBlockScreenOnEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mOffloadSessionCancelBlockScreenOn);
    }

    public boolean ignoreAppPreferredRefreshRateRequest() {
        return FlagState.m4064$$Nest$misEnabled(this.mIgnoreAppPreferredRefreshRate);
    }

    public boolean isSynthetic60HzModesEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mSynthetic60hzModes);
    }

    public boolean useNewHdrBrightnessModifier() {
        return FlagState.m4064$$Nest$misEnabled(this.mNewHdrBrightnessModifier);
    }

    public boolean isVirtualDisplayLimitEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mVirtualDisplayLimit);
    }

    public boolean isNormalBrightnessForDozeParameterEnabled(Context context) {
        if (FlagState.m4064$$Nest$misEnabled(this.mNormalBrightnessForDozeParameter) == true) goto L5;
    L7:
        return false;
    L5:
        if (context.getResources().getBoolean(R.bool.config_allowNormalBrightnessForDozePolicy) == false) goto L7;
        return true;
    }

    public boolean isIdleScreenConfigInSubscribingLightSensorEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mIdleScreenConfigInSubscribingLightSensor);
    }

    public boolean isWaitingConfirmationBeforeMirroringEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mEnableWaitingConfirmationBeforeMirroring);
    }

    public boolean isBatteryStatsEnabledForAllDisplays() {
        return FlagState.m4064$$Nest$misEnabled(this.mEnableBatteryStatsForAllDisplays);
    }

    public boolean isApplyDisplayChangedDuringDisplayAddedEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mEnableApplyDisplayChangedDuringDisplayAdded);
    }

    public boolean isBlockAutobrightnessChangesOnStylusUsage() {
        return FlagState.m4064$$Nest$misEnabled(this.mBlockAutobrightnessChangesOnStylusUsage);
    }

    public boolean isUserRefreshRateForExternalDisplayEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mIsUserRefreshRateForExternalDisplayEnabled);
    }

    public boolean hasArrSupportFlag() {
        return FlagState.m4064$$Nest$misEnabled(this.mHasArrSupport);
    }

    public boolean isAutoBrightnessModeBedtimeWearEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mAutoBrightnessModeBedtimeWearFlagState);
    }

    public boolean enableGetSupportedRefreshRates() {
        return FlagState.m4064$$Nest$misEnabled(this.mGetSupportedRefreshRatesFlagState);
    }

    public boolean isPluginManagerEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mEnablePluginManagerFlagState);
    }

    public boolean isHdrOverrideEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mEnableHdrOverridePluginTypeFlagState);
    }

    public boolean isDisplayListenerPerformanceImprovementsEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mDisplayListenerPerformanceImprovementsFlagState);
    }

    public boolean isDisplayContentModeManagementEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mEnableDisplayContentModeManagementFlagState);
    }

    public boolean isSubscribeGranularDisplayEventsEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mSubscribeGranularDisplayEvents);
    }

    public boolean isBaseDensityForExternalDisplaysEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mBaseDensityForExternalDisplays);
    }

    public boolean isFramerateOverrideTriggersRrCallbacksEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mFramerateOverrideTriggersRrCallbacks);
    }

    public boolean isRefreshRateEventForForegroundAppsEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mRefreshRateEventForForegroundApps);
    }

    public boolean isCommittedStateSeparateEventEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mCommittedStateSeparateEvent);
    }

    public boolean isSeparateTimeoutsEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mSeparateTimeouts);
    }

    public boolean isDelayImplicitRrRegistrationUntilRrAccessedEnabled() {
        return FlagState.m4064$$Nest$misEnabled(this.mDelayImplicitRrRegistrationUntilRrAccessed);
    }

    public void dump(PrintWriter pw) {
        pw.println("DisplayManagerFlags:");
        pw.println("--------------------");
        pw.println(" " + this.mAdaptiveToneImprovements1);
        pw.println(" " + this.mAdaptiveToneImprovements2);
        pw.println(" " + this.mBackUpSmoothDisplayAndForcePeakRefreshRateFlagState);
        pw.println(" " + this.mConnectedDisplayErrorHandlingFlagState);
        pw.println(" " + this.mDisplayOffloadFlagState);
        pw.println(" " + this.mExternalDisplayLimitModeState);
        pw.println(" " + this.mDisplayTopology);
        pw.println(" " + this.mPowerThrottlingClamperFlagState);
        pw.println(" " + this.mEvenDimmerFlagState);
        pw.println(" " + this.mSmallAreaDetectionFlagState);
        pw.println(" " + this.mDisplayConfigErrorHalFlagState);
        pw.println(" " + this.mSyncedResolutionSwitch);
        pw.println(" " + this.mBrightnessIntRangeUserPerceptionFlagState);
        pw.println(" " + this.mRestrictDisplayModes);
        pw.println(" " + this.mBrightnessWearBedtimeModeClamperFlagState);
        pw.println(" " + this.mAutoBrightnessModesFlagState);
        pw.println(" " + this.mFastHdrTransitions);
        pw.println(" " + this.mAlwaysRotateDisplayDevice);
        pw.println(" " + this.mPixelAnisotropyCorrectionEnabled);
        pw.println(" " + this.mSensorBasedBrightnessThrottling);
        pw.println(" " + this.mIdleScreenRefreshRateTimeout);
        pw.println(" " + this.mRefactorDisplayPowerController);
        pw.println(" " + this.mResolutionBackupRestore);
        pw.println(" " + this.mUseFusionProxSensor);
        pw.println(" " + this.mDozeBrightnessFloat);
        pw.println(" " + this.mPeakRefreshRatePhysicalLimit);
        pw.println(" " + this.mIgnoreAppPreferredRefreshRate);
        pw.println(" " + this.mSynthetic60hzModes);
        pw.println(" " + this.mOffloadDozeOverrideHoldsWakelock);
        pw.println(" " + this.mOffloadSessionCancelBlockScreenOn);
        pw.println(" " + this.mNewHdrBrightnessModifier);
        pw.println(" " + this.mVirtualDisplayLimit);
        pw.println(" " + this.mNormalBrightnessForDozeParameter);
        pw.println(" " + this.mIdleScreenConfigInSubscribingLightSensor);
        pw.println(" " + this.mEnableWaitingConfirmationBeforeMirroring);
        pw.println(" " + this.mEnableBatteryStatsForAllDisplays);
        pw.println(" " + this.mEnableApplyDisplayChangedDuringDisplayAdded);
        pw.println(" " + this.mBlockAutobrightnessChangesOnStylusUsage);
        pw.println(" " + this.mIsUserRefreshRateForExternalDisplayEnabled);
        pw.println(" " + this.mHasArrSupport);
        pw.println(" " + this.mAutoBrightnessModeBedtimeWearFlagState);
        pw.println(" " + this.mGetSupportedRefreshRatesFlagState);
        pw.println(" " + this.mEnablePluginManagerFlagState);
        pw.println(" " + this.mDisplayListenerPerformanceImprovementsFlagState);
        pw.println(" " + this.mSubscribeGranularDisplayEvents);
        pw.println(" " + this.mEnableDisplayContentModeManagementFlagState);
        pw.println(" " + this.mBaseDensityForExternalDisplays);
        pw.println(" " + this.mFramerateOverrideTriggersRrCallbacks);
        pw.println(" " + this.mRefreshRateEventForForegroundApps);
        pw.println(" " + this.mCommittedStateSeparateEvent);
        pw.println(" " + this.mSeparateTimeouts);
        pw.println(" " + this.mDelayImplicitRrRegistrationUntilRrAccessed);
    }
}
