package com.stepos.ability.mcpserver.security;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import k4.w;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class RateLimiter_Factory implements InterfaceC2137b {
    private final InterfaceC2137b configProvider;

    private RateLimiter_Factory(InterfaceC2137b interfaceC2137b) {
        this.configProvider = interfaceC2137b;
    }

    public static RateLimiter_Factory create(InterfaceC2137b interfaceC2137b) {
        return new RateLimiter_Factory(interfaceC2137b);
    }

    public static w newInstance(McpServerConfig mcpServerConfig) {
        return new w(mcpServerConfig);
    }

    @Override // javax.inject.Provider
    public w get() {
        return newInstance((McpServerConfig) this.configProvider.get());
    }
}
