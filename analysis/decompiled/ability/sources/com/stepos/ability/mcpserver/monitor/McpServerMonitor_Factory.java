package com.stepos.ability.mcpserver.monitor;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import i4.C1554b;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class McpServerMonitor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b configProvider;

    private McpServerMonitor_Factory(InterfaceC2137b interfaceC2137b) {
        this.configProvider = interfaceC2137b;
    }

    public static McpServerMonitor_Factory create(InterfaceC2137b interfaceC2137b) {
        return new McpServerMonitor_Factory(interfaceC2137b);
    }

    public static C1554b newInstance(McpServerConfig mcpServerConfig) {
        return new C1554b(mcpServerConfig);
    }

    @Override // javax.inject.Provider
    public C1554b get() {
        return newInstance((McpServerConfig) this.configProvider.get());
    }
}
