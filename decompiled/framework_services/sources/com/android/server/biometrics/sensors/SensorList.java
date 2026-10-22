package com.android.server.biometrics.sensors;

import android.app.IActivityManager;
import android.app.SynchronousUserSwitchObserver;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class SensorList<T> {
    private static final String TAG = "SensorList";
    private final IActivityManager mActivityManager;
    private final SparseArray<T> mSensors;

    public SensorList(IActivityManager activityManager) {
        this.mSensors = new SparseArray();
        this.mActivityManager = activityManager;
    }

    public void addSensor(int sensorId, T sensor, int sessionUserId, SynchronousUserSwitchObserver userSwitchObserver) {
        this.mSensors.put(sensorId, sensor);
        registerUserSwitchObserver(sessionUserId, userSwitchObserver);
    }

    private void registerUserSwitchObserver(int sessionUserId, SynchronousUserSwitchObserver userSwitchObserver) {
        this.mActivityManager.registerUserSwitchObserver(userSwitchObserver, TAG);     // Catch: RemoteException -> L7
        if (sessionUserId != (-10000)) goto L14;
        userSwitchObserver.onUserSwitching(0);     // Catch: RemoteException -> L7
        return;
    L14:
        return;
    L10:
        Slog.e(TAG, "Unable to register user switch observer");
    }

    public T valueAt(int position) {
        return this.mSensors.valueAt(position);
    }

    public T get(int sensorId) {
        return this.mSensors.get(sensorId);
    }

    public int keyAt(int position) {
        return this.mSensors.keyAt(position);
    }

    public int size() {
        return this.mSensors.size();
    }

    public boolean contains(int sensorId) {
        return this.mSensors.contains(sensorId);
    }
}
