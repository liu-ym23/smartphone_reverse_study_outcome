package com.android.server.biometrics.sensors.fingerprint;

import android.hardware.fingerprint.IFingerprintClientActiveCallback;
import android.os.RemoteException;
import android.util.Slog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GestureAvailabilityDispatcher {
    private static final String TAG = "GestureAvailabilityTracker";
    private final Map<Integer, Boolean> mActiveSensors;
    private final CopyOnWriteArrayList<IFingerprintClientActiveCallback> mClientActiveCallbacks;
    private boolean mIsActive;

    GestureAvailabilityDispatcher() {
        this.mClientActiveCallbacks = new CopyOnWriteArrayList();
        this.mActiveSensors = new HashMap();
    }

    public boolean isAnySensorActive() {
        return this.mIsActive;
    }

    public void markSensorActive(int sensorId, boolean active) {
        this.mActiveSensors.put(Integer.valueOf(sensorId), Boolean.valueOf(active));
        boolean wasActive = this.mIsActive;
        boolean isActive = false;
        Iterator<Boolean> r2 = this.mActiveSensors.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Boolean b = r2.next();
        if (b.booleanValue() == false) goto L4;
        isActive = true;
    L9:
        if (wasActive == isActive) goto L15;
        Slog.d(TAG, "Notifying gesture availability, active=" + this.mIsActive);
        this.mIsActive = isActive;
        notifyClientActiveCallbacks(this.mIsActive);
        return;
    }

    void registerCallback(IFingerprintClientActiveCallback callback) {
        this.mClientActiveCallbacks.add(callback);
    }

    void removeCallback(IFingerprintClientActiveCallback callback) {
        this.mClientActiveCallbacks.remove(callback);
    }

    private void notifyClientActiveCallbacks(boolean isActive) {
        Iterator<IFingerprintClientActiveCallback> r0 = this.mClientActiveCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IFingerprintClientActiveCallback callback = r0.next();
        callback.onClientActiveChanged(isActive);     // Catch: RemoteException -> L8
    L9:
        this.mClientActiveCallbacks.remove(callback);
        goto L4
    }
}
