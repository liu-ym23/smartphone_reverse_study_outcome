package com.stepos.ability.task.executor.permissionauth;

import y7.InterfaceC2137b;
import z4.C2175g;

/* loaded from: classes3.dex */
public final class PermissionAuthCoordinator_Factory implements InterfaceC2137b {
    private final InterfaceC2137b pendingProvider;

    private PermissionAuthCoordinator_Factory(InterfaceC2137b interfaceC2137b) {
        this.pendingProvider = interfaceC2137b;
    }

    public static PermissionAuthCoordinator_Factory create(InterfaceC2137b interfaceC2137b) {
        return new PermissionAuthCoordinator_Factory(interfaceC2137b);
    }

    public static a newInstance(C2175g c2175g) {
        return new a(c2175g);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((C2175g) this.pendingProvider.get());
    }
}
