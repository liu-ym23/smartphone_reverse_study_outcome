package com.stepos.ability.net;

import T3.c;
import U3.b;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class NetImpl_Factory implements InterfaceC2137b {
    private final InterfaceC2137b deviceIdManagerProvider;
    private final InterfaceC2137b envManagerProvider;

    private NetImpl_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.deviceIdManagerProvider = interfaceC2137b;
        this.envManagerProvider = interfaceC2137b2;
    }

    public static NetImpl_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new NetImpl_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static NetImpl newInstance(c cVar, b bVar) {
        return new NetImpl(cVar, bVar);
    }

    @Override // javax.inject.Provider
    public NetImpl get() {
        return newInstance((c) this.deviceIdManagerProvider.get(), (b) this.envManagerProvider.get());
    }
}
