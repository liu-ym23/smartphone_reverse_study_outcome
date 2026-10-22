package com.stepos.ability.mcpserver.security;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import k4.n;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class CallerIdentityRegistry_Factory implements InterfaceC2137b {
    private final InterfaceC2137b configProvider;

    private CallerIdentityRegistry_Factory(InterfaceC2137b interfaceC2137b) {
        this.configProvider = interfaceC2137b;
    }

    public static CallerIdentityRegistry_Factory create(InterfaceC2137b interfaceC2137b) {
        return new CallerIdentityRegistry_Factory(interfaceC2137b);
    }

    public static n newInstance(McpServerConfig mcpServerConfig) {
        return new n(mcpServerConfig);
    }

    @Override // javax.inject.Provider
    public n get() {
        return newInstance((McpServerConfig) this.configProvider.get());
    }
}
