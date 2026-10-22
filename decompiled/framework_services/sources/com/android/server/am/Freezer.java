package com.android.server.am;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
class Freezer {
    private static native int nativeFreezeBinder(int r0, boolean r1, int r2);

    private static native int nativeGetBinderFreezeInfo(int r0);

    private static native boolean nativeIsFreezerSupported();

    Freezer() {
    }

    public void setProcessFrozen(int pid, int uid, boolean frozen) {
        Process.setProcessFrozen(pid, uid, frozen);
    }

    public int freezeBinder(int pid, boolean freeze, int timeoutMs) {
        return nativeFreezeBinder(pid, freeze, timeoutMs);
    }

    public int getBinderFreezeInfo(int pid) {
        return nativeGetBinderFreezeInfo(pid);
    }

    public boolean isFreezerSupported() {
        return nativeIsFreezerSupported();
    }
}
