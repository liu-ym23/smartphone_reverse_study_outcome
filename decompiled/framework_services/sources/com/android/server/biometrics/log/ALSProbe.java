package com.android.server.biometrics.log;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class ALSProbe implements Probe {
    private static final String TAG = "ALSProbe";
    private boolean mDestroyRequested;
    private boolean mDestroyed;
    private boolean mDisableRequested;
    private boolean mEnabled;
    private volatile float mLastAmbientLux;
    private final Sensor mLightSensor;
    private final SensorEventListener mLightSensorListener;
    private long mMaxSubscriptionTime;
    private NextConsumer mNextConsumer;
    private final SensorManager mSensorManager;
    private final Handler mTimer;

    private static class NextConsumer {
        private final Consumer<Float> mConsumer;
        private final Handler mHandler;
        private final List<NextConsumer> mOthers;

        /* JADX INFO: renamed from: $r8$lambda$P-pWr2ProJ8vssNtTKmkJQZW1U0, reason: not valid java name */
        public static /* synthetic */ void m2598$r8$lambda$PpWr2ProJ8vssNtTKmkJQZW1U0(NextConsumer r0, float r1) {
            r0.lambda$consume$0(r1);
        }

        /* synthetic */ NextConsumer(Consumer r1, Handler r2, ALSProbeIA r3) {
            this(r1, r2);
        }

        private NextConsumer(Consumer<Float> consumer, Handler handler) {
            this.mOthers = new ArrayList();
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        public void consume(final float value) {
            if (this.mHandler == null) goto L5;
            this.mHandler.post(new ALSProbe$NextConsumer$$ExternalSyntheticLambda0(this, value));
        L6:
            Iterator<NextConsumer> r0 = this.mOthers.iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            NextConsumer c = r0.next();
            c.consume(value);
            goto L8
        L10:
            return;
        L5:
            this.mConsumer.accept(Float.valueOf(value));
            goto L6
        }

        private /* synthetic */ void lambda$consume$0(float value) {
            this.mConsumer.accept(Float.valueOf(value));
        }

        public void add(NextConsumer consumer) {
            this.mOthers.add(consumer);
        }
    }

    public static /* synthetic */ void $r8$lambda$F4FD4FcmvmYrxrGTCyOPcWWC3rc(ALSProbe r0) {
        r0.onTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$monNext, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2597$$Nest$monNext(ALSProbe r0, float r1) {
        r0.onNext(r1);
    }

    ALSProbe(SensorManager sensorManager) {
        this(sensorManager, new Handler(Looper.getMainLooper()), TimeUnit.MINUTES.toMillis(1));
    }

    ALSProbe(SensorManager sensorManager, Handler handler, long maxTime) {
        this.mMaxSubscriptionTime = -1;
        this.mEnabled = false;
        this.mDestroyed = false;
        this.mDestroyRequested = false;
        this.mDisableRequested = false;
        Sensor r0 = null;
        this.mNextConsumer = null;
        this.mLastAmbientLux = -1.0f;
        this.mLightSensorListener = new AnonymousClass1(this);
        this.mSensorManager = sensorManager;
        if (sensorManager == null) goto L6;
        r0 = sensorManager.getDefaultSensor(5);
    L6:
        this.mLightSensor = r0;
        this.mTimer = handler;
        this.mMaxSubscriptionTime = maxTime;
        if (this.mSensorManager != null) goto L9;
    L10:
        Slog.w(TAG, "No sensor - probe disabled");
        this.mDestroyed = true;
        return;
    L9:
        if (this.mLightSensor == null) goto L10;
    }

    @Override // com.android.server.biometrics.log.Probe
    public synchronized void enable() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mDestroyed == false) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.mDestroyRequested == true) goto L11;
        this.mDisableRequested = false;     // Catch: Throwable -> L9
        enableLightSensorLoggingLocked();     // Catch: Throwable -> L9
        goto L11
    }

    @Override // com.android.server.biometrics.log.Probe
    public synchronized void disable() {
        monitor-enter(this);
        this.mDisableRequested = true;     // Catch: Throwable -> L10
        if (this.mDestroyed == false) goto L7;
    L12:
        monitor-exit(this);
        return;
    L7:
        if (this.mNextConsumer != null) goto L12;
        disableLightSensorLoggingLocked(false);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.biometrics.log.Probe
    public synchronized void destroy() {
        monitor-enter(this);
        this.mDestroyRequested = true;     // Catch: Throwable -> L10
        if (this.mDestroyed == false) goto L7;
    L12:
        monitor-exit(this);
        return;
    L7:
        if (this.mNextConsumer != null) goto L12;
        disableLightSensorLoggingLocked(true);     // Catch: Throwable -> L10
        this.mDestroyed = true;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void onNext(float value) {
        monitor-enter(this);
        this.mLastAmbientLux = value;     // Catch: Throwable -> L8
        NextConsumer consumer = this.mNextConsumer;     // Catch: Throwable -> L8
        this.mNextConsumer = null;     // Catch: Throwable -> L8
        if (consumer == null) goto L14;
        Slog.v(TAG, "Finishing next consumer");     // Catch: Throwable -> L8
        if (this.mDestroyRequested == false) goto L11;
        destroy();     // Catch: Throwable -> L8
    L13:
        consumer.consume(value);     // Catch: Throwable -> L8
        goto L14
    L11:
        if (this.mDisableRequested == false) goto L13;
        disable();     // Catch: Throwable -> L8
    L14:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public float getMostRecentLux() {
        return this.mLastAmbientLux;
    }

    public synchronized void awaitNextLux(Consumer<Float> consumer, Handler handler) {
        monitor-enter(this);
        NextConsumer nextConsumer = new NextConsumer(consumer, handler, null);     // Catch: Throwable -> L6
        float current = this.mLastAmbientLux;     // Catch: Throwable -> L6
        if (current <= (-1.0f)) goto L9;
        nextConsumer.consume(current);     // Catch: Throwable -> L6
    L15:
        monitor-exit(this);
        return;
    L9:
        if (this.mNextConsumer == null) goto L12;
        this.mNextConsumer.add(nextConsumer);     // Catch: Throwable -> L6
        goto L15
    L12:
        if (this.mLightSensor == null) goto L14;
        this.mDestroyed = false;     // Catch: Throwable -> L6
        this.mNextConsumer = nextConsumer;     // Catch: Throwable -> L6
        enableLightSensorLoggingLocked();     // Catch: Throwable -> L6
        goto L15
    L14:
        Slog.w(TAG, "No light sensor - use current to consume");     // Catch: Throwable -> L6
        nextConsumer.consume(current);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void enableLightSensorLoggingLocked() {
        if (this.mEnabled == false) goto L5;
    L7:
        resetTimerLocked(true);
        return;
    L5:
        if (this.mLightSensor == null) goto L7;
        this.mEnabled = true;
        this.mLastAmbientLux = -1.0f;
        this.mSensorManager.registerListener(this.mLightSensorListener, this.mLightSensor, 3);
        Slog.v(TAG, "Enable ALS: " + this.mLightSensorListener.hashCode());
        goto L7
    }

    private void disableLightSensorLoggingLocked(boolean destroying) {
        resetTimerLocked(false);
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        if (this.mLightSensor == null) goto L12;
        this.mEnabled = false;
        if (destroying == true) goto L9;
        this.mLastAmbientLux = -1.0f;
    L9:
        this.mSensorManager.unregisterListener(this.mLightSensorListener);
        Slog.v(TAG, "Disable ALS: " + this.mLightSensorListener.hashCode());
        return;
    }

    private void resetTimerLocked(boolean start) {
        this.mTimer.removeCallbacksAndMessages(this);
        if (start == true) goto L5;
        return;
    L5:
        if (this.mMaxSubscriptionTime <= 0) goto L9;
        this.mTimer.postDelayed(new ALSProbe$$ExternalSyntheticLambda0(this), this, this.mMaxSubscriptionTime);
        return;
    }

    private synchronized void onTimeout() {
        monitor-enter(this);
        Slog.e(TAG, "Max time exceeded for ALS logger - disabling: " + this.mLightSensorListener.hashCode());     // Catch: Throwable -> L6
        onNext(this.mLastAmbientLux);     // Catch: Throwable -> L6
        disable();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
