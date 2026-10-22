package com.android.server.power;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class WirelessChargerDetector {
    private static final boolean DEBUG = false;
    private static final double MAX_GRAVITY = 10.806650161743164d;
    private static final double MIN_GRAVITY = 8.806650161743164d;
    private static final int MIN_SAMPLES = 3;
    private static final double MOVEMENT_ANGLE_COS_THRESHOLD = 0.0d;
    private static final int SAMPLING_INTERVAL_MILLIS = 50;
    private static final long SETTLE_TIME_MILLIS = 800;
    private static final String TAG = "WirelessChargerDetector";
    private boolean mAtRest;
    private boolean mDetectionInProgress;
    private long mDetectionStartTime;
    private float mFirstSampleX;
    private float mFirstSampleY;
    private float mFirstSampleZ;
    private Sensor mGravitySensor;
    private final Handler mHandler;
    private float mLastSampleX;
    private float mLastSampleY;
    private float mLastSampleZ;
    private final SensorEventListener mListener;
    private final Object mLock;
    private int mMovingSamples;
    private boolean mMustUpdateRestPosition;
    private boolean mPoweredWirelessly;
    private float mRestX;
    private float mRestY;
    private float mRestZ;
    private final SensorManager mSensorManager;
    private final Runnable mSensorTimeout;
    private final SuspendBlocker mSuspendBlocker;
    private int mTotalSamples;

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7619$$Nest$fgetmLock(WirelessChargerDetector r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishDetectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7620$$Nest$mfinishDetectionLocked(WirelessChargerDetector r0) {
        r0.finishDetectionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessSampleLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7621$$Nest$mprocessSampleLocked(WirelessChargerDetector r0, float r1, float r2, float r3) {
        r0.processSampleLocked(r1, r2, r3);
    }

    static {
        MOVEMENT_ANGLE_COS_THRESHOLD = Math.cos(0.08726646259971647d);
    }

    public WirelessChargerDetector(SensorManager sensorManager, SuspendBlocker suspendBlocker, Handler handler) {
        this.mLock = new Object();
        this.mListener = new AnonymousClass1(this);
        this.mSensorTimeout = new AnonymousClass2(this);
        this.mSensorManager = sensorManager;
        this.mSuspendBlocker = suspendBlocker;
        this.mHandler = handler;
        this.mGravitySensor = sensorManager.getDefaultSensor(9);
    }

    public void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println();     // Catch: Throwable -> L7
        pw.println("Wireless Charger Detector State:");     // Catch: Throwable -> L7
        pw.println("  mGravitySensor=" + this.mGravitySensor);     // Catch: Throwable -> L7
        pw.println("  mPoweredWirelessly=" + this.mPoweredWirelessly);     // Catch: Throwable -> L7
        pw.println("  mAtRest=" + this.mAtRest);     // Catch: Throwable -> L7
        pw.println("  mRestX=" + this.mRestX + ", mRestY=" + this.mRestY + ", mRestZ=" + this.mRestZ);     // Catch: Throwable -> L7
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
        r1.append("  mDetectionInProgress=");     // Catch: Throwable -> L7
        r1.append(this.mDetectionInProgress);     // Catch: Throwable -> L7
        pw.println(r1.toString());     // Catch: Throwable -> L7
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L7
        r2.append("  mDetectionStartTime=");     // Catch: Throwable -> L7
        if (this.mDetectionStartTime != 0) goto L9;
        String r3 = "0 (never)";
    L10:
        r2.append(r3);     // Catch: Throwable -> L7
        pw.println(r2.toString());     // Catch: Throwable -> L7
        pw.println("  mMustUpdateRestPosition=" + this.mMustUpdateRestPosition);     // Catch: Throwable -> L7
        pw.println("  mTotalSamples=" + this.mTotalSamples);     // Catch: Throwable -> L7
        pw.println("  mMovingSamples=" + this.mMovingSamples);     // Catch: Throwable -> L7
        pw.println("  mFirstSampleX=" + this.mFirstSampleX + ", mFirstSampleY=" + this.mFirstSampleY + ", mFirstSampleZ=" + this.mFirstSampleZ);     // Catch: Throwable -> L7
        pw.println("  mLastSampleX=" + this.mLastSampleX + ", mLastSampleY=" + this.mLastSampleY + ", mLastSampleZ=" + this.mLastSampleZ);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        r3 = TimeUtils.formatUptime(this.mDetectionStartTime);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long wcdToken = proto.start(fieldId);
        Object r5 = this.mLock;
        monitor-enter(r5);
        proto.write(1133871366145L, this.mPoweredWirelessly);     // Catch: Throwable -> L8
        proto.write(1133871366146L, this.mAtRest);     // Catch: Throwable -> L8
        long restVectorToken = proto.start(1146756268035L);     // Catch: Throwable -> L8
        proto.write(1108101562369L, this.mRestX);     // Catch: Throwable -> L8
        proto.write(1108101562370L, this.mRestY);     // Catch: Throwable -> L8
        proto.write(1108101562371L, this.mRestZ);     // Catch: Throwable -> L8
        proto.end(restVectorToken);     // Catch: Throwable -> L8
        proto.write(1133871366148L, this.mDetectionInProgress);     // Catch: Throwable -> L8
        proto.write(1112396529669L, this.mDetectionStartTime);     // Catch: Throwable -> L8
        proto.write(1133871366150L, this.mMustUpdateRestPosition);     // Catch: Throwable -> L8
        proto.write(1120986464263L, this.mTotalSamples);     // Catch: Throwable -> L8
        proto.write(1120986464264L, this.mMovingSamples);     // Catch: Throwable -> L8
        long firstSampleVectorToken = proto.start(1146756268041L);     // Catch: Throwable -> L8
        proto.write(1108101562369L, this.mFirstSampleX);     // Catch: Throwable -> L8
        proto.write(1108101562370L, this.mFirstSampleY);     // Catch: Throwable -> L8
        proto.write(1108101562371L, this.mFirstSampleZ);     // Catch: Throwable -> L8
        proto.end(firstSampleVectorToken);     // Catch: Throwable -> L8
        long lastSampleVectorToken = proto.start(1146756268042L);     // Catch: Throwable -> L8
        proto.write(1108101562369L, this.mLastSampleX);     // Catch: Throwable -> L8
        proto.write(1108101562370L, this.mLastSampleY);     // Catch: Throwable -> L8
        proto.write(1108101562371L, this.mLastSampleZ);     // Catch: Throwable -> L8
        proto.end(lastSampleVectorToken);     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        proto.end(wcdToken);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean update(boolean isPowered, int plugType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean wasPoweredWirelessly = this.mPoweredWirelessly;     // Catch: Throwable -> L8
        boolean r3 = false;
        if (isPowered == false) goto L10;
        if (plugType != 4) goto L10;
        this.mPoweredWirelessly = true;     // Catch: Throwable -> L8
        this.mMustUpdateRestPosition = true;     // Catch: Throwable -> L8
        startDetectionLocked();     // Catch: Throwable -> L8
    L17:
        if (this.mPoweredWirelessly == false) goto L22;
        if (wasPoweredWirelessly == true) goto L22;
        if (this.mAtRest == true) goto L22;
        r3 = true;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r3;
    L10:
        this.mPoweredWirelessly = false;     // Catch: Throwable -> L8
        if (this.mAtRest == false) goto L17;
        if (plugType == 0) goto L15;
        if (plugType == 4) goto L15;
        this.mMustUpdateRestPosition = false;     // Catch: Throwable -> L8
        clearAtRestLocked();     // Catch: Throwable -> L8
    L15:
        startDetectionLocked();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void startDetectionLocked() {
        if (this.mDetectionInProgress == false) goto L5;
        return;
    L5:
        if (this.mGravitySensor != null) goto L7;
        return;
    L7:
        if (this.mSensorManager.registerListener(this.mListener, this.mGravitySensor, 50000) == false) goto L12;
        this.mSuspendBlocker.acquire();
        this.mDetectionInProgress = true;
        this.mDetectionStartTime = SystemClock.uptimeMillis();
        this.mTotalSamples = 0;
        this.mMovingSamples = 0;
        Message msg = Message.obtain(this.mHandler, this.mSensorTimeout);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg, SETTLE_TIME_MILLIS);
        return;
    }

    private void finishDetectionLocked() {
        if (this.mDetectionInProgress == false) goto L15;
        this.mSensorManager.unregisterListener(this.mListener);
        this.mHandler.removeCallbacks(this.mSensorTimeout);
        if (this.mMustUpdateRestPosition == false) goto L13;
        clearAtRestLocked();
        if (this.mTotalSamples >= 3) goto L10;
        Slog.w(TAG, "Wireless charger detector is broken.  Only received " + this.mTotalSamples + " samples from the gravity sensor but we need at least 3 and we expect to see about 16 on average.");
    L12:
        this.mMustUpdateRestPosition = false;
        goto L13
    L10:
        if (this.mMovingSamples != 0) goto L12;
        this.mAtRest = true;
        this.mRestX = this.mLastSampleX;
        this.mRestY = this.mLastSampleY;
        this.mRestZ = this.mLastSampleZ;
    L13:
        this.mDetectionInProgress = false;
        this.mSuspendBlocker.release();
        return;
    }

    private void processSampleLocked(float x, float y, float z) {
        if (this.mDetectionInProgress == false) goto L16;
        this.mLastSampleX = x;
        this.mLastSampleY = y;
        this.mLastSampleZ = z;
        this.mTotalSamples++;
        if (this.mTotalSamples != 1) goto L7;
        this.mFirstSampleX = x;
        this.mFirstSampleY = y;
        this.mFirstSampleZ = z;
        float x2 = x;
        float y2 = y;
        float z2 = z;
    L11:
        if (this.mAtRest == true) goto L13;
        return;
    L13:
        if (hasMoved(this.mRestX, this.mRestY, this.mRestZ, x2, y2, z2) == false) goto L18;
        clearAtRestLocked();
        return;
    L18:
        return;
    L7:
        x2 = x;
        y2 = y;
        z2 = z;
        if (hasMoved(this.mFirstSampleX, this.mFirstSampleY, this.mFirstSampleZ, x2, y2, z2) == false) goto L11;
        this.mMovingSamples++;
        goto L11
    }

    private void clearAtRestLocked() {
        this.mAtRest = false;
        this.mRestX = 0.0f;
        this.mRestY = 0.0f;
        this.mRestZ = 0.0f;
    }

    private static boolean hasMoved(float x1, float y1, float z1, float x2, float y2, float z2) {
        double dotProduct = ((x1 * x2) + (y1 * y2)) + (z1 * z2);
        double mag1 = Math.sqrt(((x1 * x1) + (y1 * y1)) + (z1 * z1));
        double mag2 = Math.sqrt(((x2 * x2) + (y2 * y2)) + (z2 * z2));
        if (mag1 >= MIN_GRAVITY) goto L5;
    L16:
        return true;
    L5:
        if (mag1 > MAX_GRAVITY) goto L16;
        if (mag2 < MIN_GRAVITY) goto L16;
        if (mag2 > MAX_GRAVITY) goto L16;
        if (dotProduct < ((mag1 * mag2) * MOVEMENT_ANGLE_COS_THRESHOLD)) goto L17;
        return false;
    L17:
        return true;
    }
}
