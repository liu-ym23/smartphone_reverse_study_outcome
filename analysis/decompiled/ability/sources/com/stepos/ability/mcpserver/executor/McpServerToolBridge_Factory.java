package com.stepos.ability.mcpserver.executor;

import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class McpServerToolBridge_Factory implements InterfaceC2137b {
    private final InterfaceC2137b abilityManagerProvider;
    private final InterfaceC2137b callToolProvider;

    private McpServerToolBridge_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.callToolProvider = interfaceC2137b;
        this.abilityManagerProvider = interfaceC2137b2;
    }

    public static McpServerToolBridge_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new McpServerToolBridge_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static b newInstance(ICallTool iCallTool, IAbilityManager iAbilityManager) {
        return new b(iCallTool, iAbilityManager);
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance((ICallTool) this.callToolProvider.get(), (IAbilityManager) this.abilityManagerProvider.get());
    }
}
