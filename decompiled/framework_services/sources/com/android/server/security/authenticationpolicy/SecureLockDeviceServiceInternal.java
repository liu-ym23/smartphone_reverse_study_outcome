package com.android.server.security.authenticationpolicy;

import android.security.authenticationpolicy.DisableSecureLockDeviceParams;
import android.security.authenticationpolicy.EnableSecureLockDeviceParams;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SecureLockDeviceServiceInternal {
    private static final String TAG = "SecureLockDeviceServiceInternal";

    public abstract int disableSecureLockDevice(DisableSecureLockDeviceParams r1);

    public abstract int enableSecureLockDevice(EnableSecureLockDeviceParams r1);

    public SecureLockDeviceServiceInternal() {
    }
}
