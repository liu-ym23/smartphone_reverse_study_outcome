package com.stepos.ability.runtime;

import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class RuntimeManager_Factory implements InterfaceC2137b {
    private final InterfaceC2137b callToolProvider;
    private final InterfaceC2137b monitorProvider;

    private RuntimeManager_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.callToolProvider = interfaceC2137b;
        this.monitorProvider = interfaceC2137b2;
    }

    public static RuntimeManager_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new RuntimeManager_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        b bVarNewInstance = newInstance();
        RuntimeManager_MembersInjector.injectCallTool(bVarNewInstance, (ICallTool) this.callToolProvider.get());
        RuntimeManager_MembersInjector.injectMonitor(bVarNewInstance, (IMonitor) this.monitorProvider.get());
        return bVarNewInstance;
    }
}
