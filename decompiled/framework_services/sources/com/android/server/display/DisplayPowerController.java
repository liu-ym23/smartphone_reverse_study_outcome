package com.android.server.display;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.display.AmbientBrightnessDayStats;
import android.hardware.display.BrightnessChangeEvent;
import android.hardware.display.BrightnessConfiguration;
import android.hardware.display.BrightnessInfo;
import android.hardware.display.DisplayManagerInternal;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.util.FloatProperty;
import android.util.IndentingPrintWriter;
import android.util.MathUtils;
import android.util.MutableFloat;
import android.util.MutableInt;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import com.android.internal.app.IBatteryStats;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.RingBuffer;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.BatteryStatsService;
import com.android.server.display.brightness.BrightnessEvent;
import com.android.server.display.brightness.BrightnessReason;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.brightness.DisplayBrightnessController;
import com.android.server.display.brightness.clamper.BrightnessClamperController;
import com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2;
import com.android.server.display.brightness.strategy.DisplayBrightnessStrategyConstants;
import com.android.server.display.color.ColorDisplayService;
import com.android.server.display.config.DisplayBrightnessMappingConfig;
import com.android.server.display.config.HighBrightnessModeData;
import com.android.server.display.config.HysteresisLevels;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.state.DisplayStateController;
import com.android.server.display.utils.DebugUtils;
import com.android.server.display.utils.SensorUtils;
import com.android.server.display.whitebalance.DisplayWhiteBalanceController;
import com.android.server.display.whitebalance.DisplayWhiteBalanceFactory;
import com.android.server.display.whitebalance.DisplayWhiteBalanceSettings;
import com.android.server.policy.WindowManagerPolicy;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
final class DisplayPowerController implements AutomaticBrightnessController.Callbacks, DisplayWhiteBalanceController.Callbacks {
    private static final int BRIGHTNESS_CHANGE_STATSD_REPORT_INTERVAL_MS = 500;
    private static final float[] BRIGHTNESS_RANGE_BOUNDARIES = null;
    private static final int[] BRIGHTNESS_RANGE_INDEX = null;
    private static final int COLOR_FADE_OFF_ANIMATION_DURATION_MILLIS = 100;
    private static final int COLOR_FADE_ON_ANIMATION_DURATION_MILLIS = 250;
    private static final boolean DEBUG = false;
    private static final int MSG_BOOT_COMPLETED = 13;
    private static final int MSG_BRIGHTNESS_RAMP_DONE = 10;
    private static final int MSG_CONFIGURE_BRIGHTNESS = 4;
    private static final int MSG_OFFLOADING_SCREEN_ON_UNBLOCKED = 18;
    private static final int MSG_SCREEN_OFF_UNBLOCKED = 3;
    private static final int MSG_SCREEN_ON_UNBLOCKED = 2;
    private static final int MSG_SET_BRIGHTNESS_FROM_OFFLOAD = 17;
    private static final int MSG_SET_DWBC_COLOR_OVERRIDE = 15;
    private static final int MSG_SET_DWBC_LOGGING_ENABLED = 16;
    private static final int MSG_SET_STYLUS_BEING_USED = 19;
    private static final int MSG_SET_STYLUS_USE_ENDED = 20;
    private static final int MSG_SET_TEMPORARY_AUTO_BRIGHTNESS_ADJUSTMENT = 6;
    private static final int MSG_SET_TEMPORARY_BRIGHTNESS = 5;
    private static final int MSG_SET_WINDOW_MANAGER_BRIGHTNESS_OVERRIDE = 21;
    private static final int MSG_STATSD_HBM_BRIGHTNESS = 11;
    private static final int MSG_STOP = 7;
    private static final int MSG_SWITCH_AUTOBRIGHTNESS_MODE = 14;
    private static final int MSG_SWITCH_USER = 12;
    private static final int MSG_UPDATE_BRIGHTNESS = 8;
    private static final int MSG_UPDATE_POWER_STATE = 1;
    private static final int MSG_UPDATE_RBC = 9;
    private static final int NANO_SECONDS_TO_MILLI_SECONDS_RATIO = 1000000;
    private static final int RAMP_STATE_SKIP_AUTOBRIGHT = 2;
    private static final int RAMP_STATE_SKIP_INITIAL = 1;
    private static final int RAMP_STATE_SKIP_NONE = 0;
    private static final int REPORTED_TO_POLICY_SCREEN_OFF = 0;
    private static final int REPORTED_TO_POLICY_SCREEN_ON = 2;
    private static final int REPORTED_TO_POLICY_SCREEN_TURNING_OFF = 3;
    private static final int REPORTED_TO_POLICY_SCREEN_TURNING_ON = 1;
    private static final int REPORTED_TO_POLICY_UNREPORTED = -1;
    private static final int RINGBUFFER_MAX = 100;
    private static final int RINGBUFFER_RBC_MAX = 20;
    private static final float SCREEN_ANIMATION_RATE_MINIMUM = 0.0f;
    private static final String SCREEN_OFF_BLOCKED_TRACE_NAME = "Screen off blocked";
    private static final String SCREEN_ON_BLOCKED_BY_DISPLAYOFFLOAD_TRACE_NAME = "Screen on blocked by displayoffload";
    private static final String SCREEN_ON_BLOCKED_TRACE_NAME = "Screen on blocked";
    private static final int STYLUS_USAGE_DEBOUNCE_TIME = 1000;
    private static final String TAG = "DisplayPowerController";
    private static final boolean USE_COLOR_FADE_ON_ANIMATION = false;
    private final Animator.AnimatorListener mAnimatorListener;
    protected AutomaticBrightnessController mAutomaticBrightnessController;
    protected final AutomaticBrightnessStrategy2 mAutomaticBrightnessStrategy;
    private final IBatteryStats mBatteryStats;
    private final DisplayBlanker mBlanker;
    private boolean mBootCompleted;
    private int mBrightnessAdjustmentFlags;
    private final boolean mBrightnessBucketsInDozeConfig;
    protected final BrightnessClamperController mBrightnessClamperController;
    private RingBuffer<BrightnessEvent> mBrightnessEventRingBuffer;
    private long mBrightnessRampDecreaseMaxTimeIdleMillis;
    private long mBrightnessRampDecreaseMaxTimeMillis;
    private long mBrightnessRampIncreaseMaxTimeIdleMillis;
    private long mBrightnessRampIncreaseMaxTimeMillis;
    private float mBrightnessRampRateFastDecrease;
    private float mBrightnessRampRateFastIncrease;
    private float mBrightnessRampRateSlowDecrease;
    private float mBrightnessRampRateSlowDecreaseIdle;
    private float mBrightnessRampRateSlowIncrease;
    private float mBrightnessRampRateSlowIncreaseIdle;
    protected final BrightnessRangeController mBrightnessRangeController;
    final BrightnessReason mBrightnessReason;
    protected final BrightnessReason mBrightnessReasonTemp;
    private final BrightnessTracker mBrightnessTracker;
    private final CachedBrightnessInfo mCachedBrightnessInfo;
    private final ColorDisplayService.ColorDisplayServiceInternal mCdsi;
    private final Runnable mCleanListener;
    private final Clock mClock;
    private final boolean mColorFadeEnabled;
    private final boolean mColorFadeFadesConfig;
    private ObjectAnimator mColorFadeOffAnimator;
    private ObjectAnimator mColorFadeOnAnimator;
    protected final Context mContext;
    private final boolean mDisplayBlanksAfterDozeConfig;
    protected final DisplayBrightnessController mDisplayBrightnessController;
    private final SparseArray<DisplayPowerController> mDisplayBrightnessFollowers;
    protected DisplayDevice mDisplayDevice;
    protected DisplayDeviceConfig mDisplayDeviceConfig;
    protected final int mDisplayId;
    private DisplayManagerInternal.DisplayOffloadSession mDisplayOffloadSession;
    private final DisplayPowerProximityStateController mDisplayPowerProximityStateController;
    private boolean mDisplayReadyLocked;
    private final DisplayStateController mDisplayStateController;
    private int mDisplayStatsId;
    private final DisplayWhiteBalanceController mDisplayWhiteBalanceController;
    private final DisplayWhiteBalanceSettings mDisplayWhiteBalanceSettings;
    private float mDozeScaleFactor;
    private boolean mDozing;
    private IExtDisplayPowerController mExt;
    private final DisplayManagerFlags mFlags;
    protected final DisplayControllerHandler mHandler;
    private long mIdleStylusTimeoutMillisConfig;
    private float mInitialAutoBrightness;
    private final Injector mInjector;
    protected boolean mIsDisplayInternal;
    private boolean mIsEnabled;
    private boolean mIsInTransition;
    private boolean mIsRbcActive;
    private boolean mIsWearBedtimeModeEnabled;
    private final BrightnessEvent mLastBrightnessEvent;
    private float mLastStatsBrightness;
    private long mLastStylusUsageEventTime;
    private int mLeadDisplayId;
    private Sensor mLightSensor;
    private final Object mLock;
    private final LogicalDisplay mLogicalDisplay;
    private float[] mNitsRange;
    private final Runnable mOnBrightnessChangeRunnable;
    private int mPendingOverrideDozeScreenStateLocked;
    private boolean mPendingRequestChangedLocked;
    private DisplayManagerInternal.DisplayPowerRequest mPendingRequestLocked;
    private boolean mPendingScreenOff;
    private ScreenOffUnblocker mPendingScreenOffUnblocker;
    private ScreenOnUnblocker mPendingScreenOnUnblocker;
    private Runnable mPendingScreenOnUnblockerByDisplayOffload;
    private boolean mPendingUpdatePowerStateLocked;
    private String mPhysicalDisplayName;
    private DisplayManagerInternal.DisplayPowerRequest mPowerRequest;
    protected DisplayPowerState mPowerState;
    private final RampAnimator.Listener mRampAnimatorListener;
    private final RingBuffer<BrightnessEvent> mRbcEventRingBuffer;
    private int mReportedScreenStateToPolicy;
    private float mScreenBrightnessDozeConfig;
    protected RampAnimator.DualRampAnimator<DisplayPowerState> mScreenBrightnessRampAnimator;
    private long mScreenOffBlockStartRealTime;
    private Sensor mScreenOffBrightnessSensor;
    private ScreenOffBrightnessSensorController mScreenOffBrightnessSensorController;
    private long mScreenOnBlockByDisplayOffloadStartRealTime;
    private long mScreenOnBlockStartRealTime;
    private boolean mScreenTurningOnWasBlockedByDisplayOffload;
    private final SensorManager mSensorManager;
    protected SettingsObserver mSettingsObserver;
    private int mSkipRampState;
    private final boolean mSkipScreenOnBrightnessRamp;
    private DisplayPowerControllerSmtEx mSmtEx;
    private boolean mStopped;
    private final String mTag;
    private final BrightnessEvent mTempBrightnessEvent;
    private String mUniqueDisplayId;
    private boolean mUseSoftwareAutoBrightnessConfig;
    private final WakelockController mWakelockController;
    private final WindowManagerPolicy mWindowManagerPolicy;
    private IZswDisplayPowerController mZswExt;

    static class CachedBrightnessInfo {
        public MutableFloat adjustedBrightness;
        public MutableFloat brightness;
        public MutableFloat brightnessMax;
        public MutableInt brightnessMaxReason;
        public MutableFloat brightnessMin;
        public MutableInt brightnessReason;
        public MutableInt hbmMode;
        public MutableFloat hbmTransitionPoint;

        CachedBrightnessInfo() {
            this.brightness = new MutableFloat(Float.NaN);
            this.adjustedBrightness = new MutableFloat(Float.NaN);
            this.brightnessMin = new MutableFloat(Float.NaN);
            this.brightnessMax = new MutableFloat(Float.NaN);
            this.hbmMode = new MutableInt(0);
            this.hbmTransitionPoint = new MutableFloat(Float.POSITIVE_INFINITY);
            this.brightnessMaxReason = new MutableInt(0);
            this.brightnessReason = new MutableInt(0);
        }

        public boolean checkAndSetFloat(MutableFloat mf, float f) {
            if (mf.value == f) goto L6;
            mf.value = f;
            return true;
        L6:
            return false;
        }

        public boolean checkAndSetInt(MutableInt mi, int i) {
            if (mi.value == i) goto L6;
            mi.value = i;
            return true;
        L6:
            return false;
        }
    }

    interface Clock {
        long uptimeMillis();
    }

    private final class DisplayControllerHandler extends Handler {
        final /* synthetic */ DisplayPowerController this$0;

        DisplayControllerHandler(DisplayPowerController r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean isIdle = false;
            switch(msg.what) {
                case 1: goto L63;
                case 2: goto L61;
                case 3: goto L58;
                case 4: goto L43;
                case 5: goto L42;
                case 6: goto L41;
                case 7: goto L40;
                case 8: goto L37;
                case 9: goto L35;
                case 10: goto L33;
                case 11: goto L31;
                case 12: goto L27;
                case 13: goto L25;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L14;
                case 18: goto L11;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L6;
                default: goto L91;
            };
        L8:
            this.this$0.mDisplayBrightnessController.setStylusBeingUsed(false);
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L9:
            this.this$0.mHandler.removeMessages(20);
            Message message = this.this$0.mHandler.obtainMessage(20);
            this.this$0.mHandler.sendMessageAtTime(message, DisplayPowerController.m3742$$Nest$fgetmClock(this.this$0).uptimeMillis() + DisplayPowerController.m3745$$Nest$fgetmIdleStylusTimeoutMillisConfig(this.this$0));
            this.this$0.mDisplayBrightnessController.setStylusBeingUsed(true);
            return;
        L16:
            DisplayPowerController.m3763$$Nest$msetDwbcLoggingEnabled(this.this$0, msg.arg1);
            return;
        L17:
            float cct = Float.intBitsToFloat(msg.arg1);
            DisplayPowerController.m3764$$Nest$msetDwbcOverride(this.this$0, cct);
            return;
        L25:
            DisplayPowerController.m3751$$Nest$fputmBootCompleted(this.this$0, true);
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L31:
            DisplayPowerController.m3759$$Nest$mlogHbmBrightnessStats(this.this$0, Float.intBitsToFloat(msg.arg1), msg.arg2);
            return;
        L35:
            DisplayPowerController.m3757$$Nest$mhandleRbcChanged(this.this$0);
            return;
        L40:
            DisplayPowerController.m3754$$Nest$mcleanupHandlerThreadAfterStop(this.this$0);
            return;
        L41:
            this.this$0.mAutomaticBrightnessStrategy.setTemporaryAutoBrightnessAdjustment(Float.intBitsToFloat(msg.arg1));
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L42:
            float temporaryBrightness = DisplayPowerController.m3744$$Nest$fgetmExt(this.this$0).calcTemporaryBrightness(Float.intBitsToFloat(msg.arg1));
            this.this$0.mDisplayBrightnessController.setTemporaryBrightness(Float.valueOf(temporaryBrightness));
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L43:
            BrightnessConfiguration brightnessConfiguration = (BrightnessConfiguration) msg.obj;
            AutomaticBrightnessStrategy2 r3 = this.this$0.mAutomaticBrightnessStrategy;
            if (msg.arg1 != 1) goto L46;
            boolean r4 = true;
        L47:
            r3.setBrightnessConfiguration(brightnessConfiguration, r4);
            if (DisplayPowerController.m3741$$Nest$fgetmBrightnessTracker(this.this$0) == null) goto L56;
            BrightnessTracker r5 = DisplayPowerController.m3741$$Nest$fgetmBrightnessTracker(this.this$0);
            if (brightnessConfiguration != null) goto L52;
        L55:
            r5.setShouldCollectColorSample(isIdle);
            goto L56
        L52:
            if (brightnessConfiguration.shouldCollectColorSamples() == false) goto L55;
            isIdle = true;
        L56:
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L46:
            r4 = false;
            goto L47
        L63:
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L91:
            return;
        L6:
            if (this.this$0.mDisplayBrightnessController.updateWindowManagerBrightnessOverride((DisplayManagerInternal.DisplayBrightnessOverrideRequest) msg.obj) == false) goto L65;
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L65:
            return;
        L11:
            if (DisplayPowerController.m3743$$Nest$fgetmDisplayOffloadSession(this.this$0) != msg.obj) goto L69;
            DisplayPowerController.m3769$$Nest$munblockScreenOnByDisplayOffload(this.this$0);
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L69:
            return;
        L14:
            if (this.this$0.mDisplayBrightnessController.setBrightnessFromOffload(Float.intBitsToFloat(msg.arg1)) == false) goto L71;
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L71:
            return;
        L19:
            if (msg.arg1 != 1) goto L22;
            isIdle = true;
        L22:
            if (this.this$0.mAutomaticBrightnessController == null) goto L24;
            this.this$0.mAutomaticBrightnessController.switchMode(msg.arg1, true);
            DisplayPowerController.m3762$$Nest$msetAnimatorRampSpeeds(this.this$0, isIdle);
        L24:
            DisplayPowerController.m3765$$Nest$msetDwbcStrongMode(this.this$0, msg.arg1);
            return;
        L27:
            if ((msg.obj instanceof Float) == false) goto L29;
            float newBrightness = ((Float) msg.obj).floatValue();
        L30:
            DisplayPowerController.m3756$$Nest$mhandleOnSwitchUser(this.this$0, msg.arg1, msg.arg2, newBrightness);
            return;
        L29:
            newBrightness = Float.NaN;
            goto L30
        L33:
            if (this.this$0.mPowerState == null) goto L79;
            float brightness = this.this$0.mPowerState.getScreenBrightness();
            DisplayPowerController.m3760$$Nest$mreportStats(this.this$0, brightness);
            return;
        L79:
            return;
        L37:
            if (DisplayPowerController.m3749$$Nest$fgetmStopped(this.this$0) == false) goto L39;
            return;
        L39:
            DisplayPowerController.m3758$$Nest$mhandleSettingsChange(this.this$0);
            return;
        L58:
            if (DisplayPowerController.m3747$$Nest$fgetmPendingScreenOffUnblocker(this.this$0) != msg.obj) goto L87;
            DisplayPowerController.m3767$$Nest$munblockScreenOff(this.this$0);
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        L87:
            return;
        L61:
            if (DisplayPowerController.m3748$$Nest$fgetmPendingScreenOnUnblocker(this.this$0) != msg.obj) goto L89;
            DisplayPowerController.m3768$$Nest$munblockScreenOn(this.this$0);
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
            return;
        }
    }

    static class Injector {
        Injector() {
        }

        Clock getClock() {
            return new DisplayPowerController$Injector$$ExternalSyntheticLambda0();
        }

        DisplayPowerState getDisplayPowerState(DisplayBlanker blanker, ColorFade colorFade, int displayId, int displayState) {
            return new DisplayPowerState(blanker, colorFade, displayId, displayState);
        }

        RampAnimator.DualRampAnimator<DisplayPowerState> getDualRampAnimator(DisplayPowerState dps, FloatProperty<DisplayPowerState> firstProperty, FloatProperty<DisplayPowerState> secondProperty) {
            return new RampAnimator.DualRampAnimator(dps, firstProperty, secondProperty);
        }

