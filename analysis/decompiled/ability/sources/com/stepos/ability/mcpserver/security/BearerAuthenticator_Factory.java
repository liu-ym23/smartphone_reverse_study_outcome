package com.stepos.ability.mcpserver.security;

import k4.h;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class BearerAuthenticator_Factory implements InterfaceC2137b {
    private final InterfaceC2137b keyValidatorProvider;

    private BearerAuthenticator_Factory(InterfaceC2137b interfaceC2137b) {
        this.keyValidatorProvider = interfaceC2137b;
    }

    public static BearerAuthenticator_Factory create(InterfaceC2137b interfaceC2137b) {
        return new BearerAuthenticator_Factory(interfaceC2137b);
    }

    public static h newInstance(KeyValidator keyValidator) {
        return new h(keyValidator);
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance((KeyValidator) this.keyValidatorProvider.get());
    }
}
