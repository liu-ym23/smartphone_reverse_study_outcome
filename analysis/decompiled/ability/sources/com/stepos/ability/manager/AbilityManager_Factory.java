package com.stepos.ability.manager;

import T3.c;
import com.stepos.ability.net.INet;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AbilityManager_Factory implements InterfaceC2137b {
    private final InterfaceC2137b accountUtilProvider;
    private final InterfaceC2137b deviceIdManagerProvider;
    private final InterfaceC2137b iNetProvider;

    private AbilityManager_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3) {
        this.iNetProvider = interfaceC2137b;
        this.deviceIdManagerProvider = interfaceC2137b2;
        this.accountUtilProvider = interfaceC2137b3;
    }

    public static AbilityManager_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3) {
        return new AbilityManager_Factory(interfaceC2137b, interfaceC2137b2, interfaceC2137b3);
    }

    public static AbilityManager newInstance(INet iNet, c cVar, H3.b bVar) {
        return new AbilityManager(iNet, cVar, bVar);
    }

    @Override // javax.inject.Provider
    public AbilityManager get() {
        return newInstance((INet) this.iNetProvider.get(), (c) this.deviceIdManagerProvider.get(), (H3.b) this.accountUtilProvider.get());
    }
}
