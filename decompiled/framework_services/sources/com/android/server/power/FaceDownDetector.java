package com.android.server.power;

import android.R;
import android.app.ActivityThread;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class FaceDownDetector implements SensorEventListener {
    private static final boolean DEBUG = false;
    static final float DEFAULT_ACCELERATION_THRESHOLD = 0.2f;
    private static final boolean DEFAULT_FEATURE_ENABLED = true;
    private static final long DEFAULT_INTERACTION_BACKOFF = 60000;
    static final long DEFAULT_TIME_THRESHOLD_MILLIS = 1000;
    static final float DEFAULT_Z_ACCELERATION_THRESHOLD = -9.5f;
    static final String KEY_ACCELERATION_THRESHOLD = "acceleration_threshold";
    static final String KEY_FEATURE_ENABLED = "enable_flip_to_screen_off";
    private static final String KEY_INTERACTION_BACKOFF = "face_down_interaction_backoff_millis";
    static final String KEY_TIME_THRESHOLD_MILLIS = "time_threshold_millis";
    static final String KEY_Z_ACCELERATION_THRESHOLD = "z_acceleration_threshold";
    private static final float MOVING_AVERAGE_WEIGHT = 0.5f;
    private static final int SCREEN_OFF_RESULT = 4;
    private static final String TAG = "FaceDownDetector";
    private static final int UNFLIP = 2;
    private static final int UNKNOWN = 1;
    private static final int USER_INTERACTION = 3;
    private float mAccelerationThreshold;
    private Sensor mAccelerometer;
    private boolean mActive;
    private Context mContext;
    private final ExponentialMovingAverage mCurrentXYAcceleration;
    private final ExponentialMovingAverage mCurrentZAcceleration;
    private boolean mEnabledOverride;
    private boolean mFaceDown;
    private final Handler mHandler;
    private boolean mInteractive;
    private boolean mIsEnabled;
    private long mLastFlipTime;
    private long mMillisSaved;
    private final Consumer<Boolean> mOnFlip;
    private float mPrevAcceleration;
    private long mPrevAccelerationTime;
    public long mPreviousResultTime;
    public int mPreviousResultType;
    final BroadcastReceiver mScreenReceiver;
    private SensorManager mSensorManager;
    private int mSensorMaxLatencyMicros;
    private Duration mTimeThreshold;
    private final Runnable mUserActivityRunnable;
    private long mUserInteractionBackoffMillis;
    private long mZAccelerationFaceDownTime;
    private boolean mZAccelerationIsFaceDown;
    private float mZAccelerationThreshold;
    private float mZAccelerationThresholdLenient;

    private final class ExponentialMovingAverage {
        private final float mAlpha;
        private final float mInitialAverage;
        private float mMovingAverage;

        /* JADX INFO: renamed from: -$$Nest$fgetmMovingAverage, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m7393$$Nest$fgetmMovingAverage(ExponentialMovingAverage r0) {
            return r0.mMovingAverage;
        }

        ExponentialMovingAverage(FaceDownDetector r2, float alpha) {
            this(r2, alpha, 0.0f);
        }

        ExponentialMovingAverage(FaceDownDetector r1, float alpha, float initialAverage) {
            this.mAlpha = alpha;
            this.mInitialAverage = initialAverage;
            this.mMovingAverage = initialAverage;
        }

        void updateMovingAverage(float newValue) {
            this.mMovingAverage = (this.mAlpha * (this.mMovingAverage - newValue)) + newValue;
        }

        void reset() {
            this.mMovingAverage = this.mInitialAverage;
        }
    }

    private final class ScreenStateReceiver extends BroadcastReceiver {
        final /* synthetic */ FaceDownDetector this$0;

        /* synthetic */ ScreenStateReceiver(FaceDownDetector r1, FaceDownDetectorIA r2) {
            this(r1);
        }

        private ScreenStateReceiver(FaceDownDetector r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) == false) goto L6;
            FaceDownDetector.m7391$$Nest$fputmInteractive(this.this$0, false);
            FaceDownDetector.m7392$$Nest$mupdateActiveState(this.this$0);
            return;
        L6:
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) == false) goto L10;
            FaceDownDetector.m7391$$Nest$fputmInteractive(this.this$0, true);
            FaceDownDetector.m7392$$Nest$mupdateActiveState(this.this$0);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$cTU6lLtLDCLozLdBzKs8sgyBjLY(FaceDownDetector r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$caCdnIB7OSGcXiz4jSr9FVtZVGw(FaceDownDetector r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInteractive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7391$$Nest$fputmInteractive(FaceDownDetector r0, boolean r1) {
        r0.mInteractive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateActiveState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7392$$Nest$mupdateActiveState(FaceDownDetector r0) {
        r0.updateActiveState();
    }

    public FaceDownDetector(Consumer<Boolean> onFlip) {
        this.mEnabledOverride = true;
        this.mLastFlipTime = 0;
        this.mPreviousResultType = 1;
        this.mPreviousResultTime = 0;
        this.mMillisSaved = 0;
        this.mCurrentXYAcceleration = new ExponentialMovingAverage(this, MOVING_AVERAGE_WEIGHT);
        this.mCurrentZAcceleration = new ExponentialMovingAverage(this, MOVING_AVERAGE_WEIGHT);
        this.mFaceDown = false;
        this.mInteractive = false;
        this.mActive = false;
        this.mPrevAcceleration = 0.0f;
        this.mPrevAccelerationTime = 0;
        this.mZAccelerationIsFaceDown = false;
        this.mZAccelerationFaceDownTime = 0;
        onFlip.getClass();
        this.mOnFlip = onFlip;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScreenReceiver = new ScreenStateReceiver(this, null);
        this.mUserActivityRunnable = new FaceDownDetector$$ExternalSyntheticLambda1(this);
    }

    private /* synthetic */ void lambda$new$0() {
        if (this.mFaceDown == false) goto L6;
        exitFaceDown(3, SystemClock.uptimeMillis() - this.mLastFlipTime);
        updateActiveState();
        return;
    }

    public void systemReady(Context context) {
        this.mContext = context;
        this.mSensorManager = (SensorManager) context.getSystemService(SensorManager.class);
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(1);
        readValuesFromDeviceConfig();
        DeviceConfig.addOnPropertiesChangedListener("attention_manager_service", ActivityThread.currentApplication().getMainExecutor(), new FaceDownDetector$$ExternalSyntheticLambda0(this));
        updateActiveState();
    }

    private /* synthetic */ void lambda$systemReady$1(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    private void registerScreenReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.setPriority(1000);
        context.registerReceiver(this.mScreenReceiver, intentFilter);
    }

    private void updateActiveState() {
        long currentTime = SystemClock.uptimeMillis();
        boolean shouldBeActive = true;
        if (this.mPreviousResultType == 3) goto L5;
    L7:
        boolean sawRecentInteraction = false;
    L9:
        if (this.mInteractive == true) goto L11;
    L14:
        shouldBeActive = false;
    L16:
        if (this.mActive != shouldBeActive) goto L18;
        return;
    L18:
        if (shouldBeActive == false) goto L23;
        this.mSensorManager.registerListener(this, this.mAccelerometer, 3, this.mSensorMaxLatencyMicros);
        if (this.mPreviousResultType != 4) goto L28;
        logScreenOff();
    L28:
        this.mActive = shouldBeActive;
        return;
    L23:
        if (this.mFaceDown == true) goto L25;
    L27:
        this.mSensorManager.unregisterListener(this);
        this.mFaceDown = false;
        this.mOnFlip.accept(false);
        goto L28
    L25:
        if (this.mInteractive == true) goto L27;
        this.mPreviousResultType = 4;
        this.mPreviousResultTime = currentTime;
        goto L27
    L11:
        if (this.mIsEnabled == false) goto L14;
        if (sawRecentInteraction == true) goto L14;
    L5:
        if ((currentTime - this.mPreviousResultTime) >= this.mUserInteractionBackoffMillis) goto L7;
        sawRecentInteraction = true;
        goto L9
    }

    public void dump(PrintWriter pw) {
        pw.println("FaceDownDetector:");
        pw.println("  mFaceDown=" + this.mFaceDown);
        pw.println("  mActive=" + this.mActive);
        pw.println("  mLastFlipTime=" + this.mLastFlipTime);
        pw.println("  mSensorMaxLatencyMicros=" + this.mSensorMaxLatencyMicros);
        pw.println("  mUserInteractionBackoffMillis=" + this.mUserInteractionBackoffMillis);
        pw.println("  mPreviousResultTime=" + this.mPreviousResultTime);
        pw.println("  mPreviousResultType=" + this.mPreviousResultType);
        pw.println("  mMillisSaved=" + this.mMillisSaved);
        pw.println("  mZAccelerationThreshold=" + this.mZAccelerationThreshold);
        pw.println("  mAccelerationThreshold=" + this.mAccelerationThreshold);
        pw.println("  mTimeThreshold=" + this.mTimeThreshold);
        pw.println("  mEnabledOverride=" + this.mEnabledOverride);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == 1) goto L6;
        return;
    L6:
        if (this.mActive == true) goto L8;
        return;
    L8:
        if (this.mIsEnabled == false) goto L53;
        float x = event.values[0];
        float y = event.values[1];
        this.mCurrentXYAcceleration.updateMovingAverage((x * x) + (y * y));
        this.mCurrentZAcceleration.updateMovingAverage(event.values[2]);
        long curTime = event.timestamp;
        if (Math.abs(ExponentialMovingAverage.m7393$$Nest$fgetmMovingAverage(this.mCurrentXYAcceleration) - this.mPrevAcceleration) <= this.mAccelerationThreshold) goto L14;
        this.mPrevAcceleration = ExponentialMovingAverage.m7393$$Nest$fgetmMovingAverage(this.mCurrentXYAcceleration);
        this.mPrevAccelerationTime = curTime;
    L14:
        if ((curTime - this.mPrevAccelerationTime) > this.mTimeThreshold.toNanos()) goto L16;
        boolean moving = true;
    L18:
        if (this.mFaceDown == false) goto L20;
        float zAccelerationThreshold = this.mZAccelerationThresholdLenient;
    L22:
        if (ExponentialMovingAverage.m7393$$Nest$fgetmMovingAverage(this.mCurrentZAcceleration) >= zAccelerationThreshold) goto L24;
        boolean isCurrentlyFaceDown = true;
    L25:
        if (isCurrentlyFaceDown == true) goto L27;
    L31:
        boolean isFaceDownForPeriod = false;
    L33:
        if (isCurrentlyFaceDown == true) goto L35;
    L37:
        if (isCurrentlyFaceDown == true) goto L39;
        this.mZAccelerationIsFaceDown = false;
    L39:
        if (moving == true) goto L44;
        if (isFaceDownForPeriod == false) goto L44;
        if (this.mFaceDown == true) goto L44;
        faceDownDetected();
        return;
    L44:
        if (isFaceDownForPeriod == false) goto L46;
        return;
    L46:
        if (this.mFaceDown == false) goto L52;
        unFlipDetected();
        return;
    L52:
        return;
    L35:
        if (this.mZAccelerationIsFaceDown == true) goto L37;
        this.mZAccelerationFaceDownTime = curTime;
        this.mZAccelerationIsFaceDown = true;
        goto L39
    L27:
        if (this.mZAccelerationIsFaceDown == false) goto L31;
        if ((curTime - this.mZAccelerationFaceDownTime) <= this.mTimeThreshold.toNanos()) goto L31;
        isFaceDownForPeriod = true;
        goto L33
    L24:
        isCurrentlyFaceDown = false;
        goto L25
    L20:
        zAccelerationThreshold = this.mZAccelerationThreshold;
        goto L22
    L16:
        moving = false;
        goto L18
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void faceDownDetected() {
        this.mLastFlipTime = SystemClock.uptimeMillis();
        this.mFaceDown = true;
        this.mOnFlip.accept(true);
    }

    private void unFlipDetected() {
        exitFaceDown(2, SystemClock.uptimeMillis() - this.mLastFlipTime);
    }

    public void userActivity(int event) {
        if (event == 5) goto L6;
        this.mHandler.post(this.mUserActivityRunnable);
        return;
    }

    private void exitFaceDown(int resultType, long millisSinceFlip) {
        FrameworkStatsLog.write(FrameworkStatsLog.FACE_DOWN_REPORTED, resultType, millisSinceFlip, 0, 0);
        this.mFaceDown = false;
        this.mLastFlipTime = 0;
        this.mPreviousResultType = resultType;
        this.mPreviousResultTime = SystemClock.uptimeMillis();
        this.mOnFlip.accept(false);
    }

    private void logScreenOff() {
        long currentTime = SystemClock.uptimeMillis();
        FrameworkStatsLog.write(FrameworkStatsLog.FACE_DOWN_REPORTED, 4, this.mPreviousResultTime - this.mLastFlipTime, this.mMillisSaved, currentTime - this.mPreviousResultTime);
        this.mPreviousResultType = 1;
    }

    private boolean isEnabled() {
        if (this.mEnabledOverride == true) goto L5;
    L9:
        return false;
    L5:
        if (DeviceConfig.getBoolean("attention_manager_service", KEY_FEATURE_ENABLED, true) == false) goto L9;
        if (this.mContext.getResources().getBoolean(R.bool.config_force_phone_globals_creation) == false) goto L9;
        return true;
    }

    private float getAccelerationThreshold() {
        return getFloatFlagValue(KEY_ACCELERATION_THRESHOLD, 0.2f, -2.0f, 2.0f);
    }

    private float getZAccelerationThreshold() {
        return getFloatFlagValue(KEY_Z_ACCELERATION_THRESHOLD, DEFAULT_Z_ACCELERATION_THRESHOLD, -15.0f, 0.0f);
    }

    private long getUserInteractionBackoffMillis() {
        return getLongFlagValue(KEY_INTERACTION_BACKOFF, 60000, 0, 3600000);
    }

    private int getSensorMaxLatencyMicros() {
        return this.mContext.getResources().getInteger(R.integer.config_jumpTapTimeoutMillis);
    }

    private float getFloatFlagValue(String key, float defaultValue, float min, float max) {
        float value = DeviceConfig.getFloat("attention_manager_service", key, defaultValue);
        if (value >= min) goto L5;
    L8:
        Slog.w(TAG, "Bad flag value supplied for: " + key);
        return defaultValue;
    L5:
        if (value > max) goto L8;
        return value;
    }

    private long getLongFlagValue(String key, long defaultValue, long min, long max) {
        long value = DeviceConfig.getLong("attention_manager_service", key, defaultValue);
        if (value >= min) goto L5;
    L8:
        Slog.w(TAG, "Bad flag value supplied for: " + key);
        return defaultValue;
    L5:
        if (value > max) goto L8;
        return value;
    }

    private Duration getTimeThreshold() {
        long millis = DeviceConfig.getLong("attention_manager_service", KEY_TIME_THRESHOLD_MILLIS, 1000);
        if (millis >= 0) goto L5;
    L9:
        Slog.w(TAG, "Bad flag value supplied for: time_threshold_millis");
        return Duration.ofMillis(1000);
    L5:
        if (millis > 15000) goto L9;
        return Duration.ofMillis(millis);
    }

    private void onDeviceConfigChange(Set<String> keys) {
        Iterator<String> r0 = keys.iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        String key = r0.next();
        switch(key.hashCode()) {
            case -1974380596: goto L18;
            case -1762356372: goto L15;
            case -1566292150: goto L12;
            case 941263057: goto L9;
            default: goto L20;
        };
    L20:
        byte r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L23;
            case 2: goto L23;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        Slog.i(TAG, "Ignoring change on " + key);
        goto L4
    L23:
        readValuesFromDeviceConfig();
        updateActiveState();
        return;
    L9:
        if (key.equals(KEY_Z_ACCELERATION_THRESHOLD) == false) goto L20;
        r2 = 1;
        goto L21
    L12:
        if (key.equals(KEY_FEATURE_ENABLED) == false) goto L20;
        r2 = 3;
        goto L21
    L15:
        if (key.equals(KEY_ACCELERATION_THRESHOLD) == false) goto L20;
        r2 = 0;
        goto L21
    L18:
        if (key.equals(KEY_TIME_THRESHOLD_MILLIS) == false) goto L20;
        r2 = 2;
        goto L21
    }

    private void readValuesFromDeviceConfig() {
        this.mAccelerationThreshold = getAccelerationThreshold();
        this.mZAccelerationThreshold = getZAccelerationThreshold();
        this.mZAccelerationThresholdLenient = this.mZAccelerationThreshold + 1.0f;
        this.mTimeThreshold = getTimeThreshold();
        this.mSensorMaxLatencyMicros = getSensorMaxLatencyMicros();
        this.mUserInteractionBackoffMillis = getUserInteractionBackoffMillis();
        boolean oldEnabled = this.mIsEnabled;
        this.mIsEnabled = isEnabled();
        if (oldEnabled != this.mIsEnabled) goto L5;
    L8:
        Slog.i(TAG, "readValuesFromDeviceConfig():\nmAccelerationThreshold=" + this.mAccelerationThreshold + "\nmZAccelerationThreshold=" + this.mZAccelerationThreshold + "\nmTimeThreshold=" + this.mTimeThreshold + "\nmIsEnabled=" + this.mIsEnabled);
        return;
    L5:
        if (this.mIsEnabled == true) goto L7;
        this.mContext.unregisterReceiver(this.mScreenReceiver);
        this.mInteractive = false;
        goto L8
    L7:
        registerScreenReceiver(this.mContext);
        this.mInteractive = ((PowerManager) this.mContext.getSystemService(PowerManager.class)).isInteractive();
        goto L8
    }

    public void setEnabledOverride(boolean enabled) {
        this.mEnabledOverride = enabled;
        this.mIsEnabled = isEnabled();
    }

    public void setMillisSaved(long millisSaved) {
        this.mMillisSaved = millisSaved;
    }
}
