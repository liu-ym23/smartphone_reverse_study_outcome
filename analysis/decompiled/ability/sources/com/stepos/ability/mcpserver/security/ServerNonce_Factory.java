package com.stepos.ability.mcpserver.security;

import k4.AbstractC1623A;
import k4.z;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ServerNonce_Factory implements InterfaceC2137b {
    public static ServerNonce_Factory create() {
        return AbstractC1623A.f4795a;
    }

    public static z newInstance() {
        return new z();
    }

    @Override // javax.inject.Provider
    public z get() {
        return newInstance();
    }
}
