package com.stepos.ability.permission.init;

import H3.b;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class SlaPermissionInit_Factory implements InterfaceC2137b {
    private final InterfaceC2137b accountUtilProvider;
    private final InterfaceC2137b slaPermissionMngProvider;

    private SlaPermissionInit_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.slaPermissionMngProvider = interfaceC2137b;
        this.accountUtilProvider = interfaceC2137b2;
    }

    public static SlaPermissionInit_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new SlaPermissionInit_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static SlaPermissionInit newInstance(ISlaPermissionManager iSlaPermissionManager, b bVar) {
        return new SlaPermissionInit(iSlaPermissionManager, bVar);
    }

    @Override // javax.inject.Provider
    public SlaPermissionInit get() {
        return newInstance((ISlaPermissionManager) this.slaPermissionMngProvider.get(), (b) this.accountUtilProvider.get());
    }
}
