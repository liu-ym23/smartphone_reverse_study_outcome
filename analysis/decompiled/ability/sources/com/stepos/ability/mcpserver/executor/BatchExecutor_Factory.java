package com.stepos.ability.mcpserver.executor;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class BatchExecutor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b configProvider;
    private final InterfaceC2137b toolBridgeProvider;

    private BatchExecutor_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.toolBridgeProvider = interfaceC2137b;
        this.configProvider = interfaceC2137b2;
    }

    public static BatchExecutor_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new BatchExecutor_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static a newInstance(b bVar, McpServerConfig mcpServerConfig) {
        return new a(bVar, mcpServerConfig);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((b) this.toolBridgeProvider.get(), (McpServerConfig) this.configProvider.get());
    }
}
