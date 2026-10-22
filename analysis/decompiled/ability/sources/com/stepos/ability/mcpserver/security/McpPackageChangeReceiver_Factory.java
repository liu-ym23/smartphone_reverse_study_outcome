package com.stepos.ability.mcpserver.security;

import k4.n;
import k4.s;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class McpPackageChangeReceiver_Factory implements InterfaceC2137b {
    private final InterfaceC2137b registryProvider;

    private McpPackageChangeReceiver_Factory(InterfaceC2137b interfaceC2137b) {
        this.registryProvider = interfaceC2137b;
    }

    public static McpPackageChangeReceiver_Factory create(InterfaceC2137b interfaceC2137b) {
        return new McpPackageChangeReceiver_Factory(interfaceC2137b);
    }

    public static s newInstance(n nVar) {
        return new s(nVar);
    }

    @Override // javax.inject.Provider
    public s get() {
        return newInstance((n) this.registryProvider.get());
    }
}
