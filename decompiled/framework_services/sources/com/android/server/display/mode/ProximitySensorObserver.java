package com.android.server.display.mode;

import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.SurfaceControl;
import com.android.internal.os.BackgroundThread;
import com.android.server.sensors.SensorManagerInternal;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class ProximitySensorObserver implements SensorManagerInternal.ProximityActiveListener, DisplayManager.DisplayListener {
    private DisplayManagerInternal mDisplayManagerInternal;
    private final SparseBooleanArray mDozeStateByDisplay;
    private final DisplayModeDirector.Injector mInjector;
    private boolean mIsProxActive;
    private final String mProximitySensorName;
    private final String mProximitySensorType;
    private final Object mSensorObserverLock;
    private final VotesStorage mVotesStorage;

    ProximitySensorObserver(VotesStorage votesStorage, DisplayModeDirector.Injector injector) {
        this.mProximitySensorName = null;
        this.mProximitySensorType = "android.sensor.proximity";
        this.mDozeStateByDisplay = new SparseBooleanArray();
        this.mSensorObserverLock = new Object();
        this.mIsProxActive = false;
        this.mVotesStorage = votesStorage;
        this.mInjector = injector;
    }

    @Override // com.android.server.sensors.SensorManagerInternal.ProximityActiveListener
    public void onProximityActive(boolean isActive) {
        Object r0 = this.mSensorObserverLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsProxActive == isActive) goto L9;
        this.mIsProxActive = isActive;     // Catch: Throwable -> L7
        recalculateVotesLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void observe() {
        this.mDisplayManagerInternal = this.mInjector.getDisplayManagerInternal();
        SensorManagerInternal sensorManager = this.mInjector.getSensorManagerInternal();
        sensorManager.addProximityActiveListener(BackgroundThread.getExecutor(), this);
        Object r1 = this.mSensorObserverLock;
        monitor-enter(r1);
        Display[] r2 = this.mInjector.getDisplays();     // Catch: Throwable -> L7
        int r3 = r2.length;     // Catch: Throwable -> L7
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L9;
        Display d = r2[r4];     // Catch: Throwable -> L7
        this.mDozeStateByDisplay.put(d.getDisplayId(), this.mInjector.isDozeState(d));     // Catch: Throwable -> L7
        r4 = r4 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        registerDisplayListener();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void registerDisplayListener() {
        this.mInjector.registerDisplayListener(this, BackgroundThread.getHandler(), 7);
    }

    private void recalculateVotesLocked() {
        Display[] displays = this.mInjector.getDisplays();
        int r1 = displays.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        Display d = displays[r2];
        int displayId = d.getDisplayId();
        Vote vote = null;
        if (this.mIsProxActive == false) goto L11;
        if (this.mDozeStateByDisplay.get(displayId) == true) goto L11;
        SurfaceControl.RefreshRateRange rate = this.mDisplayManagerInternal.getRefreshRateForDisplayAndSensor(displayId, this.mProximitySensorName, "android.sensor.proximity");
        if (rate == null) goto L11;
        vote = Vote.forPhysicalRefreshRates(rate.min, rate.max);
    L11:
        this.mVotesStorage.updateVote(displayId, 22, vote);
        r2 = r2 + 1;
        goto L3
    }

    void dump(PrintWriter pw) {
        pw.println("  SensorObserver");
        Object r0 = this.mSensorObserverLock;
        monitor-enter(r0);
        pw.println("    mIsProxActive=" + this.mIsProxActive);     // Catch: Throwable -> L8
        pw.println("    mDozeStateByDisplay:");     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mDozeStateByDisplay.size()) goto L11;
        int id = this.mDozeStateByDisplay.keyAt(i);     // Catch: Throwable -> L8
        boolean dozed = this.mDozeStateByDisplay.valueAt(i);     // Catch: Throwable -> L8
        pw.println("      " + id + " -> " + dozed);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        boolean isDozeState = this.mInjector.isDozeState(this.mInjector.getDisplay(displayId));
        Object r1 = this.mSensorObserverLock;
        monitor-enter(r1);
        this.mDozeStateByDisplay.put(displayId, isDozeState);     // Catch: Throwable -> L7
        recalculateVotesLocked();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
        Object r0 = this.mSensorObserverLock;
        monitor-enter(r0);
        boolean wasDozeState = this.mDozeStateByDisplay.get(displayId);     // Catch: Throwable -> L7
        this.mDozeStateByDisplay.put(displayId, this.mInjector.isDozeState(this.mInjector.getDisplay(displayId)));     // Catch: Throwable -> L7
        if (wasDozeState == this.mDozeStateByDisplay.get(displayId)) goto L9;
        recalculateVotesLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        Object r0 = this.mSensorObserverLock;
        monitor-enter(r0);
        this.mDozeStateByDisplay.delete(displayId);     // Catch: Throwable -> L7
        recalculateVotesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
