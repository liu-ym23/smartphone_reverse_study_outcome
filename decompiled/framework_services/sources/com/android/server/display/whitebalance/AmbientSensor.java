package com.android.server.display.whitebalance;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.Slog;
import com.android.server.display.utils.History;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
abstract class AmbientSensor {
    private static final int HISTORY_SIZE = 50;
    private boolean mEnabled;
    private int mEventsCount;
    private History mEventsHistory;
    private final Handler mHandler;
    private SensorEventListener mListener;
    protected boolean mLoggingEnabled;
    private int mRate;
    protected Sensor mSensor;
    protected final SensorManager mSensorManager;
    protected String mTag;

    static class AmbientBrightnessSensor extends AmbientSensor {
        private static final String TAG = "AmbientBrightnessSensor";
        private Callbacks mCallbacks;

        interface Callbacks {
            void onAmbientBrightnessChanged(float r1);
        }

        AmbientBrightnessSensor(Handler handler, SensorManager sensorManager, int rate) {
            super(TAG, handler, sensorManager, rate);
            this.mSensor = this.mSensorManager.getDefaultSensor(5);
            if (this.mSensor == null) goto L7;
            this.mCallbacks = null;
            return;
        L7:
            throw new IllegalStateException("cannot find light sensor");
        }

        public boolean setCallbacks(Callbacks callbacks) {
            if (this.mCallbacks != callbacks) goto L6;
            return false;
        L6:
            this.mCallbacks = callbacks;
            return true;
        }

        @Override // com.android.server.display.whitebalance.AmbientSensor
        public void dump(PrintWriter writer) {
            super.dump(writer);
            writer.println("    mCallbacks=" + this.mCallbacks);
        }

        @Override // com.android.server.display.whitebalance.AmbientSensor
        protected void update(float value) {
            if (this.mCallbacks == null) goto L6;
            this.mCallbacks.onAmbientBrightnessChanged(value);
            return;
        }
    }

    static class AmbientColorTemperatureSensor extends AmbientSensor {
        private static final String TAG = "AmbientColorTemperatureSensor";
        private Callbacks mCallbacks;

        interface Callbacks {
            void onAmbientColorTemperatureChanged(float r1);
        }

        AmbientColorTemperatureSensor(Handler handler, SensorManager sensorManager, String name, int rate) {
            super(TAG, handler, sensorManager, rate);
            this.mSensor = null;
            Iterator<Sensor> r1 = this.mSensorManager.getSensorList(-1).iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            Sensor sensor = r1.next();
            if (sensor.getStringType().equals(name) == false) goto L4;
            this.mSensor = sensor;
        L10:
            if (this.mSensor == null) goto L14;
            this.mCallbacks = null;
            return;
        L14:
            throw new IllegalStateException("cannot find sensor " + name);
        }

        public boolean setCallbacks(Callbacks callbacks) {
            if (this.mCallbacks != callbacks) goto L6;
            return false;
        L6:
            this.mCallbacks = callbacks;
            return true;
        }

        @Override // com.android.server.display.whitebalance.AmbientSensor
        public void dump(PrintWriter writer) {
            super.dump(writer);
            writer.println("    mCallbacks=" + this.mCallbacks);
        }

        @Override // com.android.server.display.whitebalance.AmbientSensor
        protected void update(float value) {
            if (this.mCallbacks == null) goto L6;
            this.mCallbacks.onAmbientColorTemperatureChanged(value);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNewEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4151$$Nest$mhandleNewEvent(AmbientSensor r0, float r1) {
        r0.handleNewEvent(r1);
    }

    protected abstract void update(float r1);

    AmbientSensor(String tag, Handler handler, SensorManager sensorManager, int rate) {
        this.mListener = new AnonymousClass1(this);
        validateArguments(handler, sensorManager, rate);
        this.mTag = tag;
        this.mLoggingEnabled = false;
        this.mHandler = handler;
        this.mSensorManager = sensorManager;
        this.mEnabled = false;
        this.mRate = rate;
        this.mEventsCount = 0;
        this.mEventsHistory = new History(50);
    }

    public boolean setEnabled(boolean enabled) {
        if (enabled == false) goto L6;
        return enable();
    L6:
        return disable();
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        this.mLoggingEnabled = loggingEnabled;
        return true;
    }

    public void dump(PrintWriter writer) {
        writer.println("  " + this.mTag);
        writer.println("    mLoggingEnabled=" + this.mLoggingEnabled);
        writer.println("    mHandler=" + this.mHandler);
        writer.println("    mSensorManager=" + this.mSensorManager);
        writer.println("    mSensor=" + this.mSensor);
        writer.println("    mEnabled=" + this.mEnabled);
        writer.println("    mRate=" + this.mRate);
        writer.println("    mEventsCount=" + this.mEventsCount);
        writer.println("    mEventsHistory=" + this.mEventsHistory);
    }

    private static void validateArguments(Handler handler, SensorManager sensorManager, int rate) {
        handler.getClass();
        sensorManager.getClass();
        if (rate <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("rate must be positive");
    }

    private boolean enable() {
        if (this.mEnabled == false) goto L7;
        return false;
    L7:
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(this.mTag, "enabling");
    L9:
        this.mEnabled = true;
        startListening();
        return true;
    }

    private boolean disable() {
        if (this.mEnabled == true) goto L6;
        return false;
    L6:
        if (this.mLoggingEnabled == false) goto L8;
        Slog.d(this.mTag, "disabling");
    L8:
        this.mEnabled = false;
        this.mEventsCount = 0;
        stopListening();
        return true;
    }

    private void startListening() {
        if (this.mSensorManager != null) goto L5;
        return;
    L5:
        this.mSensorManager.registerListener(this.mListener, this.mSensor, this.mRate * 1000, this.mHandler);
    }

    private void stopListening() {
        if (this.mSensorManager != null) goto L5;
        return;
    L5:
        this.mSensorManager.unregisterListener(this.mListener);
    }

    private void handleNewEvent(float value) {
        if (this.mEnabled == true) goto L6;
        return;
    L6:
        if (this.mLoggingEnabled == false) goto L8;
        Slog.d(this.mTag, "handle new event: " + value);
    L8:
        this.mEventsCount++;
        this.mEventsHistory.add(value);
        update(value);
    }
}
