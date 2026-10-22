package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothTeardownResult extends ComponentResult {
    public long mScanCurrent;
    public long mScanTime;

    public BluetoothTeardownResult(int bluetoothCurrent, int scanCurrent, long scanTime) {
        this.mCurrent = bluetoothCurrent;
        this.mScanCurrent = scanCurrent;
        this.mScanTime = scanTime;
    }

    public String toString() {
        return "[Bluetooth] bluetooth current=" + this.mCurrent + "mA, scanCurrent=" + this.mScanCurrent + "mA, scanTime=" + (this.mScanTime / 1000) + "s\n";
    }
}
