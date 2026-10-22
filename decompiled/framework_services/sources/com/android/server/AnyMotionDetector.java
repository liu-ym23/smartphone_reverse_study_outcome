package com.android.server;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class AnyMotionDetector {
    private static final long ACCELEROMETER_DATA_TIMEOUT_MILLIS = 3000;
    private static final boolean DEBUG = false;
    private static final long ORIENTATION_MEASUREMENT_DURATION_MILLIS = 2500;
    private static final long ORIENTATION_MEASUREMENT_INTERVAL_MILLIS = 5000;
    public static final int RESULT_MOVED = 1;
    public static final int RESULT_STATIONARY = 0;
    public static final int RESULT_UNKNOWN = -1;
    private static final int SAMPLING_INTERVAL_MILLIS = 40;
    private static final int STALE_MEASUREMENT_TIMEOUT_MILLIS = 120000;
    private static final int STATE_ACTIVE = 1;
    private static final int STATE_INACTIVE = 0;
    private static final String TAG = "AnyMotionDetector";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 30000;
    private final float THRESHOLD_ENERGY;
    private final Sensor mAccelSensor;
    private final DeviceIdleCallback mCallback;
    private Vector3 mCurrentGravityVector;
    private final Handler mHandler;
    private final SensorEventListener mListener;
    private final Object mLock;
    private boolean mMeasurementInProgress;
    private final Runnable mMeasurementTimeout;
    private boolean mMeasurementTimeoutIsActive;
    private int mNumSufficientSamples;
    private Vector3 mPreviousGravityVector;
    private final RunningSignalStats mRunningStats;
    private final SensorManager mSensorManager;
    private final Runnable mSensorRestart;
    private boolean mSensorRestartIsActive;
    private int mState;
    private final float mThresholdAngle;
    private final PowerManager.WakeLock mWakeLock;
    private final Runnable mWakelockTimeout;
    private volatile boolean mWakelockTimeoutIsActive;

    interface DeviceIdleCallback {
        void onAnyMotionResult(int r1);
    }

    private static class RunningSignalStats {
        Vector3 currentVector;
        float energy;
        Vector3 previousVector;
        Vector3 runningSum;
        int sampleCount;

        public RunningSignalStats() {
            reset();
        }

        public void reset() {
            this.previousVector = null;
            this.currentVector = null;
            this.runningSum = new Vector3(0, 0.0f, 0.0f, 0.0f);
            this.energy = 0.0f;
            this.sampleCount = 0;
        }

        public void accumulate(Vector3 v) {
            if (v != null) goto L4;
            return;
        L4:
            this.sampleCount++;
            this.runningSum = this.runningSum.plus(v);
            this.previousVector = this.currentVector;
            this.currentVector = v;
            if (this.previousVector == null) goto L8;
            Vector3 dv = this.currentVector.minus(this.previousVector);
            float incrementalEnergy = ((dv.x * dv.x) + (dv.y * dv.y)) + (dv.z * dv.z);
            this.energy += incrementalEnergy;
            return;
        }

        public Vector3 getRunningAverage() {
            if (this.sampleCount > 0) goto L5;
            return null;
        L5:
            return this.runningSum.times(1.0f / this.sampleCount);
        }

        public float getEnergy() {
            return this.energy;
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public String toString() {
            String previousVectorString = "null";
            if (this.currentVector != null) goto L5;
            String currentVectorString = "null";
        L7:
            if (this.previousVector == null) goto L10;
            previousVectorString = this.previousVector.toString();
        L10:
            String msg = "previousVector = " + previousVectorString;
            return ((msg + ", currentVector = " + currentVectorString) + ", sampleCount = " + this.sampleCount) + ", energy = " + this.energy;
        L5:
            currentVectorString = this.currentVector.toString();
            goto L7
        }
    }

    public static final class Vector3 {
        public long timeMillisSinceBoot;
        public float x;
        public float y;
        public float z;

        public Vector3(long timeMillisSinceBoot, float x, float y, float z) {
            this.timeMillisSinceBoot = timeMillisSinceBoot;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public float norm() {
            return (float) Math.sqrt(dotProduct(this));
        }

        public Vector3 normalized() {
            float mag = norm();
            return new Vector3(this.timeMillisSinceBoot, this.x / mag, this.y / mag, this.z / mag);
        }

        public float angleBetween(Vector3 other) {
            Vector3 crossVector = cross(other);
            float degrees = Math.abs((float) Math.toDegrees(Math.atan2(crossVector.norm(), dotProduct(other))));
            Slog.d(AnyMotionDetector.TAG, "angleBetween: this = " + toString() + ", other = " + other.toString() + ", degrees = " + degrees);
            return degrees;
        }

        public Vector3 cross(Vector3 v) {
            return new Vector3(v.timeMillisSinceBoot, (this.y * v.z) - (this.z * v.y), (this.z * v.x) - (this.x * v.z), (this.x * v.y) - (this.y * v.x));
        }

        public String toString() {
            String msg = "timeMillisSinceBoot=" + this.timeMillisSinceBoot;
            return ((msg + " | x=" + this.x) + ", y=" + this.y) + ", z=" + this.z;
        }

        public float dotProduct(Vector3 v) {
            return ((this.x * v.x) + (this.y * v.y)) + (this.z * v.z);
        }

        public Vector3 times(float val) {
            return new Vector3(this.timeMillisSinceBoot, this.x * val, this.y * val, this.z * val);
        }

        public Vector3 plus(Vector3 v) {
            return new Vector3(v.timeMillisSinceBoot, this.x + v.x, this.y + v.y, this.z + v.z);
        }

        public Vector3 minus(Vector3 v) {
            return new Vector3(v.timeMillisSinceBoot, this.x - v.x, this.y - v.y, this.z - v.z);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceIdleCallback m49$$Nest$fgetmCallback(AnyMotionDetector r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m50$$Nest$fgetmHandler(AnyMotionDetector r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m51$$Nest$fgetmLock(AnyMotionDetector r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMeasurementTimeoutIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m52$$Nest$fgetmMeasurementTimeoutIsActive(AnyMotionDetector r0) {
        return r0.mMeasurementTimeoutIsActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumSufficientSamples, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m53$$Nest$fgetmNumSufficientSamples(AnyMotionDetector r0) {
        return r0.mNumSufficientSamples;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunningStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ RunningSignalStats m54$$Nest$fgetmRunningStats(AnyMotionDetector r0) {
        return r0.mRunningStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorRestartIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m55$$Nest$fgetmSensorRestartIsActive(AnyMotionDetector r0) {
        return r0.mSensorRestartIsActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakelockTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m56$$Nest$fgetmWakelockTimeout(AnyMotionDetector r0) {
        return r0.mWakelockTimeout;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakelockTimeoutIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m57$$Nest$fgetmWakelockTimeoutIsActive(AnyMotionDetector r0) {
        return r0.mWakelockTimeoutIsActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMeasurementTimeoutIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m58$$Nest$fputmMeasurementTimeoutIsActive(AnyMotionDetector r0, boolean r1) {
        r0.mMeasurementTimeoutIsActive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSensorRestartIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m59$$Nest$fputmSensorRestartIsActive(AnyMotionDetector r0, boolean r1) {
        r0.mSensorRestartIsActive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWakelockTimeoutIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m60$$Nest$fputmWakelockTimeoutIsActive(AnyMotionDetector r0, boolean r1) {
        r0.mWakelockTimeoutIsActive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mstartOrientationMeasurementLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m61$$Nest$mstartOrientationMeasurementLocked(AnyMotionDetector r0) {
        r0.startOrientationMeasurementLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopOrientationMeasurementLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m62$$Nest$mstopOrientationMeasurementLocked(AnyMotionDetector r0) {
        return r0.stopOrientationMeasurementLocked();
    }

    public AnyMotionDetector(PowerManager pm, Handler handler, SensorManager sm, DeviceIdleCallback callback, float thresholdAngle) {
        this.THRESHOLD_ENERGY = 5.0f;
        this.mLock = new Object();
        this.mCurrentGravityVector = null;
        this.mPreviousGravityVector = null;
        this.mListener = new AnonymousClass1(this);
        this.mSensorRestart = new AnonymousClass2(this);
        this.mMeasurementTimeout = new AnonymousClass3(this);
        this.mWakelockTimeout = new AnonymousClass4(this);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mWakeLock = pm.newWakeLock(1, TAG);     // Catch: Throwable -> L7
        this.mWakeLock.setReferenceCounted(false);     // Catch: Throwable -> L7
        this.mHandler = handler;     // Catch: Throwable -> L7
        this.mSensorManager = sm;     // Catch: Throwable -> L7
        this.mAccelSensor = this.mSensorManager.getDefaultSensor(1);     // Catch: Throwable -> L7
        this.mMeasurementInProgress = false;     // Catch: Throwable -> L7
        this.mMeasurementTimeoutIsActive = false;     // Catch: Throwable -> L7
        this.mWakelockTimeoutIsActive = false;     // Catch: Throwable -> L7
        this.mSensorRestartIsActive = false;     // Catch: Throwable -> L7
        this.mState = 0;     // Catch: Throwable -> L7
        this.mCallback = callback;     // Catch: Throwable -> L7
        this.mThresholdAngle = thresholdAngle;     // Catch: Throwable -> L7
        this.mRunningStats = new RunningSignalStats();     // Catch: Throwable -> L7
        this.mNumSufficientSamples = (int) Math.ceil(62.5d);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasSensor() {
        if (this.mAccelSensor == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void checkForAnyMotion() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 1) goto L9;
        this.mState = 1;     // Catch: Throwable -> L7
        this.mCurrentGravityVector = null;     // Catch: Throwable -> L7
        this.mPreviousGravityVector = null;     // Catch: Throwable -> L7
        this.mWakeLock.acquire();     // Catch: Throwable -> L7
        Message wakelockTimeoutMsg = Message.obtain(this.mHandler, this.mWakelockTimeout);     // Catch: Throwable -> L7
        this.mHandler.sendMessageDelayed(wakelockTimeoutMsg, 30000);     // Catch: Throwable -> L7
        this.mWakelockTimeoutIsActive = true;     // Catch: Throwable -> L7
        startOrientationMeasurementLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void stop() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L9;
        this.mState = 0;     // Catch: Throwable -> L7
    L9:
        this.mHandler.removeCallbacks(this.mMeasurementTimeout);     // Catch: Throwable -> L7
        this.mHandler.removeCallbacks(this.mSensorRestart);     // Catch: Throwable -> L7
        this.mMeasurementTimeoutIsActive = false;     // Catch: Throwable -> L7
        this.mSensorRestartIsActive = false;     // Catch: Throwable -> L7
        if (this.mMeasurementInProgress == false) goto L12;
        this.mMeasurementInProgress = false;     // Catch: Throwable -> L7
        this.mSensorManager.unregisterListener(this.mListener);     // Catch: Throwable -> L7
    L12:
        this.mCurrentGravityVector = null;     // Catch: Throwable -> L7
        this.mPreviousGravityVector = null;     // Catch: Throwable -> L7
        if (this.mWakeLock.isHeld() == false) goto L15;
        this.mHandler.removeCallbacks(this.mWakelockTimeout);     // Catch: Throwable -> L7
        this.mWakelockTimeoutIsActive = false;     // Catch: Throwable -> L7
        this.mWakeLock.release();     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void startOrientationMeasurementLocked() {
        if (this.mMeasurementInProgress == false) goto L5;
        return;
    L5:
        if (this.mAccelSensor != null) goto L7;
        return;
    L7:
        if (this.mSensorManager.registerListener(this.mListener, this.mAccelSensor, EventLogTags.VOLUME_CHANGED) == false) goto L9;
        this.mMeasurementInProgress = true;
        this.mRunningStats.reset();
    L9:
        Message measurementTimeoutMsg = Message.obtain(this.mHandler, this.mMeasurementTimeout);
        this.mHandler.sendMessageDelayed(measurementTimeoutMsg, 3000);
        this.mMeasurementTimeoutIsActive = true;
    }

    private int stopOrientationMeasurementLocked() {
        int status = -1;
        if (this.mMeasurementInProgress == false) goto L14;
        this.mHandler.removeCallbacks(this.mMeasurementTimeout);
        this.mMeasurementTimeoutIsActive = false;
        this.mSensorManager.unregisterListener(this.mListener);
        this.mMeasurementInProgress = false;
        this.mPreviousGravityVector = this.mCurrentGravityVector;
        this.mCurrentGravityVector = this.mRunningStats.getRunningAverage();
        if (this.mRunningStats.getSampleCount() != 0) goto L7;
        Slog.w(TAG, "No accelerometer data acquired for orientation measurement.");
    L7:
        status = getStationaryStatusLocked();
        this.mRunningStats.reset();
        if (status != (-1)) goto L10;
        Message msg = Message.obtain(this.mHandler, this.mSensorRestart);
        this.mHandler.sendMessageDelayed(msg, ORIENTATION_MEASUREMENT_INTERVAL_MILLIS);
        this.mSensorRestartIsActive = true;
        goto L14
    L10:
        if (this.mWakeLock.isHeld() == false) goto L12;
        this.mHandler.removeCallbacks(this.mWakelockTimeout);
        this.mWakelockTimeoutIsActive = false;
        this.mWakeLock.release();
    L12:
        this.mState = 0;
    L14:
        return status;
    }

    private int getStationaryStatusLocked() {
        if (this.mPreviousGravityVector != null) goto L5;
    L20:
        return -1;
    L5:
        if (this.mCurrentGravityVector == null) goto L20;
        Vector3 previousGravityVectorNormalized = this.mPreviousGravityVector.normalized();
        Vector3 currentGravityVectorNormalized = this.mCurrentGravityVector.normalized();
        float angle = previousGravityVectorNormalized.angleBetween(currentGravityVectorNormalized);
        if (angle >= this.mThresholdAngle) goto L14;
        if (this.mRunningStats.getEnergy() >= 5.0f) goto L14;
        return 0;
    L14:
        if (Float.isNaN(angle) == false) goto L16;
        return 1;
    L16:
        long diffTime = this.mCurrentGravityVector.timeMillisSinceBoot - this.mPreviousGravityVector.timeMillisSinceBoot;
        if (diffTime <= 120000) goto L19;
        return -1;
    L19:
        return 1;
    }
}