        WakelockController getWakelockController(int displayId, DisplayManagerInternal.DisplayPowerCallbacks displayPowerCallbacks) {
            return new WakelockController(displayId, displayPowerCallbacks);
        }

        DisplayPowerProximityStateController getDisplayPowerProximityStateController(WakelockController wakelockController, DisplayDeviceConfig displayDeviceConfig, Looper looper, Runnable nudgeUpdatePowerState, int displayId, SensorManager sensorManager) {
            return new DisplayPowerProximityStateController(wakelockController, displayDeviceConfig, looper, nudgeUpdatePowerState, displayId, sensorManager);
        }

        AutomaticBrightnessController getAutomaticBrightnessController(AutomaticBrightnessController.Callbacks callbacks, Looper looper, SensorManager sensorManager, Sensor lightSensor, SparseArray<BrightnessMappingStrategy> brightnessMappingStrategyMap, int lightSensorWarmUpTime, float brightnessMin, float brightnessMax, float dozeScaleFactor, int lightSensorRate, int initialLightSensorRate, long brighteningLightDebounceConfig, long darkeningLightDebounceConfig, long brighteningLightDebounceConfigIdle, long darkeningLightDebounceConfigIdle, boolean resetAmbientLuxAfterWarmUpConfig, HysteresisLevels ambientBrightnessThresholds, HysteresisLevels screenBrightnessThresholds, HysteresisLevels ambientBrightnessThresholdsIdle, HysteresisLevels screenBrightnessThresholdsIdle, Context context, BrightnessRangeController brightnessModeController, BrightnessClamperController clamperController, int ambientLightHorizonShort, int ambientLightHorizonLong, float userLux, float userNits, DisplayManagerFlags displayManagerFlags) {
            return new AutomaticBrightnessController(callbacks, looper, sensorManager, lightSensor, brightnessMappingStrategyMap, lightSensorWarmUpTime, brightnessMin, brightnessMax, dozeScaleFactor, lightSensorRate, initialLightSensorRate, brighteningLightDebounceConfig, darkeningLightDebounceConfig, brighteningLightDebounceConfigIdle, darkeningLightDebounceConfigIdle, resetAmbientLuxAfterWarmUpConfig, ambientBrightnessThresholds, screenBrightnessThresholds, ambientBrightnessThresholdsIdle, screenBrightnessThresholdsIdle, context, brightnessModeController, clamperController, ambientLightHorizonShort, ambientLightHorizonLong, userLux, userNits, displayManagerFlags);
        }

        BrightnessMappingStrategy getDefaultModeBrightnessMapper(Context context, DisplayDeviceConfig displayDeviceConfig, DisplayWhiteBalanceController displayWhiteBalanceController) {
            return BrightnessMappingStrategy.create(context, displayDeviceConfig, 0, displayWhiteBalanceController);
        }

        ScreenOffBrightnessSensorController getScreenOffBrightnessSensorController(SensorManager sensorManager, Sensor lightSensor, Handler handler, ScreenOffBrightnessSensorController.Clock clock, int[] sensorValueToLux, BrightnessMappingStrategy brightnessMapper) {
            return new ScreenOffBrightnessSensorController(sensorManager, lightSensor, handler, clock, sensorValueToLux, brightnessMapper);
        }

        HighBrightnessModeController getHighBrightnessModeController(Handler handler, int width, int height, IBinder displayToken, String displayUniqueId, float brightnessMin, float brightnessMax, HighBrightnessModeData hbmData, HighBrightnessModeController.HdrBrightnessDeviceConfig hdrBrightnessCfg, Runnable hbmChangeCallback, HighBrightnessModeMetadata hbmMetadata, Context context) {
            return new HighBrightnessModeController(handler, width, height, displayToken, displayUniqueId, brightnessMin, brightnessMax, hbmData, hdrBrightnessCfg, hbmChangeCallback, hbmMetadata, context);
        }

        BrightnessRangeController getBrightnessRangeController(HighBrightnessModeController hbmController, Runnable modeChangeCallback, DisplayDeviceConfig displayDeviceConfig, Handler handler, DisplayManagerFlags flags, IBinder displayToken, DisplayDeviceInfo info) {
            return new BrightnessRangeController(hbmController, modeChangeCallback, displayDeviceConfig, handler, flags, displayToken, info);
        }

        BrightnessClamperController getBrightnessClamperController(Handler handler, BrightnessClamperController.ClamperChangeListener clamperChangeListener, BrightnessClamperController.DisplayDeviceData data, Context context, DisplayManagerFlags flags, SensorManager sensorManager, float currentBrightness) {
            return new BrightnessClamperController(handler, clamperChangeListener, data, context, flags, sensorManager, currentBrightness);
        }

        DisplayWhiteBalanceController getDisplayWhiteBalanceController(Handler handler, SensorManager sensorManager, Resources resources) {
            return DisplayWhiteBalanceFactory.create(handler, sensorManager, resources);
        }

        boolean isColorFadeEnabled() {
            return !ActivityManager.isLowRamDeviceStatic();
        }
    }

    private final class ScreenOffUnblocker implements WindowManagerPolicy.ScreenOffListener {
        final /* synthetic */ DisplayPowerController this$0;

        /* synthetic */ ScreenOffUnblocker(DisplayPowerController r1, DisplayPowerControllerIA r2) {
            this(r1);
        }

        private ScreenOffUnblocker(DisplayPowerController r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.policy.WindowManagerPolicy.ScreenOffListener
        public void onScreenOff() {
            Message msg = this.this$0.mHandler.obtainMessage(3, this);
            this.this$0.mHandler.sendMessageAtTime(msg, DisplayPowerController.m3742$$Nest$fgetmClock(this.this$0).uptimeMillis());
        }
    }

    private final class ScreenOnUnblocker implements WindowManagerPolicy.ScreenOnListener {
        final /* synthetic */ DisplayPowerController this$0;

        /* synthetic */ ScreenOnUnblocker(DisplayPowerController r1, DisplayPowerControllerIA r2) {
            this(r1);
        }

        private ScreenOnUnblocker(DisplayPowerController r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.policy.WindowManagerPolicy.ScreenOnListener
        public void onScreenOn() {
            DisplayPowerController.m3744$$Nest$fgetmExt(this.this$0).onScreenOn();
            Message msg = this.this$0.mHandler.obtainMessage(2, this);
            this.this$0.mHandler.sendMessageAtTime(msg, DisplayPowerController.m3742$$Nest$fgetmClock(this.this$0).uptimeMillis());
        }
    }

    protected final class SettingsObserver extends ContentObserver {
        final /* synthetic */ DisplayPowerController this$0;

        public static /* synthetic */ void $r8$lambda$hR4l2J1Oly4ccX4qYLu3DLKQkQ0(SettingsObserver r0) {
            r0.lambda$onChange$0();
        }

        SettingsObserver(DisplayPowerController this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (DisplayPowerController.m3744$$Nest$fgetmExt(this.this$0).onChange(selfChange, uri) == false) goto L6;
            return;
        L6:
            if (uri.equals(Settings.System.getUriFor("screen_brightness_mode")) == false) goto L9;
            this.this$0.mHandler.postAtTime(new DisplayPowerController$SettingsObserver$$ExternalSyntheticLambda0(this), DisplayPowerController.m3742$$Nest$fgetmClock(this.this$0).uptimeMillis());
            return;
        L9:
            if (uri.equals(Settings.System.getUriFor("screen_brightness_for_als")) == false) goto L12;
            int preset = Settings.System.getIntForUser(this.this$0.mContext.getContentResolver(), "screen_brightness_for_als", 2, -2);
            Slog.i(DisplayPowerController.m3750$$Nest$fgetmTag(this.this$0), "Setting up auto-brightness for preset " + DisplayBrightnessMappingConfig.autoBrightnessPresetToString(preset));
            DisplayPowerController.m3766$$Nest$msetUpAutoBrightness(this.this$0, this.this$0.mContext, this.this$0.mHandler);
            DisplayPowerController.m3761$$Nest$msendUpdatePowerState(this.this$0);
            return;
        L12:
            if (uri.equals(Settings.Global.getUriFor("bedtime_mode")) == false) goto L17;
            DisplayPowerController r1 = this.this$0;
            boolean r3 = false;
            if (Settings.Global.getInt(this.this$0.mContext.getContentResolver(), "bedtime_mode", 0) != 1) goto L16;
            r3 = true;
        L16:
            DisplayPowerController.m3752$$Nest$fputmIsWearBedtimeModeEnabled(r1, r3);
            Slog.i(DisplayPowerController.m3750$$Nest$fgetmTag(this.this$0), "Update for bedtime mode. Enable: " + DisplayPowerController.m3746$$Nest$fgetmIsWearBedtimeModeEnabled(this.this$0));
            DisplayPowerController.m3761$$Nest$msendUpdatePowerState(this.this$0);
            return;
        L17:
            DisplayPowerController.m3758$$Nest$mhandleSettingsChange(this.this$0);
        }

        private /* synthetic */ void lambda$onChange$0() {
            DisplayPowerController.m3755$$Nest$mhandleBrightnessModeChange(this.this$0);
            DisplayPowerController.m3770$$Nest$mupdatePowerState(this.this$0);
        }
    }

    public static /* synthetic */ void $r8$lambda$3lWZJ4BpIHcX_GeenBdRfMVq_oU(DisplayPowerController r0) {
        r0.sendUpdatePowerState();
    }

    public static /* synthetic */ void $r8$lambda$8rUGEn0dNmrOJcwRnq2VJzM2pjc(DisplayPowerController r0) {
        lambda$clearDisplayBrightnessFollowersLocked$9(r0);
    }

