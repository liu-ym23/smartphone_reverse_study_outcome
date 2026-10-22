package com.android.server.oemlock;

/* JADX INFO: loaded from: classes2.dex */
abstract class OemLock {
    abstract String getLockName();

    abstract boolean isOemUnlockAllowedByCarrier();

    abstract boolean isOemUnlockAllowedByDevice();

    abstract void setOemUnlockAllowedByCarrier(boolean r1, byte[] r2);

    abstract void setOemUnlockAllowedByDevice(boolean r1);

    OemLock() {
    }
}
