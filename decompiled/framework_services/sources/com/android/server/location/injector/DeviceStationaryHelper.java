package com.android.server.location.injector;

import com.android.server.DeviceIdleInternal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceStationaryHelper {
    public abstract void addListener(DeviceIdleInternal.StationaryListener r1);

    public abstract void removeListener(DeviceIdleInternal.StationaryListener r1);

    public DeviceStationaryHelper() {
    }
}
