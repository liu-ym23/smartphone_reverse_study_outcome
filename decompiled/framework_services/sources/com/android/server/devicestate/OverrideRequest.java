package com.android.server.devicestate;

import android.hardware.devicestate.DeviceState;
import android.os.IBinder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
final class OverrideRequest {
    public static final int OVERRIDE_REQUEST_TYPE_BASE_STATE = 1;
    public static final int OVERRIDE_REQUEST_TYPE_EMULATED_STATE = 0;
    private final int mFlags;
    private final int mPid;
    private final int mRequestType;
    private final DeviceState mRequestedState;
    private final IBinder mToken;
    private final int mUid;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OverrideRequestType {
    }

    OverrideRequest(IBinder token, int pid, int uid, DeviceState requestedState, int flags, int requestType) {
        this.mToken = token;
        this.mPid = pid;
        this.mUid = uid;
        this.mRequestedState = requestedState;
        this.mFlags = flags;
        this.mRequestType = requestType;
    }

    IBinder getToken() {
        return this.mToken;
    }

    int getPid() {
        return this.mPid;
    }

    int getUid() {
        return this.mUid;
    }

    DeviceState getRequestedDeviceState() {
        return this.mRequestedState;
    }

    int getRequestedStateIdentifier() {
        return this.mRequestedState.getIdentifier();
    }

    int getFlags() {
        return this.mFlags;
    }

    int getRequestType() {
        return this.mRequestType;
    }
}
