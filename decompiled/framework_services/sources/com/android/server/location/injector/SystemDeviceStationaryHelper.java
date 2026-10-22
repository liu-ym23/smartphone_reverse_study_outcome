package com.android.server.location.injector;

import android.os.Binder;
import com.android.internal.util.Preconditions;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes2.dex */
public class SystemDeviceStationaryHelper extends DeviceStationaryHelper {
    private DeviceIdleInternal mDeviceIdle;

    public SystemDeviceStationaryHelper() {
    }

    public void onSystemReady() {
        DeviceIdleInternal r0 = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
        r0.getClass();
        this.mDeviceIdle = r0;
    }

    @Override // com.android.server.location.injector.DeviceStationaryHelper
    public void addListener(DeviceIdleInternal.StationaryListener listener) {
        if (this.mDeviceIdle == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        this.mDeviceIdle.registerStationaryListener(listener);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.DeviceStationaryHelper
    public void removeListener(DeviceIdleInternal.StationaryListener listener) {
        if (this.mDeviceIdle == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        this.mDeviceIdle.unregisterStationaryListener(listener);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = false;
        goto L6
    }
}
