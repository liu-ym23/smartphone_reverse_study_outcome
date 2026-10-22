package com.stepos.ability.runtime;

import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import x7.InterfaceC2117a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class RuntimeManager_MembersInjector implements InterfaceC2117a {
    private final InterfaceC2137b callToolProvider;
    private final InterfaceC2137b monitorProvider;

    private RuntimeManager_MembersInjector(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.callToolProvider = interfaceC2137b;
        this.monitorProvider = interfaceC2137b2;
    }

    public static InterfaceC2117a create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new RuntimeManager_MembersInjector(interfaceC2137b, interfaceC2137b2);
    }

    public static void injectCallTool(b bVar, ICallTool iCallTool) {
        bVar.b = iCallTool;
    }

    public static void injectMonitor(b bVar, IMonitor iMonitor) {
        bVar.c = iMonitor;
    }

    public void injectMembers(b bVar) {
        injectCallTool(bVar, (ICallTool) this.callToolProvider.get());
        injectMonitor(bVar, (IMonitor) this.monitorProvider.get());
    }
}
