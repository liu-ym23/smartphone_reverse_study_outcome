package com.android.server.appop;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnOpModeChangedListener {
    private static final int UID_ANY = -2;
    private int mCallingPid;
    private int mCallingUid;
    private int mFlags;
    private int mWatchedOpCode;
    private int mWatchingUid;

    public abstract void onOpModeChanged(int r1, int r2, String r3) throws RemoteException;

    public abstract String toString();

    OnOpModeChangedListener(int watchingUid, int flags, int watchedOpCode, int callingUid, int callingPid) {
        this.mWatchingUid = watchingUid;
        this.mFlags = flags;
        this.mWatchedOpCode = watchedOpCode;
        this.mCallingUid = callingUid;
        this.mCallingPid = callingPid;
    }

    public int getWatchingUid() {
        return this.mWatchingUid;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public int getWatchedOpCode() {
        return this.mWatchedOpCode;
    }

    public int getCallingUid() {
        return this.mCallingUid;
    }

    public int getCallingPid() {
        return this.mCallingPid;
    }

    public boolean isWatchingUid(int uid) {
        if (uid != (-2)) goto L5;
    L10:
        return true;
    L5:
        if (this.mWatchingUid < 0) goto L10;
        if (this.mWatchingUid == uid) goto L10;
        return false;
    }

    public void onOpModeChanged(int op, int uid, String packageName, String persistentDeviceId) throws RemoteException {
        if (Objects.equals(persistentDeviceId, "default:0") == false) goto L6;
        onOpModeChanged(op, uid, packageName);
        return;
    }
}
