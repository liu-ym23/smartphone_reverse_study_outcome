package com.android.server.wm;

import android.R;
import android.app.ActivityThread;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.rotationresolver.RotationResolverInternal;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.Surface;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WindowOrientationListener {
    private static final int DEFAULT_BATCH_LATENCY = 100000;
    private static final long DEFAULT_ROTATION_MEMORIZATION_TIMEOUT_MILLIS = 3000;
    private static final long DEFAULT_ROTATION_RESOLVER_TIMEOUT_MILLIS = 700;
    private static final String KEY_ROTATION_MEMORIZATION_TIMEOUT = "rotation_memorization_timeout_millis";
    private static final String KEY_ROTATION_RESOLVER_TIMEOUT = "rotation_resolver_timeout_millis";
    private static final boolean LOG = false;
    private static final String TAG = "WindowOrientationListener";
    private static final boolean USE_GRAVITY_SENSOR = false;
    private final Context mContext;
    private int mCurrentRotation;
    private final int mDefaultRotation;
    private boolean mEnabled;
    private Handler mHandler;
    private final Object mLock;
    OrientationJudge mOrientationJudge;
    private int mRate;
    RotationResolverInternal mRotationResolverService;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private String mSensorType;

    final class AccelSensorJudge extends OrientationJudge {
        private static final float ACCELERATION_TOLERANCE = 4.0f;
        private static final int ACCELEROMETER_DATA_X = 0;
        private static final int ACCELEROMETER_DATA_Y = 1;
        private static final int ACCELEROMETER_DATA_Z = 2;
        private static final int ADJACENT_ORIENTATION_ANGLE_GAP = 45;
        private static final float FILTER_TIME_CONSTANT_MS = 200.0f;
        private static final float FLAT_ANGLE = 80.0f;
        private static final long FLAT_TIME_NANOS = 1000000000;
        private static final float MAX_ACCELERATION_MAGNITUDE = 13.80665f;
        private static final long MAX_FILTER_DELTA_TIME_NANOS = 1000000000;
        private static final int MAX_TILT = 80;
        private static final float MIN_ACCELERATION_MAGNITUDE = 5.80665f;
        private static final float NEAR_ZERO_MAGNITUDE = 1.0f;
        private static final long PROPOSAL_MIN_TIME_SINCE_ACCELERATION_ENDED_NANOS = 500000000;
        private static final long PROPOSAL_MIN_TIME_SINCE_FLAT_ENDED_NANOS = 500000000;
        private static final long PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS = 300000000;
        private static final long PROPOSAL_SETTLE_TIME_NANOS = 40000000;
        private static final float RADIANS_TO_DEGREES = 57.29578f;
        private static final float SWING_AWAY_ANGLE_DELTA = 20.0f;
        private static final long SWING_TIME_NANOS = 300000000;
        private static final int TILT_HISTORY_SIZE = 200;
        private static final int TILT_OVERHEAD_ENTER = -40;
        private static final int TILT_OVERHEAD_EXIT = -15;
        private boolean mAccelerating;
        private long mAccelerationTimestampNanos;
        private boolean mFlat;
        private long mFlatTimestampNanos;
        private long mLastFilteredTimestampNanos;
        private float mLastFilteredX;
        private float mLastFilteredY;
        private float mLastFilteredZ;
        private boolean mOverhead;
        private int mPredictedRotation;
        private long mPredictedRotationTimestampNanos;
        private int mProposedRotation;
        private long mSwingTimestampNanos;
        private boolean mSwinging;
        private float[] mTiltHistory;
        private int mTiltHistoryIndex;
        private long[] mTiltHistoryTimestampNanos;
        private final int[][] mTiltToleranceConfig;
        private long mTouchEndedTimestampNanos;
        private boolean mTouched;
        final /* synthetic */ WindowOrientationListener this$0;

        public AccelSensorJudge(WindowOrientationListener this$0, Context context) {
            this.this$0 = this$0;
            super(this$0);
            this.mTiltToleranceConfig = new int[][]{new int[]{-25, 70}, new int[]{-25, 65}, new int[]{-25, 60}, new int[]{-25, 65}};
            this.mTouchEndedTimestampNanos = Long.MIN_VALUE;
            this.mTiltHistory = new float[200];
            this.mTiltHistoryTimestampNanos = new long[200];
            int[] tiltTolerance = context.getResources().getIntArray(R.array.config_callBarringMMI_for_ims);
            if (tiltTolerance.length != 8) goto L16;
            int i = 0;
        L6:
            if (i >= 4) goto L21;
            int min = tiltTolerance[i * 2];
            int max = tiltTolerance[(i * 2) + 1];
            if (min < (-90)) goto L13;
            if (min > max) goto L13;
            if (max > 90) goto L13;
            this.mTiltToleranceConfig[i][0] = min;
            this.mTiltToleranceConfig[i][1] = max;
        L14:
            i = i + 1;
        L13:
            Slog.wtf(WindowOrientationListener.TAG, "config_autoRotationTiltTolerance contains invalid range: min=" + min + ", max=" + max);
            goto L14
        L21:
            return;
        L16:
            Slog.wtf(WindowOrientationListener.TAG, "config_autoRotationTiltTolerance should have exactly 8 elements");
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public int getProposedRotationLocked() {
            return this.mProposedRotation;
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void dumpLocked(PrintWriter pw, String prefix) {
            pw.println(prefix + "AccelSensorJudge");
            String prefix2 = prefix + "  ";
            pw.println(prefix2 + "mProposedRotation=" + this.mProposedRotation);
            pw.println(prefix2 + "mPredictedRotation=" + this.mPredictedRotation);
            pw.println(prefix2 + "mLastFilteredX=" + this.mLastFilteredX);
            pw.println(prefix2 + "mLastFilteredY=" + this.mLastFilteredY);
            pw.println(prefix2 + "mLastFilteredZ=" + this.mLastFilteredZ);
            long delta = SystemClock.elapsedRealtimeNanos() - this.mLastFilteredTimestampNanos;
            pw.println(prefix2 + "mLastFilteredTimestampNanos=" + this.mLastFilteredTimestampNanos + " (" + (delta * 1.0E-6f) + "ms ago)");
            StringBuilder r2 = new StringBuilder();
            r2.append(prefix2);
            r2.append("mTiltHistory={last: ");
            r2.append(getLastTiltLocked());
            r2.append("}");
            pw.println(r2.toString());
            pw.println(prefix2 + "mFlat=" + this.mFlat);
            pw.println(prefix2 + "mSwinging=" + this.mSwinging);
            pw.println(prefix2 + "mAccelerating=" + this.mAccelerating);
            pw.println(prefix2 + "mOverhead=" + this.mOverhead);
            pw.println(prefix2 + "mTouched=" + this.mTouched);
            StringBuilder r3 = new StringBuilder();
            r3.append(prefix2);
            r3.append("mTiltToleranceConfig=[");
            pw.print(r3.toString());
            int i = 0;
        L4:
            if (i >= 4) goto L9;
            if (i == 0) goto L8;
            pw.print(", ");
        L8:
            pw.print("[");
            pw.print(this.mTiltToleranceConfig[i][0]);
            pw.print(", ");
            pw.print(this.mTiltToleranceConfig[i][1]);
            pw.print("]");
            i = i + 1;
            goto L4
        L9:
            pw.println("]");
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge, android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge, android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            Object r3 = WindowOrientationListener.m10470$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            float x = event.values[0];     // Catch: Throwable -> L7
            float y = event.values[1];     // Catch: Throwable -> L7
            float z = event.values[2];     // Catch: Throwable -> L7
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L9;
            Slog.v(WindowOrientationListener.TAG, "Raw acceleration vector: x=" + x + ", y=" + y + ", z=" + z + ", magnitude=" + Math.sqrt(((x * x) + (y * y)) + (z * z)));     // Catch: Throwable -> L7
        L9:
            long now = event.timestamp;     // Catch: Throwable -> L7
            long then = this.mLastFilteredTimestampNanos;     // Catch: Throwable -> L7
            float r13 = 1.0E-6f;
            float timeDeltaMS = (now - then) * 1.0E-6f;     // Catch: Throwable -> L7
            if (now < then) goto L27;
            if (now > (1000000000 + then)) goto L27;
            if (x == 0.0f) goto L16;
        L20:
            float alpha = timeDeltaMS / (FILTER_TIME_CONSTANT_MS + timeDeltaMS);     // Catch: Throwable -> L7
            r13 = 1.0E-6f;
            x = ((x - this.mLastFilteredX) * alpha) + this.mLastFilteredX;     // Catch: Throwable -> L7
            y = ((y - this.mLastFilteredY) * alpha) + this.mLastFilteredY;     // Catch: Throwable -> L7
            float z2 = ((z - this.mLastFilteredZ) * alpha) + this.mLastFilteredZ;     // Catch: Throwable -> L7
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L24;
            Slog.v(WindowOrientationListener.TAG, "Filtered acceleration vector: x=" + x + ", y=" + y + ", z=" + z2 + ", magnitude=" + Math.sqrt(((x * x) + (y * y)) + (z2 * z2)));     // Catch: Throwable -> L7
        L24:
            boolean skipSample = false;
            z = z2;
        L30:
            this.mLastFilteredTimestampNanos = now;     // Catch: Throwable -> L7
            this.mLastFilteredX = x;     // Catch: Throwable -> L7
            this.mLastFilteredY = y;     // Catch: Throwable -> L7
            this.mLastFilteredZ = z;     // Catch: Throwable -> L7
            boolean isAccelerating = false;
            boolean isFlat = false;
            boolean isSwinging = false;
            if (skipSample == true) goto L91;
            Object r19 = r3;
            float magnitude = (float) Math.sqrt(((x * x) + (y * y)) + (z * z));     // Catch: Throwable -> L39
            if (magnitude >= 1.0f) goto L43;
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L41;
            Slog.v(WindowOrientationListener.TAG, "Ignoring sensor data, magnitude too close to zero.");     // Catch: Throwable -> L39
        L41:
            clearPredictedRotationLocked();     // Catch: Throwable -> L39
        L92:
            this.mFlat = isFlat;     // Catch: Throwable -> L39
            this.mSwinging = isSwinging;     // Catch: Throwable -> L39
            this.mAccelerating = isAccelerating;     // Catch: Throwable -> L39
            int oldProposedRotation = this.mProposedRotation;     // Catch: Throwable -> L39
            if (this.mPredictedRotation >= 0) goto L95;
        L96:
            this.mProposedRotation = this.mPredictedRotation;     // Catch: Throwable -> L39
        L97:
            int proposedRotation = this.mProposedRotation;     // Catch: Throwable -> L39
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L101;
            Slog.v(WindowOrientationListener.TAG, "Result: currentRotation=" + WindowOrientationListener.m10467$$Nest$fgetmCurrentRotation(this.this$0) + ", proposedRotation=" + proposedRotation + ", predictedRotation=" + this.mPredictedRotation + ", timeDeltaMS=" + timeDeltaMS + ", isAccelerating=" + isAccelerating + ", isFlat=" + isFlat + ", isSwinging=" + isSwinging + ", isOverhead=" + this.mOverhead + ", isTouched=" + this.mTouched + ", timeUntilSettledMS=" + remainingMS(now, this.mPredictedRotationTimestampNanos + PROPOSAL_SETTLE_TIME_NANOS) + ", timeUntilAccelerationDelayExpiredMS=" + remainingMS(now, this.mAccelerationTimestampNanos + 500000000) + ", timeUntilFlatDelayExpiredMS=" + remainingMS(now, this.mFlatTimestampNanos + 500000000) + ", timeUntilSwingDelayExpiredMS=" + remainingMS(now, this.mSwingTimestampNanos + 300000000) + ", timeUntilTouchDelayExpiredMS=" + remainingMS(now, this.mTouchEndedTimestampNanos + 500000000));     // Catch: Throwable -> L39
        L101:
            monitor-exit(r19);     // Catch: Throwable -> L39
            if (proposedRotation == oldProposedRotation) goto L114;
            if (proposedRotation >= 0) goto L105;
            return;
        L105:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L107;
            Slog.v(WindowOrientationListener.TAG, "Proposed rotation changed!  proposedRotation=" + proposedRotation + ", oldProposedRotation=" + oldProposedRotation);
        L107:
            this.this$0.onProposedRotationChanged(proposedRotation);
            return;
        L114:
            return;
        L95:
            if (isPredictedRotationAcceptableLocked(now) == false) goto L97;
        L43:
            if (isAcceleratingLocked(magnitude) == false) goto L45;
            isAccelerating = true;
            this.mAccelerationTimestampNanos = now;     // Catch: Throwable -> L39
        L45:
            int tiltAngle = (int) Math.round(Math.asin(z / magnitude) * 57.295780181884766d);     // Catch: Throwable -> L39
            addTiltHistoryEntryLocked(now, tiltAngle);     // Catch: Throwable -> L39
            if (isFlatLocked(now) == false) goto L49;
            isFlat = true;
            this.mFlatTimestampNanos = now;     // Catch: Throwable -> L39
        L49:
            if (isSwingingLocked(now, tiltAngle) == false) goto L52;
            isSwinging = true;
            this.mSwingTimestampNanos = now;     // Catch: Throwable -> L39
        L52:
            if (tiltAngle > TILT_OVERHEAD_ENTER) goto L55;
            this.mOverhead = true;     // Catch: Throwable -> L39
        L58:
            if (this.mOverhead == true) goto L60;
            isAccelerating = isAccelerating;
            if (Math.abs(tiltAngle) > 80) goto L67;
            int orientationAngle = (int) Math.round((-Math.atan2(-x, y)) * 57.295780181884766d);     // Catch: Throwable -> L39
            if (orientationAngle >= 0) goto L73;
            orientationAngle = orientationAngle + 360;     // Catch: Throwable -> L39
        L73:
            int nearestRotation = (orientationAngle + 45) / 90;     // Catch: Throwable -> L39
            if (nearestRotation != 4) goto L77;
            nearestRotation = 0;
        L77:
            if (isTiltAngleAcceptableLocked(nearestRotation, tiltAngle) == false) goto L87;
            if (isOrientationAngleAcceptableLocked(nearestRotation, orientationAngle) == false) goto L87;
            updatePredictedRotationLocked(now, nearestRotation);     // Catch: Throwable -> L39
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L90;
            Slog.v(WindowOrientationListener.TAG, "Predicted: tiltAngle=" + tiltAngle + ", orientationAngle=" + orientationAngle + ", predictedRotation=" + this.mPredictedRotation + ", predictedRotationAgeMS=" + ((now - this.mPredictedRotationTimestampNanos) * r13));     // Catch: Throwable -> L39
        L90:
            isAccelerating = isAccelerating;
        L87:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L89;
            Slog.v(WindowOrientationListener.TAG, "Ignoring sensor data, no predicted rotation: tiltAngle=" + tiltAngle + ", orientationAngle=" + orientationAngle);     // Catch: Throwable -> L39
        L89:
            clearPredictedRotationLocked();     // Catch: Throwable -> L39
            goto L90
        L67:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L69;
            Slog.v(WindowOrientationListener.TAG, "Ignoring sensor data, tilt angle too high: tiltAngle=" + tiltAngle);     // Catch: Throwable -> L39
        L69:
            clearPredictedRotationLocked();     // Catch: Throwable -> L39
            goto L90
        L60:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L63;
            Slog.v(WindowOrientationListener.TAG, "Ignoring sensor data, device is overhead: tiltAngle=" + tiltAngle);     // Catch: Throwable -> L39
        L63:
            clearPredictedRotationLocked();     // Catch: Throwable -> L39
            goto L90
        L55:
            if (tiltAngle < (-15)) goto L58;
            this.mOverhead = false;     // Catch: Throwable -> L39
            goto L58
        L91:
            r19 = r3;
            goto L92
        L16:
            if (y != 0.0f) goto L20;
            if (z != 0.0f) goto L20;
        L27:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L29;
            Slog.v(WindowOrientationListener.TAG, "Resetting orientation listener.");     // Catch: Throwable -> L7
        L29:
            resetLocked(true);     // Catch: Throwable -> L7
            skipSample = true;
        L7:
            th = th;
        L109:
            monitor-exit(r3);     // Catch: Throwable -> L39
            throw th;
        L39:
            th = th;
            goto L109
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void onTouchStartLocked() {
            this.mTouched = true;
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void onTouchEndLocked(long whenElapsedNanos) {
            this.mTouched = false;
            this.mTouchEndedTimestampNanos = whenElapsedNanos;
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void resetLocked(boolean clearCurrentRotation) {
            this.mLastFilteredTimestampNanos = Long.MIN_VALUE;
            if (clearCurrentRotation == false) goto L5;
            this.mProposedRotation = -1;
        L5:
            this.mFlatTimestampNanos = Long.MIN_VALUE;
            this.mFlat = false;
            this.mSwingTimestampNanos = Long.MIN_VALUE;
            this.mSwinging = false;
            this.mAccelerationTimestampNanos = Long.MIN_VALUE;
            this.mAccelerating = false;
            this.mOverhead = false;
            clearPredictedRotationLocked();
            clearTiltHistoryLocked();
        }

        private boolean isTiltAngleAcceptableLocked(int rotation, int tiltAngle) {
            if (tiltAngle >= this.mTiltToleranceConfig[rotation][0]) goto L5;
            return false;
        L5:
            if (tiltAngle <= this.mTiltToleranceConfig[rotation][1]) goto L7;
            return false;
        L7:
            return true;
        }

        private boolean isOrientationAngleAcceptableLocked(int rotation, int orientationAngle) {
            int currentRotation = WindowOrientationListener.m10467$$Nest$fgetmCurrentRotation(this.this$0);
            if (currentRotation >= 0) goto L5;
            return true;
        L5:
            if (rotation != currentRotation) goto L7;
        L8:
            int lowerBound = ((rotation * 90) - 45) + 22;
            if (rotation == 0) goto L11;
            if (orientationAngle >= lowerBound) goto L17;
            return false;
        L17:
            if (rotation != currentRotation) goto L19;
        L20:
            int upperBound = ((rotation * 90) + 45) - 22;
            if (rotation != 0) goto L25;
            if (orientationAngle > 45) goto L30;
            if (orientationAngle <= upperBound) goto L31;
            return false;
        L31:
            return true;
        L30:
            return true;
        L25:
            if (orientationAngle <= upperBound) goto L32;
            return false;
        L32:
            return true;
        L19:
            if (rotation == ((currentRotation + 3) % 4)) goto L20;
            return true;
        L11:
            if (orientationAngle < 315) goto L17;
            if (orientationAngle >= (lowerBound + 360)) goto L17;
            return false;
        L7:
            if (rotation != ((currentRotation + 1) % 4)) goto L17;
            goto L8
        }

        private boolean isPredictedRotationAcceptableLocked(long now) {
            if (now >= (this.mPredictedRotationTimestampNanos + PROPOSAL_SETTLE_TIME_NANOS)) goto L6;
            return false;
        L6:
            if (now >= (this.mFlatTimestampNanos + 500000000)) goto L9;
            return false;
        L9:
            if (now >= (this.mSwingTimestampNanos + 300000000)) goto L12;
            return false;
        L12:
            if (now >= (this.mAccelerationTimestampNanos + 500000000)) goto L15;
            return false;
        L15:
            if (this.mTouched == false) goto L17;
        L21:
            return false;
        L17:
            if (now < (this.mTouchEndedTimestampNanos + 500000000)) goto L21;
            return true;
        }

        private void clearPredictedRotationLocked() {
            this.mPredictedRotation = -1;
            this.mPredictedRotationTimestampNanos = Long.MIN_VALUE;
        }

        private void updatePredictedRotationLocked(long now, int rotation) {
            if (this.mPredictedRotation == rotation) goto L6;
            this.mPredictedRotation = rotation;
            this.mPredictedRotationTimestampNanos = now;
            return;
        }

        private boolean isAcceleratingLocked(float magnitude) {
            if (magnitude >= MIN_ACCELERATION_MAGNITUDE) goto L5;
        L8:
            return true;
        L5:
            if (magnitude > MAX_ACCELERATION_MAGNITUDE) goto L8;
            return false;
        }

        private void clearTiltHistoryLocked() {
            this.mTiltHistoryTimestampNanos[0] = Long.MIN_VALUE;
            this.mTiltHistoryIndex = 1;
        }

        private void addTiltHistoryEntryLocked(long now, float tilt) {
            this.mTiltHistory[this.mTiltHistoryIndex] = tilt;
            this.mTiltHistoryTimestampNanos[this.mTiltHistoryIndex] = now;
            this.mTiltHistoryIndex = (this.mTiltHistoryIndex + 1) % 200;
            this.mTiltHistoryTimestampNanos[this.mTiltHistoryIndex] = Long.MIN_VALUE;
        }

        private boolean isFlatLocked(long now) {
            int i = this.mTiltHistoryIndex;
        L3:
            int r1 = nextTiltHistoryIndexLocked(i);
            i = r1;
            if (r1 < 0) goto L12;
            if (this.mTiltHistory[i] < FLAT_ANGLE) goto L18;
            if ((this.mTiltHistoryTimestampNanos[i] + 1000000000) > now) goto L3;
            return true;
        L18:
            return false;
        L12:
            return false;
        }

        private boolean isSwingingLocked(long now, float tilt) {
            int i = this.mTiltHistoryIndex;
        L3:
            int r1 = nextTiltHistoryIndexLocked(i);
            i = r1;
            if (r1 < 0) goto L12;
            if ((this.mTiltHistoryTimestampNanos[i] + 300000000) < now) goto L18;
            if ((this.mTiltHistory[i] + SWING_AWAY_ANGLE_DELTA) > tilt) goto L3;
            return true;
        L18:
            return false;
        L12:
            return false;
        }

        private int nextTiltHistoryIndexLocked(int index) {
            if (index != 0) goto L4;
            int r0 = 200;
        L5:
            int index2 = r0 - 1;
            if (this.mTiltHistoryTimestampNanos[index2] != Long.MIN_VALUE) goto L10;
            return -1;
        L10:
            return index2;
        L4:
            r0 = index;
            goto L5
        }

        private float getLastTiltLocked() {
            int index = nextTiltHistoryIndexLocked(this.mTiltHistoryIndex);
            if (index >= 0) goto L7;
            return Float.NaN;
        L7:
            return this.mTiltHistory[index];
        }

        private float remainingMS(long now, long until) {
            if (now < until) goto L6;
            return 0.0f;
        L6:
            return (until - now) * 1.0E-6f;
        }
    }

    abstract class OrientationJudge implements SensorEventListener {
        protected static final float MILLIS_PER_NANO = 1.0E-6f;
        protected static final long NANOS_PER_MS = 1000000;
        protected static final long PROPOSAL_MIN_TIME_SINCE_TOUCH_END_NANOS = 500000000;

        public abstract void dumpLocked(PrintWriter r1, String r2);

        public abstract int getProposedRotationLocked();

        @Override // android.hardware.SensorEventListener
        public abstract void onAccuracyChanged(Sensor r1, int r2);

        @Override // android.hardware.SensorEventListener
        public abstract void onSensorChanged(SensorEvent r1);

        public abstract void onTouchEndLocked(long r1);

        public abstract void onTouchStartLocked();

        public abstract void resetLocked(boolean r1);

        OrientationJudge(WindowOrientationListener this$0) {
        }
    }

    final class OrientationSensorJudge extends OrientationJudge {
        private static final int ROTATION_UNSET = -1;
        private final ActivityTaskManagerInternal mActivityTaskManagerInternal;
        private Runnable mCancelRotationResolverRequest;
        private int mCurrentCallbackId;
        private int mDesiredRotation;
        private int mLastRotationResolution;
        private long mLastRotationResolutionTimeStamp;
        private int mProposedRotation;
        private boolean mRotationEvaluationScheduled;
        private Runnable mRotationEvaluator;
        private long mRotationMemorizationTimeoutMillis;
        private long mRotationResolverTimeoutMillis;
        private long mTouchEndedTimestampNanos;
        private boolean mTouching;
        final /* synthetic */ WindowOrientationListener this$0;

        public static /* synthetic */ void $r8$lambda$x5Ly46j6yrgOasDDiYwlHXUgtJ8(OrientationSensorJudge r0, DeviceConfig.Properties r1) {
            r0.lambda$setupRotationResolverParameters$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCancelRotationResolverRequest, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m10472$$Nest$fgetmCancelRotationResolverRequest(OrientationSensorJudge r0) {
            return r0.mCancelRotationResolverRequest;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrentCallbackId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10473$$Nest$fgetmCurrentCallbackId(OrientationSensorJudge r0) {
            return r0.mCurrentCallbackId;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRotationEvaluationScheduled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10474$$Nest$fputmRotationEvaluationScheduled(OrientationSensorJudge r0, boolean r1) {
            r0.mRotationEvaluationScheduled = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mfinalizeRotation, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10475$$Nest$mfinalizeRotation(OrientationSensorJudge r0, int r1) {
            r0.finalizeRotation(r1);
        }

        OrientationSensorJudge(WindowOrientationListener this$0) {
            this.this$0 = this$0;
            super(this$0);
            this.mTouchEndedTimestampNanos = Long.MIN_VALUE;
            this.mProposedRotation = -1;
            this.mDesiredRotation = -1;
            this.mLastRotationResolution = -1;
            this.mCurrentCallbackId = 0;
            this.mRotationEvaluator = new AnonymousClass2(this);
            setupRotationResolverParameters();
            this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        }

        private void setupRotationResolverParameters() {
            DeviceConfig.addOnPropertiesChangedListener("window_manager", ActivityThread.currentApplication().getMainExecutor(), new WindowOrientationListener$OrientationSensorJudge$$ExternalSyntheticLambda1(this));
            readRotationResolverParameters();
        }

        private /* synthetic */ void lambda$setupRotationResolverParameters$0(DeviceConfig.Properties properties) {
            Set<String> keys = properties.getKeyset();
            if (keys.contains(WindowOrientationListener.KEY_ROTATION_RESOLVER_TIMEOUT) == false) goto L5;
        L6:
            readRotationResolverParameters();
            return;
        L5:
            if (keys.contains(WindowOrientationListener.KEY_ROTATION_MEMORIZATION_TIMEOUT) == true) goto L6;
        }

        private void readRotationResolverParameters() {
            this.mRotationResolverTimeoutMillis = DeviceConfig.getLong("window_manager", WindowOrientationListener.KEY_ROTATION_RESOLVER_TIMEOUT, WindowOrientationListener.DEFAULT_ROTATION_RESOLVER_TIMEOUT_MILLIS);
            this.mRotationMemorizationTimeoutMillis = DeviceConfig.getLong("window_manager", WindowOrientationListener.KEY_ROTATION_MEMORIZATION_TIMEOUT, 3000);
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public int getProposedRotationLocked() {
            return this.mProposedRotation;
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void onTouchStartLocked() {
            this.mTouching = true;
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void onTouchEndLocked(long whenElapsedNanos) {
            this.mTouching = false;
            this.mTouchEndedTimestampNanos = whenElapsedNanos;
            if (this.mDesiredRotation == this.mProposedRotation) goto L6;
            long now = SystemClock.elapsedRealtimeNanos();
            scheduleRotationEvaluationIfNecessaryLocked(now);
            return;
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge, android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            final int reportedRotation = (int) event.values[0];
            if (reportedRotation >= 0) goto L5;
            return;
        L5:
            if (reportedRotation > 3) goto L43;
            FrameworkStatsLog.write(FrameworkStatsLog.DEVICE_ROTATED, event.timestamp, rotationToLogEnum(reportedRotation), 2);
            if (this.this$0.isRotationResolverEnabled() == true) goto L10;
            finalizeRotation(reportedRotation);
            return;
        L10:
            if (this.this$0.isKeyguardShowingAndNotOccluded() == false) goto L19;
            if (this.mLastRotationResolution != (-1)) goto L14;
        L16:
            finalizeRotation(WindowOrientationListener.m10468$$Nest$fgetmDefaultRotation(this.this$0));
            return;
        L14:
            if ((SystemClock.uptimeMillis() - this.mLastRotationResolutionTimeStamp) >= this.mRotationMemorizationTimeoutMillis) goto L16;
            Slog.d(WindowOrientationListener.TAG, "Reusing the last rotation resolution: " + this.mLastRotationResolution);
            finalizeRotation(this.mLastRotationResolution);
            return;
        L19:
            if (this.this$0.mRotationResolverService != null) goto L25;
            this.this$0.mRotationResolverService = (RotationResolverInternal) LocalServices.getService(RotationResolverInternal.class);
            if (this.this$0.mRotationResolverService != null) goto L25;
            finalizeRotation(reportedRotation);
            return;
        L25:
            if (this.mActivityTaskManagerInternal == null) goto L33;
            WindowProcessController controller = this.mActivityTaskManagerInternal.getTopApp();
            if (controller == null) goto L33;
            if (controller.mInfo == null) goto L33;
            if (controller.mInfo.packageName == null) goto L33;
            String packageName = controller.mInfo.packageName;
            String packageName2 = packageName;
        L34:
            this.mCurrentCallbackId++;
            if (this.mCancelRotationResolverRequest == null) goto L37;
            this.this$0.getHandler().removeCallbacks(this.mCancelRotationResolverRequest);
        L37:
            final CancellationSignal cancellationSignal = new CancellationSignal();
            this.mCancelRotationResolverRequest = new WindowOrientationListener$OrientationSensorJudge$$ExternalSyntheticLambda0(cancellationSignal);
            this.this$0.getHandler().postDelayed(this.mCancelRotationResolverRequest, this.mRotationResolverTimeoutMillis);
            this.this$0.mRotationResolverService.resolveRotation(new AnonymousClass1(this, reportedRotation), packageName2, reportedRotation, WindowOrientationListener.m10467$$Nest$fgetmCurrentRotation(this.this$0), this.mRotationResolverTimeoutMillis, cancellationSignal);
            return;
        L33:
            packageName2 = null;
            goto L34
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge, android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void dumpLocked(PrintWriter pw, String prefix) {
            pw.println(prefix + "OrientationSensorJudge");
            String prefix2 = prefix + "  ";
            pw.println(prefix2 + "mDesiredRotation=" + Surface.rotationToString(this.mDesiredRotation));
            pw.println(prefix2 + "mProposedRotation=" + Surface.rotationToString(this.mProposedRotation));
            pw.println(prefix2 + "mTouching=" + this.mTouching);
            pw.println(prefix2 + "mTouchEndedTimestampNanos=" + this.mTouchEndedTimestampNanos);
            pw.println(prefix2 + "mLastRotationResolution=" + this.mLastRotationResolution);
        }

        @Override // com.android.server.wm.WindowOrientationListener.OrientationJudge
        public void resetLocked(boolean clearCurrentRotation) {
            if (clearCurrentRotation == false) goto L4;
            this.mProposedRotation = -1;
            this.mDesiredRotation = -1;
        L4:
            this.mTouching = false;
            this.mTouchEndedTimestampNanos = Long.MIN_VALUE;
            unscheduleRotationEvaluationLocked();
        }

        public int evaluateRotationChangeLocked() {
            unscheduleRotationEvaluationLocked();
            if (this.mDesiredRotation != this.mProposedRotation) goto L5;
            return -1;
        L5:
            long now = SystemClock.elapsedRealtimeNanos();
            if (isDesiredRotationAcceptableLocked(now) == false) goto L9;
            this.mProposedRotation = this.mDesiredRotation;
            return this.mProposedRotation;
        L9:
            scheduleRotationEvaluationIfNecessaryLocked(now);
            return -1;
        }

        private void finalizeRotation(int reportedRotation) {
            Object r0 = WindowOrientationListener.m10470$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mDesiredRotation = reportedRotation;     // Catch: Throwable -> L9
            int newRotation = evaluateRotationChangeLocked();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (newRotation < 0) goto L14;
            this.mLastRotationResolution = newRotation;
            this.mLastRotationResolutionTimeStamp = SystemClock.uptimeMillis();
            this.this$0.onProposedRotationChanged(newRotation);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private boolean isDesiredRotationAcceptableLocked(long now) {
            if (this.mTouching == false) goto L6;
            return false;
        L6:
            if (now >= (this.mTouchEndedTimestampNanos + 500000000)) goto L8;
            return false;
        L8:
            return true;
        }

        private void scheduleRotationEvaluationIfNecessaryLocked(long now) {
            if (this.mRotationEvaluationScheduled == true) goto L22;
            if (this.mDesiredRotation == this.mProposedRotation) goto L22;
            if (this.mTouching == true) goto L10;
            long timeOfNextPossibleRotationNanos = this.mTouchEndedTimestampNanos + 500000000;
            if (now >= timeOfNextPossibleRotationNanos) goto L16;
            long delayMs = (long) Math.ceil((timeOfNextPossibleRotationNanos - now) * 1.0E-6f);
            WindowOrientationListener.m10469$$Nest$fgetmHandler(this.this$0).postDelayed(this.mRotationEvaluator, delayMs);
            this.mRotationEvaluationScheduled = true;
            return;
        L16:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L26;
            Slog.d(WindowOrientationListener.TAG, "scheduleRotationEvaluationLocked: ignoring, already past the next possible time of rotation.");
            return;
        L26:
            return;
        L10:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L25;
            Slog.d(WindowOrientationListener.TAG, "scheduleRotationEvaluationLocked: ignoring, user is still touching the screen.");
            return;
        L25:
            return;
        L22:
            if (WindowOrientationListener.m10471$$Nest$sfgetLOG() == false) goto L27;
            Slog.d(WindowOrientationListener.TAG, "scheduleRotationEvaluationLocked: ignoring, an evaluation is already scheduled or is unnecessary.");
            return;
        }

        private void unscheduleRotationEvaluationLocked() {
            if (this.mRotationEvaluationScheduled == true) goto L5;
            return;
        L5:
            WindowOrientationListener.m10469$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mRotationEvaluator);
            this.mRotationEvaluationScheduled = false;
        }

        private int rotationToLogEnum(int rotation) {
            switch(rotation) {
                case 0: goto L11;
                case 1: goto L9;
                case 2: goto L7;
                case 3: goto L5;
                default: goto L3;
            };
        L3:
            return 0;
        L5:
            return 4;
        L7:
            return 3;
        L9:
            return 2;
        L11:
            return 1;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10467$$Nest$fgetmCurrentRotation(WindowOrientationListener r0) {
        return r0.mCurrentRotation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10468$$Nest$fgetmDefaultRotation(WindowOrientationListener r0) {
        return r0.mDefaultRotation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10469$$Nest$fgetmHandler(WindowOrientationListener r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10470$$Nest$fgetmLock(WindowOrientationListener r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10471$$Nest$sfgetLOG() {
        return LOG;
    }

    public abstract boolean isKeyguardShowingAndNotOccluded();

    abstract boolean isRotationResolverEnabled();

    public abstract void onProposedRotationChanged(int r1);

    static {
        LOG = SystemProperties.getBoolean("debug.orientation.log", false);
    }

    public WindowOrientationListener(Context context, Handler handler, int defaultRotation) {
        this(context, handler, defaultRotation, 2);
    }

    private WindowOrientationListener(Context context, Handler handler, int defaultRotation, int rate) {
        this.mCurrentRotation = -1;
        this.mLock = new Object();
        this.mContext = context;
        this.mHandler = handler;
        this.mDefaultRotation = defaultRotation;
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.mRate = rate;
        List<Sensor> l = this.mSensorManager.getSensorList(27);
        Sensor wakeUpDeviceOrientationSensor = null;
        Sensor nonWakeUpDeviceOrientationSensor = null;
        Iterator<Sensor> r3 = l.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        Sensor s = r3.next();
        if (s.isWakeUpSensor() == true) goto L7;
        nonWakeUpDeviceOrientationSensor = s;
        goto L4
    L7:
        wakeUpDeviceOrientationSensor = s;
        goto L4
    L10:
        if (wakeUpDeviceOrientationSensor == null) goto L12;
        this.mSensor = wakeUpDeviceOrientationSensor;
    L14:
        if (this.mSensor == null) goto L17;
        this.mOrientationJudge = new OrientationSensorJudge(this);
    L17:
        if (this.mOrientationJudge != null) goto L28;
        this.mSensor = this.mSensorManager.getDefaultSensor(1);
        if (this.mSensor == null) goto L29;
        this.mOrientationJudge = new AccelSensorJudge(this, context);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        this.mSensor = nonWakeUpDeviceOrientationSensor;
        goto L14
    }

    public void enable() {
        enable(true);
    }

    public void enable(boolean clearCurrentRotation) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSensor != null) goto L12;
        Slog.w(TAG, "Cannot detect sensors. Not enabled");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mEnabled == false) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L16:
        if (LOG == false) goto L18;
        Slog.d(TAG, "WindowOrientationListener enabled clearCurrentRotation=" + clearCurrentRotation);     // Catch: Throwable -> L9
    L18:
        this.mOrientationJudge.resetLocked(clearCurrentRotation);     // Catch: Throwable -> L9
        if (this.mSensor.getType() != 1) goto L21;
        this.mSensorManager.registerListener(this.mOrientationJudge, this.mSensor, this.mRate, 100000, this.mHandler);     // Catch: Throwable -> L9
    L22:
        this.mEnabled = true;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L21:
        this.mSensorManager.registerListener(this.mOrientationJudge, this.mSensor, this.mRate, this.mHandler);     // Catch: Throwable -> L9
        goto L22
    }

    public void disable() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSensor != null) goto L12;
        Slog.w(TAG, "Cannot detect sensors. Invalid disable");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mEnabled == true) goto L14;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        if (LOG == false) goto L16;
        Slog.d(TAG, "WindowOrientationListener disabled");     // Catch: Throwable -> L9
    L16:
        this.mSensorManager.unregisterListener(this.mOrientationJudge);     // Catch: Throwable -> L9
        this.mEnabled = false;     // Catch: Throwable -> L9
        goto L17
    }

    public void onTouchStart() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mOrientationJudge == null) goto L9;
        this.mOrientationJudge.onTouchStartLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void onTouchEnd() {
        long whenElapsedNanos = SystemClock.elapsedRealtimeNanos();
        Object r2 = this.mLock;
        monitor-enter(r2);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mOrientationJudge == null) goto L9;
        this.mOrientationJudge.onTouchEndLocked(whenElapsedNanos);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void setCurrentRotation(int rotation) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCurrentRotation = rotation;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getProposedRotation() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == false) goto L11;
        int r1 = this.mOrientationJudge.getProposedRotationLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    }

    public boolean canDetectOrientation() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSensor == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        Object r2 = this.mLock;
        monitor-enter(r2);
        proto.write(1133871366145L, this.mEnabled);     // Catch: Throwable -> L8
        proto.write(1159641169922L, this.mCurrentRotation);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        proto.end(token);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println(prefix + TAG);     // Catch: Throwable -> L7
        String prefix2 = prefix + "  ";     // Catch: Throwable -> L7
        pw.println(prefix2 + "mEnabled=" + this.mEnabled);     // Catch: Throwable -> L7
        pw.println(prefix2 + "mCurrentRotation=" + Surface.rotationToString(this.mCurrentRotation));     // Catch: Throwable -> L7
        pw.println(prefix2 + "mSensorType=" + this.mSensorType);     // Catch: Throwable -> L7
        pw.println(prefix2 + "mSensor=" + this.mSensor);     // Catch: Throwable -> L7
        pw.println(prefix2 + "mRate=" + this.mRate);     // Catch: Throwable -> L7
        if (this.mOrientationJudge == null) goto L9;
        this.mOrientationJudge.dumpLocked(pw, prefix2);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean shouldStayEnabledWhileDreaming() {
        if (this.mContext.getResources().getBoolean(R.bool.config_gnssLocationOverlayUnstableFallback) == false) goto L6;
        return true;
    L6:
        if (this.mSensor.getType() == 27) goto L8;
    L10:
        return false;
    L8:
        if (this.mSensor.isWakeUpSensor() == false) goto L10;
        return true;
    }
}
