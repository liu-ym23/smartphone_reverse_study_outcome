package com.android.server.display;

import android.app.ActivityTaskManager;
import android.app.IActivityTaskManager;
import android.app.TaskStackListener;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.BrightnessConfiguration;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.view.Display;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.os.BackgroundThread;
import com.android.server.EventLogTags;
import com.android.server.display.brightness.BrightnessEvent;
import com.android.server.display.brightness.clamper.BrightnessClamperController;
import com.android.server.display.config.DisplayBrightnessMappingConfig;
import com.android.server.display.config.HysteresisLevels;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.job.controllers.JobStatus;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class AutomaticBrightnessController {
    private static final long AMBIENT_LIGHT_PREDICTION_TIME_MILLIS = 100;
    public static final int AUTO_BRIGHTNESS_DISABLED = 2;
    public static final int AUTO_BRIGHTNESS_ENABLED = 1;
    public static final int AUTO_BRIGHTNESS_MODE_BEDTIME_WEAR = 3;
    public static final int AUTO_BRIGHTNESS_MODE_DEFAULT = 0;
    public static final int AUTO_BRIGHTNESS_MODE_DOZE = 2;
    public static final int AUTO_BRIGHTNESS_MODE_IDLE = 1;
    public static final int AUTO_BRIGHTNESS_MODE_MAX = 2;
    public static final int AUTO_BRIGHTNESS_OFF_DUE_TO_DISPLAY_STATE = 3;
    private static final int BRIGHTNESS_ADJUSTMENT_SAMPLE_DEBOUNCE_MILLIS = 10000;
    private static final boolean DEBUG_PRETEND_LIGHT_SENSOR_ABSENT = false;
    private static final int MSG_BRIGHTNESS_ADJUSTMENT_SAMPLE = 2;
    private static final int MSG_INVALIDATE_CURRENT_SHORT_TERM_MODEL = 3;
    private static final int MSG_INVALIDATE_PAUSED_SHORT_TERM_MODEL = 7;
    private static final int MSG_RUN_UPDATE = 6;
    private static final int MSG_UPDATE_AMBIENT_LUX = 1;
    private static final int MSG_UPDATE_FOREGROUND_APP = 4;
    private static final int MSG_UPDATE_FOREGROUND_APP_SYNC = 5;
    private static final String TAG = "AutomaticBrightnessController";
    private IActivityTaskManager mActivityTaskManager;
    private float mAmbientBrighteningThreshold;
    private final HysteresisLevels mAmbientBrightnessThresholds;
    private final HysteresisLevels mAmbientBrightnessThresholdsIdle;
    private float mAmbientDarkeningThreshold;
    private final int mAmbientLightHorizonLong;
    private final int mAmbientLightHorizonShort;
    private AmbientLightRingBuffer mAmbientLightRingBuffer;
    private float mAmbientLux;
    protected boolean mAmbientLuxValid;
    private final long mBrighteningLightDebounceConfig;
    private final long mBrighteningLightDebounceConfigIdle;
    private float mBrightnessAdjustmentSampleOldBrightness;
    private float mBrightnessAdjustmentSampleOldLux;
    private boolean mBrightnessAdjustmentSamplePending;
    private final BrightnessClamperController mBrightnessClamperController;
    private final SparseArray<BrightnessMappingStrategy> mBrightnessMappingStrategyMap;
    private final BrightnessRangeController mBrightnessRangeController;
    private final Callbacks mCallbacks;
    private Clock mClock;
    protected Context mContext;
    protected BrightnessMappingStrategy mCurrentBrightnessMapper;
    private int mCurrentLightSensorRate;
    private final long mDarkeningLightDebounceConfig;
    private final long mDarkeningLightDebounceConfigIdle;
    private final DisplayManagerFlags mDisplayManagerFlags;
    private int mDisplayPolicy;
    private int mDisplayState;
    private final float mDozeScaleFactor;
    private IExtAutomaticBrightnessController mExt;
    private float mFastAmbientLux;
    private int mForegroundAppCategory;
    private String mForegroundAppPackageName;
    protected AutomaticBrightnessHandler mHandler;
    private final int mInitialLightSensorRate;
    private final Injector mInjector;
    private boolean mIsBrightnessThrottled;
    private float mLastObservedLux;
    private long mLastObservedLuxTime;
    private final Sensor mLightSensor;
    private long mLightSensorEnableTime;
    private boolean mLightSensorEnabled;
    private final SensorEventListener mLightSensorListener;
    private int mLightSensorWarmUpTimeConfig;
    private boolean mLoggingEnabled;
    private final int mNormalLightSensorRate;
    private PackageManager mPackageManager;
    private final ShortTermModel mPausedShortTermModel;
    private int mPendingForegroundAppCategory;
    private String mPendingForegroundAppPackageName;
    private float mPreThresholdBrightness;
    private float mPreThresholdLux;
    protected float mRawScreenAutoBrightness;
    private int mRecentLightSamples;
    private final boolean mResetAmbientLuxAfterWarmUpConfig;
    protected float mScreenAutoBrightness;
    private float mScreenBrighteningThreshold;
    private final float mScreenBrightnessRangeMaximum;
    private final float mScreenBrightnessRangeMinimum;
    private final HysteresisLevels mScreenBrightnessThresholds;
    private final HysteresisLevels mScreenBrightnessThresholdsIdle;
    private float mScreenDarkeningThreshold;
    private final SensorManager mSensorManager;
    private final ShortTermModel mShortTermModel;
    private float mSlowAmbientLux;
    private int mState;
    private TaskStackListenerImpl mTaskStackListener;
    private boolean mUseNormalBrightnessForDoze;
    private final int mWeightingIntercept;

    private static final class AmbientLightRingBuffer {
        private static final float BUFFER_SLACK = 1.5f;
        private int mCapacity;
        Clock mClock;
        private int mCount;
        private int mEnd;
        private float[] mRingLux;
        private long[] mRingTime;
        private int mStart;

        public AmbientLightRingBuffer(long lightSensorRate, int ambientLightHorizon, Clock clock) {
            if (lightSensorRate <= 0) goto L7;
            this.mCapacity = (int) Math.ceil((ambientLightHorizon * BUFFER_SLACK) / lightSensorRate);
            this.mRingLux = new float[this.mCapacity];
            this.mRingTime = new long[this.mCapacity];
            this.mClock = clock;
            return;
        L7:
            throw new IllegalArgumentException("lightSensorRate must be above 0");
        }

        public float getLux(int index) {
            return this.mRingLux[offsetOf(index)];
        }

        public float[] getAllLuxValues() {
            float[] values = new float[this.mCount];
            if (this.mCount != 0) goto L6;
            return values;
        L6:
            if (this.mStart >= this.mEnd) goto L8;
            System.arraycopy(this.mRingLux, this.mStart, values, 0, this.mCount);
        L9:
            return values;
        L8:
            System.arraycopy(this.mRingLux, this.mStart, values, 0, this.mCapacity - this.mStart);
            System.arraycopy(this.mRingLux, 0, values, this.mCapacity - this.mStart, this.mEnd);
            goto L9
        }

        public long getTime(int index) {
            return this.mRingTime[offsetOf(index)];
        }

        public long[] getAllTimestamps() {
            long[] values = new long[this.mCount];
            if (this.mCount != 0) goto L6;
            return values;
        L6:
            if (this.mStart >= this.mEnd) goto L8;
            System.arraycopy(this.mRingTime, this.mStart, values, 0, this.mCount);
        L9:
            return values;
        L8:
            System.arraycopy(this.mRingTime, this.mStart, values, 0, this.mCapacity - this.mStart);
            System.arraycopy(this.mRingTime, 0, values, this.mCapacity - this.mStart, this.mEnd);
            goto L9
        }

        public void push(long time, float lux) {
            int next = this.mEnd;
            if (this.mCount != this.mCapacity) goto L8;
            int newSize = this.mCapacity * 2;
            float[] newRingLux = new float[newSize];
            long[] newRingTime = new long[newSize];
            int length = this.mCapacity - this.mStart;
            System.arraycopy(this.mRingLux, this.mStart, newRingLux, 0, length);
            System.arraycopy(this.mRingTime, this.mStart, newRingTime, 0, length);
            if (this.mStart == 0) goto L7;
            System.arraycopy(this.mRingLux, 0, newRingLux, length, this.mStart);
            System.arraycopy(this.mRingTime, 0, newRingTime, length, this.mStart);
        L7:
            this.mRingLux = newRingLux;
            this.mRingTime = newRingTime;
            next = this.mCapacity;
            this.mCapacity = newSize;
            this.mStart = 0;
        L8:
            this.mRingTime[next] = time;
            this.mRingLux[next] = lux;
            this.mEnd = next + 1;
            if (this.mEnd != this.mCapacity) goto L11;
            this.mEnd = 0;
        L11:
            this.mCount++;
        }

        public void prune(long horizon) {
            if (this.mCount != 0) goto L6;
            return;
        L6:
            if (this.mCount <= 1) goto L15;
            int next = this.mStart + 1;
            if (next < this.mCapacity) goto L11;
            next = next - this.mCapacity;
        L11:
            if (this.mRingTime[next] > horizon) goto L15;
            this.mStart = next;
            this.mCount--;
        L15:
            if (this.mRingTime[this.mStart] >= horizon) goto L20;
            this.mRingTime[this.mStart] = horizon;
            return;
        }

        public int size() {
            return this.mCount;
        }

        public void clear() {
            this.mStart = 0;
            this.mEnd = 0;
            this.mCount = 0;
        }

        public String toString() {
            StringBuilder buf = new StringBuilder();
            buf.append('[');
            int i = 0;
        L4:
            if (i >= this.mCount) goto L13;
            if ((i + 1) >= this.mCount) goto L8;
            long next = getTime(i + 1);
        L10:
            if (i == 0) goto L12;
            buf.append(", ");
        L12:
            buf.append(getLux(i));
            buf.append(" / ");
            buf.append(next - getTime(i));
            buf.append("ms");
            i = i + 1;
            goto L4
        L8:
            next = this.mClock.getSensorEventScaleTime();
            goto L10
        L13:
            buf.append(']');
            return buf.toString();
        }

        private int offsetOf(int index) {
            if (index >= this.mCount) goto L10;
            if (index < 0) goto L10;
            int index2 = index + this.mStart;
            if (index2 >= this.mCapacity) goto L8;
            return index2;
        L8:
            return index2 - this.mCapacity;
        L10:
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    private final class AutomaticBrightnessHandler extends Handler {
        final /* synthetic */ AutomaticBrightnessController this$0;

        public AutomaticBrightnessHandler(AutomaticBrightnessController r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            ShortTermModel.m3577$$Nest$minvalidate(AutomaticBrightnessController.m3568$$Nest$fgetmPausedShortTermModel(this.this$0));
            return;
        L6:
            this.this$0.updateAutoBrightness(true, false);
            return;
        L7:
            AutomaticBrightnessController.m3576$$Nest$mupdateForegroundAppSync(this.this$0);
            return;
        L8:
            AutomaticBrightnessController.m3575$$Nest$mupdateForegroundApp(this.this$0);
            return;
        L9:
            ShortTermModel.m3577$$Nest$minvalidate(AutomaticBrightnessController.m3569$$Nest$fgetmShortTermModel(this.this$0));
            return;
        L10:
            AutomaticBrightnessController.m3572$$Nest$mcollectBrightnessAdjustmentSample(this.this$0);
            return;
        L11:
            AutomaticBrightnessController.m3574$$Nest$mupdateAmbientLux(this.this$0);
            return;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutomaticBrightnessMode {
    }

    interface Callbacks {
        void updateBrightness();
    }

    interface Clock {
        long getSensorEventScaleTime();

        long uptimeMillis();
    }

    public static class Injector {
        public Injector() {
        }

        public Handler getBackgroundThreadHandler() {
            return BackgroundThread.getHandler();
        }

        Clock createClock() {
            return new RealClock(null);
        }
    }

    private static class RealClock implements Clock {
        /* synthetic */ RealClock(AutomaticBrightnessControllerIA r1) {
            this();
        }

        private RealClock() {
        }

        @Override // com.android.server.display.AutomaticBrightnessController.Clock
        public long uptimeMillis() {
            return SystemClock.uptimeMillis();
        }

        @Override // com.android.server.display.AutomaticBrightnessController.Clock
        public long getSensorEventScaleTime() {
            return SystemClock.elapsedRealtime();
        }
    }

    private class ShortTermModel {
        private float mAnchor;
        private float mBrightness;
        private boolean mIsValid;
        final /* synthetic */ AutomaticBrightnessController this$0;

        /* JADX INFO: renamed from: -$$Nest$minvalidate, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3577$$Nest$minvalidate(ShortTermModel r0) {
            r0.invalidate();
        }

        /* JADX INFO: renamed from: -$$Nest$mmaybeReset, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3578$$Nest$mmaybeReset(ShortTermModel r0, float r1) {
            return r0.maybeReset(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mreset, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3579$$Nest$mreset(ShortTermModel r0) {
            r0.reset();
        }

        /* JADX INFO: renamed from: -$$Nest$mset, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3580$$Nest$mset(ShortTermModel r0, float r1, float r2, boolean r3) {
            r0.set(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$msetUserBrightness, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3581$$Nest$msetUserBrightness(ShortTermModel r0, float r1, float r2) {
            r0.setUserBrightness(r1, r2);
        }

        /* synthetic */ ShortTermModel(AutomaticBrightnessController r1, AutomaticBrightnessControllerIA r2) {
            this(r1);
        }

        private ShortTermModel(AutomaticBrightnessController r1) {
            this.this$0 = r1;
            this.mAnchor = -1.0f;
            this.mBrightness = Float.NaN;
            this.mIsValid = false;
        }

        private void reset() {
            this.mAnchor = -1.0f;
            this.mBrightness = Float.NaN;
            this.mIsValid = false;
        }

        private void invalidate() {
            this.mIsValid = false;
            if (AutomaticBrightnessController.m3566$$Nest$fgetmLoggingEnabled(this.this$0) == false) goto L6;
            Slog.d(AutomaticBrightnessController.TAG, "ShortTermModel: invalidate user data");
            return;
        }

        private void setUserBrightness(float lux, float brightness) {
            this.mAnchor = lux;
            this.mBrightness = brightness;
            this.mIsValid = true;
            if (AutomaticBrightnessController.m3566$$Nest$fgetmLoggingEnabled(this.this$0) == false) goto L6;
            Slog.d(AutomaticBrightnessController.TAG, "ShortTermModel: anchor=" + this.mAnchor);
            return;
        }

        private boolean maybeReset(float currentLux) {
            if (this.mIsValid == false) goto L5;
            return false;
        L5:
            if (this.mAnchor != (-1.0f)) goto L7;
            return false;
        L7:
            if (this.this$0.mCurrentBrightnessMapper.shouldResetShortTermModel(currentLux, this.mAnchor) == false) goto L9;
            this.this$0.resetShortTermModel();
        L11:
            return this.mIsValid;
        L9:
            this.mIsValid = true;
            goto L11
        }

        private void set(float anchor, float brightness, boolean valid) {
            this.mAnchor = anchor;
            this.mBrightness = brightness;
            this.mIsValid = valid;
        }

        private void copyFrom(ShortTermModel from) {
            this.mAnchor = from.mAnchor;
            this.mBrightness = from.mBrightness;
            this.mIsValid = from.mIsValid;
        }

        public String toString() {
            return "mAnchor: " + this.mAnchor + "\n mBrightness: " + this.mBrightness + "\n mIsValid: " + this.mIsValid;
        }

        void dump(IndentingPrintWriter ipw) {
            ipw.increaseIndent();
            ipw.println(this);
            ipw.decreaseIndent();
        }
    }

    class TaskStackListenerImpl extends TaskStackListener {
        final /* synthetic */ AutomaticBrightnessController this$0;

        TaskStackListenerImpl(AutomaticBrightnessController this$0) {
            this.this$0 = this$0;
        }

        public void onTaskStackChanged() {
            this.this$0.mHandler.sendEmptyMessage(4);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IActivityTaskManager m3563$$Nest$fgetmActivityTaskManager(AutomaticBrightnessController r0) {
        return r0.mActivityTaskManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForegroundAppPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3564$$Nest$fgetmForegroundAppPackageName(AutomaticBrightnessController r0) {
        return r0.mForegroundAppPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightSensorEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3565$$Nest$fgetmLightSensorEnabled(AutomaticBrightnessController r0) {
        return r0.mLightSensorEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLoggingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3566$$Nest$fgetmLoggingEnabled(AutomaticBrightnessController r0) {
        return r0.mLoggingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m3567$$Nest$fgetmPackageManager(AutomaticBrightnessController r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPausedShortTermModel, reason: not valid java name */
    static /* bridge */ /* synthetic */ ShortTermModel m3568$$Nest$fgetmPausedShortTermModel(AutomaticBrightnessController r0) {
        return r0.mPausedShortTermModel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortTermModel, reason: not valid java name */
    static /* bridge */ /* synthetic */ ShortTermModel m3569$$Nest$fgetmShortTermModel(AutomaticBrightnessController r0) {
        return r0.mShortTermModel;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingForegroundAppCategory, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3570$$Nest$fputmPendingForegroundAppCategory(AutomaticBrightnessController r0, int r1) {
        r0.mPendingForegroundAppCategory = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingForegroundAppPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3571$$Nest$fputmPendingForegroundAppPackageName(AutomaticBrightnessController r0, String r1) {
        r0.mPendingForegroundAppPackageName = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcollectBrightnessAdjustmentSample, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3572$$Nest$mcollectBrightnessAdjustmentSample(AutomaticBrightnessController r0) {
        r0.collectBrightnessAdjustmentSample();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLightSensorEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3573$$Nest$mhandleLightSensorEvent(AutomaticBrightnessController r0, long r1, float r3) {
        r0.handleLightSensorEvent(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAmbientLux, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3574$$Nest$mupdateAmbientLux(AutomaticBrightnessController r0) {
        r0.updateAmbientLux();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateForegroundApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3575$$Nest$mupdateForegroundApp(AutomaticBrightnessController r0) {
        r0.updateForegroundApp();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateForegroundAppSync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3576$$Nest$mupdateForegroundAppSync(AutomaticBrightnessController r0) {
        r0.updateForegroundAppSync();
    }

    AutomaticBrightnessController(Callbacks callbacks, Looper looper, SensorManager sensorManager, Sensor lightSensor, SparseArray<BrightnessMappingStrategy> brightnessMappingStrategyMap, int lightSensorWarmUpTime, float brightnessMin, float brightnessMax, float dozeScaleFactor, int lightSensorRate, int initialLightSensorRate, long brighteningLightDebounceConfig, long darkeningLightDebounceConfig, long brighteningLightDebounceConfigIdle, long darkeningLightDebounceConfigIdle, boolean resetAmbientLuxAfterWarmUpConfig, HysteresisLevels ambientBrightnessThresholds, HysteresisLevels screenBrightnessThresholds, HysteresisLevels ambientBrightnessThresholdsIdle, HysteresisLevels screenBrightnessThresholdsIdle, Context context, BrightnessRangeController brightnessModeController, BrightnessClamperController clamperController, int ambientLightHorizonShort, int ambientLightHorizonLong, float userLux, float userNits, DisplayManagerFlags displayManagerFlags) {
        this(new Injector(), callbacks, looper, sensorManager, lightSensor, brightnessMappingStrategyMap, lightSensorWarmUpTime, brightnessMin, brightnessMax, dozeScaleFactor, lightSensorRate, initialLightSensorRate, brighteningLightDebounceConfig, darkeningLightDebounceConfig, brighteningLightDebounceConfigIdle, darkeningLightDebounceConfigIdle, resetAmbientLuxAfterWarmUpConfig, ambientBrightnessThresholds, screenBrightnessThresholds, ambientBrightnessThresholdsIdle, screenBrightnessThresholdsIdle, context, brightnessModeController, clamperController, ambientLightHorizonShort, ambientLightHorizonLong, userLux, userNits, displayManagerFlags);
    }

    AutomaticBrightnessController(Injector injector, Callbacks callbacks, Looper looper, SensorManager sensorManager, Sensor lightSensor, SparseArray<BrightnessMappingStrategy> brightnessMappingStrategyMap, int lightSensorWarmUpTime, float brightnessMin, float brightnessMax, float dozeScaleFactor, int lightSensorRate, int initialLightSensorRate, long brighteningLightDebounceConfig, long darkeningLightDebounceConfig, long brighteningLightDebounceConfigIdle, long darkeningLightDebounceConfigIdle, boolean resetAmbientLuxAfterWarmUpConfig, HysteresisLevels ambientBrightnessThresholds, HysteresisLevels screenBrightnessThresholds, HysteresisLevels ambientBrightnessThresholdsIdle, HysteresisLevels screenBrightnessThresholdsIdle, Context context, BrightnessRangeController brightnessRangeController, BrightnessClamperController clamperController, int ambientLightHorizonShort, int ambientLightHorizonLong, float userLux, float userNits, DisplayManagerFlags displayManagerFlags) {
        this.mAmbientLux = -1.0f;
        this.mScreenAutoBrightness = Float.NaN;
        this.mRawScreenAutoBrightness = Float.NaN;
        this.mDisplayPolicy = 0;
        this.mDisplayState = 0;
        this.mState = 2;
        this.mLightSensorListener = new AnonymousClass2(this);
        this.mExt = (IExtAutomaticBrightnessController) ExtImplFactory.getImpl(IExtAutomaticBrightnessController.class, new Object[]{this});
        this.mInjector = injector;
        this.mClock = injector.createClock();
        this.mContext = context;
        this.mCallbacks = callbacks;
        this.mSensorManager = sensorManager;
        this.mCurrentBrightnessMapper = brightnessMappingStrategyMap.get(0);
        this.mScreenBrightnessRangeMinimum = brightnessMin;
        this.mScreenBrightnessRangeMaximum = brightnessMax;
        this.mLightSensorWarmUpTimeConfig = lightSensorWarmUpTime;
        this.mDozeScaleFactor = dozeScaleFactor;
        this.mNormalLightSensorRate = lightSensorRate;
        this.mInitialLightSensorRate = initialLightSensorRate;
        this.mCurrentLightSensorRate = -1;
        this.mBrighteningLightDebounceConfig = brighteningLightDebounceConfig;
        this.mDarkeningLightDebounceConfig = darkeningLightDebounceConfig;
        this.mBrighteningLightDebounceConfigIdle = brighteningLightDebounceConfigIdle;
        this.mDarkeningLightDebounceConfigIdle = darkeningLightDebounceConfigIdle;
        this.mResetAmbientLuxAfterWarmUpConfig = resetAmbientLuxAfterWarmUpConfig;
        this.mAmbientLightHorizonLong = ambientLightHorizonLong;
        this.mAmbientLightHorizonShort = ambientLightHorizonShort;
        this.mWeightingIntercept = ambientLightHorizonLong;
        this.mAmbientBrightnessThresholds = ambientBrightnessThresholds;
        this.mAmbientBrightnessThresholdsIdle = ambientBrightnessThresholdsIdle;
        this.mScreenBrightnessThresholds = screenBrightnessThresholds;
        this.mScreenBrightnessThresholdsIdle = screenBrightnessThresholdsIdle;
        AutomaticBrightnessControllerIA r4 = null;
        this.mShortTermModel = new ShortTermModel(this, r4);
        this.mPausedShortTermModel = new ShortTermModel(this, r4);
        this.mHandler = new AutomaticBrightnessHandler(this, looper);
        this.mAmbientLightRingBuffer = new AmbientLightRingBuffer(this.mNormalLightSensorRate, this.mAmbientLightHorizonLong, this.mClock);
        this.mLightSensor = lightSensor;
        this.mActivityTaskManager = ActivityTaskManager.getService();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mTaskStackListener = new TaskStackListenerImpl(this);
        this.mForegroundAppPackageName = null;
        this.mPendingForegroundAppPackageName = null;
        this.mForegroundAppCategory = -1;
        this.mPendingForegroundAppCategory = -1;
        this.mBrightnessRangeController = brightnessRangeController;
        this.mBrightnessClamperController = clamperController;
        this.mBrightnessMappingStrategyMap = brightnessMappingStrategyMap;
        this.mDisplayManagerFlags = displayManagerFlags;
        if (userNits == (-1.0f)) goto L6;
        setScreenBrightnessByUser(userLux, getBrightnessFromNits(userNits));
    L6:
        this.mExt.init();
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        int i = 0;
    L8:
        if (i >= this.mBrightnessMappingStrategyMap.size()) goto L10;
        this.mBrightnessMappingStrategyMap.valueAt(i).setLoggingEnabled(loggingEnabled);
        i = i + 1;
        goto L8
    L10:
        this.mLoggingEnabled = loggingEnabled;
        return true;
    }

    public float getAutomaticScreenBrightness() {
        return getAutomaticScreenBrightness(null);
    }

    public float getAutomaticScreenBrightness(BrightnessEvent brightnessEvent) {
        if (brightnessEvent == null) goto L16;
        if (this.mAmbientLuxValid == false) goto L6;
        float r0 = this.mAmbientLux;
    L7:
        brightnessEvent.setLux(r0);
        brightnessEvent.setPreThresholdLux(this.mPreThresholdLux);
        brightnessEvent.setPreThresholdBrightness(this.mPreThresholdBrightness);
        brightnessEvent.setRecommendedBrightness(this.mScreenAutoBrightness);
        int r1 = brightnessEvent.getFlags();
        int r2 = 0;
        if (this.mAmbientLuxValid == true) goto L10;
        int r3 = 2;
    L11:
        int r4 = r1 | r3;
        if (shouldApplyDozeScaleFactor() == false) goto L14;
        r2 = 4;
    L14:
        brightnessEvent.setFlags(r4 | r2);
        brightnessEvent.setAutoBrightnessMode(getMode());
        goto L16
    L10:
        r3 = 0;
        goto L11
    L6:
        r0 = Float.NaN;
    L16:
        return this.mScreenAutoBrightness;
    }

    public float getRawAutomaticScreenBrightness() {
        return this.mRawScreenAutoBrightness;
    }

    public boolean hasValidAmbientLux() {
        return this.mAmbientLuxValid;
    }

    public float getAutomaticScreenBrightnessAdjustment() {
        return this.mCurrentBrightnessMapper.getAutoBrightnessAdjustment();
    }

    public void configure(int state, BrightnessConfiguration configuration, float brightness, boolean userChangedBrightness, float adjustment, boolean userChangedAutoBrightnessAdjustment, int displayPolicy, int displayState, boolean useNormalBrightnessForDoze, boolean shouldResetShortTermModel) {
        this.mState = state;
        boolean changed = setBrightnessConfiguration(configuration, shouldResetShortTermModel) | setDisplayPolicy(displayPolicy);
        this.mDisplayState = displayState;
        this.mUseNormalBrightnessForDoze = useNormalBrightnessForDoze;
        if (userChangedAutoBrightnessAdjustment == false) goto L5;
        float r6 = adjustment;
        changed = changed | setAutoBrightnessAdjustment(r6);
    L6:
        boolean r5 = true;
        if (this.mState != 1) goto L9;
        boolean r4 = true;
    L10:
        boolean enable = r4;
        if (userChangedBrightness == false) goto L14;
        if (enable == false) goto L14;
        float r7 = brightness;
        boolean changed2 = changed | setScreenBrightnessByUser(r7);
    L15:
        if (userChangedBrightness == true) goto L19;
        if (userChangedAutoBrightnessAdjustment == true) goto L19;
        r5 = false;
    L19:
        boolean userInitiatedChange = r5;
        boolean changed3 = this.mExt.configure(state, configuration, r7, userChangedBrightness, r6, userChangedAutoBrightnessAdjustment, displayPolicy, displayState, shouldResetShortTermModel) | changed2;
        boolean isBrightnessThrottled = this.mBrightnessClamperController.isThrottled();
        if (this.mIsBrightnessThrottled == isBrightnessThrottled) goto L22;
        this.mIsBrightnessThrottled = isBrightnessThrottled;
        changed3 = true;
    L22:
        if (changed3 == false) goto L25;
        updateAutoBrightness(false, userInitiatedChange);
        return;
    L25:
        return;
    L14:
        r7 = brightness;
        changed2 = changed;
        goto L15
    L9:
        r4 = false;
        goto L10
    L5:
        r6 = adjustment;
        goto L6
    }

    public void stop() {
        this.mExt.stop();
        setLightSensorEnabled(false);
    }

    public boolean hasUserDataPoints() {
        return this.mCurrentBrightnessMapper.hasUserDataPoints();
    }

    public boolean isDefaultConfig() {
        if (this.mCurrentBrightnessMapper.getMode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mCurrentBrightnessMapper.isDefaultConfig() == false) goto L7;
        return true;
    }

    public BrightnessConfiguration getDefaultConfig() {
        return this.mBrightnessMappingStrategyMap.get(0).getDefaultConfig();
    }

    public void update() {
        this.mHandler.sendEmptyMessage(6);
    }

    float getAmbientLux() {
        return this.mAmbientLux;
    }

    float getSlowAmbientLux() {
        return this.mSlowAmbientLux;
    }

    float getFastAmbientLux() {
        return this.mFastAmbientLux;
    }

    private boolean setDisplayPolicy(int policy) {
        if (this.mDisplayPolicy != policy) goto L6;
        return false;
    L6:
        int oldPolicy = this.mDisplayPolicy;
        this.mDisplayPolicy = policy;
        if (this.mLoggingEnabled == false) goto L10;
        Slog.d(TAG, "Display policy transitioning from " + oldPolicy + " to " + policy);
    L10:
        if (isInteractivePolicy(policy) == true) goto L17;
        if (isInteractivePolicy(oldPolicy) == false) goto L17;
        if (isInIdleMode() == true) goto L17;
        this.mHandler.sendEmptyMessageDelayed(3, this.mCurrentBrightnessMapper.getShortTermModelTimeout());
        return true;
    L17:
        if (isInteractivePolicy(policy) == true) goto L19;
        return true;
    L19:
        if (isInteractivePolicy(oldPolicy) == true) goto L25;
        this.mHandler.removeMessages(3);
        return true;
    L25:
        return true;
    }

    private static boolean isInteractivePolicy(int policy) {
        if (policy != 3) goto L5;
    L8:
        return true;
    L5:
        if (policy == 2) goto L8;
        return false;
    }

    private boolean setScreenBrightnessByUser(float brightness) {
        if (this.mAmbientLuxValid == true) goto L7;
        return false;
    L7:
        return setScreenBrightnessByUser(this.mAmbientLux, brightness);
    }

    protected boolean setScreenBrightnessByUser(float lux, float brightness) {
        if (lux != (-1.0f)) goto L5;
        return false;
    L5:
        if (Float.isNaN(brightness) == true) goto L11;
        this.mCurrentBrightnessMapper.addUserDataPoint(lux, brightness);
        ShortTermModel.m3581$$Nest$msetUserBrightness(this.mShortTermModel, lux, brightness);
        this.mExt.setScreenBrightnessByUser(lux, brightness);
        return true;
    L11:
        return false;
    }

    public void resetShortTermModel() {
        this.mCurrentBrightnessMapper.clearUserDataPoints();
        ShortTermModel.m3579$$Nest$mreset(this.mShortTermModel);
        Slog.i(TAG, "Resetting short term model");
        this.mExt.clearUserDataPoints();
    }

    protected boolean restoreShortTermModel(float recoveryRatio) {
        return this.mExt.restoreShortTermModel(recoveryRatio);
    }

    public boolean setBrightnessConfiguration(BrightnessConfiguration configuration, boolean shouldResetShortTermModel) {
        if (this.mBrightnessMappingStrategyMap.get(0).setBrightnessConfiguration(configuration) == true) goto L5;
        return false;
    L5:
        if (isInIdleMode() == true) goto L11;
        if (shouldResetShortTermModel == false) goto L12;
        resetShortTermModel();
        return true;
    L12:
        return true;
    L11:
        return true;
    }

    public int getMode() {
        return this.mCurrentBrightnessMapper.getMode();
    }

    public int getPreset() {
        return this.mCurrentBrightnessMapper.getPreset();
    }

    public boolean isInIdleMode() {
        if (this.mCurrentBrightnessMapper.getMode() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void dump(PrintWriter pw) {
        PrintWriter r0 = new IndentingPrintWriter(pw);
        r0.increaseIndent();
        pw.println();
        pw.println("Automatic Brightness Controller Configuration:");
        pw.println("----------------------------------------------");
        r0.println("mState=" + configStateToString(this.mState));
        r0.println("mScreenBrightnessRangeMinimum=" + this.mScreenBrightnessRangeMinimum);
        r0.println("mScreenBrightnessRangeMaximum=" + this.mScreenBrightnessRangeMaximum);
        r0.println("mDozeScaleFactor=" + this.mDozeScaleFactor);
        r0.println("mInitialLightSensorRate=" + this.mInitialLightSensorRate);
        r0.println("mNormalLightSensorRate=" + this.mNormalLightSensorRate);
        r0.println("mLightSensorWarmUpTimeConfig=" + this.mLightSensorWarmUpTimeConfig);
        r0.println("mBrighteningLightDebounceConfig=" + this.mBrighteningLightDebounceConfig);
        r0.println("mDarkeningLightDebounceConfig=" + this.mDarkeningLightDebounceConfig);
        r0.println("mBrighteningLightDebounceConfigIdle=" + this.mBrighteningLightDebounceConfigIdle);
        r0.println("mDarkeningLightDebounceConfigIdle=" + this.mDarkeningLightDebounceConfigIdle);
        r0.println("mResetAmbientLuxAfterWarmUpConfig=" + this.mResetAmbientLuxAfterWarmUpConfig);
        r0.println("mAmbientLightHorizonLong=" + this.mAmbientLightHorizonLong);
        r0.println("mAmbientLightHorizonShort=" + this.mAmbientLightHorizonShort);
        r0.println("mWeightingIntercept=" + this.mWeightingIntercept);
        pw.println();
        pw.println("Automatic Brightness Controller State:");
        pw.println("--------------------------------------");
        r0.println("mLightSensor=" + this.mLightSensor);
        r0.println("mLightSensorEnabled=" + this.mLightSensorEnabled);
        r0.println("mLightSensorEnableTime=" + TimeUtils.formatUptime(this.mLightSensorEnableTime));
        r0.println("mCurrentLightSensorRate=" + this.mCurrentLightSensorRate);
        r0.println("mAmbientLux=" + this.mAmbientLux);
        r0.println("mAmbientLuxValid=" + this.mAmbientLuxValid);
        r0.println("mPreThresholdLux=" + this.mPreThresholdLux);
        r0.println("mPreThresholdBrightness=" + this.mPreThresholdBrightness);
        r0.println("mAmbientBrighteningThreshold=" + this.mAmbientBrighteningThreshold);
        r0.println("mAmbientDarkeningThreshold=" + this.mAmbientDarkeningThreshold);
        r0.println("mScreenBrighteningThreshold=" + this.mScreenBrighteningThreshold);
        r0.println("mScreenDarkeningThreshold=" + this.mScreenDarkeningThreshold);
        r0.println("mLastObservedLux=" + this.mLastObservedLux);
        r0.println("mLastObservedLuxTime=" + TimeUtils.formatUptime(this.mLastObservedLuxTime));
        r0.println("mRecentLightSamples=" + this.mRecentLightSamples);
        r0.println("mAmbientLightRingBuffer=" + this.mAmbientLightRingBuffer);
        r0.println("mScreenAutoBrightness=" + this.mScreenAutoBrightness);
        r0.println("mDisplayPolicy=" + DisplayManagerInternal.DisplayPowerRequest.policyToString(this.mDisplayPolicy));
        r0.println("mShortTermModel=");
        this.mShortTermModel.dump(r0);
        r0.println("mPausedShortTermModel=");
        this.mPausedShortTermModel.dump(r0);
        r0.println();
        r0.println("mBrightnessAdjustmentSamplePending=" + this.mBrightnessAdjustmentSamplePending);
        r0.println("mBrightnessAdjustmentSampleOldLux=" + this.mBrightnessAdjustmentSampleOldLux);
        r0.println("mBrightnessAdjustmentSampleOldBrightness=" + this.mBrightnessAdjustmentSampleOldBrightness);
        r0.println("mForegroundAppPackageName=" + this.mForegroundAppPackageName);
        r0.println("mPendingForegroundAppPackageName=" + this.mPendingForegroundAppPackageName);
        r0.println("mForegroundAppCategory=" + this.mForegroundAppCategory);
        r0.println("mPendingForegroundAppCategory=" + this.mPendingForegroundAppCategory);
        r0.println("Current mode=" + DisplayBrightnessMappingConfig.autoBrightnessModeToString(this.mCurrentBrightnessMapper.getMode()));
        int i = 0;
    L4:
        if (i >= this.mBrightnessMappingStrategyMap.size()) goto L6;
        r0.println();
        r0.println("Mapper for mode " + DisplayBrightnessMappingConfig.autoBrightnessModeToString(this.mBrightnessMappingStrategyMap.keyAt(i)) + ":");
        this.mBrightnessMappingStrategyMap.valueAt(i).dump(r0, this.mBrightnessRangeController.getNormalBrightnessMax());
        i = i + 1;
        goto L4
    L6:
        r0.println();
        r0.println("mAmbientBrightnessThresholds=" + this.mAmbientBrightnessThresholds);
        r0.println("mAmbientBrightnessThresholdsIdle=" + this.mAmbientBrightnessThresholdsIdle);
        r0.println("mScreenBrightnessThresholds=" + this.mScreenBrightnessThresholds);
        r0.println("mScreenBrightnessThresholdsIdle=" + this.mScreenBrightnessThresholdsIdle);
        this.mExt.dump(pw);
    }

    public float[] getLastSensorValues() {
        return this.mAmbientLightRingBuffer.getAllLuxValues();
    }

    public long[] getLastSensorTimestamps() {
        return this.mAmbientLightRingBuffer.getAllTimestamps();
    }

    private String configStateToString(int state) {
        switch(state) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "AUTO_BRIGHTNESS_OFF_DUE_TO_DISPLAY_STATE";
    L7:
        return "AUTO_BRIGHTNESS_DISABLED";
    L9:
        return "AUTO_BRIGHTNESS_ENABLED";
    L4:
        return String.valueOf(state);
    }

    private boolean setLightSensorEnabled(boolean enable) {
        if (enable == false) goto L9;
        if (this.mLightSensorEnabled == true) goto L14;
        this.mLightSensorEnabled = true;
        this.mLightSensorEnableTime = this.mClock.uptimeMillis();
        this.mCurrentLightSensorRate = this.mInitialLightSensorRate;
        registerForegroundAppUpdater();
        this.mSensorManager.registerListener(this.mLightSensorListener, this.mLightSensor, this.mCurrentLightSensorRate * 1000, this.mHandler);
        return true;
    L14:
        return false;
    L9:
        if (this.mLightSensorEnabled == false) goto L14;
        this.mLightSensorEnabled = false;
        this.mAmbientLuxValid = !this.mResetAmbientLuxAfterWarmUpConfig;
        if (this.mAmbientLuxValid == true) goto L13;
        this.mPreThresholdLux = Float.NaN;
    L13:
        this.mScreenAutoBrightness = Float.NaN;
        this.mRawScreenAutoBrightness = Float.NaN;
        this.mPreThresholdBrightness = Float.NaN;
        this.mRecentLightSamples = 0;
        this.mAmbientLightRingBuffer.clear();
        this.mCurrentLightSensorRate = -1;
        this.mHandler.removeMessages(1);
        unregisterForegroundAppUpdater();
        this.mSensorManager.unregisterListener(this.mLightSensorListener);
        goto L14
    }

    private void handleLightSensorEvent(long time, float lux) {
        Trace.traceCounter(131072, "ALS", (int) lux);
        this.mHandler.removeMessages(1);
        if (this.mAmbientLightRingBuffer.size() != 0) goto L5;
        adjustLightSensorRate(this.mNormalLightSensorRate);
    L5:
        applyLightSensorMeasurement(time, lux);
        updateAmbientLux(time);
    }

    private void applyLightSensorMeasurement(long time, float lux) {
        this.mRecentLightSamples++;
        this.mAmbientLightRingBuffer.prune(time - ((long) this.mAmbientLightHorizonLong));
        this.mAmbientLightRingBuffer.push(time, lux);
        this.mLastObservedLux = lux;
        this.mLastObservedLuxTime = time;
    }

    private void adjustLightSensorRate(int lightSensorRate) {
        if (lightSensorRate != this.mCurrentLightSensorRate) goto L5;
        return;
    L5:
        if (this.mLoggingEnabled == false) goto L7;
        Slog.d(TAG, "adjustLightSensorRate: previousRate=" + this.mCurrentLightSensorRate + ", currentRate=" + lightSensorRate);
    L7:
        this.mCurrentLightSensorRate = lightSensorRate;
        this.mSensorManager.unregisterListener(this.mLightSensorListener);
        this.mSensorManager.registerListener(this.mLightSensorListener, this.mLightSensor, lightSensorRate * 1000, this.mHandler);
    }

    private boolean setAutoBrightnessAdjustment(float adjustment) {
        return this.mCurrentBrightnessMapper.setAutoBrightnessAdjustment(adjustment);
    }

    protected void setAmbientLux(float lux) {
        if (this.mLoggingEnabled == false) goto L6;
        Slog.d(TAG, "setAmbientLux(" + lux + ")");
    L6:
        if (lux >= 0.0f) goto L8;
        Slog.w(TAG, "Ambient lux was negative, ignoring and setting to 0");
        lux = 0.0f;
    L8:
        this.mAmbientLux = lux;
        if (isInIdleMode() == false) goto L11;
        this.mAmbientBrighteningThreshold = this.mAmbientBrightnessThresholdsIdle.getBrighteningThreshold(lux);
        this.mAmbientDarkeningThreshold = this.mAmbientBrightnessThresholdsIdle.getDarkeningThreshold(lux);
    L12:
        this.mBrightnessRangeController.onAmbientLuxChange(this.mAmbientLux);
        ShortTermModel.m3578$$Nest$mmaybeReset(this.mShortTermModel, this.mAmbientLux);
        return;
    L11:
        this.mAmbientBrighteningThreshold = this.mAmbientBrightnessThresholds.getBrighteningThreshold(lux);
        this.mAmbientDarkeningThreshold = this.mAmbientBrightnessThresholds.getDarkeningThreshold(lux);
        goto L12
    }

    private float calculateAmbientLux(long now, long horizon) {
        if (this.mLoggingEnabled == false) goto L5;
        Slog.d(TAG, "calculateAmbientLux(" + now + ", " + horizon + ")");
    L5:
        int N = this.mAmbientLightRingBuffer.size();
        if (N != 0) goto L9;
        Slog.e(TAG, "calculateAmbientLux: No ambient light readings available");
        return -1.0f;
    L9:
        int endIndex = 0;
        long horizonStartTime = now - horizon;
        int i = 0;
    L11:
        if (i >= (N - 1)) goto L16;
        if (this.mAmbientLightRingBuffer.getTime(i + 1) > horizonStartTime) goto L16;
        endIndex = endIndex + 1;
        i = i + 1;
    L16:
        if (this.mLoggingEnabled == false) goto L18;
        Slog.d(TAG, "calculateAmbientLux: selected endIndex=" + endIndex + ", point=(" + this.mAmbientLightRingBuffer.getTime(endIndex) + ", " + this.mAmbientLightRingBuffer.getLux(endIndex) + ")");
    L18:
        float sum = 0.0f;
        float totalWeight = 0.0f;
        long endTime = AMBIENT_LIGHT_PREDICTION_TIME_MILLIS;
        int i2 = N - 1;
    L19:
        if (i2 < endIndex) goto L30;
        long eventTime = this.mAmbientLightRingBuffer.getTime(i2);
        if (i2 == endIndex) goto L23;
    L25:
        long eventTime2 = eventTime - now;
        float weight = calculateWeight(eventTime2, endTime);
        float lux = this.mAmbientLightRingBuffer.getLux(i2);
        int N2 = N;
        if (this.mLoggingEnabled == false) goto L29;
        Slog.d(TAG, "calculateAmbientLux: [" + eventTime2 + ", " + endTime + "]: lux=" + lux + ", weight=" + weight);
    L29:
        totalWeight = totalWeight + weight;
        sum = sum + (lux * weight);
        endTime = eventTime2;
        i2 = i2 - 1;
        N = N2;
        goto L19
    L23:
        if (eventTime >= horizonStartTime) goto L25;
        eventTime = horizonStartTime;
        goto L25
    L30:
        float sum2 = sum;
        if (this.mLoggingEnabled == false) goto L34;
        Slog.d(TAG, "calculateAmbientLux: totalWeight=" + totalWeight + ", newAmbientLux=" + (sum2 / totalWeight));
    L34:
        return sum2 / totalWeight;
    }

    private float calculateWeight(long startDelta, long endDelta) {
        return weightIntegral(endDelta) - weightIntegral(startDelta);
    }

    private float weightIntegral(long x) {
        return x * ((x * 0.5f) + this.mWeightingIntercept);
    }

    private long nextAmbientLightBrighteningTransition(long time) {
        int N = this.mAmbientLightRingBuffer.size();
        long earliestValidTime = time;
        int i = N - 1;
    L3:
        if (i < 0) goto L9;
        if (this.mAmbientLightRingBuffer.getLux(i) <= this.mAmbientBrighteningThreshold) goto L9;
        earliestValidTime = this.mAmbientLightRingBuffer.getTime(i);
        i = i - 1;
    L9:
        if (isInIdleMode() == false) goto L11;
        long r3 = this.mBrighteningLightDebounceConfigIdle;
    L13:
        return r3 + earliestValidTime;
    L11:
        r3 = this.mBrighteningLightDebounceConfig;
        goto L13
    }

    private long nextAmbientLightDarkeningTransition(long time) {
        int N = this.mAmbientLightRingBuffer.size();
        long earliestValidTime = time;
        int i = N - 1;
    L3:
        if (i < 0) goto L9;
        if (this.mAmbientLightRingBuffer.getLux(i) >= this.mAmbientDarkeningThreshold) goto L9;
        earliestValidTime = this.mAmbientLightRingBuffer.getTime(i);
        i = i - 1;
    L9:
        if (isInIdleMode() == false) goto L11;
        long r3 = this.mDarkeningLightDebounceConfigIdle;
    L13:
        return r3 + earliestValidTime;
    L11:
        r3 = this.mDarkeningLightDebounceConfig;
        goto L13
    }

    private void updateAmbientLux() {
        long time = this.mClock.getSensorEventScaleTime();
        this.mAmbientLightRingBuffer.prune(time - ((long) this.mAmbientLightHorizonLong));
        updateAmbientLux(time);
    }

    private void updateAmbientLux(long time) {
        if (this.mAmbientLuxValid == true) goto L15;
        long timeWhenSensorWarmedUp = ((long) this.mLightSensorWarmUpTimeConfig) + this.mLightSensorEnableTime;
        if (time < timeWhenSensorWarmedUp) goto L7;
        setAmbientLux(calculateAmbientLux(time, this.mAmbientLightHorizonShort));
        this.mAmbientLuxValid = true;
        if (this.mLoggingEnabled == false) goto L14;
        Slog.d(TAG, "updateAmbientLux: Initializing: mAmbientLightRingBuffer=" + this.mAmbientLightRingBuffer + ", mAmbientLux=" + this.mAmbientLux);
    L14:
        updateAutoBrightness(true, false);
        goto L15
    L7:
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(TAG, "updateAmbientLux: Sensor not ready yet: time=" + time + ", timeWhenSensorWarmedUp=" + timeWhenSensorWarmedUp);
    L9:
        this.mHandler.sendEmptyMessageAtTime(1, timeWhenSensorWarmedUp);
        return;
    L15:
        long nextBrightenTransition = nextAmbientLightBrighteningTransition(time);
        long nextDarkenTransition = nextAmbientLightDarkeningTransition(time);
        this.mSlowAmbientLux = calculateAmbientLux(time, this.mAmbientLightHorizonLong);
        this.mFastAmbientLux = calculateAmbientLux(time, this.mAmbientLightHorizonShort);
        if (this.mSlowAmbientLux < this.mAmbientBrighteningThreshold) goto L22;
        if (this.mFastAmbientLux < this.mAmbientBrighteningThreshold) goto L22;
        if (nextBrightenTransition > time) goto L22;
    L27:
        this.mPreThresholdLux = this.mAmbientLux;
        setAmbientLux(this.mFastAmbientLux);
        if (this.mLoggingEnabled == false) goto L34;
        StringBuilder r0 = new StringBuilder();
        r0.append("updateAmbientLux: ");
        if (this.mFastAmbientLux <= this.mPreThresholdLux) goto L32;
        String r9 = "Brightened";
    L33:
        r0.append(r9);
        r0.append(": mAmbientBrighteningThreshold=");
        r0.append(this.mAmbientBrighteningThreshold);
        r0.append(", mAmbientDarkeningThreshold=");
        r0.append(this.mAmbientDarkeningThreshold);
        r0.append(", mAmbientLightRingBuffer=");
        r0.append(this.mAmbientLightRingBuffer);
        r0.append(", mAmbientLux=");
        r0.append(this.mAmbientLux);
        Slog.d(TAG, r0.toString());
        goto L34
    L32:
        r9 = "Darkened";
    L34:
        updateAutoBrightness(true, false);
        nextBrightenTransition = nextAmbientLightBrighteningTransition(time);
        nextDarkenTransition = nextAmbientLightDarkeningTransition(time);
    L35:
        long nextTransitionTime = Math.min(nextDarkenTransition, nextBrightenTransition);
        if (nextTransitionTime <= time) goto L38;
        long nextTransitionTime2 = nextTransitionTime;
    L40:
        if (this.mLoggingEnabled == false) goto L42;
        Slog.d(TAG, "updateAmbientLux: Scheduling ambient lux update for " + nextTransitionTime2 + TimeUtils.formatUptime(nextTransitionTime2));
    L42:
        this.mHandler.sendEmptyMessageAtTime(1, convertToUptime(nextTransitionTime2));
        return;
    L38:
        nextTransitionTime2 = ((long) this.mNormalLightSensorRate) + time;
    L22:
        if (this.mSlowAmbientLux > this.mAmbientDarkeningThreshold) goto L35;
        if (this.mFastAmbientLux > this.mAmbientDarkeningThreshold) goto L35;
        if (nextDarkenTransition > time) goto L35;
        goto L27
    }

    private long convertToUptime(long time) {
        return (time - this.mClock.getSensorEventScaleTime()) + this.mClock.uptimeMillis();
    }

    protected void updateAutoBrightness(boolean sendUpdate, boolean isManuallySet) {
        if (this.mAmbientLuxValid == true) goto L5;
        return;
    L5:
        float value = this.mCurrentBrightnessMapper.getBrightness(this.mAmbientLux, this.mForegroundAppPackageName, this.mForegroundAppCategory);
        this.mRawScreenAutoBrightness = value;
        float newScreenAutoBrightness = clampScreenBrightness(value);
        BrightnessSynchronizer.floatEquals(this.mScreenAutoBrightness, clampScreenBrightness(this.mScreenAutoBrightness));
        if (Float.isNaN(this.mScreenAutoBrightness) == false) goto L8;
    L12:
        boolean r1 = false;
    L13:
        boolean withinThreshold = r1;
        float oldScreenAutoBrightness = this.mScreenAutoBrightness;
        Slog.d(TAG, "updateAutoBrightness: " + this.mScreenAutoBrightness + "->" + newScreenAutoBrightness + " lux=" + this.mAmbientLux + " user=" + hasUserDataPoints());
        if (BrightnessSynchronizer.floatEquals(this.mScreenAutoBrightness, newScreenAutoBrightness) == true) goto L24;
        if (this.mLoggingEnabled == false) goto L18;
        Slog.d(TAG, "updateAutoBrightness: mScreenAutoBrightness=" + this.mScreenAutoBrightness + ", newScreenAutoBrightness=" + newScreenAutoBrightness);
    L18:
        if (withinThreshold == true) goto L20;
        this.mPreThresholdBrightness = this.mScreenAutoBrightness;
    L20:
        this.mScreenAutoBrightness = newScreenAutoBrightness;
        this.mExt.updateAutoBrightness(sendUpdate, this.mAmbientLux, oldScreenAutoBrightness, newScreenAutoBrightness, isManuallySet);
        if (sendUpdate == false) goto L25;
        this.mCallbacks.updateBrightness();
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (newScreenAutoBrightness <= this.mScreenDarkeningThreshold) goto L12;
        if (newScreenAutoBrightness >= this.mScreenBrighteningThreshold) goto L12;
        r1 = true;
        goto L13
    }

    private float clampScreenBrightness(float value) {
        float minBrightness = this.mBrightnessRangeController.getCurrentBrightnessMin();
        float maxBrightness = Math.min(this.mBrightnessRangeController.getCurrentBrightnessMax(), this.mBrightnessClamperController.getMaxBrightness());
        return MathUtils.constrain(value, minBrightness, maxBrightness);
    }

    private void prepareBrightnessAdjustmentSample() {
        if (this.mBrightnessAdjustmentSamplePending == true) goto L9;
        this.mBrightnessAdjustmentSamplePending = true;
        if (this.mAmbientLuxValid == false) goto L7;
        float r0 = this.mAmbientLux;
    L8:
        this.mBrightnessAdjustmentSampleOldLux = r0;
        this.mBrightnessAdjustmentSampleOldBrightness = this.mScreenAutoBrightness;
    L10:
        this.mHandler.sendEmptyMessageDelayed(2, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    L7:
        r0 = -1.0f;
        goto L8
    L9:
        this.mHandler.removeMessages(2);
        goto L10
    }

    private void cancelBrightnessAdjustmentSample() {
        if (this.mBrightnessAdjustmentSamplePending == false) goto L6;
        this.mBrightnessAdjustmentSamplePending = false;
        this.mHandler.removeMessages(2);
        return;
    }

    private void collectBrightnessAdjustmentSample() {
        if (this.mBrightnessAdjustmentSamplePending == false) goto L15;
        this.mBrightnessAdjustmentSamplePending = false;
        if (this.mAmbientLuxValid == true) goto L7;
        return;
    L7:
        if (this.mScreenAutoBrightness >= 0.0f) goto L11;
        if (this.mScreenAutoBrightness == (-1.0f)) goto L11;
        return;
    L11:
        if (this.mLoggingEnabled == false) goto L13;
        Slog.d(TAG, "Auto-brightness adjustment changed by user: lux=" + this.mAmbientLux + ", brightness=" + this.mScreenAutoBrightness + ", ring=" + this.mAmbientLightRingBuffer);
    L13:
        EventLog.writeEvent(EventLogTags.AUTO_BRIGHTNESS_ADJ, new Object[]{Float.valueOf(this.mBrightnessAdjustmentSampleOldLux), Float.valueOf(this.mBrightnessAdjustmentSampleOldBrightness), Float.valueOf(this.mAmbientLux), Float.valueOf(this.mScreenAutoBrightness)});
        return;
    }

    private void registerForegroundAppUpdater() {
        this.mActivityTaskManager.registerTaskStackListener(this.mTaskStackListener);     // Catch: RemoteException -> L4
        updateForegroundApp();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        if (this.mLoggingEnabled == false) goto L11;
        Slog.e(TAG, "Failed to register foreground app updater: " + e);
        return;
    }

    private void unregisterForegroundAppUpdater() {
        this.mActivityTaskManager.unregisterTaskStackListener(this.mTaskStackListener);     // Catch: RemoteException -> L4
    L5:
        this.mForegroundAppPackageName = null;
        this.mForegroundAppCategory = -1;
    }

    private void updateForegroundApp() {
        if (this.mLoggingEnabled == false) goto L5;
        Slog.d(TAG, "Attempting to update foreground app");
    L5:
        this.mInjector.getBackgroundThreadHandler().post(new AnonymousClass1(this));
    }

    private void updateForegroundAppSync() {
        if (this.mLoggingEnabled == false) goto L5;
        Slog.d(TAG, "Updating foreground app: packageName=" + this.mPendingForegroundAppPackageName + ", category=" + this.mPendingForegroundAppCategory);
    L5:
        this.mForegroundAppPackageName = this.mPendingForegroundAppPackageName;
        this.mPendingForegroundAppPackageName = null;
        this.mForegroundAppCategory = this.mPendingForegroundAppCategory;
        this.mPendingForegroundAppCategory = -1;
        updateAutoBrightness(true, false);
    }

    private void switchModeAndShortTermModels(int mode) {
        ShortTermModel tempShortTermModel = new ShortTermModel(this, null);
        ShortTermModel.m3580$$Nest$mset(tempShortTermModel, this.mCurrentBrightnessMapper.getUserLux(), this.mCurrentBrightnessMapper.getUserBrightness(), true);
        this.mHandler.removeMessages(7);
        this.mHandler.sendEmptyMessageAtTime(7, this.mClock.uptimeMillis() + this.mCurrentBrightnessMapper.getShortTermModelTimeout());
        Slog.i(TAG, "mPreviousShortTermModel: " + this.mPausedShortTermModel);
        this.mCurrentBrightnessMapper = this.mBrightnessMappingStrategyMap.get(mode);
    }

    public void switchMode(int mode, boolean sendUpdate) {
        if (this.mBrightnessMappingStrategyMap.contains(mode) == true) goto L6;
        return;
    L6:
        if (this.mCurrentBrightnessMapper.getMode() != mode) goto L8;
        return;
    L8:
        Slog.i(TAG, "Switching to mode " + DisplayBrightnessMappingConfig.autoBrightnessModeToString(mode));
        if (mode != 1) goto L11;
    L14:
        switchModeAndShortTermModels(mode);
    L15:
        if (sendUpdate == false) goto L17;
        update();
        return;
    L17:
        updateAutoBrightness(false, false);
        return;
    L11:
        if (this.mCurrentBrightnessMapper.getMode() == 1) goto L14;
        resetShortTermModel();
        this.mCurrentBrightnessMapper = this.mBrightnessMappingStrategyMap.get(mode);
        goto L15
    }

    float getUserLux() {
        return this.mCurrentBrightnessMapper.getUserLux();
    }

    float getUserNits() {
        return convertToNits(this.mCurrentBrightnessMapper.getUserBrightness());
    }

    public float convertToNits(float brightness) {
        return this.mCurrentBrightnessMapper.convertToNits(brightness);
    }

    public float convertToAdjustedNits(float brightness) {
        return this.mCurrentBrightnessMapper.convertToAdjustedNits(brightness);
    }

    public float getBrightnessFromNits(float nits) {
        return this.mCurrentBrightnessMapper.getBrightnessFromNits(nits);
    }

    public void recalculateSplines(boolean applyAdjustment, float[] adjustment) {
        this.mCurrentBrightnessMapper.recalculateSplines(applyAdjustment, adjustment);
        if (applyAdjustment == false) goto L6;
        setScreenBrightnessByUser(getAutomaticScreenBrightness());
        return;
    }

    private boolean shouldApplyDozeScaleFactor() {
        if (this.mDisplayManagerFlags.isNormalBrightnessForDozeParameterEnabled(this.mContext) == false) goto L12;
        if (this.mUseNormalBrightnessForDoze == true) goto L9;
        if (this.mDisplayPolicy != 1) goto L9;
    L15:
        if (getMode() != 2) goto L19;
    L17:
        return false;
    L19:
        return true;
    L9:
        if (Display.isDozeState(this.mDisplayState) == false) goto L17;
    L12:
        if (Display.isDozeState(this.mDisplayState) == false) goto L17;
        goto L17
    }

    public IExtAutomaticBrightnessController getExt() {
        return this.mExt;
    }

    public void handleBrightnessModeChange(int mode) {
        this.mExt.handleBrightnessModeChange(mode);
    }

    public void setScreenState(int state, int reason, DisplayManagerInternal.DisplayPowerRequest request) {
        this.mExt.setScreenState(state, reason, request);
    }
}
