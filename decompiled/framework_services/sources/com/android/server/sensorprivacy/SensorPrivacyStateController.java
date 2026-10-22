package com.android.server.sensorprivacy;

import android.os.Handler;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.pooled.PooledLambda;

/* JADX INFO: loaded from: classes3.dex */
abstract class SensorPrivacyStateController {
    private static SensorPrivacyStateController sInstance;
    AllSensorStateController mAllSensorStateController;
    private final Object mLock;

    interface AllSensorPrivacyListener {
        void onAllSensorPrivacyChanged(boolean r1);
    }

    interface SensorPrivacyListener {
        void onSensorPrivacyChanged(int r1, int r2, int r3, SensorState r4);
    }

    interface SensorPrivacyStateConsumer {
        void accept(int r1, int r2, int r3, SensorState r4);
    }

    interface SetStateResultCallback {
        void callback(boolean r1);
    }

    abstract void dumpLocked(DualDumpOutputStream r1);

    abstract void forEachStateLocked(SensorPrivacyStateConsumer r1);

    abstract SensorState getStateLocked(int r1, int r2, int r3);

    abstract void resetForTestingImpl();

    abstract void schedulePersistLocked();

    abstract void setSensorPrivacyListenerLocked(Handler r1, SensorPrivacyListener r2);

    abstract void setStateLocked(int r1, int r2, int r3, int r4, Handler r5, SetStateResultCallback r6);

    abstract void setStateLocked(int r1, int r2, int r3, boolean r4, Handler r5, SetStateResultCallback r6);

    SensorPrivacyStateController() {
        this.mAllSensorStateController = AllSensorStateController.getInstance();
        this.mLock = new Object();
    }

    static SensorPrivacyStateController getInstance() {
        if (sInstance != null) goto L6;
        sInstance = SensorPrivacyStateControllerImpl.getInstance();
    L6:
        return sInstance;
    }

    SensorState getState(int toggleType, int userId, int sensor) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SensorState r1 = getStateLocked(toggleType, userId, sensor);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setState(int toggleType, int userId, int sensor, boolean enabled, Handler callbackHandler, SetStateResultCallback callback) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        setStateLocked(toggleType, userId, sensor, enabled, callbackHandler, callback);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setState(int toggleType, int userId, int sensor, int state, Handler callbackHandler, SetStateResultCallback callback) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        setStateLocked(toggleType, userId, sensor, state, callbackHandler, callback);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setSensorPrivacyListener(Handler handler, SensorPrivacyListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setSensorPrivacyListenerLocked(handler, listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean getAllSensorState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mAllSensorStateController.getAllSensorStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setAllSensorState(boolean enable) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllSensorStateController.setAllSensorStateLocked(enable);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setAllSensorPrivacyListener(Handler handler, AllSensorPrivacyListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllSensorStateController.setAllSensorPrivacyListenerLocked(handler, listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void persistAll() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllSensorStateController.schedulePersistLocked();     // Catch: Throwable -> L7
        schedulePersistLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void forEachState(SensorPrivacyStateConsumer consumer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        forEachStateLocked(consumer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dump(DualDumpOutputStream dumpStream) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllSensorStateController.dumpLocked(dumpStream);     // Catch: Throwable -> L8
        dumpLocked(dumpStream);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        dumpStream.flush();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void atomic(Runnable r) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        r.run();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void sendSetStateCallback(Handler callbackHandler, SetStateResultCallback callback, boolean success) {
        callbackHandler.sendMessage(PooledLambda.obtainMessage(new SensorPrivacyStateController$$ExternalSyntheticLambda0(), callback, Boolean.valueOf(success)));
    }

    void resetForTesting() {
        this.mAllSensorStateController.resetForTesting();
        resetForTestingImpl();
        sInstance = null;
    }
}
