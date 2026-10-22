package com.stepos.ability.mcpserver;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.mcpserver.search.b;
import f4.C1434a;
import i4.C1554b;
import k4.h;
import k4.s;
import k4.w;
import k4.z;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class McpServerInit_Factory implements InterfaceC2137b {
    private final InterfaceC2137b authenticatorProvider;
    private final InterfaceC2137b batchExecutorProvider;
    private final InterfaceC2137b configProvider;
    private final InterfaceC2137b dagSchedulerProvider;
    private final InterfaceC2137b describeEngineProvider;
    private final InterfaceC2137b monitorProvider;
    private final InterfaceC2137b packageChangeReceiverProvider;
    private final InterfaceC2137b rateLimiterProvider;
    private final InterfaceC2137b searchEngineProvider;
    private final InterfaceC2137b serverNonceProvider;
    private final InterfaceC2137b sessionManagerProvider;
    private final InterfaceC2137b toolBridgeProvider;

    private McpServerInit_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3, InterfaceC2137b interfaceC2137b4, InterfaceC2137b interfaceC2137b5, InterfaceC2137b interfaceC2137b6, InterfaceC2137b interfaceC2137b7, InterfaceC2137b interfaceC2137b8, InterfaceC2137b interfaceC2137b9, InterfaceC2137b interfaceC2137b10, InterfaceC2137b interfaceC2137b11, InterfaceC2137b interfaceC2137b12) {
        this.configProvider = interfaceC2137b;
        this.searchEngineProvider = interfaceC2137b2;
        this.describeEngineProvider = interfaceC2137b3;
        this.toolBridgeProvider = interfaceC2137b4;
        this.dagSchedulerProvider = interfaceC2137b5;
        this.batchExecutorProvider = interfaceC2137b6;
        this.sessionManagerProvider = interfaceC2137b7;
        this.monitorProvider = interfaceC2137b8;
        this.serverNonceProvider = interfaceC2137b9;
        this.authenticatorProvider = interfaceC2137b10;
        this.rateLimiterProvider = interfaceC2137b11;
        this.packageChangeReceiverProvider = interfaceC2137b12;
    }

    public static McpServerInit_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3, InterfaceC2137b interfaceC2137b4, InterfaceC2137b interfaceC2137b5, InterfaceC2137b interfaceC2137b6, InterfaceC2137b interfaceC2137b7, InterfaceC2137b interfaceC2137b8, InterfaceC2137b interfaceC2137b9, InterfaceC2137b interfaceC2137b10, InterfaceC2137b interfaceC2137b11, InterfaceC2137b interfaceC2137b12) {
        return new McpServerInit_Factory(interfaceC2137b, interfaceC2137b2, interfaceC2137b3, interfaceC2137b4, interfaceC2137b5, interfaceC2137b6, interfaceC2137b7, interfaceC2137b8, interfaceC2137b9, interfaceC2137b10, interfaceC2137b11, interfaceC2137b12);
    }

    public static McpServerInit newInstance(McpServerConfig mcpServerConfig, b bVar, com.stepos.ability.mcpserver.describe.a aVar, com.stepos.ability.mcpserver.executor.b bVar2, C1434a c1434a, com.stepos.ability.mcpserver.executor.a aVar2, com.stepos.ability.mcpserver.endpoint.b bVar3, C1554b c1554b, z zVar, h hVar, w wVar, s sVar) {
        return new McpServerInit(mcpServerConfig, bVar, aVar, bVar2, c1434a, aVar2, bVar3, c1554b, zVar, hVar, wVar, sVar);
    }

    @Override // javax.inject.Provider
    public McpServerInit get() {
        return newInstance((McpServerConfig) this.configProvider.get(), (b) this.searchEngineProvider.get(), (com.stepos.ability.mcpserver.describe.a) this.describeEngineProvider.get(), (com.stepos.ability.mcpserver.executor.b) this.toolBridgeProvider.get(), (C1434a) this.dagSchedulerProvider.get(), (com.stepos.ability.mcpserver.executor.a) this.batchExecutorProvider.get(), (com.stepos.ability.mcpserver.endpoint.b) this.sessionManagerProvider.get(), (C1554b) this.monitorProvider.get(), (z) this.serverNonceProvider.get(), (h) this.authenticatorProvider.get(), (w) this.rateLimiterProvider.get(), (s) this.packageChangeReceiverProvider.get());
    }
}
