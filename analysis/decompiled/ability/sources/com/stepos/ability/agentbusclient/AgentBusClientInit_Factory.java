package com.stepos.ability.agentbusclient;

import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AgentBusClientInit_Factory implements InterfaceC2137b {
    private final InterfaceC2137b abilityCallExecutorProvider;
    private final InterfaceC2137b abilityListExecutorProvider;

    private AgentBusClientInit_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.abilityCallExecutorProvider = interfaceC2137b;
        this.abilityListExecutorProvider = interfaceC2137b2;
    }

    public static AgentBusClientInit_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new AgentBusClientInit_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static AgentBusClientInit newInstance(AbilityCallExecutor abilityCallExecutor, AbilityListExecutor abilityListExecutor) {
        return new AgentBusClientInit(abilityCallExecutor, abilityListExecutor);
    }

    @Override // javax.inject.Provider
    public AgentBusClientInit get() {
        return newInstance((AbilityCallExecutor) this.abilityCallExecutorProvider.get(), (AbilityListExecutor) this.abilityListExecutorProvider.get());
    }
}
