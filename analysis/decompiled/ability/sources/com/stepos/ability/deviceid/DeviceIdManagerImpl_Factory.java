package com.stepos.ability.deviceid;

import T3.b;
import android.content.Context;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class DeviceIdManagerImpl_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private DeviceIdManagerImpl_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static DeviceIdManagerImpl_Factory create(InterfaceC2137b interfaceC2137b) {
        return new DeviceIdManagerImpl_Factory(interfaceC2137b);
    }

    public static b newInstance(Context context) {
        return new b(context);
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
