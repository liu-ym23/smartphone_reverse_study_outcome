package com.android.server.sensorprivacy;

import android.os.Handler;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.pooled.PooledLambda;

/* JADX INFO: loaded from: classes3.dex */
class SensorPrivacyStateControllerImpl extends SensorPrivacyStateController {
    private static final String SENSOR_PRIVACY_XML_FILE = "sensor_privacy_impl.xml";
    private static SensorPrivacyStateControllerImpl sInstance;
    private SensorPrivacyStateController.SensorPrivacyListener mListener;
    private Handler mListenerHandler;
    private PersistedState mPersistedState;

    static SensorPrivacyStateController getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new SensorPrivacyStateControllerImpl();
    L6:
        return sInstance;
    }

    private SensorPrivacyStateControllerImpl() {
        this.mPersistedState = PersistedState.fromFile(SENSOR_PRIVACY_XML_FILE);
        persistAll();
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    SensorState getStateLocked(int toggleType, int userId, int sensor) {
        SensorState sensorState = this.mPersistedState.getState(toggleType, userId, sensor);
        if (sensorState == null) goto L7;
        return new SensorState(sensorState);
    L7:
        return getDefaultSensorState();
    }

    private static SensorState getDefaultSensorState() {
        return new SensorState(false);
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void setStateLocked(int toggleType, int userId, int sensor, boolean enabled, Handler callbackHandler, SensorPrivacyStateController.SetStateResultCallback callback) {
        SensorState lastState = this.mPersistedState.getState(toggleType, userId, sensor);
        if (lastState != null) goto L11;
        if (enabled == true) goto L7;
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, false);
        return;
    L7:
        if (enabled == false) goto L11;
        SensorState sensorState = new SensorState(true);
        this.mPersistedState.setState(toggleType, userId, sensor, sensorState);
        notifyStateChangeLocked(toggleType, userId, sensor, sensorState);
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, true);
        return;
    L11:
        if (lastState.setEnabled(enabled) == false) goto L14;
        notifyStateChangeLocked(toggleType, userId, sensor, lastState);
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, true);
        return;
    L14:
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, false);
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void setStateLocked(int toggleType, int userId, int sensor, int state, Handler callbackHandler, SensorPrivacyStateController.SetStateResultCallback callback) {
        SensorState lastState = this.mPersistedState.getState(toggleType, userId, sensor);
        if (lastState != null) goto L11;
        if (state != 2) goto L8;
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, false);
        return;
    L8:
        SensorState sensorState = new SensorState(state);
        this.mPersistedState.setState(toggleType, userId, sensor, sensorState);
        notifyStateChangeLocked(toggleType, userId, sensor, sensorState);
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, true);
        return;
    L11:
        if (lastState.setState(state) == false) goto L14;
        notifyStateChangeLocked(toggleType, userId, sensor, lastState);
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, true);
        return;
    L14:
        SensorPrivacyStateController.sendSetStateCallback(callbackHandler, callback, false);
    }

    private void notifyStateChangeLocked(int toggleType, int userId, int sensor, SensorState sensorState) {
        if (this.mListenerHandler != null) goto L5;
    L7:
        schedulePersistLocked();
        return;
    L5:
        if (this.mListener == null) goto L7;
        this.mListenerHandler.sendMessage(PooledLambda.obtainMessage(new SensorPrivacyStateControllerImpl$$ExternalSyntheticLambda1(), this.mListener, Integer.valueOf(toggleType), Integer.valueOf(userId), Integer.valueOf(sensor), new SensorState(sensorState)));
        goto L7
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void setSensorPrivacyListenerLocked(Handler handler, SensorPrivacyStateController.SensorPrivacyListener listener) {
        handler.getClass();
        listener.getClass();
        if (this.mListener != null) goto L7;
        this.mListener = listener;
        this.mListenerHandler = handler;
        return;
    L7:
        throw new IllegalStateException("Listener is already set");
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void schedulePersistLocked() {
        this.mPersistedState.schedulePersist();
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void forEachStateLocked(final SensorPrivacyStateController.SensorPrivacyStateConsumer consumer) {
        PersistedState r0 = this.mPersistedState;
        consumer.getClass();
        r0.forEachKnownState(new SensorPrivacyStateControllerImpl$$ExternalSyntheticLambda0(consumer));
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void resetForTestingImpl() {
        this.mPersistedState.resetForTesting();
        this.mListener = null;
        this.mListenerHandler = null;
        sInstance = null;
    }

    @Override // com.android.server.sensorprivacy.SensorPrivacyStateController
    void dumpLocked(DualDumpOutputStream dumpStream) {
        this.mPersistedState.dump(dumpStream);
    }
}
