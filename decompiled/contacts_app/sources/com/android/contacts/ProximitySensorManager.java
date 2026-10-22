package com.android.contacts;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes.dex */
public class ProximitySensorManager {
    private boolean mManagerEnabled;
    private final ProximitySensorEventListener mProximitySensorListener;

    /* JADX INFO: renamed from: com.android.contacts.ProximitySensorManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$contacts$ProximitySensorManager$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$com$android$contacts$ProximitySensorManager$State = r0;
            r0[State.NEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$android$contacts$ProximitySensorManager$State[State.FAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface Listener {
        void onFar();

        void onNear();
    }

    private static class ProximitySensorEventListener implements SensorEventListener {
        private static final float FAR_THRESHOLD = 5.0f;
        private State mLastState;
        private final Listener mListener;
        private final float mMaxValue;
        private final Sensor mProximitySensor;
        private final SensorManager mSensorManager;
        private boolean mWaitingForFarState;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r1, int r2) {
        }

        public ProximitySensorEventListener(SensorManager r1, Sensor r2, Listener r3) {
            this.mSensorManager = r1;
            this.mProximitySensor = r2;
            this.mMaxValue = r2.getMaximumRange();
            this.mListener = r3;
            this.mLastState = State.FAR;
            this.mWaitingForFarState = false;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r2) {
            if (r2.values != null) goto L6;
            return;
        L6:
            if (r2.values.length != 0) goto L8;
            return;
        L8:
            State r3 = getStateFromValue(r2.values[0]);
            monitor-enter(this);
        L28:
            th = move-exception;
            throw th;
        L11:
            if (r3 != this.mLastState) goto L14;
            monitor-exit(this);     // Catch: Throwable -> L28
            return;
        L14:
            this.mLastState = r3;     // Catch: Throwable -> L28
            if (this.mWaitingForFarState == true) goto L17;
        L19:
            monitor-exit(this);     // Catch: Throwable -> L28
            int r4 = AnonymousClass1.$SwitchMap$com$android$contacts$ProximitySensorManager$State[r3.ordinal()];
            if (r4 != 1) goto L23;
            this.mListener.onNear();
            return;
        L23:
            if (r4 != 2) goto L33;
            this.mListener.onFar();
            return;
        L33:
            return;
        L17:
            if (r3 != State.FAR) goto L19;
            unregisterWithoutNotification();     // Catch: Throwable -> L28
            goto L19
        }

        private State getStateFromValue(float r2) {
            if (r2 > FAR_THRESHOLD) goto L9;
            if (r2 == this.mMaxValue) goto L9;
            return State.NEAR;
        L9:
            return State.FAR;
        }

        public synchronized void unregisterWhenFar() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mLastState != State.FAR) goto L6;
            unregisterWithoutNotification();     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            this.mWaitingForFarState = true;     // Catch: Throwable -> L9
            goto L7
        }

        public synchronized void register() {
            monitor-enter(this);
            this.mSensorManager.registerListener(this, this.mProximitySensor, 2);     // Catch: Throwable -> L6
            this.mWaitingForFarState = false;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void unregister() {
            monitor-enter(this);
            unregisterWithoutNotification();     // Catch: Throwable -> L9
            State r0 = this.mLastState;     // Catch: Throwable -> L9
            this.mLastState = State.FAR;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            if (r0 == State.FAR) goto L14;
            this.mListener.onFar();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private synchronized void unregisterWithoutNotification() {
            monitor-enter(this);
            this.mSensorManager.unregisterListener(this);     // Catch: Throwable -> L6
            this.mWaitingForFarState = false;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State FAR = null;
        public static final State NEAR = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NEAR, FAR};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            NEAR = new State("NEAR", 0);
            FAR = new State("FAR", 1);
            $VALUES = $values();
        }
    }

    public ProximitySensorManager(Context r3, Listener r4) {
        SensorManager r5 = (SensorManager) r3.getSystemService("sensor");
        Sensor r0 = r5.getDefaultSensor(8);
        if (r0 != null) goto L5;
        this.mProximitySensorListener = null;
        return;
    L5:
        this.mProximitySensorListener = new ProximitySensorEventListener(r5, r0, r4);
    }

    public void enable() {
        ProximitySensorEventListener r0 = this.mProximitySensorListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mManagerEnabled == true) goto L9;
        r0.register();
        this.mManagerEnabled = true;
        return;
    }

    public void disable(boolean r3) {
        ProximitySensorEventListener r0 = this.mProximitySensorListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mManagerEnabled == false) goto L12;
        if (r3 == false) goto L8;
        r0.unregisterWhenFar();
    L9:
        this.mManagerEnabled = false;
        return;
    L8:
        r0.unregister();
        goto L9
    }
}
