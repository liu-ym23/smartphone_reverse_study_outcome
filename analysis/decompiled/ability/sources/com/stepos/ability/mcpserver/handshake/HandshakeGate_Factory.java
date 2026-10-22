package com.stepos.ability.mcpserver.handshake;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import h4.C1486a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class HandshakeGate_Factory implements InterfaceC2137b {
    private final InterfaceC2137b configProvider;

    private HandshakeGate_Factory(InterfaceC2137b interfaceC2137b) {
        this.configProvider = interfaceC2137b;
    }

    public static HandshakeGate_Factory create(InterfaceC2137b interfaceC2137b) {
        return new HandshakeGate_Factory(interfaceC2137b);
    }

    public static C1486a newInstance(McpServerConfig mcpServerConfig) {
        return new C1486a(mcpServerConfig);
    }

    @Override // javax.inject.Provider
    public C1486a get() {
        return newInstance((McpServerConfig) this.configProvider.get());
    }
}
