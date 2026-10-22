package com.android.server.sensorprivacy;

/* JADX INFO: loaded from: classes3.dex */
class SensorState {
    private long mLastChange;
    private int mStateType;

    SensorState(int stateType) {
        this.mStateType = stateType;
        this.mLastChange = SensorPrivacyService.getCurrentTimeMillis();
    }

    SensorState(int stateType, long lastChange) {
        this.mStateType = stateType;
        this.mLastChange = Math.min(SensorPrivacyService.getCurrentTimeMillis(), lastChange);
    }

    SensorState(SensorState sensorState) {
        this.mStateType = sensorState.getState();
        this.mLastChange = sensorState.getLastChange();
    }

    boolean setState(int stateType) {
        if (this.mStateType == stateType) goto L6;
        this.mStateType = stateType;
        this.mLastChange = SensorPrivacyService.getCurrentTimeMillis();
        return true;
    L6:
        return false;
    }

    int getState() {
        return this.mStateType;
    }

    long getLastChange() {
        return this.mLastChange;
    }

    private static int enabledToState(boolean enabled) {
        if (enabled == false) goto L4;
        return 1;
    L4:
        return 2;
    }

    SensorState(boolean enabled) {
        this(enabledToState(enabled));
    }

    boolean setEnabled(boolean enabled) {
        return setState(enabledToState(enabled));
    }

    boolean isEnabled() {
        if (getState() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