    public static /* synthetic */ void $r8$lambda$O6mpZthfxOx0lhcqL34r3oprwCs(DisplayPowerController r0, DisplayManagerInternal.DisplayOffloadSession r1) {
        r0.lambda$blockScreenOnByDisplayOffload$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$PyqwBbVTZ4w53dakFwc1n1ZoghQ(DisplayPowerController r0, int r1) {
        r0.lambda$overrideDozeScreenState$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$SuWf1yk5lu2qnPpoUMKnLNPfmmM(DisplayPowerController r0) {
        r0.lambda$new$2();
    }

    public static /* synthetic */ void $r8$lambda$VkeH_dpkq8ekwizFlDrhaPmB5N8(DisplayPowerController r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$Vtc1Po4a0DGkWz5GRpdfH5REh7Q(DisplayPowerController r0, boolean r1, boolean r2, DisplayDevice r3, String r4, String r5, DisplayDeviceConfig r6, IBinder r7, DisplayDeviceInfo r8, HighBrightnessModeMetadata r9, boolean r10, String r11, String r12) {
        r0.lambda$onDisplayChanged$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: $r8$lambda$X0kcyT-jGCo5DAjSMwT2VnJSrCE, reason: not valid java name */
    public static /* synthetic */ void m3739$r8$lambda$X0kcyTjGCo5DAjSMwT2VnJSrCE(DisplayPowerController r0) {
        lambda$removeDisplayBrightnessFollower$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$ZFPhLbQvTzph4eOkWY2hWLOLrk8(DisplayPowerController r0) {
        r0.lambda$new$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$gOarXu2d8jDgQ1-guoA7hSPD1rA, reason: not valid java name */
    public static /* synthetic */ float m3740$r8$lambda$gOarXu2d8jDgQ1guoA7hSPD1rA(DisplayPowerController r0, float r1, float r2) {
        return r0.lambda$createHbmControllerLocked$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$iVTSAZlXXYTnQ1GVDYvaOw8zfV4(DisplayPowerController r0, float r1) {
        r0.lambda$initialize$5(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBrightnessTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ BrightnessTracker m3741$$Nest$fgetmBrightnessTracker(DisplayPowerController r0) {
        return r0.mBrightnessTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m3742$$Nest$fgetmClock(DisplayPowerController r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayOffloadSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerInternal.DisplayOffloadSession m3743$$Nest$fgetmDisplayOffloadSession(DisplayPowerController r0) {
        return r0.mDisplayOffloadSession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtDisplayPowerController m3744$$Nest$fgetmExt(DisplayPowerController r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleStylusTimeoutMillisConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3745$$Nest$fgetmIdleStylusTimeoutMillisConfig(DisplayPowerController r2) {
        return r2.mIdleStylusTimeoutMillisConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsWearBedtimeModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3746$$Nest$fgetmIsWearBedtimeModeEnabled(DisplayPowerController r0) {
        return r0.mIsWearBedtimeModeEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingScreenOffUnblocker, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenOffUnblocker m3747$$Nest$fgetmPendingScreenOffUnblocker(DisplayPowerController r0) {
        return r0.mPendingScreenOffUnblocker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingScreenOnUnblocker, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenOnUnblocker m3748$$Nest$fgetmPendingScreenOnUnblocker(DisplayPowerController r0) {
        return r0.mPendingScreenOnUnblocker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3749$$Nest$fgetmStopped(DisplayPowerController r0) {
        return r0.mStopped;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3750$$Nest$fgetmTag(DisplayPowerController r0) {
        return r0.mTag;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3751$$Nest$fputmBootCompleted(DisplayPowerController r0, boolean r1) {
        r0.mBootCompleted = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsWearBedtimeModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3752$$Nest$fputmIsWearBedtimeModeEnabled(DisplayPowerController r0, boolean r1) {
        r0.mIsWearBedtimeModeEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyReduceBrightColorsSplineAdjustment, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3753$$Nest$mapplyReduceBrightColorsSplineAdjustment(DisplayPowerController r0) {
        r0.applyReduceBrightColorsSplineAdjustment();
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupHandlerThreadAfterStop, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3754$$Nest$mcleanupHandlerThreadAfterStop(DisplayPowerController r0) {
        r0.cleanupHandlerThreadAfterStop();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBrightnessModeChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3755$$Nest$mhandleBrightnessModeChange(DisplayPowerController r0) {
        r0.handleBrightnessModeChange();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnSwitchUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3756$$Nest$mhandleOnSwitchUser(DisplayPowerController r0, int r1, int r2, float r3) {
        r0.handleOnSwitchUser(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRbcChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3757$$Nest$mhandleRbcChanged(DisplayPowerController r0) {
        r0.handleRbcChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSettingsChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3758$$Nest$mhandleSettingsChange(DisplayPowerController r0) {
        r0.handleSettingsChange();
    }

    /* JADX INFO: renamed from: -$$Nest$mlogHbmBrightnessStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3759$$Nest$mlogHbmBrightnessStats(DisplayPowerController r0, float r1, int r2) {
        r0.logHbmBrightnessStats(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3760$$Nest$mreportStats(DisplayPowerController r0, float r1) {
        r0.reportStats(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendUpdatePowerState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3761$$Nest$msendUpdatePowerState(DisplayPowerController r0) {
        r0.sendUpdatePowerState();
    }

    /* JADX INFO: renamed from: -$$Nest$msetAnimatorRampSpeeds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3762$$Nest$msetAnimatorRampSpeeds(DisplayPowerController r0, boolean r1) {
        r0.setAnimatorRampSpeeds(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDwbcLoggingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3763$$Nest$msetDwbcLoggingEnabled(DisplayPowerController r0, int r1) {
        r0.setDwbcLoggingEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDwbcOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3764$$Nest$msetDwbcOverride(DisplayPowerController r0, float r1) {
        r0.setDwbcOverride(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDwbcStrongMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3765$$Nest$msetDwbcStrongMode(DisplayPowerController r0, int r1) {
        r0.setDwbcStrongMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUpAutoBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3766$$Nest$msetUpAutoBrightness(DisplayPowerController r0, Context r1, Handler r2) {
        r0.setUpAutoBrightness(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$munblockScreenOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3767$$Nest$munblockScreenOff(DisplayPowerController r0) {
        r0.unblockScreenOff();
    }

    /* JADX INFO: renamed from: -$$Nest$munblockScreenOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3768$$Nest$munblockScreenOn(DisplayPowerController r0) {
        r0.unblockScreenOn();
    }

    /* JADX INFO: renamed from: -$$Nest$munblockScreenOnByDisplayOffload, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3769$$Nest$munblockScreenOnByDisplayOffload(DisplayPowerController r0) {
        r0.unblockScreenOnByDisplayOffload();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePowerState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3770$$Nest$mupdatePowerState(DisplayPowerController r0) {
        r0.updatePowerState();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        BRIGHTNESS_RANGE_BOUNDARIES = new float[]{SCREEN_ANIMATION_RATE_MINIMUM, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 20.0f, 30.0f, 40.0f, 50.0f, 60.0f, 70.0f, 80.0f, 90.0f, 100.0f, 200.0f, 300.0f, 400.0f, 500.0f, 600.0f, 700.0f, 800.0f, 900.0f, 1000.0f, 1200.0f, 1400.0f, 1600.0f, 1800.0f, 2000.0f, 2250.0f, 2500.0f, 2750.0f, 3000.0f};
        BRIGHTNESS_RANGE_INDEX = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
    }

    DisplayPowerController(Context context, Injector injector, DisplayManagerInternal.DisplayPowerCallbacks callbacks, Handler handler, SensorManager sensorManager, DisplayBlanker blanker, LogicalDisplay logicalDisplay, BrightnessTracker brightnessTracker, BrightnessSetting brightnessSetting, Runnable onBrightnessChangeRunnable, HighBrightnessModeMetadata hbmMetadata, boolean bootCompleted, DisplayManagerFlags flags) {
        this.mLock = new Object();
        this.mLeadDisplayId = -1;
        this.mCachedBrightnessInfo = new CachedBrightnessInfo();
        this.mReportedScreenStateToPolicy = -1;
        this.mBrightnessReason = new BrightnessReason();
        this.mBrightnessReasonTemp = new BrightnessReason();
        this.mLastStatsBrightness = SCREEN_ANIMATION_RATE_MINIMUM;
        this.mRbcEventRingBuffer = new RingBuffer(BrightnessEvent.class, 20);
        boolean r11 = false;
        this.mSkipRampState = 0;
        this.mDisplayBrightnessFollowers = new SparseArray();
        this.mLastStylusUsageEventTime = -1;
        this.mIdleStylusTimeoutMillisConfig = 0;
        this.mAnimatorListener = new AnonymousClass2(this);
        this.mRampAnimatorListener = new AnonymousClass3(this);
        this.mCleanListener = new DisplayPowerController$$ExternalSyntheticLambda5(this);
        this.mSmtEx = new DisplayPowerControllerSmtEx(this);
        this.mBrightnessAdjustmentFlags = 0;
        this.mExt = (IExtDisplayPowerController) ExtImplFactory.getImpl(IExtDisplayPowerController.class, new Object[]{this});
        Resources resources = context.getResources();
        this.mFlags = flags;
        if (injector == null) goto L5;
        Injector r2 = injector;
    L6:
        this.mInjector = r2;
        this.mClock = this.mInjector.getClock();
        this.mLogicalDisplay = logicalDisplay;
        this.mDisplayId = this.mLogicalDisplay.getDisplayIdLocked();
        this.mDisplayDevice = this.mLogicalDisplay.getPrimaryDisplayDeviceLocked();
        IBinder displayToken = this.mDisplayDevice.getDisplayTokenLocked();
        DisplayDeviceInfo displayDeviceInfo = this.mDisplayDevice.getDisplayDeviceInfoLocked();
        this.mSensorManager = sensorManager;
        this.mHandler = new DisplayControllerHandler(this, handler.getLooper());
        this.mDisplayDeviceConfig = this.mDisplayDevice.getDisplayDeviceConfig();
        this.mIdleStylusTimeoutMillisConfig = this.mDisplayDeviceConfig.getIdleStylusTimeoutMillis();
        this.mIsEnabled = logicalDisplay.isEnabledLocked();
        this.mIsInTransition = logicalDisplay.isInTransitionLocked();
        if (displayDeviceInfo.type != 1) goto L9;
        boolean r6 = true;
    L10:
        this.mIsDisplayInternal = r6;
        this.mWakelockController = this.mInjector.getWakelockController(this.mDisplayId, callbacks);
        this.mDisplayPowerProximityStateController = this.mInjector.getDisplayPowerProximityStateController(this.mWakelockController, this.mDisplayDeviceConfig, this.mHandler.getLooper(), new DisplayPowerController$$ExternalSyntheticLambda6(this), this.mDisplayId, this.mSensorManager);
        this.mDisplayStateController = new DisplayStateController(this.mDisplayPowerProximityStateController, resources.getBoolean(R.bool.config_sms_utf8_support));
        this.mTag = "DisplayPowerController[" + this.mDisplayId + "]";
        this.mUniqueDisplayId = this.mDisplayDevice.getUniqueId();
        this.mDisplayStatsId = this.mUniqueDisplayId.hashCode();
        this.mPhysicalDisplayName = this.mDisplayDevice.getNameLocked();
        this.mLastBrightnessEvent = new BrightnessEvent(this.mDisplayId);
        this.mTempBrightnessEvent = new BrightnessEvent(this.mDisplayId);
        if (flags.isBatteryStatsEnabledForAllDisplays() == false) goto L16;
        if (isDisplaySupportedForBatteryStats(displayDeviceInfo) == false) goto L16;
        this.mBatteryStats = BatteryStatsService.getService();
    L19:
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mWindowManagerPolicy = (WindowManagerPolicy) LocalServices.getService(WindowManagerPolicy.class);
        this.mBlanker = blanker;
        this.mContext = context;
        this.mBrightnessTracker = brightnessTracker;
        this.mOnBrightnessChangeRunnable = onBrightnessChangeRunnable;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "bedtime_mode", 0) != 1) goto L22;
        boolean r0 = true;
    L23:
        this.mIsWearBedtimeModeEnabled = r0;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("bedtime_mode"), false, this.mSettingsObserver, -1);
        this.mScreenBrightnessDozeConfig = BrightnessUtils.clampAbsoluteBrightness(this.mDisplayDeviceConfig.getDefaultDozeBrightness());
        loadBrightnessRampRates();
        this.mSkipScreenOnBrightnessRamp = resources.getBoolean(R.bool.config_spatial_audio_head_tracking_enabled_default);
        this.mDozeScaleFactor = resources.getFraction(R.fraction.config_screenAutoBrightnessDozeScaleFactor, 1, 1);
        Runnable modeChangeCallback = new DisplayPowerController$$ExternalSyntheticLambda7(this);
        HighBrightnessModeController hbmController = createHbmControllerLocked(hbmMetadata, modeChangeCallback);
        this.mBrightnessRangeController = this.mInjector.getBrightnessRangeController(hbmController, modeChangeCallback, this.mDisplayDeviceConfig, this.mHandler, flags, displayToken, displayDeviceInfo);
        this.mDisplayBrightnessController = new DisplayBrightnessController(context, null, this.mDisplayId, this.mLogicalDisplay.getDisplayInfoLocked().brightnessDefault, brightnessSetting, new DisplayPowerController$$ExternalSyntheticLambda8(this), new HandlerExecutor(this.mHandler), flags);
        String thermalBrightnessThrottlingDataId = logicalDisplay.getDisplayInfoLocked().thermalBrightnessThrottlingDataId;
        this.mBrightnessClamperController = this.mInjector.getBrightnessClamperController(this.mHandler, new BrightnessRangeController$$ExternalSyntheticLambda5(modeChangeCallback), new BrightnessClamperController.DisplayDeviceData(this.mUniqueDisplayId, thermalBrightnessThrottlingDataId, logicalDisplay.getPowerThrottlingDataIdLocked(), this.mDisplayDeviceConfig, displayDeviceInfo.width, displayDeviceInfo.height, displayToken, this.mDisplayId), this.mContext, flags, this.mSensorManager, this.mDisplayBrightnessController.getCurrentBrightness());
        saveBrightnessInfo(getScreenBrightnessSetting());
        this.mAutomaticBrightnessStrategy = this.mDisplayBrightnessController.getAutomaticBrightnessStrategy();
        DisplayWhiteBalanceSettings displayWhiteBalanceSettings = null;
        DisplayWhiteBalanceController displayWhiteBalanceController = null;
        if (this.mDisplayId == 0) goto L46;
    L29:
        this.mDisplayWhiteBalanceSettings = displayWhiteBalanceSettings;
        this.mDisplayWhiteBalanceController = displayWhiteBalanceController;
        loadNitsRange(resources);
        if (this.mDisplayId != 0) goto L37;
        this.mCdsi = (ColorDisplayService.ColorDisplayServiceInternal) LocalServices.getService(ColorDisplayService.ColorDisplayServiceInternal.class);
        if (this.mCdsi == null) goto L38;
        boolean active = this.mCdsi.setReduceBrightColorsListener(new AnonymousClass1(this));
        if (active == false) goto L38;
        applyReduceBrightColorsSplineAdjustment();
    L38:
        setUpAutoBrightness(context, handler);
        if (this.mInjector.isColorFadeEnabled() == true) goto L41;
    L44:
        this.mColorFadeEnabled = r11;
        this.mColorFadeFadesConfig = resources.getBoolean(R.bool.config_animateScreenLights);
        this.mDisplayBlanksAfterDozeConfig = resources.getBoolean(R.bool.config_displayWhiteBalanceAvailable);
        this.mBrightnessBucketsInDozeConfig = resources.getBoolean(R.bool.config_displayWhiteBalanceEnabledDefault);
        this.mBootCompleted = bootCompleted;
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswDisplayPowerController(this);
        this.mExt.init();
        return;
    L41:
        if (resources.getBoolean(R.bool.config_displayWhiteBalanceLightModeAllowed) == true) goto L44;
        r11 = true;
        goto L44
    L37:
        this.mCdsi = null;
        goto L38
    L46:
        displayWhiteBalanceController = this.mInjector.getDisplayWhiteBalanceController(this.mHandler, this.mSensorManager, resources);     // Catch: Exception -> L27
        displayWhiteBalanceSettings = new DisplayWhiteBalanceSettings(this.mContext, this.mHandler);     // Catch: Exception -> L27
        displayWhiteBalanceSettings.setCallbacks(this);     // Catch: Exception -> L27
        displayWhiteBalanceController.setCallbacks(this);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Slog.e(this.mTag, "failed to set up display white-balance: " + e);
        goto L29
    L22:
        r0 = false;
    L16:
        if (this.mDisplayId != 0) goto L18;
        this.mBatteryStats = BatteryStatsService.getService();
        goto L19
    L18:
        this.mBatteryStats = null;
        goto L19
    L9:
        r6 = false;
        goto L10
    L5:
        r2 = new Injector();
        goto L6
    }

    private /* synthetic */ void lambda$new$0() {
        updatePowerState();
    }

    private /* synthetic */ void lambda$new$1() {
        sendUpdatePowerState();
        postBrightnessChangeRunnable();
        if (this.mAutomaticBrightnessController == null) goto L6;
        this.mAutomaticBrightnessController.update();
        return;
    }

    private /* synthetic */ void lambda$new$2() {
        postBrightnessChangeRunnable();
    }

    private void applyReduceBrightColorsSplineAdjustment() {
        this.mHandler.obtainMessage(9).sendToTarget();
        sendUpdatePowerState();
    }

    private void handleRbcChanged() {
        if (this.mAutomaticBrightnessController != null) goto L5;
        return;
    L5:
        float[] adjustedNits = new float[this.mNitsRange.length];
        int i = 0;
    L7:
        if (i >= this.mNitsRange.length) goto L9;
        adjustedNits[i] = this.mCdsi.getReduceBrightColorsAdjustedBrightnessNits(this.mNitsRange[i]);
        i = i + 1;
        goto L7
    L9:
        this.mIsRbcActive = this.mCdsi.isReduceBrightColorsActivated();
        this.mAutomaticBrightnessController.recalculateSplines(this.mIsRbcActive, adjustedNits);
    }

    public boolean isProximitySensorAvailable() {
        return this.mDisplayPowerProximityStateController.isProximitySensorAvailable();
    }

    public ParceledListSlice<BrightnessChangeEvent> getBrightnessEvents(int userId, boolean includePackage) {
        if (this.mBrightnessTracker != null) goto L7;
        return null;
    L7:
        return this.mBrightnessTracker.getEvents(userId, includePackage);
    }

    public void onSwitchUser(int newUserId, int userSerial, float newBrightness) {
        Message msg = this.mHandler.obtainMessage(12, newUserId, userSerial, Float.valueOf(newBrightness));
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void handleOnSwitchUser(int newUserId, int userSerial, float newBrightness) {
        Slog.i(this.mTag, "Switching user newUserId=" + newUserId + " userSerial=" + userSerial + " newBrightness=" + newBrightness);
        if (this.mAutomaticBrightnessController == null) goto L7;
        int autoBrightnessPreset = Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness_for_als", 2, -2);
        if (autoBrightnessPreset == this.mAutomaticBrightnessController.getPreset()) goto L7;
        setUpAutoBrightness(this.mContext, this.mHandler);
    L7:
        handleBrightnessModeChange();
        if (this.mBrightnessTracker == null) goto L10;
        this.mBrightnessTracker.onSwitchUser(newUserId);
    L10:
        setBrightness(newBrightness, userSerial);
        this.mDisplayBrightnessController.setAndNotifyCurrentScreenBrightness(newBrightness);
        if (this.mAutomaticBrightnessController == null) goto L13;
        this.mAutomaticBrightnessController.resetShortTermModel();
    L13:
        this.mBrightnessClamperController.onUserSwitch();
        sendUpdatePowerState();
    }

    public ParceledListSlice<AmbientBrightnessDayStats> getAmbientBrightnessStats(int userId) {
        if (this.mBrightnessTracker != null) goto L7;
        return null;
    L7:
        return this.mBrightnessTracker.getAmbientBrightnessStats(userId);
    }

    public void persistBrightnessTrackerState() {
        if (this.mBrightnessTracker == null) goto L6;
        this.mBrightnessTracker.persistBrightnessTrackerState();
        return;
    }

    public boolean requestPowerState(DisplayManagerInternal.DisplayPowerRequest request, boolean waitForNegativeProximity) {
        if (DEBUG == false) goto L5;
        Slog.d(this.mTag, "requestPowerState: " + request + ", waitForNegativeProximity=" + waitForNegativeProximity);
    L5:
        this.mExt.requestPowerState(request, this.mPendingRequestLocked, waitForNegativeProximity);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mStopped == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L13:
        boolean changed = this.mDisplayPowerProximityStateController.setPendingWaitForNegativeProximityLocked(waitForNegativeProximity);     // Catch: Throwable -> L11
        if (this.mPendingRequestLocked != null) goto L17;
        this.mPendingRequestLocked = new DisplayManagerInternal.DisplayPowerRequest(request);     // Catch: Throwable -> L11
        changed = true;
    L19:
        if (changed == false) goto L23;
        this.mDisplayReadyLocked = false;     // Catch: Throwable -> L11
        if (this.mPendingRequestChangedLocked == true) goto L23;
        this.mPendingRequestChangedLocked = true;     // Catch: Throwable -> L11
        sendUpdatePowerStateLocked();     // Catch: Throwable -> L11
    L23:
        boolean r2 = this.mDisplayReadyLocked;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L17:
        if (this.mPendingRequestLocked.equals(request) == true) goto L19;
        this.mPendingRequestLocked.copyFrom(request);     // Catch: Throwable -> L11
        changed = true;
        goto L19
    }

    public void overrideDozeScreenState(int displayState, final int reason) {
        Slog.i(TAG, "New offload doze override: " + Display.stateToString(displayState));
        if (this.mDisplayOffloadSession != null) goto L5;
        return;
    L5:
        if (DisplayManagerInternal.DisplayOffloadSession.isSupportedOffloadState(displayState) == true) goto L8;
        if (displayState == 0) goto L8;
        return;
    L8:
        if (this.mFlags.isOffloadDozeOverrideHoldsWakelockEnabled() == false) goto L10;
        this.mWakelockController.acquireWakelock(5);
    L10:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingOverrideDozeScreenStateLocked = displayState;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        this.mHandler.postAtTime(new DisplayPowerController$$ExternalSyntheticLambda10(this, reason), this.mClock.uptimeMillis());
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$overrideDozeScreenState$3(int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayStateController.overrideDozeScreenState(this.mPendingOverrideDozeScreenStateLocked, reason);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        updatePowerState();
        if (this.mFlags.isOffloadDozeOverrideHoldsWakelockEnabled() == false) goto L15;
        this.mWakelockController.releaseWakelock(5);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setBrightnessOverrideRequest(DisplayManagerInternal.DisplayBrightnessOverrideRequest request) {
        Message msg = this.mHandler.obtainMessage(21, request);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    public void setDisplayOffloadSession(DisplayManagerInternal.DisplayOffloadSession session) {
        if (session != this.mDisplayOffloadSession) goto L5;
        return;
    L5:
        unblockScreenOnByDisplayOffload();
        this.mDisplayOffloadSession = session;
    }

    public BrightnessConfiguration getDefaultBrightnessConfiguration() {
        if (this.mAutomaticBrightnessController != null) goto L7;
        return null;
    L7:
        return this.mAutomaticBrightnessController.getDefaultConfig();
    }

    public void onDisplayChanged(final HighBrightnessModeMetadata hbmMetadata, int leadDisplayId) {
        this.mLeadDisplayId = leadDisplayId;
        final DisplayDevice device = this.mLogicalDisplay.getPrimaryDisplayDeviceLocked();
        if (device != null) goto L6;
        Slog.wtf(this.mTag, "Display Device is null in DisplayPowerController for display: " + this.mLogicalDisplay.getDisplayIdLocked());
        return;
    L6:
        final String uniqueId = device.getUniqueId();
        final String displayName = device.getNameLocked();
        final DisplayDeviceConfig config = device.getDisplayDeviceConfig();
        final IBinder token = device.getDisplayTokenLocked();
        final DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        final boolean isEnabled = this.mLogicalDisplay.isEnabledLocked();
        final boolean isInTransition = this.mLogicalDisplay.isInTransitionLocked();
        if (this.mLogicalDisplay.getPrimaryDisplayDeviceLocked() == null) goto L11;
        boolean r10 = true;
        if (this.mLogicalDisplay.getPrimaryDisplayDeviceLocked().getDisplayDeviceInfoLocked().type != 1) goto L11;
    L10:
        final boolean isDisplayInternal = r10;
        final String thermalBrightnessThrottlingDataId = this.mLogicalDisplay.getDisplayInfoLocked().thermalBrightnessThrottlingDataId;
        final String powerThrottlingDataId = this.mLogicalDisplay.getPowerThrottlingDataIdLocked();
        this.mHandler.postAtTime(new DisplayPowerController$$ExternalSyntheticLambda3(this, isEnabled, isInTransition, device, uniqueId, displayName, config, token, info, hbmMetadata, isDisplayInternal, thermalBrightnessThrottlingDataId, powerThrottlingDataId), this.mClock.uptimeMillis());
        return;
    L11:
        r10 = false;
        goto L10
    }

    private /* synthetic */ void lambda$onDisplayChanged$4(boolean isEnabled, boolean isInTransition, DisplayDevice device, String uniqueId, String displayName, DisplayDeviceConfig config, IBinder token, DisplayDeviceInfo info, HighBrightnessModeMetadata hbmMetadata, boolean isDisplayInternal, String thermalBrightnessThrottlingDataId, String powerThrottlingDataId) {
        if (this.mStopped == false) goto L5;
        return;
    L5:
        boolean changed = false;
        if (this.mIsEnabled == isEnabled) goto L8;
    L9:
        changed = true;
        this.mIsEnabled = isEnabled;
        this.mIsInTransition = isInTransition;
    L11:
        if (this.mDisplayDevice == device) goto L13;
        this.mDisplayDevice = device;
        String r5 = uniqueId;
        this.mUniqueDisplayId = r5;
        this.mPhysicalDisplayName = displayName;
        this.mDisplayStatsId = this.mUniqueDisplayId.hashCode();
        this.mDisplayDeviceConfig = config;
        this.mIdleStylusTimeoutMillisConfig = this.mDisplayDeviceConfig.getIdleStylusTimeoutMillis();
        IBinder r11 = token;
        loadFromDisplayDeviceConfig(r11, info, hbmMetadata);
        this.mDisplayPowerProximityStateController.notifyDisplayDeviceChanged(config);
        this.mPowerState.resetScreenState();
        boolean changed2 = true;
    L14:
        this.mIsDisplayInternal = isDisplayInternal;
        this.mBrightnessClamperController.onDisplayChanged(new BrightnessClamperController.DisplayDeviceData(r5, thermalBrightnessThrottlingDataId, powerThrottlingDataId, config, info.width, info.height, r11, this.mDisplayId));
        if (changed2 == false) goto L18;
        updatePowerState();
        return;
    L18:
        return;
    L13:
        r5 = uniqueId;
        r11 = token;
        changed2 = changed;
        goto L14
    L8:
        if (this.mIsInTransition == isInTransition) goto L11;
        goto L9
    }

    public void stop() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        clearDisplayBrightnessFollowersLocked();     // Catch: Throwable -> L7
        this.mStopped = true;     // Catch: Throwable -> L7
        Message msg = this.mHandler.obtainMessage(7);     // Catch: Throwable -> L7
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());     // Catch: Throwable -> L7
        if (this.mAutomaticBrightnessController == null) goto L9;
        this.mAutomaticBrightnessController.stop();     // Catch: Throwable -> L7
    L9:
        this.mDisplayBrightnessController.stop();     // Catch: Throwable -> L7
        this.mContext.getContentResolver().unregisterContentObserver(this.mSettingsObserver);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void loadFromDisplayDeviceConfig(IBinder token, DisplayDeviceInfo info, HighBrightnessModeMetadata hbmMetadata) {
        this.mScreenBrightnessDozeConfig = BrightnessUtils.clampAbsoluteBrightness(this.mDisplayDeviceConfig.getDefaultDozeBrightness());
        loadBrightnessRampRates();
        loadNitsRange(this.mContext.getResources());
        setUpAutoBrightness(this.mContext, this.mHandler);
        reloadReduceBrightColours();
        setAnimatorRampSpeeds(false);
        this.mBrightnessRangeController.loadFromConfig(hbmMetadata, token, info, this.mDisplayDeviceConfig);
    }

    private void sendUpdatePowerState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        sendUpdatePowerStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void sendUpdatePowerStateLocked() {
        if (this.mStopped == false) goto L5;
        return;
    L5:
        if (this.mPendingUpdatePowerStateLocked == true) goto L9;
        this.mPendingUpdatePowerStateLocked = true;
        Message msg = this.mHandler.obtainMessage(1);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
        return;
    }

    private void initialize(int displayState) {
        Injector r1 = this.mInjector;
        DisplayBlanker r2 = this.mBlanker;
        if (this.mColorFadeEnabled == false) goto L5;
        ColorFade r3 = new ColorFade(this.mDisplayId);
    L6:
        this.mPowerState = r1.getDisplayPowerState(r2, r3, this.mDisplayId, displayState);
        if (this.mColorFadeEnabled == false) goto L9;
        this.mColorFadeOnAnimator = ObjectAnimator.ofFloat(this.mPowerState, DisplayPowerState.COLOR_FADE_LEVEL, new float[]{SCREEN_ANIMATION_RATE_MINIMUM, 1.0f});
        this.mColorFadeOnAnimator.setDuration(250);
        this.mColorFadeOnAnimator.addListener(this.mAnimatorListener);
        this.mColorFadeOffAnimator = ObjectAnimator.ofFloat(this.mPowerState, DisplayPowerState.COLOR_FADE_LEVEL, new float[]{1.0f, SCREEN_ANIMATION_RATE_MINIMUM});
        this.mColorFadeOffAnimator.setDuration(100);
        this.mColorFadeOffAnimator.addListener(this.mAnimatorListener);
    L9:
        this.mScreenBrightnessRampAnimator = this.mInjector.getDualRampAnimator(this.mPowerState, DisplayPowerState.SCREEN_BRIGHTNESS_FLOAT, DisplayPowerState.SCREEN_SDR_BRIGHTNESS_FLOAT);
        if (this.mAutomaticBrightnessController != null) goto L12;
    L14:
        boolean r0 = false;
    L15:
        setAnimatorRampSpeeds(r0);
        this.mScreenBrightnessRampAnimator.setListener(this.mRampAnimatorListener);
        noteScreenState(this.mPowerState.getScreenState(), 1);
        noteScreenBrightness(this.mPowerState.getScreenBrightness());
        float brightness = this.mDisplayBrightnessController.convertToAdjustedNits(this.mPowerState.getScreenBrightness());
        if (this.mBrightnessTracker != null) goto L18;
    L20:
        BrightnessSetting.BrightnessSettingListener brightnessSettingListener = new DisplayPowerController$$ExternalSyntheticLambda1(this);
        this.mDisplayBrightnessController.registerBrightnessSettingChangeListener(brightnessSettingListener);
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_auto_brightness_adj"), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness_mode"), false, this.mSettingsObserver, -1);
        if (this.mFlags.areAutoBrightnessModesEnabled() == false) goto L23;
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness_for_als"), false, this.mSettingsObserver, -1);
    L23:
        this.mExt.initialize();
        handleBrightnessModeChange();
        return;
    L18:
        if (brightness < SCREEN_ANIMATION_RATE_MINIMUM) goto L20;
        this.mBrightnessTracker.start(brightness);
        goto L20
    L12:
        if (this.mAutomaticBrightnessController.isInIdleMode() == false) goto L14;
        r0 = true;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    private /* synthetic */ void lambda$initialize$5(float brightnessValue) {
        Message msg = this.mHandler.obtainMessage(8, Float.valueOf(brightnessValue));
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void setUpAutoBrightness(Context context, Handler handler) {
        this.mUseSoftwareAutoBrightnessConfig = this.mDisplayDeviceConfig.isAutoBrightnessAvailable();
        if (this.mUseSoftwareAutoBrightnessConfig == true) goto L5;
        return;
    L5:
        SparseArray<BrightnessMappingStrategy> brightnessMappers = new SparseArray();
        BrightnessMappingStrategy defaultModeBrightnessMapper = this.mInjector.getDefaultModeBrightnessMapper(context, this.mDisplayDeviceConfig, this.mDisplayWhiteBalanceController);
        brightnessMappers.append(0, defaultModeBrightnessMapper);
        boolean isIdleScreenBrightnessEnabled = context.getResources().getBoolean(R.bool.config_enableMultipleAdmins);
        if (isIdleScreenBrightnessEnabled == false) goto L10;
        BrightnessMappingStrategy idleModeBrightnessMapper = BrightnessMappingStrategy.create(context, this.mDisplayDeviceConfig, 1, this.mDisplayWhiteBalanceController);
        if (idleModeBrightnessMapper == null) goto L10;
        brightnessMappers.append(1, idleModeBrightnessMapper);
    L10:
        BrightnessMappingStrategy dozeModeBrightnessMapper = BrightnessMappingStrategy.create(context, this.mDisplayDeviceConfig, 2, this.mDisplayWhiteBalanceController);
        if (this.mFlags.areAutoBrightnessModesEnabled() == false) goto L15;
        if (dozeModeBrightnessMapper == null) goto L15;
        brightnessMappers.put(2, dozeModeBrightnessMapper);
    L15:
        if (this.mFlags.areAutoBrightnessModesEnabled() == false) goto L22;
        if (this.mFlags.isAutoBrightnessModeBedtimeWearEnabled() == false) goto L22;
        BrightnessMappingStrategy bedtimeBrightnessMapper = BrightnessMappingStrategy.create(context, this.mDisplayDeviceConfig, 3, this.mDisplayWhiteBalanceController);
        if (bedtimeBrightnessMapper == null) goto L22;
        brightnessMappers.put(3, bedtimeBrightnessMapper);
    L22:
        if (this.mAutomaticBrightnessController == null) goto L24;
        float userLux = this.mAutomaticBrightnessController.getUserLux();
        float userNits = this.mAutomaticBrightnessController.getUserNits();
        float userLux2 = userLux;
        float userNits2 = userNits;
    L25:
        if (defaultModeBrightnessMapper == null) goto L50;
        HysteresisLevels ambientBrightnessThresholds = this.mDisplayDeviceConfig.getAmbientBrightnessHysteresis();
        HysteresisLevels screenBrightnessThresholds = this.mDisplayDeviceConfig.getScreenBrightnessHysteresis();
        HysteresisLevels ambientBrightnessThresholdsIdle = this.mDisplayDeviceConfig.getAmbientBrightnessIdleHysteresis();
        HysteresisLevels screenBrightnessThresholdsIdle = this.mDisplayDeviceConfig.getScreenBrightnessIdleHysteresis();
        long brighteningLightDebounce = this.mDisplayDeviceConfig.getAutoBrightnessBrighteningLightDebounce();
        long darkeningLightDebounce = this.mDisplayDeviceConfig.getAutoBrightnessDarkeningLightDebounce();
        long brighteningLightDebounceIdle = this.mDisplayDeviceConfig.getAutoBrightnessBrighteningLightDebounceIdle();
        long darkeningLightDebounceIdle = this.mDisplayDeviceConfig.getAutoBrightnessDarkeningLightDebounceIdle();
        boolean autoBrightnessResetAmbientLuxAfterWarmUp = context.getResources().getBoolean(R.bool.config_autoPowerModeUseMotionSensor);
        int lightSensorWarmUpTimeConfig = context.getResources().getInteger(R.integer.config_maxDesktopWindowingActiveTasks);
        int lightSensorRate = context.getResources().getInteger(R.integer.config_bg_current_drain_location_min_duration);
        int initialLightSensorRate = context.getResources().getInteger(R.integer.config_bg_current_drain_exempted_types);
        if (initialLightSensorRate != (-1)) goto L29;
        int initialLightSensorRate2 = lightSensorRate;
    L32:
        loadAmbientLightSensor();
        if (this.mBrightnessTracker == null) goto L38;
        if (this.mDisplayId != 0) goto L38;
        this.mBrightnessTracker.setLightSensor(this.mLightSensor);
    L38:
        if (this.mAutomaticBrightnessController == null) goto L40;
        this.mAutomaticBrightnessController.stop();
    L40:
        this.mAutomaticBrightnessController = this.mInjector.getAutomaticBrightnessController(this, handler.getLooper(), this.mSensorManager, this.mLightSensor, brightnessMappers, lightSensorWarmUpTimeConfig, SCREEN_ANIMATION_RATE_MINIMUM, 1.0f, this.mDozeScaleFactor, lightSensorRate, initialLightSensorRate2, brighteningLightDebounce, darkeningLightDebounce, brighteningLightDebounceIdle, darkeningLightDebounceIdle, autoBrightnessResetAmbientLuxAfterWarmUp, ambientBrightnessThresholds, screenBrightnessThresholds, ambientBrightnessThresholdsIdle, screenBrightnessThresholdsIdle, this.mContext, this.mBrightnessRangeController, this.mBrightnessClamperController, this.mDisplayDeviceConfig.getAmbientHorizonShort(), this.mDisplayDeviceConfig.getAmbientHorizonLong(), userLux2, userNits2, this.mFlags);
        this.mAutomaticBrightnessController.getExt().setDisplayId(this.mDisplayId);
        this.mDisplayBrightnessController.setUpAutoBrightness(this.mAutomaticBrightnessController, this.mSensorManager, this.mDisplayDeviceConfig, this.mHandler, defaultModeBrightnessMapper, this.mIsEnabled, this.mLeadDisplayId);
        this.mBrightnessEventRingBuffer = new RingBuffer(BrightnessEvent.class, 100);
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L43;
        return;
    L43:
        if (this.mScreenOffBrightnessSensorController == null) goto L45;
        this.mScreenOffBrightnessSensorController.stop();
        this.mScreenOffBrightnessSensorController = null;
    L45:
        loadScreenOffBrightnessSensor();
        int[] sensorValueToLux = this.mDisplayDeviceConfig.getScreenOffBrightnessSensorValueToLux();
        if (this.mScreenOffBrightnessSensor == null) goto L54;
        if (sensorValueToLux == null) goto L55;
        this.mScreenOffBrightnessSensorController = this.mInjector.getScreenOffBrightnessSensorController(this.mSensorManager, this.mScreenOffBrightnessSensor, this.mHandler, new DisplayPowerController$$ExternalSyntheticLambda2(), sensorValueToLux, defaultModeBrightnessMapper);
        return;
    L55:
        return;
    L54:
        return;
    L29:
        if (initialLightSensorRate <= lightSensorRate) goto L31;
        Slog.w(this.mTag, "Expected config_autoBrightnessInitialLightSensorRate (" + initialLightSensorRate + ") to be less than or equal to config_autoBrightnessLightSensorRate (" + lightSensorRate + ").");
    L31:
        initialLightSensorRate2 = initialLightSensorRate;
        goto L32
    L50:
        this.mUseSoftwareAutoBrightnessConfig = false;
        return;
    L24:
        userLux2 = -1.0f;
        userNits2 = -1.0f;
        goto L25
    }

    private void loadBrightnessRampRates() {
        this.mBrightnessRampRateFastDecrease = this.mDisplayDeviceConfig.getBrightnessRampFastDecrease();
        this.mBrightnessRampRateFastIncrease = this.mDisplayDeviceConfig.getBrightnessRampFastIncrease();
        this.mBrightnessRampRateSlowDecrease = this.mDisplayDeviceConfig.getBrightnessRampSlowDecrease();
        this.mBrightnessRampRateSlowIncrease = this.mDisplayDeviceConfig.getBrightnessRampSlowIncrease();
        this.mBrightnessRampRateSlowDecreaseIdle = this.mDisplayDeviceConfig.getBrightnessRampSlowDecreaseIdle();
        this.mBrightnessRampRateSlowIncreaseIdle = this.mDisplayDeviceConfig.getBrightnessRampSlowIncreaseIdle();
        this.mBrightnessRampDecreaseMaxTimeMillis = this.mDisplayDeviceConfig.getBrightnessRampDecreaseMaxMillis();
        this.mBrightnessRampIncreaseMaxTimeMillis = this.mDisplayDeviceConfig.getBrightnessRampIncreaseMaxMillis();
        this.mBrightnessRampDecreaseMaxTimeIdleMillis = this.mDisplayDeviceConfig.getBrightnessRampDecreaseMaxIdleMillis();
        this.mBrightnessRampIncreaseMaxTimeIdleMillis = this.mDisplayDeviceConfig.getBrightnessRampIncreaseMaxIdleMillis();
    }

    private void loadNitsRange(Resources resources) {
        if (this.mDisplayDeviceConfig != null) goto L5;
    L7:
        Slog.w(this.mTag, "Screen brightness nits configuration is unavailable; falling back");
        this.mNitsRange = BrightnessMappingStrategy.getFloatArray(resources.obtainTypedArray(R.array.config_tether_bluetooth_regexs));
        return;
    L5:
        if (this.mDisplayDeviceConfig.getNits() == null) goto L7;
        this.mNitsRange = this.mDisplayDeviceConfig.getNits();
    }

    private void reloadReduceBrightColours() {
        if (this.mCdsi != null) goto L5;
        return;
    L5:
        if (this.mCdsi.isReduceBrightColorsActivated() == false) goto L9;
        applyReduceBrightColorsSplineAdjustment();
        return;
    }

    public void setAutomaticScreenBrightnessMode(int mode) {
        Message msg = this.mHandler.obtainMessage();
        msg.what = 14;
        msg.arg1 = mode;
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void setAnimatorRampSpeeds(boolean isIdle) {
        if (this.mScreenBrightnessRampAnimator != null) goto L6;
        return;
    L6:
        if (this.mFlags.isAdaptiveTone1Enabled() == false) goto L9;
        if (isIdle == false) goto L9;
        this.mScreenBrightnessRampAnimator.setAnimationTimeLimits(this.mBrightnessRampIncreaseMaxTimeIdleMillis, this.mBrightnessRampDecreaseMaxTimeIdleMillis);
        return;
    L9:
        this.mScreenBrightnessRampAnimator.setAnimationTimeLimits(this.mBrightnessRampIncreaseMaxTimeMillis, this.mBrightnessRampDecreaseMaxTimeMillis);
    }

    private void cleanupHandlerThreadAfterStop() {
        this.mDisplayPowerProximityStateController.cleanup();
        this.mBrightnessRangeController.stop();
        this.mBrightnessClamperController.stop();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mWakelockController.releaseAll();
        if (this.mPowerState == null) goto L5;
        float brightness = this.mPowerState.getScreenBrightness();
    L6:
        reportStats(brightness);
        if (this.mPowerState == null) goto L10;
        this.mPowerState.stop();
        this.mPowerState = null;
    L10:
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == true) goto L15;
        if (this.mScreenOffBrightnessSensorController == null) goto L15;
        this.mScreenOffBrightnessSensorController.stop();
    L15:
        if (this.mDisplayWhiteBalanceController == null) goto L18;
        this.mDisplayWhiteBalanceController.setEnabled(false);
        return;
    L18:
        return;
    L5:
        brightness = SCREEN_ANIMATION_RATE_MINIMUM;
        goto L6
    }

    private void updatePowerState() {
        Trace.traceBegin(131072, "DisplayPowerController#updatePowerState");
        updatePowerStateInternal();
        Trace.traceEnd(131072);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePowerStateInternal() {
        this.mExt.updatePowerStateInternalReset();
        this.mBrightnessReasonTemp.set(null);
        this.mTempBrightnessEvent.reset();
        Object r4 = this.mLock;
        monitor-enter(r4);
    L8:
        th = th;
    L484:
        monitor-exit(r4);     // Catch: Throwable -> L8
        throw th;
    L5:
        if (this.mStopped == false) goto L10;
        monitor-exit(r4);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPendingUpdatePowerStateLocked = false;     // Catch: Throwable -> L8
        if (this.mPendingRequestLocked != null) goto L15;
        monitor-exit(r4);     // Catch: Throwable -> L8
        return;
    L15:
        if (this.mPowerRequest != null) goto L18;
        this.mPowerRequest = new DisplayManagerInternal.DisplayPowerRequest(this.mPendingRequestLocked);     // Catch: Throwable -> L8
        this.mDisplayPowerProximityStateController.updatePendingProximityRequestsLocked();     // Catch: Throwable -> L8
        this.mPendingRequestChangedLocked = false;     // Catch: Throwable -> L8
        Object[] r8 = true;
        int r9 = 3;
    L488:
        if (this.mDisplayReadyLocked == true) goto L26;
        Object[] r3 = true;
    L27:
        Object[] r11 = r3;
        SparseArray<DisplayPowerController> r2 = this.mDisplayBrightnessFollowers.clone();     // Catch: Throwable -> L480
        this.mExt.updatePowerRequst(r9, this.mPowerRequest);     // Catch: Throwable -> L480
        monitor-exit(r4);     // Catch: Throwable -> L480
        Pair<Integer, Integer> r13 = this.mDisplayStateController.updateDisplayState(this.mPowerRequest, this.mIsEnabled, this.mIsInTransition);
        int r5 = ((Integer) r13.first).intValue();
        if (r8 == true) goto L33;
    L37:
        int r14 = this.mPowerState.getScreenState();
        animateScreenStateChange(r5, ((Integer) r13.second).intValue(), this.mDisplayStateController.shouldPerformScreenOffTransition());
        int r6 = this.mPowerState.getScreenState();
        if (this.mFlags.isNormalBrightnessForDozeParameterEnabled(this.mContext) == true) goto L40;
        boolean r7 = Display.isDozeState(r6);
    L48:
        boolean r24 = r7;
        DisplayBrightnessState r10 = this.mDisplayBrightnessController.updateBrightness(this.mPowerRequest, r6, this.mDisplayOffloadSession, this.mIsWearBedtimeModeEnabled);
        float r12 = r10.getBrightness();
        float r15 = r10.getBrightness();
        this.mBrightnessReasonTemp.set(r10.getBrightnessReason());
        boolean r16 = r10.isSlowChange();
        float r17 = r10.getCustomAnimationRate();
        int r25 = r10.getBrightnessAdjustmentFlag();
        boolean r22 = this.mDisplayBrightnessController.getIsUserSetScreenBrightnessUpdated();
        if (r10.getBrightnessEvent() == null) goto L51;
        this.mTempBrightnessEvent.copyFrom(r10.getBrightnessEvent());
    L51:
        boolean r18 = this.mDisplayBrightnessController.isAllowAutoBrightnessWhileDozing();
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == true) goto L75;
        if (this.mScreenOffBrightnessSensorController == null) goto L75;
        ScreenOffBrightnessSensorController r0 = this.mScreenOffBrightnessSensorController;
        if (r10.getShouldUseAutoBrightness() == false) goto L70;
        if (this.mIsEnabled == false) goto L70;
        if (this.mPowerRequest.policy == 0) goto L67;
        if (this.mPowerRequest.policy != 1) goto L70;
        if (r18 == true) goto L70;
    L67:
        if (this.mLeadDisplayId != (-1)) goto L70;
        boolean r19 = true;
    L71:
        r0.setLightSensorEnabled(r19);
    L70:
        r19 = false;
    L75:
        if (this.mZswExt.useFakeSleepBrightness(this.mPowerRequest.policy) == false) goto L77;
        r12 = this.mZswExt.getFakeSleepBrightness();
        this.mBrightnessReasonTemp.setReason(13);
    L77:
        boolean r27 = this.mAutomaticBrightnessStrategy.isShortTermModelActive();
        boolean r1 = r10.isUserInitiatedChange();
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L80;
        boolean r28 = r1;
        int r110 = r6;
    L94:
        if (this.mAutomaticBrightnessStrategy.isAutoBrightnessEnabled() == false) goto L97;
        int r20 = 1;
    L100:
        this.mBrightnessRangeController.setAutoBrightnessEnabled(r20);
        boolean r21 = r10.shouldUpdateScreenBrightnessSetting();
        float r23 = this.mDisplayBrightnessController.getCurrentBrightness();
        boolean r30 = this.mExt.skipOverrideBrightness2Auto();
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L103;
    L135:
        float r32 = -1.0f;
    L136:
        int r26 = r25;
    L138:
        if (Float.isNaN(r12) == true) goto L140;
        r12 = clampScreenBrightness(r12);
    L140:
        if (r24 == false) goto L161;
        if (Float.isNaN(r12) == true) goto L148;
        if (r10.getDisplayBrightnessStrategyName().equals(DisplayBrightnessStrategyConstants.FALLBACK_BRIGHTNESS_STRATEGY_NAME) == false) goto L161;
    L148:
        if (this.mFlags.isDisplayOffloadEnabled() == false) goto L157;
        if (this.mDisplayOffloadSession == null) goto L157;
        if (this.mAutomaticBrightnessController != null) goto L154;
    L155:
        r15 = getDozeBrightnessForOffload();
        r12 = clampScreenBrightness(r15);
        this.mBrightnessReasonTemp.setReason(12);
        this.mTempBrightnessEvent.setFlags(this.mTempBrightnessEvent.getFlags() | 4);
    L159:
        boolean r29 = false;
    L163:
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == true) goto L178;
        if (Float.isNaN(r12) == false) goto L178;
        if (this.mAutomaticBrightnessStrategy.isAutoBrightnessEnabled() == false) goto L178;
        if (this.mScreenOffBrightnessSensorController == null) goto L178;
        r15 = this.mScreenOffBrightnessSensorController.getAutomaticScreenBrightness();
        r12 = r15;
        if (BrightnessUtils.isValidBrightnessValue(r12) == false) goto L178;
        r12 = clampScreenBrightness(r12);
        if (this.mDisplayBrightnessController.getCurrentBrightness() == r12) goto L175;
        boolean r111 = true;
    L176:
        this.mBrightnessReasonTemp.setReason(9);
        r29 = r111;
        goto L178
    L175:
        r111 = false;
    L178:
        if (Float.isNaN(r12) == false) goto L186;
        if (this.mFlags.isRefactorDisplayPowerControllerEnabled() == true) goto L186;
        float r31 = clampScreenBrightness(r23);
        if (r31 == r23) goto L184;
        r29 = true;
    L184:
        float r33 = this.mExt.overrideManuBrightness(r31);
        this.mBrightnessReasonTemp.setReason(1);
        boolean r210 = r29;
        float r112 = r33;
        float r34 = r23;
    L190:
        if (this.mAutomaticBrightnessController != null) goto L192;
        float r35 = SCREEN_ANIMATION_RATE_MINIMUM;
    L193:
        float r113 = r35;
        int r36 = 0;
    L195:
        if (r36 >= r2.size()) goto L197;
        r2.valueAt(r36).setBrightnessToFollow(r34, this.mDisplayBrightnessController.convertToNits(r34), r113, r16);
        r36 = r36 + 1;
        goto L195
    L197:
        float r37 = r34;
        int r211 = r110;
        DisplayBrightnessState r114 = this.mBrightnessClamperController.clamp(r10, this.mPowerRequest, r112, r16, r211);
        int r38 = r211;
        float r39 = r114.getBrightness();
        boolean r115 = r114.isSlowChange();
        float r40 = Math.max(r17, r114.getCustomAnimationRate());
        this.mBrightnessReasonTemp.addModifier(r114.getBrightnessReason().getModifier());
        this.mExt.onBrightnessClampedForManualRange(r39);
        if (r210 == false) goto L201;
        this.mDisplayBrightnessController.updateScreenBrightnessSetting(MathUtils.constrain(r37, r114.getMinBrightness(), r114.getMaxBrightness()), Math.min(this.mBrightnessRangeController.getCurrentBrightnessMax(), r114.getMaxBrightness()));
    L201:
        this.mBrightnessRangeController.onBrightnessChanged(r39, r37, r114);
        if (this.mBrightnessReasonTemp.getReason() != 7) goto L204;
    L207:
        boolean r41 = true;
    L208:
        boolean r42 = r41;
        if (this.mPendingScreenOff == false) goto L211;
        int r116 = r26;
        float r43 = r39;
        boolean r44 = r27;
        int r45 = r38;
        boolean r46 = r28;
        float r117 = r37;
        boolean r47 = saveBrightnessInfo(getScreenBrightnessSetting(), r114);
        boolean r48 = r115;
        float r49 = 0.0f;
    L349:
        if (r47 == false) goto L353;
        if (r42 == true) goto L353;
        postBrightnessChangeRunnable();
    L353:
        if (this.mBrightnessReasonTemp.equals(this.mBrightnessReason) == false) goto L362;
        if (r116 != 0) goto L362;
        if (this.mBrightnessReasonTemp.getReason() != 1) goto L363;
        if (r22 == false) goto L363;
        Slog.v(this.mTag, "Brightness [" + r43 + "] manual adjustment.");
    L363:
        this.mTempBrightnessEvent.setTime(System.currentTimeMillis());
        this.mTempBrightnessEvent.setBrightness(r43);
        this.mTempBrightnessEvent.setNits(this.mDisplayBrightnessController.convertToAdjustedNits(r43));
        float r50 = this.mBrightnessRangeController.getCurrentBrightnessMax();
        float r51 = MathUtils.constrainedMap(SCREEN_ANIMATION_RATE_MINIMUM, 1.0f, r114.getMinBrightness(), Math.min(r114.getMaxBrightness(), r50), r43);
        if (this.mCdsi != null) goto L366;
    L368:
        boolean r52 = false;
    L369:
        boolean r118 = r52;
        this.mTempBrightnessEvent.setPercent(Math.round((com.android.internal.display.BrightnessUtils.convertLinearToGamma(r51) * 1000.0f) / 10.0f));
        this.mTempBrightnessEvent.setUnclampedBrightness(r117);
        this.mTempBrightnessEvent.setPhysicalDisplayId(this.mUniqueDisplayId);
        this.mTempBrightnessEvent.setPhysicalDisplayName(this.mPhysicalDisplayName);
        this.mTempBrightnessEvent.setDisplayState(r45);
        this.mTempBrightnessEvent.setDisplayStateReason(((Integer) r13.second).intValue());
        this.mTempBrightnessEvent.setDisplayPolicy(this.mPowerRequest.policy);
        this.mTempBrightnessEvent.setReason(this.mBrightnessReason);
        this.mTempBrightnessEvent.setHbmMax(r50);
        this.mTempBrightnessEvent.setHbmMode(this.mBrightnessRangeController.getHighBrightnessMode());
        BrightnessEvent r53 = this.mTempBrightnessEvent;
        int r54 = this.mTempBrightnessEvent.getFlags() | (this.mIsRbcActive ? 1 : 0);
        if (this.mPowerRequest.lowPowerMode == false) goto L372;
        int r55 = 32;
    L373:
        int r56 = r54 | r55;
        if (r118 == false) goto L376;
        int r310 = 64;
    L377:
        r53.setFlags(r56 | r310);
        BrightnessEvent r57 = this.mTempBrightnessEvent;
        if (this.mCdsi == null) goto L380;
        int r58 = this.mCdsi.getReduceBrightColorsStrength();
    L381:
        r57.setRbcStrength(r58);
        this.mTempBrightnessEvent.setPowerFactor(this.mPowerRequest.screenLowPowerBrightnessFactor);
        this.mTempBrightnessEvent.setWasShortTermModelActive(r44);
        this.mTempBrightnessEvent.setDisplayBrightnessStrategyName(r10.getDisplayBrightnessStrategyName());
        this.mTempBrightnessEvent.setAutomaticBrightnessEnabled(r10.getShouldUseAutoBrightness());
        this.mTempBrightnessEvent.setSlowChange(r48);
        this.mTempBrightnessEvent.setRampSpeed(r49);
        if (this.mTempBrightnessEvent.getReason().getReason() == 7) goto L384;
    L386:
        boolean r59 = false;
    L387:
        boolean r60 = r59;
        if (this.mLastBrightnessEvent.isRbcEnabled() == this.mTempBrightnessEvent.isRbcEnabled()) goto L390;
        boolean r61 = true;
    L391:
        boolean r62 = r61;
        if (this.mTempBrightnessEvent.equalsMainData(this.mLastBrightnessEvent) == true) goto L394;
        if (r60 == true) goto L394;
    L395:
        this.mTempBrightnessEvent.setInitialBrightness(this.mLastBrightnessEvent.getBrightness());
        this.mLastBrightnessEvent.copyFrom(this.mTempBrightnessEvent);
        BrightnessEvent r63 = new BrightnessEvent(this.mTempBrightnessEvent);
        r63.setAdjustmentFlags(r116);
        int r64 = r63.getFlags();
        if (r22 == false) goto L398;
        int r311 = 8;
    L399:
        r63.setFlags(r64 | r311);
        Slog.i(this.mTag, r63.toString(false));
        if (r22 == false) goto L402;
    L403:
        logBrightnessEvent(r63, r117, r114);
    L405:
        if (this.mBrightnessEventRingBuffer == null) goto L407;
        this.mBrightnessEventRingBuffer.append(r63);
    L407:
        if (r62 == false) goto L411;
        this.mRbcEventRingBuffer.append(r63);
    L411:
        if (this.mDisplayWhiteBalanceController != null) goto L413;
        boolean r65 = false;
    L420:
        if (this.mPendingScreenOnUnblocker == null) goto L422;
    L432:
        boolean r66 = r65;
    L433:
        boolean r67 = r66;
        if (r67 == true) goto L436;
    L438:
        boolean r68 = r65;
    L439:
        boolean r69 = r68;
        if (r67 == true) goto L442;
    L446:
        if (r69 == true) goto L448;
        this.mWakelockController.acquireWakelock(6);
    L448:
        if (r67 == false) goto L470;
        if (r11 == false) goto L470;
        Object r70 = this.mLock;
        monitor-enter(r70);
    L461:
        th = th;
    L467:
        monitor-exit(r70);     // Catch: Throwable -> L459
        throw th;
    L453:
        if (this.mPendingRequestChangedLocked == true) goto L465;
        this.mDisplayReadyLocked = true;     // Catch: Throwable -> L461
        if (DEBUG == false) goto L465;
        Slog.d(this.mTag, "Display ready!");     // Catch: Throwable -> L459
    L465:
        monitor-exit(r70);     // Catch: Throwable -> L459
        sendOnStateChangedWithWakelock();
    L459:
        th = th;
    L470:
        if (r69 == false) goto L473;
        this.mWakelockController.releaseWakelock(6);
    L473:
        if (r45 == 2) goto L475;
        boolean r71 = true;
    L476:
        this.mDozing = r71;
        if (r9 == this.mPowerRequest.policy) goto L495;
        this.mExt.logDisplayPolicyChanged(r9, this.mPowerRequest.policy);
        logDisplayPolicyChanged(this.mPowerRequest.policy);
        return;
    L495:
        return;
    L475:
        r71 = false;
        goto L476
    L442:
        if (r45 == 1) goto L446;
        if (this.mReportedScreenStateToPolicy != 1) goto L446;
        setReportedScreenState(2);
        this.mWindowManagerPolicy.screenTurnedOn(this.mDisplayId);
        goto L446
    L436:
        if (this.mScreenBrightnessRampAnimator.isAnimating() == true) goto L438;
        r68 = true;
        goto L439
    L422:
        if (this.mPendingScreenOnUnblockerByDisplayOffload != null) goto L432;
        if (this.mColorFadeEnabled == false) goto L430;
        if (this.mColorFadeOnAnimator.isStarted() == true) goto L432;
        if (this.mColorFadeOffAnimator.isStarted() == true) goto L432;
    L430:
        if (this.mPowerState.waitUntilClean(this.mCleanListener) == false) goto L432;
        r66 = true;
        goto L433
    L413:
        if (r45 == 2) goto L415;
    L417:
        r65 = false;
        this.mDisplayWhiteBalanceController.setEnabled(false);
        goto L420
    L415:
        if (this.mDisplayWhiteBalanceSettings.isEnabled() == false) goto L417;
        this.mDisplayWhiteBalanceController.setEnabled(true);
        this.mDisplayWhiteBalanceController.updateDisplayColorTemperature();
        r65 = false;
        goto L420
    L402:
        if (r63.getReason().getReason() == 7) goto L405;
    L398:
        r311 = 0;
    L394:
        if (r116 == 0) goto L411;
    L390:
        r61 = false;
        goto L391
    L384:
        if (this.mLastBrightnessEvent.getReason().getReason() != 7) goto L386;
        r59 = true;
        goto L387
    L380:
        r58 = -1;
        goto L381
    L376:
        r310 = 0;
        goto L377
    L372:
        r55 = 0;
        goto L373
    L366:
        if (this.mCdsi.getReduceBrightColorsActivatedForEvenDimmer() == false) goto L368;
        r52 = true;
    L362:
        Slog.v(this.mTag, "Brightness [" + r43 + "] reason changing to: '" + this.mBrightnessReasonTemp.toString(r116) + "', previous reason: '" + this.mBrightnessReason + "'.");
        this.mBrightnessReason.set(this.mBrightnessReasonTemp);
        goto L363
    L211:
        if (this.mSkipScreenOnBrightnessRamp == false) goto L234;
        if (r38 == 2) goto L215;
        this.mSkipRampState = 0;
        goto L234
    L215:
        if (this.mSkipRampState != 0) goto L220;
        if (this.mDozing == false) goto L220;
        this.mInitialAutoBrightness = r39;
        this.mSkipRampState = 1;
    L220:
        if (this.mSkipRampState == 1) goto L222;
    L227:
        int r72 = 2;
    L229:
        if (this.mSkipRampState != r72) goto L234;
        this.mSkipRampState = 0;
        goto L234
    L222:
        if (this.mUseSoftwareAutoBrightnessConfig == false) goto L227;
        if (BrightnessSynchronizer.floatEquals(r39, this.mInitialAutoBrightness) == true) goto L226;
        this.mSkipRampState = 2;
        goto L234
    L226:
        r72 = 2;
    L234:
        if (r38 != 2) goto L238;
        if (this.mSkipRampState == 0) goto L238;
    L239:
        boolean r312 = true;
    L242:
        if (Display.isDozeState(r38) == true) goto L244;
    L246:
        boolean r313 = false;
    L248:
        if (this.mColorFadeEnabled == true) goto L250;
    L252:
        boolean r410 = false;
    L253:
        float r73 = clampScreenBrightness(r39);
        if (r114.getHdrBrightness() == r32) goto L256;
        float r411 = 0.0f;
        float r412 = r37;
        float r74 = r114.getHdrBrightness();
    L264:
        float r75 = this.mExt.getManualRangeTransitionRate(this.mExt.getModeChangeRate(this.mExt.getOverrideRate(this.mExt.getDimRate(this.mExt.getHdrRate(this.mExt.getPowerDiscountRate(r40, r73, r74), r73, r74), r73, r74), r73, r74), r73, r74), r73, r74);
        this.mExt.updateAnimateValue(r73, r74);
        if (this.mPowerRequest.policy == 1) goto L267;
    L273:
        float r314 = this.mPowerState.getScreenBrightness();
        float r76 = this.mPowerState.getSdrScreenBrightness();
        if (BrightnessUtils.isValidBrightnessValue(r74) == false) goto L344;
        if (r74 != r314) goto L282;
        if (r73 == r76) goto L344;
    L282:
        if (this.mZswExt.useFakeSleepBrightness() == true) goto L344;
        if (r312 == true) goto L290;
        if (r313 == true) goto L290;
        if (r410 == false) goto L287;
    L289:
        boolean r315 = false;
    L291:
        boolean r77 = BrightnessSynchronizer.floatEquals(r73, r76);
        r38 = r38;
        if (this.mFlags.isFastHdrTransitionsEnabled() == false) goto L296;
        if (r315 == true) goto L296;
        if (r77 == false) goto L296;
        boolean r413 = false;
    L297:
        this.mBrightnessAdjustmentFlags = r26;
        boolean r78 = this.mExt.isSkipAnimation(r315, r312, r313, r410, r42, r413);
        if (r315 == false) goto L301;
        if (r78 == false) goto L301;
        r26 = r26;
        animateScreenBrightness(r74, r73, SCREEN_ANIMATION_RATE_MINIMUM);
    L340:
        r115 = r413;
        boolean r79 = false;
    L347:
        boolean r80 = this.mAutomaticBrightnessStrategy.isAutoBrightnessEnabled();
        boolean r81 = r10.getShouldUseAutoBrightness();
        r43 = r39;
        r46 = r28;
        r45 = r38;
        float r82 = r74;
        r44 = r27;
        r117 = r412;
        r116 = r26;
        notifyBrightnessTrackerChanged(r43, r46, r44, r80, r42, r81);
        r47 = saveBrightnessInfo(getScreenBrightnessSetting(), r82, r114);
        r48 = r115;
        r49 = r411;
    L301:
        r26 = r26;
        if (this.mExt.isAodInProgress() == false) goto L305;
        this.mExt.handleAodBrightness(r74, r73);
        goto L340
    L305:
        if (this.mZswExt.skipAnimateBrightness() == false) goto L308;
        animateScreenBrightness(r74, r73, SCREEN_ANIMATION_RATE_MINIMUM);
        goto L340
    L308:
        if (r75 <= SCREEN_ANIMATION_RATE_MINIMUM) goto L312;
        animateScreenBrightness(r74, r73, r75, true);
        goto L340
    L312:
        if (r74 <= r314) goto L314;
        boolean r83 = true;
    L316:
        if (this.mAutomaticBrightnessController != null) goto L318;
    L320:
        boolean r84 = false;
    L322:
        if (r83 == false) goto L328;
        if (r413 == false) goto L328;
        if (r84 == false) goto L326;
        float r85 = this.mBrightnessRampRateSlowIncreaseIdle;
    L339:
        animateScreenBrightness(r74, r73, r85);
        r411 = r85;
        goto L340
    L326:
        r85 = this.mBrightnessRampRateSlowIncrease;
    L328:
        boolean r119 = r84;
        if (r83 == false) goto L332;
        if (r413 == true) goto L332;
        r85 = this.mBrightnessRampRateFastIncrease;
    L332:
        if (r83 == true) goto L338;
        if (r413 == false) goto L338;
        if (r119 == false) goto L336;
        r85 = this.mBrightnessRampRateSlowDecreaseIdle;
        goto L339
    L336:
        r85 = this.mBrightnessRampRateSlowDecrease;
    L338:
        r85 = this.mBrightnessRampRateFastDecrease;
        goto L339
    L318:
        if (this.mAutomaticBrightnessController.isInIdleMode() == false) goto L320;
        r84 = true;
        goto L322
    L314:
        r83 = false;
    L296:
        r413 = r115;
        goto L297
    L287:
        if (this.mExt.isContentInvisibleSkipAnimation(r14, r38) == false) goto L289;
    L290:
        r315 = true;
    L344:
        if (this.mZswExt.useFakeSleepBrightness() == false) goto L346;
        float r86 = r32;
        r79 = false;
        animateScreenBrightness(r86, r86, SCREEN_ANIMATION_RATE_MINIMUM);
        goto L347
    L346:
        r79 = false;
        goto L347
    L267:
        if (this.mPowerRequest.dozeScreenState != 0) goto L269;
    L272:
        r75 = -1.0f;
        r115 = false;
        goto L273
    L269:
        if (this.mPowerRequest.dozeScreenState == 4) goto L272;
        if (this.mPowerRequest.dozeScreenState != 6) goto L273;
    L256:
        r411 = 0.0f;
        r412 = r37;
        if (this.mBrightnessRangeController.getHighBrightnessMode() == 2) goto L259;
    L263:
        r74 = r73;
        goto L264
    L259:
        if ((this.mBrightnessReasonTemp.getModifier() & 1) != 0) goto L263;
        if ((this.mBrightnessReasonTemp.getModifier() & 2) != 0) goto L263;
        float r87 = this.mBrightnessRangeController.getHdrBrightnessValue();
        this.mBrightnessReasonTemp.addModifier(4);
        r74 = r87;
        goto L264
    L250:
        if (this.mPowerState.getColorFadeLevel() != 1.0f) goto L252;
        r410 = true;
        goto L253
    L244:
        if (this.mBrightnessBucketsInDozeConfig == false) goto L246;
        r313 = true;
    L238:
        if (this.mDisplayPowerProximityStateController.shouldSkipRampBecauseOfProximityChangeToNegative() == true) goto L239;
        r312 = false;
        goto L242
    L204:
        if (this.mAutomaticBrightnessStrategy.isTemporaryAutoBrightnessAdjustmentApplied() == true) goto L207;
        r41 = false;
        goto L208
    L192:
        r35 = this.mAutomaticBrightnessController.getAmbientLux();
    L186:
        if (this.mAutomaticBrightnessStrategy.shouldUseAutoBrightness() == true) goto L188;
        r210 = r29;
        r112 = this.mExt.overrideManuBrightness(r12);
        r34 = r15;
        goto L190
    L188:
        r210 = r29;
        r112 = r12;
        r34 = r15;
        goto L190
    L154:
        if (this.mAutomaticBrightnessStrategy.shouldUseAutoBrightness() == false) goto L155;
    L157:
        if (this.mDisplayBrightnessController.isAllowAutoBrightnessWhileDozingConfig() == true) goto L159;
        r15 = this.mScreenBrightnessDozeConfig;
        r12 = clampScreenBrightness(r15);
        this.mBrightnessReasonTemp.setReason(3);
    L161:
        r29 = r21;
        goto L163
    L103:
        if (this.mPowerRequest.isBrightOrDim() == false) goto L135;
        if (r30 == true) goto L135;
        if (Float.isNaN(r12) == true) goto L111;
        r32 = -1.0f;
        if (this.mBrightnessReasonTemp.getReason() == 11) goto L113;
        this.mAutomaticBrightnessStrategy.setAutoBrightnessApplied(false);
    L113:
        if (this.mAutomaticBrightnessStrategy.isAutoBrightnessEnabled() == false) goto L136;
        float r88 = this.mAutomaticBrightnessStrategy.getAutomaticScreenBrightness(this.mTempBrightnessEvent);
        if (BrightnessUtils.isValidBrightnessValue(r88) == false) goto L117;
    L120:
        r15 = this.mAutomaticBrightnessController.getRawAutomaticScreenBrightness();
        if (this.mAutomaticBrightnessStrategy.hasAppliedAutoBrightness() == true) goto L123;
    L125:
        boolean r89 = false;
    L126:
        r16 = r89;
        r25 = this.mAutomaticBrightnessStrategy.getAutoBrightnessAdjustmentReasonsFlags();
        if (r23 == r88) goto L129;
        boolean r90 = true;
    L130:
        r21 = r90;
        this.mAutomaticBrightnessStrategy.setAutoBrightnessApplied(true);
        this.mBrightnessReasonTemp.setReason(4);
        if (this.mScreenOffBrightnessSensorController == null) goto L133;
        this.mScreenOffBrightnessSensorController.setLightSensorEnabled(false);
    L133:
        setBrightnessFromOffload(Float.NaN);
    L134:
        this.mExt.updateAutoBrightnessRateType();
        r12 = this.mExt.overrideManuAutoBrightness(r88);
        r26 = r25;
        goto L138
    L129:
        r90 = false;
        goto L130
    L123:
        if (this.mAutomaticBrightnessStrategy.getAutoBrightnessAdjustmentChanged() == true) goto L125;
        r89 = true;
        goto L126
    L117:
        if (r88 == r32) goto L120;
        this.mAutomaticBrightnessStrategy.setAutoBrightnessApplied(false);
        r88 = r10.getBrightness();
        goto L134
    L111:
        r32 = -1.0f;
        goto L113
    L97:
        if (this.mAutomaticBrightnessStrategy.isAutoBrightnessDisabledDueToDisplayOff() == false) goto L99;
        r20 = 3;
        goto L100
    L99:
        r20 = 2;
        goto L100
    L80:
        if (this.mFlags.areAutoBrightnessModesEnabled() == true) goto L82;
    L84:
        r110 = r6;
        this.mAutomaticBrightnessStrategy.setAutoBrightnessState(r110, r18, this.mBrightnessReasonTemp.getReason(), this.mPowerRequest.policy, this.mPowerRequest.useNormalBrightnessForDoze, this.mDisplayBrightnessController.getLastUserSetScreenBrightness(), r22, this.mIsWearBedtimeModeEnabled);
        if (Float.isNaN(r12) == true) goto L87;
    L90:
        boolean r91 = false;
    L91:
        r28 = r91;
        goto L94
    L87:
        if (this.mAutomaticBrightnessStrategy.getAutoBrightnessAdjustmentChanged() == true) goto L89;
        if (r22 == false) goto L90;
    L89:
        r91 = true;
        goto L91
    L82:
        if (this.mAutomaticBrightnessController == null) goto L84;
        this.mAutomaticBrightnessController.isInIdleMode();
        goto L84
    L40:
        if (this.mPowerRequest.useNormalBrightnessForDoze == true) goto L44;
        if (this.mPowerRequest.policy != 1) goto L44;
    L45:
        r7 = true;
    L44:
        if (Display.isDozeState(r6) == true) goto L45;
        r7 = false;
        goto L48
    L33:
        if (readyToUpdateDisplayState() == false) goto L35;
        int r92 = r5;
    L36:
        initialize(r92);
        goto L37
    L35:
        r92 = 0;
    L480:
        th = th;
        goto L484
    L26:
        r3 = false;
    L482:
        th = th;
        goto L484
    L18:
        if (this.mPendingRequestChangedLocked == false) goto L21;
        int r93 = this.mPowerRequest.policy;     // Catch: Throwable -> L8
        this.mPowerRequest.copyFrom(this.mPendingRequestLocked);     // Catch: Throwable -> L8
        this.mDisplayPowerProximityStateController.updatePendingProximityRequestsLocked();     // Catch: Throwable -> L8
        this.mPendingRequestChangedLocked = false;     // Catch: Throwable -> L8
        this.mDisplayReadyLocked = false;     // Catch: Throwable -> L8
        r8 = false;
        r9 = r93;
        goto L488
    L21:
        r8 = false;
        r9 = this.mPowerRequest.policy;     // Catch: Throwable -> L8
        goto L488
    }

    private void setDwbcOverride(float cct) {
        if (this.mDisplayWhiteBalanceController == null) goto L6;
        this.mDisplayWhiteBalanceController.setAmbientColorTemperatureOverride(cct);
        updatePowerState();
        return;
    }

    private void setDwbcStrongMode(int arg) {
        if (this.mDisplayWhiteBalanceController == null) goto L10;
        boolean isIdle = true;
        if (arg == 1) goto L8;
        isIdle = false;
    L8:
        this.mDisplayWhiteBalanceController.setStrongModeEnabled(isIdle);
        return;
    }

    private void setDwbcLoggingEnabled(int arg) {
        if (this.mDisplayWhiteBalanceController == null) goto L10;
        boolean enabled = true;
        if (arg == 1) goto L8;
        enabled = false;
    L8:
        this.mDisplayWhiteBalanceController.setLoggingEnabled(enabled);
        this.mDisplayWhiteBalanceSettings.setLoggingEnabled(enabled);
        return;
    }

    @Override // com.android.server.display.AutomaticBrightnessController.Callbacks
    public void updateBrightness() {
        sendUpdatePowerState();
    }

    public void ignoreProximitySensorUntilChanged() {
        this.mDisplayPowerProximityStateController.ignoreProximitySensorUntilChanged();
    }

    public void setBrightnessConfiguration(BrightnessConfiguration r4, boolean r5) {
        this.mHandler.obtainMessage(4, r5 ? 1 : 0, 0, r4).sendToTarget();
    }

    public void setTemporaryBrightness(float brightness) {
        Message msg = this.mHandler.obtainMessage(5, Float.floatToIntBits(brightness), 0);
        msg.sendToTarget();
    }

    public void setTemporaryAutoBrightnessAdjustment(float adjustment) {
        Message msg = this.mHandler.obtainMessage(6, Float.floatToIntBits(adjustment), 0);
        msg.sendToTarget();
    }

    public void setBrightnessFromOffload(float brightness) {
        Message msg = this.mHandler.obtainMessage(17, Float.floatToIntBits(brightness), 0);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    public float[] getAutoBrightnessLevels(int mode) {
        int preset = Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness_for_als", 2, -2);
        return this.mDisplayDeviceConfig.getAutoBrightnessBrighteningLevels(mode, preset);
    }

    public float[] getAutoBrightnessLuxLevels(int mode) {
        int preset = Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness_for_als", 2, -2);
        return this.mDisplayDeviceConfig.getAutoBrightnessBrighteningLevelsLux(mode, preset);
    }

    public BrightnessInfo getBrightnessInfo() {
        CachedBrightnessInfo r1 = this.mCachedBrightnessInfo;
        monitor-enter(r1);
        float r3 = this.mCachedBrightnessInfo.brightness.value;     // Catch: Throwable -> L12
        float r4 = this.mCachedBrightnessInfo.adjustedBrightness.value;     // Catch: Throwable -> L12
        float r5 = this.mCachedBrightnessInfo.brightnessMin.value;     // Catch: Throwable -> L12
        float r6 = this.mCachedBrightnessInfo.brightnessMax.value;     // Catch: Throwable -> L12
        int r7 = this.mCachedBrightnessInfo.hbmMode.value;     // Catch: Throwable -> L12
        float r8 = this.mCachedBrightnessInfo.hbmTransitionPoint.value;     // Catch: Throwable -> L12
        int r9 = this.mCachedBrightnessInfo.brightnessMaxReason.value;     // Catch: Throwable -> L12
        if (this.mCachedBrightnessInfo.brightnessReason.value != 6) goto L8;
        boolean r0 = true;
    L9:
        BrightnessInfo r2 = new BrightnessInfo(r3, r4, r5, r6, r7, r8, r9, r0);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r2;
    L8:
        r0 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public void onBootCompleted() {
        Message msg = this.mHandler.obtainMessage(13);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private boolean saveBrightnessInfo(float brightness) {
        return saveBrightnessInfo(brightness, null);
    }

    private boolean saveBrightnessInfo(float brightness, DisplayBrightnessState state) {
        return saveBrightnessInfo(brightness, brightness, state);
    }

    private boolean saveBrightnessInfo(float brightness, float adjustedBrightness, DisplayBrightnessState state) {
        CachedBrightnessInfo r0 = this.mCachedBrightnessInfo;
        monitor-enter(r0);
        float stateMin = 1.0f;
        if (state != null) goto L25;
        float stateMax = 1.0f;
    L10:
        if (state == null) goto L13;
        stateMin = state.getMinBrightness();     // Catch: Throwable -> L7
    L13:
        if (state == null) goto L15;
        int maxReason = state.getBrightnessMaxReason();     // Catch: Throwable -> L7
    L17:
        if (state == null) goto L19;
        BrightnessReason brightnessReason = state.getBrightnessReason();     // Catch: Throwable -> L7
    L20:
        float minBrightness = Math.max(stateMin, Math.min(this.mBrightnessRangeController.getCurrentBrightnessMin(), stateMax));     // Catch: Throwable -> L7
        float maxBrightness = Math.min(this.mBrightnessRangeController.getCurrentBrightnessMax(), stateMax);     // Catch: Throwable -> L7
        boolean changed = false | this.mCachedBrightnessInfo.checkAndSetFloat(this.mCachedBrightnessInfo.brightness, brightness);     // Catch: Throwable -> L7
        boolean changed2 = ((((((changed | this.mCachedBrightnessInfo.checkAndSetFloat(this.mCachedBrightnessInfo.adjustedBrightness, adjustedBrightness)) | this.mCachedBrightnessInfo.checkAndSetFloat(this.mCachedBrightnessInfo.brightnessMin, minBrightness)) | this.mCachedBrightnessInfo.checkAndSetFloat(this.mCachedBrightnessInfo.brightnessMax, maxBrightness)) | this.mCachedBrightnessInfo.checkAndSetInt(this.mCachedBrightnessInfo.hbmMode, this.mBrightnessRangeController.getHighBrightnessMode())) | this.mCachedBrightnessInfo.checkAndSetFloat(this.mCachedBrightnessInfo.hbmTransitionPoint, this.mBrightnessRangeController.getTransitionPoint())) | this.mCachedBrightnessInfo.checkAndSetInt(this.mCachedBrightnessInfo.brightnessMaxReason, maxReason)) | this.mCachedBrightnessInfo.checkAndSetInt(this.mCachedBrightnessInfo.brightnessReason, brightnessReason.getReason());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return changed2;
    L7:
        th = move-exception;
        throw th;
    L19:
        brightnessReason = new BrightnessReason(0);     // Catch: Throwable -> L7
        goto L20
    L15:
        maxReason = 0;
        goto L17
    L25:
        stateMax = state.getMaxBrightness();     // Catch: Throwable -> L7
        goto L10
    }

    void postBrightnessChangeRunnable() {
        if (this.mHandler.hasCallbacks(this.mOnBrightnessChangeRunnable) == true) goto L6;
        this.mHandler.post(this.mOnBrightnessChangeRunnable);
        return;
    }

    private HighBrightnessModeController createHbmControllerLocked(HighBrightnessModeMetadata hbmMetadata, Runnable modeChangeCallback) {
        DisplayDeviceConfig ddConfig = this.mDisplayDevice.getDisplayDeviceConfig();
        IBinder displayToken = this.mDisplayDevice.getDisplayTokenLocked();
        String displayUniqueId = this.mDisplayDevice.getUniqueId();
        if (ddConfig == null) goto L6;
        HighBrightnessModeData r2 = ddConfig.getHighBrightnessModeData();
    L5:
        HighBrightnessModeData hbmData = r2;
        DisplayDeviceInfo info = this.mDisplayDevice.getDisplayDeviceInfoLocked();
        return this.mInjector.getHighBrightnessModeController(this.mHandler, info.width, info.height, displayToken, displayUniqueId, SCREEN_ANIMATION_RATE_MINIMUM, 1.0f, hbmData, new DisplayPowerController$$ExternalSyntheticLambda4(this), modeChangeCallback, hbmMetadata, this.mContext);
    L6:
        r2 = null;
        goto L5
    }

    private /* synthetic */ float lambda$createHbmControllerLocked$6(float sdrBrightness, float maxDesiredHdrSdrRatio) {
        return this.mDisplayDeviceConfig.getHdrBrightnessFromSdr(sdrBrightness, maxDesiredHdrSdrRatio);
    }

    private void blockScreenOn() {
        if (this.mPendingScreenOnUnblocker != null) goto L6;
        Trace.asyncTraceBegin(131072, SCREEN_ON_BLOCKED_TRACE_NAME, 0);
        this.mPendingScreenOnUnblocker = new ScreenOnUnblocker(this, null);
        this.mScreenOnBlockStartRealTime = SystemClock.elapsedRealtime();
        Slog.i(this.mTag, "Blocking screen on until initial contents have been drawn.");
        return;
    }

    private void unblockScreenOn() {
        if (this.mPendingScreenOnUnblocker == null) goto L6;
        this.mPendingScreenOnUnblocker = null;
        long delay = SystemClock.elapsedRealtime() - this.mScreenOnBlockStartRealTime;
        Slog.i(this.mTag, "Unblocked screen on after " + delay + " ms");
        Trace.asyncTraceEnd(131072, SCREEN_ON_BLOCKED_TRACE_NAME, 0);
        return;
    }

    private void blockScreenOff() {
        if (this.mPendingScreenOffUnblocker != null) goto L6;
        Trace.asyncTraceBegin(131072, SCREEN_OFF_BLOCKED_TRACE_NAME, 0);
        this.mPendingScreenOffUnblocker = new ScreenOffUnblocker(this, null);
        this.mScreenOffBlockStartRealTime = SystemClock.elapsedRealtime();
        Slog.i(this.mTag, "Blocking screen off");
        return;
    }

    private void unblockScreenOff() {
        if (this.mPendingScreenOffUnblocker == null) goto L6;
        this.mPendingScreenOffUnblocker = null;
        long delay = SystemClock.elapsedRealtime() - this.mScreenOffBlockStartRealTime;
        Slog.i(this.mTag, "Unblocked screen off after " + delay + " ms");
        Trace.asyncTraceEnd(131072, SCREEN_OFF_BLOCKED_TRACE_NAME, 0);
        return;
    }

    private void blockScreenOnByDisplayOffload(final DisplayManagerInternal.DisplayOffloadSession displayOffloadSession) {
        if (this.mPendingScreenOnUnblockerByDisplayOffload != null) goto L12;
        if (displayOffloadSession == null) goto L13;
        this.mScreenTurningOnWasBlockedByDisplayOffload = true;
        Trace.asyncTraceBegin(131072, SCREEN_ON_BLOCKED_BY_DISPLAYOFFLOAD_TRACE_NAME, 0);
        this.mScreenOnBlockByDisplayOffloadStartRealTime = SystemClock.elapsedRealtime();
        this.mPendingScreenOnUnblockerByDisplayOffload = new DisplayPowerController$$ExternalSyntheticLambda11(this, displayOffloadSession);
        if (displayOffloadSession.blockScreenOn(this.mPendingScreenOnUnblockerByDisplayOffload) == true) goto L10;
        this.mPendingScreenOnUnblockerByDisplayOffload = null;
        long delay = SystemClock.elapsedRealtime() - this.mScreenOnBlockByDisplayOffloadStartRealTime;
        Slog.w(this.mTag, "Tried blocking screen on for offloading but failed. So, end trace after " + delay + " ms.");
        Trace.asyncTraceEnd(131072, SCREEN_ON_BLOCKED_BY_DISPLAYOFFLOAD_TRACE_NAME, 0);
        return;
    L10:
        Slog.i(this.mTag, "Blocking screen on for offloading.");
        return;
    L13:
        return;
    }

    private /* synthetic */ void lambda$blockScreenOnByDisplayOffload$7(DisplayManagerInternal.DisplayOffloadSession displayOffloadSession) {
        onDisplayOffloadUnblockScreenOn(displayOffloadSession);
    }

    private void onDisplayOffloadUnblockScreenOn(DisplayManagerInternal.DisplayOffloadSession displayOffloadSession) {
        Message msg = this.mHandler.obtainMessage(18, displayOffloadSession);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void unblockScreenOnByDisplayOffload() {
        if (this.mPendingScreenOnUnblockerByDisplayOffload != null) goto L5;
        return;
    L5:
        this.mPendingScreenOnUnblockerByDisplayOffload = null;
        long delay = SystemClock.elapsedRealtime() - this.mScreenOnBlockByDisplayOffloadStartRealTime;
        Slog.i(this.mTag, "Unblocked screen on for offloading after " + delay + " ms");
        Trace.asyncTraceEnd(131072, SCREEN_ON_BLOCKED_BY_DISPLAYOFFLOAD_TRACE_NAME, 0);
    }

    private void cancelUnblockScreenOnByDisplayOffload() {
        if (this.mDisplayOffloadSession != null) goto L6;
        return;
    L6:
        if (this.mPendingScreenOnUnblockerByDisplayOffload != null) goto L8;
        return;
    L8:
        this.mDisplayOffloadSession.cancelBlockScreenOn();
    }

    private boolean setScreenState(int state, int reason) {
        return setScreenState(state, reason, false);
    }

    private boolean setScreenState(int state, int reason, boolean reportOnly) {
        if (state != 1) goto L5;
        boolean r0 = true;
    L6:
        boolean isOff = r0;
        if (state != 2) goto L9;
        boolean isOn = true;
    L11:
        if (this.mPowerState.getScreenState() == state) goto L13;
        boolean changed = true;
    L14:
        if (isOn == false) goto L19;
        if (changed == false) goto L19;
        if (this.mScreenTurningOnWasBlockedByDisplayOffload == true) goto L19;
        blockScreenOnByDisplayOffload(this.mDisplayOffloadSession);
    L27:
        if (changed == false) goto L29;
    L30:
        if (isOff == true) goto L32;
    L42:
        if (reportOnly == true) goto L56;
        if (changed == false) goto L56;
        if (readyToUpdateDisplayState() == false) goto L56;
        if (this.mPendingScreenOffUnblocker != null) goto L56;
        if (this.mPendingScreenOnUnblockerByDisplayOffload != null) goto L56;
        Trace.traceCounter(131072, "ScreenState", state);
        String propertyValue = String.valueOf(state);
        SystemProperties.set("debug.tracing.screen_state", propertyValue);     // Catch: RuntimeException -> L53
    L55:
        this.mExt.setScreenState(state, reason);
        this.mPowerState.setScreenState(state, reason);
        noteScreenState(state, reason);
    L53:
        e = move-exception;
        Slog.e(this.mTag, "Failed to set a system property: key=debug.tracing.screen_state value=" + propertyValue + " " + e.getMessage());
    L56:
        if (isOff == true) goto L58;
    L62:
        if (isOff == false) goto L64;
    L66:
        if (isOff == true) goto L77;
        if (this.mReportedScreenStateToPolicy != 0) goto L70;
    L71:
        setReportedScreenState(1);
        if (this.mPowerState.getColorFadeLevel() != SCREEN_ANIMATION_RATE_MINIMUM) goto L74;
        blockScreenOn();
    L75:
        this.mWindowManagerPolicy.screenTurningOn(this.mDisplayId, this.mPendingScreenOnUnblocker);
        SysOptBridge.getFactory().getSmartService().screenTurnOn();
        Slog.i(TAG, "Window Manager Policy screenTurningOn complete");
        goto L77
    L74:
        unblockScreenOn();
        goto L75
    L70:
        if (this.mReportedScreenStateToPolicy == (-1)) goto L71;
    L77:
        if (this.mPendingScreenOnUnblocker == null) goto L79;
        return false;
    L79:
        if (this.mPendingScreenOnUnblockerByDisplayOffload == null) goto L81;
        return false;
    L81:
        return true;
    L64:
        if (this.mReportedScreenStateToPolicy != 3) goto L66;
        unblockScreenOff();
        this.mWindowManagerPolicy.screenTurnedOff(this.mDisplayId, this.mIsInTransition);
        setReportedScreenState(0);
        SysOptBridge.getFactory().getSmartService().screenTurnOff();
        goto L66
    L58:
        if (this.mReportedScreenStateToPolicy == 0) goto L62;
        if (this.mDisplayPowerProximityStateController.isScreenOffBecauseOfProximity() == true) goto L62;
        setReportedScreenState(0);
        unblockScreenOn();
        this.mWindowManagerPolicy.screenTurnedOff(this.mDisplayId, this.mIsInTransition);
        SysOptBridge.getFactory().getSmartService().screenTurnOff();
        goto L66
    L32:
        if (this.mDisplayPowerProximityStateController.isScreenOffBecauseOfProximity() == true) goto L42;
        if (this.mReportedScreenStateToPolicy != 2) goto L36;
    L41:
        setReportedScreenState(3);
        blockScreenOff();
        this.mWindowManagerPolicy.screenTurningOff(this.mDisplayId, this.mPendingScreenOffUnblocker);
        goto L42
    L36:
        if (this.mReportedScreenStateToPolicy == (-1)) goto L41;
        if (this.mPendingScreenOffUnblocker == null) goto L42;
        return false;
    L29:
        if (this.mReportedScreenStateToPolicy != (-1)) goto L56;
    L19:
        if (isOn == true) goto L27;
        if (this.mScreenTurningOnWasBlockedByDisplayOffload == false) goto L27;
        if (this.mFlags.isOffloadSessionCancelBlockScreenOnEnabled() == false) goto L25;
        cancelUnblockScreenOnByDisplayOffload();
    L25:
        unblockScreenOnByDisplayOffload();
        this.mScreenTurningOnWasBlockedByDisplayOffload = false;
        goto L27
    L13:
        changed = false;
        goto L14
    L9:
        isOn = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private void setReportedScreenState(int state) {
        this.mExt.setReportedScreenState(state);
        Trace.traceCounter(131072, "ReportedScreenStateToPolicy", state);
        this.mReportedScreenStateToPolicy = state;
        if (state != 2) goto L6;
        this.mScreenTurningOnWasBlockedByDisplayOffload = false;
        return;
    }

    private void loadAmbientLightSensor() {
        if (this.mDisplayId != 0) goto L5;
        int fallbackType = 5;
    L6:
        this.mLightSensor = SensorUtils.findSensor(this.mSensorManager, this.mDisplayDeviceConfig.getAmbientLightSensor(), fallbackType);
        return;
    L5:
        fallbackType = 0;
        goto L6
    }

    private void loadScreenOffBrightnessSensor() {
        this.mScreenOffBrightnessSensor = SensorUtils.findSensor(this.mSensorManager, this.mDisplayDeviceConfig.getScreenOffBrightnessSensor(), 0);
    }

    private float clampScreenBrightness(float value) {
        if (Float.isNaN(value) == false) goto L6;
        value = SCREEN_ANIMATION_RATE_MINIMUM;
    L6:
        if (this.mPowerRequest == null) goto L12;
        if (this.mPowerRequest.policy != 1) goto L12;
        return MathUtils.constrain(value, this.mBrightnessRangeController.getCurrentBrightnessMin(), 1.0f);
    L12:
        return MathUtils.constrain(value, this.mBrightnessRangeController.getCurrentBrightnessMin(), this.mBrightnessRangeController.getCurrentBrightnessMax());
    }

    private void animateScreenBrightness(float target, float sdrTarget, float rate) {
        animateScreenBrightness(target, sdrTarget, rate, false);
    }

    protected void animateScreenBrightness(float target, float sdrTarget, float rate, boolean ignoreAnimationLimits) {
        if (DEBUG == false) goto L5;
        Slog.d(this.mTag, "Animating brightness: target=" + target + ", sdrTarget=" + sdrTarget + ", rate=" + rate);
    L5:
        this.mExt.animateScreenBrightness(target, sdrTarget, rate, ignoreAnimationLimits, this.mBrightnessReasonTemp, this.mBrightnessAdjustmentFlags);
        if (this.mScreenBrightnessRampAnimator.animateTo(target, sdrTarget, rate, ignoreAnimationLimits) == false) goto L16;
        Trace.traceCounter(131072, "TargetScreenBrightness", (int) target);
        String propertyValue = String.valueOf(target);
        SystemProperties.set("debug.tracing.screen_brightness", propertyValue);     // Catch: RuntimeException -> L10
    L12:
        noteScreenBrightness(target);
        return;
    L10:
        e = move-exception;
        Slog.e(this.mTag, "Failed to set a system property: key=debug.tracing.screen_brightness value=" + propertyValue + " " + e.getMessage());
        goto L12
    }

    private void animateScreenStateChange(int target, int reason, boolean performScreenOffTransition) {
        int r1 = 2;
        if (this.mColorFadeEnabled == false) goto L12;
        if (this.mColorFadeOnAnimator.isStarted() == false) goto L7;
    L8:
        if (target == 2) goto L10;
        return;
    L10:
        this.mPendingScreenOff = false;
        goto L12
    L7:
        if (this.mColorFadeOffAnimator.isStarted() == true) goto L8;
    L12:
        if (this.mDisplayBlanksAfterDozeConfig == false) goto L29;
        if (Display.isDozeState(this.mPowerState.getScreenState()) == false) goto L29;
        if (Display.isDozeState(target) == true) goto L29;
        DisplayPowerState r0 = this.mPowerState;
        Context r4 = this.mContext;
        if (this.mColorFadeFadesConfig == false) goto L20;
        int r5 = 2;
    L21:
        r0.prepareColorFade(r4, r5);
        if (this.mColorFadeOffAnimator == null) goto L24;
        this.mColorFadeOffAnimator.end();
    L24:
        if (target == 1) goto L26;
        boolean r2 = true;
    L27:
        setScreenState(1, reason, r2);
        goto L29
    L26:
        r2 = false;
        goto L27
    L20:
        r5 = 0;
    L29:
        if (this.mPendingScreenOff == false) goto L33;
        if (target == 1) goto L33;
        setScreenState(1, reason);
        this.mPendingScreenOff = false;
        this.mPowerState.dismissColorFadeResources();
    L33:
        if (target != 2) goto L40;
        if (setScreenState(2, reason) == true) goto L38;
        this.mExt.screenOnBlocked(target, reason, this.mReportedScreenStateToPolicy, false);
        return;
    L38:
        this.mPowerState.setColorFadeLevel(1.0f);
        this.mPowerState.dismissColorFade();
        return;
    L40:
        if (target != 3) goto L53;
        if (this.mScreenBrightnessRampAnimator.isAnimating() == false) goto L48;
        if (this.mPowerState.getScreenState() != 2) goto L48;
        this.mExt.screenOnBlocked(target, reason, this.mReportedScreenStateToPolicy, true);
        return;
    L48:
        if (setScreenState(3, reason) == true) goto L51;
        this.mExt.screenOnBlocked(target, reason, this.mReportedScreenStateToPolicy, false);
        return;
    L51:
        this.mPowerState.setColorFadeLevel(1.0f);
        this.mPowerState.dismissColorFade();
        return;
    L53:
        if (target != 4) goto L69;
        if (this.mScreenBrightnessRampAnimator.isAnimating() == false) goto L61;
        if (this.mPowerState.getScreenState() == 4) goto L61;
        this.mExt.screenOnBlocked(target, reason, this.mReportedScreenStateToPolicy, true);
        return;
    L61:
        if (this.mPowerState.getScreenState() != 4) goto L63;
    L67:
        this.mPowerState.setColorFadeLevel(1.0f);
        this.mPowerState.dismissColorFade();
        return;
    L63:
        if (setScreenState(3, reason) == true) goto L66;
        this.mExt.screenOnBlocked(target, reason, this.mReportedScreenStateToPolicy, false);
        return;
    L66:
        setScreenState(4, reason);
        goto L67
    L69:
        if (target == 6) goto L71;
        this.mPendingScreenOff = true;
        if (this.mColorFadeEnabled == true) goto L86;
        this.mPowerState.setColorFadeLevel(SCREEN_ANIMATION_RATE_MINIMUM);
    L86:
        if (this.mPowerState.getColorFadeLevel() != SCREEN_ANIMATION_RATE_MINIMUM) goto L89;
        setScreenState(1, reason);
        this.mPendingScreenOff = false;
        this.mPowerState.dismissColorFadeResources();
        return;
    L89:
        if (performScreenOffTransition == false) goto L99;
        DisplayPowerState r3 = this.mPowerState;
        Context r6 = this.mContext;
        if (this.mColorFadeFadesConfig == true) goto L95;
        r1 = 1;
    L95:
        if (r3.prepareColorFade(r6, r1) == false) goto L99;
        if (this.mPowerState.getScreenState() == 1) goto L99;
        this.mColorFadeOffAnimator.start();
        return;
    L99:
        this.mColorFadeOffAnimator.end();
        return;
    L71:
        if (this.mScreenBrightnessRampAnimator.isAnimating() == false) goto L76;
        if (this.mPowerState.getScreenState() == 6) goto L76;
        return;
    L76:
        if (this.mPowerState.getScreenState() != 6) goto L78;
    L81:
        this.mPowerState.setColorFadeLevel(1.0f);
        this.mPowerState.dismissColorFade();
        return;
    L78:
        if (setScreenState(2, reason) == true) goto L80;
        return;
    L80:
        setScreenState(6, reason);
        goto L81
    }

    private void sendOnStateChangedWithWakelock() {
        boolean wakeLockAcquired = this.mWakelockController.acquireWakelock(4);
        if (wakeLockAcquired == false) goto L6;
        this.mHandler.post(this.mWakelockController.getOnStateChangedRunnable());
        return;
    }

    private void logDisplayPolicyChanged(int newPolicy) {
        LogMaker log = new LogMaker(1696);
        log.setType(6);
        log.setSubtype(newPolicy);
        MetricsLogger.action(log);
    }

    private void handleSettingsChange() {
        this.mDisplayBrightnessController.setPendingScreenBrightness(this.mDisplayBrightnessController.getScreenBrightnessSetting());
        this.mAutomaticBrightnessStrategy.updatePendingAutoBrightnessAdjustments();
        sendUpdatePowerState();
    }

    private void handleBrightnessModeChange() {
        boolean r2 = false;
        int screenBrightnessModeSetting = Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness_mode", 0, -2);
        this.mExt.handleBrightnessModeChange(screenBrightnessModeSetting);
        AutomaticBrightnessStrategy2 r1 = this.mAutomaticBrightnessStrategy;
        if (screenBrightnessModeSetting != 1) goto L5;
        r2 = true;
    L5:
        r1.setUseAutoBrightness(r2);
        if (screenBrightnessModeSetting != 0) goto L9;
        this.mDisplayBrightnessController.saveBrightnessIfNeeded();
        return;
    }

    public float getScreenBrightnessSetting() {
        return this.mDisplayBrightnessController.getScreenBrightnessSetting();
    }

    public float getDozeBrightnessForOffload() {
        return this.mDisplayBrightnessController.getCurrentBrightness() * this.mDozeScaleFactor;
    }

    public void setBrightness(float brightness) {
        this.mDisplayBrightnessController.setBrightness(clampScreenBrightness(brightness), this.mBrightnessRangeController.getCurrentBrightnessMax());
    }

    public void setBrightness(float brightness, int userSerial) {
        this.mDisplayBrightnessController.setBrightness(clampScreenBrightness(brightness), userSerial, this.mBrightnessRangeController.getCurrentBrightnessMax());
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    public int getLeadDisplayId() {
        return this.mLeadDisplayId;
    }

    public void setBrightnessToFollow(float leadDisplayBrightness, float nits, float ambientLux, boolean slowChange) {
        this.mBrightnessRangeController.onAmbientLuxChange(ambientLux);
        if (nits != (-1.0f)) goto L5;
        this.mDisplayBrightnessController.setBrightnessToFollow(leadDisplayBrightness, slowChange);
    L9:
        sendUpdatePowerState();
        return;
    L5:
        float brightness = this.mDisplayBrightnessController.getBrightnessFromNits(nits);
        if (BrightnessUtils.isValidBrightnessValue(brightness) == false) goto L8;
        this.mDisplayBrightnessController.setBrightnessToFollow(brightness, slowChange);
        goto L9
    L8:
        this.mDisplayBrightnessController.setBrightnessToFollow(leadDisplayBrightness, slowChange);
        goto L9
    }

    private void notifyBrightnessTrackerChanged(float brightness, boolean userInitiated, boolean wasShortTermModelActive, boolean autobrightnessEnabled, boolean brightnessIsTemporary, boolean shouldUseAutoBrightness) {
        float brightnessInNits = this.mDisplayBrightnessController.convertToAdjustedNits(brightness);
        if (brightnessIsTemporary == false) goto L5;
        return;
    L5:
        if (this.mAutomaticBrightnessController != null) goto L7;
        return;
    L7:
        if (this.mAutomaticBrightnessController.isInIdleMode() == true) goto L31;
        if (autobrightnessEnabled == true) goto L10;
        return;
    L10:
        if (this.mBrightnessTracker == null) goto L33;
        if (shouldUseAutoBrightness == true) goto L13;
        return;
    L13:
        if (brightnessInNits < SCREEN_ANIMATION_RATE_MINIMUM) goto L35;
        if (userInitiated == true) goto L18;
    L22:
        boolean userInitiated2 = userInitiated;
    L24:
        if (this.mPowerRequest.lowPowerMode == false) goto L26;
        float powerFactor = this.mPowerRequest.screenLowPowerBrightnessFactor;
    L27:
        this.mBrightnessTracker.notifyBrightnessChanged(brightnessInNits, userInitiated2, powerFactor, wasShortTermModelActive, this.mAutomaticBrightnessController.isDefaultConfig(), this.mUniqueDisplayId, this.mAutomaticBrightnessController.getLastSensorValues(), this.mAutomaticBrightnessController.getLastSensorTimestamps());
        return;
    L26:
        powerFactor = 1.0f;
        goto L27
    L18:
        if (this.mAutomaticBrightnessController != null) goto L20;
    L21:
        userInitiated2 = false;
        goto L24
    L20:
        if (this.mAutomaticBrightnessController.hasValidAmbientLux() == true) goto L22;
    L35:
        return;
    L33:
        return;
    }

    public void addDisplayBrightnessFollower(DisplayPowerController follower) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayBrightnessFollowers.append(follower.getDisplayId(), follower);     // Catch: Throwable -> L7
        sendUpdatePowerStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeDisplayBrightnessFollower(final DisplayPowerController follower) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayBrightnessFollowers.remove(follower.getDisplayId());     // Catch: Throwable -> L7
        this.mHandler.postAtTime(new DisplayPowerController$$ExternalSyntheticLambda9(follower), this.mClock.uptimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$removeDisplayBrightnessFollower$8(DisplayPowerController follower) {
        follower.setBrightnessToFollow(Float.NaN, -1.0f, SCREEN_ANIMATION_RATE_MINIMUM, false);
    }

    private void clearDisplayBrightnessFollowersLocked() {
        int i = 0;
    L4:
        if (i >= this.mDisplayBrightnessFollowers.size()) goto L6;
        final DisplayPowerController follower = this.mDisplayBrightnessFollowers.valueAt(i);
        this.mHandler.postAtTime(new DisplayPowerController$$ExternalSyntheticLambda0(follower), this.mClock.uptimeMillis());
        i = i + 1;
        goto L4
    L6:
        this.mDisplayBrightnessFollowers.clear();
    }

    private static /* synthetic */ void lambda$clearDisplayBrightnessFollowersLocked$9(DisplayPowerController follower) {
        follower.setBrightnessToFollow(Float.NaN, -1.0f, SCREEN_ANIMATION_RATE_MINIMUM, false);
    }

    public void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println();     // Catch: Throwable -> L15
        pw.println("Display Power Controller:");     // Catch: Throwable -> L15
        pw.println("-------------------------");     // Catch: Throwable -> L15
        pw.println("  mDisplayId=" + this.mDisplayId);     // Catch: Throwable -> L15
        pw.println("  mLeadDisplayId=" + this.mLeadDisplayId);     // Catch: Throwable -> L15
        pw.println("  mLightSensor=" + this.mLightSensor);     // Catch: Throwable -> L15
        pw.println("  mDisplayBrightnessFollowers=" + this.mDisplayBrightnessFollowers);     // Catch: Throwable -> L15
        pw.println();     // Catch: Throwable -> L15
        pw.println("Display Power Controller Locked State:");     // Catch: Throwable -> L15
        pw.println("  mDisplayReadyLocked=" + this.mDisplayReadyLocked);     // Catch: Throwable -> L15
        pw.println("  mPendingRequestLocked=" + this.mPendingRequestLocked);     // Catch: Throwable -> L15
        pw.println("  mPendingRequestChangedLocked=" + this.mPendingRequestChangedLocked);     // Catch: Throwable -> L15
        pw.println("  mPendingUpdatePowerStateLocked=" + this.mPendingUpdatePowerStateLocked);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        pw.println();
        pw.println("Display Power Controller Configuration:");
        pw.println("  mScreenBrightnessDozeConfig=" + this.mScreenBrightnessDozeConfig);
        pw.println("  mUseSoftwareAutoBrightnessConfig=" + this.mUseSoftwareAutoBrightnessConfig);
        pw.println("  mSkipScreenOnBrightnessRamp=" + this.mSkipScreenOnBrightnessRamp);
        pw.println("  mColorFadeFadesConfig=" + this.mColorFadeFadesConfig);
        pw.println("  mColorFadeEnabled=" + this.mColorFadeEnabled);
        pw.println("  mIsDisplayInternal=" + this.mIsDisplayInternal);
        CachedBrightnessInfo r1 = this.mCachedBrightnessInfo;
        monitor-enter(r1);
        pw.println("  mCachedBrightnessInfo.brightness=" + this.mCachedBrightnessInfo.brightness.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.adjustedBrightness=" + this.mCachedBrightnessInfo.adjustedBrightness.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.brightnessMin=" + this.mCachedBrightnessInfo.brightnessMin.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.brightnessMax=" + this.mCachedBrightnessInfo.brightnessMax.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.hbmMode=" + this.mCachedBrightnessInfo.hbmMode.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.hbmTransitionPoint=" + this.mCachedBrightnessInfo.hbmTransitionPoint.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.brightnessMaxReason =" + this.mCachedBrightnessInfo.brightnessMaxReason.value);     // Catch: Throwable -> L12
        pw.println("  mCachedBrightnessInfo.brightnessReason =" + this.mCachedBrightnessInfo.brightnessReason);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        pw.println("  mDisplayBlanksAfterDozeConfig=" + this.mDisplayBlanksAfterDozeConfig);
        pw.println("  mBrightnessBucketsInDozeConfig=" + this.mBrightnessBucketsInDozeConfig);
        pw.println("  mDozeScaleFactor=" + this.mDozeScaleFactor);
        dumpLocal(pw);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    private void dumpLocal(PrintWriter pw) {
        pw.println();
        pw.println("Display Power Controller Thread State:");
        pw.println("  mPowerRequest=" + this.mPowerRequest);
        pw.println("  mBrightnessReason=" + this.mBrightnessReason);
        pw.println("  mDozing=" + this.mDozing);
        pw.println("  mSkipRampState=" + skipRampStateToString(this.mSkipRampState));
        pw.println("  mScreenOnBlockStartRealTime=" + this.mScreenOnBlockStartRealTime);
        pw.println("  mScreenOffBlockStartRealTime=" + this.mScreenOffBlockStartRealTime);
        pw.println("  mPendingScreenOnUnblocker=" + this.mPendingScreenOnUnblocker);
        pw.println("  mPendingScreenOffUnblocker=" + this.mPendingScreenOffUnblocker);
        pw.println("  mPendingScreenOff=" + this.mPendingScreenOff);
        pw.println("  mReportedToPolicy=" + reportedToPolicyToString(this.mReportedScreenStateToPolicy));
        pw.println("  mIsRbcActive=" + this.mIsRbcActive);
        PrintWriter r0 = new IndentingPrintWriter(pw, "    ");
        this.mAutomaticBrightnessStrategy.dump(r0);
        if (this.mScreenBrightnessRampAnimator == null) goto L6;
        pw.println("  mScreenBrightnessRampAnimator.isAnimating()=" + this.mScreenBrightnessRampAnimator.isAnimating());
    L6:
        if (this.mColorFadeOnAnimator == null) goto L9;
        pw.println("  mColorFadeOnAnimator.isStarted()=" + this.mColorFadeOnAnimator.isStarted());
    L9:
        if (this.mColorFadeOffAnimator == null) goto L11;
        pw.println("  mColorFadeOffAnimator.isStarted()=" + this.mColorFadeOffAnimator.isStarted());
    L11:
        pw.println();
        if (this.mPowerState == null) goto L14;
        this.mPowerState.dump(pw);
    L14:
        pw.println();
        if (this.mDisplayBrightnessController == null) goto L17;
        this.mDisplayBrightnessController.dump(pw);
    L17:
        pw.println();
        if (this.mBrightnessClamperController == null) goto L20;
        this.mBrightnessClamperController.dump(r0);
    L20:
        pw.println();
        if (this.mBrightnessRangeController == null) goto L23;
        this.mBrightnessRangeController.dump(pw);
    L23:
        pw.println();
        if (this.mAutomaticBrightnessController == null) goto L26;
        this.mAutomaticBrightnessController.dump(pw);
        dumpBrightnessEvents(pw);
    L26:
        dumpRbcEvents(pw);
        pw.println();
        if (this.mScreenOffBrightnessSensorController == null) goto L29;
        this.mScreenOffBrightnessSensorController.dump(pw);
    L29:
        pw.println();
        if (this.mDisplayWhiteBalanceController == null) goto L32;
        this.mDisplayWhiteBalanceController.dump(pw);
        this.mDisplayWhiteBalanceSettings.dump(pw);
    L32:
        pw.println();
        if (this.mWakelockController == null) goto L35;
        this.mWakelockController.dumpLocal(pw);
    L35:
        pw.println();
        if (this.mDisplayStateController == null) goto L38;
        this.mDisplayStateController.dump(pw);
    L38:
        this.mExt.dump(pw);
    }

    private static String reportedToPolicyToString(int state) {
        switch(state) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "REPORTED_TO_POLICY_SCREEN_ON";
    L7:
        return "REPORTED_TO_POLICY_SCREEN_TURNING_ON";
    L9:
        return "REPORTED_TO_POLICY_SCREEN_OFF";
    L4:
        return Integer.toString(state);
    }

    private static String skipRampStateToString(int state) {
        switch(state) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "RAMP_STATE_SKIP_AUTOBRIGHT";
    L7:
        return "RAMP_STATE_SKIP_INITIAL";
    L9:
        return "RAMP_STATE_SKIP_NONE";
    L4:
        return Integer.toString(state);
    }

    private static boolean isDisplaySupportedForBatteryStats(DisplayDeviceInfo displayDeviceInfo) {
        switch(displayDeviceInfo.type) {
            case 1: goto L6;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    private void dumpBrightnessEvents(PrintWriter pw) {
        int size = this.mBrightnessEventRingBuffer.size();
        if (size >= 1) goto L6;
        pw.println("No Automatic Brightness Adjustments");
        return;
    L6:
        pw.println("Automatic Brightness Adjustments Last " + size + " Events: ");
        BrightnessEvent[] eventArray = (BrightnessEvent[]) this.mBrightnessEventRingBuffer.toArray();
        int i = 0;
    L8:
        if (i >= this.mBrightnessEventRingBuffer.size()) goto L11;
        pw.println("  " + eventArray[i].toString());
        i = i + 1;
        goto L8
    }

    private void dumpRbcEvents(PrintWriter pw) {
        int size = this.mRbcEventRingBuffer.size();
        if (size >= 1) goto L6;
        pw.println("No Reduce Bright Colors Adjustments");
        return;
    L6:
        pw.println("Reduce Bright Colors Adjustments Last " + size + " Events: ");
        BrightnessEvent[] eventArray = (BrightnessEvent[]) this.mRbcEventRingBuffer.toArray();
        int i = 0;
    L8:
        if (i >= this.mRbcEventRingBuffer.size()) goto L11;
        pw.println("  " + eventArray[i]);
        i = i + 1;
        goto L8
    }

    private void noteScreenState(int screenState, int reason) {
        FrameworkStatsLog.write(FrameworkStatsLog.SCREEN_STATE_CHANGED_V2, screenState, this.mDisplayStatsId, reason);
        if (this.mBatteryStats == null) goto L10;
        this.mBatteryStats.noteScreenState(this.mDisplayId, screenState, reason);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    private void noteScreenBrightness(float brightness) {
        if (this.mBatteryStats == null) goto L14;
        if (this.mFlags.isBrightnessIntRangeUserPerceptionEnabled() == false) goto L9;
        int brightnessInt = BrightnessSynchronizer.brightnessFloatToIntSetting(this.mContext, brightness);     // Catch: RemoteException -> L7
    L10:
        this.mBatteryStats.noteScreenBrightness(this.mDisplayId, brightnessInt);     // Catch: RemoteException -> L7
        return;
    L9:
        brightnessInt = BrightnessSynchronizer.brightnessFloatToIntForNormal(this.mContext, brightness);     // Catch: RemoteException -> L7
    L15:
        return;
    }

    private void reportStats(float brightness) {
        if (this.mLastStatsBrightness != brightness) goto L5;
        return;
    L5:
        CachedBrightnessInfo r1 = this.mCachedBrightnessInfo;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mCachedBrightnessInfo.hbmTransitionPoint != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        float hbmTransitionPoint = this.mCachedBrightnessInfo.hbmTransitionPoint.value;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        boolean oldAboveTransition = false;
        if (brightness <= hbmTransitionPoint) goto L18;
        boolean aboveTransition = true;
    L20:
        if (this.mLastStatsBrightness <= hbmTransitionPoint) goto L22;
        oldAboveTransition = true;
    L22:
        if (aboveTransition == true) goto L24;
        if (oldAboveTransition == true) goto L24;
        return;
    L24:
        this.mLastStatsBrightness = brightness;
        this.mHandler.removeMessages(11);
        if (aboveTransition == oldAboveTransition) goto L27;
        logHbmBrightnessStats(brightness, this.mDisplayStatsId);
        return;
    L27:
        Message msg = this.mHandler.obtainMessage();
        msg.what = 11;
        msg.arg1 = Float.floatToIntBits(brightness);
        msg.arg2 = this.mDisplayStatsId;
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis() + 500);
        return;
    L18:
        aboveTransition = false;
        goto L20
    }

    private void logHbmBrightnessStats(float brightness, int displayStatsId) {
        DisplayControllerHandler r0 = this.mHandler;
        monitor-enter(r0);
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_HBM_BRIGHTNESS_CHANGED, displayStatsId, brightness);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private int nitsToRangeIndex(float nits) {
        int i = 0;
    L4:
        if (i >= BRIGHTNESS_RANGE_BOUNDARIES.length) goto L10;
        if (nits < BRIGHTNESS_RANGE_BOUNDARIES[i]) goto L8;
        i = i + 1;
        goto L4
    L8:
        return BRIGHTNESS_RANGE_INDEX[i];
    L10:
        return 38;
    }

    private int convertBrightnessReasonToStatsEnum(int brightnessReason) {
        switch(brightnessReason) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 10;
    L7:
        return 9;
    L9:
        return 8;
    L11:
        return 7;
    L13:
        return 6;
    L15:
        return 5;
    L17:
        return 4;
    L19:
        return 3;
    L21:
        return 2;
    L23:
        return 1;
    L25:
        return 0;
    }

    private void logBrightnessEvent(BrightnessEvent event, float unmodifiedBrightness, DisplayBrightnessState brightnessState) {
        int modifier = event.getReason().getModifier();
        int flags = event.getFlags();
        if (unmodifiedBrightness != event.getHbmMax()) goto L5;
        boolean r3 = true;
    L6:
        boolean brightnessIsMax = r3;
        float brightnessInNits = this.mDisplayBrightnessController.convertToAdjustedNits(event.getBrightness());
        float r6 = -1.0f;
        if (event.isLowPowerModeSet() == false) goto L9;
        float appliedLowPowerMode = event.getPowerFactor();
    L11:
        if (event.isRbcEnabled() == false) goto L14;
        int r4 = event.getRbcStrength();
    L13:
        int appliedRbcStrength = r4;
        if (event.getHbmMode() != 0) goto L18;
        float appliedHbmMaxNits = -1.0f;
    L20:
        if (event.getThermalMax() != 1.0f) goto L22;
    L21:
        float appliedThermalCapNits = r6;
        if (this.mIsDisplayInternal == false) goto L63;
        float r7 = this.mDisplayBrightnessController.convertToAdjustedNits(event.getInitialBrightness());
        float r9 = event.getLux();
        String r10 = event.getPhysicalDisplayId();
        boolean r11 = event.wasShortTermModelActive();
        boolean r16 = event.isAutomaticBrightnessEnabled();
        int r18 = convertBrightnessReasonToStatsEnum(event.getReason().getReason());
        int r19 = nitsToRangeIndex(brightnessInNits);
        if (event.getHbmMode() != 1) goto L28;
        boolean r21 = true;
    L30:
        if (event.getHbmMode() != 2) goto L32;
        boolean r22 = true;
    L34:
        if ((modifier & 2) <= 0) goto L36;
        boolean r23 = true;
    L37:
        int r24 = brightnessState.getBrightnessMaxReason();
        if ((modifier & 1) <= 0) goto L40;
        boolean r25 = true;
    L41:
        boolean r26 = event.isRbcEnabled();
        if ((flags & 2) <= 0) goto L44;
        boolean r27 = true;
    L46:
        if ((flags & 4) <= 0) goto L48;
        boolean r28 = true;
    L50:
        if ((flags & 8) <= 0) goto L52;
        boolean r29 = true;
    L54:
        if (event.getAutoBrightnessMode() != 1) goto L56;
        boolean r30 = true;
    L58:
        if ((flags & 32) <= 0) goto L60;
        boolean r31 = true;
    L61:
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_BRIGHTNESS_CHANGED, r7, brightnessInNits, r9, r10, r11, appliedLowPowerMode, appliedRbcStrength, appliedHbmMaxNits, appliedThermalCapNits, r16, 1, r18, r19, brightnessIsMax, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
        return;
    L60:
        r31 = false;
        goto L61
    L56:
        r30 = false;
        goto L58
    L52:
        r29 = false;
        goto L54
    L48:
        r28 = false;
        goto L50
    L44:
        r27 = false;
        goto L46
    L40:
        r25 = false;
        goto L41
    L36:
        r23 = false;
        goto L37
    L32:
        r22 = false;
        goto L34
    L28:
        r21 = false;
        goto L30
    L63:
        return;
    L22:
        r6 = this.mDisplayBrightnessController.convertToAdjustedNits(event.getThermalMax());
        goto L21
    L18:
        appliedHbmMaxNits = this.mDisplayBrightnessController.convertToAdjustedNits(event.getHbmMax());
        goto L20
    L14:
        r4 = -1;
        goto L13
    L9:
        appliedLowPowerMode = -1.0f;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    private boolean readyToUpdateDisplayState() {
        if (this.mDisplayId != 0) goto L5;
    L8:
        return true;
    L5:
        if (this.mBootCompleted == true) goto L8;
        return false;
    }

    public void stylusGestureStarted(long eventTimeNanoSeconds) {
        long eventTimeMs = eventTimeNanoSeconds / 1000000;
        if (this.mLastStylusUsageEventTime != (-1)) goto L5;
    L6:
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mHandler.sendEmptyMessageAtTime(19, this.mClock.uptimeMillis());     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        this.mLastStylusUsageEventTime = eventTimeMs;
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (eventTimeMs > (this.mLastStylusUsageEventTime + 1000)) goto L6;
    }

    public void setAutoBrightnessLoggingEnabled(boolean enabled) {
        if (this.mAutomaticBrightnessController == null) goto L6;
        this.mAutomaticBrightnessController.setLoggingEnabled(enabled);
        return;
    }

    @Override // com.android.server.display.whitebalance.DisplayWhiteBalanceController.Callbacks
    public void updateWhiteBalance() {
        sendUpdatePowerState();
    }

    public void setDisplayWhiteBalanceLoggingEnabled(boolean r3) {
        Message r0 = this.mHandler.obtainMessage();
        r0.what = 16;
        r0.arg1 = r3 ? 1 : 0;
        r0.sendToTarget();
    }

    public void setAmbientColorTemperatureOverride(float cct) {
        Message msg = this.mHandler.obtainMessage();
        msg.what = 15;
        msg.arg1 = Float.floatToIntBits(cct);
        msg.sendToTarget();
    }

    public DisplayPowerControllerSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IExtDisplayPowerController getExt() {
        return this.mExt;
    }
}
